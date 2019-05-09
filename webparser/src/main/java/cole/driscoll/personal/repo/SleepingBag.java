package cole.driscoll.personal.repo;

import java.util.Objects;

/**
 * Sleeping bag product type.
 */
public class SleepingBag extends AbsSpecial {

  /**
   * Base Price of the product.
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
    if (!(o instanceof SleepingBag)) {
      return false;
    }
    SleepingBag that = (SleepingBag) o;
    return Double.compare(that.getPrice(), getPrice()) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(price);
  }
}
