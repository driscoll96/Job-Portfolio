package cole.driscoll.personal.repo;

import java.util.Objects;

/**
 * Shirt/Blouse product type.
 */
public class ShirtBlouse extends AbsDryCleaning {

  /**
   * Base Price of the product.
   */
  private final double price = 8.99;

  /**
   * Constructor which identifies whether the product is dry cleaned or not.
   *
   * @param isDownDryCleaned - True if dry cleaned.
   */
  public ShirtBlouse(boolean isDownDryCleaned) {
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
    if (!(o instanceof ShirtBlouse)) {
      return false;
    }
    ShirtBlouse that = (ShirtBlouse) o;
    return Double.compare(that.getPrice(), getPrice()) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(price);
  }
}
