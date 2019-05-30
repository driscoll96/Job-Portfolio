package cole.driscoll.personal.repo;

import java.util.Objects;

/**
 * Yellow bag product type.
 */
public class DuffelBag extends AbsBag {

  /**
   * Base Price of the product.
   */
  private final double price = 12.99;

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DuffelBag)) {
      return false;
    }
    DuffelBag yellowBag = (DuffelBag) o;
    return Double.compare(yellowBag.price, price) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(price);
  }
}
