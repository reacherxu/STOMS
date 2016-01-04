package com.stoms.model.temp;

public class StatisticsTeacherOutlay {
	private String teacherId;
	private String teacherName;
	private String departmentName;
	private double outlay;
	private double addOutlay; 
	private double balance;
		
	public StatisticsTeacherOutlay(String teacherId,String teacherName,String departmentName,
			double outlay, double addOutlay) {
		this.teacherId=teacherId;
		this.teacherName = teacherName;
		this.departmentName=departmentName;
		this.outlay = outlay;
		this.addOutlay = addOutlay;
		this.balance = addOutlay-outlay;
	}
	
	
	public StatisticsTeacherOutlay(String teacherId,String teacherName,String departmentName,
			double outlay, double addOutlay, double balance) {
		super();
		this.teacherId=teacherId;
		this.teacherName = teacherName;
		this.departmentName=departmentName;
		this.outlay = outlay;
		this.addOutlay = addOutlay;
		this.balance = balance;
	}


	public String getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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
