//全局变量，项目的内部编码
var itemIdentifer = "";

$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"项目查询",
	                	"href":""
	                 },
	                 {
		                	"name":"入账审核",
		                	"href":"Page/Admin/projectAudit/inAccountAuditList.jsp"
		                 },
	                 {
	                	"name":"入账信息",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	if(addOutlayPK == undefined || addOutlayPK == null || addOutlayPK == "") {
		addOutlayPK = "0";
	}
	
	$("#taxCheck").change(function(event){
		
		var isDisabled = !(this.checked);
		$("#tax1")[0].disabled = isDisabled;
		$("#tax2")[0].disabled = isDisabled;
		$("#tax3")[0].disabled = isDisabled;
	  });
	
	$("#invoiceCheck").change(function(event){
		
		var isDisabled = !(this.checked);
		$("#invoiceTitle")[0].disabled = isDisabled;
		$("#invoiceDetail")[0].disabled = isDisabled;
	  });
	
	$("#inAccountApplicationForm").validationEngine("attach");
	//点击审批通过按钮时的响应事件
    $("#inAccountAuditApproveButton").click(function(check) {
        if($("#inAccountApplicationForm").validationEngine('validate')){
        	
        	var inAccountInfo = accquireInAccountFormData();
        	
        	inAccountInfo["astatus"] = "31";
        	
        	if(inAccountInfo.cardID == null || inAccountInfo.cardID.length == 0) {
        		openGeneralMessageDialog("经费卡卡号为空，请同意申请开卡！");
        		return false;
        	}
        	
        	if(inAccountInfo.indirectID == null || inAccountInfo.indirectID.length == 0) {
        		openGeneralMessageDialog("间接经费卡卡号为空，请同意申请开卡！");
        		return false;
        	}
        	
        	
        	generalAjaxCallToLoadData("inAccountAuditProcess.action", inAccountInfo, showInAccountAuditApprovedResult);
        }
        check.preventDefault();//此处阻止提交表单 
    });
    
	//点击审批未通过按钮时的响应事件
    $("#inAccountAuditRejectButton").click(function(check) {
        if($("#inAccountApplicationForm").validationEngine('validate')){
        	
        	var inAccountInfo = accquireInAccountFormData();
        	
        	inAccountInfo["astatus"] = "30";
        	generalAjaxCallToLoadData("inAccountAuditProcess.action", inAccountInfo, showInAccountAuditRejectResult);
        }
        check.preventDefault();//此处阻止提交表单 
    });
    
	
	//取得页面的基本信息然后回显
	var tempSubmitData = {"addOutlayPK":addOutlayPK};
	generalAjaxCallToLoadData("accquireAddOutlayByAddOutlayPK.action", tempSubmitData, initializePageContent);
	
	//载入当前项目入账信息的附件列表
	refreshPicList();
});


//初始化页面，并回显入账内容
function initializePageContent(data) {
	
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	
	console.log(data.jsonResult);
	var inAccountInfo = data.jsonResult.addoutlayInfo;
	var projectTypeInfo = data.jsonResult.projectTypeInfo;
	var indirectID = data.jsonResult.indirectID;
	
	itemIdentifer = inAccountInfo.itemId;
	//回显各个税额比例
	renderAllProportionLabels(projectTypeInfo);
	
	//回显入账申请的信息
	$("#itemName").html(inAccountInfo.itemName);
	$("#contractID").html(inAccountInfo.contractId);
	$("#teacherName").html(inAccountInfo.teacherName);
	$("#otherTeacherName").html(inAccountInfo.otherTeacher);
	$("#inAccountDepartment").html(inAccountInfo.outlayDepartment);
	$("#bankID").html(inAccountInfo.bankId);
	
	$("#indirectID").html(indirectID);
	if(indirectID != undefined && indirectID != null && indirectID.length > 0) {
		$("#approveCreatingIndirectCardButton").remove();
	}
	
	var tempCardID = inAccountInfo.cardId;
	$("#cardID").html(tempCardID);
	if(tempCardID != undefined && tempCardID != null && tempCardID.length > 0) {
		$("#approveCreatingNewCardButton").remove();
	}
	
	$("#outlayValue").html(inAccountInfo.outlayValue);
	$("#remitValue").html(inAccountInfo.remitValue);
	
	if(inAccountInfo.isTax == 1) {
		$("#taxCheck")[0].checked = true;
		$("#tax1")[0].disabled = false;
		$("#tax2")[0].disabled = false;
		$("#tax3")[0].disabled = false;
	}
	$("#tax1").val(inAccountInfo.tax1);
	$("#tax2").val(inAccountInfo.tax2);
	$("#tax3").val(inAccountInfo.tax3);
	
	if(inAccountInfo.isInvoice == 1) {
		$("#invoiceCheck")[0].checked = true;
		$("#invoiceTitle")[0].disabled = false;
		$("#invoiceDetail")[0].disabled = false;
	}
	$("#invoiceTitle").val(inAccountInfo.invoiceTitle);
	$("#invoiceDetail").val(inAccountInfo.invoiceDetail);
	
	$("#DirectValue").html(inAccountInfo.directValue);
	$("#IndirectValue").html(inAccountInfo.indirectValue);

	$("#Performance").val(inAccountInfo.performance);
	$("#equipment").val(inAccountInfo.equipment);
	$("#Manage").val(inAccountInfo.manage);	
	$("#departmentPublic").val(inAccountInfo.departmentPublic);
	$("#coProject").val(inAccountInfo.coProject);	
	
	//自动计算自行确定费用部分和横向项目管理费显示
	autoCalculateSelfSettingFee(inAccountInfo.outlayValue, inAccountInfo.remitValue, projectTypeInfo, inAccountInfo.isCross);
	
}

