package cole.driscoll.personal.repo.ProductServiceInfo.Detergent;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof StainOdor)) {
      return false;
    }
    StainOdor stainOdor = (StainOdor) o;
    return Double.compare(stainOdor.getPrice(), getPrice()) == 0 &&
        isLavender == stainOdor.isLavender;
  }

  @Override
  public int hashCode() {
    return Objects.hash(price, isLavender);
  }
}
