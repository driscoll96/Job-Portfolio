package cole.driscoll.personal.repo.JSONData;

/**
 * Product information scraped from the Loopie Admin website.
 */
public class ProductRaw {

  /**
   * The quantity added to cart.
   */
  private int quantity;

  /**
   * The price of a single product.
   */
  private int price;

  /**
   * The name of the product.
   */
  private String name;

  /**
   * Constructor which populates field variables.
   *
   * @param quantity - The quantity added to cart
   * @param price - The price of a single product
   * @param name - The name of the product
   */
  public ProductRaw(int quantity, int price, String name) {
    this.quantity = quantity;
    this.price = price;
    this.name = name;
  }

  public int getQuantity() {
    return quantity;
  }

  public int getPrice() {
    return price;
  }

  public String getName() {
    return name;
  }
}
