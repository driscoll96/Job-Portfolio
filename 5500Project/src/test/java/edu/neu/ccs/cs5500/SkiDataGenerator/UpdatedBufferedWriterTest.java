package edu.neu.ccs.cs5500.SkiDataGenerator;

import static org.junit.Assert.*;

import java.io.FileWriter;
import org.junit.Before;
import org.junit.Test;

public class UpdatedBufferedWriterTest {

  private UpdatedBufferedWriter writer;

  @Before
  public void setUp() throws Exception {
    writer = new UpdatedBufferedWriter(new FileWriter("C:\\Users\\aaeun\\Documents\\SyntheticData.csv"),
        "C:\\Users\\aaeun\\Documents\\SyntheticData.csv");
  }

  @Test
  public void getFilePath() {
    assertEquals(writer.getFilePath(), "C:\\Users\\aaeun\\Documents\\SyntheticData.csv");
  }
}