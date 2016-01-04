package com.stoms.action;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.service.ProvincialOutlayService;

public class ProvincialOutlayAction extends ActionSupport{
	
	
	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;
	
	private Long itemPK;
	private String itemName;
	private String teacherName;
	private String itemId;
	
	private Long outlayPk;
	
	private Double agencyStaffCost;
	private Double agencyEquipmentCost;
	private Double agencyFuelCost;
	private Double agencyMaterialCost;
	private Double agencyTestCost;
	private Double agencyTravelCost;
	private Double agencyConferenceCost;
	private Double agencyPublishCost;
	private Double agencyManageCost;
	private Double agencyOtherCost;
	private Double agencyFundTotal;
	
	private Double selfStaffCost;
	private Double selfEquipmentCost;
	private Double selfFuelCost;
	private Double selfMaterialCost;
	private Double selfTestCost;
	private Double selfTravelCost;
	private Double selfConferenceCost;
	private Double selfPublishCost;
	private Double selfManageCost;
	private Double selfOtherCost;
	private Double selfFundTotal;
	
	private Double sumStaffCost;
	private Double sumEquipmentCost;
	private Double sumFuelCost;
	private Double sumMaterialCost;
	private Double sumTestCost;
	private Double sumTravelCost;
	private Double sumConferenceCost;
	private Double sumPublishCost;
	private Double sumManageCost;
	private Double sumOtherCost;
	private Double sumFundTotal;
	
	private ProvincialOutlayService provincialOutlayService;
	
	
	//获得所有项目为itemPK的项目
	public String acquireProvincialOutlayInfo(){
	
		
		this.jsonResult = provincialOutlayService.acquireProvincialOutlayInfo(itemPK);
		if(this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}
		
		this.actionStatus = true;
		return "success";
	}

