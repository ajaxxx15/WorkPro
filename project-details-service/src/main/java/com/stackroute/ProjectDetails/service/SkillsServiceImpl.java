package com.stackroute.ProjectDetails.service;

import com.stackroute.ProjectDetails.domain.ProjectDetails;
import com.stackroute.ProjectDetails.domain.Skills;
import com.stackroute.ProjectDetails.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsServiceImpl implements SkillsService {
    private SkillRepository skillRepository;

    @Autowired
    public SkillsServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public void addProjectWrtSkills(Skills skills) {
        skillRepository.save(skills);
    }
    public Skills findBySkillName(String skillName)
    {
        List<Skills>  skillsList=skillRepository.findAll();
        for(Skills skills:skillsList)
        {
            if(skills.getSkillName().equals(skillName))
            {
                return skills;
            }
        }
        return null;
    }

    @Override
    public List<ProjectDetails> searchBySkill(String skillName){
        List<Skills>  skillsList=skillRepository.findAll();
        for(Skills skills:skillsList)
        {
            if(skills.getSkillName().equals(skillName))
            {
                List<ProjectDetails> projectDetailsList=skills.getProjectDetailsList();
                return projectDetailsList;
            }
        }
        return null;
    }
}
