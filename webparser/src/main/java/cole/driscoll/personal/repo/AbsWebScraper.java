package cole.driscoll.personal.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbsWebScraper {

  private WebDriver driver;

  public AbsWebScraper(WebDriver driver) {
    this.driver = driver;
  }

  public List<WebElement> getWebOrders() {
    return driver.findElements(By.tagName("tr"));
  }

  public List<AbsProduct> getBagList() {
    List<AbsProduct> bags = null;
    WebElement orderWebTable = driver.findElement(By.xpath("//*[@id=\"content\"]/main/div/div[2]/form/div[2]/div[2]/div/div/table/tbody/tr"));
    List<WebElement> rowTableElements = orderWebTable.findElements(By.tagName("tr"));
    List<WebElement> columnTableElements;
    int numBags;
    TypeIdentifier identifier = new TypeIdentifier();
    for(int i = 0; i < rowTableElements.size(); i++) {
      columnTableElements = rowTableElements.get(i).findElements(By.tagName("td"));
      numBags = Integer.parseInt(columnTableElements.get(0).getText());
      bags.add(identifier.identifyBagType(columnTableElements.get(1).getText()));
    }
    driver.navigate().back();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return bags;
  }

  public List<String> getProductList() {
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