package com.stackroute.RecommendationService.service;

import com.stackroute.RecommendationService.domain.Projects;
import com.stackroute.RecommendationService.repository.ProjectRecommendationsRepository;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProjectService {
    private ProjectRecommendationsRepository projectRecommendationsRepository;
    @Autowired
    public ProjectService(ProjectRecommendationsRepository projectRecommendationsRepository) {
        this.projectRecommendationsRepository=projectRecommendationsRepository;
    }

    public List<Projects> getAllProjects(String skillName) {

        return projectRecommendationsRepository.findBySkills(skillName);
    }

    public Iterable<Projects> saveProjects(String ProjectId){
        return projectRecommendationsRepository.saveByProjectId(ProjectId);
    }

    public Iterable<Projects> saveBySkill(String ProjectId,String skillName) {
        return projectRecommendationsRepository.saveBySkill(ProjectId,skillName);
    }
}
