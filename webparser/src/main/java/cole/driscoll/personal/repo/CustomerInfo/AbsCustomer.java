package cole.driscoll.personal.repo.CustomerInfo;

import cole.driscoll.personal.repo.OrderInfo.Order;
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
   * Email streetAddress.
   */
  private String email;

  /**
   * Phone number.
   */
  private String phoneNum;

  /**
   * Customer Id number.
   */
  private int Id;

  /**
   * StreetAddress info of the customer.
   */
  private StreetAddress streetAddress;

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
  public AbsCustomer(String firstName, String lastName, String email, String phoneNum, StreetAddress streetAddress) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNum = phoneNum;
    this.Id = Id;
    this.streetAddress = streetAddress;
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

  public StreetAddress getStreetAddress() {
    return streetAddress;
  }

  /**
   * Gets the full name of the customer.
   *
   * @return - Full name of the customer
   */
  public String getFullName() {
    return firstName+" "+lastName;
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
        Objects.equals(Id, that.Id) &&
        Objects.equals(streetAddress, that.streetAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orders, firstName, lastName, email, phoneNum, Id, streetAddress);
  }
}
