package edu.neu.ccs.cs5500.SkiDataGenerator;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

public class SunnyInputCollectorTest {

  private SunnyInputCollector collector;

  @Before
  public void setUp() throws Exception {
    collector = new SunnyInputCollector(new SunnyInputValidator());
  }

  @Test
  public void getSunny() {
    String sunny = "n";
    InputStream in = new ByteArrayInputStream(sunny.getBytes());
    System.setIn(in);
    assertFalse(collector.getSunny(new Scanner(System.in)));
  }
}