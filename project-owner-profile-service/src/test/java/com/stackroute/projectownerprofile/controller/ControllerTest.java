package com.stackroute.projectownerprofile.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.projectownerprofile.domain.ProjectOwner;
import com.stackroute.projectownerprofile.service.ProjectOwnerServices;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@WebMvcTest
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ProjectOwner projectOwner;

    @MockBean
    private ProjectOwnerServices projectOwnerServices;

    @InjectMocks
    private ProjectOwnerController projectOwnerController;
    private List<ProjectOwner> list;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(projectOwnerController).build();
        projectOwner = new ProjectOwner();
        projectOwner.setId("1");
        projectOwner.setName("Anusha");
        projectOwner.setEmail("anushanayak00@gmail.com");
        projectOwner.setAddress("btm");
        projectOwner.setLocation("Bangalore");
        projectOwner.setNumber(974105);
        list=new ArrayList();
        list.add(projectOwner);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void post() throws Exception {
        when(projectOwnerServices.post((ProjectOwner)any())).thenReturn(projectOwner);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1//projectOwner/projectOwnerId")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(projectOwner)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getProjectOwner() throws Exception {
        when(projectOwnerServices.getProjectOwner("anushanayk00@gmail.com")).thenReturn(projectOwner);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1//projectOwner/anushanayak00@gmail.com")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(projectOwner)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}