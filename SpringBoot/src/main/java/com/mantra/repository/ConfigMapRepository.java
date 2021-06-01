package com.mantra.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mantra.domain.ConfigMap;

@Repository
public interface ConfigMapRepository extends MongoRepository<ConfigMap, String>{	

	 List<ConfigMap> findByField(String field);
	 
	  Long deleteConfigMapByField(String field); 	
	  
	  @Query(value="DELETE FROM CONFIG_MAP WHERE FIELD=:field and CODE=:code", delete = true)
	  ConfigMap deleteConfigMapByFieldAndCodeQuery( @Param("field") String field,  @Param("code") String code); 
	  
	  /*
	  The value is used for the where condition 
	  fields attibute is used to fetch the attributes 
	  */
	  @Query(value = "{ 'field':?0, 'code':?1 }", delete = true)
	  Long deleteConfigMapByFieldAndCodeParam(String field, String code);
	  
	 
	  

}
