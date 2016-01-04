package com.stoms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stoms.dao.A863adjustDAO;
import com.stoms.dao.A863approvalBudgetDAO;
import com.stoms.dao.A863detailBudgetDAO;
import com.stoms.dao.A863njubudgetDAO;
import com.stoms.dao.ItemDAO;
import com.stoms.model.A863approvalBudget;
import com.stoms.model.A863detailBudget;
import com.stoms.model.A863njubudget;

public class A863DetailBudgetService {

	private A863detailBudgetDAO a863detailBudgetDAO;
	private A863detailBudget a863NJUdetailBudget = new A863detailBudget();
	private A863detailBudget a863ApprovaldetailBudget = new A863detailBudget();
	private List<A863detailBudget> a863CooperationBudget = new ArrayList();
	private A863njubudgetDAO a863njubudgetDAO;
	private A863approvalBudgetDAO a863approvalBudgetDAO;

	private void acquireDetailBudget(Long itemPK, int budgetID) {

		List<A863detailBudget> lists = a863detailBudgetDAO
				.findbyItemPKandBudgetID(itemPK, budgetID);
		for (A863detailBudget a : lists) {

			if (a.getOrgSign().equals("org0")) {
				a863NJUdetailBudget = a;
			} else if (a.getOrgSign().equals("orgSum")) {
				a863ApprovaldetailBudget = a;
			} else {
				a863CooperationBudget.add(a);
			}
		}
		return;

	}

	public A863detailBudget acquireNJUDetailBudget(Long itemPK, int budgetID) {
		acquireDetailBudget(itemPK, budgetID);
		return a863NJUdetailBudget;
	}

	public List acquireCooperationDetailBudget(Long itemPK, int budgetID) {
		acquireDetailBudget(itemPK, budgetID);
		return a863CooperationBudget;
	}

