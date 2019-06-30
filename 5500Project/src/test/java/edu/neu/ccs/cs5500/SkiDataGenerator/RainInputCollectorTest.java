package edu.neu.ccs.cs5500.SkiDataGenerator;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

public class RainInputCollectorTest {

  private RainInputCollector collector;

  @Before
  public void setUp() throws Exception {
    collector = new RainInputCollector(new RainInputValidator());
  }

  @Test
  public void getRain() {
    String rain = "NO";
    InputStream in = new ByteArrayInputStream(rain.getBytes());
    System.setIn(in);
    assertFalse(collector.getRain(new Scanner(System.in)));
  }
}