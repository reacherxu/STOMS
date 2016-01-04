package com.stoms.model;

/**
 * AddOutlay entity. @author MyEclipse Persistence Tools
 */

public class AddOutlay implements java.io.Serializable {

	// Fields

	private Long addOutlayPk;
	private String itemId;
	private String contractId;
	private String itemName;
	private String outlayDepartment;
	private Integer typePk;
	private String typeId;
	private String typeName;
	private String teacherName;
	private String otherTeacher;
	private String departmentId;
	private String departmentName;
	private String departmentType;
	private String cardId;
	private String bankId;
	private Double outlayValue;
	private Double remitValue;
	private String other;
	private Double manage;
	private Double manage2;
	private Double pay2;
	private Double pay;
	private Double act;
	private Double improve;
	private Double consult;
	private Double availableManageCredit;
	private Double travelCost;
	private Double exchange;
	private Double equipment;
	private Double conference;
	private Double departmentPublic;
	private Double coProject;
	private Double performance1;
	private Double performance2;
	private Double sumone;
	private Double sumtwo;
	private Double sumthree;
	private Integer isCross;
	private Double departmentPay;
	private Double pay3;
	private Double tax1;
	private Double tax2;
	private Double tax3;
	private Integer isTax;
	private Integer isInvoice;
	private String invoiceTitle;
	private String invoiceDetail;
	private Integer isFirstOutlay;
	private Integer isMark;
	private String outlayTime;
	private String picture;
	private String remark;
	private String astatus;
	private Double directValue;
	private Double indirectValue;
	private Double performance;
	private String operatorId;
	
	//预算属性
	private String studyOutlay;

	private String studyOutlay_sr; //scientific research
	private String studyOutlay_sr_test;
	private String studyOutlay_sr_energy;
	private String studyOutlay_sr_meeting;
	private String studyOutlay_sr_publish;
	private String studyOutlay_sr_other;
	
	private String studyOutlay_em;//experiment material
	private String studyOutlay_em_material;
	private String studyOutlay_em_other;
	
	private String studyOutlay_ei;//experiment instrument
	private String studyOutlay_ei_purchase;
	private String studyOutlay_ei_produce;
	
	private String studyOutlay_lr;//lab reconstruct
	
	private String studyOutlay_colaborate;
	
	private String international;
	private String international_1;
	private String international_2;
	
	private String service;
	private String management;
	private String sum;

	/**  default constructor**/
	public AddOutlay() {
	}

	/** minimal constructor */
	public AddOutlay(Long addOutlayPk) {
		this.addOutlayPk = addOutlayPk;
	}

	/** full constructor */
	public AddOutlay(Long addOutlayPk, String itemId, String contractId,
			String itemName, String outlayDepartment, Integer typePk,
			String typeId, String typeName, String teacherName,
			String otherTeacher, String departmentId, String departmentName,
			String departmentType, String cardId, String bankId,
			Double outlayValue, Double remitValue, String other, Double manage,
			Double manage2, Double pay2, Double pay, Double act,
			Double improve, Double consult, Double availableManageCredit,
			Double travelCost, Double exchange, Double equipment,
			Double conference, Double departmentPublic, Double coProject,
			Double performance1, Double performance2, Double sumone,
			Double sumtwo, Double sumthree, Integer isCross,
			Double departmentPay, Double pay3, Double tax1, Double tax2,
			Double tax3, Integer isTax, Integer isInvoice, String invoiceTitle,
			String invoiceDetail, Integer isFirstOutlay, Integer isMark,
			String outlayTime, String picture, String remark, String astatus,
			Double directValue, Double indirectValue, Double performance,
			String operatorId) {
		this.addOutlayPk = addOutlayPk;
		this.itemId = itemId;
		this.contractId = contractId;
		this.itemName = itemName;
		this.outlayDepartment = outlayDepartment;
		this.typePk = typePk;
		this.typeId = typeId;
		this.typeName = typeName;
		this.teacherName = teacherName;
		this.otherTeacher = otherTeacher;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentType = departmentType;
		this.cardId = cardId;
		this.bankId = bankId;
		this.outlayValue = outlayValue;
		this.remitValue = remitValue;
		this.other = other;
		this.manage = manage;
		this.manage2 = manage2;
		this.pay2 = pay2;
		this.pay = pay;
		this.act = act;
		this.improve = improve;
		this.consult = consult;
		this.availableManageCredit = availableManageCredit;
		this.travelCost = travelCost;
		this.exchange = exchange;
		this.equipment = equipment;
		this.conference = conference;
		this.departmentPublic = departmentPublic;
		this.coProject = coProject;
		this.performance1 = performance1;
		this.performance2 = performance2;
		this.sumone = sumone;
		this.sumtwo = sumtwo;
		this.sumthree = sumthree;
		this.isCross = isCross;
		this.departmentPay = departmentPay;
		this.pay3 = pay3;
		this.tax1 = tax1;
		this.tax2 = tax2;
		this.tax3 = tax3;
		this.isTax = isTax;
		this.isInvoice = isInvoice;
		this.invoiceTitle = invoiceTitle;
		this.invoiceDetail = invoiceDetail;
		this.isFirstOutlay = isFirstOutlay;
		this.isMark = isMark;
		this.outlayTime = outlayTime;
		this.picture = picture;
		this.remark = remark;
		this.astatus = astatus;
		this.directValue = directValue;
		this.indirectValue = indirectValue;
		this.performance = performance;
		this.operatorId = operatorId;
	}
	
