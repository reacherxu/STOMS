package com.stoms.model;



/**
 * ActualFundRemark entity. @author MyEclipse Persistence Tools
 */

public class ActualFundRemark  implements java.io.Serializable {


    // Fields    

     private Long actualFundRemarkPk;
     private Long itemPk;
     private String itemId;
     private String staffCost;
     private String equipmentCost;
     private String fuelCost;
     private String materialCost;
     private String testCost;
     private String travelCost;
     private String conferenceCost;
     private String publishCost;
     private String manageCost;
     private String otherCost;
     private String sumCost;


    // Constructors

    /** default constructor */
    public ActualFundRemark() {
    }

	/** minimal constructor */
    public ActualFundRemark(Long actualFundRemarkPk) {
        this.actualFundRemarkPk = actualFundRemarkPk;
    }
    
    /** full constructor */
    public ActualFundRemark(Long actualFundRemarkPk, Long itemPk, String itemId, String staffCost, String equipmentCost, String fuelCost, String materialCost, String testCost, String travelCost, String conferenceCost, String publishCost, String manageCost, String otherCost, String sumCost) {
        this.actualFundRemarkPk = actualFundRemarkPk;
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
    }

   
    // Property accessors

    public Long getActualFundRemarkPk() {
        return this.actualFundRemarkPk;
    }
    
    public void setActualFundRemarkPk(Long actualFundRemarkPk) {
        this.actualFundRemarkPk = actualFundRemarkPk;
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

    public String getStaffCost() {
        return this.staffCost;
    }
    
    public void setStaffCost(String staffCost) {
        this.staffCost = staffCost;
    }

    public String getEquipmentCost() {
        return this.equipmentCost;
    }
    
    public void setEquipmentCost(String equipmentCost) {
        this.equipmentCost = equipmentCost;
    }

    public String getFuelCost() {
        return this.fuelCost;
    }
    
    public void setFuelCost(String fuelCost) {
        this.fuelCost = fuelCost;
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

    public String getPublishCost() {
        return this.publishCost;
    }
    
    public void setPublishCost(String publishCost) {
        this.publishCost = publishCost;
    }

    public String getManageCost() {
        return this.manageCost;
    }
    
    public void setManageCost(String manageCost) {
        this.manageCost = manageCost;
    }

    public String getOtherCost() {
        return this.otherCost;
    }
    
    public void setOtherCost(String otherCost) {
        this.otherCost = otherCost;
    }

    public String getSumCost() {
        return this.sumCost;
    }
    
    public void setSumCost(String sumCost) {
        this.sumCost = sumCost;
    }
   








}