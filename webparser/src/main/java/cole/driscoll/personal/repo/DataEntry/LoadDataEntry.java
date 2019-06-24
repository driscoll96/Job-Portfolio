package cole.driscoll.personal.repo.DataEntry;

import cole.driscoll.personal.repo.Crawlers.AirtableWebCrawler;
import cole.driscoll.personal.repo.CustomerInfo.AbsCustomer;

public class LoadDataEntry extends AbsDataEntry {

  /**
   * Fills in the web crawler when an instance is made.
   *
   * @param crawler - Airtable web crawler
   */
  public LoadDataEntry(AirtableWebCrawler crawler) {
    super(crawler);
  }

  /*@Override
  public void enterName(String name, int entityNum) {

  }*/

  @Override
  public void enterName(AbsCustomer customer, int entityNum) {

  }
}
