package edu.neu.ccs.cs5500.SkiDataGenerator.Validators;

import edu.neu.ccs.cs5500.SkiDataGenerator.Exceptions.InvalidInputException;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.IValidator;

public class QueryValidator implements IValidator {

  /**
   * Checks the query user input.
   *
   * @param input - User input for the query
   * @return - User query choice in the form of an incomplete Cypher query
   * @throws InvalidInputException - If file path is not valid
   */
  public String checkQueryInput(String input) throws InvalidInputException {

    if (input.equalsIgnoreCase("compare traffic") || input.equalsIgnoreCase("comparetraffic")
        || input.equalsIgnoreCase("traffic compare") || input.equalsIgnoreCase("trafficcompare")
        || input.equalsIgnoreCase("traffic-compare") || input.equalsIgnoreCase("compare-traffic")) {
      return "traffic";
    }
    if (input.equalsIgnoreCase("after base") || input.equalsIgnoreCase("afterbase")
        || input.equalsIgnoreCase("after-base")) {
      return "base";
    } else {
      throw new InvalidInputException("query-incorrect");
    }
  }

}
