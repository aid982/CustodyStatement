package com.capital.dragon.statement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountBonds extends AccountValue{
	private String accrued;

	public String getAccrued() {
		return accrued;
	}

	public void setAccrued(String accrued) {
		this.accrued = accrued;
	}
	
	

}
