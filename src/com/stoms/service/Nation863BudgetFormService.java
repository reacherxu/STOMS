package com.stoms.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import com.stoms.dao.A863cooperationBudgetDAO;
import com.stoms.dao.A863itemDAO;
import com.stoms.dao.A863njubudgetDAO;
import com.stoms.dao.A863outlayDAO;
import com.stoms.dao.A863remarkDAO;
import com.stoms.dao.A863sumDAO;
import com.stoms.dao.ItemDAO;
import com.stoms.model.A863cooperationBudget;
import com.stoms.model.A863item;
import com.stoms.model.A863njubudget;
import com.stoms.model.A863outlay;
import com.stoms.model.A863remark;
import com.stoms.model.A863sum;
import com.stoms.model.Item;

public class Nation863BudgetFormService {

	private ItemDAO itemDAO;
	private A863itemDAO a863itemDAO;
	private A863njubudgetDAO a863njubudgetDAO;
	private A863cooperationBudgetDAO a863cooperationBudgetDAO;
	private A863sumDAO a863sumDAO;
	private A863outlayDAO a863outlayDAO;
	private A863remarkDAO a863remarkDAO;

	/**
	 * 根据itemPK得到863预算表的基本信息
	 * 
	 * @param itemPK
	 * @return
	 */
	public A863item acquire863BudgetInfoByItemPK(long itemPK) {

		A863item tempA863item;
		List a863ItemList = a863itemDAO.findByItemPk(itemPK);

		if (a863ItemList == null || a863ItemList.size() == 0) {

			Item tempItem = itemDAO.findById(itemPK);

			if (tempItem == null) {
				return null;
			}

			tempA863item = new A863item();

			tempA863item.setItemPk(itemPK);
			tempA863item.setItemId(tempItem.getItemId());
			tempA863item.setContractId(tempItem.getContractId());
			tempA863item.setItemName(tempItem.getItemName());
			tempA863item.setTeacherName(tempItem.getTeacherName());
			tempA863item.setCardId(tempItem.getCardId());

		} else {
			tempA863item = (A863item) a863ItemList.get(0);
		}

		return tempA863item;
	}

	/**
	 * 根据itemPK返回南京大学863预算信息
	 * 
	 * @param itemPK
	 * @return
	 */
	public A863njubudget acquireA863njubudgetInfoByItemPK(long itemPK) {

		A863njubudget tempA863njubudget;
		List tempA863njubudgetList = a863njubudgetDAO.findByItemPk(itemPK);

		if (tempA863njubudgetList == null || tempA863njubudgetList.size() == 0) {
			tempA863njubudget = new A863njubudget();
		} else {
			tempA863njubudget = (A863njubudget) tempA863njubudgetList.get(0);
		}

		return tempA863njubudget;
	}

	/**
	 * 根据outlayPK返回相应的支出登记说明信息
	 * 
	 * @param outlayPK
	 * @return
	 */
	public A863remark acuqireA863remarkInfoByOutlayPK(long outlayPK) {

		A863remark tempA863remark;

		List tempA863remarkList = a863remarkDAO.findByA863outlayPk(outlayPK);

		if (tempA863remarkList == null || tempA863remarkList.size() == 0) {
			tempA863remark = new A863remark();
		} else {
			tempA863remark = (A863remark) tempA863remarkList.get(0);
		}

		return tempA863remark;
	}

	/**
	 * 根据itemPK返回协作单位的预算信息
	 * 
	 * @param itemPK
	 * @return
	 */
	public List acquireA863cooperationBudgetInfoByItemPK(long itemPK) {
		List tempA863cooperationBudgetList = a863cooperationBudgetDAO
				.findByItemPk(itemPK);
		int addBudgetInfoNum = 0;
		if (tempA863cooperationBudgetList == null) {
			addBudgetInfoNum = 4;
		} else {
			addBudgetInfoNum = 4 - tempA863cooperationBudgetList.size();
		}

		for (int i = 0; i < addBudgetInfoNum; i++) {
			A863cooperationBudget tempA863cooperationBudget = new A863cooperationBudget();
			tempA863cooperationBudgetList.add(tempA863cooperationBudget);
		}

		return tempA863cooperationBudgetList;
	}

	/**
	 * 根据ItemPK返回预算合计
	 * 
	 * @param itemPK
	 * @return
	 */
	public A863sum acquireA863sumInfoByItemPK(long itemPK) {
		A863sum tempA863sum;

		List tempA863sumList = a863sumDAO.findByItemPk(itemPK);

		if (tempA863sumList == null || tempA863sumList.size() == 0) {
			tempA863sum = new A863sum();
		} else {
			tempA863sum = (A863sum) tempA863sumList.get(0);
		}

		return tempA863sum;
	}

