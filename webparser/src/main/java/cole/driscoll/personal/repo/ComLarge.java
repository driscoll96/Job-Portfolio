package cole.driscoll.personal.repo;

import java.util.Objects;

/**
 * Commercial large bag product type.
 */
public class ComLarge extends AbsCommercialBag {

  /**
   * Base price of the product
   */
  private final double price = 73.99;

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ComLarge)) {
      return false;
    }
    ComLarge comLarge = (ComLarge) o;
    return Double.compare(comLarge.price, price) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(price);
  }
}
