package cole.driscoll.personal.repo;

/**
 * Abstract dry cleaning product type.
 */
public abstract class AbsDryCleaning extends AbsComforterDryCleaning {

  /**
   * Constructor which takes a boolean to tell whether the product is dry cleaned or not.
   *
   * @param isDownDryCleaned - True is dry cleaned
   */
  public AbsDryCleaning(boolean isDownDryCleaned) {
    super(isDownDryCleaned);
  }
}
