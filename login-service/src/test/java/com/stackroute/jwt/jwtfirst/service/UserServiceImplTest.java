//package com.stackroute.jwt.jwtfirst.service;
//
//import com.stackroute.jwt.jwtfirst.model.User;
//import com.stackroute.jwt.jwtfirst.repo.UserRepository;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.mockito.internal.verification.VerificationModeFactory.times;
//
//public class UserServiceImplTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    private User user;
//
//    //Create a mock for UserRepository
//    @Mock
//    private UserRepository userRepository;
//
//    //Inject the mocks as dependencies into UserServiceImpl
//    @InjectMocks
//    private UserServiceImpl userService;
//    List<User> list = null;
//
//    @Before
//    public void setUp() throws Exception {
//            //Initialising the mock object
//            MockitoAnnotations.initMocks(this);
//            user=new User();
//            user.setId(1);
//            user.setFirstName("Anusha");
//            user.setLastName("Nayak");
//            user.setEmail("anushanayak00@gmail.com");
//            user.setPassword("Anusha123");
//            user.setRole("USER");
//            user.setEnable(true);
//            user.setPhonenumber("9972171647");
//            list=new ArrayList<>();
//            list.add(user);
//        }
//
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void saveUser() {
//        when(userRepository.save((User) any())).thenReturn(user);
//        User savedUser = userService.save(user);
//        Assert.assertEquals(user, savedUser);
//        //verify here verifies that userRepository save method is only called once
//        Mockito.verify(userRepository, times(1)).save(user);
//    }
//
//
//    @Test
//    public void saveUserFailure() {
//        when(userRepository.save((User) any())).thenReturn(null);
//        User savedUser = userService.save(user);
//        System.out.println("savedUser" + savedUser);
//        Assert.assertNotEquals(user, savedUser);
//    }
//
//    @Test
//    public void findall() {
//        userRepository.save(user);
//        when(userRepository.findAll()).thenReturn(list);
//        List<User> userList=userService.findall();
//        Assert.assertEquals(list,userList);
//
//    }
//
//}