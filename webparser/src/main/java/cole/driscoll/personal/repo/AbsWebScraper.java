package cole.driscoll.personal.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Scraper which contains a different methods to scrape data from the admin and airtables pages.
 */
public abstract class AbsWebScraper {

  /**
   * The relevant WebDriver.
   */
  private WebDriver driver;

  /**
   * Constructor which takes the WebDriver.
   *
   * @param driver - WebDriver
   */
  public AbsWebScraper(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Gets the raw admin web data.
   *
   * @return - List of the raw data
   */
  public List<WebElement> getWebOrders() {
    return driver.findElements(By.tagName("tr"));
  }

  /**
   * Gets the list of products from the admin order page.
   *
   * @return - List of Products
   */
  public List<AbsProduct> getProductListFromOrders() {
    List<AbsProduct> bags = null;
    WebElement orderWebTable = driver.findElement(By.xpath("//*[@id=\"content\"]/main/div/div[2]/form/div[2]/div[2]/div/div/table/tbody/tr"));
    List<WebElement> rowTableElements = orderWebTable.findElements(By.tagName("tr"));
    List<WebElement> columnTableElements;
    int numBags;
    TypeIdentifier identifier = new TypeIdentifier();
    for(int i = 0; i < rowTableElements.size(); i++) {
      columnTableElements = rowTableElements.get(i).findElements(By.tagName("td"));
      numBags = Integer.parseInt(columnTableElements.get(0).getText());
      bags.add(identifier.identifyProductType(columnTableElements.get(1).getText()));
    }
    driver.navigate().back();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return bags;
  }

  /**
   * Gets the list of products from the admin customer page.
   *
   * @return - List of raw product names
   */
  public List<String> getProductListFromCustomers() {
    ArrayList<String> products = new ArrayList<>();
    List<WebElement> productCategories = driver.findElements(By.tagName("tr"));
    for (int i = 0; i < productCategories.size(); i++) {
      products.add(productCategories.get(i).findElements(By.tagName("td")).get(0).getText());
    }
    return products;
  }

  public WebDriver getDriver() {
    return driver;
  }
}