package edu.neu.ccs.cs5500.SkiDataGenerator.Collectors;

import edu.neu.ccs.cs5500.SkiDataGenerator.Exceptions.InvalidInputException;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.IValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.SunnyInputValidator;
import java.util.Scanner;

/**
 * Prompts and collects sunny condition input from the user.
 */
public class SunnyInputCollector extends AbsInputCollector {

  /**
   * Fills field variable with given validator.
   *
   * @param validator - Season input validator
   */
  public SunnyInputCollector(IValidator validator) {
    super(validator);
  }

  /**
   * Prompts and collects user input about if it's sunny until they enter a valid input.
   *
   * @param scan - Scanner to get user input
   * @return - True if it is sunny
   */
  public boolean getSunny(Scanner scan) {
    boolean sunny = false;
    boolean correctInput = false;
    while (!correctInput) {
      try {
        sunny = ((SunnyInputValidator) (super.getValidator())).checkSunny(scan.nextLine());
        correctInput = true;
      } catch (InvalidInputException e) {
        correctInput = false;
      }
    }
    return sunny;
  }
}
