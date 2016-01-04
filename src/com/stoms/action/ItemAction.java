package com.stoms.action;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.service.ItemService;

public class ItemAction extends ActionSupport {
	private ItemService itemService;
	
	private boolean actionStatus;
	private String jsonResult;
	
	private String contractID;
	private String itemId;
	private int itemIdCount;
	private String projectStatusName;
	private String itemString;
	
	
	
	//setter and getter
	public String getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	public ItemService getItemService() {
		return itemService;
	}

	public void setActionStatus(boolean actionStatus) {
		this.actionStatus = actionStatus;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public String getContractID() {
		return contractID;
	}

	public void setContractID(String contractID) {
		this.contractID = contractID;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getItemIdCount() {
		return itemIdCount;
	}

	public void setItemIdCount(int itemIdCount) {
		this.itemIdCount = itemIdCount;
	}

	public String getProjectStatusName() {
		return projectStatusName;
	}

	public void setProjectStatusName(String projectStatusName) {
		this.projectStatusName = projectStatusName;
	}

	public String getItemString() {
		return itemString;
	}

	public void setItemString(String itemString) {
		this.itemString = itemString;
	}

	
	


	public boolean isActionStatus() {
		return actionStatus;
	}




	
}
