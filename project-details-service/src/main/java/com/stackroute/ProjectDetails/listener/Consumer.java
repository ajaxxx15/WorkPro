package com.stackroute.ProjectDetails.listener;

import com.stackroute.ProjectDetails.domain.BidKafka;
import com.stackroute.ProjectDetails.domain.BidOfFreelancer;
import com.stackroute.ProjectDetails.domain.ProjectDetails;
import com.stackroute.ProjectDetails.domain.ProjectsOfProjectOwner;
import com.stackroute.ProjectDetails.exceptions.ProjectDoesNotExistException;
import com.stackroute.ProjectDetails.exceptions.UnauthorizedException;
import com.stackroute.ProjectDetails.service.BidService;
import com.stackroute.ProjectDetails.service.ProjectOwnerProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Consumer {
    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private BidService bidService;
    @Autowired
   private ProjectOwnerProjectsService projectOwnerProjectsService;


//    public Consumer(ProjectOwnerProjectsService projectOwnerProjectsService,BidService bidService) {
//        this.projectOwnerProjectsService = projectOwnerProjectsService;
//        this.bidService = bidService;
//    }

    public Consumer() {
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "myTopic")
    public void receive(BidKafka bidKafka) {
        bidService.save(bidKafka);

       // System.out.println(bidKafka);
        BidOfFreelancer bidOfFreelancer=new BidOfFreelancer(bidKafka.getFreelancerEmail(),bidKafka.getDuration(),bidKafka.getBidAmount(),bidKafka.isAwarded());
        System.out.println(bidOfFreelancer+"<,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");

       // System.out.println("******** object "+ projectOwnerProjectsService.getClass());
            ProjectsOfProjectOwner allProjectsOfProjectOwner = projectOwnerProjectsService.getProjectsByEmailId(bidKafka.getProjectOwnerEmail());
        //System.out.println(allProjectsOfProjectOwner);
            for (ProjectDetails details : allProjectsOfProjectOwner.getProjectDetailsList()) {
                if (details.getProjectId().equals(bidKafka.getProjectId()) ){


                    if(details.getAllBidsOfFreelancers().isEmpty())
                    {
                        List<BidOfFreelancer> bidOfFreelancers = details.getAllBidsOfFreelancers();
                        bidOfFreelancers.add(bidOfFreelancer);
                        details.setAllBidsOfFreelancers(bidOfFreelancers);
                    }
                    else {
//
                            List<BidOfFreelancer> bidOfFreelancers = details.getAllBidsOfFreelancers();
                            bidOfFreelancers.add(bidOfFreelancer);
                            details.setAllBidsOfFreelancers(bidOfFreelancers);
//
                    }
                    projectOwnerProjectsService.addProjects(allProjectsOfProjectOwner);
                }
            }

    }
}
