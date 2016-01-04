package com.stoms.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.stoms.dao.ItemDAO;
import com.stoms.dao.SocialScienceApprovalBudgetDAO;
import com.stoms.dao.SocialScienceCooperationBudgetDAO;
import com.stoms.dao.SocialScienceItemDAO;
import com.stoms.dao.SocialScienceNjubudgetDAO;
import com.stoms.dao.SocialScienceOutlayDAO;
import com.stoms.dao.SocialScienceRemarkDAO;
import com.stoms.model.A863cooperationBudget;
import com.stoms.model.Item;
import com.stoms.model.SocialScienceApprovalBudget;
import com.stoms.model.SocialScienceCooperationBudget;
import com.stoms.model.SocialScienceItem;
import com.stoms.model.SocialScienceNjubudget;
import com.stoms.model.SocialScienceOutlay;
import com.stoms.model.SocialScienceRemark;

/**
 * 
 * @author Administrator
 * 
 */
public class SocialScienceFundBudgetService {

	private ItemDAO itemDAO;
	private SocialScienceItemDAO socialScienceItemDAO;
	private SocialScienceNjubudgetDAO socialScienceNjubudgetDAO;
	private SocialScienceCooperationBudgetDAO socialScienceCooperationBudgetDAO;
	private SocialScienceApprovalBudgetDAO socialScienceApprovalBudgetDAO;
	private SocialScienceOutlayDAO socialScienceOutlayDAO;
	private SocialScienceRemarkDAO socialScienceRemarkDAO;

	public SocialScienceOutlayDAO getSocialScienceOutlayDAO() {
		return socialScienceOutlayDAO;
	}

	public void setSocialScienceOutlayDAO(
			SocialScienceOutlayDAO socialScienceOutlayDAO) {
		this.socialScienceOutlayDAO = socialScienceOutlayDAO;
	}

	/**
	 * 根据ItemPK取得该社科基金的基本信息
	 * 
	 * @param itemPK
	 * @return
	 */
	public SocialScienceItem acquireSocialScienceItemBaseInfoByItemPK(
			long itemPK) {

		SocialScienceItem tempSocialScienceItem;

		List tempSocialScienceItemList = socialScienceItemDAO
				.findByItemPk(itemPK);

		if (tempSocialScienceItemList == null
				|| tempSocialScienceItemList.size() == 0) {

			Item tempItemInfo = itemDAO.findById(itemPK);

			if (tempItemInfo == null) {
				return null;
			}

			tempSocialScienceItem = new SocialScienceItem();
			tempSocialScienceItem.setItemPk(itemPK);
			tempSocialScienceItem.setItemName(tempItemInfo.getItemName());
			tempSocialScienceItem.setItemId(tempItemInfo.getItemId());
			tempSocialScienceItem.setContractId(tempItemInfo.getContractId());
			tempSocialScienceItem.setTeacherName(tempItemInfo.getTeacherName());
			tempSocialScienceItem.setCardId(tempItemInfo.getCardId());

		} else {
			tempSocialScienceItem = (SocialScienceItem) tempSocialScienceItemList
					.get(0);
		}

		return tempSocialScienceItem;
	}

	/**
	 * 
	 * @param itemPK
	 * @return
	 */
	public SocialScienceNjubudget acquireSocialScienceNjubudgetInfoByItemPK(
			long itemPK) {

		SocialScienceNjubudget tempSocialScienceNjubudget;

		List tempSocialScienceNjubudgetList = socialScienceNjubudgetDAO
				.findByItemPk(itemPK);

		if (tempSocialScienceNjubudgetList == null
				|| tempSocialScienceNjubudgetList.size() == 0) {
			tempSocialScienceNjubudget = new SocialScienceNjubudget();
		} else {
			tempSocialScienceNjubudget = (SocialScienceNjubudget) tempSocialScienceNjubudgetList
					.get(0);
		}

		return tempSocialScienceNjubudget;
	}

