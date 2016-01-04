package com.stoms.model;

/**
 * Budget entity. @author MyEclipse Persistence Tools
 */

public class Budget implements java.io.Serializable {

	// Fields

	private Integer budgetId;
	private String contractId;
	private String manager;
	private Float studyOutlay;
	private Float studyOutlaySr;
	private Float studyOutlaySrTest;
	private Float studyOutlaySrEnergy;
	private Float studyOutlaySrMeeting;
	private Float studyOutlaySrPublish;
	private Float studyOutlaySrOther;
	private Float studyOutlayEm;
	private Float studyOutlayEmMaterial;
	private Float studyOutlayEmOther;
	private Float studyOutlayEi;
	private Float studyOutlayEiPurchase;
	private Float studyOutlayEiProduce;
	private Float studyOutlayLr;
	private Float studyOutlayColaborate;
	private Float international;
	private Float international1;
	private Float international2;
	private Float service;
	private Float management;
	private Float sum;

	// Constructors

	/** default constructor */
	public Budget() {
	}

	/** minimal constructor */
	public Budget(String contractId, String manager) {
		this.contractId = contractId;
		this.manager = manager;
	}

	/** full constructor */
	public Budget(String contractId, String manager, Float studyOutlay,
			Float studyOutlaySr, Float studyOutlaySrTest,
			Float studyOutlaySrEnergy, Float studyOutlaySrMeeting,
			Float studyOutlaySrPublish, Float studyOutlaySrOther,
			Float studyOutlayEm, Float studyOutlayEmMaterial,
			Float studyOutlayEmOther, Float studyOutlayEi,
			Float studyOutlayEiPurchase, Float studyOutlayEiProduce,
			Float studyOutlayLr, Float studyOutlayColaborate,
			Float international, Float international1, Float international2,
			Float service, Float management, Float sum) {
		this.contractId = contractId;
		this.manager = manager;
		this.studyOutlay = studyOutlay;
		this.studyOutlaySr = studyOutlaySr;
		this.studyOutlaySrTest = studyOutlaySrTest;
		this.studyOutlaySrEnergy = studyOutlaySrEnergy;
		this.studyOutlaySrMeeting = studyOutlaySrMeeting;
		this.studyOutlaySrPublish = studyOutlaySrPublish;
		this.studyOutlaySrOther = studyOutlaySrOther;
		this.studyOutlayEm = studyOutlayEm;
		this.studyOutlayEmMaterial = studyOutlayEmMaterial;
		this.studyOutlayEmOther = studyOutlayEmOther;
		this.studyOutlayEi = studyOutlayEi;
		this.studyOutlayEiPurchase = studyOutlayEiPurchase;
		this.studyOutlayEiProduce = studyOutlayEiProduce;
		this.studyOutlayLr = studyOutlayLr;
		this.studyOutlayColaborate = studyOutlayColaborate;
		this.international = international;
		this.international1 = international1;
		this.international2 = international2;
		this.service = service;
		this.management = management;
		this.sum = sum;
	}

	// Property accessors

	public Integer getBudgetId() {
		return this.budgetId;
	}

	public void setBudgetId(Integer budgetId) {
		this.budgetId = budgetId;
	}

	public String getContractId() {
		return this.contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Float getStudyOutlay() {
		return this.studyOutlay;
	}

	public void setStudyOutlay(Float studyOutlay) {
		this.studyOutlay = studyOutlay;
	}

	public Float getStudyOutlaySr() {
		return this.studyOutlaySr;
	}

	public void setStudyOutlaySr(Float studyOutlaySr) {
		this.studyOutlaySr = studyOutlaySr;
	}

	public Float getStudyOutlaySrTest() {
		return this.studyOutlaySrTest;
	}

	public void setStudyOutlaySrTest(Float studyOutlaySrTest) {
		this.studyOutlaySrTest = studyOutlaySrTest;
	}

	public Float getStudyOutlaySrEnergy() {
		return this.studyOutlaySrEnergy;
	}

	public void setStudyOutlaySrEnergy(Float studyOutlaySrEnergy) {
		this.studyOutlaySrEnergy = studyOutlaySrEnergy;
	}

	public Float getStudyOutlaySrMeeting() {
		return this.studyOutlaySrMeeting;
	}

	public void setStudyOutlaySrMeeting(Float studyOutlaySrMeeting) {
		this.studyOutlaySrMeeting = studyOutlaySrMeeting;
	}

	public Float getStudyOutlaySrPublish() {
		return this.studyOutlaySrPublish;
	}

	public void setStudyOutlaySrPublish(Float studyOutlaySrPublish) {
		this.studyOutlaySrPublish = studyOutlaySrPublish;
	}

	public Float getStudyOutlaySrOther() {
		return this.studyOutlaySrOther;
	}

	public void setStudyOutlaySrOther(Float studyOutlaySrOther) {
		this.studyOutlaySrOther = studyOutlaySrOther;
	}

	public Float getStudyOutlayEm() {
		return this.studyOutlayEm;
	}

	public void setStudyOutlayEm(Float studyOutlayEm) {
		this.studyOutlayEm = studyOutlayEm;
	}

	public Float getStudyOutlayEmMaterial() {
		return this.studyOutlayEmMaterial;
	}

	public void setStudyOutlayEmMaterial(Float studyOutlayEmMaterial) {
		this.studyOutlayEmMaterial = studyOutlayEmMaterial;
	}

	public Float getStudyOutlayEmOther() {
		return this.studyOutlayEmOther;
	}

	public void setStudyOutlayEmOther(Float studyOutlayEmOther) {
		this.studyOutlayEmOther = studyOutlayEmOther;
	}

	public Float getStudyOutlayEi() {
		return this.studyOutlayEi;
	}

	public void setStudyOutlayEi(Float studyOutlayEi) {
		this.studyOutlayEi = studyOutlayEi;
	}

	public Float getStudyOutlayEiPurchase() {
		return this.studyOutlayEiPurchase;
	}

	public void setStudyOutlayEiPurchase(Float studyOutlayEiPurchase) {
		this.studyOutlayEiPurchase = studyOutlayEiPurchase;
	}

	public Float getStudyOutlayEiProduce() {
		return this.studyOutlayEiProduce;
	}

	public void setStudyOutlayEiProduce(Float studyOutlayEiProduce) {
		this.studyOutlayEiProduce = studyOutlayEiProduce;
	}

	public Float getStudyOutlayLr() {
		return this.studyOutlayLr;
	}

	public void setStudyOutlayLr(Float studyOutlayLr) {
		this.studyOutlayLr = studyOutlayLr;
	}

	public Float getStudyOutlayColaborate() {
		return this.studyOutlayColaborate;
	}

	public void setStudyOutlayColaborate(Float studyOutlayColaborate) {
		this.studyOutlayColaborate = studyOutlayColaborate;
	}

	public Float getInternational() {
		return this.international;
	}

	public void setInternational(Float international) {
		this.international = international;
	}

	public Float getInternational1() {
		return this.international1;
	}

	public void setInternational1(Float international1) {
		this.international1 = international1;
	}

	public Float getInternational2() {
		return this.international2;
	}

	public void setInternational2(Float international2) {
		this.international2 = international2;
	}

	public Float getService() {
		return this.service;
	}

	public void setService(Float service) {
		this.service = service;
	}

	public Float getManagement() {
		return this.management;
	}

	public void setManagement(Float management) {
		this.management = management;
	}

	public Float getSum() {
		return this.sum;
	}

	public void setSum(Float sum) {
		this.sum = sum;
	}

}