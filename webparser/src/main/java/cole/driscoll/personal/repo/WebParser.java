package cole.driscoll.personal.repo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebParser extends AbsWebScraper {

  private CustomerPool pool;
  private List<WebElement> orders;

  public WebParser(WebDriver driver) {
    super(driver);
    List<WebElement> orders = super.getWebOrders();
  }

  public List<Order> convertWebOrders() throws ParseException {
    this.pool = new CustomerPool();
    List<Order> convertedOrders = new ArrayList<>();
    Order order;
    Date orderDate, delivery, pickUp;
    List<AbsBag> bags;
    for (int i = 0; i < orders.size(); i++) {
      List<String> orderInfo = Arrays.asList(orders.get(i).getText().split(" "));
      orderDate = new SimpleDateFormat("MM/dd/yyyy hh:mma").parse(orderInfo.get(1)+" "+orderInfo.get(3));
      delivery = new SimpleDateFormat("MM/dd/yyyy hh:mma").parse(orderInfo.get(6)+" "+orderInfo.get(8));
      pickUp = new SimpleDateFormat("MM/dd/yyyy hh:mma").parse(orderInfo.get(9)+" "+orderInfo.get(11));
      orders.get(0).click();
      super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      bags = super.getBagList(Integer.parseInt(orderInfo.get(0)));
      order = new Order(Integer.parseInt(orderInfo.get(0)), orderDate, pickUp, delivery,
          Double.parseDouble(orderInfo.get(14).substring(1)), bags, null);

    }
    return convertedOrders;
  }
}
