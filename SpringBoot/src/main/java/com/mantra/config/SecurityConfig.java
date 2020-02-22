package com.mantra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/css/**", "/index").permitAll()		
		.antMatchers("/ping").hasRole("USER")
		.antMatchers("/tender/**").hasRole("ADMIN")
		.and()
		.formLogin()		
		.failureUrl("/error");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("abhishek").password("pass")
		.roles("USER")
		.and().withUser("admin").password("pass").roles("ADMIN");
		
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
	  // try different password encoder
		return NoOpPasswordEncoder.getInstance();
		
	}

}
