package com.stackroute.RecommendationService.listener;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.stackroute.RecommendationService.domain.Freelancers;
import com.stackroute.RecommendationService.domain.ProjectKafka;
import com.stackroute.RecommendationService.domain.Projects;
import com.stackroute.RecommendationService.service.FreelancerService;
import com.stackroute.RecommendationService.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.CountDownLatch;

@Service
public class Consumer {
    private CountDownLatch latch = new CountDownLatch(1);
    @Autowired
    private FreelancerService freelancerService;
    @Autowired
    private ProjectService projectService;


    public Consumer() {
    }

    public CountDownLatch getLatch() {
        return latch;
    }

//    @KafkaListener(topics = "freelancerTopic")
//    public void receive(Freelancers freelancer) {
//        System.out.println("inside kafka ***************************");
//        System.out.println(freelancer);
////        freelancerService.saveFreelancers(freelancer.getEmailId());
//    }
//    @KafkaListener(topics = "freelancerTopic")
//    public void receive(Object message) {
//        Gson gson =new Gson();
//        Freelancers freelancers=gson.fromJson(gson.fromJson(gson.toJson(message), Map.class).get("value").toString(),Freelancers.class);
//
//    }

//    @KafkaListener(topics = "projectTopic")
//    public void receive(Projects projects) {
//
//        System.out.println(projects);
//        projectService.saveProjects(projects.getProjectId());
//    }
    @KafkaListener(topics = "freelancerTopic")
    public void receiveFreelancer(Object message) {

        System.out.println(message);
        Gson gson =new Gson();
        Freelancers freelancers=gson.fromJson(gson.fromJson(gson.toJson(message), Map.class).get("value").toString(),Freelancers.class);

        System.out.println(freelancers);
        freelancerService.saveFreelancers(freelancers.getFreelancerEmail());
        String emailId=freelancers.getFreelancerEmail();
        for (String param : freelancers.getSkills()) {
            System.out.println(param);
            freelancerService.saveBySkill(emailId,param);
        }

//        freelancerService.saveBySkill(freelancers.getSkills());
    }
//    @KafkaListener(topics = "projectTopic")
//    public void receiveProject(ProjectKafka message) {
//
//        System.out.println(message);
////        Gson gson =new Gson();
////        Projects projects=gson.fromJson(gson.fromJson(gson.toJson(message), Map.class).get("value").toString(),Projects.class);
//
////        System.out.println(projects);
////        projectService.saveProjects(projects.getProjectId());
//    }


}
