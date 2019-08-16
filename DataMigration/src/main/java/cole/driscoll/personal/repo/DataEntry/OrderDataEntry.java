package cole.driscoll.personal.repo.DataEntry;

/**
 * Functionality for entering data into an Airtable order's info page.
 *//*

public class OrderDataEntry extends AbsDataEntry {

  */
/**
   * Fills in the web crawler when an instance is made.
   *
   * @param crawler - Airtable web crawler
   *//*

  public OrderDataEntry(AirtableWebCrawler crawler) {
    super(crawler);
  }

  public void enterOrderInfo(Order order, int orderNum) {
    super.getCrawler().goToOrderInfo(orderNum);
    enterID(Integer.toString(order.getID()));

  }

  */
/**
   * Enters the order ID into the order's ID text box.
   *//*

  //TODO: figure out if this should be in a different encompassing class (probably)
  public void enterID(String ID) {
    super.getCrawler().getDriver().findElement(By.xpath("//*[@id=\"hyperbaseContainer\"]/div[20]/div[2]/div[2]"
        + "/div/div/div/div/div[2]/div[1]/div[2]/div/div/input")).sendKeys(ID);
  }

  @Override
  public void enterName(AbsCustomer customer, int orderNum) {
    super.getCrawler().goToOrderInfo(orderNum);
    boolean nameText = super.getCrawler().getDriver().findElement(By.cssSelector("#hyperbaseContainer "
        + "> div:nth-child(20) > div.dialog > div.detailViewWithActivityFeedBaseLeft > div > div > "
        + "div > div > div.top > div.labelCellPair.labelCellPairDetailCursor > div.cellContainer > "
        + "div > div > div > div.py1 > div > div.flex-auto.flex > div.flex-auto.p1 > div.flex-inline."
        + "col-12 > div > div")).isDisplayed();
    if (nameText) {
      return;
    }
    super.getCrawler().getDriver().findElement(By.cssSelector("#hyperbaseContainer > div:nth-child(20) "
        + "> div.dialog > div.detailViewWithActivityFeedBaseLeft > div > div > div > div > div.top > "
        + "div.labelCellPair.labelCellPairDetailCursor > div.cellContainer > div > div > div > div")).click();
    super.getCrawler().getDriver().findElement(By.cssSelector("#hyperbaseContainer > div:nth-child(21) "
        + "> div > div > div:nth-child(1) > div > label > input")).sendKeys(customer.getFullName());
    String noMatchText = super.getCrawler().getDriver().findElement(By.cssSelector("#hyperbaseContainer > div:nth-child(21) "
        + "> div > div > div.overflow-auto.relative > div > div.center.quiet.p3.absolute.top-0.left-"
        + "0.right-0")).getText();
    // If the customer attached to the order does not exist already in Airtable
    if (noMatchText.equals("No matching records.")) {
      new CustomerDataEntry(super.getCrawler()).CreateNewCustomer(customer);
    }
  }

  // Do not need
  */
/*public void enterPhoneNum(String phone, int orderNum) {
    super.getCrawler().goToOrderInfo(orderNum);
    WebElement phoneInputBox = super.getCrawler().getDriver().findElements(By.className("labelCellPair")).get(2);
    phoneInputBox.click();
    phoneInputBox.findElement(By.tagName("input")).sendKeys(phone);
  }*//*


}
*/