//修改费用响应事件
function modifyProportion(){
	
	var outlayValue = getLabelWidgetValue("outlayValue");
	var remitValue = getLabelWidgetValue("remitValue");
	var Value = outlayValue - remitValue;
	
	renderProportionLabel("payProportionLabel", getNumberInputWidgetValue("pay")/Value);
	renderProportionLabel("manageProportionLabel", getNumberInputWidgetValue("Manage")/Value);
	renderProportionLabel("pay2ProportionLabel", getNumberInputWidgetValue("pay2")/Value);
	renderProportionLabel("manage2ProportionLabel", getNumberInputWidgetValue("Manage2")/Value);
	renderProportionLabel("actProportionLabel", getNumberInputWidgetValue("Act")/Value);
	renderProportionLabel("improveProportionLabel", getNumberInputWidgetValue("Improve")/Value);
	renderProportionLabel("availableManageCreditProportionLabel", getNumberInputWidgetValue("AvailableManageCredit")/Value);
	renderProportionLabel("consultProportionLabel", getNumberInputWidgetValue("Consult")/Value);
	renderProportionLabel("travelCostProportionLabel", getNumberInputWidgetValue("travelCost")/Value);
	renderProportionLabel("exchangeProportionLabel", getNumberInputWidgetValue("exchange")/Value);
	renderProportionLabel("equipmentProportionLabel", getNumberInputWidgetValue("equipment")/Value);
	renderProportionLabel("conferenceProportionLabel", getNumberInputWidgetValue("conference")/Value);
	renderProportionLabel("departmentPayProportionLabel", getNumberInputWidgetValue("DepartmentPay")/outlayValue);
	renderProportionLabel("pay3ProportionLabel", getNumberInputWidgetValue("pay3")/outlayValue);
	renderProportionLabel("tax1ProportionLabel", getNumberInputWidgetValue("tax1")/outlayValue);
	renderProportionLabel("tax2ProportionLabel", getNumberInputWidgetValue("tax2")/outlayValue);
	renderProportionLabel("tax3ProportionLabel", getNumberInputWidgetValue("tax3")/outlayValue);	
	//add two new DepartmentPublic,CoProject
	renderProportionLabel("departmentPublicProportionLabel", getNumberInputWidgetValue("departmentPublic")/Value);
	renderProportionLabel("coProjectProportionLabel", getNumberInputWidgetValue("coProject")/Value);	
	
}

