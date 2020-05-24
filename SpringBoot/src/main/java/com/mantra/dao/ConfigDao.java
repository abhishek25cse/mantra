package com.mantra.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mantra.domain.ConfigMap;
import com.mantra.repository.ConfigMapRepository;

@Component
public class ConfigDao {
	
	@Autowired
	ConfigMapRepository configMapRepo;
	
	public List<ConfigMap> fetchConfigMap() {
		return configMapRepo.findAll();
	}
	
	public ConfigMap saveConfigMap(ConfigMap configMap) {
		return configMapRepo.save(configMap);
	}
	
	public Long deleteConfigMap(ConfigMap configMap) {
		return configMapRepo.deleteConfigMapByField(configMap.getField());
	}
	
	public void deleteAllConfigMap() {
		configMapRepo.deleteAll();
	}
	
	

}
