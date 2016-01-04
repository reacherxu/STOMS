$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"我的项目",
	                	"href":"Page/Teacher/projectManagement/projectRegistrationList.jsp"
	                 },
	                 {
		                "name":"项目登记",
		                "href":"Page/Teacher/projectManagement/projectRegistration.jsp?itemPK=" + itemPK 
		             },
	                 {
	                	"name":"预算信息",
		                "href":""
	                 }];
	console.log(parent);
	//parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	console.log("national FundBudget!");
	
	//如果itemPK为空，则将itemPK置为"0"
	if(itemPK == undefined || itemPK == "") {
		console.log("item is empty!");
		itemPK = "0";
	} else {
		
		console.log("itemPK ： " + itemPK);
	}
	
	 //点击保存按钮时的响应事件
    $("#nationalFundBudgetSavaButton").click(function(check) {
    	
        console.log("nationalFundBudgetSaveButton");
        var tempFormData = acquireFormData();
        console.log(tempFormData);
        
		//异步调用
		generalAjaxCallToLoadData("saveNationalFundBudgetInfo.action",tempFormData, showSavingResult);
        check.preventDefault();//此处阻止提交表单
    });
    
    
	$("#nationalFundBudgetForm").validationEngine("attach");	
	//点击提交按钮时的响应事件
    $("#nationalFundBudgetSubmitButton").click(function(check) {
        if($("#nationalFundBudgetForm").validationEngine('validate')){
        	console.log("nationalFundBudgetSubmitButton");
        	var tempFormData = acquireFormData();
        	generalAjaxCallToLoadData("submitNationalFundBudgetInfo.action",tempFormData, showSubmitingResult);
        }
        check.preventDefault();//此处阻止提交表单  
    });
    

	//异步取得国家基金项目的详细信息，初始化页面
	generalAjaxCallToLoadData("acquireNationalFundBudgetInfo.action",{"itemPK":itemPK}, initializeNationalFundBudgetInfo);

	
	//载入当前项目的附件列表
	refreshPicList();
	
});

//科研业务费累计
function reserchBusinessSum() {
	
	var reserchBusinessSumValue = getInputWidgetValue("testCost_Budget") + getInputWidgetValue("fuelCost_Budget")
							+ getInputWidgetValue("conferenceCost_Budget") + getInputWidgetValue("publishCost_Budget")
							+ getInputWidgetValue("otherBusiness_Budget");
	
	$("#sumBusiness_Budget").html(reserchBusinessSumValue);
	
	researchFundSum();
}

//实验材料费
function experimentMaterialSum(){
	
	var experimentMaterialSumValue = getInputWidgetValue("rawMaterial_Budget") + getInputWidgetValue("otherMaterial_Budget");
	$("#sumMaterial_Budget").html(experimentMaterialSumValue);
	
	researchFundSum();
}

//实验设备费
function experimentEquipmentSum() {
	
	var experimentEquipmentSumValue = getInputWidgetValue("buyEquipment_Budget") + getInputWidgetValue("trialEquipment_Budget");
	$("#sumEquipment_Budget").html(experimentEquipmentSumValue);
	
	researchFundSum();
}

//研究经费总和
function researchFundSum() {
	var researchFundSumValue = getLabelWidgetValue("sumBusiness_Budget") + getLabelWidgetValue("sumMaterial_Budget")
								+ getLabelWidgetValue("sumEquipment_Budget") + getInputWidgetValue("laboratory_Budget")
								+ getInputWidgetValue("cooperation_Budget");
	$("#studyFund_Budget").html(researchFundSumValue);
	
	itemFundSum();
}

//国际合作与交流费
function internatialExchangeSum() {
	var internatialExchangeSumValue = getInputWidgetValue("exchange_Budget") + getInputWidgetValue("expert_Budget");
	$("#exchangeSum_Budget").html(internatialExchangeSumValue);
	
	itemFundSum();
}

//计划内项目经费合计
function itemFundSum() {
	var itemFundSumValue = getLabelWidgetValue("studyFund_Budget") + getLabelWidgetValue("exchangeSum_Budget")
							+ getInputWidgetValue("serviceCost_Budget") + getInputWidgetValue("manageCost_Budget");
	$("#sums_Budget").html(itemFundSumValue);
}

