package com.stoms.action;

import java.util.List;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.model.NationalFundBudget;
import com.stoms.model.NationalFundItem;
import com.stoms.service.ItemService;
import com.stoms.service.NationalFundBudgetService;
import com.stoms.utils.JSONTranslation;


public class NationalFundBudgetAction extends ActionSupport{
	
	
	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;
	
	private Long itemPK;
	private Long nationalFundAdjustPk;
	
	private String itemName;
	private String teacherName;	
	private String approveId;
	private Double dialFundsSum;
	private Double otherPlanFundsBuget;
	private Double otherSubsidizeBuget;
	private Double otherSumBuget;
	
	private Double studyFund;
	private Double sumBusiness;
	private Double testCost;
	private Double fuelCost;
	private Double conferenceCost;
	private Double publishCost;
	private Double otherBusiness;
	private Double sumMaterial;
	private Double rawMaterial;
	private Double otherMaterial;
	private Double sumEquipment;
	private Double buyEquipment;
	private Double trialEquipment;
	private Double laboratory;
	private Double cooperation;
	private Double exchangeSum;
	private Double exchange;
	private Double expert;
	private Double serviceCost;
	private Double manageCost;
	private Double sums;
	
	private Double studyFund_Adjust;
	private Double sumBusiness_Adjust;
	private Double testCost_Adjust;
	private Double fuelCost_Adjust;
	private Double conferenceCost_Adjust;
	private Double publishCost_Adjust;
	private Double otherBusiness_Adjust;
	private Double sumMaterial_Adjust;
	private Double rawMaterial_Adjust;
	private Double otherMaterial_Adjust;
	private Double sumEquipment_Adjust;
	private Double buyEquipment_Adjust;
	private Double trialEquipment_Adjust;
	private Double laboratory_Adjust;
	private Double cooperation_Adjust;
	private Double exchangeSum_Adjust;
	private Double exchange_Adjust;
	private Double expert_Adjust;
	private Double serviceCost_Adjust;
	private Double manageCost_Adjust;
	private Double sums_Adjust;
	private String ntime;
	
	private Double studyFund_BudgetSum;
	private Double sumBusiness_BudgetSum;
	private Double testCost_BudgetSum;
	private Double fuelCost_BudgetSum;
	private Double conferenceCost_BudgetSum;
	private Double publishCost_BudgetSum;
	private Double otherBusiness_BudgetSum;
	private Double sumMaterial_BudgetSum;
	private Double rawMaterial_BudgetSum;
	private Double otherMaterial_BudgetSum;
	private Double sumEquipment_BudgetSum;
	private Double buyEquipment_BudgetSum;
	private Double trialEquipment_BudgetSum;
	private Double laboratory_BudgetSum;
	private Double cooperation_BudgetSum;
	private Double exchangeSum_BudgetSum;
	private Double exchange_BudgetSum;
	private Double expert_BudgetSum;
	private Double serviceCost_BudgetSum;
	private Double manageCost_BudgetSum;
	private Double sums_BudgetSum;
	
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
	
	
	
	
	private NationalFundBudgetService nationalFundBudgetService;
	private ItemService itemService;
	
	
	//获得所有项目为itemPK的项目
	public String acquireNationalFundBudgetInfo(){
		
		this.jsonResult = nationalFundBudgetService.acquireNationalFundInfo(itemPK);
		if(this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}
				
		this.actionStatus = true;
		return "success";
	}
	

