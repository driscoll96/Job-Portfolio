package edu.neu.ccs.cs5500.SkiDataGenerator;

import java.io.BufferedWriter;
import java.io.Writer;

/**
 * Buffered writing but with file path as a property.
 */
public class UpdatedBufferedWriter extends BufferedWriter {

  /**
   * Path of the file being edited.
   */
  private String filePath;

  /**
   * Takes and fills file path with given path.
   *
   * @param out - File writer
   * @param filePath - File path
   */
  public UpdatedBufferedWriter(Writer out, String filePath) {
    super(out);
    this.filePath = filePath;
  }

  /**
   * Gets the file path.
   *
   * @return - File path
   */
  public String getFilePath() {
    return filePath;
  }
}
