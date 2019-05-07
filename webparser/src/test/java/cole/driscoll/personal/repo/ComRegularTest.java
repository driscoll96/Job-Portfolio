package cole.driscoll.personal.repo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComRegularTest {

  private ComRegular bag;

  @Before
  public void setUp() throws Exception {
    bag = new ComRegular();
  }

  @Test
  public void getPrice() {
    assertEquals(bag.getPrice(), 44.99, 0.0);
  }

  @Test
  public void equals() {
    assertEquals(bag, bag);
    assertEquals(bag, new ComRegular());
    assertNotEquals(bag, new Dress(false));
  }
}