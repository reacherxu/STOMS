package com.stoms.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.dao.TeacherDAO;
import com.stoms.dao.TeacherLoginDAO;
import com.stoms.model.Teacher;
import com.stoms.model.TeacherLogin;
import com.stoms.utils.JSONTranslation;

public class AdminPasswordChangeAction extends ActionSupport {

	private TeacherLoginDAO teacherLoginDAO;
	private String oldPassword;
	private String newPassword1;
	private String newPassword2;
	private boolean actionStatus;
	private String jsonResult;

	public String saveAdminPassword() {

		
		HttpSession session = ServletActionContext.getRequest().getSession();
		String teacherID = (String)session.getAttribute("curr_teacherID");
		
		List adminList = teacherLoginDAO.findByTeacherId(teacherID);

		if (null == adminList || 0 == adminList.size()) {

			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}

		TeacherLogin currentAdmin = (TeacherLogin) adminList.get(0);

		if (currentAdmin.getTpassword().equals(oldPassword)) {
			if (newPassword1.equals(newPassword2)) {
				currentAdmin.setTpassword(newPassword1);
				teacherLoginDAO.attachDirty(currentAdmin);
			}
			else return "newpassword1 not equals with newpassword2!";
		}
		else return "oldpassword error!";
		
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
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword1() {
		return newPassword1;
	}
	public void setNewPassword1(String newPassword1) {
		this.newPassword1 = newPassword1;
	}
	public String getNewPassword2() {
		return newPassword2;
	}
	public void setNewPassword2(String newPassword2) {
		this.newPassword2 = newPassword2;
	}
	
	

}
