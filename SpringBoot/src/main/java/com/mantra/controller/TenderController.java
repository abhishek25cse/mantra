package com.mantra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mantra.domain.Tender;
import com.mantra.dto.TenderTO;
import com.mantra.service.TenderService;

@RestController
@RequestMapping(value = "tender")
public class TenderController {
	
	@Autowired
	TenderService tenderService;
	
	@GetMapping(path="findAll", produces = MediaType.APPLICATION_JSON_VALUE) 
	public List<Tender> fetchAllTenders() {		
		return tenderService.fetchAllTenders();
	}
	

}
