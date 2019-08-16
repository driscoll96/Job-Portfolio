package cole.driscoll.personal.repo.DataEntry;

/**
 * Interface for data entry mechanisms for customer, order, and load info.
 */
public interface IDataEntry {

  /**
   * Does a POST request to the Loopie API for the JSON customer into the name info text box.
   */
  int enterCustomer(String JSONCustomer);
}
