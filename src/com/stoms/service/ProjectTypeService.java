package com.stoms.service;

import java.util.List;

import com.stoms.dao.ProjectTypeDAO;
import com.stoms.model.Department;
import com.stoms.model.ProjectType;
import com.stoms.utils.JSONTranslation;

public class ProjectTypeService {

	private ProjectTypeDAO projectTypeDAO;

	/**
	 * 删除主键为projectPK的院系
	 * 
	 * @param projectPK
	 * @return
	 */
	public boolean deleteSelectedProjectType(int[] PKArray) {

		boolean result = false;

		for (int i = 0; i < PKArray.length; i++) {

			int PK = PKArray[i];

			ProjectType tempProjectType = projectTypeDAO.findById(PK);
			if (tempProjectType != null) {
				projectTypeDAO.delete(tempProjectType);
				result = true;
			}
		}

		return result;
	}

	/**
	 * 增加项目类型
	 * 
	 * @return
	 */
	public boolean addNewProjectType(String typeId, String typeName, String departmentType,
			double pmanage, double pmanage2, double ppay, double ppay2,
			double pconsult, double pact, double pimprove,
			double pavailableManageCredit, double pdepartmentPay, double ppay3,
			double ptax1, double ptax2, double ptax3, double ptravelCost,
			double pexchange, double pequipment, double pconference, int isTax,
			int isCross, int budgetType) {

		boolean result = false;

		ProjectType tempProjectType = new ProjectType();

		tempProjectType.setTypeId(typeId);
		tempProjectType.setTypeName(typeName);
		tempProjectType.setDepartmentType(departmentType);
		tempProjectType.setPmanage(pmanage);
		tempProjectType.setPmanage2(pmanage2);
		tempProjectType.setPpay(ppay);
		tempProjectType.setPpay2(ppay2);
		tempProjectType.setPpay3(ppay3);
		tempProjectType.setPconsult(pconsult);
		tempProjectType.setPact(pact);
		tempProjectType.setPimprove(pimprove);
		tempProjectType.setPavailableManageCredit(pavailableManageCredit);
		tempProjectType.setPdepartmentPay(pdepartmentPay);
		tempProjectType.setPtax1(ptax1);
		tempProjectType.setPtax2(ptax2);
		tempProjectType.setPtax3(ptax3);
		tempProjectType.setPtravelCost(ptravelCost);
		tempProjectType.setPexchange(pexchange);
		tempProjectType.setPequipment(pequipment);
		tempProjectType.setPconference(pconference);
		tempProjectType.setIsTax(isTax);
		tempProjectType.setIsCross(isCross);
		tempProjectType.setBudgetType(budgetType);

		projectTypeDAO.save(tempProjectType);

		result = true;

		return result;
	}

	/**
	 * 修改项目类型
	 * 
	 * @return
	 */
	public boolean modifyProjectType(int projectTypePK, String typeId,
			String typeName, String departmentType, double pmanage, double pmanage2,
			double ppay, double ppay2, double pconsult, double pact,
			double pimprove, double pavailableManageCredit,
			double pdepartmentPay, double ppay3, double ptax1, double ptax2,
			double ptax3, double ptravelCost, double pexchange,
			double pequipment, double pconference, int isTax, int isCross,
			int budgetType) {

		boolean result = false;

		ProjectType tempProjectType = null;

		if ((tempProjectType = projectTypeDAO.findById(projectTypePK)) == null)
			tempProjectType = new ProjectType();

		tempProjectType.setTypeId(typeId);
		tempProjectType.setTypeName(typeName);
		tempProjectType.setDepartmentType(departmentType);
		tempProjectType.setPmanage(pmanage);
		tempProjectType.setPmanage2(pmanage2);
		tempProjectType.setPpay(ppay);
		tempProjectType.setPpay2(ppay2);
		tempProjectType.setPpay3(ppay3);
		tempProjectType.setPconsult(pconsult);
		tempProjectType.setPact(pact);
		tempProjectType.setPimprove(pimprove);
		tempProjectType.setPavailableManageCredit(pavailableManageCredit);
		tempProjectType.setPdepartmentPay(pdepartmentPay);
		tempProjectType.setPtax1(ptax1);
		tempProjectType.setPtax2(ptax2);
		tempProjectType.setPtax3(ptax3);
		tempProjectType.setPtravelCost(ptravelCost);
		tempProjectType.setPexchange(pexchange);
		tempProjectType.setPequipment(pequipment);
		tempProjectType.setPconference(pconference);
		tempProjectType.setIsTax(isTax);
		tempProjectType.setIsCross(isCross);
		tempProjectType.setBudgetType(budgetType);

		projectTypeDAO.attachDirty(tempProjectType);

		result = true;

		return result;
	}

