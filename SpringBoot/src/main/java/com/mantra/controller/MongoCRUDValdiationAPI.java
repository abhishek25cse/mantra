package com.mantra.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mantra.domain.Employee;

@RestController
@RequestMapping(value="api/crud", produces="application/json")
public class MongoCRUDValdiationAPI {
	
	/*@Autowired
	MongoCRUDService service;*/
	
	@PostMapping(value="insert")
	public Employee insertEmployee(@RequestBody Employee employee) {
		Employee emp = new Employee();
		return emp;
	}

}
