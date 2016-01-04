/**
 * @author xjk
 */

package com.stoms.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import com.stoms.dao.ActualFundBudgetDAO;
import com.stoms.dao.AgencyFundOutlayDAO;
import com.stoms.dao.ItemDAO;
import com.stoms.dao.SelfFundOutlayDAO;
import com.stoms.dao.SumFundOutlayDAO;
import com.stoms.model.ActualFundBudget;
import com.stoms.model.AgencyFundOutlay;
import com.stoms.model.Item;
import com.stoms.model.SelfFundOutlay;
import com.stoms.model.SumFundOutlay;
import com.stoms.utils.JSONTranslation;

public class ProvincialOutlayService {
	
	
	//预算
	private ActualFundBudgetDAO actualFundBudgetDAO;
	
	//省科技厅
	private AgencyFundOutlayDAO agencyFundOutlayDAO;
	
	//省自筹
	private SelfFundOutlayDAO selfFundOutlayDAO;
	
	//总和
	private SumFundOutlayDAO sumFundOutlayDAO;
	

	private ColumnSumOutlayService columnSumOutlayService;
	
	
	private ItemDAO itemDAO;
	
	/**
	 * 取得项目的基本详细
	 * @param itemPK
	 * @return
	 */
	private Object getItemInfo ( Long itemPK ) {
		
		//根据itemPK在Item表中查找相应的对象
		Item item = itemDAO.findById(itemPK);
		if (item == null) {
			return "";
		}
		
		return item;
	}
	
	/**
	 * 取得项目的预算基本信息 
	 * @param itemPK
	 * @return
	 */
	private Object getItemBudgetInfo ( Long itemPK ) {
		
		
		List list = actualFundBudgetDAO.findByItemPk(itemPK);
		
		if (list == null || list.size() == 0) {
			return "";
		}
		
		return (ActualFundBudget)list.get(0);
	}
	
	/**
	 * 根据itemPk预读的数据
	 *
	 * 
	 */
	public String acquireProvincialOutlayInfo(Long itemPK ){
		
		String result = "";
		String[] excludes = {};
		
		//封装json返回
        JSONObject jsonObject = new JSONObject();
    	jsonObject.element("itemInfo", this.getItemInfo(itemPK) );
    	jsonObject.element("actualFundBudgetInfo", this.getItemBudgetInfo(itemPK) );
		
     	String columnSumInfo = JSONTranslation.arrayToJson(
     			columnSumOutlayService.acquireColumnSumofOutlay(itemPK), excludes);
     	
     	jsonObject.element("columnSumInfo", columnSumInfo );
    	
    	result = jsonObject.toString();

		return result;	
	}
	

