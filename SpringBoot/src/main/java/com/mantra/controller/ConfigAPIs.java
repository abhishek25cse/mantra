package com.mantra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mantra.domain.ConfigMap;
import com.mantra.service.ConfigService;

@RestController
@RequestMapping(value="api/config")
public class ConfigAPIs {
	
	@Autowired
	ConfigService configService;
	
	@GetMapping(value="error") 
	public String errorPage () {
		return "LOGIN Error";
	}
	
	@GetMapping(value="login") 
	public String homePage () {
		return "LOGIN done";
	}
	@GetMapping(value="all" , produces=MediaType.APPLICATION_JSON_UTF8_VALUE ) 
	public ResponseEntity<List<ConfigMap>> fetchConfigMap() {
		ResponseEntity<List<ConfigMap>> response = new ResponseEntity<List<ConfigMap>>(configService.fetchConfigMap(), HttpStatus.ACCEPTED);
		return response;
		
	}
	
	@GetMapping(value="save" , produces=MediaType.APPLICATION_JSON_UTF8_VALUE ) 
	public ResponseEntity<ConfigMap> fetchConfigMap(@RequestParam ConfigMap configMap) {
		ResponseEntity<ConfigMap> response = new ResponseEntity<ConfigMap>(configService.saveConfigMap(configMap), HttpStatus.ACCEPTED);
		return response;		
	}


}
