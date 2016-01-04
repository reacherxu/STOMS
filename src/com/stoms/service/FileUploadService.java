package com.stoms.service;

import java.io.File;
import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.stoms.dao.AddOutlayDAO;
import com.stoms.dao.ItemDAO;
import com.stoms.model.AddOutlay;
import com.stoms.model.Item;

public class FileUploadService {

	private ItemDAO itemDAO;
	private AddOutlayDAO addOutlayDAO;

	/**
	 * 根据itemPK设置对应项目的上传附件（图片）的路径 如果有多个图片，路径用 ;（分号） 分隔，组成一个字符串存入
	 * 
	 * @param itemPK
	 * @return
	 */
	public String addItemPictureInfo(long itemPK, String filePath) {

		Item item = itemDAO.findById(itemPK);

		if (item == null || filePath == null) {
			return "";
		}

		String pathDB = item.getPicture();

		if ("null".equals(pathDB) || pathDB == null)
			pathDB = "";

		pathDB = pathDB + filePath + ";";

		item.setPicture(pathDB);
		itemDAO.attachDirty(item);

		JSONObject jsonObject = new JSONObject();
		jsonObject.element("picUploadArray", pathDB.split(";"));

		return jsonObject.toString();

	}

	/**
	 * 根据addOutlayPK设置对应项目入账的上传附件（图片）的路径 如果有多个图片，路径用 ;（分号） 分隔，组成一个字符串存入
	 * 
	 * @param addOutlayPK
	 * @param dbFilePath
	 * @return
	 */
	public String addInAccountPictureInfo(long addOutlayPK, String dbFilePath) {

		AddOutlay addOutlay = addOutlayDAO.findById(addOutlayPK);

		if (addOutlay == null || dbFilePath == null) {
			return "";
		}

		String pathDB = addOutlay.getPicture();

		if ("null".equals(pathDB) || pathDB == null)
			pathDB = "";

		pathDB = pathDB + dbFilePath + ";";
		addOutlay.setPicture(pathDB);
		addOutlayDAO.attachDirty(addOutlay);

		JSONObject jsonObject = new JSONObject();
		jsonObject.element("picUploadArray", pathDB.split(";"));

		return jsonObject.toString();
	}

	/**
	 * 获得某个项目的图片列表
	 * 
	 * @param itemPK
	 * @return
	 */
	public String acquireItemPictureList(long itemPK) {

		Item item = itemDAO.findById(itemPK);

		if (item == null) {
			return "";
		}

		String pathDB = item.getPicture();

		if ("null".equals(pathDB) || pathDB == null)
			return "";

		JSONObject jsonObject = new JSONObject();
		jsonObject.element("picUploadArray", pathDB.split(";"));

		return jsonObject.toString();

	}

	/**
	 * 获得某个项目入账的图片列表
	 * 
	 * @param addOutlayPK
	 * @return
	 */
	public String acquireInAccountPictureList(long addOutlayPK) {

		AddOutlay addOutlay = addOutlayDAO.findById(addOutlayPK);

		if (addOutlay == null) {
			return "";
		}

		String pathDB = addOutlay.getPicture();

		if ("null".equals(pathDB) || pathDB == null)
			pathDB = "";

		JSONObject jsonObject = new JSONObject();
		jsonObject.element("picUploadArray", pathDB.split(";"));

		return jsonObject.toString();

	}

	/**
	 * 删除某个项目所有附件
	 * 
	 * @param itemPK
	 * @return
	 */
	public int deleteItemPic(long itemPK) {

		Item item = itemDAO.findById(itemPK);

		if (item == null) {
			return -1;
		}

		String pathDB = item.getPicture();
		if ("null".equals(pathDB) || pathDB == null || "".equals(pathDB))
			return 0;

		String fileDirPath = ServletActionContext.getServletContext()
				.getRealPath("/uploadImages/item/" + itemPK);
		System.out.println("删除文件:\n" + fileDirPath);

		// 删除硬盘上的实际图片文件
		File fileDir = new File(fileDirPath);
		try {
			FileUtils.deleteDirectory(fileDir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 删除数据库中附件列表
		item.setPicture("");
		itemDAO.attachDirty(item);

		return pathDB.split(";").length;
	}

	/**
	 * 删除某个项目入账的所有附件
	 * 
	 * @param itemPK
	 * @return
	 */
	public int deleteInAccountPicture(long addOutlayPK) {

		AddOutlay addOutlay = addOutlayDAO.findById(addOutlayPK);

		if (addOutlay == null) {
			return -1;
		}

		String pathDB = addOutlay.getPicture();

		if ("null".equals(pathDB) || pathDB == null || "".equals(pathDB))
			return 0;

		String fileDirPath = ServletActionContext.getServletContext()
				.getRealPath("/uploadImages/inAccount/" + addOutlayPK);
		System.out.println("删除文件:\n" + fileDirPath);

		// 删除硬盘上的实际图片文件
		File fileDir = new File(fileDirPath);
		try {
			FileUtils.deleteDirectory(fileDir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 删除数据库中附件列表
		addOutlay.setPicture("");
		addOutlayDAO.attachDirty(addOutlay);

		return pathDB.split(";").length;
	}

	public ItemDAO getItemDAO() {
		return itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public AddOutlayDAO getAddOutlayDAO() {
		return addOutlayDAO;
	}

	public void setAddOutlayDAO(AddOutlayDAO addOutlayDAO) {
		this.addOutlayDAO = addOutlayDAO;
	}

}
