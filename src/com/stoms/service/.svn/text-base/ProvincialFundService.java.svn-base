/**
 * @author xjk
 */

package com.stoms.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.stoms.dao.ActualFundBudgetDAO;
import com.stoms.dao.ActualFundItemDAO;
import com.stoms.dao.ItemDAO;
import com.stoms.model.ActualFundBudget;
import com.stoms.model.ActualFundItem;
import com.stoms.model.Item;
import com.stoms.utils.JSONTranslation;

public class ProvincialFundService {
	
	//实际到位
	private ActualFundItemDAO actualFundItemDAO;
	
	//预算
	private ActualFundBudgetDAO actualFundBudgetDAO;
	
	private ItemDAO itemDAO;
	
	/**
	 * 根据itemPk预读的数据
	 * 如果数据库中没有该数据，则插入新的数据后再取。
	 * 
	 */
	public String acquireProvincialFundInfo(long itemPK){
		String result = "";
		
		//根据itemPK在Item表中查找相应的对象
		Item item = itemDAO.findById(itemPK);
		if (item == null) {
			return "";
		}
		//String[] excludes = {"projectType","teacher","department"};
		String[] excludes = {};
		String itemInfo = JSONTranslation.objectToJson(item, excludes);

		//实际到位
		List actualFundItemList = actualFundItemDAO.findByItemPk(itemPK);
		if( actualFundItemList == null || actualFundItemList.size() == 0) {
			ActualFundItem actualFundItem = new ActualFundItem();
			actualFundItem.setItemPk(itemPK);
			actualFundItemDAO.save(actualFundItem);
			actualFundItemList = actualFundItemDAO.findByItemPk(itemPK);					
		}
		ActualFundItem actualFundItem = (ActualFundItem)actualFundItemList.get(0);
		//String[] itemExcludes = {"itemPk"};
		String actualFundItemInfo = JSONTranslation.objectToJson(actualFundItem, excludes);
		

		//预算
		List actualFundBudgetList = actualFundBudgetDAO.findByItemPk(itemPK);
		if( actualFundBudgetList == null || actualFundBudgetList.size() == 0) {
			ActualFundBudget actualFundBudget = new ActualFundBudget();
			actualFundBudget.setItemPk(itemPK);
			actualFundBudgetDAO.save(actualFundBudget);
			actualFundBudgetList = actualFundBudgetDAO.findByItemPk(itemPK);					
		}
		ActualFundBudget actualFundBudget = (ActualFundBudget)actualFundBudgetList.get(0);
		String actualFundBudgetInfo = JSONTranslation.objectToJson(actualFundBudget, excludes);
		
		
		//封装json返回
        JSONObject jsonObject = new JSONObject();
    	jsonObject.element("itemInfo", itemInfo);
		jsonObject.element("actualFundItemInfo", actualFundItemInfo );
		jsonObject.element("actualFundBudgetInfo", actualFundBudgetInfo );
		result = jsonObject.toString();
				
		return result;
		
	}
	
	private boolean saveOrSumbitProvincialFundInfo(
			Long itemPK, String itemName, String teacherName, String itemId, 
			
			Double actualNationFund, Double actualAgencyFund,Double actualCountyFund, 
			Double actualDepartmentFund,Double actualSelfFund, Double actualOtherFund,Double actualFundTotal,
			
			Double actualFundBudgetStaffCost,Double actualFundBudgetEquipmentCost, Double actualFundBudgetFuelCost,Double actualFundBudgetMaterialCost, 
			Double actualFundBudgetTestCost,Double actualFundBudgetTravelCost, Double actualFundBudgetConferenceCost,Double actualFundBudgetPublishCost, 
			Double actualFundBudgetManageCost,Double actualFundBudgetOtherCost, Double actualFundBudgetTotal,
			
			String status) {
		
		boolean result = true;
		
		//实际到位
		ActualFundItem actualFundItem = (ActualFundItem)actualFundItemDAO.findByItemPk(itemPK).get(0);
		if(actualFundItem == null) {
			return false;
		}
		actualFundItem.setItemName(itemName);
		actualFundItem.setTeacherName(teacherName);
		actualFundItem.setItemId(itemId);
		actualFundItem.setNationFund(actualNationFund);
		actualFundItem.setAgencyFund(actualAgencyFund);
		actualFundItem.setCountyFund(actualCountyFund);
		actualFundItem.setDepartmentFund(actualDepartmentFund);
		actualFundItem.setSelfFund(actualSelfFund);
		actualFundItem.setOtherFund(actualOtherFund);
		actualFundItem.setFundSum(actualFundTotal);
		
		actualFundItemDAO.attachDirty(actualFundItem);
		
		//预算
		ActualFundBudget actualFundBudget = (ActualFundBudget)actualFundBudgetDAO.findByItemPk(itemPK).get(0);
		if(actualFundBudget == null) {
			return false;
		}
		actualFundBudget.setItemId(itemId);
		actualFundBudget.setStaffCost(actualFundBudgetStaffCost);
		actualFundBudget.setEquipmentCost(actualFundBudgetEquipmentCost);
		actualFundBudget.setFuelCost(actualFundBudgetFuelCost);
		actualFundBudget.setMaterialCost(actualFundBudgetMaterialCost);
		actualFundBudget.setTestCost(actualFundBudgetTestCost);
		actualFundBudget.setTravelCost(actualFundBudgetTravelCost);
		actualFundBudget.setConferenceCost(actualFundBudgetConferenceCost);
		actualFundBudget.setPublishCost(actualFundBudgetPublishCost);
		actualFundBudget.setManageCost(actualFundBudgetManageCost);
		actualFundBudget.setOtherCost(actualFundBudgetOtherCost);
		actualFundBudget.setSumCost(actualFundBudgetTotal);
		
		//保存和提交的状态参数
		actualFundBudget.setAstatus(status);
		
		actualFundBudgetDAO.attachDirty(actualFundBudget);

		return result;
	}
	
