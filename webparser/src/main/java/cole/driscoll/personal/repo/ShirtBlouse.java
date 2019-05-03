package cole.driscoll.personal.repo;

public class ShirtBlouse extends AbsDryCleaning {

  private final double price = 8.99;

  public ShirtBlouse(boolean isDownDryCleaned) {
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