	/**
	 * 提交数据
	 * 
	 *
	 */
	public boolean submitProvincialOutlayInfo(
			
			Long itemPK,  String itemId,
			
			Double agencyStaffCost,Double agencyEquipmentCost, Double agencyFuelCost,Double agencyMaterialCost, 
			Double agencyTestCost,Double agencyTravelCost, Double agencyConferenceCost,Double agencyPublishCost, 
			Double agencyManageCost,Double agencyOtherCost, Double agencyFundTotal,

			Double selfStaffCost, Double selfEquipmentCost,Double selfFuelCost, Double selfMaterialCost, 
			Double selfTestCost,Double selfTravelCost, Double selfConferenceCost,Double selfPublishCost, 
			Double selfManageCost,Double selfOtherCost, Double selfFundTotal, 
			
			Double sumStaffCost,Double sumEquipmentCost, Double sumFuelCost,Double sumMaterialCost, 
			Double sumTestCost, Double sumTravelCost,Double sumConferenceCost, Double sumPublishCost,
			Double sumManageCost, Double sumOtherCost, Double sumFundTotal ){
		
		
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String currentDate = formatter.format(date);
		
		AgencyFundOutlay agencyFundOutlay = new AgencyFundOutlay();
	
		agencyFundOutlay.setItemPk(itemPK);
		agencyFundOutlay.setItemId(itemId);
		agencyFundOutlay.setStaffCost(agencyStaffCost);
		agencyFundOutlay.setEquipmentCost(agencyEquipmentCost);
		agencyFundOutlay.setFuelCost(agencyFuelCost);
		agencyFundOutlay.setMaterialCost(agencyMaterialCost);
		agencyFundOutlay.setTestCost(agencyTestCost);
		agencyFundOutlay.setTravelCost(agencyTravelCost);
		agencyFundOutlay.setConferenceCost(agencyConferenceCost);
		agencyFundOutlay.setPublishCost(agencyPublishCost);
		agencyFundOutlay.setManageCost(agencyManageCost);
		agencyFundOutlay.setOtherCost(agencyOtherCost);
		agencyFundOutlay.setSumCost(agencyFundTotal);
		agencyFundOutlay.setOutlayTime(currentDate);
	
		
		//省自筹
		SelfFundOutlay selfFundOutlay = new SelfFundOutlay();
		
		selfFundOutlay.setItemPk(itemPK);
		selfFundOutlay.setItemId(itemId);
		selfFundOutlay.setStaffCost(selfStaffCost);
		selfFundOutlay.setEquipmentCost(selfEquipmentCost);
		selfFundOutlay.setFuelCost(selfFuelCost);
		selfFundOutlay.setMaterialCost(selfMaterialCost);
		selfFundOutlay.setTestCost(selfTestCost);
		selfFundOutlay.setTravelCost(selfTravelCost);
		selfFundOutlay.setConferenceCost(selfConferenceCost);
		selfFundOutlay.setPublishCost(selfPublishCost);
		selfFundOutlay.setManageCost(selfManageCost);
		selfFundOutlay.setOtherCost(selfOtherCost);
		selfFundOutlay.setSumCost(selfFundTotal);
		selfFundOutlay.setOutlayTime(currentDate);
	

		//总和
		SumFundOutlay sumFundOutlay = new SumFundOutlay();

		sumFundOutlay.setItemPk(itemPK);
		sumFundOutlay.setItemId(itemId);
		sumFundOutlay.setStaffCost(sumStaffCost);
		sumFundOutlay.setEquipmentCost(sumEquipmentCost);
		sumFundOutlay.setFuelCost(sumFuelCost);
		sumFundOutlay.setMaterialCost(sumMaterialCost);
		sumFundOutlay.setTestCost(sumTestCost);
		sumFundOutlay.setTravelCost(sumTravelCost);
		sumFundOutlay.setConferenceCost(sumConferenceCost);
		sumFundOutlay.setPublishCost(sumPublishCost);
		sumFundOutlay.setManageCost(sumManageCost);
		sumFundOutlay.setOtherCost(sumOtherCost);
		sumFundOutlay.setSumCost(sumFundTotal);
		sumFundOutlay.setOutlayTime(currentDate);
		
		agencyFundOutlayDAO.attachDirty(agencyFundOutlay);
		selfFundOutlayDAO.attachDirty(selfFundOutlay);
		sumFundOutlayDAO.attachDirty(sumFundOutlay);

		return true;
	}
	
	/**
	 * 获得该项目（省基金）的支出历史
	 * @param itemPK
	 * @return
	 */
	public String acquireProvincialOutlayHistory( Long itemPK ) {
		
		String result = "";
		List list = sumFundOutlayDAO.findByItemPk(itemPK);

		String[] excludes = {};
		
		JSONObject jsonObject = new JSONObject();
    	jsonObject.element("itemInfo", this.getItemInfo(itemPK) );
		jsonObject.element("provincialOutlayList", JSONTranslation.arrayToJson( list,excludes));
		result = jsonObject.toString();
		
		return result;
		
	}
	
