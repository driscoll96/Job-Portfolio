package cole.driscoll.personal.repo;

public class StainOdor extends AbsDetergent {

  private final double price = 0.00;
  private boolean isLavender;

  public StainOdor(boolean isLavender) {
    this.isLavender = isLavender;
  }

  @Override
  public double getPrice() {
    if (this.isLavender) {
      return price + 1.79;
    }
    return price;
  }
}
