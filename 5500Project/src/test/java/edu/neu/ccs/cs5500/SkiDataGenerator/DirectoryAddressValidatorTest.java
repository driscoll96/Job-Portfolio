package edu.neu.ccs.cs5500.SkiDataGenerator;

import static org.junit.Assert.*;

import java.io.File;
import org.junit.Before;
import org.junit.Test;

public class DirectoryAddressValidatorTest {

  DirectoryAddressValidator validator;

  @Before
  public void setUp() throws Exception {
    validator = new DirectoryAddressValidator();
  }

  /**
   * Change file path input to a directory in your computer.
   */
  @Test
  public void checkFilePath() throws InvalidInputException {
    assertFalse(new File("C:\\Users\\aaeun\\OneDrive\\Documents\\Test").isFile());
    validator.checkDirectoryAddress("C:\\Users\\aaeun\\OneDrive\\Documents\\Test");
    assertTrue(new File("C:\\Users\\aaeun\\OneDrive\\Documents\\Test\\SyntheticData.csv").isFile());
  }

  @Test(expected = InvalidInputException.class)
  public void checkFilePathFail() throws InvalidInputException {
    validator.checkDirectoryAddress("yeah");
  }

  // This checks to make sure that it throws an exception if a "SyntheticData.csv" file already
  // already exists in the directory
  @Test(expected = InvalidInputException.class)
  public void checkFilePathFail1() throws InvalidInputException {
    validator.checkDirectoryAddress("C:\\Users\\User\\Documents\\Zoom");
  }
}