	/**
	 * 根据outlayPK范围863项目的此次支出情况
	 * 
	 * @param outlayPK
	 * @return
	 */
	public A863outlay acquireA863outlayInfoByOutlayPK(long outlayPK) {

		A863outlay tempA863outlay;

		tempA863outlay = a863outlayDAO.findById(outlayPK);

		if (tempA863outlay == null) {
			tempA863outlay = new A863outlay();
		}

		return tempA863outlay;
	}

	/**
	 * 保存863基本信息到A863item表中
	 * 
	 * @param itemPK
	 * @return
	 */
	public boolean store863BudgetInfo(long itemPK) {
		boolean result = true;

		List a863ItemList = a863itemDAO.findByItemPk(itemPK);

		if (a863ItemList == null || a863ItemList.size() == 0) {

			Item tempItem = itemDAO.findById(itemPK);

			if (tempItem == null) {
				return false;
			}
			A863item tempA863item = new A863item();
			tempA863item.setItemPk(itemPK);
			tempA863item.setItemId(tempItem.getItemId());
			tempA863item.setContractId(tempItem.getContractId());
			tempA863item.setItemName(tempItem.getItemName());
			tempA863item.setTeacherName(tempItem.getTeacherName());
			tempA863item.setCardId(tempItem.getCardId());

			a863itemDAO.save(tempA863item);
		}

		return result;
	}

	/**
	 * 保存南京大學預算信息到A863njubudget表中
	 * 
	 * @param itemPK
	 * @param outGoings
	 * @param directCost
	 * @param equipmentCost
	 * @param buyCost
	 * @param tryToMakeCost
	 * @param reformLeaseCost
	 * @param materialCost
	 * @param testCost
	 * @param fuelCost
	 * @param travelCost
	 * @param conferenceCost
	 * @param internationalCost
	 * @param publishCost
	 * @param labourCost
	 * @param consultationCost
	 * @param constructionCost
	 * @param otherCost
	 * @param indirectCost
	 * @param achievementsCost
	 * @param fundSourse
	 * @param specialFundSource
	 * @param selfFundSource
	 * @param otherFinanceSource
	 * @param itsOwnSource
	 * @param otherSource
	 * @return
	 */
	public boolean storeA863njubudgetInfo(long itemPK, String startYear,
			String endYear, Double outGoings, Double directCost,
			Double equipmentCost, Double buyCost, Double tryToMakeCost,
			Double reformLeaseCost, Double materialCost, Double testCost,
			Double fuelCost, Double travelCost, Double conferenceCost,
			Double internationalCost, Double publishCost, Double labourCost,
			Double consultationCost, Double constructionCost, Double otherCost,
			Double indirectCost, Double achievementsCost, Double fundSourse,
			Double specialFundSource, Double selfFundSource,
			Double otherFinanceSource, Double itsOwnSource, Double otherSource) {

		A863njubudget tempA863njubudget;
		List tempA863njubudgetList = a863njubudgetDAO.findByItemPk(itemPK);

		if (tempA863njubudgetList == null || tempA863njubudgetList.size() == 0) {
			tempA863njubudget = new A863njubudget();

			tempA863njubudget = storePartialA863njubudgetInfo(
					tempA863njubudget, itemPK, startYear, endYear, outGoings,
					directCost, equipmentCost, buyCost, tryToMakeCost,
					reformLeaseCost, materialCost, testCost, fuelCost,
					travelCost, conferenceCost, internationalCost, publishCost,
					labourCost, consultationCost, constructionCost, otherCost,
					indirectCost, achievementsCost, fundSourse,
					specialFundSource, selfFundSource, otherFinanceSource,
					itsOwnSource, otherSource);

			a863njubudgetDAO.save(tempA863njubudget);
		} else {
			tempA863njubudget = (A863njubudget) tempA863njubudgetList.get(0);

			tempA863njubudget = storePartialA863njubudgetInfo(
					tempA863njubudget, itemPK, startYear, endYear, outGoings,
					directCost, equipmentCost, buyCost, tryToMakeCost,
					reformLeaseCost, materialCost, testCost, fuelCost,
					travelCost, conferenceCost, internationalCost, publishCost,
					labourCost, consultationCost, constructionCost, otherCost,
					indirectCost, achievementsCost, fundSourse,
					specialFundSource, selfFundSource, otherFinanceSource,
					itsOwnSource, otherSource);

			a863njubudgetDAO.attachDirty(tempA863njubudget);
		}

		boolean result = true;
		return result;
	}

