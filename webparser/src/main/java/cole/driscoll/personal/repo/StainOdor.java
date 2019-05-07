package cole.driscoll.personal.repo;

/**
 * Stain odor detergent product type.
 */
public class StainOdor extends AbsDetergent {

  /**
   * Base price of the product.
   */
  private final double price = 0.00;

  /**
   * If the product is lavender.
   */
  private boolean isLavender;

  /**
   * Constructor which identifies whether the detergent is lavender.
   *
   * @param isLavender - True if lavender.
   */
  public StainOdor(boolean isLavender) {
    this.isLavender = isLavender;
  }

  @Override
  public double getPrice() {
    if (this.isLavender) {
      return price + 1.79;
    }
    return price;
  }
}