	/**
	 * 返回所有项目类型的主键和类型名称
	 * 
	 * @return
	 */
	public String acquireAllProjectTypePKAndName() {

		String result = "";
		List allProjectTypeList = projectTypeDAO.findAll();
		String[] excludes = { "typeId", "subTypeId", "subTypeName", "pmanage",
				"ppay", "pconsult", "pavailableManageCredit", "pdepartmentPay",
				"ppay3", "ptax1", "ptax2", "ptax3", "isTax", "items",
				"isCross", "pact", "pimprove", "pmanage2", "ppay2" };

		result = JSONTranslation.arrayToJson(allProjectTypeList, excludes);
		return result;
	}
	
	/**
	 * 返回所有项目类型的主键、类型ID和类型名称
	 * 2013-07-14
	 * @shi
	 */
	public String acquireAllProjectTypePKAndIDAndName() {

		String result = "";
		List allProjectTypeList = projectTypeDAO.findAll();
		String[] excludes = { "subTypeId", "subTypeName", "pmanage",
				"ppay", "pconsult", "pavailableManageCredit", "pdepartmentPay",
				"ppay3", "ptax1", "ptax2", "ptax3", "isTax", "items",
				"isCross", "pact", "pimprove", "pmanage2", "ppay2" };

		result = JSONTranslation.arrayToJson(allProjectTypeList, excludes);
		return result;
	}

	/**
	 * 返回所有项目类型的PK，名称和预算类型
	 * 
	 * @return
	 */
	public String accquireItemTypePKNameAndBudgetType() {

		String result = "";
		List allProjectTypeList = projectTypeDAO.findAll();
		String[] excludes = { "typeId", "subTypeId", "subTypeName", "pmanage",
				"ppay", "pconsult", "pavailableManageCredit", "pdepartmentPay",
				"ppay3", "ptax1", "ptax2", "ptax3", "isTax", "items",
				"isCross", "pact", "pimprove", "pmanage2", "ppay2" };

		result = JSONTranslation.arrayToJson(allProjectTypeList, excludes);
		return result;
	}

	/*
	 * 获取特定一个projectType信息
	 */
	public ProjectType acquireOneprojectTypeInfoByPK(int projectTypePK) {

		ProjectType projectType = projectTypeDAO.findById(projectTypePK);
		return projectType;
	}

	/**
	 * 获取所有的项目类型列表
	 * 
	 * @return
	 */
	public List acquireAllProjectType() {
		List allProjectTypeList = projectTypeDAO.findAll();
		return allProjectTypeList;
	}

	/**
	 * 返回主键为projectTypePK的项目类型
	 * 
	 * @param projectTypePK
	 * @return
	 */
	public ProjectType acquireProjectTypeByProjectTypePK(int projectTypePK) {

		ProjectType tempProjectType = projectTypeDAO.findById(projectTypePK);

		return tempProjectType;
	}

	// setters and getters
	public ProjectTypeDAO getProjectTypeDAO() {
		return projectTypeDAO;
	}

	public void setProjectTypeDAO(ProjectTypeDAO projectTypeDAO) {
		this.projectTypeDAO = projectTypeDAO;
	}
}
