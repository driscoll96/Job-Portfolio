package edu.neu.ccs.cs5500.SkiDataGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validates the user input for ski map file address by checking if they are follow specific
 * formats.
 */
public class MapFileAddressValidator implements IValidator {

  /**
   * Validates the file address user input for the ski resort.
   *
   * @param input - User input
   * @return - Reader for the map
   * @throws InvalidInputException - if map file is empty or not a valid file address
   */
  public BufferedReader checkMapFilePath(String input) throws InvalidInputException {
    BufferedReader map;
    boolean nonEmpty = false;
    try {
      map = new BufferedReader(new FileReader(input));
      Pattern pat = Pattern.compile(".*[a-zA-Z]+.*", Pattern.CASE_INSENSITIVE);
      Matcher match;
      String line;
      while ((line = map.readLine()) != null) {
        match = pat.matcher(line);
        if (match.find()) {
          nonEmpty = true;
        }
      }
      if (!nonEmpty) {
        throw new InvalidInputException("map-empty");
      }
      return new BufferedReader(new FileReader(input));
    } catch (IOException e) {
      throw new InvalidInputException("map-not-file");
    }
  }

}
