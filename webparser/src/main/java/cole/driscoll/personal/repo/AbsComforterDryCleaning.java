package cole.driscoll.personal.repo;

public abstract class AbsComforterDryCleaning extends AbsBag {

  private boolean isDownDryCleaned;
  protected final double priceIncrease = 5.00;

  public AbsComforterDryCleaning(int ID, boolean isDownDryCleaned) {
    super(ID);
    this.isDownDryCleaned = isDownDryCleaned;
  }

  public boolean isDownDryCleaned() {
    return isDownDryCleaned;
  }
}
