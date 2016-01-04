package com.stoms.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.model.Department;
import com.stoms.model.Item;
import com.stoms.model.TeacherAuthority;
import com.stoms.service.DepartmentService;
import com.stoms.service.ItemService;
import com.stoms.service.ProjectManagerService;
import com.stoms.service.ProjectTypeService;
import com.stoms.service.TeacherAuthorityService;
import com.stoms.utils.JSONTranslation;

public class ProjectRegistrationAction extends ActionSupport {

	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;

	private Long itemPK;

	private String itemID;

	private String itemName;

	private int itemTypePk;

	private String itemType;

	private String contractID;

	private int isCross;

	private String teacherName;
	
	private String otherTeacher;

	private String teacherId;

	private int departmentPk;

	private String departmentName;

	private String departmentType;

	private Double itemValue;

	private Double remitValue;

	private String timeLower;

	private String timeUpper;

	private String applyYear;

	private String typeId;
	
	private int budgetType;

	private String[] participateTeacherNameArray;
	private String[] participateTeacherIDArray;

	private ItemService itemService;
	private DepartmentService departmentService;
	private ProjectTypeService projectTypeService;
	private ProjectManagerService projectManagerService;
	private TeacherAuthorityService teacherAuthorityService;

	/**
	 * 返回所有工号为teacherId的已经提交可还没通过科技处审批的项目
	 * 
	 * @return
	 */
	public String findAllUnapprovedItems() {

		// 得到会话的用户ID
		HttpSession session = ServletActionContext.getRequest().getSession();
		String teacherID = (String) session.getAttribute("curr_teacherID");

		this.jsonResult = itemService.findAllUnapprovedItems(teacherID);
		
		if (this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}

		this.actionStatus = true;
		return "success";
	}

	/**
	 * 取得所有项目类型的主键和名称，以及院系的主键和名称， 来初始化页面中院系和项目类型的下拉列表
	 * 
	 * @return
	 */
	public String acquireInfoToInitializePage() {

		// 项目类型的主键和名称信息
		String allProjectTypeInfo = projectTypeService
				.acquireAllProjectTypePKAndName();
		// 院系的主键和名称信息
		String allDepartmentInfo = departmentService
				.acquireAllDepartmentPKAndName();

		/***************** 获取该教师和授权给该教师的 工号和姓名 begin ************************/
		HttpSession session = ServletActionContext.getRequest().getSession();
		String currentTeacherID = (String) session
				.getAttribute("curr_teacherID");
		String currentTeacherName = (String) session
				.getAttribute("teacherName");

		if (currentTeacherID == null || currentTeacherID.trim().equals("")
				|| currentTeacherName == null
				|| currentTeacherName.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}

		List authorialTeachers = teacherAuthorityService
				.acquireTeacherAuthorityList(currentTeacherID);
		TeacherAuthority tempTeacherAuthority = new TeacherAuthority();
		tempTeacherAuthority.setTeacherId(currentTeacherID);
		tempTeacherAuthority.setTeacherName(currentTeacherName);
		authorialTeachers.add(0, tempTeacherAuthority);

		String[] teacherAuthorityExcludes = { "teacherAuthorityPk",
				"authorizedId", "authorizedName" };
		String responsibleTeachersInfo = JSONTranslation.arrayToJson(
				authorialTeachers, teacherAuthorityExcludes);

		/***************** 获取该教师和授权给该教师的 工号和姓名 end ************************/

		String itemInfo = "{}";
		String participateTeachers = "{}";

		if (itemPK != 0) {

			itemInfo = itemService.findItemByItemPK(itemPK);
			participateTeachers = projectManagerService
					.acquireParticipateTeacherByItemPK(itemPK);
		}

		if (allProjectTypeInfo == null || allProjectTypeInfo.trim().equals("")
				|| allDepartmentInfo == null
				|| allDepartmentInfo.trim().equals("")
				|| responsibleTeachersInfo == null
				|| responsibleTeachersInfo.trim().equals("")) {

			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}

		JSONObject jsonObject = new JSONObject();
		jsonObject.element("allProjectTypeInfo", allProjectTypeInfo);
		jsonObject.element("allDepartmentInfo", allDepartmentInfo);
		jsonObject.element("responsibleTeachersInfo", responsibleTeachersInfo);
		jsonObject.element("itemInfo", itemInfo);
		jsonObject.element("participateTeachers", participateTeachers);

		this.jsonResult = jsonObject.toString();
		if (this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}

		this.actionStatus = true;
		return "success";
	}

