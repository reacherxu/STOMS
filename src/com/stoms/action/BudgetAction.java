package com.stoms.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.model.Expenditure;
import com.stoms.service.BudgetMappingService;
import com.stoms.service.BudgetService;
import com.stoms.service.ExpenditureService;
import com.stoms.service.ItemService;
import com.stoms.utils.JSONTranslation;

public class BudgetAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BudgetService budgetService;
	private ItemService itemService;
	private BudgetMappingService budgetMappingService;
	private ExpenditureService expenditureService;

	private boolean actionStatus;
	private String jsonResult;

	private String itemId;

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

	private String param;
	/**
	 * 增加一行预算
	 * 项目中更新合同号
	 * @return
	 */
	public String insertBudget() {
		boolean budgetStatus = false;
		boolean itemStatus = false;
		
		if (contractId == null || manager == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		budgetStatus = budgetService.addNewBudget(contractId, manager,
				studyOutlay, studyOutlaySr, studyOutlaySrTest,
				studyOutlaySrEnergy, studyOutlaySrMeeting,
				studyOutlaySrPublish, studyOutlaySrOther, studyOutlayEm,
				studyOutlayEmMaterial, studyOutlayEmOther, studyOutlayEi,
				studyOutlayEiPurchase, studyOutlayEiProduce, studyOutlayLr,
				studyOutlayColaborate, international, international1,
				international2, service, management, sum);
		itemStatus = itemService.updateMapping(itemId,contractId);
		if( budgetStatus && itemStatus )
			this.actionStatus = true;

		if (!this.actionStatus) {
			this.jsonResult = "";
			return "success";
		}

		this.jsonResult = "";
		return "success";

	}

	/**
	 * 更新预算
	 * 
	 * @return
	 */
	public String updateBudget() {
		if (contractId == null || manager == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = budgetService.updateBudget(contractId, manager,
				studyOutlay, studyOutlaySr, studyOutlaySrTest,
				studyOutlaySrEnergy, studyOutlaySrMeeting,
				studyOutlaySrPublish, studyOutlaySrOther, studyOutlayEm,
				studyOutlayEmMaterial, studyOutlayEmOther, studyOutlayEi,
				studyOutlayEiPurchase, studyOutlayEiProduce, studyOutlayLr,
				studyOutlayColaborate, international, international1,
				international2, service, management, sum);

		if (!this.actionStatus) {
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = true;
		this.jsonResult = "";
		return "success";
	}

	/**
	 * 查看是否有合同号
	 * 
	 * @return
	 */
	public String acquireContractID() {

		if (itemId == null || itemId == "") {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		String contractID = itemService.acquireItemContractID(itemId);
		if (contractID == null || contractID == "") {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = budgetService.hasContractID(contractID);

		if (this.actionStatus) {
			this.jsonResult = budgetService.getDataToForm(contractID);
			return "success";
		}

		this.actionStatus = false;
		this.jsonResult = "";
		return "success";

	}
	
	/**
	 * 显示 预算和支出的对比
	 * @return
	 */
	public String acquireBudgetContrast() {
		String jsonBudget = null;
		String jsonExpenditure = null;
		
		if (itemId == null || itemId == "") {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		//concerning budget
		String contractID = itemService.acquireItemContractID(itemId);
		if (contractID == null || contractID == "") {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		this.actionStatus = budgetService.hasContractID(contractID);
		if (this.actionStatus) {
			jsonBudget = budgetService.getDataToForm(contractID);
		}
		
		//concerning expenditure
		jsonExpenditure = budgetMappingService.acquireMapping(itemId);
		jsonExpenditure = translateIntoMoney(jsonExpenditure);
		
		if(jsonBudget != null && jsonExpenditure != null )		
			this.jsonResult = mergeJson(jsonBudget,jsonExpenditure);
		
		return "success";
	}
	
	/**
	 * 显示明细
	 * @return
	 */
	public String findDetail() {
		
		if (itemId == null || itemId == "") {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		List<Expenditure> searchList = new ArrayList<Expenditure>();//store the whole result
		
		//get detail
		String detailList = budgetMappingService.getDetail(itemId,param);
		if( detailList.equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		String detail[] = detailList.split(";");
		for(int i=0;i<detail.length;i++ ) {
			if( !detail[i].equals("") && detail[i] != null ) {
				List<Expenditure> tmpDetailList = expenditureService.getDetail(itemId,detail[i]);
				for(int j=0;j<tmpDetailList.size();j++)
					searchList.add(tmpDetailList.get(j));
			}
		}
		
		String[] excludes = { "research","srbusiness","test","energy","meetings",
				"publishments","other_srbusiness","experiment_material","raw_material",
				"other_material","equipment","equipment_purchase","equipment_produce",
				"lab_reconstruction","collaboration","international_communication",
				"export_communication","import_communication","labour","management"};

		this.jsonResult = JSONTranslation.arrayToJson(searchList, excludes);
		if (this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}

		this.actionStatus = true;
		return "success";
	}
	

	private String translateIntoMoney(String jsonExpenditure) {
		String result = "{";
		
		jsonExpenditure = jsonExpenditure.substring(2,jsonExpenditure.length()-2);
		String mapping[] = jsonExpenditure.split(",");
		for( int i=0; i<mapping.length; i++) {
			
			String tmp[] = mapping[i].split(":");
			String key = tmp[0];
			String value = tmp[1];
			
			if(key.equals("\"manager\"")  ||  key.equals("\"mappingPk\"")) {
				if( i == 0 )
					result += mapping[i];
				else
					result += "," + mapping[i];
				continue;
			}
			if( value.equals("\"\"") ) {
				if( i == 0 )
					result += key + ":" + 0;
				else
					result += "," + key + ":" + 0;
				continue;
			}
			// acquire an array of expenditure,and then sum it
			String expenditure[] = trimToken(value).split(";");
			float sum = 0;
			for(int j=0; j<expenditure.length; j++ ) {
				float money = expenditureService.findByPro_Sub(itemId,expenditure[j]);
				sum += money;
			}
			if( i == 0 ) {
				result += key + ":" + sum;
			}
			else {
				result += "," + key + ":" + sum;
			} 
		}
		//acuqire the sum of the expenditure
		result += "}";
		return result;
	}

	private String trimToken(String str) {
		return str.substring(1,str.length()-1);
	}
	private String mergeJson(String jsonBudget, String jsonExpenditure) {
		jsonBudget = jsonBudget.replace("management", "manage");
		return jsonBudget.replace("}", ",") + jsonExpenditure.substring(1);
	}

	// setters and getters
	
	public boolean isActionStatus() {
		return actionStatus;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Float getStudyOutlay() {
		return studyOutlay;
	}

	public void setStudyOutlay(Float studyOutlay) {
		this.studyOutlay = studyOutlay;
	}

	public Float getStudyOutlaySr() {
		return studyOutlaySr;
	}

	public void setStudyOutlaySr(Float studyOutlaySr) {
		this.studyOutlaySr = studyOutlaySr;
	}

	public Float getStudyOutlaySrTest() {
		return studyOutlaySrTest;
	}

	public void setStudyOutlaySrTest(Float studyOutlaySrTest) {
		this.studyOutlaySrTest = studyOutlaySrTest;
	}

	public Float getStudyOutlaySrEnergy() {
		return studyOutlaySrEnergy;
	}

	public void setStudyOutlaySrEnergy(Float studyOutlaySrEnergy) {
		this.studyOutlaySrEnergy = studyOutlaySrEnergy;
	}

	public Float getStudyOutlaySrMeeting() {
		return studyOutlaySrMeeting;
	}

	public void setStudyOutlaySrMeeting(Float studyOutlaySrMeeting) {
		this.studyOutlaySrMeeting = studyOutlaySrMeeting;
	}

	public Float getStudyOutlaySrPublish() {
		return studyOutlaySrPublish;
	}

	public void setStudyOutlaySrPublish(Float studyOutlaySrPublish) {
		this.studyOutlaySrPublish = studyOutlaySrPublish;
	}

	public Float getStudyOutlaySrOther() {
		return studyOutlaySrOther;
	}

	public void setStudyOutlaySrOther(Float studyOutlaySrOther) {
		this.studyOutlaySrOther = studyOutlaySrOther;
	}

	public Float getStudyOutlayEm() {
		return studyOutlayEm;
	}

	public void setStudyOutlayEm(Float studyOutlayEm) {
		this.studyOutlayEm = studyOutlayEm;
	}

	public Float getStudyOutlayEmMaterial() {
		return studyOutlayEmMaterial;
	}

	public void setStudyOutlayEmMaterial(Float studyOutlayEmMaterial) {
		this.studyOutlayEmMaterial = studyOutlayEmMaterial;
	}

	public Float getStudyOutlayEmOther() {
		return studyOutlayEmOther;
	}

	public void setStudyOutlayEmOther(Float studyOutlayEmOther) {
		this.studyOutlayEmOther = studyOutlayEmOther;
	}

	public Float getStudyOutlayEi() {
		return studyOutlayEi;
	}

	public void setStudyOutlayEi(Float studyOutlayEi) {
		this.studyOutlayEi = studyOutlayEi;
	}

	public Float getStudyOutlayEiPurchase() {
		return studyOutlayEiPurchase;
	}

	public void setStudyOutlayEiPurchase(Float studyOutlayEiPurchase) {
		this.studyOutlayEiPurchase = studyOutlayEiPurchase;
	}

	public Float getStudyOutlayEiProduce() {
		return studyOutlayEiProduce;
	}

	public void setStudyOutlayEiProduce(Float studyOutlayEiProduce) {
		this.studyOutlayEiProduce = studyOutlayEiProduce;
	}

	public Float getStudyOutlayLr() {
		return studyOutlayLr;
	}

	public void setStudyOutlayLr(Float studyOutlayLr) {
		this.studyOutlayLr = studyOutlayLr;
	}

	public Float getStudyOutlayColaborate() {
		return studyOutlayColaborate;
	}

	public void setStudyOutlayColaborate(Float studyOutlayColaborate) {
		this.studyOutlayColaborate = studyOutlayColaborate;
	}

	public Float getInternational() {
		return international;
	}

	public void setInternational(Float international) {
		this.international = international;
	}

	public Float getInternational1() {
		return international1;
	}

	public void setInternational1(Float international1) {
		this.international1 = international1;
	}

	public Float getInternational2() {
		return international2;
	}

	public void setInternational2(Float international2) {
		this.international2 = international2;
	}

	public Float getService() {
		return service;
	}

	public void setService(Float service) {
		this.service = service;
	}

	public Float getManagement() {
		return management;
	}

	public void setManagement(Float management) {
		this.management = management;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Float getSum() {
		return sum;
	}

	public void setSum(Float sum) {
		this.sum = sum;
	}

	public void setActionStatus(boolean actionStatus) {
		this.actionStatus = actionStatus;
	}

	public String getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	public BudgetService getBudgetService() {
		return budgetService;
	}

	public void setBudgetService(BudgetService budgetService) {
		this.budgetService = budgetService;
	}

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	public BudgetMappingService getBudgetMappingService() {
		return budgetMappingService;
	}

	public void setBudgetMappingService(BudgetMappingService budgetMappingService) {
		this.budgetMappingService = budgetMappingService;
	}

	public ExpenditureService getExpenditureService() {
		return expenditureService;
	}

	public void setExpenditureService(ExpenditureService expenditureService) {
		this.expenditureService = expenditureService;
	}

}