//获取入账申请表单信息
function accquireInAccountFormData() {
	var inAccountInfo = {};
	
	inAccountInfo["addOutlayPK"] = addOutlayPK;
	inAccountInfo["itemID"] = itemIdentifer;
	
	var indirectIDLabelContent = $("#indirectID").html();
	inAccountInfo["indirectID"] = $.trim(indirectIDLabelContent);
	
	var cardIDLabelContent = $("#cardID").html();
	inAccountInfo["cardID"] = $.trim(cardIDLabelContent);
	
	inAccountInfo["pay"] = getNumberInputWidgetValue("pay");
	inAccountInfo["manage"] = getNumberInputWidgetValue("Manage");
	inAccountInfo["pay2"] = getNumberInputWidgetValue("pay2");
	inAccountInfo["manage2"] = getNumberInputWidgetValue("Manage2");
	inAccountInfo["act"] = getNumberInputWidgetValue("Act");
	inAccountInfo["improve"] = getNumberInputWidgetValue("Improve");
	inAccountInfo["availableManageCredit"] = getNumberInputWidgetValue("AvailableManageCredit");
	inAccountInfo["consult"] = getNumberInputWidgetValue("Consult");
	inAccountInfo["travelCost"] = getNumberInputWidgetValue("travelCost");
	inAccountInfo["exchange"] = getNumberInputWidgetValue("exchange");
	inAccountInfo["equipment"] = getNumberInputWidgetValue("equipment");
	inAccountInfo["conference"] = getNumberInputWidgetValue("conference");
	
	//add two new DepartmentPublic,CoProject
	inAccountInfo["departmentPublic"] = getNumberInputWidgetValue("departmentPublic");
	inAccountInfo["coProject"] = getNumberInputWidgetValue("coProject");
	inAccountInfo["performance"] = getNumberInputWidgetValue("Performance");
	
	
	
	if($("#DepartmentPay")[0].disabled) {
		inAccountInfo["departmentPay"] = 0;
		inAccountInfo["pay3"] = 0;
	} else {
		inAccountInfo["departmentPay"] = getNumberInputWidgetValue("DepartmentPay");
		inAccountInfo["pay3"] = getNumberInputWidgetValue("pay3");
	}
	
	var isTaxChecked = $("#taxCheck")[0].checked;
	if(isTaxChecked) {
		inAccountInfo["isTax"] = 1;
		inAccountInfo["tax1"] = getNumberInputWidgetValue("tax1");
		inAccountInfo["tax2"] = getNumberInputWidgetValue("tax2");
		inAccountInfo["tax3"] = getNumberInputWidgetValue("tax3");
	} else {
		inAccountInfo["isTax"] = 0;
		inAccountInfo["tax1"] = 0;
		inAccountInfo["tax2"] = 0;
		inAccountInfo["tax3"] = 0;
	}
	
	var isInvoiceChecked = $("#invoiceCheck")[0].checked;
	if(isInvoiceChecked) {
		inAccountInfo["isInvoice"] = 1;
		inAccountInfo["invoiceTitle"] = getStringInputWidgetValue("invoiceTitle");
		inAccountInfo["invoiceDetail"] = getStringInputWidgetValue("invoiceDetail");
	} else {
		inAccountInfo["isInvoice"] = 0;
		inAccountInfo["invoiceTitle"] = "";
		inAccountInfo["invoiceDetail"] = "";
	}
	
	inAccountInfo["other"] = getStringInputWidgetValue("other");
	
	var suggestion = $("#suggestion").val();
	inAccountInfo["suggestion"] = suggestion;
	
	
	return inAccountInfo;
}

//显示保存入账申请通过结果信息
function showInAccountAuditApprovedResult(data) {
	
	if(!data.actionStatus) {
		openGeneralMessageDialog("审批通过 操作失败，请重试！");
		return false;
	}
	
	openGeneralAssureDialogAndGoBack("审批通过 操作成功，需要打印么？", openInAccountPrintPage, {});
}

//打开入账信息打印页面
function openInAccountPrintPage(parameter) {
	
	var detailInfoUrl = "";
	detailInfoUrl = "Page/Teacher/inAccountApplication/inAccountPrint.jsp?addOutlayPK=" + addOutlayPK + "&itemID=0";
	
	window.open(detailInfoUrl);
	
}
//显示保存入账申请未通过结果信息
function showInAccountAuditRejectResult(data) {
	if(!data.actionStatus) {
		openGeneralMessageDialog("审批未通过 操作失败，请重试！");
		return false;
	}
	
	openGeneralMessageDialogThenGoBack("审批未通过 操作成功！");
}

//得到数值输入框的值
function getNumberInputWidgetValue(widgetID) {
	
	var tempValue = 0;
	
	if($("#" + widgetID).val() != "") {
		tempValue = $("#" + widgetID).val();
	}
	
	if(isNaN(parseInt(tempValue))) {
		return parseInt("0", 10);
	}
	
	return parseInt(tempValue, 10);
}

//得到字符输入框的值
function getStringInputWidgetValue(widgetID) {
	
	var tempValue = "";
	
	tempValue = $("#" + widgetID).val();
	
	tempValue = $.trim(tempValue);
	
	return tempValue;
}

function getLabelWidgetValue(widgetID) {
	
	var tempValue = 0;
	
	if($("#" + widgetID).html() != "") {
		tempValue = $("#" + widgetID).html();
	}
	
	if(isNaN(parseInt(tempValue, 10))) {
		return parseInt("0");
	}
	
	return parseInt(tempValue);
}

