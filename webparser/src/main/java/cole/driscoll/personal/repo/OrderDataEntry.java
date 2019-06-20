package cole.driscoll.personal.repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Functionality for entering data into an Airtable order's info page.
 */
public class OrderDataEntry extends AbsDataEntry {

  /**
   * Fills in the web crawler when an instance is made.
   *
   * @param crawler - Airtable web crawler
   */
  public OrderDataEntry(AirtableWebCrawler crawler) {
    super(crawler);
  }

  public void enterOrderInfo(Order order, int orderNum) {
    super.getCrawler().goToOrderInfo(orderNum);
    enterID(Integer.toString(order.getID()));

  }

  /**
   * Enters the order ID into the order's ID text box.
   */
  //TODO: figure out if this should be in a different encompassing class (probably)
  public void enterID(String ID) {
    super.getCrawler().getDriver().findElement(By.xpath("//*[@id=\"hyperbaseContainer\"]/div[20]/div[2]/div[2]"
        + "/div/div/div/div/div[2]/div[1]/div[2]/div/div/input")).sendKeys(ID);
  }

  @Override
  public void enterName(String name, int orderNum) {
    super.getCrawler().goToOrderInfo(orderNum);
    // Go to customer page if the customer does not already exist
  }

  // Do not need
  /*public void enterPhoneNum(String phone, int orderNum) {
    super.getCrawler().goToOrderInfo(orderNum);
    WebElement phoneInputBox = super.getCrawler().getDriver().findElements(By.className("labelCellPair")).get(2);
    phoneInputBox.click();
    phoneInputBox.findElement(By.tagName("input")).sendKeys(phone);
  }*/

}
