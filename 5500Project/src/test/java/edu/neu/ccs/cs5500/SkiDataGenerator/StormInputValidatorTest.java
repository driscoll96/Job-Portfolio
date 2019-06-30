package edu.neu.ccs.cs5500.SkiDataGenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StormInputValidatorTest {

  private StormInputValidator validator;

  @Before
  public void setUp() throws Exception {
    validator = new StormInputValidator();
  }

  @Test
  public void checkStormTrue() throws InvalidInputException {
    assertTrue(validator.checkStorm("yes"));
    assertTrue(validator.checkStorm("Yes"));
    assertTrue(validator.checkStorm("YES"));
  }

  @Test
  public void checkStormFalse() throws InvalidInputException {
    assertFalse(validator.checkStorm("no"));
    assertFalse(validator.checkStorm("No"));
    assertFalse(validator.checkStorm("NO"));
  }

  @Test(expected = InvalidInputException.class)
  public void checkStormFail() throws InvalidInputException {
    validator.checkStorm("yeah");
  }
}