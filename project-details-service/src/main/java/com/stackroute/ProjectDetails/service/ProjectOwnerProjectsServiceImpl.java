package com.stackroute.ProjectDetails.service;

import com.stackroute.ProjectDetails.domain.ProjectsOfProjectOwner;

import com.stackroute.ProjectDetails.repository.ProjectsOfProjectOwnerRepository;
import com.stackroute.ProjectDetails.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProjectOwnerProjectsServiceImpl implements ProjectOwnerProjectsService {
    private ProjectsOfProjectOwnerRepository projectsOfProjectOwnerRepository;
    private SkillRepository skillRepository;

    @Autowired
    public ProjectOwnerProjectsServiceImpl(ProjectsOfProjectOwnerRepository projectsOfProjectOwnerRepository,SkillRepository skillRepository) {
        this.projectsOfProjectOwnerRepository = projectsOfProjectOwnerRepository;
        this.skillRepository=skillRepository;
    }


    //......................................project owner add projects.............
    @Override
    public void addProjects(ProjectsOfProjectOwner projectsOfProjectOwner) {
        projectsOfProjectOwnerRepository.save(projectsOfProjectOwner);
    }


    //    .................................project owner search all his projects........
    @Override
    public ProjectsOfProjectOwner getProjectsByEmailId(String projectOwnerEmailId) {
        return projectsOfProjectOwnerRepository.findByProjectOwnerEmailId(projectOwnerEmailId);
    }
    public ProjectsOfProjectOwner getProjectsById(String projectOwnerEmailId){
        Optional<ProjectsOfProjectOwner> ob= projectsOfProjectOwnerRepository.findById(projectOwnerEmailId);
        return ob.get();
    }
}
