package com.capital.dragon.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;
import org.neo4j.cypher.internal.compiler.v2_1.ast.rewriters.useAliasesInSortSkipAndLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.capital.dragon.forms.UserPasswordChangeByEmailForm;
import com.capital.dragon.model.User;
import com.capital.dragon.repo.UserRepo;
import com.capital.dragon.service.EmailSender;
import com.capital.dragon.service.PasswordGeneratorService;

@Controller
public class ChangePasswordByEmailController {
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private UserRepo userRepo;
	
	@RequestMapping("/changePasswordByEmail")
	public String getChangePasswordForm(@Valid UserPasswordChangeByEmailForm userPasswordChangeByEmailForm) {
		return "user/userChangePasswordEmail";
	}
	@RequestMapping(value="/changePasswordByEmail",method =RequestMethod.POST)
	@Transactional
	public String setPassword(@Valid UserPasswordChangeByEmailForm userPasswordChangeByEmailForm,BindingResult result,RedirectAttributes redirect) {
		User user = userRepo.findByEmail(userPasswordChangeByEmailForm.getEmail());
		if(user==null) {
			result.rejectValue("email", "email", "Entered email is not found!");		
		}
		
		if (result.hasErrors())

		{
			return "user/userChangePasswordEmail";
		}
		String generatedPassword = PasswordGeneratorService.generatePassword();		
		user.setPassword(generatedPassword);
		userRepo.save(user);
		EmailSender.sendEmail(javaMailSender, user.getEmail(), "Password restore", "Your password has been set to:"+generatedPassword);		
		
		
		redirect.addFlashAttribute("globalMessage", "password was sent to your email");		
		return "redirect:/changePasswordByEmail";
	}

}
