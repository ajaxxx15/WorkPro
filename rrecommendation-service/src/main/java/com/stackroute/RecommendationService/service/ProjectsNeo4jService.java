package com.stackroute.RecommendationService.service;

import com.stackroute.RecommendationService.domain.Projects;
import com.stackroute.RecommendationService.domain.ProjectsNeo4j;
import com.stackroute.RecommendationService.repository.ProjectRecommendationsRepository;
import com.stackroute.RecommendationService.repository.ProjectsNeo4jRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsNeo4jService {
    private ProjectsNeo4jRecommendationRepository projectsNeo4jRecommendationRepository;
    @Autowired
    public ProjectsNeo4jService(ProjectsNeo4jRecommendationRepository projectsNeo4jRecommendationRepository) {
        this.projectsNeo4jRecommendationRepository=projectsNeo4jRecommendationRepository;
    }

    public List<ProjectsNeo4j> getAllProjects(String skillName) {

        return projectsNeo4jRecommendationRepository.findBySkills(skillName);
    }

    public Iterable<ProjectsNeo4j> saveProjects(String ProjectId,String projectOwnerEmailId,String projectDescription,String projectName){
        System.out.println(projectName+" This is inside service");
        return projectsNeo4jRecommendationRepository.saveByProjectId(ProjectId,projectOwnerEmailId,projectDescription,projectName);
    }

    public Iterable<ProjectsNeo4j> saveBySkill(String ProjectId,String skillName) {
        return projectsNeo4jRecommendationRepository.saveBySkill(ProjectId,skillName);
    }
}
