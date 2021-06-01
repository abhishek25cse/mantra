package com.mantra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class ProjectConfiguration {
	   /*The below cnfiuration is for enablng CORS for specific APIs
    The below Mapping adds the request mapping path and should not add the basepath if any. FFor example the base 
    path for this Project is /api but the cors mapping does not use /api but path after that */
   /* @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}*/
    
    
   /* @Bean
   	public WebMvcConfigurer corsConfigurer() {
   		return new WebMvcConfigurer() {
   			public void addCorsMappings(CorsRegistry registry) {
   				registry.addMapping("/api/config/all").allowedOrigins("http://localhost:3000");
   				registry.addMapping("/api/config/save").allowedOrigins("http://localhost:3000").
   				allowedMethods("POST");
   				registry.addMapping("user").allowedOrigins("localhost:3000");
   			}
   		};
   	}*/

}
