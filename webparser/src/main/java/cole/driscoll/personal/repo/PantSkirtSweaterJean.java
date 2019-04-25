package cole.driscoll.personal.repo;

public class PantSkirtSweaterJean extends AbsDryCleaning {

  private final double price = 14.99;

  public PantSkirtSweaterJean(int ID, boolean isDownDryCleaned) {
    super(ID, isDownDryCleaned);
  }

  @Override
  public double getPrice() {
    if (super.isDownDryCleaned()) {
      return price + priceIncrease;
    }
    return price;
  }
}
