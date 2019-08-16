package cole.driscoll.personal.repo.CustomerInfo;

/**
 * Email information of Loopie customer on the Admin page.
 */
public class Email {

  /**
   * Email address.
   */
  private String Address;

  public Email(String Address) {
    this.Address = Address;
  }

  public String getAddress() {
    return Address;
  }
}
