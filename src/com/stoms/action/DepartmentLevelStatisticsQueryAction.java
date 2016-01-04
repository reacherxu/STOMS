package com.stoms.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.service.DepartmentService;
import com.stoms.service.StatisticsDepartmentOutlayService;
import com.stoms.utils.JSONTranslation;

public class DepartmentLevelStatisticsQueryAction extends ActionSupport{

	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;
	
	private DepartmentService departmentService;
	
	
	private int isCross;
	private String departmentType;
	private String startDate;
	private String endDate;
	private int[] selectedDepartmentPKs;
	
	private StatisticsDepartmentOutlayService statisticsDepartmentOutlayService;
	
	/**
	 * 返回所有院系的主键和名称
	 * @return
	 */
	public String acquireAllDepartmentPKAndName() {
		
		// 院系的主键和名称信息
		String allDepartmentInfo = departmentService
				.acquireAllDepartmentPKAndName();
		
		if (allDepartmentInfo == null || allDepartmentInfo.trim().equals("")) {

			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}
		
		this.actionStatus = true;
		this.jsonResult = allDepartmentInfo;
		
		return "success";
	}
	
	/**
	 * 院系级统计查询
	 * @return
	 */
	public String departmentLevelStatisticsQuery() {
		/*
		System.out.println(this.isCross);
		System.out.println(this.departmentType);
		System.out.println(this.startDate);
		System.out.println(this.endDate);
		
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
		
		List statisticsResultList = statisticsDepartmentOutlayService.ManageDepartmentOutlay(this.isCross, this.departmentType,this.startDate, this.endDate, this.selectedDepartmentPKs);
		
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

	public StatisticsDepartmentOutlayService getStatisticsDepartmentOutlayService() {
		return statisticsDepartmentOutlayService;
	}

	public void setStatisticsDepartmentOutlayService(
			StatisticsDepartmentOutlayService statisticsDepartmentOutlayService) {
		this.statisticsDepartmentOutlayService = statisticsDepartmentOutlayService;
	}

	
	
	
}
