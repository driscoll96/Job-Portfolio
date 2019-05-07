package cole.driscoll.personal.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Abstract customer class which holds the info of customers.
 */
public abstract class AbsCustomer implements ICustomer {

  /**
   * List of their orders.
   */
  private List<Order> orders;

  /**
   * First name.
   */
  private String firstName;

  /**
   * Last name.
   */
  private String lastName;

  /**
   * Email address.
   */
  private String email;

  /**
   * Phone number.
   */
  private String phoneNum;

  /**
   * The mobile carrier used by the customers.
   */
  private String mobileCarrier;

  /**
   * Address info of the customer.
   */
  private Address address;

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
  public AbsCustomer(String firstName, String lastName, String email, String phoneNum, String mobileCarrier,
      Address address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNum = phoneNum;
    this.mobileCarrier = mobileCarrier;
    this.address = address;
    this.orders = new ArrayList<>();
  }

  public List<Order> getOrders() {
    return orders;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNum() {
    return phoneNum;
  }

  public String getMobileCarrier() {
    return mobileCarrier;
  }

  public Address getAddress() {
    return address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbsCustomer)) {
      return false;
    }
    AbsCustomer that = (AbsCustomer) o;
    return phoneNum == that.phoneNum &&
        Objects.equals(orders, that.orders) &&
        Objects.equals(firstName, that.firstName) &&
        Objects.equals(lastName, that.lastName) &&
        Objects.equals(email, that.email) &&
        Objects.equals(mobileCarrier, that.mobileCarrier) &&
        Objects.equals(address, that.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orders, firstName, lastName, email, phoneNum, mobileCarrier, address);
  }
}
