package com.tipperoo.springbootInfrastructure.repos;

import com.tipperoo.springbootInfrastructure.dao.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer>  {
}
