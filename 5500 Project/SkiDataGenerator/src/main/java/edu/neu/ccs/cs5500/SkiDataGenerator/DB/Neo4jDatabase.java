package edu.neu.ccs.cs5500.SkiDataGenerator.DB;


import java.io.File;
import java.util.Scanner;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;


/**
 * A neo4j database.
 */
public class Neo4jDatabase {

  private GraphDatabaseService graphDb;
  private static final String CHILD = "neo4j";
  private static final String ADDRESS = "USING PERIODIC COMMIT\n"
      + "  LOAD CSV WITH HEADERS FROM 'file:///D:Data/SyntheticDataD.csv' AS line ";
  private static final String CLEAR_DB = "MATCH (n) DETACH DELETE (n) ";
  private static final String CREATE_RELATIONSHIPS =
      "MERGE (s:Skier { skierNum: toInt(line.SkierNum)})"
          + "  MERGE (l:Lift {liftNum: toInt(line.LiftNum)})"
          + "  CREATE (s)-[r:RODE {time: toInt(line.Time)}]->(l)";
  private static final String MOST_USED_LIFTS = "MATCH (s)-[:RODE]->(l) RETURN l, COUNT(s) "
      + "as skiers ORDER BY skiers DESC LIMIT 5";
  private static final String LEAST_USED_LIFTS = "MATCH (s)-[:RODE]->(l) RETURN l, COUNT(s) "
      + "as skiers ORDER BY skiers LIMIT 5";
  private static final String MOST_USED_BASE = "MATCH (s)-[r:RODE]->(l) WHERE r.time = 30 RETURN l,"
      + "COUNT(s) as skiers ORDER BY skiers DESC LIMIT 5";
  private static final String LEAST_USED_BASE = "MATCH (s)-[r:RODE]->(l) WHERE r.time = 30 RETURN l,"
      + "COUNT(s) as skiers ORDER BY skiers LIMIT 5";


  /**
   * A constructor for a neo4j database.
   */
  public Neo4jDatabase() {
    boolean invalidFile = true;
    System.out.println("Please enter a DB directory. Create a new folder if needed.");
    while (invalidFile) {
      Scanner scan = new Scanner(System.in);
      try {
        File targetFile = new File(scan.nextLine(), CHILD);
        GraphDatabaseService graphDb = new GraphDatabaseFactory()
            .newEmbeddedDatabase(targetFile);
        this.graphDb = graphDb;
        invalidFile = false;
      } catch (Exception e) {
        invalidFile = true;
        System.out.println("Please enter a valid directory location \n"
            + "Windows Example:\n Z:\\\\results\\\\\nPOSIX Example:\n/home/userName/Documents");
      }
    }
  }

  /**
   * Loads the Readers data into the DB.
   */
  public void loadDataCSV() {

    try (Transaction trx = this.graphDb.beginTx()) {
      this.graphDb.execute(CLEAR_DB);
      trx.success();
    }

    //Needs to be outside TX to use periodic commit
    this.graphDb.execute(
        ADDRESS + CREATE_RELATIONSHIPS);
  }

  /**
   * Performs a query to compare the most used lifts or base lifts at a SkiResort.
   *
   * @param query string representation of what queries to perform.
   */
  public void queryCompare(String query) {

    if (query.equalsIgnoreCase("traffic")) {
      try (Transaction trx = this.graphDb.beginTx()) {
        Result most = this.graphDb.execute(MOST_USED_LIFTS);
        Result least = this.graphDb.execute(LEAST_USED_LIFTS);
        printCypherQuery(most, "+++++MOST USED LIFTS+++++");
        printCypherQuery(least, "+++++LEAST USED LIFTS++++");
        trx.success();
      }
    } else {
      try (Transaction trx = this.graphDb.beginTx()) {
        Result most = this.graphDb.execute(MOST_USED_BASE);
        Result least = this.graphDb.execute(LEAST_USED_BASE);
        printCypherQuery(most, "+++++MOST USED BASE+++++");
        printCypherQuery(least, "+++++LEAST USED BASE++++");
        trx.success();
      }
    }
  }

  /**
   * Prints the result of the query.
   *
   * @param res the Result of the query.
   */
  private void printCypherQuery(Result res, String modifier) {
    System.out.println(modifier);
    System.out.println(res.resultAsString());
  }
}
