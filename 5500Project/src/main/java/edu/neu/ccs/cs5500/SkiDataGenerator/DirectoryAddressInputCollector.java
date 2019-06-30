package edu.neu.ccs.cs5500.SkiDataGenerator;

import java.io.BufferedWriter;
import java.util.Scanner;

/**
 * Collects the path of the file which will contain the output data.
 */
public class DirectoryAddressInputCollector extends AbsInputCollector {

  /**
   * Fills field variable with given validator.
   *
   * @param validator - Season input validator
   */
  public DirectoryAddressInputCollector(IValidator validator) {
    super(validator);
  }

  /**
   * Prompts and collects user input of the directory address they want their output file to be
   * created in. The user is prompted until they enter a valid input.
   *
   * @param scan - Scanner to get user input
   * @return - Writer to create output
   */
  public UpdatedBufferedWriter getFilePath(Scanner scan) {
    BufferedWriter fileWriter = null;
    boolean correctInput = false;
    while (!correctInput) {
      try {
        fileWriter = ((DirectoryAddressValidator) (super.getValidator()))
            .checkDirectoryAddress(scan.nextLine());
        correctInput = true;
      } catch (InvalidInputException e) {
        correctInput = false;
      }
    }
    return (UpdatedBufferedWriter) fileWriter;
  }
}

