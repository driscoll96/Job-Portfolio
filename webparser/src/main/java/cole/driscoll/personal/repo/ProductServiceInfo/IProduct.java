package cole.driscoll.personal.repo.ProductServiceInfo;

/**
 * Methods for product classes.
 */
public interface IProduct {

  /**
   * Gets the price of the product, which includes the any price increases.
   *
   * @return - Price
   */
  double getPrice();

}
