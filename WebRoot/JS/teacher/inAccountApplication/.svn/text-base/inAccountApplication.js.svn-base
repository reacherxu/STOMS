//是否申请卡
var isFirstOutlay = 0;
//项目类型信息
var projectTypeInfo;
//当前项目的经费卡号
var currentCardID;

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
	
	
	console.log("editableSelect!!!!!!!!!!!!!!!!!!");
	
	if(addOutlayPK == undefined || addOutlayPK == null || addOutlayPK == "") {
		addOutlayPK = "0";
	}
	SetAutoSelect("inAccountDepartment","220");//AutoSelect0
	SetAutoSelect("invoiceDetail","220");//AutoSelect1
	$("#AutoSelect1")[0].disabled = true;
	
	$("#taxCheck").change(function(event){
		
		var isDisabled = !(this.checked);
		$("#tax1")[0].disabled = isDisabled;
		$("#tax2")[0].disabled = isDisabled;
		$("#tax3")[0].disabled = isDisabled;
		//自动计算税金
		autoCalculateTaxsValue(this.checked);
		
	  });
	
	$("#invoiceCheck").change(function(event){
		
		var isDisabled = !(this.checked);
		$("#invoiceTitle")[0].disabled = isDisabled;
		$("#invoiceDetail")[0].disabled = isDisabled;
		$("#AutoSelect1")[0].disabled = isDisabled;
		
	  });
	
	$("#inAccountApplicationForm").validationEngine("attach");
	//点击提交按钮时的响应事件
    $("#inAccountApplicationSubmitButton").click(function(check) {
        if($("#inAccountApplicationForm").validationEngine('validate')){
        
        	var inAccountInfo = accquireInAccountFormData();
        	
        	//第一次入账，且没有选择其他经费卡号，提醒用户选择新开卡或选择其他卡号
        	if( $("#cardID")[0].disabled == false && inAccountInfo.cardID == null
        			&& (currentCardID == undefined || currentCardID == null || currentCardID.length == 0)) {
        		openGeneralMessageDialog("请开新卡或从下拉菜单中选择一个经费卡！");
        		return false;
        	}
        	
        	generalAjaxCallToLoadData("submitAddOutlayInfo.action", inAccountInfo, showSubmitingInAccountInfoResult);
        }
        check.preventDefault();//此处阻止提交表单 
    });
	
	//取得页面的基本信息然后回显
	
	var tempSubmitData = {"addOutlayPK":addOutlayPK, "itemID":itemID};
	generalAjaxCallToLoadData("accquireAddOutlayByAddOutlayPKAndItemID.action", tempSubmitData, initializePageContent);

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
	var inAccountInfo = data.jsonResult.addOutlayInfo;
	var cardIDArray = data.jsonResult.cardIDs;
	currentCardID = data.jsonResult.currentCardID;
	projectTypeInfo = data.jsonResult.projectTypeInfo;
	
	//回显选择项目类型中 项目类型信息
	allProjectTypeInfo = data.jsonResult.allProjectTypeInfo;
	
	var departmentType = inAccountInfo.departmentType;//文科或者理科
	
	for(var i = 0; i < allProjectTypeInfo.length; i++) {
		
		var tempDepartmentType1 = allProjectTypeInfo[i].departmentType;
		if(departmentType == tempDepartmentType1) {
			
			var typePK = allProjectTypeInfo[i].typePk;
			var typeID = allProjectTypeInfo[i].typeId;
			var typeName = allProjectTypeInfo[i].typeName;
			
			tempOption = "<option value='" + typePK+"separator"+typeID + "'>" + typeName + "</option>";
			$("#inAccountType").append(tempOption);
		}
	}
	var va = inAccountInfo.typePk+'separator'+inAccountInfo.typeId;
	$("#inAccountType").attr("value",va);//选择当前项目的类型为选中项
	
	
	var indirectID = data.jsonResult.indirectID;
	
	//卡号
	for(var i = 0; i < cardIDArray.length; i++) {
		var tempCardID = cardIDArray[i];
		
		if(tempCardID == undefined || tempCardID == null || tempCardID.length == 0) {
			continue;
		}
		
		var tempOption = "<option value = '" + tempCardID + "'>" + tempCardID + "</option>";
		$("#cardID").append(tempOption);
	}
	
	//如果该项目已有经费卡号，则不让用户新开经费卡
	if(currentCardID != undefined && currentCardID != null && currentCardID.length > 0) {
		
		$("#createNewCardIDButton").remove();
		$("#cardID").val(inAccountInfo.cardId);
	} else 
		if(inAccountInfo.isFirstOutlay) {
			
			assureCreatingNewCardID({});
		} else {
			$("#cardID").val(inAccountInfo.cardId);
		}
	
	//回显该项目类型的各个税的比例
	renderProportionLabel("tax1ProportionLabel", projectTypeInfo.ptax1);
	renderProportionLabel("tax2ProportionLabel", projectTypeInfo.ptax2);
	renderProportionLabel("tax3ProportionLabel", projectTypeInfo.ptax3);
	
	$("#itemName").html(inAccountInfo.itemName);
	$("#contractID").html(inAccountInfo.contractId);
	$("#teacherName").html(inAccountInfo.teacherName);
	$("#otherTeacherName").html(inAccountInfo.otherTeacher);
	$("#inAccountDepartment").val(inAccountInfo.outlayDepartment);
	$("#bankID").val(inAccountInfo.bankId);
	$("#indirectID").html(indirectID);
	
	$("#outlayValue").val(inAccountInfo.outlayValue);
	$("#remitValue").val(inAccountInfo.remitValue);
	
	
	
	$("#DirectValue").val(inAccountInfo.directValue);
	$("#IndirectValue").val(inAccountInfo.indirectValue);
	$("#Performance").val(inAccountInfo.performance);
	$("#Equipment").val(inAccountInfo.equipment);
	$("#Manage").html(inAccountInfo.manage);
	$("#Performance2").html(inAccountInfo.performance);
	$("#DepartmentPublic").html(inAccountInfo.departmentPublic);
	$("#CoProject").html(inAccountInfo.coProject);		
	
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
		$("#AutoSelect1")[0].disabled = false;
	}
	$("#invoiceTitle").val(inAccountInfo.invoiceTitle);
	$("#invoiceDetail").val(inAccountInfo.invoiceDetail);
	
}

