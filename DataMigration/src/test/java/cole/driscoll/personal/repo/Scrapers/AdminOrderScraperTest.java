package cole.driscoll.personal.repo.Scrapers;

import static org.junit.Assert.*;

import cole.driscoll.personal.repo.Crawlers.AdminOrderWebCrawler;
import cole.driscoll.personal.repo.OrderInfo.OrderProduct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminOrderScraperTest {

  private AdminOrderScraper scraper;
  private WebDriver driver;
  private AdminOrderWebCrawler crawler;


  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\User\\OneDrive\\Job App Stuff\\chromedriver_win32 (1)\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    scraper = new AdminOrderScraper(driver);
    crawler = new AdminOrderWebCrawler(driver);
  }

  @Test
  public void getProductList() {
    crawler.goToProductPage();
    List list = scraper.getProductList();
    ArrayList products = new ArrayList<String>();
    products.add("Loopie Wash & Fold Service");
    products.add("Wash & Fold Service (Hotel)");
    products.add("Loopie Duffel Bag");
    products.add("Commercial Order (Regular)");
    products.add("Commercial Order (Large bag)");
    products.add("Commercial Loopie bag 30\" x 40\" (Blue)");
    products.add("Wash & Dry (No Fold!)");
    products.add("Comforter (Twin-Full)");
    products.add("Comforter (Queen-King)");
    products.add("Down ComfortersDryCleaning (Twin-Full)");
    products.add("Down ComfortersDryCleaning (Queen-King)");
    products.add("STAIN & ODOR Clean Scent Eco- Friendly (Default)");
    products.add("Sensitive Skin (Fresh Scent natural laundry detergent)");
    products.add("Stain & Odor (Lavender Eucalyptus)");
    products.add("Unscented Detergent");
    products.add("Bedding Bag! (Sheets, Comforter, Towel & Pillow Cases)");
    products.add("Sleeping Bag");
    products.add("Clothing Donation (Free)");
    products.add("Dress (Dry Cleaned)");
    products.add("Shirt or Blouse (Dry cleaned)");
    products.add("Shirt or Blouse (Laundered & Pressed)");
    products.add("Pant / Skirt / Sweater / Jeans (Laundered & Pressed)");
    products.add("Blazer / Suit Jacket / Sport Coat");
    products.add("Suit Special (2 Shirts, 1 Pant, 1 Suit Jacket or Blazer)");
    assertEquals(list, products);
  }

