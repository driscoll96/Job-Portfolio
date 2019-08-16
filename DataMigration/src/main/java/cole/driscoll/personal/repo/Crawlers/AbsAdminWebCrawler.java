package cole.driscoll.personal.repo.Crawlers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbsAdminWebCrawler implements IWebCrawler {

  /**
   * The chrome WebDriver.
   */
  private WebDriver driver;

  /**
   * List of current tabs.
   */
  private List<String> tabs;

  /**
   * Constructor which fills the WebDriver.
   *
   * @param driver - WebDriver
   */
  public AbsAdminWebCrawler(WebDriver driver) {
    this.driver = driver;
    tabs = new ArrayList<>();
  }

  /**
   * Gets the relevant WebDriver.
   *
   * @return - WebDriver
   */
  public WebDriver getDriver() {
    return driver;
  }

  @Override
  public void maxWindow() {
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @Override
  public void goToProductPage() {
    driver.get("https://www.loopie.us/admin/login.php");
    maxWindow();
    driver.findElement(
        By.xpath("//*[@id=\"content\"]/main/div/div[1]/div/div[1]/form/div/span/button")).click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElement(By.xpath("/html/body/div/nav/div/ul/li[3]/a")).click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//*[@id=\"zip\"]")).sendKeys("98103");
    driver.findElement(By.xpath("//*[@id=\"zip_button\"]")).click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @Override
  public void signIn() {
    driver.get("https://www.loopie.us/admin/login.php");
    maxWindow();
    driver.findElement(By.name("p_username")).sendKeys("Admin");
    driver.findElement(By.name("p_password")).sendKeys("admin456");
    driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[3]/button")).click();
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
  }
}
