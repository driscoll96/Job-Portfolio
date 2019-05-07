package cole.driscoll.personal.repo;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Order info.
 */
public class Order implements IOrder {

  /**
   * ID number.
   */
  private int ID;

  /**
   * Order date.
   */
  private Date orderDate;

  /**
   * Pick up date.
   */
  private Date pickUp;

  /**
   * Delivery date.
   */
  private Date delivery;

  /**
   * Order amount.
   */
  private double orderAmount;

  /**
   * List of the order products.
   */
  private List<AbsProduct> productList;

  /**
   * Customer info.
   */
  private AbsCustomer customer;

  /**
   * Constructor which populates all of the property variables.
   *
   * @param ID - ID number
   * @param orderDate - Order date.
   * @param pickUp - Pick up date
   * @param delivery - Delivery date.
   * @param orderAmount - Order amount.
   * @param productList - List of the order products.
   * @param customer - Customer info.
   */
  public Order(int ID, Date orderDate, Date pickUp, Date delivery, double orderAmount,
      List<AbsProduct> productList, AbsCustomer customer) {
    this.ID = ID;
    this.orderDate = orderDate;
    this.pickUp = pickUp;
    this.delivery = delivery;
    this.orderAmount = orderAmount;
    this.productList = productList;
    this.customer = customer;
  }

  public int getID() {
    return ID;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public Date getPickUp() {
    return pickUp;
  }

  public Date getDelivery() {
    return delivery;
  }

  public double getOrderAmount() {
    return orderAmount;
  }

  public List<AbsProduct> getProductList() {
    return productList;
  }

  public AbsCustomer getCustomer() {
    return customer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Order)) {
      return false;
    }
    Order order = (Order) o;
    return ID == order.ID &&
        Double.compare(order.orderAmount, orderAmount) == 0 &&
        Objects.equals(orderDate, order.orderDate) &&
        Objects.equals(pickUp, order.pickUp) &&
        Objects.equals(delivery, order.delivery) &&
        Objects.equals(productList, order.productList) &&
        Objects.equals(customer, order.customer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, orderDate, pickUp, delivery, orderAmount, productList, customer);
  }
}
