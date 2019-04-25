package cole.driscoll.personal.repo;

import java.util.Date;
import java.util.List;

public class Order implements IOrder {

  private int ID;
  private Date orderDate;
  private Date pickUp;
  private Date delivery;
  private float orderAmount;
  private List<AbsBag> bagList;


  public Order(int ID, Date orderDate, Date pickUp, Date delivery, float orderAmount,
      List<AbsBag> bagList) {
    this.ID = ID;
    this.orderDate = orderDate;
    this.pickUp = pickUp;
    this.delivery = delivery;
    this.orderAmount = orderAmount;
    this.bagList = bagList;
  }
}
