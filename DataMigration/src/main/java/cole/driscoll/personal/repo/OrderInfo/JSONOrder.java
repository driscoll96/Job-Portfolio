package cole.driscoll.personal.repo.OrderInfo;

import cole.driscoll.personal.repo.OrderInfo.OrderProduct;
import java.util.List;

/**
 * Order information scraped from the Loopie Admin website to be converted into JSON.
 */
public class JSONOrder {

  /**
   * Order ID.
   */
  private String orderId;

  /**
   * Name of the customer who ordered.
   */
  private String name;

  /**
   * List of products ordered.
   */
  private List<OrderProduct> products;

  /**
   * Internal notes on the customer.
   */
  private String internalNotes;

  /**
   * Delivery notes.
   */
  private String deliveryNotes;

  /**
   * Fills every field variable with given variables.
   *
   * @param orderId - Order ID
   * @param name - Name of the customer who ordered
   * @param products - List of products ordered
   * @param internalNotes - Internal notes on the customer
   * @param deliveryNotes - Delivery notes
   */
  public JSONOrder(String orderId, String name, List<OrderProduct> products,
      String internalNotes, String deliveryNotes) {
    this.orderId = orderId;
    this.name = name;
    this.products = products;
    this.internalNotes = internalNotes;
    this.deliveryNotes = deliveryNotes;
  }

  public String getOrderId() {
    return orderId;
  }

  public String getName() {
    return name;
  }

  public List<OrderProduct> getProducts() {
    return products;
  }

  public String getInternalNotes() {
    return internalNotes;
  }

  public String getDeliveryNotes() {
    return deliveryNotes;
  }
}
