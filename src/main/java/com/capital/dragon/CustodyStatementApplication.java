package com.capital.dragon;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@SpringBootApplication
@EnableWebSecurity
@EnableAspectJAutoProxy
public class CustodyStatementApplication  {
	
	private static final Logger log = LoggerFactory.getLogger(CustodyStatementApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CustodyStatementApplication.class, args);
	}

	
	
	
	
}
