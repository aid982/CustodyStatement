package com.capital.dragon.statement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EquityTrades  extends Trades {
	
	private String gross;
	
	private String net;	
		

	public String getGross() {
		return gross;
	}
	public void setGross(String gross) {
		this.gross = gross;
	}

	public String getNet() {
		return net;
	}
	public void setNet(String net) {
		this.net = net;
	}

	
	

}
