package edu.neu.ccs.cs5500.repository;

import edu.neu.ccs.cs5500.entity.SkiLift;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

/**
 * Interface that Queries Neo4j.
 */

public interface SkiLiftRepository extends Neo4jRepository<SkiLift, String> {

  @Query("MATCH (s:Skier)-[r:RODE]->(l:Lift) RETURN s,r,l LIMIT 100")
  List<SkiLift> findAll();

  @Query("MATCH (s:Skier)-[r:RODE]->(l:Lift) WHERE l.liftNum = {id} RETURN s, r, l LIMIT 100")
  SkiLift findLift(@Param("id") Long id);

  @Query("MATCH (s:Skier)-[r:RODE]->(l:Lift) WHERE s.day = {day} AND l.liftNum = {id} RETURN s, r, l LIMIT 100")
  SkiLift findLiftByDay(@Param("id") Long id, @Param("day") String day);

  @Query("MATCH (s)-[r:RODE]->(l) RETURN l,s,r, COLLECT(s) as lifts ORDER BY SIZE(lifts) DESC LIMIT 5")
  List<SkiLift> findMostUsed();

  @Query("MATCH (s)-[r:RODE]->(l) WHERE s.day = {day} RETURN l,s,r, COLLECT(s) as lifts ORDER BY SIZE(lifts) DESC LIMIT 5")
  List<SkiLift> findMostUsedByDay(@Param("day") String day);

  @Query("MATCH (s)-[r:RODE]->(l) RETURN l,s,r, COLLECT(s) as lifts ORDER BY SIZE(lifts) LIMIT 5")
  List<SkiLift> findLeastUsed();

  @Query("MATCH (s)-[r:RODE]->(l) WHERE s.day = {day} RETURN l,s,r, COLLECT(s) as lifts ORDER BY SIZE(lifts) LIMIT 5")
  List<SkiLift> findLeastUsedByDay(@Param("day") String day);

  @Query("MATCH (s)-[r:RODE]->(l) WHERE r.time = 0 RETURN l,s,r, COLLECT(s) as lifts ORDER BY SIZE(lifts) DESC LIMIT 5")
  List<SkiLift> findMostUsedBase();

  @Query("MATCH (s)-[r:RODE]->(l) WHERE r.time = 0 AND s.day = {day} RETURN l,s,r, COLLECT(s) as lifts ORDER BY SIZE(lifts) DESC LIMIT 5")
  List<SkiLift> findMostUsedBaseByDay(@Param("day") String day);

  @Query("MATCH (s)-[r:RODE]->(l) WHERE r.time = 0 RETURN l,s,r, COLLECT(s) as lifts ORDER BY SIZE(lifts) LIMIT 5")
  List<SkiLift> findLeastUsedBase();

  @Query("MATCH (s)-[r:RODE]->(l) WHERE r.time = 0 AND s.day = {day} RETURN l,s,r, COLLECT(s) as lifts ORDER BY SIZE(lifts) LIMIT 5")
  List<SkiLift> findLeastUsedBaseByDay(@Param("day") String day);
}
