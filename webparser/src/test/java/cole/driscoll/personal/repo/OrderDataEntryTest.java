package cole.driscoll.personal.repo;

import cole.driscoll.personal.repo.Crawlers.AirtableWebCrawler;
import cole.driscoll.personal.repo.CustomerInfo.StreetAddress;
import cole.driscoll.personal.repo.CustomerInfo.NonCommercialCustomer;
import cole.driscoll.personal.repo.DataEntry.OrderDataEntry;
import cole.driscoll.personal.repo.OrderInfo.Order;
import cole.driscoll.personal.repo.ProductServiceInfo.AbsProduct;
import cole.driscoll.personal.repo.ProductServiceInfo.Regular.WashFold;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderDataEntryTest {

  private WebDriver driver;
  private OrderDataEntry entry;
  private ArrayList<AbsProduct> products;
  private Order order;

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Job App Stuff\\chromedriver_win32 (1)\\chromedriver.exe");
    driver = new ChromeDriver();
    entry = new OrderDataEntry(new AirtableWebCrawler(driver));
    products = new ArrayList<>();
    products.add(new WashFold(false, false));
    products.add(new WashFold(false, false));
    order = new Order(835, new Date(), new Date(), new Date(), 30.00,
        products, new NonCommercialCustomer("Cole", "Driscoll",
        "cd@gmail.com", "1234567890", new StreetAddress("123 st", null, "Seattle",
        "Wa", "12345")));
  }

  @Test
  public void enterName() {
    entry.getCrawler().goToOrderInfo(1);
  }

  @Test
  public void enterOrderInfo() {
    entry.enterOrderInfo(order, 1);
  }

}