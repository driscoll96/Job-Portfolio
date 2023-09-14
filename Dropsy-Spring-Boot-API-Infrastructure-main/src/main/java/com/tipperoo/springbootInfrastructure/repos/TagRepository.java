package com.tipperoo.springbootInfrastructure.repos;

import com.tipperoo.springbootInfrastructure.dao.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Integer> {
}
