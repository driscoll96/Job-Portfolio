package edu.neu.ccs.cs5500.SkiDataGenerator;

import java.util.Scanner;

/**
 * Prompts and collects season of the year from users.
 */
public class SeasonInputCollector extends AbsInputCollector {

  /**
   * Fills field variable with given validator.
   *
   * @param validator - Season input validator
   */
  public SeasonInputCollector(IValidator validator) {
    super(validator);
  }

  /**
   * Prompts and collects user input about the season of the year until they enter a valid input.
   *
   * @param scan - Scanner to get user input
   * @return - Season of the year
   */
  public Season getSeason(Scanner scan) {
    Season season = null;
    boolean correctInput = false;
    while (!correctInput) {
      try {
        season = ((SeasonInputValidator) (super.getValidator())).checkSeason(scan.nextLine());
        correctInput = true;
      } catch (InvalidInputException e) {
        correctInput = false;
      }
    }
    return season;
  }

}
