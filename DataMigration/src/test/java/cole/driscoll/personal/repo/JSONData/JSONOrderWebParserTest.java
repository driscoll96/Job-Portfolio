package cole.driscoll.personal.repo.JSONData;

import static org.junit.Assert.*;

import cole.driscoll.personal.repo.Crawlers.AdminOrderWebCrawler;
import cole.driscoll.personal.repo.OrderInfo.JSONOrder;
import cole.driscoll.personal.repo.Parsers.JSONOrderWebParser;
import cole.driscoll.personal.repo.Scrapers.AdminOrderScraper;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSONOrderWebParserTest {

  private WebDriver driver;
  private JSONOrderWebParser parser;
  private AdminOrderScraper scraper;
  private AdminOrderWebCrawler crawler;

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\User\\OneDrive\\Job App Stuff\\chromedriver_win32 (1)\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    parser = new JSONOrderWebParser(new AdminOrderScraper(driver), new AdminOrderWebCrawler(driver));
    scraper = new AdminOrderScraper(driver);
    crawler = new AdminOrderWebCrawler(driver);
  }

  @Test
  public void getJSONOrderDataTest() {
    parser.getCrawler().signIn();
    List<String> orders = parser.convertDataToJSON(1638);
    JSONOrder orderActual;
    for (int i = 1638; i < 1638+orders.size(); i++) {
      crawler.goToOrderInfo(i);
      orderActual = new JSONOrder(scraper.getId(),
          scraper.getName(), scraper.getOrderProductDetails(),
          scraper.getInternalNotes(), scraper.getDeliveryNotes());
      String orderStr = "{\"orderId\":\""+orderActual.getOrderId()+"\",\"name\":\""
          +orderActual.getName()+"\",\"products\":["+"],\"internalNotes\":\""+orderActual.getInternalNotes()
          +"\",\"deliveryNotes\":\""+orderActual.getDeliveryNotes()+"\"}";
      String finishedStr = insertOrderProducts(orderStr, orderActual);
      assertEquals(orders.get(i-1638), finishedStr);
    }
  }

  @Test
  public void getJSONOrderDataTestSkipping() {
    parser.getCrawler().signIn();
    List<String> orders = parser.testSkippingBlankOrders(426, 432);
    assertEquals(orders.size(), 4);
  }

  public String insertOrderProducts(String orderStr, JSONOrder order) {
    String productStrConstant = "\",\"products\":[";
    int index = orderStr.lastIndexOf(productStrConstant)+productStrConstant.length()-1;
    String insertedStr;
    for(int i = 0; i < order.getProducts().size(); i++) {
      if (i != order.getProducts().size()-1) {
        insertedStr = "{\"quantity\":" + order.getProducts().get(i).getQuantity()
            + ",\"name\":\"" + order.getProducts().get(i).getName() + "\",\"total\":" + order
            .getProducts().get(i).getTotal() + "},";
        orderStr = insertString(orderStr, insertedStr, index);
        index += insertedStr.length();
      } else {
        insertedStr = "{\"quantity\":" + order.getProducts().get(i).getQuantity()
            + ",\"name\":\"" + order.getProducts().get(i).getName() + "\",\"total\":" + order
            .getProducts().get(i).getTotal() + "}";
        orderStr = insertString(orderStr, insertedStr, index);
        index += insertedStr.length();
      }
    }
    return orderStr;
  }

  public String insertString(
      String originalString,
      String stringToBeInserted,
      int index)
  {
    String newString = new String();

    for (int i = 0; i < originalString.length(); i++) {
      newString += originalString.charAt(i);

      if (i == index) {
        newString += stringToBeInserted;
      }
    }
    return newString;
  }


}