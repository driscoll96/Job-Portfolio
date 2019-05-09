package cole.driscoll.personal.repo;

import java.util.Objects;

/**
 * Commercial regular bag product type.
 */
public class ComRegular extends AbsCommercialBag {

  /**
   * Base price of the product.
   */
  private final double price = 44.99;

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ComRegular)) {
      return false;
    }
    ComRegular that = (ComRegular) o;
    return Double.compare(that.getPrice(), getPrice()) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(price);
  }
}
