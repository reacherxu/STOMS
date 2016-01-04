package com.stoms.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Transactional;

import com.stoms.dao.A863itemDAO;
import com.stoms.dao.ActualFundItemDAO;
import com.stoms.dao.DepartmentDAO;
import com.stoms.dao.ItemDAO;
import com.stoms.dao.NationalFundItemDAO;
import com.stoms.dao.ProjectTypeDAO;
import com.stoms.dao.SocialScienceItemDAO;
import com.stoms.dao.TeacherDAO;
import com.stoms.model.A863item;
import com.stoms.model.ActualFundItem;
import com.stoms.model.Department;
import com.stoms.model.Item;
import com.stoms.model.NationalFundItem;
import com.stoms.model.ProjectType;
import com.stoms.model.SocialScienceItem;
import com.stoms.model.Teacher;
import com.stoms.model.temp.StatisticsItemByManager;
import com.stoms.utils.JSONTranslation;

public class ItemService {

	private ItemDAO itemDAO;
	private DepartmentDAO departmentDAO;
	private ProjectTypeDAO projectTypeDAO;
	private TeacherDAO teacherDAO;
	private ActualFundItemDAO actualFundItemDAO;
	private NationalFundItemDAO nationalFundItemDAO;
	private A863itemDAO a863itemDAO;
	private SocialScienceItemDAO socialScienceItemDAO;
	private String itemId;
	private int itemIdCount;
	private String itemString;
	private String projectStatusName;
	
	/**
	 * 返回所有工号为teacherId的已经提交可还没通过科技处审批的项目
	 * 
	 * @param teacherId
	 * @return
	 */
	// 管理员功能：项目统计查询（查询条件为typepks，是否横向，departmentpks，时间段，项目状态projectStatus）
	public List acquireStatisticsItem(int[] typepks, int isCross,
			String lowYear, String upperYear, int[] departmentpks) {
		//
		// if (projectStatus.equals("10")) {
		// projectStatusName = "未提交项目";
		// }
		// if (projectStatus.equals("11")) {
		// projectStatusName = "已提交（等待审批）项目";
		// }
		// if (projectStatus.equals("30")) {
		// projectStatusName = "审批未通过项目";
		// }
		// if (projectStatus.equals("31")) {
		// projectStatusName = "审批已通过项目";
		// }
		//
		// if (projectStatusName.equals("")) {
		// projectStatusName = "其他";
		// }

		List<Item> itemList = itemDAO.findStatisticsItemlistByManager(typepks,
				isCross, departmentpks);

		List<StatisticsItemByManager> statisticsItemByManagers = new ArrayList<StatisticsItemByManager>();
		List<Item> delItemList = new ArrayList<Item>();

		List<Item> delList1 = new ArrayList<Item>();
		List<Item> delList2 = new ArrayList<Item>();
		if (lowYear != null && !"".equals(lowYear)) {
			for (Item item : itemList) {
				if (item.getTimeLower().compareTo(lowYear) < 0) {
					delList1.add(item);
				}
			}
		}
		itemList.removeAll(delList1);

		if (upperYear != null && !"".equals(upperYear)) {
			for (Item item : itemList) {
				if (item.getTimeUpper().compareTo(upperYear) > 0) {
					delList2.add(item);
				}
			}
		}
		itemList.removeAll(delList2);

		int countapply = itemList.size();
		int countapprove=0;
		int counting=0;
		int countfinish=0;
		for (Item l : itemList) {		
			if (l.getProjectStatus().equals("31")) {
				countapprove++;
				if (l.getIsFinished()!=null) {
					if (l.getIsFinished().intValue() == 0) {
						counting++;
					}else {
						countfinish++;
					}
				}
				
			}
		}
		statisticsItemByManagers.add(new StatisticsItemByManager("all", countapply));
		statisticsItemByManagers.add(new StatisticsItemByManager("31", countapprove));
		statisticsItemByManagers.add(new StatisticsItemByManager("310", counting));
		statisticsItemByManagers.add(new StatisticsItemByManager("311", countfinish));
//		while (itemList.size() > 0) {
//			projectStatusName = itemList.get(0).getProjectStatus();
//
//			if (projectStatusName.equals("31")) {
//
//				if (itemList.get(0).getIsFinished() != null
//						&& itemList.get(0).getIsFinished() == 1) {
//					for (Item i : itemList) {
//						if (i.getIsFinished() != null) {
//							if (i.getProjectStatus().equals(projectStatusName)
//									&& i.getIsFinished() == 1) {
//								delItemList.add(i);
//							}
//						}
//
//					}
//					statisticsItemByManagers.add(new StatisticsItemByManager(
//							projectStatusName + ":1", delItemList.size()));
//				}
//				if (itemList.get(0).getIsFinished() != null
//						&& itemList.get(0).getIsFinished() == 0) {
//					for (Item i : itemList) {
//						if (i.getIsFinished() != null) {
//							if (i.getProjectStatus().equals(projectStatusName)
//									&& i.getIsFinished() == 0) {
//								delItemList.add(i);
//							}
//						}
//					}
//					statisticsItemByManagers.add(new StatisticsItemByManager(
//							projectStatusName + ":0", delItemList.size()));
//				}
//			}
//
//			if (!projectStatusName.equals("31")) {
//				for (Item i : itemList) {
//					if (i.getProjectStatus().equals(projectStatusName)) {
//						delItemList.add(i);
//					}
//				}
//				statisticsItemByManagers.add(new StatisticsItemByManager(
//						projectStatusName, delItemList.size()));
//			}
//
//			itemList.removeAll(delItemList);
//			delItemList.clear();
//		}

		return statisticsItemByManagers;
	}
	/**
	 * 删除主键数组里面的项目
	 * @param 
	 * @return
	 */
	public boolean deleteSelectedItem(long[] PKArray) {
		
		boolean result = false;
		
		for (int i = 0; i < PKArray.length; i++) {
			
			long PK = (long)PKArray[i];
			
			Item tempObject = itemDAO.findById(PK);
			if(tempObject != null) {
				itemDAO.delete(tempObject);
				result = true;
			}
		}
		
		return result;
	}
	
