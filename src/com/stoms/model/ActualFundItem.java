package com.stoms.model;

/**
 * ActualFundItem entity. @author MyEclipse Persistence Tools
 */

public class ActualFundItem implements java.io.Serializable {

	// Fields

	private Long actualFundItemPk;
	private Long itemPk;
	private String itemId;
	private String contractId;
	private String itemName;
	private String teacherName;
	private Double nationFund;
	private Double agencyFund;
	private Double countyFund;
	private Double departmentFund;
	private Double selfFund;
	private Double otherFund;
	private Double fundSum;

	// Constructors

	/** default constructor */
	public ActualFundItem() {
	}

	/** minimal constructor */
	public ActualFundItem(Long actualFundItemPk) {
		this.actualFundItemPk = actualFundItemPk;
	}

	/** full constructor */
	public ActualFundItem(Long actualFundItemPk, Long itemPk, String itemId,
			String contractId, String itemName, String teacherName,
			Double nationFund, Double agencyFund, Double countyFund,
			Double departmentFund, Double selfFund, Double otherFund,
			Double fundSum) {
		this.actualFundItemPk = actualFundItemPk;
		this.itemPk = itemPk;
		this.itemId = itemId;
		this.contractId = contractId;
		this.itemName = itemName;
		this.teacherName = teacherName;
		this.nationFund = nationFund;
		this.agencyFund = agencyFund;
		this.countyFund = countyFund;
		this.departmentFund = departmentFund;
		this.selfFund = selfFund;
		this.otherFund = otherFund;
		this.fundSum = fundSum;
	}

	// Property accessors

	public Long getActualFundItemPk() {
		return this.actualFundItemPk;
	}

	public void setActualFundItemPk(Long actualFundItemPk) {
		this.actualFundItemPk = actualFundItemPk;
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

	public String getContractId() {
		return this.contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Double getNationFund() {
		return this.nationFund;
	}

	public void setNationFund(Double nationFund) {
		this.nationFund = nationFund;
	}

	public Double getAgencyFund() {
		return this.agencyFund;
	}

	public void setAgencyFund(Double agencyFund) {
		this.agencyFund = agencyFund;
	}

	public Double getCountyFund() {
		return this.countyFund;
	}

	public void setCountyFund(Double countyFund) {
		this.countyFund = countyFund;
	}

	public Double getDepartmentFund() {
		return this.departmentFund;
	}

	public void setDepartmentFund(Double departmentFund) {
		this.departmentFund = departmentFund;
	}

	public Double getSelfFund() {
		return this.selfFund;
	}

	public void setSelfFund(Double selfFund) {
		this.selfFund = selfFund;
	}

	public Double getOtherFund() {
		return this.otherFund;
	}

	public void setOtherFund(Double otherFund) {
		this.otherFund = otherFund;
	}

	public Double getFundSum() {
		return this.fundSum;
	}

	public void setFundSum(Double fundSum) {
		this.fundSum = fundSum;
	}

}