package com.stoms.model;

/**
 * SocialScienceRemark entity. @author MyEclipse Persistence Tools
 */

public class SocialScienceRemark implements java.io.Serializable {

	// Fields

	private Long socialScienceRemarkPk;
	private Long socialScienceOutlayPk;
	private Long itemPk;
	private String itemId;
	private String materialCost;
	private String dataCost;
	private String travelCost;
	private String conferenceCost;
	private String exchangeCost;
	private String equipmentCost;
	private String serviceCost;
	private String consultCost;
	private String printCost;
	private String manageCost;
	private String otherCost;
	private String costSum;

	// Constructors

	/** default constructor */
	public SocialScienceRemark() {
	}

	/** minimal constructor */
	public SocialScienceRemark(Long socialScienceRemarkPk) {
		this.socialScienceRemarkPk = socialScienceRemarkPk;
	}

	/** full constructor */
	public SocialScienceRemark(Long socialScienceRemarkPk,
			Long socialScienceOutlayPk, Long itemPk, String itemId,
			String materialCost, String dataCost, String travelCost,
			String conferenceCost, String exchangeCost, String equipmentCost,
			String serviceCost, String consultCost, String printCost,
			String manageCost, String otherCost, String costSum) {
		this.socialScienceRemarkPk = socialScienceRemarkPk;
		this.socialScienceOutlayPk = socialScienceOutlayPk;
		this.itemPk = itemPk;
		this.itemId = itemId;
		this.materialCost = materialCost;
		this.dataCost = dataCost;
		this.travelCost = travelCost;
		this.conferenceCost = conferenceCost;
		this.exchangeCost = exchangeCost;
		this.equipmentCost = equipmentCost;
		this.serviceCost = serviceCost;
		this.consultCost = consultCost;
		this.printCost = printCost;
		this.manageCost = manageCost;
		this.otherCost = otherCost;
		this.costSum = costSum;
	}

	// Property accessors

	public Long getSocialScienceRemarkPk() {
		return this.socialScienceRemarkPk;
	}

	public void setSocialScienceRemarkPk(Long socialScienceRemarkPk) {
		this.socialScienceRemarkPk = socialScienceRemarkPk;
	}

	public Long getSocialScienceOutlayPk() {
		return this.socialScienceOutlayPk;
	}

	public void setSocialScienceOutlayPk(Long socialScienceOutlayPk) {
		this.socialScienceOutlayPk = socialScienceOutlayPk;
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

	public String getMaterialCost() {
		return this.materialCost;
	}

	public void setMaterialCost(String materialCost) {
		this.materialCost = materialCost;
	}

	public String getDataCost() {
		return this.dataCost;
	}

	public void setDataCost(String dataCost) {
		this.dataCost = dataCost;
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

	public String getEquipmentCost() {
		return this.equipmentCost;
	}

	public void setEquipmentCost(String equipmentCost) {
		this.equipmentCost = equipmentCost;
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

	public String getPrintCost() {
		return this.printCost;
	}

	public void setPrintCost(String printCost) {
		this.printCost = printCost;
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

	public String getCostSum() {
		return this.costSum;
	}

	public void setCostSum(String costSum) {
		this.costSum = costSum;
	}

}