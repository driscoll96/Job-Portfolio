package cole.driscoll.personal.repo;

/**
 * Unscented detergent product type.
 */
public class Unscented extends AbsDetergent {

  /**
   * Base Price of the product.
   */
  private final double price = 1.29;

  @Override
  public double getPrice() {
    return price;
  }
}
