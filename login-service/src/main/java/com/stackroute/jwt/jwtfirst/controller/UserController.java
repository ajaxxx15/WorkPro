package com.stackroute.jwt.jwtfirst.controller;


import com.stackroute.jwt.jwtfirst.model.User;
import com.stackroute.jwt.jwtfirst.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUsers(Principal principal)
    {
            List<User> users= userService.findall();
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }


    @GetMapping(value = "/getUser")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<User> getUser(Principal principal)
    {
      User user1= userService.getUserByEmail(principal.getName());
        return new ResponseEntity<User>(user1, HttpStatus.OK);
    }
}
