package com.stackroute.jwt.jwtfirst.controller;

import com.stackroute.jwt.jwtfirst.exception.UnauthorizedException;
import com.stackroute.jwt.jwtfirst.domain.UserDTO;
import com.stackroute.jwt.jwtfirst.model.User;
import com.stackroute.jwt.jwtfirst.security.JwtTokenUtil;
import com.stackroute.jwt.jwtfirst.security.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class AuthenticationController {

    @Value("${jwt.header}")
    private  String tokenHeader;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login1 (@RequestBody User user, HttpServletRequest request, HttpServletResponse response)
    {
        try {
            Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
            final JwtUser userDetails =(JwtUser) authentication.getPrincipal();
            SecurityContextHolder.getContext().setAuthentication(authentication);
            final String token = jwtTokenUtil.generateToken(userDetails);
            response.setHeader("token", token);
            return new ResponseEntity<>(new UserDTO(userDetails.getUser(), token), HttpStatus.OK);
        }
        catch (Exception e)
        {
            throw new UnauthorizedException(e.getMessage());
        }

    }
}
