package com.stoms.service;

import java.util.List;

import com.stoms.dao.TeacherTitleDAO;
import com.stoms.model.TeacherTitle;
import com.stoms.utils.JSONTranslation;

public class TeacherTitleService {
	
	private TeacherTitleDAO teacherTitleDAO;
	
	
	public String acquireAllTeacherTitles() {
		
		String result = "";
		List allTeacherTitles = teacherTitleDAO.findAll();
		
		String[] excludes = { "teachers"};
		result = JSONTranslation.arrayToJson(allTeacherTitles, excludes);
		return result;
	}
	
	public String addNewTitle(String titleName) {
		
		String result = "";
		List tempTitleList = teacherTitleDAO.findByTitleName(titleName);
		
		//如果已存在该头衔名，则返回空
		if(tempTitleList.size() > 0) {
			return result;
		}
		TeacherTitle teacherTile = new TeacherTitle();
		teacherTile.setTitleName(titleName);
		
		teacherTitleDAO.save(teacherTile);
		
		
		List addedTitleList = teacherTitleDAO.findByTitleName(titleName);
		
		//如果刚添加的头衔名不成功，则返回空
		if(addedTitleList.size() == 0) {
			return result;
		}
		
		TeacherTitle addedTeacherTitle = (TeacherTitle)addedTitleList.get(0);
		String[] excludes = { "teachers"};
		result = JSONTranslation.objectToJson(addedTeacherTitle, excludes);
		return result;
		
	}
	
	/**
	 * 删除一个教师头衔种类
	 * @param titlePK
	 * @return
	 */
	public boolean deleteTitle(Integer titlePK) {
		
		boolean status = true;
		
		TeacherTitle tempTeacherTitle = teacherTitleDAO.findById(titlePK);
		if(tempTeacherTitle == null) {
			status = false;
			return status;
		}
		teacherTitleDAO.delete(tempTeacherTitle);
		return status;
	}
	
	public boolean updateTitle(Integer titlePK, String titleName) {
		
		boolean status = true;
		TeacherTitle tempTeacherTitle = teacherTitleDAO.findById(titlePK);
		
		if(tempTeacherTitle == null) {
			status = false;
			return status;
		}
		
		tempTeacherTitle.setTitleName(titleName);
		teacherTitleDAO.attachDirty(tempTeacherTitle);
		
		return status;
	}
	public TeacherTitleDAO getTeacherTitleDAO() {
		return teacherTitleDAO;
	}

	public void setTeacherTitleDAO(TeacherTitleDAO teacherTitleDAO) {
		this.teacherTitleDAO = teacherTitleDAO;
	}

	
}
