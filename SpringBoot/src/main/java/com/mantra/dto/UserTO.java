package com.mantra.dto;

import java.io.Serializable;

public class UserTO implements Serializable{
	
	private String name ;
	private String role;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
