package com.stoms.action;

import java.util.List;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.model.Department;
import com.stoms.model.Teacher;
import com.stoms.model.TeacherTitle;
import com.stoms.service.DepartmentService;
import com.stoms.service.TeacherLoginService;
import com.stoms.service.TeacherService;
import com.stoms.service.TeacherTitleService;
import com.stoms.utils.JSONTranslation;

public class TeacherMaintainceAction extends ActionSupport {

	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;

	// teacher properties
	private long teacherPK;
	private int titlePK;
	private String[] PKArray;

	private String teacherId;
	private String teacherName;
	private String titleName;
	private String departmentId;
	private String departmentName;
	private String tel;
	private String mobile;
	private String email;

	private TeacherService teacherService;
	private DepartmentService departmentService;
	private TeacherTitleService teacherTitleService;
	private TeacherLoginService teacherLoginService;

	private int departmentPk;
	/**
	 * 删除教师类型信息
	 * 
	 * @return
	 */
	public String deleteSelectedTeacher() {

		if (this.PKArray == null || this.PKArray.length == 0) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";

		}

		this.actionStatus = teacherService.deleteSelectedTeacher(this.PKArray);
		
		if(!this.actionStatus) {
			this.jsonResult = "";
			return "success";
		}
		
		this.actionStatus = teacherLoginService.deleteSelectedTeacher(this.PKArray);
		this.jsonResult = "";
		return "success";
	}

	/**
	 * 增加一个新的教师
	 * 
	 * @return
	 */
	public String addNewTeacher() {

		if (teacherId == null || teacherName == null || titleName == null
				|| departmentId == null || departmentName == null
				|| tel == null || mobile == null || email == null) {

			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = teacherService.addNewTeacher(titlePK, teacherId,
				teacherName, titleName, departmentId, departmentName, tel,
				mobile, email);

		if(!this.actionStatus) {
			this.jsonResult = "";
			return "success";
		}
		
		this.actionStatus = teacherLoginService.createNewTeacher(teacherId, 1);
		this.jsonResult = "";
		return "success";
	}
	
	/**
	 * 增加一个新的管理员
	 * 
	 * @return
	 */
	public String addNewAdmin() {

		if (teacherId == null || teacherName == null || titleName == null
				|| departmentId == null || departmentName == null
				|| tel == null || mobile == null || email == null) {

			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = teacherService.addNewTeacher(titlePK, teacherId,
				teacherName, titleName, departmentId, departmentName, tel,
				mobile, email);

		if(!this.actionStatus) {
			this.jsonResult = "";
			return "success";
		}
		
		this.actionStatus = teacherLoginService.createNewTeacher(teacherId, 0);
		this.jsonResult = "";
		return "success";
	}

	/**
	 * 增加一个新的教师
	 * 
	 * @return
	 */
	public String modifyTeacher() {

		if (teacherId == null || teacherName == null || titleName == null
				|| departmentId == null || departmentName == null
				|| tel == null || mobile == null || email == null) {

			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = teacherService.modifyTeacher(teacherPK, titlePK,
				teacherId, teacherName, titleName, departmentId,
				departmentName, tel, mobile, email);

		this.jsonResult = "";
		return "success";
	}
	
	/**
	 * 获取一个教师的信息
	 * 通过教师姓名和院系PK
	 * @return
	 * 20131008 add by shi
	 */
	public String acquireOneTeacherInfoByTeacherNameAndDepartmentPK() {

		List teachers = teacherService.acquireTeacherInfo(teacherName,departmentPk);
		if(teachers.size()==1){
			String[] excludes = { "" };
			this.jsonResult = JSONTranslation.objectToJson(teachers.get(0), excludes);
			this.actionStatus = true;
			
		}else if (teachers.size() > 1) {
			this.jsonResult = "{\"error\":\"2\"}";//返回error:2,代表符合条件的teacher不只一个
			this.actionStatus = false;
		}else if(teachers.size() == 0){
			this.jsonResult = "{\"error\":\"0\"}";//返回error:0,代表 没有符合条件的teacher
			this.actionStatus = false;
		}
		return "success";
		
	}
	
	/**
	 * 获取一个教师的信息
	 * 
	 * @return
	 */
	public String acquireOneTeacherInfo() {

		Teacher teacherItem = teacherService.acquireOneTeacherInfo(teacherPK);

		String[] excludes = { "" };
		this.jsonResult = JSONTranslation.objectToJson(teacherItem, excludes);

		if (this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.jsonResult = "";
			this.actionStatus = false;
			return "success";
		}

		this.actionStatus = true;
		return "success";
	}

	/**
	 * 获取院系和教师信息用于初始化编辑页面
	 * 
	 * @return
	 */
	public String acquireTeacherInfoToInitializePage() {

		// 院系的主键，名称，院系ID
		String allDepartmentInfo = departmentService
				.acquireAllDepartmentPKAndName();

		// 教师职称
		String allTitleInfo = teacherTitleService.acquireAllTeacherTitles();

		if (allDepartmentInfo == null || allDepartmentInfo.trim().equals("")
				|| allTitleInfo == null || allTitleInfo.trim().equals("")) {

			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}

		JSONObject jsonObject = new JSONObject();
		jsonObject.element("allDepartmentInfo", allDepartmentInfo);
		jsonObject.element("allTitleInfo", allTitleInfo);

		this.jsonResult = jsonObject.toString();
		if (this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "{}";
			return "success";
		}

		this.actionStatus = true;
		return "success";
	}

	/**
	 * 获得所有教师信息
	 * 
	 * @return
	 */
	public String acquireAllTeacherInfo() {

		List allTeacherInfo = teacherService.acquireAllTeacherInfo();
		String[] excludes = { "teacherTitle", "department" };
		this.jsonResult = JSONTranslation.arrayToJson(allTeacherInfo, excludes);

		if (this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.jsonResult = "";
			this.actionStatus = false;
			return "success";
		}

		this.actionStatus = true;
		return "success";
	}

	public String acquireAllAdminInfo() {

		List allTeacherInfo = teacherService.acquireAllAdminInfo();
		String[] excludes = { "teacherTitle", "department" };
		this.jsonResult = JSONTranslation.arrayToJson(allTeacherInfo, excludes);

		if (this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.jsonResult = "";
			this.actionStatus = false;
			return "success";
		}

		this.actionStatus = true;
		return "success";
	}
	
	/**
	 * 初始化所有教师密码为其工号
	 * @return
	 */
	public String intializeAllTeacherPassword() {
		
		this.actionStatus = teacherLoginService.intializeAllPassword();
		//this.actionStatus = true;
		this.jsonResult = "";
		return "success";
	}

	// setters&getters
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

	public void setTeacherPK(int teacherPK) {
		this.teacherPK = teacherPK;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public TeacherTitleService getTeacherTitleService() {
		return teacherTitleService;
	}

	public void setTeacherTitleService(TeacherTitleService teacherTitleService) {
		this.teacherTitleService = teacherTitleService;
	}

	public void setTeacherPK(long teacherPK) {
		this.teacherPK = teacherPK;
	}

	public long getTeacherPK() {
		return teacherPK;
	}

	public int getTitlePK() {
		return titlePK;
	}

	public void setTitlePK(int titlePK) {
		this.titlePK = titlePK;
	}

	public String[] getPKArray() {
		return PKArray;
	}

	public void setPKArray(String[] pKArray) {
		PKArray = pKArray;
	}

	public int getDepartmentPk() {
		return departmentPk;
	}

	public void setDepartmentPk(int departmentPk) {
		this.departmentPk = departmentPk;
	}

	public TeacherLoginService getTeacherLoginService() {
		return teacherLoginService;
	}

	public void setTeacherLoginService(TeacherLoginService teacherLoginService) {
		this.teacherLoginService = teacherLoginService;
	}

}
