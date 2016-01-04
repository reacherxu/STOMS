$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"我的项目",
	                	"href":"Page/Teacher/projectManagement/projectRegistrationList.jsp"
	                 },
	                 {
		                	"name":"预算调整历史",
		                	"href":"Page/Teacher/projectManagement/nationalFundAdjustList.jsp?itemPK=" + itemPK
		             },
	                 {
	                	"name":"预算调整",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	
	console.log("nationalFundBudgetAdjustment!");
	
	
	//如果itemPK为空，则将itemPK置为"0"
	if(itemPK == undefined || itemPK == "") {
		console.log("item is empty!");
		itemPK = "0";
	} else {
		
		console.log("itemPK ： " + itemPK);
	}
	
	if(nationalFundAdjustPk == undefined || nationalFundAdjustPk == null || nationalFundAdjustPk == "") {
		nationalFundAdjustPk = "0";
	}
	console.log("nationalFundAdjustPk ： " + nationalFundAdjustPk);
	
	//调整时间
	$( "#ntime" ).datepicker({
		showOn: 'button',
		buttonImage: "JqueryLib/css/datepickerCss/images/calendar.gif",
		buttonImageOnly: true,
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd"
	}).unbind('blur');
	
	

	//点击保存按钮时的响应事件
	$("#nationalFundBudgetAdjustmentSavaButton").click(function(check) {
	   	
	       console.log("nationalFundBudgetAdjustmentSavaButton");
	       var tempFormData = acquireFormData();
	       console.log(tempFormData);
	       
			//异步调用
			generalAjaxCallToLoadData("saveNationalFundBudgetAdjustment.action",tempFormData, showSavingResult);
	       check.preventDefault();//此处阻止提交表单
	   });
	
	$("#nationalFundBudgetAdjustForm").validationEngine("attach");	
	//点击提交按钮时的响应事件
    $("#nationalFundBudgetAdjustmentSubmitButton").click(function(check) {
        if($("#nationalFundBudgetAdjustForm").validationEngine('validate')){
        	//$("#ntime").datepicker( "hide" );
        	console.log("nationalFundBudgetAdjustmentSubmitButton");
        	var tempFormData = acquireFormData();
        	generalAjaxCallToLoadData("submitNationalFundBudgetAdjustment.action",tempFormData, showSubmitingResult);
        }
        check.preventDefault();//此处阻止提交表单  
    });
    
    
    var tempSubmitData = {"nationalFundAdjustPk":nationalFundAdjustPk, "itemPK":itemPK};
	//异步取得国家基金项目的预算信息，初始化页面
	generalAjaxCallToLoadData("acquireNationalFundBudgetAdjust.action",tempSubmitData, initializeNationalFundBudgetAdjust);

	//载入当前项目的附件列表
	refreshPicList();
	
	
});

	   

//科研业务费累计调整
function reserchBusinessSum() {
	
	var reserchBusinessSumValue = getInputWidgetValue("testCost_Adjust") + getInputWidgetValue("fuelCost_Adjust")
							+ getInputWidgetValue("conferenceCost_Adjust") + getInputWidgetValue("publishCost_Adjust")
							+ getInputWidgetValue("otherBusiness_Adjust");
	
	$("#sumBusiness_Adjust").html(reserchBusinessSumValue);
	
	researchFundSum();
}

//实验材料费调整
function experimentMaterialSum(){
	
	var experimentMaterialSumValue = getInputWidgetValue("rawMaterial_Adjust") + getInputWidgetValue("otherMaterial_Adjust");
	$("#sumMaterial_Adjust").html(experimentMaterialSumValue);
	
	researchFundSum();
}

//实验设备费调整
function experimentEquipmentSum() {
	
	var experimentEquipmentSumValue = getInputWidgetValue("buyEquipment_Adjust") + getInputWidgetValue("trialEquipment_Adjust");
	$("#sumEquipment_Adjust").html(experimentEquipmentSumValue);
	
	researchFundSum();
}

