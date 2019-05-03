package cole.driscoll.personal.repo;

public class TypeIdentifier {

  public AbsProduct identifyBagType(String bagWebName) {
    if (bagWebName.equals("Loopie Wash & Fold Service ( Per bag)")) {
      return new WashFold(false);
    } else if (bagWebName.equals("Commercial Order (Regular)")) {
      return new ComRegular();
    } else if (bagWebName.equals("Commercial Order (Large bag)")) {
      return new ComLarge();
    } else if (bagWebName.equals("Wash & Dry (No Fold!)")) {
      return new WashDry();
    } else if (bagWebName.equals("Comforter (Twin-Full)")) {
      return new ComforterTwinFull(false);
    } else if (bagWebName.equals("Comforter (Queen-King)")) {
      return new ComforterQueenKing(false);
    } else if (bagWebName.equals("Down Comforters (Queen-King)")) {
      return new ComforterQueenKing(true);
    } else if (bagWebName.equals("Down Comforters (Twin-Full)")) {
      return new ComforterQueenKing(true);
    } else if (bagWebName.equals("Shirt or Blouse (Laundered & Pressed)")) {
      return new ShirtBlouse(false);
    } else if (bagWebName.equals("Suit Special (2 Shirts, 1 Pant, 1 Suit Jacket or Blazer)")) {
      return new SuitSpecial(false);
    } else if (bagWebName.equals("Pant / Skirt / Sweater / Jeans (Laundered & Pressed)")) {
      return new PantSkirtSweaterJean(false);
    } else if (bagWebName.equals("Blazer / Suit Jacket / Sport Coat")) {
      return new BlazerJacketCoat(false);
    } else if (bagWebName.equals("Wash & Fold (Self Drop Off & pickup)")) {
      return new WashFold(true);
    } else if (bagWebName.equals("Standard 32\" x 22\" nylon Loopie bag (Yellow)")) {
      return new YellowBag();
    } else if (bagWebName.equals("Stain & Odor (Lavender Eucalyptus)")) {
      return new StainOdor(true);
    } else if (bagWebName.equals("Sensitive Skin (Fresh Scent natural laundry detergent)")) {
      return new SensitiveSkin();
    } else if (bagWebName.equals("Unscented Detergent")) {
      return new Unscented();
    } else if (bagWebName.equals("Commercial Loopie bag 30\" x 40\" (Blue)")) {
      return new BlueBag();
    } else if (bagWebName.equals("Shirt or Blouse (Dry cleaned)")) {
      return new ShirtBlouse(true);
    } else if (bagWebName.equals("Dress (Dry Cleaned)")) {
      return new Dress(true);
    } else if (bagWebName.equals("Bedding Bag! (Sheets, Comforter, Towel & Pillow Cases)")) {
      return new Bedding();
    } else if (bagWebName.equals("Sleeping Bag")) {
      return new SleepingBag();
    } else if (bagWebName.equals("Clothing Donation (Free)")) {
      return new Donation();
    }
    return null;
  }
}
