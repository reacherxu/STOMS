package com.stoms.service;

import java.util.List;

import com.stoms.dao.ItemDAO;
import com.stoms.model.Item;
import com.stoms.utils.JSONTranslation;

public class ProjectInfoAuditService {

	private ItemDAO itemDAO;
	
	public String acquireProjectInfoAuditList( ) {
	
		List<Item> ItemList = itemDAO.findByProjectStatus("11");
		if ( ItemList == null || ItemList.size() == 0) {
			return "";
		}
		
		String[] excludes = {};
		String itemInfo = JSONTranslation.arrayToJson(ItemList, excludes);
		
		return itemInfo.toString();
	}
	
	public String acquireProjectInfoAuditList(String operatorId) {
		
		List<Item> ItemList = itemDAO.findByProjectStatusAndoperatorId(operatorId);
		if ( ItemList == null || ItemList.size() == 0) {
			return "";
		}
		
		String[] excludes = {};
		String itemInfo = JSONTranslation.arrayToJson(ItemList, excludes);
		
		return itemInfo.toString();
	}
	
	public boolean projectInfoAuditApprove( Long itemPK ) {
		
		return this.setProjectAuditStatus(itemPK, "31");
	}
	
	public boolean projectInfoAuditReject( Long itemPK ) {
		
		return this.setProjectAuditStatus(itemPK, "30");
	}
	
	private boolean setProjectAuditStatus( Long itemPK, String status ) {
		
		Item item = itemDAO.findById(itemPK);

		if (item == null) {
			return false;
		}
		
		item.setProjectStatus(status);
		itemDAO.attachDirty(item);
		
		return true;
	}

	public ItemDAO getItemDAO() {
		return itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	
	
}
