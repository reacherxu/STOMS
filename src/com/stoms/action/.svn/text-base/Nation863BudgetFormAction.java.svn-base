package com.stoms.action;

import java.util.List;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.model.A863detailBudget;
import com.stoms.model.A863item;
import com.stoms.model.A863njubudget;
import com.stoms.model.A863outlay;
import com.stoms.model.A863remark;
import com.stoms.model.A863sum;
import com.stoms.service.A863DetailBudgetService;
import com.stoms.service.ColumnSumOutlayService;
import com.stoms.service.ItemService;
import com.stoms.service.Nation863BudgetFormService;
import com.stoms.utils.JSONTranslation;

public class Nation863BudgetFormAction extends ActionSupport {

	private String jsonResult;
	private boolean actionStatus;

	private Long itemPK;
	private Long outlayPK;

	// 一般项目只有一次预算，只有973项目分为两次预算和一个总的预算
	// 标记是第几次预算: 0表示总预算， 1表示973第一次预算， 2表示973第二次预算
	private int indexOfBudget;

	private String startYear;
	private String endYear;

	private Double outGoings_Sum;
	private Double directCost_Sum;
	private Double equipmentCost_Sum;
	private Double buyCost_Sum;
	private Double tryToMakeCost_Sum;
	private Double reformLeaseCost_Sum;
	private Double materialCost_Sum;
	private Double testCost_Sum;
	private Double fuelCost_Sum;
	private Double travelCost_Sum;
	private Double conferenceCost_Sum;
	private Double internationalCost_Sum;
	private Double publishCost_Sum;
	private Double labourCost_Sum;
	private Double consultationCost_Sum;
	private Double constructionCost_Sum;
	private Double otherCost_Sum;
	private Double indirectCost_Sum;
	private Double achievementsCost_Sum;
	private Double fundSourse_Sum;
	private Double specialFundSource_Sum;
	private Double selfFundSource_Sum;
	private Double otherFinanceSource_Sum;
	private Double itsOwnSource_Sum;
	private Double otherSource_Sum;

	private String[] organizationName_Array;
	private Double[] outGoings_Array;
	private Double[] directCost_Array;
	private Double[] equipmentCost_Array;
	private Double[] buyCost_Array;
	private Double[] tryToMakeCost_Array;
	private Double[] reformLeaseCost_Array;
	private Double[] materialCost_Array;
	private Double[] testCost_Array;
	private Double[] fuelCost_Array;
	private Double[] travelCost_Array;
	private Double[] conferenceCost_Array;
	private Double[] internationalCost_Array;
	private Double[] publishCost_Array;
	private Double[] labourCost_Array;
	private Double[] consultationCost_Array;
	private Double[] constructionCost_Array;
	private Double[] otherCost_Array;
	private Double[] indirectCost_Array;
	private Double[] achievementsCost_Array;
	private Double[] fundSourse_Array;
	private Double[] specialFundSource_Array;
	private Double[] selfFundSource_Array;
	private Double[] otherFinanceSource_Array;
	private Double[] itsOwnSource_Array;
	private Double[] otherSource_Array;

	// 实际支出
	private Double buyEquipment_RealOutGoings;
	private Double trialEquipment_RealOutGoings;
	private Double transform_RealOutGoings;
	private Double equipmentCost_RealOutGoings;
	private Double materialCost_RealOutGoings;
	private Double testCost_RealOutGoings;
	private Double fuelCost_RealOutGoings;
	private Double travelCost_RealOutGoings;
	private Double conferenceCost_RealOutGoings;
	private Double exchangeCost_RealOutGoings;
	private Double publishCost_RealOutGoings;
	private Double serviceCost_RealOutGoings;
	private Double consultCost_RealOutGoings;
	private Double constructionCost_RealOutGoings;
	private Double otherCost_RealOutGoings;
	private Double costSum_RealOutGoings;
	private Double performanceCost_RealOutGoings;
	private Double indirectCost_RealOutGoings;
	private Double directCost_RealOutGoings;

	// 支出说明
	private String buyEquipment_Remark;
	private String trialEquipment_Remark;
	private String transform_Remark;
	private String equipmentCost_Remark;
	private String materialCost_Remark;
	private String testCost_Remark;
	private String fuelCost_Remark;
	private String travelCost_Remark;
	private String conferenceCost_Remark;
	private String exchangeCost_Remark;
	private String publishCost_Remark;
	private String serviceCost_Remark;
	private String consultCost_Remark;
	private String constructionCost_Remark;
	private String otherCost_Remark;
	private String costSum_Remark;
	private String performanceCost_Remark;
	private String indirectCost_Remark;
	private String directCost_Remark;

	private Nation863BudgetFormService nation863BudgetFormService;
	private ColumnSumOutlayService columnSumOutlayService;
	private ItemService itemService;
	private A863DetailBudgetService a863DetailBudgetService;

