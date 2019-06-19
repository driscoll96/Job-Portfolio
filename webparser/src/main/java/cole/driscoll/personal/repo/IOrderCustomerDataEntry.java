package cole.driscoll.personal.repo;

/**
 * Interface for data entry mechanisms for customer and order info.
 */
public interface IOrderCustomerDataEntry extends IDataEntry {

  /**
   * Enters the phone number in the appropriate info text box.
   *
   * @param phone - Phone number associated with the entity
   * @param entityNum - Position of entity in Airtable list of entity
   */
  void enterPhoneNum(String phone, int entityNum);

}
