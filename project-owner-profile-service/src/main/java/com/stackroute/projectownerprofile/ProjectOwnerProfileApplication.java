package com.stackroute.projectownerprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProjectOwnerProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectOwnerProfileApplication.class, args);
	}

}
