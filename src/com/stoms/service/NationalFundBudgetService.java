package com.stoms.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import com.stoms.dao.ItemDAO;
import com.stoms.dao.NationalFundAdjustDAO;
import com.stoms.dao.NationalFundBudgetDAO;
import com.stoms.dao.NationalFundBudgetRemarkDAO;
import com.stoms.dao.NationalFundBudgetSumDAO;
import com.stoms.dao.NationalFundItemDAO;
import com.stoms.model.Department;
import com.stoms.model.Item;
import com.stoms.model.NationalFundAdjust;
import com.stoms.model.NationalFundBudget;
import com.stoms.model.NationalFundBudgetRemark;
import com.stoms.model.NationalFundBudgetSum;
import com.stoms.model.NationalFundItem;
import com.stoms.model.NationalFundRemark;
import com.stoms.model.ProjectType;
import com.stoms.model.Teacher;
import com.stoms.model.TeacherAuthority;

import com.stoms.utils.JSONTranslation;

public class NationalFundBudgetService {
	
	private NationalFundBudgetDAO nationalFundBudgetDAO;
	private NationalFundItemDAO nationalFundItemDAO;
	private ItemDAO itemDAO;
	private NationalFundAdjustDAO nationalFundAdjustDAO;
	private NationalFundBudgetSumDAO nationalFundBudgetSumDAO;
	private NationalFundBudgetRemarkDAO nationalFundBudgetRemarkDAO;
	
	
	//获得预算信息和说明
	public String acquireNationalFundInfo(long itemPK){
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
		
		NationalFundItem nationalFundItem = new NationalFundItem();
		if(nationalFundItemList != null && nationalFundItemList.size() > 0) {
			nationalFundItem = (NationalFundItem)nationalFundItemList.get(0);
		}
		
		 String[] itemExcludes = {"nationalFundItemPk","itemPk"};
		 String nationalFundItemInfo = JSONTranslation.objectToJson(nationalFundItem, itemExcludes);
		
		//根据itemPK在NationalFundBudget表中查找相应的对象
		List nationalFundBudgetList = nationalFundBudgetDAO.findByItemPk(itemPK);
		
		NationalFundBudget nationalFundBudget = new NationalFundBudget();
		if(nationalFundBudgetList != null && nationalFundBudgetList.size() > 0) {
			nationalFundBudget = (NationalFundBudget)nationalFundBudgetList.get(0);
		}
		
		String[] budgetExcludes = {"nationalFundBudgetPk","itemPk","itemId"};
		String nationalFundBudgetInfo = JSONTranslation.objectToJson(nationalFundBudget, budgetExcludes);
		
		
		//根据itemPK在NationalFundBudgetRemark表中查找相应的对象
		List nationalFundBudgetRemarkList = nationalFundBudgetRemarkDAO.findByItemPk(itemPK);
		
		NationalFundBudgetRemark nationalFundBudgetRemark = new NationalFundBudgetRemark();
		if(nationalFundBudgetRemarkList != null && nationalFundBudgetRemarkList.size() > 0) {
			nationalFundBudgetRemark = (NationalFundBudgetRemark)nationalFundBudgetRemarkList.get(0);
		}
		
		String[] budgetRemarkExcludes = {};
		String nationalFundBudgetRemarkInfo = JSONTranslation.objectToJson(nationalFundBudgetRemark, budgetRemarkExcludes);
		
		 
        JSONObject jsonObject = new JSONObject();
    	jsonObject.element("itemInfo", itemInfo);
		jsonObject.element("nationalFundItemInfo", nationalFundItemInfo);
		jsonObject.element("nationalFundBudgetInfo", nationalFundBudgetInfo);
		jsonObject.element("nationalFundBudgetRemarkInfo", nationalFundBudgetRemarkInfo);
		result = jsonObject.toString();
				
		return result;
		
	}
	
