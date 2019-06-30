package edu.neu.ccs.cs5500.SkiDataGenerator;

import java.util.Scanner;

public class QueryCollector extends AbsInputCollector {

  /**
   * A constructor for an Abstract Input Collector.
   *
   * @param validator the validator.
   */
  public QueryCollector(IValidator validator) {
    super(validator);
  }

  /**
   * Prompts and collects the user's database query input . The user is prompted until they enter a
   * valid input.
   *
   * @param scan - Scanner to get user input
   * @return - User's query input
   */
  public String getQuery(Scanner scan) {
    boolean correctInput = false;
    String query = null;
    while (!correctInput) {
      try {
        query = ((QueryValidator) (super.getValidator()))
            .checkQueryInput(scan.nextLine());
        correctInput = true;
      } catch (InvalidInputException e) {
        correctInput = false;
      }
    }
    return query;
  }
}
