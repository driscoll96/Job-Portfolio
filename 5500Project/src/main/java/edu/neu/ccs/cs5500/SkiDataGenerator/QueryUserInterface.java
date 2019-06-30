package edu.neu.ccs.cs5500.SkiDataGenerator;

import java.util.Scanner;

/**
 * Gathers user input which to be used as data queries.
 */
public class QueryUserInterface implements IUserInterface {

  /**
   * Gets the user input for the query they want data for.
   *
   * @return - The Cypher query
   */
  public String getQuery() {
    QueryCollector collector = new QueryCollector(new QueryValidator());
    System.out.println(UserInterfaceMessages.Query);
    String query = collector.getQuery(new Scanner(System.in));
    if (query.equalsIgnoreCase("compare traffic -most")) {
      return "compare most";
    } else if (query.equalsIgnoreCase("compare traffic -least")) {
      return "compare least";
    } else if (query.equalsIgnoreCase("after base -most")) {
      return "base most";
    } else {
      return "base least";
    }
  }
}
