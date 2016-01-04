package com.stoms.model;

/**
 * A863approvalBudget entity. @author MyEclipse Persistence Tools
 */

public class A863approvalBudget implements java.io.Serializable {

	// Fields

	private Long a863approvalPk;
	private Long itemPk;
	private String itemId;
	private String timeLower;
	private String timeUpper;
	private Double buyEquipment;
	private Double trialEquipment;
	private Double transform;
	private Double equipmentCost;
	private Double materialCost;
	private Double testCost;
	private Double fuelCost;
	private Double travelCost;
	private Double conferenceCost;
	private Double exchangeCost;
	private Double publishCost;
	private Double serviceCost;
	private Double consultCost;
	private Double constructionCost;
	private Double otherCost;
	private Double directCost;
	private Double costSum;
	private Double performanceCost;
	private Double indirectCost;
	private Double subsidizeSpecial;
	private Double otherFundsSelf;
	private Double ownFundsSelf;
	private Double otherSelf;
	private Double selfFinance;
	private Double fundSum;
	private String astatus;

	// Constructors

	/** default constructor */
	public A863approvalBudget() {
	}

	/** minimal constructor */
	public A863approvalBudget(Long a863approvalPk) {
		this.a863approvalPk = a863approvalPk;
	}

	/** full constructor */
	public A863approvalBudget(Long a863approvalPk, Long itemPk, String itemId,
			String timeLower, String timeUpper, Double buyEquipment,
			Double trialEquipment, Double transform, Double equipmentCost,
			Double materialCost, Double testCost, Double fuelCost,
			Double travelCost, Double conferenceCost, Double exchangeCost,
			Double publishCost, Double serviceCost, Double consultCost,
			Double constructionCost, Double otherCost, Double directCost,
			Double costSum, Double performanceCost, Double indirectCost,
			Double subsidizeSpecial, Double otherFundsSelf,
			Double ownFundsSelf, Double otherSelf, Double selfFinance,
			Double fundSum, String astatus) {
		this.a863approvalPk = a863approvalPk;
		this.itemPk = itemPk;
		this.itemId = itemId;
		this.timeLower = timeLower;
		this.timeUpper = timeUpper;
		this.buyEquipment = buyEquipment;
		this.trialEquipment = trialEquipment;
		this.transform = transform;
		this.equipmentCost = equipmentCost;
		this.materialCost = materialCost;
		this.testCost = testCost;
		this.fuelCost = fuelCost;
		this.travelCost = travelCost;
		this.conferenceCost = conferenceCost;
		this.exchangeCost = exchangeCost;
		this.publishCost = publishCost;
		this.serviceCost = serviceCost;
		this.consultCost = consultCost;
		this.constructionCost = constructionCost;
		this.otherCost = otherCost;
		this.directCost = directCost;
		this.costSum = costSum;
		this.performanceCost = performanceCost;
		this.indirectCost = indirectCost;
		this.subsidizeSpecial = subsidizeSpecial;
		this.otherFundsSelf = otherFundsSelf;
		this.ownFundsSelf = ownFundsSelf;
		this.otherSelf = otherSelf;
		this.selfFinance = selfFinance;
		this.fundSum = fundSum;
		this.astatus = astatus;
	}

	// Property accessors

	public Long getA863approvalPk() {
		return this.a863approvalPk;
	}

	public void setA863approvalPk(Long a863approvalPk) {
		this.a863approvalPk = a863approvalPk;
	}

	public Long getItemPk() {
		return this.itemPk;
	}

