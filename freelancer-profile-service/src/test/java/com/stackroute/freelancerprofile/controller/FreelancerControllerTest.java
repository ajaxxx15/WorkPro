//package com.stackroute.freelancerprofile.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.freelancerprofile.domain.Bid;
//import com.stackroute.freelancerprofile.domain.Freelancer;
//import com.stackroute.freelancerprofile.domain.Skill;
//import com.stackroute.freelancerprofile.service.BidServiceImpl;
//import com.stackroute.freelancerprofile.service.FreelancerServiceImpl;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
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
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class FreelancerControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    private Freelancer freelancer;
//    private Bid bid;
//
//    @MockBean
//    private FreelancerServiceImpl freelancerService;
//    private BidServiceImpl bidService;
//
//    @InjectMocks
//    private FreelancerController freelancerController;
//    private List<Freelancer> list;
//
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(freelancerController).build();
//        freelancer=new Freelancer();
//        freelancer.setId("1");
//        freelancer.setFreelancerName("Anusha");
//        freelancer.setFreelancerEmail("anushanayak00@gmail.com");
//        freelancer.setFreelancerAddress("bangalore");
//        freelancer.setYearsOfExpertise(5);
//        list=new ArrayList();
//        list.add(freelancer);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
////    @Test
////    public void postDetail()throws Exception {
////        when(freelancerService.save((Freelancer) any())).thenReturn(freelancer);
////        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/freelancerprofile/postDetails")
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(freelancer)))
////                .andExpect(MockMvcResultMatchers.status().isCreated())
////                .andDo(MockMvcResultHandlers.print());
////    }
//    @Test
//    public void getDetails()throws Exception {
//        when(freelancerService.getAll()).thenReturn(Collections.singletonList(freelancer));
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1//freelancer/1")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(freelancer)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//    private static String asJsonString(final Object obj)
//    {
//        try{
//            return new ObjectMapper().writeValueAsString(obj);
//
//        }catch(Exception e){
//            throw new RuntimeException(e);
//        }
//    }
//}