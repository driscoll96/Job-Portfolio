package edu.neu.ccs.cs5500.SkiDataGenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SnowInputValidatorTest {

  private SnowInputValidator validator;

  @Before
  public void setUp() throws Exception {
    validator = new SnowInputValidator();
  }

  @Test
  public void checkSnowTrue() throws InvalidInputException {
    assertTrue(validator.checkSnow("yes"));
    assertTrue(validator.checkSnow("Yes"));
    assertTrue(validator.checkSnow("YES"));
  }

  @Test
  public void checkSnowFalse() throws InvalidInputException {
    assertFalse(validator.checkSnow("no"));
    assertFalse(validator.checkSnow("No"));
    assertFalse(validator.checkSnow("NO"));
  }

  @Test(expected = InvalidInputException.class)
  public void checkSnowFail() throws InvalidInputException {
    validator.checkSnow("yeah");
  }
}