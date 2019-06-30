package edu.neu.ccs.cs5500.SkiDataGenerator;

import java.util.Random;

/**
 * Randomly generates a skill level for a skier.
 */
public class RandomSkillLevelGenerator {

  /**
   * Generates the skill level.
   *
   * @return - Skill level
   */
  public SkillLevel generateSkill() {
    Random rand = new Random();
    int level = rand.nextInt(2);
    if (level == 0) {
      return SkillLevel.BUNNYHILL;
    }
    if (level == 1) {
      return SkillLevel.INTERMEDIATE;
    }
    return SkillLevel.EXPERT;
  }

}
