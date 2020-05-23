package com.mantra.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mantra.domain.Employee;
import com.mantra.dto.UserTO;
import com.mantra.service.PingService;

@RestController
@RequestMapping(value = "api/ping")
public class PingController {
	
//	@Autowired
	PingService pingService;
	
	@GetMapping
	public String testService() {
		return "The service is up"; 
	}
	
	@GetMapping(path = "/user" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserTO> getUser() {
		UserTO user = pingService.checkCall();
	
		ResponseEntity<UserTO> res = new ResponseEntity<UserTO>(user,HttpStatus.OK);
		
		return res;
	}
	
	@GetMapping(path = "/userxml",  produces =  MediaType.APPLICATION_XML_VALUE)	
	public ResponseEntity<UserTO> getUserXML() {
		UserTO user =  new UserTO();		
		user.setName("Abhishek");
		user.setRole("dev-xml");
		ResponseEntity res = new ResponseEntity(user,HttpStatus.INTERNAL_SERVER_ERROR);
		return res;
	}
	
	@GetMapping(path = "/userMongo",  produces =  MediaType.APPLICATION_JSON_VALUE)	
	public List<Employee> getUserMongo() {
		List<Employee> emps = null;
		emps = 	pingService.findAll();
		return emps;
	}
	@GetMapping(path = "/userSave",  produces =  MediaType.APPLICATION_JSON_VALUE)	
	public String saveUser() {
		return pingService.save();
	}

}
