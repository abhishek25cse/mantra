package com.mantra.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mantra.dto.UserTO;

@RestController
public class PingController {
	
	@GetMapping("ping")
	public String testService() {
		return "The service is up"; 
	}
	
	@GetMapping(path = "user" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserTO> getUser() {
		UserTO user =  new UserTO();		
		user.setName("Abhishek");
		user.setRole("dev-json");
		ResponseEntity res = new ResponseEntity(user,HttpStatus.INTERNAL_SERVER_ERROR);
		return res;
	}
	
	@GetMapping(path = "userxml",  produces =  MediaType.APPLICATION_XML_VALUE)	
	public ResponseEntity<UserTO> getUserXML() {
		UserTO user =  new UserTO();		
		user.setName("Abhishek");
		user.setRole("dev-xml");
		ResponseEntity res = new ResponseEntity(user,HttpStatus.INTERNAL_SERVER_ERROR);
		return res;
	}
	

}
