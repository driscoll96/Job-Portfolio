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
   * Gets the raw admin order data.
   *
   * @return - List of Web Elements containing order data
   */
  List<WebElement> getWebOrders();

  /**
   * Gets the raw admin customer data.
   *
   * @return - List of Web Elements containing customer info
   */
  List<WebElement> getCustomers();

}