//其他经费来源合计
function otherItemFundSum() {
	
	var otherItemFundSumValue = getInputWidgetValue("otherPlanFundsBuget") + getInputWidgetValue("otherSubsidizeBuget");
	$("#otherSumBuget").html(otherItemFundSumValue);
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

//初始化页面
function initializeNationalFundBudgetInfo(data){
	
	if(!data.actionStatus) {
		console.log("fail");
		return false;
	}

	var itemInfo = data.jsonResult.itemInfo;
	var nationalFundItemInfo = data.jsonResult.nationalFundItemInfo;
	var nationalFundBudgetInfo = data.jsonResult.nationalFundBudgetInfo;	
	var nationalFundBudgetRemarkInfo = data.jsonResult.nationalFundBudgetRemarkInfo;
	console.log(itemInfo);
	console.log(nationalFundItemInfo);
	console.log(nationalFundBudgetInfo);
	console.log(nationalFundBudgetRemarkInfo);
		
	
	if(itemPK != "0") {
		$("#itemName").html(itemInfo.itemName);
		$("#teacherName").html(itemInfo.teacherName);
		$("#approveID").val(nationalFundItemInfo.approveId);	
		$("#dialFundsSum").val(nationalFundItemInfo.dialFundsSum);
		$("#otherPlanFundsBuget").val(nationalFundItemInfo.otherPlanFundsBuget);
		$("#otherSubsidizeBuget").val(nationalFundItemInfo.otherSubsidizeBuget);
		$("#otherSumBuget").html(nationalFundItemInfo.otherSumBuget);
		//预算
		$("#studyFund_Budget").html(nationalFundBudgetInfo.studyFund);
		$("#sumBusiness_Budget").html(nationalFundBudgetInfo.sumBusiness);	
		$("#testCost_Budget").val(nationalFundBudgetInfo.testCost);
		$("#fuelCost_Budget").val(nationalFundBudgetInfo.fuelCost);
		$("#conferenceCost_Budget").val(nationalFundBudgetInfo.conferenceCost);
		$("#publishCost_Budget").val(nationalFundBudgetInfo.publishCost);
		$("#otherBusiness_Budget").val(nationalFundBudgetInfo.otherBusiness);
		$("#sumMaterial_Budget").html(nationalFundBudgetInfo.sumMaterial);
		$("#rawMaterial_Budget").val(nationalFundBudgetInfo.rawMaterial);
		$("#otherMaterial_Budget").val(nationalFundBudgetInfo.otherMaterial);
		$("#sumEquipment_Budget").html(nationalFundBudgetInfo.sumEquipment);
		$("#buyEquipment_Budget").val(nationalFundBudgetInfo.buyEquipment);
		$("#trialEquipment_Budget").val(nationalFundBudgetInfo.trialEquipment);
		$("#laboratory_Budget").val(nationalFundBudgetInfo.laboratory);
		$("#cooperation_Budget").val(nationalFundBudgetInfo.cooperation);
		$("#exchangeSum_Budget").html(nationalFundBudgetInfo.exchangeSum);
		$("#exchange_Budget").val(nationalFundBudgetInfo.exchange);
		$("#expert_Budget").val(nationalFundBudgetInfo.expert);
		$("#serviceCost_Budget").val(nationalFundBudgetInfo.serviceCost);
		$("#manageCost_Budget").val(nationalFundBudgetInfo.manageCost);
		$("#sums_Budget").html(nationalFundBudgetInfo.sums);
		

		//显示说明
		$("#studyFund_Remark").val(nationalFundBudgetRemarkInfo.studyFund);
		$("#sumBusiness_Remark").val(nationalFundBudgetRemarkInfo.sumBusiness);	
		$("#testCost_Remark").val(nationalFundBudgetRemarkInfo.testCost);
		$("#fuelCost_Remark").val(nationalFundBudgetRemarkInfo.fuelCost);
		$("#conferenceCost_Remark").val(nationalFundBudgetRemarkInfo.conferenceCost);
		$("#publishCost_Remark").val(nationalFundBudgetRemarkInfo.publishCost);
		$("#otherBusiness_Remark").val(nationalFundBudgetRemarkInfo.otherBusiness);
		$("#sumMaterial_Remark").val(nationalFundBudgetRemarkInfo.sumMaterial);
		$("#rawMaterial_Remark").val(nationalFundBudgetRemarkInfo.rawMaterial);
		$("#otherMaterial_Remark").val(nationalFundBudgetRemarkInfo.otherMaterial);
		$("#sumEquipment_Remark").val(nationalFundBudgetRemarkInfo.sumEquipment);
		$("#buyEquipment_Remark").val(nationalFundBudgetRemarkInfo.buyEquipment);
		$("#trialEquipment_Remark").val(nationalFundBudgetRemarkInfo.trialEquipment);
		$("#laboratory_Remark").val(nationalFundBudgetRemarkInfo.laboratory);
		$("#cooperation_Remark").val(nationalFundBudgetRemarkInfo.cooperation);
		$("#exchangeSum_Remark").val(nationalFundBudgetRemarkInfo.exchangeSum);
		$("#exchange_Remark").val(nationalFundBudgetRemarkInfo.exchange);
		$("#expert_Remark").val(nationalFundBudgetRemarkInfo.expert);
		$("#serviceCost_Remark").val(nationalFundBudgetRemarkInfo.serviceCost);
		$("#manageCost_Remark").val(nationalFundBudgetRemarkInfo.manageCost);
		$("#sums_Remark").val(nationalFundBudgetRemarkInfo.sums);
	}
}

//获得国家基金项目数据
function acquireFormData(){
	
	var formData = {};
	
	formData["itemPK"] = itemPK;
	
	var itemName = $("#itemName").html();
	var teacherName = $("#teacherName").html();
	var approveId = $("#approveID").val();
	var dialFundsSum = $("#dialFundsSum").val();
	var otherPlanFundsBuget = $("#otherPlanFundsBuget").val();
	var otherSubsidizeBuget = $("#otherSubsidizeBuget").val();
	var otherSumBuget = $("#otherSumBuget").html();
		
	var studyFund = $("#studyFund_Budget").html();
	var sumBusiness = $("#sumBusiness_Budget").html();
	var testCost = $("#testCost_Budget").val();
	var fuelCost = $("#fuelCost_Budget").val();
	var conferenceCost = $("#conferenceCost_Budget").val();
	var publishCost = $("#publishCost_Budget").val();
	var otherBusiness = $("#otherBusiness_Budget").val();
	var sumMaterial = $("#sumMaterial_Budget").html();
	var rawMaterial = $("#rawMaterial_Budget").val();
	var otherMaterial = $("#otherMaterial_Budget").val();
	var sumEquipment = $("#sumEquipment_Budget").html();
	var buyEquipment = $("#buyEquipment_Budget").val();
	var trialEquipment = $("#trialEquipment_Budget").val();
	var laboratory = $("#laboratory_Budget").val();
	var cooperation = $("#cooperation_Budget").val();
	var exchangeSum = $("#exchangeSum_Budget").html();
	var exchange = $("#exchange_Budget").val();
	var expert = $("#expert_Budget").val();
	var serviceCost = $("#serviceCost_Budget").val();
	var manageCost = $("#manageCost_Budget").val();
	var sums = $("#sums_Budget").html();
	

	formData["itemName"] = itemName;
	formData["teacherName"] = teacherName;
	formData["approveId"] = approveId;
	formData["dialFundsSum"] = dialFundsSum;
	formData["otherPlanFundsBuget"] = otherPlanFundsBuget;
	formData["otherSubsidizeBuget"] = otherSubsidizeBuget;
	formData["otherSumBuget"] = otherSumBuget;
	
	formData["studyFund"] = studyFund;
	formData["sumBusiness"] = sumBusiness;
	formData["testCost"] = testCost;
	formData["fuelCost"] = fuelCost;
	formData["conferenceCost"] = conferenceCost;
	formData["publishCost"] = publishCost;
	formData["otherBusiness"] = otherBusiness;
	formData["sumMaterial"] = sumMaterial;
	formData["rawMaterial"] = rawMaterial;
	formData["otherMaterial"] = otherMaterial;
	formData["sumEquipment"] = sumEquipment;
	formData["buyEquipment"] = buyEquipment;
	formData["trialEquipment"] = trialEquipment;
	formData["laboratory"] = laboratory;
	formData["cooperation"] = cooperation;
	formData["exchangeSum"] = exchangeSum;
	formData["exchange"] = exchange;
	formData["expert"] = expert;
	formData["serviceCost"] = serviceCost;
	formData["manageCost"] = manageCost;
	formData["sums"] = sums;
	
	//说明
	var studyFund_Remark = $("#studyFund_Remark").val();
	var sumBusiness_Remark = $("#sumBusiness_Remark").val();
	var testCost_Remark = $("#testCost_Remark").val();
	var fuelCost_Remark = $("#fuelCost_Remark").val();
	var conferenceCost_Remark = $("#conferenceCost_Remark").val();
	var publishCost_Remark = $("#publishCost_Remark").val();
	var otherBusiness_Remark = $("#otherBusiness_Remark").val();
	var sumMaterial_Remark = $("#sumMaterial_Remark").val();
	var rawMaterial_Remark = $("#rawMaterial_Remark").val();
	var otherMaterial_Remark = $("#otherMaterial_Remark").val();
	var sumEquipment_Remark = $("#sumEquipment_Remark").val();
	var buyEquipment_Remark = $("#buyEquipment_Remark").val();
	var trialEquipment_Remark = $("#trialEquipment_Remark").val();
	var laboratory_Remark = $("#laboratory_Remark").val();
	var cooperation_Remark = $("#cooperation_Remark").val();
	var exchangeSum_Remark = $("#exchangeSum_Remark").val();
	var exchange_Remark = $("#exchange_Remark").val();
	var expert_Remark = $("#expert_Remark").val();
	var serviceCost_Remark = $("#serviceCost_Remark").val();
	var manageCost_Remark = $("#manageCost_Remark").val();
	var sums_Remark = $("#sums_Remark").val();
		
	formData["studyFund_Remark"] = studyFund_Remark;
	formData["sumBusiness_Remark"] = sumBusiness_Remark;
	formData["testCost_Remark"] = testCost_Remark;
	formData["fuelCost_Remark"] = fuelCost_Remark;
	formData["conferenceCost_Remark"] = conferenceCost_Remark;
	formData["publishCost_Remark"] = publishCost_Remark;
	formData["otherBusiness_Remark"] = otherBusiness_Remark;
	formData["sumMaterial_Remark"] = sumMaterial_Remark;
	formData["rawMaterial_Remark"] = rawMaterial_Remark;
	formData["otherMaterial_Remark"] = otherMaterial_Remark;
	formData["sumEquipment_Remark"] = sumEquipment_Remark;
	formData["buyEquipment_Remark"] = buyEquipment_Remark;
	formData["trialEquipment_Remark"] = trialEquipment_Remark;
	formData["laboratory_Remark"] = laboratory_Remark;
	formData["cooperation_Remark"] = cooperation_Remark;
	formData["exchangeSum_Remark"] = exchangeSum_Remark;
	formData["exchange_Remark"] = exchange_Remark;
	formData["expert_Remark"] = expert_Remark;
	formData["serviceCost_Remark"] = serviceCost_Remark;
	formData["manageCost_Remark"] = manageCost_Remark;
	formData["sums_Remark"] = sums_Remark;
	
	
	return formData;
		
}

function resetForm(){
	$("#nationalFundBudgetForm")[0].reset();
	$( "label[id$='Total']" ).html("");
	$( "label[id^='sum']" ).html("");
	
}

//反馈保存操作的状态
function showSavingResult(data) {
	
	if(!data.actionStatus) {
		openGeneralMessageDialog("预算信息保存失败，请重试");
	} else {
		openGeneralMessageDialogThenGoBack("预算信息保存成功！");
	}
}

//反馈提交操作的状态
function showSubmitingResult(data) {
	
	if(!data.actionStatus) {
		openGeneralMessageDialog("预算信息提交失败，请重试！");
	} else {
		resetForm();
		openGeneralMessageDialogThenGoBack("预算信息提交成功！");
	}
}


