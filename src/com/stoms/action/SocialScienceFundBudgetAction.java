package com.stoms.action;

import java.util.List;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.model.SocialScienceApprovalBudget;
import com.stoms.model.SocialScienceItem;
import com.stoms.model.SocialScienceNjubudget;
import com.stoms.model.SocialScienceOutlay;
import com.stoms.model.SocialScienceRemark;
import com.stoms.service.ColumnSumOutlayService;
import com.stoms.service.ItemService;
import com.stoms.service.SocialScienceFundBudgetService;
import com.stoms.utils.JSONTranslation;

public class SocialScienceFundBudgetAction extends ActionSupport {

	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;

	private Long itemPK;
	private Long outlayPK;

	private Double materialCost_Sum;
	private Double dataCost_Sum;
	private Double travelCost_Sum;
	private Double conferenceCost_Sum;
	private Double exchangeCost_Sum;
	private Double equipmentCost_Sum;
	private Double consultCost_Sum;
	private Double serviceCost_Sum;
	private Double printCost_Sum;
	private Double manageCost_Sum;
	private Double otherCost_Sum;

	private String[] organizationName_Array;
	private Double[] materialCost_Array;
	private Double[] dataCost_Array;
	private Double[] travelCost_Array;
	private Double[] conferenceCost_Array;
	private Double[] exchangeCost_Array;
	private Double[] equipmentCost_Array;
	private Double[] consultCost_Array;
	private Double[] serviceCost_Array;
	private Double[] printCost_Array;
	private Double[] manageCost_Array;
	private Double[] otherCost_Array;
	
	private Double materialCost_currentOutlay;
	private Double dataCost_currentOutlay;
	private Double travelCost_currentOutlay;
	private Double conferenceCost_currentOutlay;
	private Double exchangeCost_currentOutlay;
	private Double equipmentCost_currentOutlay;
	private Double consultCost_currentOutlay;
	private Double serviceCost_currentOutlay;
	private Double printCost_currentOutlay;
	private Double manageCost_currentOutlay;
	private Double otherCost_currentOutlay;
	
	private String materialCost_remark;
	private String dataCost_remark;
	private String travelCost_remark;
	private String conferenceCost_remark;
	private String exchangeCost_remark;
	private String equipmentCost_remark;
	private String consultCost_remark;
	private String serviceCost_remark;
	private String printCost_remark;
	private String manageCost_remark;
	private String otherCost_remark;

	private SocialScienceFundBudgetService socialScienceFundBudgetService;
	private ItemService itemService;
	private ColumnSumOutlayService columnSumOutlayService;