	/**
	 * 保存南京大学预算信息到tempA863njubudget对象中，并返回改对象
	 * 
	 * @param tempA863njubudget
	 * @param itemPK
	 * @param outGoings
	 * @param directCost
	 * @param equipmentCost
	 * @param buyCost
	 * @param tryToMakeCost
	 * @param reformLeaseCost
	 * @param materialCost
	 * @param testCost
	 * @param fuelCost
	 * @param travelCost
	 * @param conferenceCost
	 * @param internationalCost
	 * @param publishCost
	 * @param labourCost
	 * @param consultationCost
	 * @param constructionCost
	 * @param otherCost
	 * @param indirectCost
	 * @param achievementsCost
	 * @param fundSourse
	 * @param specialFundSource
	 * @param selfFundSource
	 * @param otherFinanceSource
	 * @param itsOwnSource
	 * @param otherSource
	 * @return
	 */
	public A863njubudget storePartialA863njubudgetInfo(
			A863njubudget tempA863njubudget, long itemPK, String startYear,
			String endYear, Double outGoings, Double directCost,
			Double equipmentCost, Double buyCost, Double tryToMakeCost,
			Double reformLeaseCost, Double materialCost, Double testCost,
			Double fuelCost, Double travelCost, Double conferenceCost,
			Double internationalCost, Double publishCost, Double labourCost,
			Double consultationCost, Double constructionCost, Double otherCost,
			Double indirectCost, Double achievementsCost, Double fundSourse,
			Double specialFundSource, Double selfFundSource,
			Double otherFinanceSource, Double itsOwnSource, Double otherSource) {

		tempA863njubudget.setItemPk(itemPK);
		tempA863njubudget.setTimeLower(startYear);
		tempA863njubudget.setTimeUpper(endYear);
		tempA863njubudget.setCostSum(outGoings);
		tempA863njubudget.setDirectCost(directCost);
		tempA863njubudget.setEquipmentCost(equipmentCost);
		tempA863njubudget.setBuyEquipment(buyCost);
		tempA863njubudget.setTrialEquipment(tryToMakeCost);
		tempA863njubudget.setTransform(reformLeaseCost);
		tempA863njubudget.setMaterialCost(materialCost);
		tempA863njubudget.setTestCost(testCost);
		tempA863njubudget.setFuelCost(fuelCost);
		tempA863njubudget.setTravelCost(travelCost);
		tempA863njubudget.setConferenceCost(conferenceCost);
		tempA863njubudget.setExchangeCost(internationalCost);
		tempA863njubudget.setPublishCost(publishCost);
		tempA863njubudget.setServiceCost(labourCost);
		tempA863njubudget.setConsultCost(consultationCost);
		tempA863njubudget.setConstructionCost(constructionCost);
		tempA863njubudget.setOtherCost(otherCost);
		tempA863njubudget.setIndirectCost(indirectCost);
		tempA863njubudget.setPerformanceCost(achievementsCost);
		tempA863njubudget.setFundSum(fundSourse);
		tempA863njubudget.setSubsidizeSpecial(specialFundSource);
		tempA863njubudget.setSelfFinance(selfFundSource);
		tempA863njubudget.setOtherFundsSelf(otherFinanceSource);
		tempA863njubudget.setOwnFundsSelf(itsOwnSource);
		tempA863njubudget.setOtherSelf(otherSource);

		return tempA863njubudget;
	}

	/**
	 * 保存协作单位预算信息到A863cooperationBudget表中
	 * 
	 * @param itemPK
	 * @param organizationName_Array
	 * @param outGoings_Array
	 * @param directCost_Array
	 * @param equipmentCost_Array
	 * @param buyCost_Array
	 * @param tryToMakeCost_Array
	 * @param reformLeaseCost_Array
	 * @param materialCost_Array
	 * @param testCost_Array
	 * @param fuelCost_Array
	 * @param travelCost_Array
	 * @param conferenceCost_Array
	 * @param internationalCost_Array
	 * @param publishCost_Array
	 * @param labourCost_Array
	 * @param consultationCost_Array
	 * @param constructionCost_Array
	 * @param otherCost_Array
	 * @param indirectCost_Array
	 * @param achievementsCost_Array
	 * @param fundSourse_Array
	 * @param specialFundSource_Array
	 * @param selfFundSource_Array
	 * @param otherFinanceSource_Array
	 * @param itsOwnSource_Array
	 * @param otherSource_Array
	 * @return
	 */
	public boolean storeCooperationBudgetInfo(long itemPK,
			String[] organizationName_Array, Double[] outGoings_Array,
			Double[] directCost_Array, Double[] equipmentCost_Array,
			Double[] buyCost_Array, Double[] tryToMakeCost_Array,
			Double[] reformLeaseCost_Array, Double[] materialCost_Array,
			Double[] testCost_Array, Double[] fuelCost_Array,
			Double[] travelCost_Array, Double[] conferenceCost_Array,
			Double[] internationalCost_Array, Double[] publishCost_Array,
			Double[] labourCost_Array, Double[] consultationCost_Array,
			Double[] constructionCost_Array, Double[] otherCost_Array,
			Double[] indirectCost_Array, Double[] achievementsCost_Array,
			Double[] fundSourse_Array, Double[] specialFundSource_Array,
			Double[] selfFundSource_Array, Double[] otherFinanceSource_Array,
			Double[] itsOwnSource_Array, Double[] otherSource_Array) {

		List tempCooperationBudgetList = a863cooperationBudgetDAO
				.findByItemPk(itemPK);

		if (tempCooperationBudgetList != null
				&& tempCooperationBudgetList.size() > 0) {
			int originialCooperationNum = tempCooperationBudgetList.size();

			for (int i = 0; i < originialCooperationNum; i++) {

				A863cooperationBudget tempA863cooperationBudget = (A863cooperationBudget) tempCooperationBudgetList
						.get(i);
				a863cooperationBudgetDAO.delete(tempA863cooperationBudget);
			}
		}

		for (int i = 1; i < organizationName_Array.length; i++) {

			A863cooperationBudget tempA863cooperationBudget = new A863cooperationBudget();
			tempA863cooperationBudget = storePartialCooperationBudgetInfo(
					tempA863cooperationBudget, itemPK, i,
					organizationName_Array[i], outGoings_Array[i],
					directCost_Array[i], equipmentCost_Array[i],
					buyCost_Array[i], tryToMakeCost_Array[i],
					reformLeaseCost_Array[i], materialCost_Array[i],
					testCost_Array[i], fuelCost_Array[i], travelCost_Array[i],
					conferenceCost_Array[i], internationalCost_Array[i],
					publishCost_Array[i], labourCost_Array[i],
					consultationCost_Array[i], constructionCost_Array[i],
					otherCost_Array[i], indirectCost_Array[i],
					achievementsCost_Array[i], fundSourse_Array[i],
					specialFundSource_Array[i], selfFundSource_Array[i],
					otherFinanceSource_Array[i], itsOwnSource_Array[i],
					otherSource_Array[i]);

			a863cooperationBudgetDAO.save(tempA863cooperationBudget);
		}
		return true;
	}

