package com.stoms.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.model.Department;
import com.stoms.service.DepartmentService;
import com.stoms.utils.JSONTranslation;

public class DepartmentMaintainceAction extends ActionSupport {
	
	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;
	
	//department properties
	private int departmentPK;
	private int[] departmentPKArray;
	private String departmentId;
	private String departmentName;
	private String departmentType;
	private String assistanceId;
	private String directorId;
	private String assistanceTel;
	private String assistanceMobile;
	private String assistanceEmail;
	
	private DepartmentService departmentService;

	/**
	 * 取得所有院系的信息
	 * @return
	 */
	public String acquireAllDepartmentInfo() {
		
		List allDepartmentInfo = departmentService.acquireAllDepartmentInfo();
		String[] excludes = { "teachers"};
		this.jsonResult = JSONTranslation.arrayToJson(allDepartmentInfo, excludes);
		
		if(this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.jsonResult = "";
			this.actionStatus = false;
			return "success";
		}
		
		this.actionStatus = true;
		return "success";
	}
	//20131008 add by shi
	public String acquireOneDepartmentInfoByID() {
		
		Department onedepartmentInfo = departmentService.acquireOneDepartmentInfoByID(departmentId);
		String[] excludes = {""};
		this.jsonResult = JSONTranslation.objectToJson(onedepartmentInfo, excludes);
		
		if(this.jsonResult == null || this.jsonResult.trim().equals("")
				|| this.jsonResult == "null") {
			this.jsonResult = "";
			this.actionStatus = false;
			return "success";
		}
		
		this.actionStatus = true;
		return "success";
	}
	
	public String acquireOneDepartmentInfoByPK() {
		
		Department onedepartmentInfo = departmentService.acquireOneDepartmentInfoByPK(departmentPK);
		String[] excludes = {""};
		
		this.jsonResult = JSONTranslation.objectToJson(onedepartmentInfo, excludes);
		
		if(this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.jsonResult = "";
			this.actionStatus = false;
			return "success";
		}
		
		this.actionStatus = true;
		return "success";
	}
	
	
	/**
	 * 增加一个新的院系信息
	 * @return
	 */
	public String addNewDepartment() {
		
		if(this.departmentId == null || this.departmentName == null 
			|| this.departmentType == null || this.assistanceId == null
			|| this.assistanceMobile == null || this.assistanceTel == null
			|| this.assistanceEmail == null) {
				this.actionStatus = false;
				this.jsonResult = "";
				return "success";
			}
		
		//院系的科研秘书和主人的ＩＤ要存进去
		Department tempDepartment = departmentService.addNewDepartment(this.departmentId, this.departmentName,
											this.departmentType, this.assistanceId,this.directorId,this.assistanceTel,
											this.assistanceMobile, this.assistanceEmail);
		
		if(tempDepartment == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		String[] excludes = { "teachers"};
		
		this.jsonResult = JSONTranslation.objectToJson(tempDepartment, excludes);
		
		if(this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.jsonResult = "";
			this.actionStatus = false;
			return "success";
		}
		
		this.actionStatus = true;
		return "success";
	}
	
	/**
	 * 删除主键为departmentPK的院系
	 * @return
	 */
	public String deleteSelectedDepartment() {
		
		if(this.departmentPKArray == null || this.departmentPKArray.length == 0) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
			
		}
		
		this.actionStatus = departmentService.deleteSelectedDepartment(this.departmentPKArray);
		this.jsonResult = "";
		return "success";
	}
	
	public String modifyDepartment(){
		if(this.departmentId == null || this.departmentName == null 
				|| this.departmentType == null || this.assistanceId == null
				|| this.assistanceMobile == null || this.assistanceTel == null
				|| this.assistanceEmail == null) {
					this.actionStatus = false;
					this.jsonResult = "";
					return "success";
				}
		
		//院系的科研秘书和主人的ＩＤ要存进去
		this.actionStatus = departmentService.modifyDepartment(this.departmentPK, this.departmentId, this.departmentName,
				                         this.departmentType, this.assistanceId,this.directorId,this.assistanceTel,
				                         this.assistanceMobile, this.assistanceEmail);
		this.jsonResult = "";
		return "success";
	}
	
	
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

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
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
	public String getAssistanceName() {
		return assistanceId;
	}
	public void setAssistanceName(String assistanceId) {
		this.assistanceId = assistanceId;
	}
	public String getAssistanceTel() {
		return assistanceTel;
	}
	public void setAssistanceTel(String assistanceTel) {
		this.assistanceTel = assistanceTel;
	}
	public String getAssistanceMobile() {
		return assistanceMobile;
	}
	public void setAssistanceMobile(String assistanceMobile) {
		this.assistanceMobile = assistanceMobile;
	}
	public String getAssistanceEmail() {
		return assistanceEmail;
	}
	public void setAssistanceEmail(String assistanceEmail) {
		this.assistanceEmail = assistanceEmail;
	}

	public int getDepartmentPK() {
		return departmentPK;
	}

	public void setDepartmentPK(int departmentPK) {
		this.departmentPK = departmentPK;
	}

	public int[] getDepartmentPKArray() {
		return departmentPKArray;
	}

	public void setDepartmentPKArray(int[] departmentPKArray) {
		this.departmentPKArray = departmentPKArray;
	}

	public String getAssistanceId() {
		return assistanceId;
	}

	public void setAssistanceId(String assistanceId) {
		this.assistanceId = assistanceId;
	}

	public String getDirectorId() {
		return directorId;
	}

	public void setDirectorId(String directorId) {
		this.directorId = directorId;
	}
	
}