	public Item modifyItem(Long itemPK, String itemName,String contractID,
			String teacherName, String otherTeacher, String itemType,
			int departmentPk,String departmentId,String departmentName, String departmentType,
			String cardid, Double itemValue, Double remitValue,
			String timeLower, String timeUpper, int isFinished) {

		Item tempItem = itemDAO.findById(itemPK);

		tempItem.setItemName(itemName);
		tempItem.setContractId(contractID);
		tempItem.setTeacherName(teacherName);
		tempItem.setOtherTeacher(otherTeacher);
		tempItem.setTypeId(itemType);
//		Department department = new Department();
//		department.setDepartmentPk(departmentPk);
//		department.setDepartmentId(departmentId);
//		department.setDepartmentName(departmentName);
//		tempItem.setDepartment(department);
		tempItem.setCardId(cardid);
		tempItem.setItemValue(itemValue);
		tempItem.setRemitValue(remitValue);
		tempItem.setTimeLower(timeLower);
		tempItem.setTimeUpper(timeUpper);
		tempItem.setIsFinished(isFinished);
		itemDAO.attachDirty(tempItem);
		return tempItem;

	}
	
	public Item acquireOneItemInfo(long itemPK){
		Item item = itemDAO.findById(itemPK);
		return item;
	}
	// 管理员功能：单个项目信息查询（查询条件为typepks，是否横向，departmentpks，时间段）
	public List acquireItemInfo2(String itemid,String contractid,String typeid,String itemname,
			String departmentid,String departmenttype,String teachername,
			String lowYear,String upperYear) {
		List<Item> iteminfolist = itemDAO.findItemInfoByManager2(itemid,contractid,typeid,
				itemname,departmentid,departmenttype,teachername,lowYear,upperYear);
		
		System.out.println(iteminfolist.size());

		return iteminfolist;
	}	
	
	// 管理员功能：单个项目信息查询（查询条件为typepks，是否横向，departmentpks，时间段）
	public List acquireItemInfo(int[] typepks, int isCross, String lowYear,
			String upperYear, int[] departmentpks) {
		List<Item> iteminfolist = itemDAO.findItemInfoByManager(typepks,
				isCross, departmentpks);
		
		System.out.println(iteminfolist.size());

		List<Item> delList1 = new ArrayList<Item>();
		List<Item> delList2 = new ArrayList<Item>();
		if (lowYear != null && !"".equals(lowYear)) {
			for (Item item : iteminfolist) {
				if (item.getTimeLower()==null) {
					delList1.add(item);
				}
				if (item.getTimeLower()!=null&&item.getTimeLower().compareTo(lowYear) < 0) {
					delList1.add(item);
				}
			}
		}
		iteminfolist.removeAll(delList1);

		if (upperYear != null && !"".equals(upperYear)) {
			for (Item item : iteminfolist) {
				if (item.getTimeLower()==null) {
					delList2.add(item);
				}
				if (item.getTimeLower()!=null&&item.getTimeLower().compareTo(upperYear) > 0) {
					delList2.add(item);
				}
			}
		}
		iteminfolist.removeAll(delList2);
		System.out.println(iteminfolist.size());
		return iteminfolist;
	}

