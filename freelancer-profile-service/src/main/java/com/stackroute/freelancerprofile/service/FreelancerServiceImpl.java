package com.stackroute.freelancerprofile.service;

import com.stackroute.freelancerprofile.domain.Freelancer;
import com.stackroute.freelancerprofile.domain.Skill;
import com.stackroute.freelancerprofile.exception.UserNotFound;
import com.stackroute.freelancerprofile.repository.FreelancerRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class FreelancerServiceImpl implements FreelancerService {

    private FreelancerRepository freelancerRepository;

    @Autowired
    FreelancerServiceImpl(FreelancerRepository freelancerRepository){
        this.freelancerRepository=freelancerRepository;
    }

    public Freelancer save(Freelancer freelancer){
        Freelancer result=freelancerRepository.save(freelancer);
        return result;

    }
    public List<Freelancer> getAll(){
        List<Freelancer> list=freelancerRepository.findAll();
        return list;
    }


    public Freelancer edit(Freelancer freelancer,String id){

        Freelancer fetcherFreelancer=new Freelancer();
        List<Freelancer> result = freelancerRepository.findAll();
        for(Freelancer skill1:result) {
            fetcherFreelancer.setFreelancerAddress(freelancer.getFreelancerAddress());
            fetcherFreelancer.setFreelancerName(freelancer.getFreelancerName());
            fetcherFreelancer.setFreelancerEmail(freelancer.getFreelancerEmail());
            fetcherFreelancer.setSkills(freelancer.getSkills());
            fetcherFreelancer.setYearsOfExpertise(freelancer.getYearsOfExpertise());
        }
       return freelancerRepository.save(fetcherFreelancer);
    }
    public Freelancer search(String id)
        {
        Freelancer resultFreelancer=new Freelancer();
        List<Freelancer> list = freelancerRepository.findAll();
        for(Freelancer skill1:list){
            if((skill1.getFreelancerEmail()).equals(id)){
                System.out.println(id);
                resultFreelancer.setFreelancerName(skill1.getFreelancerName());
                resultFreelancer.setFreelancerAddress(skill1.getFreelancerAddress());
                resultFreelancer.setId(skill1.getId());
                resultFreelancer.setYearsOfExpertise(skill1.getYearsOfExpertise());
                resultFreelancer.setSkills(skill1.getSkills());
                resultFreelancer.setFreelancerEmail(skill1.getFreelancerEmail());
                System.out.println(resultFreelancer);
            }
        }
        return resultFreelancer;

    }

}
