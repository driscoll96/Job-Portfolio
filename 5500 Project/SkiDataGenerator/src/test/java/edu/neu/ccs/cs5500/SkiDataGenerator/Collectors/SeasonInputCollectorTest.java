package edu.neu.ccs.cs5500.SkiDataGenerator.Collectors;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5500.SkiDataGenerator.Collectors.SeasonInputCollector;
import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.Season;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.SeasonInputValidator;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

public class SeasonInputCollectorTest {

  private SeasonInputCollector collector;

  @Before
  public void setUp() throws Exception {
    collector = new SeasonInputCollector(new SeasonInputValidator());
  }

  @Test
  public void getSeason() {
    String season = "Spring";
    InputStream in = new ByteArrayInputStream(season.getBytes());
    System.setIn(in);
    assertEquals(collector.getSeason(new Scanner(System.in)), Season.SPRING);
  }
}