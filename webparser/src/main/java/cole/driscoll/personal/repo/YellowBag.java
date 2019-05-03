package cole.driscoll.personal.repo;

public class YellowBag extends AbsBag {

  private final double price = 4.99;

  @Override
  public double getPrice() {
    return price;
  }
}
