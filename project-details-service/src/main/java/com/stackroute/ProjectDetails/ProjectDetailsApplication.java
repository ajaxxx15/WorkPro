package com.stackroute.ProjectDetails;


import com.stackroute.ProjectDetails.domain.ProjectDetails;
import com.stackroute.ProjectDetails.domain.ProjectsOfProjectOwner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class ProjectDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectDetailsApplication.class, args);
	}

}