	/** budget constructor */
	public AddOutlay(Long addOutlayPk, String itemId, String contractId,
			String itemName, String outlayDepartment, Integer typePk,
			String typeId, String typeName, String teacherName,
			String otherTeacher, String departmentId, String departmentName,
			String departmentType, String cardId, String bankId,
			Double outlayValue, Double remitValue, String other, Double manage,
			Double manage2, Double pay2, Double pay, Double act,
			Double improve, Double consult, Double availableManageCredit,
			Double travelCost, Double exchange, Double equipment,
			Double conference, Double departmentPublic, Double coProject,
			Double performance1, Double performance2, Double sumone,
			Double sumtwo, Double sumthree, Integer isCross,
			Double departmentPay, Double pay3, Double tax1, Double tax2,
			Double tax3, Integer isTax, Integer isInvoice, String invoiceTitle,
			String invoiceDetail, Integer isFirstOutlay, Integer isMark,
			String outlayTime, String picture, String remark, String astatus,
			Double directValue, Double indirectValue, Double performance,String operatorId,
			
			String studyOutlay, String studyOutlay_sr,
			String studyOutlay_sr_test, String studyOutlay_sr_energy,
			String studyOutlay_sr_meeting, String studyOutlay_sr_publish,
			String studyOutlay_sr_other, String studyOutlay_em,
			String studyOutlay_em_material, String studyOutlay_em_other,
			String studyOutlay_ei, String studyOutlay_ei_purchase,
			String studyOutlay_ei_produce, String studyOutlay_lr,
			String studyOutlay_colaborate, String international,
			String international_1, String international_2, String service,
			String management,String sum) {
		super();
		this.addOutlayPk = addOutlayPk;
		this.itemId = itemId;
		this.contractId = contractId;
		this.itemName = itemName;
		this.outlayDepartment = outlayDepartment;
		this.typePk = typePk;
		this.typeId = typeId;
		this.typeName = typeName;
		this.teacherName = teacherName;
		this.otherTeacher = otherTeacher;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentType = departmentType;
		this.cardId = cardId;
		this.bankId = bankId;
		this.outlayValue = outlayValue;
		this.remitValue = remitValue;
		this.other = other;
		this.manage = manage;
		this.manage2 = manage2;
		this.pay2 = pay2;
		this.pay = pay;
		this.act = act;
		this.improve = improve;
		this.consult = consult;
		this.availableManageCredit = availableManageCredit;
		this.travelCost = travelCost;
		this.exchange = exchange;
		this.equipment = equipment;
		this.conference = conference;
		this.departmentPublic = departmentPublic;
		this.coProject = coProject;
		this.performance1 = performance1;
		this.performance2 = performance2;
		this.sumone = sumone;
		this.sumtwo = sumtwo;
		this.sumthree = sumthree;
		this.isCross = isCross;
		this.departmentPay = departmentPay;
		this.pay3 = pay3;
		this.tax1 = tax1;
		this.tax2 = tax2;
		this.tax3 = tax3;
		this.isTax = isTax;
		this.isInvoice = isInvoice;
		this.invoiceTitle = invoiceTitle;
		this.invoiceDetail = invoiceDetail;
		this.isFirstOutlay = isFirstOutlay;
		this.isMark = isMark;
		this.outlayTime = outlayTime;
		this.picture = picture;
		this.remark = remark;
		this.astatus = astatus;
		this.directValue = directValue;
		this.indirectValue = indirectValue;
		this.performance = performance;
		this.operatorId = operatorId;
		
		this.studyOutlay = studyOutlay;
		this.studyOutlay_sr = studyOutlay_sr;
		this.studyOutlay_sr_test = studyOutlay_sr_test;
		this.studyOutlay_sr_energy = studyOutlay_sr_energy;
		this.studyOutlay_sr_meeting = studyOutlay_sr_meeting;
		this.studyOutlay_sr_publish = studyOutlay_sr_publish;
		this.studyOutlay_sr_other = studyOutlay_sr_other;
		this.studyOutlay_em = studyOutlay_em;
		this.studyOutlay_em_material = studyOutlay_em_material;
		this.studyOutlay_em_other = studyOutlay_em_other;
		this.studyOutlay_ei = studyOutlay_ei;
		this.studyOutlay_ei_purchase = studyOutlay_ei_purchase;
		this.studyOutlay_ei_produce = studyOutlay_ei_produce;
		this.studyOutlay_lr = studyOutlay_lr;
		this.studyOutlay_colaborate = studyOutlay_colaborate;
		this.international = international;
		this.international_1 = international_1;
		this.international_2 = international_2;
		this.service = service;
		this.management = management;
		this.sum = sum;
	}

