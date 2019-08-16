package edu.neu.ccs.cs5500.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a Skier on a mountain.
 */

@NodeEntity(label = "Skier")
public class Skier {

  @Id @GeneratedValue
  private Long graphId;

  @Property(name = "skierNum")
  private Long id;


  @JsonIgnoreProperties("skier")
  @Relationship(type = "RODE", direction = Relationship.OUTGOING)
  private List<Ride> rides = new ArrayList<>();

  public Skier(){}
  public Skier(Long id) {this.id = id;}

  // Getters & Setters

  public List<Ride> getRides() {
    return rides;
  }

  public void setLifts(List<Ride> ride) {this.rides = ride;}

  public void addRide(Ride ride) {
    if (this.rides == null) {
      this.rides = new ArrayList<>();
    }
    this.rides.add(ride);
  }

  public Long getId() {return id;}

  public void setId(Long id) {this.id = id;}

  public Long getGraphId() {return graphId;}

  public void setGraphId(Long graphId) {this.graphId = graphId;}
}

