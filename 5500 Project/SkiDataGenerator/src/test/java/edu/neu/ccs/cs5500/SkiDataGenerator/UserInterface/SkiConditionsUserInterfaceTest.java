package edu.neu.ccs.cs5500.SkiDataGenerator.UserInterface;

import edu.neu.ccs.cs5500.SkiDataGenerator.Collectors.DayInputCollector;
import edu.neu.ccs.cs5500.SkiDataGenerator.Collectors.RainInputCollector;
import edu.neu.ccs.cs5500.SkiDataGenerator.Collectors.SeasonInputCollector;
import edu.neu.ccs.cs5500.SkiDataGenerator.Collectors.SnowInputCollector;
import edu.neu.ccs.cs5500.SkiDataGenerator.Collectors.StormInputCollector;
import edu.neu.ccs.cs5500.SkiDataGenerator.Collectors.SunnyInputCollector;
import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.SkiResort;
import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.Weather;
import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.Day;
import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.Season;
import edu.neu.ccs.cs5500.SkiDataGenerator.UserInterface.SkiConditionsUserInterface;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.DayInputValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.RainInputValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.SeasonInputValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.SnowInputValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.StormInputValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.SunnyInputValidator;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.Before;

public class SkiConditionsUserInterfaceTest {

  private SkiConditionsUserInterface skiConditionsUserInterface;
  private Weather weather;

  @Before
  public void setUp() throws Exception {
    skiConditionsUserInterface = new SkiConditionsUserInterface();
  }

  public SkiResort getSkiConditionsTestFunction(String dayInput, String seasonInput,
      String snowInput,
      String sunnyInput, String rainInput, String stormInput) {
    System.out
        .println("Enter conditions of the type of Whistler day you want to produce data for.\n");
    System.out.println("Day of the Week:\n");
    InputStream in = new ByteArrayInputStream(dayInput.getBytes());
    System.setIn(in);
    Day day = new DayInputCollector(new DayInputValidator()).getDay(new Scanner(System.in));
    System.out.println("Season of the Year:\n");
    in = new ByteArrayInputStream(seasonInput.getBytes());
    System.setIn(in);
    Season season = new SeasonInputCollector(new SeasonInputValidator())
        .getSeason(new Scanner(System.in));
    System.out.println("Snow the Day Before?\n");
    in = new ByteArrayInputStream(snowInput.getBytes());
    System.setIn(in);
    boolean snow = new SnowInputCollector(new SnowInputValidator()).getSnow(new Scanner(System.in));
    System.out.println("Sunny?\n");
    in = new ByteArrayInputStream(sunnyInput.getBytes());
    System.setIn(in);
    boolean sunny = new SunnyInputCollector(new SunnyInputValidator())
        .getSunny(new Scanner(System.in));
    System.out.println("Rain?\n");
    in = new ByteArrayInputStream(rainInput.getBytes());
    System.setIn(in);
    boolean rain = new RainInputCollector(new RainInputValidator()).getRain(new Scanner(System.in));
    System.out.println("Blizzard/Storm?\n");
    in = new ByteArrayInputStream(stormInput.getBytes());
    System.setIn(in);
    boolean storm = new StormInputCollector(new StormInputValidator())
        .getStorm(new Scanner(System.in));
    SkiResort genResort = new SkiResort(day, season, new Weather(sunny, snow, rain, storm));
    return genResort;
  }

//  @Test
//  public void getSkiConditionsTest() {
//    String[] days = new String[]{"friday", "monday", "Tuesday", "Wednesday", "Thursday", "Saturday",
//        "Sunday"};
//    Day[] daysReal = new Day[]{Day.FRIDAY, Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY,
//        Day.SATURDAY, Day.SUNDAY};
//    String[] seasons = new String[]{"spring", "summer", "fall", "winter"};
//    Season[] seasonsReal = new Season[]{Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER};
//    String[] weather = new String[]{"yes", "no"};
//    boolean[] weatherReal = new boolean[]{true, false};
//    for (int i = 0; i < days.length; i++) {
//      for (int j = 0; j < seasons.length; j++) {
//        for (int snow = 0; snow < weather.length; snow++) {
//          for (int sunny = 0; sunny < weather.length; sunny++) {
//            for (int rain = 0; rain < weather.length; rain++) {
//              for (int storm = 0; storm < weather.length; storm++) {
//                assertEquals(getSkiConditionsTestFunction(days[i], seasons[j], weather[snow],
//                    weather[sunny], weather[rain], weather[storm]),
//                    new SkiResort(daysReal[i], seasonsReal[j], new Weather(weatherReal[snow],
//                        weatherReal[sunny], weatherReal[rain], weatherReal[storm])));
//              }
//            }
//          }
//        }
//      }
//    }
//  }
}