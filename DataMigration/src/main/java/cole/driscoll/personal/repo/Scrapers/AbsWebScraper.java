package cole.driscoll.personal.repo.Scrapers;

import org.openqa.selenium.WebDriver;

/**
 * Scraper which contains a different methods to scrape data from the admin and airtables pages.
 */
public abstract class AbsWebScraper {

  /**
   * The WebDriver for the relevant website.
   */
  private WebDriver driver;

  /**
   * Constructor which takes the WebDriver.
   *
   * @param driver - WebDriver
   */
  public AbsWebScraper(WebDriver driver) {
    this.driver = driver;
  }

  public WebDriver getDriver() {
    return driver;
  }
}