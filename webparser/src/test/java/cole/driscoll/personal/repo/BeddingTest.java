package cole.driscoll.personal.repo;

import static org.junit.Assert.*;

import cole.driscoll.personal.repo.ProductServiceInfo.Specials.Bedding;
import org.junit.Before;
import org.junit.Test;

public class BeddingTest {

  private Bedding bedding;

  @Before
  public void setUp() throws Exception {
    bedding = new Bedding();
  }

  @Test
  public void getPrice() {
    assertEquals(bedding.getPrice(), 49.99, 0.0);
  }
}