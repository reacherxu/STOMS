package com.stoms.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.service.StatisticsTeacherOutlayService;
import com.stoms.utils.JSONTranslation;

public class projectLeaderLevelStatisticsQueryAction extends ActionSupport{
	
	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;
	
	private int isCross;
	private String departmentType;
	private String startDate;
	private String endDate;
	private int[] selectedDepartmentPKs;
	private String teacherName;
	
	private StatisticsTeacherOutlayService statisticsTeacherOutlayService;
	
	
	/**
	 * 项目负责人级查询
	 * @return
	 */
	public String projectLeaderLevelStatisticsQuery() {
		/*
		System.out.println(this.isCross);
		System.out.println(this.departmentType);
		System.out.println(this.startDate);
		System.out.println(this.endDate);
		System.out.println(this.teacherName);
		
		if(this.selectedDepartmentPKs != null && this.selectedDepartmentPKs.length > 0) {
			for(int i = 0; i < this.selectedDepartmentPKs.length; i++) {
				System.out.println(this.selectedDepartmentPKs[i]);
			}
		}
		*/
		

		if(startDate == null || endDate == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		List statisticsResultList = statisticsTeacherOutlayService.ManageTeacherOutlay(this.isCross, this.departmentType,this.startDate, this.endDate, this.selectedDepartmentPKs,this.teacherName);
		
		String[] excludes = {};
		String statisticsResult = JSONTranslation.arrayToJson(statisticsResultList, excludes);
		
		if(statisticsResult == null || statisticsResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		
		this.jsonResult = statisticsResult;
		this.actionStatus = true;
		return "success";
	}

	
	//setters&getters
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

	public int getIsCross() {
		return isCross;
	}

	public void setIsCross(int isCross) {
		this.isCross = isCross;
	}

	public String getDepartmentType() {
		return departmentType;
	}

	public void setDepartmentType(String departmentType) {
		this.departmentType = departmentType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int[] getSelectedDepartmentPKs() {
		return selectedDepartmentPKs;
	}

	public void setSelectedDepartmentPKs(int[] selectedDepartmentPKs) {
		this.selectedDepartmentPKs = selectedDepartmentPKs;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	public StatisticsTeacherOutlayService getStatisticsTeacherOutlayService() {
		return statisticsTeacherOutlayService;
	}

	public void setStatisticsTeacherOutlayService(
			StatisticsTeacherOutlayService statisticsTeacherOutlayService) {
		this.statisticsTeacherOutlayService = statisticsTeacherOutlayService;
	}
			
}
