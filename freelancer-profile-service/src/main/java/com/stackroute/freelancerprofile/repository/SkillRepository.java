package com.stackroute.freelancerprofile.repository;

import com.stackroute.freelancerprofile.domain.Skill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends MongoRepository<Skill,String> {
}
