package edu.neu.ccs.cs5500.SkiDataGenerator.Collectors;

import edu.neu.ccs.cs5500.SkiDataGenerator.Validators.IValidator;
import java.util.Objects;

/**
 * An Abstract Input Collectors.
 */
public abstract class AbsInputCollector {

  private final IValidator validator;

  /**
   * A constructor for an Abstract Input Collectors.
   *
   * @param validator the validator.
   */
  public AbsInputCollector(IValidator validator) {
    this.validator = validator;
  }

  /**
   * Gets the validator.
   *
   * @return the Validator.
   */
  public IValidator getValidator() {
    return validator;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof AbsInputCollector)) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(validator);
  }
}
