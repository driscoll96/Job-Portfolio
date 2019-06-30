package edu.neu.ccs.cs5500.SkiDataGenerator;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

public class DayInputCollectorTest {

  private DayInputCollector collector;

  @Before
  public void setUp() throws Exception {
    collector = new DayInputCollector(new DayInputValidator());
  }

  @Test
  public void getDay() {
    String input = "Friday";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    assertEquals(Day.FRIDAY, collector.getDay(new Scanner(System.in)));
  }
}