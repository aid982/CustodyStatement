package com.capital.dragon.logging;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WebAuditor {
	
	@Before("execution(* com.capital.dragon.controllers.*.*(..))")	
	public void beforeMethodExecution(JoinPoint joinPoint){
		 Object[] signatureArgs = joinPoint.getArgs();
		   for (Object signatureArg: signatureArgs) {
		      System.out.println("Arg: " + signatureArg);		      
		   }
		
		
	}
}
