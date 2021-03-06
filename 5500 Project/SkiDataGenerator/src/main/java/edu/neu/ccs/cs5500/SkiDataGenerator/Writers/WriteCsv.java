package edu.neu.ccs.cs5500.SkiDataGenerator.Writers;

import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.SkiLiftRide;
import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.Skier;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

/**
 * A class to write to a Readers.
 */
public class WriteCsv {

  /**
   * Writes to the Readers file.
   *
   * @param writer the BufferedWriter given.
   */
  public void writeToFile(BufferedWriter writer, List<Skier> skiers) {
    try {
      writer.append("SkierNum");
      writer.append(",");
      writer.append("Time");
      writer.append(",");
      writer.append("LiftNum");
      writer.append(",");
      writer.append("Day");
      writer.append(",");
      writer.newLine();

      for (Skier skier : skiers) {
        for (SkiLiftRide ride : skier.getLiftRides()) {
          writer.write(Integer.toString(skier.getSkierNum()));
          writer.append(",");
          writer.write(Integer.toString(ride.getTime()));
          writer.append(",");
          writer.write(Integer.toString(ride.getLiftNum()));
          writer.append(",");
          writer.write(skier.getDay().getString());
          writer.append(",");
          writer.newLine();

        }
      }
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
    } finally {
      try {
        writer.flush();
        //writer.close();
      } catch (IOException ioe) {
        System.out.println("Failed to flush writer.");
      }
    }
  }

  /**
   * Closes the buffered writer stream to the output csv file.
   *
   * @param writer - Writer to the output csv
   */
  public void cleanUp(BufferedWriter writer) {
    try {
      writer.close();
    } catch (IOException ioe) {
      System.out.println("Failed to close writer.");
    }
  }
}
