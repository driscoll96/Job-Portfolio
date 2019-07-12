package cole.driscoll.personal.repo.ProductServiceInfo.ComfortersDryCleaning;

import java.util.Objects;

/**
 * Twin-Full comforter product type.
 */
public class ComforterTwinFull extends AbsComforter {

  /**
   * Base price of the product.
   */
  private final double price = 35.00;

  /**
   * Constructor which identifies whether it is down or not.
   *
   * @param down - True if down
   */
  public ComforterTwinFull(boolean down) {
    super(down);
  }

  @Override
  public double getPrice() {
    if (super.isDownDryCleaned()) {
      return price + priceIncrease;
    }
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ComforterTwinFull)) {
      return false;
    }
    ComforterTwinFull that = (ComforterTwinFull) o;
    return Double.compare(that.getPrice(), getPrice()) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPrice());
  }
}
