package cole.driscoll.personal.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.openqa.selenium.WebDriver;

/**
 * The data structure for the Loopie customers in the form of an ArrayList.
 */

public class CustomerPool implements ICustomerPool {

  /**
   * List of Loopie customers.
   */
  private List<AbsCustomer> customers;

  /**
   * The constructor which populates a customer list.
   * @param customers
   */
  public CustomerPool(List<AbsCustomer> customers) {
    this.customers = customers;
  }

  /**
   * The constructor populates the customer list with an empty ArrayList.
   */
  public CustomerPool() {
    this.customers = new ArrayList<>();
  }

  /**
   * Fill the customer pool with the customer info from the website customer page.
   */
  public void populatePool(WebDriver driver) {
    // TODO: Fill this method

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CustomerPool)) {
      return false;
    }
    CustomerPool that = (CustomerPool) o;
    return that.getCustomers().equals(getCustomers());
  }

  @Override
  public int hashCode() {
    return Objects.hash(customers);
  }

  /**
   * Gets the customer list.
   *
   * @return - Customer list
   */
  public List<AbsCustomer> getCustomers() {
    return customers;
  }
}
