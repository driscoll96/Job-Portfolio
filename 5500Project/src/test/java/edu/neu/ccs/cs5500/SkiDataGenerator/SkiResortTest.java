package edu.neu.ccs.cs5500.SkiDataGenerator;

import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SkiResortTest {

  public ReadCsv CSVReader = new ReadCsv();
  public MapFileAddressValidator val = new MapFileAddressValidator();
  public SkiResort skiResort;
  public SkiResort skiResort1;


  @Before
  public void setUp() throws Exception {
    try {
      CSVReader.readFromFile(val.checkMapFilePath("C:\\Users\\aaeun\\OneDrive\\Documents\\School Organization\\Summer 2019\\5500 Repo\\LiftConnections.csv"));
    } catch (Exception e) {
      TestCase.fail();
    }
    skiResort = new SkiResort(Day.MONDAY, Season.WINTER, new Weather(false, false, false, true));
    skiResort1 = new SkiResort(Day.MONDAY, Season.WINTER, new Weather(false, false, false, false));
  }

  @Test
  public void setAllLifts() {
    skiResort.setAllLifts(CSVReader.getReadLifts());
    Assert.assertEquals(skiResort.getAllLifts(), CSVReader.getReadLifts());
  }

  @Test
  public void addLift() {
    skiResort.setAllLifts(CSVReader.getReadLifts());
    SkiLift skiLift = new SkiLift(20, "Harmony", SkillLevel.BUNNYHILL);
    skiResort.addLift(skiLift);
    Assert.assertEquals(skiResort.getAllLifts().toString(),
        "[Lift Number: 0 Lift Name: BlackComb Gondola Lift Connections: [0, 1, 2, 3, 4, 5, 6, 7, 8] Alpine Status: false, "
            + "Lift Number: 1 Lift Name: Catskinner Lift Connections: [0, 1, 2, 3, 4, 5, 6, 7, 8] Alpine Status: false, "
            + "Lift Number: 2 Lift Name: Jersey Lift Connections: [0, 1, 2, 3, 4, 5, 6, 7, 8] Alpine Status: false, "
            + "Lift Number: 3 Lift Name: Excellerator Lift Connections: [0, 2, 3, 6, 8] Alpine Status: false, "
            + "Lift Number: 4 Lift Name: Excalibur Lift Connections: [0, 3, 4] Alpine Status: false, "
            + "Lift Number: 5 Lift Name: 7th Heaven Lift Connections: [0, 2, 3, 4, 6, 8, 9, 10] Alpine Status: false, "
            + "Lift Number: 6 Lift Name: Glacier Lift Connections: [2, 3, 4, 6, 8, 9, 10] Alpine Status: false, "
            + "Lift Number: 7 Lift Name: Peak to Peak Lift Connections: [0, 1, 2, 3, 4, 5, 6, 8, 11, 12, 13, 14, 16, 17, 18, 19] Alpine Status: false, "
            + "Lift Number: 8 Lift Name: Crystal Lift Connections: [2, 3, 4, 6, 8] Alpine Status: false, "
            + "Lift Number: 9 Lift Name: Showcase T Bar Lift Connections: [2, 3, 4, 6, 8, 9] Alpine Status: false, "
            + "Lift Number: 10 Lift Name: Horsemann T Bar Lift Connections: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10] Alpine Status: false, "
            + "Lift Number: 11 Lift Name: Whistler Gondola Lift Connections: [11, 12, 13, 14, 15, 17, 18, 19] Alpine Status: false, "
            + "Lift Number: 12 Lift Name: Fitzsimmons Lift Connections: [11, 12, 17] Alpine Status: false, "
            + "Lift Number: 13 Lift Name: Creekside Gondola Lift Connections: [11, 12, 13, 17, 19] Alpine Status: false, "
            + "Lift Number: 14 Lift Name: Peak Lift Connections: [11, 12, 13, 14, 15, 17, 18, 19] Alpine Status: true, "
            + "Lift Number: 15 Lift Name: Harmony Lift Connections: [11, 12, 13, 14, 16, 15, 17, 18, 19] Alpine Status: true, "
            + "Lift Number: 16 Lift Name: Symphony Lift Connections: [15, 18, 17, 11, 12] Alpine Status: true, "
            + "Lift Number: 17 Lift Name: Garbanzo Lift Connections: [11, 12, 13, 17, 18, 19] Alpine Status: false, "
            + "Lift Number: 18 Lift Name: Emerald Lift Connections: [11, 12, 13, 14, 15, 17, 18, 19] Alpine Status: false, "
            + "Lift Number: 19 Lift Name: Red Lift Connections: [11, 12, 13, 14, 15, 17, 18, 19] Alpine Status: false, "
            + "Lift Number: 20 Lift Name: Harmony Lift Connections: [] Alpine Status: false]");
  }

  @Test
  public void createLiftMap() {
    skiResort.setAllLifts(CSVReader.getReadLifts());
    ArrayList<ArrayList<Integer>> skiMap = skiResort.createLiftMap();
    System.out.println(skiMap.toString());
    Assert.assertEquals(skiMap.toString(),
        "[[1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1], "
            + "[0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1], "
            + "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0], "
            + "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1], "
            + "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1], "
            + "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1], "
            + "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1]]");
  }

  @Test
  public void createLiftMap1() {
    skiResort1.setAllLifts(CSVReader.getReadLifts());
    ArrayList<ArrayList<Integer>> skiMap = skiResort1.createLiftMap();
    System.out.println(skiMap.toString());
    Assert.assertEquals(skiMap.toString(),
        "[[1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1], "
            + "[0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0], "
            + "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1], "
            + "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0], "
            + "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1], "
            + "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1], "
            + "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1], "
            + "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0], "
            + "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1], "
            + "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1], "
            + "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1]]");
  }

  @Test
  public void testHashCode() {
    skiResort.setAllLifts(CSVReader.getReadLifts());
    ReadCsv reader = new ReadCsv();
    try {
      reader.readFromFile(new MapFileAddressValidator().checkMapFilePath("C:\\Users\\User\\"
          + "OneDrive\\CoolCreativeAardvarks\\ExampleLiftConnections.csv"));
    } catch (Exception e) {
      e.printStackTrace();
    }
    assertEquals(skiResort.hashCode(), skiResort.hashCode());
    Day[] daysReal = new Day[]{Day.SATURDAY, Day.SUNDAY, Day.FRIDAY, Day.THURSDAY, Day.MONDAY,
        Day.TUESDAY, Day.WEDNESDAY};
    Season[] seasonsReal = new Season[]{Season.FALL, Season.WINTER, Season.SPRING, Season.SUMMER};
    // Weather is either equal to weather of "skiResort" or not
    Weather[] weatherReal = new Weather[]{new Weather(false, false, false, true),
        new Weather(false, false, true, true)};
    ArrayList<ArrayList<SkiLift>> lifts = new ArrayList<>();
    // Lift data ArrayList is either equal to lift data of "skiResort" or not
    lifts.add(CSVReader.getReadLifts());
    lifts.add(reader.getReadLifts());
    for (int i = 0; i < daysReal.length; i++) {
      for (int j = 0; j < seasonsReal.length; j++) {
        for (int k = 0; k < weatherReal.length; k++) {
          for (int l = 0; l < lifts.size(); l++) {
            SkiResort resort = new SkiResort(daysReal[i], seasonsReal[j], weatherReal[k]);
            resort.setAllLifts(lifts.get(l));
            if (daysReal[i].equals(Day.MONDAY) && seasonsReal[j].equals(Season.WINTER) &&
                weatherReal[k].equals(new Weather(false, false, false, true))
                && lifts.get(l).equals(CSVReader.getReadLifts())) {
              assertEquals(resort.hashCode(), skiResort.hashCode());
            } else {
              assertNotEquals(resort.hashCode(), skiResort.hashCode());
            }
          }
        }
      }
    }
  }
}