package edu.neu.ccs.cs5500.SkiDataGenerator.Exceptions;

public class InvalidCommandLineArgument extends Exception {

  /**
   * Exception if wrong cmd args are input.
   */
  public InvalidCommandLineArgument() {
    System.out
        .println("Please enter a valid command line argument:\n\""
            + "Day\": Produces a day's worth of skier's lift data\n\""
            + "query\": Allows queries requested by user\n"
            + "\"query -admin\": Fills database with data");
  }
}
