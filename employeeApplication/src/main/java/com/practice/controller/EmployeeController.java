package com.practice.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping
	public String getEmployeeCourses() {
		String uri="http://COURSEAPPLICATION/courseApplication/courses/";
		String response=restTemplate.getForObject(uri, String.class);
		return response;
	}


	@GetMapping("/postparam")
	public ResponseEntity<String> testPostWithParam(@RequestParam String name) {

		String uri = "http://COURSEAPPLICATION/courseApplication/courses/byRequestpostParam";

		HttpHeaders headerData= new HttpHeaders();
		headerData.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		 map.add("name", name);

		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<MultiValueMap<String, String>>(map, headerData);

		ResponseEntity<String> response = restTemplate.postForEntity(uri, httpEntity, String.class);

		return response;
	}
	
	@GetMapping("/postrequestbody")
	public ResponseEntity<String> testPostRequestBody() {

		String uri = "http://COURSEAPPLICATION/courseApplication/courses/byRequestBody";

		HttpHeaders headerData= new HttpHeaders();
		headerData.setContentType(MediaType.APPLICATION_JSON);
		
		JSONObject request = new JSONObject();
		request.put("id", 110);
		request.put("name", "test10");
		request.put("months", 12);
		request.put("desc", "test10");

		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headerData);
		
		ResponseEntity<String> response = restTemplate.postForEntity(uri, entity, String.class);

		return response;
	}
	@GetMapping("/byReqbody")
	public ResponseEntity<String> testReqBody() throws JSONException {

		String uri = "http://COURSEAPPLICATION/courseApplication/courses/byRequestBody";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		JSONObject request = new JSONObject();
		request.put("id", 12);
		request.put("name", "TESTING");
		request.put("desc", "TESTING");
		request.put("months", 25);

		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);

		ResponseEntity<String> response = restTemplate.postForEntity(uri, entity, String.class);

		System.out.println(response);
		return response;

	}

	@GetMapping("/byReqbodyExchange")
	public ResponseEntity<String> testReqBody2() throws JSONException {

		String uri = "http://COURSEAPPLICATION/courseApplication/courses/byRequestBody";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		JSONObject request = new JSONObject();
		request.put("id", 12);
		request.put("name", "TESTING1");
		request.put("desc", "TESTING1");
		request.put("months", 125);

		
		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);

		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
		return response;

	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
