//package com.stackroute.jwt.jwtfirst.repo;
//
//import com.stackroute.jwt.jwtfirst.controller.UserController;
//import com.stackroute.jwt.jwtfirst.model.User;
//import com.stackroute.jwt.jwtfirst.service.UserServiceImpl;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.*;
//
//
//@RunWith(SpringRunner.class)
//@DataMongoTest
//public class UserRepositoryTest {
//    @Autowired
//    private UserRepository userRepository;
//    private User user;
//    @MockBean
//    private UserServiceImpl userService;
//    @InjectMocks
//    private UserController userController;
//
//    @Before
//    public void setUp() throws Exception {
//        user = new User();
//        user.setId(1);
//        user.setFirstName("Anusha");
//        user.setLastName("Nayak");
//        user.setEmail("anushanayak00@gmail.com");
//        user.setPassword("Anusha123");
//        user.setRole("USER");
//        user.setEnable(true);
//        user.setPhonenumber("9972171647");
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        userRepository.deleteAll();
//    }
//
//    @Test
//    public void saveUser() throws Exception {
//        userRepository.save(user);
//        User fetchUser = userRepository.findById(user.getId()).get();
//        Assert.assertEquals(1, fetchUser.getId());
//    }
//}
//
////    }
//
////    @Test
////    public void testSavePostFailure() {
////        User testProgram = new User(2,"Anu","Nayak","anusha@gmail.com","Anusha123","USER",true,"9741084525");
////        userRepository.save(user);
////        User fetchUser = userRepository.findById(user.getId()).get();
////        Assert.assertNotSame(testProgram, user);
////    }
//
