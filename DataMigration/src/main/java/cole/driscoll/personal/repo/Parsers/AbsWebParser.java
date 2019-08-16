package cole.driscoll.personal.repo.Parsers;

import cole.driscoll.personal.repo.Crawlers.AbsAdminWebCrawler;
import cole.driscoll.personal.repo.Scrapers.AbsWebScraper;

/**
 * Abstract web parser for JSON data conversion.
 */
public abstract class AbsWebParser implements IWebParser {

  /**
   * Scraper for admin page.
   */
  private AbsWebScraper scraper;

  /**
   * Crawler for admin page.
   */
  private AbsAdminWebCrawler crawler;

  /**
   * Fills the field variables with given scraper and crawler.
   *
   * @param scraper - Admin scraper
   * @param crawler - Admin crawler
   */
  public AbsWebParser(AbsWebScraper scraper, AbsAdminWebCrawler crawler) {
    this.scraper = scraper;
    this.crawler = crawler;
  }

  public AbsWebScraper getScraper() {
    return scraper;
  }

  public AbsAdminWebCrawler getCrawler() {
    return crawler;
  }

}
