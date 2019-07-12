package cole.driscoll.personal.repo.JSONData;

import cole.driscoll.personal.repo.CustomerInfo.StreetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * Information scraped from the Loopie Admin website.
 */
public class JSONCustomer {

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
   * Customer address.
   */
  private List<StreetAddress> Addresses = new ArrayList<>();

  /**
   * Phone number.
   */
  private List<Phone> Phones = new ArrayList<>();

  /**
   * Not sure what this is for.
   */
  private final String __T = "u";

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
    String phone = phoneNum.replaceAll("[^0-9]","");
    this.FirstName = firstName;
    this.LastName = lastName;
    this.Phone = "+1-" + phone;
    this.Emails.add(email);
    this.Addresses.add(new StreetAddress(address1, address2, city, state, zipCode));
    this.Phones.add(new Phone(phone, firstName));
  }

}