//同意开间接经费卡
function approveCreatingIndirectCard() {
	
	var tempSubmitData = {"itemID":itemIdentifer};
	$("#approveCreatingIndirectCardButton")[0].disabled = true;
	generalAjaxCallToLoadData("accquireNewCreatedIndirectID.action", tempSubmitData, showNewCreatedIndirectID);
	
}

function showNewCreatedIndirectID(data) {
	
	if(!data.actionStatus) {
		console.log("error!");
		$("#approveCreatingIndirectCardButton")[0].disabled = false;
		return false;
	}
	
	var newIndirectID = data.jsonResult.indirectID;
	$("#indirectID").html(newIndirectID);
	
	
}

//同意开新经费卡
function approveCreatingNewCard() {
	
	$("#cardID").html(itemIdentifer);
	$("#approveCreatingNewCardButton")[0].disabled = true;
}


//回显所有的税费比例
function renderAllProportionLabels(projectTypeInfo) {
	
	renderProportionLabel("payProportionLabel", projectTypeInfo.ppay);
	renderProportionLabel("manageProportionLabel", projectTypeInfo.pmanage);
	renderProportionLabel("pay2ProportionLabel", projectTypeInfo.ppay2);
	renderProportionLabel("manage2ProportionLabel", projectTypeInfo.pmanage2);
	renderProportionLabel("actProportionLabel", projectTypeInfo.pact);
	renderProportionLabel("improveProportionLabel", projectTypeInfo.pimprove);
	renderProportionLabel("availableManageCreditProportionLabel", projectTypeInfo.pavailableManageCredit);
	renderProportionLabel("consultProportionLabel", projectTypeInfo.pconsult);
	renderProportionLabel("travelCostProportionLabel", projectTypeInfo.ptravelCost);
	renderProportionLabel("exchangeProportionLabel", projectTypeInfo.pexchange);
	renderProportionLabel("equipmentProportionLabel", projectTypeInfo.pequipment);
	renderProportionLabel("conferenceProportionLabel", projectTypeInfo.pconference);
	renderProportionLabel("departmentPayProportionLabel", projectTypeInfo.pdepartmentPay);
	renderProportionLabel("pay3ProportionLabel", projectTypeInfo.ppay3);
	renderProportionLabel("tax1ProportionLabel", projectTypeInfo.ptax1);
	renderProportionLabel("tax2ProportionLabel", projectTypeInfo.ptax2);
	renderProportionLabel("tax3ProportionLabel", projectTypeInfo.ptax3);
	//增加的两个字段：院系公共支出、课题统筹支出
	renderProportionLabel("departmentPublicProportionLabel", projectTypeInfo.departmentPublic);
	renderProportionLabel("coProjectProportionLabel", projectTypeInfo.coProject);
}

//回显各种税的比例
function renderProportionLabel(labelID, proportion){
	
	var labelContent = "";
	
	if(proportion == -1) {
		labelContent = "( * )";		
	}
	else{
	proportion = parseFloat(proportion * 100).toFixed(2);
	labelContent = "(" + proportion + "%)";
	}
	$("#" + labelID).html(labelContent);
}


