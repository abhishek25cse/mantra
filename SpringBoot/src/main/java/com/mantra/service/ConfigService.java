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
		 return configList.stream().collect(Collectors.
				 groupingBy(ConfigMap:: getField));
		/* return configList.stream().collect(Collectors.
				 groupingBy(ConfigMap:: getField, Collectors.mapping(ConfigMap::getField, Collectors.toList())));*/
	}

	public ConfigMap saveConfigMap(ConfigMap cMap) {
		return configDao.saveConfigMap(cMap);
	}
	
	public Long deleteConfigMap(ConfigMap cMap) {
		return configDao.deleteConfigMap(cMap);
	}
	
	public void deleteAllConfigMap() {
		configDao.deleteAllConfigMap();
	}

}
