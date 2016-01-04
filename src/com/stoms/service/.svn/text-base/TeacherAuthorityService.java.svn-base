package com.stoms.service;

import java.util.List;

import com.stoms.dao.TeacherAuthorityDAO;
import com.stoms.model.TeacherAuthority;
import com.stoms.utils.JSONTranslation;

public class TeacherAuthorityService {

	private TeacherAuthorityDAO teacherAuthorityDAO;
	
	//返回所有授权给当前教师ID的信息
	public List acquireTeacherAuthorityList(String authorizedId) {
			
		List<TeacherAuthority> teacherAuthorList = teacherAuthorityDAO.findByAuthorizedId(authorizedId);
		//System.out.println(teacherAuthorList.size());
		return teacherAuthorList;
	}

	//setters&getters
	public TeacherAuthorityDAO getTeacherAuthorityDAO() {
		return teacherAuthorityDAO;
	}

	public void setTeacherAuthorityDAO(TeacherAuthorityDAO teacherAuthorityDAO) {
		this.teacherAuthorityDAO = teacherAuthorityDAO;
	}	
}

