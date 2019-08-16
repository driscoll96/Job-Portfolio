package edu.neu.ccs.cs5500.SkiDataGenerator.Writers;

import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.Day;
import edu.neu.ccs.cs5500.SkiDataGenerator.Readers.ReadCsv;
import edu.neu.ccs.cs5500.SkiDataGenerator.Writers.WriteCsv;
import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.SkiLift;
import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.SkiLiftRide;
import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.Skier;
import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.SkillLevel;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.DirectoryAddressValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.MapFileAddressValidator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WriteCsvTest {
  public ReadCsv CSVReader = new ReadCsv();
  public MapFileAddressValidator val = new MapFileAddressValidator();


  public WriteCsv CSVWriter = new WriteCsv();
  public DirectoryAddressValidator dVal = new DirectoryAddressValidator();
  public List<Skier> skiers = new ArrayList<Skier>();
  public Skier skier1 = new Skier(1, -1, false, SkillLevel.INTERMEDIATE, false, Day.FRIDAY);
  public Skier skier2 = new Skier(2, -1, true, SkillLevel.BUNNYHILL, true, Day.FRIDAY);
  public Skier skier3 = new Skier(3, -1, false, SkillLevel.EXPERT, true, Day.FRIDAY);
  public SkiLift skiLift1 = new SkiLift(1, "Blackcomb Gondola", SkillLevel.EXPERT);
  public SkiLift skiLift2 = new SkiLift(2, "Catskinner", SkillLevel.BUNNYHILL);
  public SkiLiftRide skiRide1 = new SkiLiftRide(1, 30);
  public SkiLiftRide skiRide2 = new SkiLiftRide(1, 90);
  public SkiLiftRide skiRide3 = new SkiLiftRide( 2, 100);
  public SkiLiftRide skiRide4 = new SkiLiftRide( 1, 45);
  public SkiLiftRide skiRide5 = new SkiLiftRide( 2, 300);

  @Before
  public void setUp() throws Exception {

    CSVReader = new ReadCsv();
    val = new MapFileAddressValidator();

    CSVWriter = new WriteCsv();
    dVal = new DirectoryAddressValidator();

    skier1.addLiftRide(skiRide1);
    skier1.addLiftRide(skiRide2);
    skier1.addLiftRide(skiRide3);
    skier1.addLiftRide(skiRide5);

    skier2.addLiftRide(skiRide3);
    skier2.addLiftRide(skiRide4);

    skiers.add(skier1);
    skiers.add(skier2);
    skiers.add(skier3);
  }

  @Test
  public void writeToFile() {

    try {
      CSVWriter.writeToFile(dVal.checkDirectoryAddress("C:\\Users\\User\\Documents\\R"), skiers);
    } catch (Exception e) {
      TestCase.fail();
    }

    List<List<String>> records = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\Documents\\R\\SyntheticData.csv"))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] values = line.split(",");
        records.add(Arrays.asList(values));
      }
    } catch (FileNotFoundException FNFE){
      System.out.println("FNFE");
    } catch (IOException IOE){
      System.out.println("IOE");
    } finally {
      Assert.assertEquals(records.toString(), "[[SkierNum, Time, LiftNum, Day], [1, 30, 1, FRIDAY], [1, 90, 1, FRIDAY], [1, 100, 2, FRIDAY], [1, 300, 2, FRIDAY], [2, 100, 2, FRIDAY], [2, 45, 1, FRIDAY]]");
    }
  }
}