	/**
	 * 保存数据
	 * 
	 * 在载入预算页面的时候会预读数据,如果发现没有对应itemPk则会插入itemPk对应的预算,则返回false
	 *
	 */
	public boolean saveProvincialFundInfo(
			
			Long itemPK, String itemName, String teacherName, String itemId, 
			
			Double actualNationFund, Double actualAgencyFund,Double actualCountyFund, 
			Double actualDepartmentFund,Double actualSelfFund, Double actualOtherFund,Double actualFundTotal,
			
			Double actualFundBudgetStaffCost,Double actualFundBudgetEquipmentCost, Double actualFundBudgetFuelCost,Double actualFundBudgetMaterialCost, 
			Double actualFundBudgetTestCost,Double actualFundBudgetTravelCost, Double actualFundBudgetConferenceCost,Double actualFundBudgetPublishCost, 
			Double actualFundBudgetManageCost,Double actualFundBudgetOtherCost, Double actualFundBudgetTotal){
		
				return this.saveOrSumbitProvincialFundInfo(
						
						itemPK, itemName, teacherName, itemId,
		
						actualNationFund, actualAgencyFund, actualCountyFund, actualDepartmentFund, 
						actualSelfFund, actualOtherFund, actualFundTotal, 
						
						actualFundBudgetStaffCost, actualFundBudgetEquipmentCost, actualFundBudgetFuelCost, actualFundBudgetMaterialCost, 
						actualFundBudgetTestCost, actualFundBudgetTravelCost, actualFundBudgetConferenceCost, actualFundBudgetPublishCost, 
						actualFundBudgetManageCost, actualFundBudgetOtherCost, actualFundBudgetTotal, 
						"10");
		
		
	}
	
	/**
	 * 提交数据
	 * 
	 * 在载入预算页面的时候会预读数据,如果发现没有对应itemPk则会插入itemPk对应的预算,则返回false
	 *
	 */
	public boolean submitProvincialFundInfo(
			Long itemPK, String itemName, String teacherName, String itemId, 
			
			Double actualNationFund, Double actualAgencyFund,Double actualCountyFund, 
			Double actualDepartmentFund,Double actualSelfFund, Double actualOtherFund,Double actualFundTotal,
			
			Double actualFundBudgetStaffCost,Double actualFundBudgetEquipmentCost, Double actualFundBudgetFuelCost,Double actualFundBudgetMaterialCost, 
			Double actualFundBudgetTestCost,Double actualFundBudgetTravelCost, Double actualFundBudgetConferenceCost,Double actualFundBudgetPublishCost, 
			Double actualFundBudgetManageCost,Double actualFundBudgetOtherCost, Double actualFundBudgetTotal) {
		
			
				return this.saveOrSumbitProvincialFundInfo(
						
						itemPK, itemName, teacherName, itemId,
		
						actualNationFund, actualAgencyFund, actualCountyFund, actualDepartmentFund, 
						actualSelfFund, actualOtherFund, actualFundTotal, 
						
						actualFundBudgetStaffCost, actualFundBudgetEquipmentCost, actualFundBudgetFuelCost, actualFundBudgetMaterialCost, 
						actualFundBudgetTestCost, actualFundBudgetTravelCost, actualFundBudgetConferenceCost, actualFundBudgetPublishCost, 
						actualFundBudgetManageCost, actualFundBudgetOtherCost, actualFundBudgetTotal, 
						"11");
	}

	public ActualFundItemDAO getActualFundItemDAO() {
		return actualFundItemDAO;
	}

	public void setActualFundItemDAO(ActualFundItemDAO actualFundItemDAO) {
		this.actualFundItemDAO = actualFundItemDAO;
	}

	public ActualFundBudgetDAO getActualFundBudgetDAO() {
		return actualFundBudgetDAO;
	}

	public void setActualFundBudgetDAO(ActualFundBudgetDAO actualFundBudgetDAO) {
		this.actualFundBudgetDAO = actualFundBudgetDAO;
	}

	public ItemDAO getItemDAO() {
		return itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
}
