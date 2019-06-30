package edu.neu.ccs.cs5500.SkiDataGenerator;

import java.util.Scanner;

/**
 * Gathers user input of ski conditions to be used for data production.
 */
public class SkiConditionsUserInterface implements IUserInterface {

  /**
   * Prompts the user for ski condition inputs and uses the collector to convert them into a
   * SkierResort.
   *
   * @return - SkiResort to hold all conditions
   */
  public SkiResort getSkiConditions() {
    System.out.println(UserInterfaceMessages.SkiConditions);
    System.out.println(UserInterfaceMessages.Day);
    Day day = new DayInputCollector(new DayInputValidator()).getDay(new Scanner(System.in));
    System.out.println(UserInterfaceMessages.Season);
    Season season = new SeasonInputCollector(new SeasonInputValidator())
        .getSeason(new Scanner(System.in));
    System.out.println(UserInterfaceMessages.SnowConditions);
    boolean snow = new SnowInputCollector(new SnowInputValidator()).getSnow(new Scanner(System.in));
    System.out.println(UserInterfaceMessages.SunnyConditions);
    boolean sunny = new SunnyInputCollector(new SunnyInputValidator())
        .getSunny(new Scanner(System.in));
    System.out.println(UserInterfaceMessages.RainConditions);
    boolean rain = new RainInputCollector(new RainInputValidator()).getRain(new Scanner(System.in));
    System.out.println(UserInterfaceMessages.StormConditions);
    boolean storm = new StormInputCollector(new StormInputValidator())
        .getStorm(new Scanner(System.in));
    return new SkiResort(day, season, new Weather(sunny, snow, rain, storm));
  }

}
