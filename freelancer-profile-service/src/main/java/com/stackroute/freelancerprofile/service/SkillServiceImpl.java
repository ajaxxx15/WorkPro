package com.stackroute.freelancerprofile.service;


import com.stackroute.freelancerprofile.domain.Skill;
import com.stackroute.freelancerprofile.repository.SkillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SkillServiceImpl implements SkillService {
    private SkillRepository skillRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(SkillServiceImpl.class);


    @Autowired
    SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill save(Skill skill) {
        Skill result = skillRepository.save(skill);
        return result;
    }
    public List<Skill> getAll(){
        return skillRepository.findAll();
    }
    public Skill findById(String id){
        return skillRepository.findById(id).get();
    }

    public Skill search(String skill) {

        Skill result=new Skill();
        List<Skill> list=(List<Skill>)skillRepository.findAll();
        for(Skill skill1:list){
             if((skill1.getSkill()).equals(skill)){
                 LOGGER.info("inside if............................."+skill);
                 LOGGER.info(skill1.getSkill());
                 result.setSkill(skill1.getSkill());
                 result.setList(skill1.getList());
             }
         }
      return result;
    }
}

