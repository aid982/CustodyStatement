package com.capital.dragon.statement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Trades {
	private String date;
	private String trade;
	private String buysell;
	private String security;
	private String ccy;
	private String qty;
	private String stl_date;
	private String stlAmount;
	private String price;
	private String comments;
	private String fx;
	private String charges;
	private String stl_ccy;
	
	
	public String getStl_ccy() {
		return stl_ccy;
	}
	public void setStl_ccy(String stl_ccy) {
		this.stl_ccy = stl_ccy;
	}
	public String getCharges() {
		return charges;
	}
	public void setCharges(String charges) {
		this.charges = charges;
	}
	public String getFx() {
		return fx;
	}
	public void setFx(String fx) {
		this.fx = fx;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStlAmount() {
		return stlAmount;
	}
	public void setStlAmount(String stlAmount) {
		this.stlAmount = stlAmount;
	}
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
	public String getBuysell() {
		return buysell;
	}
	public void setBuysell(String buysell) {
		this.buysell = buysell;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public String getCcy() {
		return ccy;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getStl_date() {
		return stl_date;
	}
	public void setStl_date(String stl_date) {
		this.stl_date = stl_date;
	}
	
	

}
