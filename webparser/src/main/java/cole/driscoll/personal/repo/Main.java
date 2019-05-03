package cole.driscoll.personal.repo;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

  public static void main(String[] args) throws ParseException {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Job App Stuff\\chromedriver_win32 (1)\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    final String url = "https://www.loopie.us/admin/login.php";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get(url);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    CheckForUpdate check = new CheckForUpdate(driver);
    if (!check.sameProducts()) {
      System.out.println("There has been updates to products types on the admin page. Contact "
          + "coledriscoll@gmail.com to request an update to this program. Program Terminated");
      driver.close();
      System.exit(1);
    }
    driver.findElement(By.name("p_username")).sendKeys("Admin");
    driver.findElement(By.name("p_password")).sendKeys("admin456");
    driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[3]/button")).click();
    driver.findElement(By.xpath("//*[@id=\"content\"]/main/aside/div[2]/ul/li[3]/a")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebElement dateStart = driver.findElement(By.name("date_start"));
    dateStart.clear();
    dateStart.sendKeys("07/01/2018");
    driver.findElement(By.xpath("//*[@id=\"content\"]/main/div/div[2]/form/div[9]/button")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebParser parser = new WebParser(driver);
    List<Order> convertedOrders = parser.convertWebOrders();


  }

}
