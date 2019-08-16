package edu.neu.ccs.cs5500.repository;

import edu.neu.ccs.cs5500.entity.Skier;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;


/**
 * Interface that Queries Neo4j.
 */

public interface SkierRepository extends Neo4jRepository<Skier, Long> {

  @Query("MATCH (s:Skier)-[r:RODE]->(l:Lift) RETURN s,r,l LIMIT 100")
  List<Skier> findAll();

  @Query("MATCH (s:Skier)-[r:RODE]->(l:Lift) WHERE s.day = {day} RETURN s, r, l LIMIT 100")
  List<Skier> findAllByDay(@Param("day") String day);

  @Query("MATCH (s:Skier)-[r:RODE]->(l:Lift) WHERE s.skierNum = {id} AND s.day = {day} RETURN s, r, l")
  Skier findSkierByDay(@Param("id") Long id, @Param("day") String day);
}