	public List acquireSocialScienceCooperationBudgetInfoByItemPK(long itemPK) {

		List<SocialScienceCooperationBudget> tempSocialScienceCooperationBudgetList = socialScienceCooperationBudgetDAO
				.findByItemPk(itemPK);

		int addBudgetInfoNum = 0;
		if (tempSocialScienceCooperationBudgetList == null) {
			addBudgetInfoNum = 4;
		} else {
			addBudgetInfoNum = 4 - tempSocialScienceCooperationBudgetList
					.size();
		}

		for (int i = 0; i < addBudgetInfoNum; i++) {
			SocialScienceCooperationBudget tempSocialScienceCooperationBudget = new SocialScienceCooperationBudget();
			tempSocialScienceCooperationBudgetList
					.add(tempSocialScienceCooperationBudget);
		}

		return tempSocialScienceCooperationBudgetList;

	}

	public SocialScienceApprovalBudget acquireSocialScienceApprovalBudgetByItemPK(
			long itemPK) {

		SocialScienceApprovalBudget tempSocialScienceApprovalBudget;

		List tempSocialScienceApprovalBudgetList = socialScienceApprovalBudgetDAO
				.findByItemPk(itemPK);

		if (tempSocialScienceApprovalBudgetList == null
				|| tempSocialScienceApprovalBudgetList.size() == 0) {
			tempSocialScienceApprovalBudget = new SocialScienceApprovalBudget();
		} else {
			tempSocialScienceApprovalBudget = (SocialScienceApprovalBudget) tempSocialScienceApprovalBudgetList
					.get(0);
		}

		return tempSocialScienceApprovalBudget;
	}

	public boolean storeSocialScienceItemBaseInfo(long itemPK) {

		SocialScienceItem tempSocialScienceItem;

		List tempSocialScienceItemList = socialScienceItemDAO
				.findByItemPk(itemPK);

		if (tempSocialScienceItemList == null
				|| tempSocialScienceItemList.size() == 0) {

			Item tempItemInfo = itemDAO.findById(itemPK);

			if (tempItemInfo == null) {
				return false;
			}

			tempSocialScienceItem = new SocialScienceItem();
			tempSocialScienceItem.setItemPk(itemPK);
			tempSocialScienceItem.setItemName(tempItemInfo.getItemName());
			tempSocialScienceItem.setItemId(tempItemInfo.getItemId());
			tempSocialScienceItem.setContractId(tempItemInfo.getContractId());
			tempSocialScienceItem.setTeacherName(tempItemInfo.getTeacherName());
			tempSocialScienceItem.setCardId(tempItemInfo.getCardId());

			socialScienceItemDAO.save(tempSocialScienceItem);
		}

		return true;
	}

	public boolean storeSocialScienceNjuBudgetInfo(long itemPK,
			Double materialCost, Double dataCost, Double travelCost,
			Double conferenceCost, Double exchangeCost, Double equipmentCost,
			Double consultCost, Double serviceCost, Double printCost,
			Double manageCost, Double otherCost) {

		SocialScienceNjubudget tempSocialScienceNjubudget;

		List tempSocialScienceNjubudgetList = socialScienceNjubudgetDAO
				.findByItemPk(itemPK);

		if (tempSocialScienceNjubudgetList == null
				|| tempSocialScienceNjubudgetList.size() == 0) {
			tempSocialScienceNjubudget = new SocialScienceNjubudget();
			tempSocialScienceNjubudget.setItemPk(itemPK);
			tempSocialScienceNjubudget = storePartialSocialScienceNjuBudgetInfo(
					tempSocialScienceNjubudget, materialCost, dataCost,
					travelCost, conferenceCost, exchangeCost, equipmentCost,
					consultCost, serviceCost, printCost, manageCost, otherCost);

			socialScienceNjubudgetDAO.save(tempSocialScienceNjubudget);

		} else {

			tempSocialScienceNjubudget = (SocialScienceNjubudget) tempSocialScienceNjubudgetList
					.get(0);
			tempSocialScienceNjubudget = storePartialSocialScienceNjuBudgetInfo(
					tempSocialScienceNjubudget, materialCost, dataCost,
					travelCost, conferenceCost, exchangeCost, equipmentCost,
					consultCost, serviceCost, printCost, manageCost, otherCost);

			socialScienceNjubudgetDAO.attachDirty(tempSocialScienceNjubudget);
		}

		return true;
	}

