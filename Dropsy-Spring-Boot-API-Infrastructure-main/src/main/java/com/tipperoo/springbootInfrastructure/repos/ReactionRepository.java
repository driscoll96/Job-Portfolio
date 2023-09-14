package com.tipperoo.springbootInfrastructure.repos;

import com.tipperoo.springbootInfrastructure.dao.Reaction;
import org.springframework.data.repository.CrudRepository;

public interface ReactionRepository extends CrudRepository<Reaction, Integer>  {
}
