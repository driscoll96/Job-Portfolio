package cole.driscoll.personal.repo.Crawlers;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminCustomerWebCrawlerTest {

  AdminCustomerWebCrawler crawler;
  WebDriver driver;

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\User\\OneDrive\\Job App Stuff\\chromedriver_win32 (1)\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    crawler = new AdminCustomerWebCrawler(driver);
  }

  @Test
  public void goToCustomerPage() throws InterruptedException {
    crawler.goToCustomerPage();
    TimeUnit.SECONDS.sleep(1);
    assertEquals(driver.getCurrentUrl(), "https://www.loopie.us/admin/customers.php");
  }

  @Test
  public void goToCustomersTopOrderSummary() throws InterruptedException {
    crawler.goToCustomerPage();
    WebElement customer;
    String orderNum;
    for (int i = 0; i < 10; i++) {
      customer = driver.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).get(i);
      crawler.goToCustomersTopOrderSummary(customer.findElements(By.tagName("td")).get(7).findElement(By.tagName("a")));
      TimeUnit.SECONDS.sleep(1);
      String summaryUrl = driver.getCurrentUrl();
      driver.findElement(By.xpath("//*[@id=\"content\"]/main/div/div[2]/div[2]/div/p/span[2]/a")).click();
      driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
      orderNum = driver.findElement(By.xpath("//*[@id=\"zone{id}\"]/table/tbody/tr/td[1]/a")).getText();
      crawler.goToCustomerPage();
      assertEquals(summaryUrl, "https://www.loopie.us/admin/orders.php?action=edit&id="+orderNum);
    }
  }

  @Test
  public void goToCustomerInfo() {
    for (int i = 200; i < 210; i++) {
      crawler.goToCustomerInfo(i);
      String summaryUrl = driver.getCurrentUrl();
      assertEquals(summaryUrl,
          "https://www.loopie.us/admin/customers.php?action=edit&id=" + i);
      crawler.goToCustomerPage();
    }
  }
}