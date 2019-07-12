package cole.driscoll.personal.repo.DataEntry;

import cole.driscoll.personal.repo.CustomerInfo.AbsCustomer;

/**
 * Interface for data entry mechanisms for customer, order, and load info.
 */
public interface IDataEntry {

  /**
   * Enters the name into the name info text box.
   *
   * @param customer - Name of the entity
   * @param entityNum - Position of entity in Airtable list of entity
   */
  void enterName(AbsCustomer customer, int entityNum);
}
