package cole.driscoll.personal.repo;

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
}
