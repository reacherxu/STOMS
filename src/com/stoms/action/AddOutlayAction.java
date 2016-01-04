package com.stoms.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.stoms.model.AddOutlay;
import com.stoms.model.OldAddOutlay;
import com.stoms.model.ProjectType;
import com.stoms.service.AddOutlayService;
import com.stoms.service.ItemService;
import com.stoms.service.ProjectTypeService;
import com.stoms.service.TeacherService;
import com.stoms.utils.JSONTranslation;

public class AddOutlayAction extends ActionSupport {

	// two results for all the action
	private boolean actionStatus;
	private String jsonResult;

	private long addOutlayPK;
	private String itemID;

	private String teacherName;
	private String otherTeacher;
	private Integer typePk;
	private String typeId;
	private String typeName;
	private String outlayDepartment;
	private String indirectID;
	private String cardID;
	private Double outlayValue;
	private Double remitValue;
	private String bankId;
	private int isTax;
	private Double tax1;
	private Double tax2;
	private Double tax3;
	private int isInvoice;
	private String invoiceTitle;
	private String invoiceDetail;

	// 管理費1
	private Double manage;
	// 管理費2
	private Double manage2;

	// 劳务费1
	private Double pay;
	// 劳务费2
	private Double pay2;
	// 劳务费3
	private Double pay3;

	// 业务活动费
	private Double act;
	// 改善工作条件
	private Double improve;

	// 可用管理额度
	private Double availableManageCredit;
	// 专家管理费用
	private Double consult;

	// 差旅费
	private Double travelCost;
	// 国际合作与交流
	private Double exchange;
	// 设备费
	private Double equipment;
	// 会议费
	private Double conference;

	// 院系酬金
	private Double departmentPay;
	// 入账申请审批意见
	private String other;
	// 入账申请审批状态
	private String astatus;
	// 是否申请开新卡
	private int isFirstOutlay;

	private String suggestion;
	// 新增的两个字段： 院系公共支出、课题统筹支出
	private double departmentPublic;
	private double coProject;

	private double directValue;
	private double indirectValue;

	private double performance;
	private double performance1;
	private double performance2;

	private double sumthree;

	private AddOutlayService addOutlayService;
	private ItemService itemService;
	private ProjectTypeService projectTypeService;
	private TeacherService teacherService;

	private String itemName;
	private String contractId;

	/**
	 * accquireOldAddoutlaysByAddoutlayPK
	 * 
	 * @return
	 */
	public String accquireOldAddoutlaysByAddoutlayPK() {
		String[] excludes = {};

		List list = addOutlayService.searchbyAddoutlayPk(addOutlayPK);

		if (list == null || list.size() == 0) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		String json = JSONTranslation.arrayToJson(list, excludes);
		this.actionStatus = true;
		this.jsonResult = json;
		return "success";
	}

