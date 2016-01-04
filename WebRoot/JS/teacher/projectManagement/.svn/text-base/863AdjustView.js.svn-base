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
		                	"href":"Page/Teacher/projectManagement/863AdjustList.jsp?itemPK=" + itemPK
		             },
	                 {
	                	"name":"预算调整",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	
	console.log("863Adjustment!");
	
	
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
	
	
	var tempSubmitData = {"a863adjustPk":a863adjustPk, "itemPK":itemPK};
	//异步取得国家基金项目的预算信息，初始化页面
	generalAjaxCallToLoadData("acquire863AdjustInfo.action",tempSubmitData, initialize863Adjust);

	//载入当前项目的附件列表
	refreshPicList();
	
	$("input").attr("readonly", "readonly");
	$("textarea").attr("readonly", "readonly");
	
	
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
		
		$("#suggestion").val(a863adjustInfo.suggestion);
					
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

