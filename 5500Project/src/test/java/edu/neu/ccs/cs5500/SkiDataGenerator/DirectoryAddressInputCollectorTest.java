package edu.neu.ccs.cs5500.SkiDataGenerator;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

public class DirectoryAddressInputCollectorTest {

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