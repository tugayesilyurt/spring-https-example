package com.spring.https.client.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.https.client.service.HttpsCallService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/")
@RequiredArgsConstructor
public class HttpsClientController {

	private final HttpsCallService httpsCallService;

	@GetMapping("https/call")
	public ResponseEntity<?> callHttps() {
		
		String response = httpsCallService.httpsCall();

		return new ResponseEntity<String>(response, HttpStatus.OK);
		
	}

}
