package edu.neu.ccs.cs5500.SkiDataGenerator;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.SkillLevel;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class RandomSkillLevelGeneratorTest {

  private RandomSkillLevelGenerator generator;

  @Before
  public void setUp() throws Exception {
    generator = new RandomSkillLevelGenerator();
  }

  @Test
  public void generateSkill() {
    ArrayList<SkillLevel> randLevels = new ArrayList<>();
    for (int i = 0; i < 200; i++) {
      randLevels.add(generator.generateSkill());
    }
    boolean flag = true;
    SkillLevel first = randLevels.get(0);
    for(int i = 1; i < 200 && flag; i++) {
      if (randLevels.get(i) != first) {
        flag = false;
      }
    }
    assertFalse(flag);
  }
}