package cole.driscoll.personal.repo;

public abstract class AbsComforterDryCleaning extends AbsProduct {

  private boolean isDownDryCleaned;
  protected final double priceIncrease = 5.00;

  public AbsComforterDryCleaning(boolean isDownDryCleaned) {
    this.isDownDryCleaned = isDownDryCleaned;
  }

  public boolean isDownDryCleaned() {
    return isDownDryCleaned;
  }
}
