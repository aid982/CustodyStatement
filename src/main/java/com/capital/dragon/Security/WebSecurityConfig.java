package com.capital.dragon.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;



@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {  
	
	
	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService userDetailsService) throws Exception {
	        auth
	            .userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	    }

	
	 

	 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
         .authorizeRequests()
             .antMatchers("/resources/**", "/signup","/changePasswordByEmail").permitAll()             
             .anyRequest().authenticated()
             .and()
         .formLogin()
             .loginPage("/login")
             .permitAll()
             .and()
         .logout()
             .permitAll().
             and()
             .httpBasic();
		
		http
		.csrf().disable();    
             
             	
		
	}
	// 
	 @Bean
	    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
	        return new SecurityEvaluationContextExtension();
	    }
	
	

}
