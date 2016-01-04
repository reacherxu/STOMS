package com.stoms.model;



/**
 * NationalFundAdjust entity. @author MyEclipse Persistence Tools
 */

public class NationalFundAdjust  implements java.io.Serializable {


    // Fields    

     private Long nationalFundAdjustPk;
     private Item item;
     private Long itemPk2;
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
     private String ntime;
     private String nstatus;
     private String picture;
     private String suggestion;
     private String operatorId;


    // Constructors

    /** default constructor */
    public NationalFundAdjust() {
    }

	/** minimal constructor */
    public NationalFundAdjust(Long nationalFundAdjustPk) {
        this.nationalFundAdjustPk = nationalFundAdjustPk;
    }
    
    /** full constructor */
    public NationalFundAdjust(Long nationalFundAdjustPk, Item item, Long itemPk2, String itemId, Double testCost, Double fuelCost, Double conferenceCost, Double publishCost, Double otherBusiness, Double sumBusiness, Double rawMaterial, Double otherMaterial, Double sumMaterial, Double buyEquipment, Double trialEquipment, Double sumEquipment, Double laboratory, Double cooperation, Double studyFund, Double exchange, Double expert, Double exchangeSum, Double serviceCost, Double manageCost, Double sums, String ntime, String nstatus, String picture, String suggestion, String operatorId) {
        this.nationalFundAdjustPk = nationalFundAdjustPk;
        this.item = item;
        this.itemPk2 = itemPk2;
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
        this.ntime = ntime;
        this.nstatus = nstatus;
        this.picture = picture;
        this.suggestion = suggestion;
        this.operatorId = operatorId;
    }

   
    // Property accessors

    public Long getNationalFundAdjustPk() {
        return this.nationalFundAdjustPk;
    }
    
    public void setNationalFundAdjustPk(Long nationalFundAdjustPk) {
        this.nationalFundAdjustPk = nationalFundAdjustPk;
    }

    public Item getItem() {
        return this.item;
    }
    
    public void setItem(Item item) {
        this.item = item;
    }

    public Long getItemPk2() {
        return this.itemPk2;
    }
    
    public void setItemPk2(Long itemPk2) {
        this.itemPk2 = itemPk2;
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

    public String getNtime() {
        return this.ntime;
    }
    
    public void setNtime(String ntime) {
        this.ntime = ntime;
    }

    public String getNstatus() {
        return this.nstatus;
    }
    
    public void setNstatus(String nstatus) {
        this.nstatus = nstatus;
    }

    public String getPicture() {
        return this.picture;
    }
    
    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSuggestion() {
        return this.suggestion;
    }
    
    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getOperatorId() {
        return this.operatorId;
    }
    
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
   








}