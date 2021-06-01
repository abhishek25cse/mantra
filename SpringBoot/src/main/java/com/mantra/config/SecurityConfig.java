package com.mantra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/* in the method below if used fullyAuthenticated()		
	 * instead of permitAll then the output had empty array.
	 *  although the database had the rows.
	 *  -- csrf().disable() is added to enable the POST call which was giving 403 error
	 *  */
	@Override 
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.anyRequest()
		.permitAll()
		.and().httpBasic();
		/*.and()	
        .formLogin();*/
	}
	
	/*@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER");
	}*/
	
	@Bean
	public UserDetailsService userDetailsService() {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		UserDetails user = User.withUsername("user").password(encoder.encode("user")).roles("USER").build();
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(user);
		return manager;

	}
	/* @Bean
	 public UserDetailsService userDetailsService() {

	        User.UserBuilder users = User.withDefaultPasswordEncoder();
	        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	        manager.createUser(users.username("user").password("password").roles("USER").build());
	        manager.createUser(users.username("admin").password("password").roles("USER", "ADMIN").build());
	        return manager;

	    }*/
	 
	/*@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}*/
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("abhishek").password("{noop}pass").roles("USER")
		.and()
		.withUser("admin").password("{noop}pass").roles("ADMIN");
		
	}*/
	
	/*@Bean
	public PasswordEncoder getPasswordEncoder() {
	  // try different password encoder
		return NoOpPasswordEncoder.getInstance();
		
	}*/

}
