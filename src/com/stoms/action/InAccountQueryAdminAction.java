package com.stoms.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.model.AddOutlay;
import com.stoms.model.Item;
import com.stoms.model.TeacherLogin;
import com.stoms.service.InAccountQueryAdminService;
import com.stoms.utils.JSONTranslation;


/**
 * 管理页面下经费查询的action
 * 
 * @author xjk
 *
 */
public class InAccountQueryAdminAction extends ActionSupport{

	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;
	
	
	private int isCross;
	private String itemName;
	private String teacherName;
	private String cardId;
	private String itemId;
	private String contractId;
	
	//来款单位
	private String outlayDepartment;
	
	//是否开了发票
	private int isInvoice;
	
	//项目的时间
	private String timeLower;
	private String timeUpper;
	
	//入账的时间
	private String outlayStartDate;
	private String outlayEndDate;
	
	private int[] selectedItemTypePKs;
	private int[] selectedDepartmentPKs;
	
	private double outlayValue;
	private double remitValue;
	private String departmentId;
	private String departmentType;
	private long addoutlayPK;

	private AddOutlay addoutlay;
	private String otherTeacher;
	private String departmentName;
	private int typePk;
	private String typeId;
	private String typeName;
	private String other;
	private double pay;
	private double manage;
	private double pay2;
	private double manage2;
	private double availableManageCredit;
	private double consult;
	private double act;
	private double improve;
	private double directValue;
	private double indirectValue;
	private double performance;
	private double equipment;
	private double departmentPublic;
	private double coProject;
	private double performance1;
	private double performance2;
	private double departmentPay;
	private double pay3;
	private int isTax;
	private double tax1;
	private double tax2;
	private double tax3;
	private String remark;
	
	
	private InAccountQueryAdminService inAccountQueryAdminService;
	
	public String deleteAddoutlay(){
		long[] PKArray ={addoutlayPK};
		this.actionStatus = inAccountQueryAdminService.getAddOutlayService().deleteSelectedAddoutlay(PKArray);
		this.jsonResult = "";
		return "success";
	}
	
	public String modifyAddoutlay(){
		this.jsonResult = "";
		boolean eq = inAccountQueryAdminService.getAddOutlayService().isEqual(
				addoutlayPK, outlayDepartment, teacherName, otherTeacher, 
				outlayValue, itemId, cardId, 
				departmentId, departmentName, departmentType, 
				typePk, typeId, typeName, 
				remitValue, other, pay, manage, pay2, manage2, 
				availableManageCredit, consult, act, improve, 
				directValue, indirectValue, performance, equipment, 
				departmentPublic, coProject, performance1, performance2,
				isCross, departmentPay, pay3, isTax, tax1, tax2, tax3,remark);
		if(eq){
			this.actionStatus = false;
			this.jsonResult = "{'equal':1}";
		}else{
			AddOutlay addoutlay = inAccountQueryAdminService.getAddOutlayService().modifyAddOutlay(
					addoutlayPK, outlayDepartment, teacherName, otherTeacher, 
					outlayValue, itemId, cardId, 
					departmentId, departmentName, departmentType, 
					typePk, typeId, typeName, 
					remitValue, other, pay, manage, pay2, manage2, 
					availableManageCredit, consult, act, improve, 
					directValue, indirectValue, performance, equipment, 
					departmentPublic, coProject, performance1, performance2,
					isCross, departmentPay, pay3, isTax, tax1, tax2, tax3,remark);
			if(addoutlay != null){
				this.actionStatus = true;
			}else{
				this.actionStatus = false;
			}
		}
		return "success";
	}
	
	//acquireOneAddoutlayInfoByAddOutlayPK
	public String acquireOneAddoutlayInfo() {
		String addoutlay = inAccountQueryAdminService.acquireOneAddoutlayInfo(addoutlayPK);
		System.out.println(addoutlay);
		if( addoutlay.equals("") ) {
			this.actionStatus = false;
			this.jsonResult = "";
		}
		else {
			this.actionStatus = true;
			this.jsonResult = addoutlay;
		}
		return "success";
	}
	
	public String addoutlayQuery() {
		
		this.jsonResult = inAccountQueryAdminService.addoutlayQuery(itemId,outlayValue,
				remitValue, isCross, outlayDepartment, teacherName, departmentId,
				departmentType, timeLower, timeUpper);
		
		if(this.jsonResult == ""){
			this.actionStatus = false;
		}else{
			this.actionStatus = true;
		}
		return "success";
	}
	
	public String inAccountAdminQuery() {
		
		this.jsonResult = inAccountQueryAdminService.inAccountAdminQuery(
				 itemName, teacherName, cardId, itemId, contractId, outlayDepartment, 
				 isInvoice, isCross, timeLower, timeUpper, outlayStartDate,
				 outlayEndDate, selectedItemTypePKs, selectedDepartmentPKs );
		
		if(this.jsonResult == ""){
			this.actionStatus = false;
		}else{
			this.actionStatus = true;
		}
		return "success";
	}

	public String getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	public boolean isActionStatus() {
		return actionStatus;
	}

