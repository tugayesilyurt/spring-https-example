package com.spring.https.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpsCallService {

	@Autowired
	private RestTemplate restTemplate;

	public String httpsCall() {

		String url = "https://https-server-service:8090/v1/https/example";

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, String.class);

		System.out.println("Result = " + response.getBody());
		
		return response.getBody();

	}

}
