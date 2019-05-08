package com.stackroute.jwt.jwtfirst.service;

import com.stackroute.jwt.jwtfirst.exception.UserAlreadyException;
import com.stackroute.jwt.jwtfirst.model.User;
import com.stackroute.jwt.jwtfirst.repo.UserRepository;
import com.stackroute.jwt.jwtfirst.security.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;


    public User save(User user) throws UserAlreadyException{
        List<User> list = (List<User>) userRepository.findAll();
        for (User user1 : list) {
            if ((user1.getEmail()).equals(user.getEmail())) {
                throw new UserAlreadyException("user Already exists");
            }
        }
            String password = PasswordUtil.getPasswordHash(user.getPassword());
            user.setPassword(password);
            user.setDate(new Date());


        return userRepository.save(user);
    }


    public List<User> findall() {
      List<User> userlist= (List<User>) userRepository.findAll();
      return userlist;
    }


    public User getUserByEmail(String email) {
        return userRepository.findByEmailIgnoreCase(email);
    }
}
