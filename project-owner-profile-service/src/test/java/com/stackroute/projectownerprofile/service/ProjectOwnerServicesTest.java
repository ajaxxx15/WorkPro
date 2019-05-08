package com.stackroute.projectownerprofile.service;

import com.stackroute.projectownerprofile.controller.ProjectOwnerController;
import com.stackroute.projectownerprofile.domain.ProjectOwner;
import com.stackroute.projectownerprofile.repository.ProjectOwnerRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class ProjectOwnerServicesTest {
     @Autowired
    private MockMvc mockMvc;


    private ProjectOwner projectOwner;

    //Create a mock for UserRepository
    @Mock
    private ProjectOwnerRepository projectOwnerRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private ProjectOwnerServices projectOwnerServices;
    List<ProjectOwner> list = null;


    @Before
    public void setUp() throws Exception {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        projectOwner = new ProjectOwner();
        projectOwner.setId("1");
        projectOwner.setName("Anusha");
        projectOwner.setEmail("anushanayak00@gmail.com");
        projectOwner.setAddress("btm");
        projectOwner.setLocation("Bangalore");
        projectOwner.setNumber(974105);
        list=new ArrayList<>();
        list.add(projectOwner);
    }
    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void postUserTestSuccess() {

        when(projectOwnerRepository.save((ProjectOwner) any())).thenReturn(projectOwner);
        ProjectOwner savedProgram = projectOwnerServices.post(projectOwner);
        Assert.assertEquals(projectOwner, savedProgram);

        //verify here verifies that userRepository save method is only called once
        Mockito.verify(projectOwnerRepository, times(1)).save(projectOwner);

    }
    @Test
    public void postUserTestFailure() {
        when(projectOwnerRepository.save((ProjectOwner) any())).thenReturn(null);
        ProjectOwner savedProgram = projectOwnerServices.post(projectOwner);
        System.out.println("savedUser" + savedProgram);
        Assert.assertNotEquals(projectOwner, savedProgram);
    }
    }