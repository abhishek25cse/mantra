package com.mantra.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="CONFIG_MAP")
public class ConfigMap {	
	public ConfigMap() {
		super();
	}
	
	@Id
	@Field(value="id")
	private String id;
	
	@Field(value="FIELD")
	private String field;
	
	@Field(value="DESC")
	private String desc;
	
	@Field(value="CODE")
	private String code;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
