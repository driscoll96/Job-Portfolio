package cole.driscoll.personal.repo;

import static org.junit.Assert.*;

import cole.driscoll.personal.repo.ProductServiceInfo.Bags.BlueBag;
import cole.driscoll.personal.repo.CustomerInfo.StreetAddress;
import org.junit.Before;
import org.junit.Test;

public class StreetAddressTest {

  public StreetAddress streetAddress;

  @Before
  public void setUp() throws Exception {
    streetAddress = new StreetAddress("123 50th st", null, "Seattle", "WA", "91020");
  }


  @Test
  public void equals() {
    assertEquals(streetAddress, streetAddress);
    assertEquals(streetAddress, new StreetAddress("123 50th st", null,
        "Seattle", "WA", "91020"));
    assertNotEquals(streetAddress, new BlueBag());
  }

  @Test
  public void hashCodeTest() {
    assertEquals(streetAddress.hashCode(), new StreetAddress("123 50th st", null,
        "Seattle", "WA", "91020").hashCode());
  }

  @Test
  public void getStreet() {
    assertEquals(streetAddress.getStreetAddress1(), "123 50th st");
  }

  @Test
  public void getCity() {
    assertEquals(streetAddress.getCity(), "Seattle");
  }

  @Test
  public void getState() {
    assertEquals(streetAddress.getState(), "WA");
  }

  @Test
  public void getZipCode() {
    assertEquals(streetAddress.getZipCode(), 91020);
  }
}