	/**
	 * 保存协作单位预算信息到tempA863cooperationBudget对象中，并返回该对象
	 * 
	 * @param tempA863cooperationBudget
	 * @param itemPK
	 * @param index
	 * @param organizationName
	 * @param outGoings
	 * @param directCost
	 * @param equipmentCost
	 * @param buyCost
	 * @param tryToMakeCost
	 * @param reformLeaseCost
	 * @param materialCost
	 * @param testCost
	 * @param fuelCost
	 * @param travelCost
	 * @param conferenceCost
	 * @param internationalCost
	 * @param publishCost
	 * @param labourCost
	 * @param consultationCost
	 * @param constructionCost
	 * @param otherCost
	 * @param indirectCost
	 * @param achievementsCost
	 * @param fundSourse
	 * @param specialFundSource
	 * @param selfFundSource
	 * @param otherFinanceSource
	 * @param itsOwnSource
	 * @param otherSource
	 * @return
	 */
	public A863cooperationBudget storePartialCooperationBudgetInfo(
			A863cooperationBudget tempA863cooperationBudget, long itemPK,
			int index, String organizationName, Double outGoings,
			Double directCost, Double equipmentCost, Double buyCost,
			Double tryToMakeCost, Double reformLeaseCost, Double materialCost,
			Double testCost, Double fuelCost, Double travelCost,
			Double conferenceCost, Double internationalCost,
			Double publishCost, Double labourCost, Double consultationCost,
			Double constructionCost, Double otherCost, Double indirectCost,
			Double achievementsCost, Double fundSourse,
			Double specialFundSource, Double selfFundSource,
			Double otherFinanceSource, Double itsOwnSource, Double otherSource) {

		tempA863cooperationBudget.setItemPk(itemPK);
		tempA863cooperationBudget.setCooperationId(index);
		tempA863cooperationBudget.setCooperationName(organizationName);
		tempA863cooperationBudget.setCostSum(outGoings);
		tempA863cooperationBudget.setDirectCost(directCost);
		tempA863cooperationBudget.setEquipmentCost(equipmentCost);
		tempA863cooperationBudget.setBuyEquipment(buyCost);
		tempA863cooperationBudget.setTrialEquipment(tryToMakeCost);
		tempA863cooperationBudget.setTransform(reformLeaseCost);
		tempA863cooperationBudget.setMaterialCost(materialCost);
		tempA863cooperationBudget.setTestCost(testCost);
		tempA863cooperationBudget.setFuelCost(fuelCost);
		tempA863cooperationBudget.setTravelCost(travelCost);
		tempA863cooperationBudget.setConferenceCost(conferenceCost);
		tempA863cooperationBudget.setExchangeCost(internationalCost);
		tempA863cooperationBudget.setPublishCost(publishCost);
		tempA863cooperationBudget.setServiceCost(labourCost);
		tempA863cooperationBudget.setConsultCost(consultationCost);
		tempA863cooperationBudget.setConstructionCost(constructionCost);
		tempA863cooperationBudget.setOtherCost(otherCost);
		tempA863cooperationBudget.setIndirectCost(indirectCost);
		tempA863cooperationBudget.setPerformanceCost(achievementsCost);
		tempA863cooperationBudget.setFundSum(fundSourse);
		tempA863cooperationBudget.setSubsidizeSpecial(specialFundSource);
		tempA863cooperationBudget.setSelfFinance(selfFundSource);
		tempA863cooperationBudget.setOtherFundsSelf(otherFinanceSource);
		tempA863cooperationBudget.setOwnFundsSelf(itsOwnSource);
		tempA863cooperationBudget.setOtherSelf(otherSource);

		return tempA863cooperationBudget;
	}

