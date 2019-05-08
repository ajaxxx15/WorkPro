package com.stackroute.ProjectDetails.service;

import com.stackroute.ProjectDetails.domain.ProjectsOfProjectOwner;
import org.springframework.stereotype.Service;


@Service
public interface ProjectOwnerProjectsService {
     void addProjects(ProjectsOfProjectOwner projectsOfProjectOwner);
     ProjectsOfProjectOwner getProjectsByEmailId(String projectOwnerEmailId);

}