	public String findAllUnapprovedItems(String teacherId) {
		String result = "";
		// 这块要组合查询，不但要查询教师的ID还要判断项目的状态
		// List<Item> itemList = itemDAO.findTeaIDVSproStatus(teacherId);
		List<Item> itemList = itemDAO.findbyTeacherIDandCreatID(teacherId);

		/*
		 * for (int i = 0; i < itemList.size(); i++) { Item item =
		 * itemList.get(i); if (!item.getProjectStatus().equals("10")&&
		 * !item.getProjectStatus().equals("11")) { itemList.remove(item); } }
		 */

		String[] excludes = { "teacher", "department", "contractId", "creatId",
				"creatName", "teacherId", "teacherName", "departmentType",
				"departmentName", "itemValue", "remitValue", "timeLower",
				"timeUpper", "paidFunds", "applyYear", "applyDate",
				"approveDate", "timeFinish", "isCross", "isFinished",
				"evaluate", "picture", "other", "subTypeId", "subTypeName",
				"departmentType", "pmanage", "ppay", "pconsult",
				"pavailableManageCredit", "pdepartmentPay", "ppay", "ppay3",
				"ptax1", "ptax2", "ppay", "ptax3", "isTax", "isCross", "pact",
				"pimprove", "pmanage2", "ppay2" };

		if (itemList == null || itemList.size() == 0) {
			return "";
		}

		result = JSONTranslation.arrayToJson(itemList, excludes);
		return result;
	}

	// 通过teacherId获得横向项目cardId
	public String[] acquireCardID(String teacherId) {
		String[] cardStrings = null;
		List al = new ArrayList();
		List removeal = new ArrayList();
		al = itemDAO.findCardIDbyTeacherID(teacherId);

		for (int i = 0; i < al.size(); i++) {
			if (al.get(i) == null || al.get(i).equals("")) {
				removeal.add(al.get(i));
			}
		}
		al.removeAll(removeal);

		cardStrings = (String[]) al.toArray(new String[1]);
		return cardStrings;
	}
	public static void main(String[] args) {
		 ItemService is = new ItemService();
		 System.out.println(is.creatItemID("0202", "131"));
	}
	// 创建itemID
	@Transactional
	public  String creatItemID(String departmentId, String typeId) {
		itemString = departmentId + typeId;
		List<Item> CreatItemList = itemDAO.findByItemString(itemString);
//		itemIdCount = 1;
//
//		if (CreatItemList.size() == 0) {
//			itemId = itemString + "001";
//		}
//		for (int i = 0; i < CreatItemList.size(); i++) {
//			Item item = CreatItemList.get(i);
//			if (Integer.parseInt(item.getItemId().substring(7)) == itemIdCount) {
//				itemIdCount++;
//			} else {
//				itemId = itemString + itemIdCount / 100
//						+ (itemIdCount % 100 / 10) + (itemIdCount % 10);
//				List<Item> AlreadyItem = itemDAO.findByItemId(itemId);
//
//				if (AlreadyItem.size() > 0) {
//					itemIdCount++;
//				} else {
//					break;
//				}
//			}
//		}
		itemIdCount = 0;
//		for (int i = 0; i < CreatItemList.size(); i++) {
//			Item item = CreatItemList.get(i);
//			int maxCount = Integer.parseInt(item.getItemId().substring(7));
//			if("0205151".equals(itemString) && maxCount == 601){
//				continue;
//			}
//			if("0205151".equals(itemString) && maxCount == 600 && itemIdCount < 600){
//				itemIdCount = maxCount+1;
//			}
//			if (maxCount > itemIdCount) {
//				itemIdCount = maxCount;
//			}
//		}
		if(CreatItemList.size() == 0){
			itemId = itemString + "001";
		}else{
			//首先获得查询结果的最后一个数据，比如为003
			//然后把这个值加1作为新ID，如果新ID已经存在，就再加1，直到不存在位置
			Item item = CreatItemList.get(CreatItemList.size()-1);
			if(item.getItemId().length() == 10){
				itemIdCount = Integer.parseInt(item.getItemId().substring(7));
			}else if(item.getItemId().length() == 12){
				itemIdCount = Integer.parseInt(item.getItemId().substring(9));
			}
			
			while(true){
				itemId = itemString + (itemIdCount+1) / 100
						+ ((itemIdCount+1) % 100 / 10) + ((itemIdCount+1) % 10);
				List<Item> AlreadyItem = itemDAO.findByItemId(itemId);

				if (AlreadyItem.size() > 0) {
					itemIdCount++;
				} else {
					break;
				}
			}
			itemId = itemString + (itemIdCount+1) / 100
					+ ((itemIdCount+1) % 100 / 10) + ((itemIdCount+1) % 10);
		}
		return itemId;
	}

	public String findItemByItemPK(long itemPK) {

		String result = "";

		Item item = itemDAO.findById(itemPK);

		if (item == null) {
			return "";
		}
		String[] excludes = { "teacher", "subTypeId", "subTypeName", "pmanage",
				"ppay", "pconsult", "pavailableManageCredit", "pdepartmentPay",
				"ppay3", "ptax1", "ptax2", "ptax3", "isTax", "items",
				"departmentId", "assistanceName", "assistanceTel",
				"assistanceMobile", "assistanceEmail", "teachers", "paidFunds",
				"isFinished" };
		result = JSONTranslation.objectToJson(item, excludes);
		return result;
	}
	
