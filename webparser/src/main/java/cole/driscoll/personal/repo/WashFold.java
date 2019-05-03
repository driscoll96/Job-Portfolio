package cole.driscoll.personal.repo;

public class WashFold extends AbsStandardBag {

  private final double price = 29.99;
  private boolean notDelivered;

  public WashFold(boolean discount) {
    this.notDelivered = discount;
  }

  @Override
  public double getPrice() {
    if (notDelivered) {
      return price - 5.00;
    }
    return price;
  }
}