	//保存预算数据
	public boolean saveNationalFundBudgetInfo(Long itemPK, String itemName, String teacherName,
			String approveId, Double dialFundsSum, Double otherPlanFundsBuget, Double otherSubsidizeBuget, Double otherSumBuget, 
			Double studyFund,Double sumBusiness, Double testCost, Double fuelCost, Double conferenceCost,Double publishCost,
			Double otherBusiness,Double sumMaterial,Double rawMaterial,Double otherMaterial,Double sumEquipment,
			Double buyEquipment,Double trialEquipment,Double laboratory,Double cooperation,Double exchangeSum,Double exchange,
			Double expert,Double serviceCost,Double manageCost,Double sums,String studyFund_Remark,String sumBusiness_Remark, String testCost_Remark, String fuelCost_Remark, 
			String conferenceCost_Remark,String publishCost_Remark,String otherBusiness_Remark,String sumMaterial_Remark,
			String rawMaterial_Remark,String otherMaterial_Remark,String sumEquipment_Remark,String buyEquipment_Remark,
			String trialEquipment_Remark,String laboratory_Remark,String cooperation_Remark,String exchangeSum_Remark,
			String exchange_Remark,String expert_Remark,String serviceCost_Remark,String manageCost_Remark,String sums_Remark){
		
		boolean result = true;
		
		//保存NationalFundItem
		List nationalFundItemList = nationalFundItemDAO.findByItemPk(itemPK);
		
		NationalFundItem nationalFundItem = new NationalFundItem();
		if(nationalFundItemList != null && nationalFundItemList.size() > 0) {
			nationalFundItem = (NationalFundItem)nationalFundItemList.get(0);
		}
		
		nationalFundItem.setItemPk(itemPK);
		nationalFundItem.setItemName(itemName);
		nationalFundItem.setTeacherName(teacherName);
		nationalFundItem.setApproveId(approveId);
		nationalFundItem.setDialFundsSum(dialFundsSum);
		nationalFundItem.setOtherPlanFundsBuget(otherPlanFundsBuget);
		nationalFundItem.setOtherSubsidizeBuget(otherSubsidizeBuget);
		nationalFundItem.setOtherSumBuget(otherSumBuget);
		
		nationalFundItemDAO.attachDirty(nationalFundItem);
		
		//保存NationalFundBudget
		List nationalFundBudgetList = nationalFundBudgetDAO.findByItemPk(itemPK);
		
		NationalFundBudget nationalFundBudget = new NationalFundBudget();
		if(nationalFundBudgetList != null && nationalFundBudgetList.size() > 0) {
			nationalFundBudget = (NationalFundBudget)nationalFundBudgetList.get(0);
		}
		nationalFundBudget.setItemPk(itemPK);
		nationalFundBudget.setStudyFund(studyFund);
		nationalFundBudget.setSumBusiness(sumBusiness);
		nationalFundBudget.setTestCost(testCost);
		nationalFundBudget.setFuelCost(fuelCost);
		nationalFundBudget.setConferenceCost(conferenceCost);
		nationalFundBudget.setPublishCost(publishCost);
		nationalFundBudget.setOtherBusiness(otherBusiness);
		nationalFundBudget.setSumMaterial(sumMaterial);
		nationalFundBudget.setRawMaterial(rawMaterial);
		nationalFundBudget.setOtherMaterial(otherMaterial);
		nationalFundBudget.setSumEquipment(sumEquipment);
		nationalFundBudget.setBuyEquipment(buyEquipment);
		nationalFundBudget.setTrialEquipment(trialEquipment);
		nationalFundBudget.setLaboratory(laboratory);
		nationalFundBudget.setCooperation(cooperation);
		nationalFundBudget.setExchangeSum(exchangeSum);
		nationalFundBudget.setExchange(exchange);
		nationalFundBudget.setExpert(expert);
		nationalFundBudget.setServiceCost(serviceCost);
		nationalFundBudget.setManageCost(manageCost);
		nationalFundBudget.setSums(sums);
		nationalFundBudget.setNstatus("10");
		
		nationalFundBudgetDAO.attachDirty(nationalFundBudget);		
		
		//根据itemPK在NationalFundBudgetRemark表中查找相应的对象
		List nationalFundBudgetRemarkList = nationalFundBudgetRemarkDAO.findByItemPk(itemPK);
		
		NationalFundBudgetRemark nationalFundBudgetRemark = new NationalFundBudgetRemark();
		if(nationalFundBudgetRemarkList != null && nationalFundBudgetRemarkList.size() > 0) {
			nationalFundBudgetRemark = (NationalFundBudgetRemark)nationalFundBudgetRemarkList.get(0);
		}
		    
		    nationalFundBudgetRemark.setItemPk(itemPK);
		    nationalFundBudgetRemark.setStudyFund(studyFund_Remark);		
		    nationalFundBudgetRemark.setSumBusiness(sumBusiness_Remark);
		    nationalFundBudgetRemark.setTestCost(testCost_Remark);
		    nationalFundBudgetRemark.setFuelCost(fuelCost_Remark);
		    nationalFundBudgetRemark.setConferenceCost(conferenceCost_Remark);
			nationalFundBudgetRemark.setPublishCost(publishCost_Remark);
			nationalFundBudgetRemark.setOtherBusiness(otherBusiness_Remark);
			nationalFundBudgetRemark.setSumMaterial(sumMaterial_Remark);
			nationalFundBudgetRemark.setRawMaterial(rawMaterial_Remark);
			nationalFundBudgetRemark.setOtherMaterial(otherMaterial_Remark);
			nationalFundBudgetRemark.setSumEquipment(sumEquipment_Remark);
			nationalFundBudgetRemark.setBuyEquipment(buyEquipment_Remark);
			nationalFundBudgetRemark.setTrialEquipment(trialEquipment_Remark);
			nationalFundBudgetRemark.setLaboratory(laboratory_Remark);
			nationalFundBudgetRemark.setCooperation(cooperation_Remark);
			nationalFundBudgetRemark.setExchangeSum(exchangeSum_Remark);
			nationalFundBudgetRemark.setExchange(exchange_Remark);
			nationalFundBudgetRemark.setExpert(expert_Remark);
			nationalFundBudgetRemark.setServiceCost(serviceCost_Remark);
			nationalFundBudgetRemark.setManageCost(manageCost_Remark);
			nationalFundBudgetRemark.setSums(sums_Remark);
			
			nationalFundBudgetRemarkDAO.attachDirty(nationalFundBudgetRemark);
			
		return result;
	}
	
	

