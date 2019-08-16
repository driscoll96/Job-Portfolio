package cole.driscoll.personal.repo.Parsers;

public interface IWebParser {

  /**
   * Gets the total amount of admin entities (either customers or orders).
   *
    * @return - Total admin customers or orders
   */
  int getTotal();

}
