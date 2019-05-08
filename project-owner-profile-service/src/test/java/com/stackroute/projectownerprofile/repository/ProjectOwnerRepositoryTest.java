package com.stackroute.projectownerprofile.repository;

import com.stackroute.projectownerprofile.controller.ProjectOwnerController;
import com.stackroute.projectownerprofile.domain.ProjectOwner;
import com.stackroute.projectownerprofile.service.ProjectOwnerServices;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class ProjectOwnerRepositoryTest {


    @Autowired
    private ProjectOwnerRepository projectOwnerRepository;
    private ProjectOwner projectOwner;
    @MockBean
    private ProjectOwnerServices projectOwnerServices;
    @InjectMocks
    private ProjectOwnerController projectOwnerController;


    @Before
    public void setUp() throws Exception {
        projectOwner = new ProjectOwner();
        projectOwner.setId("1");
        projectOwner.setName("Anusha");
        projectOwner.setEmail("anushanayak00@gmail.com");
        projectOwner.setAddress("btm");
        projectOwner.setLocation("Bangalore");
        projectOwner.setNumber(974105);
    }

    @After
    public void tearDown() throws Exception {
        projectOwnerRepository.deleteAll();
    }

    @Test
    public void testPostProgram() {
        projectOwnerRepository.save(projectOwner);
        ProjectOwner fetchProgram = projectOwnerRepository.findById(projectOwner.getId()).get();
        Assert.assertEquals("1", fetchProgram.getId());

    }

    @Test
    public void testSavePostFailure() {
        ProjectOwner testProgram = new ProjectOwner("2", "Anu", "anusha@gmail.com", "btm", "Bangalore", 9741);
        projectOwnerRepository.save(projectOwner);
        ProjectOwner fetchProgram = projectOwnerRepository.findById(projectOwner.getId()).get();
        Assert.assertNotSame(testProgram, projectOwner);
    }

}