package com.stoms.model;

/**
 * BudgetMapping entity. @author MyEclipse Persistence Tools
 */

public class BudgetMapping implements java.io.Serializable {

	// Fields

	private Integer mappingPk;
	private String projectId;
	private String manager;
	private String research;
	private String srbusiness;
	private String test;
	private String energy;
	private String meetings;
	private String publishments;
	private String otherSrbusiness;
	private String experimentMaterial;
	private String rawMaterial;
	private String otherMaterial;
	private String equipment;
	private String equipmentPurchase;
	private String equipmentProduce;
	private String labReconstruction;
	private String collaboration;
	private String internationalCommunication;
	private String exportCommunication;
	private String importCommunication;
	private String labour;
	private String management;

	// Constructors

	/** default constructor */
	public BudgetMapping() {
	}

	/** minimal constructor */
	public BudgetMapping(String projectId) {
		this.projectId = projectId;
	}

	/** full constructor */
	public BudgetMapping(String projectId, String manager, String research,
			String srbusiness, String test, String energy, String meetings,
			String publishments, String otherSrbusiness,
			String experimentMaterial, String rawMaterial,
			String otherMaterial, String equipment, String equipmentPurchase,
			String equipmentProduce, String labReconstruction,
			String collaboration, String internationalCommunication,
			String exportCommunication, String importCommunication,
			String labour, String management) {
		this.projectId = projectId;
		this.manager = manager;
		this.research = research;
		this.srbusiness = srbusiness;
		this.test = test;
		this.energy = energy;
		this.meetings = meetings;
		this.publishments = publishments;
		this.otherSrbusiness = otherSrbusiness;
		this.experimentMaterial = experimentMaterial;
		this.rawMaterial = rawMaterial;
		this.otherMaterial = otherMaterial;
		this.equipment = equipment;
		this.equipmentPurchase = equipmentPurchase;
		this.equipmentProduce = equipmentProduce;
		this.labReconstruction = labReconstruction;
		this.collaboration = collaboration;
		this.internationalCommunication = internationalCommunication;
		this.exportCommunication = exportCommunication;
		this.importCommunication = importCommunication;
		this.labour = labour;
		this.management = management;
	}

	// Property accessors

	public Integer getMappingPk() {
		return this.mappingPk;
	}

	public void setMappingPk(Integer mappingPk) {
		this.mappingPk = mappingPk;
	}

	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getResearch() {
		return this.research;
	}

	public void setResearch(String research) {
		this.research = research;
	}

	public String getSrbusiness() {
		return this.srbusiness;
	}

	public void setSrbusiness(String srbusiness) {
		this.srbusiness = srbusiness;
	}

	public String getTest() {
		return this.test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getEnergy() {
		return this.energy;
	}

	public void setEnergy(String energy) {
		this.energy = energy;
	}

	public String getMeetings() {
		return this.meetings;
	}

	public void setMeetings(String meetings) {
		this.meetings = meetings;
	}

	public String getPublishments() {
		return this.publishments;
	}

	public void setPublishments(String publishments) {
		this.publishments = publishments;
	}

	public String getOtherSrbusiness() {
		return this.otherSrbusiness;
	}

	public void setOtherSrbusiness(String otherSrbusiness) {
		this.otherSrbusiness = otherSrbusiness;
	}

	public String getExperimentMaterial() {
		return this.experimentMaterial;
	}

	public void setExperimentMaterial(String experimentMaterial) {
		this.experimentMaterial = experimentMaterial;
	}

	public String getRawMaterial() {
		return this.rawMaterial;
	}

	public void setRawMaterial(String rawMaterial) {
		this.rawMaterial = rawMaterial;
	}

	public String getOtherMaterial() {
		return this.otherMaterial;
	}

	public void setOtherMaterial(String otherMaterial) {
		this.otherMaterial = otherMaterial;
	}

	public String getEquipment() {
		return this.equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getEquipmentPurchase() {
		return this.equipmentPurchase;
	}

	public void setEquipmentPurchase(String equipmentPurchase) {
		this.equipmentPurchase = equipmentPurchase;
	}

	public String getEquipmentProduce() {
		return this.equipmentProduce;
	}

	public void setEquipmentProduce(String equipmentProduce) {
		this.equipmentProduce = equipmentProduce;
	}

	public String getLabReconstruction() {
		return this.labReconstruction;
	}

	public void setLabReconstruction(String labReconstruction) {
		this.labReconstruction = labReconstruction;
	}

	public String getCollaboration() {
		return this.collaboration;
	}

	public void setCollaboration(String collaboration) {
		this.collaboration = collaboration;
	}

	public String getInternationalCommunication() {
		return this.internationalCommunication;
	}

	public void setInternationalCommunication(String internationalCommunication) {
		this.internationalCommunication = internationalCommunication;
	}

	public String getExportCommunication() {
		return this.exportCommunication;
	}

	public void setExportCommunication(String exportCommunication) {
		this.exportCommunication = exportCommunication;
	}

	public String getImportCommunication() {
		return this.importCommunication;
	}

	public void setImportCommunication(String importCommunication) {
		this.importCommunication = importCommunication;
	}

	public String getLabour() {
		return this.labour;
	}

	public void setLabour(String labour) {
		this.labour = labour;
	}

	public String getManagement() {
		return this.management;
	}

	public void setManagement(String management) {
		this.management = management;
	}

}