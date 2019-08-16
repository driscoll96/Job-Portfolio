package cole.driscoll.personal.repo.Scrapers;

import static org.junit.Assert.*;

import cole.driscoll.personal.repo.Crawlers.AbsAdminWebCrawler;
import cole.driscoll.personal.repo.Crawlers.AdminCustomerWebCrawler;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminCustomerScraperTest {

  private AdminCustomerScraper scraper;
  private WebDriver driver;
  private AdminCustomerWebCrawler crawler;


  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\User\\OneDrive\\Job App Stuff\\chromedriver_win32 (1)\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    scraper = new AdminCustomerScraper(driver);
    crawler = new AdminCustomerWebCrawler(driver);
  }

  @Test
  public void getCustomers() throws InterruptedException {
    crawler.signIn();
    driver.get("https://www.loopie.us/admin/statistics.php?date_start=03%2F01%2F2018&date_end=06%2F09%2F2019&zip_code=");
    int numCustomers = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"content\"]/main/div"
        + "[1]/div[3]/div/table/tbody/tr[3]/td[2]/a")).getText());
    crawler.goToCustomerPage();
    List<WebElement> customers = scraper.getCustomers();
    assertEquals(customers.size(), numCustomers-17);
  }

  @Test
  public void getCustomerEmail() throws InterruptedException {
    crawler.goToCustomerPage();
    List<WebElement> customers = scraper.getCustomers();
    List<String> emails = new ArrayList<>();
    List<String> emailsActual = new ArrayList<>();
    emailsActual.add("fredroth1967@gmail.com");
    emailsActual.add("woletzbf@gmail.com");
    emailsActual.add("mincinmj@whitman.edu");
    emailsActual.add("washington08@hotmail.com");
    emailsActual.add("johnnyboygomes@gmail.com");
    emailsActual.add("tamarindpdx@gmail.com");
    emailsActual.add("Jeremy.gustavel@gmail.com");
    emailsActual.add("evangraj@gmail.com");
    emailsActual.add("ebchill@gmail.com");
    emailsActual.add("riley.hillis@colorado.edu");
    emailsActual.add("sepi.sadeghi@gmail.com");
    for (int i = 0; i < 10; i++) {
      crawler.goToCustomerInfo(customers.size()-i-1);
      emails.add(scraper.getCustomerEmail());
    }
    assertEquals(emails, emailsActual);
  }

  @Test
  public void getTotalCustomers() {
    crawler.signIn();
    driver.get("https://www.loopie.us/admin/statistics.php?date_start=11%2F01%2F2017&date_end=06%2F24%2F2019&zip_code=");
    String total = driver.findElement(By.xpath("//*[@id=\"content\"]/main/div[1]/div[3]/div/table/tbody/tr[3]/td[2]/a")).getText();
    crawler.goToCustomerPage();
    assertEquals(total, scraper.getTotalCustomers());
  }

  //TODO:
  @Test
  public void getZip() {
    crawler.signIn();
    ArrayList<String> listActual = new ArrayList<>();
    listActual.add("98146");
    listActual.add("98146");
    listActual.add("98121");
    listActual.add("98121");
    listActual.add("98107");
    listActual.add("98121");
    listActual.add("98104");
    listActual.add("98104");
    listActual.add("98105");
    listActual.add("98102");
    ArrayList<String> list = new ArrayList<>();
    for (int i = 326; i < 336; i++) {
      crawler.goToCustomerInfo(i);
      list.add(scraper.getZip());
    }
    assertEquals(list, listActual);
  }

  @Test
  public void getState() {
    crawler.signIn();
    ArrayList<String> listActual = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    listActual.add("WA");
    listActual.add("WA");
    listActual.add("WA");
    listActual.add("WA");
    listActual.add("WA");
    listActual.add("WA");
    listActual.add("WA");
    listActual.add("Washington");
    listActual.add("WA");
    listActual.add("WA");
    for (int i = 326; i < 336; i++) {
      crawler.goToCustomerInfo(i);
      list.add(scraper.getState());
    }
    assertEquals(list, listActual);
  }

  @Test
  public void getFirstName() {
    crawler.signIn();
    ArrayList<String> listActual = new ArrayList<>();
    listActual.add("Erin");
    listActual.add("Jeffery ");
    listActual.add("Eric");
    listActual.add("Luke");
    listActual.add("Amanda");
    listActual.add("James");
    listActual.add("Scott");
    listActual.add("Shane");
    listActual.add("Emma");
    listActual.add("Rajeev");
    ArrayList<String> list = new ArrayList<>();
    for (int i = 326; i < 336; i++) {
      crawler.goToCustomerInfo(i);
      list.add(scraper.getFirstName());
    }
    assertEquals(list, listActual);
  }

  @Test
  public void getLastName() {
    crawler.signIn();
    ArrayList<String> listActual = new ArrayList<>();
    listActual.add("Riggers");
    listActual.add("Baird");
    listActual.add("Lyon");
    listActual.add("Murdock");
    listActual.add("Stoker");
    listActual.add("Powers");
    listActual.add("Kirchhoff");
    listActual.add("Fantauzzo");
    listActual.add("Chaput");
    listActual.add("Sen");
    ArrayList<String> list = new ArrayList<>();
    for (int i = 326; i < 336; i++) {
      crawler.goToCustomerInfo(i);
      list.add(scraper.getLastName());
    }
    assertEquals(list, listActual);
  }

  @Test
  public void getPhoneNum() {
    crawler.signIn();
    ArrayList<String> listActual = new ArrayList<>();
    listActual.add("4253262109");
    listActual.add("2063272390");
    listActual.add("(208) 342-0259");
    listActual.add("(208) 991-6745");
    listActual.add("2066608782");
    listActual.add("(503) 961-5390");
    listActual.add("17067991234");
    listActual.add("410-292-0581");
    listActual.add("(206) 992-8544");
    listActual.add("(914) 319-0303");
    ArrayList<String> list = new ArrayList<>();
    for (int i = 326; i < 336; i++) {
      crawler.goToCustomerInfo(i);
      list.add(scraper.getPhoneNum());
    }
    assertEquals(list, listActual);
  }

  @Test
  public void getCustomerEmail1() {
    crawler.signIn();
    ArrayList<String> listActual = new ArrayList<>();
    listActual.add("erinriggers@gmail.com");
    listActual.add("emailforta@gmail.com");
    listActual.add("superpants97@gmail.com");
    listActual.add("lukeanthonymurdock1@gmail.com");
    listActual.add("dailyyomo@gmail.com");
    listActual.add("jhpowersmd@mac.com");
    listActual.add("erin.kirchhoff@yahoo.com");
    listActual.add("sfantauzzo@brassica.com");
    listActual.add("chammie107@comcast.net");
    listActual.add("rajeevdebsen@gmail.com");
    ArrayList<String> list = new ArrayList<>();
    for (int i = 326; i < 336; i++) {
      crawler.goToCustomerInfo(i);
      list.add(scraper.getCustomerEmail());
    }
    assertEquals(list, listActual);
  }

  @Test
  public void getStreetAddress1() {
    crawler.signIn();
    ArrayList<String> listActual = new ArrayList<>();
    listActual.add("1019 Southwest 114th Street");
    listActual.add("10230 10th ave sw");
    listActual.add("2312 3rd Avenue");
    listActual.add("2312 3rd Avenue");
    listActual.add("1417 Northwest 54th Street");
    listActual.add("2000 4th Avenue");
    listActual.add("700 3rd Avenue");
    listActual.add("515 Madison St");
    listActual.add("4225 11th Avenue Northeast");
    listActual.add("435 Summit Avenue East");
    ArrayList<String> list = new ArrayList<>();
    for (int i = 326; i < 336; i++) {
      crawler.goToCustomerInfo(i);
      list.add(scraper.getStreetAddress1());
    }
    assertEquals(list, listActual);
  }

  @Test
  public void getStreetAddress2() {
    crawler.signIn();
    ArrayList<String> listActual = new ArrayList<>();
    listActual.add("");
    listActual.add("");
    listActual.add("430");
    listActual.add("430");
    listActual.add("424");
    listActual.add("510");
    listActual.add("");
    listActual.add("Room 2026");
    listActual.add("Apt 207");
    listActual.add("Apt 402");
    ArrayList<String> list = new ArrayList<>();
    for (int i = 326; i < 336; i++) {
      crawler.goToCustomerInfo(i);
      list.add(scraper.getStreetAddress2());
    }
    assertEquals(list, listActual);
  }

  @Test
  public void getCity() {
    crawler.signIn();
    ArrayList<String> listActual = new ArrayList<>();
    listActual.add("Seattle");
    listActual.add("Seattle");
    listActual.add("Seattle");
    listActual.add("Seattle");
    listActual.add("Seattle");
    listActual.add("Seattle");
    listActual.add("Seattle");
    listActual.add("Seattle ");
    listActual.add("Seattle");
    listActual.add("Seattle");
    ArrayList<String> list = new ArrayList<>();
    for (int i = 326; i < 336; i++) {
      crawler.goToCustomerInfo(i);
      list.add(scraper.getCity());
    }
    assertEquals(list, listActual);
  }
}