	public void setActionStatus(boolean actionStatus) {
		this.actionStatus = actionStatus;
	}

	public int getIsCross() {
		return isCross;
	}

	public void setIsCross(int isCross) {
		this.isCross = isCross;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
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

	public String getOutlayStartDate() {
		return outlayStartDate;
	}

	public void setOutlayStartDate(String outlayStartDate) {
		this.outlayStartDate = outlayStartDate;
	}

	public String getOutlayEndDate() {
		return outlayEndDate;
	}

	public void setOutlayEndDate(String outlayEndDate) {
		this.outlayEndDate = outlayEndDate;
	}

	public int[] getSelectedItemTypePKs() {
		return selectedItemTypePKs;
	}

	public void setSelectedItemTypePKs(int[] selectedItemTypePKs) {
		this.selectedItemTypePKs = selectedItemTypePKs;
	}

	public int[] getSelectedDepartmentPKs() {
		return selectedDepartmentPKs;
	}

	public void setSelectedDepartmentPKs(int[] selectedDepartmentPKs) {
		this.selectedDepartmentPKs = selectedDepartmentPKs;
	}

	public InAccountQueryAdminService getInAccountQueryAdminService() {
		return inAccountQueryAdminService;
	}

	public void setInAccountQueryAdminService(
			InAccountQueryAdminService inAccountQueryAdminService) {
		this.inAccountQueryAdminService = inAccountQueryAdminService;
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

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentType() {
		return departmentType;
	}

	public void setDepartmentType(String departmentType) {
		this.departmentType = departmentType;
	}

	public long getAddoutlayPK() {
		return addoutlayPK;
	}

	public void setAddoutlayPK(long addoutlayPK) {
		this.addoutlayPK = addoutlayPK;
	}

	public AddOutlay getAddoutlay() {
		return addoutlay;
	}

	public void setAddoutlay(AddOutlay addoutlay) {
		this.addoutlay = addoutlay;
	}

	public String getOtherTeacher() {
		return otherTeacher;
	}

	public void setOtherTeacher(String otherTeacher) {
		this.otherTeacher = otherTeacher;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getTypePk() {
		return typePk;
	}

	public void setTypePk(int typePk) {
		this.typePk = typePk;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}

	public double getManage() {
		return manage;
	}

	public void setManage(double manage) {
		this.manage = manage;
	}

	public double getPay2() {
		return pay2;
	}

	public void setPay2(double pay2) {
		this.pay2 = pay2;
	}

	public double getManage2() {
		return manage2;
	}

	public void setManage2(double manage2) {
		this.manage2 = manage2;
	}

	public double getAvailableManageCredit() {
		return availableManageCredit;
	}

	public void setAvailableManageCredit(double availableManageCredit) {
		this.availableManageCredit = availableManageCredit;
	}

	public double getConsult() {
		return consult;
	}

	public void setConsult(double consult) {
		this.consult = consult;
	}

	public double getAct() {
		return act;
	}

	public void setAct(double act) {
		this.act = act;
	}

	public double getImprove() {
		return improve;
	}

	public void setImprove(double improve) {
		this.improve = improve;
	}

	public double getDirectValue() {
		return directValue;
	}

	public void setDirectValue(double directValue) {
		this.directValue = directValue;
	}

	public double getIndirectValue() {
		return indirectValue;
	}

	public void setIndirectValue(double indirectValue) {
		this.indirectValue = indirectValue;
	}

	public double getPerformance() {
		return performance;
	}

	public void setPerformance(double performance) {
		this.performance = performance;
	}

	public double getEquipment() {
		return equipment;
	}

	public void setEquipment(double equipment) {
		this.equipment = equipment;
	}

	public double getDepartmentPublic() {
		return departmentPublic;
	}

	public void setDepartmentPublic(double departmentPublic) {
		this.departmentPublic = departmentPublic;
	}

	public double getCoProject() {
		return coProject;
	}

	public void setCoProject(double coProject) {
		this.coProject = coProject;
	}

	public double getPerformance1() {
		return performance1;
	}

	public void setPerformance1(double performance1) {
		this.performance1 = performance1;
	}

	public double getPerformance2() {
		return performance2;
	}

	public void setPerformance2(double performance2) {
		this.performance2 = performance2;
	}

	public double getDepartmentPay() {
		return departmentPay;
	}

	public void setDepartmentPay(double departmentPay) {
		this.departmentPay = departmentPay;
	}

	public double getPay3() {
		return pay3;
	}

	public void setPay3(double pay3) {
		this.pay3 = pay3;
	}

	public int getIsTax() {
		return isTax;
	}

	public void setIsTax(int isTax) {
		this.isTax = isTax;
	}

	public double getTax1() {
		return tax1;
	}

	public void setTax1(double tax1) {
		this.tax1 = tax1;
	}

	public double getTax2() {
		return tax2;
	}

	public void setTax2(double tax2) {
		this.tax2 = tax2;
	}

	public double getTax3() {
		return tax3;
	}

	public void setTax3(double tax3) {
		this.tax3 = tax3;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
