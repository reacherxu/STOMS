$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	


	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"项目查询",
	                	"href":""
	                 },
	                 {
		                	"name":"预算调整审核",
		                	"href":"Page/Admin/projectAudit/budgetAdjustmentAuditList.jsp"
		                 },
	                 {
	                	"name":"调整信息",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	console.log("863AdjustmentAudit!");
	
	
	//如果itemPK为空，则将itemPK置为"0"
	if(itemPK == undefined || itemPK == "") {
		console.log("item is empty!");
		itemPK = "0";
	} else {
		
		console.log("itemPK ： " + itemPK);
	}
	
	if(a863adjustPk == undefined || a863adjustPk == null || a863adjustPk == "") {
		a863adjustPk = "0";
	}
	console.log("a863adjustPk ： " + a863adjustPk);
	
	//调整时间
	$( "#ntime" ).datepicker({
		showOn: 'button',
		buttonImage: "JqueryLib/css/datepickerCss/images/calendar.gif",
		buttonImageOnly: true,
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd"
	}).unbind('blur');
	
	//点击审批通过按钮时的响应事件
	$("#A863AdjustAuditPassButton").click(function() {
	
			openGeneralAssureDialog("通过审核,确定?", 
					function(){ 
				
				var tempFormData = acquireFormData();
				
			       console.log(tempFormData);
			       console.log("tong guo sheng he!");
			       generalAjaxCallToLoadData("A863AdjustAuditPass.action",tempFormData, showAuditResult);
			       }, 
					{} );
	    });	
		
	
	$("#A863AdjustAuditRejectButton").click(function() {
			
			openGeneralAssureDialog("不通过审核,确定?", 
					function(){ 
				
				var tempFormData = acquireFormData();
				
				generalAjaxCallToLoadData("A863AdjustAuditReject.action",tempFormData, showAuditResult); }, 
					{});
	    });	
		
	
	var tempSubmitData = {"a863adjustPk":a863adjustPk, "itemPK":itemPK};
	//异步取得调整信息，初始化页面
	generalAjaxCallToLoadData("acquire863AdjustInfo.action",tempSubmitData, initialize863Adjust);

	//载入当前项目的附件列表
	refreshPicList();
	
	
});


//初始化页面
function initialize863Adjust(data){
	
	if(!data.actionStatus) {
		console.log("fail");
		return false;
	}

	var a863NJUBudgetInfo = data.jsonResult.a863NJUBudgetInfo;
	var a863adjustInfo = data.jsonResult.a863adjustInfo;
	
	console.log(a863NJUBudgetInfo);
	console.log(a863adjustInfo);
		
	
	if(itemPK != "0") {
		console.log("tiaozheng");
		a863adjustPk = a863adjustInfo.a863adjustPk;
		
		//显示预算经费
		$("#costSum_before").html(a863NJUBudgetInfo.costSum);
		$("#equipmentCost_before").html(a863NJUBudgetInfo.equipmentCost);	
		$("#materialCost_before").html(a863NJUBudgetInfo.materialCost);
		$("#testCost_before").html(a863NJUBudgetInfo.testCost);
		$("#fuelCost_before").html(a863NJUBudgetInfo.fuelCost);
		$("#travelCost_before").html(a863NJUBudgetInfo.travelCost);
		$("#conferenceCost_before").html(a863NJUBudgetInfo.conferenceCost);
		$("#exchangeCost_before").html(a863NJUBudgetInfo.exchangeCost);
		$("#publishCost_before").html(a863NJUBudgetInfo.publishCost);
		$("#serviceCost_before").html(a863NJUBudgetInfo.serviceCost);
		$("#consultCost_before").html(a863NJUBudgetInfo.consultCost);
		$("#indirectCost_before").html(a863NJUBudgetInfo.indirectCost);
		$("#otherCost_before").html(a863NJUBudgetInfo.otherCost);
	
		
		//显示预算调整
		$("#costSum_adjust").html(a863adjustInfo.costSum);
		$("#equipmentCost_adjust").html(a863adjustInfo.equipmentCost);	
		$("#materialCost_adjust").html(a863adjustInfo.materialCost);
		$("#testCost_adjust").html(a863adjustInfo.testCost);
		$("#fuelCost_adjust").html(a863adjustInfo.fuelCost);
		$("#travelCost_adjust").html(a863adjustInfo.travelCost);
		$("#conferenceCost_adjust").html(a863adjustInfo.conferenceCost);
		$("#exchangeCost_adjust").html(a863adjustInfo.exchangeCost);
		$("#publishCost_adjust").html(a863adjustInfo.publishCost);
		$("#serviceCost_adjust").html(a863adjustInfo.serviceCost);
		$("#consultCost_adjust").html(a863adjustInfo.consultCost);
		$("#indirectCost_adjust").html(a863adjustInfo.indirectCost);
		$("#otherCost_adjust").html(a863adjustInfo.otherCost);
		
		$("#ntime").html(a863adjustInfo.ntime);
					
	}
	afterSum();
	
}

