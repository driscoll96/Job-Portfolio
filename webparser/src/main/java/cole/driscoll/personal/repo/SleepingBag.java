package cole.driscoll.personal.repo;

/**
 * Sleeping bag product type.
 */
public class SleepingBag extends AbsSpecial {

  /**
   * Base Price of the product.
   */
  private final double price = 44.99;

  @Override
  public double getPrice() {
    return price;
  }

}
