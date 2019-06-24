package cole.driscoll.personal.repo.Crawlers;

public interface IWebCrawler {

  /**
   * Goes to the product page of either the Admin or Airtable page.
   */
  void goToProductPage();

  /**
   * Signs into the website.
   */
  void signIn();

  /**
   * Goes to the orders page of the website.
   */
  void goToOrderspage();

  /**
   * Maximizes the window of the WebDriver.
   */
  void maxWindow();

  /**
   * Goes to the a order's information page using the order number based on its position in the
   * table (ascending top to bottom).
   *
   * @param orderNum - The order number
   */
  void goToOrderInfo(int orderNum);
}
