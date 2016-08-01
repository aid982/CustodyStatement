package com.capital.dragon.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import com.capital.dragon.CustodyStatementApplication;
import com.capital.dragon.Exception.ForbiddenException;
import com.capital.dragon.Security.CurrentUser;
import com.capital.dragon.forms.QueryForm;
import com.capital.dragon.model.User;
import com.capital.dragon.repo.UserRepo;
import com.capital.dragon.service.UtillClass;
import com.capital.dragon.statement.Statement;
import com.sun.research.ws.wadl.HTTPMethods;



@Controller
@RequestMapping(value = "/")
public class Main {
	@Value("${credential1c}")
	private String credential1c;
	private UserRepo userRepo;
	
	@Autowired
	public  Main(UserRepo userRepo) {	
		this.userRepo = userRepo;
	}
	@ModelAttribute
	public void addQueryObject(@CurrentUser User user,Model model){
		QueryForm query = new QueryForm();
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");		
		String dateToStr = dateFormat.format(date);	
		query.setDate1(dateToStr);
		query.setDate2(dateToStr);		
		query.setAccounts(user.getAccounts());		
		model.addAttribute("query",query);		
		
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView getReport(@CurrentUser User user,@Valid QueryForm query,BindingResult result,RedirectAttributes redirect) {
		
		try {
			Date date1 = UtillClass.getDateFromString(query.getDate1());
			Date date2 = UtillClass.getDateFromString(query.getDate2());
			if (date2.before(date1)) {
				result.rejectValue("date1", "date1", "date from cannot be greater then date to");
				
			}
		} catch (ParseException e) {
			result.rejectValue("date1", "date1", "date must be provided i format yyyy-MM-dd");			
		}
		
		// Checking if account belonging to client
		if (!user.isAdmin()) {
			if (!user.findAccount(query.getAccount())) {
				result.rejectValue("account", "account", "Access for  account " + query.getAccount() + " is denied");

			}

		}

		if (result.hasErrors()) {
			return new ModelAndView("index");			
		}


		RestTemplate restTemplate = new RestTemplate();		
		String url = "http://localhost/Custody_main/hs/custudy/";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
		        .queryParam("date1", query.getDate1())
		        .queryParam("date2", query.getDate2())
		        .queryParam("account", query.getAccount());
	
		
		String plainCreds = credential1c;		
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization","Basic "+base64Creds);
		
		HttpEntity<String> request = new HttpEntity<String>(headers);

		//
		ResponseEntity<Statement> response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, request, Statement.class);
		Statement statement = response.getBody();

		Map<String, Object> model = new HashMap<>();
		model.put("statement", statement);
		model.put("account",query.getAccount());
		model.put("date1", query.getDate1());
		model.put("date2", query.getDate2());
		return new ModelAndView("statement", model);		

	}

	@RequestMapping(method = RequestMethod.GET)
	public  ModelAndView mainPage() {
		Map<String, Object> model = new HashMap<>();
		model.put("account", "010709B");		
		return new ModelAndView("index", model);

	}
	
	@RequestMapping(value="/{accountId}",method = RequestMethod.GET)
	public  ModelAndView mainPageFilterByAccount(@PathVariable("accountId") Integer accountId,@CurrentUser User currentUser) {
		if (!currentUser.isAdmin()) {
			throw new ForbiddenException();
		}
		
		User user = userRepo.findOne(accountId.longValue());				
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");		
		String dateToStr = dateFormat.format(date);
		QueryForm query = new QueryForm();
		query.setDate1(dateToStr);
		query.setDate2(dateToStr);		
		query.setAccounts(user.getAccounts());
		Map<String, Object> model = new HashMap<>();
		model.put("query",query);				
		return new ModelAndView("index", model);

	}

}