	public String findItemByItemPK2(long itemPK) {

		String result = "";

		Item item = itemDAO.findById(itemPK);

		if (item == null) {
			return "";
		}
		String[] excludes = {};
		result = JSONTranslation.objectToJson(item, excludes);
		return result;

	}

	public String acquireItemInfoByItemID(String itemID) {

		String result = "";

		List itemList = itemDAO.findByItemId(itemID);
		Item tempItem = new Item();
		if (itemList != null || itemList.size() > 1) {
			tempItem = (Item) itemList.get(0);
		}

		String[] excludes = { "teacher", "department", "projectType",
				"creatId", "creatName", "teacherId",
				"teacherName", "departmentType", "departmentName", "itemValue",
				"cardId", "remitValue", "timeLower", "timeUpper", "paidFunds",
				"applyYear", "applyDate", "approveDate", "timeFinish",
				"projectStatus", "isCross", "isFinished", "evaluate",
				"picture", "other" };

		result = JSONTranslation.objectToJson(tempItem, excludes);

		return result;

	}
	
	/**
	 * 获取该项目的起止时间
	 * @param itemID
	 * @return
	 */
	public String acquireYearRangeByItemID(String itemID) {
		
		String result = "";

		List itemList = itemDAO.findByItemId(itemID);
		Item tempItem = new Item();
		if (itemList != null || itemList.size() > 1) {
			tempItem = (Item) itemList.get(0);
			
			result = tempItem.getTimeLower() + " 至  " 
					+ tempItem.getTimeUpper();
			
		} 
		
		return result;
	}

	/**
	 * 判断该项目是否已包含预算信息
	 * 
	 * @param itemPK
	 * @param itemTypeID
	 * @return
	 */
	public boolean judgeWhetherHavedBudgetInfo(long itemPK, int budgetType) {

		boolean result = false;

		List budgetList = new ArrayList();

		switch (budgetType) {
		case 4:
			// 社科基金
			budgetList = socialScienceItemDAO.findByItemPk(itemPK);
			break;
		case 3:
			// 863/973基金
			budgetList = a863itemDAO.findByItemPk(itemPK);
			break;
		case 2:
			// 国家基金
			budgetList = nationalFundItemDAO.findByItemPk(itemPK);
			break;
		case 1:
			// 省基金
			budgetList = actualFundItemDAO.findByItemPk(itemPK);
			break;
		}

		if (!(budgetList == null || budgetList.size() == 0)) {
			result = true;
		}

		return result;
	}

	/**
	 * 删除主键为itemPK的项目的预算信息
	 * 
	 * @param itemPK
	 * @param itemTypeID
	 * @return
	 */
	@Transactional
	public boolean deleteRelatedBudgetOfThisItem(long itemPK,
			int deleteRelatedBudgetOfThisItem) {

		boolean result = true;

		List budgetList = new ArrayList();

		switch (deleteRelatedBudgetOfThisItem) {
		case 4:
			// 社科基金
			budgetList = socialScienceItemDAO.findByItemPk(itemPK);
			if (budgetList != null && budgetList.size() > 0) {
				for (int i = 0; i < budgetList.size(); i++) {
					SocialScienceItem tempSocialScienceItem = (SocialScienceItem) budgetList
							.get(i);
					if (tempSocialScienceItem != null) {
						socialScienceItemDAO.delete(tempSocialScienceItem);
					}
				}
			}
			break;
		case 3:
			// 863/973基金
			budgetList = a863itemDAO.findByItemPk(itemPK);
			if (budgetList != null && budgetList.size() > 0) {
				for (int i = 0; i < budgetList.size(); i++) {
					A863item tempA863item = (A863item) budgetList.get(i);
					if (tempA863item != null) {
						a863itemDAO.delete(tempA863item);
					}
				}
			}
			break;
		case 2:
			// 国家基金
			budgetList = nationalFundItemDAO.findByItemPk(itemPK);
			if (budgetList != null && budgetList.size() > 0) {
				for (int i = 0; i < budgetList.size(); i++) {
					NationalFundItem tempNationalFundItem = (NationalFundItem) budgetList
							.get(i);
					if (tempNationalFundItem != null) {
						nationalFundItemDAO.delete(tempNationalFundItem);
					}
				}
			}
			break;
		case 1:
			// 省基金
			budgetList = actualFundItemDAO.findByItemPk(itemPK);
			if (budgetList != null && budgetList.size() > 0) {
				for (int i = 0; i < budgetList.size(); i++) {
					ActualFundItem tempActualFundItem = (ActualFundItem) budgetList
							.get(i);
					if (tempActualFundItem != null) {
						actualFundItemDAO.delete(tempActualFundItem);
					}
				}
			}
			break;
		default:
			result = false;
		}

		return result;

	}

