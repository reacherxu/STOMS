package com.stoms.action;

import java.util.List;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.service.ItemService;
import com.stoms.service.NationalFundOutlayService;
import com.stoms.utils.JSONTranslation;

public class NationalFundOutlayAction extends ActionSupport{
	
	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;
	
	private Long itemPK;
	private Long nationalFundOutlayPk;
	private Long nationalFundRemarkPk;
	
	private Double dialFundsLast;
	private Double otherPlanFundsOutlay;
	private Double otherSubsidizeOutlay;
	private Double otherSumOutlay;
	
	private Double studyFund_Outlay;
	private Double sumBusiness_Outlay;
	private Double testCost_Outlay;
	private Double fuelCost_Outlay;
	private Double conferenceCost_Outlay;
	private Double publishCost_Outlay;
	private Double otherBusiness_Outlay;
	private Double sumMaterial_Outlay;
	private Double rawMaterial_Outlay;
	private Double otherMaterial_Outlay;
	private Double sumEquipment_Outlay;
	private Double buyEquipment_Outlay;
	private Double trialEquipment_Outlay;
	private Double laboratory_Outlay;
	private Double cooperation_Outlay;
	private Double exchangeSum_Outlay;
	private Double exchange_Outlay;
	private Double expert_Outlay;
	private Double serviceCost_Outlay;
	private Double manageCost_Outlay;
	private Double sums_Outlay;
	
	private String studyFund_Remark;
	private String sumBusiness_Remark;
	private String testCost_Remark;
	private String fuelCost_Remark;
	private String conferenceCost_Remark;
	private String publishCost_Remark;
	private String otherBusiness_Remark;
	private String sumMaterial_Remark;
	private String rawMaterial_Remark;
	private String otherMaterial_Remark;
	private String sumEquipment_Remark;
	private String buyEquipment_Remark;
	private String trialEquipment_Remark;
	private String laboratory_Remark;
	private String cooperation_Remark;
	private String exchangeSum_Remark;
	private String exchange_Remark;
	private String expert_Remark;
	private String serviceCost_Remark;
	private String manageCost_Remark;
	private String sums_Remark;
	
	
	private NationalFundOutlayService nationalFundOutlayService;
	private ItemService itemService;
	
	//获得itemPK项目的具体支出登记
	public String acquireNationalFundOutlay(){
		
		this.jsonResult = nationalFundOutlayService.acquireNationalFundOutlay(nationalFundOutlayPk,itemPK);
		if(this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}
				
		this.actionStatus = true;
		return "success";
	}
	
