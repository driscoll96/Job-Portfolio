package edu.neu.ccs.cs5500.controller;


import edu.neu.ccs.cs5500.entity.SkiLift;
import edu.neu.ccs.cs5500.service.SkiLiftService;
import edu.neu.ccs.cs5500.util.http.ResponseMessage;
import edu.neu.ccs.cs5500.util.http.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller maps the Lift endpoints.
 */


@RestController
public class SkiLiftController {

  @Autowired
  SkiLiftService skiLiftService;

  @GetMapping("/lifts")
  public List<SkiLift> getAllSkiLifts() {
    return skiLiftService.findAllLifts();
  }

  @GetMapping("/lift/{liftId}")
  public SkiLift getLift(@PathVariable(value = "liftId") Long id) {
    return skiLiftService.findLift(id);
  }

  @GetMapping("/{day}/lift/{liftId}")
  public SkiLift getLiftByDay(
      @PathVariable(value = "liftId") Long id,
      @PathVariable(value = "day") String day) {
    String allCapsDay = day.toUpperCase();
    return skiLiftService.findLiftByDay(id, allCapsDay);
  }

  @GetMapping("/lifts/most")
  public List<SkiLift> getMostUsedLifts() {
    return skiLiftService.findMostUsedLifts();
  }

  @GetMapping("/{day}/lifts/most")
  public List<SkiLift> getMostUsedLiftsByDay(
      @PathVariable(value = "day") String day) {
    String allCapsDay = day.toUpperCase();
    return skiLiftService.findMostUsedLiftsByDay(allCapsDay);
  }

  @GetMapping("/lifts/least")
  public List<SkiLift> getLeastUsedLifts() {
    return skiLiftService.findLeastUsedLifts();
  }

  @GetMapping("/{day}/lifts/least")
  public List<SkiLift> getLeastUsedLiftsByDay(
      @PathVariable(value = "day") String day) {
    String allCapsDay = day.toUpperCase();
    return skiLiftService.findLeastUsedLiftsByDay(allCapsDay);
  }

  @GetMapping("/lifts/base/most")
  public List<SkiLift> getMostUsedBaseLifts() {
    return skiLiftService.findMostUsedBaseLifts();
  }

  @GetMapping("/{day}/lifts/base/most")
  public List<SkiLift> getMostUsedBaseLiftsByDay(
      @PathVariable(value = "day") String day) {
    String allCapsDay = day.toUpperCase();
    return skiLiftService.findMostUsedBaseLiftsByDay(allCapsDay);
  }

  @GetMapping("/lifts/base/least")
  public List<SkiLift> getLeastUsedBaseLifts() {
    return skiLiftService.findLeastUsedBaseLifts();
  }

  @GetMapping("/{day}/lifts/base/least")
  public List<SkiLift> getLeastUsedBaseLiftsByDay(
      @PathVariable(value = "day") String day) {
    String allCapsDay = day.toUpperCase();
    return skiLiftService.findLeastUsedBaseLiftsByDay(allCapsDay);
  }
}