package com.stoms.action;

import java.util.List;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.model.NationalFundBudget;
import com.stoms.model.NationalFundItem;
import com.stoms.service.BudgetAdjustService;
import com.stoms.utils.JSONTranslation;

public class NationalBudgetAdjustmentAuditAction extends ActionSupport{
	
	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;
	
	private Long itemPK;
	private Long nationalFundAdjustPk;
	
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
	
	private String suggestion;
	
	private BudgetAdjustService budgetAdjustService;
	
	
	//获得所有已提交的待审批的预算调整列表
	public String acquireAllUnAuditedBudgetAdjustment(){
		
		List budgetAdjustList = budgetAdjustService.acquireAllUnAuditedBudgetAdjustment();
		
		if (budgetAdjustList == null || budgetAdjustList.size() == 0) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		String[] excludes = {"projectType","teacher","department"};

		this.jsonResult = JSONTranslation.arrayToJson(budgetAdjustList,excludes);

		if (this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = true;
		return "success";
		
	}
	
	//获取具体的要审批的预算调整信息
	public String acquireBudgetAdjustmentDetail(){
		
		this.jsonResult = budgetAdjustService.acquireBudgetAdjustmentDetail(nationalFundAdjustPk,itemPK);
		if(this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}
				
		this.actionStatus = true;
		return "success";
	}


	//审批通过，保存预算总经费到预算表里
	public String budgetAdjustmentAuditPass(){
		
		if(this.itemPK == null){
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		this.actionStatus = budgetAdjustService.budgetAdjustmentAuditPass(this.nationalFundAdjustPk,this.itemPK, 
				this.studyFund_BudgetSum,this.sumBusiness_BudgetSum, this.testCost_BudgetSum, this.fuelCost_BudgetSum, this.conferenceCost_BudgetSum,this.publishCost_BudgetSum,
				this.otherBusiness_BudgetSum,this.sumMaterial_BudgetSum,this.rawMaterial_BudgetSum,this.otherMaterial_BudgetSum,this.sumEquipment_BudgetSum,
				this.buyEquipment_BudgetSum,this.trialEquipment_BudgetSum,this.laboratory_BudgetSum,this.cooperation_BudgetSum,this.exchangeSum_BudgetSum,this.exchange_BudgetSum,
				this.expert_BudgetSum,this.serviceCost_BudgetSum,this.manageCost_BudgetSum,this.sums_BudgetSum,this.suggestion);
	
		this.jsonResult = "";
		return "success";
	}
	
	

	//审批不通过
	public String budgetAdjustmentAuditReject(){
		
		if(this.nationalFundAdjustPk == null){
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		this.actionStatus = budgetAdjustService.budgetAdjustmentAuditReject(this.nationalFundAdjustPk,this.suggestion);
	
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


	public Long getNationalFundAdjustPk() {
		return nationalFundAdjustPk;
	}


	public void setNationalFundAdjustPk(Long nationalFundAdjustPk) {
		this.nationalFundAdjustPk = nationalFundAdjustPk;
	}


	public BudgetAdjustService getBudgetAdjustService() {
		return budgetAdjustService;
	}


	public void setBudgetAdjustService(BudgetAdjustService budgetAdjustService) {
		this.budgetAdjustService = budgetAdjustService;
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

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

}