	public Item saveProjectRegistrationInfo(Long itemPK, String itemName,
			int itemTypePk, String itemType, String contractID, int isCross,
			String teacherName, String teacherId, int departmentPk,
			String departmentName, String departmentType, Double itemValue,
			String timeLower, String timeUpper, String applyYear) {

		Item tempItem = itemDAO.findById(itemPK);

		if (tempItem == null) {
//			// 如果找不到与该itemPK为主键的项目信息，则新建一个项目对象
//
//			tempItem = new Item();
//
//			tempItem = setItemProperties(tempItem, itemName, itemTypePk,
//					itemType, contractID, isCross, teacherName, teacherId,
//					departmentPk, departmentName, departmentType, itemValue,
//					timeLower, timeUpper, applyYear);
//
//			tempItem = saveCreatorIDAndName(tempItem);
//
//			String tempProjectStatus = tempItem.getProjectStatus();
//			if (tempProjectStatus != "70") {
//				tempItem.setProjectStatus("10");
//			}
//
//			itemDAO.save(tempItem);

		} else {
			// 如果是非新建项目，则取出该项目内容，并更新一些属性值
//
//			tempItem = setItemProperties(tempItem, itemName, itemTypePk,
//					itemType, contractID, isCross, teacherName, teacherId,
//					departmentPk, departmentName, departmentType, itemValue,
//					timeLower, timeUpper, applyYear);
//
//			String tempProjectStatus = tempItem.getProjectStatus();
//			if (tempProjectStatus != "70") {
//				tempItem.setProjectStatus("10");
//			}
//
//			itemDAO.attachDirty(tempItem);
		}

		return tempItem;

	}

	@Transactional
	public Item submitProjectRegistrationInfo(Long itemPK, String itemName,
			int itemTypePk, String itemType, String contractID, int isCross,
			String teacherName, String otherTeacher, String teacherId, int departmentPk,
			String departmentName, String departmentType, Double itemValue,
			String timeLower, String timeUpper, String applyYear) {

		Item tempItem = itemDAO.findById(itemPK);

		if (tempItem == null) {
			// 如果找不到与该itemPK为主键的项目信息，则新建一个项目对象

			tempItem = new Item();

			tempItem = setItemProperties(tempItem, itemName, itemTypePk,
					itemType, contractID, isCross, teacherName, otherTeacher,teacherId,
					departmentPk, departmentName, departmentType, itemValue,
					timeLower, timeUpper, applyYear);

			tempItem = saveCreatorIDAndName(tempItem);

			// 生成项目代码
			String itemID = creatItemID(tempItem.getDepartment()
					.getDepartmentId(), tempItem.getProjectType().getTypeId());
			tempItem.setItemId(itemID);

			/*
			 * // 如果是纵向项目，则自动生成经费卡号，经费卡号和项目代码一致 if (isCross == 0) {
			 * tempItem.setCardId(itemID); }
			 */

			// 保存申请日期和年度
			tempItem = saveApplyDateForItem(tempItem);

			String tempProjectStatus = tempItem.getProjectStatus();
			if (tempProjectStatus == "70") {
				tempItem.setProjectStatus("71");
			} else {
				tempItem.setProjectStatus("11");
			}

			itemDAO.save(tempItem);

		} else {
			// 如果是非新建项目，则取出该项目内容，并更新一些属性值

//			tempItem = setItemProperties(tempItem, itemName, itemTypePk,
//					itemType, contractID, isCross, teacherName, teacherId,
//					departmentPk, departmentName, departmentType, itemValue,
//					timeLower, timeUpper, applyYear);
//
//			// 生成项目代码
//			String itemID = tempItem.getItemId();
//			if (itemID == null || itemID.trim().equals("")) {
//				itemID = creatItemID(
//						tempItem.getDepartment().getDepartmentId(), tempItem
//								.getProjectType().getTypeId());
//				tempItem.setItemId(itemID);
//
//			}
//
//			/*
//			 * // 如果是纵向项目，则自动生成经费卡号，经费卡号和项目代码一致 if (isCross == 0) {
//			 * tempItem.setCardId(itemID); }
//			 */
//
//			// 保存申请日期和年度
//			tempItem = saveApplyDateForItem(tempItem);
//
//			String tempProjectStatus = tempItem.getProjectStatus();
//			if (tempProjectStatus == "70") {
//				tempItem.setProjectStatus("71");
//			} else {
//				tempItem.setProjectStatus("11");
//			}
//
//			itemDAO.attachDirty(tempItem);
		}

		// 保存预算表里的基本信息
		storeItemIDForBudgetTable(tempItem);

		return tempItem;
	}

