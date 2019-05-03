package cole.driscoll.personal.repo;

public class BlazerJacketCoat extends AbsDryCleaning {

  private final double price = 17.99;

  public BlazerJacketCoat(boolean isDownDryCleaned) {
    super(isDownDryCleaned);
  }

  @Override
  public double getPrice() {
    return price;
  }
}
