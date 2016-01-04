package com.stoms.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.PropertyFilter;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.dao.TeacherAuthorityDAO;
import com.stoms.dao.TeacherDAO;
import com.stoms.dao.TeacherLoginDAO;
import com.stoms.dao.TeacherTitleDAO;
import com.stoms.model.Teacher;
import com.stoms.model.TeacherLogin;
import com.stoms.model.TeacherAuthority;
import com.stoms.utils.JSONTranslation;

public class TeacherInfoMaintanceAction extends ActionSupport{
	
	private TeacherLoginDAO teacherLoginDAO;
	private TeacherDAO teacherDAO;
	private TeacherAuthorityDAO teacherAuthorityDAO;

	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;
	
	private String mobile;
	private String tel;
	private String email;
	
	private String authorizedId;
	private String authorizedName;
	
	public String acquireTeacherInfo() {
		
		//得到会话的用户ID
		HttpSession session = ServletActionContext.getRequest().getSession();
		String teacherID = (String)session.getAttribute("curr_teacherID");
		
		if(teacherID == null || teacherID.trim().length() == 0) {
			
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		//根据teacherID在teacherLogin表中查找相应的对象
		List teacherLoginList = teacherLoginDAO.findByTeacherId(teacherID);
		
		if(teacherLoginList == null || teacherLoginList.size() == 0) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		TeacherLogin teacherLogin = (TeacherLogin)teacherLoginList.get(0);
		
        String[] excludes = {"teacherLoginPk", "teacherId", "tpassword", "userType", "isActivate"};
        String teacherLoginInfo = JSONTranslation.objectToJson(teacherLogin, excludes);
        
        
        //根据teacherID在teacher表中查找相应的对象
        List teacherList = teacherDAO.findByTeacherId(teacherID);
        if(teacherList == null || teacherList.size() == 0) {
        	this.actionStatus = false;
			this.jsonResult = "";
			return "success";
        }
        Teacher tempTeacher = (Teacher)teacherList.get(0);
        String[] teacherExcludes = {"teacherLoginPk", "teacherTitle", "department", "departmentId"};
        String teacherInfo = JSONTranslation.objectToJson(tempTeacher, teacherExcludes);
        

		//根据teacherID在TeacherAuthority表中查找相应的对象
		List teacherAuthorityList = teacherAuthorityDAO.findByTeacherId(teacherID);
		
		TeacherAuthority teacherAuthority = new TeacherAuthority();
		
		if(teacherAuthorityList != null && teacherAuthorityList.size() > 0) {
			teacherAuthority = (TeacherAuthority)teacherAuthorityList.get(0);
		}
		
        String[] Authorityexcludes = {};
        String teacherAuthorityInfo = JSONTranslation.objectToJson(teacherAuthority, Authorityexcludes);
        
        JSONObject jsonObject = new JSONObject();
		jsonObject.element("teacherLoginInfo", teacherLoginInfo);
		jsonObject.element("teacherInfo", teacherInfo);
		jsonObject.element("teacherAuthorityInfo", teacherAuthorityInfo);
        this.jsonResult = jsonObject.toString();
		
		if(jsonResult == null || jsonResult.trim().equals("")) {
			
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}
		
		this.actionStatus = true;
		return "success";
	}
	
	/**
	 * 获得管理员账户信息
	 * @return
	 */
	public String acquireAdminInfo() {
		
		//得到会话的用户ID
		HttpSession session = ServletActionContext.getRequest().getSession();
		String adminID = (String)session.getAttribute("curr_adminID");
		
		if(adminID == null || adminID.trim().length() == 0) {
			
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		//根据teacherID在teacherLogin表中查找相应的对象
		List teacherLoginList = teacherLoginDAO.findByTeacherId(adminID);
		
		if(teacherLoginList == null || teacherLoginList.size() == 0) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		TeacherLogin teacherLogin = (TeacherLogin)teacherLoginList.get(0);
		
        String[] excludes = {"teacherLoginPk", "teacherId", "tpassword", "userType", "isActivate"};
        String teacherLoginInfo = JSONTranslation.objectToJson(teacherLogin, excludes);
        
        
        //根据teacherID在teacher表中查找相应的对象
        List teacherList = teacherDAO.findByTeacherId(adminID);
        if(teacherList == null || teacherList.size() == 0) {
        	this.actionStatus = false;
			this.jsonResult = "";
			return "success";
        }
        Teacher tempTeacher = (Teacher)teacherList.get(0);
        String[] teacherExcludes = {"teacherLoginPk", "teacherTitle", "department", "departmentId"};
        String teacherInfo = JSONTranslation.objectToJson(tempTeacher, teacherExcludes);
        

		//根据teacherID在TeacherAuthority表中查找相应的对象
		List teacherAuthorityList = teacherAuthorityDAO.findByTeacherId(adminID);
		
		TeacherAuthority teacherAuthority = new TeacherAuthority();
		
		if(teacherAuthorityList != null && teacherAuthorityList.size() > 0) {
			teacherAuthority = (TeacherAuthority)teacherAuthorityList.get(0);
		}
		
        String[] Authorityexcludes = {};
        String teacherAuthorityInfo = JSONTranslation.objectToJson(teacherAuthority, Authorityexcludes);
        
        JSONObject jsonObject = new JSONObject();
		jsonObject.element("teacherLoginInfo", teacherLoginInfo);
		jsonObject.element("teacherInfo", teacherInfo);
		jsonObject.element("teacherAuthorityInfo", teacherAuthorityInfo);
        this.jsonResult = jsonObject.toString();
		
		if(jsonResult == null || jsonResult.trim().equals("")) {
			
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}
		
		this.actionStatus = true;
		return "success";
	}
	
	/**
	 * 获取当前用户的授权信息
	 * @return
	 */
	public String acquireUserAuthorizationInfo() {
		
		//得到会话的用户ID
		HttpSession session = ServletActionContext.getRequest().getSession();
		String teacherID = (String)session.getAttribute("curr_teacherID");
		
		if(teacherID == null || teacherID.trim().length() == 0) {
			
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		
		//根据teacherID在TeacherAuthority表中查找相应的对象
		List teacherAuthorityList = teacherAuthorityDAO.findByTeacherId(teacherID);
		
		TeacherAuthority teacherAuthority = new TeacherAuthority();
		
		if(teacherAuthorityList != null && teacherAuthorityList.size() > 0) {
			teacherAuthority = (TeacherAuthority)teacherAuthorityList.get(0);
		}
		
        String[] Authorityexcludes = {};
        String teacherAuthorityInfo = JSONTranslation.objectToJson(teacherAuthority, Authorityexcludes);
        
        if(teacherAuthorityInfo == null || teacherAuthorityInfo.trim().length() == 0) {
			
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
        
        this.jsonResult = teacherAuthorityInfo;
        this.actionStatus = true;
		return "success";
	}
	
	public String saveTeacherInfo() {
		//得到会话的用户ID
		HttpSession session = ServletActionContext.getRequest().getSession();
		String teacherID = (String)session.getAttribute("curr_teacherID");
		
		if(teacherID == null || teacherID.trim().length() == 0) {
			
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}
		
		List teacherList = teacherDAO.findByTeacherId(teacherID);
		
		if(teacherList == null || teacherList.size() == 0) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}

		
		Teacher teacher = (Teacher)teacherList.get(0);
		teacher.setEmail(this.email);
		teacher.setMobile(this.mobile);
		teacher.setTel(this.tel);
		teacherDAO.attachDirty(teacher);
		//teacherDAO.save(teacher);
		
		this.actionStatus = true;
		this.jsonResult = "{}";
		return "success";
	}
	
	/**
	 * 保存管理员账户的信息
	 * @return
	 */
	public String saveAdminInfo() {
		//得到会话的用户ID
		HttpSession session = ServletActionContext.getRequest().getSession();
		String adminID = (String)session.getAttribute("curr_adminID");
		
		if(adminID == null || adminID.trim().length() == 0) {
			
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}
		
		List teacherList = teacherDAO.findByTeacherId(adminID);
		
		if(teacherList == null || teacherList.size() == 0) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}

		
		Teacher teacher = (Teacher)teacherList.get(0);
		teacher.setEmail(this.email);
		teacher.setMobile(this.mobile);
		teacher.setTel(this.tel);
		teacherDAO.attachDirty(teacher);
		//teacherDAO.save(teacher);
		
		this.actionStatus = true;
		this.jsonResult = "{}";
		return "success";
	}
	
	public String authorizationManage() {
		
		//得到会话的用户ID
		HttpSession session = ServletActionContext.getRequest().getSession();
		String teacherID = (String)session.getAttribute("curr_teacherID");
		
		if(teacherID == null || teacherID.trim().length() == 0) {
			
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}
		
		List teacherAuthorityList = teacherAuthorityDAO.findByTeacherId(teacherID);
		
		TeacherAuthority teacherAuthority = new TeacherAuthority();
		
		if(teacherAuthorityList != null && teacherAuthorityList.size() > 0) {
			teacherAuthority = (TeacherAuthority)teacherAuthorityList.get(0);
		}
		teacherAuthority.setTeacherId(teacherID);
		teacherAuthority.setAuthorizedId(authorizedId);
		teacherAuthority.setAuthorizedName(authorizedName);
		teacherAuthorityDAO.attachDirty(teacherAuthority);
		
		this.actionStatus = true;
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
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public TeacherAuthorityDAO getTeacherAuthorityDAO() {
		return teacherAuthorityDAO;
	}

	public void setTeacherAuthorityDAO(TeacherAuthorityDAO teacherAuthorityDAO) {
		this.teacherAuthorityDAO = teacherAuthorityDAO;
	}

	public String getAuthorizedId() {
		return authorizedId;
	}

	public void setAuthorizedId(String authorizedId) {
		this.authorizedId = authorizedId;
	}

	public String getAuthorizedName() {
		return authorizedName;
	}

	public void setAuthorizedName(String authorizedName) {
		this.authorizedName = authorizedName;
	}
	
}
