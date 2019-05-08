package com.stackroute.ProjectDetails.service;

import com.stackroute.ProjectDetails.domain.ProjectDetails;
import com.stackroute.ProjectDetails.domain.Skills;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SkillsService {
     void addProjectWrtSkills(Skills skills);
     Skills findBySkillName(String  skillName);
     List<ProjectDetails> searchBySkill(String skillName);
}
