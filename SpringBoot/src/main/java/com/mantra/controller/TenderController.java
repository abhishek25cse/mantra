package com.mantra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mantra.domain.Tender;
import com.mantra.service.TenderService;

@RestController
@RequestMapping(value = "api/tender")
public class TenderController {
	
	@Autowired
	TenderService tenderService;
	
	@GetMapping(path="findAll", produces = MediaType.APPLICATION_JSON_VALUE) 
	public List<Tender> fetchAllTenders() {		
		return tenderService.fetchAllTenders();
	}
	
	@GetMapping(value="saveTender/{poNumber}", produces = MediaType.APPLICATION_JSON_VALUE) 
	public Tender saveTender(@PathVariable("poNumber") String poNumber ) {		
		return tenderService.saveTender(poNumber);
	}
	
	@GetMapping(value="deleteAll", produces = MediaType.APPLICATION_JSON_VALUE) 
	public void deleteAllTender() {		
		 tenderService.deleteAllTender();
	}
	
	
	@PostMapping(value="createTender" , produces = MediaType.APPLICATION_JSON_VALUE, consumes =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tender> createTender(@RequestBody Tender tender) {
		return new ResponseEntity<Tender>(tenderService.createTender(tender), HttpStatus.OK);
	}
	
	// This API is not working as expected. Its inserting rather than updating
	@GetMapping(value="channgeStatus" , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Tender>> enabledisabletender(@RequestParam("poNum") String poNum, @RequestParam("status")String status) {
		return new ResponseEntity<List<Tender>>(tenderService.enabledisableTender(poNum, status), HttpStatus.OK);
	}
	
	@GetMapping(value="findByPoNo" , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Tender>> findByPoNo(@RequestParam("poNum") String poNum) {
		return new ResponseEntity<List<Tender>>(tenderService.findByPoNo(poNum), HttpStatus.OK);
	}
	
	@GetMapping(value="deleteByPoNo" , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> deleteByPoNo(@RequestParam("poNum") String poNum) {
		return new ResponseEntity<Long>(tenderService.deleteByPoNo(poNum), HttpStatus.OK);
	}
}
