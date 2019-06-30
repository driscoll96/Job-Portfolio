package edu.neu.ccs.cs5500.SkiDataGenerator;

/**
 * Exception thrown when user ski condition input is not valid.
 */
public class InvalidInputException extends Exception {

  /**
   * Constructor which takes a string as a way to print the appropriate help message to the user.
   *
   * @param exceptType - String telling what kind of invalid input was given
   */
  public InvalidInputException(String exceptType) {
    if (exceptType.equals("day")) {
      System.out
          .println("Please enter a day in the week by full word or three letter abbreviation\n");
    }
    if (exceptType.equals("season")) {
      System.out.println("Please enter a season (Fall, Winter, Spring, Summer)\n");
    }
    if (exceptType.equals("snow")) {
      System.out.println("Please indicate whether it snowed the day before with yes or no\n");
    }
    if (exceptType.equals("sunny-cloudy")) {
      System.out.println("Please indicate whether it is sunny with yes or no\n");
    }
    if (exceptType.equals("rain")) {
      System.out.println("Please indicate whether it is raining with yes or no\n");
    }
    if (exceptType.equals("storm")) {
      System.out.println("Please indicate whether there is a blizzard/storm with yes or no\n");
    }
    if (exceptType.equals("file")) {
      System.out.println(
          "Please enter a valid directory location that does not already contain a csv file "
              + "named: SyntheticData.csv.\nWindows Example:\n"
              + "Z:\\\\results\\\\\nPOSIX Example:\n/home/userName/Documents");
    }
    if (exceptType.equals("map-not-file")) {
      System.out.println("Please enter a valid file address.\nWindows Example:\n"
          + "Z:\\\\results\\\\map.csv\nPOSIX Example:\n/home/userName/Documents/map.csv");
    }
    if (exceptType.equals("map-empty")) {
      System.out.println("Please enter a valid, non-empty ski resort map data file.");
    }
    if (exceptType.equals("query-incorrect")) {
      System.out
          .println("Please enter a correct query:\n\n"
              + "\"View Traffic\": Produces one day worth of data\n\n"
              + "Compare Traffic: Produces at two days worth of data\n\n "
              + "After Base: Produces data showing where lift rides go after"
              + " a certain base lift\n");
    }
  }
}
