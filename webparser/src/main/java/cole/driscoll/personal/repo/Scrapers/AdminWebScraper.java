package cole.driscoll.personal.repo.Scrapers;

import cole.driscoll.personal.repo.ProductServiceInfo.AbsProduct;
import cole.driscoll.personal.repo.TypeIdentifier;
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

  @Override
  public List<AbsProduct> getOrderProducts() {
    List<AbsProduct> bags = new ArrayList<>();
    WebElement orderWebTable = super.getDriver().findElement(By.xpath("//*[@id=\"content\"]/main/div/div[2]/form/div[2]/div[2]/div/div/table/tbody"));
    List<WebElement> rowTableElements = orderWebTable.findElements(By.tagName("tr"));
    List<WebElement> columnTableElements;
    int numBags;
    TypeIdentifier identifier = new TypeIdentifier();
    for(int i = 0; i < rowTableElements.size(); i++) {
      columnTableElements = rowTableElements.get(i).findElements(By.tagName("td"));
      if (columnTableElements.size() == 5) {
        numBags = Integer.parseInt(columnTableElements.get(0).getText().substring(0, 1));
        for (int j = 0; j < numBags; j++) {
          bags.add(identifier.identifyProductType(
              columnTableElements.get(1).findElement(By.tagName("strong")).getText()));
        }
      }
    }
    return bags;
  }

  @Override
  public List<WebElement> getWebOrders() {
    return super.getDriver().findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
  }

  @Override
  public List<WebElement> getCustomers() {
    return super.getDriver().findElement(By.tagName("tbody")).findElements(By.tagName("tr")).subList(0, 294);
  }

  /**
   * Gets the customer's first name from customer's info page.
   *
   * @return - Web Element which holds the email address
   */
  public String getFirstName() {
    return super.getDriver().findElement(By.xpath("//*[@id=\"customer_form\"]/div[2]/div[1]/div/input")).getAttribute("value");
  }

  /**
   * Gets the customer's last name from customer's info page.
   *
   * @return - Web Element which holds the email address
   */
  public String getLastName() {
    return super.getDriver().findElement(By.xpath("//*[@id=\"customer_form\"]/div[2]/div[2]/div/input")).getAttribute("value");
  }

  /**
   * Gets the customer's phone number from customer's info page.
   *
   * @return - Web Element which holds the email address
   */
  public String getPhoneNum() {
    return super.getDriver().findElement(By.xpath("//*[@id=\"customer_form\"]/div[4]/div[1]/div/input")).getAttribute("value");
  }

  /**
   * Gets the customer email from customer's info page.
   *
   * @return - Web Element which holds the email address
   */
  public String getCustomerEmail() {
    return super.getDriver().findElement(By.xpath("//*[@id=\"customer_form\"]/div[3]/div/div/input")).getAttribute("value");
  }

  /**
   * Gets the customer street address from customer's info page.
   *
   * @return - Web Element which holds the email address
   */
  public String getStreetAddress1() {
    return super.getDriver().findElement(By.xpath("//*[@id=\"customer_form\"]/div[6]/div[1]/div/input")).getAttribute("value");
  }

  /**
   * Gets the customer 2nd part of the street address from customer's info page.
   *
   * @return - Web Element which holds the email address
   */
  public String getStreetAddress2() {
    return super.getDriver().findElement(By.xpath("//*[@id=\"customer_form\"]/div[6]/div[2]/div/input")).getAttribute("value");
  }

  /**
   * Gets the customer city from customer's info page.
   *
   * @return - Web Element which holds the email address
   */
  public String getCity() {
    return super.getDriver().findElement(By.xpath("//*[@id=\"customer_form\"]/div[7]/div[2]/div/input")).getAttribute("value");
  }

  /**
   * Gets the zip code from the customer's info page.
   *
   * @return - Web Element which holds the zip code
   */
  public String getZip() {
    return super.getDriver().findElement(By.xpath("//*[@id=\"customer_form\"]/div[7]/div[1]/div/input")).getAttribute("value");
  }

  /**
   * Gets the state from the customer's info page.
   *
   * @return - Web Element which holds the state
   */
  public String getState() {
    return super.getDriver().findElement(By.xpath("//*[@id=\"customer_form\"]/div[8]/div/div/input")).getAttribute("value");
  }

  /**
   * Gets the total number of Loopie customers on the admin page.
   *
   * @return - Total number of admin customers
   */
  public String getTotalCustomers() {
    return super.getDriver().findElement(By.xpath("//*[@id=\"customers_table\"]/tbody/tr[1]/td[2]/a")).getText();
  }

}
