package com.stoms.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import net.sf.json.JSONObject;

import com.stoms.dao.A863adjustDAO;
import com.stoms.dao.A863njubudgetDAO;
import com.stoms.dao.ItemDAO;
import com.stoms.model.A863adjust;
import com.stoms.model.A863njubudget;
import com.stoms.model.Item;
import com.stoms.model.NationalFundAdjust;
import com.stoms.utils.JSONTranslation;

public class A863adjustService {
	
	
	private A863njubudgetDAO a863njubudgetDAO;
	private A863adjustDAO a863adjustDAO;
	private ItemDAO itemDAO;
	
	

	//获取预算调整信息
	public String acquire863AdjustInfo(long a863adjustPk, long itemPK){
		String result = "";
		
		//根据itemPK在A863njubudget表中查找相应的对象
		List a863NJUBudgetList = a863njubudgetDAO.findByItemPk(itemPK);
		
		A863njubudget a863njubudget = new A863njubudget();
		if(a863NJUBudgetList != null && a863NJUBudgetList.size() > 0) {
			a863njubudget = (A863njubudget)a863NJUBudgetList.get(0);
		}
		
		String[] budgetExcludes = {};
		String a863NJUBudgetInfo = JSONTranslation.objectToJson(a863njubudget, budgetExcludes);
		
		//根据a863adjustPk在A863adjust表里查预算调整			
		A863adjust a863adjust = a863adjustDAO.findById(a863adjustPk);
		if (a863adjust == null){
			a863adjust = new A863adjust();
		}
			
		String[] adjustExcludes = {};
		String a863adjustInfo = JSONTranslation.objectToJson(a863adjust, adjustExcludes);
		

        JSONObject jsonObject = new JSONObject();
    	jsonObject.element("a863NJUBudgetInfo", a863NJUBudgetInfo);
		jsonObject.element("a863adjustInfo", a863adjustInfo);
		result = jsonObject.toString();		
		
		return result;
		
	}
	
	//保存调整
	public boolean save863Adjust(Long a863adjustPk,Long itemPK,
			Double costSum_adjust, Double equipmentCost_adjust, Double materialCost_adjust, Double testCost_adjust, 
			Double fuelCost_adjust,Double travelCost_adjust, Double conferenceCost_adjust, Double exchangeCost_adjust, 
			Double publishCost_adjust,Double serviceCost_adjust,Double consultCost_adjust,Double indirectCost_adjust,
			Double otherCost_adjust,String ntime){
		
		boolean result = true;
		
		//保存调整数据
		A863adjust a863adjust = a863adjustDAO.findById(a863adjustPk);
		
		if(a863adjust == null) {
			a863adjust = new A863adjust();
			
		}
		
		Item tempItem = itemDAO.findById(itemPK);
		
		if(tempItem == null) {
			return false;
		} else {
			a863adjust.setItem(tempItem);
		}
		a863adjust.setItemPk2(itemPK);
		a863adjust.setCostSum(costSum_adjust);
		a863adjust.setEquipmentCost(equipmentCost_adjust);
		a863adjust.setMaterialCost(materialCost_adjust);
		a863adjust.setTestCost(testCost_adjust);
		a863adjust.setFuelCost(fuelCost_adjust);
		a863adjust.setTravelCost(travelCost_adjust);
		a863adjust.setConferenceCost(conferenceCost_adjust);
		a863adjust.setExchangeCost(exchangeCost_adjust);
		a863adjust.setPublishCost(publishCost_adjust);
		a863adjust.setServiceCost(serviceCost_adjust);
		a863adjust.setConsultCost(consultCost_adjust);
		a863adjust.setIndirectCost(indirectCost_adjust);
		a863adjust.setOtherCost(otherCost_adjust);
		a863adjust.setNtime(ntime);
		a863adjust.setNstatus("10");
		
		a863adjustDAO.attachDirty(a863adjust);
		
		return result;
	}

	
	