	/**
	 * 保存批复预算数到A863sum表中
	 * 
	 * @param itemPK
	 * @param outGoings_Sum
	 * @param directCost_Sum
	 * @param equipmentCost_Sum
	 * @param buyCost_Sum
	 * @param tryToMakeCost_Sum
	 * @param reformLeaseCost_Sum
	 * @param materialCost_Sum
	 * @param testCost_Sum
	 * @param fuelCost_Sum
	 * @param travelCost_Sum
	 * @param conferenceCost_Sum
	 * @param internationalCost_Sum
	 * @param publishCost_Sum
	 * @param labourCost_Sum
	 * @param consultationCost_Sum
	 * @param constructionCost_Sum
	 * @param otherCost_Sum
	 * @param indirectCost_Sum
	 * @param achievementsCost_Sum
	 * @param fundSourse_Sum
	 * @param specialFundSource_Sum
	 * @param selfFundSource_Sum
	 * @param otherFinanceSource_Sum
	 * @param itsOwnSource_Sum
	 * @param otherSource_Sum
	 * @return
	 */
	public boolean storeSummaryBudgetInfo(long itemPK, Double outGoings_Sum,
			Double directCost_Sum, Double equipmentCost_Sum,
			Double buyCost_Sum, Double tryToMakeCost_Sum,
			Double reformLeaseCost_Sum, Double materialCost_Sum,
			Double testCost_Sum, Double fuelCost_Sum, Double travelCost_Sum,
			Double conferenceCost_Sum, Double internationalCost_Sum,
			Double publishCost_Sum, Double labourCost_Sum,
			Double consultationCost_Sum, Double constructionCost_Sum,
			Double otherCost_Sum, Double indirectCost_Sum,
			Double achievementsCost_Sum, Double fundSourse_Sum,
			Double specialFundSource_Sum, Double selfFundSource_Sum,
			Double otherFinanceSource_Sum, Double itsOwnSource_Sum,
			Double otherSource_Sum) {

		List tempA863sumBudgetList = a863sumDAO.findByItemPk(itemPK);

		A863sum tempA863sumBudget;
		if (tempA863sumBudgetList == null || tempA863sumBudgetList.size() == 0) {
			tempA863sumBudget = new A863sum();

			tempA863sumBudget = storePartialA863sumBudgetInfo(
					tempA863sumBudget, itemPK, outGoings_Sum, directCost_Sum,
					equipmentCost_Sum, buyCost_Sum, tryToMakeCost_Sum,
					reformLeaseCost_Sum, materialCost_Sum, testCost_Sum,
					fuelCost_Sum, travelCost_Sum, conferenceCost_Sum,
					internationalCost_Sum, publishCost_Sum, labourCost_Sum,
					consultationCost_Sum, constructionCost_Sum, otherCost_Sum,
					indirectCost_Sum, achievementsCost_Sum, fundSourse_Sum,
					specialFundSource_Sum, selfFundSource_Sum,
					otherFinanceSource_Sum, itsOwnSource_Sum, otherSource_Sum);

			a863sumDAO.save(tempA863sumBudget);

		} else {
			tempA863sumBudget = (A863sum) tempA863sumBudgetList.get(0);
			tempA863sumBudget = storePartialA863sumBudgetInfo(
					tempA863sumBudget, itemPK, outGoings_Sum, directCost_Sum,
					equipmentCost_Sum, buyCost_Sum, tryToMakeCost_Sum,
					reformLeaseCost_Sum, materialCost_Sum, testCost_Sum,
					fuelCost_Sum, travelCost_Sum, conferenceCost_Sum,
					internationalCost_Sum, publishCost_Sum, labourCost_Sum,
					consultationCost_Sum, constructionCost_Sum, otherCost_Sum,
					indirectCost_Sum, achievementsCost_Sum, fundSourse_Sum,
					specialFundSource_Sum, selfFundSource_Sum,
					otherFinanceSource_Sum, itsOwnSource_Sum, otherSource_Sum);

			a863sumDAO.attachDirty(tempA863sumBudget);
		}
		return true;
	}

