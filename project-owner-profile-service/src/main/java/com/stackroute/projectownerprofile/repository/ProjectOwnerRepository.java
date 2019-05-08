package com.stackroute.projectownerprofile.repository;

import com.stackroute.projectownerprofile.domain.ProjectOwner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProjectOwnerRepository extends MongoRepository<ProjectOwner,String> {
}
