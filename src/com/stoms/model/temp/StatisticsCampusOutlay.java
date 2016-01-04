package com.stoms.model.temp;

public class StatisticsCampusOutlay {
	private String groupName;
	private double outlay;
	private double addOutlay; 
	private double balance;
		
	public StatisticsCampusOutlay(String groupName,
			double outlay, double addOutlay) {
		this.groupName = groupName;
		this.outlay = outlay;
		this.addOutlay = addOutlay;
		this.balance = addOutlay-outlay;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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
	
	
	public StatisticsCampusOutlay(String groupName,
			double outlay, double addOutlay, double balance) {
		super();
		this.groupName = groupName;
		this.outlay = outlay;
		this.addOutlay = addOutlay;
		this.balance = balance;
	}


	
}
