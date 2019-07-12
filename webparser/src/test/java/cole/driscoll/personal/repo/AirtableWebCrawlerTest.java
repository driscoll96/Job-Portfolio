package cole.driscoll.personal.repo;

import static org.junit.Assert.*;

import cole.driscoll.personal.repo.Crawlers.AirtableWebCrawler;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AirtableWebCrawlerTest {

  private AirtableWebCrawler crawler;
  WebDriver driver;

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\User\\OneDrive\\Job App Stuff\\chromedriver_win32 (1)\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    crawler = new AirtableWebCrawler(driver);
  }

  @Test
  public void goToProductPage() throws InterruptedException {
    crawler.goToProductPage();
    TimeUnit.SECONDS.sleep(1);
    assertEquals(driver.getCurrentUrl(), "https://airtable.com/tbluxbhofupfVSAAD/viwUw62qdfp9mri8v?blocks=hide");
  }

  @Test
  public void signIn() throws InterruptedException {
    crawler.signIn();
    TimeUnit.SECONDS.sleep(1);
    assertEquals(driver.getCurrentUrl(), "https://airtable.com/");
  }

  @Test
  public void goToOrderspage() throws InterruptedException {
    crawler.goToOrderspage();
    TimeUnit.SECONDS.sleep(1);
    assertEquals(driver.getCurrentUrl(), "https://airtable.com/tblHSvgxLOgWynMvM/viwCmcPKNZE6nMez3?blocks=hide");
  }

  @Test
  public void goToOrdersPageAfterLoggedIn() {
    crawler.goToProductPage();
    crawler.goToOrdersPageAfterLoggedIn();
    assertEquals(driver.getCurrentUrl(), "https://airtable.com/tblHSvgxLOgWynMvM/viwCmcPKNZE6nMez3?blocks=hide");
  }
}