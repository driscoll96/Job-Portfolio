package cole.driscoll.personal.repo;

/**
 * Identifies different types of products or customers.
 */
public class TypeIdentifier {

//  /**
//   * Identify a customer's type based on whether they have ordered a commercial type product.
//   *
//   * ** Scraping the diff customer types for now.
//   *
//   * @param products - List of products in the order
//   * @return - New customer instance
//   */
//  public AbsCustomer identifyCustomerType(List<AbsProduct> products, String firstName,
//      String lastName, String email, String phoneNum, int Id, StreetAddress streetAddress) {
//    for (AbsProduct product : products) {
//      if (product instanceof AbsCommercialBag) {
//        return new CommercialCustomer(firstName, lastName, email, phoneNum, streetAddress);
//      }
//    }
//    return new NonCommercialCustomer(firstName, lastName, email, phoneNum, streetAddress);
//  }
//
//  /**
//   * Identify the instance of the customer based on full name.
//   *
//   * @param firstName - First name of customer
//   * @param lastName - Last name of customer
//   * @param customers - Pool of customers
//   * @return - Customer who placed the given order
//   */
//  public AbsCustomer identifyCustomerWithOrder(String firstName, String lastName, List<AbsCustomer> customers) {
//    for (int i = 0; i < customers.size(); i++) {
//      if (customers.get(i).getFirstName().equals(firstName) &&
//          customers.get(i).getLastName().equals(lastName)) {
//        return customers.get(i);
//      }
//    }
//    return null;
//  }
}
