package com.mantra.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mantra.domain.ConfigMap;
import com.mantra.service.ConfigService;

@CrossOrigin(origins="*", maxAge=3600, allowedHeaders = "*" )
@RestController
@RequestMapping(value="api/config")
public class ConfigAPIs {
	
	@Autowired
	ConfigService configService;
	
	
	@GetMapping(value="/fetch" , produces=MediaType.APPLICATION_JSON_VALUE ) 
	public ResponseEntity<Map<String, List<ConfigMap>>> fetchConfigMap() {
		System.out.println("Inside fetch for the config code ");
		ResponseEntity<Map<String, List<ConfigMap>>> response = 
				new ResponseEntity<Map<String, List<ConfigMap>>>( configService.fetchConfigMap(), HttpStatus.ACCEPTED);
		return response;
		
	}
	
	@DeleteMapping(path="/delete" , produces= "application/json") 
	public ResponseEntity<Long> deleteConfig(@RequestBody ConfigMap configMap) {	
		System.out.println("In method deleteConfig");		
		ResponseEntity<Long> response = new ResponseEntity<Long>(configService.deleteConfigMap(configMap), HttpStatus.ACCEPTED);
		return response;		
	}
	
	@DeleteMapping(path="/deleteAll" , produces= "application/json" ) 
	public ResponseEntity<Void> deleteAllConfig() {			
		System.out.println("In method  deleteAllConfig");
		configService.deleteAllConfigMap();
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		return response;		
	}
	
	@PostMapping(path="/save" , produces= "application/json",  consumes= "application/json") 
	public ResponseEntity<ConfigMap> saveConfig(@RequestBody ConfigMap configMap) {	
		System.out.println("In method saveConfig");
		ResponseEntity<ConfigMap> response = new ResponseEntity<ConfigMap>(configService.saveConfigMap(configMap), HttpStatus.ACCEPTED);
		return response;		
	}


}
