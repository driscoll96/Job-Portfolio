package cole.driscoll.personal.repo;

public class CustomerDataEntry extends AbsDataEntry implements IOrderCustomerDataEntry {

  /**
   * Fills in the web crawler when an instance is made.
   *
   * @param crawler - Airtable web crawler
   */
  public CustomerDataEntry(AirtableWebCrawler crawler) {
    super(crawler);
  }

  @Override
  public void enterPhoneNum(String phone, int entityNum) {

  }

  @Override
  public void enterName(String name, int entityNum) {

  }
}
