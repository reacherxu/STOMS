package com.stoms.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.dao.TeacherDAO;
import com.stoms.dao.TeacherLoginDAO;
import com.stoms.model.Teacher;
import com.stoms.model.TeacherLogin;


public class TeacherLoginAction extends ActionSupport{
	
	private TeacherLoginDAO teacherLoginDAO;
	private TeacherDAO teacherDAO;
	private String teacherId;
	private String password;
	private String authorizedCode;
	
	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;

	public String isValidate() {
		
		JSONObject jsonObject = new JSONObject();
		
		//向Session中保存teacherID,teacherName
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String tempAuthorizedCode = (String) session.getAttribute("rand");
		if (tempAuthorizedCode == null || tempAuthorizedCode.trim().equals("")
				|| this.authorizedCode == null
				|| this.authorizedCode.trim().equals("")
				|| !tempAuthorizedCode.equals(authorizedCode)) {
			
			this.actionStatus = true;
			//验证码有误
			jsonObject.element("statusCode", "0");
			jsonObject.element("userType", "teacher");
			this.jsonResult = jsonObject.toString();
			return "success";
			
		}
		
		List teacherLoginList = teacherLoginDAO.findByTeacherId(teacherId);
		if(teacherLoginList == null || teacherLoginList.size() == 0) {
			this.actionStatus = true;
			//用户名不存在
			jsonObject.element("statusCode", "1");
			jsonObject.element("userType", "teacher");
			this.jsonResult = jsonObject.toString();
			return "success";
		}
		
		TeacherLogin teacherLogin = (TeacherLogin)teacherLoginList.get(0);
		
		if(!teacherLogin.getTpassword().equals(this.password) || teacherLogin.getIsActivate() != 1) {
			this.actionStatus = true;
			//密码错误
			jsonObject.element("statusCode", "1");
			jsonObject.element("userType", "teacher");
			this.jsonResult = jsonObject.toString();
			return "success";
		}
		
		String teacherName = "";
		List teacherList = teacherDAO.findByTeacherId(teacherId);
		
		if(teacherList == null || teacherList.size() == 0) {
			this.actionStatus = true;
			//用户名不存在
			jsonObject.element("statusCode", "1");
			jsonObject.element("userType", "teacher");
			this.jsonResult = jsonObject.toString();
			return "success";
		}
		
		Teacher tempTeacher = (Teacher)teacherList.get(0);
		teacherName = tempTeacher.getTeacherName();
		
		String lastLoginIP = teacherLogin.getRecentLoginIp();
		String userType = "teacher";
		String tmp = "";
		if (2 == teacherLogin.getUserType()) {
			
			userType = "superAdmin";
			
			session.setAttribute("curr_superAdminID", teacherId);
			session.setAttribute("superAdminName", teacherName);
			session.setAttribute("lastSuperAdminLoginIP", lastLoginIP);
		}else if (0 == teacherLogin.getUserType()) {
			userType = "admin";
			
			session.setAttribute("curr_adminID", teacherId);
			session.setAttribute("adminName", teacherName);
			session.setAttribute("lastAdminLoginIP", lastLoginIP);
			
		} else {
			session.setAttribute("curr_teacherID", teacherId);
			session.setAttribute("teacherName", teacherName);
			session.setAttribute("lastLoginIP", lastLoginIP);
			
		}
		
		
		//得到当前请求页面的主机的IP地址
		String currentIP = getIpAddr(request);
		//获取当前页面请求主机的时间
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String currentDate = formatter.format(date);
	    //将当前请求页面的IP和时间保存进数据库
		teacherLogin.setRecentLoginIp(currentIP);
		teacherLogin.setRecentLoginTime(currentDate);
		teacherLoginDAO.attachDirty(teacherLogin);
		
		this.actionStatus = true;
		//输入信息合法
		jsonObject.element("statusCode", "2");
		jsonObject.element("userType", userType);
		this.jsonResult = jsonObject.toString();
		return "success";
	}
	