	public A863detailBudget acquireApprovalDetailBudget(Long itemPK,
			int budgetID) {
		acquireDetailBudget(itemPK, budgetID);
		return a863ApprovaldetailBudget;
	}

	
	public String saveSumBudget(Long itemPK) {
		boolean flag1 = false;
		boolean flag2 = false;
		A863njubudget sum11 = new A863njubudget();
		A863approvalBudget sum22 = new A863approvalBudget();

		List<A863detailBudget> lists = a863detailBudgetDAO.findByItemPk(itemPK);
		for (A863detailBudget a : lists) {

			if (a.getOrgSign().equals("org0")) {
				flag1 = true;
				sum11.setItemPk(a.getItemPk());
				sum11.setItemId(a.getItemId());
				sum11.setBuyEquipment(sum11.getBuyEquipment()
						+ a.getBuyEquipment());
				sum11.setTrialEquipment(sum11.getTrialEquipment()
						+ a.getTrialEquipment());
				sum11.setTransform(sum11.getTransform() + a.getTransform());
				sum11.setEquipmentCost(sum11.getEquipmentCost()
						+ a.getEquipmentCost());
				sum11.setMaterialCost(sum11.getMaterialCost()
						+ a.getMaterialCost());
				sum11.setTestCost(sum11.getTestCost() + a.getTestCost());
				sum11.setFuelCost(sum11.getFuelCost() + a.getFuelCost());
				sum11.setTravelCost(sum11.getTravelCost() + a.getTravelCost());
				sum11.setConferenceCost(sum11.getConferenceCost()
						+ a.getConferenceCost());
				sum11.setExchangeCost(sum11.getExchangeCost()
						+ a.getExchangeCost());
				sum11.setPublishCost(sum11.getPublishCost()
						+ a.getPublishCost());
				sum11.setServiceCost(sum11.getServiceCost()
						+ a.getServiceCost());
				sum11.setConsultCost(sum11.getConsultCost()
						+ a.getConsultCost());
				sum11.setConstructionCost(sum11.getConstructionCost()
						+ a.getConstructionCost());
				sum11.setOtherCost(sum11.getOtherCost() + a.getOtherCost());
				sum11.setDirectCost(sum11.getDirectCost() + a.getDirectCost());
				sum11.setCostSum(sum11.getCostSum() + a.getCostSum());
				sum11.setPerformanceCost(sum11.getPerformanceCost()
						+ a.getPerformanceCost());
				sum11.setIndirectCost(sum11.getIndirectCost()
						+ a.getIndirectCost());
				sum11.setSubsidizeSpecial(sum11.getSubsidizeSpecial()
						+ a.getSubsidizeSpecial());
				sum11.setOtherFundsSelf(sum11.getOtherFundsSelf()
						+ a.getOtherFundsSelf());
				sum11.setOwnFundsSelf(sum11.getOwnFundsSelf()
						+ a.getOwnFundsSelf());
				sum11.setOtherSelf(sum11.getOtherSelf() + a.getOtherSelf());
				sum11.setSelfFinance(sum11.getSelfFinance()
						+ a.getSelfFinance());
				sum11.setFundSum(sum11.getFundSum() + a.getFundSum());
				sum11.setAstatus("31");
			} else if (a.getOrgSign().equals("orgSum")) {
				flag2 = true;
				sum22.setItemPk(a.getItemPk());
				sum22.setItemId(a.getItemId());
				sum22.setBuyEquipment(sum22.getBuyEquipment()
						+ a.getBuyEquipment());
				sum22.setTrialEquipment(sum22.getTrialEquipment()
						+ a.getTrialEquipment());
				sum22.setTransform(sum22.getTransform() + a.getTransform());
				sum22.setEquipmentCost(sum22.getEquipmentCost()
						+ a.getEquipmentCost());
				sum22.setMaterialCost(sum22.getMaterialCost()
						+ a.getMaterialCost());
				sum22.setTestCost(sum22.getTestCost() + a.getTestCost());
				sum22.setFuelCost(sum22.getFuelCost() + a.getFuelCost());
				sum22.setTravelCost(sum22.getTravelCost() + a.getTravelCost());
				sum22.setConferenceCost(sum22.getConferenceCost()
						+ a.getConferenceCost());
				sum22.setExchangeCost(sum22.getExchangeCost()
						+ a.getExchangeCost());
				sum22.setPublishCost(sum22.getPublishCost()
						+ a.getPublishCost());
				sum22.setServiceCost(sum22.getServiceCost()
						+ a.getServiceCost());
				sum22.setConsultCost(sum22.getConsultCost()
						+ a.getConsultCost());
				sum22.setConstructionCost(sum22.getConstructionCost()
						+ a.getConstructionCost());
				sum22.setOtherCost(sum22.getOtherCost() + a.getOtherCost());
				sum22.setDirectCost(sum22.getDirectCost() + a.getDirectCost());
				sum22.setCostSum(sum22.getCostSum() + a.getCostSum());
				sum22.setPerformanceCost(sum22.getPerformanceCost()
						+ a.getPerformanceCost());
				sum22.setIndirectCost(sum22.getIndirectCost()
						+ a.getIndirectCost());
				sum22.setSubsidizeSpecial(sum22.getSubsidizeSpecial()
						+ a.getSubsidizeSpecial());
				sum22.setOtherFundsSelf(sum22.getOtherFundsSelf()
						+ a.getOtherFundsSelf());
				sum22.setOwnFundsSelf(sum22.getOwnFundsSelf()
						+ a.getOwnFundsSelf());
				sum22.setOtherSelf(sum22.getOtherSelf() + a.getOtherSelf());
				sum22.setSelfFinance(sum22.getSelfFinance()
						+ a.getSelfFinance());
				sum22.setFundSum(sum22.getFundSum() + a.getFundSum());
				sum22.setAstatus("31");

			}
		}
		if (flag1) {
			a863njubudgetDAO.save(sum11);
		}
		if (flag2) {
			a863approvalBudgetDAO.save(sum22);
		}

		return "success";

	}

