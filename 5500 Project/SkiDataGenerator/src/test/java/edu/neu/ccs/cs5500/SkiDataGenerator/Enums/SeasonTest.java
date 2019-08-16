package edu.neu.ccs.cs5500.SkiDataGenerator.Enums;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.Season;
import org.junit.Before;
import org.junit.Test;

public class SeasonTest {

  private Season spring, winter, fall, summer;

  @Before
  public void setUp() throws Exception {
    spring = Season.SPRING;
    summer = Season.SUMMER;
    fall = Season.FALL;
    winter = Season.WINTER;
  }

  @Test
  public void getPercentChange() {
    assertEquals(spring.getPercentChange(), 0.1, 0.0);
    assertEquals(summer.getPercentChange(), -0.2, 0.0);
    assertEquals(fall.getPercentChange(), -0.2, 0.0);
    assertEquals(winter.getPercentChange(), 0.1, 0.0);
  }
}