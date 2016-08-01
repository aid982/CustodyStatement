package com.capital.dragon.statement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FX {
	private String date;
	private String trade;
	private String initAmount;
	private String finalAmount;
	private String initCCY;
	private String finalCCY;
	private String fxRate;
	private String stlDate;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTrade() {
		return trade;
	}
	public void setTrade(String trade) {
		this.trade = trade;
	}
	public String getInitAmount() {
		return initAmount;
	}
	public void setInitAmount(String initAmount) {
		this.initAmount = initAmount;
	}
	public String getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(String finalAmount) {
		this.finalAmount = finalAmount;
	}
	public String getInitCCY() {
		return initCCY;
	}
	public void setInitCCY(String initCCY) {
		this.initCCY = initCCY;
	}
	public String getFinalCCY() {
		return finalCCY;
	}
	public void setFinalCCY(String finalCCY) {
		this.finalCCY = finalCCY;
	}
	public String getFxRate() {
		return fxRate;
	}
	public void setFxRate(String fxRate) {
		this.fxRate = fxRate;
	}
	public String getStlDate() {
		return stlDate;
	}
	public void setStlDate(String stlDate) {
		this.stlDate = stlDate;
	}
	
	

}
