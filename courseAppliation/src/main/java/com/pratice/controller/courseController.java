package com.pratice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pratice.model.Course;

@RestController
@RequestMapping("/courses")
public class courseController {
	
@GetMapping
	public List<Course> fetchAllCouses() {
		List<Course> courseList=new ArrayList<>();
		Course c=new Course(1l, "Test1", "Test1", 10);
		Course c1=new Course(2l, "Test2", "Test2", 8);
		courseList.add(c);
		courseList.add(c1);
		return courseList;
	}

@GetMapping("/byRequestParam")
public List<Course> fetchAllCousesByParam(@RequestParam String name) {
	System.out.println("Request paramater for fetchAllCousesByParam ==> "+name);
	List<Course> courseList=new ArrayList<>();
	Course c=new Course(1l, "Java", "Java and J2EE", 5);
	Course c1=new Course(2l, "Hibernate", "Hibernate couse", 2);
	courseList.add(c);
	courseList.add(c1);
	return courseList;
}

@PostMapping("/byRequestpostParam")
public List<Course> fetchAllCousesByPostByParam(@RequestParam String name) {
	System.out.println("Request paramater for fetchAllCousesByParam ==> "+name);
	List<Course> courseList=new ArrayList<>();
	Course c=new Course(100l, "Java", "Java and J2EE", 10);
	Course c1=new Course(200l, "Hibernate", "Hibernate couse", 21);
	courseList.add(c);
	courseList.add(c1);
	return courseList;
}

@PostMapping("/byRequestBody")
public Course fetchAllCousesRequestbody(@RequestBody Course course) {
	course.setName(course.getName()+" Has been modified  ");
	return course;
}

}
