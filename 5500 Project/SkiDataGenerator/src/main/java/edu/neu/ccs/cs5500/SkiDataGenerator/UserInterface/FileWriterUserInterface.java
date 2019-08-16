package edu.neu.ccs.cs5500.SkiDataGenerator.UserInterface;

import edu.neu.ccs.cs5500.SkiDataGenerator.Collectors.DirectoryAddressInputCollector;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.DirectoryAddressValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.UserInterfaceMessages;
import edu.neu.ccs.cs5500.SkiDataGenerator.Writers.UpdatedBufferedWriter;
import java.util.Scanner;

/**
 * Gathers user input used for file writing.
 */
public class FileWriterUserInterface implements IUserInterface {

  /**
   * Prompts the user for directory address and uses the collector to convert it into a file
   * writer.
   *
   * @return - File writer
   */
  public UpdatedBufferedWriter getFileWriter() {
    DirectoryAddressInputCollector collector = new DirectoryAddressInputCollector(
        new DirectoryAddressValidator());
    System.out.println(UserInterfaceMessages.DIRECTORY.getValue());
    return collector.getFilePath(new Scanner(System.in));
  }
}