	/**
	 * 根据ItemPK返回863预算表的项目基本信息，南京大学预算，协作单位预算和预算合计
	 * 
	 * @return
	 */
	public String acquire863BudgetInfoByItemPK() {

		A863item tempA863itemInfo = nation863BudgetFormService
				.acquire863BudgetInfoByItemPK(itemPK);

		if (tempA863itemInfo == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		JSONObject jsonObject = new JSONObject();

		String[] excludes = {};
		String tempA863itemInfoJson = JSONTranslation.objectToJson(
				tempA863itemInfo, excludes);
		jsonObject.element("A863itemInfo", tempA863itemInfoJson);

		String tempA863njubudgetInfoJson = "";
		String tempA863cooperationBudgetListJson = "";
		String tempA863sumInfoJson = "";

		if (indexOfBudget == 0) {

			A863njubudget tempA863njubudgetInfo = nation863BudgetFormService
					.acquireA863njubudgetInfoByItemPK(itemPK);
			tempA863njubudgetInfoJson = JSONTranslation.objectToJson(
					tempA863njubudgetInfo, excludes);

			List tempA863cooperationBudgetList = nation863BudgetFormService
					.acquireA863cooperationBudgetInfoByItemPK(itemPK);
			tempA863cooperationBudgetListJson = JSONTranslation.arrayToJson(
					tempA863cooperationBudgetList, excludes);

			A863sum tempA863sumInfo = nation863BudgetFormService
					.acquireA863sumInfoByItemPK(itemPK);
			tempA863sumInfoJson = JSONTranslation.objectToJson(tempA863sumInfo,
					excludes);
		} else if (indexOfBudget == 1 || indexOfBudget == 2) {

			A863detailBudget tempA863NJUDetailBudget = a863DetailBudgetService
					.acquireNJUDetailBudget(itemPK, indexOfBudget);
			tempA863njubudgetInfoJson = JSONTranslation.objectToJson(
					tempA863NJUDetailBudget, excludes);

			List tempA863CooperationDetailBudgetList = a863DetailBudgetService
					.acquireCooperationDetailBudget(itemPK, indexOfBudget);
			tempA863cooperationBudgetListJson = JSONTranslation.arrayToJson(
					tempA863CooperationDetailBudgetList, excludes);

			A863detailBudget tempA863ApprovedDetailBudget = a863DetailBudgetService
					.acquireApprovalDetailBudget(itemPK, indexOfBudget);
			tempA863sumInfoJson = JSONTranslation.objectToJson(
					tempA863ApprovedDetailBudget, excludes);
		}

		jsonObject.element("A863njubudgetInfo", tempA863njubudgetInfoJson);
		jsonObject.element("A863cooperationBudgetList",
				tempA863cooperationBudgetListJson);
		jsonObject.element("A863sumInfo", tempA863sumInfoJson);

		this.jsonResult = jsonObject.toString();
		this.actionStatus = true;
		return "success";
	}

	public String store863BudgetInfo() {

		boolean tempResult = nation863BudgetFormService
				.store863BudgetInfo(itemPK);

		if (!tempResult) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		if (indexOfBudget == 0) {
			tempResult = nation863BudgetFormService.storeA863njubudgetInfo(
					itemPK, startYear, endYear, outGoings_Array[0],
					directCost_Array[0], equipmentCost_Array[0],
					buyCost_Array[0], tryToMakeCost_Array[0],
					reformLeaseCost_Array[0], materialCost_Array[0],
					testCost_Array[0], fuelCost_Array[0], travelCost_Array[0],
					conferenceCost_Array[0], internationalCost_Array[0],
					publishCost_Array[0], labourCost_Array[0],
					consultationCost_Array[0], constructionCost_Array[0],
					otherCost_Array[0], indirectCost_Array[0],
					achievementsCost_Array[0], fundSourse_Array[0],
					specialFundSource_Array[0], selfFundSource_Array[0],
					otherFinanceSource_Array[0], itsOwnSource_Array[0],
					otherSource_Array[0]);

			if (!tempResult) {
				this.actionStatus = false;
				this.jsonResult = "";
				return "success";
			}

			tempResult = nation863BudgetFormService.storeCooperationBudgetInfo(
					itemPK, organizationName_Array, outGoings_Array,
					directCost_Array, equipmentCost_Array, buyCost_Array,
					tryToMakeCost_Array, reformLeaseCost_Array,
					materialCost_Array, testCost_Array, fuelCost_Array,
					travelCost_Array, conferenceCost_Array,
					internationalCost_Array, publishCost_Array,
					labourCost_Array, consultationCost_Array,
					constructionCost_Array, otherCost_Array,
					indirectCost_Array, achievementsCost_Array,
					fundSourse_Array, specialFundSource_Array,
					selfFundSource_Array, otherFinanceSource_Array,
					itsOwnSource_Array, otherSource_Array);

			if (!tempResult) {
				this.actionStatus = false;
				this.jsonResult = "";
				return "success";
			}

			tempResult = nation863BudgetFormService.storeSummaryBudgetInfo(
					itemPK, outGoings_Sum, directCost_Sum, equipmentCost_Sum,
					buyCost_Sum, tryToMakeCost_Sum, reformLeaseCost_Sum,
					materialCost_Sum, testCost_Sum, fuelCost_Sum,
					travelCost_Sum, conferenceCost_Sum, internationalCost_Sum,
					publishCost_Sum, labourCost_Sum, consultationCost_Sum,
					constructionCost_Sum, otherCost_Sum, indirectCost_Sum,
					achievementsCost_Sum, fundSourse_Sum,
					specialFundSource_Sum, selfFundSource_Sum,
					otherFinanceSource_Sum, itsOwnSource_Sum, otherSource_Sum);

			if (!tempResult) {
				this.actionStatus = false;
				this.jsonResult = "";
				return "success";
			}
		} else if (indexOfBudget == 1 || indexOfBudget == 2) {

			tempResult = a863DetailBudgetService
					.storeA863njubudgetInfoInDetail(itemPK, indexOfBudget,
							startYear, endYear, outGoings_Array[0],
							directCost_Array[0], equipmentCost_Array[0],
							buyCost_Array[0], tryToMakeCost_Array[0],
							reformLeaseCost_Array[0], materialCost_Array[0],
							testCost_Array[0], fuelCost_Array[0],
							travelCost_Array[0], conferenceCost_Array[0],
							internationalCost_Array[0], publishCost_Array[0],
							labourCost_Array[0], consultationCost_Array[0],
							constructionCost_Array[0], otherCost_Array[0],
							indirectCost_Array[0], achievementsCost_Array[0],
							fundSourse_Array[0], specialFundSource_Array[0],
							selfFundSource_Array[0],
							otherFinanceSource_Array[0], itsOwnSource_Array[0],
							otherSource_Array[0]);

			if (!tempResult) {
				this.actionStatus = false;
				this.jsonResult = "";
				return "success";
			}

			tempResult = a863DetailBudgetService
					.storeCooperationBudgetInfoInDetail(itemPK, indexOfBudget,
							organizationName_Array, outGoings_Array,
							directCost_Array, equipmentCost_Array,
							buyCost_Array, tryToMakeCost_Array,
							reformLeaseCost_Array, materialCost_Array,
							testCost_Array, fuelCost_Array, travelCost_Array,
							conferenceCost_Array, internationalCost_Array,
							publishCost_Array, labourCost_Array,
							consultationCost_Array, constructionCost_Array,
							otherCost_Array, indirectCost_Array,
							achievementsCost_Array, fundSourse_Array,
							specialFundSource_Array, selfFundSource_Array,
							otherFinanceSource_Array, itsOwnSource_Array,
							otherSource_Array);

			if (!tempResult) {
				this.actionStatus = false;
				this.jsonResult = "";
				return "success";
			}

			tempResult = a863DetailBudgetService
					.storeSummaryBudgetInfoInDetail(itemPK, indexOfBudget,
							outGoings_Sum, directCost_Sum, equipmentCost_Sum,
							buyCost_Sum, tryToMakeCost_Sum,
							reformLeaseCost_Sum, materialCost_Sum,
							testCost_Sum, fuelCost_Sum, travelCost_Sum,
							conferenceCost_Sum, internationalCost_Sum,
							publishCost_Sum, labourCost_Sum,
							consultationCost_Sum, constructionCost_Sum,
							otherCost_Sum, indirectCost_Sum,
							achievementsCost_Sum, fundSourse_Sum,
							specialFundSource_Sum, selfFundSource_Sum,
							otherFinanceSource_Sum, itsOwnSource_Sum,
							otherSource_Sum);

			if (!tempResult) {
				this.actionStatus = false;
				this.jsonResult = "";
				return "success";
			}

		} else {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = true;
		this.jsonResult = "";
		return "success";
	}

	/**
	 * 根据itemPK和outlayPK获取该项目的预算信息，预算总支出以及该次支出登记的数额和说明
	 * 
	 * @return
	 */
	public String acquire863OutlayInfoByItemPKAndOutlayPK() {

		A863item tempA863itemInfo = nation863BudgetFormService
				.acquire863BudgetInfoByItemPK(itemPK);

		if (tempA863itemInfo == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		JSONObject jsonObject = new JSONObject();

		String[] excludes = {};

		String tempA863itemInfoJson = JSONTranslation.objectToJson(
				tempA863itemInfo, excludes);
		jsonObject.element("A863itemInfo", tempA863itemInfoJson);

		A863njubudget tempA863njubudgetInfo = nation863BudgetFormService
				.acquireA863njubudgetInfoByItemPK(itemPK);
		String tempA863njubudgetInfoJson = JSONTranslation.objectToJson(
				tempA863njubudgetInfo, excludes);
		jsonObject.element("A863njubudgetInfo", tempA863njubudgetInfoJson);

		List budgetSumUsedList = columnSumOutlayService
				.acquireColumnSumofOutlay(itemPK);
		String tempA863njuBudgetSumUsedListJson = JSONTranslation.arrayToJson(
				budgetSumUsedList, excludes);
		jsonObject.element("A863njuBudgetSumUsed",
				tempA863njuBudgetSumUsedListJson);

		// currentOutlayInfo
		A863outlay tempA863outlay = nation863BudgetFormService
				.acquireA863outlayInfoByOutlayPK(outlayPK);
		String tempA863outlayJson = JSONTranslation.objectToJson(
				tempA863outlay, excludes);
		jsonObject.element("current863OutlayInfo", tempA863outlayJson);

		A863remark tempA863remarkInfo = nation863BudgetFormService
				.acuqireA863remarkInfoByOutlayPK(outlayPK);
		String tempA863remarkInfoJson = JSONTranslation.objectToJson(
				tempA863remarkInfo, excludes);
		jsonObject.element("A863RemarkInfo", tempA863remarkInfoJson);

		this.actionStatus = true;
		this.jsonResult = jsonObject.toString();

		return "success";
	}

	/**
	 * 保存A863支出信息内容
	 * 
	 * @return
	 */
	public String storeA863OutlayInfo() {

		long newOutlayPK = nation863BudgetFormService.storeA863OutlayInfo(
				outlayPK, itemPK, buyEquipment_RealOutGoings,
				trialEquipment_RealOutGoings, transform_RealOutGoings,
				equipmentCost_RealOutGoings, materialCost_RealOutGoings,
				testCost_RealOutGoings, fuelCost_RealOutGoings,
				travelCost_RealOutGoings, conferenceCost_RealOutGoings,
				exchangeCost_RealOutGoings, publishCost_RealOutGoings,
				serviceCost_RealOutGoings, consultCost_RealOutGoings,
				constructionCost_RealOutGoings, otherCost_RealOutGoings,
				costSum_RealOutGoings, performanceCost_RealOutGoings,
				indirectCost_RealOutGoings, directCost_RealOutGoings);

		this.actionStatus = nation863BudgetFormService.storeA863OutlayRemark(
				newOutlayPK, itemPK, buyEquipment_Remark,
				trialEquipment_Remark, transform_Remark, equipmentCost_Remark,
				materialCost_Remark, testCost_Remark, fuelCost_Remark,
				travelCost_Remark, conferenceCost_Remark, exchangeCost_Remark,
				publishCost_Remark, serviceCost_Remark, consultCost_Remark,
				constructionCost_Remark, otherCost_Remark, costSum_Remark,
				performanceCost_Remark, indirectCost_Remark, directCost_Remark);

		this.jsonResult = "";
		return "success";
	}

	/**
	 * 取得项目的基本信息和该项目的支出登记历史列表
	 * 
	 * @return
	 */
	public String acquireA863OutlayHistoryInfoByItemPK() {

		JSONObject jsonObject = new JSONObject();

		String tempA863itemInfoJson = itemService.findItemByItemPK(itemPK);
		jsonObject.element("A863itemInfo", tempA863itemInfoJson);

		List tempA863OutlayHistoryList = nation863BudgetFormService
				.acquireA863OutlayHistoryInfoByItemPK(itemPK);

		String[] excludes = { "buyEquipment", "trialEquipment", "transform",
				"equipmentCost", "materialCost", "testCost", "fuelCost",
				"travelCost", "conferenceCost", "exchangeCost", "publishCost",
				"serviceCost", "consultCost", "constructionCost", "otherCost",
				"performanceCost", "indirectCost", "directCost" };

		String tempA863OutlayHistoryListJson = JSONTranslation.arrayToJson(
				tempA863OutlayHistoryList, excludes);
		jsonObject.element("A863OutlayHistoryList",
				tempA863OutlayHistoryListJson);

		this.actionStatus = true;
		this.jsonResult = jsonObject.toString();
		return "success";
	}

	// setters&getters

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

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

	public Double getOutGoings_Sum() {
		return outGoings_Sum;
	}

	public void setOutGoings_Sum(Double outGoings_Sum) {
		this.outGoings_Sum = outGoings_Sum;
	}

	public Double getDirectCost_Sum() {
		return directCost_Sum;
	}

	public void setDirectCost_Sum(Double directCost_Sum) {
		this.directCost_Sum = directCost_Sum;
	}

	public Double getEquipmentCost_Sum() {
		return equipmentCost_Sum;
	}

	public void setEquipmentCost_Sum(Double equipmentCost_Sum) {
		this.equipmentCost_Sum = equipmentCost_Sum;
	}

	public Double getBuyCost_Sum() {
		return buyCost_Sum;
	}

	public void setBuyCost_Sum(Double buyCost_Sum) {
		this.buyCost_Sum = buyCost_Sum;
	}

	public Double getTryToMakeCost_Sum() {
		return tryToMakeCost_Sum;
	}

	public void setTryToMakeCost_Sum(Double tryToMakeCost_Sum) {
		this.tryToMakeCost_Sum = tryToMakeCost_Sum;
	}

	public Double getReformLeaseCost_Sum() {
		return reformLeaseCost_Sum;
	}

	public void setReformLeaseCost_Sum(Double reformLeaseCost_Sum) {
		this.reformLeaseCost_Sum = reformLeaseCost_Sum;
	}

	public Double getMaterialCost_Sum() {
		return materialCost_Sum;
	}

	public void setMaterialCost_Sum(Double materialCost_Sum) {
		this.materialCost_Sum = materialCost_Sum;
	}

	public Double getTestCost_Sum() {
		return testCost_Sum;
	}

	public void setTestCost_Sum(Double testCost_Sum) {
		this.testCost_Sum = testCost_Sum;
	}

	public Double getFuelCost_Sum() {
		return fuelCost_Sum;
	}

	public void setFuelCost_Sum(Double fuelCost_Sum) {
		this.fuelCost_Sum = fuelCost_Sum;
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

	public Double getInternationalCost_Sum() {
		return internationalCost_Sum;
	}

	public void setInternationalCost_Sum(Double internationalCost_Sum) {
		this.internationalCost_Sum = internationalCost_Sum;
	}

	public Double getPublishCost_Sum() {
		return publishCost_Sum;
	}

	public void setPublishCost_Sum(Double publishCost_Sum) {
		this.publishCost_Sum = publishCost_Sum;
	}

	public Double getLabourCost_Sum() {
		return labourCost_Sum;
	}

	public void setLabourCost_Sum(Double labourCost_Sum) {
		this.labourCost_Sum = labourCost_Sum;
	}

	public Double getConsultationCost_Sum() {
		return consultationCost_Sum;
	}

	public void setConsultationCost_Sum(Double consultationCost_Sum) {
		this.consultationCost_Sum = consultationCost_Sum;
	}

	public Double getOtherCost_Sum() {
		return otherCost_Sum;
	}

	public void setOtherCost_Sum(Double otherCost_Sum) {
		this.otherCost_Sum = otherCost_Sum;
	}

	public Double getIndirectCost_Sum() {
		return indirectCost_Sum;
	}

	public void setIndirectCost_Sum(Double indirectCost_Sum) {
		this.indirectCost_Sum = indirectCost_Sum;
	}

	public Double getAchievementsCost_Sum() {
		return achievementsCost_Sum;
	}

	public void setAchievementsCost_Sum(Double achievementsCost_Sum) {
		this.achievementsCost_Sum = achievementsCost_Sum;
	}

	public Double getFundSourse_Sum() {
		return fundSourse_Sum;
	}

	public void setFundSourse_Sum(Double fundSourse_Sum) {
		this.fundSourse_Sum = fundSourse_Sum;
	}

	public Double getSpecialFundSource_Sum() {
		return specialFundSource_Sum;
	}

	public void setSpecialFundSource_Sum(Double specialFundSource_Sum) {
		this.specialFundSource_Sum = specialFundSource_Sum;
	}

	public Double getSelfFundSource_Sum() {
		return selfFundSource_Sum;
	}

	public void setSelfFundSource_Sum(Double selfFundSource_Sum) {
		this.selfFundSource_Sum = selfFundSource_Sum;
	}

	public Double getOtherFinanceSource_Sum() {
		return otherFinanceSource_Sum;
	}

	public void setOtherFinanceSource_Sum(Double otherFinanceSource_Sum) {
		this.otherFinanceSource_Sum = otherFinanceSource_Sum;
	}

	public Double getItsOwnSource_Sum() {
		return itsOwnSource_Sum;
	}

	public void setItsOwnSource_Sum(Double itsOwnSource_Sum) {
		this.itsOwnSource_Sum = itsOwnSource_Sum;
	}

	public Double getOtherSource_Sum() {
		return otherSource_Sum;
	}

	public void setOtherSource_Sum(Double otherSource_Sum) {
		this.otherSource_Sum = otherSource_Sum;
	}

	public String[] getOrganizationName_Array() {
		return organizationName_Array;
	}

	public void setOrganizationName_Array(String[] organizationName_Array) {
		this.organizationName_Array = organizationName_Array;
	}

	public Double[] getOutGoings_Array() {
		return outGoings_Array;
	}

	public void setOutGoings_Array(Double[] outGoings_Array) {
		this.outGoings_Array = outGoings_Array;
	}

	public Double[] getDirectCost_Array() {
		return directCost_Array;
	}

	public void setDirectCost_Array(Double[] directCost_Array) {
		this.directCost_Array = directCost_Array;
	}

	public Double[] getEquipmentCost_Array() {
		return equipmentCost_Array;
	}

	public void setEquipmentCost_Array(Double[] equipmentCost_Array) {
		this.equipmentCost_Array = equipmentCost_Array;
	}

	public Double[] getBuyCost_Array() {
		return buyCost_Array;
	}

	public void setBuyCost_Array(Double[] buyCost_Array) {
		this.buyCost_Array = buyCost_Array;
	}

	public Double[] getTryToMakeCost_Array() {
		return tryToMakeCost_Array;
	}

	public void setTryToMakeCost_Array(Double[] tryToMakeCost_Array) {
		this.tryToMakeCost_Array = tryToMakeCost_Array;
	}

	public Double[] getReformLeaseCost_Array() {
		return reformLeaseCost_Array;
	}

	public void setReformLeaseCost_Array(Double[] reformLeaseCost_Array) {
		this.reformLeaseCost_Array = reformLeaseCost_Array;
	}

	public Double[] getMaterialCost_Array() {
		return materialCost_Array;
	}

	public void setMaterialCost_Array(Double[] materialCost_Array) {
		this.materialCost_Array = materialCost_Array;
	}

	public Double[] getTestCost_Array() {
		return testCost_Array;
	}

	public void setTestCost_Array(Double[] testCost_Array) {
		this.testCost_Array = testCost_Array;
	}

	public Double[] getFuelCost_Array() {
		return fuelCost_Array;
	}

	public void setFuelCost_Array(Double[] fuelCost_Array) {
		this.fuelCost_Array = fuelCost_Array;
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

	public Double[] getInternationalCost_Array() {
		return internationalCost_Array;
	}

	public void setInternationalCost_Array(Double[] internationalCost_Array) {
		this.internationalCost_Array = internationalCost_Array;
	}

	public Double[] getPublishCost_Array() {
		return publishCost_Array;
	}

	public void setPublishCost_Array(Double[] publishCost_Array) {
		this.publishCost_Array = publishCost_Array;
	}

	public Double[] getLabourCost_Array() {
		return labourCost_Array;
	}

	public void setLabourCost_Array(Double[] labourCost_Array) {
		this.labourCost_Array = labourCost_Array;
	}

	public Double[] getConsultationCost_Array() {
		return consultationCost_Array;
	}

	public void setConsultationCost_Array(Double[] consultationCost_Array) {
		this.consultationCost_Array = consultationCost_Array;
	}

	public Double[] getOtherCost_Array() {
		return otherCost_Array;
	}

	public void setOtherCost_Array(Double[] otherCost_Array) {
		this.otherCost_Array = otherCost_Array;
	}

	public Double[] getIndirectCost_Array() {
		return indirectCost_Array;
	}

	public void setIndirectCost_Array(Double[] indirectCost_Array) {
		this.indirectCost_Array = indirectCost_Array;
	}

	public Double[] getAchievementsCost_Array() {
		return achievementsCost_Array;
	}

	public void setAchievementsCost_Array(Double[] achievementsCost_Array) {
		this.achievementsCost_Array = achievementsCost_Array;
	}

	public Double[] getFundSourse_Array() {
		return fundSourse_Array;
	}

	public void setFundSourse_Array(Double[] fundSourse_Array) {
		this.fundSourse_Array = fundSourse_Array;
	}

	public Double[] getSpecialFundSource_Array() {
		return specialFundSource_Array;
	}

	public void setSpecialFundSource_Array(Double[] specialFundSource_Array) {
		this.specialFundSource_Array = specialFundSource_Array;
	}

	public Double[] getSelfFundSource_Array() {
		return selfFundSource_Array;
	}

	public void setSelfFundSource_Array(Double[] selfFundSource_Array) {
		this.selfFundSource_Array = selfFundSource_Array;
	}

	public Double[] getOtherFinanceSource_Array() {
		return otherFinanceSource_Array;
	}

	public void setOtherFinanceSource_Array(Double[] otherFinanceSource_Array) {
		this.otherFinanceSource_Array = otherFinanceSource_Array;
	}

	public Double[] getItsOwnSource_Array() {
		return itsOwnSource_Array;
	}

	public void setItsOwnSource_Array(Double[] itsOwnSource_Array) {
		this.itsOwnSource_Array = itsOwnSource_Array;
	}

	public Double[] getOtherSource_Array() {
		return otherSource_Array;
	}

	public void setOtherSource_Array(Double[] otherSource_Array) {
		this.otherSource_Array = otherSource_Array;
	}

	public Nation863BudgetFormService getNation863BudgetFormService() {
		return nation863BudgetFormService;
	}

	public void setNation863BudgetFormService(
			Nation863BudgetFormService nation863BudgetFormService) {
		this.nation863BudgetFormService = nation863BudgetFormService;
	}

	public ColumnSumOutlayService getColumnSumOutlayService() {
		return columnSumOutlayService;
	}

	public void setColumnSumOutlayService(
			ColumnSumOutlayService columnSumOutlayService) {
		this.columnSumOutlayService = columnSumOutlayService;
	}

	public Double getConstructionCost_Sum() {
		return constructionCost_Sum;
	}

	public void setConstructionCost_Sum(Double constructionCost_Sum) {
		this.constructionCost_Sum = constructionCost_Sum;
	}

	public Double[] getConstructionCost_Array() {
		return constructionCost_Array;
	}

	public void setConstructionCost_Array(Double[] constructionCost_Array) {
		this.constructionCost_Array = constructionCost_Array;
	}

	public Long getOutlayPK() {
		return outlayPK;
	}

	public void setOutlayPK(Long outlayPK) {
		this.outlayPK = outlayPK;
	}

	public Double getBuyEquipment_RealOutGoings() {
		return buyEquipment_RealOutGoings;
	}

	public void setBuyEquipment_RealOutGoings(Double buyEquipment_RealOutGoings) {
		this.buyEquipment_RealOutGoings = buyEquipment_RealOutGoings;
	}

	public Double getTrialEquipment_RealOutGoings() {
		return trialEquipment_RealOutGoings;
	}

	public void setTrialEquipment_RealOutGoings(
			Double trialEquipment_RealOutGoings) {
		this.trialEquipment_RealOutGoings = trialEquipment_RealOutGoings;
	}

	public Double getTransform_RealOutGoings() {
		return transform_RealOutGoings;
	}

	public void setTransform_RealOutGoings(Double transform_RealOutGoings) {
		this.transform_RealOutGoings = transform_RealOutGoings;
	}

	public Double getEquipmentCost_RealOutGoings() {
		return equipmentCost_RealOutGoings;
	}

	public void setEquipmentCost_RealOutGoings(
			Double equipmentCost_RealOutGoings) {
		this.equipmentCost_RealOutGoings = equipmentCost_RealOutGoings;
	}

	public Double getMaterialCost_RealOutGoings() {
		return materialCost_RealOutGoings;
	}

	public void setMaterialCost_RealOutGoings(Double materialCost_RealOutGoings) {
		this.materialCost_RealOutGoings = materialCost_RealOutGoings;
	}

	public Double getTestCost_RealOutGoings() {
		return testCost_RealOutGoings;
	}

	public void setTestCost_RealOutGoings(Double testCost_RealOutGoings) {
		this.testCost_RealOutGoings = testCost_RealOutGoings;
	}

	public Double getFuelCost_RealOutGoings() {
		return fuelCost_RealOutGoings;
	}

	public void setFuelCost_RealOutGoings(Double fuelCost_RealOutGoings) {
		this.fuelCost_RealOutGoings = fuelCost_RealOutGoings;
	}

	public Double getTravelCost_RealOutGoings() {
		return travelCost_RealOutGoings;
	}

	public void setTravelCost_RealOutGoings(Double travelCost_RealOutGoings) {
		this.travelCost_RealOutGoings = travelCost_RealOutGoings;
	}

	public Double getConferenceCost_RealOutGoings() {
		return conferenceCost_RealOutGoings;
	}

	public void setConferenceCost_RealOutGoings(
			Double conferenceCost_RealOutGoings) {
		this.conferenceCost_RealOutGoings = conferenceCost_RealOutGoings;
	}

	public Double getExchangeCost_RealOutGoings() {
		return exchangeCost_RealOutGoings;
	}

	public void setExchangeCost_RealOutGoings(Double exchangeCost_RealOutGoings) {
		this.exchangeCost_RealOutGoings = exchangeCost_RealOutGoings;
	}

	public Double getPublishCost_RealOutGoings() {
		return publishCost_RealOutGoings;
	}

	public void setPublishCost_RealOutGoings(Double publishCost_RealOutGoings) {
		this.publishCost_RealOutGoings = publishCost_RealOutGoings;
	}

	public Double getServiceCost_RealOutGoings() {
		return serviceCost_RealOutGoings;
	}

	public void setServiceCost_RealOutGoings(Double serviceCost_RealOutGoings) {
		this.serviceCost_RealOutGoings = serviceCost_RealOutGoings;
	}

	public Double getConsultCost_RealOutGoings() {
		return consultCost_RealOutGoings;
	}

	public void setConsultCost_RealOutGoings(Double consultCost_RealOutGoings) {
		this.consultCost_RealOutGoings = consultCost_RealOutGoings;
	}

	public Double getConstructionCost_RealOutGoings() {
		return constructionCost_RealOutGoings;
	}

	public void setConstructionCost_RealOutGoings(
			Double constructionCost_RealOutGoings) {
		this.constructionCost_RealOutGoings = constructionCost_RealOutGoings;
	}

	public Double getOtherCost_RealOutGoings() {
		return otherCost_RealOutGoings;
	}

	public void setOtherCost_RealOutGoings(Double otherCost_RealOutGoings) {
		this.otherCost_RealOutGoings = otherCost_RealOutGoings;
	}

	public Double getCostSum_RealOutGoings() {
		return costSum_RealOutGoings;
	}

	public void setCostSum_RealOutGoings(Double costSum_RealOutGoings) {
		this.costSum_RealOutGoings = costSum_RealOutGoings;
	}

	public Double getPerformanceCost_RealOutGoings() {
		return performanceCost_RealOutGoings;
	}

	public void setPerformanceCost_RealOutGoings(
			Double performanceCost_RealOutGoings) {
		this.performanceCost_RealOutGoings = performanceCost_RealOutGoings;
	}

	public Double getIndirectCost_RealOutGoings() {
		return indirectCost_RealOutGoings;
	}

	public void setIndirectCost_RealOutGoings(Double indirectCost_RealOutGoings) {
		this.indirectCost_RealOutGoings = indirectCost_RealOutGoings;
	}

	public Double getDirectCost_RealOutGoings() {
		return directCost_RealOutGoings;
	}

	public void setDirectCost_RealOutGoings(Double directCost_RealOutGoings) {
		this.directCost_RealOutGoings = directCost_RealOutGoings;
	}

	public String getBuyEquipment_Remark() {
		return buyEquipment_Remark;
	}

	public void setBuyEquipment_Remark(String buyEquipment_Remark) {
		this.buyEquipment_Remark = buyEquipment_Remark;
	}

	public String getTrialEquipment_Remark() {
		return trialEquipment_Remark;
	}

	public void setTrialEquipment_Remark(String trialEquipment_Remark) {
		this.trialEquipment_Remark = trialEquipment_Remark;
	}

	public String getTransform_Remark() {
		return transform_Remark;
	}

	public void setTransform_Remark(String transform_Remark) {
		this.transform_Remark = transform_Remark;
	}

	public String getEquipmentCost_Remark() {
		return equipmentCost_Remark;
	}

	public void setEquipmentCost_Remark(String equipmentCost_Remark) {
		this.equipmentCost_Remark = equipmentCost_Remark;
	}

	public String getMaterialCost_Remark() {
		return materialCost_Remark;
	}

	public void setMaterialCost_Remark(String materialCost_Remark) {
		this.materialCost_Remark = materialCost_Remark;
	}

	public String getTestCost_Remark() {
		return testCost_Remark;
	}

	public void setTestCost_Remark(String testCost_Remark) {
		this.testCost_Remark = testCost_Remark;
	}

	public String getFuelCost_Remark() {
		return fuelCost_Remark;
	}

	public void setFuelCost_Remark(String fuelCost_Remark) {
		this.fuelCost_Remark = fuelCost_Remark;
	}

	public String getTravelCost_Remark() {
		return travelCost_Remark;
	}

	public void setTravelCost_Remark(String travelCost_Remark) {
		this.travelCost_Remark = travelCost_Remark;
	}

	public String getConferenceCost_Remark() {
		return conferenceCost_Remark;
	}

	public void setConferenceCost_Remark(String conferenceCost_Remark) {
		this.conferenceCost_Remark = conferenceCost_Remark;
	}

	public String getExchangeCost_Remark() {
		return exchangeCost_Remark;
	}

	public void setExchangeCost_Remark(String exchangeCost_Remark) {
		this.exchangeCost_Remark = exchangeCost_Remark;
	}

	public String getPublishCost_Remark() {
		return publishCost_Remark;
	}

	public void setPublishCost_Remark(String publishCost_Remark) {
		this.publishCost_Remark = publishCost_Remark;
	}

	public String getServiceCost_Remark() {
		return serviceCost_Remark;
	}

	public void setServiceCost_Remark(String serviceCost_Remark) {
		this.serviceCost_Remark = serviceCost_Remark;
	}

	public String getConsultCost_Remark() {
		return consultCost_Remark;
	}

	public void setConsultCost_Remark(String consultCost_Remark) {
		this.consultCost_Remark = consultCost_Remark;
	}

	public String getConstructionCost_Remark() {
		return constructionCost_Remark;
	}

	public void setConstructionCost_Remark(String constructionCost_Remark) {
		this.constructionCost_Remark = constructionCost_Remark;
	}

	public String getOtherCost_Remark() {
		return otherCost_Remark;
	}

	public void setOtherCost_Remark(String otherCost_Remark) {
		this.otherCost_Remark = otherCost_Remark;
	}

	public String getCostSum_Remark() {
		return costSum_Remark;
	}

	public void setCostSum_Remark(String costSum_Remark) {
		this.costSum_Remark = costSum_Remark;
	}

	public String getPerformanceCost_Remark() {
		return performanceCost_Remark;
	}

	public void setPerformanceCost_Remark(String performanceCost_Remark) {
		this.performanceCost_Remark = performanceCost_Remark;
	}

	public String getIndirectCost_Remark() {
		return indirectCost_Remark;
	}

	public void setIndirectCost_Remark(String indirectCost_Remark) {
		this.indirectCost_Remark = indirectCost_Remark;
	}

	public String getDirectCost_Remark() {
		return directCost_Remark;
	}

	public void setDirectCost_Remark(String directCost_Remark) {
		this.directCost_Remark = directCost_Remark;
	}

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public int getIndexOfBudget() {
		return indexOfBudget;
	}

	public void setIndexOfBudget(int indexOfBudget) {
		this.indexOfBudget = indexOfBudget;
	}

	public A863DetailBudgetService getA863DetailBudgetService() {
		return a863DetailBudgetService;
	}

	public void setA863DetailBudgetService(
			A863DetailBudgetService a863DetailBudgetService) {
		this.a863DetailBudgetService = a863DetailBudgetService;
	}

}