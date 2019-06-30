package edu.neu.ccs.cs5500.SkiDataGenerator;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class SkierGeneratorTest {

  private SkierGenerator generator;
  private List<Skier> skiers;
  private Weather weather1, weather2, weather3, weather4, weather5, weather6, weather7, weather8,
      weather9, weather10;
  private SkiResort skiResort1, skiResort2, skiResort3, skiResort4;

  @Before
  public void setUp() throws Exception {
    weather1 = new Weather(true, true, false, false);
    weather2 = new Weather(false, true, false, false);
    weather3 = new Weather(true, false, false, false);
    weather4 = new Weather(false, false, false, false);
    weather5 = new Weather(true, true, true, false);
    weather6 = new Weather(true, true, false, true);
    weather7 = new Weather(false, true, true, false);
    weather9 = new Weather(false, true, false, true);
    weather10 = new Weather(true, false, false, true);

    skiResort1 = new SkiResort(Day.MONDAY, Season.WINTER, weather1);
    skiResort2 = new SkiResort(Day.SATURDAY, Season.SUMMER, weather10);
    skiResort3 = new SkiResort(Day.SUNDAY, Season.SPRING, weather7);
    skiResort4 = new SkiResort(Day.FRIDAY, Season.FALL, weather2);
  }

  @Test
  public void equals() {
  }

  @Test
  public void generateSkiers1() {
    generator = new SkierGenerator(skiResort1);
    skiers = generator.generateSkiers();
    assertEquals(13500, skiers.size());
  }

  @Test
  public void generateSkiers2() {
    generator = new SkierGenerator(skiResort2);
    skiers = generator.generateSkiers();
    assertEquals(12000, skiers.size());
  }

  @Test
  public void generateSkiers3() {
    generator = new SkierGenerator(skiResort3);
    skiers = generator.generateSkiers();
    assertEquals(18000, skiers.size());
  }

  @Test
  public void generateSkiers4() {
    generator = new SkierGenerator(skiResort4);
    skiers = generator.generateSkiers();
    assertEquals(11200, skiers.size());
  }
}