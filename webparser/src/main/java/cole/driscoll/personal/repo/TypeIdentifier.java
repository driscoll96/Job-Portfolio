package cole.driscoll.personal.repo;

import java.util.List;

/**
 * Identifies different types of products or customers.
 */
public class TypeIdentifier {

  /**
   * Preforms a series of checks to identify the correct bag type and make an instance of it.
   *
   * @param productWebName - The web name of the product item
   * @return - Instance of the correct product type
   */
  public AbsProduct identifyProductType(String productWebName) {
    if (productWebName.equals("Loopie Wash & Fold Service")) {
      return new WashFold(false, false);
    } else if (productWebName.equals("Commercial Order (Regular)")) {
      return new ComRegular();
    } else if (productWebName.equals("Standard 32\" x 22\" nylon Loopie bag (Yellow)")) {
      return new YellowBag();
    } else if (productWebName.equals("Wash & Fold Service (Hotel)")) {
      return new WashFold(false, true);
    } else if (productWebName.equals("Commercial Order (Large bag)")) {
      return new ComLarge();
    } else if (productWebName.equals("Wash & Dry (No Fold!)")) {
      return new WashDry();
    } else if (productWebName.equals("Comforter (Twin-Full)")) {
      return new ComforterTwinFull(false);
    } else if (productWebName.equals("Comforter (Queen-King)")) {
      return new ComforterQueenKing(false);
    } else if (productWebName.equals("Down Comforters (Queen-King)")) {
      return new ComforterQueenKing(true);
    } else if (productWebName.equals("Down Comforters (Twin-Full)")) {
      return new ComforterTwinFull(true);
    } else if (productWebName.equals("Shirt or Blouse (Laundered & Pressed)")) {
      return new ShirtBlouse(false);
    } else if (productWebName.equals("Suit Special (2 Shirts, 1 Pant, 1 Suit Jacket or Blazer)")) {
      return new SuitSpecial(false);
    } else if (productWebName.equals("Pant / Skirt / Sweater / Jeans (Laundered & Pressed)")) {
      return new PantSkirtSweaterJean(false);
    } else if (productWebName.equals("Blazer / Suit Jacket / Sport Coat")) {
      return new BlazerJacketCoat(false);
    } else if (productWebName.equals("Wash & Fold (Self Drop Off & pickup)")) {
      return new WashFold(true, false);
    } else if (productWebName.equals("Loopie Duffel Bag")) {
      return new DuffelBag();
    } else if (productWebName.equals("Stain & Odor (Lavender Eucalyptus)")) {
      return new StainOdor(true);
    } else if (productWebName.equals("Sensitive Skin (Fresh Scent natural laundry detergent)")) {
      return new SensitiveSkin();
    } else if (productWebName.equals("Unscented Detergent")) {
      return new Unscented();
    } else if (productWebName.equals("STAIN & ODOR Clean Scent Eco- Friendly (Default)")) {
      return new StainOdor(false);
    } else if (productWebName.equals("Commercial Loopie bag 30\" x 40\" (Blue)")) {
      return new BlueBag();
    } else if (productWebName.equals("Shirt or Blouse (Dry cleaned)")) {
      return new ShirtBlouse(true);
    } else if (productWebName.equals("Dress (Dry Cleaned)")) {
      return new Dress(true);
    } else if (productWebName.equals("Bedding Bag! (Sheets, Comforter, Towel & Pillow Cases)")) {
      return new Bedding();
    } else if (productWebName.equals("Sleeping Bag")) {
      return new SleepingBag();
    } else if (productWebName.equals("Clothing Donation (Free)")) {
      return new Donation();
    }
    return null;
  }

  /**
   * Identify a customer's type based on whether they have ordered a commercial type product.
   *
   * ** Scraping the diff customer types for now.
   *
   * @param products - List of products in the order
   * @return - New customer instance
   */
  public AbsCustomer identifyCustomerType(List<AbsProduct> products, String firstName,
      String lastName, String email, String phoneNum, int Id, Address address) {
    for (AbsProduct product : products) {
      if (product instanceof AbsCommercialBag) {
        return new CommercialCustomer(firstName, lastName, email, phoneNum, Id, address);
      }
    }
    return new NonCommercialCustomer(firstName, lastName, email, phoneNum, Id, address);
  }

  /**
   * Identify the instance of the customer based on full name.
   *
   * @param firstName - First name of customer
   * @param lastName - Last name of customer
   * @param customers - Pool of customers
   * @return - Customer who placed the given order
   */
  public AbsCustomer identifyCustomerWithOrder(String firstName, String lastName, List<AbsCustomer> customers) {
    for (int i = 0; i < customers.size(); i++) {
      if (customers.get(i).getFirstName().equals(firstName) &&
          customers.get(i).getLastName().equals(lastName)) {
        return customers.get(i);
      }
    }
    return null;
  }
}
