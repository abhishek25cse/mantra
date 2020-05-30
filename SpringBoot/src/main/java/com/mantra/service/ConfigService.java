package com.mantra.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mantra.dao.ConfigDao;
import com.mantra.domain.ConfigMap;

@Service
public class ConfigService {
	
	@Autowired
	ConfigDao configDao;
	
	
	public Map<String, List<ConfigMap>> fetchConfigMap() {
		 List<ConfigMap> configList =  configDao.fetchConfigMap();
		 return null;/*configList.stream().collect(Collectors.
				 groupingBy(ConfigMap:: getField));*/
	}
	
	public List<ConfigMap> fetchConfigMapOnField(String field) {		
		return  configDao.fetchConfigMapOnField(field);
	}

	public ConfigMap saveConfigMap(ConfigMap cMap) {
		return configDao.saveConfigMap(cMap);
	}
	
	public Long deleteConfigMap(ConfigMap cMap) {		
		return configDao.deleteConfigMap(cMap);
	}
	
	public Long deleteConfigMapFieldCodeParam(String field, String code) {
		if(null == field || null == code) 
			return null;
		return configDao.deleteConfigMapFieldCodeParam(field, code);
	}	
	
	public ConfigMap deleteConfigMapFieldCodeQuery(String field, String code) {
		if(null == field || null == code) 
			return null;
		return configDao.deleteConfigMapFieldCodeQuery(field, code);
	}	
	
	public void deleteAllConfigMap() {
		configDao.deleteAllConfigMap();
	}

	

}
