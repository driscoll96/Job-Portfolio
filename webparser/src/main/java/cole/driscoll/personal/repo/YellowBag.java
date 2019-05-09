package cole.driscoll.personal.repo;

import java.util.Objects;

/**
 * Yellow bag product type.
 */
public class YellowBag extends AbsBag {

  /**
   * Base Price of the product.
   */
  private final double price = 4.99;

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof YellowBag)) {
      return false;
    }
    YellowBag yellowBag = (YellowBag) o;
    return Double.compare(yellowBag.price, price) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(price);
  }
}
