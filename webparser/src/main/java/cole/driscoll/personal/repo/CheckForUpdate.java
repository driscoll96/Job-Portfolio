package cole.driscoll.personal.repo;

import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckForUpdate extends AbsWebScraper {

  public CheckForUpdate(WebDriver driver) {
    super(driver);
  }

  public boolean sameProducts() {
    try {
      getDriver().findElement(By.xpath("//*[@id=\"content\"]/main/div/div[1]/div/div[1]/form/div/span/button")).click();
      getDriver().findElement(By.xpath("/html/body/div/nav/div/ul/li[3]/a")).click();
      getDriver().findElement(By.xpath("//*[@id=\"zip\"]")).sendKeys("98103");
      getDriver().findElement(By.xpath("//*[@id=\"zip_button\"]")).click();
      List<String> products = super.getProductList();
      // Need to figure out a way to get current products (maybe go to airtables)
    } catch (NoSuchElementException e) {
      System.out.println("Program terminated. Please make sure you are logged out of your Loopie "
          + "customer account before loading the program");
      getDriver().close();
      System.exit(1);
    }
    return false;
  }

}
