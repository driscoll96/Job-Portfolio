package cole.driscoll.personal.repo;

public class ComLarge extends AbsCommercialBag {

  private final double price = 73.99;

  /*public ComLarge(int ID) {
    super(ID);
  }*/

  @Override
  public double getPrice() {
    return price;
  }
}