	/**
	 * 保存项目的创建者的工号和姓名
	 * modified by shi 20131008
	 * @param originalItem
	 * @return
	 */
	private Item saveCreatorIDAndName(Item originalItem) {

		HttpSession session = ServletActionContext.getRequest().getSession();
		String currentTeacherID = (String) session
				.getAttribute("curr_adminID");//此处creatorID和creatorName 改为管理员的session20131007shi 当需要教师自己录入时 可以改回教师的session
		String currentTeacherName = (String) session
				.getAttribute("adminName");

		originalItem.setCreatId(currentTeacherID);
		originalItem.setCreatName(currentTeacherName);

		return originalItem;
	}

	/**
	 * 设置oldItem项目的各个属性
	 * 
	 * @param oldItem
	 * @param itemID
	 * @param itemName
	 * @param itemTypePk
	 * @param itemType
	 * @param isCross
	 * @param teacherName
	 * @param teacherId
	 * @param departmentPk
	 * @param departmentName
	 * @param departmentType
	 * @param itemValue
	 * @param remitValue
	 * @param timeLower
	 * @param timeUpper
	 * @param paidFunds
	 * @param isFinished
	 * @return
	 */
	private Item setItemProperties(Item oldItem, String itemName,
			int itemTypePk, String itemType, String contractID, int isCross,
			String teacherName, String otherTeacher,String teacherId, int departmentPk,
			String departmentName, String departmentType, Double itemValue,
			String timeLower, String timeUpper, String applyYear) {

		Item tempItem = oldItem;

		ProjectType projectType = projectTypeDAO.findById(itemTypePk);
		List teacherList = teacherDAO.findByTeacherId(teacherId);
		Department department = departmentDAO.findById(departmentPk);

		tempItem.setItemName(itemName);
		if (projectType != null) {
			tempItem.setProjectType(projectType);
			tempItem.setTypeId(projectType.getTypeId());
		}

		tempItem.setContractId(contractID);

		tempItem.setTypeName(itemType);
		if (isCross != -1) {
			tempItem.setIsCross(isCross);
		}
		if (teacherList.size() == 1) {
			Teacher tempTeacher = (Teacher) teacherList.get(0);
			tempItem.setTeacher(tempTeacher);
		}

		tempItem.setTeacherName(teacherName);
		tempItem.setOtherTeacher(otherTeacher);
		tempItem.setTeacherId(teacherId);
		if (department != null) {
			tempItem.setDepartment(department);
			tempItem.setDepartmentId(department.getDepartmentId());
		}
		tempItem.setDepartmentName(departmentName);

		tempItem.setDepartmentType(departmentType);

		tempItem.setItemValue(itemValue);
		tempItem.setTimeLower(timeLower);
		tempItem.setTimeUpper(timeUpper);
		tempItem.setApplyYear(applyYear);
		
		//如果该项目的登记工作由管理员操作，则session的curr_adminID字段不为空，则保存管理员账号到数据库中
		HttpSession session = ServletActionContext.getRequest().getSession();
		String tmpOperatorID = (String) session
				.getAttribute("curr_adminID");
		if(tmpOperatorID != null && !tmpOperatorID.trim().equals("")) {
			tempItem.setOperatorId(tmpOperatorID);
		}
		
		return tempItem;
	}

	/**
	 * 
	 * @param item
	 */
	public Item saveApplyDateForItem(Item item) {

		// 获取当前页面请求主机的时间
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = formatter.format(date);

		item.setApplyDate(currentDate);

		return item;
	}

	/**
	 * 为主键为itemPK的项目创建经费卡号
	 * 
	 * @param itemPK
	 * @return
	 */
	@Transactional
	public String createCardIDForCrossItem(long itemPK) {

		String cardID = "";

		Item tempItem = itemDAO.findById(itemPK);

		cardID = tempItem.getItemId();

		String originalCardID = tempItem.getCardId();

		if (originalCardID == null || originalCardID.trim().equals("")) {
			tempItem.setCardId(cardID);
			itemDAO.attachDirty(tempItem);
		}

		return cardID;
	}

	/**
	 * 返回项目ID为itemID的项目的经费卡卡号
	 * 
	 * @param itemID
	 * @return
	 */
	public String acquireCardIDOfItemByItemID(String itemID) {

		List tempItemList = itemDAO.findByItemId(itemID);

		if (tempItemList == null || tempItemList.size() == 0) {
			return "";
		}

		Item tempItem = (Item) tempItemList.get(0);

		return tempItem.getCardId();
	}

