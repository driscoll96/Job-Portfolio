package cole.driscoll.personal.repo;

import java.util.Objects;

/**
 * Donation product type.
 */
public class Donation extends AbsSpecial {

  /**
   * Base Price of the product.
   */
  private final double price = 0.00;

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Donation)) {
      return false;
    }
    Donation donation = (Donation) o;
    return Double.compare(donation.price, price) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(price);
  }
}
