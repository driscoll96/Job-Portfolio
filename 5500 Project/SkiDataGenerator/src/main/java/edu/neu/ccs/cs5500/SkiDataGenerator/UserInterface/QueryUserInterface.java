package edu.neu.ccs.cs5500.SkiDataGenerator.UserInterface;

import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.UserInterfaceMessages;
import edu.neu.ccs.cs5500.SkiDataGenerator.Collectors.QueryCollector;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.QueryValidator;
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
    System.out.println(UserInterfaceMessages.QUERY.getValue());
    return(collector.getQuery(new Scanner(System.in)));
  }
}
