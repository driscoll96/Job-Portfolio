package edu.neu.ccs.cs5500.SkiDataGenerator;

import edu.neu.ccs.cs5500.SkiDataGenerator.Readers.ReadCsv;
import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.SkiLift;
import edu.neu.ccs.cs5500.SkiDataGenerator.UserInterface.FileReaderUserInterface;
import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * Generator for the resort's ski lifts.
 */
public class LiftGenerator {

  /**
   * Uses the file reader user interface to get the location of the ski resort map csv file and
   * populates their connections list.
   *
   * @return - List of the ski lifts with their connections populated
   */
  public ArrayList<SkiLift> createResortLifts() {
    FileReaderUserInterface readerUserInterface = new FileReaderUserInterface();
    BufferedReader skiMapData = readerUserInterface.getFileReader();
    ReadCsv readCsv = new ReadCsv();
    readCsv.readFromFile(skiMapData);
    ArrayList<SkiLift> allLifts = readCsv.getReadLifts();
    return allLifts;
  }
}