	/**
	 * 保存批复预算数到tempA863sumBudget对象中，并返回该对象
	 * 
	 * @param tempA863sumBudget
	 * @param itemPK
	 * @param outGoings_Sum
	 * @param directCost_Sum
	 * @param equipmentCost_Sum
	 * @param buyCost_Sum
	 * @param tryToMakeCost_Sum
	 * @param reformLeaseCost_Sum
	 * @param materialCost_Sum
	 * @param testCost_Sum
	 * @param fuelCost_Sum
	 * @param travelCost_Sum
	 * @param conferenceCost_Sum
	 * @param internationalCost_Sum
	 * @param publishCost_Sum
	 * @param labourCost_Sum
	 * @param consultationCost_Sum
	 * @param constructionCost_Sum
	 * @param otherCost_Sum
	 * @param indirectCost_Sum
	 * @param achievementsCost_Sum
	 * @param fundSourse_Sum
	 * @param specialFundSource_Sum
	 * @param selfFundSource_Sum
	 * @param otherFinanceSource_Sum
	 * @param itsOwnSource_Sum
	 * @param otherSource_Sum
	 * @return
	 */
	public A863sum storePartialA863sumBudgetInfo(A863sum tempA863sumBudget,
			long itemPK, Double outGoings_Sum, Double directCost_Sum,
			Double equipmentCost_Sum, Double buyCost_Sum,
			Double tryToMakeCost_Sum, Double reformLeaseCost_Sum,
			Double materialCost_Sum, Double testCost_Sum, Double fuelCost_Sum,
			Double travelCost_Sum, Double conferenceCost_Sum,
			Double internationalCost_Sum, Double publishCost_Sum,
			Double labourCost_Sum, Double consultationCost_Sum,
			Double constructionCost_Sum, Double otherCost_Sum,
			Double indirectCost_Sum, Double achievementsCost_Sum,
			Double fundSourse_Sum, Double specialFundSource_Sum,
			Double selfFundSource_Sum, Double otherFinanceSource_Sum,
			Double itsOwnSource_Sum, Double otherSource_Sum) {

		tempA863sumBudget.setItemPk(itemPK);
		tempA863sumBudget.setCostSum(outGoings_Sum);
		tempA863sumBudget.setDirectCost(directCost_Sum);
		tempA863sumBudget.setEquipmentCost(equipmentCost_Sum);
		tempA863sumBudget.setBuyEquipment(buyCost_Sum);
		tempA863sumBudget.setTrialEquipment(tryToMakeCost_Sum);
		tempA863sumBudget.setTransform(reformLeaseCost_Sum);
		tempA863sumBudget.setMaterialCost(materialCost_Sum);
		tempA863sumBudget.setTestCost(testCost_Sum);
		tempA863sumBudget.setFuelCost(fuelCost_Sum);
		tempA863sumBudget.setTravelCost(travelCost_Sum);
		tempA863sumBudget.setConferenceCost(conferenceCost_Sum);
		tempA863sumBudget.setExchangeCost(internationalCost_Sum);
		tempA863sumBudget.setPublishCost(publishCost_Sum);
		tempA863sumBudget.setServiceCost(labourCost_Sum);
		tempA863sumBudget.setConsultCost(consultationCost_Sum);
		tempA863sumBudget.setConstructionCost(constructionCost_Sum);
		tempA863sumBudget.setOtherCost(otherCost_Sum);
		tempA863sumBudget.setIndirectCost(indirectCost_Sum);
		tempA863sumBudget.setPerformanceCost(achievementsCost_Sum);
		tempA863sumBudget.setFundSum(fundSourse_Sum);
		tempA863sumBudget.setSubsidizeSpecial(specialFundSource_Sum);
		tempA863sumBudget.setSelfFinance(selfFundSource_Sum);
		tempA863sumBudget.setOtherFundsSelf(otherFinanceSource_Sum);
		tempA863sumBudget.setOwnFundsSelf(itsOwnSource_Sum);
		tempA863sumBudget.setOtherSelf(otherSource_Sum);

		return tempA863sumBudget;
	}

	/**
	 * 存储支出数据到表A863outlay中
	 * 
	 * @param outlayPK
	 * @param itemPK
	 * @param buyEquipment
	 * @param trialEquipment
	 * @param transform
	 * @param equipmentCost
	 * @param materialCost
	 * @param testCost
	 * @param fuelCost
	 * @param travelCost
	 * @param conferenceCost
	 * @param exchangeCost
	 * @param publishCost
	 * @param serviceCost
	 * @param consultCost
	 * @param constructionCost
	 * @param otherCost
	 * @param costSum
	 * @param performanceCost
	 * @param indirectCost
	 * @param directCost
	 * @return
	 */
	public long storeA863OutlayInfo(long outlayPK, long itemPK,
			Double buyEquipment, Double trialEquipment, Double transform,
			Double equipmentCost, Double materialCost, Double testCost,
			Double fuelCost, Double travelCost, Double conferenceCost,
			Double exchangeCost, Double publishCost, Double serviceCost,
			Double consultCost, Double constructionCost, Double otherCost,
			Double costSum, Double performanceCost, Double indirectCost,
			Double directCost) {

		A863outlay tempA863outlay = a863outlayDAO.findById(outlayPK);

		if (tempA863outlay == null) {
			tempA863outlay = new A863outlay();
			tempA863outlay.setItemPk(itemPK);

			tempA863outlay = storePartialA863outlayInfo(tempA863outlay,
					buyEquipment, trialEquipment, transform, equipmentCost,
					materialCost, testCost, fuelCost, travelCost,
					conferenceCost, exchangeCost, publishCost, serviceCost,
					consultCost, constructionCost, otherCost, costSum,
					performanceCost, indirectCost, directCost);

			a863outlayDAO.save(tempA863outlay);
		} else {

			tempA863outlay = storePartialA863outlayInfo(tempA863outlay,
					buyEquipment, trialEquipment, transform, equipmentCost,
					materialCost, testCost, fuelCost, travelCost,
					conferenceCost, exchangeCost, publishCost, serviceCost,
					consultCost, constructionCost, otherCost, costSum,
					performanceCost, indirectCost, directCost);

			a863outlayDAO.attachDirty(tempA863outlay);
		}

		return tempA863outlay.getA863outlayPk();
	}

