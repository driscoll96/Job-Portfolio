package cole.driscoll.personal.repo;

import cole.driscoll.personal.repo.Crawlers.AdminCustomerWebCrawler;
import cole.driscoll.personal.repo.DataEntry.CustomerDataEntry;
import cole.driscoll.personal.repo.Exceptions.UnsuccessfulPostException;
import cole.driscoll.personal.repo.Parsers.JSONCustomerWebParser;
import cole.driscoll.personal.repo.Scrapers.AdminCustomerScraper;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

  /**
   * Args is:
   *    1. Customer ID to start with
   *
   * @param args - Arguments
   */
  public static void main(String[] args) throws UnsuccessfulPostException {
    if (args.length != 1) {
      throw new InvalidArgumentException("Must run program with a single argument:\n A whole number between 19 and "
          + "the total number of Loopie admin (https://loopie.us/admin/customers.php) customers.");
    }
    int startCustomerNum = Integer.parseInt(args[0]);
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\User\\OneDrive\\Loopie Stuff\\chromedriver_win32 (1)\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    JSONCustomerWebParser customerParser = new JSONCustomerWebParser(
        new AdminCustomerScraper(driver), new AdminCustomerWebCrawler(driver));
    customerParser.getCrawler().signIn();
    ((AdminCustomerWebCrawler) customerParser.getCrawler()).goToCustomerPage();
    int totalCustomers = Integer
        .parseInt(((AdminCustomerScraper) customerParser.getScraper()).getTotalCustomers());
    if (startCustomerNum < 19 || totalCustomers < startCustomerNum) {
        throw new InvalidArgumentException("Please give a number between 19 and "+totalCustomers+" "
            + "as the starting the customer to start migrating.");
    } else {
      List<String> jsonCustomers = customerParser.convertDataToJSON(Integer.parseInt(args[0]));
      CustomerDataEntry migration;
      int requestCheck;
      for (int i = 0; i < jsonCustomers.size(); i++) {
        migration = new CustomerDataEntry();
        requestCheck = migration.enterCustomer(jsonCustomers.get(i));
        System.out.println(requestCheck);
        if (requestCheck != 400 && requestCheck != 200 && requestCheck != 201) {
          throw new UnsuccessfulPostException(requestCheck);
        }
      }

//    JSONOrderWebParser orderParser = new JSONOrderWebParser(new AdminOrderScraper(driver), new AdminOrderWebCrawler(driver));
//    List<String> jsonOrders = orderParser.convertDataToJSON(Integer.parseInt(args[1]));

    }
  }

}
