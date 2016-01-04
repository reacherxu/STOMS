package com.stoms.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import com.stoms.dao.ItemDAO;
import com.stoms.dao.NationalFundAdjustDAO;
import com.stoms.dao.NationalFundBudgetDAO;
import com.stoms.dao.NationalFundBudgetSumDAO;
import com.stoms.dao.NationalFundItemDAO;
import com.stoms.model.Department;
import com.stoms.model.Item;
import com.stoms.model.NationalFundAdjust;
import com.stoms.model.NationalFundBudget;
import com.stoms.model.NationalFundBudgetSum;
import com.stoms.model.NationalFundItem;
import com.stoms.model.ProjectType;
import com.stoms.model.Teacher;

import com.stoms.utils.JSONTranslation;


public class BudgetAdjustService {
	
	private NationalFundBudgetDAO nationalFundBudgetDAO;
	private NationalFundItemDAO nationalFundItemDAO;
	private ItemDAO itemDAO;
	private NationalFundAdjustDAO nationalFundAdjustDAO;
	private NationalFundBudgetSumDAO nationalFundBudgetSumDAO;
	
	
	//获取所有教师提交的待审批的预算调整
	public List acquireAllUnAuditedBudgetAdjustment(){
		
		List tempBudgetAdjustList = nationalFundAdjustDAO.findByNstatus("11");

		return tempBudgetAdjustList;
	}

	
	//获取具体的要审批的预算调整信息
	public String acquireBudgetAdjustmentDetail(long nationalFundAdjustPk, long itemPK){
		String result = "";
		
		//根据itemPK在Item表中查找相应的对象
		Item item = itemDAO.findById(itemPK);
		if (item == null) {
			return "";
		}
		String[] excludes = {"projectType","teacher","department"};
		String itemInfo = JSONTranslation.objectToJson(item, excludes);
		

		//根据itemPK在NationalFundItem表中查找相应的对象
		List nationalFundItemList = nationalFundItemDAO.findByItemPk(itemPK);		
		if(nationalFundItemList == null || nationalFundItemList.size() == 0) {
			return "";				
		}
		
		NationalFundItem nationalFundItem = (NationalFundItem)nationalFundItemList.get(0);
		String[] itemExcludes = {};
		String nationalFundItemInfo = JSONTranslation.objectToJson(nationalFundItem, itemExcludes);
		 
		//根据itemPK在NationalFundBudget表中查找相应的对象
		List nationalFundBudgetList = nationalFundBudgetDAO.findByItemPk(itemPK);
			
		if(nationalFundBudgetList == null || nationalFundBudgetList.size() == 0) {
			return "";	
		}
			
		NationalFundBudget nationalFundBudget = (NationalFundBudget)nationalFundBudgetList.get(0);
		String[] budgetExcludes = {};
		String nationalFundBudgetInfo = JSONTranslation.objectToJson(nationalFundBudget, budgetExcludes);
		

		//根据nationalFundAdjustPk在NationalFundAdjust表里查预算调整	
		NationalFundAdjust nationalFundAdjust = nationalFundAdjustDAO.findById(nationalFundAdjustPk);
		if(nationalFundAdjust == null){
			return "";
		}
		String[] adjustExcludes = {"projectType","teacher","department"};
		String nationalFundAdjustInfo = JSONTranslation.objectToJson(nationalFundAdjust, adjustExcludes);
		

        JSONObject jsonObject = new JSONObject();
    	jsonObject.element("itemInfo", itemInfo);
		jsonObject.element("nationalFundItemInfo", nationalFundItemInfo);
		jsonObject.element("nationalFundBudgetInfo", nationalFundBudgetInfo);
		jsonObject.element("nationalFundAdjustInfo", nationalFundAdjustInfo);
		result = jsonObject.toString();
				
		return result;
		
	}
	
	
	
