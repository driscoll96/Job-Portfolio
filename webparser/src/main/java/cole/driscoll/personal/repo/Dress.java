package cole.driscoll.personal.repo;

public class Dress extends AbsDryCleaning {

  private final double price = 19.99;

  public Dress(int ID, boolean isDownDryCleaned) {
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
