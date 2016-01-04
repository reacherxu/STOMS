package com.stoms.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.stoms.dao.AddOutlayDAO;
import com.stoms.dao.DepartmentDAO;
import com.stoms.dao.ItemDAO;
import com.stoms.dao.OldAddOutlayDAO;
import com.stoms.dao.ProjectManagerDAO;
import com.stoms.dao.ProjectTypeDAO;
import com.stoms.model.AddOutlay;
import com.stoms.model.Department;
import com.stoms.model.Item;
import com.stoms.model.ProjectManager;
import com.stoms.model.ProjectType;
import com.stoms.model.OldAddOutlay;
import com.stoms.model.temp.ManagerOutlayQuery;
import com.stoms.utils.JSONTranslation;

//author shi (2013-07-14添加typePk,typeId,typeName部分)
public class AddOutlayService {

	private AddOutlayDAO addOutlayDAO;
	private OldAddOutlayDAO oldAddOutlayDAO;
	private ItemDAO itemDAO;
	private ProjectManagerDAO projectManagerDAO;
	private DepartmentDAO departmentDAO;
	private ProjectTypeDAO projectTypeDAO;

	//返回入账历史
	public List searchbyAddoutlayPk(Long addOutlayPk) {
		List<OldAddOutlay> oldAddOutlay = oldAddOutlayDAO
				.findByAddOutlayPk(addOutlayPk);
		return oldAddOutlay;
	}

	/**
	 * 删除主键数组里面的经费
	 * 
	 * @param
	 * @return
	 */
	public boolean deleteSelectedAddoutlay(long[] PKArray) {

		boolean result = false;

		for (int i = 0; i < PKArray.length; i++) {

			long PK = (long) PKArray[i];

			AddOutlay tempObject = addOutlayDAO.findById(PK);
			if (tempObject != null) {
				addOutlayDAO.delete(tempObject);
				result = true;
			}
		}

		return result;
	}

