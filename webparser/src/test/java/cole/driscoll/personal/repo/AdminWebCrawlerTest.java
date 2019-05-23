package cole.driscoll.personal.repo;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminWebCrawlerTest {

  AdminWebCrawler crawler;
  WebDriver driver;

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Job App Stuff\\chromedriver_win32 (1)\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    crawler = new AdminWebCrawler(driver);
  }

  @Test
  public void goToProductPage() throws InterruptedException {
    crawler.goToProductPage();
    TimeUnit.SECONDS.sleep(10);
    assertEquals(driver.getCurrentUrl(), "https://www.loopie.us/cart.php?type=check_prices");
  }

  @Test
  public void signIn() throws InterruptedException {
    crawler.signIn();
    TimeUnit.SECONDS.sleep(10);
    assertEquals(driver.getCurrentUrl(), "https://www.loopie.us/admin/orders.php");
  }

  @Test
  public void goToOrderspage() throws InterruptedException {
    crawler.goToOrderspage();
    TimeUnit.SECONDS.sleep(10);
    assertEquals(driver.getCurrentUrl().substring(0, 38), "https://www.loopie.us/admin/orders.php");
    TimeUnit.SECONDS.sleep(10);
    assertEquals(driver.findElement(By.xpath("//*[@id=\"date_start\"]")).getAttribute("value"), "07/01/2018");
  }

  @Test
  public void goToCustomerPage() throws InterruptedException {
    crawler.goToCustomerPage();
    TimeUnit.SECONDS.sleep(10);
    assertEquals(driver.getCurrentUrl(), "https://www.loopie.us/admin/customers.php");
  }

  @Test
  public void goToCustomersTopOrderSummary() throws InterruptedException {
    // TODO: How to one-by-one go through a customer's 1st order and then go to next customer (stale element workaround)
    crawler.goToCustomerPage();
    List<WebElement> customers = driver.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
    for (int i = 0; i < 3; i++) {
      crawler.goToCustomersTopOrderSummary(customers.get(i).findElements(By.tagName("td")).get(7).findElement(By.tagName("a")));
      TimeUnit.SECONDS.sleep(2);
      String summaryUrl = driver.getCurrentUrl();
      driver.findElement(By.xpath("//*[@id=\"content\"]/main/div/div[2]/div[2]/div/p/span[2]/a")).click();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      String orderNum = driver.findElement(By.xpath("//*[@id=\"zone{id}\"]/table/tbody/tr/td[1]/a")).getText();
      crawler.goToCustomerPage();
      assertEquals(summaryUrl, "https://www.loopie.us/admin/orders.php?action=edit&id="+orderNum);
    }
  }

  @Test
  public void goToCustomerInfo() {
  }
}