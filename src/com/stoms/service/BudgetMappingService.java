package com.stoms.service;

import java.util.List;

import com.stoms.dao.BudgetMappingDAO;
import com.stoms.model.BudgetMapping;
import com.stoms.utils.JSONTranslation;

public class BudgetMappingService {
	private BudgetMappingDAO budgetMappingDAO;
	
	public BudgetMappingService() {
		
	}
	public String acquireMapping(String projectId) {
		List list = budgetMappingDAO.findByProjectId(projectId);
		/*
		 * the current project doesn't have a mapping, then use the default mapping 
		 */
		if(list.size() == 0) {
			String defaultProjectId = "000000";
			list = budgetMappingDAO.findByProjectId(defaultProjectId);
		}
		String[] excludes = {};
		
		return JSONTranslation.arrayToJson(list, excludes);
	}
	
	
	public boolean acquireProjectID(String projectId) {
		boolean result = false;
		
		List temp = budgetMappingDAO.findByProjectId(projectId);
		if(temp != null && temp.size() > 0) {
			result = true;
		}
		
		return result;
	}
	/**
	 * get detailed information
	 * @param itemId
	 * @param param
	 * @return
	 */
	public String getDetail(String projectId, String param) {
		String result = "";
		
		List<BudgetMapping> tmpList =  budgetMappingDAO.findByProjectId(projectId);
		
		if(tmpList.size() ==0 || tmpList == null)
			return "";
		else {
			BudgetMapping temp = tmpList.get(0);
			if( param.equals("research"))
				result = temp.getResearch();
			else if(param.equals("srbusiness")) {
				result = temp.getSrbusiness();
			} else if(param.equals("test")) {
				result = temp.getTest();
			} else if(param.equals("energy")) {
				result = temp.getEnergy();
			} else if(param.equals("meetings")) {
				result = temp.getMeetings();
			} else if(param.equals("publishments")) {
				result = temp.getPublishments();
			} else if(param.equals("other_srbusiness")) {
				result = temp.getOtherSrbusiness();
			} else if(param.equals("experiment_material")) {
				result = temp.getExperimentMaterial();
			} else if(param.equals("raw_material")) {
				result = temp.getRawMaterial();
			} else if(param.equals("other_material")) {
				result = temp.getOtherMaterial();
			} else if(param.equals("equipment")) {
				result = temp.getEquipment();
			} else if(param.equals("equipment_purchase")) {
				result = temp.getEquipmentPurchase();
			} else if(param.equals("equipment_produce")) {
				result = temp.getEquipmentProduce();
			} else if(param.equals("lab_reconstruction")) {
				result = temp.getLabReconstruction();
			} else if(param.equals("collaboration")) {
				result = temp.getCollaboration();
			} else if(param.equals("international_communication")) {
				result = temp.getInternationalCommunication();
			} else if(param.equals("export_communication")) {
				result = temp.getExportCommunication();
			} else if(param.equals("import_communication")) {
				result = temp.getImportCommunication();
			} else if(param.equals("labour")) {
				result = temp.getLabour();
			} else  {
				result = temp.getManagement();
			}
		}
		return result;
	}
	public String saveMapping(String projectId, String manager, String research, String srbusiness,
			String test, String energy, String meetings, String publishments, String otherSrbusiness,
			String experimentMaterial, String rawMaterial, String otherMaterial,String equipment, 
			String equipmentPurchase, String equipmentProduce, String labReconstruction,
			String collaboration, String internationalCommunication, String exportCommunication,
			String importCommunication, String labour, String management) {
		List list = budgetMappingDAO.findByProjectId(projectId);
		if(list.size() == 0) {
			BudgetMapping budgetMapping = new BudgetMapping(projectId, manager, research, srbusiness, test, 
					energy, meetings, publishments, otherSrbusiness, experimentMaterial, rawMaterial, otherMaterial, 
					equipment, equipmentPurchase, equipmentProduce, labReconstruction, collaboration, 
					internationalCommunication, exportCommunication, importCommunication, labour, management);
			budgetMappingDAO.save(budgetMapping);
		}
		else {
			BudgetMapping budgetMapping = (BudgetMapping) list.get(0);
			budgetMapping.setResearch(research);
			budgetMapping.setSrbusiness(srbusiness);
			budgetMapping.setTest(test);
			budgetMapping.setEnergy(energy);
			budgetMapping.setMeetings(meetings);
			budgetMapping.setPublishments(publishments);
			budgetMapping.setOtherSrbusiness(otherSrbusiness);
			budgetMapping.setExperimentMaterial(experimentMaterial);
			budgetMapping.setRawMaterial(rawMaterial);
			budgetMapping.setOtherMaterial(otherMaterial);
			budgetMapping.setEquipment(equipment);
			budgetMapping.setEquipmentPurchase(equipmentPurchase);
			budgetMapping.setEquipmentProduce(equipmentProduce);
			budgetMapping.setLabReconstruction(labReconstruction);
			budgetMapping.setCollaboration(collaboration);
			budgetMapping.setInternationalCommunication(internationalCommunication);
			budgetMapping.setExportCommunication(exportCommunication);
			budgetMapping.setImportCommunication(importCommunication);
			budgetMapping.setLabour(labour);
			budgetMapping.setManagement(management);
			
			budgetMappingDAO.attachDirty(budgetMapping);
		}
		return "success";
	}
	
	public BudgetMappingDAO getBudgetMappingDAO() {
		return budgetMappingDAO;
	}

	public void setBudgetMappingDAO(BudgetMappingDAO budgetMappingDAO) {
		this.budgetMappingDAO = budgetMappingDAO;
	}
	
}
