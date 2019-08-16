package cole.driscoll.personal.repo.Parsers;

import cole.driscoll.personal.repo.Crawlers.AbsAdminWebCrawler;
import cole.driscoll.personal.repo.Crawlers.AdminCustomerWebCrawler;
import cole.driscoll.personal.repo.Scrapers.AbsWebScraper;
import cole.driscoll.personal.repo.Scrapers.AdminCustomerScraper;

public abstract class AbsCustomerWebParser extends AbsWebParser {

  /**
   * Fills the field variables with given scraper and crawler.
   *
   * @param scraper - Admin scraper
   * @param crawler - Admin crawler
   */
  public AbsCustomerWebParser(AbsWebScraper scraper,
      AbsAdminWebCrawler crawler) {
    super(scraper, crawler);
  }

  @Override
  public int getTotal() {
    ((AdminCustomerWebCrawler)super.getCrawler()).goToCustomerPage();
    return Integer.parseInt(((AdminCustomerScraper)super.getScraper()).getTotalCustomers());
  }
}
