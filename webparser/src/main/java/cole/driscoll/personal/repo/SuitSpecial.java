package cole.driscoll.personal.repo;

public class SuitSpecial extends AbsDryCleaning {

  private final double price = 41.25;

  public SuitSpecial(boolean isDownDryCleaned) {
    super(isDownDryCleaned);
  }

  @Override
  public double getPrice() {
    return price;
  }
}
