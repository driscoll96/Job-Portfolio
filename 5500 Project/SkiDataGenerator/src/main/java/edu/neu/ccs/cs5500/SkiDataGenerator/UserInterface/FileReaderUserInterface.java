package edu.neu.ccs.cs5500.SkiDataGenerator.UserInterface;

import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.UserInterfaceMessages;
import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.MapFileAddressValidator;
import edu.neu.ccs.cs5500.SkiDataGenerator.Collectors.SkiMapInputCollector;
import java.io.BufferedReader;
import java.util.Scanner;

/**
 * Gathers user input to be used for reading files.
 */
public class FileReaderUserInterface implements IUserInterface {

  /**
   * Prompts the user for file address and uses the collector to convert it into a file reader.
   *
   * @return - File reader
   */
  public BufferedReader getFileReader() {
    SkiMapInputCollector collector = new SkiMapInputCollector((new MapFileAddressValidator()));
    System.out.println(UserInterfaceMessages.FILE_PATH.getValue());
    return collector.getReader(new Scanner(System.in));
  }

}
