package cole.driscoll.personal.repo.ProductServiceInfo.ComfortersDryCleaning;

import java.util.Objects;

/**
 * Pant/Skirt/Sweater/Jean product type.
 */
public class PantSkirtSweaterJean extends AbsDryCleaning {

  /**
   * Base Price of the product.
   */
  private final double price = 14.99;

  /**
   * Constructor which identifies whether the product is dry cleaned or not.
   *
   * @param isDownDryCleaned - True if dry cleaned.
   */
  public PantSkirtSweaterJean(boolean isDownDryCleaned) {
    super(isDownDryCleaned);
  }

  @Override
  public double getPrice() {
    if (super.isDownDryCleaned()) {
      return price + priceIncrease;
    }
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PantSkirtSweaterJean)) {
      return false;
    }
    PantSkirtSweaterJean that = (PantSkirtSweaterJean) o;
    return Double.compare(that.getPrice(), getPrice()) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPrice());
  }
}
