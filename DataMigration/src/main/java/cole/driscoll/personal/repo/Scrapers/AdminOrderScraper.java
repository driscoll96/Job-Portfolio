package cole.driscoll.personal.repo.Scrapers;

import cole.driscoll.personal.repo.OrderInfo.OrderProduct;
import cole.driscoll.personal.repo.TypeIdentifier;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminOrderScraper extends AbsWebScraper {

  /**
   * Constructor which takes the WebDriver.
   *
   * @param driver - WebDriver
   */
  public AdminOrderScraper(WebDriver driver) {
    super(driver);
  }

  /**
   * Gets the list of products offered in the Loopie marketing web page.
   *
   * @return - List of products Loopie offers
   */
  public List<String> getProductList() {
    ArrayList<String> products = new ArrayList<>();
    List<WebElement> productTables = super.getDriver().findElements(By.tagName("table"));
    List<WebElement> tableProducts;
    for (int i = 0; i < productTables.size(); i++) {
      tableProducts = productTables.get(i).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
      for (int j = 0; j < tableProducts.size(); j++) {
        products.add(tableProducts.get(j).findElements(By.tagName("td")).get(0).getText());
      }
    }
    return products;
  }

//  /**
//   * Gets all the products ordered by a customer in a single order (quantity taken into account).
//   *
//   * @return - List of product instances
//   */
//  public List<AbsProduct> getOrderProducts() {
//    List<AbsProduct> bags = new ArrayList<>();
//    WebElement orderWebTable = super.getDriver().findElement(By.xpath("//*[@id=\"content\"]/main/div/div[2]/form/div[2]/div[2]/div/div/table/tbody"));
//    List<WebElement> rowTableElements = orderWebTable.findElements(By.tagName("tr"));
//    List<WebElement> columnTableElements;
//    int numBags;
//    TypeIdentifier identifier = new TypeIdentifier();
//    for(int i = 0; i < rowTableElements.size(); i++) {
//      columnTableElements = rowTableElements.get(i).findElements(By.tagName("td"));
//      if (columnTableElements.size() == 5) {
//        numBags = Integer.parseInt(columnTableElements.get(0).getText().substring(0, 1));
//        for (int j = 0; j < numBags; j++) {
//          bags.add(identifier.identifyProductType(
//              columnTableElements.get(1).findElement(By.tagName("strong")).getText()));
//        }
//      }
//    }
//    return bags;
//  }

  /**
   * Gets the product details of an admin order.
   * Used for JSON data conversion.
   *
   * @return - List of products ordered
   */
  public List<OrderProduct> getOrderProductDetails() {
    List<OrderProduct> orderProducts = new ArrayList<>();
    WebElement orderWebTable = super.getDriver().findElement(By.xpath("//*[@id=\"content\"]/main/div/div[2]/form/div[2]/div[2]/div/div/table/tbody"));
    List<WebElement> rowTableElements = orderWebTable.findElements(By.tagName("tr"));
    for(int i = 0; i < rowTableElements.size(); i++) {
      List<WebElement> columnTableElements = rowTableElements.get(i).findElements(By.tagName("td"));
      if (columnTableElements.size() == 5) {
        orderProducts.add(new OrderProduct(Integer.parseInt(columnTableElements.get(0).getText().substring(0, 1)),
            columnTableElements.get(1).findElement(By.tagName("strong")).getText(),
            Double.parseDouble(columnTableElements.get(3).getText().substring(1))));
      }
    }
    return orderProducts;
  }

  /**
   * Gets the total number of Loopie orders on the admin page.
   *
   * @return - Total number of admin orders
   */
  public String getTotalOrders() {
    return super.getDriver().findElement(By.xpath("//*[@id=\"zone{id}\"]/table/tbody/tr[1]/td[1]/a")).getText();
  }

  /**
   * Gets the internal notes for an admin order.
   *
   * @return - Internal notes
   */
  public String getInternalNotes() {
    return super.getDriver().findElement(By.xpath("//*[@id=\"customer_notes_span\"]")).getText();
  }

  /**
   * Gets the delivery notes for an admin order.
   *
   * @return - Delivery notes
   */
  public String getDeliveryNotes() {
    String notes = super.getDriver().findElement(By.xpath("//*[@id=\"content\"]/main/div/div[2]/div[3]/div[1]/p[2]")).getText();
    String regex = "\\s*\\bEdit\\b\\s*";
    notes = notes.replaceAll(regex, "");
    regex = "\\s*\\bDelivery Notes\\b\\s*";
    notes = notes.replaceAll(regex, "");
    return notes;
  }

  /**
   * Gets the order ID.
   *
   * @return - order ID
   */
  public String getId() {
    return getDriver().findElement(By.xpath("//*[@id=\"content\"]/main/div/div[2]/div[1]/div/p/span[2]")).getText();
  }

  /**
   * Gets the customer name.
   *
   * @return - customer name
   */
  public String getName() {
    return getDriver().findElement(By.xpath("//*[@id=\"content\"]/main/div/div[2]/div[2]/div/p/span[2]/a")).getText();
  }
}