	public SocialScienceNjubudget storePartialSocialScienceNjuBudgetInfo(
			SocialScienceNjubudget tempSocialScienceNjubudget,
			Double materialCost, Double dataCost, Double travelCost,
			Double conferenceCost, Double exchangeCost, Double equipmentCost,
			Double consultCost, Double serviceCost, Double printCost,
			Double manageCost, Double otherCost) {

		tempSocialScienceNjubudget.setMaterialCost(materialCost);
		tempSocialScienceNjubudget.setDataCost(dataCost);
		tempSocialScienceNjubudget.setTravelCost(travelCost);
		tempSocialScienceNjubudget.setConferenceCost(conferenceCost);
		tempSocialScienceNjubudget.setExchangeCost(exchangeCost);
		tempSocialScienceNjubudget.setEquipmentCost(equipmentCost);
		tempSocialScienceNjubudget.setConsultCost(consultCost);
		tempSocialScienceNjubudget.setServiceCost(serviceCost);
		tempSocialScienceNjubudget.setPrintCost(printCost);
		tempSocialScienceNjubudget.setManageCost(manageCost);
		tempSocialScienceNjubudget.setOtherCost(otherCost);

		Double costSum = materialCost.doubleValue() + dataCost.doubleValue()
				+ travelCost.doubleValue() + conferenceCost.doubleValue()
				+ exchangeCost.doubleValue() + equipmentCost.doubleValue()
				+ consultCost.doubleValue() + serviceCost.doubleValue()
				+ printCost.doubleValue() + manageCost.doubleValue()
				+ otherCost.doubleValue();
		DecimalFormat tempDecimalFormat = new DecimalFormat("#.00");
		tempDecimalFormat.format(costSum);
		tempSocialScienceNjubudget.setCostSum(costSum);

		return tempSocialScienceNjubudget;
	}

	public boolean storeSocialScienceCooperationBudgetInfo(long itemPK,
			String[] organizationName_Array, Double[] materialCost_Array,
			Double[] dataCost_Array, Double[] travelCost_Array,
			Double[] conferenceCost_Array, Double[] exchangeCost_Array,
			Double[] equipmentCost_Array, Double[] consultCost_Array,
			Double[] serviceCost_Array, Double[] printCost_Array,
			Double[] manageCost_Array, Double[] otherCost_Array) {

		List<SocialScienceCooperationBudget> tempSocialScienceCooperationBudgetList = socialScienceCooperationBudgetDAO
				.findByItemPk(itemPK);

		if (tempSocialScienceCooperationBudgetList != null
				|| tempSocialScienceCooperationBudgetList.size() > 0) {
			int listLength = tempSocialScienceCooperationBudgetList.size();

			for (int i = 0; i < listLength; i++) {
				SocialScienceCooperationBudget tempSocialScienceCooperationBudget = (SocialScienceCooperationBudget) tempSocialScienceCooperationBudgetList
						.get(i);
				socialScienceCooperationBudgetDAO
						.delete(tempSocialScienceCooperationBudget);
			}
		}

		for (int i = 1; i < organizationName_Array.length; i++) {
			SocialScienceCooperationBudget tempSocialScienceCooperationBudget = storePartialSocialScienceCooperationBudgetInfo(
					itemPK, i, organizationName_Array[i],
					materialCost_Array[i], dataCost_Array[i],
					travelCost_Array[i], conferenceCost_Array[i],
					exchangeCost_Array[i], equipmentCost_Array[i],
					consultCost_Array[i], serviceCost_Array[i],
					printCost_Array[i], manageCost_Array[i], otherCost_Array[i]);

			socialScienceCooperationBudgetDAO
					.save(tempSocialScienceCooperationBudget);
		}

		return true;
	}

