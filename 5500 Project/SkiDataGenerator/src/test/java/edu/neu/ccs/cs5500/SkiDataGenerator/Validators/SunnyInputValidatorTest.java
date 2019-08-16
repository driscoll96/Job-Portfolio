package edu.neu.ccs.cs5500.SkiDataGenerator.Validators;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5500.SkiDataGenerator.Exceptions.InvalidInputException;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.SunnyInputValidator;
import org.junit.Before;
import org.junit.Test;

public class SunnyInputValidatorTest {

  private SunnyInputValidator validator;

  @Before
  public void setUp() throws Exception {
    validator = new SunnyInputValidator();
  }

  @Test
  public void checkSunnyTrue() throws InvalidInputException {
    assertTrue(validator.checkSunny("yes"));
    assertTrue(validator.checkSunny("Yes"));
    assertTrue(validator.checkSunny("YES"));
  }

  @Test
  public void checkSunnyFalse() throws InvalidInputException {
    assertFalse(validator.checkSunny("no"));
    assertFalse(validator.checkSunny("No"));
    assertFalse(validator.checkSunny("NO"));
  }

  @Test(expected = InvalidInputException.class)
  public void checkSunnyFail() throws InvalidInputException {
    validator.checkSunny("yeah");
  }
}