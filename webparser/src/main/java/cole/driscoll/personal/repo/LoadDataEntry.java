package cole.driscoll.personal.repo;

public class LoadDataEntry extends AbsDataEntry implements IDataEntry {

  /**
   * Fills in the web crawler when an instance is made.
   *
   * @param crawler - Airtable web crawler
   */
  public LoadDataEntry(AirtableWebCrawler crawler) {
    super(crawler);
  }

  @Override
  public void enterName(String name, int entityNum) {

  }
}
