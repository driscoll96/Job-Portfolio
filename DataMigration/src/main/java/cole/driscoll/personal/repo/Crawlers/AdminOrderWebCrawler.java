package cole.driscoll.personal.repo.Crawlers;

import org.openqa.selenium.WebDriver;

public class AdminOrderWebCrawler extends AbsAdminWebCrawler {

  /**
   * Constructor which fills the WebDriver.
   *
   * @param driver - WebDriver
   */
  public AdminOrderWebCrawler(WebDriver driver) {
    super(driver);
  }

  /**
   * Goes to the a order's information page using the order number based on its position in the
   * table (ascending top to bottom).
   */
  public void goToOrderspage() {
    super.getDriver().get("https://www.loopie.us/admin/orders.php");
  }

  /**
   * Goes to the orders page of the website.
   */
  public void goToOrderInfo(int orderNum) {
    super.getDriver().get("https://www.loopie.us/admin/orders.php?action=edit&id=" + orderNum);
  }

}
