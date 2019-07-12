package cole.driscoll.personal.repo;

import static org.junit.Assert.*;

import cole.driscoll.personal.repo.ProductServiceInfo.Bags.BlueBag;
import cole.driscoll.personal.repo.ProductServiceInfo.ComfortersDryCleaning.Dress;
import org.junit.Before;
import org.junit.Test;

public class DressTest {

  private Dress dress;

  @Before
  public void setUp() throws Exception {
    dress = new Dress(true);
  }

  @Test
  public void getPrice() {
    assertEquals(dress.getPrice(), 24.99, 0.0);
  }

  @Test
  public void equals() {
    assertEquals(dress, dress);
    assertEquals(dress, new Dress(true));
    assertNotEquals(dress, new Dress(false));
    assertNotEquals(dress, new BlueBag());
  }
}