package com.stoms.action;

import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.dao.TeacherDAO;
import com.stoms.dao.TeacherLoginDAO;
import com.stoms.model.Teacher;
import com.stoms.model.TeacherLogin;
import com.stoms.utils.JSONTranslation;

public class AdminInfoMaintainceAction extends ActionSupport {

	private TeacherLoginDAO teacherLoginDAO;
	private TeacherDAO teacherDAO;
	private String tel;
	private String email;
	private boolean actionStatus;
	private String jsonResult;

	public String acquireAdminInfo() {

		List adminList = teacherLoginDAO.findByTeacherId("db");

		if (null == adminList || 0 == adminList.size()) {

			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}

		TeacherLogin currentAdmin = (TeacherLogin) adminList.get(0);
		
		String[] excludes = { "teacherTitle", "department", "teacherLogins" };
		this.jsonResult = JSONTranslation.objectToJson(currentAdmin, excludes);

		if (null == this.jsonResult || this.jsonResult.isEmpty()) {

			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}

		this.actionStatus = true;
		return "success";
	}

	public String saveAdminInfo() {

		System.out.println(this.tel);
		System.out.println(this.email);
		
		if(null == this.tel) {
			this.tel = "";
		}
		
		if(null == this.email) {
			this.email = "";
		}
		
		List teacherList = teacherDAO.findByTeacherId("db");
		
		if(teacherList == null || teacherList.size() == 0) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}

		
		Teacher currentTeacher = (Teacher)teacherList.get(0);
		
		currentTeacher.setEmail(this.email);
		currentTeacher.setTel(this.tel);

		teacherDAO.attachDirty(currentTeacher);
		
		this.jsonResult = "{}";
		this.actionStatus = true;
		return "success";
	}

	// setters and getters
	public TeacherLoginDAO getTeacherLoginDAO() {
		return teacherLoginDAO;
	}

	public void setTeacherLoginDAO(TeacherLoginDAO teacherLoginDAO) {
		this.teacherLoginDAO = teacherLoginDAO;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

}
