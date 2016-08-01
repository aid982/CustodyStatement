package com.capital.dragon.statement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixedIncomeTrades extends Trades {	
	private String principal;
	private String accrued;
	private String totalConsideration;
	
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getAccrued() {
		return accrued;
	}
	public void setAccrued(String accrued) {
		this.accrued = accrued;
	}
	public String getTotalConsideration() {
		return totalConsideration;
	}
	public void setTotalConsideration(String totalConsideration) {
		this.totalConsideration = totalConsideration;
	}
	
	

}
