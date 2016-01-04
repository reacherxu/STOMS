package com.stoms.action;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.service.TeacherTitleService;

public class TeacherTitleMaintainceAction extends ActionSupport{
	
	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;
	
	private TeacherTitleService teacherTitleService;
	private String titleName;
	private Integer titlePK;
	/**
	 * 得到所有的教师头衔信息
	 * @return
	 */
	public String acquireAllTeacherTitles() {
		
		this.jsonResult = teacherTitleService.acquireAllTeacherTitles();
		
		if(jsonResult == null || jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}
		
		this.actionStatus = true;
		return "success";
	}
	
	/**
	 * 添加一个新的头衔
	 * @return
	 */
	public String addNewTitle() {
		
		this.jsonResult = teacherTitleService.addNewTitle(titleName);
		
		if(jsonResult == null || jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}
		
		this.actionStatus = true;
		return "success";
	}

	/**
	 * 删除一个教师头衔
	 * @return
	 */
	public String deleteTitle() {
		
		this.actionStatus = teacherTitleService.deleteTitle(this.titlePK);
		this.jsonResult = "{}";
		return "success";
	}
	
	public String updateTitle() {
		
		this.actionStatus = teacherTitleService.updateTitle(this.titlePK, this.titleName);
		this.jsonResult = "{}";
		return "success";
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

	public TeacherTitleService getTeacherTitleService() {
		return teacherTitleService;
	}

	public void setTeacherTitleService(TeacherTitleService teacherTitleService) {
		this.teacherTitleService = teacherTitleService;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public Integer getTitlePK() {
		return titlePK;
	}

	public void setTitlePK(Integer titlePK) {
		this.titlePK = titlePK;
	}
	
}
