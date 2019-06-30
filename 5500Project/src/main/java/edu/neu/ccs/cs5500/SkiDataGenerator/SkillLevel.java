package edu.neu.ccs.cs5500.SkiDataGenerator;

/**
 * The level of skill of a skier.
 */
public enum SkillLevel {
  BUNNYHILL(0),
  INTERMEDIATE(1),
  EXPERT(2);

  /**
   * Associated skill number.
   */
  private int numLevel;

  /**
   * Constructor which fills the instance with its skill number.
   *
   * @param numLevel - Associated skill number
   */
  SkillLevel(int numLevel) {
    this.numLevel = numLevel;
  }

  /**
   * Gets the skill number.
   *
   * @return - Associated skill number
   */
  public int getNumLevel() {
    return numLevel;
  }
}
