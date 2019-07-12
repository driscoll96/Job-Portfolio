package cole.driscoll.personal.repo;

import static org.junit.Assert.*;

import cole.driscoll.personal.repo.CustomerInfo.StreetAddress;
import cole.driscoll.personal.repo.ProductServiceInfo.Bags.BlueBag;
import cole.driscoll.personal.repo.ProductServiceInfo.Bags.DuffelBag;
import cole.driscoll.personal.repo.ProductServiceInfo.Bags.YellowBag;
import cole.driscoll.personal.repo.CustomerInfo.AbsCustomer;
import cole.driscoll.personal.repo.CustomerInfo.CommercialCustomer;
import cole.driscoll.personal.repo.CustomerInfo.NonCommercialCustomer;
import cole.driscoll.personal.repo.ProductServiceInfo.AbsProduct;
import cole.driscoll.personal.repo.ProductServiceInfo.Regular.ComLarge;
import cole.driscoll.personal.repo.ProductServiceInfo.Regular.ComRegular;
import cole.driscoll.personal.repo.ProductServiceInfo.ComfortersDryCleaning.ComforterQueenKing;
import cole.driscoll.personal.repo.ProductServiceInfo.ComfortersDryCleaning.ComforterTwinFull;
import cole.driscoll.personal.repo.ProductServiceInfo.ComfortersDryCleaning.Dress;
import cole.driscoll.personal.repo.ProductServiceInfo.ComfortersDryCleaning.PantSkirtSweaterJean;
import cole.driscoll.personal.repo.ProductServiceInfo.ComfortersDryCleaning.ShirtBlouse;
import cole.driscoll.personal.repo.ProductServiceInfo.Detergent.SensitiveSkin;
import cole.driscoll.personal.repo.ProductServiceInfo.Detergent.StainOdor;
import cole.driscoll.personal.repo.ProductServiceInfo.Detergent.Unscented;
import cole.driscoll.personal.repo.ProductServiceInfo.Specials.Bedding;
import cole.driscoll.personal.repo.ProductServiceInfo.Specials.BlazerJacketCoat;
import cole.driscoll.personal.repo.ProductServiceInfo.Specials.Donation;
import cole.driscoll.personal.repo.ProductServiceInfo.Specials.SleepingBag;
import cole.driscoll.personal.repo.ProductServiceInfo.Specials.SuitSpecial;
import cole.driscoll.personal.repo.ProductServiceInfo.Regular.WashDry;
import cole.driscoll.personal.repo.ProductServiceInfo.Regular.WashFold;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TypeIdentifierTest {

  private TypeIdentifier identifier;

  @Before
  public void setUp() throws Exception {
    identifier = new TypeIdentifier();
  }

  @Test
  public void identifyProductType() {
    assertEquals(identifier.identifyProductType("Loopie Wash & Fold Service"),
        new WashFold(false, false));
    assertEquals(identifier.identifyProductType("Commercial Order (Regular)"),
        new ComRegular());
    assertEquals(identifier.identifyProductType("Wash & Fold Service (Hotel)"),
        new WashFold(false, true));
    assertEquals(identifier.identifyProductType("Commercial Order (Large bag)"),
        new ComLarge());
    assertEquals(identifier.identifyProductType("Wash & Dry (No Fold!)"),
        new WashDry());
    assertEquals(identifier.identifyProductType("Comforter (Twin-Full)"),
        new ComforterTwinFull(false));
    assertEquals(identifier.identifyProductType("Comforter (Queen-King)"),
        new ComforterQueenKing(false));
    assertEquals(identifier.identifyProductType("Down ComfortersDryCleaning (Queen-King)"),
        new ComforterQueenKing(true));
    assertEquals(identifier.identifyProductType("Down ComfortersDryCleaning (Twin-Full)"),
        new ComforterTwinFull(true));
    assertEquals(identifier.identifyProductType("Shirt or Blouse (Laundered & Pressed)"),
        new ShirtBlouse(false));
    assertEquals(identifier.identifyProductType("Suit Special (2 Shirts, 1 Pant, 1 Suit Jacket or Blazer)"),
        new SuitSpecial(true));
    assertEquals(identifier.identifyProductType("Pant / Skirt / Sweater / Jeans (Laundered & Pressed)"),
        new PantSkirtSweaterJean(false));
    assertEquals(identifier.identifyProductType("Blazer / Suit Jacket / Sport Coat"),
        new BlazerJacketCoat(true));
    assertEquals(identifier.identifyProductType("Wash & Fold (Self Drop Off & pickup)"),
        new WashFold(true, false));
    assertEquals(identifier.identifyProductType("Loopie Duffel Bag"),
        new DuffelBag());
    assertEquals(identifier.identifyProductType("Stain & Odor (Lavender Eucalyptus)"),
        new StainOdor(true));
    assertEquals(identifier.identifyProductType("Sensitive Skin (Fresh Scent natural laundry detergent)"),
        new SensitiveSkin());
    assertEquals(identifier.identifyProductType("Unscented Detergent"), new Unscented());
    assertEquals(identifier.identifyProductType("STAIN & ODOR Clean Scent Eco- Friendly (Default)"),
        new StainOdor(false));
    assertEquals(identifier.identifyProductType("Commercial Loopie bag 30\" x 40\" (Blue)"),
        new BlueBag());
    assertEquals(identifier.identifyProductType("Shirt or Blouse (Dry cleaned)"),
        new ShirtBlouse(true));
    assertEquals(identifier.identifyProductType("Dress (Dry Cleaned)"),
        new Dress(true));
    assertEquals(identifier.identifyProductType("Bedding Bag! (Sheets, Comforter, Towel & Pillow Cases)"),
        new Bedding());
    assertEquals(identifier.identifyProductType("Sleeping Bag"),
        new SleepingBag());
    assertEquals(identifier.identifyProductType("Clothing Donation (Free)"),
        new Donation());
    assertEquals(identifier.identifyProductType("Standard 32\" x 22\" nylon Loopie bag (Yellow)"),
        new YellowBag());
  }

  @Test
  public void identifyCustomerType() {
    List<AbsProduct> products = new ArrayList<>();
    products.add(new WashFold(false, false));
    products.add(new WashDry());
    NonCommercialCustomer customer = new NonCommercialCustomer("c", "d", "cd@GMAIL.COM",
        "1234567890", new StreetAddress("street", null,"seattle", "WA", "90102"));
    assertEquals(identifier.identifyCustomerType(products, "c", "d", "cd@GMAIL.COM",
        "1234567890", 123, new StreetAddress("street", null,"seattle", "WA", "90102")), customer);
    List<AbsProduct> productsCom = new ArrayList<>();
    productsCom.add(new ComRegular());
    CommercialCustomer customerCom = new CommercialCustomer("c", "d", "cd@GMAIL.COM",
        "1234567890", new StreetAddress("street", null,"seattle", "WA", "90102"));
    assertEquals(identifier.identifyCustomerType(productsCom, "c", "d", "cd@GMAIL.COM",
        "1234567890", 123, new StreetAddress("street", null,"seattle", "WA", "90102")), customerCom);
  }

  @Test
  public void identifyCustomerWithOrder() {
    List<AbsCustomer> customers = new ArrayList<>();
    customers.add(new NonCommercialCustomer("c", "d", "cd@GMAIL.COM",
        "1234567890", new StreetAddress("street", null,"seattle", "WA", "90102")));
    AbsCustomer customer = new CommercialCustomer("page", "ten", "cd@GMAIL.COM",
        "1234567890", new StreetAddress("street", null,"seattle", "WA", "90102"));
    customers.add(customer);
    customers.add(new CommercialCustomer("ivor", "zal", "cd@GMAIL.COM",
        "1234567890", new StreetAddress("street", null,"seattle", "WA", "90102")));
    assertEquals(identifier.identifyCustomerWithOrder("page", "ten", customers), customer);
  }
}