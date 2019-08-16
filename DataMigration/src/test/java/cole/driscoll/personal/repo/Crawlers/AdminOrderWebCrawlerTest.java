package cole.driscoll.personal.repo.Crawlers;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminOrderWebCrawlerTest {

  AdminOrderWebCrawler crawler;
  WebDriver driver;

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\User\\OneDrive\\Job App Stuff\\chromedriver_win32 (1)\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    crawler = new AdminOrderWebCrawler(driver);
  }

  @Test
  public void goToProductPage() throws InterruptedException {
    crawler.goToProductPage();
    TimeUnit.SECONDS.sleep(1);
    assertEquals(driver.getCurrentUrl(), "https://www.loopie.us/cart.php?type=check_prices");
  }

  @Test
  public void signIn() throws InterruptedException {
    crawler.signIn();
    TimeUnit.SECONDS.sleep(1);
    assertEquals(driver.getCurrentUrl(), "https://www.loopie.us/admin/");
  }

  @Test
  public void goToOrderspage() throws InterruptedException {
    crawler.goToOrderspage();
    TimeUnit.SECONDS.sleep(1);
    assertEquals(driver.getCurrentUrl().substring(0, 38), "https://www.loopie.us/admin/orders.php");
    TimeUnit.SECONDS.sleep(1);
    assertEquals(driver.findElement(By.xpath("//*[@id=\"date_start\"]")).getAttribute("value"), "07/01/2018");
  }

  @Test
  public void goToOrderPage() {
    crawler.goToOrderspage();
    for (int i = 0; i < 11; i++) {
      crawler.goToOrderInfo(i);
      int orderNum = Integer.parseInt(
          driver.findElement(By.xpath("//*[@id=\"content\"]/main/div/div[2]/div[1]/div/p/span[2]"))
              .getText());
      assertEquals("https://www.loopie.us/admin/orders.php?action=edit&id=" + orderNum,
          driver.getCurrentUrl());
    }
  }
}