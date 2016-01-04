package com.stoms.action;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.service.BudgetMappingService;

/**
 * @author WJF
 * 
 */
public class BudgetMappingAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;

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

	private BudgetMappingService budgetMappingService;

	public BudgetMappingAction() {
	}

	/*
	 * acquire the project's mapping from BudgetMapping table
	 */
	public String acquireMapping() {
		String result = budgetMappingService.acquireMapping(projectId);

		if (result == null) {
			this.actionStatus = false;
			this.jsonResult = "";
		}
		this.actionStatus = true;
		this.jsonResult = result;
		return "success";
	}

	/**
	 * 获取映射关系 并取得支出
	 * 
	 * @return
	 */
	public String acquireBudgetMappingExpenditure() {

		if (projectId == null || projectId == "") {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = budgetMappingService.acquireProjectID(projectId);
		if (this.actionStatus) {
			this.jsonResult = "";
			return "success";
		}

		// //TODO 已有的要设置回显菜单
		// if(this.actionStatus) {
		// this.jsonResult = budgetService.getDataToForm(contractID);
		// return "success";
		// }

		// TODO false时要设置
		this.actionStatus = false;
		this.jsonResult = "";
		return "success";

	}

	public String saveMapping() {
		if (projectId.equals("null")) {
			this.actionStatus = false;
			this.jsonResult = "";
		} else {
			budgetMappingService.saveMapping(projectId, manager, research,
					srbusiness, test, energy, meetings, publishments,
					otherSrbusiness, experimentMaterial, rawMaterial,
					otherMaterial, equipment, equipmentPurchase,
					equipmentProduce, labReconstruction, collaboration,
					internationalCommunication, exportCommunication,
					importCommunication, labour, management);
			this.actionStatus = true;
			this.jsonResult = "";
		}
		return "success";
	}

	public String getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	public boolean isActionStatus() {
		return actionStatus;
	}

	public void setActionStatus(boolean actionStatus) {
		this.actionStatus = actionStatus;
	}

	public Integer getMappingPk() {
		return mappingPk;
	}

	public void setMappingPk(Integer mappingPk) {
		this.mappingPk = mappingPk;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getResearch() {
		return research;
	}

	public void setResearch(String research) {
		this.research = research;
	}

	public String getSrbusiness() {
		return srbusiness;
	}

	public void setSrbusiness(String srbusiness) {
		this.srbusiness = srbusiness;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getEnergy() {
		return energy;
	}

	public void setEnergy(String energy) {
		this.energy = energy;
	}

	public String getMeetings() {
		return meetings;
	}

	public void setMeetings(String meetings) {
		this.meetings = meetings;
	}

	public String getPublishments() {
		return publishments;
	}

	public void setPublishments(String publishments) {
		this.publishments = publishments;
	}

	public String getOtherSrbusiness() {
		return otherSrbusiness;
	}

	public void setOtherSrbusiness(String otherSrbusiness) {
		this.otherSrbusiness = otherSrbusiness;
	}

	public String getExperimentMaterial() {
		return experimentMaterial;
	}

	public void setExperimentMaterial(String experimentMaterial) {
		this.experimentMaterial = experimentMaterial;
	}

	public String getRawMaterial() {
		return rawMaterial;
	}

	public void setRawMaterial(String rawMaterial) {
		this.rawMaterial = rawMaterial;
	}

	public String getOtherMaterial() {
		return otherMaterial;
	}

	public void setOtherMaterial(String otherMaterial) {
		this.otherMaterial = otherMaterial;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getEquipmentPurchase() {
		return equipmentPurchase;
	}

	public void setEquipmentPurchase(String equipmentPurchase) {
		this.equipmentPurchase = equipmentPurchase;
	}

	public String getEquipmentProduce() {
		return equipmentProduce;
	}

	public void setEquipmentProduce(String equipmentProduce) {
		this.equipmentProduce = equipmentProduce;
	}

	public String getLabReconstruction() {
		return labReconstruction;
	}

	public void setLabReconstruction(String labReconstruction) {
		this.labReconstruction = labReconstruction;
	}

	public String getCollaboration() {
		return collaboration;
	}

	public void setCollaboration(String collaboration) {
		this.collaboration = collaboration;
	}

	public String getInternationalCommunication() {
		return internationalCommunication;
	}

	public void setInternationalCommunication(String internationalCommunication) {
		this.internationalCommunication = internationalCommunication;
	}

	public String getExportCommunication() {
		return exportCommunication;
	}

	public void setExportCommunication(String exportCommunication) {
		this.exportCommunication = exportCommunication;
	}

	public String getImportCommunication() {
		return importCommunication;
	}

	public void setImportCommunication(String importCommunication) {
		this.importCommunication = importCommunication;
	}

	public String getLabour() {
		return labour;
	}

	public void setLabour(String labour) {
		this.labour = labour;
	}

	public String getManagement() {
		return management;
	}

	public void setManagement(String management) {
		this.management = management;
	}

	public BudgetMappingService getBudgetMappingService() {
		return budgetMappingService;
	}

	public void setBudgetMappingService(
			BudgetMappingService budgetMappingService) {
		this.budgetMappingService = budgetMappingService;
	}
}
