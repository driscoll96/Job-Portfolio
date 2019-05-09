package cole.driscoll.personal.repo;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

  public static void main(String[] args) throws ParseException {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Job App Stuff\\chromedriver_win32 (1)\\chromedriver.exe");
    WebDriver adminDriver = new ChromeDriver();
    adminDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebDriver airTableDriver = new ChromeDriver();
    airTableDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    AbsWebCrawler adminCrawler = new AdminWebCrawler(adminDriver);
    AbsWebCrawler airtableCrawler = new AirtableWebCrawler(airTableDriver);
    adminCrawler.goToProductPage();
    airtableCrawler.goToProductPage();
    CheckForUpdate check = new CheckForUpdate(adminDriver, airTableDriver);
    if (!check.sameProducts()) {
      System.out.println("There has been updates to products types on the admin page. Contact "
          + "coledriscoll@gmail.com to request an update to this program. Program Terminated");
      adminDriver.close();
      airTableDriver.close();
      System.exit(1);
    }
    adminCrawler.goToOrderspage();
    // TODO: Scrape/parse the customer list first then get the orders
    WebParser parser = new WebParser(adminDriver);
    List<Order> convertedOrders = parser.convertWebOrders();


  }

}
