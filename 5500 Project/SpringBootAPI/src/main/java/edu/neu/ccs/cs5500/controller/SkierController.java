package edu.neu.ccs.cs5500.controller;


import edu.neu.ccs.cs5500.entity.Skier;
import edu.neu.ccs.cs5500.service.SkierService;
import edu.neu.ccs.cs5500.util.http.ResponseMessage;
import edu.neu.ccs.cs5500.util.http.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller maps the Skier endpoints.
 */


@RestController
public class SkierController {

  @Autowired
  SkierService skierService;

  @GetMapping("/skiers")
  public List<Skier> getAllSkiers() {
    return skierService.findAllSkiers();
  }

  @GetMapping("/{day}/skiers")
  public List<Skier> getAllSkiersByDay(
      @PathVariable(value = "day") String day) {
    String allCapsDay = day.toUpperCase();
    return skierService.findAllSkiersByDay(allCapsDay);
  }

  @GetMapping("/{day}/skier/{skierId}")
  public Skier getSkierByIdAndDay(
      @PathVariable(value = "skierId") Long id,
      @PathVariable(value = "day") String day){
    String allCapsDay = day.toUpperCase();
    return skierService.findSkierByIdAndDay(id, allCapsDay);
  }

}