	//提交预算数据
	public boolean submitNationalFundBudgetInfo(Long itemPK, String itemName, String teacherName,
			String approveId, Double dialFundsSum, Double otherPlanFundsBuget, Double otherSubsidizeBuget, Double otherSumBuget, 
			Double studyFund,Double sumBusiness, Double testCost, Double fuelCost, Double conferenceCost,Double publishCost,
			Double otherBusiness,Double sumMaterial,Double rawMaterial,Double otherMaterial,Double sumEquipment,
			Double buyEquipment,Double trialEquipment,Double laboratory,Double cooperation,Double exchangeSum,Double exchange,
			Double expert,Double serviceCost,Double manageCost,Double sums){
		
		boolean result = true;
		
		//提交NationalFundItem
		List nationalFundItemList = nationalFundItemDAO.findByItemPk(itemPK);
		
		NationalFundItem nationalFundItem = new NationalFundItem();
		if(nationalFundItemList != null && nationalFundItemList.size() > 0) {
			nationalFundItem = (NationalFundItem)nationalFundItemList.get(0);
		}
		nationalFundItem.setItemPk(itemPK);
		nationalFundItem.setItemName(itemName);
		nationalFundItem.setTeacherName(teacherName);
		nationalFundItem.setApproveId(approveId);
		nationalFundItem.setDialFundsSum(dialFundsSum);
		nationalFundItem.setOtherPlanFundsBuget(otherPlanFundsBuget);
		nationalFundItem.setOtherSubsidizeBuget(otherSubsidizeBuget);
		nationalFundItem.setOtherSumBuget(otherSumBuget);
		
		nationalFundItemDAO.attachDirty(nationalFundItem);
		
		//提交NationalFundBudget
		List nationalFundBudgetList = nationalFundBudgetDAO.findByItemPk(itemPK);
		
		NationalFundBudget nationalFundBudget = new NationalFundBudget();
		if(nationalFundBudgetList != null && nationalFundBudgetList.size() > 0) {
			nationalFundBudget = (NationalFundBudget)nationalFundBudgetList.get(0);
		}
		nationalFundBudget.setItemPk(itemPK);
		nationalFundBudget.setStudyFund(studyFund);
		nationalFundBudget.setSumBusiness(sumBusiness);
		nationalFundBudget.setTestCost(testCost);
		nationalFundBudget.setFuelCost(fuelCost);
		nationalFundBudget.setConferenceCost(conferenceCost);
		nationalFundBudget.setPublishCost(publishCost);
		nationalFundBudget.setOtherBusiness(otherBusiness);
		nationalFundBudget.setSumMaterial(sumMaterial);
		nationalFundBudget.setRawMaterial(rawMaterial);
		nationalFundBudget.setOtherMaterial(otherMaterial);
		nationalFundBudget.setSumEquipment(sumEquipment);
		nationalFundBudget.setBuyEquipment(buyEquipment);
		nationalFundBudget.setTrialEquipment(trialEquipment);
		nationalFundBudget.setLaboratory(laboratory);
		nationalFundBudget.setCooperation(cooperation);
		nationalFundBudget.setExchangeSum(exchangeSum);
		nationalFundBudget.setExchange(exchange);
		nationalFundBudget.setExpert(expert);
		nationalFundBudget.setServiceCost(serviceCost);
		nationalFundBudget.setManageCost(manageCost);
		nationalFundBudget.setSums(sums);
		nationalFundBudget.setNstatus("11");
		
		nationalFundBudgetDAO.attachDirty(nationalFundBudget);		
				
		return result;
				
	}
	
	
	
