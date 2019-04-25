package cole.driscoll.personal.repo;

public class ComforterQueenKing extends AbsComforter {

  private final double price = 40.00;

  public ComforterQueenKing(int ID, boolean down) {
    super(ID, down);
  }

  @Override
  public double getPrice() {
    if (super.isDownDryCleaned()) {
      return price + priceIncrease;
    }
    return price;
  }
}