function inAccountApplicationSaveResponse() {
		
	var inAccountInfo = accquireInAccountFormData();
	
	generalAjaxCallToLoadData("saveAddOutlayInfo.action", inAccountInfo, showSavingInAccountInfoResult);
}

//获取入账申请表单信息
function accquireInAccountFormData() {
	var inAccountInfo = {};
	
	inAccountInfo["addOutlayPK"] = addOutlayPK;
	inAccountInfo["itemID"] = itemID;
	
	inAccountInfo["otherTeacher"] = getStringInputWidgetValue("otherTeacherName");
	
	var PKandID = $("#inAccountType").val();

	var pk = PKandID.split("separator")[0];
	var id = PKandID.split("separator")[1];
	
	inAccountInfo["typePk"] = parseInt(pk);
	inAccountInfo["typeId"] = id;
	inAccountInfo["typeName"] = $("#inAccountType option:selected").text();
	
	inAccountInfo["outlayDepartment"] = document.getElementById('AutoSelect0').value;//史乐修改
	
	var tempCardID = getSelectWidgetValue("cardID");
	inAccountInfo["cardID"] = tempCardID;
	
	
	inAccountInfo["outlayValue"] = getNumberInputWidgetValue("outlayValue");
	inAccountInfo["remitValue"] = getNumberInputWidgetValue("remitValue");
	
	inAccountInfo["bankId"] = getStringInputWidgetValue("bankID");
	
	var isTaxChecked = $("#taxCheck")[0].checked;
	if(isTaxChecked) {
		inAccountInfo["isTax"] = 1;
		inAccountInfo["tax1"] = getInputWidgetValue("tax1");
		inAccountInfo["tax2"] = getInputWidgetValue("tax2");
		inAccountInfo["tax3"] = getInputWidgetValue("tax3");
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
		inAccountInfo["invoiceDetail"] = document.getElementById('AutoSelect1').value;//史乐修改
	} else {
		inAccountInfo["isInvoice"] = 0;
		inAccountInfo["invoiceTitle"] = "";
		inAccountInfo["invoiceDetail"] = "";
	}
	
	inAccountInfo["isFirstOutlay"] = isFirstOutlay;
	
	inAccountInfo["directValue"] = getNumberInputWidgetValue("DirectValue");
	inAccountInfo["indirectValue"] = getNumberInputWidgetValue("IndirectValue");
	inAccountInfo["performance"] = getNumberInputWidgetValue("Performance");
	inAccountInfo["equipment"] = getNumberInputWidgetValue("Equipment");
	
	inAccountInfo["manage"] = getLabelWidgetValue("Manage");
	inAccountInfo["departmentPublic"] = getLabelWidgetValue("DepartmentPublic");
	inAccountInfo["coProject"] = getLabelWidgetValue("CoProject");
	
	
	return inAccountInfo;
}

//显示保存入账申请的结果信息
function showSavingInAccountInfoResult(data) {
	if(!data.actionStatus) {
		openGeneralMessageDialog("入账申请记录保存失败，请重试！");
		return false;
	}
	
	addOutlayPK = data.jsonResult.addOutlayPK;
	swfu.setPostParams({"addOutlayPK":addOutlayPK});
	swfu.startUpload();
	openGeneralMessageDialog("恭喜您，入账申请记录保存成功！");
}

