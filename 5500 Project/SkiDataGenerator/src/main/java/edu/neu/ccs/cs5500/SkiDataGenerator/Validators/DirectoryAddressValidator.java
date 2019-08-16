package edu.neu.ccs.cs5500.SkiDataGenerator.Validators;

import edu.neu.ccs.cs5500.SkiDataGenerator.Exceptions.InvalidInputException;
import edu.neu.ccs.cs5500.SkiDataGenerator.Writers.UpdatedBufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Validates the user input for output directory address by checking if they are follow specific
 * formats.
 */
public class DirectoryAddressValidator implements IValidator {

  /**
   * Checks the directory address user input.
   *
   * @param input - Directory address for csv file output
   * @return - Writer to create output in file
   * @throws InvalidInputException - If file path is not valid
   */
  public UpdatedBufferedWriter checkDirectoryAddress(String input) throws InvalidInputException {
    FileWriter csv;
    try {
      String filePath = input + "\\SyntheticData.csv";
      if (new File(filePath).isFile()) {
        throw new InvalidInputException("file");
      }
      csv = new FileWriter(filePath, true);
      return new UpdatedBufferedWriter(csv, filePath);
    } catch (IOException e) {
      throw new InvalidInputException("file");
    }
  }
}
