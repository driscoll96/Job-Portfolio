package cole.driscoll.personal.repo.Parsers;

import cole.driscoll.personal.repo.Crawlers.AbsAdminWebCrawler;
import cole.driscoll.personal.repo.Crawlers.AdminCustomerWebCrawler;
import cole.driscoll.personal.repo.CustomerInfo.Customer;
import cole.driscoll.personal.repo.Scrapers.AbsWebScraper;
import cole.driscoll.personal.repo.Scrapers.AdminCustomerScraper;
import java.util.ArrayList;
import java.util.List;

/**
 * Parser that converts and organizes admin web data into an ArrayList .
 */

public class CustomerWebParser extends AbsCustomerWebParser {

  /**
   * Fills the field variables with given scraper and crawler.
   *
   * @param scraper - Admin scraper
   * @param crawler - Admin crawler
   */
  public CustomerWebParser(AbsWebScraper scraper,
      AbsAdminWebCrawler crawler) {
    super(scraper, crawler);
  }

  /**
   * Goes through the customers from start to most recent (inclusive) and gets the admin website
   * customer data and converts it into an ArrayList of order instances.
   *
   * @param start - Customer ID number to start with
   * @return - List of customers
   */
  public List<Customer> getCustomerInfo(int start) {
    ArrayList<Customer> customers = new ArrayList<>();
    int mostRecentCustomer = super.getTotal();
    for (int i = start; i <= mostRecentCustomer; i++) {
      ((AdminCustomerWebCrawler)super.getCrawler()).goToCustomerInfo(i);
      Customer customer = new Customer(((AdminCustomerScraper)super.getScraper()).getFirstName(),
          ((AdminCustomerScraper)super.getScraper()).getLastName(),
          ((AdminCustomerScraper)super.getScraper()).getCustomerEmail(),
          ((AdminCustomerScraper)super.getScraper()).getPhoneNum(),
          ((AdminCustomerScraper)super.getScraper()).getStreetAddress1(),
          ((AdminCustomerScraper)super.getScraper()).getStreetAddress2(),
          ((AdminCustomerScraper)super.getScraper()).getZip(),
          ((AdminCustomerScraper)super.getScraper()).getCity(),
          ((AdminCustomerScraper)super.getScraper()).getState());
      customers.add(customer);
    }
    return customers;
  }

  /**
   * Goes through the customers from start to end (inclusive) and gets the admin website
   * customer data and converts it into an ArrayList of order instances.
   *
   * @param start - Customer ID number to start with
   * @param end - Customer ID number to start with (inclusive)
   * @return - List of customers
   */
  public List<Customer> getCustomerInfo(int start, int end) {
    ArrayList<Customer> customers = new ArrayList<>();
    for (int i = start; i <= end; i++) {
      ((AdminCustomerWebCrawler)super.getCrawler()).goToCustomerInfo(i);
      Customer customer = new Customer(((AdminCustomerScraper)super.getScraper()).getFirstName(),
          ((AdminCustomerScraper)super.getScraper()).getLastName(),
          ((AdminCustomerScraper)super.getScraper()).getCustomerEmail(),
          ((AdminCustomerScraper)super.getScraper()).getPhoneNum(),
          ((AdminCustomerScraper)super.getScraper()).getStreetAddress1(),
          ((AdminCustomerScraper)super.getScraper()).getStreetAddress2(),
          ((AdminCustomerScraper)super.getScraper()).getZip(),
          ((AdminCustomerScraper)super.getScraper()).getCity(),
          ((AdminCustomerScraper)super.getScraper()).getState());
      customers.add(customer);
    }
    return customers;
  }
}
