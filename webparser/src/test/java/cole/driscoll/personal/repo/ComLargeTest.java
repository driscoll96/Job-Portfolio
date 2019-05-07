package cole.driscoll.personal.repo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComLargeTest {

  private ComLarge bag;

  @Before
  public void setUp() throws Exception {
    bag = new ComLarge();
  }

  @Test
  public void getPrice() {
    assertEquals(bag.getPrice(), 73.99, 0.0);
  }

  @Test
  public void equals() {
    assertEquals(bag, bag);
    assertEquals(bag, new ComLarge());
    assertNotEquals(bag, new Dress(false));
  }
}