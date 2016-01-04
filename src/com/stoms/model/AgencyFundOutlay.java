package com.stoms.model;



/**
 * AgencyFundOutlay entity. @author MyEclipse Persistence Tools
 */

public class AgencyFundOutlay  implements java.io.Serializable {


    // Fields    

     private Long agencyFundOutlayPk;
     private Long itemPk;
     private String itemId;
     private Double staffCost;
     private Double equipmentCost;
     private Double fuelCost;
     private Double materialCost;
     private Double testCost;
     private Double travelCost;
     private Double conferenceCost;
     private Double publishCost;
     private Double manageCost;
     private Double otherCost;
     private Double sumCost;
     private String outlayTime;


    // Constructors

    /** default constructor */
    public AgencyFundOutlay() {
    }

	/** minimal constructor */
    public AgencyFundOutlay(Long agencyFundOutlayPk) {
        this.agencyFundOutlayPk = agencyFundOutlayPk;
    }
    
    /** full constructor */
    public AgencyFundOutlay(Long agencyFundOutlayPk, Long itemPk, String itemId, Double staffCost, Double equipmentCost, Double fuelCost, Double materialCost, Double testCost, Double travelCost, Double conferenceCost, Double publishCost, Double manageCost, Double otherCost, Double sumCost, String outlayTime) {
        this.agencyFundOutlayPk = agencyFundOutlayPk;
        this.itemPk = itemPk;
        this.itemId = itemId;
        this.staffCost = staffCost;
        this.equipmentCost = equipmentCost;
        this.fuelCost = fuelCost;
        this.materialCost = materialCost;
        this.testCost = testCost;
        this.travelCost = travelCost;
        this.conferenceCost = conferenceCost;
        this.publishCost = publishCost;
        this.manageCost = manageCost;
        this.otherCost = otherCost;
        this.sumCost = sumCost;
        this.outlayTime = outlayTime;
    }

   
    // Property accessors

    public Long getAgencyFundOutlayPk() {
        return this.agencyFundOutlayPk;
    }
    
    public void setAgencyFundOutlayPk(Long agencyFundOutlayPk) {
        this.agencyFundOutlayPk = agencyFundOutlayPk;
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

    public Double getStaffCost() {
        return this.staffCost;
    }
    
    public void setStaffCost(Double staffCost) {
        this.staffCost = staffCost;
    }

    public Double getEquipmentCost() {
        return this.equipmentCost;
    }
    
    public void setEquipmentCost(Double equipmentCost) {
        this.equipmentCost = equipmentCost;
    }

    public Double getFuelCost() {
        return this.fuelCost;
    }
    
    public void setFuelCost(Double fuelCost) {
        this.fuelCost = fuelCost;
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

    public Double getPublishCost() {
        return this.publishCost;
    }
    
    public void setPublishCost(Double publishCost) {
        this.publishCost = publishCost;
    }

    public Double getManageCost() {
        return this.manageCost;
    }
    
    public void setManageCost(Double manageCost) {
        this.manageCost = manageCost;
    }

    public Double getOtherCost() {
        return this.otherCost;
    }
    
    public void setOtherCost(Double otherCost) {
        this.otherCost = otherCost;
    }

    public Double getSumCost() {
        return this.sumCost;
    }
    
    public void setSumCost(Double sumCost) {
        this.sumCost = sumCost;
    }

    public String getOutlayTime() {
        return this.outlayTime;
    }
    
    public void setOutlayTime(String outlayTime) {
        this.outlayTime = outlayTime;
    }
   








}