//自动计算各种自行确定的费用和横向项目管理费显示
function autoCalculateSelfSettingFee(inAccount, remitValue, projectTypeInfo, isCrossItem) {
	
	if(inAccount <= 0) {
		$("#pay").val(0);
		$("#Manage").val(0);
		$("#pay2").val(0);
		$("#Manage2").val(0);
		$("#Act").val(0);
		$("#Improve").val(0);
		$("#AvailableManageCredit").val(0);
		$("#Consult").val(0);
		$("#travelCost").val(0);
		$("#exchange").val(0);
		$("#equipment").val(0);
		$("#conference").val(0);
		$("#departmentPublic").val(0);
		$("#coProject").val(0);
		$("#DepartmentPay").val(0);
		$("#pay3").val(0);
		
		
	} else {
		
		var inAccountAfter = inAccount - remitValue;
		var tempPpay = inAccountAfter * projectTypeInfo.ppay;
		tempPpay = parseInt(tempPpay, 10);
		if(projectTypeInfo.ppay == -1){
			tempPpay = 0;
			
		}
		$("#pay").val(tempPpay);
		
		/*
		var tempPmanage = inAccountAfter * projectTypeInfo.pmanage;
		tempPmanage = parseInt(tempPmanage, 10);
		if(projectTypeInfo.pmanage == -1){
			tempPmanage = 0;
			
		}
		$("#Manage").val(tempPmanage);
		*/
		var tempPpay2 = inAccountAfter * projectTypeInfo.ppay2;
		tempPpay2 = parseInt(tempPpay2, 10);
		if(projectTypeInfo.ppay2 == -1){
			tempPpay2 = 0;
			
		}
		$("#pay2").val(tempPpay2);
		
		var tempPmanage2 = inAccountAfter * projectTypeInfo.pmanage2;
		tempPmanage2 = parseInt(tempPmanage2, 10);
		if(projectTypeInfo.pmanage2 == -1){
			tempPmanage2 = 0;
			
		}
		$("#Manage2").val(tempPmanage2);
		
		var tempPact = inAccountAfter * projectTypeInfo.pact;
		tempPact = parseInt(tempPact, 10);
		if(projectTypeInfo.pact == -1){
			tempPact = 0;
			
		}
		$("#Act").val(tempPact);
		
		var tempPimprove = inAccountAfter * projectTypeInfo.pimprove;
		tempPimprove = parseInt(tempPimprove, 10);
		if(projectTypeInfo.pimprove == -1){
			tempPimprove = 0;
			
		}
		$("#Improve").val(tempPimprove);
		
		var tempPavailableManageCredit = inAccountAfter * projectTypeInfo.pavailableManageCredit;
		tempPavailableManageCredit = parseInt(tempPavailableManageCredit, 10);
		if(projectTypeInfo.pavailableManageCredit == -1){
			tempPavailableManageCredit = 0;
			
		}
		$("#AvailableManageCredit").val(tempPavailableManageCredit);
		
		var tempPconsult = inAccountAfter * projectTypeInfo.pconsult;
		tempPconsult = parseInt(tempPconsult, 10);
		if(projectTypeInfo.pconsult == -1){
			tempPconsult = 0;
			
		}
		$("#Consult").val(tempPconsult);
		
		var tempPtravelCost = inAccountAfter * projectTypeInfo.ptravelCost;
		tempPtravelCost = parseInt(tempPtravelCost, 10);
		if(projectTypeInfo.ptravelCost == -1){
			tempPtravelCost = 0;
			
		}
		$("#travelCost").val(tempPtravelCost);
		
		var tempPexchange = inAccountAfter * projectTypeInfo.pexchange;
		tempPexchange = parseInt(tempPexchange, 10);
		if(projectTypeInfo.pexchange == -1){
			tempPexchange = 0;
			
		}
		$("#exchange").val(tempPexchange);
		
		/*
		var tempPequipment = inAccountAfter * projectTypeInfo.pequipment;
		tempPequipment = parseInt(tempPequipment, 10);
		if(projectTypeInfo.pequipment == -1){
			tempPequipment = 0;
			
		}
		$("#equipment").val(tempPequipment);
		*/
		
		var tempPconference = inAccountAfter * projectTypeInfo.pconference;
		tempPconference = parseInt(tempPconference, 10);
		if(projectTypeInfo.pconference == -1){
			tempPconference = 0;
			
		}
		$("#conference").val(tempPconference);
		/*
		var tempdepartmentPublic = inAccountAfter * projectTypeInfo.departmentPublic;
		tempdepartmentPublic = parseInt(tempdepartmentPublic, 10);
		if(projectTypeInfo.departmentPublic == -1){
			tempdepartmentPublic = 0;
			
		}
		$("#departmentPublic").val(tempdepartmentPublic);
		
		var tempcoProject = inAccountAfter * projectTypeInfo.coProject;
		tempcoProject = parseInt(tempcoProject, 10);
		if(projectTypeInfo.coProject == -1){
			tempcoProject = 0;
			
		}
		$("#coProject").val(tempcoProject);
		*/
		
		//横向项目管理费显示
		if(isCrossItem == 1) {
			$("#isCross").html("是");
			
			var tempPdepartmentPay = inAccount * projectTypeInfo.pdepartmentPay;
			tempPdepartmentPay = parseInt(tempPdepartmentPay, 10);
			if(projectTypeInfo.pdepartmentPay == -1){
				tempPdepartmentPay = 0;
				
			}
			$("#DepartmentPay").val(tempPdepartmentPay);
			
			var tempPpay3 = inAccount * projectTypeInfo.ppay3;
			tempPpay3 = parseInt(tempPpay3, 10);
			if(projectTypeInfo.ppay3 == -1){
				tempPpay3 = 0;
				
			}
			$("#pay3").val(tempPpay3);
			
			$("#DepartmentPay")[0].disabled = false;
			$("#pay3")[0].disabled = false;
			
		} else {
			$("#isCross").html("否");
			$("#DepartmentPay").val(0);
			$("#pay3").val(0);
		}
	}
	
}


