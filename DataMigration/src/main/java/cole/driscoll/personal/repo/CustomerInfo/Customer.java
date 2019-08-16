package cole.driscoll.personal.repo.CustomerInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer information scraped from the Loopie Admin website to be converted into JSON.
 */
public class Customer {

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
   * Email address
   */
  private String Email;

  /**
   * Email addresses.
   */
  private List<cole.driscoll.personal.repo.CustomerInfo.Email> Emails = new ArrayList<>();

  /**
   * Customer address.
   */
  private List<StreetAddress> Addresses = new ArrayList<>();

  /**
   * Phone number.
   */
  private List<Phone> Phones = new ArrayList<>();

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
  public Customer(String firstName, String lastName, String email, String phoneNum,
      String address1, String address2, String zipCode, String city, String state) {
    String phone = phoneNum.replaceAll("[^0-9]","");
    this.FirstName = firstName;
    this.LastName = lastName;
    this.Phone = "+1-" + phone;
    this.Email = email;
    this.Emails.add(new Email(email));
    this.Addresses.add(new StreetAddress(address1, address2, city, state, zipCode));
    this.Phones.add(new Phone(phone, firstName));
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

  public List<Email> getEmails() {
    return Emails;
  }

  public List<StreetAddress> getAddresses() {
    return Addresses;
  }

  public List<cole.driscoll.personal.repo.CustomerInfo.Phone> getPhones() {
    return Phones;
  }

  public String getEmail() {
    return Email;
  }
}