	public SocialScienceCooperationBudget storePartialSocialScienceCooperationBudgetInfo(
			long itemPK, int index, String organizationName,
			Double materialCost, Double dataCost, Double travelCost,
			Double conferenceCost, Double exchangeCost, Double equipmentCost,
			Double consultCost, Double serviceCost, Double printCost,
			Double manageCost, Double otherCost) {

		SocialScienceCooperationBudget tempSocialScienceCooperationBudget = new SocialScienceCooperationBudget();

		tempSocialScienceCooperationBudget.setItemPk(itemPK);
		tempSocialScienceCooperationBudget.setCooperationId(index);
		tempSocialScienceCooperationBudget.setCooperationName(organizationName);
		tempSocialScienceCooperationBudget.setMaterialCost(materialCost);
		tempSocialScienceCooperationBudget.setDataCost(dataCost);
		tempSocialScienceCooperationBudget.setTravelCost(travelCost);
		tempSocialScienceCooperationBudget.setConferenceCost(conferenceCost);
		tempSocialScienceCooperationBudget.setExchangeCost(exchangeCost);
		tempSocialScienceCooperationBudget.setEquipmentCost(equipmentCost);
		tempSocialScienceCooperationBudget.setConsultCost(consultCost);
		tempSocialScienceCooperationBudget.setServiceCost(serviceCost);
		tempSocialScienceCooperationBudget.setPrintCost(printCost);
		tempSocialScienceCooperationBudget.setManageCost(manageCost);
		tempSocialScienceCooperationBudget.setOtherCost(otherCost);

		Double costSum = materialCost.doubleValue() + dataCost.doubleValue()
				+ travelCost.doubleValue() + conferenceCost.doubleValue()
				+ exchangeCost.doubleValue() + equipmentCost.doubleValue()
				+ consultCost.doubleValue() + serviceCost.doubleValue()
				+ printCost.doubleValue() + manageCost.doubleValue()
				+ otherCost.doubleValue();
		DecimalFormat tempDecimalFormat = new DecimalFormat("#.00");
		tempDecimalFormat.format(costSum);
		tempSocialScienceCooperationBudget.setCostSum(costSum);

		return tempSocialScienceCooperationBudget;

	}

	public boolean storeSocialScienceApprovalBudgetInfo(long itemPK,
			Double materialCost, Double dataCost, Double travelCost,
			Double conferenceCost, Double exchangeCost, Double equipmentCost,
			Double consultCost, Double serviceCost, Double printCost,
			Double manageCost, Double otherCost) {

		SocialScienceApprovalBudget tempSocialScienceApprovalBudget;

		List tempSocialScienceApprovalBudgetList = socialScienceApprovalBudgetDAO
				.findByItemPk(itemPK);

		if (tempSocialScienceApprovalBudgetList == null
				|| tempSocialScienceApprovalBudgetList.size() == 0) {

			tempSocialScienceApprovalBudget = new SocialScienceApprovalBudget();
			tempSocialScienceApprovalBudget.setItemPk(itemPK);
			tempSocialScienceApprovalBudget = storePartialSocialScienceApprovalBudgetInfo(
					tempSocialScienceApprovalBudget, materialCost, dataCost,
					travelCost, conferenceCost, exchangeCost, equipmentCost,
					consultCost, serviceCost, printCost, manageCost, otherCost);

			socialScienceApprovalBudgetDAO
					.save(tempSocialScienceApprovalBudget);

		} else {

			tempSocialScienceApprovalBudget = (SocialScienceApprovalBudget) tempSocialScienceApprovalBudgetList
					.get(0);
			tempSocialScienceApprovalBudget = storePartialSocialScienceApprovalBudgetInfo(
					tempSocialScienceApprovalBudget, materialCost, dataCost,
					travelCost, conferenceCost, exchangeCost, equipmentCost,
					consultCost, serviceCost, printCost, manageCost, otherCost);

			socialScienceApprovalBudgetDAO
					.attachDirty(tempSocialScienceApprovalBudget);
		}

		return true;

	}

