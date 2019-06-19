package cole.driscoll.personal.repo;

/**
 * Interface for data entry mechanisms for customer, order, and load info.
 */
public interface IDataEntry {

  /**
   * Enters the name into the name info text box.
   *
   * @param name - Name of the entity
   * @param entityNum - Position of entity in Airtable list of entity
   */
  void enterName(String name, int entityNum);
}
