package com.stoms.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.service.ProjectInfoAuditService;

public class ProjectInfoAuditAction extends ActionSupport {

	// two results for all the action
	private boolean actionStatus;
	private String jsonResult;
	
	private Long itemPK;

	private ProjectInfoAuditService projectInfoAuditService;

	
	/**
	 * 管理员项目信息审核 返回所有状态为11（教师提交确认）的项目
	 * @return
	 */
	public String acquireProjectInfoAuditList() {
		
		//如果该项目信息的登记工作由管理员操作，返回由该管理员和教师端登记的项目信息列表
		HttpSession session = ServletActionContext.getRequest().getSession();
		String tmpOperatorID = (String) session
				.getAttribute("curr_adminID");
		
		this.jsonResult = projectInfoAuditService.acquireProjectInfoAuditList(tmpOperatorID);
		if(this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}
				
		this.actionStatus = true;
		return "success";
	}
	
	/**
	 * 项目信息审核通过
	 * @param itemPK
	 * @return
	 */
	public String projectInfoAuditApprove( ) {
		
		this.actionStatus = projectInfoAuditService.projectInfoAuditApprove(this.itemPK);
		this.jsonResult = "";
		
		return "success";
	}
	
	/**
	 * 项目信息审核不通过
	 * @param itemPK
	 * @return
	 */
	public String projectInfoAuditReject( ) {

		this.actionStatus = projectInfoAuditService.projectInfoAuditReject(this.itemPK);
		this.jsonResult = "";
		
		return "success";
	}

	public Long getItemPK() {
		return itemPK;
	}

	public void setItemPK(Long itemPK) {
		this.itemPK = itemPK;
	}

	public boolean isActionStatus() {
		return actionStatus;
	}


	public void setActionStatus(boolean actionStatus) {
		this.actionStatus = actionStatus;
	}


	public String getJsonResult() {
		return jsonResult;
	}


	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}


	public ProjectInfoAuditService getProjectInfoAuditService() {
		return projectInfoAuditService;
	}


	public void setProjectInfoAuditService(
			ProjectInfoAuditService projectInfoAuditService) {
		this.projectInfoAuditService = projectInfoAuditService;
	}

}
