package cole.driscoll.personal.repo;

import java.util.List;
import org.openqa.selenium.WebElement;

public interface IWebScraper {

  /**
   * Gets the list of products from website.
   *
   * @return - List of products.
   */
  List<String> getProductList();

  /**
   * Gets the list of products from the admin order page.
   *
   * @return - List of Products
   */
  List<AbsProduct> getOrderProducts();

  /**
   * Gets the raw admin web data.
   *
   * @return - List of the raw data
   */
  List<WebElement> getWebOrders();

}
