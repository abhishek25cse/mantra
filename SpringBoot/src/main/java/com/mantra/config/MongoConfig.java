package com.mantra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;

import com.mongodb.MongoClient;

//@Configuration
public class MongoConfig {

	/*
	 * Use the standard Mongo driver API to create a com.mongodb.MongoClient
	 * instance.
	 */
	/*public @Bean MongoClient mongoClient() {
		return new MongoClient("localhost");
	}
	
	public @Bean MongoClientFactoryBean mongo() {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        mongo.setHost("localhost");
        return mongo;
   }*/

}
