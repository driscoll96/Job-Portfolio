package cole.driscoll.personal.repo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {

  private Order order;
  private List<AbsProduct> products;
  private CommercialCustomer customer;

  @Before
  public void setUp() throws Exception {
    products = new ArrayList<>();
    YellowBag bag = new YellowBag();
    Dress dress = new Dress(true);
    products.add(bag);
    products.add(dress);
    customer = new CommercialCustomer("c", "d", "d@gmail.com",
        "3456872234", "AT&T", new Address("123", "s", "WA", "123013"));
    order = new Order(1101, new Date(1111), new Date(2222), new Date(3333), 49.99, products, customer);
  }

  @Test
  public void getID() {
    assertEquals(order.getID(), 1101);
  }

  @Test
  public void getOrderDate() {
    assertEquals(order.getOrderDate(), new Date(1111));
  }

  @Test
  public void getPickUp() {
    assertEquals(order.getPickUp(), new Date(2222));
  }

  @Test
  public void getDelivery() {
    assertEquals(order.getDelivery(), new Date(3333));
  }

  @Test
  public void getOrderAmount() {
    assertEquals(order.getOrderAmount(), 49.99, 0.0);
  }

  @Test
  public void getProductList() {
    assertEquals(order.getProductList(), products);
  }

  @Test
  public void getCustomer() {
    assertEquals(order.getCustomer(), new CommercialCustomer("c", "d", "d@gmail.com",
        "3456872234", "AT&T", new Address("123", "s", "WA", "123013")));
  }

  @Test
  public void equals() {
    assertEquals(order, order);
    assertEquals(order, new Order(1101, new Date(1111), new Date(2222), new Date(3333), 49.99, products, customer));
    assertNotEquals(order, new BlueBag());
    assertNotEquals(order, new Order(11, new Date(1111), new Date(2222), new Date(33), 49.99, products, customer));
  }
}