	//提交调整
	public boolean submit863Adjust(Long a863adjustPk,Long itemPK,
			Double costSum_adjust, Double equipmentCost_adjust, Double materialCost_adjust, Double testCost_adjust, 
			Double fuelCost_adjust,Double travelCost_adjust, Double conferenceCost_adjust, Double exchangeCost_adjust, 
			Double publishCost_adjust,Double serviceCost_adjust,Double consultCost_adjust,Double indirectCost_adjust,
			Double otherCost_adjust,String ntime){
		
		boolean result = true;
		
		//保存调整数据
		A863adjust a863adjust = a863adjustDAO.findById(a863adjustPk);
		
		if(a863adjust == null) {
			a863adjust = new A863adjust();
			
		}
		
		Item tempItem = itemDAO.findById(itemPK);
		
		if(tempItem == null) {
			return false;
		} else {
			a863adjust.setItem(tempItem);
		}
		a863adjust.setItemPk2(itemPK);
		a863adjust.setCostSum(costSum_adjust);
		a863adjust.setEquipmentCost(equipmentCost_adjust);
		a863adjust.setMaterialCost(materialCost_adjust);
		a863adjust.setTestCost(testCost_adjust);
		a863adjust.setFuelCost(fuelCost_adjust);
		a863adjust.setTravelCost(travelCost_adjust);
		a863adjust.setConferenceCost(conferenceCost_adjust);
		a863adjust.setExchangeCost(exchangeCost_adjust);
		a863adjust.setPublishCost(publishCost_adjust);
		a863adjust.setServiceCost(serviceCost_adjust);
		a863adjust.setConsultCost(consultCost_adjust);
		a863adjust.setIndirectCost(indirectCost_adjust);
		a863adjust.setOtherCost(otherCost_adjust);
		a863adjust.setNtime(ntime);
		a863adjust.setNstatus("11");
		
		a863adjustDAO.attachDirty(a863adjust);
		
		return result;
	}

	//预算调整list
	public List acquireAll863AdjustList(long itemPK){
			
			//根据itemPK在A863adjust表里查所有的预算调整
			List all863AdjustList = a863adjustDAO.findByItemPk2(itemPK);
			
			return all863AdjustList;
		
		}
	
	
	//获取所有教师提交的待审批的预算调整
	public List acquireAllUnAudited863Adjust(){
		
		List tempBudgetAdjustList = a863adjustDAO.findByNstatus("11");

		return tempBudgetAdjustList;
	}

		
	
	//审批通过，保存预算总经费到预算表
	@Transactional
	public boolean A863AdjustAuditPass(Long a863adjustPk,Long itemPK,
			Double costSum_after, Double equipmentCost_after, Double materialCost_after, Double testCost_after, 
			Double fuelCost_after,Double travelCost_after, Double conferenceCost_after, Double exchangeCost_after, 
			Double publishCost_after,Double serviceCost_after,Double consultCost_after,Double indirectCost_after,
			Double otherCost_after,String suggestion){
		
		boolean result = true;
		
		//根据itemPK在A863njubudget表中查找相应的对象
		List a863NJUBudgetList = a863njubudgetDAO.findByItemPk(itemPK);
		
		A863njubudget a863njubudget = new A863njubudget();
		if(a863NJUBudgetList != null && a863NJUBudgetList.size() > 0) {
			a863njubudget = (A863njubudget)a863NJUBudgetList.get(0);
		}
		
		a863njubudget.setItemPk(itemPK);
		a863njubudget.setCostSum(costSum_after);
		a863njubudget.setEquipmentCost(equipmentCost_after);
		a863njubudget.setMaterialCost(materialCost_after);
		a863njubudget.setTestCost(testCost_after);
		a863njubudget.setFuelCost(fuelCost_after);
		a863njubudget.setTravelCost(travelCost_after);
		a863njubudget.setConferenceCost(conferenceCost_after);
		a863njubudget.setExchangeCost(exchangeCost_after);
		a863njubudget.setPublishCost(publishCost_after);
		a863njubudget.setServiceCost(serviceCost_after);
		a863njubudget.setConsultCost(consultCost_after);
		a863njubudget.setIndirectCost(indirectCost_after);
		a863njubudget.setOtherCost(otherCost_after);
				
		a863njubudgetDAO.attachDirty(a863njubudget);
		
		//在调整表里改状态,存审批意见
		A863adjust a863adjust = a863adjustDAO.findById(a863adjustPk);
		if(a863adjust == null) {
			return false;
		}	
	
		a863adjust.setSuggestion(suggestion);
		a863adjust.setNstatus("31");			
		a863adjustDAO.attachDirty(a863adjust);
				
		
		return result;
		
	}
	
	
	//审批不通过
	public boolean A863AdjustAuditReject(Long a863adjustPk,String suggestion){
		
		boolean result = true;
		
		//在调整表里改状态,,存审批意见
		A863adjust a863adjust = a863adjustDAO.findById(a863adjustPk);
		if(a863adjust == null) {
			return false;
		}	
	
		a863adjust.setSuggestion(suggestion);
		a863adjust.setNstatus("30");			
		a863adjustDAO.attachDirty(a863adjust);
				
		return result;
		
	}
	
	
//setters&getters
	public A863njubudgetDAO getA863njubudgetDAO() {
		return a863njubudgetDAO;
	}



	public void setA863njubudgetDAO(A863njubudgetDAO a863njubudgetDAO) {
		this.a863njubudgetDAO = a863njubudgetDAO;
	}



	public A863adjustDAO getA863adjustDAO() {
		return a863adjustDAO;
	}



	public void setA863adjustDAO(A863adjustDAO a863adjustDAO) {
		this.a863adjustDAO = a863adjustDAO;
	}

	public ItemDAO getItemDAO() {
		return itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	
	

}
