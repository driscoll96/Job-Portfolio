package edu.neu.ccs.cs5500.SkiDataGenerator;

import java.util.Scanner;

/**
 * Prompts and collects rainy conditions from users.
 */
public class RainInputCollector extends AbsInputCollector {

  /**
   * Fills field variable with given validator.
   *
   * @param validator - Season input validator
   */
  public RainInputCollector(IValidator validator) {
    super(validator);
  }

  /**
   * Prompts and collects user input about if it's raining until they enter a valid input.
   *
   * @param scan - Scanner to get user input
   * @return - True if it is raining
   */
  public boolean getRain(Scanner scan) {
    boolean rain = false;
    boolean correctInput = false;
    while (!correctInput) {
      try {
        rain = ((RainInputValidator) (super.getValidator())).checkRain(scan.nextLine());
        correctInput = true;
      } catch (InvalidInputException e) {
        correctInput = false;
      }
    }
    return rain;
  }
}
