package edu.neu.ccs.cs5500.SkiDataGenerator;


import edu.neu.ccs.cs5500.SkiDataGenerator.Readers.ReadCsv;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.MapFileAddressValidator;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReadCsvTest {

  public ReadCsv CSVReader = new ReadCsv();
  public MapFileAddressValidator val = new MapFileAddressValidator();

  @Before
  public void setUp() throws Exception {
    CSVReader = new ReadCsv();
    val = new MapFileAddressValidator();
  }

  @Test
  public void readFromFile() {
    try {
      CSVReader.readFromFile(val.checkMapFilePath("ExampleLiftConnections.csv"));
    } catch (Exception e) {
      TestCase.fail();
    }
    Assert.assertEquals(CSVReader.getReadLifts().toString(),
        "[Lift Number: 2 Lift Name: Jersey Lift Connections: [0, 1, 2, 3, 4] Alpine Status: false, "
            + "Lift Number: 3 Lift Name: Excellerator Lift Connections: [0, 2, 3] Alpine Status: true, "
            + "Lift Number: 4 Lift Name: Excalibur Lift Connections: [0, 3, 4] Alpine Status: false]");
  }

  @Test
  public void readFromFileInvalid() {
    try {
      CSVReader.readFromFile(val.checkMapFilePath("ExampleLiftConnections.csv"));
    } catch (Exception e) {
      TestCase.fail();
    }
    Assert.assertNotEquals(CSVReader.getReadLifts().toString(),
        "[Lift ID Lift Name Lift Connections, "
            + "Lift Number: 2 Lift Name: Jersey Lift Connections: [0, 1, 2, 3, 4], "
            + "Lift Number: 3 Lift Name: Excellerator Lift Connections: [0, 2, 3], "
            + " ift Number: 4 Lift Name: Excalibur Lift Connections: [0, 3, 4]]");
  }
}