package edu.neu.ccs.cs5500.SkiDataGenerator.Entity;

import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.Day;
import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.SkillLevel;
import java.util.ArrayList;

/**
 * A class representing a skier on a mountain.
 */

public class Skier {

  private int skierNum;
  private int currentLift;
  private boolean lazy;
  private SkillLevel skillLevel;
  private boolean hasLunch;
  private ArrayList<SkiLiftRide> liftRides;
  private Day day;

  /**
   * Time relative to the skier (what hour in the day it is for them).
   */
  public int skierTime;


  /**
   * A constructor for a skier. Sets the skier's time to 9 am because that is when the resort
   * opens.
   *
   * @param skierNum the skier ID
   * @param currentLift the current or last lift the skier was on
   * @param lazy if the skier loops multiple lifts before moving on
   * @param skillLevel the ski level of the skier
   * @param hasLunch if the skier skis through lunch or not
   */
  public Skier(int skierNum, int currentLift, boolean lazy, SkillLevel skillLevel,
      boolean hasLunch, Day day) {
    this.skierNum = skierNum;
    this.currentLift = currentLift;
    this.lazy = lazy;
    this.skillLevel = skillLevel;
    this.hasLunch = hasLunch;
    this.liftRides = new ArrayList<>();
    this.skierTime = 0;
    this.day = day;
  }

  /**
   * Gets the ID number of the skier
   *
   * @return the skier ID number.
   */
  public int getSkierNum() {
    return skierNum;
  }

  /**
   * Gets the skiers current or last lift.
   *
   * @return the current or last lift the skier was on.
   */
  public int getCurrentLift() {
    return currentLift;
  }

  /**
   * Sets the skier current lift of the skier.
   *
   * @param currentLift the current lift the skier is on.
   */
  public void setCurrentLift(int currentLift) {
    this.currentLift = currentLift;
  }

  /**
   * Gets if the skier is lazy or not.
   *
   * @return true if the skier is lazy, false otherwise.
   */
  public boolean isLazy() {
    return lazy;
  }

  /**
   * Sets if the skier is lazy or not.
   *
   * @param lazy if the skier is lazy or not.
   */
  public void setLazy(boolean lazy) {
    this.lazy = lazy;
  }

  /**
   * Gets the SkillLevel of the skier.
   *
   * @return the skier's SkillLevel.
   */
  public SkillLevel getSkillLevel() {
    return skillLevel;
  }

  /**
   * Gets the Day of the skier.
   *
   * @return the skier's Day.
   */
  public Day getDay() {
    return day;
  }

  /**
   * Sets the SkillLevel of the skier.
   *
   * @param skillLevel the skier's SkillLevel.
   */
  public void setSkillLevel(SkillLevel skillLevel) {
    this.skillLevel = skillLevel;
  }

  /**
   * Gets if the skier has lunch or not.
   *
   * @return true if the skier has lunch, false otherwise.
   */
  public boolean isHasLunch() {
    return hasLunch;
  }

  /**
   * Sets if the skier has lunch.
   *
   * @param hasLunch if the skier has lunch or not.
   */
  public void setHasLunch(boolean hasLunch) {
    this.hasLunch = hasLunch;
  }

  /**
   * Gets the list of SkiLiftRides.
   *
   * @return the list of SkiLiftRides.
   */
  public ArrayList<SkiLiftRide> getLiftRides() {
    return this.liftRides;
  }

  /**
   * Gets the skier's time of day.
   *
   * @return - Skier's time of day
   */
  public int getSkierTime() {
    return this.skierTime;
  }

  /**
   * Increments the skier's time of day by 30 minutes.
   */
  public void incrementTimeOneRide(int time) {

    this.skierTime += time;
  }

  /**
   * Adds a ski lift ride to the skier list of lift rides.
   *
   * @param newLiftRide the new lift ride that the skier has taken.
   */
  public void addLiftRide(SkiLiftRide newLiftRide) {
    this.liftRides.add(newLiftRide);
  }

  /**
   * Hashcode of the skier.
   *
   * @return the hashcode of the skier.
   */
  @Override
  public int hashCode() {
    return this.skierNum;
  }

  /**
   * Equals function of the skier.
   *
   * @param obj the skier to compare to.
   * @return true if the skiers are the same, false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Skier compare = (Skier) obj;

    if (this.skierNum != (compare.skierNum) || (this.currentLift != compare.currentLift) || (
        this.lazy != compare.lazy) || (this.skillLevel.equals(compare.skillLevel))
        || (this.liftRides.equals(compare.liftRides))) {
      return false;
    }
    return true;
  }

  /**
   * toString of the skier.
   *
   * @return the string of the skier.
   */
  @Override
  public String toString() {
    return ("Skier Number:" + this.skierNum + ", " + "Current Lift:" + this.currentLift + ", "
        + "Lazy?:" + this.lazy + ", " + "Skill Level:" + this.skillLevel + ", " + "Lunch?:" + this
        .isHasLunch() + ", " + "Lift Rides: " + this.liftRides.toString());
  }
}

