package cole.driscoll.personal.repo;

import java.util.List;

public abstract class AbsCustomer implements ICustomer {

  private int numOrders;
  private List<Order> orders;
  private String firstName;
  private String lastName;
  private String email;
  private int phoneNum;
  private String mobileCarrier;
  private Address address;

  public AbsCustomer(int numOrders, List<Order> orders, String firstName,
      String lastName, String email, int phoneNum, String mobileCarrier,
      Address address) {
    this.numOrders = numOrders;
    this.orders = orders;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNum = phoneNum;
    this.mobileCarrier = mobileCarrier;
    this.address = address;
    this.orders = orders;
  }
}
