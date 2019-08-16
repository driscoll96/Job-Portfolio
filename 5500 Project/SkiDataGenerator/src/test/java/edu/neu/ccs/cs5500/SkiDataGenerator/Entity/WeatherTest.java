package edu.neu.ccs.cs5500.SkiDataGenerator.Entity;

import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.Weather;
import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.Day;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WeatherTest {

  Weather weather;

  @Before
  public void setUp() throws Exception {
    weather = new Weather(true, false, true, true);
  }

  @Test
  public void equals() {
    assertEquals(weather, weather);
    assertNotEquals(weather, Day.FRIDAY);
    assertEquals(weather, new Weather(true, false, true, true));
    assertNotEquals(weather, new Weather(false, false, true, true));
    assertNotEquals(weather, new Weather(true, true, true, true));
    assertNotEquals(weather, new Weather(false, false, false, true));
    assertNotEquals(weather, new Weather(false, false, true, true));
    assertNotEquals(weather, new Weather(false, true, true, true));
    assertNotEquals(weather, new Weather(true, false, false, true));
    assertNotEquals(weather, new Weather(false, true, true, true));
    assertNotEquals(weather, new Weather(true, true, true, false));
    assertNotEquals(weather, new Weather(false, false, false, false));
    assertNotEquals(weather, new Weather(true, true, false, false));
  }

  @Test
  public void hashCodeTest() {
    assertEquals(weather.hashCode(), weather.hashCode());
    assertEquals(weather.hashCode(), new Weather(true, false, true, true).hashCode());
    assertNotEquals(weather.hashCode(), new Weather(false, false, true, true).hashCode());
    assertNotEquals(weather.hashCode(), Day.FRIDAY.hashCode());
  }

  @Test
  public void isSunny() {
    assertTrue(weather.isSunny());
  }

  @Test
  public void isSnow() {
    assertFalse(weather.isSnow());
  }

  @Test
  public void isRain() {
    assertTrue(weather.isRain());
  }

  @Test
  public void isStorm() {
    assertTrue(weather.isStorm());
  }

  @Test
  public void percentChange() {
    assertEquals(new Weather(true, true, false, false).getPercentChange(), 0.25, 0.0);
    assertEquals(new Weather(false, true, false, false).getPercentChange(), 0.0, 0.0);
    assertEquals(new Weather(true, false, false, false).getPercentChange(), 0.0, 0.0);
    assertEquals(new Weather(false, false, false, false).getPercentChange(), 0.0, 0.0);
    assertEquals(new Weather(true, true, true, false).getPercentChange(), -0.5, 0.0);
    assertEquals(new Weather(true, true, false, true).getPercentChange(), -0.5, 0.0);
    assertEquals(new Weather(true, true, true, true).getPercentChange(), -0.5, 0.0);
    assertEquals(new Weather(false, true, true, false).getPercentChange(), -0.5, 0.0);
    assertEquals(new Weather(false, true, false, true).getPercentChange(), -0.5, 0.0);
    assertEquals(new Weather(true, false, false, true).getPercentChange(), -0.5, 0.0);
    assertEquals(new Weather(true, false, true, false).getPercentChange(), -0.5, 0.0);
    assertEquals(weather.getPercentChange(), -0.5, 0.0);
  }
}