	/**
	 * 管理员端通过输入教师工号打开教师端主页面
	 * @return
	 */
	public String redirectToTeacherMainPage() {
		
		JSONObject jsonObject = new JSONObject();
		
		//向Session中保存teacherID,teacherName
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		List teacherLoginList = teacherLoginDAO.findByTeacherId(teacherId);
		if(teacherLoginList == null || teacherLoginList.size() == 0) {
			this.actionStatus = true;
			//用户名不存在
			jsonObject.element("statusCode", "1");
			jsonObject.element("userType", "teacher");
			this.jsonResult = jsonObject.toString();
			return "success";
		}
		
		TeacherLogin teacherLogin = (TeacherLogin)teacherLoginList.get(0);
		
		if(teacherLogin.getIsActivate() != 1) {
			this.actionStatus = true;
			//密码错误
			jsonObject.element("statusCode", "1");
			jsonObject.element("userType", "teacher");
			this.jsonResult = jsonObject.toString();
			return "success";
		}
		
		String teacherName = "";
		List teacherList = teacherDAO.findByTeacherId(teacherId);
		
		if(teacherList == null || teacherList.size() == 0) {
			this.actionStatus = true;
			//用户名不存在
			jsonObject.element("statusCode", "1");
			jsonObject.element("userType", "teacher");
			this.jsonResult = jsonObject.toString();
			return "success";
		}
		
		Teacher tempTeacher = (Teacher)teacherList.get(0);
		teacherName = tempTeacher.getTeacherName();
		
		String lastLoginIP = teacherLogin.getRecentLoginIp();
		
		String userType = "teacher";
		
		if( 1 == teacherLogin.getUserType()){
			session.setAttribute("curr_teacherID", teacherId);
			session.setAttribute("teacherName", teacherName);
			session.setAttribute("lastLoginIP", lastLoginIP);
		} else {
			this.actionStatus = true;
			//用户名不存在
			jsonObject.element("statusCode", "1");
			jsonObject.element("userType", "teacher");
			this.jsonResult = jsonObject.toString();
			return "success";
		}
		
		this.actionStatus = true;
		//输入信息合法
		jsonObject.element("statusCode", "2");
		jsonObject.element("userType", userType);
		this.jsonResult = jsonObject.toString();
		return "success";
	}

	/**
	 * 得到当前请求页面的主机的IP地址
	 * @param request
	 * @return
	 */
	private String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	/**
	 * 用户退出登录，将Session中的内容清空
	 * @return
	 */
	public String userLogout() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String tmp = (String) session.getAttribute("curr_teacherID");
		
		if(tmp != null) {
			session.removeAttribute("curr_teacherID");
			session.removeAttribute("teacherName");
			session.removeAttribute("lastLoginIP");
			session.removeAttribute("userType");
		}
		
		this.actionStatus = true;
		this.jsonResult = "{}";
		return "success";
	}
	
	/**
	 * 管理员账户退出
	 * @return
	 */
	public String adminLogout() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String tmp = (String) session.getAttribute("curr_adminID");
		
		if(tmp != null) {
			session.removeAttribute("curr_adminID");
			session.removeAttribute("adminName");
			session.removeAttribute("lastAdminLoginIP");
			session.removeAttribute("userType");
		}
		
		this.actionStatus = true;
		this.jsonResult = "{}";
		return "success";
	}
	
	/**
	 * 超级管理员账户退出
	 * @return
	 */
	public String superAdminLogout() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String tmp = (String) session.getAttribute("curr_superAdminID");
		
		if(tmp != null) {
			session.removeAttribute("curr_superAdminID");
			session.removeAttribute("superAdminName");
			session.removeAttribute("lastSuperAdminLoginIP");
			session.removeAttribute("userType");
		}
		
		this.actionStatus = true;
		this.jsonResult = "{}";
		return "success";
	}
  
	public TeacherLoginDAO getTeacherLoginDAO() {
		return teacherLoginDAO;
	}

	public void setTeacherLoginDAO(TeacherLoginDAO teacherLoginDAO) {
		this.teacherLoginDAO = teacherLoginDAO;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}
	
	public String getAuthorizedCode() {
		return authorizedCode;
	}

	public void setAuthorizedCode(String authorizedCode) {
		this.authorizedCode = authorizedCode;
	}
}
