package edu.neu.ccs.cs5500.SkiDataGenerator;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5500.SkiDataGenerator.InvalidInputException;
import edu.neu.ccs.cs5500.SkiDataGenerator.MapFileAddressValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.SkiMapInputCollector;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Before;
import org.junit.Test;

public class SkiMapInputCollectorTest {

  private SkiMapInputCollector collector;

  @Before
  public void setUp() throws Exception {
    collector = new SkiMapInputCollector(new MapFileAddressValidator());
  }

  /**
   * Change file path input to a directory in your computer.
   */
  @Test
  public void checkFilePath() throws IOException {
    String input = "C:\\Users\\aaeun\\OneDrive\\Documents\\School Organization\\Summer 2019\\5500 Repo\\LiftConnections1.csv";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    BufferedReader map = collector.getReader(new Scanner(System.in));
    String line;
    boolean nonEmpty = false;
    Pattern p = Pattern.compile(".*[a-zA-Z]+.*", Pattern.CASE_INSENSITIVE);
    Matcher m;
    while ((line = map.readLine()) != null) {
      m = p.matcher(line);
      if (m.find()) {
        nonEmpty = true;
      }
    }
    assertTrue(nonEmpty);
    assertTrue(new File("C:\\Users\\aaeun\\OneDrive\\Documents\\School Organization\\Summer 2019\\5500 Repo\\LiftConnections1.csv").isFile());
  }
}