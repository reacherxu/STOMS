package com.stoms.model;



/**
 * A863remark entity. @author MyEclipse Persistence Tools
 */

public class A863remark  implements java.io.Serializable {


    // Fields    

     private Long a863remarkPk;
     private Long a863outlayPk;
     private Long itemPk;
     private String itemId;
     private String buyEquipment;
     private String trialEquipment;
     private String transform;
     private String equipmentCost;
     private String materialCost;
     private String testCost;
     private String fuelCost;
     private String travelCost;
     private String conferenceCost;
     private String exchangeCost;
     private String publishCost;
     private String serviceCost;
     private String consultCost;
     private String constructionCost;
     private String otherCost;
     private String directCost;
     private String costSum;
     private String performanceCost;
     private String indirectCost;
     private String subsidizeSpecial;
     private String otherFundsSelf;
     private String ownFundsSelf;
     private String otherSelf;
     private String selfFinance;
     private String fundSum;


    // Constructors

    /** default constructor */
    public A863remark() {
    }

	/** minimal constructor */
    public A863remark(Long a863remarkPk) {
        this.a863remarkPk = a863remarkPk;
    }
    
    /** full constructor */
    public A863remark(Long a863remarkPk, Long a863outlayPk, Long itemPk, String itemId, String buyEquipment, String trialEquipment, String transform, String equipmentCost, String materialCost, String testCost, String fuelCost, String travelCost, String conferenceCost, String exchangeCost, String publishCost, String serviceCost, String consultCost, String constructionCost, String otherCost, String directCost, String costSum, String performanceCost, String indirectCost, String subsidizeSpecial, String otherFundsSelf, String ownFundsSelf, String otherSelf, String selfFinance, String fundSum) {
        this.a863remarkPk = a863remarkPk;
        this.a863outlayPk = a863outlayPk;
        this.itemPk = itemPk;
        this.itemId = itemId;
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
    }

   
    // Property accessors

    public Long getA863remarkPk() {
        return this.a863remarkPk;
    }
    
    public void setA863remarkPk(Long a863remarkPk) {
        this.a863remarkPk = a863remarkPk;
    }

    public Long getA863outlayPk() {
        return this.a863outlayPk;
    }
    
    public void setA863outlayPk(Long a863outlayPk) {
        this.a863outlayPk = a863outlayPk;
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

    public String getBuyEquipment() {
        return this.buyEquipment;
    }
    
    public void setBuyEquipment(String buyEquipment) {
        this.buyEquipment = buyEquipment;
    }

    public String getTrialEquipment() {
        return this.trialEquipment;
    }
    
    public void setTrialEquipment(String trialEquipment) {
        this.trialEquipment = trialEquipment;
    }

    public String getTransform() {
        return this.transform;
    }
    
    public void setTransform(String transform) {
        this.transform = transform;
    }

    public String getEquipmentCost() {
        return this.equipmentCost;
    }
    
    public void setEquipmentCost(String equipmentCost) {
        this.equipmentCost = equipmentCost;
    }

    public String getMaterialCost() {
        return this.materialCost;
    }
    
    public void setMaterialCost(String materialCost) {
        this.materialCost = materialCost;
    }

    public String getTestCost() {
        return this.testCost;
    }
    
    public void setTestCost(String testCost) {
        this.testCost = testCost;
    }

    public String getFuelCost() {
        return this.fuelCost;
    }
    
    public void setFuelCost(String fuelCost) {
        this.fuelCost = fuelCost;
    }

    public String getTravelCost() {
        return this.travelCost;
    }
    
    public void setTravelCost(String travelCost) {
        this.travelCost = travelCost;
    }

    public String getConferenceCost() {
        return this.conferenceCost;
    }
    
    public void setConferenceCost(String conferenceCost) {
        this.conferenceCost = conferenceCost;
    }

    public String getExchangeCost() {
        return this.exchangeCost;
    }
    
    public void setExchangeCost(String exchangeCost) {
        this.exchangeCost = exchangeCost;
    }

    public String getPublishCost() {
        return this.publishCost;
    }
    
    public void setPublishCost(String publishCost) {
        this.publishCost = publishCost;
    }

    public String getServiceCost() {
        return this.serviceCost;
    }
    
    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getConsultCost() {
        return this.consultCost;
    }
    
    public void setConsultCost(String consultCost) {
        this.consultCost = consultCost;
    }

    public String getConstructionCost() {
        return this.constructionCost;
    }
    
    public void setConstructionCost(String constructionCost) {
        this.constructionCost = constructionCost;
    }

    public String getOtherCost() {
        return this.otherCost;
    }
    
    public void setOtherCost(String otherCost) {
        this.otherCost = otherCost;
    }

    public String getDirectCost() {
        return this.directCost;
    }
    
    public void setDirectCost(String directCost) {
        this.directCost = directCost;
    }

    public String getCostSum() {
        return this.costSum;
    }
    
    public void setCostSum(String costSum) {
        this.costSum = costSum;
    }

    public String getPerformanceCost() {
        return this.performanceCost;
    }
    
    public void setPerformanceCost(String performanceCost) {
        this.performanceCost = performanceCost;
    }

    public String getIndirectCost() {
        return this.indirectCost;
    }
    
    public void setIndirectCost(String indirectCost) {
        this.indirectCost = indirectCost;
    }

    public String getSubsidizeSpecial() {
        return this.subsidizeSpecial;
    }
    
    public void setSubsidizeSpecial(String subsidizeSpecial) {
        this.subsidizeSpecial = subsidizeSpecial;
    }

    public String getOtherFundsSelf() {
        return this.otherFundsSelf;
    }
    
    public void setOtherFundsSelf(String otherFundsSelf) {
        this.otherFundsSelf = otherFundsSelf;
    }

    public String getOwnFundsSelf() {
        return this.ownFundsSelf;
    }
    
    public void setOwnFundsSelf(String ownFundsSelf) {
        this.ownFundsSelf = ownFundsSelf;
    }

    public String getOtherSelf() {
        return this.otherSelf;
    }
    
    public void setOtherSelf(String otherSelf) {
        this.otherSelf = otherSelf;
    }

    public String getSelfFinance() {
        return this.selfFinance;
    }
    
    public void setSelfFinance(String selfFinance) {
        this.selfFinance = selfFinance;
    }

    public String getFundSum() {
        return this.fundSum;
    }
    
    public void setFundSum(String fundSum) {
        this.fundSum = fundSum;
    }
   








}