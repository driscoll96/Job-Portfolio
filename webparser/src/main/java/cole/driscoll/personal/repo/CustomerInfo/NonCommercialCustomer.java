package cole.driscoll.personal.repo.CustomerInfo;

/**
 * Non commercial customer info.
 */
public class NonCommercialCustomer extends AbsCustomer {

  /**
   * Constructor of the which takes and fills all properties, except the order list which it just
   * populates with an empty ArrayList.
   *
   * @param firstName - First name.
   * @param lastName - Last name.
   * @param email - Email streetAddress.
   * @param phoneNum - Phone number.
   * @param streetAddress - StreetAddress info of the customer.
   */
  public NonCommercialCustomer(String firstName, String lastName, String email, String phoneNum, StreetAddress streetAddress) {
    super(firstName, lastName, email, phoneNum, streetAddress);
  }
}
