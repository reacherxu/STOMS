package com.stoms.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.stoms.dao.ItemDAO;
import com.stoms.model.temp.StatisticsItemByManager;
import com.stoms.utils.JSONTranslation;
import com.stoms.model.Item;

public class ProjectQueryAdminService {

	private ItemDAO itemDAO;

	private DepartmentService departmentService;
	
	private ProjectTypeService projectTypeService;
	
	private ItemService itemService;
	
	public String acquireProjectQueryInfoAdmin () {
		
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
	public String itemQuery (
			String itemid,String contractid,String typeid,String itemname,
			String departmentid,String departmenttype,String teachername,
			String startDate,String endDate) {
		
		String[] excludes = {};
		
		List list = itemService.acquireItemInfo2(itemid,contractid,typeid,
				itemname,departmentid,departmenttype,teachername,startDate,endDate);

		if (list == null || list.size() == 0)
			return "";
		return JSONTranslation.arrayToJson(list, excludes);

	}
	public String acquireOneItemInfo(long itemPK){
		String[] excludes = {};
		Item item = itemService.acquireOneItemInfo(itemPK);

		if (item == null)
			return "";
		return JSONTranslation.objectToJson(item, excludes);
	}
	
	
	public String singleProjectInfoAdminQuery (
			int[] selectedItemTypePKs, int isCross,String startDate,
			String endDate,int[] selectedDepartmentPKs) {
		
		String[] excludes = {};
		
		List list = itemService.acquireItemInfo(selectedItemTypePKs,
				isCross, startDate, endDate, selectedDepartmentPKs);

		if (list == null || list.size() == 0)
			return "";
		return JSONTranslation.arrayToJson(list, excludes);

	}
	
	public String projectStatisticAdminQuery (
			int[] selectedItemTypePKs, int isCross,String startDate,
			String endDate,int[] selectedDepartmentPKs) {
		
		String[] excludes = {};
		
		List list = itemService.acquireStatisticsItem(selectedItemTypePKs,
				isCross, startDate, endDate, selectedDepartmentPKs);

		if (list == null || list.size() == 0)
			return "";
		
		return JSONTranslation.arrayToJson(list, excludes);

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

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	public ItemDAO getItemDAO() {
		return itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	
}
