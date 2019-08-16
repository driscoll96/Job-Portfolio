package edu.neu.ccs.cs5500.controller;

import edu.neu.ccs.cs5500.entity.Ride;
import edu.neu.ccs.cs5500.service.RideService;
import edu.neu.ccs.cs5500.util.http.ResponseMessage;
import edu.neu.ccs.cs5500.util.http.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller maps the Ride endpoints.
 */


@RestController
public class RideController {

  @Autowired
  RideService rideService;

  @GetMapping("/rides")
  public List<Ride> getAllRides() {
    return rideService.findAllRides();
  }

  @GetMapping("/{day}/rides")
  public List<Ride> getAllRidesByDay(
    @PathVariable(value = "day") String day){
    String allCapsDay = day.toUpperCase();
    return rideService.findAllRidesByDay(allCapsDay);
  }

  @GetMapping("/{day}/rides/{skierId}")
  public List<Ride> getSkiLiftRidesBySkierId(
      @PathVariable(value = "skierId") Long id,
      @PathVariable(value = "day") String day) {
    String allCapsDay = day.toUpperCase();
    return rideService.findRidesBySkierId(id, allCapsDay);
  }

}