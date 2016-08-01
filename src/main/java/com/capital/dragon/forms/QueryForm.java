package com.capital.dragon.forms;

import java.util.ArrayList;
import java.util.List;

import com.capital.dragon.model.Account;

public class QueryForm {
	private String date1;
	private String date2;
	private String account;
	private List<Account> accounts = new ArrayList<>();
	
	
	
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	

}
