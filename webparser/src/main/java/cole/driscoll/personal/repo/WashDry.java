package cole.driscoll.personal.repo;

public class WashDry extends AbsStandardBag {

  private final double price = 24.99;

  public WashDry(int ID) {
    super(ID);
  }

  @Override
  public double getPrice() {
    return price;
  }
}
