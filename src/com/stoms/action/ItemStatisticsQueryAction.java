package com.stoms.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.model.temp.TeacherStatisticsByTypePK;
import com.stoms.service.TeacherStatisticsService;
import com.stoms.utils.JSONTranslation;

public class ItemStatisticsQueryAction extends ActionSupport {

	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;

	private int isCross;
	private String startYear;
	private String endYear;

	private TeacherStatisticsService teacherStatisticsService;

	/**
	 * 教师统计查询
	 * 
	 * @return
	 */
	public String itemStatisticsQuery() {

		// 向Session中保存teacherID,teacherName
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String teacherID = (String) session.getAttribute("curr_teacherID");

		if (teacherID == null || teacherID.trim().equals("")
				|| startYear == null || endYear == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		List<TeacherStatisticsByTypePK> teacherStatisticsByTypePKs = teacherStatisticsService
				.acquireTeacherStatisticByIsCross(isCross, teacherID,
						startYear, endYear);

		String[] TeacherStatisticsByTypePKExcludes = {};
		String itemStatisticsResult = JSONTranslation.arrayToJson(
				teacherStatisticsByTypePKs, TeacherStatisticsByTypePKExcludes);

		if (itemStatisticsResult == null
				|| itemStatisticsResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = true;
		this.jsonResult = itemStatisticsResult;
		
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

	public TeacherStatisticsService getTeacherStatisticsService() {
		return teacherStatisticsService;
	}

	public void setTeacherStatisticsService(
			TeacherStatisticsService teacherStatisticsService) {
		this.teacherStatisticsService = teacherStatisticsService;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

}
