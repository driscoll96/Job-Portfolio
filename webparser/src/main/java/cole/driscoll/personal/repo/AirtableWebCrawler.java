package cole.driscoll.personal.repo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    signIn();
    super.getDriver().get("https://airtable.com/tbluxbhofupfVSAAD/viwUw62qdfp9mri8v?blocks=hide");
    // TODO: Figure out why xpath for services tab on airtable page isn't working
    /*super.getDriver().findElement(By.xpath("//*[@id=\"homeScreen\"]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div[1]/a/div")).click();
    super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //System.out.println(super.getDriver().findElement(By.xpath("")).getText());
    super.getDriver().findElement(By.id("tbluxbhofupfVSAAD")).click();
    //services.findElement(By.tagName("a")).click();
    super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
  }

  @Override
  public void signIn() {
    super.getDriver().get("https://airtable.com/login");
    super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    super.getDriver().manage().window().maximize();
    super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebElement username = super.getDriver().findElement(By.xpath("//*[@id=\"sign-in-form-fields-root\"]/div/label[1]/input"));
    username.clear();
    username.sendKeys("loopielaundry@gmail.com");
    WebElement password = super.getDriver().findElement(By.xpath("//*[@id=\"sign-in-form-fields-root\"]/div/label[2]/input"));
    password.clear();
    password.sendKeys("loopie2018");
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

  public void goToOrdersPageAfterLoggedIn() {
    super.getDriver().get("https://airtable.com/tblHSvgxLOgWynMvM/viwCmcPKNZE6nMez3?blocks=hide");
  }
}
