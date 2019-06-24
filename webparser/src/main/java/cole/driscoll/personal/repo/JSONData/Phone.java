package cole.driscoll.personal.repo.JSONData;

public class Phone {

  /**
   * Type of the phone being used (e.g. landline or mobile).
   */
  private final String PhoneType = "mobile";

  /**
   * The international calling code.
   */
  private final String CallingCode = "+1";

  /**
   * The phone number.
   */
  private String Number;

  /**
   * The verification code required for the user to login.
   */
  private PhoneVerificationCode VerificationCode = new PhoneVerificationCode();

  /**
   * Indicates whether the phone number has been verified as belonging to a known person or entity.
   */
  private final boolean IsVerified = true;

  /**
   * The date/time when the phone number was last verified.
   */
  //private String VerificationTimeUtc;

  /**
   * The name of the phone number. Example "Wife's phone", "Marcus' Cell".
   */
  private String Name;

  /**
   * Whether the phone number should be treated as the default phone number for the user.
   */
  private final boolean Default = true;

  /**
   * Creates phone instance using phone number and name of the customer.
   *
   * @param number - Phone number
   * @param name - Customer name
   */
  public Phone(String number, String name) {
    this.Number = number;
    Name = name + "s Phone";
  }
}
