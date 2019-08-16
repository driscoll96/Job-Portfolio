package edu.neu.ccs.cs5500.SkiDataGenerator.Collectors;

import edu.neu.ccs.cs5500.SkiDataGenerator.Exceptions.InvalidInputException;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.IValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.StormInputValidator;
import java.util.Scanner;

/**
 * Prompts and collects stormy conditions from users.
 */
public class StormInputCollector extends AbsInputCollector {

  /**
   * Fills field variable with given validator.
   *
   * @param validator - Season input validator
   */
  public StormInputCollector(IValidator validator) {
    super(validator);
  }

  /**
   * Prompts and collects user input about if there's a storm/blizzard until they enter a valid
   * input.
   *
   * @param scan - Scanner to get user input
   * @return - True if there is a storm/blizzard
   */
  public boolean getStorm(Scanner scan) {
    boolean storm = false;
    boolean correctInput = false;
    while (!correctInput) {
      try {
        storm = ((StormInputValidator) (super.getValidator())).checkStorm(scan.nextLine());
        correctInput = true;
      } catch (InvalidInputException e) {
        correctInput = false;
      }
    }
    return storm;
  }
}
