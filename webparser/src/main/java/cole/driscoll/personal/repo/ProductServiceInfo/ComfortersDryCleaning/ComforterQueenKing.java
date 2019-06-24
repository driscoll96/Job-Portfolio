package cole.driscoll.personal.repo.ProductServiceInfo.ComfortersDryCleaning;

import java.util.Objects;

/**
 * The Queen-King comforter product type.
 */
public class ComforterQueenKing extends AbsComforter {

  /**
   * Base of the product
   */
  private final double price = 40.00;

  /**
   * Constructor which identifies whether it is down or not.
   *
   * @param down - True if down
   */
  public ComforterQueenKing(boolean down) {
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
    if (!(o instanceof ComforterQueenKing)) {
      return false;
    }
    ComforterQueenKing that = (ComforterQueenKing) o;
    return Double.compare(getPrice(), that.getPrice()) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPrice());
  }
}
