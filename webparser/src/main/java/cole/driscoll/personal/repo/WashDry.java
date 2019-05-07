package cole.driscoll.personal.repo;

/**
 * Wash and dry product type.
 */
public class WashDry extends AbsNonCommercialBag {

  /**
   * Base Price of the product.
   */
  private final double price = 24.99;

  @Override
  public double getPrice() {
    return price;
  }
}
