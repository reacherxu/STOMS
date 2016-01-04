package com.stoms.action;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.model.Item;
import com.stoms.service.DepartmentService;
import com.stoms.service.ItemService;
import com.stoms.service.ProjectTypeService;

public class ProjectVerificationAction extends ActionSupport{
	
	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;
	
	private Long itemPK;
	
	private String itemID;
	
	private String itemName;
	
	private int itemTypePk;
	
	private String itemType;
	
	private int isCross;
	
	private String teacherName;
	
	private String teacherId;
	
	private int departmentPk;
	
	private String departmentName;
	
	private String departmentType;
	
	private Double itemValue;
	
	private Double remitValue;
	
	private String timeLower;
	
	private String timeUpper;
	
	private String[] participateTeacherNameArray;
	private String[] participateTeacherIDArray;
	
	
	private ItemService itemService;
	private DepartmentService departmentService;
	private ProjectTypeService projectTypeService;
	
	/**
	 * 返回所有工号为teacherId的已经提交可还没通过科技处审批的项目
	 * @return
	 */
	public String findAllUnapprovedItems() {
		
		//得到会话的用户ID
		HttpSession session = ServletActionContext.getRequest().getSession();
		String teacherID = (String)session.getAttribute("curr_teacherID");
		
		this.jsonResult = itemService.findAllUnapprovedItems(teacherID);
		if(this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}
		
		this.actionStatus = true;
		return "success";
	}
	
	/**
	 * 取得所有项目类型的主键和名称，以及院系的主键和名称， 来初始化页面中院系和项目类型的下拉列表
	 * @return
	 */
	public String acquireInfoToInitializePage() {
		
		String allProjectTypeInfo = projectTypeService.acquireAllProjectTypePKAndName();
		String allDepartmentInfo = departmentService.acquireAllDepartmentPKAndName();
		String itemInfo = "{}";
		
		if(itemPK != 0 ) {
			
			itemInfo = itemService.findItemByItemPK(itemPK);
		}
		
		if(allProjectTypeInfo == null || allProjectTypeInfo.trim().equals("")
				|| allDepartmentInfo == null || allDepartmentInfo.trim().equals("")) {
			
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.element("allProjectTypeInfo", allProjectTypeInfo);
		jsonObject.element("allDepartmentInfo", allDepartmentInfo);
		jsonObject.element("itemInfo", itemInfo);
		
		this.jsonResult = jsonObject.toString();
		if(this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}
		
		this.actionStatus = true;
		return "success";
	}
	
	/*
	
	 // 保存用户填写的项目登记信息
	 
	public String saveProjectRegistrationInfo() {
		
		if(this.itemPK == null ||this.itemName == null
				|| this.itemType == null || this.teacherName == null || this.teacherId == null
				|| this.departmentName == null || this.departmentType == null
				|| this.itemValue == null || this.timeLower == null
				|| this.timeUpper == null || this.participateTeacherNameArray == null
				|| this.participateTeacherIDArray == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		
		Item returnItem = itemService.saveProjectRegistrationInfo(this.itemPK, this.itemName, this.itemTypePk,
					this.itemType, this.isCross, this.teacherName, this.teacherId, this.departmentPk, this.departmentName,
					this.departmentType, this.itemValue, this.timeLower, this.timeUpper);
		
		if(returnItem != null) {
			this.actionStatus = true;
		} else {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		this.jsonResult = "";
		return "success";
	}
	
	public String submitProjectRegistrationInfo() {
		
		if(this.itemPK == null || this.itemName == null
				|| this.itemType == null || this.teacherName == null || this.teacherId == null
				|| this.departmentName == null || this.departmentType == null
				|| this.itemValue == null || this.timeLower == null
				|| this.timeUpper == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		this.actionStatus = itemService.submitProjectRegistrationInfo(this.itemPK, this.itemName, this.itemTypePk,
					this.itemType, this.isCross, this.teacherName, this.teacherId, this.departmentPk, this.departmentName,
					this.departmentType, this.itemValue, this.timeLower, this.timeUpper);
		
		this.jsonResult = "";
		return "success";
	}
	
	*/
	//setters and getters
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

	public void setParticipateTeacherNameArray(String[] participateTeacherNameArray) {
		this.participateTeacherNameArray = participateTeacherNameArray;
	}

	public String[] getParticipateTeacherIDArray() {
		return participateTeacherIDArray;
	}

	public void setParticipateTeacherIDArray(String[] participateTeacherIDArray) {
		this.participateTeacherIDArray = participateTeacherIDArray;
	}
	
}
