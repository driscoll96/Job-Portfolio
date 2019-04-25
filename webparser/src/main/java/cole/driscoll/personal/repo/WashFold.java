package cole.driscoll.personal.repo;

public class WashFold extends AbsStandardBag {

  private final double price = 29.99;

  public WashFold(int ID) {
    super(ID);
  }

  @Override
  public double getPrice() {
    return price;
  }
}