	/**
	 * 存储支出数据到对象A863outlay中，并返回改对象
	 * 
	 * @param tempA863outlay
	 * @param buyEquipment
	 * @param trialEquipment
	 * @param transform
	 * @param equipmentCost
	 * @param materialCost
	 * @param testCost
	 * @param fuelCost
	 * @param travelCost
	 * @param conferenceCost
	 * @param exchangeCost
	 * @param publishCost
	 * @param serviceCost
	 * @param consultCost
	 * @param constructionCost
	 * @param otherCost
	 * @param costSum
	 * @param performanceCost
	 * @param indirectCost
	 * @param directCost
	 * @return
	 */
	public A863outlay storePartialA863outlayInfo(A863outlay tempA863outlay,
			Double buyEquipment, Double trialEquipment, Double transform,
			Double equipmentCost, Double materialCost, Double testCost,
			Double fuelCost, Double travelCost, Double conferenceCost,
			Double exchangeCost, Double publishCost, Double serviceCost,
			Double consultCost, Double constructionCost, Double otherCost,
			Double costSum, Double performanceCost, Double indirectCost,
			Double directCost) {

		tempA863outlay.setBuyEquipment(buyEquipment);
		tempA863outlay.setTrialEquipment(trialEquipment);
		tempA863outlay.setTransform(transform);
		tempA863outlay.setEquipmentCost(equipmentCost);
		tempA863outlay.setMaterialCost(materialCost);
		tempA863outlay.setTestCost(testCost);
		tempA863outlay.setFuelCost(fuelCost);
		tempA863outlay.setTravelCost(travelCost);
		tempA863outlay.setConferenceCost(conferenceCost);
		tempA863outlay.setExchangeCost(exchangeCost);
		tempA863outlay.setPublishCost(publishCost);
		tempA863outlay.setServiceCost(serviceCost);
		tempA863outlay.setConsultCost(consultCost);
		tempA863outlay.setConstructionCost(constructionCost);
		tempA863outlay.setOtherCost(otherCost);
		tempA863outlay.setCostSum(costSum);
		tempA863outlay.setPerformanceCost(performanceCost);
		tempA863outlay.setIndirectCost(indirectCost);
		tempA863outlay.setDirectCost(directCost);

		// 获取当前页面请求主机的时间
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = formatter.format(date);
		tempA863outlay.setOutlayTime(currentDate);

		return tempA863outlay;

	}

	/**
	 * 存储支出说明到表A863remark中
	 * 
	 * @param outlayPK
	 * @param itemPK
	 * @param buyEquipment
	 * @param trialEquipment
	 * @param transform
	 * @param equipmentCost
	 * @param materialCost
	 * @param testCost
	 * @param fuelCost
	 * @param travelCost
	 * @param conferenceCost
	 * @param exchangeCost
	 * @param publishCost
	 * @param serviceCost
	 * @param consultCost
	 * @param constructionCost
	 * @param otherCost
	 * @param costSum
	 * @param performanceCost
	 * @param indirectCost
	 * @param directCost
	 * @return
	 */
	public boolean storeA863OutlayRemark(long outlayPK, long itemPK,
			String buyEquipment, String trialEquipment, String transform,
			String equipmentCost, String materialCost, String testCost,
			String fuelCost, String travelCost, String conferenceCost,
			String exchangeCost, String publishCost, String serviceCost,
			String consultCost, String constructionCost, String otherCost,
			String costSum, String performanceCost, String indirectCost,
			String directCost) {

		A863remark tempA863remark;

		List tempA863remarkList = a863remarkDAO.findByA863outlayPk(outlayPK);

		if (tempA863remarkList == null || tempA863remarkList.size() == 0) {
			tempA863remark = new A863remark();
			tempA863remark.setItemPk(itemPK);
			tempA863remark = storePartialA863remarkInfo(tempA863remark,
					buyEquipment, trialEquipment, transform, equipmentCost,
					materialCost, testCost, fuelCost, travelCost,
					conferenceCost, exchangeCost, publishCost, serviceCost,
					consultCost, constructionCost, otherCost, costSum,
					performanceCost, indirectCost, directCost);

			a863remarkDAO.save(tempA863remark);
		} else {
			tempA863remark = (A863remark) tempA863remarkList.get(0);
			tempA863remark = storePartialA863remarkInfo(tempA863remark,
					buyEquipment, trialEquipment, transform, equipmentCost,
					materialCost, testCost, fuelCost, travelCost,
					conferenceCost, exchangeCost, publishCost, serviceCost,
					consultCost, constructionCost, otherCost, costSum,
					performanceCost, indirectCost, directCost);
			a863remarkDAO.attachDirty(tempA863remark);
		}
		// A863remark
		return true;
	}

