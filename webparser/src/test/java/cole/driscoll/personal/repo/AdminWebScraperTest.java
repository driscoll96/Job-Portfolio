package cole.driscoll.personal.repo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminWebScraperTest {
  private AdminWebScraper scraper;
  private WebDriver driver;


  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\User\\OneDrive\\Job App Stuff\\chromedriver_win32 (1)\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    scraper = new AdminWebScraper(driver);
  }

  @Test
  public void getProductList() {
    List list = scraper.getProductList();
    ArrayList products = new ArrayList<String>();
    products.add("Loopie Wash & Fold Service");
    products.add("Wash & Fold Service (Hotel)");
    products.add("Loopie Duffel Bag");
  }

  @Test
  public void getOrderProducts() {
  }

  @Test
  public void getWebOrdersOrCustomer() {
  }

  @Test
  public void getCustomerEmail() {
  }

  @Test
  public void getZip() {
  }

  @Test
  public void getState() {
  }
}