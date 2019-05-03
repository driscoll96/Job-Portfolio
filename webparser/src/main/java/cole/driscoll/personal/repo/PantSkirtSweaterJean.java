package cole.driscoll.personal.repo;

public class PantSkirtSweaterJean extends AbsDryCleaning {

  private final double price = 14.99;

  public PantSkirtSweaterJean(boolean isDownDryCleaned) {
    super(isDownDryCleaned);
  }

  @Override
  public double getPrice() {
    if (super.isDownDryCleaned()) {
      return price + priceIncrease;
    }
    return price;
  }
}
