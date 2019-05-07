package cole.driscoll.personal.repo;

import static org.junit.Assert.*;

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