//计算调整后经费
function afterSum(){
	
	var costSum_after = getLabelWidgetValue("costSum_before") + getLabelWidgetValue("costSum_adjust");
	$("#costSum_after").html(costSum_after);
	
	var equipmentCost_after = getLabelWidgetValue("equipmentCost_before") + getLabelWidgetValue("equipmentCost_adjust");
	$("#equipmentCost_after").html(equipmentCost_after);
	
	var materialCost_after = getLabelWidgetValue("materialCost_before") + getLabelWidgetValue("materialCost_adjust");
	$("#materialCost_after").html(materialCost_after);
	
	var testCost_after = getLabelWidgetValue("testCost_before") + getLabelWidgetValue("testCost_adjust");
	$("#testCost_after").html(testCost_after);
	
	var fuelCost_after = getLabelWidgetValue("fuelCost_before") + getLabelWidgetValue("fuelCost_adjust");
	$("#fuelCost_after").html(fuelCost_after);
	
	var travelCost_after = getLabelWidgetValue("travelCost_before") + getLabelWidgetValue("travelCost_adjust");
	$("#travelCost_after").html(travelCost_after);
	
	var conferenceCost_after = getLabelWidgetValue("conferenceCost_before") + getLabelWidgetValue("conferenceCost_adjust");
	$("#conferenceCost_after").html(conferenceCost_after);
	
	var exchangeCost_after = getLabelWidgetValue("exchangeCost_before") + getLabelWidgetValue("exchangeCost_adjust");
	$("#exchangeCost_after").html(exchangeCost_after);
	
	var publishCost_after = getLabelWidgetValue("publishCost_before") + getLabelWidgetValue("publishCost_adjust");
	$("#publishCost_after").html(publishCost_after);
	
	var serviceCost_after = getLabelWidgetValue("serviceCost_before") + getLabelWidgetValue("serviceCost_adjust");
	$("#serviceCost_after").html(serviceCost_after);
	
	var consultCost_after = getLabelWidgetValue("consultCost_before") + getLabelWidgetValue("consultCost_adjust");
	$("#consultCost_after").html(consultCost_after);
	
	var indirectCost_after = getLabelWidgetValue("indirectCost_before") + getLabelWidgetValue("indirectCost_adjust");
	$("#indirectCost_after").html(indirectCost_after);
	
	var otherCost_after = getLabelWidgetValue("otherCost_before") + getLabelWidgetValue("otherCost_adjust");
	$("#otherCost_after").html(otherCost_after);
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

//获得调整后总经费
function acquireFormData(){
	
	var formData = {};
	formData["a863adjustPk"] = a863adjustPk;
	formData["itemPK"] = itemPK;
	
	var costSum_after = $("#costSum_after").html();
	var equipmentCost_after = $("#equipmentCost_after").html();
	var materialCost_after = $("#materialCost_after").html();
	var testCost_after = $("#testCost_after").html();
	var fuelCost_after = $("#fuelCost_after").html();
	var travelCost_after = $("#travelCost_after").html();
	var conferenceCost_after = $("#conferenceCost_after").html();
	var exchangeCost_after = $("#exchangeCost_after").html();
	var publishCost_after = $("#publishCost_after").html();
	var serviceCost_after = $("#serviceCost_after").html();
	var consultCost_after = $("#consultCost_after").html();
	var indirectCost_after = $("#indirectCost_after").html();
	var otherCost_after = $("#otherCost_after").html();
	
	formData["costSum_after"] = costSum_after;
	formData["equipmentCost_after"] = equipmentCost_after;
	formData["materialCost_after"] = materialCost_after;
	formData["testCost_after"] = testCost_after;
	formData["fuelCost_after"] = fuelCost_after;
	formData["travelCost_after"] = travelCost_after;
	formData["conferenceCost_after"] = conferenceCost_after;
	formData["exchangeCost_after"] = exchangeCost_after;
	formData["publishCost_after"] = publishCost_after;
	formData["serviceCost_after"] = serviceCost_after;
	formData["consultCost_after"] = consultCost_after;
	formData["indirectCost_after"] = indirectCost_after;
	formData["otherCost_after"] = otherCost_after;
	
	
	var suggestion = $("#suggestion").val();
	formData["suggestion"] = suggestion;
	
	return formData;
		
}


//显示审批结果
function showAuditResult(data){
	if(!data.actionStatus) {
		openGeneralMessageDialog("审批失败，请重试！");
	} else {
		
		openGeneralMessageDialog("恭喜您，审批成功！");
	
		parent.pageTransition("Page/Admin/projectAudit/A863AdjustAuditList.jsp");
	}
}