	public boolean modifyAddOutlayItemNameAndContractId(
			AddOutlay tempAddOutlay, String itemName, String contractId) {
		try {
			tempAddOutlay.setItemName(itemName);
			tempAddOutlay.setContractId(contractId);

			addOutlayDAO.attachDirty(tempAddOutlay);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean isEqual(long addOutlayPK, String outlayDepartment,
			String teacherName, String otherTeacher, double outlayValue,
			String itemId, String cardId, String departmentId,
			String departmentName, String departmentType, int typePk,
			String typeId, String typeName, double remitValue, String other,
			double pay, double manage, double pay2, double manage2,
			double availableManageCredit, double consult, double act,
			double improve, double directValue, double indirectValue,
			double performance, double equipment, double departmentPublic,
			double coProject, double performance1, double performance2,
			int isCross, double departmentPay, double pay3, int isTax,
			double tax1, double tax2, double tax3,String remark) {
		AddOutlay tempA = addOutlayDAO.findById(addOutlayPK);
		System.out.println(tempA.getOutlayDepartment());
		System.out.println(outlayDepartment);
		System.out.println(tempA.getOutlayDepartment() == outlayDepartment);
		System.out.println(tempA.getOutlayDepartment().equals(outlayDepartment));
		
		if (tempA.getOutlayDepartment().equals(outlayDepartment)
				&& tempA.getTeacherName().equals(teacherName)
				&& tempA.getOtherTeacher().equals(otherTeacher)
				&& tempA.getOutlayValue().equals(outlayValue)
				&& tempA.getItemId().equals(itemId)
				&& tempA.getCardId().equals(cardId)
				&& tempA.getDepartmentId().equals(departmentId)
				&& tempA.getDepartmentName().equals(departmentName)
				&& tempA.getDepartmentType().equals(departmentType)
				&& tempA.getTypePk().equals(typePk)
				&& tempA.getTypeId().equals(typeId)
				&& tempA.getTypeName().equals(typeName)
				&& tempA.getRemitValue() == remitValue
				&& tempA.getOther().equals(other)
				&& tempA.getPay() == pay
				&& tempA.getManage() == manage
				&& tempA.getPay2() == pay2
				&& tempA.getManage2() == manage2
				&& tempA.getAvailableManageCredit() == availableManageCredit
				&& tempA.getConsult() == consult
				&& tempA.getAct() == act
				&& tempA.getImprove() == improve
				&& tempA.getDirectValue() == directValue
				&& tempA.getIndirectValue() == indirectValue
				&& tempA.getPerformance() == performance
				&& 0.0 == equipment//null
				&& tempA.getDepartmentPublic() == departmentPublic
				&& tempA.getCoProject() == coProject
				&& tempA.getPerformance1() == performance1
				&& tempA.getPerformance2() == performance2
				&&
				// int isCross,double departmentPay,double pay3,
				// int isTax, double tax1, double tax2, double tax3
				tempA.getIsCross() == isCross
				&& tempA.getDepartmentPay() == departmentPay
				&& tempA.getPay3() == pay3 && tempA.getIsTax() == isTax
				&& tempA.getTax1() == tax1 && tempA.getTax2() == tax2
				&& tempA.getTax3() == tax3) {
					if(tempA.getRemark() == null){
						if(remark == ""){
							return true;//如果库里的remark是null，界面的remark是“”,就是equal
						}else{
							return false;
						}
					}else if(!remark.equals(tempA.getRemark())){
						return false;//如果库里的remark == 界面的remark,就是equal
					}
					return true;
		}
		return false;
	}

	public AddOutlay modifyAddOutlay(long addOutlayPK, String outlayDepartment,
			String teacherName, String otherTeacher, double outlayValue,
			String itemId, String cardId, String departmentId,
			String departmentName, String departmentType, int typePk,
			String typeId, String typeName, double remitValue, String other,
			double pay, double manage, double pay2, double manage2,
			double availableManageCredit, double consult, double act,
			double improve, double directValue, double indirectValue,
			double performance, double equipment, double departmentPublic,
			double coProject, double performance1, double performance2,
			int isCross, double departmentPay, double pay3, int isTax,
			double tax1, double tax2, double tax3, String remark) {

		AddOutlay tempAddOutlay = addOutlayDAO.findById(addOutlayPK);
		OldAddOutlay oldAddOutlay = new OldAddOutlay();

		oldAddOutlay.setAddOutlayPk(addOutlayPK);
		oldAddOutlay.setOutlayDepartment(tempAddOutlay.getOutlayDepartment());
		oldAddOutlay.setTeacherName(tempAddOutlay.getTeacherName());
		oldAddOutlay.setOtherTeacher(tempAddOutlay.getOtherTeacher());
		oldAddOutlay.setOutlayValue(tempAddOutlay.getOutlayValue());
		oldAddOutlay.setItemId(tempAddOutlay.getItemId());
		oldAddOutlay.setCardId(tempAddOutlay.getCardId());
		oldAddOutlay.setDepartmentId(tempAddOutlay.getDepartmentId());
		oldAddOutlay.setDepartmentName(tempAddOutlay.getDepartmentName());
		oldAddOutlay.setDepartmentType(tempAddOutlay.getDepartmentType());
		oldAddOutlay.setTypePk(tempAddOutlay.getTypePk());
		oldAddOutlay.setTypeId(tempAddOutlay.getTypeId());
		oldAddOutlay.setTypeName(tempAddOutlay.getTypeName());
		oldAddOutlay.setRemitValue(tempAddOutlay.getRemitValue());
		oldAddOutlay.setOther(tempAddOutlay.getOther());
		oldAddOutlay.setPay(tempAddOutlay.getPay());
		oldAddOutlay.setManage(tempAddOutlay.getManage());
		oldAddOutlay.setPay2(tempAddOutlay.getPay2());
		oldAddOutlay.setManage2(tempAddOutlay.getManage2());
		oldAddOutlay.setAvailableManageCredit(tempAddOutlay
				.getAvailableManageCredit());
		oldAddOutlay.setConsult(tempAddOutlay.getConsult());
		oldAddOutlay.setAct(tempAddOutlay.getAct());
		oldAddOutlay.setImprove(tempAddOutlay.getImprove());
		oldAddOutlay.setDirectValue(tempAddOutlay.getDirectValue());
		oldAddOutlay.setIndirectValue(tempAddOutlay.getIndirectValue());
		oldAddOutlay.setPerformance(tempAddOutlay.getPerformance());
		oldAddOutlay.setEquipment(tempAddOutlay.getEquipment());
		oldAddOutlay.setDepartmentPublic(tempAddOutlay.getDepartmentPublic());
		oldAddOutlay.setCoProject(tempAddOutlay.getCoProject());
		oldAddOutlay.setPerformance1(tempAddOutlay.getPerformance1());
		oldAddOutlay.setPerformance2(tempAddOutlay.getPerformance2());
		oldAddOutlay.setIsCross(tempAddOutlay.getIsCross());
		oldAddOutlay.setDepartmentPay(tempAddOutlay.getDepartmentPay());
		oldAddOutlay.setPay3(tempAddOutlay.getPay3());
		oldAddOutlay.setIsTax(tempAddOutlay.getIsTax());
		oldAddOutlay.setTax1(tempAddOutlay.getTax1());
		oldAddOutlay.setTax2(tempAddOutlay.getTax2());
		oldAddOutlay.setTax3(tempAddOutlay.getTax3());
		oldAddOutlay.setOutlayTime(tempAddOutlay.getOutlayTime());
		oldAddOutlay.setRemark(tempAddOutlay.getRemark());
		oldAddOutlayDAO.save(oldAddOutlay);

		tempAddOutlay.setAddOutlayPk(addOutlayPK);
		tempAddOutlay.setOutlayDepartment(outlayDepartment);
		tempAddOutlay.setTeacherName(teacherName);
		tempAddOutlay.setOtherTeacher(otherTeacher);
		tempAddOutlay.setOutlayValue(outlayValue);
		tempAddOutlay.setItemId(itemId);
		tempAddOutlay.setCardId(cardId);
		tempAddOutlay.setDepartmentId(departmentId);
		tempAddOutlay.setDepartmentName(departmentName);
		tempAddOutlay.setDepartmentType(departmentType);
		tempAddOutlay.setTypePk(typePk);
		tempAddOutlay.setTypeId(typeId);
		tempAddOutlay.setTypeName(typeName);
		tempAddOutlay.setRemitValue(remitValue);
		tempAddOutlay.setOther(other);
		tempAddOutlay.setPay(pay);
		tempAddOutlay.setManage(manage);
		tempAddOutlay.setPay2(pay2);
		tempAddOutlay.setManage2(manage2);
		tempAddOutlay.setAvailableManageCredit(availableManageCredit);
		tempAddOutlay.setConsult(consult);
		tempAddOutlay.setAct(act);
		tempAddOutlay.setImprove(improve);
		tempAddOutlay.setDirectValue(directValue);
		tempAddOutlay.setIndirectValue(indirectValue);
		tempAddOutlay.setPerformance(performance);
		tempAddOutlay.setEquipment(equipment);
		tempAddOutlay.setDepartmentPublic(departmentPublic);
		tempAddOutlay.setCoProject(coProject);
		tempAddOutlay.setPerformance1(performance1);
		tempAddOutlay.setPerformance2(performance2);
		tempAddOutlay.setIsCross(isCross);
		tempAddOutlay.setDepartmentPay(departmentPay);
		tempAddOutlay.setPay3(pay3);
		tempAddOutlay.setIsTax(isTax);
		tempAddOutlay.setTax1(tax1);
		tempAddOutlay.setTax2(tax2);
		tempAddOutlay.setTax3(tax3);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = formatter.format(date);
		tempAddOutlay.setOutlayTime(currentDate);
		tempAddOutlay.setRemark(remark);
		// tempAddOutlay.

		addOutlayDAO.attachDirty(tempAddOutlay);
		return tempAddOutlay;

	}

	/**
	 * 返回主键为addOutlayPK的入账信息
	 * 
	 * @param addOutlayPK
	 * @return
	 */
	public AddOutlay acquireOneAddoutlayInfoByAddOutlayPK(long addOutlayPK) {

		AddOutlay tempAddOutlay = addOutlayDAO.findById(addOutlayPK);
		return tempAddOutlay;
	}

	public List addoutlayQuery(String itemId, double outlayValue,
			double remitValue, int isCross, String outlayDepartment,
			String teacherName, String departmentId, String departmentType,
			String lowYear, String upperYear) {

		List managerOutlayQueries = new ArrayList();
		managerOutlayQueries = addOutlayDAO.addoutlayQuery(itemId, outlayValue,
				remitValue, isCross, outlayDepartment, teacherName,
				departmentId, departmentType, lowYear, upperYear);

		// List<ManagerOutlayQuery> lists = new ArrayList<ManagerOutlayQuery>();
		// lists = CasttoManagerOutlayQueries(managerOutlayQueries);

		System.out.println(managerOutlayQueries.size());
		return managerOutlayQueries;
	}

	public List acquireManagerOutlay(String itemName, String teacherName,
			String cardId, String itemId, String contractId,
			String outlayDepartment, int isInvoice, int isCross,
			String timeLower, String timeUpper, String outlayStartDate,
			String outlayEndDate, int[] typepks, int[] departmentpks) {

		List managerOutlayQueries = new ArrayList();
		managerOutlayQueries = addOutlayDAO.findByItemAndAddOutlay(itemName,
				teacherName, cardId, itemId, contractId, outlayDepartment,
				isInvoice, isCross, typepks, departmentpks);

		List<ManagerOutlayQuery> lists = new ArrayList<ManagerOutlayQuery>();

		lists = CasttoManagerOutlayQueries(managerOutlayQueries);

		lists = removeByTimeLimit(lists, timeLower, timeUpper, outlayStartDate,
				outlayEndDate);
		System.out.println(lists.size());
		return lists;
	}

	private List<ManagerOutlayQuery> CasttoManagerOutlayQueries(
			List managerOutlayQueries) {
		List<ManagerOutlayQuery> lists = new ArrayList<ManagerOutlayQuery>();
		for (int i = 0; i < managerOutlayQueries.size(); i++) {
			Object[] object = (Object[]) managerOutlayQueries.get(i);
			// for (int j = 0; j < object.length; j++) {
			// System.out.println(object[j]);
			// }

			ManagerOutlayQuery managerOutlayQuery = new ManagerOutlayQuery();
			managerOutlayQuery.setItemId((String) object[0]);
			managerOutlayQuery.setItemName((String) object[1]);
			managerOutlayQuery.setTypeName((String) object[2]);
			managerOutlayQuery.setIsCross((Integer) object[3]);
			managerOutlayQuery.setTeacherName((String) object[4]);
			managerOutlayQuery.setDepartmentName((String) object[5]);
			managerOutlayQuery.setAddOutlayPk((Long) object[6]);
			managerOutlayQuery.setCardId((String) object[7]);
			managerOutlayQuery.setContractId((String) object[8]);
			managerOutlayQuery.setOutlayValue((Double) object[9]);
			managerOutlayQuery.setRemitValue((Double) object[10]);
			managerOutlayQuery.setOutlayDepartment((String) object[11]);
			managerOutlayQuery.setIsInvoice((Integer) object[12]);
			managerOutlayQuery.setTimeLower((String) object[13]);
			managerOutlayQuery.setTimeUpper((String) object[14]);
			managerOutlayQuery.setOutlayTime((String) object[15]);
			managerOutlayQuery.setAstatus((String) object[16]);
			lists.add(managerOutlayQuery);
		}

		return lists;
	}

	private List<ManagerOutlayQuery> removeByTimeLimit(
			List<ManagerOutlayQuery> managerOutlayQueries, String timeLower,
			String timeUpper, String outlayStartDate, String outlayEndDate) {
		List<ManagerOutlayQuery> delList1 = new ArrayList<ManagerOutlayQuery>();
		List<ManagerOutlayQuery> delList2 = new ArrayList<ManagerOutlayQuery>();
		List<ManagerOutlayQuery> delList3 = new ArrayList<ManagerOutlayQuery>();
		List<ManagerOutlayQuery> delList4 = new ArrayList<ManagerOutlayQuery>();
		if (timeLower != null && !timeLower.equals("")) {
			for (ManagerOutlayQuery managerOutlayQuery : managerOutlayQueries) {
				if (managerOutlayQuery.getTimeLower() != null
						&& managerOutlayQuery.getTimeLower().compareTo(
								timeLower) < 0) {
					delList1.add(managerOutlayQuery);
				}
			}
		}
		managerOutlayQueries.removeAll(delList1);

		if (timeUpper != null && !timeUpper.equals("")) {
			for (ManagerOutlayQuery managerOutlayQuery : managerOutlayQueries) {
				if (managerOutlayQuery.getTimeLower() != null
						&& managerOutlayQuery.getTimeLower().compareTo(
								timeUpper) > 0) {
					delList2.add(managerOutlayQuery);
				}
			}
		}
		managerOutlayQueries.removeAll(delList2);

		if (outlayStartDate != null && !outlayStartDate.equals("")) {
			for (ManagerOutlayQuery managerOutlayQuery : managerOutlayQueries) {
				if (managerOutlayQuery.getOutlayTime() != null
						&& managerOutlayQuery.getOutlayTime().compareTo(
								outlayStartDate) < 0) {
					delList3.add(managerOutlayQuery);
				}
			}
		}
		managerOutlayQueries.removeAll(delList3);

		if (outlayEndDate != null && !outlayEndDate.equals("")) {
			for (ManagerOutlayQuery managerOutlayQuery : managerOutlayQueries) {
				if (managerOutlayQuery.getOutlayTime() != null
						&& managerOutlayQuery.getOutlayTime().compareTo(
								outlayEndDate) > 0) {
					delList4.add(managerOutlayQuery);
				}
			}
		}
		managerOutlayQueries.removeAll(delList4);
		return managerOutlayQueries;
	}

	/**
	 * 根据addOutlayPK查找相应的入账信息，如果该记录不存在，则根据itemID新创建一个对象
	 * 
	 * @param addOutlayPK
	 * @param itemID
	 * @return
	 */
	public AddOutlay accquireAddOutlayByAddOutlayPKAndItemID(long addOutlayPK,
			String itemID) {

		AddOutlay tempAddOutlay = addOutlayDAO.findById(addOutlayPK);

		if (tempAddOutlay == null) {
			tempAddOutlay = createNewAddOutlayObject(itemID);
		}

		return tempAddOutlay;
	}

	/**
	 * 创建一个新的入账信息对象
	 * 
	 * @param itemID
	 * @return
	 */
	private AddOutlay createNewAddOutlayObject(String itemID) {

		AddOutlay tempAddOutlay = new AddOutlay();

		List itemList = itemDAO.findByItemId(itemID);

		if (itemList == null || itemList.size() == 0) {
			return null;
		}

		Item tempItem = (Item) itemList.get(0);

		tempAddOutlay.setItemId(itemID);
		tempAddOutlay.setContractId(tempItem.getContractId());
		tempAddOutlay.setItemName(tempItem.getItemName());
		// tempAddOutlay.setTypePk(tempItem.getProjectType().getTypePk());
		// tempAddOutlay.setTypeName(tempItem.getTypeName());
		// tempAddOutlay.setTypeId(tempItem.getProjectType().getTypeId());
		tempAddOutlay.setTeacherName(tempItem.getTeacherName());
		//
		// // other teacher Name
		// String otherTeacherNames = "";
		//
		// List otherTeacherList = projectManagerDAO.findByItemId(itemID);
		// if (otherTeacherList != null || otherTeacherList.size() > 0) {
		//
		// for (int i = 0; i < otherTeacherList.size(); i++) {
		//
		// if (i > 0) {
		// otherTeacherNames = otherTeacherNames + "; ";
		// }
		//
		// ProjectManager tempProjectManager = (ProjectManager) otherTeacherList
		// .get(i);
		//
		// String tempTeacher2Name = tempProjectManager.getTeacher2name();
		//
		// if (tempTeacher2Name != null
		// && !tempTeacher2Name.trim().equals("")) {
		// otherTeacherNames = otherTeacherNames + tempTeacher2Name;
		// }
		// }
		// }
		// tempAddOutlay.setOtherTeacher(otherTeacherNames);
		//
		tempAddOutlay.setDepartmentId(tempItem.getDepartment()
				.getDepartmentId());
		tempAddOutlay.setDepartmentName(tempItem.getDepartmentName());
		tempAddOutlay.setDepartmentType(tempItem.getDepartmentType());
		tempAddOutlay.setIsCross(tempItem.getIsCross());

		return tempAddOutlay;
	}

	/**
	 * 保存信息到AddOutlay表中
	 * 
	 * @param addOutlayPK
	 * @param itemID
	 * @param otherTeacher
	 * @param outlayDepartment
	 * @param cardID
	 * @param outlayValue
	 * @param remitValue
	 * @param bankId
	 * @param isTax
	 * @param tax1
	 * @param tax2
	 * @param tax3
	 * @param isInvoice
	 * @param invoiceTitle
	 * @param invoiceDetail
	 * @return
	 */
	// public long saveAddOutlayInfo(long addOutlayPK, String itemID,
	// String otherTeacher,Integer typePk, String typeId, String typeName,
	// String outlayDepartment, String cardID,
	// Double outlayValue, Double remitValue, String bankId, int isTax,
	// Double tax1, Double tax2, Double tax3, int isInvoice,
	// String invoiceTitle, String invoiceDetail, int isFirstOutlay,
	// Double directValue,Double indirectValue,Double performance,
	// Double equipment,Double departmentPublic,Double coProject,Double manage)
	// {
	//
	// AddOutlay tempAddOutlay = addOutlayDAO.findById(addOutlayPK);
	//
	// if (tempAddOutlay == null) {
	// tempAddOutlay = createNewAddOutlayObject(itemID);
	// tempAddOutlay = savePartialInfoToAddOutlay(tempAddOutlay,
	// otherTeacher,typePk,typeId,typeName,outlayDepartment, cardID,
	// outlayValue,
	// remitValue, bankId, isTax, tax1, tax2, tax3, isInvoice,
	// invoiceTitle, invoiceDetail, isFirstOutlay,
	// directValue,indirectValue,performance,equipment,departmentPublic,coProject,manage);
	// tempAddOutlay.setAstatus("10");
	// addOutlayDAO.save(tempAddOutlay);
	//
	// } else {
	//
	// tempAddOutlay = savePartialInfoToAddOutlay(tempAddOutlay,
	// otherTeacher,typePk,typeId,typeName,outlayDepartment, cardID,
	// outlayValue,
	// remitValue, bankId, isTax, tax1, tax2, tax3, isInvoice,
	// invoiceTitle, invoiceDetail, isFirstOutlay,
	// directValue,indirectValue,performance,equipment,departmentPublic,coProject,manage);
	// tempAddOutlay.setAstatus("10");
	// addOutlayDAO.attachDirty(tempAddOutlay);
	// }
	//
	// return tempAddOutlay.getAddOutlayPk();
	// }

	public long submitAddOutlayInfo(long addOutlayPK, String itemID,
			String teacherName, String otherTeacher, Integer typePk,
			String typeId, String typeName, String outlayDepartment,
			String cardID, Double outlayValue, Double remitValue,
			String bankId, int isTax, Double tax1, Double tax2, Double tax3,
			int isInvoice, String invoiceTitle, String invoiceDetail,
			int isFirstOutlay, Double directValue, Double indirectValue,
			Double performance, Double equipment, Double departmentPublic,
			Double coProject, Double manage) {

		AddOutlay tempAddOutlay = addOutlayDAO.findById(addOutlayPK);

		if (tempAddOutlay == null) {
			tempAddOutlay = createNewAddOutlayObject(itemID);
			tempAddOutlay = savePartialInfoToAddOutlay(tempAddOutlay,
					teacherName, otherTeacher, typePk, typeId, typeName,
					outlayDepartment, cardID, outlayValue, remitValue, bankId,
					isTax, tax1, tax2, tax3, isInvoice, invoiceTitle,
					invoiceDetail, isFirstOutlay, directValue, indirectValue,
					performance, equipment, departmentPublic, coProject, manage);

			tempAddOutlay.setAstatus("11");

			addOutlayDAO.save(tempAddOutlay);

		} else {

			tempAddOutlay = savePartialInfoToAddOutlay(tempAddOutlay,
					teacherName, otherTeacher, typePk, typeId, typeName,
					outlayDepartment, cardID, outlayValue, remitValue, bankId,
					isTax, tax1, tax2, tax3, isInvoice, invoiceTitle,
					invoiceDetail, isFirstOutlay, directValue, indirectValue,
					performance, equipment, departmentPublic, coProject, manage);

			tempAddOutlay.setAstatus("11");

			addOutlayDAO.attachDirty(tempAddOutlay);
		}

		return tempAddOutlay.getAddOutlayPk();
	}

	/**
	 * 为对象tempAddOutlay保存教师页面填入的部分信息，然后返回该对象
	 * 
	 * @param tempAddOutlay
	 * @param otherTeacher
	 * @param outlayDepartment
	 * @param cardID
	 * @param outlayValue
	 * @param remitValue
	 * @param bankId
	 * @param isTax
	 * @param tax1
	 * @param tax2
	 * @param tax3
	 * @param isInvoice
	 * @param invoiceTitle
	 * @param invoiceDetail
	 * @return
	 */
	private AddOutlay savePartialInfoToAddOutlay(AddOutlay tempAddOutlay,
			String teacherName, String otherTeacher, Integer typePk,
			String typeId, String typeName, String outlayDepartment,
			String cardID, Double outlayValue, Double remitValue,
			String bankId, int isTax, Double tax1, Double tax2, Double tax3,
			int isInvoice, String invoiceTitle, String invoiceDetail,
			int isFirstOutlay, Double directValue, Double indirectValue,
			Double performance, Double equipment, Double departmentPublic,
			Double coProject, Double manage) {

		tempAddOutlay.setTeacherName(teacherName);
		tempAddOutlay.setOtherTeacher(otherTeacher);
		tempAddOutlay.setTypePk(typePk);
		tempAddOutlay.setTypeId(typeId);
		tempAddOutlay.setTypeName(typeName);
		tempAddOutlay.setOutlayDepartment(outlayDepartment);
		tempAddOutlay.setCardId(cardID);
		tempAddOutlay.setOutlayValue(outlayValue);
		tempAddOutlay.setRemitValue(remitValue);
		tempAddOutlay.setBankId(bankId);
		tempAddOutlay.setIsTax(isTax);
		tempAddOutlay.setTax1(tax1);
		tempAddOutlay.setTax2(tax2);
		tempAddOutlay.setTax3(tax3);
		tempAddOutlay.setIsInvoice(isInvoice);
		tempAddOutlay.setInvoiceTitle(invoiceTitle);
		tempAddOutlay.setInvoiceDetail(invoiceDetail);
		tempAddOutlay.setIsFirstOutlay(isFirstOutlay);

		tempAddOutlay.setDirectValue(directValue);
		tempAddOutlay.setIndirectValue(indirectValue);
		tempAddOutlay.setPerformance(performance);
		tempAddOutlay.setEquipment(equipment);
		tempAddOutlay.setDepartmentPublic(departmentPublic);
		tempAddOutlay.setCoProject(coProject);
		tempAddOutlay.setManage(manage);

		// 获取当前页面请求主机的时间
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = formatter.format(date);
		tempAddOutlay.setOutlayTime(currentDate);

		// 如果该入账申请的登记工作由管理员操作，则session的curr_adminID字段不为空，则保存管理员账号到数据库中
		/***************** begin ************************/
		HttpSession session = ServletActionContext.getRequest().getSession();
		String tmpOperatorID = (String) session.getAttribute("curr_adminID");
		if (tmpOperatorID != null && !tmpOperatorID.trim().equals("")) {
			tempAddOutlay.setOperatorId(tmpOperatorID);
		}

		return tempAddOutlay;

	}

	/**
	 * 根据itemID查找该项目的 入账申请记录
	 * 
	 * @param itemID
	 * @return
	 */
	public List acquireAllInAccountApplicationsByItemID(String itemID) {

		List inAccountApplicationList = addOutlayDAO.findByItemId(itemID);

		return inAccountApplicationList;
	}

	/**
	 * 返回所有教师已提交待审批的入账申请
	 * 
	 * @return
	 */
	public List acquireAllUnAuditedInAccountApplications() {

		List tempInAccountApplicationsList = addOutlayDAO.findByAstatus("11");

		return tempInAccountApplicationsList;
	}

	public List acquireAllUnAuditedInAccountApplications(String operatorId) {

		List tempInAccountApplicationsList = addOutlayDAO
				.findByProjectStatusAndoperatorId(operatorId);

		return tempInAccountApplicationsList;
	}

	/**
	 * 根据入账表的addOutlayPK取得相应的入账申请信息
	 * 
	 * @param addOutlayPK
	 * @return
	 */
	public AddOutlay accquireAddOutlayByAddOutlayPK(long addOutlayPK) {

		AddOutlay addOutlay = addOutlayDAO.findById(addOutlayPK);

		return addOutlay;
	}

	/**
	 * 管理员入账申请的审批操作，审批通过置状态为"31"，否则为"30"
	 * 
	 * @param addOutlayPK
	 * @param isTax
	 * @param tax1
	 * @param tax2
	 * @param tax3
	 * @param isInvoice
	 * @param invoiceTitle
	 * @param invoiceDetail
	 * @param pay
	 * @param pay2
	 * @param pay3
	 * @param manage
	 * @param manage2
	 * @param availableManageCredit
	 * @param consult
	 * @param departmentPay
	 * @param other
	 * @param astatus
	 * @return
	 */
	public AddOutlay inAccountAuditProcess(long addOutlayPK, int isTax,
			Double tax1, Double tax2, Double tax3, int isInvoice,
			String invoiceTitle, String invoiceDetail, Double pay, Double pay2,
			Double pay3, Double manage, Double manage2, Double act,
			Double improve, Double availableManageCredit, Double consult,
			Double travelCost, Double exchange, Double equipment,
			Double conference, Double departmentPay, String other,
			String astatus, String cardID, String suggestion,
			double departmentPublic, double coProject, double performance,
			double performance1, double performance2, double sumthree) {

		AddOutlay tempAddOutlay = addOutlayDAO.findById(addOutlayPK);

		if (tempAddOutlay == null) {
			return null;
		}

		tempAddOutlay.setIsTax(isTax);
		tempAddOutlay.setTax1(tax1);
		tempAddOutlay.setTax2(tax2);
		tempAddOutlay.setTax3(tax3);
		tempAddOutlay.setIsInvoice(isInvoice);
		tempAddOutlay.setInvoiceTitle(invoiceTitle);
		tempAddOutlay.setInvoiceDetail(invoiceDetail);
		tempAddOutlay.setPay(pay);
		tempAddOutlay.setPay2(pay2);
		tempAddOutlay.setPay3(pay3);
		tempAddOutlay.setManage(manage);
		tempAddOutlay.setManage2(manage2);
		tempAddOutlay.setAct(act);
		tempAddOutlay.setImprove(improve);
		tempAddOutlay.setAvailableManageCredit(availableManageCredit);
		tempAddOutlay.setConsult(consult);
		tempAddOutlay.setTravelCost(travelCost);
		tempAddOutlay.setExchange(exchange);
		tempAddOutlay.setEquipment(equipment);
		tempAddOutlay.setConference(conference);
		tempAddOutlay.setDepartmentPay(departmentPay);
		tempAddOutlay.setOther(other);
		tempAddOutlay.setAstatus(astatus);
		tempAddOutlay.setCardId(cardID);
		tempAddOutlay.setRemark(suggestion);
		tempAddOutlay.setPerformance1(performance1);
		tempAddOutlay.setPerformance2(performance2);
		tempAddOutlay.setSumthree(sumthree);

		// two new
		tempAddOutlay.setDepartmentPublic(departmentPublic);
		tempAddOutlay.setCoProject(coProject);
		tempAddOutlay.setPerformance(performance);

		addOutlayDAO.attachDirty(tempAddOutlay);

		return tempAddOutlay;
	}

	/**
	 * 返回主键为addOutlayPK的入账信息的isFirstOutlay字段信息
	 * 
	 * @param addOutlayPK
	 * @return
	 */
	public int acquireIsFirstOutlayByAddOutlayPK(long addOutlayPK) {

		AddOutlay tempAddOutlay = addOutlayDAO.findById(addOutlayPK);

		if (tempAddOutlay == null) {
			return -1;
		}

		return tempAddOutlay.getIsFirstOutlay();
	}

	// setters and getters

	public AddOutlayDAO getAddOutlayDAO() {
		return addOutlayDAO;
	}

	public void setAddOutlayDAO(AddOutlayDAO addOutlayDAO) {
		this.addOutlayDAO = addOutlayDAO;
	}

	public OldAddOutlayDAO getOldAddOutlayDAO() {
		return oldAddOutlayDAO;
	}

	public void setOldAddOutlayDAO(OldAddOutlayDAO oldAddOutlayDAO) {
		this.oldAddOutlayDAO = oldAddOutlayDAO;
	}

	public ItemDAO getItemDAO() {
		return itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public ProjectManagerDAO getProjectManagerDAO() {
		return projectManagerDAO;
	}

	public void setProjectManagerDAO(ProjectManagerDAO projectManagerDAO) {
		this.projectManagerDAO = projectManagerDAO;
	}

	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public ProjectTypeDAO getProjectTypeDAO() {
		return projectTypeDAO;
	}

	public void setProjectTypeDAO(ProjectTypeDAO projectTypeDAO) {
		this.projectTypeDAO = projectTypeDAO;
	}

	public void test1() {

		List<ProjectType> projectTypes = projectTypeDAO.findAll();
		List<AddOutlay> addOutlays = addOutlayDAO.findAll();
		List<Department> departments = departmentDAO.findAll();

		for (AddOutlay addOutlay : addOutlays) {
			for (Department department : departments) {
				if (department.getDepartmentId().equals(
						addOutlay.getDepartmentId())) {
					addOutlay.setDepartmentName(department.getDepartmentName());
					addOutlayDAO.attachDirty(addOutlay);
				}
			}

			for (ProjectType projectType : projectTypes) {
				if (projectType.getTypeId().equals(addOutlay.getTypeId())) {
					addOutlay.setTypePk(projectType.getTypePk());
					addOutlay.setTypeName(projectType.getTypeName());

					addOutlayDAO.attachDirty(addOutlay);

				}
			}
		}
	}

	public void test3() {

		List<AddOutlay> addOutlays = addOutlayDAO.findAll();

		for (AddOutlay addOutlay : addOutlays) {

			String time = addOutlay.getOutlayTime();
			if (time != null && time.contains("/")) {
				String newtime = time.replaceAll("/", "-");
				System.out.println(newtime);
				addOutlay.setOutlayTime(newtime);
				addOutlayDAO.attachDirty(addOutlay);
			}
		}
		//
		// addOutlays = addOutlayDAO.findAll();

		for (AddOutlay addOutlay : addOutlays) {
			String time = addOutlay.getOutlayTime();
			String newtime;
			int a;
			int b;
			if (time != null && time.length() < 10) {
				a = time.indexOf("-");
				b = time.lastIndexOf("-");
				String nian = time.substring(0, a);
				String yue = time.substring(a + 1, b);
				String ri = time.substring(b + 1);
				newtime = nian + "-";
				if (yue.length() == 1) {
					yue = "0" + yue;
				}
				if (ri.length() == 1) {
					ri = "0" + ri;
				}

				newtime += yue;
				newtime += "-";
				newtime += ri;

				newtime = nian + "-" + yue + "-" + ri;
				System.out.println(newtime);
				addOutlay.setOutlayTime(newtime);
				addOutlayDAO.attachDirty(addOutlay);

			}
		}
	}

	public void test4() {
		List<AddOutlay> addOutlays = addOutlayDAO.findAll();
		for (AddOutlay addOutlay : addOutlays) {
			addOutlay.setAstatus("31");
			addOutlayDAO.attachDirty(addOutlay);
		}
	}

	public void test6() {
		List<AddOutlay> addOutlays = addOutlayDAO.findAll();
		for (AddOutlay addOutlay : addOutlays) {
			addOutlay.setCardId(addOutlay.getItemId());
			addOutlayDAO.attachDirty(addOutlay);
		}
	}
}
