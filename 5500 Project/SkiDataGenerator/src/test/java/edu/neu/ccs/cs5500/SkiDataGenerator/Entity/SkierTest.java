package edu.neu.ccs.cs5500.SkiDataGenerator.Entity;


import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.SkiLiftRide;
import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.Skier;
import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.Day;
import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.SkillLevel;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SkierTest {

  private SkiLiftRide testSkiLiftRide;
  private SkiLiftRide testSkiLiftRide1;
  private SkiLiftRide testSkiLiftRide2;

  private ArrayList<SkiLiftRide> testSkiRide;
  private ArrayList<SkiLiftRide> testSkiRide1;

  private Skier testSkier;
  private Skier testSkier2;

  @Before
  public void setUp() throws Exception {

    testSkiLiftRide = new SkiLiftRide(1, 0);
    testSkiLiftRide1 = new SkiLiftRide(1, 30);
    testSkiLiftRide2 = new SkiLiftRide(1, 60);

    testSkiRide = new ArrayList<>();
    testSkiRide.add(testSkiLiftRide);
    testSkiRide.add(testSkiLiftRide1);

    testSkiRide1 = new ArrayList<>();
    testSkiRide1.add(testSkiLiftRide1);
    testSkiRide1.add(testSkiLiftRide2);

    testSkier = new Skier(1, 1, false, SkillLevel.BUNNYHILL, true, Day.FRIDAY);
    testSkier2 = new Skier(2, 2, true, SkillLevel.INTERMEDIATE, false, Day.FRIDAY);
  }

  @Test
  public void getSkierNum() {
    Assert.assertEquals(testSkier.getSkierNum(), testSkier.hashCode());
  }

  @Test
  public void getCurrentLiftValid() {
    Assert.assertEquals(testSkier.getCurrentLift(), 1);
  }

  @Test
  public void getCurrentLiftInvalid() {
    Assert.assertNotEquals(testSkier.getCurrentLift(), 2);
  }

  @Test
  public void setCurrentLiftValid() {
    testSkier.setCurrentLift(3);
    Assert.assertEquals(testSkier.getCurrentLift(), 3);
  }

  @Test
  public void setCurrentLiftInvalid() {
    testSkier2.setCurrentLift(3);
    Assert.assertNotEquals(testSkier.getCurrentLift(), 2);
  }

  @Test
  public void isLazyValid() {
    Assert.assertTrue(testSkier.isHasLunch());
  }


  @Test
  public void setLazyValid() {
    testSkier.setLazy(false);
    Assert.assertFalse(testSkier.isLazy());
  }


  @Test
  public void getSkillLevelValid() {
    Assert.assertEquals(testSkier.getSkillLevel(), SkillLevel.BUNNYHILL);
  }

  @Test
  public void getSkillLevelInvalid() {
    Assert.assertNotEquals(testSkier.getSkillLevel(), SkillLevel.INTERMEDIATE);
  }

  @Test
  public void setSkillLevelValid() {
    testSkier.setSkillLevel(SkillLevel.INTERMEDIATE);
    Assert.assertEquals(testSkier.getSkillLevel(), SkillLevel.INTERMEDIATE);
  }

  @Test
  public void setSkillLevelInvalid() {
    testSkier.setSkillLevel(SkillLevel.INTERMEDIATE);
    Assert.assertNotEquals(testSkier.getSkillLevel(), SkillLevel.BUNNYHILL);
  }

  @Test
  public void isHasLunchValid() {
    Assert.assertTrue(testSkier.isHasLunch());
  }

  @Test
  public void isHasLunchInvalid() {
    Assert.assertFalse(!testSkier.isHasLunch());
  }

  @Test
  public void setHasLunchValid() {
    testSkier.setHasLunch(false);
    Assert.assertFalse(testSkier.isHasLunch());
  }

  @Test
  public void setHasLunchInvalid() {
    testSkier.setHasLunch(true);
    Assert.assertFalse(!testSkier.isHasLunch());
  }

  @Test
  public void addLiftRideValid() {
    testSkier.addLiftRide(testSkiLiftRide);
    testSkier.addLiftRide(testSkiLiftRide1);
    Assert.assertEquals(testSkier.getLiftRides(), testSkiRide);
  }

  @Test
  public void addLiftRideInvalid() {
    testSkier.addLiftRide(testSkiLiftRide);
    testSkier.addLiftRide(testSkiLiftRide1);
    Assert.assertNotEquals(testSkier.getLiftRides(), testSkiRide1);
  }

  @Test
  public void testToStringValid() {
    Assert.assertEquals(testSkier.toString(),
        "Skier Number:" + testSkier.getSkierNum() + ", " + "Current Lift:" + testSkier.getCurrentLift()
            + ", " + "Lazy?:" + testSkier.isLazy() + ", " + "Skill Level:" + testSkier.getSkillLevel() + ", "
            + "Lunch?:" + testSkier.isHasLunch() + ", " + "Lift Rides: " + testSkier.getLiftRides()
            .toString());
  }

  @Test
  public void testToStringInvalid() {
    Assert.assertNotEquals(testSkier.toString(),
        "Skier Number:" + testSkier.getSkierNum() + "," + "Current Lift:" + testSkier2.getCurrentLift()
            + ", " + "Lazy?:" + testSkier.isLazy() + ", " + "Skill Level:" + testSkier.getSkillLevel() + ", "
            + "Lunch?:" + testSkier.isHasLunch() + ", " + "Lift Rides: " + testSkier.getLiftRides()
            .toString());
  }

  @Test
  public void testEqualsValid() {
    Assert.assertTrue(testSkier.equals(testSkier));
  }

  @Test
  public void testEqualsValid1() {
    Assert.assertFalse(testSkier.equals(testSkier2));
  }

  @Test
  public void testEqualsInvalid() {
    Assert.assertFalse(testSkier.equals(testSkier2));
  }

  @Test
  public void testHashCodeValid() {
    Assert.assertEquals(testSkier.hashCode(), 1);
  }

  @Test
  public void testHashCodeInvalid() {
    Assert.assertNotEquals(testSkier.hashCode(), 4);
  }
}