package com.pratice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CourseAppliationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseAppliationApplication.class, args);
	}

}
