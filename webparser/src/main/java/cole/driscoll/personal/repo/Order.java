package cole.driscoll.personal.repo;

import java.util.Date;
import java.util.List;

public class Order implements IOrder {

  private int ID;
  private Date orderDate;
  private Date pickUp;
  private Date delivery;
  private double orderAmount;
  private List<AbsBag> bagList;
  private AbsCustomer customer;


  public Order(int ID, Date orderDate, Date pickUp, Date delivery, double orderAmount,
      List<AbsBag> bagList, AbsCustomer customer) {
    this.ID = ID;
    this.orderDate = orderDate;
    this.pickUp = pickUp;
    this.delivery = delivery;
    this.orderAmount = orderAmount;
    this.bagList = bagList;
    this.customer = customer;
  }
}