	/**
	 * 保存用户填写的项目登记信息
	 * 
	 * @return
	 */
	public String saveProjectRegistrationInfo() {

		if (this.itemPK == null || this.itemName == null
				|| this.itemType == null || this.teacherName == null
				|| this.teacherId == null || this.departmentName == null
				|| this.departmentType == null || this.itemValue == null
				|| this.timeLower == null || this.timeUpper == null
				|| this.applyYear == null || this.contractID == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		Item returnItem = itemService.saveProjectRegistrationInfo(this.itemPK,
				this.itemName, this.itemTypePk, this.itemType, this.contractID,
				this.isCross, this.teacherName, this.teacherId,
				this.departmentPk, this.departmentName, this.departmentType,
				this.itemValue, this.timeLower, this.timeUpper, this.applyYear);

		if (returnItem == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		long returnItemPK = returnItem.getItemPk();

		// 没有传入参与教师信息，则删除所有之前存放的参与教师信息
		if (this.participateTeacherNameArray == null
				&& this.participateTeacherIDArray == null) {
			this.actionStatus = projectManagerService
					.deleteParticipateTeachersByItemPK(itemPK);
		}

		// 传入了参与教师信息，则保存参与教师信息
		if (this.participateTeacherNameArray != null
				&& this.participateTeacherIDArray != null) {
			if (this.participateTeacherNameArray.length > 0
					&& this.participateTeacherIDArray.length > 0
					&& this.participateTeacherIDArray.length == this.participateTeacherNameArray.length) {

				this.actionStatus = projectManagerService
						.storeParticipateTeacher(returnItemPK, teacherId,
								participateTeacherIDArray,
								participateTeacherNameArray);

				if (!this.actionStatus) {
					this.actionStatus = false;
					this.jsonResult = "";
					return "success";
				}

			}
		}

		/* 获取保存的项目信息 */
		String[] excludes = { "teacher", "department", "itemId", "itemName",
				"contractId", "creatId", "creatName", "teacherId",
				"teacherName", "departmentType", "departmentName", "itemValue",
				"remitValue", "timeLower", "timeUpper", "paidFunds",
				"applyDate", "approveDate", "timeFinish", "projectStatus",
				"isCross", "isFinished", "evaluate", "picture", "other",
				"subTypeId", "subTypeName", "pmanage", "ppay", "pconsult",
				"pavailableManageCredit", "pdepartmentPay", "ppay3", "ptax1",
				"ptax2", "ptax3", "isTax" };

		this.jsonResult = JSONTranslation.objectToJson(returnItem, excludes);

		if (this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = true;
		return "success";
	}

	/**
	 * 项目登记时的提交
	 * 
	 * @return
	 */
	public String submitProjectRegistrationInfo() {

		if (this.itemPK == null || this.itemName == null
				|| this.itemType == null || this.teacherName == null 
				|| this.teacherId == null || this.departmentName == null
				|| this.departmentType == null || this.itemValue == null
				|| this.timeLower == null || this.timeUpper == null
				|| this.applyYear == null || this.contractID == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		Item tempItem = itemService.submitProjectRegistrationInfo(this.itemPK,
				this.itemName, this.itemTypePk, this.itemType, this.contractID,
				this.isCross, this.teacherName, this.otherTeacher, this.teacherId,
				this.departmentPk, this.departmentName, this.departmentType,
				this.itemValue, this.timeLower, this.timeUpper, this.applyYear);

		if (tempItem == null) {

			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		/* 获取保存的项目信息 */
		String[] excludes = { "teacher", "department", "projectType",
				"itemName", "contractId", "creatName", "teacherId",
				"teacherName", "departmentType", "departmentName", "itemValue",
				"remitValue", "timeLower", "timeUpper", "paidFunds",
				"applyDate", "approveDate", "timeFinish", "creatId",
				"projectStatus", "typeName", "isFinished", "evaluate",
				"picture", "other" };

		this.jsonResult = JSONTranslation.objectToJson(tempItem, excludes);

		this.actionStatus = true;
		return "success";
	}

	/**
	 * 为主键为itemPK的项目创建经费卡号
	 * 
	 * @return
	 */
	public String createCardIDForCrossItem() {

		String cardID = itemService.createCardIDForCrossItem(this.itemPK);

		if (cardID == null || cardID.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = true;
		this.jsonResult = "{\"cardID\":\"" + cardID + "\"}";
		return "success";
	}

	/**
	 * 判断该项目是否已包含相应的预算信息
	 * 
	 * @return
	 */
	public String judgeWhetherHavedBudgetInfo() {

		JSONObject jsonObject = new JSONObject();

		if (typeId == null) {
			System.out.println("item is null!");
			this.actionStatus = true;
			jsonObject.element("isBudgetExisted", false);
			this.jsonResult = jsonObject.toString();
			return "success";
		}

		boolean status = itemService.judgeWhetherHavedBudgetInfo(this.itemPK,
				this.budgetType);

		this.actionStatus = true;
		jsonObject.element("isBudgetExisted", status);
		this.jsonResult = jsonObject.toString();
		return "success";
	}

	/**
	 * 删除主键为ItemPK的项目的预算信息
	 * 
	 * @return
	 */
	public String deleteRelatedBudgetOfThisItem() {

		if (typeId == null) {
			System.out.println("item is null!");
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = itemService.deleteRelatedBudgetOfThisItem(
				this.itemPK, this.budgetType);
		this.jsonResult = "";
		return "success";
	}

	// setters and getters
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

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public ProjectTypeService getProjectTypeService() {
		return projectTypeService;
	}

	public void setProjectTypeService(ProjectTypeService projectTypeService) {
		this.projectTypeService = projectTypeService;
	}

	public Long getItemPK() {
		return itemPK;
	}

	public void setItemPK(Long itemPK) {
		this.itemPK = itemPK;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemTypePk() {
		return itemTypePk;
	}

	public void setItemTypePk(int itemTypePk) {
		this.itemTypePk = itemTypePk;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public int getIsCross() {
		return isCross;
	}

	public void setIsCross(int isCross) {
		this.isCross = isCross;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getOtherTeacher() {
		return otherTeacher;
	}

	public void setOtherTeacher(String otherTeacher) {
		this.otherTeacher = otherTeacher;
	}

	public int getDepartmentPk() {
		return departmentPk;
	}

	public void setDepartmentPk(int departmentPk) {
		this.departmentPk = departmentPk;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentType() {
		return departmentType;
	}

	public void setDepartmentType(String departmentType) {
		this.departmentType = departmentType;
	}

	public Double getItemValue() {
		return itemValue;
	}

	public void setItemValue(Double itemValue) {
		this.itemValue = itemValue;
	}

	public Double getRemitValue() {
		return remitValue;
	}

	public void setRemitValue(Double remitValue) {
		this.remitValue = remitValue;
	}

	public String getTimeLower() {
		return timeLower;
	}

	public void setTimeLower(String timeLower) {
		this.timeLower = timeLower;
	}

	public String getTimeUpper() {
		return timeUpper;
	}

	public void setTimeUpper(String timeUpper) {
		this.timeUpper = timeUpper;
	}

	public String[] getParticipateTeacherNameArray() {
		return participateTeacherNameArray;
	}

	public void setParticipateTeacherNameArray(
			String[] participateTeacherNameArray) {
		this.participateTeacherNameArray = participateTeacherNameArray;
	}

	public String[] getParticipateTeacherIDArray() {
		return participateTeacherIDArray;
	}

	public void setParticipateTeacherIDArray(String[] participateTeacherIDArray) {
		this.participateTeacherIDArray = participateTeacherIDArray;
	}

	public ProjectManagerService getProjectManagerService() {
		return projectManagerService;
	}

	public void setProjectManagerService(
			ProjectManagerService projectManagerService) {
		this.projectManagerService = projectManagerService;
	}

	public TeacherAuthorityService getTeacherAuthorityService() {
		return teacherAuthorityService;
	}

	public void setTeacherAuthorityService(
			TeacherAuthorityService teacherAuthorityService) {
		this.teacherAuthorityService = teacherAuthorityService;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getContractID() {
		return contractID;
	}

	public void setContractID(String contractID) {
		this.contractID = contractID;
	}

	public String getApplyYear() {
		return applyYear;
	}

	public void setApplyYear(String applyYear) {
		this.applyYear = applyYear;
	}

	public int getBudgetType() {
		return budgetType;
	}

	public void setBudgetType(int budgetType) {
		this.budgetType = budgetType;
	}
}
