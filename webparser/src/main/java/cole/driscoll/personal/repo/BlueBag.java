package cole.driscoll.personal.repo;

import java.util.Objects;

/**
 * Blue bag product type.
 */
public class BlueBag extends AbsBag {

  /**
   * Base price of product.
   */
  private final double price = 7.99;

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BlueBag)) {
      return false;
    }
    BlueBag blueBag = (BlueBag) o;
    return Double.compare(blueBag.price, price) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(price);
  }
}
