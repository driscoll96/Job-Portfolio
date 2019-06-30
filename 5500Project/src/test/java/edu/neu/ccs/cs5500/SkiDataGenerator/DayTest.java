package edu.neu.ccs.cs5500.SkiDataGenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DayTest {

  private Day mon, tue, wed, sat, sun, fri, thu;

  @Before
  public void setUp() throws Exception {
    mon = Day.MONDAY;
    tue = Day.TUESDAY;
    wed = Day.WEDNESDAY;
    sat = Day.SATURDAY;
    sun = Day.SUNDAY;
    fri = Day.FRIDAY;
    thu = Day.THURSDAY;
  }

  @Test
  public void getSkiers() {
    assertEquals(mon.getSkiers(), 10000, 0.0);
    assertEquals(tue.getSkiers(), 8000, 0.0);
    assertEquals(wed.getSkiers(), 10000, 0.0);
    assertEquals(thu.getSkiers(), 12000, 0.0);
    assertEquals(fri.getSkiers(), 14000, 0.0);
    assertEquals(sat.getSkiers(), 40000, 0.0);
    assertEquals(sun.getSkiers(), 30000, 0.0);
  }
}