	/**
	 * 根据addOutlayPK或itemID取得相应的入账信息
	 * 
	 * @return
	 */
	public String accquireAddOutlayByAddOutlayPKAndItemID() {

		if (this.itemID == null || this.itemID.trim().equals("")) {

			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		AddOutlay tempAddOutlay = addOutlayService
				.accquireAddOutlayByAddOutlayPKAndItemID(addOutlayPK, itemID);

		if (tempAddOutlay == null) {

			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		JSONObject jsonObject = new JSONObject();

		String currentCardID = itemService.acquireCardIDOfItemByItemID(itemID);
		if (currentCardID == null || currentCardID.trim().equals("")) {
			currentCardID = "";
		}
		jsonObject.element("currentCardID", currentCardID);

		String[] cardIDArray = null;
		List<String> cardIDs = new ArrayList<String>();

		String teacherID = itemService.acquireTeacherIdOfItemByItemID(itemID);

		if (teacherID == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		int isCross = tempAddOutlay.getIsCross();
		if (isCross == 0) {
			// 纵向,将当前的经费卡号列出来
			cardIDs.add(currentCardID);
			cardIDArray = cardIDs.toArray(new String[cardIDs.size()]);
		} else {
			// 横向 将该项目负责人的所有的横向项目的经费卡列出来

			cardIDArray = itemService.acquireCardID(teacherID);
		}
		jsonObject.element("cardIDs", cardIDArray);

		String[] excludes = {};
		String addOutlayJson = JSONTranslation.objectToJson(tempAddOutlay,
				excludes);
		if (addOutlayJson == null || addOutlayJson.trim().equals("")) {

			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		jsonObject.element("addOutlayInfo", addOutlayJson);

		// 该项目相应的项目类型信息
		int projectTypePk = tempAddOutlay.getTypePk();
		ProjectType tempProjectType = projectTypeService
				.acquireProjectTypeByProjectTypePK(projectTypePk);
		if (tempProjectType == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		addOutlayJson = JSONTranslation.objectToJson(tempProjectType, excludes);
		jsonObject.element("projectTypeInfo", addOutlayJson);

		// 所有项目类型的主键、类型ID和类型名称 信息2013-07-14（shi）
		String allProjectTypeInfo = projectTypeService
				.acquireAllProjectTypePKAndIDAndName();
		jsonObject.element("allProjectTypeInfo", allProjectTypeInfo);

		// 间接经费卡
		String tmpIndirectID = teacherService
				.acquireIndirectIDbyTeacherID(teacherID);
		jsonObject.element("indirectID", tmpIndirectID);

		this.jsonResult = jsonObject.toString();
		this.actionStatus = true;
		return "success";
	}

	/**
	 * 保存入账申请记录
	 * 
	 * @return
	 */
	// public String saveAddOutlayInfo() {
	//
	// if (itemID == null || otherTeacher == null || outlayDepartment == null
	// || cardID == null || bankId == null || invoiceTitle == null
	// || invoiceDetail == null) {
	// this.actionStatus = false;
	// this.jsonResult = "";
	// return "success";
	// }
	//
	// long tempAddOutlayPK = addOutlayService.saveAddOutlayInfo(addOutlayPK,
	// itemID, otherTeacher,typePk,typeId,typeName, outlayDepartment, cardID,
	// outlayValue,
	// remitValue, bankId, isTax, tax1, tax2, tax3, isInvoice,
	// invoiceTitle, invoiceDetail, isFirstOutlay,
	// directValue,indirectValue,performance,equipment,departmentPublic,coProject,manage);
	//
	// this.actionStatus = true;
	// this.jsonResult = "{\"addOutlayPK\":\"" + tempAddOutlayPK + "\"}";
	// return "success";
	// }

	/**
	 * 提交入账申请的记录
	 * 
	 * @return
	 */
	public String submitAddOutlayInfo() {

		if (itemID == null || otherTeacher == null || outlayDepartment == null
				|| cardID == null || bankId == null || invoiceTitle == null
				|| invoiceDetail == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		long tempAddOutlayPK = addOutlayService.submitAddOutlayInfo(
				addOutlayPK, itemID, teacherName, otherTeacher, typePk, typeId,
				typeName, outlayDepartment, cardID, outlayValue, remitValue,
				bankId, isTax, tax1, tax2, tax3, isInvoice, invoiceTitle,
				invoiceDetail, isFirstOutlay, directValue, indirectValue,
				performance, equipment, departmentPublic, coProject, manage);

		this.actionStatus = true;
		this.jsonResult = "{\"addOutlayPK\":\"" + tempAddOutlayPK + "\"}";
		return "success";
	}

	public String updateItemNameAndContractId() {
		boolean flag = true;
		List inAccountApplicationList = addOutlayService
				.acquireAllInAccountApplicationsByItemID(itemID);
		for (Object o_addoutlay : inAccountApplicationList) {
			AddOutlay addoutlay = (AddOutlay) o_addoutlay;
			flag = addOutlayService.modifyAddOutlayItemNameAndContractId(
					addoutlay, itemName, contractId);
		}
		if (flag) {
			this.actionStatus = true;
		} else {
			this.actionStatus = false;
		}
		this.jsonResult = "";
		return "success";
	}

	/**
	 * 根据itemID返回该项目的入账申请信息
	 * 
	 * @return
	 */
	public String acquireAllInAccountApplicationsByItemID() {

		if (itemID == null || itemID.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		List inAccountApplicationList = addOutlayService
				.acquireAllInAccountApplicationsByItemID(itemID);

		if (inAccountApplicationList == null
				|| inAccountApplicationList.size() == 0) {
			inAccountApplicationList = new ArrayList();
		}

		String[] excludes = {};
		String tempInAccountListInfo = JSONTranslation.arrayToJson(
				inAccountApplicationList, excludes);

		String tempItemInfo = this.itemService.acquireItemInfoByItemID(itemID);

		JSONObject jsonObject = new JSONObject();
		jsonObject.element("inAcccountListInfo", tempInAccountListInfo);
		jsonObject.element("itemInfo", tempItemInfo);

		this.jsonResult = jsonObject.toString();

		if (this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = true;
		return "success";
	}

	/**
	 * 取得所有教师已提交的待审批的入账申请列表
	 * 
	 * @return
	 */
	public String acquireAllUnAuditedInAccountApplications() {

		// 如果该入账的登记工作由管理员操作，返回由该管理员和教师端登记的入账申请信息
		HttpSession session = ServletActionContext.getRequest().getSession();
		String tmpOperatorID = (String) session.getAttribute("curr_adminID");

		List inAccountApplicationList = addOutlayService
				.acquireAllUnAuditedInAccountApplications(tmpOperatorID);

		if (inAccountApplicationList == null
				|| inAccountApplicationList.size() == 0) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		String[] excludes = {};

		this.jsonResult = JSONTranslation.arrayToJson(inAccountApplicationList,
				excludes);

		if (this.jsonResult == null || this.jsonResult.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = true;
		return "success";
	}

	/**
	 * 根据入账信息的主键addOutlayPK取得相应的入账申请信息 2222222222222222222222222222222
	 * 
	 * @return
	 */
	public String accquireAddOutlayByAddOutlayPK2() {

		AddOutlay tempAddOutlay = addOutlayService
				.accquireAddOutlayByAddOutlayPK(addOutlayPK);
		//
		List list = addOutlayService.searchbyAddoutlayPk(addOutlayPK);
		OldAddOutlay oldAddOutlay = new OldAddOutlay();
		if (list.size() > 0) {
			oldAddOutlay = (OldAddOutlay) list.get(list.size() - 1);
		} else {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		if (tempAddOutlay == null || oldAddOutlay == null) {

			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		// 在tempAddOutlay上做修改，改成tempAddOutlay-oldAddOutlay；
		//
		/*
		Double manage = tempAddOutlay.getManage() - oldAddOutlay.getManage();
		tempAddOutlay.setManage(manage);
		Double act = tempAddOutlay.getAct() - oldAddOutlay.getAct();
		tempAddOutlay.setAct(act);
		Double improve = tempAddOutlay.getImprove() - oldAddOutlay.getImprove();
		tempAddOutlay.setImprove(improve);
		Double availableManageCredit = tempAddOutlay.getAvailableManageCredit()
				- oldAddOutlay.getAvailableManageCredit();
		tempAddOutlay.setAvailableManageCredit(availableManageCredit);
		Double departmentPay = tempAddOutlay.getDepartmentPay()
				- oldAddOutlay.getDepartmentPay();
		tempAddOutlay.setDepartmentPay(departmentPay);
		Double departmentPublic = tempAddOutlay.getDepartmentPublic()
				- oldAddOutlay.getDepartmentPublic();
		tempAddOutlay.setDepartmentPublic(departmentPublic);
		Double performance1 = tempAddOutlay.getPerformance1()
				- oldAddOutlay.getPerformance1();
		tempAddOutlay.setPerformance1(performance1);
		Double manage2 = tempAddOutlay.getManage2() - oldAddOutlay.getManage2();
		tempAddOutlay.setManage2(manage2);
		Double pay = tempAddOutlay.getPay() - oldAddOutlay.getPay();
		tempAddOutlay.setPay(pay);
		Double pay2 = tempAddOutlay.getPay2() - oldAddOutlay.getPay2();
		tempAddOutlay.setPay2(pay2);
		Double consult = tempAddOutlay.getConsult() - oldAddOutlay.getConsult();
		tempAddOutlay.setConsult(consult);
		Double pay3 = tempAddOutlay.getPay3() - oldAddOutlay.getPay3();
		tempAddOutlay.setPay3(pay3);
		Double tax1 = tempAddOutlay.getTax1() - oldAddOutlay.getTax1();
		tempAddOutlay.setTax1(tax1);
		Double tax2 = tempAddOutlay.getTax2() - oldAddOutlay.getTax2();
		tempAddOutlay.setTax2(tax2);
		Double tax3 = tempAddOutlay.getTax3() - oldAddOutlay.getTax3();
		tempAddOutlay.setTax3(tax3);
		Double performance2 = tempAddOutlay.getPerformance2()
				- oldAddOutlay.getPerformance2();
		tempAddOutlay.setPerformance2(performance2);
		Double performance = tempAddOutlay.getPerformance()
				- oldAddOutlay.getPerformance();
		tempAddOutlay.setPerformance(performance);
		Double coProject = tempAddOutlay.getCoProject()
				- oldAddOutlay.getCoProject();
		tempAddOutlay.setCoProject(coProject);
		Double indirectValue = tempAddOutlay.getIndirectValue()
				- oldAddOutlay.getIndirectValue();
		tempAddOutlay.setIndirectValue(indirectValue);
		// sumone,performance2Right,sumtwo,sumthree
		*/
		String[] excludes = {};
		String addOutlayJson = JSONTranslation.objectToJson(tempAddOutlay,
				excludes);

		if (addOutlayJson == null || addOutlayJson.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		JSONObject jsonObject = new JSONObject();
		jsonObject.element("addoutlayInfo", addOutlayJson);
		
		String oldAddOutlayJson = JSONTranslation.objectToJson(oldAddOutlay,
				excludes);

		if (addOutlayJson == null || addOutlayJson.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		jsonObject.element("oldAddoutlayInfo", oldAddOutlayJson);

		// 该项目相应的项目类型信息
		int projectTypePk = tempAddOutlay.getTypePk();
		ProjectType tempProjectType = projectTypeService
				.acquireProjectTypeByProjectTypePK(projectTypePk);

		if (tempProjectType == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		addOutlayJson = JSONTranslation.objectToJson(tempProjectType, excludes);

		jsonObject.element("projectTypeInfo", addOutlayJson);

		String tempItemID = tempAddOutlay.getItemId();
		String itemYearRange = itemService.acquireYearRangeByItemID(tempItemID);
		jsonObject.element("itemYearRange", itemYearRange);

		// 间接经费卡
		String teacherID = itemService
				.acquireTeacherIdOfItemByItemID(tempItemID);
		if (teacherID == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		String tmpIndirectID = teacherService
				.acquireIndirectIDbyTeacherID(teacherID);
		jsonObject.element("indirectID", tmpIndirectID);

		this.jsonResult = jsonObject.toString();
		this.actionStatus = true;
		return "success";
	}

	/**
	 * 根据入账信息的主键addOutlayPK取得相应的入账申请信息
	 * 
	 * @return
	 */
	public String accquireAddOutlayByAddOutlayPK() {

		AddOutlay tempAddOutlay = addOutlayService
				.accquireAddOutlayByAddOutlayPK(addOutlayPK);

		if (tempAddOutlay == null) {

			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		String[] excludes = {};
		String addOutlayJson = JSONTranslation.objectToJson(tempAddOutlay,
				excludes);

		if (addOutlayJson == null || addOutlayJson.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		JSONObject jsonObject = new JSONObject();
		jsonObject.element("addoutlayInfo", addOutlayJson);

		// 该项目相应的项目类型信息
		int projectTypePk = tempAddOutlay.getTypePk();
		ProjectType tempProjectType = projectTypeService
				.acquireProjectTypeByProjectTypePK(projectTypePk);

		if (tempProjectType == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		addOutlayJson = JSONTranslation.objectToJson(tempProjectType, excludes);

		jsonObject.element("projectTypeInfo", addOutlayJson);

		String tempItemID = tempAddOutlay.getItemId();
		String itemYearRange = itemService.acquireYearRangeByItemID(tempItemID);
		jsonObject.element("itemYearRange", itemYearRange);

		// 间接经费卡
		String teacherID = itemService
				.acquireTeacherIdOfItemByItemID(tempItemID);
		if (teacherID == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		String tmpIndirectID = teacherService
				.acquireIndirectIDbyTeacherID(teacherID);
		jsonObject.element("indirectID", tmpIndirectID);

		this.jsonResult = jsonObject.toString();
		this.actionStatus = true;
		return "success";
	}

	/**
	 * 管理员入账申请的审批操作，审批通过置状态为"31"，否则为"30"
	 * 
	 * @return
	 */
	public String inAccountAuditProcess() {

		if (other == null || astatus == null || invoiceTitle == null
				|| invoiceDetail == null || cardID == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		boolean tempStatus = true;

		int isFirstAddout = addOutlayService
				.acquireIsFirstOutlayByAddOutlayPK(this.addOutlayPK);
		// 如果是新申请的则为项目ID为cardID的项目新建一个卡号
		if (isFirstAddout == 1 && cardID.trim().length() > 0
				&& this.astatus.equals("31")) {
			tempStatus = itemService.createCardForItemByItemID(cardID, cardID);
		}
		if (!tempStatus) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}
		// 当前面传来的indirectID 不为空时，创建间接经费卡。
		// 需要从item中取得teacherid，这就需要添加项目的时候把teacherid加进去，
		// 添加项目时如何确定teacherid？acquireOneTeacherInfoByTeacherNameAndDepartmentPK
		// 先完善数据表中能完善的存在 老系统的item表 只有itemName
		if (this.indirectID.trim().length() > 0) {
			// 为教师创建一个间接经费卡
			String tmpTeacherID = itemService
					.acquireTeacherIdOfItemByItemID(itemID);
			if (tmpTeacherID == null) {
				this.actionStatus = false;
				this.jsonResult = "";// 由 该项目代码 查不到对应的教师id
				return "success";
			}

			// 这里面indirectID为空时 直接跳过开间接经费卡，间接经费卡号是参数 外面传过来的
			String tmpIndirectID = teacherService
					.acquireIndirectIDbyTeacherID(tmpTeacherID);
			if ((tmpIndirectID == null || tmpIndirectID.trim().equals(""))
					&& this.astatus.equals("31") && this.indirectID != null
					&& this.indirectID.trim().length() > 0) {
				tempStatus = teacherService.createNewIndiretIDofTeacher(
						tmpTeacherID, this.indirectID);
			} else {

			}
			if (!tempStatus) {
				this.actionStatus = false;
				this.jsonResult = "";
				return "success";
			}
		}

		// 保存入账的各项数据
		AddOutlay tempAddOutlay = addOutlayService.inAccountAuditProcess(
				this.addOutlayPK, this.isTax, this.tax1, this.tax2, this.tax3,
				this.isInvoice, this.invoiceTitle, this.invoiceDetail,
				this.pay, this.pay2, this.pay3, this.manage, this.manage2,
				this.act, this.improve, this.availableManageCredit,
				this.consult, this.travelCost, this.exchange, this.equipment,
				this.conference, this.departmentPay, this.other, this.astatus,
				this.cardID, this.suggestion, this.departmentPublic,
				this.coProject, this.performance, this.performance1,
				this.performance2, this.sumthree);

		if (tempAddOutlay == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		this.actionStatus = true;
		this.jsonResult = "";
		return "success";
	}

	/**
	 * 获得itemID项目的教师的新创建的间接经费卡号
	 * 
	 * @return
	 */
	public String accquireNewCreatedIndirectID() {

		if (itemID == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		String teacherID = itemService.acquireTeacherIdOfItemByItemID(itemID);
		if (teacherID == null) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		String tmpDepartmentID = teacherService
				.acquireDepartmentIDOfTeacher(teacherID);
		if (tmpDepartmentID == null || tmpDepartmentID.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		String tmpIndirectID = teacherService.creatIndirectID(tmpDepartmentID);

		if (tmpIndirectID == null || tmpIndirectID.trim().equals("")) {
			this.actionStatus = false;
			this.jsonResult = "";
			return "success";
		}

		JSONObject jsonObject = new JSONObject();
		jsonObject.element("indirectID", tmpIndirectID);

		this.jsonResult = jsonObject.toString();
		this.actionStatus = true;

		return "success";
	}

	// setters and getters
	public boolean isActionStatus() {
		return actionStatus;
	}

	public void setActionStatus(boolean actionStatus) {
		this.actionStatus = actionStatus;
	}

	public String getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	public AddOutlayService getAddOutlayService() {
		return addOutlayService;
	}

	public void setAddOutlayService(AddOutlayService addOutlayService) {
		this.addOutlayService = addOutlayService;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public long getAddOutlayPK() {
		return addOutlayPK;
	}

	public void setAddOutlayPK(long addOutlayPK) {
		this.addOutlayPK = addOutlayPK;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getOtherTeacher() {
		return otherTeacher;
	}

	public void setOtherTeacher(String otherTeacher) {
		this.otherTeacher = otherTeacher;
	}

	public Integer getTypePk() {
		return typePk;
	}

	public void setTypePk(Integer typePk) {
		this.typePk = typePk;
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

	public String getOutlayDepartment() {
		return outlayDepartment;
	}

	public void setOutlayDepartment(String outlayDepartment) {
		this.outlayDepartment = outlayDepartment;
	}

	public String getIndirectID() {
		return indirectID;
	}

	public void setIndirectID(String indirectID) {
		this.indirectID = indirectID;
	}

	public String getCardID() {
		return cardID;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

	public Double getOutlayValue() {
		return outlayValue;
	}

	public void setOutlayValue(Double outlayValue) {
		this.outlayValue = outlayValue;
	}

	public Double getRemitValue() {
		return remitValue;
	}

	public void setRemitValue(Double remitValue) {
		this.remitValue = remitValue;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public int getIsTax() {
		return isTax;
	}

	public void setIsTax(int isTax) {
		this.isTax = isTax;
	}

	public Double getTax1() {
		return tax1;
	}

	public void setTax1(Double tax1) {
		this.tax1 = tax1;
	}

	public Double getTax2() {
		return tax2;
	}

	public void setTax2(Double tax2) {
		this.tax2 = tax2;
	}

	public Double getTax3() {
		return tax3;
	}

	public void setTax3(Double tax3) {
		this.tax3 = tax3;
	}

	public int getIsInvoice() {
		return isInvoice;
	}

	public void setIsInvoice(int isInvoice) {
		this.isInvoice = isInvoice;
	}

	public String getInvoiceTitle() {
		return invoiceTitle;
	}

	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	public String getInvoiceDetail() {
		return invoiceDetail;
	}

	public void setInvoiceDetail(String invoiceDetail) {
		this.invoiceDetail = invoiceDetail;
	}

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public Double getManage() {
		return manage;
	}

	public void setManage(Double manage) {
		this.manage = manage;
	}

	public Double getManage2() {
		return manage2;
	}

	public void setManage2(Double manage2) {
		this.manage2 = manage2;
	}

	public Double getPay() {
		return pay;
	}

	public void setPay(Double pay) {
		this.pay = pay;
	}

	public Double getPay2() {
		return pay2;
	}

	public void setPay2(Double pay2) {
		this.pay2 = pay2;
	}

	public Double getPay3() {
		return pay3;
	}

	public void setPay3(Double pay3) {
		this.pay3 = pay3;
	}

	public Double getAvailableManageCredit() {
		return availableManageCredit;
	}

	public void setAvailableManageCredit(Double availableManageCredit) {
		this.availableManageCredit = availableManageCredit;
	}

	public Double getConsult() {
		return consult;
	}

	public void setConsult(Double consult) {
		this.consult = consult;
	}

	public Double getDepartmentPay() {
		return departmentPay;
	}

	public void setDepartmentPay(Double departmentPay) {
		this.departmentPay = departmentPay;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getAstatus() {
		return astatus;
	}

	public void setAstatus(String astatus) {
		this.astatus = astatus;
	}

	public ProjectTypeService getProjectTypeService() {
		return projectTypeService;
	}

	public void setProjectTypeService(ProjectTypeService projectTypeService) {
		this.projectTypeService = projectTypeService;
	}

	public int getIsFirstOutlay() {
		return isFirstOutlay;
	}

	public void setIsFirstOutlay(int isFirstOutlay) {
		this.isFirstOutlay = isFirstOutlay;
	}

	public Double getAct() {
		return act;
	}

	public void setAct(Double act) {
		this.act = act;
	}

	public Double getImprove() {
		return improve;
	}

	public void setImprove(Double improve) {
		this.improve = improve;
	}

	public Double getTravelCost() {
		return travelCost;
	}

	public void setTravelCost(Double travelCost) {
		this.travelCost = travelCost;
	}

	public Double getExchange() {
		return exchange;
	}

	public void setExchange(Double exchange) {
		this.exchange = exchange;
	}

	public Double getEquipment() {
		return equipment;
	}

	public void setEquipment(Double equipment) {
		this.equipment = equipment;
	}

	public Double getConference() {
		return conference;
	}

	public void setConference(Double conference) {
		this.conference = conference;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public double getDepartmentPublic() {
		return departmentPublic;
	}

	public void setDepartmentPublic(double departmentPublic) {
		this.departmentPublic = departmentPublic;
	}

	public double getCoProject() {
		return coProject;
	}

	public void setCoProject(double coProject) {
		this.coProject = coProject;
	}

	public double getDirectValue() {
		return directValue;
	}

	public void setDirectValue(double directValue) {
		this.directValue = directValue;
	}

	public double getIndirectValue() {
		return indirectValue;
	}

	public void setIndirectValue(double indirectValue) {
		this.indirectValue = indirectValue;
	}

	public double getPerformance() {
		return performance;
	}

	public void setPerformance(double performance) {
		this.performance = performance;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public double getPerformance1() {
		return performance1;
	}

	public void setPerformance1(double performance1) {
		this.performance1 = performance1;
	}

	public double getPerformance2() {
		return performance2;
	}

	public void setPerformance2(double performance2) {
		this.performance2 = performance2;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public double getSumthree() {
		return sumthree;
	}

	public void setSumthree(double sumthree) {
		this.sumthree = sumthree;
	}

}
