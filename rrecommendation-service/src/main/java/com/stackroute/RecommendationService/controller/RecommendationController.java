package com.stackroute.RecommendationService.controller;


import com.stackroute.RecommendationService.domain.Freelancers;
import com.stackroute.RecommendationService.domain.ProjectKafka;
import com.stackroute.RecommendationService.domain.Projects;
import com.stackroute.RecommendationService.domain.ProjectsNeo4j;
import com.stackroute.RecommendationService.service.FreelancerService;
import com.stackroute.RecommendationService.service.ProjectService;
import com.stackroute.RecommendationService.service.ProjectsNeo4jService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class RecommendationController {
    private FreelancerService freelancerService;
    private ProjectService projectService;
    private ProjectsNeo4jService projectsNeo4jService;
    @Autowired
    public RecommendationController(FreelancerService freelancerService, ProjectService projectService,ProjectsNeo4jService projectsNeo4jService) {
        this.freelancerService = freelancerService;
        this.projectService = projectService;
        this.projectsNeo4jService=projectsNeo4jService;
    }



//The below method is used to retrieve all freelancers with a particular skill
//    @GetMapping("/recommendations/allfreelancer/Skill/{skillName}")
//    public ResponseEntity<Iterable<Freelancers>> getAllFreelancers(@PathVariable String skillName) {
//        Iterable<Freelancers> freelancers = freelancerService.getAllFreelancers(skillName);
//        return new ResponseEntity<>(freelancers, HttpStatus.OK);
//    }



//The below method is used to retrieve all projects with a particular skill
//@GetMapping("/recommendations/allfreelancer/Skill/{skillName}")
//public ResponseEntity<Iterable<Projects>> getAllProjects(@PathVariable String skillName) {
//    Iterable<Projects> projects = projectService.getAllProjects(skillName);
//    return new ResponseEntity<>(projects, HttpStatus.OK);
//}


    @GetMapping("/recommendations/allfreelancer/Skill/{skillName}")
    public ResponseEntity<Iterable<Freelancers>> getAllFreelancers(@PathVariable List<String> skillName) {
        List<Freelancers> freelancers=new ArrayList<>();
        for (String param:skillName) {
            freelancers.addAll(freelancerService.getAllFreelancers(param));
        }
        return new ResponseEntity<>(freelancers, HttpStatus.OK);
    }

    @GetMapping("/recommendations/allProjects/Skill/{skillName}")
    public ResponseEntity<Iterable<ProjectsNeo4j>> getAllProjects(@PathVariable List<String> skillName) {
        List<ProjectsNeo4j> projects= new ArrayList<>() ;
        for (String param : skillName) {
            System.out.println(param);
            projects.addAll(projectsNeo4jService.getAllProjects(param));
        }

        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
    @PostMapping("/project/projectDetailService")
    public void anymethod(@RequestBody ProjectKafka a)
    {
//        List<String> allrequiredSkills = Arrays.asList(a.getSkillsSetList().split(","));
//        System.out.println(allrequiredSkills);
        System.out.println(a);
        a.getSkillsSetList().trim();
        List<String> allrequiredSkills = Arrays.asList(a.getSkillsSetList().split(" "));
        System.out.println(allrequiredSkills);
        String pid=a.getProjectId();
        String emailId=a.getProjectOwnerEmailId();
        String projectName=a.getProjectName();

        String desc=a.getProjectDescription();
        System.out.println(emailId+"This is emailId");
        System.out.println(projectName+"This is projectName");
        this.projectsNeo4jService.saveProjects(pid,emailId,desc,projectName);
//        List<Projects> projects= new ArrayList<>() ;
        for (String param : allrequiredSkills) {
            System.out.println(param);
          this.projectsNeo4jService.saveBySkill(pid,param);
        }

    }

}
