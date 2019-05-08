package com.stackroute.freelancerprofile.controller;

import com.stackroute.freelancerprofile.domain.*;
import com.stackroute.freelancerprofile.exception.UnauthorizedException;
//import com.stackroute.freelancerprofile.listener.Consumer;
import com.stackroute.freelancerprofile.listener.Producer;
import com.stackroute.freelancerprofile.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class FreelancerController {
    private FreelancerServiceImpl freelancerService;
    private BidServiceImpl bidService;
    private SkillServiceImpl skillService;
    private Skill skillObject;
    private List<Freelancer> list;
    private Freelancer freelancer;
    private Producer producer;
    private GeneratemailApplication generatemailApplication;
    private BidKafkaService bidKafkaService;
    private static final Logger LOGGER = LoggerFactory.getLogger(SkillServiceImpl.class);

    @Autowired
    public FreelancerController(GeneratemailApplication generatemailApplication,BidKafkaService bidKafkaService,Producer producer, FreelancerServiceImpl freelancerService, BidServiceImpl bidService, SkillServiceImpl skillService, List<Freelancer> list, Skill skillObject, Freelancer freelancer) {
        this.freelancerService = freelancerService;
        this.bidService = bidService;
        this.skillService = skillService;
        this.list = list;
        this.skillObject = skillObject;
        this.freelancer = freelancer;
        this.producer=producer;
        this.generatemailApplication=generatemailApplication;
        this.bidKafkaService=bidKafkaService;

    }


//    freelancer registers for the first time
    @PostMapping("/freelancerprofile/postDetails")
    public ResponseEntity<?> postDetail(@RequestBody Freelancer newfreelancer) {
        freelancer = freelancerService.save(newfreelancer);



        for (String string : newfreelancer.getSkills()) {
            Skill result = new Skill();
            List<Freelancer> freelancersList = new ArrayList<>();
            Skill newSkill = new Skill();
            boolean found = false;


            List<Skill> listSkill = skillService.getAll();
            if (listSkill.isEmpty()) {
                LOGGER.info("Inside isEmpty\n\n");
                newSkill.setSkill(string);
                freelancersList.add(newfreelancer);
                newSkill.setList(freelancersList);

                result = skillService.save(newSkill);
            } else {
                for (Skill s : listSkill) {
                    LOGGER.info("Inside FOR\n\n");


                    if (s.getSkill().equals(string)) {

                        LOGGER.info("Inside IF\n\n");
                        LOGGER.info("\n\nSkill ID : " + s.getId());

                        result = skillService.findById(s.getId());
                        List<Freelancer> list1 = s.getList();
                        list1.add(newfreelancer);
                        result.setList(list1);

                        LOGGER.info("newSkill ID : " + result.getId());

                        result = skillService.save(result);
                        found = true;
                    }
                }
            }

            if (found == false && !listSkill.isEmpty()) {
                LOGGER.info("Inside ELSE\n\n");
                newSkill.setSkill(string);
                freelancersList.add(newfreelancer);
                newSkill.setList(freelancersList);
                result = skillService.save(newSkill);
            }

        }
        System.out.println(freelancer);
        producer.sendFreelancer(freelancer);
        return new ResponseEntity<String>("here", HttpStatus.OK);
    }


    @GetMapping("/freelancer/{id}")
    public ResponseEntity<?> getDetails(@PathVariable("id") String id) {
        Freelancer freelancer = freelancerService.search(id);
        return new ResponseEntity<Freelancer>(freelancer, HttpStatus.OK);
    }

    @PostMapping("/bid/bidDetails")
    public ResponseEntity<?> postBidInformation(@RequestBody Bid bid, @RequestHeader HttpHeaders header, HttpServletRequest request) {
        long contentLength = header.getContentLength();
        String token = request.getHeader("token");
//        if (token != null) {
            Bid resultbid = bidService.save(bid);

            producer.sendBid(bid);
            return new ResponseEntity<Bid>(resultbid, HttpStatus.OK);
//        } else
//            throw new UnauthorizedException("login please");

    }


    @GetMapping("/bid/allbids/{freelancerEmail}")
    public ResponseEntity<?> getBidinformation(@PathVariable("freelancerEmail") String freelancerEmail) {
        List<Bid> result = bidService.allBids(freelancerEmail);
        return new ResponseEntity<List<Bid>>(result, HttpStatus.OK);

    }

    @GetMapping("/bid/awardedBids/{freelancerEmail}")
    public ResponseEntity<?> getAwardedBids(@PathVariable("freelancerEmail") String id) {
        List<BidKafka> result=bidKafkaService.search(id);
        return new ResponseEntity<List<BidKafka>>(result, HttpStatus.OK);

    }

    @PutMapping("/freelancerprofile/{id}")
    public ResponseEntity<?> editProfile(@RequestBody Freelancer freelancer, @PathVariable("id") String id) {

        return new ResponseEntity<Freelancer>(freelancerService.edit(freelancer, id), HttpStatus.OK);
    }

    @GetMapping("/skill/{skill}")
    public ResponseEntity<?> searchBySkill(@PathVariable("skill") String skill) {

        return new ResponseEntity<Skill>(skillService.search(skill), HttpStatus.OK);
    }



    @PostMapping("/send/{projectID}/{email}")
    public String sendEmail(@RequestBody EmailMessage emailmessage,@PathVariable("email") String email,@PathVariable("projectID") String projectID) throws AddressException, MessagingException, IOException {
//        emailmessage.setSubject("congratulations! You have been invited");
//        System.out.println(emailmessage.getSubject());

        emailmessage.setBody("Hello Freelancer!! \n  " +
                "Greetings for the day! \n" +
                "You re been invited for bidding.Kindly go through the link to start the process of bidding \n"+
                "http://workpro.stackroute.io/#/projectDetailsComponent/"+projectID+"/"+email );




        generatemailApplication.sendmail(emailmessage);
        return "Email sent successfully";
    }


}
