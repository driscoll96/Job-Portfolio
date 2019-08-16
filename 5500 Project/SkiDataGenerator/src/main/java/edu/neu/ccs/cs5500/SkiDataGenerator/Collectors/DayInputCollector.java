package edu.neu.ccs.cs5500.SkiDataGenerator.Collectors;

import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.DayInputValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.Day;
import edu.neu.ccs.cs5500.SkiDataGenerator.Exceptions.InvalidInputException;
import java.util.Scanner;

/**
 * Prompts and collects day of the week from users.
 */
public class DayInputCollector extends AbsInputCollector {

  /**
   * Fills field variable with given validator.
   *
   * @param validator - Season input validator
   */
  public DayInputCollector(DayInputValidator validator) {
    super(validator);
  }

  /**
   * Prompts and collects user input about the day of the week until they enter a valid input.
   *
   * @param scan - Scanner to get user input
   * @return - Day of the week
   */
  public Day getDay(Scanner scan) {
    Day day = null;
    boolean correctInput = false;
    while (!correctInput) {
      try {
        day = ((DayInputValidator) (super.getValidator())).checkDay(scan.nextLine());
        correctInput = true;
      } catch (InvalidInputException e) {
        correctInput = false;
      }
    }
    return day;
  }
}
