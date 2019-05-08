package com.stackroute.projectownerprofile.controller;


import com.stackroute.projectownerprofile.domain.ProjectOwner;
import com.stackroute.projectownerprofile.service.ProjectOwnerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ProjectOwnerController {

    private ProjectOwnerServices projectOwnerServices;

    @Autowired
    public ProjectOwnerController(@RequestBody ProjectOwnerServices projectOwnerServices) {
        this.projectOwnerServices = projectOwnerServices;
    }


    @PostMapping("/projectOwner/projectOwnerId")
        public ResponseEntity<?> post(@RequestBody ProjectOwner projectOwner){
            ProjectOwner po=projectOwnerServices.post(projectOwner);
            return new ResponseEntity<ProjectOwner>(po, HttpStatus.CREATED);
        }

        @GetMapping("/projectOwner/{email}")
        public ResponseEntity<?> getProjectOwner(@PathVariable("email") String email){
            ProjectOwner po=projectOwnerServices.getProjectOwner(email);
            return new ResponseEntity<ProjectOwner>(po,HttpStatus.OK);
        }

}
