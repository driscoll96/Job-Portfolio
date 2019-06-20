package cole.driscoll.personal.repo;

public class CustomerDataEntry extends AbsDataEntry {

  /**
   * Fills in the web crawler when an instance is made.
   *
   * @param crawler - Airtable web crawler
   */
  public CustomerDataEntry(AirtableWebCrawler crawler) {
    super(crawler);
  }

  public void enterPhoneNum(String phone, int entityNum) {

  }
}
