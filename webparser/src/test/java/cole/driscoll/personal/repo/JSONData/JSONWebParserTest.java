package cole.driscoll.personal.repo.JSONData;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSONWebParserTest {

  private WebDriver driver;
  private JSONWebParser parser;

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\User\\OneDrive\\Job App Stuff\\chromedriver_win32 (1)\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    parser = new JSONWebParser(driver);
  }

  @Test
  public void getJSONCustomerData() {
    parser.getCrawler().signIn();
    List<String> customers = parser.getJSONCustomerData(327);
    for (String customer : customers) {
      System.out.println(customer);
    }
  }
}