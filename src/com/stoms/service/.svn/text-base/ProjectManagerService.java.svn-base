package com.stoms.service;

import java.util.List;

import com.stoms.dao.ProjectManagerDAO;
import com.stoms.model.ProjectManager;
import com.stoms.utils.JSONTranslation;

public class ProjectManagerService {

	private ProjectManagerDAO projectManagerDAO;

	/**
	 * 存储参与该项目的教师信息
	 * @param itemPK         项目主键
	 * @param teacherID      该项目负责人的工号
	 * @param teacher2ID     参与该项目的教师的工号数组
	 * @param teacher2Name   参与该项目的教师姓名数组
	 * @return
	 */
	public boolean storeParticipateTeacher(Long itemPK, String teacherID, String[] teacher2ID, String[] teacher2Name) {
		
		boolean status = true;
		
		status = deleteParticipateTeachersByItemPK(itemPK);
		if(!status) {
			return false;
		}
		
		//存入该次添加的参与教师信息
		int participateTeacherNum = teacher2ID.length;
		
		for(int i = 0; i < participateTeacherNum; i++) {
			
			ProjectManager tempProjectManager = new ProjectManager();
			tempProjectManager.setItemPk(itemPK);
			tempProjectManager.setTeacherId(teacherID);
			tempProjectManager.setTeacher2id(teacher2ID[i]);
			tempProjectManager.setTeacher2name(teacher2Name[i]);
			tempProjectManager.setStatus(Integer.toString(i));
			projectManagerDAO.save(tempProjectManager);
		}
		
		return status;
	}
	
	/**
	 * 根据itemPK删除该项目相关的参与教师
	 * @param itemPK
	 * @return
	 */
	public boolean deleteParticipateTeachersByItemPK(long itemPK) {
		
		boolean result = true;
		
		List participateTeacherList = projectManagerDAO.findByItemPk(itemPK);
		
		//删除已存在的参与教师信息
		if(participateTeacherList != null) {
			
			for(int j = 0; j < participateTeacherList.size(); j++) {
				ProjectManager tempProjectManager = (ProjectManager)participateTeacherList.get(j);
				projectManagerDAO.delete(tempProjectManager);
			}
		}
		
		return result;
	}
	
	/**
	 * 根据ItemPK获得该项目的参与教师信息
	 * @param itemPK
	 * @return
	 */
	public String acquireParticipateTeacherByItemPK(long itemPK) {
		
		String result = "";
		List participateTeachers = projectManagerDAO.findByItemPk(itemPK);
		String[] excludes = { "projectManagerPk","itemPk","itemId",
								"teacherId","status"};
		result = JSONTranslation.arrayToJson(participateTeachers, excludes);
		return result;
	}
	
	//setters and getters
	
	public ProjectManagerDAO getProjectManagerDAO() {
		return projectManagerDAO;
	}

	public void setProjectManagerDAO(ProjectManagerDAO projectManagerDAO) {
		this.projectManagerDAO = projectManagerDAO;
	}
}
