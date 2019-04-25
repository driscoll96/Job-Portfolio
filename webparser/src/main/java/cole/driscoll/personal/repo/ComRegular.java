package cole.driscoll.personal.repo;

public class ComRegular extends AbsCommercialBag {

  private final double price = 44.99;

  public ComRegular(int ID) {
    super(ID);
  }

  @Override
  public double getPrice() {
    return price;
  }
}
