package edu.neu.ccs.cs5500.SkiDataGenerator.UserInterface;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5500.SkiDataGenerator.UserInterface.FileReaderUserInterface;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Before;
import org.junit.Test;

public class FileReaderUserInterfaceTest {

  private FileReaderUserInterface readerUserInterface;

  @Before
  public void setUp() throws Exception {
    readerUserInterface = new FileReaderUserInterface();
  }

  /**
   * Change file path input to a ski map csv file in your computer.
   */
  @Test
  public void getFileReader() throws IOException {
    String input = "C:\\Users\\User\\OneDrive\\CoolCreativeAardvarks-master\\LiftConnections.csv";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    BufferedReader reader = readerUserInterface.getFileReader();
    assertTrue(new File("C:\\Users\\User\\OneDrive\\CoolCreativeAardvarks-master\\LiftConnections.csv").isFile());
    assertTrue(reader.readLine() != null);
  }
}