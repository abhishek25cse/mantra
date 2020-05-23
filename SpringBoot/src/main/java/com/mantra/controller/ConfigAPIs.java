package com.mantra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mantra.domain.ConfigMap;
import com.mantra.dto.ConfigMapDTO;
import com.mantra.service.ConfigService;

@CrossOrigin(origins="http://localhost:3000", maxAge=3600)
@RestController
@RequestMapping(value="api/config")
public class ConfigAPIs {
	
	@Autowired
	ConfigService configService;
	
	
	@GetMapping(value="/all" , produces=MediaType.APPLICATION_JSON_VALUE ) 
	public ResponseEntity<List<ConfigMap>> fetchConfigMap() {
		List<ConfigMap>  configList = configService.fetchConfigMap();
		System.out.println(configList);
		ResponseEntity<List<ConfigMap>> response = new ResponseEntity<List<ConfigMap>>(configList, HttpStatus.ACCEPTED);
		/*HttpHeaders  header = response.getHeaders();
		header.add("Access-Control-Allow-Origin", "http://localhost:3000");
		header.add("Access-Control-Allow-Credentials", "true");	
		*/
		return response;
		
	}
	
	@PostMapping(value="/save" , produces=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<ConfigMap> saveConfig() {	
		/*@RequestBody ConfigMapDTO configMapDTO*/
		ConfigMap configMap = new ConfigMap();
		ResponseEntity<ConfigMap> response = new ResponseEntity<ConfigMap>(configService.saveConfigMap(configMap), HttpStatus.ACCEPTED);
		return response;		
	}


}
