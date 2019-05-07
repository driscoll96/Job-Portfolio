package cole.driscoll.personal.repo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AddressTest {

  public Address address;

  @Before
  public void setUp() throws Exception {
    address = new Address("123 50th st", "Seattle", "WA", "91020");
  }


  @Test
  public void equals() {
    assertEquals(address, address);
    assertEquals(address, new Address("123 50th st", "Seattle", "WA", "91020"));
    assertNotEquals(address, new BlueBag());
  }

  @Test
  public void hashCodeTest() {
    assertEquals(address.hashCode(), new Address("123 50th st", "Seattle", "WA", "91020").hashCode());
  }

  @Test
  public void getStreet() {
    assertEquals(address.getStreet(), "123 50th st");
  }

  @Test
  public void getCity() {
    assertEquals(address.getCity(), "Seattle");
  }

  @Test
  public void getState() {
    assertEquals(address.getState(), "WA");
  }

  @Test
  public void getZipCode() {
    assertEquals(address.getZipCode(), 91020);
  }
}