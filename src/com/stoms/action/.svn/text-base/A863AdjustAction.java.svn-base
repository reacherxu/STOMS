package com.stoms.action;

import java.util.List;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.service.A863adjustService;
import com.stoms.service.ItemService;
import com.stoms.utils.JSONTranslation;


public class A863AdjustAction extends ActionSupport{

	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;
	
	private Long itemPK;
	private Long a863adjustPk;
	
	private Double costSum_adjust;
	private Double equipmentCost_adjust;
	private Double materialCost_adjust;
	private Double testCost_adjust;
	private Double fuelCost_adjust;
	private Double travelCost_adjust;
	private Double conferenceCost_adjust;
	private Double exchangeCost_adjust;
	private Double publishCost_adjust;
	private Double serviceCost_adjust;
	private Double consultCost_adjust;
	private Double indirectCost_adjust;
	private Double otherCost_adjust;
	private String ntime;
	
	private Double costSum_after;
	private Double equipmentCost_after;
	private Double materialCost_after;
	private Double testCost_after;
	private Double fuelCost_after;
	private Double travelCost_after;
	private Double conferenceCost_after;
	private Double exchangeCost_after;
	private Double publishCost_after;
	private Double serviceCost_after;
	private Double consultCost_after;
	private Double indirectCost_after;
	private Double otherCost_after;
	
	private String suggestion;
	
	private A863adjustService a863adjustService;
	private ItemService itemService;
	
	//获得所有项目为itemPK的项目预算调整
	public String acquire863AdjustInfo(){
		
		this.jsonResult = a863adjustService.acquire863AdjustInfo(a863adjustPk,itemPK);
		if(this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}
				
		this.actionStatus = true;
		return "success";
	}
	
