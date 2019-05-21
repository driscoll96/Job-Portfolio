package cole.driscoll.personal.repo;

import static org.junit.Assert.*;

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
        "3456872234", 1234, new Address("123", "s", "WA", "123013"));
    customer2 = new NonCommercialCustomer("l", "d", "l@gmail.com",
        "3456322234", 123, new Address("13", "c", "WA", "123013"));
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