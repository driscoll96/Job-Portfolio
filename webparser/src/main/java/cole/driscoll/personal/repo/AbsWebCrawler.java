package cole.driscoll.personal.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public abstract class AbsWebCrawler implements IWebCrawler {

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
  public AbsWebCrawler(WebDriver driver) {
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

  /**
   * Gets the window tabs list.
   *
   * @return - Window tabs list
   */
  public List<String> getTabs() {
    return tabs;
  }

  /**
   * Add element to tabs list.
   *
   * @param newTab - New tab
   */
  public void addToTabsList(String newTab) {
    tabs.add(newTab);
  }

  /**
   * Removes element from tabs list.
   *
   * @param i - index of element to remove
   */
  public void removeFromTabsList(int i) {
    tabs.remove(i);
  }
}
