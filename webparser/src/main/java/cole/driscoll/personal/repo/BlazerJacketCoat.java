package cole.driscoll.personal.repo;

import java.util.Objects;

/**
 * Blazer/Jacket/Coat product type.
 */
public class BlazerJacketCoat extends AbsDryCleaning {

  /**
   * Base price of the product.
   */
  private final double price = 17.99;

  public BlazerJacketCoat(boolean isDownDryCleaned) {
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
    if (!(o instanceof BlazerJacketCoat)) {
      return false;
    }
    BlazerJacketCoat that = (BlazerJacketCoat) o;
    return Double.compare(that.price, price) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPrice());
  }
}