	/**
	 * 根据ItemPK取得社科基金的相关信息
	 * 
	 * @return
	 */
	public String acquireSocialScienceFundBudgetInfoByItemPK() {

		SocialScienceItem tempSocialScienceItem = socialScienceFundBudgetService
				.acquireSocialScienceItemBaseInfoByItemPK(itemPK);
		if (tempSocialScienceItem == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		String[] excludes = {};
		String tempSocialScienceItemJson = JSONTranslation.objectToJson(
				tempSocialScienceItem, excludes);

		JSONObject jsonObject = new JSONObject();
		jsonObject.element("socialScienceItemInfo", tempSocialScienceItemJson);

		SocialScienceNjubudget tempSocialScienceNjubudget = socialScienceFundBudgetService
				.acquireSocialScienceNjubudgetInfoByItemPK(itemPK);
		String tempSocialScienceNjubudgetJson = JSONTranslation.objectToJson(
				tempSocialScienceNjubudget, excludes);
		jsonObject.element("socialScienceNjuBudgetInfo",
				tempSocialScienceNjubudgetJson);

		List tempSocialScienceCooperationBudgetList = socialScienceFundBudgetService
				.acquireSocialScienceCooperationBudgetInfoByItemPK(itemPK);
		String tempSocialScienceCooperationBudgetListJson = JSONTranslation
				.arrayToJson(tempSocialScienceCooperationBudgetList, excludes);
		jsonObject.element("scienceCooperationBudgetInfo",
				tempSocialScienceCooperationBudgetListJson);

		SocialScienceApprovalBudget tempSocialScienceApprovalBudget = socialScienceFundBudgetService
				.acquireSocialScienceApprovalBudgetByItemPK(itemPK);
		String tempSocialScienceApprovalBudgetJson = JSONTranslation
				.objectToJson(tempSocialScienceApprovalBudget, excludes);
		jsonObject.element("socialScienceApprovalBudgetInfo",
				tempSocialScienceApprovalBudgetJson);

		this.actionStatus = true;
		this.jsonResult = jsonObject.toString();
		return "success";
	}

	/**
	 * 存储社科基金预算信息
	 * @return
	 */
	public String storeSocialScienceFundBudgetInfo() {

		boolean tempStoreResult = true;

		tempStoreResult = socialScienceFundBudgetService
				.storeSocialScienceItemBaseInfo(itemPK);
		
		if (!tempStoreResult) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		tempStoreResult = socialScienceFundBudgetService
				.storeSocialScienceNjuBudgetInfo(itemPK, materialCost_Array[0],
						dataCost_Array[0], travelCost_Array[0],
						conferenceCost_Array[0], exchangeCost_Array[0],
						equipmentCost_Array[0], consultCost_Array[0],
						serviceCost_Array[0], printCost_Array[0],
						manageCost_Array[0], otherCost_Array[0]);
		if (!tempStoreResult) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		tempStoreResult = socialScienceFundBudgetService
				.storeSocialScienceCooperationBudgetInfo(itemPK,
						organizationName_Array, materialCost_Array,
						dataCost_Array, travelCost_Array, conferenceCost_Array,
						exchangeCost_Array, equipmentCost_Array,
						consultCost_Array, serviceCost_Array, printCost_Array,
						manageCost_Array, otherCost_Array);
		if (!tempStoreResult) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		tempStoreResult = socialScienceFundBudgetService
				.storeSocialScienceApprovalBudgetInfo(itemPK, materialCost_Sum,
						dataCost_Sum, travelCost_Sum, conferenceCost_Sum,
						exchangeCost_Sum, equipmentCost_Sum, consultCost_Sum,
						serviceCost_Sum, printCost_Sum, manageCost_Sum,
						otherCost_Sum);
		if (!tempStoreResult) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = true;
		this.jsonResult = "";
		return "success";
	}

	/**
	 * 
	 * @return
	 */
	public String acquireSocialScienceFundOutlayListInfoByItemPK() {
		
		JSONObject jsonObject = new JSONObject();

		String tempSocialScienceFundItemInfoJson = itemService.findItemByItemPK(itemPK);
		jsonObject.element("socialScienceFundItemInfo", tempSocialScienceFundItemInfoJson);
		
		List tempSocialScienceFundOutlayList = socialScienceFundBudgetService.acquireSocialScienceFundOutlayList(itemPK);
		String[] excludes = {};
		String tempSocialScienceFundOutlayListJson = JSONTranslation.arrayToJson(tempSocialScienceFundOutlayList, excludes);
		jsonObject.element("socialScienceFundOutlayList", tempSocialScienceFundOutlayListJson);
		
		this.actionStatus = true;
		this.jsonResult = jsonObject.toString();
		return "success";
	}
	
	public String acquireSocialScienceFundOutlayInfo() {
		
		SocialScienceItem tempSocialScienceItem = socialScienceFundBudgetService.acquireSocialScienceItemBaseInfoByItemPK(itemPK);
		if(tempSocialScienceItem == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		String[] excludes = {};
		String tempSocialScienceItemJson = JSONTranslation.objectToJson(tempSocialScienceItem, excludes);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.element("socialScienceFundItemInfo", tempSocialScienceItemJson);
		
		SocialScienceNjubudget tempSocialScienceNjubudget = socialScienceFundBudgetService.acquireSocialScienceNjubudgetInfoByItemPK(itemPK);
		String tempSocialScienceNjubudgetJson = JSONTranslation.objectToJson(tempSocialScienceNjubudget, excludes);
		jsonObject.element("socialScienceFundNjuBudgetInfo", tempSocialScienceNjubudgetJson);
		
		List budgetSumUsedList = columnSumOutlayService.acquireColumnSumofOutlay(itemPK);
		String tempBudgetAccumulatedInfoJson = JSONTranslation.arrayToJson(budgetSumUsedList, excludes);
		jsonObject.element("socialScienceBudgetAccumulatedInfo", tempBudgetAccumulatedInfoJson);
		
		SocialScienceOutlay tempSocialScienceOutlay = socialScienceFundBudgetService.acquireSocialScienceOutlayByOutlayPK(outlayPK);
		String tempSocialScienceOutlayJson = JSONTranslation.objectToJson(tempSocialScienceOutlay, excludes);
		jsonObject.element("socialScienceFundOutlayInfo", tempSocialScienceOutlayJson);
		
		SocialScienceRemark tempSocialScienceRemark = socialScienceFundBudgetService.acquireSocialScienceRemarkInfoByOutlayPK(outlayPK);
		String tempSocialScienceRemarkJson = JSONTranslation.objectToJson(tempSocialScienceRemark, excludes);
		jsonObject.element("socialScienceFundOutlayRemarkInfo", tempSocialScienceRemarkJson);
		
		this.actionStatus = true;
		this.jsonResult = jsonObject.toString();
		
		return "success";
	}
	
	public String storeSocialScienceFundOutlayInfo() {

		long tempOutlayPK = socialScienceFundBudgetService
				.storeSocialScienceCurrentOutlayInfo(itemPK, outlayPK,
						materialCost_currentOutlay, dataCost_currentOutlay,
						travelCost_currentOutlay, conferenceCost_currentOutlay,
						exchangeCost_currentOutlay,
						equipmentCost_currentOutlay, consultCost_currentOutlay,
						serviceCost_currentOutlay, printCost_currentOutlay,
						manageCost_currentOutlay, otherCost_currentOutlay);
		
		if(tempOutlayPK == 0) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = socialScienceFundBudgetService
				.storeSocialScienceFundOutlayRemarkInfo(itemPK, tempOutlayPK,
						materialCost_remark, dataCost_remark,
						travelCost_remark, conferenceCost_remark,
						exchangeCost_remark, equipmentCost_remark,
						consultCost_remark, serviceCost_remark,
						printCost_remark, manageCost_remark, otherCost_remark);
		
		this.jsonResult = "";
		
		return "success";
	}
	// setters and getters
	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
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

	public Long getItemPK() {
		return itemPK;
	}

	public void setItemPK(Long itemPK) {
		this.itemPK = itemPK;
	}

	public Double getMaterialCost_Sum() {
		return materialCost_Sum;
	}

	public void setMaterialCost_Sum(Double materialCost_Sum) {
		this.materialCost_Sum = materialCost_Sum;
	}

	public Double getDataCost_Sum() {
		return dataCost_Sum;
	}

	public void setDataCost_Sum(Double dataCost_Sum) {
		this.dataCost_Sum = dataCost_Sum;
	}

	public Double getTravelCost_Sum() {
		return travelCost_Sum;
	}

	public void setTravelCost_Sum(Double travelCost_Sum) {
		this.travelCost_Sum = travelCost_Sum;
	}

	public Double getConferenceCost_Sum() {
		return conferenceCost_Sum;
	}

	public void setConferenceCost_Sum(Double conferenceCost_Sum) {
		this.conferenceCost_Sum = conferenceCost_Sum;
	}

	public Double getExchangeCost_Sum() {
		return exchangeCost_Sum;
	}

	public void setExchangeCost_Sum(Double exchangeCost_Sum) {
		this.exchangeCost_Sum = exchangeCost_Sum;
	}

	public Double getEquipmentCost_Sum() {
		return equipmentCost_Sum;
	}

	public void setEquipmentCost_Sum(Double equipmentCost_Sum) {
		this.equipmentCost_Sum = equipmentCost_Sum;
	}

	public Double getConsultCost_Sum() {
		return consultCost_Sum;
	}

	public void setConsultCost_Sum(Double consultCost_Sum) {
		this.consultCost_Sum = consultCost_Sum;
	}

	public Double getServiceCost_Sum() {
		return serviceCost_Sum;
	}

	public void setServiceCost_Sum(Double serviceCost_Sum) {
		this.serviceCost_Sum = serviceCost_Sum;
	}

	public Double getPrintCost_Sum() {
		return printCost_Sum;
	}

	public void setPrintCost_Sum(Double printCost_Sum) {
		this.printCost_Sum = printCost_Sum;
	}

	public Double getManageCost_Sum() {
		return manageCost_Sum;
	}

	public void setManageCost_Sum(Double manageCost_Sum) {
		this.manageCost_Sum = manageCost_Sum;
	}

	public Double getOtherCost_Sum() {
		return otherCost_Sum;
	}

	public void setOtherCost_Sum(Double otherCost_Sum) {
		this.otherCost_Sum = otherCost_Sum;
	}

	public String[] getOrganizationName_Array() {
		return organizationName_Array;
	}

	public void setOrganizationName_Array(String[] organizationName_Array) {
		this.organizationName_Array = organizationName_Array;
	}

	public Double[] getMaterialCost_Array() {
		return materialCost_Array;
	}

	public void setMaterialCost_Array(Double[] materialCost_Array) {
		this.materialCost_Array = materialCost_Array;
	}

	public Double[] getDataCost_Array() {
		return dataCost_Array;
	}

	public void setDataCost_Array(Double[] dataCost_Array) {
		this.dataCost_Array = dataCost_Array;
	}

	public Double[] getTravelCost_Array() {
		return travelCost_Array;
	}

	public void setTravelCost_Array(Double[] travelCost_Array) {
		this.travelCost_Array = travelCost_Array;
	}

	public Double[] getConferenceCost_Array() {
		return conferenceCost_Array;
	}

	public void setConferenceCost_Array(Double[] conferenceCost_Array) {
		this.conferenceCost_Array = conferenceCost_Array;
	}

	public Double[] getExchangeCost_Array() {
		return exchangeCost_Array;
	}

	public void setExchangeCost_Array(Double[] exchangeCost_Array) {
		this.exchangeCost_Array = exchangeCost_Array;
	}

	public Double[] getEquipmentCost_Array() {
		return equipmentCost_Array;
	}

	public void setEquipmentCost_Array(Double[] equipmentCost_Array) {
		this.equipmentCost_Array = equipmentCost_Array;
	}

	public Double[] getConsultCost_Array() {
		return consultCost_Array;
	}

	public void setConsultCost_Array(Double[] consultCost_Array) {
		this.consultCost_Array = consultCost_Array;
	}

	public Double[] getServiceCost_Array() {
		return serviceCost_Array;
	}

	public void setServiceCost_Array(Double[] serviceCost_Array) {
		this.serviceCost_Array = serviceCost_Array;
	}

	public Double[] getPrintCost_Array() {
		return printCost_Array;
	}

	public void setPrintCost_Array(Double[] printCost_Array) {
		this.printCost_Array = printCost_Array;
	}

	public Double[] getManageCost_Array() {
		return manageCost_Array;
	}

	public void setManageCost_Array(Double[] manageCost_Array) {
		this.manageCost_Array = manageCost_Array;
	}

	public Double[] getOtherCost_Array() {
		return otherCost_Array;
	}

	public void setOtherCost_Array(Double[] otherCost_Array) {
		this.otherCost_Array = otherCost_Array;
	}

	public SocialScienceFundBudgetService getSocialScienceFundBudgetService() {
		return socialScienceFundBudgetService;
	}

	public void setSocialScienceFundBudgetService(
			SocialScienceFundBudgetService socialScienceFundBudgetService) {
		this.socialScienceFundBudgetService = socialScienceFundBudgetService;
	}

	public ColumnSumOutlayService getColumnSumOutlayService() {
		return columnSumOutlayService;
	}

	public void setColumnSumOutlayService(
			ColumnSumOutlayService columnSumOutlayService) {
		this.columnSumOutlayService = columnSumOutlayService;
	}

	public Long getOutlayPK() {
		return outlayPK;
	}

	public void setOutlayPK(Long outlayPK) {
		this.outlayPK = outlayPK;
	}

	public Double getMaterialCost_currentOutlay() {
		return materialCost_currentOutlay;
	}

	public void setMaterialCost_currentOutlay(Double materialCost_currentOutlay) {
		this.materialCost_currentOutlay = materialCost_currentOutlay;
	}

	public Double getDataCost_currentOutlay() {
		return dataCost_currentOutlay;
	}

	public void setDataCost_currentOutlay(Double dataCost_currentOutlay) {
		this.dataCost_currentOutlay = dataCost_currentOutlay;
	}

	public Double getTravelCost_currentOutlay() {
		return travelCost_currentOutlay;
	}

	public void setTravelCost_currentOutlay(Double travelCost_currentOutlay) {
		this.travelCost_currentOutlay = travelCost_currentOutlay;
	}

	public Double getConferenceCost_currentOutlay() {
		return conferenceCost_currentOutlay;
	}

	public void setConferenceCost_currentOutlay(Double conferenceCost_currentOutlay) {
		this.conferenceCost_currentOutlay = conferenceCost_currentOutlay;
	}

	public Double getExchangeCost_currentOutlay() {
		return exchangeCost_currentOutlay;
	}

	public void setExchangeCost_currentOutlay(Double exchangeCost_currentOutlay) {
		this.exchangeCost_currentOutlay = exchangeCost_currentOutlay;
	}

	public Double getEquipmentCost_currentOutlay() {
		return equipmentCost_currentOutlay;
	}

	public void setEquipmentCost_currentOutlay(Double equipmentCost_currentOutlay) {
		this.equipmentCost_currentOutlay = equipmentCost_currentOutlay;
	}

	public Double getConsultCost_currentOutlay() {
		return consultCost_currentOutlay;
	}

	public void setConsultCost_currentOutlay(Double consultCost_currentOutlay) {
		this.consultCost_currentOutlay = consultCost_currentOutlay;
	}

	public Double getServiceCost_currentOutlay() {
		return serviceCost_currentOutlay;
	}

	public void setServiceCost_currentOutlay(Double serviceCost_currentOutlay) {
		this.serviceCost_currentOutlay = serviceCost_currentOutlay;
	}

	public Double getPrintCost_currentOutlay() {
		return printCost_currentOutlay;
	}

	public void setPrintCost_currentOutlay(Double printCost_currentOutlay) {
		this.printCost_currentOutlay = printCost_currentOutlay;
	}

	public Double getManageCost_currentOutlay() {
		return manageCost_currentOutlay;
	}

	public void setManageCost_currentOutlay(Double manageCost_currentOutlay) {
		this.manageCost_currentOutlay = manageCost_currentOutlay;
	}

	public Double getOtherCost_currentOutlay() {
		return otherCost_currentOutlay;
	}

	public void setOtherCost_currentOutlay(Double otherCost_currentOutlay) {
		this.otherCost_currentOutlay = otherCost_currentOutlay;
	}

	public String getMaterialCost_remark() {
		return materialCost_remark;
	}

	public void setMaterialCost_remark(String materialCost_remark) {
		this.materialCost_remark = materialCost_remark;
	}

	public String getDataCost_remark() {
		return dataCost_remark;
	}

	public void setDataCost_remark(String dataCost_remark) {
		this.dataCost_remark = dataCost_remark;
	}

	public String getTravelCost_remark() {
		return travelCost_remark;
	}

	public void setTravelCost_remark(String travelCost_remark) {
		this.travelCost_remark = travelCost_remark;
	}

	public String getConferenceCost_remark() {
		return conferenceCost_remark;
	}

	public void setConferenceCost_remark(String conferenceCost_remark) {
		this.conferenceCost_remark = conferenceCost_remark;
	}

	public String getExchangeCost_remark() {
		return exchangeCost_remark;
	}

	public void setExchangeCost_remark(String exchangeCost_remark) {
		this.exchangeCost_remark = exchangeCost_remark;
	}

	public String getEquipmentCost_remark() {
		return equipmentCost_remark;
	}

	public void setEquipmentCost_remark(String equipmentCost_remark) {
		this.equipmentCost_remark = equipmentCost_remark;
	}

	public String getConsultCost_remark() {
		return consultCost_remark;
	}

	public void setConsultCost_remark(String consultCost_remark) {
		this.consultCost_remark = consultCost_remark;
	}

	public String getServiceCost_remark() {
		return serviceCost_remark;
	}

	public void setServiceCost_remark(String serviceCost_remark) {
		this.serviceCost_remark = serviceCost_remark;
	}

	public String getPrintCost_remark() {
		return printCost_remark;
	}

	public void setPrintCost_remark(String printCost_remark) {
		this.printCost_remark = printCost_remark;
	}

	public String getManageCost_remark() {
		return manageCost_remark;
	}

	public void setManageCost_remark(String manageCost_remark) {
		this.manageCost_remark = manageCost_remark;
	}

	public String getOtherCost_remark() {
		return otherCost_remark;
	}

	public void setOtherCost_remark(String otherCost_remark) {
		this.otherCost_remark = otherCost_remark;
	}

}
