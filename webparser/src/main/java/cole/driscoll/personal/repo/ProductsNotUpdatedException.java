package cole.driscoll.personal.repo;

import org.openqa.selenium.WebDriver;

/**
 * Exception gets thrown if product lists of admin page and airtable does not contain the same elements
 */
public class ProductsNotUpdatedException extends Exception {

  /**
   * Gives message describing error.
   *
   * @param message - Error message
   */
  public ProductsNotUpdatedException(String message, WebDriver admin, WebDriver airtable) {
    super(message);
    admin.close();
    airtable.close();
  }
}
