package cole.driscoll.personal.repo.Parsers;

import cole.driscoll.personal.repo.Crawlers.AdminCustomerWebCrawler;
import cole.driscoll.personal.repo.CustomerInfo.Customer;
import cole.driscoll.personal.repo.Scrapers.AdminCustomerScraper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * Gets customer data from the Loopie admin page and turns it into JSON data.
 */
public class JSONCustomerWebParser extends AbsCustomerWebParser implements IJSONWebParser {

  /**
   * Fills the field variables with given scraper and crawler.
   *
   * @param scraper - Admin scraper
   * @param crawler - Admin crawler
   */
  public JSONCustomerWebParser(AdminCustomerScraper scraper,
      AdminCustomerWebCrawler crawler) {
    super(scraper, crawler);
  }

  @Override
  public List<String> convertDataToJSON(int start) {
    ArrayList<String> customers = new ArrayList<>();
    Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    int mostRecentCustomer = super.getTotal();
    for (int i = start; i <= mostRecentCustomer; i++) {
      ((AdminCustomerWebCrawler)super.getCrawler()).goToCustomerInfo(i);
      String customer = gson.toJson(new Customer(((AdminCustomerScraper)super.getScraper()).getFirstName(),
          ((AdminCustomerScraper)super.getScraper()).getLastName(),
          ((AdminCustomerScraper)super.getScraper()).getCustomerEmail(),
          ((AdminCustomerScraper)super.getScraper()).getPhoneNum(),
          ((AdminCustomerScraper)super.getScraper()).getStreetAddress1(),
          ((AdminCustomerScraper)super.getScraper()).getStreetAddress2(),
          ((AdminCustomerScraper)super.getScraper()).getZip(),
          ((AdminCustomerScraper)super.getScraper()).getCity(),
          ((AdminCustomerScraper)super.getScraper()).getState()));
      customers.add(customer);
    }
    return customers;
  }

  @Override
  public List<String> convertDataToJSON(int start, int end) {
    ArrayList<String> customers = new ArrayList<>();
    Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    for (int i = start; i <= end; i++) {
      ((AdminCustomerWebCrawler)super.getCrawler()).goToCustomerInfo(i);
      String customer = gson.toJson(new Customer(((AdminCustomerScraper)super.getScraper()).getFirstName(),
          ((AdminCustomerScraper)super.getScraper()).getLastName(),
          ((AdminCustomerScraper)super.getScraper()).getCustomerEmail(),
          ((AdminCustomerScraper)super.getScraper()).getPhoneNum(),
          ((AdminCustomerScraper)super.getScraper()).getStreetAddress1(),
          ((AdminCustomerScraper)super.getScraper()).getStreetAddress2(),
          ((AdminCustomerScraper)super.getScraper()).getZip(),
          ((AdminCustomerScraper)super.getScraper()).getCity(),
          ((AdminCustomerScraper)super.getScraper()).getState()));
      customers.add(customer);
    }
    return customers;
  }
}
