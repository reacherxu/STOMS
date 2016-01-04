package com.stoms.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.service.ProjectTypeService;
import com.stoms.model.Department;
import com.stoms.model.ProjectType;
import com.stoms.utils.JSONTranslation;

public class ProjectTypeMaintainceAction extends ActionSupport {

	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;
	private int[] PKArray;

	private int projectTypePK;

	private String typeId;
	private String typeName;
	private String departmentType;
	private double pmanage;
	private double pmanage2;
	private double ppay;
	private double ppay2;
	private double pconsult;
	private double pact;
	private double pimprove;
	private double pavailableManageCredit;
	private double pdepartmentPay;

	private double ptravelCost;
	private double pexchange;
	private double pequipment;
	private double pconference;

	private double ppay3;
	private double ptax1;
	private double ptax2;
	private double ptax3;
	private int isTax;
	private int isCross;
	private int budgetType;

	private ProjectTypeService projectTypeService;

	/**
	 * 删除项目类型信息
	 * 
	 * @return
	 */
	public String deleteSelectedProjectType() {

		if (this.PKArray == null || this.PKArray.length == 0) {

			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = projectTypeService
				.deleteSelectedProjectType(this.PKArray);
		this.jsonResult = "";
		return "success";
	}

	/**
	 * 增加一个新的项目类型信息
	 * 
	 * @return
	 */
	public String addNewProjectType() {

		if (typeId == null || typeName == null || departmentType == null) {

			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = projectTypeService.addNewProjectType(typeId,
				typeName, departmentType, pmanage,
				pmanage2, ppay, ppay2, pconsult, pact, pimprove,
				pavailableManageCredit, pdepartmentPay, ppay3, ptax1, ptax2,
				ptax3, ptravelCost, pexchange, pequipment, pconference, isTax,
				isCross, budgetType);

		this.jsonResult = "";
		return "success";
	}

	/**
	 * 修改一个项目类型信息
	 * 
	 * @return
	 */
	public String modifyProjectType() {

		if (typeId == null || typeName == null || departmentType == null) {

			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = projectTypeService.modifyProjectType(projectTypePK,
				typeId, typeName, departmentType,
				pmanage, pmanage2, ppay, ppay2, pconsult, pact, pimprove,
				pavailableManageCredit, pdepartmentPay, ppay3, ptax1, ptax2,
				ptax3, ptravelCost, pexchange, pequipment, pconference, isTax, isCross, budgetType);
		this.jsonResult = "";
		return "success";
	}

	/**
	 * 获取项目类型的所有记录
	 * 
	 * @return
	 */
	public String acquireAllProjectType() {
		List allProjectType = projectTypeService.acquireAllProjectType();
		String[] excludes = { "items" };
		this.jsonResult = JSONTranslation.arrayToJson(allProjectType, excludes);

		if (this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.jsonResult = "";
			this.actionStatus = false;
			return "success";
		}

		this.actionStatus = true;
		return "success";
	}

	/**
	 * 获取特定项目类型的具体信息
	 * 
	 * @return
	 */
	public String acquireOneProjectTypeInfoByPK() {

		ProjectType oneProjectTypeInfo = projectTypeService
				.acquireOneprojectTypeInfoByPK(projectTypePK);
		String[] excludes = {};

		this.jsonResult = JSONTranslation.objectToJson(oneProjectTypeInfo,
				excludes);

		if (this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.jsonResult = "";
			this.actionStatus = false;
			return "success";
		}

		this.actionStatus = true;
		return "success";
	}

	// setters and getters
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

	public ProjectTypeService getProjectTypeService() {
		return projectTypeService;
	}

	public void setProjectTypeService(ProjectTypeService projectTypeService) {
		this.projectTypeService = projectTypeService;
	}

	public int getProjectTypePK() {
		return projectTypePK;
	}

	public void setProjectTypePK(int projectTypePK) {
		this.projectTypePK = projectTypePK;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	

	public String getDepartmentType() {
		return departmentType;
	}

	public void setDepartmentType(String departmentType) {
		this.departmentType = departmentType;
	}

	public double getPmanage() {
		return pmanage;
	}

	public void setPmanage(double pmanage) {
		this.pmanage = pmanage;
	}

	public double getPmanage2() {
		return pmanage2;
	}

	public void setPmanage2(double pmanage2) {
		this.pmanage2 = pmanage2;
	}

	public double getPpay() {
		return ppay;
	}

	public void setPpay(double ppay) {
		this.ppay = ppay;
	}

	public double getPpay2() {
		return ppay2;
	}

	public void setPpay2(double ppay2) {
		this.ppay2 = ppay2;
	}

	public double getPconsult() {
		return pconsult;
	}

	public void setPconsult(double pconsult) {
		this.pconsult = pconsult;
	}

	public double getPact() {
		return pact;
	}

	public void setPact(double pact) {
		this.pact = pact;
	}

	public double getPimprove() {
		return pimprove;
	}

	public void setPimprove(double pimprove) {
		this.pimprove = pimprove;
	}

	public double getPavailableManageCredit() {
		return pavailableManageCredit;
	}

	public void setPavailableManageCredit(double pavailableManageCredit) {
		this.pavailableManageCredit = pavailableManageCredit;
	}

	public double getPdepartmentPay() {
		return pdepartmentPay;
	}

	public void setPdepartmentPay(double pdepartmentPay) {
		this.pdepartmentPay = pdepartmentPay;
	}

	public double getPpay3() {
		return ppay3;
	}

	public void setPpay3(double ppay3) {
		this.ppay3 = ppay3;
	}

	public double getPtax1() {
		return ptax1;
	}

	public void setPtax1(double ptax1) {
		this.ptax1 = ptax1;
	}

	public double getPtax2() {
		return ptax2;
	}

	public void setPtax2(double ptax2) {
		this.ptax2 = ptax2;
	}

	public double getPtax3() {
		return ptax3;
	}

	public void setPtax3(double ptax3) {
		this.ptax3 = ptax3;
	}

	public int getIsTax() {
		return isTax;
	}

	public void setIsTax(int isTax) {
		this.isTax = isTax;
	}

	public int getIsCross() {
		return isCross;
	}

	public void setIsCross(int isCross) {
		this.isCross = isCross;
	}

	public int getBudgetType() {
		return budgetType;
	}

	public void setBudgetType(int budgetType) {
		this.budgetType = budgetType;
	}

	public int[] getPKArray() {
		return PKArray;
	}

	public void setPKArray(int[] pKArray) {
		PKArray = pKArray;
	}

	public double getPtravelCost() {
		return ptravelCost;
	}

	public void setPtravelCost(double ptravelCost) {
		this.ptravelCost = ptravelCost;
	}

	public double getPexchange() {
		return pexchange;
	}

	public void setPexchange(double pexchange) {
		this.pexchange = pexchange;
	}

	public double getPequipment() {
		return pequipment;
	}

	public void setPequipment(double pequipment) {
		this.pequipment = pequipment;
	}

	public double getPconference() {
		return pconference;
	}

	public void setPconference(double pconference) {
		this.pconference = pconference;
	}

}
