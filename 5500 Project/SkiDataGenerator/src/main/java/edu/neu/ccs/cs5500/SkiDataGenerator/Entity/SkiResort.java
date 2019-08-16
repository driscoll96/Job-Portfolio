package edu.neu.ccs.cs5500.SkiDataGenerator.Entity;

import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.Day;
import edu.neu.ccs.cs5500.SkiDataGenerator.Enums.Season;
import java.util.ArrayList;
import java.util.Objects;

/**
 * A class representing a SkiResort.
 */
public class SkiResort {

  private Day day;
  private Season season;
  private Weather weather;
  private ArrayList<SkiLift> allLifts;


  /**
   * A constructor for a SkiResort.
   */
  public SkiResort(Day day, Season season, Weather weather) {
    this.day = day;
    this.season = season;
    this.weather = weather;
  }

  /**
   * Gets the lift of all skiLists.
   *
   * @return the list of skiLifts.
   */
  public ArrayList<SkiLift> getAllLifts() {
    return allLifts;
  }

  /**
   * Gets the Day of the conditions.
   *
   * @return the Day.
   */

  public Day getDay() {
    return day;
  }

  /**
   * Gets the Season of the conditions.
   *
   * @return the Season.
   */
  public Season getSeason() {
    return season;
  }

  /**
   * Gets the Weather of the conditions.
   *
   * @return the Weather.
   */
  public Weather getWeather() {
    return weather;
  }

  /**
   * Sets all of the lifts from the read in Readers
   *
   * @param allLifts teh list of all lifts in the SkiResort.
   */
  public void setAllLifts(ArrayList<SkiLift> allLifts) {
    this.allLifts = allLifts;
  }

  /**
   * Adds a lift to the list of SkiLifts.
   *
   * @param newLift the new lift to be added.
   */
  public void addLift(SkiLift newLift) {
    allLifts.add(newLift);
  }

  /**
   * Creates the map of all of the SkiLifts and their connectivity.
   */
  public ArrayList<ArrayList<Integer>> createLiftMap() {
    ArrayList<ArrayList<Integer>> skiMap = new ArrayList<>();

    for (int i = 0; i < allLifts.size(); i++) {
      ArrayList<Integer> connections = new ArrayList<>();
      for (int j = 0; j < allLifts.size(); j++) {
        connections.add(0);
      }
      skiMap.add(connections);
    }

    for (int lift = 0; lift < allLifts.size(); lift++) {
      int numOfConnections = allLifts.get(lift).getLiftConnections().size();
      for (int connection = 0; connection < numOfConnections; connection++) {
        int index = allLifts.get(lift).getLiftConnections().get(connection);
        // if alpine and stormy - it has no connections:
        if (allLifts.get(lift).isAlpine() && this.weather.isStorm()) {
          break;
        }
        // if its not stormy:
        if (!this.weather.isStorm()) {
          setValue(skiMap, lift, index, 1);
        }
        // if its stormy and not alpine:
        if (this.weather.isStorm() && !allLifts.get(index).isAlpine()) {
          setValue(skiMap, lift, index, 1);
        }
      }
    }
    return skiMap;
  }

  /**
   * Changes a value of the SkiResort Lift map.
   *
   * @param list the list to be edited.
   * @param row the row to be edited.
   * @param column the column to be edited.
   * @param value the value to be used to update the cell with.
   */
  private void setValue(ArrayList<ArrayList<Integer>> list, int row, int column, int value) {
    list.get(row).set(column, value);
  }

  /**
   * toString for the SkiResort, including the skiLifts.
   *
   * @return the string representation.
   */
  @Override
  public String toString() {
    return ("Day:" + this.getDay().toString() + " Season:" + this.getSeason().toString()
        + " Weather:"
        + this.getWeather().toString());
  }

  /**
   * hashCode for the SkiResort.
   *
   * @return the hashCode for the SkiResort.
   */
  @Override
  public int hashCode() {
    return Objects.hash(day, season, weather, allLifts);
  }

  /**
   * The equals function for the SkiResort.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    SkiResort compare = (SkiResort) obj;
    if (!this.allLifts.equals(compare.allLifts) || !this.day.equals(compare.day) || !this.season
        .equals(compare.season)
        || !this.weather.equals(compare.weather)) {
      return false;
    }
    return true;
  }
}
