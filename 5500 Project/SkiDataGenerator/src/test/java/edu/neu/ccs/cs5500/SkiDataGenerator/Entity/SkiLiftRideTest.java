package edu.neu.ccs.cs5500.SkiDataGenerator.Entity;


import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.SkiLiftRide;
import edu.neu.ccs.cs5500.SkiDataGenerator.Exceptions.InvalidLiftRideTimeException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SkiLiftRideTest {

  public SkiLiftRide testLiftRide;
  public SkiLiftRide testLiftRide1;
  public SkiLiftRide testLiftRide2;

  @Before
  public void setUp() throws InvalidLiftRideTimeException {
    testLiftRide = new SkiLiftRide(1, 70);
  }

  @Test
  public void constructorValid() {
    try {
      testLiftRide1 = new SkiLiftRide(2, 0);
      Assert.assertEquals(testLiftRide1.getTime(), 0, 0);
    } catch (Exception e) {
      TestCase.fail();
    }
  }

  @Test
  public void constructorValid1() {
    try {
      testLiftRide2 = new SkiLiftRide(2, 360);
      Assert.assertEquals(testLiftRide2.getTime(), 360, 0);
    } catch (Exception e) {
      TestCase.fail();
    }
  }

  @Test
  public void constructorInvalid() {
    try {
      testLiftRide2 = new SkiLiftRide(2, 361);
      TestCase.fail();
    } catch (Exception e) {
    }
  }

  @Test
  public void getLiftNum() {
    Assert.assertEquals(testLiftRide.getLiftNum(), 1, 0);
  }

  @Test
  public void getTime() {
    Assert.assertEquals(testLiftRide.getTime(), 70, 0);
  }

  @Test
  public void testEqualsValid() {
    testLiftRide1 = new SkiLiftRide(1, 30);
    testLiftRide2 = new SkiLiftRide(1, 30);
    Assert.assertEquals(testLiftRide1, testLiftRide2);
  }

  @Test
  public void testEqualsInvalid() {
    testLiftRide1 = new SkiLiftRide(1, 30);
    testLiftRide2 = new SkiLiftRide(1, 31);
    Assert.assertNotEquals(testLiftRide1, testLiftRide2);
  }

  @Test
  public void testHashcodeValid() {
    testLiftRide1 = new SkiLiftRide(1, 30);
    testLiftRide2 = new SkiLiftRide(1, 30);
    Assert.assertEquals(testLiftRide1.hashCode(), testLiftRide2.hashCode());
  }

  @Test
  public void testHashcodeInvalid() {
    testLiftRide1 = new SkiLiftRide(1, 30);
    testLiftRide2 = new SkiLiftRide(0, 31);
    Assert.assertNotEquals(testLiftRide1.hashCode(), testLiftRide2.hashCode());
  }

  @Test
  public void testHashcodeInvalid1() {
    testLiftRide1 = new SkiLiftRide(6, 5);
    testLiftRide2 = new SkiLiftRide(1, 10);
    Assert.assertNotEquals(testLiftRide1.hashCode(), testLiftRide2.hashCode());
  }

  @Test
  public void testToStringValid() {
    testLiftRide1 = new SkiLiftRide(1, 30);
    Assert.assertEquals(testLiftRide1.toString(), "Lift Number:1, Time:30");
  }

  @Test
  public void testToStringInvalid() {
    testLiftRide1 = new SkiLiftRide(1, 30);
    Assert.assertNotEquals(testLiftRide1.toString(), "Lift Number:0, Time:30");
  }
}