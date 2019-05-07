package cole.driscoll.personal.repo;

/**
 * Abstract comforter and dry cleaning product type.
 */
public abstract class AbsComforterDryCleaning extends AbsProduct {

  /**
   * Whether the product is down or dry cleaned.
   */
  private boolean isDownDryCleaned;

  /**
   * The amount to increase the price of the by if it is down or dry cleaned.
   */
  protected final double priceIncrease = 5.00;

  /**
   * Constructor identifies if it is down or dry cleaned.
   *
   * @param isDownDryCleaned - True if down or dry cleaned
   */
  public AbsComforterDryCleaning(boolean isDownDryCleaned) {
    this.isDownDryCleaned = isDownDryCleaned;
  }

  /**
   * Returns true if down or dry cleaned.
   *
   * @return - True if down or dry cleaned
   */
  public boolean isDownDryCleaned() {
    return isDownDryCleaned;
  }
}
