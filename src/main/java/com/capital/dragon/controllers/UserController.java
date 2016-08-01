package com.capital.dragon.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.capital.dragon.forms.UserPasswordChangeForm;
import com.capital.dragon.model.User;
import com.capital.dragon.repo.UserRepo;

@Controller
public class UserController {
	
	private UserRepo userRepo;	
	@Autowired
	public UserController(UserRepo userRepo) {
		
		this.userRepo = userRepo;
	}

	@RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
	public  ModelAndView getUser(@PathVariable("id") Long id) {
		User user = userRepo.findOne(id);		
		Map<String, Object> model = new HashMap<>();
		model.put("user", user);		
		return new ModelAndView("user/user", model);

	}
	
	@RequestMapping(value = "/user/{id}/pswdChange",method = RequestMethod.GET)
	public  String getUserPasswordForm(@PathVariable("id") Long id,@Valid UserPasswordChangeForm userPasswordChangeForm) {
			
		return "user/userPasswordChange";

	}
	@RequestMapping(value = "/user/{id}/pswdChange",method = RequestMethod.POST)
	public  String setUserPassword(@PathVariable("id") Long id,@Valid UserPasswordChangeForm userPasswordChangeForm,BindingResult result,RedirectAttributes redirect) {
		if(!userPasswordChangeForm.getPassword().equals(userPasswordChangeForm.getPasswordConfirmed())) {
			result.rejectValue("password", "password", "password and Confirm password are not matched!");			
		}	
		User user = userRepo.findOne(id);
		if(!user.isPasswordMatched(userPasswordChangeForm.getPasswordOld())){
			result.rejectValue("password", "password", "incorrect old password!");
			
		}
		if (result.hasErrors()) {
			return "user/userPasswordChange";			
		}
		user.setPassword(userPasswordChangeForm.getPassword());
		userRepo.save(user);
		redirect.addFlashAttribute("globalMessage", "password changed successfully!");
		return "redirect:/";

	}

}