//研究经费总和调整
function researchFundSum() {
	var researchFundSumValue = getLabelWidgetValue("sumBusiness_Adjust") + getLabelWidgetValue("sumMaterial_Adjust")
								+ getLabelWidgetValue("sumEquipment_Adjust") + getInputWidgetValue("laboratory_Adjust")
								+ getInputWidgetValue("cooperation_Adjust");
	$("#studyFund_Adjust").html(researchFundSumValue);
	
	itemFundSum();
}

//国际合作与交流费调整
function internatialExchangeSum() {
	var internatialExchangeSumValue = getInputWidgetValue("exchange_Adjust") + getInputWidgetValue("expert_Adjust");
	$("#exchangeSum_Adjust").html(internatialExchangeSumValue);
	
	itemFundSum();
}

//项目经费合计调整
function itemFundSum() {
	var itemFundSumValue = getLabelWidgetValue("studyFund_Adjust") + getLabelWidgetValue("exchangeSum_Adjust")
							+ getInputWidgetValue("serviceCost_Adjust") + getInputWidgetValue("manageCost_Adjust");
	$("#sums_Adjust").html(itemFundSumValue);
	
	 budgetSum();
}

//其他经费来源合计
function otherItemFundSum() {
	
	var otherItemFundSumValue = getInputWidgetValue("otherPlanFundsBuget") + getInputWidgetValue("otherSubsidizeBuget");
	$("#otherSumBuget").html(otherItemFundSumValue);
}


