package cole.driscoll.personal.repo;

import cole.driscoll.personal.repo.Scrapers.AdminOrderScraper;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * *********** NOT SURE IF THIS IS GOING TO STAY
 * Checker which makes sure that the company products or prices have not changed.
 */
public class CheckForUpdate {

  private WebDriver adminDriver;

  /**
   * Constructor which takes the WebDrivers of the Admin website and Airtable.com.
   *
   * @param adminDriver - WebDriver for Admin website
   * @param airtableDriver - WebDriver for Airtable.com
   */
  public CheckForUpdate(WebDriver adminDriver, WebDriver airtableDriver) {
    this.adminDriver = adminDriver;
  }

  /**
   * Checks whether the company products list has been changed by checking the Airtable product list.
   *
   * @return - True if the products are the same
   */
  public boolean sameProducts() {
    try {
      AdminOrderScraper adminScraper = new AdminOrderScraper(adminDriver);
      List<String> adminProducts = adminScraper.getProductList();
      if (adminProducts.equals("")) {
        return true;
      }
    } catch (NoSuchElementException e) {
      System.out.println("Program terminated. Please make sure you are logged out of your Loopie "
          + "customer account before loading the program");
      adminDriver.close();
      System.exit(1);
    }
    return false;
  }

}
