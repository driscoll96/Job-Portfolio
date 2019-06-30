package edu.neu.ccs.cs5500.SkiDataGenerator;


import java.util.ArrayList;
import java.util.List;


public class Main {


  /**
   * The main driver function that takes in user data and outputs skier data to a CSV format.
   *
   * @param args user arguments.
   * @throws InvalidCommandLineArgument if the files entered are not valid.
   */


  public static void main(String[] args) throws InvalidCommandLineArgument, InvalidInputException {
    if (args.length != 1) {
      throw new InvalidCommandLineArgument();
    }
    WriteCsv writeCsv = new WriteCsv();
    UpdatedBufferedWriter outputWriter;

    if (args[0].equals("day")) {
      //Interface with user, get conditions and create SkiResort.
      SkiConditionsUserInterface conditionsUserInterface = new SkiConditionsUserInterface();
      SkiResort skiResort = conditionsUserInterface.getSkiConditions();

      // Implementation to generate a day of skier data is in this new class
      List<Skier> skiers = new SingleDayDataGenerator().generateSingleDay(skiResort);

      // Output skier data.
      outputWriter = new FileWriterUserInterface().getFileWriter();
      writeCsv.writeToFile(outputWriter, skiers);

    } else if (args[0].equals("query")) {
      outputWriter = new FileWriterUserInterface().getFileWriter();
      Neo4jDataGenerator dataGen = new Neo4jDataGenerator();
      ArrayList<ArrayList<Skier>> skiersForDatabase = dataGen.generateAllData();
      for (ArrayList<Skier> skiers : skiersForDatabase) {
        writeCsv.writeToFile(outputWriter, skiers);
      }
      writeCsv.cleanUp(outputWriter);

      // File path of the data to put in neo4j
      Neo4jDatabase dataBase = new Neo4jDatabase();
      dataBase.loadDataCSV();
      QueryUserInterface queryUserInterface = new QueryUserInterface();
      String query = queryUserInterface.getQuery();
      if (query.equalsIgnoreCase("compare most") || query.equalsIgnoreCase("compare least")) {
        dataBase.queryCompare(query);
      } else {
        dataBase.queryTrafficFlow(query);
      }

    } else {
      throw new InvalidCommandLineArgument();
    }
  }
}
