package com.stackroute.freelancerprofile.repository;

import com.stackroute.freelancerprofile.domain.Freelancer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreelancerRepository extends MongoRepository<Freelancer,String> {
}
