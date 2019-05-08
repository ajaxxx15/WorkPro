package com.stackroute.freelancerprofile.service;

import com.stackroute.freelancerprofile.domain.Freelancer;
import com.stackroute.freelancerprofile.repository.FreelancerRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class FreelancerServiceImplTest {
    @Autowired
    private MockMvc mockMvc;


    private Freelancer freelancer;

    //Create a mock for UserRepository
    @Mock
    private FreelancerRepository freelancerRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private FreelancerServiceImpl freelancerService;
    List<Freelancer> list = null;


    @Before
    public void setUp() throws Exception {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        freelancer=new Freelancer();
        freelancer.setId("1");
        freelancer.setFreelancerName("Anusha");
        freelancer.setFreelancerEmail("anushanayak00@gmail.com");
        freelancer.setFreelancerAddress("bangalore");
        freelancer.setYearsOfExpertise(5);
        list=new ArrayList<>();
        list.add(freelancer);
    }
    @Test
    public void save() {
        when(freelancerRepository.save((Freelancer) any())).thenReturn(freelancer);
        Freelancer savedUser = freelancerService.save(freelancer);
        Assert.assertEquals(freelancer, savedUser);
        //verify here verifies that userRepository save method is only called once
        Mockito.verify(freelancerRepository, times(1)).save(freelancer);
    }

    @Test
    public void getAll() {
        freelancerRepository.save(freelancer);
        when(freelancerRepository.findAll()).thenReturn(list);
        List<Freelancer> userList=freelancerService.getAll();
        Assert.assertEquals(list,userList);
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void saveUserFailure() {
        when(freelancerRepository.save((Freelancer) any())).thenReturn(null);
        Freelancer savedUser = freelancerService.save(freelancer);
        System.out.println("savedUser" + savedUser);
        Assert.assertNotEquals(freelancer, savedUser);
    }

}