	public SocialScienceApprovalBudget storePartialSocialScienceApprovalBudgetInfo(
			SocialScienceApprovalBudget tempSocialScienceApprovalBudget,
			Double materialCost, Double dataCost, Double travelCost,
			Double conferenceCost, Double exchangeCost, Double equipmentCost,
			Double consultCost, Double serviceCost, Double printCost,
			Double manageCost, Double otherCost) {

		tempSocialScienceApprovalBudget.setMaterialCost(materialCost);
		tempSocialScienceApprovalBudget.setDataCost(dataCost);
		tempSocialScienceApprovalBudget.setTravelCost(travelCost);
		tempSocialScienceApprovalBudget.setConferenceCost(conferenceCost);
		tempSocialScienceApprovalBudget.setExchangeCost(exchangeCost);
		tempSocialScienceApprovalBudget.setEquipmentCost(equipmentCost);
		tempSocialScienceApprovalBudget.setConsultCost(consultCost);
		tempSocialScienceApprovalBudget.setServiceCost(serviceCost);
		tempSocialScienceApprovalBudget.setPrintCost(printCost);
		tempSocialScienceApprovalBudget.setManageCost(manageCost);
		tempSocialScienceApprovalBudget.setOtherCost(otherCost);

		Double costSum = materialCost.doubleValue() + dataCost.doubleValue()
				+ travelCost.doubleValue() + conferenceCost.doubleValue()
				+ exchangeCost.doubleValue() + equipmentCost.doubleValue()
				+ consultCost.doubleValue() + serviceCost.doubleValue()
				+ printCost.doubleValue() + manageCost.doubleValue()
				+ otherCost.doubleValue();
		DecimalFormat tempDecimalFormat = new DecimalFormat("#.00");
		tempDecimalFormat.format(costSum);
		tempSocialScienceApprovalBudget.setCostSum(costSum);
		
		/*double costSum = materialCost.doubleValue() + dataCost.doubleValue()
				+ travelCost.doubleValue() + conferenceCost.doubleValue()
				+ exchangeCost.doubleValue() + equipmentCost.doubleValue()
				+ consultCost.doubleValue() + serviceCost.doubleValue()
				+ printCost.doubleValue() + manageCost.doubleValue()
				+ otherCost.doubleValue();
		DecimalFormat tempDecimalFormat = new DecimalFormat("#.00");
		tempDecimalFormat.format(costSum);
		tempSocialScienceApprovalBudget.setCostSum(costSum);*/

		return tempSocialScienceApprovalBudget;
	}

	public List acquireSocialScienceFundOutlayList(long itemPK) {

		List tempSocialScienceFundOutlayList = socialScienceOutlayDAO
				.findByItemPk(itemPK);
		return tempSocialScienceFundOutlayList;
	}

	public SocialScienceOutlay acquireSocialScienceOutlayByOutlayPK(
			long outlayPK) {

		SocialScienceOutlay tempSocialScienceOutlay = socialScienceOutlayDAO
				.findById(outlayPK);

		if (tempSocialScienceOutlay == null) {
			tempSocialScienceOutlay = new SocialScienceOutlay();
		}

		return tempSocialScienceOutlay;
	}

	public SocialScienceRemark acquireSocialScienceRemarkInfoByOutlayPK(
			long outlayPK) {

		SocialScienceRemark tempSocialScienceRemark;

		List tempSocialScienceRemarkList = socialScienceRemarkDAO
				.findBySocialScienceOutlayPk(outlayPK);

		if (tempSocialScienceRemarkList != null
				&& tempSocialScienceRemarkList.size() > 0) {
			tempSocialScienceRemark = (SocialScienceRemark) tempSocialScienceRemarkList
					.get(0);
		} else {
			tempSocialScienceRemark = new SocialScienceRemark();
		}

		return tempSocialScienceRemark;
	}

