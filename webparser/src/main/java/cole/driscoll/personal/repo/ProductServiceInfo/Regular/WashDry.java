package cole.driscoll.personal.repo.ProductServiceInfo.Regular;

import cole.driscoll.personal.repo.ProductServiceInfo.Bags.AbsNonCommercialBag;
import java.util.Objects;

/**
 * Wash and dry product type.
 */
public class WashDry extends AbsNonCommercialBag {

  /**
   * Base Price of the product.
   */
  private final double price = 24.99;

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof WashDry)) {
      return false;
    }
    WashDry washDry = (WashDry) o;
    return Double.compare(washDry.getPrice(), getPrice()) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(price);
  }
}
