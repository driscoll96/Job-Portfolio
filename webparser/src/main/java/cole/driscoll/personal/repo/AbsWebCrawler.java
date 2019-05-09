package cole.driscoll.personal.repo;

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

  public WebDriver getDriver() {
    return driver;
  }
}
