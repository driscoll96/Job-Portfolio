package cole.driscoll.personal.repo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Abstract web crawler.
 */
public class AdminWebCrawler extends AbsWebCrawler {

  /**
   * Constructor which fills the WebDriver.
   *
   * @param driver - WebDriver
   */
  public AdminWebCrawler(WebDriver driver) {
    super(driver);
  }

  @Override
  public void goToProductPage() {
    super.getDriver().get("https://www.loopie.us/admin/login.php");
    super.maxWindow();
    super.getDriver().findElement(
        By.xpath("//*[@id=\"content\"]/main/div/div[1]/div/div[1]/form/div/span/button")).click();
    super.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    super.getDriver().findElement(By.xpath("/html/body/div/nav/div/ul/li[3]/a")).click();
    super.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    super.getDriver().findElement(By.xpath("//*[@id=\"zip\"]")).sendKeys("98103");
    super.getDriver().findElement(By.xpath("//*[@id=\"zip_button\"]")).click();
    super.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @Override
  public void signIn() {
    super.getDriver().get("https://www.loopie.us/admin/login.php");
    super.maxWindow();
    super.getDriver().findElement(By.name("p_username")).sendKeys("Admin");
    super.getDriver().findElement(By.name("p_password")).sendKeys("admin456");
    super.getDriver().findElement(By.xpath("//*[@id=\"login_form\"]/div[3]/button")).click();
    super.getDriver().findElement(By.xpath("//*[@id=\"content\"]/main/aside/div[2]/ul/li[3]/a")).click();
    super.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @Override
  public void goToOrderspage() {
    signIn();
    WebElement dateStart = super.getDriver().findElement(By.name("date_start"));
    dateStart.clear();
    dateStart.sendKeys("07/01/2018");
    super.getDriver().findElement(By.xpath("//*[@id=\"content\"]/main/div/div[2]/form/div[9]/button")).click();
    super.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  public void goToCustomerPage() {
    signIn();
    super.getDriver().findElement(By.xpath("//*[@id=\"content\"]/main/aside/div[2]/ul/li[2]")).click();
    super.getDriver().findElement(By.xpath("//*[@id=\"content\"]/main/aside/div[2]/ul/li[2]/ul/li[1]/a")).click();
    try {
      long lastHeight = (long) ((JavascriptExecutor) super.getDriver()).executeScript("return document.body.scrollHeight");

      while (true) {
        ((JavascriptExecutor) super.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(8000);

        long newHeight = (long) ((JavascriptExecutor) super.getDriver()).executeScript("return document.body.scrollHeight");
        if (newHeight == lastHeight) {
          break;
        }
        lastHeight = newHeight;
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void goToCustomersTopOrderSummary(WebElement totalSpentLink) {
    totalSpentLink.click();
    super.getDriver().findElement(By.xpath("//*[@id=\"zone{id}\"]/table/tbody/tr/td[1]/a")).click();
  }

  /**
   * Goes to the a customer's information page using a customer number based on its position in the
   * table (ascending top to bottom).
   *
   * @param customerNum - Position in the table (ascending top to bottom)
   */
  public void goToCustomerInfo(int customerNum) {
    goToCustomerPage();
    super.getDriver().findElement(
        By.tagName("tbody")).findElements(By.tagName("tr")).get(customerNum).findElements
        (By.tagName("td")).get(1).findElement(By.tagName("a")).click();
  }

  /**
   * Goes to the a order's information page using the order number based on its position in the
   * table (ascending top to bottom).
   *
   * @param orderNum - The order number
   */
  public void goToOrderPage(int orderNum) {
    goToOrderspage();
    super.getDriver().findElement(
        By.tagName("tbody")).findElements(By.tagName("tr")).get(orderNum).findElements
        (By.tagName("td")).get(0).findElement(By.tagName("a")).click();

  }
}

