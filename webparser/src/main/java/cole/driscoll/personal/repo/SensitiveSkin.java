package cole.driscoll.personal.repo;

import java.util.Objects;

/**
 * Sensitive skin detergent type.
 */
public class SensitiveSkin extends AbsDetergent {

  /**
   * Base Price of the product.
   */
  private final double price = 1.79;

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SensitiveSkin)) {
      return false;
    }
    SensitiveSkin that = (SensitiveSkin) o;
    return Double.compare(that.getPrice(), getPrice()) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(price);
  }
}
