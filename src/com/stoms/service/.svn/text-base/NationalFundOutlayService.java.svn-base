package com.stoms.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import com.stoms.dao.ItemDAO;
import com.stoms.dao.NationalFundBudgetDAO;
import com.stoms.dao.NationalFundBudgetRemarkDAO;
import com.stoms.dao.NationalFundItemDAO;
import com.stoms.dao.NationalFundOutlayDAO;
import com.stoms.dao.NationalFundRemarkDAO;

import com.stoms.model.Item;
import com.stoms.model.NationalFundBudget;
import com.stoms.model.NationalFundBudgetRemark;
import com.stoms.model.NationalFundItem;
import com.stoms.model.NationalFundOutlay;
import com.stoms.model.NationalFundRemark;
import com.stoms.utils.JSONTranslation;

import com.stoms.service.ColumnSumOutlayService;

public class NationalFundOutlayService {
	
	private NationalFundBudgetDAO nationalFundBudgetDAO;
	private NationalFundItemDAO nationalFundItemDAO;
	private ItemDAO itemDAO;
	private NationalFundOutlayDAO nationalFundOutlayDAO;
	private NationalFundRemarkDAO nationalFundRemarkDAO;
	private ColumnSumOutlayService columnSumOutlayService;
	private NationalFundBudgetRemarkDAO nationalFundBudgetRemarkDAO;
	
	
	
