package com.capital.dragon.statement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MoneyMovement {
	
	private Boolean totals;
	private String currency;
	private String  trade;
	private String comments;
	private String stlDate;
	private Double open;
	private Double in;
	private Double out;
	private Double close;
	private Double expectedIn;
	private Double expectedOut;
	private Double expectedClose;
	
	public Boolean getTotals() {
		return totals;
	}
	public void setTotals(Boolean totals) {
		this.totals = totals;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getTrade() {
		return trade;
	}
	public void setTrade(String trade) {
		this.trade = trade;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getStlDate() {
		return stlDate;
	}
	public void setStlDate(String stlDate) {
		this.stlDate = stlDate;
	}
	public Double getOpen() {
		return open;
	}
	public void setOpen(Double open) {
		this.open = open;
	}
	public Double getIn() {
		return in;
	}
	public void setIn(Double in) {
		this.in = in;
	}
	public Double getOut() {
		return out;
	}
	public void setOut(Double out) {
		this.out = out;
	}
	public Double getClose() {
		return close;
	}
	public void setClose(Double close) {
		this.close = close;
	}
	public Double getExpectedIn() {
		return expectedIn;
	}
	public void setExpectedIn(Double expectedIn) {
		this.expectedIn = expectedIn;
	}
	public Double getExpectedOut() {
		return expectedOut;
	}
	public void setExpectedOut(Double expectedOut) {
		this.expectedOut = expectedOut;
	}
	public Double getExpectedClose() {
		return expectedClose;
	}
	public void setExpectedClose(Double expectedClose) {
		this.expectedClose = expectedClose;
	}
	public MoneyMovement() {		
	}
	
	
	

}
