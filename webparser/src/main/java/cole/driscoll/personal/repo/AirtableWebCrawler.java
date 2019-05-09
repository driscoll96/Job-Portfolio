package cole.driscoll.personal.repo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AirtableWebCrawler extends AbsWebCrawler {

  /**
   * Constructor which fills the WebDriver.
   *
   * @param driver - WebDriver
   */
  public AirtableWebCrawler(WebDriver driver) {
    super(driver);
  }

  @Override
  public void goToProductPage() {
    super.getDriver().findElement(By.xpath("//*[@id=\"homeScreen\"]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div[1]/a/div")).click();
    super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    super.getDriver().findElement(By.xpath("//*[@id=\"tableTabsContainer\"]/div/div[2]/div[2]/div[6]")).click();
    super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

  }

  @Override
  public void signIn() {
    super.getDriver().get("https://airtable.com/login");
    super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    super.getDriver().manage().window().maximize();
    super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    super.getDriver().findElement(
        By.xpath("//*[@id=\"sign-in-form-fields-root\"]/div/label[1]/input")).sendKeys("loopielaundry@gmail.com");
    super.getDriver().findElement(By.xpath("//*[@id=\"sign-in-form-fields-root\"]/div/label[2]/input")).sendKeys("loopie2018");
    super.getDriver().findElement(By.xpath("//*[@id=\"sign-in-form-fields-root\"]/div/label[3]/input")).click();
    super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Override
  public void goToOrderspage() {
    signIn();
    super.getDriver().findElement(By.xpath("//*[@id=\"homeScreen\"]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div[1]/a/div")).click();
    super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    super.getDriver().findElement(By.xpath("//*[@id=\"tableTabsContainer\"]/div/div[2]/div[2]/div[1]")).click();
    super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
}
