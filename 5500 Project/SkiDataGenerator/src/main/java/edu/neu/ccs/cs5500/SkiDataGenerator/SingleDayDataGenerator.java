package edu.neu.ccs.cs5500.SkiDataGenerator;


import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.SkiLift;
import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.SkiResort;
import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.Skier;
import java.util.ArrayList;
import java.util.List;

/**
 * Data generator which produces ski data for a single day.
 */
public class SingleDayDataGenerator {

  /**
   * Uses generateSingleDayFromMap method to create and path skiers, filling in their lift ride
   * list.
   *
   * @param resort - The ski resort
   * @return - List of skiers
   */
  public List<Skier> generateSingleDay(SkiResort resort) {
    // Generate Skier list.

    ArrayList<SkiLift> allLifts = new LiftGenerator().createResortLifts();
    return generateSingleDayFromMap(resort, allLifts);
  }

  /**
   * Creates and paths skiers, filling in their lift ride list.
   *
   * @param resort - The ski resort
   * @return - List of skiers
   */
  public List<Skier> generateSingleDayFromMap(SkiResort resort, ArrayList<SkiLift> allLifts) {
    // Generate Skier list.
    SkierGenerator skierGenerator = new SkierGenerator(resort);
    List<Skier> skiers = skierGenerator.generateSkiers();
    resort.setAllLifts(allLifts);
    ArrayList<ArrayList<Integer>> skiMap = resort.createLiftMap();

    // Generate the paths for skier and populate LiftRides.
    PathGen pathGen = new PathGen(skiers, skiMap, resort.getAllLifts());
    pathGen.fillSkiersRideLists();
    return skiers;
  }
}
