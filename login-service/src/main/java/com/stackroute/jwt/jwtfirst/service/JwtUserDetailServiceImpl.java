package com.stackroute.jwt.jwtfirst.service;

import com.stackroute.jwt.jwtfirst.security.JwtUserFactory;
import com.stackroute.jwt.jwtfirst.model.User;
import com.stackroute.jwt.jwtfirst.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class JwtUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmailIgnoreCase(username);
        if(user == null){
            throw new UsernameNotFoundException(String.format("No User found with username '%s'.",username));
        }else{
            return JwtUserFactory.create(user);
        }

    }
}
