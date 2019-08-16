package edu.neu.ccs.cs5500.service;

import edu.neu.ccs.cs5500.entity.Ride;
import edu.neu.ccs.cs5500.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service that facilitates database retrieval.
 */

@Service
public class RideService {

  @Autowired
  RideRepository rideRepository;

  public List<Ride> findAllRides() {
    return rideRepository.findAll();
  }

  public List<Ride> findAllRidesByDay(String day) {return  rideRepository.findAllRidesByDay(day);}

  public List<Ride> findRidesBySkierId(Long id, String day) {
    return rideRepository.findRideBySkierId(id, day);
  }

}
