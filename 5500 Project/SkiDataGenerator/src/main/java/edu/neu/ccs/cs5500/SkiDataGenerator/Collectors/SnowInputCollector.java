package edu.neu.ccs.cs5500.SkiDataGenerator.Collectors;

import edu.neu.ccs.cs5500.SkiDataGenerator.Exceptions.InvalidInputException;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.IValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.SnowInputValidator;
import java.util.Scanner;

/**
 * Prompts and collects snowy conditions input from users.
 */
public class SnowInputCollector extends AbsInputCollector {

  /**
   * Fills field variable with given validator.
   *
   * @param validator - Season input validator
   */
  public SnowInputCollector(IValidator validator) {
    super(validator);
  }

  /**
   * Prompts and collects user input about if it snow the night before until they enter a valid
   * input.
   *
   * @param scan - Scanner to get user input
   * @return - True if it did snow
   */
  public boolean getSnow(Scanner scan) {
    boolean snow = false;
    boolean correctInput = false;
    while (!correctInput) {
      try {
        snow = ((SnowInputValidator) (super.getValidator())).checkSnow(scan.nextLine());
        correctInput = true;
      } catch (InvalidInputException e) {
        correctInput = false;
      }
    }
    return snow;
  }

}
