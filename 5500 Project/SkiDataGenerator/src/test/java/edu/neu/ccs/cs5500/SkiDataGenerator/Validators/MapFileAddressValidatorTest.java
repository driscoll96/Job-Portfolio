package edu.neu.ccs.cs5500.SkiDataGenerator.Validators;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5500.SkiDataGenerator.Exceptions.InvalidInputException;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.MapFileAddressValidator;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Before;
import org.junit.Test;

public class MapFileAddressValidatorTest {

  private MapFileAddressValidator validator;

  @Before
  public void setUp() throws Exception {
    validator = new MapFileAddressValidator();
  }

  /**
   * Change file path input to a non-empty csv file in your computer.
   */
  @Test
  public void checkFilePath() throws InvalidInputException, IOException {
    BufferedReader map = validator.checkMapFilePath("C:\\Users\\User\\OneDrive\\CoolCreativeAardvarks-master\\LiftConnections.csv");
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
    assertTrue(new File("C:\\Users\\User\\OneDrive\\CoolCreativeAardvarks-master\\LiftConnections.csv").isFile());
  }

  @Test(expected = InvalidInputException.class)
  public void InvalidAddress() throws InvalidInputException {
    validator.checkMapFilePath("yeah");
  }

  /**
   * Change file path input to an empty csv file in your computer.
   */
  @Test(expected = InvalidInputException.class)
  public void EmptyFile() throws InvalidInputException, IOException {
    validator.checkMapFilePath("C:\\Users\\User\\Documents\\Zoom\\Map1.csv");
  }
}