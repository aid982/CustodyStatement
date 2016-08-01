package com.capital.dragon.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_table")
public class User  {
	@Id
	@GeneratedValue
	private Long id;		
	@Size(max = 100, min = 5)
	private String login;	
	@NotNull
	@Email
	private String email;	
	private String name;
	@NotNull
	private String password;	
	private Date passwordExpireDate;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Account> accounts = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable
	@JsonIgnore	
	private List<Role> roles = new  ArrayList<>();
	
	private Boolean enabled;
	
	
	
	public User() {
		
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		password = passwordEncoder.encode(password);		
		this.password = password;
	}
	
	public Boolean isPasswordMatched(String password){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();		
		return passwordEncoder.matches(password, this.password); 
		
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	public Date getPasswordExpireDate() {
		return passwordExpireDate;
	}
	public void setPasswordExpireDate(Date passwordExpireDate) {
		this.passwordExpireDate = passwordExpireDate;
	}
	public User(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.login = user.getLogin();
		this.roles = user.getRoles();
		this.accounts = user.getAccounts();
		this.passwordExpireDate = user.getPasswordExpireDate();
		this.enabled = user.getEnabled();
		
		
	}
	public String[] getRolesAsStrings(){
		String[] arrayRoles = new String[roles.size()];
		for (int i = 0; i < roles.size(); i++) {
			arrayRoles[i] = roles.get(i).toString();		
		}		
		return arrayRoles;
		
	}
	
	public Boolean isAdmin() {
		Iterator<Role> iterator =this.getRoles().iterator();
		while(iterator.hasNext()){
			Role role=iterator.next();			
			if((role!=null)&&(role.getId().equals("ROLE_ADMIN"))) {
				return true;				
			}
		}
		return false;		
	}
	public Boolean findAccount(String account) {
		Optional<Account> findAccount = this.accounts.stream().filter(x->x.getId().equals(account)).findFirst();
		return findAccount.isPresent();
		
	}
	
	
	

}
