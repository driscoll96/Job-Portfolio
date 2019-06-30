package edu.neu.ccs.cs5500.SkiDataGenerator;

/**
 * Information about the season of the year. Winter and spring are considered peak season, summer
 * and fall are considered off-peak.
 */
public enum Season {
  WINTER(0.1),
  SPRING(0.1),
  SUMMER(-0.2),
  FALL(-0.2);

  /**
   * Percent change in the amount of skiers for specific season.
   */
  double percentChange;

  /**
   * Creates season with corresponding percent change.
   *
   * @param change - Percent change
   */
  Season(double change) {
    percentChange = change;
  }

  /**
   * Gets the percent change for specific season.
   *
   * @return - Percent change
   */
  public double getPercentChange() {
    return percentChange;
  }

}
