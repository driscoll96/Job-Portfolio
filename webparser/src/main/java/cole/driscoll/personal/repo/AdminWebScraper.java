package cole.driscoll.personal.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminWebScraper extends AbsWebScraper {

  /**
   * Constructor which takes the WebDriver.
   *
   * @param driver - WebDriver
   */
  public AdminWebScraper(WebDriver driver) {
    super(driver);
  }

  @Override
  public List<String> getProductList() {
    ArrayList<String> products = new ArrayList<>();
    List<WebElement> productTables = super.getDriver().findElements(By.tagName("tbody"));
    List<WebElement> productCategories;
    for (int j = 0; j < productTables.size(); j++) {
      productCategories = productTables.get(j).findElements(By.tagName("tr"));
      for (int i = 0; i < productCategories.size(); i++) {
        products.add(productCategories.get(i).findElements(By.tagName("td")).get(0).getText());
      }
    }
    return products;
  }

  @Override
  public List<AbsProduct> getOrderProducts() {
    List<AbsProduct> bags = null;
    WebElement orderWebTable = super.getDriver().findElement(By.xpath("//*[@id=\"content\"]/main/div"
        + "/div[2]/form/div[2]/div[2]/div/div/table/tbody/tr"));
    List<WebElement> rowTableElements = orderWebTable.findElements(By.tagName("tr"));
    List<WebElement> columnTableElements;
    int numBags;
    TypeIdentifier identifier = new TypeIdentifier();
    for(int i = 0; i < rowTableElements.size(); i++) {
      columnTableElements = rowTableElements.get(i).findElements(By.tagName("td"));
      numBags = Integer.parseInt(columnTableElements.get(0).getText());
      bags.add(identifier.identifyProductType(columnTableElements.get(1).getText()));
    }
    super.getDriver().navigate().back();
    super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return bags;
  }

  @Override
  public List<WebElement> getWebOrders() {
    return super.getDriver().findElements(By.tagName("tr"));
  }

}