	/**
	 * 设置各种预算表里的项目代码
	 * 
	 * @param itemID
	 *            项目代码，系统自定义的编码（前四位院系代码，接着三位项目类型代码，最后三位序号）
	 */
	public void storeItemIDForBudgetTable(Item tempItem) {

		// @param budgetType 预算表类型 4：社科基金类型； 3：863/973预算类型； 2：国家基金预算类型；
		// 1：省基金预算类型；0：无预算类型
		int budgetType = tempItem.getProjectType().getBudgetType();
		long itemPK = tempItem.getItemPk();
		List budgetList = new ArrayList();

		switch (budgetType) {
		case 4:
			// 社科基金
			budgetList = socialScienceItemDAO.findByItemPk(itemPK);
			if (budgetList != null && budgetList.size() > 0) {

				SocialScienceItem tempSocialScienceItem = (SocialScienceItem) budgetList
						.get(0);
				tempSocialScienceItem.setContractId(tempItem.getContractId());
				tempSocialScienceItem.setItemName(tempItem.getItemName());
				tempSocialScienceItem.setItemId(tempItem.getItemId());
				tempSocialScienceItem.setTeacherName(tempItem.getTeacherName());
				socialScienceItemDAO.attachDirty(tempSocialScienceItem);
			}
			break;
		case 3:
			// 863/973基金
			budgetList = a863itemDAO.findByItemPk(itemPK);
			if (budgetList != null && budgetList.size() > 0) {

				A863item tempA863item = (A863item) budgetList.get(0);
				tempA863item.setContractId(tempItem.getContractId());
				tempA863item.setItemName(tempItem.getItemName());
				tempA863item.setItemId(tempItem.getItemId());
				tempA863item.setTeacherName(tempItem.getTeacherName());
				a863itemDAO.attachDirty(tempA863item);
			}
			break;
		case 2:
			// 国家基金
			budgetList = nationalFundItemDAO.findByItemPk(itemPK);
			if (budgetList != null && budgetList.size() > 0) {

				NationalFundItem tempNationalFundItem = (NationalFundItem) budgetList
						.get(0);
				tempNationalFundItem.setContractId(tempItem.getContractId());
				tempNationalFundItem.setItemName(tempItem.getItemName());
				tempNationalFundItem.setItemId(tempItem.getItemId());
				tempNationalFundItem.setTeacherName(tempItem.getTeacherName());
				nationalFundItemDAO.attachDirty(tempNationalFundItem);
			}
			break;
		case 1:
			// 省基金
			budgetList = actualFundItemDAO.findByItemPk(itemPK);
			if (budgetList != null && budgetList.size() > 0) {

				ActualFundItem tempActualFundItem = (ActualFundItem) budgetList
						.get(0);

				tempActualFundItem.setContractId(tempItem.getContractId());
				tempActualFundItem.setItemName(tempItem.getItemName());
				tempActualFundItem.setItemId(tempItem.getItemId());
				tempActualFundItem.setTeacherName(tempItem.getTeacherName());
				actualFundItemDAO.attachDirty(tempActualFundItem);

			}
			break;
		}
	}

	/**
	 * 返回项目ID为itemID的项目的负责人工号
	 * 
	 * @param itemID
	 * @return
	 */
	public String acquireTeacherIdOfItemByItemID(String itemID) {

		List tempItemList = itemDAO.findByItemId(itemID);

		if (tempItemList == null || tempItemList.size() == 0) {
			return "";
		}

		Item tempItem = (Item) tempItemList.get(0);

		return tempItem.getTeacherId();
	}

	/**
	 * 为项目ID为itemID的项目创建银行卡号
	 * 
	 * @param cardId
	 * @param itemID
	 * @return
	 */
	@Transactional
	public boolean createCardForItemByItemID(String cardId, String itemID) {
		boolean result = true;

		List tempItemList = itemDAO.findByItemId(itemID);

		if (tempItemList == null || tempItemList.size() == 0) {
			return false;
		}

		Item tempItem = (Item) tempItemList.get(0);

		String originalCardId = tempItem.getCardId();
		System.out.println(originalCardId);
		if (originalCardId == null || originalCardId.trim().equals("")) {
			tempItem.setCardId(cardId);
			itemDAO.attachDirty(tempItem);
		}

		return result;
	}

	// setters and getters

