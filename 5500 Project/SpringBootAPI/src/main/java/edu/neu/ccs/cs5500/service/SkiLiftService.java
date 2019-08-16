package edu.neu.ccs.cs5500.service;

import edu.neu.ccs.cs5500.entity.SkiLift;
import edu.neu.ccs.cs5500.repository.SkiLiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service that facilitates database retrieval.
 */

@Service
public class SkiLiftService {

  @Autowired
  SkiLiftRepository skiLiftRepository;

  public List<SkiLift> findAllLifts() {
    return skiLiftRepository.findAll();
  }

  public SkiLift findLift(Long id) {
    return skiLiftRepository.findLift(id);
  }

  public SkiLift findLiftByDay(Long id, String day) {
    return skiLiftRepository.findLiftByDay(id, day);
  }

  public List<SkiLift> findMostUsedLifts() {
    return skiLiftRepository.findMostUsed();
  }

  public List<SkiLift> findMostUsedLiftsByDay(String day) {
    return skiLiftRepository.findMostUsedByDay(day);
  }

  public List<SkiLift> findLeastUsedLifts() {
    return skiLiftRepository.findLeastUsed();
  }

  public List<SkiLift> findLeastUsedLiftsByDay(String day) {
    return skiLiftRepository.findLeastUsedByDay(day);
  }

  public List<SkiLift> findMostUsedBaseLifts() {
    return skiLiftRepository.findMostUsedBase();
  }

  public List<SkiLift> findMostUsedBaseLiftsByDay(String day) {
    return skiLiftRepository.findMostUsedBaseByDay(day);
  }

  public List<SkiLift> findLeastUsedBaseLifts() {
    return skiLiftRepository.findLeastUsedBase();
  }

  public List<SkiLift> findLeastUsedBaseLiftsByDay(String day) {
    return skiLiftRepository.findLeastUsedBaseByDay(day);
  }
}
