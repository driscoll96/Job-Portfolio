package edu.neu.ccs.cs5500.SkiDataGenerator;

/**
 * Validates the ski condition input for season of the year by checking if they are follow specific
 * formats.
 */
public class SeasonInputValidator implements IValidator {

  /**
   * Checks the season input.
   *
   * @param input - User input
   * @return - Instance of the "Season" class
   * @throws InvalidInputException - If input is not valid
   */
  public Season checkSeason(String input) throws InvalidInputException {
    if (input.toLowerCase().equals("fall")) {
      return Season.FALL;
    }
    if (input.toLowerCase().equals("winter")) {
      return Season.WINTER;
    }
    if (input.toLowerCase().equals("summer")) {
      return Season.SUMMER;
    }
    if (input.toLowerCase().equals("spring")) {
      return Season.SPRING;
    } else {
      throw new InvalidInputException("season");
    }
  }

}
