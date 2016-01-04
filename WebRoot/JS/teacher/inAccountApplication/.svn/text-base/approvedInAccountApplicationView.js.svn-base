$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	
	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"我的项目",
	                	"href":"Page/Teacher/projectManagement/projectRegistrationList.jsp"
	                 },
	                 {
		                "name":"入账申请历史",
		                "href":"Page/Teacher/inAccountApplication/inAccountApplicationList.jsp?itemID=" + itemID
		             },
	                 {
	                	"name":"入账申请",
		                "href":""
	                 }];
	
	if(parent.pathWayRender != undefined) {
		parent.pathWayRender(tempPagePaths);
	}
	
	/******************************* 显示导航条 结束****************************************/
	
	
	if(addOutlayPK == undefined || addOutlayPK == null || addOutlayPK == "") {
		addOutlayPK = "0";
	}
	
	//取得页面的基本信息然后回显
	var tempSubmitData = {"addOutlayPK":addOutlayPK};
	generalAjaxCallToLoadData("accquireAddOutlayByAddOutlayPK.action", tempSubmitData, initializePageContent);
	
	//载入当前项目入账信息的附件列表
	refreshPicList();
	
	$("textarea").attr("readonly", "readonly");
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
	
	//回显各个税额比例
	renderAllProportionLabels(projectTypeInfo,inAccountInfo);
	
	//回显入账申请的信息
	$("#itemName").html(inAccountInfo.itemName);
	$("#contractID").html(inAccountInfo.contractId);
	$("#teacherName").html(inAccountInfo.teacherName);
	$("#otherTeacherName").html(inAccountInfo.otherTeacher);
	$("#inAccountDepartment").html(inAccountInfo.outlayDepartment);
	$("#bankID").html(inAccountInfo.bankId);
	
	$("#indirectID").html(indirectID);
	var tempCardID = inAccountInfo.cardId;
	$("#cardID").html(tempCardID);
	
	$("#outlayValue").html(inAccountInfo.outlayValue);
	$("#remitValue").html(inAccountInfo.remitValue);
	
	
	$("#DirectValue").html(inAccountInfo.directValue);
	$("#IndirectValue").html(inAccountInfo.indirectValue);
	
	
	$("#pay").html(inAccountInfo.pay);
	$("#Manage").html(inAccountInfo.manage);
	$("#pay2").html(inAccountInfo.pay2);
	$("#Manage2").html(inAccountInfo.manage2);
	$("#Act").html(inAccountInfo.act);
	$("#Improve").html(inAccountInfo.improve);
	$("#AvailableManageCredit").html(inAccountInfo.availableManageCredit);
	$("#Consult").html(inAccountInfo.consult);
	$("#travelCost").html(inAccountInfo.travelCost);
	$("#exchange").html(inAccountInfo.exchange);
	$("#equipment").html(inAccountInfo.equipment);
	$("#conference").html(inAccountInfo.conference);
	$("#departmentPublic").html(inAccountInfo.departmentPublic);
	$("#coProject").html(inAccountInfo.coProject);
	
	$("#Performance").html(inAccountInfo.performance);
	
	if(inAccountInfo.isCross == 1) {
		$("#isCross").html("是");
	} else {
		$("#isCross").html("否");
	}
	$("#DepartmentPay").html(inAccountInfo.departmentPay);
	$("#pay3").html(inAccountInfo.pay3);
	
	if(inAccountInfo.isTax == 1) {
		$("#taxCheck").html("是");
	} else {
		$("#taxCheck").html("否");
	}
	$("#tax1").html(inAccountInfo.tax1);
	$("#tax2").html(inAccountInfo.tax2);
	$("#tax3").html(inAccountInfo.tax3);
	
	if(inAccountInfo.isInvoice == 1) {
		$("#invoiceCheck").html("是");
	} else {
		$("#invoiceCheck").html("否");
	}
	$("#invoiceTitle").html(inAccountInfo.invoiceTitle);
	$("#invoiceDetail").html(inAccountInfo.invoiceDetail);
	
	$("#suggestion").val(inAccountInfo.remark);
	
}

