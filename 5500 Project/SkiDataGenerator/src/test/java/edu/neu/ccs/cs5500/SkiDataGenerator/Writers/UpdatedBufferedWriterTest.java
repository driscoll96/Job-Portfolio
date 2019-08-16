package edu.neu.ccs.cs5500.SkiDataGenerator.Writers;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5500.SkiDataGenerator.Writers.UpdatedBufferedWriter;
import java.io.FileWriter;
import org.junit.Before;
import org.junit.Test;

public class UpdatedBufferedWriterTest {

  private UpdatedBufferedWriter writer;

  @Before
  public void setUp() throws Exception {
    writer = new UpdatedBufferedWriter(new FileWriter("C:\\Users\\User\\Documents\\Zoom\\SyntheticData.csv"),
        "C:\\Users\\User\\Documents\\Zoom\\SyntheticData.csv");
  }

  @Test
  public void getFilePath() {
    assertEquals(writer.getFilePath(), "C:\\Users\\User\\Documents\\Zoom\\SyntheticData.csv");
  }
}