package cole.driscoll.personal.repo;

import java.util.Objects;

/**
 * Holds the info of customer's address.
 */
public class Address {

  /**
   * Street name.
   */
  private String street;

  /**
   * City.
   */
  private String city;

  /**
   * State.
   */
  private String state;

  /**
   * Zip code.
   */
  private String zipCode;

  /**
   * Constructor which populates all the property variables.
   *
   * @param street - Street name
   * @param city - City
   * @param state - State
   * @param zipCode - Zip code
   */
  public Address(String street, String city, String state, String zipCode) {
    this.street = street;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Address)) {
      return false;
    }
    Address address = (Address) o;
    return zipCode == address.zipCode &&
        Objects.equals(street, address.street) &&
        Objects.equals(city, address.city) &&
        Objects.equals(state, address.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(street, city, state, zipCode);
  }

  public String getStreet() {
    return street;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getZipCode() {
    return zipCode;
  }
}
