package cole.driscoll.personal.repo;

import cole.driscoll.personal.repo.Crawlers.AdminWebCrawler;
import cole.driscoll.personal.repo.Crawlers.AirtableWebCrawler;
import cole.driscoll.personal.repo.Exceptions.ProductsNotUpdatedException;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// TODO: This
public class CheckForUpdateTest {
  WebDriver adminDriver;
  WebDriver airTableDriver;
  CheckForUpdate check;

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\User\\OneDrive\\Job App Stuff\\chromedriver_win32 (1)\\chromedriver.exe");
    adminDriver = new ChromeDriver();
    adminDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    airTableDriver = new ChromeDriver();
    airTableDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    AirtableWebCrawler airtableCrawler = new AirtableWebCrawler(airTableDriver);
    AdminWebCrawler adminCrawler = new AdminWebCrawler(adminDriver);
    adminCrawler.goToProductPage();
    airtableCrawler.goToProductPage();
    check = new CheckForUpdate(adminDriver, airTableDriver);
  }

  @Test (expected = ProductsNotUpdatedException.class)
  public void sameProductsFail() {
    check.sameProducts();
  }
}