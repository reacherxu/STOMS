package com.stoms.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.model.AddOutlay;
import com.stoms.model.Teacher;
import com.stoms.service.AddOutlayService;
import com.stoms.service.ProjectQueryAdminService;
import com.stoms.utils.JSONTranslation;
import com.stoms.service.ItemService;
import com.stoms.model.Item;

/**
 * 管理页面下项目查询和统计的action
 * 
 * @author xjk
 *
 */
public class ProjectQueryAdminAction extends ActionSupport{

	// two results for all the action
	private String jsonResult;
	private boolean actionStatus;
	
	private int isCross;
	private String startDate;
	private String endDate;
	private int[] selectedItemTypePKs;
	private int[] selectedDepartmentPKs;
	private String itemid;
	private String contractid;
	private String typeid;
	private String itemname;
	private String departmentid;
	private String departmenttype;
	private String teachername;
	private long itemPK;
	private String otherteacher;
	private int departmentPK;
	private String departmentname;
	private String cardid;
	private double itemvalue;
	private double remitvalue;
	private int isFinished;
	private ItemService itemService;
	
	private ProjectQueryAdminService projectQueryAdminService;
	
	/**
	 * 返回所有项目类型的主键和名称
	 * 
	 */
	public String acquireProjectQueryInfoAdmin() {
		
		// 项目类型的主键和名称信息
		String queryInputList = projectQueryAdminService.acquireProjectQueryInfoAdmin();

		if( queryInputList == null ) {
			this.actionStatus = false;
			this.jsonResult = "";
		}
		else {
			
			this.actionStatus = true;
			this.jsonResult = queryInputList;
		}
		
		return "success";
	}
	
	/**
	 * 项目信息 查询 addby shi 20131017
	 * @return findItemByItemPK2
	 */
	public String itemQuery() {
		
		String itemList = projectQueryAdminService.itemQuery(
				itemid,contractid,typeid,itemname,departmentid,departmenttype,teachername,startDate,endDate);
		if( itemList.equals("") ) {
			this.actionStatus = false;
			this.jsonResult = "";
		}
		else {
			this.actionStatus = true;
			this.jsonResult = itemList;
		}
		return "success";
	}
	
	public String acquireOneItemInfo() {
		String item = projectQueryAdminService.acquireOneItemInfo(itemPK);
		if( item.equals("") ) {
			this.actionStatus = false;
			this.jsonResult = "";
		}
		else {
			this.actionStatus = true;
			this.jsonResult = item;
		}
		return "success";
	}
	
	public String modifyItem(){
		Item item = projectQueryAdminService.getItemService().modifyItem(itemPK,itemname,contractid,
				teachername,otherteacher,typeid,departmentPK,departmentid,departmentname,departmenttype,
				cardid, itemvalue, remitvalue,startDate, endDate, isFinished);

		if(item != null){
			this.actionStatus = true;
		}else{
			this.actionStatus = false;
		}
		this.jsonResult = "";
		return "success";
	}
	
	public String deleteItem(){
		long[] PKArray ={itemPK};
		this.actionStatus = projectQueryAdminService.getItemService().deleteSelectedItem(PKArray);
		this.jsonResult = "";
		return "success";
	}
	
	/**
	 * 管理员单个项目查询
	 * @return
	 */
	public String singleProjectInfoAdminQuery() {
		
		String itemList = projectQueryAdminService.singleProjectInfoAdminQuery(
				selectedItemTypePKs,isCross,startDate,endDate,selectedDepartmentPKs );
		
		if( itemList.equals("") ) {
			this.actionStatus = false;
			this.jsonResult = "";
		}
		else {
			
			this.actionStatus = true;
			this.jsonResult = itemList;
		}
		
		return "success";
	}
	
	/**
	 * 管理员项目统计查询
	 * @return
	 */
	public String projectStatisticAdminQuery() {
		
		String itemStatistic = projectQueryAdminService.projectStatisticAdminQuery(
				selectedItemTypePKs,isCross,startDate,endDate,selectedDepartmentPKs );
		
		if( itemStatistic.equals("") ) {
			this.actionStatus = false;
			this.jsonResult = "";
		}
		else {
			
			this.actionStatus = true;
			this.jsonResult = itemStatistic;
		}
		
		return "success";
	}


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


	public int getIsCross() {
		return isCross;
	}


	public void setIsCross(int isCross) {
		this.isCross = isCross;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public int[] getSelectedItemTypePKs() {
		return selectedItemTypePKs;
	}


	public void setSelectedItemTypePKs(int[] selectedItemTypePKs) {
		this.selectedItemTypePKs = selectedItemTypePKs;
	}


	public int[] getSelectedDepartmentPKs() {
		return selectedDepartmentPKs;
	}


	public void setSelectedDepartmentPKs(int[] selectedDepartmentPKs) {
		this.selectedDepartmentPKs = selectedDepartmentPKs;
	}


	public ProjectQueryAdminService getProjectQueryAdminService() {
		return projectQueryAdminService;
	}


	public void setProjectQueryAdminService(
			ProjectQueryAdminService projectQueryAdminService) {
		this.projectQueryAdminService = projectQueryAdminService;
	}

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getContractid() {
		return contractid;
	}

	public void setContractid(String contractid) {
		this.contractid = contractid;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepartmenttype() {
		return departmenttype;
	}

	public void setDepartmenttype(String departmenttype) {
		this.departmenttype = departmenttype;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public long getItemPK() {
		return itemPK;
	}

	public void setItemPK(long itemPK) {
		this.itemPK = itemPK;
	}
	public String getOtherteacher() {
		return otherteacher;
	}

	public void setOtherteacher(String otherteacher) {
		this.otherteacher = otherteacher;
	}

	public int getDepartmentPK() {
		return departmentPK;
	}

	public void setDepartmentPK(int departmentPK) {
		this.departmentPK = departmentPK;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public double getItemvalue() {
		return itemvalue;
	}

	public void setItemvalue(double itemvalue) {
		this.itemvalue = itemvalue;
	}

	public double getRemitvalue() {
		return remitvalue;
	}

	public void setRemitvalue(double remitvalue) {
		this.remitvalue = remitvalue;
	}

	public int getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(int isFinished) {
		this.isFinished = isFinished;
	}

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
}
