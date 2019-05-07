package cole.driscoll.personal.repo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComforterTwinFullTest {

  private ComforterTwinFull comforter;
  private ComforterTwinFull downComforter;

  @Before
  public void setUp() throws Exception {
    comforter = new ComforterTwinFull(false);
    downComforter = new ComforterTwinFull(true);
  }

  @Test
  public void getPrice() {
    assertEquals(comforter.getPrice(), 35.00, 0.0);
    assertEquals(downComforter.getPrice(), 40.00, 0.0);
  }

  @Test
  public void equals() {
    assertEquals(comforter, comforter);
    assertEquals(comforter, new ComforterTwinFull(false));
    assertNotEquals(comforter, new Bedding());
    assertNotEquals(comforter, downComforter);
    assertEquals(downComforter, new ComforterTwinFull(true));
  }

  @Test
  public void hashCodeTest() {
    assertEquals(comforter.hashCode(), new ComforterTwinFull(false).hashCode());
  }
}