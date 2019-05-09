package cole.driscoll.personal.repo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Parser that converts and organizes admin web data into an ArrayList.
 */

public class WebParser {

  private WebDriver driver;

  /**
   * Constructor which takes in the admin Webdriver and calls the web scraper method to get the raw
   * admin data.
   *
   * @param driver - The admin web driver
   */
  public WebParser(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Gets the admin website data and converts it into an ArrayList of order instances.
   *
   * @return - List of order instances
   * @throws ParseException - If conversion of string to int or double fails
   */
  public List<Order> convertWebOrders() throws ParseException {
    AdminWebScraper scraper = new AdminWebScraper(driver);
    List<WebElement> orders = scraper.getWebOrders();
    List<Order> convertedOrders = new ArrayList<>();
    Order order;
    Date orderDate, delivery, pickUp;
    List<AbsProduct> bags;
    for (int i = 0; i < orders.size(); i++) {
      List<String> orderInfo = Arrays.asList(orders.get(i).getText().split(" "));
      orderDate = new SimpleDateFormat("MM/dd/yyyy hh:mma").parse(orderInfo.get(1)+" "+orderInfo.get(3));
      delivery = new SimpleDateFormat("MM/dd/yyyy hh:mma").parse(orderInfo.get(6)+" "+orderInfo.get(8));
      pickUp = new SimpleDateFormat("MM/dd/yyyy hh:mma").parse(orderInfo.get(9)+" "+orderInfo.get(11));
      orders.get(0).click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      bags = scraper.getOrderProducts();
      // TODO: match to the correct customer
      order = new Order(Integer.parseInt(orderInfo.get(0)), orderDate, pickUp, delivery,
          Double.parseDouble(orderInfo.get(14).substring(1)), bags, null);

    }
    return convertedOrders;
  }
}