	public long storeSocialScienceCurrentOutlayInfo(long itemPK, long outlayPK,
			Double materialCost, Double dataCost, Double travelCost,
			Double conferenceCost, Double exchangeCost, Double equipmentCost,
			Double consultCost, Double serviceCost, Double printCost,
			Double manageCost, Double otherCost) {

		SocialScienceOutlay tempSocialScienceOutlay = socialScienceOutlayDAO
				.findById(outlayPK);

		if (tempSocialScienceOutlay == null) {
			tempSocialScienceOutlay = new SocialScienceOutlay();
			tempSocialScienceOutlay.setItemPk(itemPK);
			tempSocialScienceOutlay = storePartialSocialScienceCurrentOutlayInfo(
					tempSocialScienceOutlay, materialCost, dataCost,
					travelCost, conferenceCost, exchangeCost, equipmentCost,
					consultCost, serviceCost, printCost, manageCost, otherCost);
			socialScienceOutlayDAO.save(tempSocialScienceOutlay);

		} else {
			tempSocialScienceOutlay = storePartialSocialScienceCurrentOutlayInfo(
					tempSocialScienceOutlay, materialCost, dataCost,
					travelCost, conferenceCost, exchangeCost, equipmentCost,
					consultCost, serviceCost, printCost, manageCost, otherCost);
			socialScienceOutlayDAO.attachDirty(tempSocialScienceOutlay);

		}
		return tempSocialScienceOutlay.getSocialScienceOutlayPk();
	}

	public SocialScienceOutlay storePartialSocialScienceCurrentOutlayInfo(
			SocialScienceOutlay tempSocialScienceOutlay, Double materialCost,
			Double dataCost, Double travelCost, Double conferenceCost,
			Double exchangeCost, Double equipmentCost, Double consultCost,
			Double serviceCost, Double printCost, Double manageCost,
			Double otherCost) {

		tempSocialScienceOutlay.setMaterialCost(materialCost);
		tempSocialScienceOutlay.setDataCost(dataCost);
		tempSocialScienceOutlay.setTravelCost(travelCost);
		tempSocialScienceOutlay.setConferenceCost(conferenceCost);
		tempSocialScienceOutlay.setExchangeCost(exchangeCost);
		tempSocialScienceOutlay.setEquipmentCost(equipmentCost);
		tempSocialScienceOutlay.setConsultCost(consultCost);
		tempSocialScienceOutlay.setServiceCost(serviceCost);
		tempSocialScienceOutlay.setPrintCost(printCost);
		tempSocialScienceOutlay.setManageCost(manageCost);
		tempSocialScienceOutlay.setOtherCost(otherCost);

		Double costSum = materialCost.doubleValue() + dataCost.doubleValue()
				+ travelCost.doubleValue() + conferenceCost.doubleValue()
				+ exchangeCost.doubleValue() + equipmentCost.doubleValue()
				+ consultCost.doubleValue() + serviceCost.doubleValue()
				+ printCost.doubleValue() + manageCost.doubleValue()
				+ otherCost.doubleValue();
		DecimalFormat tempDecimalFormat = new DecimalFormat("#.00");
		tempDecimalFormat.format(costSum);
		tempSocialScienceOutlay.setCostSum(costSum);

		// 获取当前页面请求主机的时间
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = formatter.format(date);
		tempSocialScienceOutlay.setOutlayTime(currentDate);

		return tempSocialScienceOutlay;
	}

