package cole.driscoll.personal.repo.JSONData;

import static org.junit.Assert.assertEquals;

import cole.driscoll.personal.repo.Crawlers.AdminCustomerWebCrawler;
import cole.driscoll.personal.repo.CustomerInfo.Customer;
import cole.driscoll.personal.repo.Parsers.JSONCustomerWebParser;
import cole.driscoll.personal.repo.Scrapers.AdminCustomerScraper;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSONCustomerWebParserTest {

  private WebDriver driver;
  private JSONCustomerWebParser parser;
  private AdminCustomerWebCrawler crawler;
  private AdminCustomerScraper scraper;

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\User\\OneDrive\\Loopie Stuff\\chromedriver_win32 (1)\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    parser = new JSONCustomerWebParser(new AdminCustomerScraper(driver), new AdminCustomerWebCrawler(driver));
    crawler = new AdminCustomerWebCrawler(driver);
    scraper = new AdminCustomerScraper(driver);
  }

  @Test
  public void getJSONCustomerData() {
    parser.getCrawler().signIn();
    List<String> customers = parser.convertDataToJSON(370, 371);
    Customer customerActual;
    for (int i = 370; i < 371; i++) {
      crawler.goToCustomerInfo(i);
      customerActual = new Customer(scraper.getFirstName(),
          scraper.getLastName(), scraper.getCustomerEmail(), scraper.getPhoneNum(), scraper.getStreetAddress1(),
          scraper.getStreetAddress2(), scraper.getZip(), scraper.getCity(), scraper.getState());
      String orderStr = "{\"FirstName\":\""+customerActual.getFirstName()+"\",\"LastName\":\""
          +customerActual.getLastName()+"\",\"Phone\":\""+customerActual.getPhone()+"\",\"Email\":\""+customerActual.getEmail()
          +"\",\"Emails\":[{\"Address\":\""+customerActual.getEmail()+"\"}],\"Addresses\":[{\"StreetAddress1\":\""
          +customerActual.getAddresses().get(0).getStreetAddress1()+"\",\"StreetAddress2\":\""+
          customerActual.getAddresses().get(0).getStreetAddress2()+"\",\"City\":\""+customerActual.getAddresses().get(0).getCity()
          +"\",\"State\":\""+customerActual.getAddresses().get(0).getState()+"\",\"ZipCode\":\""
          +customerActual.getAddresses().get(0).getZipCode()+"\",\"Country\":\""+customerActual.getAddresses().get(0).getCountry()
          +"\"}],\"Phones\":[{\"CallingCode\":\"+1\",\"Number\":\""+customerActual.getPhone().substring(3)
          +"\"}],\"__T\":\"u\"}";
      assertEquals(customers.get(i-370), orderStr);
    }
  }
}