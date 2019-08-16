package cole.driscoll.personal.repo.Parsers;

import cole.driscoll.personal.repo.Crawlers.AbsAdminWebCrawler;
import cole.driscoll.personal.repo.Crawlers.AdminOrderWebCrawler;
import cole.driscoll.personal.repo.OrderInfo.JSONOrder;
import cole.driscoll.personal.repo.Scrapers.AbsWebScraper;
import cole.driscoll.personal.repo.Scrapers.AdminOrderScraper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * Parser for admin web page to convert order info into JSON.
 */
public class JSONOrderWebParser extends AbsWebParser implements IJSONWebParser {

  /**
   * Fills the field variables with given scraper and crawler.
   *
   * @param scraper - Admin scraper
   * @param crawler - Admin crawler
   */
  public JSONOrderWebParser(AbsWebScraper scraper, AbsAdminWebCrawler crawler) {
    super(scraper, crawler);
  }

  @Override
  public List<String> convertDataToJSON(int start) {
    ArrayList<String> orders = new ArrayList<>();
    Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    int mostRecentOrder = getTotal();
    for (int i = start; i <= mostRecentOrder; i++) {
      ((AdminOrderWebCrawler) super.getCrawler()).goToOrderInfo(i);
      if (!((AdminOrderScraper)super.getScraper()).getId().equals("{id}")) {
        String order = gson.toJson(new JSONOrder(((AdminOrderScraper) super.getScraper()).getId(),
            ((AdminOrderScraper) super.getScraper()).getName(),
            ((AdminOrderScraper) super.getScraper()).getOrderProductDetails(),
            ((AdminOrderScraper) super.getScraper()).getInternalNotes(),
            ((AdminOrderScraper) super.getScraper()).getDeliveryNotes()));
        orders.add(order);
      }
    }
    return orders;
  }

  @Override
  public List<String> convertDataToJSON(int start, int end) {
    ArrayList<String> orders = new ArrayList<>();
    Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    for (int i = start; i <= end; i++) {
      ((AdminOrderWebCrawler) super.getCrawler()).goToOrderInfo(i);
      if (!((AdminOrderScraper)super.getScraper()).getId().equals("{id}")) {
        String order = gson.toJson(new JSONOrder(((AdminOrderScraper) super.getScraper()).getId(),
            ((AdminOrderScraper) super.getScraper()).getName(),
            ((AdminOrderScraper) super.getScraper()).getOrderProductDetails(),
            ((AdminOrderScraper) super.getScraper()).getInternalNotes(),
            ((AdminOrderScraper) super.getScraper()).getDeliveryNotes()));
        orders.add(order);
      }
    }
    return orders;
  }

  /**
   * For test purposes.
   *
   * @param start
   * @param end
   * @return
   */
  public List<String> testSkippingBlankOrders(int start, int end) {
    ArrayList<String> orders = new ArrayList<>();
    Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    for (int i = start; i < end; i++) {
      ((AdminOrderWebCrawler) super.getCrawler()).goToOrderInfo(i);
      if (!((AdminOrderScraper)super.getScraper()).getId().equals("{id}")) {
        String order = gson.toJson(new JSONOrder(((AdminOrderScraper) super.getScraper()).getId(),
            ((AdminOrderScraper) super.getScraper()).getName(),
            ((AdminOrderScraper) super.getScraper()).getOrderProductDetails(),
            ((AdminOrderScraper) super.getScraper()).getInternalNotes(),
            ((AdminOrderScraper) super.getScraper()).getDeliveryNotes()));
        orders.add(order);
      }
    }
    return orders;
  }

  @Override
  public int getTotal() {
    ((AdminOrderWebCrawler)super.getCrawler()).goToOrderspage();
    return Integer.parseInt(((AdminOrderScraper)super.getScraper()).getTotalOrders());
  }

}
