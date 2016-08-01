package com.capital.dragon.statement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public class SecurityMovement {	
	private String name;	
	private Double  qtyEndRem;	
	private Double  qtyBegRem;	
	private Double qtyPlus;	
	private Double qtyMinus;	
	private Double qtyPlanEnd;	
	private Double qtyPlanPlus;	
	private Double  qtyPlanMinus;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getQtyEndRem() {
		return qtyEndRem;
	}
	public void setQtyEndRem(Double qtyEndRem) {
		this.qtyEndRem = qtyEndRem;
	}
	public Double getQtyBegRem() {
		return qtyBegRem;
	}
	public void setQtyBegRem(Double qtyBegRem) {
		this.qtyBegRem = qtyBegRem;
	}
	public Double getQtyPlus() {
		return qtyPlus;
	}
	public void setQtyPlus(Double qtyPlus) {
		this.qtyPlus = qtyPlus;
	}
	public Double getQtyMinus() {
		return qtyMinus;
	}
	public void setQtyMinus(Double qtyMinus) {
		this.qtyMinus = qtyMinus;
	}
	public Double getQtyPlanEnd() {
		return qtyPlanEnd;
	}
	public void setQtyPlanEnd(Double qtyPlanEnd) {
		this.qtyPlanEnd = qtyPlanEnd;
	}
	public Double getQtyPlanPlus() {
		return qtyPlanPlus;
	}
	public void setQtyPlanPlus(Double qtyPlanPlus) {
		this.qtyPlanPlus = qtyPlanPlus;
	}
	public Double getQtyPlanMinus() {
		return qtyPlanMinus;
	}
	public void setQtyPlanMinus(Double qtyPlanMinus) {
		this.qtyPlanMinus = qtyPlanMinus;
	}
	@Override
	public String toString() {
		return "Security [Security=" + name + ", QtyEndRem=" + qtyEndRem + ", QtyBegRem=" + qtyBegRem + ", QtyPlus="
				+ qtyPlus + ", QtyMinus=" + qtyMinus + ", QtyPlanEnd=" + qtyPlanEnd + ", QtyPlanPlus=" + qtyPlanPlus
				+ ", QtyPlanMinus=" + qtyPlanMinus + "]";
	}
	public SecurityMovement() {	
	 
	}	
	

	}
