//package com.stackroute.jwt.jwtfirst.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.jwt.jwtfirst.model.User;
//import com.stackroute.jwt.jwtfirst.repo.UserRepository;
//import com.stackroute.jwt.jwtfirst.service.UserServiceImpl;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class PreloginControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//    private User user;
//
//    @MockBean
//    private UserServiceImpl userService;
//
//    @InjectMocks
//    private UserController userController;
//    private List<User> list;
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup().build();
//        user=new User();
//        user.setId(1);
//        user.setFirstName("Anusha");
//        user.setLastName("Nayak");
//        user.setEmail("anushanayak00@gmail.com");
//        user.setPassword("Anusha123");
//        user.setRole("USER");
//        user.setEnable(true);
//        user.setPhonenumber("9972171647");
//        list=new ArrayList<>();
//        list.add(user);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void registration()throws Exception {
//        when(userService.save((User) any())).thenReturn(user);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/registration")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    private static String asJsonString(final Object obj)
//    {
//        try{
//            return new ObjectMapper().writeValueAsString(obj);
//
//        }catch(Exception e){
//            throw new RuntimeException(e);
//        }
//    }
//
//}
