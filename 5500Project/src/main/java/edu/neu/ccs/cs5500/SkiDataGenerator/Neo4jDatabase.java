package edu.neu.ccs.cs5500.SkiDataGenerator;


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
  private static final String ADDRESS = "USING PERIODIC COMMIT LOAD CSV WITH HEADERS FROM"
      + " \"file:///import\\SyntheticData.csv\" AS line ";
  private static final String CLEAR_DB = "MATCH (n) DETACH DELETE (n) ";
  private final String CREATE_RIDES = "CREATE (r:LiftRide { skierNum: toInt(line.SkierNum), "
      + "time: toInt(line.Time), liftNum: toInt(line.LiftNum), day:toInt(line.Conditions)}) ";
  private static final String CREATE_LIFTS = "MERGE (l:Lift {id:toInt(trim(line.LiftNum))}) ";
  private static final String CREATE_RELATIONSHIPS = "MATCH(r:LiftRide), (l:Lift) "
      + "WHERE r.liftNum = l.id CREATE (r)-[:RODE]->(l) ";
  private static final String MOST_USED_LIFTS = "MATCH (a)-[:RODE]->(b) RETURN b, "
      + "COLLECT(a) as lifts ORDER BY SIZE(lifts) DESC LIMIT 1";
  private static final String LEAST_USED_LIFTS = "MATCH (a)-[:RODE]->(b) RETURN b,"
      + " COLLECT(a) as lifts ORDER BY SIZE(lifts) LIMIT 1";
  private static final String MOST_USED_BASE = "MATCH (a)-[:RODE]->(b) WHERE a.time = 0 RETURN b, "
      + "COLLECT(a) as lifts ORDER BY SIZE(lifts) DESC LIMIT 1";
  private static final String LEAST_USED_BASE = "MATCH (a)-[:RODE]->(b) WHERE a.time = 0 RETURN b, "
      + "COLLECT(a) as lifts ORDER BY SIZE(lifts) LIMIT 1";


  /**
   * A constructor for a neo4j database.
   */
  public Neo4jDatabase() throws InvalidInputException {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter an empty directory. Create a new folder if needed.");
    try {
      File targetFile = new File(scan.nextLine(), CHILD);
      GraphDatabaseService graphDb = new GraphDatabaseFactory()
          .newEmbeddedDatabase(targetFile);
      this.graphDb = graphDb;
    } catch (Exception e) {
      throw new InvalidInputException("neo4j-file");
    }
  }

  /**
   * Loads the CSV data into the DB.
   *
   */
  public void loadDataCSV() {

    try (Transaction trx = this.graphDb.beginTx()) {
      this.graphDb.execute(CLEAR_DB);
      trx.success();
    }

    //Needs to be outside TX to use periodic commit
    this.graphDb.execute(
        ADDRESS + CREATE_RIDES + CREATE_LIFTS);

    try (Transaction trx = this.graphDb.beginTx()) {
      this.graphDb.execute(CREATE_RELATIONSHIPS);
      trx.success();
    }
  }

  /**
   * Performs a query to compare the most used lifts according to the days at a SkiResort.
   *
   * @param usage String representing if the query is retrieving the most or least used lift.
   */
  public void queryCompare(String usage) {
    String query;
    if (usage.equalsIgnoreCase("compare most")) {
      query = MOST_USED_LIFTS;
    } else {
      query = LEAST_USED_LIFTS;
    }
    try (Transaction trx = this.graphDb.beginTx()) {
      Result result = this.graphDb.execute(query);
      printCypherQuery(result);
      trx.success();
    }
  }

  /**
   * Performs a query to compare the traffic flow of skiers after they get off of their base lift.
   *
   * @param usage String representing if the query is retrieving the most or least used lift after a
   * base.
   */
  public void queryTrafficFlow(String usage) {
    String query;
    if (usage.equalsIgnoreCase("base most")) {
      query = MOST_USED_BASE;
    } else {
      query = LEAST_USED_BASE;
    }
    try (Transaction trx = this.graphDb.beginTx()) {
      Result result = this.graphDb.execute(query);
      printCypherQuery(result);
      trx.success();
    }
  }

  /**
   * Prints the result of the query.
   *
   * @param res the Result of the query.
   */
  private void printCypherQuery(Result res) {
    System.out.println(res.resultAsString());
  }
}
