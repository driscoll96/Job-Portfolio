package edu.neu.ccs.cs5500.SkiDataGenerator.Validators;

import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.Day;
import edu.neu.ccs.cs5500.SkiDataGenerator.Exceptions.InvalidInputException;

/**
 * Validates the ski condition input for day of the week by checking if they are follow specific
 * formats.
 */
public class DayInputValidator implements IValidator {

  /**
   * Checks the day input.
   *
   * @param input - User input
   * @return - Instance of the "Day" class.
   * @throws InvalidInputException - If input is not valid
   */
  public Day checkDay(String input) throws InvalidInputException {
    if (input.equalsIgnoreCase("monday") || input.equalsIgnoreCase("mon")) {
      return Day.MONDAY;
    }
    if (input.equalsIgnoreCase("tuesday") || input.equalsIgnoreCase("tue")) {
      return Day.TUESDAY;
    }
    if (input.equalsIgnoreCase("wednesday") || input.equalsIgnoreCase("wed")) {
      return Day.WEDNESDAY;
    }
    if (input.equalsIgnoreCase("thursday") || input.equalsIgnoreCase("thu")) {
      return Day.THURSDAY;
    }
    if (input.equalsIgnoreCase("friday") || input.equalsIgnoreCase("fri")) {
      return Day.FRIDAY;
    }
    if (input.equalsIgnoreCase("saturday") || input.equalsIgnoreCase("sat")) {
      return Day.SATURDAY;
    }
    if (input.equalsIgnoreCase("sunday") || input.equalsIgnoreCase("sun")) {
      return Day.SUNDAY;
    } else {
      throw new InvalidInputException("day");
    }
  }

}
