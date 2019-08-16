package edu.neu.ccs.cs5500.SkiDataGenerator.Validators;

import edu.neu.ccs.cs5500.SkiDataGenerator.Exceptions.InvalidInputException;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.IValidator;

/**
 * Validates the user input for rainy conditions by checking if they are follow specific formats.
 */
public class RainInputValidator implements IValidator {

  /**
   * Checks the rain input.
   *
   * @param input - User input
   * @return - Whether it is raining or not
   * @throws InvalidInputException - If input is not valid
   */
  public boolean checkRain(String input) throws InvalidInputException {
    if (input.toLowerCase().equals("yes") || input.toLowerCase().equals("y")) {
      return true;
    } else if (input.toLowerCase().equals("no") || input.toLowerCase().equals("n")) {
      return false;
    } else {
      throw new InvalidInputException("rain");
    }
  }

}
