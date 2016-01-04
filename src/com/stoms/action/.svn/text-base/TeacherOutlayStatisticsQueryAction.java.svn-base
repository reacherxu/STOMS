package com.stoms.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.model.temp.TeacherStatisticsByTypePK;
import com.stoms.service.TeacherStatisticsOutlayService;
import com.stoms.utils.JSONTranslation;

public class TeacherOutlayStatisticsQueryAction extends ActionSupport {
	
	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;

	private int isCross;
	private String startDate;
	private String endDate;
	
	private TeacherStatisticsOutlayService teacherStatisticsOutlayService;

	/**
	 * 教师端的经费统计查询
	 * 查询在startDate与endDate时间范围内的项目类型为isCross的入账和支出统计
	 * @return
	 */
	public String teacherOutlayStatisticsQuery() {
		
		// 向Session中保存teacherID,teacherName
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String teacherID = (String) session.getAttribute("curr_teacherID");

		if (teacherID == null || teacherID.trim().equals("")
				|| startDate == null || endDate == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		List<TeacherStatisticsByTypePK> teacherOutlayStatisticsList 
			= teacherStatisticsOutlayService.TeacherStatisticOutlay(isCross, teacherID, startDate, endDate);
		
		String[] teacherOutlayStatisticsListExcludes = {};
		String teacherOutlayStatisticsResult = JSONTranslation.arrayToJson(
				teacherOutlayStatisticsList, teacherOutlayStatisticsListExcludes);

		if (teacherOutlayStatisticsResult == null
				|| teacherOutlayStatisticsResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		this.jsonResult = teacherOutlayStatisticsResult;
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

	public int getIsCross() {
		return isCross;
	}

	public void setIsCross(int isCross) {
		this.isCross = isCross;
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

	public TeacherStatisticsOutlayService getTeacherStatisticsOutlayService() {
		return teacherStatisticsOutlayService;
	}

	public void setTeacherStatisticsOutlayService(
			TeacherStatisticsOutlayService teacherStatisticsOutlayService) {
		this.teacherStatisticsOutlayService = teacherStatisticsOutlayService;
	}
}