	/**
	 * 存储支出说明到对象A863remark中，并返回该对象
	 * 
	 * @param tempA863remark
	 * @param buyEquipment
	 * @param trialEquipment
	 * @param transform
	 * @param equipmentCost
	 * @param materialCost
	 * @param testCost
	 * @param fuelCost
	 * @param travelCost
	 * @param conferenceCost
	 * @param exchangeCost
	 * @param publishCost
	 * @param serviceCost
	 * @param consultCost
	 * @param constructionCost
	 * @param otherCost
	 * @param costSum
	 * @param performanceCost
	 * @param indirectCost
	 * @param directCost
	 * @return
	 */
	public A863remark storePartialA863remarkInfo(A863remark tempA863remark,
			String buyEquipment, String trialEquipment, String transform,
			String equipmentCost, String materialCost, String testCost,
			String fuelCost, String travelCost, String conferenceCost,
			String exchangeCost, String publishCost, String serviceCost,
			String consultCost, String constructionCost, String otherCost,
			String costSum, String performanceCost, String indirectCost,
			String directCost) {

		tempA863remark.setBuyEquipment(buyEquipment);
		tempA863remark.setTrialEquipment(trialEquipment);
		tempA863remark.setTransform(transform);
		tempA863remark.setEquipmentCost(equipmentCost);
		tempA863remark.setMaterialCost(materialCost);
		tempA863remark.setTestCost(testCost);
		tempA863remark.setFuelCost(fuelCost);
		tempA863remark.setTravelCost(travelCost);
		tempA863remark.setConferenceCost(conferenceCost);
		tempA863remark.setExchangeCost(exchangeCost);
		tempA863remark.setPublishCost(publishCost);
		tempA863remark.setServiceCost(serviceCost);
		tempA863remark.setConsultCost(consultCost);
		tempA863remark.setConstructionCost(constructionCost);
		tempA863remark.setOtherCost(otherCost);
		tempA863remark.setCostSum(costSum);
		tempA863remark.setPerformanceCost(performanceCost);
		tempA863remark.setIndirectCost(indirectCost);
		tempA863remark.setDirectCost(directCost);

		return tempA863remark;
	}

	/**
	 * 根据itemPK返回该项目的支出历史列表
	 * 
	 * @param itemPK
	 * @return
	 */
	public List acquireA863OutlayHistoryInfoByItemPK(long itemPK) {

		List a863OutlayHistoryList = a863outlayDAO.findByItemPk(itemPK);
		return a863OutlayHistoryList;
	}

	// setter&&getter
	public ItemDAO getItemDAO() {
		return itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public A863njubudgetDAO getA863njubudgetDAO() {
		return a863njubudgetDAO;
	}

	public void setA863njubudgetDAO(A863njubudgetDAO a863njubudgetDAO) {
		this.a863njubudgetDAO = a863njubudgetDAO;
	}

	public A863cooperationBudgetDAO getA863cooperationBudgetDAO() {
		return a863cooperationBudgetDAO;
	}

	public void setA863cooperationBudgetDAO(
			A863cooperationBudgetDAO a863cooperationBudgetDAO) {
		this.a863cooperationBudgetDAO = a863cooperationBudgetDAO;
	}

	public A863sumDAO getA863sumDAO() {
		return a863sumDAO;
	}

	public void setA863sumDAO(A863sumDAO a863sumDAO) {
		this.a863sumDAO = a863sumDAO;
	}

	public A863itemDAO getA863itemDAO() {
		return a863itemDAO;
	}

	public void setA863itemDAO(A863itemDAO a863itemDAO) {
		this.a863itemDAO = a863itemDAO;
	}

	public A863outlayDAO getA863outlayDAO() {
		return a863outlayDAO;
	}

	public void setA863outlayDAO(A863outlayDAO a863outlayDAO) {
		this.a863outlayDAO = a863outlayDAO;
	}

	public A863remarkDAO getA863remarkDAO() {
		return a863remarkDAO;
	}

	public void setA863remarkDAO(A863remarkDAO a863remarkDAO) {
		this.a863remarkDAO = a863remarkDAO;
	}

}
