package cole.driscoll.personal.repo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public abstract class AbsWebCrawler implements IWebCrawler {

  /**
   * The chrome WebDriver.
   */
  private WebDriver driver;

  /**
   * Constructor which fills the WebDriver.
   *
   * @param driver - WebDriver
   */
  public AbsWebCrawler(WebDriver driver) {
    this.driver = driver;
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
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
}
