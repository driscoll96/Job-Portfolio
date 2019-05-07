package cole.driscoll.personal.repo;

/**
 * Yellow bag product type.
 */
public class YellowBag extends AbsBag {

  /**
   * Base Price of the product.
   */
  private final double price = 4.99;

  @Override
  public double getPrice() {
    return price;
  }
}
