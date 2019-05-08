package com.stackroute.RecommendationService.service;


import com.stackroute.RecommendationService.domain.Freelancers;
import com.stackroute.RecommendationService.repository.FreelancerRecommendationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class FreelancerService {

    private FreelancerRecommendationRepository freelancerRecommendationRepository;

    @Autowired
    public FreelancerService(FreelancerRecommendationRepository freelancerRecommendationRepository) {
        this.freelancerRecommendationRepository=freelancerRecommendationRepository;
    }

    public List<Freelancers> getAllFreelancers(String skillName) {
        return freelancerRecommendationRepository.findBySkills(skillName);
    }

    public Iterable<Freelancers> saveFreelancers(String emailId){
        return freelancerRecommendationRepository.saveByEmailId(emailId);
    }

        public Iterable<Freelancers> saveBySkill(String EmailId,String skillName){
        return freelancerRecommendationRepository.saveBySkill(EmailId,skillName);
        }

}