	//保存调整
	public String save863Adjust(){
		
		if(this.itemPK == null){
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		this.actionStatus = a863adjustService.save863Adjust(this.a863adjustPk,this.itemPK, 
				this.costSum_adjust, this.equipmentCost_adjust, this.materialCost_adjust, this.testCost_adjust, 
				this.fuelCost_adjust,this.travelCost_adjust, this.conferenceCost_adjust, this.exchangeCost_adjust, 
				this.publishCost_adjust,this.serviceCost_adjust,
				this.consultCost_adjust,this.indirectCost_adjust,this.otherCost_adjust,this.ntime);
	
		this.jsonResult = "";
		return "success";
		
	}
	
	//提交调整
	public String submit863Adjust(){
			
			if(this.itemPK == null){
				this.actionStatus = false;
				this.jsonResult = "";
				return "success";
			}
			
			this.actionStatus = a863adjustService.submit863Adjust(this.a863adjustPk,this.itemPK, 
					this.costSum_adjust, this.equipmentCost_adjust, this.materialCost_adjust, this.testCost_adjust, 
					this.fuelCost_adjust,this.travelCost_adjust, this.conferenceCost_adjust, this.exchangeCost_adjust, 
					this.publishCost_adjust,this.serviceCost_adjust,
					this.consultCost_adjust,this.indirectCost_adjust,this.otherCost_adjust,this.ntime);
		
			this.jsonResult = "";
			return "success";
			
	}
	
	//获得itemPK项目所有的预算调整
	public String acquireAll863AdjustList(){
		
		if(itemPK == null)  {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		String itemInfo = "{}";
		itemInfo = itemService.findItemByItemPK(itemPK);

		List all863AdjustList = a863adjustService.acquireAll863AdjustList(itemPK);

//		if (all863AdjustList == null
//				|| all863AdjustList.size() == 0) {
//			this.actionStatus = false;
//			this.jsonResult = "";
//			return "success";
//		}


		String[] excludes = {};

		String all863AdjustListinfo= JSONTranslation.arrayToJson(all863AdjustList,
				excludes);
		
		JSONObject jsonObject = new JSONObject();
	    jsonObject.element("itemInfo", itemInfo);
    	jsonObject.element("all863AdjustListinfo", all863AdjustListinfo);
		this.jsonResult = jsonObject.toString();

		if (this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = true;
		return "success";
		
	
	}
	
	
	

	//获得所有已提交的待审批的预算调整列表
	public String acquireAllUnAudited863Adjust(){
		
		List budgetAdjustList = a863adjustService.acquireAllUnAudited863Adjust();
		
		if (budgetAdjustList == null || budgetAdjustList.size() == 0) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		String[] excludes = {};

		this.jsonResult = JSONTranslation.arrayToJson(budgetAdjustList,excludes);

		if (this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = true;
		return "success";
		
	}
	
	//审批通过，保存预算总经费到预算表里
	public String A863AdjustAuditPass(){
		
		if(this.itemPK == null){
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		this.actionStatus = a863adjustService.A863AdjustAuditPass(this.a863adjustPk,this.itemPK, 
				this.costSum_after, this.equipmentCost_after, this.materialCost_after, this.testCost_after, 
				this.fuelCost_after,this.travelCost_after, this.conferenceCost_after, this.exchangeCost_after, 
				this.publishCost_after,this.serviceCost_after,
				this.consultCost_after,this.indirectCost_after,this.otherCost_after,this.suggestion);
	
		this.jsonResult = "";
		return "success";
	}
	
	
	//审批不通过
	public String A863AdjustAuditReject(){
		
		if(this.a863adjustPk == null){
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		this.actionStatus = a863adjustService.A863AdjustAuditReject(this.a863adjustPk,this.suggestion);
	
		this.jsonResult = "";
		return "success";
	}
	
	//setters&getters
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

	public Long getA863adjustPk() {
		return a863adjustPk;
	}

	public void setA863adjustPk(Long a863adjustPk) {
		this.a863adjustPk = a863adjustPk;
	}

	public A863adjustService getA863adjustService() {
		return a863adjustService;
	}

	public void setA863adjustService(A863adjustService a863adjustService) {
		this.a863adjustService = a863adjustService;
	}

	public Double getCostSum_adjust() {
		return costSum_adjust;
	}

	public void setCostSum_adjust(Double costSum_adjust) {
		this.costSum_adjust = costSum_adjust;
	}

	public Double getEquipmentCost_adjust() {
		return equipmentCost_adjust;
	}

	public void setEquipmentCost_adjust(Double equipmentCost_adjust) {
		this.equipmentCost_adjust = equipmentCost_adjust;
	}

	public Double getMaterialCost_adjust() {
		return materialCost_adjust;
	}

	public void setMaterialCost_adjust(Double materialCost_adjust) {
		this.materialCost_adjust = materialCost_adjust;
	}

	public Double getTestCost_adjust() {
		return testCost_adjust;
	}

	public void setTestCost_adjust(Double testCost_adjust) {
		this.testCost_adjust = testCost_adjust;
	}

	public Double getFuelCost_adjust() {
		return fuelCost_adjust;
	}

	public void setFuelCost_adjust(Double fuelCost_adjust) {
		this.fuelCost_adjust = fuelCost_adjust;
	}

	public Double getTravelCost_adjust() {
		return travelCost_adjust;
	}

	public void setTravelCost_adjust(Double travelCost_adjust) {
		this.travelCost_adjust = travelCost_adjust;
	}

	public Double getConferenceCost_adjust() {
		return conferenceCost_adjust;
	}

	public void setConferenceCost_adjust(Double conferenceCost_adjust) {
		this.conferenceCost_adjust = conferenceCost_adjust;
	}

	public Double getExchangeCost_adjust() {
		return exchangeCost_adjust;
	}

	public void setExchangeCost_adjust(Double exchangeCost_adjust) {
		this.exchangeCost_adjust = exchangeCost_adjust;
	}

	public Double getPublishCost_adjust() {
		return publishCost_adjust;
	}

	public void setPublishCost_adjust(Double publishCost_adjust) {
		this.publishCost_adjust = publishCost_adjust;
	}

	public Double getServiceCost_adjust() {
		return serviceCost_adjust;
	}

	public void setServiceCost_adjust(Double serviceCost_adjust) {
		this.serviceCost_adjust = serviceCost_adjust;
	}

	public Double getConsultCost_adjust() {
		return consultCost_adjust;
	}

	public void setConsultCost_adjust(Double consultCost_adjust) {
		this.consultCost_adjust = consultCost_adjust;
	}

	public Double getIndirectCost_adjust() {
		return indirectCost_adjust;
	}

	public void setIndirectCost_adjust(Double indirectCost_adjust) {
		this.indirectCost_adjust = indirectCost_adjust;
	}

	public Double getOtherCost_adjust() {
		return otherCost_adjust;
	}

	public void setOtherCost_adjust(Double otherCost_adjust) {
		this.otherCost_adjust = otherCost_adjust;
	}

	public String getNtime() {
		return ntime;
	}

	public void setNtime(String ntime) {
		this.ntime = ntime;
	}

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public Double getCostSum_after() {
		return costSum_after;
	}

	public void setCostSum_after(Double costSum_after) {
		this.costSum_after = costSum_after;
	}

	public Double getEquipmentCost_after() {
		return equipmentCost_after;
	}

	public void setEquipmentCost_after(Double equipmentCost_after) {
		this.equipmentCost_after = equipmentCost_after;
	}

	public Double getMaterialCost_after() {
		return materialCost_after;
	}

	public void setMaterialCost_after(Double materialCost_after) {
		this.materialCost_after = materialCost_after;
	}

	public Double getTestCost_after() {
		return testCost_after;
	}

	public void setTestCost_after(Double testCost_after) {
		this.testCost_after = testCost_after;
	}

	public Double getFuelCost_after() {
		return fuelCost_after;
	}

	public void setFuelCost_after(Double fuelCost_after) {
		this.fuelCost_after = fuelCost_after;
	}

	public Double getTravelCost_after() {
		return travelCost_after;
	}

	public void setTravelCost_after(Double travelCost_after) {
		this.travelCost_after = travelCost_after;
	}

	public Double getConferenceCost_after() {
		return conferenceCost_after;
	}

	public void setConferenceCost_after(Double conferenceCost_after) {
		this.conferenceCost_after = conferenceCost_after;
	}

	public Double getExchangeCost_after() {
		return exchangeCost_after;
	}

	public void setExchangeCost_after(Double exchangeCost_after) {
		this.exchangeCost_after = exchangeCost_after;
	}

	public Double getPublishCost_after() {
		return publishCost_after;
	}

	public void setPublishCost_after(Double publishCost_after) {
		this.publishCost_after = publishCost_after;
	}

	public Double getServiceCost_after() {
		return serviceCost_after;
	}

	public void setServiceCost_after(Double serviceCost_after) {
		this.serviceCost_after = serviceCost_after;
	}

	public Double getConsultCost_after() {
		return consultCost_after;
	}

	public void setConsultCost_after(Double consultCost_after) {
		this.consultCost_after = consultCost_after;
	}

	public Double getIndirectCost_after() {
		return indirectCost_after;
	}

	public void setIndirectCost_after(Double indirectCost_after) {
		this.indirectCost_after = indirectCost_after;
	}

	public Double getOtherCost_after() {
		return otherCost_after;
	}

	public void setOtherCost_after(Double otherCost_after) {
		this.otherCost_after = otherCost_after;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	
}




