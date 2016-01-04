package com.stoms.model.temp;


public class ManagerOutlayQuery {
	private String itemId;
	private String itemName;
	private String typeName;
	private int isCross;
	private String teacherName;
	private String departmentName;
	private long addOutlayPk;
	private String cardId;
	private String contractId;
	private double outlayValue;
	private double remitValue; 
	private String outlayDepartment;
	private int isInvoice;
	private String timeLower;
	private String timeUpper;
	private String outlayTime;
	private String astatus;
		
	public ManagerOutlayQuery(String itemId,String itemName,String typeName,
			int isCross,String teacherName,String departmentName,long addOutlayPk,String cardId,
			String contractId,double outlayValue,double remitValue,String outlayDepartment,
			int isInvoice,String timeLower,String timeUpper,String outlayTime,String astatus) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.typeName =typeName;
		this.isCross = isCross;
		this.teacherName=teacherName;
		this.departmentName=departmentName;
		this.addOutlayPk=addOutlayPk;
		this.cardId=cardId;
		this.contractId=contractId;
		this.outlayValue=outlayValue;
		this.remitValue=remitValue;
		this.outlayDepartment=outlayDepartment;
		this.isInvoice=isInvoice;
		this.timeLower=timeLower;
		this.timeUpper=timeUpper;
		this.outlayTime=outlayTime;
		this.astatus=astatus;
	}
	
	public ManagerOutlayQuery() {

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


	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public int getIsCross() {
		return isCross;
	}


	public void setIsCross(int isCross) {
		this.isCross = isCross;
	}


	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getCardId() {
		return cardId;
	}


	public void setCardId(String cardId) {
		this.cardId = cardId;
	}


	public String getContractId() {
		return contractId;
	}


	public void setContractId(String contractId) {
		this.contractId = contractId;
	}


	public double getOutlayValue() {
		return outlayValue;
	}


	public void setOutlayValue(double outlayValue) {
		this.outlayValue = outlayValue;
	}


	public double getRemitValue() {
		return remitValue;
	}


	public void setRemitValue(double remitValue) {
		this.remitValue = remitValue;
	}


	public String getOutlayDepartment() {
		return outlayDepartment;
	}


	public void setOutlayDepartment(String outlayDepartment) {
		this.outlayDepartment = outlayDepartment;
	}


	public int getIsInvoice() {
		return isInvoice;
	}


	public void setIsInvoice(int isInvoice) {
		this.isInvoice = isInvoice;
	}


	public String getTimeLower() {
		return timeLower;
	}


	public void setTimeLower(String timeLower) {
		this.timeLower = timeLower;
	}


	public String getTimeUpper() {
		return timeUpper;
	}


	public void setTimeUpper(String timeUpper) {
		this.timeUpper = timeUpper;
	}


	public String getOutlayTime() {
		return outlayTime;
	}


	public void setOutlayTime(String outlayTime) {
		this.outlayTime = outlayTime;
	}

	public long getAddOutlayPk() {
		return addOutlayPk;
	}

	public void setAddOutlayPk(long addOutlayPk) {
		this.addOutlayPk = addOutlayPk;
	}

	public String getAstatus() {
		return astatus;
	}

	public void setAstatus(String astatus) {
		this.astatus = astatus;
	}
	
	
	
	
}
