package cole.driscoll.personal.repo;

public class ComforterTwinFull extends AbsComforter {

  private final double price = 35.00;

  public ComforterTwinFull(boolean down) {
    super(down);
  }

  public double getPrice() {
    if (super.isDownDryCleaned()) {
      return price + priceIncrease;
    }
    return price;
  }
}
