package cole.driscoll.personal.repo;

public class BlazerJacketCoat extends AbsDryCleaning {

  private final double price = 17.99;

  public BlazerJacketCoat(int ID, boolean isDownDryCleaned) {
    super(ID, isDownDryCleaned);
  }

  @Override
  public double getPrice() {
    return price;
  }
}
