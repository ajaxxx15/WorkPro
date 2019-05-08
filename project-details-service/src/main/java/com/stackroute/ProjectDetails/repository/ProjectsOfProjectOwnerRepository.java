package com.stackroute.ProjectDetails.repository;


import com.stackroute.ProjectDetails.domain.ProjectsOfProjectOwner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectsOfProjectOwnerRepository extends MongoRepository<ProjectsOfProjectOwner,String> {

    ProjectsOfProjectOwner findByProjectOwnerEmailId(String projectOwnerEmailId);

}
