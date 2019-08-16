package edu.neu.ccs.cs5500.SkiDataGenerator;

import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.SkiLift;
import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.SkiLiftRide;
import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.Skier;
import edu.neu.ccs.cs5500.SkiDataGenerator.Exceptions.InvalidLiftRideTimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Path generator which populates each skiers' list of rides taken.
 */
public class PathGen {

  private List<Skier> skiers;
  private ArrayList<ArrayList<Integer>> skiMap;
  private ArrayList<SkiLift> allLists;
  static final int NUM_RIDES = 11;
  static final int BEGIN_LUNCH = 180;
  static final int END_LUNCH = 240;
  static final int LUNCH = 60;
  static final int RIDE = 30;

  /**
   * Constructor fills fields.
   *
   * @param skiers - Skiers
   * @param skiMap - 2D matrix of lift connections
   */
  public PathGen(List<Skier> skiers, ArrayList<ArrayList<Integer>> skiMap,
      ArrayList<SkiLift> allLists) {
    this.skiers = skiers;
    this.skiMap = skiMap;
    this.allLists = allLists;
  }

  /**
   * Adds 12 ski lift rides to each skier's lift ride list. If they eat lunch then they don't take a
   * lift. The time is incremented an hour to signify lift ride and skiing time.
   */
  public void fillSkiersRideLists() {
    for (Skier skier : skiers) {
      pathSkierOnBaseLift(skier);
      if (skier.isLazy()) {
        fillLazySkierList(skier);
      } else {
        // Add 11 more ski rides to list
        for (int i = 0; i < NUM_RIDES; i++) {
          // If they eat lunch and its 12 pm then they don't ride and eat for an hour
          if (skier.isHasLunch() && skier.getSkierTime() > BEGIN_LUNCH && skier.getSkierTime() < END_LUNCH) {
            skier.incrementTimeOneRide(LUNCH);
            // Decrement because lunch doesn't count as lift ride
            i--;
          } else {
            findNewLift(skier);
          }
        }
      }
    }
  }

  /**
   * Puts skier on first (base) ski lift.
   *
   * @param skier - Current skier
   */
  private void pathSkierOnBaseLift(Skier skier) {
    int baseLift = getRandomNumberForBase();
    skier.addLiftRide(new SkiLiftRide(baseLift, skier.getSkierTime()));
    skier.setCurrentLift(baseLift);
    // Increment to signify ride and skiing down slope
    skier.incrementTimeOneRide(RIDE);
  }

  /**
   * Finds a new ski lift for the skier to go.
   *
   * @param skier - Current skier
   */
  private void findNewLift(Skier skier) {
    // Pick next possible lift
    int newRide = getNextLiftRide(skiMap.get(skier.getCurrentLift()), skier);
    // Adds a new SkiLiftRide to skier's list (I assumed: time = when skier starts ride)
    try {
      skier.addLiftRide(new SkiLiftRide(newRide, skier.getSkierTime()));
      skier.setCurrentLift(newRide);
      skier.incrementTimeOneRide(RIDE);
    } catch (InvalidLiftRideTimeException e) {
      return;
    }
  }

  /**
   * For lazy skiers they cycle through the same path 3 times. This function repeats the initial
   * lift 2 more times and then has the skier do 3 more cycles elsewhere.
   *
   * @param skier - Current skier
   */
  private void fillLazySkierList(Skier skier) {
    try {
      // Skier does base lift 2 more times
      for (int i = 0; i < 2; i++) {
        skier.addLiftRide(new SkiLiftRide(skier.getCurrentLift(), skier.getSkierTime()));
        skier.incrementTimeOneRide(RIDE);
      }
      // 3 new lazy cycles where they repeat 3 lift rides 3 times
      for (int i = 0; i < 3; i++) {
        findNewLift(skier);
        // j < 2 because "findNewLift" counts as first pass through
        for (int j = 0; j < 2; j++) {
          // If they eat lunch and its 12 pm then they don't ride
          if (skier.isHasLunch() && skier.getSkierTime() >= 180 && skier.getSkierTime() <= 240) {
            skier.incrementTimeOneRide(LUNCH);
          }
          skier.addLiftRide(new SkiLiftRide(skier.getCurrentLift(), skier.getSkierTime()));
          skier.incrementTimeOneRide(RIDE);
        }
      }
    } catch (InvalidLiftRideTimeException e) {
      return;
    }
  }

  /**
   * Gets a random number based on the number ID of the base ski lift. The base lifts are
   * predetermined and each lift is weighted.
   *
   * @return - Index of the ski lift that is chosen
   */
  private int getRandomNumberForBase() {
    ArrayList<Integer> weightedList = new ArrayList<>();
    // Adds weights to Blackcomb
    for (int i = 0; i < 2; i++) {
      weightedList.add(0);
    }
    // Adds weights to Whistler
    for (int i = 0; i < 5; i++) {
      weightedList.add(11);
    }
    // Adds weights to Creekside
    for (int i = 0; i < 3; i++) {
      weightedList.add(13);
    }
    return getRandNumFromGivenNums(weightedList);
  }

  /**
   * Filter outs ski lifts which will bring skier to a level which is too tough for them and then
   * chooses a random index from the possible lifts.
   *
   * @param liftConnections - List of lift connections, 1 if they are connected
   * @param skier - Info of the skier travelling
   * @return - Randomly chosen index which represents the lift which the skier will travel by
   */
  private int getNextLiftRide(ArrayList<Integer> liftConnections, Skier skier) {
    ArrayList<Integer> possibleLiftRides = new ArrayList<>();
    int index = 0;
    for (Integer i : liftConnections) {
      // Checks for 1 value in AM and if the Skill Levels match.
      if (i == 1 && allLists.get(index).getSkillLevel().getNumLevel() <= skier.getSkillLevel()
          .getNumLevel()) {
        possibleLiftRides.add(index);
      }
      index++;
    }
    return getRandNumFromGivenNums(possibleLiftRides);
  }

  /**
   * Chooses a random index from a given list of indices which represent lifts.
   *
   * @param possibleLiftIndices - Lift indices
   * @return - Randomly chosen index
   */
  private int getRandNumFromGivenNums(ArrayList<Integer> possibleLiftIndices) {
    Random rand = new Random();
    return possibleLiftIndices.get(rand.nextInt(possibleLiftIndices.size()));
  }

}
