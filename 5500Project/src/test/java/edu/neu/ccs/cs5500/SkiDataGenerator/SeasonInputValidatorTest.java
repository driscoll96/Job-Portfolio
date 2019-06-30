package edu.neu.ccs.cs5500.SkiDataGenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SeasonInputValidatorTest {

  private SeasonInputValidator validator;

  @Before
  public void setUp() throws Exception {
    validator = new SeasonInputValidator();
  }

  @Test
  public void checkSeasonSpring() throws InvalidInputException {
    assertEquals(validator.checkSeason("Spring"), Season.SPRING);
    assertEquals(validator.checkSeason("spring"), Season.SPRING);
    assertEquals(validator.checkSeason("SPRING"), Season.SPRING);
  }

  @Test(expected = InvalidInputException.class)
  public void checkSpringFail() throws InvalidInputException {
    validator.checkSeason("Sprinng");
  }

  @Test
  public void checkSeasonSummer() throws InvalidInputException {
    assertEquals(validator.checkSeason("Summer"), Season.SUMMER);
    assertEquals(validator.checkSeason("summer"), Season.SUMMER);
    assertEquals(validator.checkSeason("SUMMER"), Season.SUMMER);
  }

  @Test(expected = InvalidInputException.class)
  public void checkSummerFail() throws InvalidInputException {
    validator.checkSeason("summMER");
  }

  @Test
  public void checkSeasonFall() throws InvalidInputException {
    assertEquals(validator.checkSeason("Fall"), Season.FALL);
    assertEquals(validator.checkSeason("fall"), Season.FALL);
    assertEquals(validator.checkSeason("FALL"), Season.FALL);
  }

  @Test(expected = InvalidInputException.class)
  public void checkFallFail() throws InvalidInputException {
    validator.checkSeason("falll");
  }

  @Test
  public void checkSeasonWinter() throws InvalidInputException {
    assertEquals(validator.checkSeason("Winter"), Season.WINTER);
    assertEquals(validator.checkSeason("winter"), Season.WINTER);
    assertEquals(validator.checkSeason("WINTER"), Season.WINTER);
  }

  @Test(expected = InvalidInputException.class)
  public void checkWinterFail() throws InvalidInputException {
    validator.checkSeason("winner");
  }
}