	// Property accessors

	public Long getAddOutlayPk() {
		return this.addOutlayPk;
	}

	public void setAddOutlayPk(Long addOutlayPk) {
		this.addOutlayPk = addOutlayPk;
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getContractId() {
		return this.contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getOutlayDepartment() {
		return this.outlayDepartment;
	}

	public void setOutlayDepartment(String outlayDepartment) {
		this.outlayDepartment = outlayDepartment;
	}

	public Integer getTypePk() {
		return this.typePk;
	}

	public void setTypePk(Integer typePk) {
		this.typePk = typePk;
	}

	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getOtherTeacher() {
		return this.otherTeacher;
	}

	public void setOtherTeacher(String otherTeacher) {
		this.otherTeacher = otherTeacher;
	}

	public String getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentType() {
		return this.departmentType;
	}

	public void setDepartmentType(String departmentType) {
		this.departmentType = departmentType;
	}

	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getBankId() {
		return this.bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public Double getOutlayValue() {
		return this.outlayValue;
	}

	public void setOutlayValue(Double outlayValue) {
		this.outlayValue = outlayValue;
	}

	public Double getRemitValue() {
		return this.remitValue;
	}

	public void setRemitValue(Double remitValue) {
		this.remitValue = remitValue;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public Double getManage() {
		return this.manage;
	}

	public void setManage(Double manage) {
		this.manage = manage;
	}

	public Double getManage2() {
		return this.manage2;
	}

	public void setManage2(Double manage2) {
		this.manage2 = manage2;
	}

	public Double getPay2() {
		return this.pay2;
	}

	public void setPay2(Double pay2) {
		this.pay2 = pay2;
	}

	public Double getPay() {
		return this.pay;
	}

	public void setPay(Double pay) {
		this.pay = pay;
	}

	public Double getAct() {
		return this.act;
	}

	public void setAct(Double act) {
		this.act = act;
	}

	public Double getImprove() {
		return this.improve;
	}

	public void setImprove(Double improve) {
		this.improve = improve;
	}

	public Double getConsult() {
		return this.consult;
	}

	public void setConsult(Double consult) {
		this.consult = consult;
	}

	public Double getAvailableManageCredit() {
		return this.availableManageCredit;
	}

	public void setAvailableManageCredit(Double availableManageCredit) {
		this.availableManageCredit = availableManageCredit;
	}

	public Double getTravelCost() {
		return this.travelCost;
	}

	public void setTravelCost(Double travelCost) {
		this.travelCost = travelCost;
	}

	public Double getExchange() {
		return this.exchange;
	}

	public void setExchange(Double exchange) {
		this.exchange = exchange;
	}

	public Double getEquipment() {
		return this.equipment;
	}

	public void setEquipment(Double equipment) {
		this.equipment = equipment;
	}

	public Double getConference() {
		return this.conference;
	}

	public void setConference(Double conference) {
		this.conference = conference;
	}

	public Double getDepartmentPublic() {
		return this.departmentPublic;
	}

	public void setDepartmentPublic(Double departmentPublic) {
		this.departmentPublic = departmentPublic;
	}

	public Double getCoProject() {
		return this.coProject;
	}

	public void setCoProject(Double coProject) {
		this.coProject = coProject;
	}

	public Double getPerformance1() {
		return this.performance1;
	}

	public void setPerformance1(Double performance1) {
		this.performance1 = performance1;
	}

	public Double getPerformance2() {
		return this.performance2;
	}

	public void setPerformance2(Double performance2) {
		this.performance2 = performance2;
	}

	public Double getSumone() {
		return this.sumone;
	}

	public void setSumone(Double sumone) {
		this.sumone = sumone;
	}

	public Double getSumtwo() {
		return this.sumtwo;
	}

	public void setSumtwo(Double sumtwo) {
		this.sumtwo = sumtwo;
	}

	public Double getSumthree() {
		return this.sumthree;
	}

	public void setSumthree(Double sumthree) {
		this.sumthree = sumthree;
	}

	public Integer getIsCross() {
		return this.isCross;
	}

	public void setIsCross(Integer isCross) {
		this.isCross = isCross;
	}

	public Double getDepartmentPay() {
		return this.departmentPay;
	}

	public void setDepartmentPay(Double departmentPay) {
		this.departmentPay = departmentPay;
	}

	public Double getPay3() {
		return this.pay3;
	}

	public void setPay3(Double pay3) {
		this.pay3 = pay3;
	}

	public Double getTax1() {
		return this.tax1;
	}

	public void setTax1(Double tax1) {
		this.tax1 = tax1;
	}

	public Double getTax2() {
		return this.tax2;
	}

	public void setTax2(Double tax2) {
		this.tax2 = tax2;
	}

	public Double getTax3() {
		return this.tax3;
	}

	public void setTax3(Double tax3) {
		this.tax3 = tax3;
	}

	public Integer getIsTax() {
		return this.isTax;
	}

	public void setIsTax(Integer isTax) {
		this.isTax = isTax;
	}

	public Integer getIsInvoice() {
		return this.isInvoice;
	}

	public void setIsInvoice(Integer isInvoice) {
		this.isInvoice = isInvoice;
	}

	public String getInvoiceTitle() {
		return this.invoiceTitle;
	}

	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	public String getInvoiceDetail() {
		return this.invoiceDetail;
	}

	public void setInvoiceDetail(String invoiceDetail) {
		this.invoiceDetail = invoiceDetail;
	}

	public Integer getIsFirstOutlay() {
		return this.isFirstOutlay;
	}

	public void setIsFirstOutlay(Integer isFirstOutlay) {
		this.isFirstOutlay = isFirstOutlay;
	}

	public Integer getIsMark() {
		return this.isMark;
	}

	public void setIsMark(Integer isMark) {
		this.isMark = isMark;
	}

	public String getOutlayTime() {
		return this.outlayTime;
	}

	public void setOutlayTime(String outlayTime) {
		this.outlayTime = outlayTime;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAstatus() {
		return this.astatus;
	}

	public void setAstatus(String astatus) {
		this.astatus = astatus;
	}

	public Double getDirectValue() {
		return this.directValue;
	}

	public void setDirectValue(Double directValue) {
		this.directValue = directValue;
	}

	public Double getIndirectValue() {
		return this.indirectValue;
	}

	public void setIndirectValue(Double indirectValue) {
		this.indirectValue = indirectValue;
	}

	public Double getPerformance() {
		return this.performance;
	}

	public void setPerformance(Double performance) {
		this.performance = performance;
	}

	public String getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	

	
	public String getStudyOutlay() {
		return studyOutlay;
	}

	public void setStudyOutlay(String studyOutlay) {
		this.studyOutlay = studyOutlay;
	}

	public String getStudyOutlay_sr() {
		return studyOutlay_sr;
	}

	public void setStudyOutlay_sr(String studyOutlay_sr) {
		this.studyOutlay_sr = studyOutlay_sr;
	}

	public String getStudyOutlay_sr_test() {
		return studyOutlay_sr_test;
	}

	public void setStudyOutlay_sr_test(String studyOutlay_sr_test) {
		this.studyOutlay_sr_test = studyOutlay_sr_test;
	}

	public String getStudyOutlay_sr_energy() {
		return studyOutlay_sr_energy;
	}

	public void setStudyOutlay_sr_energy(String studyOutlay_sr_energy) {
		this.studyOutlay_sr_energy = studyOutlay_sr_energy;
	}

	public String getStudyOutlay_sr_meeting() {
		return studyOutlay_sr_meeting;
	}

	public void setStudyOutlay_sr_meeting(String studyOutlay_sr_meeting) {
		this.studyOutlay_sr_meeting = studyOutlay_sr_meeting;
	}

	public String getStudyOutlay_sr_publish() {
		return studyOutlay_sr_publish;
	}

	public void setStudyOutlay_sr_publish(String studyOutlay_sr_publish) {
		this.studyOutlay_sr_publish = studyOutlay_sr_publish;
	}

	public String getStudyOutlay_sr_other() {
		return studyOutlay_sr_other;
	}

	public void setStudyOutlay_sr_other(String studyOutlay_sr_other) {
		this.studyOutlay_sr_other = studyOutlay_sr_other;
	}

	public String getStudyOutlay_em() {
		return studyOutlay_em;
	}

	public void setStudyOutlay_em(String studyOutlay_em) {
		this.studyOutlay_em = studyOutlay_em;
	}

	public String getStudyOutlay_em_material() {
		return studyOutlay_em_material;
	}

	public void setStudyOutlay_em_material(String studyOutlay_em_material) {
		this.studyOutlay_em_material = studyOutlay_em_material;
	}

	public String getStudyOutlay_em_other() {
		return studyOutlay_em_other;
	}

	public void setStudyOutlay_em_other(String studyOutlay_em_other) {
		this.studyOutlay_em_other = studyOutlay_em_other;
	}

	public String getStudyOutlay_ei() {
		return studyOutlay_ei;
	}

	public void setStudyOutlay_ei(String studyOutlay_ei) {
		this.studyOutlay_ei = studyOutlay_ei;
	}

	public String getStudyOutlay_ei_purchase() {
		return studyOutlay_ei_purchase;
	}

	public void setStudyOutlay_ei_purchase(String studyOutlay_ei_purchase) {
		this.studyOutlay_ei_purchase = studyOutlay_ei_purchase;
	}

	public String getStudyOutlay_ei_produce() {
		return studyOutlay_ei_produce;
	}

	public void setStudyOutlay_ei_produce(String studyOutlay_ei_produce) {
		this.studyOutlay_ei_produce = studyOutlay_ei_produce;
	}

	public String getStudyOutlay_lr() {
		return studyOutlay_lr;
	}

	public void setStudyOutlay_lr(String studyOutlay_lr) {
		this.studyOutlay_lr = studyOutlay_lr;
	}

	public String getStudyOutlay_colaborate() {
		return studyOutlay_colaborate;
	}

	public void setStudyOutlay_colaborate(String studyOutlay_colaborate) {
		this.studyOutlay_colaborate = studyOutlay_colaborate;
	}

	public String getInternational() {
		return international;
	}

	public void setInternational(String international) {
		this.international = international;
	}

	public String getInternational_1() {
		return international_1;
	}

	public void setInternational_1(String international_1) {
		this.international_1 = international_1;
	}

	public String getInternational_2() {
		return international_2;
	}

	public void setInternational_2(String international_2) {
		this.international_2 = international_2;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getManagement() {
		return management;
	}

	public void setManagement(String management) {
		this.management = management;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

}