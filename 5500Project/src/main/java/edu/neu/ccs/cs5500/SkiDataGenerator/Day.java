package edu.neu.ccs.cs5500.SkiDataGenerator;

/**
 * Stores information about day of the week.
 */
public enum Day {
  MONDAY(10000),
  TUESDAY(8000),
  WEDNESDAY(10000),
  THURSDAY(12000),
  FRIDAY(14000),
  SATURDAY(40000),
  SUNDAY(30000);

  /**
   * The typical number of skiers in that day.
   */
  double skiers;

  /**
   * Creates day instance with number of skiers associated with every day.
   *
   * @param skiers - Typical number of skiers in that day
   */
  Day(double skiers) {
    this.skiers = skiers;
  }

  /**
   * Gets the number of skiers.
   *
   * @return - Number of skiers
   */
  public double getSkiers() {
    return skiers;
  }
}
