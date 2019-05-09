package cole.driscoll.personal.repo;

import java.util.Objects;

/**
 * Bedding product type.
 */
public class Bedding extends AbsSpecial {

  /**
   * Price of the bedding.
   */
  private final double price = 49.99;

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Bedding)) {
      return false;
    }
    Bedding bedding = (Bedding) o;
    return Double.compare(bedding.getPrice(), getPrice()) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(price);
  }
}
