package com.mantra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mantra.domain.ConfigMap;

@Repository
public interface ConfigMapRepository extends MongoRepository<ConfigMap, String>{	

	  Long deleteConfigMapByField(String field); 

}
