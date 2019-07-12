package cole.driscoll.personal.repo.ProductServiceInfo.ComfortersDryCleaning;

/**
 * Abstract comforter product type.
 */
public abstract class AbsComforter extends AbsComforterDryCleaning {

  /**
   * Constructor which identifies if it is down.
   *
   * @param isDownDryCleaned - True if down
   */
  public AbsComforter(boolean isDownDryCleaned) {
    super(isDownDryCleaned);
  }
}
