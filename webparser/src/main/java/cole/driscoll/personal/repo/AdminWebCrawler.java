package cole.driscoll.personal.repo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
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
    super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    super.getDriver().manage().window().maximize();
    super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    super.getDriver().findElement(
        By.xpath("//*[@id=\"content\"]/main/div/div[1]/div/div[1]/form/div/span/button")).click();
    super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    super.getDriver().findElement(By.xpath("/html/body/div/nav/div/ul/li[3]/a")).click();
    super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    super.getDriver().findElement(By.xpath("//*[@id=\"zip\"]")).sendKeys("98103");
    super.getDriver().findElement(By.xpath("//*[@id=\"zip_button\"]")).click();
    super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Override
  public void signIn() {
    super.getDriver().get("https://www.loopie.us/admin/login.php");
    super.getDriver().findElement(By.name("p_username")).sendKeys("Admin");
    super.getDriver().findElement(By.name("p_password")).sendKeys("admin456");
    super.getDriver().findElement(By.xpath("//*[@id=\"login_form\"]/div[3]/button")).click();
    super.getDriver().findElement(By.xpath("//*[@id=\"content\"]/main/aside/div[2]/ul/li[3]/a")).click();
    super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Override
  public void goToOrderspage() {
    signIn();
    WebElement dateStart = super.getDriver().findElement(By.name("date_start"));
    dateStart.clear();
    dateStart.sendKeys("07/01/2018");
    super.getDriver().findElement(By.xpath("//*[@id=\"content\"]/main/div/div[2]/form/div[9]/button")).click();
    super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
}

