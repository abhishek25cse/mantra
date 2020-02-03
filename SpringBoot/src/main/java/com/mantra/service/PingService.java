package com.mantra.service;

import java.util.List;

import com.mantra.domain.Employee;
import com.mantra.dto.UserTO;

public interface PingService {

	
	public UserTO checkCall();
	public List<Employee> findAll();
	public String save();
}
