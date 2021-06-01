package com.mantra.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutenticationAPI {
	
	@GetMapping(value="error") 
	public String errorPage () {
		return "error thrown via AutenticationAPI :  LOGIN Error";
	}
	
	@GetMapping(value="login") 
	public String homePage () {
		return "AutenticationAPI: LOGIN done";
	}

}