	public void setItemPk(Long itemPk) {
		this.itemPk = itemPk;
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getTimeLower() {
		return this.timeLower;
	}

	public void setTimeLower(String timeLower) {
		this.timeLower = timeLower;
	}

	public String getTimeUpper() {
		return this.timeUpper;
	}

	public void setTimeUpper(String timeUpper) {
		this.timeUpper = timeUpper;
	}

	public Double getBuyEquipment() {
		return this.buyEquipment;
	}

	public void setBuyEquipment(Double buyEquipment) {
		this.buyEquipment = buyEquipment;
	}

	public Double getTrialEquipment() {
		return this.trialEquipment;
	}

	public void setTrialEquipment(Double trialEquipment) {
		this.trialEquipment = trialEquipment;
	}

	public Double getTransform() {
		return this.transform;
	}

	public void setTransform(Double transform) {
		this.transform = transform;
	}

	public Double getEquipmentCost() {
		return this.equipmentCost;
	}

	public void setEquipmentCost(Double equipmentCost) {
		this.equipmentCost = equipmentCost;
	}

	public Double getMaterialCost() {
		return this.materialCost;
	}

	public void setMaterialCost(Double materialCost) {
		this.materialCost = materialCost;
	}

	public Double getTestCost() {
		return this.testCost;
	}

	public void setTestCost(Double testCost) {
		this.testCost = testCost;
	}

	public Double getFuelCost() {
		return this.fuelCost;
	}

	public void setFuelCost(Double fuelCost) {
		this.fuelCost = fuelCost;
	}

	public Double getTravelCost() {
		return this.travelCost;
	}

	public void setTravelCost(Double travelCost) {
		this.travelCost = travelCost;
	}

	public Double getConferenceCost() {
		return this.conferenceCost;
	}

	public void setConferenceCost(Double conferenceCost) {
		this.conferenceCost = conferenceCost;
	}

	public Double getExchangeCost() {
		return this.exchangeCost;
	}

	public void setExchangeCost(Double exchangeCost) {
		this.exchangeCost = exchangeCost;
	}

	public Double getPublishCost() {
		return this.publishCost;
	}

	public void setPublishCost(Double publishCost) {
		this.publishCost = publishCost;
	}

	public Double getServiceCost() {
		return this.serviceCost;
	}

	public void setServiceCost(Double serviceCost) {
		this.serviceCost = serviceCost;
	}

	public Double getConsultCost() {
		return this.consultCost;
	}

	public void setConsultCost(Double consultCost) {
		this.consultCost = consultCost;
	}

	public Double getConstructionCost() {
		return this.constructionCost;
	}

	public void setConstructionCost(Double constructionCost) {
		this.constructionCost = constructionCost;
	}

	public Double getOtherCost() {
		return this.otherCost;
	}

	public void setOtherCost(Double otherCost) {
		this.otherCost = otherCost;
	}

	public Double getDirectCost() {
		return this.directCost;
	}

	public void setDirectCost(Double directCost) {
		this.directCost = directCost;
	}

	public Double getCostSum() {
		return this.costSum;
	}

	public void setCostSum(Double costSum) {
		this.costSum = costSum;
	}

	public Double getPerformanceCost() {
		return this.performanceCost;
	}

	public void setPerformanceCost(Double performanceCost) {
		this.performanceCost = performanceCost;
	}

	public Double getIndirectCost() {
		return this.indirectCost;
	}

	public void setIndirectCost(Double indirectCost) {
		this.indirectCost = indirectCost;
	}

	public Double getSubsidizeSpecial() {
		return this.subsidizeSpecial;
	}

	public void setSubsidizeSpecial(Double subsidizeSpecial) {
		this.subsidizeSpecial = subsidizeSpecial;
	}

	public Double getOtherFundsSelf() {
		return this.otherFundsSelf;
	}

	public void setOtherFundsSelf(Double otherFundsSelf) {
		this.otherFundsSelf = otherFundsSelf;
	}

	public Double getOwnFundsSelf() {
		return this.ownFundsSelf;
	}

	public void setOwnFundsSelf(Double ownFundsSelf) {
		this.ownFundsSelf = ownFundsSelf;
	}

	public Double getOtherSelf() {
		return this.otherSelf;
	}

	public void setOtherSelf(Double otherSelf) {
		this.otherSelf = otherSelf;
	}

	public Double getSelfFinance() {
		return this.selfFinance;
	}

	public void setSelfFinance(Double selfFinance) {
		this.selfFinance = selfFinance;
	}

	public Double getFundSum() {
		return this.fundSum;
	}

	public void setFundSum(Double fundSum) {
		this.fundSum = fundSum;
	}

	public String getAstatus() {
		return this.astatus;
	}

	public void setAstatus(String astatus) {
		this.astatus = astatus;
	}

}