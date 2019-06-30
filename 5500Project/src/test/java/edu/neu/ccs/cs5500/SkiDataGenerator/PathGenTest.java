package edu.neu.ccs.cs5500.SkiDataGenerator;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class PathGenTest {

  private BufferedReader reader;
  private SkierGenerator skierGenerator;
  private ReadCsv readCsv;
  private PathGen pathGen;
  private List<Skier> skiers;

  @Before
  public void setUp() throws Exception {
    try {
      // User of test will have to change file path to the location of the "LiftConnections.csv" file
      reader = new BufferedReader(
          new FileReader(new File("C:\\Users\\User\\OneDrive\\5500Project\\LiftConnections.csv")));
    } catch (IOException e) {
      e.printStackTrace();
    }
//    skierGenerator = new SkierGenerator(Day.FRIDAY, Season.WINTER, new Weather(true, true, false, false));
//    skiers = skierGenerator.generateSkiers();
    readCsv = new ReadCsv();
    readCsv.readFromFile(reader);
    ArrayList<SkiLift> allLifts = readCsv.getReadLifts();
   // SkiResort skiResort = new SkiResort(allLifts);
    //ArrayList<ArrayList<Integer>> skiMap = skiResort.createLiftMap();
    //pathGen = new PathGen(skiers, skiMap, allLifts);
  }

//  @Test
//  public void fillSkiersRideLists() {
//    pathGen.fillSkiersRideLists();
//    for (Skier skier : skiers) {
//      assertTrue(skier.getLiftRides().size() == 12);
//      assertTrue(skier.getSkierTime() == 21 || skier.getSkierTime() == 22);
//      assertTrue(skier.getLiftRides().get(0).liftNum == 0 ||
//          skier.getLiftRides().get(0).liftNum == 11 || skier.getLiftRides().get(0).liftNum == 13);
//    }
//  }
}