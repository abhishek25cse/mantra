package com.mantra.controller;

import org.springframework.http.HttpStatus;
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
	
	@GetMapping("user")
	public ResponseEntity<UserTO> getUser() {
		UserTO user =  new UserTO();		
		user.setName("Abhishek");
		user.setRole("dev");
		ResponseEntity res = new ResponseEntity(user,HttpStatus.INTERNAL_SERVER_ERROR);
		return res;
	}
	

}