	//提交数据
	public String submitProvincialOutlayInfo(){
		
		if(this.itemPK == null){
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		
		this.actionStatus = provincialOutlayService.submitProvincialOutlayInfo(
				
				itemPK, itemId,

				agencyStaffCost, agencyEquipmentCost, agencyFuelCost, agencyMaterialCost, 
				agencyTestCost, agencyTravelCost, agencyConferenceCost, agencyPublishCost, 
				agencyManageCost, agencyOtherCost, agencyFundTotal, 
				
				selfStaffCost, selfEquipmentCost, selfFuelCost, selfMaterialCost, 
				selfTestCost, selfTravelCost, selfConferenceCost, selfPublishCost, 
				selfManageCost, selfOtherCost, selfFundTotal, 
				
				sumStaffCost, sumEquipmentCost, sumFuelCost, sumMaterialCost, 
				sumTestCost, sumTravelCost, sumConferenceCost, sumPublishCost, 
				sumManageCost, sumOtherCost, sumFundTotal );
	
		this.jsonResult = "";
		return "success";
	}
	
	public String acquireProvincialOutlayHistory(){
		
		if(itemPK == null)  {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		this.jsonResult = provincialOutlayService.acquireProvincialOutlayHistory(itemPK);
		
		this.actionStatus = true;
		return "success";
	}
	
	public String acquireProvincialOutlayView( ) {
		
		if( itemPK == null || outlayPk == null )  {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		this.jsonResult = provincialOutlayService.acquireProvincialOutlayView(itemPK, outlayPk);
		
		this.actionStatus = true;
		return "success";
	}
	
	public String acquireProvincialStatistic () {
		
		if( itemPK == null )  {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		this.jsonResult = provincialOutlayService.acquireProvincialStatistic(itemPK);
		
		this.actionStatus = true;
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

	public Long getOutlayPk() {
		return outlayPk;
	}

	public void setOutlayPk(Long outlayPk) {
		this.outlayPk = outlayPk;
	}

	public Double getAgencyStaffCost() {
		return agencyStaffCost;
	}

	public void setAgencyStaffCost(Double agencyStaffCost) {
		this.agencyStaffCost = agencyStaffCost;
	}

	public Double getAgencyEquipmentCost() {
		return agencyEquipmentCost;
	}

	public void setAgencyEquipmentCost(Double agencyEquipmentCost) {
		this.agencyEquipmentCost = agencyEquipmentCost;
	}

	public Double getAgencyFuelCost() {
		return agencyFuelCost;
	}

	public void setAgencyFuelCost(Double agencyFuelCost) {
		this.agencyFuelCost = agencyFuelCost;
	}

	public Double getAgencyMaterialCost() {
		return agencyMaterialCost;
	}

	public void setAgencyMaterialCost(Double agencyMaterialCost) {
		this.agencyMaterialCost = agencyMaterialCost;
	}

	public Double getAgencyTestCost() {
		return agencyTestCost;
	}

	public void setAgencyTestCost(Double agencyTestCost) {
		this.agencyTestCost = agencyTestCost;
	}

	public Double getAgencyTravelCost() {
		return agencyTravelCost;
	}

	public void setAgencyTravelCost(Double agencyTravelCost) {
		this.agencyTravelCost = agencyTravelCost;
	}

	public Double getAgencyConferenceCost() {
		return agencyConferenceCost;
	}

	public void setAgencyConferenceCost(Double agencyConferenceCost) {
		this.agencyConferenceCost = agencyConferenceCost;
	}

	public Double getAgencyPublishCost() {
		return agencyPublishCost;
	}

	public void setAgencyPublishCost(Double agencyPublishCost) {
		this.agencyPublishCost = agencyPublishCost;
	}

	public Double getAgencyManageCost() {
		return agencyManageCost;
	}

	public void setAgencyManageCost(Double agencyManageCost) {
		this.agencyManageCost = agencyManageCost;
	}

	public Double getAgencyOtherCost() {
		return agencyOtherCost;
	}

	public void setAgencyOtherCost(Double agencyOtherCost) {
		this.agencyOtherCost = agencyOtherCost;
	}

	public Double getAgencyFundTotal() {
		return agencyFundTotal;
	}

	public void setAgencyFundTotal(Double agencyFundTotal) {
		this.agencyFundTotal = agencyFundTotal;
	}

	public Double getSelfStaffCost() {
		return selfStaffCost;
	}

	public void setSelfStaffCost(Double selfStaffCost) {
		this.selfStaffCost = selfStaffCost;
	}

	public Double getSelfEquipmentCost() {
		return selfEquipmentCost;
	}

	public void setSelfEquipmentCost(Double selfEquipmentCost) {
		this.selfEquipmentCost = selfEquipmentCost;
	}

	public Double getSelfFuelCost() {
		return selfFuelCost;
	}

	public void setSelfFuelCost(Double selfFuelCost) {
		this.selfFuelCost = selfFuelCost;
	}

	public Double getSelfMaterialCost() {
		return selfMaterialCost;
	}

	public void setSelfMaterialCost(Double selfMaterialCost) {
		this.selfMaterialCost = selfMaterialCost;
	}

	public Double getSelfTestCost() {
		return selfTestCost;
	}

	public void setSelfTestCost(Double selfTestCost) {
		this.selfTestCost = selfTestCost;
	}

	public Double getSelfTravelCost() {
		return selfTravelCost;
	}

	public void setSelfTravelCost(Double selfTravelCost) {
		this.selfTravelCost = selfTravelCost;
	}

	public Double getSelfConferenceCost() {
		return selfConferenceCost;
	}

	public void setSelfConferenceCost(Double selfConferenceCost) {
		this.selfConferenceCost = selfConferenceCost;
	}

	public Double getSelfPublishCost() {
		return selfPublishCost;
	}

	public void setSelfPublishCost(Double selfPublishCost) {
		this.selfPublishCost = selfPublishCost;
	}

	public Double getSelfManageCost() {
		return selfManageCost;
	}

	public void setSelfManageCost(Double selfManageCost) {
		this.selfManageCost = selfManageCost;
	}

	public Double getSelfOtherCost() {
		return selfOtherCost;
	}

	public void setSelfOtherCost(Double selfOtherCost) {
		this.selfOtherCost = selfOtherCost;
	}

	public Double getSelfFundTotal() {
		return selfFundTotal;
	}

	public void setSelfFundTotal(Double selfFundTotal) {
		this.selfFundTotal = selfFundTotal;
	}

	public Double getSumStaffCost() {
		return sumStaffCost;
	}

	public void setSumStaffCost(Double sumStaffCost) {
		this.sumStaffCost = sumStaffCost;
	}

	public Double getSumEquipmentCost() {
		return sumEquipmentCost;
	}

	public void setSumEquipmentCost(Double sumEquipmentCost) {
		this.sumEquipmentCost = sumEquipmentCost;
	}

	public Double getSumFuelCost() {
		return sumFuelCost;
	}

	public void setSumFuelCost(Double sumFuelCost) {
		this.sumFuelCost = sumFuelCost;
	}

	public Double getSumMaterialCost() {
		return sumMaterialCost;
	}

	public void setSumMaterialCost(Double sumMaterialCost) {
		this.sumMaterialCost = sumMaterialCost;
	}

	public Double getSumTestCost() {
		return sumTestCost;
	}

	public void setSumTestCost(Double sumTestCost) {
		this.sumTestCost = sumTestCost;
	}

	public Double getSumTravelCost() {
		return sumTravelCost;
	}

	public void setSumTravelCost(Double sumTravelCost) {
		this.sumTravelCost = sumTravelCost;
	}

	public Double getSumConferenceCost() {
		return sumConferenceCost;
	}

	public void setSumConferenceCost(Double sumConferenceCost) {
		this.sumConferenceCost = sumConferenceCost;
	}

	public Double getSumPublishCost() {
		return sumPublishCost;
	}

	public void setSumPublishCost(Double sumPublishCost) {
		this.sumPublishCost = sumPublishCost;
	}

	public Double getSumManageCost() {
		return sumManageCost;
	}

	public void setSumManageCost(Double sumManageCost) {
		this.sumManageCost = sumManageCost;
	}

	public Double getSumOtherCost() {
		return sumOtherCost;
	}

	public void setSumOtherCost(Double sumOtherCost) {
		this.sumOtherCost = sumOtherCost;
	}

	public Double getSumFundTotal() {
		return sumFundTotal;
	}

	public void setSumFundTotal(Double sumFundTotal) {
		this.sumFundTotal = sumFundTotal;
	}

	public ProvincialOutlayService getProvincialOutlayService() {
		return provincialOutlayService;
	}

	public void setProvincialOutlayService(
			ProvincialOutlayService provincialOutlayService) {
		this.provincialOutlayService = provincialOutlayService;
	}
}
