package com.stoms.model.temp;

public class TeacherStatisticsSelfOutlay {
	private String itemId;
	private String contractId;
	private String itemName;
	private double outlay;
	private double addOutlay; 
	private double sumoutlay;
	private double sumaddoutlay;
	private double sumbalance;
		
	public TeacherStatisticsSelfOutlay(String itemId, String contractId, String itemName,
			double outlay, double addOutlay,double sumoutlay,double sumaddoutlay) {
		this.itemId = itemId;
		this.contractId = contractId;
		this.itemName = itemName;
		this.outlay = outlay;
		this.addOutlay = addOutlay;
		this.sumoutlay=sumoutlay;
		this.sumaddoutlay=sumaddoutlay;
		this.sumbalance=sumaddoutlay-sumoutlay;
	}
	
	
//	public TeacherStatisticsSelfOutlay(String itemId, String itemName,
//			double outlay, double addOutlay) {
//		super();
//		this.itemId = itemId;
//		this.itemName = itemName;
//		this.outlay = outlay;
//		this.addOutlay = addOutlay;
//	}


	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getOutlay() {
		return outlay;
	}
	public void setOutlay(double outlay) {
		this.outlay = outlay;
	}
	public double getAddOutlay() {
		return addOutlay;
	}
	public void setAddOutlay(double addOutlay) {
		this.addOutlay = addOutlay;
	}


	public double getSumoutlay() {
		return sumoutlay;
	}


	public void setSumoutlay(double sumoutlay) {
		this.sumoutlay = sumoutlay;
	}


	public double getSumaddoutlay() {
		return sumaddoutlay;
	}


	public void setSumaddoutlay(double sumaddoutlay) {
		this.sumaddoutlay = sumaddoutlay;
	}


	public double getSumbalance() {
		return sumbalance;
	}


	public void setSumbalance(double sumbalance) {
		this.sumbalance = sumbalance;
	}


	public String getContractId() {
		return contractId;
	}


	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	
	
}
