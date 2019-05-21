package cole.driscoll.personal.repo;

import java.util.ArrayList;
import java.util.List;
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
    WebElement orderWebTable = super.getDriver().findElement(By.xpath("//*[@id=\"content\"]/main/div/div[2]/form/div[2]/div[2]/div/div/table/tbody"));
    List<WebElement> rowTableElements = orderWebTable.findElements(By.tagName("tr"));
    List<WebElement> columnTableElements;
    int numBags;
    TypeIdentifier identifier = new TypeIdentifier();
    for(int i = 0; i < rowTableElements.size(); i++) {
      columnTableElements = rowTableElements.get(i).findElements(By.tagName("td"));
      numBags = Integer.parseInt(columnTableElements.get(0).getText());
      for (int j = 0; j < numBags; j++) {
        bags.add(identifier.identifyProductType(columnTableElements.get(1).getText()));
      }
    }
    return bags;
  }

  @Override
  public List<WebElement> getWebOrdersOrCustomer() {
    return super.getDriver().findElements(By.tagName("tr"));
  }

  public String getCustomerEmail() {
    return super.getDriver().findElement(By.xpath("//*[@id=\"customer_form\"]/div[3]/div/div/input")).getText();
  }

  public String getZip() {
    return super.getDriver().findElement(By.xpath("//*[@id=\"customer_form\"]/div[7]/div[1]/div/input")).getText();
  }

  public String getState() {
    return super.getDriver().findElement(By.xpath("//*[@id=\"customer_form\"]/div[8]/div/div/input")).getText();
  }

}
