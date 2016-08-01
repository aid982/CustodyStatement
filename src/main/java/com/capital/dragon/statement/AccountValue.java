package com.capital.dragon.statement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountValue {
	private String securityCode;
	private String securityName;
	private String type;
	private String isin;
	private String qty;
	private String price;
	private String listingCCY;
	private String totalValueListing;
	private Double totalValueUSD;
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}	
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public String getSecurityName() {
		return securityName;
	}
	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIsin() {
		return isin;
	}
	public void setIsin(String isin) {
		this.isin = isin;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getListingCCY() {
		return listingCCY;
	}
	public void setListingCCY(String listingCCY) {
		this.listingCCY = listingCCY;
	}
	public String getTotalValueListing() {
		return totalValueListing;
	}
	public void setTotalValueListing(String totalValueListing) {
		this.totalValueListing = totalValueListing;
	}
	public Double getTotalValueUSD() {
		return totalValueUSD;
	}
	public void setTotalValueUSD(Double totalValueUSD) {
		this.totalValueUSD = totalValueUSD;
	}
	
	
	
	
	
	
	
	

}
