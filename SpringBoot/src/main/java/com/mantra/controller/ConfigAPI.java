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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mantra.domain.ConfigMap;
import com.mantra.service.ConfigService;

import io.swagger.annotations.ApiOperation;
//@Api(value = "ConfigAPIs this class is used to maintain the configuration property of the appliciation" )
@CrossOrigin(origins="*", maxAge=3600, allowedHeaders = "*" )
@RestController
@RequestMapping(value="api/config")
public class ConfigAPI {
	
	@Autowired
	ConfigService configService;
	
	@ApiOperation(value = "View a list of config file arranged in group based on the field type ", response = Map.class)
	@GetMapping(value="/fetchAll" , produces=MediaType.APPLICATION_JSON_VALUE ) 
	public ResponseEntity<Map<String, List<ConfigMap>>> fetchConfigMap() {
		System.out.println("Inside fetch for the config code ");
		ResponseEntity<Map<String, List<ConfigMap>>> response = 
				new ResponseEntity<Map<String, List<ConfigMap>>>( configService.fetchConfigMap(), HttpStatus.ACCEPTED);
		return response;
		
	}
	
	@ApiOperation(value = "View a list of config file based on the field type ", response = List.class)
	@GetMapping(value="/fetchField" , produces=MediaType.APPLICATION_JSON_VALUE ) 
	public ResponseEntity<List<ConfigMap>> fetchConfigMapOnField(@RequestParam("field") String field) {
		System.out.println("Inside fetch for the config code  based on field ");
		ResponseEntity<List<ConfigMap>> response = 
				new ResponseEntity<List<ConfigMap>>( configService.fetchConfigMapOnField(field), HttpStatus.ACCEPTED);
		return response;
		
	}
	
	
	
	@ApiOperation(value = "Save the config  ", response = ConfigMap.class)
	@PostMapping(path="/save" , produces= "application/json",  consumes= "application/json") 
	public ResponseEntity<ConfigMap> saveConfig(@RequestBody ConfigMap configMap) {	
		System.out.println("In method saveConfig");
		ResponseEntity<ConfigMap> response = new ResponseEntity<ConfigMap>(configService.saveConfigMap(configMap), HttpStatus.ACCEPTED);
		return response;		
	}
	
	@ApiOperation(value = "Delete a  config based on the field type ", response = Long.class)
	@DeleteMapping(path="/deleteField" , produces= "application/json") 
	public ResponseEntity<Long> deleteConfig(@RequestBody ConfigMap configMap) {	
		System.out.println("In method deleteConfig");		
		ResponseEntity<Long> response = new ResponseEntity<Long>(configService.deleteConfigMap(configMap), HttpStatus.ACCEPTED);
		return response;		
	}
	

	@ApiOperation(value = "Delete a  config based on the field type and code specified as a value param in the Repository ", response = Long.class)
	@DeleteMapping(path="/deleteFieldCodeType1" , produces= "application/json") 
	public ResponseEntity<Long> deleteConfigFieldCode(@RequestParam("field")String field,@RequestParam("code") String code) {	
		System.out.println("In method deleteConfigFieldCode");		
		ResponseEntity<Long> response = new ResponseEntity<Long>(configService.deleteConfigMapFieldCodeParam(field, code), HttpStatus.ACCEPTED);
		return response;		
	}
	
	// The below API is not available write now. Still WIP
	@ApiOperation(value = "Delete a  config based on the field type and code with the native query ")
	@DeleteMapping(path="/deleteFieldCodeType2" , produces= "application/json") 
	public ResponseEntity<ConfigMap> deleteConfigFieldCodeQuery(@RequestParam("field")String field,@RequestParam("code") String code) {	
		System.out.println("In method deleteConfigFieldCode");	
		ResponseEntity<ConfigMap> response = null;
		ConfigMap configMapDel = configService.deleteConfigMapFieldCodeQuery(field, code);
		if(null == configMapDel) {
			response = new ResponseEntity<ConfigMap>(configMapDel, HttpStatus.NO_CONTENT);			
		} else {
			response = new ResponseEntity<ConfigMap>(configMapDel, HttpStatus.ACCEPTED);			
		}
		return response;		
	}
	
	@ApiOperation(value = "Delete all the config  ", response = Void.class)
	@DeleteMapping(path="/deleteAll" , produces= "application/json" ) 
	public ResponseEntity<Void> deleteAllConfig() {			
		System.out.println("In method  deleteAllConfig");
		configService.deleteAllConfigMap();
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		return response;		
	}
	
	


}
