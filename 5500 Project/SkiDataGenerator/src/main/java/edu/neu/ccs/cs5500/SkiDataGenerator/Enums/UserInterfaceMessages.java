package edu.neu.ccs.cs5500.SkiDataGenerator.Enums;

public enum UserInterfaceMessages {

  FILE_PATH("Enter the file address which contains ski map data of the resort.\n"),
  DIRECTORY("Enter the directory address for output file to be created in.\n"),
  QUERY("Choose a query to analyze:\n\n"
      + "Compare Traffic: Shows which lifts are most/least used\n\n"
      + "After Base: Shows which base lift is most/least popular\n"),
  DAY("Day of the Week:\n"),
  SEASON("Season of the Year:\n"),
  SKI_CONDITIONS("Enter conditions of the type of ski resort day you want to produce data for.\n"),
  SNOW_CONDITIONS("Snow the Day Before?\n"),
  RAIN_CONDITIONS("Rain?\n"),
  SUNNY_CONDITIONS("Sunny?\n"),
  STORM_CONDITIONS("Blizzard/Storm?\n");

  public final String value;

  UserInterfaceMessages(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}