	public String acquireAllNationalFundOutlayList(){
		
		if(itemPK == null)  {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		String itemInfo = "{}";
		itemInfo = itemService.findItemByItemPK(itemPK);

		List allNationalFundOutlayList = nationalFundOutlayService.acquireAllNationalFundOutlayList(itemPK);

//		if (allNationalFundOutlayList == null
//				|| allNationalFundOutlayList.size() == 0) {
//			this.actionStatus = false;
//			this.jsonResult = "";
//			return "success";
//		}

		String[] excludes = {};
		
		String allNationalFundOutlayListinfo = JSONTranslation.arrayToJson(allNationalFundOutlayList,
				excludes);
		
		JSONObject jsonObject = new JSONObject();
	    jsonObject.element("itemInfo", itemInfo);
    	jsonObject.element("allNationalFundOutlayListinfo", allNationalFundOutlayListinfo);
		this.jsonResult = jsonObject.toString();

		if (this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = true;
		return "success";
		
	}

	
	
	//保存支出
	public String saveNationalFundOutlay(){
		
		if(this.itemPK == null){
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		this.actionStatus = nationalFundOutlayService.saveNationalFundOutlay(this.nationalFundOutlayPk,this.nationalFundRemarkPk,this.itemPK, 
				this.dialFundsLast, this.otherPlanFundsOutlay, this.otherSubsidizeOutlay, this.otherSumOutlay, 
				this.studyFund_Outlay,this.sumBusiness_Outlay, this.testCost_Outlay, this.fuelCost_Outlay, this.conferenceCost_Outlay,this.publishCost_Outlay,
				this.otherBusiness_Outlay,this.sumMaterial_Outlay,this.rawMaterial_Outlay,this.otherMaterial_Outlay,this.sumEquipment_Outlay,
				this.buyEquipment_Outlay,this.trialEquipment_Outlay,this.laboratory_Outlay,this.cooperation_Outlay,this.exchangeSum_Outlay,this.exchange_Outlay,
				this.expert_Outlay,this.serviceCost_Outlay,this.manageCost_Outlay,this.sums_Outlay,
				this.studyFund_Remark,this.sumBusiness_Remark, this.testCost_Remark, this.fuelCost_Remark, this.conferenceCost_Remark,this.publishCost_Remark,
				this.otherBusiness_Remark,this.sumMaterial_Remark,this.rawMaterial_Remark,this.otherMaterial_Remark,this.sumEquipment_Remark,
				this.buyEquipment_Remark,this.trialEquipment_Remark,this.laboratory_Remark,this.cooperation_Remark,this.exchangeSum_Remark,this.exchange_Remark,
				this.expert_Remark,this.serviceCost_Remark,this.manageCost_Remark,this.sums_Remark);
	
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

	public Long getNationalFundOutlayPk() {
		return nationalFundOutlayPk;
	}

	public void setNationalFundOutlayPk(Long nationalFundOutlayPk) {
		this.nationalFundOutlayPk = nationalFundOutlayPk;
	}

	public NationalFundOutlayService getNationalFundOutlayService() {
		return nationalFundOutlayService;
	}

	public void setNationalFundOutlayService(
			NationalFundOutlayService nationalFundOutlayService) {
		this.nationalFundOutlayService = nationalFundOutlayService;
	}

	public Double getDialFundsLast() {
		return dialFundsLast;
	}

	public void setDialFundsLast(Double dialFundsLast) {
		this.dialFundsLast = dialFundsLast;
	}

	public Double getOtherPlanFundsOutlay() {
		return otherPlanFundsOutlay;
	}

	public void setOtherPlanFundsOutlay(Double otherPlanFundsOutlay) {
		this.otherPlanFundsOutlay = otherPlanFundsOutlay;
	}

	public Double getOtherSubsidizeOutlay() {
		return otherSubsidizeOutlay;
	}

	public void setOtherSubsidizeOutlay(Double otherSubsidizeOutlay) {
		this.otherSubsidizeOutlay = otherSubsidizeOutlay;
	}

	public Double getOtherSumOutlay() {
		return otherSumOutlay;
	}

	public void setOtherSumOutlay(Double otherSumOutlay) {
		this.otherSumOutlay = otherSumOutlay;
	}

	public Double getStudyFund_Outlay() {
		return studyFund_Outlay;
	}

	public void setStudyFund_Outlay(Double studyFund_Outlay) {
		this.studyFund_Outlay = studyFund_Outlay;
	}

	public Double getSumBusiness_Outlay() {
		return sumBusiness_Outlay;
	}

	public void setSumBusiness_Outlay(Double sumBusiness_Outlay) {
		this.sumBusiness_Outlay = sumBusiness_Outlay;
	}

	public Double getTestCost_Outlay() {
		return testCost_Outlay;
	}

	public void setTestCost_Outlay(Double testCost_Outlay) {
		this.testCost_Outlay = testCost_Outlay;
	}

	public Double getFuelCost_Outlay() {
		return fuelCost_Outlay;
	}

	public void setFuelCost_Outlay(Double fuelCost_Outlay) {
		this.fuelCost_Outlay = fuelCost_Outlay;
	}

	public Double getConferenceCost_Outlay() {
		return conferenceCost_Outlay;
	}

	public void setConferenceCost_Outlay(Double conferenceCost_Outlay) {
		this.conferenceCost_Outlay = conferenceCost_Outlay;
	}

	public Double getPublishCost_Outlay() {
		return publishCost_Outlay;
	}

	public void setPublishCost_Outlay(Double publishCost_Outlay) {
		this.publishCost_Outlay = publishCost_Outlay;
	}

	public Double getOtherBusiness_Outlay() {
		return otherBusiness_Outlay;
	}

	public void setOtherBusiness_Outlay(Double otherBusiness_Outlay) {
		this.otherBusiness_Outlay = otherBusiness_Outlay;
	}

	public Double getSumMaterial_Outlay() {
		return sumMaterial_Outlay;
	}

	public void setSumMaterial_Outlay(Double sumMaterial_Outlay) {
		this.sumMaterial_Outlay = sumMaterial_Outlay;
	}

	public Double getRawMaterial_Outlay() {
		return rawMaterial_Outlay;
	}

	public void setRawMaterial_Outlay(Double rawMaterial_Outlay) {
		this.rawMaterial_Outlay = rawMaterial_Outlay;
	}

	public Double getOtherMaterial_Outlay() {
		return otherMaterial_Outlay;
	}

	public void setOtherMaterial_Outlay(Double otherMaterial_Outlay) {
		this.otherMaterial_Outlay = otherMaterial_Outlay;
	}

	public Double getSumEquipment_Outlay() {
		return sumEquipment_Outlay;
	}

	public void setSumEquipment_Outlay(Double sumEquipment_Outlay) {
		this.sumEquipment_Outlay = sumEquipment_Outlay;
	}

	public Double getBuyEquipment_Outlay() {
		return buyEquipment_Outlay;
	}

	public void setBuyEquipment_Outlay(Double buyEquipment_Outlay) {
		this.buyEquipment_Outlay = buyEquipment_Outlay;
	}

	public Double getTrialEquipment_Outlay() {
		return trialEquipment_Outlay;
	}

	public void setTrialEquipment_Outlay(Double trialEquipment_Outlay) {
		this.trialEquipment_Outlay = trialEquipment_Outlay;
	}

	public Double getLaboratory_Outlay() {
		return laboratory_Outlay;
	}

	public void setLaboratory_Outlay(Double laboratory_Outlay) {
		this.laboratory_Outlay = laboratory_Outlay;
	}

	public Double getCooperation_Outlay() {
		return cooperation_Outlay;
	}

	public void setCooperation_Outlay(Double cooperation_Outlay) {
		this.cooperation_Outlay = cooperation_Outlay;
	}

	public Double getExchangeSum_Outlay() {
		return exchangeSum_Outlay;
	}

	public void setExchangeSum_Outlay(Double exchangeSum_Outlay) {
		this.exchangeSum_Outlay = exchangeSum_Outlay;
	}

	public Double getExchange_Outlay() {
		return exchange_Outlay;
	}

	public void setExchange_Outlay(Double exchange_Outlay) {
		this.exchange_Outlay = exchange_Outlay;
	}

	public Double getExpert_Outlay() {
		return expert_Outlay;
	}

	public void setExpert_Outlay(Double expert_Outlay) {
		this.expert_Outlay = expert_Outlay;
	}

	public Double getServiceCost_Outlay() {
		return serviceCost_Outlay;
	}

	public void setServiceCost_Outlay(Double serviceCost_Outlay) {
		this.serviceCost_Outlay = serviceCost_Outlay;
	}

	public Double getManageCost_Outlay() {
		return manageCost_Outlay;
	}

	public void setManageCost_Outlay(Double manageCost_Outlay) {
		this.manageCost_Outlay = manageCost_Outlay;
	}

	public Double getSums_Outlay() {
		return sums_Outlay;
	}

	public void setSums_Outlay(Double sums_Outlay) {
		this.sums_Outlay = sums_Outlay;
	}

	public Long getNationalFundRemarkPk() {
		return nationalFundRemarkPk;
	}

	public void setNationalFundRemarkPk(Long nationalFundRemarkPk) {
		this.nationalFundRemarkPk = nationalFundRemarkPk;
	}

	public String getStudyFund_Remark() {
		return studyFund_Remark;
	}

	public void setStudyFund_Remark(String studyFund_Remark) {
		this.studyFund_Remark = studyFund_Remark;
	}

	public String getSumBusiness_Remark() {
		return sumBusiness_Remark;
	}

	public void setSumBusiness_Remark(String sumBusiness_Remark) {
		this.sumBusiness_Remark = sumBusiness_Remark;
	}

	public String getTestCost_Remark() {
		return testCost_Remark;
	}

	public void setTestCost_Remark(String testCost_Remark) {
		this.testCost_Remark = testCost_Remark;
	}

	public String getFuelCost_Remark() {
		return fuelCost_Remark;
	}

	public void setFuelCost_Remark(String fuelCost_Remark) {
		this.fuelCost_Remark = fuelCost_Remark;
	}

	public String getConferenceCost_Remark() {
		return conferenceCost_Remark;
	}

	public void setConferenceCost_Remark(String conferenceCost_Remark) {
		this.conferenceCost_Remark = conferenceCost_Remark;
	}

	public String getPublishCost_Remark() {
		return publishCost_Remark;
	}

	public void setPublishCost_Remark(String publishCost_Remark) {
		this.publishCost_Remark = publishCost_Remark;
	}

	public String getOtherBusiness_Remark() {
		return otherBusiness_Remark;
	}

	public void setOtherBusiness_Remark(String otherBusiness_Remark) {
		this.otherBusiness_Remark = otherBusiness_Remark;
	}

	public String getSumMaterial_Remark() {
		return sumMaterial_Remark;
	}

	public void setSumMaterial_Remark(String sumMaterial_Remark) {
		this.sumMaterial_Remark = sumMaterial_Remark;
	}

	public String getRawMaterial_Remark() {
		return rawMaterial_Remark;
	}

	public void setRawMaterial_Remark(String rawMaterial_Remark) {
		this.rawMaterial_Remark = rawMaterial_Remark;
	}

	public String getOtherMaterial_Remark() {
		return otherMaterial_Remark;
	}

	public void setOtherMaterial_Remark(String otherMaterial_Remark) {
		this.otherMaterial_Remark = otherMaterial_Remark;
	}

	public String getSumEquipment_Remark() {
		return sumEquipment_Remark;
	}

	public void setSumEquipment_Remark(String sumEquipment_Remark) {
		this.sumEquipment_Remark = sumEquipment_Remark;
	}

	public String getBuyEquipment_Remark() {
		return buyEquipment_Remark;
	}

	public void setBuyEquipment_Remark(String buyEquipment_Remark) {
		this.buyEquipment_Remark = buyEquipment_Remark;
	}

	public String getTrialEquipment_Remark() {
		return trialEquipment_Remark;
	}

	public void setTrialEquipment_Remark(String trialEquipment_Remark) {
		this.trialEquipment_Remark = trialEquipment_Remark;
	}

	public String getLaboratory_Remark() {
		return laboratory_Remark;
	}

	public void setLaboratory_Remark(String laboratory_Remark) {
		this.laboratory_Remark = laboratory_Remark;
	}

	public String getCooperation_Remark() {
		return cooperation_Remark;
	}

	public void setCooperation_Remark(String cooperation_Remark) {
		this.cooperation_Remark = cooperation_Remark;
	}

	public String getExchangeSum_Remark() {
		return exchangeSum_Remark;
	}

	public void setExchangeSum_Remark(String exchangeSum_Remark) {
		this.exchangeSum_Remark = exchangeSum_Remark;
	}

	public String getExchange_Remark() {
		return exchange_Remark;
	}

	public void setExchange_Remark(String exchange_Remark) {
		this.exchange_Remark = exchange_Remark;
	}

	public String getExpert_Remark() {
		return expert_Remark;
	}

	public void setExpert_Remark(String expert_Remark) {
		this.expert_Remark = expert_Remark;
	}

	public String getServiceCost_Remark() {
		return serviceCost_Remark;
	}

	public void setServiceCost_Remark(String serviceCost_Remark) {
		this.serviceCost_Remark = serviceCost_Remark;
	}

	public String getManageCost_Remark() {
		return manageCost_Remark;
	}

	public void setManageCost_Remark(String manageCost_Remark) {
		this.manageCost_Remark = manageCost_Remark;
	}

	public String getSums_Remark() {
		return sums_Remark;
	}

	public void setSums_Remark(String sums_Remark) {
		this.sums_Remark = sums_Remark;
	}

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	

	
	
}
