package com.stoms.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.dao.TeacherDAO;
import com.stoms.dao.TeacherLoginDAO;
import com.stoms.model.Teacher;
import com.stoms.model.TeacherLogin;

public class TeacherPasswordChangeAction extends ActionSupport {
	private TeacherLoginDAO teacherLoginDAO;
	
	
	private boolean actionStatus;
	private String jsonResult;
	
	private String currentPassord;
	private String newPassord;
	


	public String saveTeacherPassord() {
		// 得到会话的用户ID
		HttpSession session = ServletActionContext.getRequest().getSession();
		String teacherID = (String) session.getAttribute("curr_teacherID");

		if (teacherID == null || teacherID.trim().length() == 0) {

			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}

		List teacherInfo = teacherLoginDAO.findByTeacherId(teacherID);

		if (teacherInfo.size() == 0 || teacherInfo == null) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}

		TeacherLogin teacherLogin = (TeacherLogin) teacherInfo.get(0);
		System.out.println(this.currentPassord);
		System.out.println(this.newPassord);
		if (teacherLogin.getTpassword().equals(this.currentPassord)) {
			teacherLogin.setTpassword(this.newPassord);
			teacherLoginDAO.attachDirty(teacherLogin);
			this.actionStatus = true;

			// 保存新密码
		} else {
			this.actionStatus = false;
		}

		this.jsonResult = "{}";
		return "success";
	}
	

	/**
	 * 保存管理员密码的修改信息
	 * @return
	 */
	public String saveAdminPassord() {
		// 得到会话的用户ID
		HttpSession session = ServletActionContext.getRequest().getSession();
		String teacherID = (String) session.getAttribute("curr_adminID");

		if (teacherID == null || teacherID.trim().length() == 0) {

			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}

		List teacherInfo = teacherLoginDAO.findByTeacherId(teacherID);

		if (teacherInfo.size() == 0 || teacherInfo == null) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}

		TeacherLogin teacherLogin = (TeacherLogin) teacherInfo.get(0);
		System.out.println(this.currentPassord);
		System.out.println(this.newPassord);
		if (teacherLogin.getTpassword().equals(this.currentPassord)) {
			teacherLogin.setTpassword(this.newPassord);
			teacherLoginDAO.attachDirty(teacherLogin);
			this.actionStatus = true;

			// 保存新密码
		} else {
			this.actionStatus = false;
		}

		this.jsonResult = "{}";
		return "success";
	}
//setters and getters
	public TeacherLoginDAO getTeacherLoginDAO() {
		return teacherLoginDAO;
	}
	public void setTeacherLoginDAO(TeacherLoginDAO teacherLoginDAO) {
		this.teacherLoginDAO = teacherLoginDAO;
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
	public String getCurrentPassord() {
		return currentPassord;
	}
	public void setCurrentPassord(String currentPassord) {
		this.currentPassord = currentPassord;
	}
	public String getNewPassord() {
		return newPassord;
	}
	public void setNewPassord(String newPassord) {
		this.newPassord = newPassord;
	}
	
}
