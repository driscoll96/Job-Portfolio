package edu.neu.ccs.cs5500.SkiDataGenerator.Validators;

import edu.neu.ccs.cs5500.SkiDataGenerator.Exceptions.InvalidInputException;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.IValidator;

/**
 * Validates the user input for snowy conditions by checking if they are follow specific formats.
 */
public class SnowInputValidator implements IValidator {

  /**
   * Checks the snow input.
   *
   * @param input - User input
   * @return - Whether it snowed the day before
   * @throws InvalidInputException - If input is not valid
   */
  public boolean checkSnow(String input) throws InvalidInputException {
    if (input.toLowerCase().equals("yes") || input.toLowerCase().equals("y")) {
      return true;
    } else if (input.toLowerCase().equals("no") || input.toLowerCase().equals("n")) {
      return false;
    } else {
      throw new InvalidInputException("snow");
    }
  }

}