	//获取预算调整信息
	public String acquireNationalFundBudgetAdjust(long nationalFundAdjustPk, long itemPK){
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
		
		NationalFundItem nationalFundItem = new NationalFundItem();
		if(nationalFundItemList != null && nationalFundItemList.size() > 0) {
			nationalFundItem = (NationalFundItem)nationalFundItemList.get(0);
		}
		
		 String[] itemExcludes = {"nationalFundItemPk","itemPk"};
		 String nationalFundItemInfo = JSONTranslation.objectToJson(nationalFundItem, itemExcludes);
		
		//根据itemPK在NationalFundBudget表中查找相应的对象
		List nationalFundBudgetList = nationalFundBudgetDAO.findByItemPk(itemPK);
		
		NationalFundBudget nationalFundBudget = new NationalFundBudget();
		if(nationalFundBudgetList != null && nationalFundBudgetList.size() > 0) {
			nationalFundBudget = (NationalFundBudget)nationalFundBudgetList.get(0);
		}
		
		String[] budgetExcludes = {"nationalFundBudgetPk","itemPk","itemId"};
		String nationalFundBudgetInfo = JSONTranslation.objectToJson(nationalFundBudget, budgetExcludes);
		
		
		//根据nationalFundAdjustPk在NationalFundAdjust表里查预算调整			
		NationalFundAdjust nationalFundAdjust = nationalFundAdjustDAO.findById(nationalFundAdjustPk);
		if (nationalFundAdjust == null){
			nationalFundAdjust = new NationalFundAdjust();
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
	
	public List acquireAllNationalFundAdjustList(long itemPK){
		
		//根据itemPK在NationalFundAdjust表里查所有的预算调整
		List allNationalFundAdjustList = nationalFundAdjustDAO.findByItemPk2(itemPK);
		
		return allNationalFundAdjustList;
	
	}
	
	
	
	
	
	//保存预算调整
	public boolean saveNationalFundBudgetAdjustment(Long nationalFundAdjustPk,Long itemPK,
			Double dialFundsSum, Double otherPlanFundsBuget, Double otherSubsidizeBuget, Double otherSumBuget, 
			Double studyFund_Adjust,Double sumBusiness_Adjust, Double testCost_Adjust, Double fuelCost_Adjust, 
			Double conferenceCost_Adjust,Double publishCost_Adjust,Double otherBusiness_Adjust,Double sumMaterial_Adjust,
			Double rawMaterial_Adjust,Double otherMaterial_Adjust,Double sumEquipment_Adjust,Double buyEquipment_Adjust,
			Double trialEquipment_Adjust,Double laboratory_Adjust,Double cooperation_Adjust,Double exchangeSum_Adjust,
			Double exchange_Adjust,Double expert_Adjust,Double serviceCost_Adjust,Double manageCost_Adjust,Double sums_Adjust,String ntime){
		boolean result = true;
		
		//保存NationalFundItem
		List nationalFundItemList = nationalFundItemDAO.findByItemPk(itemPK);
		
		NationalFundItem nationalFundItem = new NationalFundItem();
		if(nationalFundItemList != null && nationalFundItemList.size() > 0) {
			nationalFundItem = (NationalFundItem)nationalFundItemList.get(0);
		}
		nationalFundItem.setItemPk(itemPK);
		nationalFundItem.setDialFundsSum(dialFundsSum);
		nationalFundItem.setOtherPlanFundsBuget(otherPlanFundsBuget);
		nationalFundItem.setOtherSubsidizeBuget(otherSubsidizeBuget);
		nationalFundItem.setOtherSumBuget(otherSumBuget);
		
		nationalFundItemDAO.attachDirty(nationalFundItem);
		
		//保存调整数据
		
		NationalFundAdjust nationalFundAdjust = nationalFundAdjustDAO.findById(nationalFundAdjustPk);
	
		if(nationalFundAdjust == null) {
			nationalFundAdjust = new NationalFundAdjust();
			
		}
		
		Item tempItem = itemDAO.findById(itemPK);
		
		if(tempItem == null) {
			return false;
		} else {
			nationalFundAdjust.setItem(tempItem);
		}
		nationalFundAdjust.setItemPk2(itemPK);
		nationalFundAdjust.setStudyFund(studyFund_Adjust);		
		nationalFundAdjust.setSumBusiness(sumBusiness_Adjust);
		nationalFundAdjust.setTestCost(testCost_Adjust);
		nationalFundAdjust.setFuelCost(fuelCost_Adjust);
		nationalFundAdjust.setConferenceCost(conferenceCost_Adjust);
		nationalFundAdjust.setPublishCost(publishCost_Adjust);
		nationalFundAdjust.setOtherBusiness(otherBusiness_Adjust);
		nationalFundAdjust.setSumMaterial(sumMaterial_Adjust);
		nationalFundAdjust.setRawMaterial(rawMaterial_Adjust);
		nationalFundAdjust.setOtherMaterial(otherMaterial_Adjust);
		nationalFundAdjust.setSumEquipment(sumEquipment_Adjust);
		nationalFundAdjust.setBuyEquipment(buyEquipment_Adjust);
		nationalFundAdjust.setTrialEquipment(trialEquipment_Adjust);
		nationalFundAdjust.setLaboratory(laboratory_Adjust);
		nationalFundAdjust.setCooperation(cooperation_Adjust);
		nationalFundAdjust.setExchangeSum(exchangeSum_Adjust);
		nationalFundAdjust.setExchange(exchange_Adjust);
		nationalFundAdjust.setExpert(expert_Adjust);
		nationalFundAdjust.setServiceCost(serviceCost_Adjust);
		nationalFundAdjust.setManageCost(manageCost_Adjust);
		nationalFundAdjust.setSums(sums_Adjust);
		nationalFundAdjust.setNstatus("10");
	    nationalFundAdjust.setNtime(ntime);
				
		nationalFundAdjustDAO.attachDirty(nationalFundAdjust);
		
		return result;
		
	}
	
	
	
	//提交预算调整与预算总经费
	public boolean submitNationalFundBudgetAdjustment(Long nationalFundAdjustPk,Long itemPK,
			Double dialFundsSum, Double otherPlanFundsBuget, Double otherSubsidizeBuget, Double otherSumBuget, 
			Double studyFund_Adjust,Double sumBusiness_Adjust, Double testCost_Adjust, Double fuelCost_Adjust, 
			Double conferenceCost_Adjust,Double publishCost_Adjust,Double otherBusiness_Adjust,Double sumMaterial_Adjust,
			Double rawMaterial_Adjust,Double otherMaterial_Adjust,Double sumEquipment_Adjust,Double buyEquipment_Adjust,
			Double trialEquipment_Adjust,Double laboratory_Adjust,Double cooperation_Adjust,Double exchangeSum_Adjust,
			Double exchange_Adjust,Double expert_Adjust,Double serviceCost_Adjust,Double manageCost_Adjust,Double sums_Adjust,String ntime,
			Double studyFund_BudgetSum,Double sumBusiness_BudgetSum, Double testCost_BudgetSum, Double fuelCost_BudgetSum, 
			Double conferenceCost_BudgetSum,Double publishCost_BudgetSum,Double otherBusiness_BudgetSum,Double sumMaterial_BudgetSum,
			Double rawMaterial_BudgetSum,Double otherMaterial_BudgetSum,Double sumEquipment_BudgetSum,Double buyEquipment_BudgetSum,
			Double trialEquipment_BudgetSum,Double laboratory_BudgetSum,Double cooperation_BudgetSum,Double exchangeSum_BudgetSum,
			Double exchange_BudgetSum,Double expert_BudgetSum,Double serviceCost_BudgetSum,Double manageCost_BudgetSum,Double sums_BudgetSum){
		boolean result = true;
		
		//提交NationalFundItem
		List nationalFundItemList = nationalFundItemDAO.findByItemPk(itemPK);
		
		NationalFundItem nationalFundItem = new NationalFundItem();
		if(nationalFundItemList != null && nationalFundItemList.size() > 0) {
			nationalFundItem = (NationalFundItem)nationalFundItemList.get(0);
		}
		nationalFundItem.setItemPk(itemPK);
		nationalFundItem.setDialFundsSum(dialFundsSum);
		nationalFundItem.setOtherPlanFundsBuget(otherPlanFundsBuget);
		nationalFundItem.setOtherSubsidizeBuget(otherSubsidizeBuget);
		nationalFundItem.setOtherSumBuget(otherSumBuget);
		
		nationalFundItemDAO.attachDirty(nationalFundItem);
		
		//提交调整数据
		NationalFundAdjust nationalFundAdjust = nationalFundAdjustDAO.findById(nationalFundAdjustPk);
		if(nationalFundAdjust == null) {
			nationalFundAdjust = new NationalFundAdjust();
			
		}
		
		Item tempItem = itemDAO.findById(itemPK);
		
		if(tempItem == null) {
			return false;
		} else {
			nationalFundAdjust.setItem(tempItem);
		}
		
		nationalFundAdjust.setItemPk2(itemPK);
		nationalFundAdjust.setStudyFund(studyFund_Adjust);		
		nationalFundAdjust.setSumBusiness(sumBusiness_Adjust);
		nationalFundAdjust.setTestCost(testCost_Adjust);
		nationalFundAdjust.setFuelCost(fuelCost_Adjust);
		nationalFundAdjust.setConferenceCost(conferenceCost_Adjust);
		nationalFundAdjust.setPublishCost(publishCost_Adjust);
		nationalFundAdjust.setOtherBusiness(otherBusiness_Adjust);
		nationalFundAdjust.setSumMaterial(sumMaterial_Adjust);
		nationalFundAdjust.setRawMaterial(rawMaterial_Adjust);
		nationalFundAdjust.setOtherMaterial(otherMaterial_Adjust);
		nationalFundAdjust.setSumEquipment(sumEquipment_Adjust);
		nationalFundAdjust.setBuyEquipment(buyEquipment_Adjust);
		nationalFundAdjust.setTrialEquipment(trialEquipment_Adjust);
		nationalFundAdjust.setLaboratory(laboratory_Adjust);
		nationalFundAdjust.setCooperation(cooperation_Adjust);
		nationalFundAdjust.setExchangeSum(exchangeSum_Adjust);
		nationalFundAdjust.setExchange(exchange_Adjust);
		nationalFundAdjust.setExpert(expert_Adjust);
		nationalFundAdjust.setServiceCost(serviceCost_Adjust);
		nationalFundAdjust.setManageCost(manageCost_Adjust);
		nationalFundAdjust.setSums(sums_Adjust);
		nationalFundAdjust.setNstatus("11");	
		nationalFundAdjust.setNtime(ntime);
				
		nationalFundAdjustDAO.attachDirty(nationalFundAdjust);
		
		//提交预算总经费
		NationalFundBudgetSum nationalFundBudgetSum = new NationalFundBudgetSum();
		
		nationalFundBudgetSum.setItemPk(itemPK);
		nationalFundBudgetSum.setStudyFund(studyFund_BudgetSum);		
		nationalFundBudgetSum.setSumBusiness(sumBusiness_BudgetSum);
		nationalFundBudgetSum.setTestCost(testCost_BudgetSum);
		nationalFundBudgetSum.setFuelCost(fuelCost_BudgetSum);
		nationalFundBudgetSum.setConferenceCost(conferenceCost_BudgetSum);
		nationalFundBudgetSum.setPublishCost(publishCost_BudgetSum);
		nationalFundBudgetSum.setOtherBusiness(otherBusiness_BudgetSum);
		nationalFundBudgetSum.setSumMaterial(sumMaterial_BudgetSum);
		nationalFundBudgetSum.setRawMaterial(rawMaterial_BudgetSum);
		nationalFundBudgetSum.setOtherMaterial(otherMaterial_BudgetSum);
		nationalFundBudgetSum.setSumEquipment(sumEquipment_BudgetSum);
		nationalFundBudgetSum.setBuyEquipment(buyEquipment_BudgetSum);
		nationalFundBudgetSum.setTrialEquipment(trialEquipment_BudgetSum);
		nationalFundBudgetSum.setLaboratory(laboratory_BudgetSum);
		nationalFundBudgetSum.setCooperation(cooperation_BudgetSum);
		nationalFundBudgetSum.setExchangeSum(exchangeSum_BudgetSum);
		nationalFundBudgetSum.setExchange(exchange_BudgetSum);
		nationalFundBudgetSum.setExpert(expert_BudgetSum);
		nationalFundBudgetSum.setServiceCost(serviceCost_BudgetSum);
		nationalFundBudgetSum.setManageCost(manageCost_BudgetSum);
		nationalFundBudgetSum.setSums(sums_BudgetSum);
				
		nationalFundBudgetSumDAO.save(nationalFundBudgetSum);
			
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

	public NationalFundBudgetRemarkDAO getNationalFundBudgetRemarkDAO() {
		return nationalFundBudgetRemarkDAO;
	}

	public void setNationalFundBudgetRemarkDAO(
			NationalFundBudgetRemarkDAO nationalFundBudgetRemarkDAO) {
		this.nationalFundBudgetRemarkDAO = nationalFundBudgetRemarkDAO;
	}
	
	

}


