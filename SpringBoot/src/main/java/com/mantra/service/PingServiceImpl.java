package com.mantra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mantra.domain.Employee;
import com.mantra.dto.UserTO;

//@Service
public class PingServiceImpl implements PingService {
	
	//@Autowired
	PingDao pingDao;
	

	public UserTO checkCall() {
		return pingDao.fetchUser();
	}
	
	public List<Employee> findAll(){
		return pingDao.findAll();
	}
	
	public String save(){
		return pingDao.save();
	}

}
