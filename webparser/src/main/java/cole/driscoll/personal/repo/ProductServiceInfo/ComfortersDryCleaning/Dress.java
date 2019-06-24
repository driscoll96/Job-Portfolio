package cole.driscoll.personal.repo.ProductServiceInfo.ComfortersDryCleaning;

import java.util.Objects;

/**
 * Dress product type.
 */
public class Dress extends AbsDryCleaning {

  /**
   * Base price of the product.
   */
  private final double price = 19.99;

  /**
   * Constructor which identifies whether the product is dry cleaned or not.
   *
   * @param isDownDryCleaned - True if dry cleaned.
   */
  public Dress(boolean isDownDryCleaned) {
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
    if (!(o instanceof Dress)) {
      return false;
    }
    Dress dress = (Dress) o;
    return Double.compare(dress.getPrice(), getPrice()) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPrice());
  }
}
