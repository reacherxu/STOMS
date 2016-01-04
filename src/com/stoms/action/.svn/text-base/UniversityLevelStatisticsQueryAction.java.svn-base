package com.stoms.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.model.temp.StatisticsCampusOutlay;
import com.stoms.service.ProjectTypeService;
import com.stoms.service.StatisticsCampusOutlayService;
import com.stoms.utils.JSONTranslation;

public class UniversityLevelStatisticsQueryAction extends ActionSupport {

	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;

	private int isCross;
	private String startDate;
	private String endDate;
	private int[] selectedItemTypePKs;

	private ProjectTypeService projectTypeService;
	private StatisticsCampusOutlayService statisticsCampusOutlayService;

	/**
	 * 返回所有项目类型的主键和名称
	 * 
	 */
	public String acquireAllItemTypesPKAndName() {

		// 项目类型的主键和名称信息
		String allProjectTypeInfo = projectTypeService
				.acquireAllProjectTypePKAndName();

		if (allProjectTypeInfo == null || allProjectTypeInfo.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = true;
		this.jsonResult = allProjectTypeInfo;

		return "success";
	}

	/**
	 * 校级统计查询
	 * 
	 * @return
	 */
	public String universityLevelStatisticsQuery() {

		if (startDate == null || endDate == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		List statisticsResultList = statisticsCampusOutlayService
				.StatisticsCampusOutlayStatisticsCampusOutlay(this.isCross,
						this.startDate, this.endDate, this.selectedItemTypePKs);

		String[] excludes = {};
		String statisticsResult = JSONTranslation.arrayToJson(
				statisticsResultList, excludes);

		if (statisticsResult == null || statisticsResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.jsonResult = statisticsResult;
		this.actionStatus = true;
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

	public int getIsCross() {
		return isCross;
	}

	public void setIsCross(int isCross) {
		this.isCross = isCross;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public ProjectTypeService getProjectTypeService() {
		return projectTypeService;
	}

	public void setProjectTypeService(ProjectTypeService projectTypeService) {
		this.projectTypeService = projectTypeService;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public StatisticsCampusOutlayService getStatisticsCampusOutlayService() {
		return statisticsCampusOutlayService;
	}

	public void setStatisticsCampusOutlayService(
			StatisticsCampusOutlayService statisticsCampusOutlayService) {
		this.statisticsCampusOutlayService = statisticsCampusOutlayService;
	}

	public int[] getSelectedItemTypePKs() {
		return selectedItemTypePKs;
	}

	public void setSelectedItemTypePKs(int[] selectedItemTypePKs) {
		this.selectedItemTypePKs = selectedItemTypePKs;
	}

}
