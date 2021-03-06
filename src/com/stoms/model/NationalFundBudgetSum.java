package com.stoms.model;



/**
 * NationalFundBudgetSum entity. @author MyEclipse Persistence Tools
 */

public class NationalFundBudgetSum  implements java.io.Serializable {


    // Fields    

     private Long nationalFundBudgetSumPk;
     private Long itemPk;
     private String itemId;
     private Double testCost;
     private Double fuelCost;
     private Double conferenceCost;
     private Double publishCost;
     private Double otherBusiness;
     private Double sumBusiness;
     private Double rawMaterial;
     private Double otherMaterial;
     private Double sumMaterial;
     private Double buyEquipment;
     private Double trialEquipment;
     private Double sumEquipment;
     private Double laboratory;
     private Double cooperation;
     private Double studyFund;
     private Double exchange;
     private Double expert;
     private Double exchangeSum;
     private Double serviceCost;
     private Double manageCost;
     private Double sums;


    // Constructors

    /** default constructor */
    public NationalFundBudgetSum() {
    }

	/** minimal constructor */
    public NationalFundBudgetSum(Long nationalFundBudgetSumPk) {
        this.nationalFundBudgetSumPk = nationalFundBudgetSumPk;
    }
    
    /** full constructor */
    public NationalFundBudgetSum(Long nationalFundBudgetSumPk, Long itemPk, String itemId, Double testCost, Double fuelCost, Double conferenceCost, Double publishCost, Double otherBusiness, Double sumBusiness, Double rawMaterial, Double otherMaterial, Double sumMaterial, Double buyEquipment, Double trialEquipment, Double sumEquipment, Double laboratory, Double cooperation, Double studyFund, Double exchange, Double expert, Double exchangeSum, Double serviceCost, Double manageCost, Double sums) {
        this.nationalFundBudgetSumPk = nationalFundBudgetSumPk;
        this.itemPk = itemPk;
        this.itemId = itemId;
        this.testCost = testCost;
        this.fuelCost = fuelCost;
        this.conferenceCost = conferenceCost;
        this.publishCost = publishCost;
        this.otherBusiness = otherBusiness;
        this.sumBusiness = sumBusiness;
        this.rawMaterial = rawMaterial;
        this.otherMaterial = otherMaterial;
        this.sumMaterial = sumMaterial;
        this.buyEquipment = buyEquipment;
        this.trialEquipment = trialEquipment;
        this.sumEquipment = sumEquipment;
        this.laboratory = laboratory;
        this.cooperation = cooperation;
        this.studyFund = studyFund;
        this.exchange = exchange;
        this.expert = expert;
        this.exchangeSum = exchangeSum;
        this.serviceCost = serviceCost;
        this.manageCost = manageCost;
        this.sums = sums;
    }

   
    // Property accessors

    public Long getNationalFundBudgetSumPk() {
        return this.nationalFundBudgetSumPk;
    }
    
    public void setNationalFundBudgetSumPk(Long nationalFundBudgetSumPk) {
        this.nationalFundBudgetSumPk = nationalFundBudgetSumPk;
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

    public Double getConferenceCost() {
        return this.conferenceCost;
    }
    
    public void setConferenceCost(Double conferenceCost) {
        this.conferenceCost = conferenceCost;
    }

    public Double getPublishCost() {
        return this.publishCost;
    }
    
    public void setPublishCost(Double publishCost) {
        this.publishCost = publishCost;
    }

    public Double getOtherBusiness() {
        return this.otherBusiness;
    }
    
    public void setOtherBusiness(Double otherBusiness) {
        this.otherBusiness = otherBusiness;
    }

    public Double getSumBusiness() {
        return this.sumBusiness;
    }
    
    public void setSumBusiness(Double sumBusiness) {
        this.sumBusiness = sumBusiness;
    }

    public Double getRawMaterial() {
        return this.rawMaterial;
    }
    
    public void setRawMaterial(Double rawMaterial) {
        this.rawMaterial = rawMaterial;
    }

    public Double getOtherMaterial() {
        return this.otherMaterial;
    }
    
    public void setOtherMaterial(Double otherMaterial) {
        this.otherMaterial = otherMaterial;
    }

    public Double getSumMaterial() {
        return this.sumMaterial;
    }
    
    public void setSumMaterial(Double sumMaterial) {
        this.sumMaterial = sumMaterial;
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

    public Double getSumEquipment() {
        return this.sumEquipment;
    }
    
    public void setSumEquipment(Double sumEquipment) {
        this.sumEquipment = sumEquipment;
    }

    public Double getLaboratory() {
        return this.laboratory;
    }
    
    public void setLaboratory(Double laboratory) {
        this.laboratory = laboratory;
    }

    public Double getCooperation() {
        return this.cooperation;
    }
    
    public void setCooperation(Double cooperation) {
        this.cooperation = cooperation;
    }

    public Double getStudyFund() {
        return this.studyFund;
    }
    
    public void setStudyFund(Double studyFund) {
        this.studyFund = studyFund;
    }

    public Double getExchange() {
        return this.exchange;
    }
    
    public void setExchange(Double exchange) {
        this.exchange = exchange;
    }

    public Double getExpert() {
        return this.expert;
    }
    
    public void setExpert(Double expert) {
        this.expert = expert;
    }

    public Double getExchangeSum() {
        return this.exchangeSum;
    }
    
    public void setExchangeSum(Double exchangeSum) {
        this.exchangeSum = exchangeSum;
    }

    public Double getServiceCost() {
        return this.serviceCost;
    }
    
    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Double getManageCost() {
        return this.manageCost;
    }
    
    public void setManageCost(Double manageCost) {
        this.manageCost = manageCost;
    }

    public Double getSums() {
        return this.sums;
    }
    
    public void setSums(Double sums) {
        this.sums = sums;
    }
   








}