//  @Test
//  public void getOrderProducts() {
//    crawler.goToOrderspage();
//    List<WebElement> customers = driver.findElements(By.tagName("tr"));
//    List<AbsProduct> products = new ArrayList<>();
//    List<AbsProduct> actualProducts = new ArrayList<>();
//    actualProducts.add(new WashFold(false, false));
//    actualProducts.add(new WashFold(false, false));
//    actualProducts.add(new WashFold(false, false));
//    actualProducts.add(new WashFold(false, false));
//    actualProducts.add(new YellowBag());
//    actualProducts.add(new YellowBag());
//    actualProducts.add(new WashFold(false, false));
//    actualProducts.add(new YellowBag());
//    actualProducts.add(new WashFold(false, false));
//    for (int i = customers.size()-6; i < customers.size()-1; i++) {
//      crawler.goToOrderInfo(i);
//      List<AbsProduct> list = scraper.getOrderProducts();
//      products.addAll(list);
//    }
//    assertEquals(actualProducts, products);
//  }

  @Test
  public void getOrderProductDetails() {
    List<List<OrderProduct>> productOrdersActualList = new ArrayList<>();
    List<OrderProduct> ordersActualProduct = new ArrayList<>();
    ordersActualProduct.add(new OrderProduct(3, "Commercial Order (Regular)", 134.97));
    ordersActualProduct.add(new OrderProduct(1, "Loopie Wash & Fold Service", 29.99));
    productOrdersActualList.add(ordersActualProduct);
    ordersActualProduct = new ArrayList<>();
    ordersActualProduct.add(new OrderProduct(1, "Loopie Wash & Fold Service", 29.99));
    productOrdersActualList.add(ordersActualProduct);
    ordersActualProduct = new ArrayList<>();
    ordersActualProduct.add(new OrderProduct(6, "Loopie Wash & Fold Service", 179.94));
    productOrdersActualList.add(ordersActualProduct);
    ordersActualProduct = new ArrayList<>();
    ordersActualProduct.add(new OrderProduct(1, "Loopie Wash & Fold Service", 29.99));
    productOrdersActualList.add(ordersActualProduct);
    ordersActualProduct = new ArrayList<>();
    ordersActualProduct.add(new OrderProduct(1, "Loopie Wash & Fold Service", 29.99));
    productOrdersActualList.add(ordersActualProduct);
    crawler.signIn();
    for (int i = 1291; i >= 1287; i--) {
      crawler.goToOrderInfo(i);
      assertEquals(scraper.getOrderProductDetails(), productOrdersActualList.get(1291-i));
    }
  }

  @Test
  public void getTotalOrders() {
    crawler.signIn();
    crawler.goToOrderspage();
    String total = scraper.getTotalOrders();
    crawler.getDriver().findElement(By.xpath("//*[@id=\"zone{id}\"]/table/tbody/tr[1]/td[1]/a")).click();
    assertEquals(total, scraper.getDriver().findElement(By.xpath("//*[@id=\"content\"]/main/div/div[2]/div[1]/div/p/span[2]")).getText());
  }

  @Test
  public void getInternalNotes() {
    crawler.signIn();
    ArrayList<String> listActual = new ArrayList<>();;
    listActual.add("Go through main entrance, and go in white door into garage. Take the elevator to "
        + "floor “4” and you will enter her unit. You can also try “4R” if you cannot access “4”. "
        + "Deliver at Queen Anne Dispatch to Box 146");
    listActual.add("THIS IS FOR JEAN REMFORD (nina testorosa is a fake account, but I added her card "
        + "info here) Address on 20th ave They store clothes in black bin on the side of the house "
        + "***ask for credit card number next pick up***");
    listActual.add("");
    listActual.add("");
    listActual.add("Ideal Image-Might consider reoccurring weekly pick ups");
    listActual.add("Capellis Operations manager- recurring pick up from downtown Seattle location "
        + "monday-friday at noon. -Dropped off at Natalie’s on 11/05");
    listActual.add("");
    ArrayList<String> list = new ArrayList<>();
    for (int i = 1636; i < 1643; i++) {
      crawler.goToOrderInfo(i);
      list.add(scraper.getInternalNotes());
    }
    assertEquals(list, listActual);
  }

  @Test
  public void getDeliveryNotes() {
    crawler.signIn();
    ArrayList<String> listActual = new ArrayList<>();
    listActual.add("");
    listActual.add("");
    listActual.add("");
    listActual.add("");
    listActual.add("");
    listActual.add("");
    listActual.add("Pick up and deliver to concierge");
    ArrayList<String> list = new ArrayList<>();
    for (int i = 1636; i < 1643; i++) {
      crawler.goToOrderInfo(i);
      list.add(scraper.getDeliveryNotes());
    }
    assertEquals(list, listActual);
  }

  @Test
  public void getId() {
    crawler.signIn();
    ArrayList<String> listActual = new ArrayList<>();
    listActual.add("1636");
    listActual.add("1637");
    listActual.add("1638");
    listActual.add("1639");
    listActual.add("1640");
    listActual.add("1641");
    listActual.add("1642");
    for (int i = 1636; i < 1643; i++) {
      crawler.goToOrderInfo(i);
      assertEquals(scraper.getId(), listActual.get(i-1636));
    }
  }

  @Test
  public void getName() {
    crawler.signIn();
    ArrayList<String> listActual = new ArrayList<>();
    listActual.add("Andrea Raetzer");
    listActual.add("Nina Testarosa");
    listActual.add("Clara Doray");
    listActual.add("Matthew McFadden");
    listActual.add("Joe Shammah");
    listActual.add("Alex Haggard");
    listActual.add("Jani Rautiainen");
    for (int i = 1636; i < 1643; i++) {
      crawler.goToOrderInfo(i);
      assertEquals(scraper.getName(), listActual.get(i-1636));
    }
  }
}