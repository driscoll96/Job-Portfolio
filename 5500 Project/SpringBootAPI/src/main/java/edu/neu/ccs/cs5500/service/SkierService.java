package edu.neu.ccs.cs5500.service;

import edu.neu.ccs.cs5500.entity.Skier;
import edu.neu.ccs.cs5500.repository.SkierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service that facilitates database retrieval.
 */

@Service
public class SkierService {

  @Autowired
  SkierRepository skierRepository;

  public List<Skier> findAllSkiers() {
    return skierRepository.findAll();
  }

  public List<Skier> findAllSkiersByDay(String day) {
    return skierRepository.findAllByDay(day);
  }

  public Skier findSkierByIdAndDay(Long id, String day) {
    return skierRepository.findSkierByDay(id, day);
  }
}
