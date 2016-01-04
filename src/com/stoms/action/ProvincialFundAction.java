package com.stoms.action;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.service.ProvincialFundService;

public class ProvincialFundAction extends ActionSupport{
	
	
	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;
	
	private Long itemPK;
	private String itemName;
	private String teacherName;
	private String itemId;
	
	private Double actualNationFund;
	private Double actualAgencyFund;
	private Double actualCountyFund;
	private Double actualDepartmentFund;
	private Double actualSelfFund;
	private Double actualOtherFund;
	private Double actualFundTotal;
	
	private Double actualFundBudgetStaffCost;
	private Double actualFundBudgetEquipmentCost;
	private Double actualFundBudgetFuelCost;
	private Double actualFundBudgetMaterialCost;
	private Double actualFundBudgetTestCost;
	private Double actualFundBudgetTravelCost;
	private Double actualFundBudgetConferenceCost;
	private Double actualFundBudgetPublishCost;
	private Double actualFundBudgetManageCost;
	private Double actualFundBudgetOtherCost;
	private Double actualFundBudgetTotal;
	
	private ProvincialFundService provincialFundService;
	
	
	//获得所有项目为itemPK的项目
	public String acquireProvincialFundInfo(){
		
		this.jsonResult = provincialFundService.acquireProvincialFundInfo(itemPK);
		if(this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}
				
		this.actionStatus = true;
		return "success";
	}

