package edu.neu.ccs.cs5500.SkiDataGenerator.UserInterface;

import edu.neu.ccs.cs5500.SkiDataGenerator.Collectors.DayInputCollector;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.DayInputValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.Day;
import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.Season;
import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.UserInterfaceMessages;
import edu.neu.ccs.cs5500.SkiDataGenerator.Collectors.RainInputCollector;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.RainInputValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Collectors.SeasonInputCollector;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.SeasonInputValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.SkiResort;
import edu.neu.ccs.cs5500.SkiDataGenerator.Collectors.SnowInputCollector;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.SnowInputValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Collectors.StormInputCollector;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.StormInputValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Collectors.SunnyInputCollector;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.SunnyInputValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.Weather;
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
   System.out.println(UserInterfaceMessages.SKI_CONDITIONS.getValue());
   System.out.println(UserInterfaceMessages.DAY.getValue());
    Day day = new DayInputCollector(new DayInputValidator()).getDay(new Scanner(System.in));
    System.out.println(UserInterfaceMessages.SEASON.getValue());
    Season season = new SeasonInputCollector(new SeasonInputValidator())
        .getSeason(new Scanner(System.in));
   System.out.println(UserInterfaceMessages.SNOW_CONDITIONS.getValue());
    boolean snow = new SnowInputCollector(new SnowInputValidator()).getSnow(new Scanner(System.in));
    System.out.println(UserInterfaceMessages.SUNNY_CONDITIONS.getValue());
    boolean sunny = new SunnyInputCollector(new SunnyInputValidator())
        .getSunny(new Scanner(System.in));
    System.out.println(UserInterfaceMessages.RAIN_CONDITIONS.getValue());
    boolean rain = new RainInputCollector(new RainInputValidator()).getRain(new Scanner(System.in));
    System.out.println(UserInterfaceMessages.STORM_CONDITIONS.getValue());
    boolean storm = new StormInputCollector(new StormInputValidator())
        .getStorm(new Scanner(System.in));
    return new SkiResort(day, season, new Weather(sunny, snow, rain, storm));
  }

}
