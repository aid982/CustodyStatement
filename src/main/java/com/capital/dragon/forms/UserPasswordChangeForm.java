package com.capital.dragon.forms;

public class UserPasswordChangeForm {
	private String login;
	private String passwordOld;
	private String password;
	private String passwordConfirmed;
	
	
	public String getPasswordOld() {
		return passwordOld;
	}
	public void setPasswordOld(String passwordOld) {
		this.passwordOld = passwordOld;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmed() {
		return passwordConfirmed;
	}
	public void setPasswordConfirmed(String passwordConfirmed) {
		this.passwordConfirmed = passwordConfirmed;
	}
	
	

}
