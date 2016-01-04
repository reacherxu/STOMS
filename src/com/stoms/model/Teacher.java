package com.stoms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private Long teacherPk;
	private TeacherTitle teacherTitle;
	private Department department;
	private String teacherId;
	private String teacherName;
	private String titleName;
	private String departmentId;
	private String departmentName;
	private String tel;
	private String mobile;
	private String email;
	private String indirectId;

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(Long teacherPk, String teacherId, String teacherName) {
		this.teacherPk = teacherPk;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
	}

	/** full constructor */
	public Teacher(Long teacherPk, TeacherTitle teacherTitle,
			Department department, String teacherId, String teacherName,
			String titleName, String departmentId, String departmentName,
			String tel, String mobile, String email, String indirectId) {
		this.teacherPk = teacherPk;
		this.teacherTitle = teacherTitle;
		this.department = department;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.titleName = titleName;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.tel = tel;
		this.mobile = mobile;
		this.email = email;
		this.indirectId = indirectId;
	}

	// Property accessors

	public Long getTeacherPk() {
		return this.teacherPk;
	}

	public void setTeacherPk(Long teacherPk) {
		this.teacherPk = teacherPk;
	}

	public TeacherTitle getTeacherTitle() {
		return this.teacherTitle;
	}

	public void setTeacherTitle(TeacherTitle teacherTitle) {
		this.teacherTitle = teacherTitle;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTitleName() {
		return this.titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndirectId() {
		return this.indirectId;
	}

	public void setIndirectId(String indirectId) {
		this.indirectId = indirectId;
	}

}