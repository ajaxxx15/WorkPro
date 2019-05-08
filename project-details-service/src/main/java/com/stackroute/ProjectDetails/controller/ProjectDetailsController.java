package com.stackroute.ProjectDetails.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.ProjectDetails.domain.*;
import com.stackroute.ProjectDetails.exceptions.UnauthorizedException;
import com.stackroute.ProjectDetails.listener.Producer;
import com.stackroute.ProjectDetails.exceptions.ProjectAlreadyExistsException;
import com.stackroute.ProjectDetails.exceptions.ProjectBidAlreadyAwardedException;
import com.stackroute.ProjectDetails.exceptions.ProjectDoesNotExistException;
import com.stackroute.ProjectDetails.service.BidService;
import com.stackroute.ProjectDetails.service.GeneratemailApplication;
import com.stackroute.ProjectDetails.service.ProjectOwnerProjectsServiceImpl;
import com.stackroute.ProjectDetails.service.SkillsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ProjectDetailsController {
    private ProjectOwnerProjectsServiceImpl projectOwnerProjectsService;
    private SkillsServiceImpl skillsService;
    private  Producer producer;
    private BidService bidService;


    @Autowired
    public ProjectDetailsController(ProjectOwnerProjectsServiceImpl projectOwnerProjectsService,SkillsServiceImpl skillsService,Producer producer,BidService bidService) {
        this.projectOwnerProjectsService = projectOwnerProjectsService;
        this.skillsService=skillsService;
        this.producer=producer;
        this.bidService=bidService;
    }


    /**
     * Project Owner searches his projects by id
     * @param projectId will be the project id which is automatic assigned to project while adding Projects
     * @param projectOwnerId will be Project Owner email id
     * @return ProjectDetails if it is there otherWise it will return not found
     */
    @GetMapping("/projectOwner/{projectOwnerId}/projects/{projectId}")
    public ResponseEntity<?> projectDetailsForFreelancer(@PathVariable("projectId") String projectId, @PathVariable("projectOwnerId") String projectOwnerId) {

        ProjectsOfProjectOwner allProjectsOfProjectOwner = projectOwnerProjectsService.getProjectsByEmailId(projectOwnerId);
        for (ProjectDetails details : allProjectsOfProjectOwner.getProjectDetailsList()) {
            //List<ProjectDetails> projectDetailsList = allProjectsOfProjectOwner.getProjectDetailsList();
                if (details.getProjectId().equals(projectId)){
                return new ResponseEntity<ProjectDetails>(details, HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>("Project Not Found", HttpStatus.OK);
    }

    /**
     * When Freelancer searches the Projects by SkillName
     * @param skillName skills
     * @return List of Projects
     */
    @GetMapping("/skill/{skillName}/projects")
    public ResponseEntity<?> freelancerProjectSearch(@PathVariable String skillName) {

        return new ResponseEntity< List<ProjectDetails>>(skillsService.searchBySkill(skillName), HttpStatus.OK);
    }
// freelancer can bid on a project but if it is null then problem
    /**
     *Freelancers bid on a project
     * @param header used for validation
     * @param request used for validation
     * @param bidOfFreelancer freelancer details
     * @param projectId freelancer bid on a project
     * @param projectOwnerId project owner email id
     * @return  Freelancer  bid on a project
     * @throws ProjectDoesNotExistException
     * @throws UnauthorizedException
     */
//    @PostMapping("/projectOwner/{projectOwnerId}/projects/{projectId}/bid")
//    public ResponseEntity<?> freelancerBidOnAProject (@RequestHeader HttpHeaders header, HttpServletRequest request, @RequestBody BidOfFreelancer bidOfFreelancer, @PathVariable("projectId") String projectId, @PathVariable("projectOwnerId") String projectOwnerId) throws ProjectDoesNotExistException, UnauthorizedException {
//
//        //long contentLength = header.getContentLength();
//        //String token=request.getHeader("token");
//        //if(token!=null){
//            ProjectsOfProjectOwner allProjectsOfProjectOwner = projectOwnerProjectsService.getProjectsByEmailId(projectOwnerId);
//            for (ProjectDetails details : allProjectsOfProjectOwner.getProjectDetailsList()) {
//                if (details.getProjectId().equals(projectId) ){
//                  //  System.out.println(details.getAllBidsOfFreelancers());
//
//                    if(details.getAllBidsOfFreelancers().isEmpty())
//                    {
//                        List<BidOfFreelancer> bidOfFreelancers = details.getAllBidsOfFreelancers();
//                        bidOfFreelancers.add(bidOfFreelancer);
//                        details.setAllBidsOfFreelancers(bidOfFreelancers);
//                    }
//                    else {
//                        if(details.getProjectStatus().equals("closed"))
//                        {
//                            return new ResponseEntity<String>(" You(Freelancer)  can't bid. Project has been closed", HttpStatus.OK);
//                        }
//                        else if(details.getAllBidsOfFreelancers().get(0).getFreelancerEmailId().equals(bidOfFreelancer.getFreelancerEmailId()))
//                        {
//                            return new ResponseEntity<String>(" You(Freelancer)  can't bid more than once", HttpStatus.OK);
//                        }
//                        else {
//                            List<BidOfFreelancer> bidOfFreelancers = details.getAllBidsOfFreelancers();
//                            bidOfFreelancers.add(bidOfFreelancer);
//                            details.setAllBidsOfFreelancers(bidOfFreelancers);
//                        }
//                    }
//                    projectOwnerProjectsService.addProjects(allProjectsOfProjectOwner);
//                    break;
//                }
//            }
//            return new ResponseEntity<String>(" You(Freelancer)  bid on a project", HttpStatus.OK);
//       // }
//        //else
//          //  throw new UnauthorizedException("Login Please");
//
//    }

    /**
     * Freelancer has won the project bid
     * @return Freelancer has won the project bid
     */
    @GetMapping("projects/projectId/bid/won")
    public ResponseEntity<?> freelancerBidsWon() {
        return new ResponseEntity<String>("Freelancer has won the project bid", HttpStatus.OK);
    }


    /**
     * Project Owner add his projects
     * Method also add projects with respect to skills in skills collections
     * @param projectsOfProjectOwner all the details provided by project owner
     * @return Project owner adds a project
     * @throws ProjectAlreadyExistsException
     */
    @PostMapping("/projects/project")
    public ResponseEntity<?> addProject(@RequestBody ProjectsOfProjectOwner projectsOfProjectOwner ) throws ProjectAlreadyExistsException  {

        ProjectsOfProjectOwner allProjectsOfProjectOwner = projectOwnerProjectsService.getProjectsByEmailId(projectsOfProjectOwner.getProjectOwnerEmailId());
        if(allProjectsOfProjectOwner!=null) {
            for (ProjectDetails projectDetails : allProjectsOfProjectOwner.getProjectDetailsList()) {
                if (projectDetails.getProjectId().equals(projectsOfProjectOwner.getProjectDetailsList().get(0).getProjectId())) {
                    throw new ProjectAlreadyExistsException();
                }
            }
        }

        if (allProjectsOfProjectOwner == null) {
            projectOwnerProjectsService.addProjects(projectsOfProjectOwner);

        } else {
            allProjectsOfProjectOwner.getProjectDetailsList().add(projectsOfProjectOwner.getProjectDetailsList().get(0));
            projectOwnerProjectsService.addProjects(allProjectsOfProjectOwner);
        }

        for(ProjectDetails details: projectsOfProjectOwner.getProjectDetailsList())
        {
            for(String skillsFromProjectOwner:details.getSkillsSetList())
            {
                Skills oldSkills= skillsService.findBySkillName(skillsFromProjectOwner);
                if(oldSkills==null)
                {
                    Skills newSkills = new Skills();
                    newSkills.setSkillName(skillsFromProjectOwner);
                    List<ProjectDetails> projectDetailsList = new ArrayList<>();
                    projectDetailsList.add(details);
                    newSkills.setProjectDetailsList(projectDetailsList);
                    this.skillsService.addProjectWrtSkills(newSkills);
                }
                else
                {
                    oldSkills.getProjectDetailsList().add(projectsOfProjectOwner.getProjectDetailsList().get(0));
                    this.skillsService.addProjectWrtSkills(oldSkills);
                }
            }
        }


        ProduceProject p = new ProduceProject();
        p.setProjectOwnerEmailId(projectsOfProjectOwner.getProjectOwnerEmailId());
        String a = "";


        for(ProjectDetails details: projectsOfProjectOwner.getProjectDetailsList())
        {
            String desc=details.getProjectDescription();
            String b=details.getProjectId();
            String projectName=details.getProjectName();
            p.setProjectDescription(desc);
            p.setProjectId(b);
            p.setProjectName(projectName);
            for(String skillsFromProjectOwner:details.getSkillsSetList())
            {

                System.out.println(skillsFromProjectOwner);
                a = a + skillsFromProjectOwner + " ";
//                System.out.println(a);
//                p.getSkillsSetList().add(skillsFromProjectOwner);

            }
        }


//        System.out.println(a);
        p.setSkillsSetList(a);
//        System.out.println(p);
//        p.setSkillsSetList();
        this.postToRecommendationService(p);
//        System.out.println(projectsOfProjectOwner);

        System.out.println("Producing -----------------------------");

        return new ResponseEntity<String>("Project owner adds a project", HttpStatus.OK);
    }


    /**
     * Project Owner gets all his projects
     * @param projectOwnerId project owner email id
     * @return all his projects
     */
    @GetMapping("/projectOwner/{projectOwnerId}/project")
    public ResponseEntity<ProjectsOfProjectOwner> projectOwnerViewsAllProjects(@PathVariable String projectOwnerId) {
        ProjectsOfProjectOwner allProjectsOfProjectOwner = projectOwnerProjectsService.getProjectsByEmailId(projectOwnerId);
        return new ResponseEntity<ProjectsOfProjectOwner>(allProjectsOfProjectOwner, HttpStatus.OK);
    }


    /**
     * When Project Owner accepts the bid from the freelancer
     * project status will be changed to closed
     * and project awarded will be true
     * @param email freelancer email id
     * @param projectId
     * @param projectOwnerId
     * @return Project owner accepts a bid
     * @throws ProjectBidAlreadyAwardedException
     */
    @Autowired
    GeneratemailApplication generatemailApplication;

    @PutMapping("/projectOwner/{projectOwnerId}/projects/{projectId}/bid/accept/{freelancerEmail}")
    public ResponseEntity<?> ownerAcceptsBid(@RequestBody EmailMessage emailMessage,@PathVariable("freelancerEmail") String email,@PathVariable("projectId") String projectId, @PathVariable("projectOwnerId") String projectOwnerId) throws ProjectBidAlreadyAwardedException,AddressException, MessagingException, IOException{
        System.out.println(projectOwnerId+"   This is projectownerid");
        System.out.println(projectId+"   This is projectid");
        System.out.println(email+"   This is freelancerEmailId");
        ProjectsOfProjectOwner allProjectsOfProjectOwner = projectOwnerProjectsService.getProjectsByEmailId(projectOwnerId);

        System.out.println("uhykuhkjhkjhkhkjhkhkhkhkhkhkh");
        List<BidKafka> listBid=bidService.getAll();
        System.out.println(allProjectsOfProjectOwner + "this guy is going null");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        for (ProjectDetails details : allProjectsOfProjectOwner.getProjectDetailsList()) {
            System.out.println("Inside project details");
            if (details.getProjectId().equals(projectId)) {

                details.setProjectStatus("closed");

                for (BidOfFreelancer freelancer : details.getAllBidsOfFreelancers()) {
                    System.out.println("Inside all bids of freelancers");
                    if (freelancer.getFreelancerEmailId().equals(email)) {
                        freelancer.setProjectAwarded(true);
                        System.out.println(freelancer.isProjectAwarded());
                        System.out.println("project awarded");
                        this.projectOwnerProjectsService.addProjects(allProjectsOfProjectOwner);
                        break;
                    }
                }
                break;
            }
        }

        System.out.println("hfhgfhgfhfhfhfhfhfhff");
        for(BidKafka bid:listBid) {
            if (bid.getFreelancerEmail().equals(email)){
                bid.setAwarded(true);
                producer.sendBid(bid);
                System.out.println(bid+"produced..........................................");
            }
        }
        System.out.println(emailMessage);
        emailMessage.setBody("Hello Freelancer!! \n Greetings for the day! \n You have been awarded a bid. Click on the link to view \n http://workpro.stackroute.io/#/projectDetailsComponent/"+projectId+"/"+ projectOwnerId );


        System.out.println("hjhjghjgjhghjghjghjgjjhgjhghjgj");
        generatemailApplication.sendmail(emailMessage);
        return new ResponseEntity<String>("Project owner accepts a bid", HttpStatus.OK);
    }


    /**
     * Project owner sees all the bids by freelancer on a particular projects
     * @param projectId id of projects
     * @param projectOwnerId
     * @return if the project is available it will return List of bids of freelancer  otherwise projects not found
     */
    @GetMapping("/projectOwner/{projectOwnerId}/projects/{projectId}/bids")
    public ResponseEntity<?> projectOwnerViewsAllBids(@PathVariable("projectId") String projectId, @PathVariable("projectOwnerId") String projectOwnerId) {

        ProjectsOfProjectOwner list = projectOwnerProjectsService.getProjectsByEmailId(projectOwnerId);
        for (ProjectDetails details : list.getProjectDetailsList()) {
            if (details.getProjectId().equals(projectId)){
                List<BidOfFreelancer> bidOfFreelancers = details.getAllBidsOfFreelancers();
                return new ResponseEntity<List<BidOfFreelancer>>(bidOfFreelancers, HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>("Project Not Found", HttpStatus.OK);
    }

    public static void postToRecommendationService(ProduceProject message) {
//
//        ObjectMapper Obj = new ObjectMapper();
//        String a = Obj.writeValueAsString(message)

        RestTemplate  rest = new RestTemplate();
        String  url = "http://localhost:8075/api/v1/project/projectDetailService";
        String a = rest.postForObject(url, message,  String.class);

    }
}
