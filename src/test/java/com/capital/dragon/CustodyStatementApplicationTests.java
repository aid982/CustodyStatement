package com.capital.dragon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.capital.dragon.service.PasswordGeneratorService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CustodyStatementApplication.class)
@WebAppConfiguration
public class CustodyStatementApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(PasswordGeneratorService.generatePassword());
		
	}

}
