package cole.driscoll.personal.repo;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

  public static void main(String[] args)
      throws ParseException, ProductsNotUpdatedException {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Job App Stuff\\chromedriver_win32 (1)\\chromedriver.exe");
    WebDriver adminDriver = new ChromeDriver();
    adminDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    WebDriver airTableDriver = new ChromeDriver();
    airTableDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    AdminWebCrawler adminCrawler = new AdminWebCrawler(adminDriver);
    AirtableWebCrawler airtableCrawler = new AirtableWebCrawler(airTableDriver);
    adminCrawler.goToProductPage();
    adminDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);;
    airtableCrawler.goToProductPage();
    CheckForUpdate check = new CheckForUpdate(adminDriver, airTableDriver);
    if (!check.sameProducts()) {
      throw new ProductsNotUpdatedException("There has been updates to products types on the admin page. Contact "
          + "coledriscoll@gmail.com to request an update to this program. Program Terminated", adminDriver, airTableDriver);
    }
    //adminCrawler.goToCustomerPage();
    CustomerPool pool = new CustomerPool();
    WebParser parser = new WebParser(adminDriver);
    pool.populatePool(adminDriver, parser);
    adminCrawler.goToOrderspage();
    try {
      List<Order> convertedOrders = parser.convertWebOrders(pool.getCustomers());
    } catch (NoCustomerFoundException e) {
      airTableDriver.close();
      System.exit(1);
    }
    // TODO: Put orders in Airtable
    airtableCrawler.goToOrdersPageAfterLoggedIn();

  }

}
