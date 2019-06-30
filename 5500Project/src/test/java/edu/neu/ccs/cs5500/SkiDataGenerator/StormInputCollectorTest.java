package edu.neu.ccs.cs5500.SkiDataGenerator;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

public class StormInputCollectorTest {

  private StormInputCollector collector;

  @Before
  public void setUp() throws Exception {
    collector = new StormInputCollector(new StormInputValidator());
  }

  @Test
  public void getStorm() {
    String storm = "YeS";
    InputStream in = new ByteArrayInputStream(storm.getBytes());
    System.setIn(in);
    assertTrue(collector.getStorm(new Scanner(System.in)));
  }
}