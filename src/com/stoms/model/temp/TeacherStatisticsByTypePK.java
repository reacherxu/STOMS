package com.stoms.model.temp;

public class TeacherStatisticsByTypePK {
	private String itemId;
	private String itemName;
	private double outlay;
	private double addOutlay; 
	private double balance;
		
	public TeacherStatisticsByTypePK(String itemId, String itemName,
			double outlay, double addOutlay) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.outlay = outlay;
		this.addOutlay = addOutlay;
		this.balance = addOutlay-outlay;
	}
	
	
	public TeacherStatisticsByTypePK(String itemId, String itemName,
			double outlay, double addOutlay, double balance) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.outlay = outlay;
		this.addOutlay = addOutlay;
		this.balance = balance;
	}


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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
