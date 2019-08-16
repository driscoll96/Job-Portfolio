package edu.neu.ccs.cs5500.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import org.neo4j.ogm.annotation.*;

import java.util.List;

/**
 * A class representing a SkiLift.
 */

@NodeEntity(label = "Lift")
public class SkiLift {

  @Id
  @GeneratedValue
  private Long graphId;

  @Property(name = "liftNum")
  private Long id;

  @JsonIgnoreProperties("lift")
  @Relationship(type = "RODE", direction = Relationship.INCOMING)
  private List<Ride> rides = new ArrayList<>();

  public SkiLift() {
  }

  public SkiLift(Long id) {
    this.id = id;
  }

  // Getters & Setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Ride> getRides() {
    return rides;
  }

  public void setRides(List<Ride> rides) {
    this.rides = rides;
  }

  public void addRide(Ride ride) {
    if (this.rides == null) {
      this.rides = new ArrayList<>();
    }
    this.rides.add(ride);
  }

  public Long getGraphId() {
    return graphId;
  }

  public void setGraphId(Long graphId) {
    this.graphId = graphId;
  }
}
