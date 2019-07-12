package cole.driscoll.personal.repo.Exceptions;

import org.openqa.selenium.WebDriver;

/**
 * Identifies when the admin customer data does not match the order data.
 */
public class NoCustomerFoundException extends Exception {

  /**
   * Sends a message explaining the problem and closes driver.
   *
   * @param message - Error message
   */
  public NoCustomerFoundException(String message, WebDriver admin) {
    super(message);
    admin.close();
  }
}
