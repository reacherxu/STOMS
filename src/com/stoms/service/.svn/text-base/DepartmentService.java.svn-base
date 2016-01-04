package com.stoms.service;

import java.util.ArrayList;
import java.util.List;

import com.stoms.dao.DepartmentDAO;
import com.stoms.model.Department;
import com.stoms.utils.JSONTranslation;

public class DepartmentService {
	
	private DepartmentDAO departmentDAO;

	/**
	 * 返回所有院系的主键和院系名
	 * 
	 * @return
	 */
	public String acquireAllDepartmentPKAndName() {

		String result = "";
		List allDepartmentList = departmentDAO.findAll();
		String[] excludes = { "assistanceName", "assistanceTel", "assistanceMobile",
				"assistanceEmail", "teachers", "assistanceId", "directorId" };
		result = JSONTranslation.arrayToJson(allDepartmentList, excludes);
		return result;
	}

	/**
	 * 
	 * @param departmentId
	 * @param departmentName
	 * @param departmentType
	 * @param assistanceName
	 * @param assistanceMobile
	 * @param assistanceTel
	 * @param assistanceEmail
	 * @return
	 */
	public Department addNewDepartment(String departmentId, String departmentName, String departmentType, String assistanceId,String directorId,
			 String assistanceTel, String assistanceMobile, String assistanceEmail) {
		
		Department tempDepartment = null;
		
		Department department = new Department();
		department.setDepartmentId(departmentId);
		department.setDepartmentName(departmentName);
		department.setDepartmentType(departmentType);
		department.setAssistanceId(assistanceId);
		department.setDirectorId(directorId);
		department.setAssistanceMobile(assistanceMobile);
		department.setAssistanceTel(assistanceTel);
		department.setAssistanceEmail(assistanceEmail);
		
		departmentDAO.save(department);
		
		List departmentList = departmentDAO.findByDepartmentId(departmentId);
		
		if(departmentList.size() == 0) {
			return null;
		}
		
		tempDepartment = (Department)departmentList.get(0);
		return tempDepartment;
		
	}
	
	/**
	 * 删除主键为departmentPK的院系
	 * @param departmentPK
	 * @return
	 */
	public boolean deleteSelectedDepartment(int[] departmentPKArray) {
		
		boolean result = false;
		
		for (int i = 0; i < departmentPKArray.length; i++) {
			
			int departmentPK = departmentPKArray[i];
			
			Department tempDepartment = departmentDAO.findById(departmentPK);
			if(tempDepartment != null) {
				departmentDAO.delete(tempDepartment);
				result = true;
			}
		}
		
		return result;
	}
	/**
	 * 返回所有院系信息
	 * @return
	 */
	public List acquireAllDepartmentInfo() {
		
		List allDepartmentList = departmentDAO.findAll();
		return allDepartmentList;
	}
	
	public Department acquireOneDepartmentInfoByPK(int departmentPK) {
			
		Department departmentInfo = departmentDAO.findById(departmentPK);
			return departmentInfo;
	}
	//add by shi 20140619
	public Department acquireOneDepartmentInfoByName(String departmentName) {
		List<Department> departments = new ArrayList<Department>();
		departments= departmentDAO.findByDepartmentName(departmentName);
		Department departmentInfo = new Department();
		if(departments!=null && departments.size()>0){
			departmentInfo = departments.get(0);
		}
			
		return departmentInfo;
	}
	//add by shi 20131008
	public Department acquireOneDepartmentInfoByID(String departmentId) {
		
		List allDepartmentInfo = departmentDAO.findByDepartmentId(departmentId);
		Department de;
		if(allDepartmentInfo.size() == 0){
			de = null;
		}else{
			 de = (Department)allDepartmentInfo.get(0);
		}
		return de;
	}
	
	public boolean modifyDepartment(int departmentPK,String departmentId, String departmentName, String departmentType, String assistanceId,String directorId,
			 String assistanceTel, String assistanceMobile, String assistanceEmail){
		boolean result = false;
		Department tempDepartment = departmentDAO.findById(departmentPK);
		if(tempDepartment == null) {
			return result;
		}

		tempDepartment.setDepartmentId(departmentId);
		tempDepartment.setDepartmentName(departmentName);
		tempDepartment.setDepartmentType(departmentType);
		tempDepartment.setAssistanceId(assistanceId);
		tempDepartment.setDirectorId(directorId);
		tempDepartment.setAssistanceMobile(assistanceMobile);
		tempDepartment.setAssistanceTel(assistanceTel);
		tempDepartment.setAssistanceEmail(assistanceEmail);
		
		departmentDAO.attachDirty(tempDepartment);
		
		result = true;	
		return result;
	}
	
	
	//setters and getters
	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}
	
	

}
