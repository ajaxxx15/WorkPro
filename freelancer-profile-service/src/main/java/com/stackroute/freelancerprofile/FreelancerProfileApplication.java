package com.stackroute.freelancerprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class FreelancerProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreelancerProfileApplication.class, args);
	}

}