	//审批通过，保存预算总经费到预算表
	public boolean budgetAdjustmentAuditPass(Long nationalFundAdjustPk,Long itemPK,
			Double studyFund_BudgetSum,Double sumBusiness_BudgetSum, Double testCost_BudgetSum, Double fuelCost_BudgetSum, 
			Double conferenceCost_BudgetSum,Double publishCost_BudgetSum,Double otherBusiness_BudgetSum,Double sumMaterial_BudgetSum,
			Double rawMaterial_BudgetSum,Double otherMaterial_BudgetSum,Double sumEquipment_BudgetSum,Double buyEquipment_BudgetSum,
			Double trialEquipment_BudgetSum,Double laboratory_BudgetSum,Double cooperation_BudgetSum,Double exchangeSum_BudgetSum,
			Double exchange_BudgetSum,Double expert_BudgetSum,Double serviceCost_BudgetSum,Double manageCost_BudgetSum,Double sums_BudgetSum,String suggestion){
		
		boolean result = true;
		
		
		//根据itemPK在NationalFundBudget表中查找相应的对象
		List nationalFundBudgetList = nationalFundBudgetDAO.findByItemPk(itemPK);
		
		if(nationalFundBudgetList == null || nationalFundBudgetList.size() == 0) {
			return false;	
		}			
		NationalFundBudget nationalFundBudget = (NationalFundBudget)nationalFundBudgetList.get(0);
				
		//保存预算总经费
		nationalFundBudget.setStudyFund(studyFund_BudgetSum);		
		nationalFundBudget.setSumBusiness(sumBusiness_BudgetSum);
		nationalFundBudget.setTestCost(testCost_BudgetSum);
		nationalFundBudget.setFuelCost(fuelCost_BudgetSum);
		nationalFundBudget.setConferenceCost(conferenceCost_BudgetSum);
		nationalFundBudget.setPublishCost(publishCost_BudgetSum);
		nationalFundBudget.setOtherBusiness(otherBusiness_BudgetSum);
		nationalFundBudget.setSumMaterial(sumMaterial_BudgetSum);
		nationalFundBudget.setRawMaterial(rawMaterial_BudgetSum);
		nationalFundBudget.setOtherMaterial(otherMaterial_BudgetSum);
		nationalFundBudget.setSumEquipment(sumEquipment_BudgetSum);
		nationalFundBudget.setBuyEquipment(buyEquipment_BudgetSum);
		nationalFundBudget.setTrialEquipment(trialEquipment_BudgetSum);
		nationalFundBudget.setLaboratory(laboratory_BudgetSum);
		nationalFundBudget.setCooperation(cooperation_BudgetSum);
		nationalFundBudget.setExchangeSum(exchangeSum_BudgetSum);
		nationalFundBudget.setExchange(exchange_BudgetSum);
		nationalFundBudget.setExpert(expert_BudgetSum);
		nationalFundBudget.setServiceCost(serviceCost_BudgetSum);
		nationalFundBudget.setManageCost(manageCost_BudgetSum);
		nationalFundBudget.setSums(sums_BudgetSum);
		
		nationalFundBudgetDAO.attachDirty(nationalFundBudget);
		
		
		
		//在调整表里改状态
		NationalFundAdjust nationalFundAdjust = nationalFundAdjustDAO.findById(nationalFundAdjustPk);
		if(nationalFundAdjust == null) {
			return false;
		}	
	
		nationalFundAdjust.setSuggestion(suggestion);
		nationalFundAdjust.setNstatus("31");			
		nationalFundAdjustDAO.attachDirty(nationalFundAdjust);
				
		return result;
		
	}
	
	

	//审批不通过
	public boolean budgetAdjustmentAuditReject(Long nationalFundAdjustPk,String suggestion){
		
		boolean result = true;
		
		//在调整表里改状态
		NationalFundAdjust nationalFundAdjust = nationalFundAdjustDAO.findById(nationalFundAdjustPk);
		if(nationalFundAdjust == null) {
			return false;
		}	
	
		nationalFundAdjust.setSuggestion(suggestion);
		nationalFundAdjust.setNstatus("30");			
		nationalFundAdjustDAO.attachDirty(nationalFundAdjust);
				
		return result;
		
	}

	//setters&getters
	public NationalFundBudgetDAO getNationalFundBudgetDAO() {
		return nationalFundBudgetDAO;
	}


	public void setNationalFundBudgetDAO(NationalFundBudgetDAO nationalFundBudgetDAO) {
		this.nationalFundBudgetDAO = nationalFundBudgetDAO;
	}


	public NationalFundItemDAO getNationalFundItemDAO() {
		return nationalFundItemDAO;
	}


	public void setNationalFundItemDAO(NationalFundItemDAO nationalFundItemDAO) {
		this.nationalFundItemDAO = nationalFundItemDAO;
	}


	public ItemDAO getItemDAO() {
		return itemDAO;
	}


	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}


	public NationalFundAdjustDAO getNationalFundAdjustDAO() {
		return nationalFundAdjustDAO;
	}


	public void setNationalFundAdjustDAO(NationalFundAdjustDAO nationalFundAdjustDAO) {
		this.nationalFundAdjustDAO = nationalFundAdjustDAO;
	}


	public NationalFundBudgetSumDAO getNationalFundBudgetSumDAO() {
		return nationalFundBudgetSumDAO;
	}


	public void setNationalFundBudgetSumDAO(
			NationalFundBudgetSumDAO nationalFundBudgetSumDAO) {
		this.nationalFundBudgetSumDAO = nationalFundBudgetSumDAO;
	}
	
	

}