	public boolean storeSocialScienceFundOutlayRemarkInfo(long itemPK,
			long outlayPK, String materialCost, String dataCost,
			String travelCost, String conferenceCost, String exchangeCost,
			String equipmentCost, String consultCost, String serviceCost,
			String printCost, String manageCost, String otherCost) {

		SocialScienceRemark tempSocialScienceRemark;

		List tempSocialScienceRemarkList = socialScienceRemarkDAO
				.findBySocialScienceOutlayPk(outlayPK);

		if (tempSocialScienceRemarkList != null
				&& tempSocialScienceRemarkList.size() > 0) {
			tempSocialScienceRemark = (SocialScienceRemark) tempSocialScienceRemarkList
					.get(0);

			tempSocialScienceRemark = storePartialSocialScienceRemarkInfo(
					tempSocialScienceRemark, materialCost, dataCost,
					travelCost, conferenceCost, exchangeCost, equipmentCost,
					consultCost, serviceCost, printCost, manageCost, otherCost);
			socialScienceRemarkDAO.save(tempSocialScienceRemark);

		} else {

			tempSocialScienceRemark = new SocialScienceRemark();
			tempSocialScienceRemark.setSocialScienceOutlayPk(outlayPK);
			tempSocialScienceRemark.setItemPk(itemPK);

			tempSocialScienceRemark = storePartialSocialScienceRemarkInfo(
					tempSocialScienceRemark, materialCost, dataCost,
					travelCost, conferenceCost, exchangeCost, equipmentCost,
					consultCost, serviceCost, printCost, manageCost, otherCost);
			socialScienceRemarkDAO.attachDirty(tempSocialScienceRemark);
		}

		return true;
	}

	public SocialScienceRemark storePartialSocialScienceRemarkInfo(
			SocialScienceRemark tempSocialScienceRemark, String materialCost,
			String dataCost, String travelCost, String conferenceCost,
			String exchangeCost, String equipmentCost, String consultCost,
			String serviceCost, String printCost, String manageCost,
			String otherCost) {

		tempSocialScienceRemark.setMaterialCost(materialCost);
		tempSocialScienceRemark.setDataCost(dataCost);
		tempSocialScienceRemark.setTravelCost(travelCost);
		tempSocialScienceRemark.setConferenceCost(conferenceCost);
		tempSocialScienceRemark.setExchangeCost(exchangeCost);
		tempSocialScienceRemark.setEquipmentCost(equipmentCost);
		tempSocialScienceRemark.setConsultCost(consultCost);
		tempSocialScienceRemark.setServiceCost(serviceCost);
		tempSocialScienceRemark.setPrintCost(printCost);
		tempSocialScienceRemark.setManageCost(manageCost);
		tempSocialScienceRemark.setOtherCost(otherCost);

		return tempSocialScienceRemark;

	}

	// setters and getters
	public ItemDAO getItemDAO() {
		return itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public SocialScienceItemDAO getSocialScienceItemDAO() {
		return socialScienceItemDAO;
	}

	public void setSocialScienceItemDAO(
			SocialScienceItemDAO socialScienceItemDAO) {
		this.socialScienceItemDAO = socialScienceItemDAO;
	}

	public SocialScienceNjubudgetDAO getSocialScienceNjubudgetDAO() {
		return socialScienceNjubudgetDAO;
	}

	public void setSocialScienceNjubudgetDAO(
			SocialScienceNjubudgetDAO socialScienceNjubudgetDAO) {
		this.socialScienceNjubudgetDAO = socialScienceNjubudgetDAO;
	}

	public SocialScienceCooperationBudgetDAO getSocialScienceCooperationBudgetDAO() {
		return socialScienceCooperationBudgetDAO;
	}

	public void setSocialScienceCooperationBudgetDAO(
			SocialScienceCooperationBudgetDAO socialScienceCooperationBudgetDAO) {
		this.socialScienceCooperationBudgetDAO = socialScienceCooperationBudgetDAO;
	}

	public SocialScienceApprovalBudgetDAO getSocialScienceApprovalBudgetDAO() {
		return socialScienceApprovalBudgetDAO;
	}

	public void setSocialScienceApprovalBudgetDAO(
			SocialScienceApprovalBudgetDAO socialScienceApprovalBudgetDAO) {
		this.socialScienceApprovalBudgetDAO = socialScienceApprovalBudgetDAO;
	}

	public SocialScienceRemarkDAO getSocialScienceRemarkDAO() {
		return socialScienceRemarkDAO;
	}

	public void setSocialScienceRemarkDAO(
			SocialScienceRemarkDAO socialScienceRemarkDAO) {
		this.socialScienceRemarkDAO = socialScienceRemarkDAO;
	}
}
