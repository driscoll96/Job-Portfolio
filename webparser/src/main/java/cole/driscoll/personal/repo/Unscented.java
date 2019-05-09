package cole.driscoll.personal.repo;

import java.util.Objects;

/**
 * Unscented detergent product type.
 */
public class Unscented extends AbsDetergent {

  /**
   * Base Price of the product.
   */
  private final double price = 1.29;

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Unscented)) {
      return false;
    }
    Unscented unscented = (Unscented) o;
    return Double.compare(unscented.getPrice(), getPrice()) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(price);
  }
}
