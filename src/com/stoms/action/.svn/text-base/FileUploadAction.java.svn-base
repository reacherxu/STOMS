package com.stoms.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.model.AddOutlay;
import com.stoms.model.Department;
import com.stoms.model.Item;
import com.stoms.service.AddOutlayService;
import com.stoms.service.DepartmentService;
import com.stoms.service.FileUploadService;
import com.stoms.service.ItemService;
import com.stoms.utils.ExcelOperate;
import com.stoms.utils.JSONTranslation;
import com.stoms.utils.PdfFile;
import com.stoms.utils.PdfFile2;

public class FileUploadAction extends ActionSupport {

	private String jsonResult;
	private boolean actionStatus;

	private String Filedata; // struts2中已经把上传的文件保存在了这个路径的临时文件中

	private String Filename;

	private Long itemPK;
	private String flag;

	private long addOutlayPK;

	private FileUploadService fileUploadService;
	private DepartmentService departmentService;
	private AddOutlayService addOutlayService;
	private ItemService itemService;

	public String fileUpload() {

		jsonResult = "";
		try {

			// 文件相对地址 用于网页引用显示
			String dbFilePath = "STOMS_FileData_temp/" + flag;

			// 文件具体保存的本地地址 一般以盘符开头
			String filePath = ServletActionContext.getServletContext()
					.getRealPath(dbFilePath);

			// System.out.println( filePath );

			if (Filedata != null) {

				// 上传的时候文件是保存在临时文件夹中 拷贝到对应的保存地址
				File fileFrom = new File(Filedata);
				File fileToCreate = new File(filePath);
				FileUtils.copyFile(fileFrom, fileToCreate);

				// 保存一份同样的文件到d盘
				String filePathBackup = "d:/" + dbFilePath;
				File fileBackup = new File(filePathBackup);
				FileUtils.copyFile(fileFrom, fileBackup);

				// 文件地址保存到数据库
				// jsonResult = fileUploadService.addItemPictureInfo(itemPK,
				// dbFilePath);
				jsonResult = "";
			}

			actionStatus = true;
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());

			actionStatus = false;
		}
		return "success";
	}

	/**
	 * 获取国家自然科学基金的数据
	 * 
	 * @return
	 */
	public String getDataToForm() {
		jsonResult = "";
		PdfFile pf = new PdfFile();
		try {
			AddOutlay addoutlay = pf.getData("d:/STOMS_FileData_temp/",
					"GuoJia.pdf");
			Department department = new Department();
			department = departmentService
					.acquireOneDepartmentInfoByName(addoutlay
							.getDepartmentName());
			System.out.println("DepartmentID yes:"
					+ department.getDepartmentId());
			addoutlay.setDepartmentId(department.getDepartmentId());
			actionStatus = true;
			String[] excludes = {};
			jsonResult = JSONTranslation.objectToJson(addoutlay, excludes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			actionStatus = false;
		}
		return "success";
	}

	/**
	 * 获取省基金的数据
	 * 
	 * @return
	 */
	public String getDataToForm2() {
		jsonResult = "";
		PdfFile2 pf = new PdfFile2();
		try {
			AddOutlay addoutlay = pf.getData("d:/STOMS_FileData_temp/",
					"Sheng.pdf");
			Department department = null;
			department = departmentService
					.acquireOneDepartmentInfoByName(addoutlay
							.getDepartmentName());
			if(department != null){
				addoutlay.setDepartmentId(department.getDepartmentId());
				addoutlay.setDepartmentType(department.getDepartmentType());
			}
			actionStatus = true;
			String[] excludes = {};
			jsonResult = JSONTranslation.objectToJson(addoutlay, excludes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			actionStatus = false;
		}
		return "success";
	}
	/**
	 * 获取省基金的数据
	 * 二次
	 * @return
	 */
	public String getDataToForm22() {
		jsonResult = "";
		PdfFile2 pf = new PdfFile2();
		try {
			AddOutlay addoutlay = pf.getData("d:/STOMS_FileData_temp/",
					"TwiceSheng.pdf");
			//设置itemID
			List items = itemService.getItemDAO().findByContractId(addoutlay.getContractId());
			if(items.size() <= 0){
				actionStatus = false;
				return "success";
			}
			Item item = (Item)items.get(0);
			addoutlay.setItemId(item.getItemId());
			//设置院系ID，院系类型
			Department department = new Department();
			department = departmentService
					.acquireOneDepartmentInfoByName(addoutlay
							.getDepartmentName());
			addoutlay.setDepartmentId(department.getDepartmentId());
			addoutlay.setDepartmentType(department.getDepartmentType());
			
			actionStatus = true;
			String[] excludes = {};
			jsonResult = JSONTranslation.objectToJson(addoutlay, excludes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			actionStatus = false;
		}
		return "success";
	}

	/**
	 * 国家基金二次进账
	 * 
	 * @return
	 */
	public String stateFundTwiceAdd() throws Exception {
		jsonResult = "";
		ArrayList<AddOutlay> addoutlays = new ArrayList<AddOutlay>();
		addoutlays = new ExcelOperate().getData("d:/STOMS_FileData_temp/", "Twice.xls");
		// 循环，对每一个addoutlay，根据合同号，查出它的项目ID，
		// 根据项目ID，查出该项目的上一次addoutlay，要：项目类型，项目类型的额度
		// 然后入账：“自然基金”，teacherName，outlayValue
		// 项目类型和上一笔相同，额度根据项目类型算出来。入账时间，操作员设置一下就OK了。
		List<AddOutlay> wrongAdd = new ArrayList<AddOutlay>();
		for (AddOutlay addoutlay : addoutlays) {
			// 由ItemId得到addoutlay1。--开始
//			String itemID = "";
//			itemID = addoutlay.getItemId();
//			if (itemID.trim().length() < 0) {
//				wrongAdd.add(addoutlay);// 这个项目ID是空的，放入wrongAdd
//				continue;
//			}
//			List addoutlay1s = addOutlayService.getAddOutlayDAO().findByItemId(
//					itemID);
//			AddOutlay addoutlay1 = new AddOutlay();
//			if (addoutlay1s.size() > 0) {// 如果根据项目ID能查出addoutlay1
//				addoutlay1 = (AddOutlay) addoutlay1s.get(0);
//			} else {
//				wrongAdd.add(addoutlay);// 这个项目ID没有入账过，放入wrongAdd
//				continue;
//			}
			// 由contractId得到itemID。--结束
			
			List items = itemService.getItemDAO().findByContractId(
					addoutlay.getContractId());
			if (items.size() <= 0) {
				wrongAdd.add(addoutlay);// 这个项目ID是空的，放入wrongAdd
				continue;
			}
			String itemID = "";
			itemID = ((Item)items.get(0)).getItemId();
			List addoutlay1s = addOutlayService.getAddOutlayDAO().findByItemId(
					itemID);
			AddOutlay addoutlay1 = new AddOutlay();
			if (addoutlay1s.size() > 0) {// 如果根据ContractId能查出addoutlay1
				addoutlay1 = (AddOutlay) addoutlay1s.get(0);
			} else {
				wrongAdd.add(addoutlay);// 这个项目ID没有入账过，放入wrongAdd
				continue;
			}
			
			
			String teacherName = addoutlay.getTeacherName();
			String otherTeacher = "";
			int typePk = addoutlay1.getTypePk();// 怎么搞
			String typeId = addoutlay1.getTypeId();
			String typeName = addoutlay1.getTypeName();
			String outlayDepartment = addoutlay1.getOutlayDepartment();
			String cardID = itemID;
			Double outlayValue = addoutlay.getOutlayValue()*10000;// 单位是万
			Double remitValue = 0.0;
			String bankId = "";
			int isTax = 0;
			Double tax1 = 0.0;
			Double tax2 = 0.0;
			Double tax3 = 0.0;
			int isInvoice = 0;
			String invoiceTitle = "";
			String invoiceDetail = "";
			int isFirstOutlay = 0;
			Double directValue = 0.0;//
			Double indirectValue = 0.0;
			Double performance = 0.0;
			Double equipment = 0.0;
			Double departmentPublic = 0.0;
			Double coProject = 0.0;
			Double manage = 0.0;
			long addooutlaypk = addOutlayService
					.submitAddOutlayInfo(0, itemID, teacherName, otherTeacher,
							typePk, typeId, typeName, outlayDepartment, cardID,
							outlayValue, remitValue, bankId, isTax, tax1, tax2,
							tax3, isInvoice, invoiceTitle, invoiceDetail,
							isFirstOutlay, directValue, indirectValue,
							performance, equipment, departmentPublic,
							coProject, manage);

			Double pay2 = 0.0;
			Double manage2 = 0.0;
			Double improve = 0.0;

			// 管理费1，管理费2，劳务费2，改善工作条件费。
			// manage,manage2,pay2,improve
			manage = outlayValue*0.03;
			manage2 = outlayValue*0.02;
			if(typePk == 66 || typePk == 67){
				pay2 = outlayValue*0.15;
			}else if(typePk == 68 || typePk == 69){
				pay2 = outlayValue*0.1;
			}
			improve = outlayValue*0.05;
			// 可用管理额度
			Double availableManageCredit = 0.0;

			AddOutlay tempAddOutlay = addOutlayService.inAccountAuditProcess(
					addooutlaypk, isTax, tax1, tax2, tax3, isInvoice,
					invoiceTitle, invoiceDetail, 0.00, pay2, 0.0, manage,
					manage2, 0.00, improve, availableManageCredit, -1.0, 0.0,
					0.0, equipment, 0.0, 0.0, "", "31", cardID, "",
					departmentPublic, coProject, performance, 0.0, 0.0, 0.0);
			System.out.println(tempAddOutlay.getItemId());
		}
		String[] ex = {};
		jsonResult = JSONTranslation.arrayToJson(wrongAdd,ex );
		actionStatus = true;
		
		return "success";
	}

	public String inAccountFileUpload() {

		jsonResult = "";

		try {

			// 文件相对地址 用于网页引用显示
			String dbFilePath = "uploadImages/inAccount/" + addOutlayPK + "/"
					+ Calendar.getInstance().getTimeInMillis() + "__1__"
					+ Filename;

			// 文件具体保存的本地地址 一般以盘符开头
			String filePath = ServletActionContext.getServletContext()
					.getRealPath(dbFilePath);

			// System.out.println( filePath );

			if (Filedata != null) {

				// 上传的时候文件是保存在临时文件夹中 拷贝到对应的保存地址
				File fileFrom = new File(Filedata);
				File fileToCreate = new File(filePath);
				FileUtils.copyFile(fileFrom, fileToCreate);

				// 保存一份同样的文件到d盘
				String filePathBackup = "d:/" + dbFilePath;
				File fileBackup = new File(filePathBackup);
				FileUtils.copyFile(fileFrom, fileBackup);

				// 文件地址保存到数据库
				jsonResult = fileUploadService.addInAccountPictureInfo(
						addOutlayPK, dbFilePath);

			}

			actionStatus = true;
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());

			actionStatus = false;
		}

		return "success";
	}

	public String acquireItemPictureList() {

		jsonResult = fileUploadService.acquireItemPictureList(itemPK);
		actionStatus = true;
		return "success";
	}

	public String acquireInAccountPictureList() {

		jsonResult = fileUploadService.acquireInAccountPictureList(addOutlayPK);
		actionStatus = true;
		return "success";
	}

	public String deleteItemPic() {

		jsonResult = String.valueOf(fileUploadService.deleteItemPic(itemPK));
		actionStatus = true;
		return "success";
	}

	public String deleteInAccountPicture() {

		jsonResult = String.valueOf(fileUploadService
				.deleteInAccountPicture(addOutlayPK));
		actionStatus = true;
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

	public String getFiledata() {
		return Filedata;
	}

	public void setFiledata(String filedata) {
		Filedata = filedata;
	}

	public String getFilename() {
		return Filename;
	}

	public void setFilename(String filename) {
		Filename = filename;
	}

	public Long getItemPK() {
		return itemPK;
	}

	public void setItemPK(Long itemPK) {
		this.itemPK = itemPK;
	}

	public FileUploadService getFileUploadService() {
		return fileUploadService;
	}

	public void setFileUploadService(FileUploadService fileUploadService) {
		this.fileUploadService = fileUploadService;
	}

	public long getAddOutlayPK() {
		return addOutlayPK;
	}

	public void setAddOutlayPK(long addOutlayPK) {
		this.addOutlayPK = addOutlayPK;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public AddOutlayService getAddOutlayService() {
		return addOutlayService;
	}

	public void setAddOutlayService(AddOutlayService addOutlayService) {
		this.addOutlayService = addOutlayService;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

}