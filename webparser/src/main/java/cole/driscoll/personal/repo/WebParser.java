package cole.driscoll.personal.repo;

import cole.driscoll.personal.repo.Crawlers.AdminWebCrawler;
import cole.driscoll.personal.repo.CustomerInfo.AbsCustomer;
import cole.driscoll.personal.repo.CustomerInfo.StreetAddress;
import cole.driscoll.personal.repo.Exceptions.NoCustomerFoundException;
import cole.driscoll.personal.repo.OrderInfo.Order;
import cole.driscoll.personal.repo.Scrapers.AdminWebScraper;
import cole.driscoll.personal.repo.ProductServiceInfo.AbsProduct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Parser that converts and organizes admin web data into an ArrayList.
 */

public class WebParser {

  private WebDriver driver;

  private AdminWebScraper adminScraper;

  private TypeIdentifier identifier;

  /**
   * Constructor which takes in the admin Webdriver and calls the web scraper method to get the raw
   * admin data.
   *
   * @param driver - The admin web driver
   */
  public WebParser(WebDriver driver) {
    this.driver = driver;
    this.adminScraper = new AdminWebScraper(driver);
    this.identifier = new TypeIdentifier();
  }

  /**
   * Gets the admin website order data and converts it into an ArrayList of order instances.
   *
   * @param customers - Admin customer list
   * @return - List of order instances
   * @throws ParseException - If conversion of string to int or double fails
   */
  public List<Order> convertWebOrders(List<AbsCustomer> customers) throws ParseException, NoCustomerFoundException {
    List<WebElement> orders = adminScraper.getWebOrders();
    List<Order> convertedOrders = new ArrayList<>();
    Order order;
    Date orderDate, delivery, pickUp;
    List<AbsProduct> bags;
    AbsCustomer customer;
    for (int i = 0; i < orders.size(); i++) {
      List<String> orderInfo = Arrays.asList(orders.get(i).getText().split(" "));
      orderDate = new SimpleDateFormat("MM/dd/yyyy hh:mma").parse(orderInfo.get(1)+" "+orderInfo.get(3));
      delivery = new SimpleDateFormat("MM/dd/yyyy hh:mma").parse(orderInfo.get(6)+" "+orderInfo.get(8));
      pickUp = new SimpleDateFormat("MM/dd/yyyy hh:mma").parse(orderInfo.get(9)+" "+orderInfo.get(11));
      orders.get(0).click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      bags = adminScraper.getOrderProducts();
      customer = identifier.identifyCustomerWithOrder(orderInfo.get(2), orderInfo.get(3), customers);
      if (customer == null) {
        throw new NoCustomerFoundException("There was an inconsistency between order information and customer list. "
            + "Contact coledriscoll@gmail.com for error fix. Program Terminated.", driver);
      }
      order = new Order(Integer.parseInt(orderInfo.get(0)), orderDate, pickUp, delivery,
          Double.parseDouble(orderInfo.get(14).substring(1)), bags, customer);
      convertedOrders.add(order);
    }
    return convertedOrders;
  }

  /**
   * Gets the admin website customer data and converts it into an ArrayList of order instances.
   *
   * @return - List of customers
   */
  public List<AbsCustomer> convertCustomers() {
    List<AbsCustomer> customers = new ArrayList<>();
    List<WebElement> rawCustomerInfo = adminScraper.getCustomers();
    List<WebElement> columns;
    AbsCustomer customer;
    AdminWebCrawler crawler = new AdminWebCrawler(driver);
    for (int i = 0; i < rawCustomerInfo.size(); i++) {
      columns = rawCustomerInfo.get(i).findElements(By.tagName("td"));
      crawler.goToCustomersTopOrderSummary(columns.get(7));
      List<AbsProduct> customerProducts = adminScraper.getOrderProducts();
      //crawler.goToCustomerPage();
      //crawler.goToCustomerInfo(columns);
      customer = identifier.identifyCustomerType(customerProducts, columns.get(2).getText(), columns.get(3).getText(),
          adminScraper.getCustomerEmail(), columns.get(4).getText(), Integer.parseInt(columns.get(1).getText()),
          new StreetAddress(columns.get(5).getText(), null, columns.get(6).getText(), adminScraper.getState(), adminScraper.getZip()));
      customers.add(customer);
    }
    return customers;
  }
}
