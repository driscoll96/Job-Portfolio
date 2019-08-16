package edu.neu.ccs.cs5500.SkiDataGenerator;

import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.SkiResort;
import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.Skier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Generates a number of skier class instances depending on the what the user inputs as the
 * condition inputs.
 */
public class SkierGenerator {

  private SkiResort skiResort;

  /**
   * Takes in the skiResort with conditions and creates a skier generator instance.
   */
  public SkierGenerator(SkiResort skiResort) {
    this.skiResort = skiResort;
  }

  /**
   * Uses the ski conditions to calculate and generate the correct amount of the skiers and place
   * them in a list.
   *
   * @return - List of skiers
   */
  public List generateSkiers() {
    RandomSkillLevelGenerator skillGenerator = new RandomSkillLevelGenerator();
    ArrayList<Skier> skiers = new ArrayList<>();
    int skierNum = (int) Math.round(
        this.skiResort.getDay().getSkiers()
            + (this.skiResort.getDay().getSkiers() * this.skiResort.getSeason().getPercentChange())
            + (this.skiResort.getDay().getSkiers() * this.skiResort.getWeather()
            .getPercentChange()));
    for (int i = 0; i < skierNum; i++) {
      skiers.add(new Skier(i, -1, ThreadLocalRandom.current().nextBoolean(),
          skillGenerator.generateSkill(), ThreadLocalRandom.current().nextBoolean(), this.skiResort.getDay()));
    }
    return skiers;
  }

  /**
   * Equals function for the SkierGenerator.
   *
   * @param obj SkierGenerator to compare.
   * @return true if equal, false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof SkierGenerator)) {
      return false;
    }
    SkierGenerator that = (SkierGenerator) obj;
    return skiResort.equals(that.skiResort);
  }

  /**
   * toString for the SkierGenerator.
   *
   * @return String rep of the SkierGenerator.
   */
  @Override
  public String toString() {
    return (this.skiResort.toString());
  }

  /**
   * Hashcode for the SkierGenerator.
   *
   * @return hashcode of the SkierGenerator.
   */
  @Override
  public int hashCode() {
    return Objects.hash(skiResort);
  }
}
