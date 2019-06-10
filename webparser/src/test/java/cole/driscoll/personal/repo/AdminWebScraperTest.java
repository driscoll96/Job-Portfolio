package cole.driscoll.personal.repo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminWebScraperTest {
  private AdminWebScraper scraper;
  private WebDriver driver;
  private AdminWebCrawler crawler;


  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\User\\OneDrive\\Job App Stuff\\chromedriver_win32 (1)\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    scraper = new AdminWebScraper(driver);
    crawler = new AdminWebCrawler(driver);
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
    products.add("Down Comforters (Twin-Full)");
    products.add("Down Comforters (Queen-King)");
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

  @Test
  public void getOrderProducts() {
    crawler.goToOrderspage();
    List<WebElement> customers = driver.findElements(By.tagName("tr"));
    List<AbsProduct> products = new ArrayList<>();
    List<AbsProduct> actualProducts = new ArrayList<>();
    actualProducts.add(new WashFold(false, false));
    actualProducts.add(new WashFold(false, false));
    actualProducts.add(new WashFold(false, false));
    actualProducts.add(new WashFold(false, false));
    actualProducts.add(new YellowBag());
    actualProducts.add(new YellowBag());
    actualProducts.add(new WashFold(false, false));
    actualProducts.add(new YellowBag());
    actualProducts.add(new WashFold(false, false));
    for (int i = customers.size()-6; i < customers.size()-1; i++) {
      crawler.goToOrderPage(i);
      List<AbsProduct> list = scraper.getOrderProducts();
      products.addAll(list);
    }
    assertEquals(actualProducts, products);
  }

  @Test
  public void getWebOrdersOrCustomer() {
    crawler.signIn();
    driver.get("https://www.loopie.us/admin/statistics.php?date_start=03%2F01%2F2018&date_end=06%2F09%2F2019&zip_code=");
    int numCustomers = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"content\"]/main/div"
        + "[1]/div[3]/div/table/tbody/tr[3]/td[2]/a")).getText());
    driver.get("https://www.loopie.us/admin/statistics.php?date_start=07%2F01%2F2018&date_end=06%2F09%2F2019&zip_code=");
    int NumOrders = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"content\"]/main/div[1]/"
        + "div[3]/div/table/tbody/tr[1]/td[2]")).getText());
    crawler.goToOrderspage();
    List<WebElement> orders = scraper.getWebOrdersOrCustomer();
    assertEquals(orders.size(), NumOrders);
    crawler.goToCustomerPage();
    assertEquals(scraper.getWebOrdersOrCustomer().size(), numCustomers);
  }

  @Test
  public void getCustomerEmail() {
  }

  @Test
  public void getZip() {
  }

  @Test
  public void getState() {
  }
}