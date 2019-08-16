package edu.neu.ccs.cs5500.SkiDataGenerator;


import edu.neu.ccs.cs5500.SkiDataGenerator.DB.Neo4jDataGenerator;
import edu.neu.ccs.cs5500.SkiDataGenerator.DB.Neo4jDatabase;
import edu.neu.ccs.cs5500.SkiDataGenerator.Writers.UpdatedBufferedWriter;
import edu.neu.ccs.cs5500.SkiDataGenerator.Writers.WriteCsv;
import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.SkiResort;
import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.Skier;
import edu.neu.ccs.cs5500.SkiDataGenerator.Exceptions.InvalidCommandLineArgument;
import edu.neu.ccs.cs5500.SkiDataGenerator.Exceptions.InvalidInputException;
import edu.neu.ccs.cs5500.SkiDataGenerator.UserInterface.FileWriterUserInterface;
import edu.neu.ccs.cs5500.SkiDataGenerator.UserInterface.QueryUserInterface;
import edu.neu.ccs.cs5500.SkiDataGenerator.UserInterface.SkiConditionsUserInterface;
import java.util.ArrayList;
import java.util.List;


public class Main {


  /**
   * The main driver function that takes in user data and outputs skier data to a Readers format.
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
      //Generate data for neo4j DB.
      outputWriter = new FileWriterUserInterface().getFileWriter();
      Neo4jDataGenerator dataGen = new Neo4jDataGenerator();
      ArrayList<ArrayList<Skier>> skiersForDatabase = dataGen.generateThreeDays();
      for (ArrayList<Skier> skiers : skiersForDatabase) {
        writeCsv.writeToFile(outputWriter, skiers);
      }
      writeCsv.cleanUp(outputWriter);

      //Create and load DB, interface with user to get query.
      Neo4jDatabase dataBase = new Neo4jDatabase();
      dataBase.loadDataCSV();
      QueryUserInterface queryUserInterface = new QueryUserInterface();
      dataBase.queryCompare(queryUserInterface.getQuery());

    } else if (args[0].equals("all")) {
      outputWriter = new FileWriterUserInterface().getFileWriter();
      Neo4jDataGenerator dataGen = new Neo4jDataGenerator();
      ArrayList<ArrayList<Skier>> skiersForDatabase = dataGen.generateAllData();
      for (ArrayList<Skier> skiers : skiersForDatabase) {
        writeCsv.writeToFile(outputWriter, skiers);
      }
      writeCsv.cleanUp(outputWriter);
    } else {
      throw new InvalidCommandLineArgument();
    }
  }
}
