package cole.driscoll.personal.repo;

/**
 * Info of commercial customer.
 */
public class CommercialCustomer extends AbsCustomer {

  /**
   * Constructor of the which takes and fills all properties, except the order list which it just
   * populates with an empty ArrayList.
   *
   * @param firstName - First name.
   * @param lastName - Last name.
   * @param email - Email address.
   * @param phoneNum - Phone number.
   * @param mobileCarrier - Mobile carrier used by the customers.
   * @param address - Address info of the customer.
   */
  public CommercialCustomer(String firstName, String lastName, String email, String phoneNum,
      String mobileCarrier, Address address) {
    super(firstName, lastName, email, phoneNum, mobileCarrier, address);
  }
}
