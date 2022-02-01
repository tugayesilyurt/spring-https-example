package com.spring.https.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/")
@RequiredArgsConstructor
public class HttpsController {
	
	@GetMapping("https/example")
	public ResponseEntity<?> httpsExample(){
		
		String httpsExample = "Https example - created by htyesilyurt@gmail.com";
		
		return new ResponseEntity<String>(httpsExample, HttpStatus.OK);
	}

}
