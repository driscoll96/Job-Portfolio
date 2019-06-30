package edu.neu.ccs.cs5500.SkiDataGenerator;

/**
 * A SkiLiftRide on the mountain.
 */
public class SkiLiftRide {

  private int liftNum;
  private int time;

  /**
   * A constructor for the SkiLiftRide.
   *
   * @param liftNum the lift ride  number.
   * @param time the time of the lift ride.
   */
  public SkiLiftRide(int liftNum, int time) throws InvalidLiftRideTimeException {
    this.liftNum = liftNum;
    if (time >= 0 && time <= 360) {
      this.time = time;
    } else {
      throw new InvalidLiftRideTimeException("Time must be between within 0 and 360");
    }
  }

  /**
   * Gets the lift number.
   *
   * @return the lift number.
   */
  public int getLiftNum() {
    return liftNum;
  }

  /**
   * Gets the time of the lift ride.
   *
   * @return the time of the lift ride.
   */
  public int getTime() {
    return time;
  }

  /**
   * toString function for a SkiLiftRide.
   *
   * @return the String of the lift ride.
   */
  @Override
  public String toString() {
    return ("Lift Number:" + this.liftNum + ", " + "Time:" + this.time);
  }

  /**
   * Equals function for the SkiLiftRide.
   *
   * @param obj the SkiLiftRide to compare to.
   * @return true if the SkiLiftRides are the same, false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    SkiLiftRide compare = (SkiLiftRide) obj;
    if (this.liftNum != (compare.liftNum) || (this.time != compare.time)) {
      return false;
    }
    return true;
  }

  /**
   * Hashcode function for the SkiLiftRide.
   *
   * @return hashcode int.
   */
  @Override
  public int hashCode() {
    int result = (((this.time) + (this.liftNum * 7)) / 11);
    return result;
  }
}
