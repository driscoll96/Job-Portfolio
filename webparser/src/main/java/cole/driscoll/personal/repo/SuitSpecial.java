package cole.driscoll.personal.repo;

public class SuitSpecial extends AbsDryCleaning {

  private final double price = 41.25;

  public SuitSpecial(int ID, boolean isDownDryCleaned) {
    super(ID, isDownDryCleaned);
  }

  @Override
  public double getPrice() {
    return price;
  }
}
