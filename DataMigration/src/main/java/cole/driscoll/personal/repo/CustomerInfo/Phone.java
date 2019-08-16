package cole.driscoll.personal.repo.CustomerInfo;

/**
 * Contains the info of a customer's phone (for JSON data).
 */
// Commented out variables are not needed for now
public class Phone {

  /**
   * Type of the phone being used (e.g. landline or mobile).
   */
  //private final String PhoneType = "mobile";

  /**
   * The international calling code.
   */
  private final String CallingCode = "+1";

  /**
   * The phone number.
   */
  private String Number;

  /**
   * Indicates whether the phone number has been verified as belonging to a known person or entity.
   */
  //private final boolean IsVerified = true;

  /**
   * The date/time when the phone number was last verified.
   */
  //private String VerificationTimeUtc;

  /**
   * The name of the phone number. Example "Wife's phone", "Marcus' Cell".
   */
  //private String Name;

  /**
   * Whether the phone number should be treated as the default phone number for the user.
   */
  //private final boolean Default = true;

  /**
   * Creates phone instance using phone number and name of the customer.
   *
   * @param number - Phone number
   * @param name - Customer name
   */
  public Phone(String number, String name) {
    this.Number = number;
    //Name = name + "s Phone";
  }
}
