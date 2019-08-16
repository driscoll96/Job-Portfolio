package edu.neu.ccs.cs5500.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.*;


/**
 * A class representing a Ride.
 */
@RelationshipEntity(type = "RODE")
public class Ride {

  @Id
  @GeneratedValue
  private Long id;

  @Property(name = "time")
  private Long time;

  @JsonIgnore
  @StartNode
  private Skier skier;

  @EndNode
  private SkiLift lift;

  public Ride() {
  }

  public Ride(Long id, Skier skier, SkiLift lift, Long time) {
    this.id = id;
    this.skier = skier;
    this.lift = lift;
    this.time = time;
  }

  // Getters & Setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Skier getSkier() {
    return skier;
  }

  public void setSkier(Skier skier) {
    this.skier = skier;
  }

  public SkiLift getLift() {
    return lift;
  }

  public void setLift(SkiLift lift) {
    this.lift = lift;
  }

  public Long getTime() {
    return time;
  }

  public void setTime(Long time) {
    this.time = time;
  }
}
