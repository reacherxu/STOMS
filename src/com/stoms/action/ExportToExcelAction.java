package com.stoms.action;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.model.AddOutlay;
import com.stoms.model.Item;
import com.stoms.service.AddOutlayService;
import com.stoms.service.ItemService;
import com.stoms.utils.ExcelOperate;

public class ExportToExcelAction extends ActionSupport {
	
	private String jsonResult;
	private boolean actionStatus;
	
	private String[] itemPKs;
	private String[] addoutlayPKs;
	private String[] teacherPKs;
	private String[] departmentPKs;
	private String[] itemTypePKs;
	
	private AddOutlayService addOutlayService;
	private ItemService itemService;
	
	public String itemExportToExcel(){
		jsonResult = "";
		
		List<List<String>> items = new ArrayList<List<String>>();
		List<String> mList1 = new ArrayList<String>();
		mList1.add("项目ID");
		mList1.add("项目名称");
		mList1.add("教师姓名");
		mList1.add("教师姓名2");
		mList1.add("院系名称");
		mList1.add("项目类型代码");
		items.add(mList1);
		for(String itemPK:itemPKs){
			List<String> mList = new ArrayList<String>();
			Item item = new Item();
			item = itemService.getItemDAO().findById(Long.parseLong(itemPK));
			String itemId = item.getItemId();
			String itemName = item.getItemName();
			String teacherName = item.getTeacherName();
			String otherTeacher = item.getOtherTeacher();
			String departmentName= item.getDepartmentName();
			String itemType = item.getTypeId();
			mList.add(itemId);
			mList.add(itemName);
			mList.add(teacherName);
			mList.add(otherTeacher);
			mList.add(departmentName);
			mList.add(itemType);
			items.add(mList);
		}
		
		String fileName = "";
		fileName = new ExcelOperate().writeToExcel(items, "Items");
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.element("fileName", fileName);
		this.jsonResult = jsonObject.toString();
		
		this.actionStatus = true;
		return "success";
	}
	//入账信息导出excel
	public String addoutlayExportToExcel(){
		jsonResult = "";
		
		List<List<String>> addoutlays = new ArrayList<List<String>>();
		List<String> mList1 = new ArrayList<String>();
		mList1.add("项目ID");
		mList1.add("项目名称");
		mList1.add("教师姓名");
		mList1.add("教师姓名2");
		mList1.add("来款金额");
		mList1.add("汇出金额");
		mList1.add("来款单位");
		mList1.add("录入时间");
		addoutlays.add(mList1);
		for(String addoutlayPK:addoutlayPKs){
			List<String> mList = new ArrayList<String>();
			AddOutlay addoutlay = new AddOutlay();
			addoutlay = addOutlayService.getAddOutlayDAO().findById(Long.parseLong(addoutlayPK));
			String itemId = addoutlay.getItemId();
			String itemName = addoutlay.getItemName();
			String teacherName = addoutlay.getTeacherName();
			String otherTeacher = addoutlay.getOtherTeacher();
			String outlayValue= addoutlay.getOutlayValue().toString();
			String remitValue= addoutlay.getRemitValue().toString();
			String outlayDepartmentName = addoutlay.getOutlayDepartment();
			String outlayTime = addoutlay.getOutlayTime();
			mList.add(itemId);
			mList.add(itemName);
			mList.add(teacherName);
			mList.add(otherTeacher);
			mList.add(outlayValue);
			mList.add(remitValue);
			mList.add(outlayDepartmentName);
			mList.add(outlayTime);
			addoutlays.add(mList);
		}
		
		String fileName = "";
		fileName = new ExcelOperate().writeToExcel(addoutlays, "Addoutlays");
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.element("fileName", fileName);
		this.jsonResult = jsonObject.toString();
		
		this.actionStatus = true;
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
	public AddOutlayService getAddOutlayService() {
		return addOutlayService;
	}
	public void setAddOutlayService(AddOutlayService addOutlayService) {
		this.addOutlayService = addOutlayService;
	}
	public ItemService getItemService() {
		return itemService;
	}
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	public String[] getItemPKs() {
		return itemPKs;
	}
	public void setItemPKs(String[] itemPKs) {
		this.itemPKs = itemPKs;
	}
	public String[] getAddoutlayPKs() {
		return addoutlayPKs;
	}
	public void setAddoutlayPKs(String[] addoutlayPKs) {
		this.addoutlayPKs = addoutlayPKs;
	}
	public String[] getTeacherPKs() {
		return teacherPKs;
	}
	public void setTeacherPKs(String[] teacherPKs) {
		this.teacherPKs = teacherPKs;
	}
	public String[] getDepartmentPKs() {
		return departmentPKs;
	}
	public void setDepartmentPKs(String[] departmentPKs) {
		this.departmentPKs = departmentPKs;
	}
	public String[] getItemTypePKs() {
		return itemTypePKs;
	}
	public void setItemTypePKs(String[] itemTypePKs) {
		this.itemTypePKs = itemTypePKs;
	}
}
