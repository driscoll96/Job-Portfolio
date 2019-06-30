package edu.neu.ccs.cs5500.SkiDataGenerator;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import org.junit.Before;
import org.junit.Test;

public class FileWriterUserInterfaceTest {

  private FileWriterUserInterface writerUserInterface;

  @Before
  public void setUp() throws Exception {
    writerUserInterface = new FileWriterUserInterface();
  }

  /**
   * Change file path input to a directory in your computer.
   */
  @Test
  public void getFileWriter() {
    String input = "C:\\Users\\aaeun\\Documents";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    writerUserInterface.getFileWriter();
    assertTrue(new File("C:\\Users\\aaeun\\Documents\\SyntheticData.csv").isFile());
  }
}