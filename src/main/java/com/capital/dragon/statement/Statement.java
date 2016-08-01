package com.capital.dragon.statement;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public class Statement {
	private List<SecurityMovement> securityMovements = new ArrayList<>();
	private List<MoneyMovement> moneyMovements = new ArrayList<>();
	private List<EquityTrades> equityTrades = new ArrayList<>();
	private List<FixedIncomeTrades> fixedIncomeTrades = new ArrayList<>();
	private List<Trades> tradesInProcess = new ArrayList<>();
	private List<FX> fx = new ArrayList<>();
	private List<FX> fxInProcess = new ArrayList<>();
	private List<Deposits> deposits = new ArrayList<>();
	private List<AccountValue> accountValue = new ArrayList<>();
	private List<AccountBonds> accountValueBonds = new ArrayList<>();
	
	public String getSumOfBondsValue() {
		Double sum = accountValueBonds.stream().mapToDouble(e->e.getTotalValueUSD()).reduce(0.00, Double::sum);
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		return decimalFormat.format(sum);
		
	}
	
	public String getSumOfEquityValue() {
		Double sum =accountValue.stream().mapToDouble(e->e.getTotalValueUSD()).reduce(0.00, Double::sum);
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		return decimalFormat.format(sum);		 		
	}
	
	

	public List<EquityTrades> getEquityTrades() {
		return equityTrades;
	}

	public void setEquityTrades(List<EquityTrades> equityTrades) {
		this.equityTrades = equityTrades;
	}

	public List<FixedIncomeTrades> getFixedIncomeTrades() {
		return fixedIncomeTrades;
	}

	public void setFixedIncomeTrades(List<FixedIncomeTrades> fixedIncomeTrades) {
		this.fixedIncomeTrades = fixedIncomeTrades;
	}

	public List<Trades> getTradesInProcess() {
		return tradesInProcess;
	}

	public void setTradesInProcess(List<Trades> tradesInProcess) {
		this.tradesInProcess = tradesInProcess;
	}

	public List<FX> getFx() {
		return fx;
	}

	public void setFx(List<FX> fx) {
		this.fx = fx;
	}

	public List<FX> getFxInProcess() {
		return fxInProcess;
	}

	public void setFxInProcess(List<FX> fxInProcess) {
		this.fxInProcess = fxInProcess;
	}

	public List<Deposits> getDeposits() {
		return deposits;
	}

	public void setDeposits(List<Deposits> deposits) {
		this.deposits = deposits;
	}

	public List<AccountValue> getAccountValue() {
		return accountValue;
	}

	public void setAccountValue(List<AccountValue> accountValue) {
		this.accountValue = accountValue;
	}

	public List<AccountBonds> getAccountValueBonds() {
		return accountValueBonds;
	}

	public void setAccountValueBonds(List<AccountBonds> accountValueBonds) {
		this.accountValueBonds = accountValueBonds;
	}

	public List<MoneyMovement> getMoneyMovements() {
		return moneyMovements;
	}

	public void setMoneyMovements(List<MoneyMovement> moneyMovements) {
		this.moneyMovements = moneyMovements;
	}

	public List<SecurityMovement> getSecurityMovements() {
		return securityMovements;
	}

	public void setSecurityMovements(List<SecurityMovement> securityMovements) {
		this.securityMovements = securityMovements;
	}

	public Statement() {		
	}

	@Override
	public String toString() {
		return "Statement [securityMovements=" + securityMovements + "]";
	}
	

	


	
	
	
	
	

	
	
	

}
