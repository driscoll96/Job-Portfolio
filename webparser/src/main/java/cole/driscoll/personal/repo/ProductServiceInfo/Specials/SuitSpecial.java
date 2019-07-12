package cole.driscoll.personal.repo.ProductServiceInfo.Specials;

import cole.driscoll.personal.repo.ProductServiceInfo.ComfortersDryCleaning.AbsDryCleaning;
import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SuitSpecial)) {
      return false;
    }
    SuitSpecial that = (SuitSpecial) o;
    return Double.compare(that.getPrice(), getPrice()) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(price);
  }
}
