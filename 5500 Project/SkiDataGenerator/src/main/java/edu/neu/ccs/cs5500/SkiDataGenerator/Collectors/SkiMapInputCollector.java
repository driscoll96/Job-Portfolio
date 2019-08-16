package edu.neu.ccs.cs5500.SkiDataGenerator.Collectors;

import edu.neu.ccs.cs5500.SkiDataGenerator.Exceptions.InvalidInputException;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.IValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.MapFileAddressValidator;
import java.io.BufferedReader;
import java.util.Scanner;

/**
 * Prompts and collects ski map input from the user.
 */
public class SkiMapInputCollector extends AbsInputCollector {

  /**
   * Fills field variable with given validator.
   *
   * @param validator - Season input validator
   */
  public SkiMapInputCollector(IValidator validator) {
    super(validator);
  }

  /**
   * Prompts and collects user input about the day of the week until they enter a valid input.
   *
   * @param scan - Scanner to get user input
   * @return - Day of the week
   */
  public BufferedReader getReader(Scanner scan) {
    BufferedReader reader = null;
    boolean correctInput = false;
    while (!correctInput) {
      try {
        reader = ((MapFileAddressValidator) (super.getValidator()))
            .checkMapFilePath(scan.nextLine());
        correctInput = true;
      } catch (InvalidInputException e) {
        correctInput = false;
      }
    }
    return reader;
  }

}
