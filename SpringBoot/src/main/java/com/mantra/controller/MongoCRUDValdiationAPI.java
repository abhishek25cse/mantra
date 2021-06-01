package com.mantra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mantra.domain.Employee;
import com.mantra.service.MongoCRUDService;

@RestController
@RequestMapping(value="api/crud", produces="application/json")
public class MongoCRUDValdiationAPI {
	
	@Autowired
	MongoCRUDService service;
	
	@PostMapping(value="insert")
	public Employee insertEmployee(@RequestBody Employee employee) {
		return service.insertEmployee(employee);
		
	}
	
	@GetMapping(value = "deleteByName")
	public Long deleteByName(@RequestParam("name") String name) {
		return service.deleteEmployee(name);
	}
	
	@GetMapping(value = "findAll")
	public List<Employee> findAll() {
		return service.findAll();
	}
	
	@PostMapping(value = "update")
	public List<Employee> update(@RequestParam("cName") String currentEmpName, @RequestParam("nName") String empNewName) {
		return service.update(currentEmpName, empNewName );
	}

}
