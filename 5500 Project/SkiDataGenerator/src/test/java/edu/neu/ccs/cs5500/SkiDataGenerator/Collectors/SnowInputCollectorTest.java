package edu.neu.ccs.cs5500.SkiDataGenerator.Collectors;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5500.SkiDataGenerator.Collectors.SnowInputCollector;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.SnowInputValidator;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

public class SnowInputCollectorTest {

  private SnowInputCollector collector;

  @Before
  public void setUp() throws Exception {
    collector = new SnowInputCollector(new SnowInputValidator());
  }

  @Test
  public void getSnow() {
    String snow = "yes";
    InputStream in = new ByteArrayInputStream(snow.getBytes());
    System.setIn(in);
    assertTrue(collector.getSnow(new Scanner(System.in)));
  }
}