package cole.driscoll.personal.repo.CustomerInfo;

import java.util.Objects;

/**
 * Holds the info of customer's address.
 */
public class StreetAddress {

  /**
   * Street name.
   */
  private String StreetAddress1;

  /**
   * Second part of the street name.
   */
  private String StreetAddress2;

  /**
   * City.
   */
  private String City;

  /**
   * State.
   */
  private String State;

  /**
   * Zip code.
   */
  private String ZipCode;

  /**
   * Country
   */
  private final String Country = "US";

  /**
   * Constructor which populates all the property variables.
   *
   * @param StreetAddress1 - Street name
   * @param StreetAddress2 - Second part of the street name
   * @param city - City
   * @param state - State
   * @param zipCode - Zip code
   */
  public StreetAddress(String StreetAddress1, String StreetAddress2, String city, String state,
      String zipCode) {
    this.StreetAddress1 = StreetAddress1;
    this.StreetAddress2 = StreetAddress2;
    this.City = city;
    StateAbbrevs stateAbbrevs = new StateAbbrevs();
    if (!stateAbbrevs.getStates().containsKey(state.toLowerCase())) {
      this.State = "unspecified";
    } else {
      this.State = stateAbbrevs.getStates().get(state.toLowerCase());
    }
    this.ZipCode = zipCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof StreetAddress)) {
      return false;
    }
    StreetAddress streetAddress = (StreetAddress) o;
    return ZipCode == streetAddress.ZipCode &&
        Objects.equals(StreetAddress1, streetAddress.StreetAddress1) &&
        Objects.equals(City, streetAddress.City) &&
        Objects.equals(State, streetAddress.State);
  }

  @Override
  public int hashCode() {
    return Objects.hash(StreetAddress1, City, State, ZipCode);
  }

  public String getStreetAddress1() {
    return StreetAddress1;
  }

  public String getCity() {
    return City;
  }

  public String getState() {
    return State;
  }

  public String getZipCode() {
    return ZipCode;
  }

  public String getCountry() {
    return Country;
  }

  public String getStreetAddress2() {
    return StreetAddress2;
  }
}
