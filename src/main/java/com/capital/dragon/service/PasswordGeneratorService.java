package com.capital.dragon.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Value;

public class PasswordGeneratorService {
	@Value("${lengthOfGeneratedPassword}")
	private static Integer lengthOfGeneratedPassword = 9;
	private static final List<Integer> VALID_CHARS = new ArrayList<>();
	static{
		IntStream.rangeClosed('0','9').forEach(VALID_CHARS::add);
		IntStream.rangeClosed('A','Z').forEach(VALID_CHARS::add);
		IntStream.rangeClosed('a','z').forEach(VALID_CHARS::add);
		IntStream.rangeClosed('!','*').forEach(VALID_CHARS::add);
	}
	public static String generatePassword(){
		
		String password = new String(new SecureRandom().ints(lengthOfGeneratedPassword, 0, VALID_CHARS.size())
				   .map(VALID_CHARS::get).toArray(), 0, lengthOfGeneratedPassword) ;	

		return password;
		 
		 
		
	}

}
