package com.capital.dragon.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.capital.dragon.Exception.ForbiddenException;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(value = ForbiddenException.class)
	public ModelAndView handleForbidenException(Exception ex) {
		  return new ModelAndView("errors/forbiden", "message", ex);
		
	}

}
