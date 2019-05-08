package com.stackroute.ProjectDetails.repository;

import com.stackroute.ProjectDetails.domain.Skills;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends MongoRepository<Skills,String> {

}