	/**
	 * 省基金支出对应的记录查看
	 * @param outlayPk
	 * @return
	 */
	public String acquireProvincialOutlayView( Long itemPK, Long outlayPk ) {
		
	
		String result = "";
		String[] excludes = {};

		//省科技厅
		AgencyFundOutlay agencyFundOutlay = agencyFundOutlayDAO.findById(outlayPk);
		if( agencyFundOutlay == null ) {
			agencyFundOutlay = new AgencyFundOutlay();
		}
		String agencyFundOutlayInfo = JSONTranslation.objectToJson(agencyFundOutlay, excludes);
		
		//省自筹
		SelfFundOutlay selfFundOutlay = selfFundOutlayDAO.findById(outlayPk);
		if( selfFundOutlay == null ) {
			selfFundOutlay = new SelfFundOutlay();
		}
		String selfFundOutlayInfo = JSONTranslation.objectToJson(selfFundOutlay, excludes);
		
		
		//总和
		SumFundOutlay sumFundOutlay = sumFundOutlayDAO.findById(outlayPk);
		if( sumFundOutlay == null ) {
			sumFundOutlay = new SumFundOutlay();
		}
		String sumFundOutlayInfo = JSONTranslation.objectToJson(sumFundOutlay, excludes);
		
		JSONObject jsonObject = new JSONObject();
    	jsonObject.element("itemInfo", this.getItemInfo(itemPK) );
		jsonObject.element("agencyFundOutlayInfo", agencyFundOutlayInfo);
		jsonObject.element("selfFundOutlayInfo", selfFundOutlayInfo);
		jsonObject.element("sumFundOutlayInfo", sumFundOutlayInfo);
		result = jsonObject.toString();
		
		return result;
	}
	

	/**
	 * 统计
	 * @param itemPK
	 * @return
	 */
	public String acquireProvincialStatistic ( Long itemPK ) {
		
		String result = "";
		String[] excludes = {};
		
		JSONObject jsonObject = new JSONObject();
    	jsonObject.element("itemInfo", this.getItemInfo(itemPK) );
     	jsonObject.element("actualFundBudgetInfo", this.getItemBudgetInfo(itemPK) );
     			
     	String columnSumInfo = JSONTranslation.arrayToJson(
     			columnSumOutlayService.acquireColumnSumofOutlay(itemPK), excludes);
     	
     	jsonObject.element("columnSumInfo", columnSumInfo );
     	
		result = jsonObject.toString();
		
		return result;
	}

	public ActualFundBudgetDAO getActualFundBudgetDAO() {
		return actualFundBudgetDAO;
	}

	public void setActualFundBudgetDAO(ActualFundBudgetDAO actualFundBudgetDAO) {
		this.actualFundBudgetDAO = actualFundBudgetDAO;
	}

	public AgencyFundOutlayDAO getAgencyFundOutlayDAO() {
		return agencyFundOutlayDAO;
	}

	public void setAgencyFundOutlayDAO(AgencyFundOutlayDAO agencyFundOutlayDAO) {
		this.agencyFundOutlayDAO = agencyFundOutlayDAO;
	}

	public SelfFundOutlayDAO getSelfFundOutlayDAO() {
		return selfFundOutlayDAO;
	}

	public void setSelfFundOutlayDAO(SelfFundOutlayDAO selfFundOutlayDAO) {
		this.selfFundOutlayDAO = selfFundOutlayDAO;
	}

	public SumFundOutlayDAO getSumFundOutlayDAO() {
		return sumFundOutlayDAO;
	}

	public void setSumFundOutlayDAO(SumFundOutlayDAO sumFundOutlayDAO) {
		this.sumFundOutlayDAO = sumFundOutlayDAO;
	}

	public ColumnSumOutlayService getColumnSumOutlayService() {
		return columnSumOutlayService;
	}

	public void setColumnSumOutlayService(
			ColumnSumOutlayService columnSumOutlayService) {
		this.columnSumOutlayService = columnSumOutlayService;
	}

	public ItemDAO getItemDAO() {
		return itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	
	
}
