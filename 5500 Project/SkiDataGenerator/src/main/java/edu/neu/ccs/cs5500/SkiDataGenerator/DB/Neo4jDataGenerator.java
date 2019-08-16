package edu.neu.ccs.cs5500.SkiDataGenerator.DB;

import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.SkiLift;
import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.SkiResort;
import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.Skier;
import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.Weather;
import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.Day;
import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.Season;
import edu.neu.ccs.cs5500.SkiDataGenerator.LiftGenerator;
import edu.neu.ccs.cs5500.SkiDataGenerator.SingleDayDataGenerator;
import java.util.ArrayList;

public class Neo4jDataGenerator {

  private ArrayList<SkiLift> allLifts = null;
  private static final int ALWAYS_RAINING = 1;

  /**
   * A constructor for the DataGenerator.
   */
  public Neo4jDataGenerator() {
    this.allLifts = allLifts;
  }

  /**
   * Generates a day of ski lift data for every combination of ski condition input. Produces skiers
   * for every day and fills their ski lift ride list.
   *
   * @return - 2D ArrayList of skiers for every combination of inputs
   */
  public ArrayList<ArrayList<Skier>> generateAllData() {
    ArrayList<ArrayList<Skier>> allData = new ArrayList<>();
    Day[] daysReal = new Day[]{Day.SATURDAY, Day.SUNDAY, Day.FRIDAY, Day.THURSDAY, Day.MONDAY,
        Day.TUESDAY, Day.WEDNESDAY};
    Season[] seasonsReal = new Season[]{Season.FALL, Season.WINTER, Season.SPRING, Season.SUMMER};
    boolean[] weatherReal = new boolean[]{true, false};
    SingleDayDataGenerator dataGenerator = new SingleDayDataGenerator();
    this.allLifts = new LiftGenerator().createResortLifts();

    for (int i = 0; i < daysReal.length; i++) {
      for (int j = 0; j < seasonsReal.length; j++) {
        for (int snow = 0; snow < weatherReal.length; snow++) {
          for (int sunny = 0; sunny < weatherReal.length; sunny++) {
            for (int storm = 0; storm < weatherReal.length; storm++) {
              allData.add((ArrayList<Skier>) dataGenerator
                  .generateSingleDayFromMap(new SkiResort(daysReal[i], seasonsReal[j], new
                      Weather(weatherReal[snow], weatherReal[sunny], weatherReal[ALWAYS_RAINING],
                      weatherReal[storm])), this.allLifts));
            }
          }
        }
      }
    }
    return allData;
  }

  /**
   * Creates three days worth of skier data.
   *
   * @return - Three days worth of skier data
   */
  public ArrayList<ArrayList<Skier>> generateThreeDays() {
    ArrayList<ArrayList<Skier>> ThreeDays = new ArrayList<>();
    SingleDayDataGenerator dataGenerator = new SingleDayDataGenerator();
    this.allLifts = new LiftGenerator().createResortLifts();
    Weather weather = new Weather(true, true, false, false);
    ThreeDays.add((ArrayList<Skier>) dataGenerator
        .generateSingleDayFromMap(new SkiResort(Day.FRIDAY, Season.WINTER, weather), this.allLifts));
    ThreeDays.add((ArrayList<Skier>) dataGenerator
        .generateSingleDayFromMap(new SkiResort(Day.SATURDAY, Season.WINTER, weather), this.allLifts));
    ThreeDays.add((ArrayList<Skier>) dataGenerator
        .generateSingleDayFromMap(new SkiResort(Day.SUNDAY, Season.WINTER, weather), this.allLifts));
    return ThreeDays;
  }
}
