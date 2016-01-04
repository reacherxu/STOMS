package com.stoms.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.stoms.dao.ItemDAO;
import com.stoms.dao.OldAddOutlayDAO;
import com.stoms.model.AddOutlay;
import com.stoms.model.Item;
import com.stoms.model.temp.StatisticsTeacherOutlay;
import com.stoms.utils.JSONTranslation;

public class InAccountQueryAdminService {

	private ItemDAO itemDAO;
	
	private OldAddOutlayDAO oldAddOutlayDAO;

	private DepartmentService departmentService;
	
	private ProjectTypeService projectTypeService;
	
	private AddOutlayService addOutlayService;
	
	public String acquireInAccountQueryInfoAdmin () {
		
		String result = "";
		
		//院系列表
		String allDepartmentInfo = departmentService.acquireAllDepartmentPKAndName();
		
		//院系列表
		String allProjectTypeInfo = projectTypeService.acquireAllProjectTypePKAndName();

		if (allDepartmentInfo == null || allDepartmentInfo.trim().equals("")
				|| allProjectTypeInfo == null || allProjectTypeInfo.trim().equals("")) {

			return null;
		}

		JSONObject jsonObject = new JSONObject();
		jsonObject.element("allDepartmentInfo", allDepartmentInfo);
		jsonObject.element("allProjectTypeInfo", allProjectTypeInfo);
		result = jsonObject.toString();

		return result;
	}
	//获得一个入账的详细信息
	public String acquireOneAddoutlayInfo(long addoutlayPK){
		String[] excludes = {};
		AddOutlay addoutlay = addOutlayService.acquireOneAddoutlayInfoByAddOutlayPK(addoutlayPK);
		if (addoutlay == null)
			return "";
		return JSONTranslation.objectToJson(addoutlay, excludes);
	}
	
	public String addoutlayQuery(String itemId,double outlayValue,double remitValue,int isCross,
			String outlayDepartment,String teacherName,String departmentId, String departmentType,
			String lowYear,String upperYear){
		String[] excludes = {};
		
		List list = addOutlayService.addoutlayQuery(itemId,outlayValue,
				remitValue, isCross, outlayDepartment, teacherName, departmentId,
				departmentType, lowYear, upperYear);

		if (list == null || list.size() == 0)
			return "";

		return JSONTranslation.arrayToJson(list, excludes);
	}
	
	public String inAccountAdminQuery(
			String itemName,String teacherName,String cardId,
			String itemId,String contractId,String outlayDepartment,int isInvoice,
			int isCross,String timeLower,String timeUpper,String outlayStartDate,
			String outlayEndDate,int[] typepks,int[] departmentpks ) {
		
		String[] excludes = {};
		
		List list = addOutlayService.acquireManagerOutlay(
				itemName, teacherName, cardId, itemId, contractId, outlayDepartment, 
				 isInvoice,isCross, timeLower, timeUpper, outlayStartDate,
				 outlayEndDate, typepks, departmentpks );

		if (list == null || list.size() == 0)
			return "";

		return JSONTranslation.arrayToJson(list, excludes);
		
	}

	public ItemDAO getItemDAO() {
		return itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public OldAddOutlayDAO getOldAddOutlayDAO() {
		return oldAddOutlayDAO;
	}
	public void setOldAddOutlayDAO(OldAddOutlayDAO oldAddOutlayDAO) {
		this.oldAddOutlayDAO = oldAddOutlayDAO;
	}
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public ProjectTypeService getProjectTypeService() {
		return projectTypeService;
	}

	public void setProjectTypeService(ProjectTypeService projectTypeService) {
		this.projectTypeService = projectTypeService;
	}

	public AddOutlayService getAddOutlayService() {
		return addOutlayService;
	}

	public void setAddOutlayService(AddOutlayService addOutlayService) {
		this.addOutlayService = addOutlayService;
	}

}