	public ItemDAO getItemDAO() {
		return itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
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

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public ActualFundItemDAO getActualFundItemDAO() {
		return actualFundItemDAO;
	}

	public void setActualFundItemDAO(ActualFundItemDAO actualFundItemDAO) {
		this.actualFundItemDAO = actualFundItemDAO;
	}

	public A863itemDAO getA863itemDAO() {
		return a863itemDAO;
	}

	public void setA863itemDAO(A863itemDAO a863itemDAO) {
		this.a863itemDAO = a863itemDAO;
	}

	public NationalFundItemDAO getNationalFundItemDAO() {
		return nationalFundItemDAO;
	}

	public void setNationalFundItemDAO(NationalFundItemDAO nationalFundItemDAO) {
		this.nationalFundItemDAO = nationalFundItemDAO;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getItemIdCount() {
		return itemIdCount;
	}

	public void setItemIdCount(int itemIdCount) {
		this.itemIdCount = itemIdCount;
	}

	public String getItemString() {
		return itemString;
	}

	public void setItemString(String itemString) {
		this.itemString = itemString;
	}

	public String getProjectStatusName() {
		return projectStatusName;
	}

	public void setProjectStatusName(String projectStatusName) {
		this.projectStatusName = projectStatusName;
	}

	public SocialScienceItemDAO getSocialScienceItemDAO() {
		return socialScienceItemDAO;
	}

	public void setSocialScienceItemDAO(
			SocialScienceItemDAO socialScienceItemDAO) {
		this.socialScienceItemDAO = socialScienceItemDAO;
	}

	
	public void test1() {

		List<ProjectType> projectTypes = projectTypeDAO.findAll();
		List<Item> items = itemDAO.findAll();
		List<Department> departments=departmentDAO.findAll();
		System.out.println(projectTypes.size());
		System.out.println(items.size());
		for (Item item : items) {
			for (ProjectType pType : projectTypes) {
				if (pType.getTypeId().equals(item.getTypeId())) {
					item.setProjectType(pType);
					item.setTypeName(pType.getTypeName());
					itemDAO.attachDirty(item);
					break;
				}
			}	
		}		
		for (Item item : items) {
			for (Department department : departments) {
				if (department.getDepartmentId().equals(item.getDepartmentId())) {
					item.setDepartment(department);
					itemDAO.attachDirty(item);
					break;
				}
			}
		}
	}
	

public void test2() {
	
	List<Item> items = itemDAO.findAll();
	System.out.println(items.size());
	for (Item item : items) {
		String time = item.getTimeLower();
		
		if (time!=null&&time.contains("-")) {
			if (time.length()<10) {
				int a = time.indexOf("-");
				int b = time.lastIndexOf("-");
				String nian = time.substring(0,a);
				String yue = time.substring(a+1,b);
				String ri = time.substring(b+1);
				String newtime = nian+"-";
				if(yue.length() == 1)
				{
					yue = "0"+ yue;
				}
				if(ri.length() == 1)
				{
					ri = "0"+ ri;
				}
				
				newtime+=yue;
				newtime+="-";
				newtime+=ri;
				
				item.setTimeLower(newtime);
				itemDAO.attachDirty(item);
			}
		}
	}
	
	
	for (Item item : items) {
		String time = item.getTimeUpper();
		
		if (time!=null&&time.contains("-")) {
			if (time.length()<10) {
				int a = time.indexOf("-");
				int b = time.lastIndexOf("-");
				String nian = time.substring(0,a);
				String yue = time.substring(a+1,b);
				String ri = time.substring(b+1);
				String newtime = nian+"-";
				if(yue.length() == 1)
				{
					yue = "0"+ yue;
				}
				if(ri.length() == 1)
				{
					ri = "0"+ ri;
				}
				
				newtime+=yue;
				newtime+="-";
				newtime+=ri;
				
				item.setTimeUpper(newtime);
				itemDAO.attachDirty(item);
			}
		}
	}		

}

public void test3() {
	
	List<Item> items = itemDAO.findAll();
	System.out.println(items.size());
	for (Item item : items) {
		String time = item.getTimeLower();
		
		if (time!=null&&!time.contains("-")&&time.length()==8) {
			String nian = time.substring(0,4);
			String yue = time.substring(4,6);
			String ri = time.substring(6);
			
			String newtime = nian+"-"+yue+"-"+ri;
			
			item.setTimeLower(newtime);
			itemDAO.attachDirty(item);
			
		}
	}
	
	for (Item item : items) {
		String time = item.getTimeUpper();
		
		if (time!=null&&!time.contains("-")&&time.length()==8) {
			String nian = time.substring(0,4);
			String yue = time.substring(4,6);
			String ri = time.substring(6);
			
			String newtime = nian+"-"+yue+"-"+ri;
			
			item.setTimeUpper(newtime);
			itemDAO.attachDirty(item);
			
		}
	}
}
public void test4() {
	List<Item> items = itemDAO.findAll();
	for (Item item : items) {
		item.setProjectStatus("31");
		itemDAO.attachDirty(item);
	}
}

public void test5() {

	List<Teacher> teachers = teacherDAO.findAll();
	List<Item> items = itemDAO.findAll();
	System.out.println(items.size());
	for (Item item : items) {
		for (Teacher tea : teachers) {
			if (tea.getTeacherName().equals(item.getTeacherName())) {
				item.setTeacher(tea);
				item.setTeacherId(tea.getTeacherId());
				itemDAO.attachDirty(item);
				break;
			}
		}	
	}		

}

public void test6() {
	List<Item> items = itemDAO.findAll();
	for (Item item : items) {
		item.setCardId(item.getItemId());
		itemDAO.attachDirty(item);
	}
}

}
