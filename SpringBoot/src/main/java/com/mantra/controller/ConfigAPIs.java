package com.mantra.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigAPIs {
	
	@GetMapping(value="error") 
	public String errorPage () {
		return "LOGIN Error";
	}
	
	@GetMapping(value="login") 
	public String homePage () {
		return "LOGIN done";
	}


}