//显示提交入账申请的结果信息
function showSubmitingInAccountInfoResult(data) {
	if(!data.actionStatus) {
		openGeneralMessageDialog("入账申请记录提交失败，请重试！");
		return false;
	}
	
	addOutlayPK = data.jsonResult.addOutlayPK;
	
	swfu.setPostParams({"addOutlayPK":addOutlayPK});
	swfu.startUpload();
	
	openGeneralMessageDialogThenGoBack("恭喜您，入账申请记录提交成功！");
}

//得到输入框的值
function getInputWidgetValue(widgetID) {
	
	var tempValue = 0;
	
	if($("#" + widgetID).val() != "") {
		tempValue = $("#" + widgetID).val();
	}
	
	if(isNaN(parseInt(tempValue, 10))) {
		return parseInt("0");
	}
	
	return parseInt(tempValue);
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

//得到下拉菜单的值
function getSelectWidgetValue(widgetID) {
	
	var tempValue = "";
	
	tempValue = $("#" + widgetID).find("option:selected").val();
	tempValue = $.trim(tempValue);
	
	return tempValue;
}

//申请创建一张新经费卡
function createNewCardIDButtonResponse() {
	
	var dialogMessageContent = "您确定要申请新经费卡么？";
	openGeneralAssureDialog(dialogMessageContent, assureCreatingNewCardID, {});
}

//确定要申请新经费卡
function assureCreatingNewCardID(parameter) {
	
	console.log("create new card id!");
	isFirstOutlay = 1;
	$("#createNewCardIDButton")[0].disabled = true;
	
	var tempOption = "<option selected value = ''>新开经费卡</option>";
	$("#cardID").append(tempOption);
	$("#cardID")[0].disabled = true;
}

//根据项目类型自动计算各种税金
function autoCalculateTaxsValue(isChecked) {
	
	//如果含有税
	if(isChecked) {
		
		var outlayValue = getNumberInputWidgetValue("outlayValue");
		
		if(outlayValue > 0) {
			
			
			var newTax1 = (outlayValue/1.03)* 0.03;
			var newTax2 = newTax1 * 0.07;
			var newTax3 = newTax1 * 0.05;
			//var newTax1 = outlayValue * (projectTypeInfo.ptax1);
			//var newTax2 = outlayValue * (projectTypeInfo.ptax2);
			//var newTax3 = outlayValue * (projectTypeInfo.ptax3);
			
			$("#tax1").val(newTax1.toFixed(2));
			$("#tax2").val(newTax2.toFixed(2));
			$("#tax3").val(newTax3.toFixed(2));
			
			//$("#tax1").val( parseInt(newTax1, 10) );
			//$("#tax2").val( parseInt(newTax2, 10) );
			//$("#tax3").val( parseInt(newTax3, 10) );
		} else {
			$("#tax1").val(0);
			$("#tax2").val(0);
			$("#tax3").val(0);
		}
	} else {
		//如果不含有税
		$("#tax1").val(0);
		$("#tax2").val(0);
		$("#tax3").val(0);
	}
}

//??来款金额和汇出金额输入框改变时的响应事件，自动计算税额
function addoutInputWidgetOnchangeResponse() {
	
	var isTaxChecked = $("#taxCheck")[0].checked;
	autoCalculateTaxsValue(isTaxChecked);
}

//直接费用、间接费用计算管理费等
function addDirectIndirectOnchangeResponse(){
	
	var DirectValue= getNumberInputWidgetValue("DirectValue");
	var IndirectValue = getNumberInputWidgetValue("IndirectValue");
	var Performance = getNumberInputWidgetValue("Performance");	
	var Equipment = getNumberInputWidgetValue("Equipment");
	 
	var Manage ;
	if((DirectValue-Equipment)<10000000){
		Manage = ((DirectValue-Equipment)*0.05).toFixed(2);	
	}
	else Manage = ((DirectValue-Equipment)*0.03).toFixed(2);	
	
	var DepartmentPublic = ((IndirectValue-Manage-Performance)*0.2).toFixed(2);
	var CoProject = ((IndirectValue-Manage-Performance)*0.8).toFixed(2);
	
	if(Manage<0) Manage = 0;
	if(DepartmentPublic<0) DepartmentPublic = 0;
	if(CoProject<0) CoProject = 0;
	
	$("#Manage").html(Manage);
	$("#Performance2").html(Performance);
	$("#DepartmentPublic").html(DepartmentPublic);
	$("#CoProject").html(CoProject);
	
}

//回显各种税的比例
function renderProportionLabel(labelID, proportion){
	proportion = parseFloat(proportion * 100).toFixed(2);
	//var proportionIntergerType = parseInt(proportion, 10);
	var labelContent = "(" + proportion + "%)";
	$("#" + labelID).html(labelContent);
}