//回显所有的税费比例
function renderAllProportionLabels(projectTypeInfo,inAccountInfo){
	
	var outlayValue = inAccountInfo.outlayValue - inAccountInfo.remitValue;
	
	projectTypeInfo.ppay = parseFloat(inAccountInfo.pay/outlayValue).toFixed(4);
	renderProportionLabel("payProportionLabel", projectTypeInfo.ppay);
	
	projectTypeInfo.pmanage = parseFloat(inAccountInfo.manage/outlayValue).toFixed(4);
	renderProportionLabel("manageProportionLabel", projectTypeInfo.pmanage);
	
	projectTypeInfo.ppay2 = parseFloat(inAccountInfo.pay2/outlayValue).toFixed(4);
	renderProportionLabel("pay2ProportionLabel", projectTypeInfo.ppay2);
	
	projectTypeInfo.pmanage2 = parseFloat(inAccountInfo.manage2/outlayValue).toFixed(4);
	renderProportionLabel("manage2ProportionLabel", projectTypeInfo.pmanage2);
	
	projectTypeInfo.pact = parseFloat(inAccountInfo.act/outlayValue).toFixed(4);
	renderProportionLabel("actProportionLabel", projectTypeInfo.pact);
	
	projectTypeInfo.pimprove = parseFloat(inAccountInfo.improve/outlayValue).toFixed(4);
	renderProportionLabel("improveProportionLabel", projectTypeInfo.pimprove);
	
	projectTypeInfo.pavailableManageCredit = parseFloat(inAccountInfo.availableManageCredit/outlayValue).toFixed(4);
	renderProportionLabel("availableManageCreditProportionLabel", projectTypeInfo.pavailableManageCredit);
	
	projectTypeInfo.pconsult = parseFloat(inAccountInfo.consult/outlayValue).toFixed(4);
	renderProportionLabel("consultProportionLabel", projectTypeInfo.pconsult);
	
	projectTypeInfo.ptravelCost = parseFloat(inAccountInfo.travelCost/outlayValue).toFixed(4);
	renderProportionLabel("travelCostProportionLabel", projectTypeInfo.ptravelCost);
	
	projectTypeInfo.pexchange = parseFloat(inAccountInfo.exchange/outlayValue).toFixed(4);
	renderProportionLabel("exchangeProportionLabel", projectTypeInfo.pexchange);
	
	projectTypeInfo.pequipment = parseFloat(inAccountInfo.equipment/outlayValue).toFixed(4);
	renderProportionLabel("equipmentProportionLabel", projectTypeInfo.pequipment);
	
	projectTypeInfo.pconference = parseFloat(inAccountInfo.conference/outlayValue).toFixed(4);
	renderProportionLabel("conferenceProportionLabel", projectTypeInfo.pconference);
	
	projectTypeInfo.departmentPublic = parseFloat(inAccountInfo.departmentPublic/outlayValue).toFixed(4);
	renderProportionLabel("departmentPublicProportionLabel", projectTypeInfo.departmentPublic);
	
	projectTypeInfo.coProject = parseFloat(inAccountInfo.coProject/outlayValue).toFixed(4);
	renderProportionLabel("coProjectProportionLabel", projectTypeInfo.coProject);
	
	projectTypeInfo.pdepartmentPay = parseFloat(inAccountInfo.departmentPay/inAccountInfo.outlayValue).toFixed(4);
	renderProportionLabel("departmentPayProportionLabel", projectTypeInfo.pdepartmentPay);
	
	projectTypeInfo.ppay3 = parseFloat(inAccountInfo.pay3/inAccountInfo.outlayValue).toFixed(4);
	renderProportionLabel("pay3ProportionLabel", projectTypeInfo.ppay3);
	
	projectTypeInfo.ptax1 = parseFloat(inAccountInfo.tax1/inAccountInfo.outlayValue).toFixed(4);
	renderProportionLabel("tax1ProportionLabel", projectTypeInfo.ptax1);
	
	projectTypeInfo.ptax2 = parseFloat(inAccountInfo.tax2/inAccountInfo.outlayValue).toFixed(4);
	renderProportionLabel("tax2ProportionLabel", projectTypeInfo.ptax2);
	
	projectTypeInfo.ptax3 = parseFloat(inAccountInfo.tax3/inAccountInfo.outlayValue).toFixed(4);
	renderProportionLabel("tax3ProportionLabel", projectTypeInfo.ptax3);
	
}



//回显各种税的比例
function renderProportionLabel(labelID, proportion){
	proportion = parseFloat(proportion * 100).toFixed(2);
	var labelContent = "(" + proportion + "%)";	
	$("#" + labelID).html(labelContent);
}

function printInAccountInfoButtonResponse() {
	
	var detailInfoUrl = "";
	detailInfoUrl = "Page/Teacher/inAccountApplication/inAccountPrint.jsp?addOutlayPK=" + addOutlayPK + "&itemID=" + itemID;
	
	window.open(detailInfoUrl);
}
