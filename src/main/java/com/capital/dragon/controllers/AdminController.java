package com.capital.dragon.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.capital.dragon.model.User;
import com.capital.dragon.repo.UserRepo;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	private UserRepo userRepo;
	
	@Autowired
	public  AdminController(UserRepo userRepo) {	
		this.userRepo = userRepo;
	}
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getListOfAllUsers(){
		Iterable<User> iterable = userRepo.findAll();		
		Map<String, Object> model = new HashMap<>();
		model.put("listOfUsers",iterable);		
		return new ModelAndView("admin/userList", model);
		
	}

}
