package edu.neu.ccs.cs5500.SkiDataGenerator.Validators;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5500.SkiDataGenerator.Exceptions.InvalidInputException;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.RainInputValidator;
import org.junit.Before;
import org.junit.Test;

public class RainInputValidatorTest {

  private RainInputValidator validator;

  @Before
  public void setUp() throws Exception {
    validator = new RainInputValidator();
  }

  @Test
  public void checkRainTrue() throws InvalidInputException {
    assertTrue(validator.checkRain("yes"));
    assertTrue(validator.checkRain("Yes"));
    assertTrue(validator.checkRain("YES"));
  }

  @Test
  public void checkRainFalse() throws InvalidInputException {
    assertFalse(validator.checkRain("no"));
    assertFalse(validator.checkRain("No"));
    assertFalse(validator.checkRain("NO"));
  }

  @Test(expected = InvalidInputException.class)
  public void checkRainFail() throws InvalidInputException {
    validator.checkRain("yeah");
  }
}