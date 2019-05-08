package com.stackroute.jwt.jwtfirst.controller;


import com.stackroute.jwt.jwtfirst.domain.Response;
import com.stackroute.jwt.jwtfirst.exception.UserAlreadyException;
import com.stackroute.jwt.jwtfirst.model.User;
import com.stackroute.jwt.jwtfirst.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class PreloginController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody User user) {
        Response response=new Response();
        try {
            User user1 = userService.save(user);
            if (user1 != null) {
//                return new ResponseEntity<>(new Response("user is successfully added"), HttpStatus.OK);
                response.setMessage("User is successfully added");
            }
        }
        catch( UserAlreadyException e){
            response.setMessage(e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
