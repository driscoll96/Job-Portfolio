package cole.driscoll.personal.repo.JSONData;

import cole.driscoll.personal.repo.Crawlers.AdminWebCrawler;
import cole.driscoll.personal.repo.Scrapers.AdminWebScraper;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;

/**
 * Gets customer data from the Loopie admin page and turns it into JSON data.
 */
public class JSONWebParser {

  /**
   * Scraper for admin page.
   */
  private AdminWebScraper scraper;

  /**
   * Crawler for admin page.
   */
  private AdminWebCrawler crawler;

  /**
   * Creates scraper and crawler using the given WebDriver.
   *
   * @param driver - WebDriver
   */
  public JSONWebParser(WebDriver driver) {
    this.scraper = new AdminWebScraper(driver);
    this.crawler = new AdminWebCrawler(driver);
  }

  /**
   * Starts from the top customer in the Loopie admin website and goes to each customer;s info page
   * to extract their data. The data is converted into the JSON database format. The given number
   * represents the beginning of the iteration range (exclusive).
   *
   * @param start - The beginning of the iteration range (exclusive)
   * @return - ArrayList of JSON customer info
   */
  public List<String> getJSONCustomerData(int start) {
    ArrayList<String> customers = new ArrayList<>();
    Gson gson = new Gson();
    int mostRecentCustomer = getTotalCustomers();
    for (int i = start+1; i <= mostRecentCustomer; i++) {
      crawler.goToCustomerInfo(i);
      String customer = gson.toJson(new JSONCustomer(scraper.getFirstName(), scraper.getLastName(),
          scraper.getCustomerEmail(), scraper.getPhoneNum(), scraper.getStreetAddress1(),
          scraper.getStreetAddress2(), scraper.getZip(), scraper.getCity(), scraper.getState()));
      customers.add(customer);
    }
    return customers;
  }

  /**
   * Goes to the admin customer page and gets top customer's ID, which represents the total number
   * of customer's
   *
   * @return - Top customer's ID
   */
  private int getTotalCustomers() {
    crawler.goToCustomerPage();
    return Integer.parseInt(scraper.getTotalCustomers());
  }

  public AdminWebCrawler getCrawler() {
    return crawler;
  }
}
