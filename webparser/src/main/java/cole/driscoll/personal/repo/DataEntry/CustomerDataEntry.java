package cole.driscoll.personal.repo.DataEntry;

import cole.driscoll.personal.repo.Crawlers.AirtableWebCrawler;
import cole.driscoll.personal.repo.CustomerInfo.AbsCustomer;
import org.openqa.selenium.By;

public class CustomerDataEntry extends AbsDataEntry {

  /**
   * Fills in the web crawler when an instance is made.
   *
   * @param crawler - Airtable web crawler
   */
  public CustomerDataEntry(AirtableWebCrawler crawler) {
    super(crawler);
  }

  public void CreateNewCustomer(AbsCustomer customer) {
    super.getCrawler().getDriver().findElement(By.xpath("//*[@id=\"hyperbaseContainer\"]/div[21]/div/div/div[3]/div/div/div")).click();

  }

  public void enterPhoneNum(String phone, int entityNum) {

  }

  @Override
  public void enterName(AbsCustomer customer, int entityNum) {

  }
}
