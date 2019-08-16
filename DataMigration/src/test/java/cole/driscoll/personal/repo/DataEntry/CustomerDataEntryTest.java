package cole.driscoll.personal.repo.DataEntry;

import cole.driscoll.personal.repo.Crawlers.AdminCustomerWebCrawler;
import cole.driscoll.personal.repo.CustomerInfo.Customer;
import cole.driscoll.personal.repo.Parsers.JSONCustomerWebParser;
import cole.driscoll.personal.repo.Parsers.CustomerWebParser;
import cole.driscoll.personal.repo.Scrapers.AdminCustomerScraper;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class CustomerDataEntryTest {

  private CustomerDataEntry entry;
  private JSONCustomerWebParser parser;
  private List<String> jsonCustomers;
  private CustomerWebParser customerWebParser;
  private WebDriver driver;

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\User\\OneDrive\\Loopie Stuff\\chromedriver_win32 (1)\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    parser = new JSONCustomerWebParser(new AdminCustomerScraper(driver), new AdminCustomerWebCrawler(driver));
    parser.getCrawler().signIn();
    jsonCustomers = parser.convertDataToJSON(117, 117);
    customerWebParser = new CustomerWebParser(new AdminCustomerScraper(driver), new AdminCustomerWebCrawler(driver));
  }

  @Test
  public void enterCustomers() {
    for (int i = 0; i < jsonCustomers.size(); i++) {
      System.out.println(jsonCustomers.get(i));
      entry = new CustomerDataEntry();
      System.out.println(entry.enterCustomer(jsonCustomers.get(i)));
    }
  }

  /**
   * Make sure all the customer information has been transferred to the API first
   */
  @Test
  public void checkForEnteredCustomer() {
    List<Customer> customers = customerWebParser.getCustomerInfo(19);
    driver.get("https://cole.base-data.loopie.io/v1/users");
    String responseBody = driver.findElement(By.xpath("/html/body/pre")).getText();
    for (int i = 0; i < customers.size(); i++) {
      System.out.println(customers.get(i).getPhone());
      assertTrue(responseBody.contains(customers.get(i).getPhone()));
    }
  }
}