package edu.neu.ccs.cs5500.SkiDataGenerator.Readers;


import edu.neu.ccs.cs5500.SkiDataGenerator.Entity.SkiLift;
import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.SkillLevel;
import edu.neu.ccs.cs5500.SkiDataGenerator.Exceptions.InvalidLiftException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class represents a ReadCsvFile.
 */
public class ReadCsv {

  private static final int HEADERS = 5;
  private static final int SKILL = 4;
  private static final int LIFT = 1;
  private static final int ALPINE = 2;

  private ArrayList<SkiLift> readLifts;

  /**
   * A Constructor for a Readers Reader.
   */
  public ReadCsv() {
    readLifts = new ArrayList<>();
  }

  /**
   * Gets the list of constructed lifts.
   */
  public ArrayList<SkiLift> getReadLifts() {
    return readLifts;
  }

  /**
   * Read given file to this ReadCsvFile.
   *
   * @param reader bufferedReader given to this ReadCsvFile.
   */
  public void readFromFile(BufferedReader reader) {
    try {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] liftInfo = line.split(",");
        addSkiLift(liftInfo);
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OOPS! A file was not found : " + fnfe.getMessage());
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          System.out.println("Failed to close input stream");
        }
      }
    }
  }

  /**
   * Create each skiLift and add connection information to each SkiLift.
   *
   * @param info SkiLiftAttributes.
   */
  private void addSkiLift(String[] info) throws InvalidLiftException {
    if (info.length >= HEADERS) {
      try {
        for (int len = 0; len < info.length; len++) {
          if (len == 1) {
            len++;
          }
          info[len] = info[len].replace(" ", "");
          info[len] = info[len].replace("\"", "");
        }
        int idNum = Integer.parseInt(info[0]);
        SkillLevel level = parseSkillLevel(Integer.parseInt(info[SKILL]));
        SkiLift skiLift = new SkiLift(idNum, info[LIFT], level);
        if (info[info.length - ALPINE].equalsIgnoreCase("yes")) {
          skiLift.setAlpine();
        }
        for (int i = 2; i < info.length - ALPINE; i++) {
          Integer liftToAdd = Integer.parseInt(info[i]);
          skiLift.addToConnectionsList(liftToAdd);
        }
        readLifts.add(skiLift);
      } catch (Exception e) {
        if (info.length < HEADERS) {
          System.out.println("Line skipped- not a valid lift.");
        }
      }
    } else {
      throw new InvalidLiftException("Not a valid Lift File");
    }
  }

  private SkillLevel parseSkillLevel(int level) {
    if (level == 2) {
      return SkillLevel.EXPERT;
    } else if (level == 1) {
      return SkillLevel.INTERMEDIATE;
    } else {
      return SkillLevel.BUNNYHILL;
    }
  }
}
