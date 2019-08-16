package edu.neu.ccs.cs5500.SkiDataGenerator.Validators;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.Day;
import edu.neu.ccs.cs5500.SkiDataGenerator.Exceptions.InvalidInputException;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.DayInputValidator;
import org.junit.Before;
import org.junit.Test;

public class DayInputValidatorTest {

  private DayInputValidator validator;

  @Before
  public void setUp() throws Exception {
    validator = new DayInputValidator();
  }

  @Test
  public void checkThursday() throws InvalidInputException {
    assertEquals(validator.checkDay("thursday"), Day.THURSDAY);
    assertEquals(validator.checkDay("Thursday"), Day.THURSDAY);
    assertEquals(validator.checkDay("THURSDAY"), Day.THURSDAY);
    assertEquals(validator.checkDay("thu"), Day.THURSDAY);
  }

  @Test(expected = InvalidInputException.class)
  public void checkThursdayFail() throws InvalidInputException {
    validator.checkDay("thrusday");
  }

  @Test
  public void checkMonday() throws InvalidInputException {
    assertEquals(validator.checkDay("monday"), Day.MONDAY);
    assertEquals(validator.checkDay("Monday"), Day.MONDAY);
    assertEquals(validator.checkDay("MONDAY"), Day.MONDAY);
    assertEquals(validator.checkDay("mon"), Day.MONDAY);
  }

  @Test(expected = InvalidInputException.class)
  public void checkMondayFail() throws InvalidInputException {
    validator.checkDay("mondays");
  }

  @Test
  public void checkTuesday() throws InvalidInputException {
    assertEquals(validator.checkDay("tuesday"), Day.TUESDAY);
    assertEquals(validator.checkDay("Tuesday"), Day.TUESDAY);
    assertEquals(validator.checkDay("TUESDAY"), Day.TUESDAY);
    assertEquals(validator.checkDay("tue"), Day.TUESDAY);
  }

  @Test(expected = InvalidInputException.class)
  public void checkTuesdayFail() throws InvalidInputException {
    validator.checkDay("tuesdayy");
  }

  @Test
  public void checkWednesday() throws InvalidInputException {
    assertEquals(validator.checkDay("wednesday"), Day.WEDNESDAY);
    assertEquals(validator.checkDay("Wednesday"), Day.WEDNESDAY);
    assertEquals(validator.checkDay("WEDNESDAY"), Day.WEDNESDAY);
    assertEquals(validator.checkDay("wed"), Day.WEDNESDAY);
  }

  @Test(expected = InvalidInputException.class)
  public void checkWednesdayFail() throws InvalidInputException {
    validator.checkDay("w");
  }

  @Test
  public void checkFriday() throws InvalidInputException {
    assertEquals(validator.checkDay("friday"), Day.FRIDAY);
    assertEquals(validator.checkDay("Friday"), Day.FRIDAY);
    assertEquals(validator.checkDay("FRIDAY"), Day.FRIDAY);
    assertEquals(validator.checkDay("fri"), Day.FRIDAY);
  }

  @Test(expected = InvalidInputException.class)
  public void checkFridayFail() throws InvalidInputException {
    validator.checkDay("Freday");
  }

  @Test
  public void checkSaturday() throws InvalidInputException {
    assertEquals(validator.checkDay("saturday"), Day.SATURDAY);
    assertEquals(validator.checkDay("SATURDAY"), Day.SATURDAY);
    assertEquals(validator.checkDay("Saturday"), Day.SATURDAY);
    assertEquals(validator.checkDay("sat"), Day.SATURDAY);
  }

  @Test(expected = InvalidInputException.class)
  public void checkSaturdayFail() throws InvalidInputException {
    validator.checkDay("Satur day");
  }

  @Test
  public void checkSunday() throws InvalidInputException {
    assertEquals(validator.checkDay("sunday"), Day.SUNDAY);
    assertEquals(validator.checkDay("Sunday"), Day.SUNDAY);
    assertEquals(validator.checkDay("SUNDAY"), Day.SUNDAY);
    assertEquals(validator.checkDay("sun"), Day.SUNDAY);
  }

  @Test(expected = InvalidInputException.class)
  public void checkSundayFail() throws InvalidInputException {
    validator.checkDay("sunnyday");
  }
}