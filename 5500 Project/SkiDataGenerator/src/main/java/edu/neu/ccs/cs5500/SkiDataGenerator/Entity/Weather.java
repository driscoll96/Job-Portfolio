package edu.neu.ccs.cs5500.SkiDataGenerator.Entity;

import java.util.Objects;

/**
 * Info about weather of the day.
 */
public class Weather {

  private boolean sunny;
  private boolean snow;
  private boolean rain;
  private boolean storm;

  /**
   * Constructor that fills field variables with given info.
   *
   * @param sunny - True if sunny, false if cloudy
   * @param snow - True if it snowed the day before
   * @param rain - True if raining
   * @param storm - True if stormy
   */
  public Weather(boolean sunny, boolean snow, boolean rain, boolean storm) {
    this.sunny = sunny;
    this.snow = snow;
    this.rain = rain;
    this.storm = storm;
  }

  /**
   * Gets if the weather is sunny.
   *
   * @return true if sunny.
   */
  public boolean isSunny() {
    return sunny;
  }

  /**
   * Gets if the weather is snowy.
   *
   * @return true if snowy.
   */
  public boolean isSnow() {
    return snow;
  }

  /**
   * Gets if the weather is rainy.
   *
   * @return true if rainy.
   */
  public boolean isRain() {
    return rain;
  }

  /**
   * Gets if the weather is stormy.
   *
   * @return true if stormy.
   */
  public boolean isStorm() {
    return storm;
  }


  /**
   * Gets the percent change in skier numbers based on weather variables.
   *
   * @return - Percent change
   */
  public double getPercentChange() {
    if (isStorm() || isRain()) {
      return -0.5;
    }
    if (isSunny() && isSnow()) {
      return 0.25;
    }
    return 0.0;
  }

  /**
   * The equals function for Weather.
   *
   * @param obj weather to compare to.
   * @return true if they are equal, false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Weather)) {
      return false;
    }
    Weather weather = (Weather) obj;
    return sunny == weather.sunny
        && snow == weather.snow
        && rain == weather.rain
        && storm == weather.storm;
  }

  /**
   * Hashcode for the Weather.
   *
   * @return hashcode for weather.
   */
  @Override
  public int hashCode() {
    return Objects.hash(sunny, snow, rain, storm);
  }

  /**
   * toSTring function for Weather.
   *
   * @return string rep of Weather.
   */
  @Override
  public String toString() {
    return "Sun: " + this.sunny + " Snow: " + this.snow + " Rain: " + this.rain + " Storm: "
        + this.storm;
  }
}