	//获得所有项目为itemPK的项目预算调整
	public String acquireNationalFundBudgetAdjust(){
		
		this.jsonResult = nationalFundBudgetService.acquireNationalFundBudgetAdjust(nationalFundAdjustPk,itemPK);
		if(this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}
				
		this.actionStatus = true;
		return "success";
	}
	
	
	//获得itemPK项目所有的预算调整
	public String acquireAllNationalFundAdjustList(){
		
		if(itemPK == null)  {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		String itemInfo = "{}";
		itemInfo = itemService.findItemByItemPK(itemPK);
		
		List allNationalFundAdjustList = nationalFundBudgetService.acquireAllNationalFundAdjustList(itemPK);

//		if (allNationalFundAdjustList == null
//				|| allNationalFundAdjustList.size() == 0) {
//			this.actionStatus = false;
//			this.jsonResult = "";
//			return "success";
//		}

		String[] excludes = {};

		String allNationalFundAdjustListinfo= JSONTranslation.arrayToJson(allNationalFundAdjustList,
				excludes);
		
		JSONObject jsonObject = new JSONObject();
	    jsonObject.element("itemInfo", itemInfo);
    	jsonObject.element("allNationalFundAdjustListinfo", allNationalFundAdjustListinfo);
		this.jsonResult = jsonObject.toString();

		if (this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = true;
		return "success";
		
	
	}
	

	//保存预算数据
	public String saveNationalFundBudgetInfo(){
		
		if(this.itemPK == null){
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		
		this.actionStatus = nationalFundBudgetService.saveNationalFundBudgetInfo(this.itemPK, this.itemName, this.teacherName,
				this.approveId, this.dialFundsSum, this.otherPlanFundsBuget, this.otherSubsidizeBuget, this.otherSumBuget, 
				this.studyFund,this.sumBusiness, this.testCost, this.fuelCost, this.conferenceCost,this.publishCost,
				this.otherBusiness,this.sumMaterial,this.rawMaterial,this.otherMaterial,this.sumEquipment,
				this.buyEquipment,this.trialEquipment,this.laboratory,this.cooperation,this.exchangeSum,this.exchange,
				this.expert,this.serviceCost,this.manageCost,this.sums,
				this.studyFund_Remark,this.sumBusiness_Remark, this.testCost_Remark, this.fuelCost_Remark, this.conferenceCost_Remark,this.publishCost_Remark,
				this.otherBusiness_Remark,this.sumMaterial_Remark,this.rawMaterial_Remark,this.otherMaterial_Remark,this.sumEquipment_Remark,
				this.buyEquipment_Remark,this.trialEquipment_Remark,this.laboratory_Remark,this.cooperation_Remark,this.exchangeSum_Remark,this.exchange_Remark,
				this.expert_Remark,this.serviceCost_Remark,this.manageCost_Remark,this.sums_Remark);
	
		this.jsonResult = "";
		return "success";
	}
	
	//提交预算数据
	public String submitNationalFundBudgetInfo(){
		if(this.itemPK == null){
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		
		this.actionStatus = nationalFundBudgetService.submitNationalFundBudgetInfo(this.itemPK, this.itemName, this.teacherName,
				this.approveId, this.dialFundsSum, this.otherPlanFundsBuget, this.otherSubsidizeBuget, this.otherSumBuget, 
				this.studyFund,this.sumBusiness, this.testCost, this.fuelCost, this.conferenceCost,this.publishCost,
				this.otherBusiness,this.sumMaterial,this.rawMaterial,this.otherMaterial,this.sumEquipment,
				this.buyEquipment,this.trialEquipment,this.laboratory,this.cooperation,this.exchangeSum,this.exchange,
				this.expert,this.serviceCost,this.manageCost,this.sums);
	
		this.jsonResult = "";
		return "success";
	}
	
	//保存预算调整
	public String saveNationalFundBudgetAdjustment(){
		
		if(this.itemPK == null){
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		this.actionStatus = nationalFundBudgetService.saveNationalFundBudgetAdjustment(this.nationalFundAdjustPk,this.itemPK, 
				this.dialFundsSum, this.otherPlanFundsBuget, this.otherSubsidizeBuget, this.otherSumBuget, 
				this.studyFund_Adjust,this.sumBusiness_Adjust, this.testCost_Adjust, this.fuelCost_Adjust, this.conferenceCost_Adjust,this.publishCost_Adjust,
				this.otherBusiness_Adjust,this.sumMaterial_Adjust,this.rawMaterial_Adjust,this.otherMaterial_Adjust,this.sumEquipment_Adjust,
				this.buyEquipment_Adjust,this.trialEquipment_Adjust,this.laboratory_Adjust,this.cooperation_Adjust,this.exchangeSum_Adjust,this.exchange_Adjust,
				this.expert_Adjust,this.serviceCost_Adjust,this.manageCost_Adjust,this.sums_Adjust,this.ntime);
	
		this.jsonResult = "";
		return "success";
	}
	
	
	//提交预算调整及调整总经费
	public String submitNationalFundBudgetAdjustment(){
		
		if(this.itemPK == null){
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		this.actionStatus = nationalFundBudgetService.submitNationalFundBudgetAdjustment(this.nationalFundAdjustPk,this.itemPK, 
				this.dialFundsSum, this.otherPlanFundsBuget, this.otherSubsidizeBuget, this.otherSumBuget, 
				this.studyFund_Adjust,this.sumBusiness_Adjust, this.testCost_Adjust, this.fuelCost_Adjust, this.conferenceCost_Adjust,this.publishCost_Adjust,
				this.otherBusiness_Adjust,this.sumMaterial_Adjust,this.rawMaterial_Adjust,this.otherMaterial_Adjust,this.sumEquipment_Adjust,
				this.buyEquipment_Adjust,this.trialEquipment_Adjust,this.laboratory_Adjust,this.cooperation_Adjust,this.exchangeSum_Adjust,this.exchange_Adjust,
				this.expert_Adjust,this.serviceCost_Adjust,this.manageCost_Adjust,this.sums_Adjust,this.ntime,
				this.studyFund_BudgetSum,this.sumBusiness_BudgetSum, this.testCost_BudgetSum, this.fuelCost_BudgetSum, this.conferenceCost_BudgetSum,this.publishCost_BudgetSum,
				this.otherBusiness_BudgetSum,this.sumMaterial_BudgetSum,this.rawMaterial_BudgetSum,this.otherMaterial_BudgetSum,this.sumEquipment_BudgetSum,
				this.buyEquipment_BudgetSum,this.trialEquipment_BudgetSum,this.laboratory_BudgetSum,this.cooperation_BudgetSum,this.exchangeSum_BudgetSum,this.exchange_BudgetSum,
				this.expert_BudgetSum,this.serviceCost_BudgetSum,this.manageCost_BudgetSum,this.sums_BudgetSum);
	
		this.jsonResult = "";
		return "success";
	}
	
	
	
//setters&gettersS
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


	public Long getNationalFundAdjustPk() {
		return nationalFundAdjustPk;
	}


	public void setNationalFundAdjustPk(Long nationalFundAdjustPk) {
		this.nationalFundAdjustPk = nationalFundAdjustPk;
	}


	public NationalFundBudgetService getNationalFundBudgetService() {
		return nationalFundBudgetService;
	}

	public void setNationalFundBudgetService(
			NationalFundBudgetService nationalFundBudgetService) {
		this.nationalFundBudgetService = nationalFundBudgetService;
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


	public String getApproveId() {
		return approveId;
	}


	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}


	public Double getDialFundsSum() {
		return dialFundsSum;
	}


	public void setDialFundsSum(Double dialFundsSum) {
		this.dialFundsSum = dialFundsSum;
	}


	public Double getOtherPlanFundsBuget() {
		return otherPlanFundsBuget;
	}


	public void setOtherPlanFundsBuget(Double otherPlanFundsBuget) {
		this.otherPlanFundsBuget = otherPlanFundsBuget;
	}


	public Double getOtherSubsidizeBuget() {
		return otherSubsidizeBuget;
	}


	public void setOtherSubsidizeBuget(Double otherSubsidizeBuget) {
		this.otherSubsidizeBuget = otherSubsidizeBuget;
	}


	public Double getOtherSumBuget() {
		return otherSumBuget;
	}


	public void setOtherSumBuget(Double otherSumBuget) {
		this.otherSumBuget = otherSumBuget;
	}


	public Double getStudyFund() {
		return studyFund;
	}


	public void setStudyFund(Double studyFund) {
		this.studyFund = studyFund;
	}


	public Double getSumBusiness() {
		return sumBusiness;
	}


	public void setSumBusiness(Double sumBusiness) {
		this.sumBusiness = sumBusiness;
	}


	public Double getTestCost() {
		return testCost;
	}


	public void setTestCost(Double testCost) {
		this.testCost = testCost;
	}


	public Double getFuelCost() {
		return fuelCost;
	}


	public void setFuelCost(Double fuelCost) {
		this.fuelCost = fuelCost;
	}


	public Double getConferenceCost() {
		return conferenceCost;
	}


	public void setConferenceCost(Double conferenceCost) {
		this.conferenceCost = conferenceCost;
	}


	public Double getPublishCost() {
		return publishCost;
	}


	public void setPublishCost(Double publishCost) {
		this.publishCost = publishCost;
	}


	public Double getOtherBusiness() {
		return otherBusiness;
	}


	public void setOtherBusiness(Double otherBusiness) {
		this.otherBusiness = otherBusiness;
	}


	public Double getSumMaterial() {
		return sumMaterial;
	}


	public void setSumMaterial(Double sumMaterial) {
		this.sumMaterial = sumMaterial;
	}


	public Double getRawMaterial() {
		return rawMaterial;
	}


	public void setRawMaterial(Double rawMaterial) {
		this.rawMaterial = rawMaterial;
	}


	public Double getOtherMaterial() {
		return otherMaterial;
	}


	public void setOtherMaterial(Double otherMaterial) {
		this.otherMaterial = otherMaterial;
	}


	public Double getSumEquipment() {
		return sumEquipment;
	}


	public void setSumEquipment(Double sumEquipment) {
		this.sumEquipment = sumEquipment;
	}


	public Double getBuyEquipment() {
		return buyEquipment;
	}


	public void setBuyEquipment(Double buyEquipment) {
		this.buyEquipment = buyEquipment;
	}


	public Double getTrialEquipment() {
		return trialEquipment;
	}


	public void setTrialEquipment(Double trialEquipment) {
		this.trialEquipment = trialEquipment;
	}


	public Double getLaboratory() {
		return laboratory;
	}


	public void setLaboratory(Double laboratory) {
		this.laboratory = laboratory;
	}


	public Double getCooperation() {
		return cooperation;
	}


	public void setCooperation(Double cooperation) {
		this.cooperation = cooperation;
	}


	public Double getExchangeSum() {
		return exchangeSum;
	}


	public void setExchangeSum(Double exchangeSum) {
		this.exchangeSum = exchangeSum;
	}


	public Double getExchange() {
		return exchange;
	}


	public void setExchange(Double exchange) {
		this.exchange = exchange;
	}


	public Double getExpert() {
		return expert;
	}


	public void setExpert(Double expert) {
		this.expert = expert;
	}


	public Double getServiceCost() {
		return serviceCost;
	}


	public void setServiceCost(Double serviceCost) {
		this.serviceCost = serviceCost;
	}


	public Double getManageCost() {
		return manageCost;
	}


	public void setManageCost(Double manageCost) {
		this.manageCost = manageCost;
	}


	public Double getSums() {
		return sums;
	}


	public void setSums(Double sums) {
		this.sums = sums;
	}

	public Double getStudyFund_Adjust() {
		return studyFund_Adjust;
	}

	public void setStudyFund_Adjust(Double studyFund_Adjust) {
		this.studyFund_Adjust = studyFund_Adjust;
	}

	public Double getSumBusiness_Adjust() {
		return sumBusiness_Adjust;
	}

	public void setSumBusiness_Adjust(Double sumBusiness_Adjust) {
		this.sumBusiness_Adjust = sumBusiness_Adjust;
	}

	public Double getTestCost_Adjust() {
		return testCost_Adjust;
	}

	public void setTestCost_Adjust(Double testCost_Adjust) {
		this.testCost_Adjust = testCost_Adjust;
	}

	public Double getFuelCost_Adjust() {
		return fuelCost_Adjust;
	}

	public void setFuelCost_Adjust(Double fuelCost_Adjust) {
		this.fuelCost_Adjust = fuelCost_Adjust;
	}

	public Double getConferenceCost_Adjust() {
		return conferenceCost_Adjust;
	}

	public void setConferenceCost_Adjust(Double conferenceCost_Adjust) {
		this.conferenceCost_Adjust = conferenceCost_Adjust;
	}

	public Double getPublishCost_Adjust() {
		return publishCost_Adjust;
	}

	public void setPublishCost_Adjust(Double publishCost_Adjust) {
		this.publishCost_Adjust = publishCost_Adjust;
	}

	public Double getOtherBusiness_Adjust() {
		return otherBusiness_Adjust;
	}

	public void setOtherBusiness_Adjust(Double otherBusiness_Adjust) {
		this.otherBusiness_Adjust = otherBusiness_Adjust;
	}

	public Double getSumMaterial_Adjust() {
		return sumMaterial_Adjust;
	}

	public void setSumMaterial_Adjust(Double sumMaterial_Adjust) {
		this.sumMaterial_Adjust = sumMaterial_Adjust;
	}

	public Double getRawMaterial_Adjust() {
		return rawMaterial_Adjust;
	}

	public void setRawMaterial_Adjust(Double rawMaterial_Adjust) {
		this.rawMaterial_Adjust = rawMaterial_Adjust;
	}

	public Double getOtherMaterial_Adjust() {
		return otherMaterial_Adjust;
	}

	public void setOtherMaterial_Adjust(Double otherMaterial_Adjust) {
		this.otherMaterial_Adjust = otherMaterial_Adjust;
	}

	public Double getSumEquipment_Adjust() {
		return sumEquipment_Adjust;
	}

	public void setSumEquipment_Adjust(Double sumEquipment_Adjust) {
		this.sumEquipment_Adjust = sumEquipment_Adjust;
	}

	public Double getBuyEquipment_Adjust() {
		return buyEquipment_Adjust;
	}

	public void setBuyEquipment_Adjust(Double buyEquipment_Adjust) {
		this.buyEquipment_Adjust = buyEquipment_Adjust;
	}

	public Double getTrialEquipment_Adjust() {
		return trialEquipment_Adjust;
	}

	public void setTrialEquipment_Adjust(Double trialEquipment_Adjust) {
		this.trialEquipment_Adjust = trialEquipment_Adjust;
	}

	public Double getLaboratory_Adjust() {
		return laboratory_Adjust;
	}

	public void setLaboratory_Adjust(Double laboratory_Adjust) {
		this.laboratory_Adjust = laboratory_Adjust;
	}

	public Double getCooperation_Adjust() {
		return cooperation_Adjust;
	}

	public void setCooperation_Adjust(Double cooperation_Adjust) {
		this.cooperation_Adjust = cooperation_Adjust;
	}

	public Double getExchangeSum_Adjust() {
		return exchangeSum_Adjust;
	}

	public void setExchangeSum_Adjust(Double exchangeSum_Adjust) {
		this.exchangeSum_Adjust = exchangeSum_Adjust;
	}

	public Double getExchange_Adjust() {
		return exchange_Adjust;
	}

	public void setExchange_Adjust(Double exchange_Adjust) {
		this.exchange_Adjust = exchange_Adjust;
	}

	public Double getExpert_Adjust() {
		return expert_Adjust;
	}

	public void setExpert_Adjust(Double expert_Adjust) {
		this.expert_Adjust = expert_Adjust;
	}

	public Double getServiceCost_Adjust() {
		return serviceCost_Adjust;
	}

	public void setServiceCost_Adjust(Double serviceCost_Adjust) {
		this.serviceCost_Adjust = serviceCost_Adjust;
	}

	public Double getManageCost_Adjust() {
		return manageCost_Adjust;
	}

	public void setManageCost_Adjust(Double manageCost_Adjust) {
		this.manageCost_Adjust = manageCost_Adjust;
	}

	public Double getSums_Adjust() {
		return sums_Adjust;
	}

	public void setSums_Adjust(Double sums_Adjust) {
		this.sums_Adjust = sums_Adjust;
	}

	public Double getStudyFund_BudgetSum() {
		return studyFund_BudgetSum;
	}

	public void setStudyFund_BudgetSum(Double studyFund_BudgetSum) {
		this.studyFund_BudgetSum = studyFund_BudgetSum;
	}

	public Double getSumBusiness_BudgetSum() {
		return sumBusiness_BudgetSum;
	}

	public void setSumBusiness_BudgetSum(Double sumBusiness_BudgetSum) {
		this.sumBusiness_BudgetSum = sumBusiness_BudgetSum;
	}

	public Double getTestCost_BudgetSum() {
		return testCost_BudgetSum;
	}

	public void setTestCost_BudgetSum(Double testCost_BudgetSum) {
		this.testCost_BudgetSum = testCost_BudgetSum;
	}

	public Double getFuelCost_BudgetSum() {
		return fuelCost_BudgetSum;
	}

	public void setFuelCost_BudgetSum(Double fuelCost_BudgetSum) {
		this.fuelCost_BudgetSum = fuelCost_BudgetSum;
	}

	public Double getConferenceCost_BudgetSum() {
		return conferenceCost_BudgetSum;
	}

	public void setConferenceCost_BudgetSum(Double conferenceCost_BudgetSum) {
		this.conferenceCost_BudgetSum = conferenceCost_BudgetSum;
	}

	public Double getPublishCost_BudgetSum() {
		return publishCost_BudgetSum;
	}

	public void setPublishCost_BudgetSum(Double publishCost_BudgetSum) {
		this.publishCost_BudgetSum = publishCost_BudgetSum;
	}

	public Double getOtherBusiness_BudgetSum() {
		return otherBusiness_BudgetSum;
	}

	public void setOtherBusiness_BudgetSum(Double otherBusiness_BudgetSum) {
		this.otherBusiness_BudgetSum = otherBusiness_BudgetSum;
	}

	public Double getSumMaterial_BudgetSum() {
		return sumMaterial_BudgetSum;
	}

	public void setSumMaterial_BudgetSum(Double sumMaterial_BudgetSum) {
		this.sumMaterial_BudgetSum = sumMaterial_BudgetSum;
	}

	public Double getRawMaterial_BudgetSum() {
		return rawMaterial_BudgetSum;
	}

	public void setRawMaterial_BudgetSum(Double rawMaterial_BudgetSum) {
		this.rawMaterial_BudgetSum = rawMaterial_BudgetSum;
	}

	public Double getOtherMaterial_BudgetSum() {
		return otherMaterial_BudgetSum;
	}

	public void setOtherMaterial_BudgetSum(Double otherMaterial_BudgetSum) {
		this.otherMaterial_BudgetSum = otherMaterial_BudgetSum;
	}

	public Double getSumEquipment_BudgetSum() {
		return sumEquipment_BudgetSum;
	}

	public void setSumEquipment_BudgetSum(Double sumEquipment_BudgetSum) {
		this.sumEquipment_BudgetSum = sumEquipment_BudgetSum;
	}

	public Double getBuyEquipment_BudgetSum() {
		return buyEquipment_BudgetSum;
	}

	public void setBuyEquipment_BudgetSum(Double buyEquipment_BudgetSum) {
		this.buyEquipment_BudgetSum = buyEquipment_BudgetSum;
	}

	public Double getTrialEquipment_BudgetSum() {
		return trialEquipment_BudgetSum;
	}

	public void setTrialEquipment_BudgetSum(Double trialEquipment_BudgetSum) {
		this.trialEquipment_BudgetSum = trialEquipment_BudgetSum;
	}

	public Double getLaboratory_BudgetSum() {
		return laboratory_BudgetSum;
	}

	public void setLaboratory_BudgetSum(Double laboratory_BudgetSum) {
		this.laboratory_BudgetSum = laboratory_BudgetSum;
	}

	public Double getCooperation_BudgetSum() {
		return cooperation_BudgetSum;
	}

	public void setCooperation_BudgetSum(Double cooperation_BudgetSum) {
		this.cooperation_BudgetSum = cooperation_BudgetSum;
	}

	public Double getExchangeSum_BudgetSum() {
		return exchangeSum_BudgetSum;
	}

	public void setExchangeSum_BudgetSum(Double exchangeSum_BudgetSum) {
		this.exchangeSum_BudgetSum = exchangeSum_BudgetSum;
	}

	public Double getExchange_BudgetSum() {
		return exchange_BudgetSum;
	}

	public void setExchange_BudgetSum(Double exchange_BudgetSum) {
		this.exchange_BudgetSum = exchange_BudgetSum;
	}

	public Double getExpert_BudgetSum() {
		return expert_BudgetSum;
	}

	public void setExpert_BudgetSum(Double expert_BudgetSum) {
		this.expert_BudgetSum = expert_BudgetSum;
	}

	public Double getServiceCost_BudgetSum() {
		return serviceCost_BudgetSum;
	}

	public void setServiceCost_BudgetSum(Double serviceCost_BudgetSum) {
		this.serviceCost_BudgetSum = serviceCost_BudgetSum;
	}

	public Double getManageCost_BudgetSum() {
		return manageCost_BudgetSum;
	}

	public void setManageCost_BudgetSum(Double manageCost_BudgetSum) {
		this.manageCost_BudgetSum = manageCost_BudgetSum;
	}

	public Double getSums_BudgetSum() {
		return sums_BudgetSum;
	}

	public void setSums_BudgetSum(Double sums_BudgetSum) {
		this.sums_BudgetSum = sums_BudgetSum;
	}


	public ItemService getItemService() {
		return itemService;
	}


	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}


	public String getNtime() {
		return ntime;
	}


	public void setNtime(String ntime) {
		this.ntime = ntime;
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
	
	

}
