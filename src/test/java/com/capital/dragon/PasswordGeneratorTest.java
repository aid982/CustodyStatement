package com.capital.dragon;

import java.security.SecureRandom;
import java.util.stream.Collectors;

import org.junit.Test;

import com.capital.dragon.service.PasswordGeneratorService;

public class PasswordGeneratorTest {
	@Test
	public void startTesting(){
		System.out.println(PasswordGeneratorService.generatePassword());
	}

}
