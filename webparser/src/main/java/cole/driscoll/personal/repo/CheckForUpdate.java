package cole.driscoll.personal.repo;

import cole.driscoll.personal.repo.Scrapers.AdminWebScraper;
import cole.driscoll.personal.repo.Scrapers.AirtableWebScraper;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Checker which makes sure that the company products or prices have not changed.
 */
public class CheckForUpdate {

  private WebDriver adminDriver;

  private WebDriver airtableDriver;

  /**
   * Constructor which takes the WebDrivers of the Admin website and Airtable.com.
   *
   * @param adminDriver - WebDriver for Admin website
   * @param airtableDriver - WebDriver for Airtable.com
   */
  public CheckForUpdate(WebDriver adminDriver, WebDriver airtableDriver) {
    this.adminDriver = adminDriver;
    this.airtableDriver = airtableDriver;
  }

  /**
   * Checks whether the company products list has been changed by checking the Airtable product list.
   *
   * @return - True if the products are the same
   */
  public boolean sameProducts() {
    try {
      AdminWebScraper adminScraper = new AdminWebScraper(adminDriver);
      AirtableWebScraper airtableScraper = new AirtableWebScraper(airtableDriver);
      List<String> adminProducts = adminScraper.getProductList();
      List<String> airtableProducts = airtableScraper.getProductList();
      if (adminProducts.equals(airtableProducts)) {
        return true;
      }
    } catch (NoSuchElementException e) {
      System.out.println("Program terminated. Please make sure you are logged out of your Loopie "
          + "customer account before loading the program");
      adminDriver.close();
      airtableDriver.close();
      System.exit(1);
    }
    return false;
  }

}
