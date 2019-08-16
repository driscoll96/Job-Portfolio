package edu.neu.ccs.cs5500.SkiDataGenerator.Collectors;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.Day;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.DayInputValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.DirectoryAddressValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.RainInputValidator;
import java.io.ByteArrayInputStream;
import java.io.File;
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

  public static class DirectoryAddressInputCollectorTest {

    private DirectoryAddressInputCollector collector;

    @Before
    public void setUp() throws Exception {
      collector = new DirectoryAddressInputCollector(new DirectoryAddressValidator());
    }

    /**
     * Change file path input to a directory in your computer.
     */
    @Test
    public void getFilePath() {
      String input = "C:\\Users\\aaeun\\OneDrive\\Documents";
      InputStream in = new ByteArrayInputStream(input.getBytes());
      System.setIn(in);
      collector.getFilePath(new Scanner(System.in));
      assertTrue(new File("C:\\Users\\aaeun\\OneDrive\\Documents\\SyntheticData.csv").isFile());
    }
  }

  public static class RainInputCollectorTest {

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
}