//计算项目总经费
function budgetSum(){
	var studyFund_BudgetSum = getLabelWidgetValue("studyFund_Budget") + getLabelWidgetValue("studyFund_Adjust");
	$("#studyFund_BudgetSum").html(studyFund_BudgetSum);
	
	var sumBusiness_BudgetSum = getLabelWidgetValue("sumBusiness_Budget") + getLabelWidgetValue("sumBusiness_Adjust");
	$("#sumBusiness_BudgetSum").html(sumBusiness_BudgetSum);
	
	var testCost_BudgetSum = getLabelWidgetValue("testCost_Budget") + getInputWidgetValue("testCost_Adjust");
	$("#testCost_BudgetSum").html(testCost_BudgetSum);
	
	var fuelCost_BudgetSum = getLabelWidgetValue("fuelCost_Budget") + getInputWidgetValue("fuelCost_Adjust");
	$("#fuelCost_BudgetSum").html(fuelCost_BudgetSum);
	
	var conferenceCost_BudgetSum = getLabelWidgetValue("conferenceCost_Budget") + getInputWidgetValue("conferenceCost_Adjust");
	$("#conferenceCost_BudgetSum").html(conferenceCost_BudgetSum);
	
	var publishCost_BudgetSum = getLabelWidgetValue("publishCost_Budget") + getInputWidgetValue("publishCost_Adjust");
	$("#publishCost_BudgetSum").html(publishCost_BudgetSum);
	
	var otherBusiness_BudgetSum = getLabelWidgetValue("otherBusiness_Budget") + getInputWidgetValue("otherBusiness_Adjust");
	$("#otherBusiness_BudgetSum").html(otherBusiness_BudgetSum);
	
	var sumMaterial_BudgetSum = getLabelWidgetValue("sumMaterial_Budget") + getLabelWidgetValue("sumMaterial_Adjust");
	$("#sumMaterial_BudgetSum").html(sumMaterial_BudgetSum);
	
	var rawMaterial_BudgetSum = getLabelWidgetValue("rawMaterial_Budget") + getInputWidgetValue("rawMaterial_Adjust");
	$("#rawMaterial_BudgetSum").html(rawMaterial_BudgetSum);
	
	var otherMaterial_BudgetSum = getLabelWidgetValue("otherMaterial_Budget") + getInputWidgetValue("otherMaterial_Adjust");
	$("#otherMaterial_BudgetSum").html(otherMaterial_BudgetSum);
	
	var sumEquipment_BudgetSum = getLabelWidgetValue("sumEquipment_Budget") + getLabelWidgetValue("sumEquipment_Adjust");
	$("#sumEquipment_BudgetSum").html(sumEquipment_BudgetSum);
	
	var buyEquipment_BudgetSum = getLabelWidgetValue("buyEquipment_Budget") + getInputWidgetValue("buyEquipment_Adjust");
	$("#buyEquipment_BudgetSum").html(buyEquipment_BudgetSum);
	
	var trialEquipment_BudgetSum = getLabelWidgetValue("trialEquipment_Budget") + getInputWidgetValue("trialEquipment_Adjust");
	$("#trialEquipment_BudgetSum").html(trialEquipment_BudgetSum);
	
	var laboratory_BudgetSum = getLabelWidgetValue("laboratory_Budget") + getInputWidgetValue("laboratory_Adjust");
	$("#laboratory_BudgetSum").html(laboratory_BudgetSum);
	
	var cooperation_BudgetSum = getLabelWidgetValue("cooperation_Budget") + getInputWidgetValue("cooperation_Adjust");
	$("#cooperation_BudgetSum").html(cooperation_BudgetSum);
	
	var exchangeSum_BudgetSum = getLabelWidgetValue("exchangeSum_Budget") + getLabelWidgetValue("exchangeSum_Adjust");
	$("#exchangeSum_BudgetSum").html(exchangeSum_BudgetSum);
	
	var exchange_BudgetSum = getLabelWidgetValue("exchange_Budget") + getInputWidgetValue("exchange_Adjust");
	$("#exchange_BudgetSum").html(exchange_BudgetSum);
	
	var expert_BudgetSum = getLabelWidgetValue("expert_Budget") + getInputWidgetValue("expert_Adjust");
	$("#expert_BudgetSum").html(expert_BudgetSum);
	
	var serviceCost_BudgetSum = getLabelWidgetValue("serviceCost_Budget") + getInputWidgetValue("serviceCost_Adjust");
	$("#serviceCost_BudgetSum").html(serviceCost_BudgetSum);
	
	var manageCost_BudgetSum = getLabelWidgetValue("manageCost_Budget") + getInputWidgetValue("manageCost_Adjust");
	$("#manageCost_BudgetSum").html(manageCost_BudgetSum);
	
	var sums_BudgetSum = getLabelWidgetValue("sums_Budget") + getLabelWidgetValue("sums_Adjust");
	$("#sums_BudgetSum").html(sums_BudgetSum);
	
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
function initializeNationalFundBudgetAdjust(data){
	
	if(!data.actionStatus) {
		console.log("fail");
		return false;
	}

	var itemInfo = data.jsonResult.itemInfo;
	var nationalFundItemInfo = data.jsonResult.nationalFundItemInfo;
	var nationalFundBudgetInfo = data.jsonResult.nationalFundBudgetInfo;	
	var nationalFundAdjustInfo = data.jsonResult.nationalFundAdjustInfo;
	console.log(itemInfo);
	console.log(nationalFundItemInfo);
	console.log(nationalFundBudgetInfo);
	console.log(nationalFundAdjustInfo);
		
	
	if(itemPK != "0") {
		console.log("tiaozheng");
		console.log(nationalFundAdjustInfo);
		nationalFundAdjustPk = nationalFundAdjustInfo.nationalFundAdjustPk;
		$("#itemName").html(itemInfo.itemName);
		$("#teacherName").html(itemInfo.teacherName);
		$("#approveID").html(nationalFundItemInfo.approveId);	
		$("#dialFundsSum").val(nationalFundItemInfo.dialFundsSum);
		$("#otherPlanFundsBuget").val(nationalFundItemInfo.otherPlanFundsBuget);
		$("#otherSubsidizeBuget").val(nationalFundItemInfo.otherSubsidizeBuget);
		$("#otherSumBuget").html(nationalFundItemInfo.otherSumBuget);
		
		//显示预算经费
		$("#studyFund_Budget").html(nationalFundBudgetInfo.studyFund);
		$("#sumBusiness_Budget").html(nationalFundBudgetInfo.sumBusiness);	
		$("#testCost_Budget").html(nationalFundBudgetInfo.testCost);
		$("#fuelCost_Budget").html(nationalFundBudgetInfo.fuelCost);
		$("#conferenceCost_Budget").html(nationalFundBudgetInfo.conferenceCost);
		$("#publishCost_Budget").html(nationalFundBudgetInfo.publishCost);
		$("#otherBusiness_Budget").html(nationalFundBudgetInfo.otherBusiness);
		$("#sumMaterial_Budget").html(nationalFundBudgetInfo.sumMaterial);
		$("#rawMaterial_Budget").html(nationalFundBudgetInfo.rawMaterial);
		$("#otherMaterial_Budget").html(nationalFundBudgetInfo.otherMaterial);
		$("#sumEquipment_Budget").html(nationalFundBudgetInfo.sumEquipment);
		$("#buyEquipment_Budget").html(nationalFundBudgetInfo.buyEquipment);
		$("#trialEquipment_Budget").html(nationalFundBudgetInfo.trialEquipment);
		$("#laboratory_Budget").html(nationalFundBudgetInfo.laboratory);
		$("#cooperation_Budget").html(nationalFundBudgetInfo.cooperation);
		$("#exchangeSum_Budget").html(nationalFundBudgetInfo.exchangeSum);
		$("#exchange_Budget").html(nationalFundBudgetInfo.exchange);
		$("#expert_Budget").html(nationalFundBudgetInfo.expert);
		$("#serviceCost_Budget").html(nationalFundBudgetInfo.serviceCost);
		$("#manageCost_Budget").html(nationalFundBudgetInfo.manageCost);
		$("#sums_Budget").html(nationalFundBudgetInfo.sums);
		
		
		if(nationalFundAdjustPk != "0") {
		//显示预算调整
		$("#studyFund_Adjust").html(nationalFundAdjustInfo.studyFund);
		$("#sumBusiness_Adjust").html(nationalFundAdjustInfo.sumBusiness);	
		$("#testCost_Adjust").val(nationalFundAdjustInfo.testCost);
		$("#fuelCost_Adjust").val(nationalFundAdjustInfo.fuelCost);
		$("#conferenceCost_Adjust").val(nationalFundAdjustInfo.conferenceCost);
		$("#publishCost_Adjust").val(nationalFundAdjustInfo.publishCost);
		$("#otherBusiness_Adjust").val(nationalFundAdjustInfo.otherBusiness);
		$("#sumMaterial_Adjust").html(nationalFundAdjustInfo.sumMaterial);
		$("#rawMaterial_Adjust").val(nationalFundAdjustInfo.rawMaterial);
		$("#otherMaterial_Adjust").val(nationalFundAdjustInfo.otherMaterial);
		$("#sumEquipment_Adjust").html(nationalFundAdjustInfo.sumEquipment);
		$("#buyEquipment_Adjust").val(nationalFundAdjustInfo.buyEquipment);
		$("#trialEquipment_Adjust").val(nationalFundAdjustInfo.trialEquipment);
		$("#laboratory_Adjust").val(nationalFundAdjustInfo.laboratory);
		$("#cooperation_Adjust").val(nationalFundAdjustInfo.cooperation);
		$("#exchangeSum_Adjust").html(nationalFundAdjustInfo.exchangeSum);
		$("#exchange_Adjust").val(nationalFundAdjustInfo.exchange);
		$("#expert_Adjust").val(nationalFundAdjustInfo.expert);
		$("#serviceCost_Adjust").val(nationalFundAdjustInfo.serviceCost);
		$("#manageCost_Adjust").val(nationalFundAdjustInfo.manageCost);
		$("#sums_Adjust").html(nationalFundAdjustInfo.sums);
		$("#ntime").val(nationalFundAdjustInfo.ntime);

		budgetSum();
		}
				
	}
}



//获得国家基金项目调整经费及预算总经费
function acquireFormData(){
	
	var formData = {};
	formData["nationalFundAdjustPk"] = nationalFundAdjustPk;
	formData["itemPK"] = itemPK;
	
	var dialFundsSum = $("#dialFundsSum").val();
	var otherPlanFundsBuget = $("#otherPlanFundsBuget").val();
	var otherSubsidizeBuget = $("#otherSubsidizeBuget").val();
	var otherSumBuget = $("#otherSumBuget").html();
		
	//调整经费
	var studyFund_Adjust = $("#studyFund_Adjust").html();
	var sumBusiness_Adjust = $("#sumBusiness_Adjust").html();
	var testCost_Adjust = $("#testCost_Adjust").val();
	var fuelCost_Adjust = $("#fuelCost_Adjust").val();
	var conferenceCost_Adjust = $("#conferenceCost_Adjust").val();
	var publishCost_Adjust = $("#publishCost_Adjust").val();
	var otherBusiness_Adjust = $("#otherBusiness_Adjust").val();
	var sumMaterial_Adjust = $("#sumMaterial_Adjust").html();
	var rawMaterial_Adjust = $("#rawMaterial_Adjust").val();
	var otherMaterial_Adjust = $("#otherMaterial_Adjust").val();
	var sumEquipment_Adjust = $("#sumEquipment_Adjust").html();
	var buyEquipment_Adjust = $("#buyEquipment_Adjust").val();
	var trialEquipment_Adjust = $("#trialEquipment_Adjust").val();
	var laboratory_Adjust = $("#laboratory_Adjust").val();
	var cooperation_Adjust = $("#cooperation_Adjust").val();
	var exchangeSum_Adjust = $("#exchangeSum_Adjust").html();
	var exchange_Adjust = $("#exchange_Adjust").val();
	var expert_Adjust = $("#expert_Adjust").val();
	var serviceCost_Adjust = $("#serviceCost_Adjust").val();
	var manageCost_Adjust = $("#manageCost_Adjust").val();
	var sums_Adjust = $("#sums_Adjust").html();
	
	var ntime = $("#ntime").val();
	ntime = $.trim(ntime);
	if(ntime == null || ntime.length == 0) {
		ntime = "";	
	}
	formData["ntime"] = ntime;
	
	//预算总经费
	var studyFund_BudgetSum = $("#studyFund_BudgetSum").html();
	var sumBusiness_BudgetSum = $("#sumBusiness_BudgetSum").html();
	var testCost_BudgetSum = $("#testCost_BudgetSum").html();
	var fuelCost_BudgetSum = $("#fuelCost_BudgetSum").html();
	var conferenceCost_BudgetSum = $("#conferenceCost_BudgetSum").html();
	var publishCost_BudgetSum = $("#publishCost_BudgetSum").html();
	var otherBusiness_BudgetSum = $("#otherBusiness_BudgetSum").html();
	var sumMaterial_BudgetSum = $("#sumMaterial_BudgetSum").html();
	var rawMaterial_BudgetSum = $("#rawMaterial_BudgetSum").html();
	var otherMaterial_BudgetSum = $("#otherMaterial_BudgetSum").html();
	var sumEquipment_BudgetSum = $("#sumEquipment_BudgetSum").html();
	var buyEquipment_BudgetSum = $("#buyEquipment_BudgetSum").html();
	var trialEquipment_BudgetSum = $("#trialEquipment_BudgetSum").html();
	var laboratory_BudgetSum = $("#laboratory_BudgetSum").html();
	var cooperation_BudgetSum = $("#cooperation_BudgetSum").html();
	var exchangeSum_BudgetSum = $("#exchangeSum_BudgetSum").html();
	var exchange_BudgetSum = $("#exchange_BudgetSum").html();
	var expert_BudgetSum = $("#expert_BudgetSum").html();
	var serviceCost_BudgetSum = $("#serviceCost_BudgetSum").html();
	var manageCost_BudgetSum = $("#manageCost_BudgetSum").html();
	var sums_BudgetSum = $("#sums_BudgetSum").html();
	

	formData["dialFundsSum"] = dialFundsSum;
	formData["otherPlanFundsBuget"] = otherPlanFundsBuget;
	formData["otherSubsidizeBuget"] = otherSubsidizeBuget;
	formData["otherSumBuget"] = otherSumBuget;
	
	formData["studyFund_Adjust"] = studyFund_Adjust;
	formData["sumBusiness_Adjust"] = sumBusiness_Adjust;
	formData["testCost_Adjust"] = testCost_Adjust;
	formData["fuelCost_Adjust"] = fuelCost_Adjust;
	formData["conferenceCost_Adjust"] = conferenceCost_Adjust;
	formData["publishCost_Adjust"] = publishCost_Adjust;
	formData["otherBusiness_Adjust"] = otherBusiness_Adjust;
	formData["sumMaterial_Adjust"] = sumMaterial_Adjust;
	formData["rawMaterial_Adjust"] = rawMaterial_Adjust;
	formData["otherMaterial_Adjust"] = otherMaterial_Adjust;
	formData["sumEquipment_Adjust"] = sumEquipment_Adjust;
	formData["buyEquipment_Adjust"] = buyEquipment_Adjust;
	formData["trialEquipment_Adjust"] = trialEquipment_Adjust;
	formData["laboratory_Adjust"] = laboratory_Adjust;
	formData["cooperation_Adjust"] = cooperation_Adjust;
	formData["exchangeSum_Adjust"] = exchangeSum_Adjust;
	formData["exchange_Adjust"] = exchange_Adjust;
	formData["expert_Adjust"] = expert_Adjust;
	formData["serviceCost_Adjust"] = serviceCost_Adjust;
	formData["manageCost_Adjust"] = manageCost_Adjust;
	formData["sums_Adjust"] = sums_Adjust;
	
	
	formData["studyFund_BudgetSum"] = studyFund_BudgetSum;
	formData["sumBusiness_BudgetSum"] = sumBusiness_BudgetSum;
	formData["testCost_BudgetSum"] = testCost_BudgetSum;
	formData["fuelCost_BudgetSum"] = fuelCost_BudgetSum;
	formData["conferenceCost_BudgetSum"] = conferenceCost_BudgetSum;
	formData["publishCost_BudgetSum"] = publishCost_BudgetSum;
	formData["otherBusiness_BudgetSum"] = otherBusiness_BudgetSum;
	formData["sumMaterial_BudgetSum"] = sumMaterial_BudgetSum;
	formData["rawMaterial_BudgetSum"] = rawMaterial_BudgetSum;
	formData["otherMaterial_BudgetSum"] = otherMaterial_BudgetSum;
	formData["sumEquipment_BudgetSum"] = sumEquipment_BudgetSum;
	formData["buyEquipment_BudgetSum"] = buyEquipment_BudgetSum;
	formData["trialEquipment_BudgetSum"] = trialEquipment_BudgetSum;
	formData["laboratory_BudgetSum"] = laboratory_BudgetSum;
	formData["cooperation_BudgetSum"] = cooperation_BudgetSum;
	formData["exchangeSum_BudgetSum"] = exchangeSum_BudgetSum;
	formData["exchange_BudgetSum"] = exchange_BudgetSum;
	formData["expert_BudgetSum"] = expert_BudgetSum;
	formData["serviceCost_BudgetSum"] = serviceCost_BudgetSum;
	formData["manageCost_BudgetSum"] = manageCost_BudgetSum;
	formData["sums_BudgetSum"] = sums_BudgetSum;
	
	return formData;
		
}


function resetForm(){
	$("#nationalFundBudgetAdjustForm").validationEngine("hideAll");	
	$("#nationalFundBudgetAdjustForm")[0].reset();
	$( "label[id$='Total']" ).html("");
	$( "label[id^='sum']" ).html("");
	
}


//反馈保存操作的状态
function showSavingResult(data) {
	
	if(!data.actionStatus) {
		openGeneralMessageDialog("预算调整保存失败，请重试");
	} else {
		openGeneralMessageDialog("预算调整保存成功！");
	}
}

//反馈提交操作的状态
function showSubmitingResult(data) {
	
	if(!data.actionStatus) {
		openGeneralMessageDialog("预算调整提交失败，请重试！");
	} else {
		
		$("#nationalFundBudgetAdjustForm").validationEngine("hideAll");	
		//resetForm();
		openGeneralMessageDialogThenGoBack("预算调整提交成功！");
	}
}