	//保存数据
	public String saveProvincialFundInfo(){
		
		if(this.itemPK == null){
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		
		this.actionStatus = provincialFundService.saveProvincialFundInfo(
				itemPK, itemName, teacherName, itemId,

				actualNationFund, actualAgencyFund, actualCountyFund, actualDepartmentFund, 
				actualSelfFund, actualOtherFund, actualFundTotal, 
				
				actualFundBudgetStaffCost, actualFundBudgetEquipmentCost, actualFundBudgetFuelCost, actualFundBudgetMaterialCost, 
				actualFundBudgetTestCost, actualFundBudgetTravelCost, actualFundBudgetConferenceCost, actualFundBudgetPublishCost, 
				actualFundBudgetManageCost, actualFundBudgetOtherCost, actualFundBudgetTotal );
	
		this.jsonResult = "";
		return "success";
	}
	

	//提交数据
	public String submitProvincialFundInfo(){
		
		if(this.itemPK == null){
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		
		this.actionStatus = provincialFundService.submitProvincialFundInfo(
				itemPK, itemName, teacherName, itemId,

				actualNationFund, actualAgencyFund, actualCountyFund, actualDepartmentFund, 
				actualSelfFund, actualOtherFund, actualFundTotal, 
				
				actualFundBudgetStaffCost, actualFundBudgetEquipmentCost, actualFundBudgetFuelCost, actualFundBudgetMaterialCost, 
				actualFundBudgetTestCost, actualFundBudgetTravelCost, actualFundBudgetConferenceCost, actualFundBudgetPublishCost, 
				actualFundBudgetManageCost, actualFundBudgetOtherCost, actualFundBudgetTotal  );
	
		this.jsonResult = "";
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

	public Long getItemPK() {
		return itemPK;
	}

	public void setItemPK(Long itemPK) {
		this.itemPK = itemPK;
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

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Double getActualNationFund() {
		return actualNationFund;
	}

	public void setActualNationFund(Double actualNationFund) {
		this.actualNationFund = actualNationFund;
	}

	public Double getActualAgencyFund() {
		return actualAgencyFund;
	}

	public void setActualAgencyFund(Double actualAgencyFund) {
		this.actualAgencyFund = actualAgencyFund;
	}

	public Double getActualCountyFund() {
		return actualCountyFund;
	}

	public void setActualCountyFund(Double actualCountyFund) {
		this.actualCountyFund = actualCountyFund;
	}

	public Double getActualDepartmentFund() {
		return actualDepartmentFund;
	}

	public void setActualDepartmentFund(Double actualDepartmentFund) {
		this.actualDepartmentFund = actualDepartmentFund;
	}

	public Double getActualSelfFund() {
		return actualSelfFund;
	}

	public void setActualSelfFund(Double actualSelfFund) {
		this.actualSelfFund = actualSelfFund;
	}

	public Double getActualOtherFund() {
		return actualOtherFund;
	}

	public void setActualOtherFund(Double actualOtherFund) {
		this.actualOtherFund = actualOtherFund;
	}

	public Double getActualFundTotal() {
		return actualFundTotal;
	}

	public void setActualFundTotal(Double actualFundTotal) {
		this.actualFundTotal = actualFundTotal;
	}

	public Double getActualFundBudgetStaffCost() {
		return actualFundBudgetStaffCost;
	}

	public void setActualFundBudgetStaffCost(Double actualFundBudgetStaffCost) {
		this.actualFundBudgetStaffCost = actualFundBudgetStaffCost;
	}

	public Double getActualFundBudgetEquipmentCost() {
		return actualFundBudgetEquipmentCost;
	}

	public void setActualFundBudgetEquipmentCost(
			Double actualFundBudgetEquipmentCost) {
		this.actualFundBudgetEquipmentCost = actualFundBudgetEquipmentCost;
	}

	public Double getActualFundBudgetFuelCost() {
		return actualFundBudgetFuelCost;
	}

	public void setActualFundBudgetFuelCost(Double actualFundBudgetFuelCost) {
		this.actualFundBudgetFuelCost = actualFundBudgetFuelCost;
	}

	public Double getActualFundBudgetMaterialCost() {
		return actualFundBudgetMaterialCost;
	}

	public void setActualFundBudgetMaterialCost(Double actualFundBudgetMaterialCost) {
		this.actualFundBudgetMaterialCost = actualFundBudgetMaterialCost;
	}

	public Double getActualFundBudgetTestCost() {
		return actualFundBudgetTestCost;
	}

	public void setActualFundBudgetTestCost(Double actualFundBudgetTestCost) {
		this.actualFundBudgetTestCost = actualFundBudgetTestCost;
	}

	public Double getActualFundBudgetTravelCost() {
		return actualFundBudgetTravelCost;
	}

	public void setActualFundBudgetTravelCost(Double actualFundBudgetTravelCost) {
		this.actualFundBudgetTravelCost = actualFundBudgetTravelCost;
	}

	public Double getActualFundBudgetConferenceCost() {
		return actualFundBudgetConferenceCost;
	}

	public void setActualFundBudgetConferenceCost(
			Double actualFundBudgetConferenceCost) {
		this.actualFundBudgetConferenceCost = actualFundBudgetConferenceCost;
	}

	public Double getActualFundBudgetPublishCost() {
		return actualFundBudgetPublishCost;
	}

	public void setActualFundBudgetPublishCost(Double actualFundBudgetPublishCost) {
		this.actualFundBudgetPublishCost = actualFundBudgetPublishCost;
	}

	public Double getActualFundBudgetManageCost() {
		return actualFundBudgetManageCost;
	}

	public void setActualFundBudgetManageCost(Double actualFundBudgetManageCost) {
		this.actualFundBudgetManageCost = actualFundBudgetManageCost;
	}

	public Double getActualFundBudgetOtherCost() {
		return actualFundBudgetOtherCost;
	}

	public void setActualFundBudgetOtherCost(Double actualFundBudgetOtherCost) {
		this.actualFundBudgetOtherCost = actualFundBudgetOtherCost;
	}

	public Double getActualFundBudgetTotal() {
		return actualFundBudgetTotal;
	}

	public void setActualFundBudgetTotal(Double actualFundBudgetTotal) {
		this.actualFundBudgetTotal = actualFundBudgetTotal;
	}

	public ProvincialFundService getProvincialFundService() {
		return provincialFundService;
	}

	public void setProvincialFundService(ProvincialFundService provincialFundService) {
		this.provincialFundService = provincialFundService;
	}
	
}
