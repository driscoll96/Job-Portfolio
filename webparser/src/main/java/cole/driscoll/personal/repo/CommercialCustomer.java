package cole.driscoll.personal.repo;

import java.util.List;

public class CommercialCustomer extends AbsCustomer {

  public CommercialCustomer(int numOrders, List<Order> orders, String firstName,
      String lastName, String email, int phoneNum, String mobileCarrier,
      Address address) {
    super(numOrders, orders, firstName, lastName, email, phoneNum, mobileCarrier, address);
  }
}
