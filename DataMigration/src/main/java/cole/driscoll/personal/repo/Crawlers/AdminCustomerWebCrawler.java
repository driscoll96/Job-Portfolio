package cole.driscoll.personal.repo.Crawlers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Web crawler for the Loopie admin page.
 */
public class AdminCustomerWebCrawler extends AbsAdminWebCrawler {

  /**
   * Constructor which fills the WebDriver.
   *
   * @param driver - WebDriver
   */
  public AdminCustomerWebCrawler(WebDriver driver) {
    super(driver);
  }

  /**
   * Goes to the Loopie admin customer page.
   */
  public void goToCustomerPage() {
    getDriver().get("https://www.loopie.us/admin/customers.php");
    super.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
  }

  /**
   * Navigates to a customers top order summary.
   *
   * @param totalSpentLink - Link to navigate to the customers orders
   */
  public void goToCustomersTopOrderSummary(WebElement totalSpentLink) {
    totalSpentLink.click();
    super.getDriver().findElement(By.xpath("//*[@id=\"zone{id}\"]/table/tbody/tr/td[1]/a")).click();
  }

  /**
   * Goes to the a customer's information page using a customer number based on its position in the
   * table (ascending top to bottom).
   *
   * @param customerNum - Position in the table (ascending top to bottom)
   */
  public void goToCustomerInfo(int customerNum) {
    super.getDriver().get("https://www.loopie.us/admin/customers.php?action=edit&id="+customerNum);
  }
}

