package com.capital.dragon.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	

}
