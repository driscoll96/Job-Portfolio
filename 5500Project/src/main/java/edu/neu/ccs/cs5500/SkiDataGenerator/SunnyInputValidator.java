package edu.neu.ccs.cs5500.SkiDataGenerator;

/**
 * Validates the input for sunny conditions by checking if they are follow specific formats.
 */
public class SunnyInputValidator implements IValidator {

  /**
   * Checks the sunny/cloudy input.
   *
   * @param input - User input
   * @return - Whether it is sunny or not
   * @throws InvalidInputException - If input is not valid
   */
  public boolean checkSunny(String input) throws InvalidInputException {
    if (input.toLowerCase().equals("yes") || input.toLowerCase().equals("y")) {
      return true;
    } else if (input.toLowerCase().equals("no") || input.toLowerCase().equals("n")) {
      return false;
    } else {
      throw new InvalidInputException("sunny-cloudy");
    }
  }
}
