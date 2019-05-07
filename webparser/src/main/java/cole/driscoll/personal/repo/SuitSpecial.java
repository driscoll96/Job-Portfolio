package cole.driscoll.personal.repo;

/**
 * Suit special product type.
 */
public class SuitSpecial extends AbsDryCleaning {

  /**
   * Base Price of the product.
   */
  private final double price = 41.25;

  /**
   * Constructor which identifies whether the product is dry cleaned or not.
   *
   * @param isDownDryCleaned - True if dry cleaned.
   */
  public SuitSpecial(boolean isDownDryCleaned) {
    super(isDownDryCleaned);
  }

  @Override
  public double getPrice() {
    return price;
  }
}
