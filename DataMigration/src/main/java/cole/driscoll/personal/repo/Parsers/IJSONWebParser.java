package cole.driscoll.personal.repo.Parsers;

import java.util.List;

public interface IJSONWebParser {

  /**
   * Starts from the top entity in the Loopie admin website and goes to each entity's info page
   * to extract their data. The data is converted into the JSON database format. The given number
   * represents the beginning of the iteration range (inclusive).
   *
   * @param start - The beginning of the iteration range (inclusive)
   * @return - ArrayList of JSON entity info
   */
  List<String> convertDataToJSON(int start);

  /**
   * Starts from the top entity in the Loopie admin website and goes to each entity's info page
   * to extract their data. The data is converted into the JSON database format. The given numbers
   * represents the beginning and end of the iteration range (inclusive).
   *
   * @param start - The beginning of the iteration range (inclusive)
   * @param end - The end of the iteration range (inclusive)
   * @return - ArrayList of JSON entity info
   */
  List<String> convertDataToJSON(int start, int end);

}
