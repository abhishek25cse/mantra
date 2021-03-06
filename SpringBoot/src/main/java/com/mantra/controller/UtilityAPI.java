package com.mantra.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mantra.service.UtilityService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/utility")
public class UtilityAPI {
	
	@Autowired
	UtilityService utilityService;
	
	/*	This is a utility to arrange IMAGES depending as Year --> month as in the file properties*/
	@ApiOperation(value = "Image Segregation by file properties  ", response = ResponseEntity.class)
	@GetMapping(value="/imageSegregationByProperties",  produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Void> segregateImageByProperties(@RequestParam("source") String src, @RequestParam("target") String target) throws IOException {
		ResponseEntity<Void>  response ;
		try {
			utilityService.stepOneByProperties(src, target);
			System.out.println("Source of file copy is : "+src);
			response= new ResponseEntity<Void>(HttpStatus.OK);	
		} catch (Exception ex ) {
			System.out.println("Exception segregateImage   "+ex);			
			response= new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);			
		}		
		return response;
	}
	
	@ApiOperation(value = "Image Segregation by file NAME  ", response = ResponseEntity.class)
	@GetMapping(value="/imageSegregationByName",  produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Void> segregateImagebyName(@RequestParam("source") String src, @RequestParam("target") String target) throws IOException {
		ResponseEntity<Void>  response ;
		try {
			utilityService.stepOneByName(src, target);
			System.out.println("Source of file copy is : "+src);
			response= new ResponseEntity<Void>(HttpStatus.OK);	
		} catch (Exception ex ) {
			System.out.println("Exception segregateImage   "+ex);			
			response= new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);			
		}		
		return response;
	}
}
