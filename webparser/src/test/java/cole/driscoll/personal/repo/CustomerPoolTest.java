package cole.driscoll.personal.repo;

import cole.driscoll.personal.repo.CustomerInfo.AbsCustomer;
import cole.driscoll.personal.repo.CustomerInfo.StreetAddress;
import cole.driscoll.personal.repo.CustomerInfo.CommercialCustomer;
import cole.driscoll.personal.repo.CustomerInfo.CustomerPool;
import cole.driscoll.personal.repo.CustomerInfo.NonCommercialCustomer;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CustomerPoolTest {

  private CustomerPool pool;
  private List<AbsCustomer> customers;
  private AbsCustomer customer1, customer2;

  @Before
  public void setUp() throws Exception {
    customer1 = new CommercialCustomer("c", "d", "d@gmail.com",
        "3456872234", new StreetAddress("123", null,"s", "WA", "123013"));
    customer2 = new NonCommercialCustomer("l", "d", "l@gmail.com",
        "3456322234", new StreetAddress("13", null,"c", "WA", "123013"));
    customers = new ArrayList<>();
    customers.add(customer1);
    customers.add(customer2);
    pool = new CustomerPool(customers);
  }

  @Test
  public void populatePool() {

  }

  @Test
  public void equals() {
  }

  @Test
  public void getCustomers() {
  }
}