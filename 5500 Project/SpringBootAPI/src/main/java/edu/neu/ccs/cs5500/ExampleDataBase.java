package edu.neu.ccs.cs5500;

import edu.neu.ccs.cs5500.entity.Ride;
import edu.neu.ccs.cs5500.entity.SkiLift;
import edu.neu.ccs.cs5500.entity.Skier;
import edu.neu.ccs.cs5500.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class ExampleDataBase implements CommandLineRunner {

  private final RideRepository repository;

  @Autowired
  public ExampleDataBase(RideRepository repository) {
    this.repository = repository;
  }

  @Override
  public void run(String... args) throws Exception {
    this.repository.save(new Ride(23456889000L, new Skier(23456789000L), new SkiLift(23456789000L), 23456789000L));
  }
}
