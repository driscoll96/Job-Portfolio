package edu.neu.ccs.cs5500.SkiDataGenerator.Entity;


import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.SkiLift;
import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.SkillLevel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SkiLiftTest {

  private SkiLift testSkiLift;
  private SkiLift testSkiLift2;

  @Before
  public void setUp() throws Exception {
    testSkiLift = new SkiLift(3, "Harmony", SkillLevel.EXPERT);
    testSkiLift2 = new SkiLift(5, "Symphony", SkillLevel.BUNNYHILL);
  }

  @Test
  public void getLiftNumValid() {
    Assert.assertEquals(testSkiLift.getLiftNum(), 3);
  }

  @Test
  public void getLiftNumInvalid() {
    Assert.assertNotEquals(testSkiLift.getLiftNum(), 4);
  }

  @Test
  public void testToStringValid() {
    Assert.assertEquals(testSkiLift.toString(), "Lift Number: 3 Lift Name: Harmony Lift Connections: [] Alpine Status: false");
  }

  @Test
  public void testToStringInvalid() {
    Assert.assertNotEquals(testSkiLift.toString(), "Lift Number:3");
  }

  @Test
  public void testEqualsValid() {
    Assert.assertTrue(testSkiLift.equals(testSkiLift));
  }

  @Test
  public void testEqualsInvalid() {
    Assert.assertFalse(testSkiLift.equals(testSkiLift2));
  }

  @Test
  public void testHashCodeValid() {
    Assert.assertEquals(testSkiLift.hashCode(), 3);
  }

  @Test
  public void testHashCodeInvalid() {
    Assert.assertNotEquals(testSkiLift.hashCode(), 4);
  }
}