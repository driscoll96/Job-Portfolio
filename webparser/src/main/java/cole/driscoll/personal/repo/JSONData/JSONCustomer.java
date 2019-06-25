package cole.driscoll.personal.repo.JSONData;

import cole.driscoll.personal.repo.CustomerInfo.StreetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * information scraped from the Loopie Admin website.
 */
public class JSONCustomer {

  /**
   * Customer ID.
   */
  //private int ID;

  /**
   * First name.
   */
  private String FirstName;

  /**
   * Last name.
   */
  private String LastName;

  /**
   * Customer's default phone.
   */
  private String Phone;

  /**
   * Email address.
   */
  private List<String> Emails = new ArrayList<>();

  /**
   * Payment Cards (null for database)
   */
  //private List<PaymentCard> PaymentCards = new ArrayList<>();

  /**
   * Customer address.
   */
  private List<StreetAddress> Addresses = new ArrayList<>();

  /**
   * Devices registered by customer.
   */
  //private List<UserDevice> Devices = new ArrayList<>();

  /**
   * Phone number.
   */
  private List<Phone> Phones = new ArrayList<>();

  private final String __T = "u";

  /**
   * Last time customer was active (null when transferring into database?)
   */
  private final String LastActive = "";

  /**
   * Constructor which populates field variables with customer info from the admin website.
   *
   * @param firstName - First name
   * @param lastName - Last name
   * @param phoneNum - Phone number
   * @param email - Email address
   * @param address1 - Street address
   * @param address2 - Street address part 2
   * @param zipCode - Zip code
   * @param city - City
   * @param state - State
   */
  public JSONCustomer(String firstName, String lastName, String email, String phoneNum,
      String address1, String address2, String zipCode, String city, String state) {
    this.FirstName = firstName;
    this.LastName = lastName;
    this.Phone = "+1-" + phoneNum;
    this.Emails.add(email);
    this.Addresses.add(new StreetAddress(address1, address2, city, state, zipCode));
    this.Phones.add(new Phone(phoneNum, firstName));
  }

  public String getFirstName() {
    return FirstName;
  }

  public String getLastName() {
    return LastName;
  }

  public String getPhone() {
    return Phone;
  }

  public List<String> getEmails() {
    return Emails;
  }

  public List<StreetAddress> getAddresses() {
    return Addresses;
  }

  public List<cole.driscoll.personal.repo.JSONData.Phone> getPhones() {
    return Phones;
  }
}
