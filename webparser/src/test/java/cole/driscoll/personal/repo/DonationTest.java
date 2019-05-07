package cole.driscoll.personal.repo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DonationTest {

  private Donation donation;

  @Before
  public void setUp() throws Exception {
    donation = new Donation();
  }

  @Test
  public void getPrice() {
    assertEquals(donation.getPrice(), 0.00, 0.0);
  }

  @Test
  public void equals() {
    assertEquals(donation, donation);
    assertEquals(donation, new Donation());
    assertNotEquals(donation, new BlueBag());
  }
}