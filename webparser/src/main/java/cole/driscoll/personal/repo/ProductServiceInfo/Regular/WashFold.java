package cole.driscoll.personal.repo.ProductServiceInfo.Regular;

import cole.driscoll.personal.repo.ProductServiceInfo.Bags.AbsNonCommercialBag;
import java.util.Objects;

/**
 * Wash and Fold product type.
 */
public class WashFold extends AbsNonCommercialBag {

  /**
   * Base Price of the Product.
   */
  private final double price = 29.99;

  /**
   * True if customer did delivery and pickup.
   */
  private boolean notDelivered;

  /**
   * True if ordered by a hotel.
   */
  private boolean orderedByHotel;

  /**
   * Constructor that tells if customer did delivery and pickup.
   *
   * @param discount - True if customer gets discount
   */
  public WashFold(boolean discount, boolean orderedByHotel) {
    this.notDelivered = discount;
    this.orderedByHotel = orderedByHotel;
  }

  @Override
  public double getPrice() {
    if (notDelivered) {
      return price - 5.00;
    }
    if (orderedByHotel) {
      return price + 10.00;
    }
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof WashFold)) {
      return false;
    }
    WashFold washFold = (WashFold) o;
    return Double.compare(washFold.getPrice(), getPrice()) == 0 &&
        notDelivered == washFold.notDelivered;
  }

  @Override
  public int hashCode() {
    return Objects.hash(price, notDelivered);
  }
}
