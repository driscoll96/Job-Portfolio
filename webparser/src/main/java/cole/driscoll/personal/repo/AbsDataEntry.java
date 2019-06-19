package cole.driscoll.personal.repo;

/**
 * Attaches an Airtable web crawler to every data entry class.
 */
public abstract class AbsDataEntry {

  /**
   * Airtable web crawler.
   */
  private AirtableWebCrawler crawler;

  /**
   * Fills in the web crawler when an instance is made.
   * @param crawler - Airtable web crawler
   */
  public AbsDataEntry(AirtableWebCrawler crawler) {
    this.crawler = crawler;
  }

  /**
   * Gets the Airtable web crawler.
   *
   * @return - Airtable web crawler
   */
  public AirtableWebCrawler getCrawler() {
    return crawler;
  }
}
