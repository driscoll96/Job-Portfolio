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
   * Maximizes the window of the WebDriver.
   */
  void maxWindow();
}
