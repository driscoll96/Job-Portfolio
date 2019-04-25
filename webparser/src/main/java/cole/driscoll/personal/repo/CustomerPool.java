package cole.driscoll.personal.repo;

import java.util.ArrayList;
import java.util.List;

public class CustomerPool implements ICustomerPool {

  private List<AbsCustomer> customers;

  public CustomerPool(List<AbsCustomer> customers) {
    this.customers = customers;
  }

  public CustomerPool() {
    this.customers = new ArrayList<>();
  }
}