	//获取支出登记信息
	public String acquireNationalFundOutlay(long nationalFundOutlayPk, long itemPK){
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
		
		
		//根据nationalFundOutlayPk在NationalFundOutlay表里查支出		
		NationalFundOutlay nationalFundOutlay = nationalFundOutlayDAO.findById(nationalFundOutlayPk);
		if (nationalFundOutlay == null){
			nationalFundOutlay = new NationalFundOutlay();
		}
			
		String[] outlayExcludes = {};
		String nationalFundOutlayInfo = JSONTranslation.objectToJson(nationalFundOutlay, outlayExcludes);
		
		//根据itemPK在ColumnSumOutlayService里面查总支出
		String[] allOutlayExcludes = {};
		String allNationalFundOutlayInfo = JSONTranslation.arrayToJson(
     			columnSumOutlayService.acquireColumnSumofOutlay(itemPK), allOutlayExcludes);
		
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
		jsonObject.element("nationalFundOutlayInfo", nationalFundOutlayInfo);
		jsonObject.element("allNationalFundOutlayInfo", allNationalFundOutlayInfo);
		jsonObject.element("nationalFundBudgetRemarkInfo", nationalFundBudgetRemarkInfo);
		result = jsonObject.toString();
				
		return result;
		
	}

	
	public List acquireAllNationalFundOutlayList(long itemPK){
		
		//根据itemPK在nationalFundOutlay表里查所有的支出
		List allNationalFundOutlayList = nationalFundOutlayDAO.findByItemPk(itemPK);
		
		return allNationalFundOutlayList;
	
	}
	
	
	//保存支出登记
	public boolean saveNationalFundOutlay(Long nationalFundOutlayPk,Long nationalFundRemarkPk,Long itemPK,
			Double dialFundsLast, Double otherPlanFundsOutlay, Double otherSubsidizeOutlay, Double otherSumOutlay, 
			Double studyFund_Outlay,Double sumBusiness_Outlay, Double testCost_Outlay, Double fuelCost_Outlay, 
			Double conferenceCost_Outlay,Double publishCost_Outlay,Double otherBusiness_Outlay,Double sumMaterial_Outlay,
			Double rawMaterial_Outlay,Double otherMaterial_Outlay,Double sumEquipment_Outlay,Double buyEquipment_Outlay,
			Double trialEquipment_Outlay,Double laboratory_Outlay,Double cooperation_Outlay,Double exchangeSum_Outlay,
			Double exchange_Outlay,Double expert_Outlay,Double serviceCost_Outlay,Double manageCost_Outlay,Double sums_Outlay,
			String studyFund_Remark,String sumBusiness_Remark, String testCost_Remark, String fuelCost_Remark, 
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
		nationalFundItem.setDialFundsLast(dialFundsLast);
		nationalFundItem.setOtherPlanFundsOutlay(otherPlanFundsOutlay);
		nationalFundItem.setOtherSubsidizeOutlay(otherSubsidizeOutlay);
		nationalFundItem.setOtherSumOutlay(otherSumOutlay);
		
		nationalFundItemDAO.attachDirty(nationalFundItem);
		
		//保存支出	
		NationalFundOutlay nationalFundOutlay = nationalFundOutlayDAO.findById(nationalFundOutlayPk);
	
		if(nationalFundOutlay == null) {
			nationalFundOutlay = new NationalFundOutlay();
			
		}
			
		nationalFundOutlay.setItemPk(itemPK);
		nationalFundOutlay.setStudyFund(studyFund_Outlay);		
		nationalFundOutlay.setSumBusiness(sumBusiness_Outlay);
		nationalFundOutlay.setTestCost(testCost_Outlay);
		nationalFundOutlay.setFuelCost(fuelCost_Outlay);
		nationalFundOutlay.setConferenceCost(conferenceCost_Outlay);
		nationalFundOutlay.setPublishCost(publishCost_Outlay);
		nationalFundOutlay.setOtherBusiness(otherBusiness_Outlay);
		nationalFundOutlay.setSumMaterial(sumMaterial_Outlay);
		nationalFundOutlay.setRawMaterial(rawMaterial_Outlay);
		nationalFundOutlay.setOtherMaterial(otherMaterial_Outlay);
		nationalFundOutlay.setSumEquipment(sumEquipment_Outlay);
		nationalFundOutlay.setBuyEquipment(buyEquipment_Outlay);
		nationalFundOutlay.setTrialEquipment(trialEquipment_Outlay);
		nationalFundOutlay.setLaboratory(laboratory_Outlay);
		nationalFundOutlay.setCooperation(cooperation_Outlay);
		nationalFundOutlay.setExchangeSum(exchangeSum_Outlay);
		nationalFundOutlay.setExchange(exchange_Outlay);
		nationalFundOutlay.setExpert(expert_Outlay);
		nationalFundOutlay.setServiceCost(serviceCost_Outlay);
		nationalFundOutlay.setManageCost(manageCost_Outlay);
		nationalFundOutlay.setSums(sums_Outlay);
		
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String currentDate = formatter.format(date);
	    nationalFundOutlay.setOutlayTime(currentDate);
	    
	    NationalFundRemark nationalFundRemark = nationalFundRemarkDAO.findById(nationalFundRemarkPk);
	    
	    if (nationalFundRemark == null){
	    	nationalFundRemark = new NationalFundRemark();
	    }
	    
	    nationalFundRemark.setItemPk(itemPK);
	    nationalFundRemark.setStudyFund(studyFund_Remark);		
	    nationalFundRemark.setSumBusiness(sumBusiness_Remark);
	    nationalFundRemark.setTestCost(testCost_Remark);
	    nationalFundRemark.setFuelCost(fuelCost_Remark);
	    nationalFundRemark.setConferenceCost(conferenceCost_Remark);
		nationalFundRemark.setPublishCost(publishCost_Remark);
		nationalFundRemark.setOtherBusiness(otherBusiness_Remark);
		nationalFundRemark.setSumMaterial(sumMaterial_Remark);
		nationalFundRemark.setRawMaterial(rawMaterial_Remark);
		nationalFundRemark.setOtherMaterial(otherMaterial_Remark);
		nationalFundRemark.setSumEquipment(sumEquipment_Remark);
		nationalFundRemark.setBuyEquipment(buyEquipment_Remark);
		nationalFundRemark.setTrialEquipment(trialEquipment_Remark);
		nationalFundRemark.setLaboratory(laboratory_Remark);
		nationalFundRemark.setCooperation(cooperation_Remark);
		nationalFundRemark.setExchangeSum(exchangeSum_Remark);
		nationalFundRemark.setExchange(exchange_Remark);
		nationalFundRemark.setExpert(expert_Remark);
		nationalFundRemark.setServiceCost(serviceCost_Remark);
		nationalFundRemark.setManageCost(manageCost_Remark);
		nationalFundRemark.setSums(sums_Remark);
		
		nationalFundRemarkDAO.attachDirty(nationalFundRemark);
	    
		nationalFundOutlay.setNationalFundRemark(nationalFundRemark);
				
		nationalFundOutlayDAO.attachDirty(nationalFundOutlay);
		
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
	public NationalFundOutlayDAO getNationalFundOutlayDAO() {
		return nationalFundOutlayDAO;
	}

	public void setNationalFundOutlayDAO(NationalFundOutlayDAO nationalFundOutlayDAO) {
		this.nationalFundOutlayDAO = nationalFundOutlayDAO;
	}

	public NationalFundRemarkDAO getNationalFundRemarkDAO() {
		return nationalFundRemarkDAO;
	}
	public void setNationalFundRemarkDAO(NationalFundRemarkDAO nationalFundRemarkDAO) {
		this.nationalFundRemarkDAO = nationalFundRemarkDAO;
	}

	public ColumnSumOutlayService getColumnSumOutlayService() {
		return columnSumOutlayService;
	}

	public void setColumnSumOutlayService(
			ColumnSumOutlayService columnSumOutlayService) {
		this.columnSumOutlayService = columnSumOutlayService;
	}


	public NationalFundBudgetRemarkDAO getNationalFundBudgetRemarkDAO() {
		return nationalFundBudgetRemarkDAO;
	}


	public void setNationalFundBudgetRemarkDAO(
			NationalFundBudgetRemarkDAO nationalFundBudgetRemarkDAO) {
		this.nationalFundBudgetRemarkDAO = nationalFundBudgetRemarkDAO;
	}
	
	
}
