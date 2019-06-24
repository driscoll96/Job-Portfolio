package cole.driscoll.personal.repo.Scrapers;

import cole.driscoll.personal.repo.ProductServiceInfo.AbsProduct;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AirtableWebScraper extends AbsWebScraper {


  public AirtableWebScraper(WebDriver driver) {
    super(driver);
  }

  @Override
  public List<String> getProductList() {
    List<String> productList = new ArrayList<>();
    productList.add(super.getDriver().findElement(By.xpath("//*[@id=\"dataLeftPane\"]/div/div[2]/div[2]/div/div")).getText());
    List<WebElement> rows = super.getDriver().findElements(By.className("dataRow leftPane"));
    for (int i = 0; i < rows.size(); i++) {
      productList.add(rows.get(i).findElement(By.className("cell primary read")).getText());
    }
    return productList;
  }

  @Override
  public List<AbsProduct> getOrderProducts() {
    return null;
  }

  @Override
  public List<WebElement> getWebOrders() {
    return null;
  }

  @Override
  public List<WebElement> getCustomers() {
    return null;
  }

}
