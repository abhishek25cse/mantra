package com.mantra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mantra.dao.ConfigDao;
import com.mantra.domain.ConfigMap;

@Service
public class ConfigService {
	
	@Autowired
	ConfigDao configDao;
	
	
	public List<ConfigMap> fetchConfigMap() {
		return configDao.fetchConfigMap();
	}

	public ConfigMap saveConfigMap(ConfigMap cMap) {
		return configDao.saveConfigMap(cMap);
	}

}