	/**
	 * 保存南京大学预算信息到A863detailBudget表中
	 * 
	 * @param itemPK
	 * @param indexOfBudget
	 * @param startYear
	 * @param endYear
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

	public boolean storeA863njubudgetInfoInDetail(long itemPK,
			int indexOfBudget, String startYear, String endYear,
			Double outGoings, Double directCost, Double equipmentCost,
			Double buyCost, Double tryToMakeCost, Double reformLeaseCost,
			Double materialCost, Double testCost, Double fuelCost,
			Double travelCost, Double conferenceCost, Double internationalCost,
			Double publishCost, Double labourCost, Double consultationCost,
			Double constructionCost, Double otherCost, Double indirectCost,
			Double achievementsCost, Double fundSourse,
			Double specialFundSource, Double selfFundSource,
			Double otherFinanceSource, Double itsOwnSource, Double otherSource) {

		A863detailBudget tempA863detailBudget = acquireNJUDetailBudget(itemPK,
				indexOfBudget);

		if (tempA863detailBudget == null) {
			tempA863detailBudget = new A863detailBudget();
			tempA863detailBudget.setItemPk(itemPK);
			tempA863detailBudget.setBudgerId(indexOfBudget);
			tempA863detailBudget.setOrgSign("org0");

			tempA863detailBudget = storePartialA863njubudgetInfoInDetail(
					tempA863detailBudget, startYear, endYear, outGoings,
					directCost, equipmentCost, buyCost, tryToMakeCost,
					reformLeaseCost, materialCost, testCost, fuelCost,
					travelCost, conferenceCost, internationalCost, publishCost,
					labourCost, consultationCost, constructionCost, otherCost,
					indirectCost, achievementsCost, fundSourse,
					specialFundSource, selfFundSource, otherFinanceSource,
					itsOwnSource, otherSource);

			a863detailBudgetDAO.save(tempA863detailBudget);
		} else {

			tempA863detailBudget = storePartialA863njubudgetInfoInDetail(
					tempA863detailBudget, startYear, endYear, outGoings,
					directCost, equipmentCost, buyCost, tryToMakeCost,
					reformLeaseCost, materialCost, testCost, fuelCost,
					travelCost, conferenceCost, internationalCost, publishCost,
					labourCost, consultationCost, constructionCost, otherCost,
					indirectCost, achievementsCost, fundSourse,
					specialFundSource, selfFundSource, otherFinanceSource,
					itsOwnSource, otherSource);

			a863detailBudgetDAO.attachDirty(tempA863detailBudget);
		}

		return true;

	}

	/**
	 * 保存南京大学预算信息到A863detailBudget对象中，并返回该对象
	 * 
	 * @param tempA863detailBudget
	 * @param startYear
	 * @param endYear
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
	
	public A863detailBudget storePartialA863njubudgetInfoInDetail(
			A863detailBudget tempA863detailBudget, String startYear,
			String endYear, Double outGoings, Double directCost,
			Double equipmentCost, Double buyCost, Double tryToMakeCost,
			Double reformLeaseCost, Double materialCost, Double testCost,
			Double fuelCost, Double travelCost, Double conferenceCost,
			Double internationalCost, Double publishCost, Double labourCost,
			Double consultationCost, Double constructionCost, Double otherCost,
			Double indirectCost, Double achievementsCost, Double fundSourse,
			Double specialFundSource, Double selfFundSource,
			Double otherFinanceSource, Double itsOwnSource, Double otherSource) {

		// tempA863detailBudget.setTimeLower(startYear);
		// tempA863detailBudget.setTimeUpper(endYear);
		// tempA863detailBudget.set
		tempA863detailBudget.setCostSum(outGoings);
		tempA863detailBudget.setDirectCost(directCost);
		tempA863detailBudget.setEquipmentCost(equipmentCost);
		tempA863detailBudget.setBuyEquipment(buyCost);
		tempA863detailBudget.setTrialEquipment(tryToMakeCost);
		tempA863detailBudget.setTransform(reformLeaseCost);
		tempA863detailBudget.setMaterialCost(materialCost);
		tempA863detailBudget.setTestCost(testCost);
		tempA863detailBudget.setFuelCost(fuelCost);
		tempA863detailBudget.setTravelCost(travelCost);
		tempA863detailBudget.setConferenceCost(conferenceCost);
		tempA863detailBudget.setExchangeCost(internationalCost);
		tempA863detailBudget.setPublishCost(publishCost);
		tempA863detailBudget.setServiceCost(labourCost);
		tempA863detailBudget.setConsultCost(consultationCost);
		tempA863detailBudget.setConstructionCost(constructionCost);
		tempA863detailBudget.setOtherCost(otherCost);
		tempA863detailBudget.setIndirectCost(indirectCost);
		tempA863detailBudget.setPerformanceCost(achievementsCost);
		tempA863detailBudget.setFundSum(fundSourse);
		tempA863detailBudget.setSubsidizeSpecial(specialFundSource);
		tempA863detailBudget.setSelfFinance(selfFundSource);
		tempA863detailBudget.setOtherFundsSelf(otherFinanceSource);
		tempA863detailBudget.setOwnFundsSelf(itsOwnSource);
		tempA863detailBudget.setOtherSelf(otherSource);

		return tempA863detailBudget;
	}

	/**
	 * 存储合作单位信息到A863detailBudget表中，在存入之前删除该项目该批次的合作单位信息
	 * @param itemPK
	 * @param indexOfBudget
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
	
	public boolean storeCooperationBudgetInfoInDetail(long itemPK,
			int indexOfBudget, String[] organizationName_Array,
			Double[] outGoings_Array, Double[] directCost_Array,
			Double[] equipmentCost_Array, Double[] buyCost_Array,
			Double[] tryToMakeCost_Array, Double[] reformLeaseCost_Array,
			Double[] materialCost_Array, Double[] testCost_Array,
			Double[] fuelCost_Array, Double[] travelCost_Array,
			Double[] conferenceCost_Array, Double[] internationalCost_Array,
			Double[] publishCost_Array, Double[] labourCost_Array,
			Double[] consultationCost_Array, Double[] constructionCost_Array,
			Double[] otherCost_Array, Double[] indirectCost_Array,
			Double[] achievementsCost_Array, Double[] fundSourse_Array,
			Double[] specialFundSource_Array, Double[] selfFundSource_Array,
			Double[] otherFinanceSource_Array, Double[] itsOwnSource_Array,
			Double[] otherSource_Array) {

		List<A863detailBudget> tempCooperationBudegetList = acquireCooperationDetailBudget(
				itemPK, indexOfBudget);

		if (tempCooperationBudegetList != null
				&& tempCooperationBudegetList.size() > 0) {

			int tempListLength = tempCooperationBudegetList.size();

			for (A863detailBudget tempA863detailBudget : tempCooperationBudegetList) {
				a863detailBudgetDAO.delete(tempA863detailBudget);
			}
		}

		for (int i = 1; i < organizationName_Array.length; i++) {

			A863detailBudget tempA863detailBudget = new A863detailBudget();

			tempA863detailBudget = storePartialCooperationBudgetInfoInDetail(
					tempA863detailBudget, itemPK, indexOfBudget, i,
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

			a863detailBudgetDAO.save(tempA863detailBudget);
		}

		return true;
	}

	/**
	 * 存储合作单位信息到A863detailBudget对象中，并返回该临时对象
	 * @param tempA863detailBudget
	 * @param itemPK
	 * @param indexOfBudget
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
	public A863detailBudget storePartialCooperationBudgetInfoInDetail(
			A863detailBudget tempA863detailBudget, long itemPK,
			int indexOfBudget, int index, String organizationName,
			Double outGoings, Double directCost, Double equipmentCost,
			Double buyCost, Double tryToMakeCost, Double reformLeaseCost,
			Double materialCost, Double testCost, Double fuelCost,
			Double travelCost, Double conferenceCost, Double internationalCost,
			Double publishCost, Double labourCost, Double consultationCost,
			Double constructionCost, Double otherCost, Double indirectCost,
			Double achievementsCost, Double fundSourse,
			Double specialFundSource, Double selfFundSource,
			Double otherFinanceSource, Double itsOwnSource, Double otherSource) {

		tempA863detailBudget.setItemPk(itemPK);
		tempA863detailBudget.setBudgerId(indexOfBudget);
		tempA863detailBudget.setOrgSign("org" + index);
		tempA863detailBudget.setCooperationName(organizationName);
		tempA863detailBudget.setCostSum(outGoings);
		tempA863detailBudget.setDirectCost(directCost);
		tempA863detailBudget.setEquipmentCost(equipmentCost);
		tempA863detailBudget.setBuyEquipment(buyCost);
		tempA863detailBudget.setTrialEquipment(tryToMakeCost);
		tempA863detailBudget.setTransform(reformLeaseCost);
		tempA863detailBudget.setMaterialCost(materialCost);
		tempA863detailBudget.setTestCost(testCost);
		tempA863detailBudget.setFuelCost(fuelCost);
		tempA863detailBudget.setTravelCost(travelCost);
		tempA863detailBudget.setConferenceCost(conferenceCost);
		tempA863detailBudget.setExchangeCost(internationalCost);
		tempA863detailBudget.setPublishCost(publishCost);
		tempA863detailBudget.setServiceCost(labourCost);
		tempA863detailBudget.setConsultCost(consultationCost);
		tempA863detailBudget.setConstructionCost(constructionCost);
		tempA863detailBudget.setOtherCost(otherCost);
		tempA863detailBudget.setIndirectCost(indirectCost);
		tempA863detailBudget.setPerformanceCost(achievementsCost);
		tempA863detailBudget.setFundSum(fundSourse);
		tempA863detailBudget.setSubsidizeSpecial(specialFundSource);
		tempA863detailBudget.setSelfFinance(selfFundSource);
		tempA863detailBudget.setOtherFundsSelf(otherFinanceSource);
		tempA863detailBudget.setOwnFundsSelf(itsOwnSource);
		tempA863detailBudget.setOtherSelf(otherSource);

		return tempA863detailBudget;
	}

	/**
	 * 存储批复预算数到A863detailBudget表中
	 * @param itemPK
	 * @param indexOfBudget
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
	public boolean storeSummaryBudgetInfoInDetail(long itemPK,
			int indexOfBudget, Double outGoings_Sum, Double directCost_Sum,
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

		A863detailBudget tempA863detailBudget = acquireApprovalDetailBudget(
				itemPK, indexOfBudget);

		if (tempA863detailBudget == null) {
			tempA863detailBudget = new A863detailBudget();
			tempA863detailBudget.setItemPk(itemPK);
			tempA863detailBudget.setBudgerId(indexOfBudget);
			tempA863detailBudget.setOrgSign("orgSum");

			tempA863detailBudget = storePartialA863SummaryBudgetInfoInDetail(
					tempA863detailBudget, outGoings_Sum, directCost_Sum,
					equipmentCost_Sum, buyCost_Sum, tryToMakeCost_Sum,
					reformLeaseCost_Sum, materialCost_Sum, testCost_Sum,
					fuelCost_Sum, travelCost_Sum, conferenceCost_Sum,
					internationalCost_Sum, publishCost_Sum, labourCost_Sum,
					consultationCost_Sum, constructionCost_Sum, otherCost_Sum,
					indirectCost_Sum, achievementsCost_Sum, fundSourse_Sum,
					specialFundSource_Sum, selfFundSource_Sum,
					otherFinanceSource_Sum, itsOwnSource_Sum, otherSource_Sum);

			a863detailBudgetDAO.save(tempA863detailBudget);
		} else {

			tempA863detailBudget = storePartialA863SummaryBudgetInfoInDetail(
					tempA863detailBudget, outGoings_Sum, directCost_Sum,
					equipmentCost_Sum, buyCost_Sum, tryToMakeCost_Sum,
					reformLeaseCost_Sum, materialCost_Sum, testCost_Sum,
					fuelCost_Sum, travelCost_Sum, conferenceCost_Sum,
					internationalCost_Sum, publishCost_Sum, labourCost_Sum,
					consultationCost_Sum, constructionCost_Sum, otherCost_Sum,
					indirectCost_Sum, achievementsCost_Sum, fundSourse_Sum,
					specialFundSource_Sum, selfFundSource_Sum,
					otherFinanceSource_Sum, itsOwnSource_Sum, otherSource_Sum);

			a863detailBudgetDAO.attachDirty(tempA863detailBudget);
		}

		return true;
	}

	/**
	 * 存储批复信息到A863detailBudget对象中，并返回该零食对象
	 * @param tempA863detailBudget
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
	public A863detailBudget storePartialA863SummaryBudgetInfoInDetail(
			A863detailBudget tempA863detailBudget, Double outGoings_Sum,
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

		tempA863detailBudget.setCostSum(outGoings_Sum);
		tempA863detailBudget.setDirectCost(directCost_Sum);
		tempA863detailBudget.setEquipmentCost(equipmentCost_Sum);
		tempA863detailBudget.setBuyEquipment(buyCost_Sum);
		tempA863detailBudget.setTrialEquipment(tryToMakeCost_Sum);
		tempA863detailBudget.setTransform(reformLeaseCost_Sum);
		tempA863detailBudget.setMaterialCost(materialCost_Sum);
		tempA863detailBudget.setTestCost(testCost_Sum);
		tempA863detailBudget.setFuelCost(fuelCost_Sum);
		tempA863detailBudget.setTravelCost(travelCost_Sum);
		tempA863detailBudget.setConferenceCost(conferenceCost_Sum);
		tempA863detailBudget.setExchangeCost(internationalCost_Sum);
		tempA863detailBudget.setPublishCost(publishCost_Sum);
		tempA863detailBudget.setServiceCost(labourCost_Sum);
		tempA863detailBudget.setConsultCost(consultationCost_Sum);
		tempA863detailBudget.setConstructionCost(constructionCost_Sum);
		tempA863detailBudget.setOtherCost(otherCost_Sum);
		tempA863detailBudget.setIndirectCost(indirectCost_Sum);
		tempA863detailBudget.setPerformanceCost(achievementsCost_Sum);
		tempA863detailBudget.setFundSum(fundSourse_Sum);
		tempA863detailBudget.setSubsidizeSpecial(specialFundSource_Sum);
		tempA863detailBudget.setSelfFinance(selfFundSource_Sum);
		tempA863detailBudget.setOtherFundsSelf(otherFinanceSource_Sum);
		tempA863detailBudget.setOwnFundsSelf(itsOwnSource_Sum);
		tempA863detailBudget.setOtherSelf(otherSource_Sum);
		
		return tempA863detailBudget;
	}

	// setters&getters
	public A863detailBudgetDAO getA863detailBudgetDAO() {
		return a863detailBudgetDAO;
	}

	public void setA863detailBudgetDAO(A863detailBudgetDAO a863detailBudgetDAO) {
		this.a863detailBudgetDAO = a863detailBudgetDAO;
	}

	public A863detailBudget getA863NJUdetailBudget() {
		return a863NJUdetailBudget;
	}

	public void setA863NJUdetailBudget(A863detailBudget a863njUdetailBudget) {
		a863NJUdetailBudget = a863njUdetailBudget;
	}

	public A863detailBudget getA863ApprovaldetailBudget() {
		return a863ApprovaldetailBudget;
	}

	public void setA863ApprovaldetailBudget(
			A863detailBudget a863ApprovaldetailBudget) {
		this.a863ApprovaldetailBudget = a863ApprovaldetailBudget;
	}

	public List<A863detailBudget> getA863CooperationBudget() {
		return a863CooperationBudget;
	}

	public void setA863CooperationBudget(
			List<A863detailBudget> a863CooperationBudget) {
		this.a863CooperationBudget = a863CooperationBudget;
	}

	public A863njubudgetDAO getA863njubudgetDAO() {
		return a863njubudgetDAO;
	}

	public void setA863njubudgetDAO(A863njubudgetDAO a863njubudgetDAO) {
		this.a863njubudgetDAO = a863njubudgetDAO;
	}

	public A863approvalBudgetDAO getA863approvalBudgetDAO() {
		return a863approvalBudgetDAO;
	}

	public void setA863approvalBudgetDAO(
			A863approvalBudgetDAO a863approvalBudgetDAO) {
		this.a863approvalBudgetDAO = a863approvalBudgetDAO;
	}

}
