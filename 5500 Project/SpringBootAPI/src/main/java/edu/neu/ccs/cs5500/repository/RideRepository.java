package edu.neu.ccs.cs5500.repository;

import edu.neu.ccs.cs5500.entity.Ride;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

/**
 * Interface that Queries Neo4j.
 */

public interface RideRepository extends Neo4jRepository<Ride, Long> {

  @Query("MATCH (s:Skier)-[r:RODE]->(l:Lift) RETURN s,r,l LIMIT 100")
  List<Ride> findAll();

  @Query("MATCH (s:Skier)-[r:RODE]->(l:Lift) WHERE s.day = {day} RETURN s,r,l LIMIT 100")
  List<Ride>findAllRidesByDay(@Param("day") String day);

  @Query("MATCH (s:Skier)-[r:RODE]->(l:Lift) WHERE s.skierNum = {id} AND s.day = {day} RETURN r,s,l")
  List<Ride> findRideBySkierId(@Param("id") Long id, @Param("day") String day);
}
