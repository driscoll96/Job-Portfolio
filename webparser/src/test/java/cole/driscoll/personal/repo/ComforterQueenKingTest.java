package cole.driscoll.personal.repo;

import static org.junit.Assert.*;

import cole.driscoll.personal.repo.ProductServiceInfo.ComfortersDryCleaning.ComforterQueenKing;
import cole.driscoll.personal.repo.ProductServiceInfo.Specials.Bedding;
import org.junit.Before;
import org.junit.Test;

public class ComforterQueenKingTest {

  private ComforterQueenKing comforter;
  private ComforterQueenKing downComforter;

  @Before
  public void setUp() throws Exception {
    comforter = new ComforterQueenKing(false);
    downComforter = new ComforterQueenKing(true);
  }

  @Test
  public void getPrice() {
    assertEquals(comforter.getPrice(), 40.00, 0.0);
    assertEquals(downComforter.getPrice(), 45.00, 0.0);
  }

  @Test
  public void equals() {
    assertEquals(comforter, comforter);
    assertEquals(comforter, new ComforterQueenKing(false));
    assertNotEquals(comforter, new Bedding());
    assertNotEquals(comforter, downComforter);
    assertEquals(downComforter, new ComforterQueenKing(true));
  }

  @Test
  public void hashCodeTest() {
    assertEquals(comforter.hashCode(), new ComforterQueenKing(false).hashCode());
  }
}