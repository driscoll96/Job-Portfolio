package edu.neu.ccs.cs5500.SkiDataGenerator.Entity;

import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.SkillLevel;
import java.util.ArrayList;

/**
 * A class representing a Ski Lift.
 */
public class SkiLift {

  private int liftNum;
  private String liftName;
  private ArrayList<Integer> liftConnections;
  private boolean alpine;
  private SkillLevel skillLevel;

  /**
   * A constructor for the SkiLift
   *
   * @param liftNum the lift number, corresponds to the lift ID number.
   * @param liftName the lift name.
   * @param skillLevel the SkillLevel of the Lift.
   */
  public SkiLift(int liftNum, String liftName, SkillLevel skillLevel) {
    this.liftNum = liftNum;
    this.liftName = liftName;
    this.liftConnections = new ArrayList<>();
    this.alpine = false;
    this.skillLevel = skillLevel;
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
   * Gets the lift name.
   *
   * @return the lift name.
   */
  public String getLiftName() {
    return liftName;
  }

  /**
   * Gets the lift connections list.
   *
   * @return the list of lifts this lift s connected too.
   */
  public ArrayList<Integer> getLiftConnections() {
    return this.liftConnections;
  }

  /**
   * Add a connection to the SkierLift lift of connections.
   *
   * @param liftToAdd the lift to add.
   */
  public void addToConnectionsList(Integer liftToAdd) {
    this.liftConnections.add(liftToAdd);
  }

  /**
   * Changes the Alpine status of the lift.
   */
  public void setAlpine() {
    alpine = true;
  }

  /**
   * Returns true if the Lift is Alpine, false otherwise.
   *
   * @return true if Alpine, false otherwise.
   */
  public boolean isAlpine() {
    return alpine;
  }

  /**
   * Gets the skillLevel of the SkiLift
   *
   * @return teh level of the SkiLift.
   */
  public SkillLevel getSkillLevel() {
    return skillLevel;
  }

  /**
   * The toString method.
   *
   * @return the string representation of the class.
   */
  @Override
  public String toString() {
    return "Lift Number: " + this.liftNum + " Lift Name: " + this.liftName + " Lift Connections: "
        + this.liftConnections + " Alpine Status: " + this.alpine;
  }

  /**
   * The equals method.
   *
   * @param obj the SkiLIft to compare to.
   * @return true if the SKiLifts are the same object, false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    SkiLift compare = (SkiLift) obj;

    if (this.liftNum != (compare.liftNum) || this.liftName.equals(compare.liftName)
        || this.liftConnections.equals(compare.liftConnections)
        || this.alpine != compare.alpine) {
      return false;
    }
    return true;
  }

  /**
   * The hashcode function.
   *
   * @return the hashcode value of the SkiLift.
   */
  @Override
  public int hashCode() {
    return this.liftNum;
  }
}
