package edu.neu.ccs.cs5500.SkiDataGenerator;

public class QueryValidator implements IValidator {

  /**
   * Checks the query user input.
   *
   * @param input - User input for the query
   * @return - User query choice in the form of an incomplete Cypher query
   * @throws InvalidInputException - If file path is not valid
   */

  // See if we should have more queries or just have these
  public String checkQueryInput(String input) throws InvalidInputException {
    if (input.equalsIgnoreCase("view traffic") || input.equalsIgnoreCase("viewtraffic")
        || input.equalsIgnoreCase("traffic view") || input.equalsIgnoreCase("trafficview")
        || input.equalsIgnoreCase("traffic-view") || input.equalsIgnoreCase("view-traffic")) {
      String viewTrafficCypherQuery = "insert here";
      return viewTrafficCypherQuery;
    }
    if (input.equalsIgnoreCase("compare traffic") || input.equalsIgnoreCase("comparetraffic")
        || input.equalsIgnoreCase("traffic compare") || input.equalsIgnoreCase("trafficcompare")
        || input.equalsIgnoreCase("traffic-compare") || input.equalsIgnoreCase("compare-traffic")) {
      String compareTrafficCypherQuery = "insert here";
      return compareTrafficCypherQuery;
    }
    if (input.equalsIgnoreCase("after base") || input.equalsIgnoreCase("afterbase")
        || input.equalsIgnoreCase("after-base")) {
      String afterBaseCypherQuery = "insert here";
      return afterBaseCypherQuery;
    } else {
      throw new InvalidInputException("query-incorrect");
    }
  }

}
