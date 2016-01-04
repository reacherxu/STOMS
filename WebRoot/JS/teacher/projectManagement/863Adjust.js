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
	
	

	//点击保存按钮时的响应事件
	$("#nation863AdjustSaveButton").click(function(check) {
	   	
	       console.log("nation863AdjustSaveButton");
	       var tempFormData = acquireFormData();
	       console.log(tempFormData);
	       
			//异步调用
			generalAjaxCallToLoadData("save863Adjust.action",tempFormData, showSavingResult);
	       check.preventDefault();//此处阻止提交表单
	   });

	$("#nation863AdjustForm").validationEngine("attach");	
	//点击提交按钮时的响应事件
    $("#nation863AdjustSubmitButton").click(function(check) {
        if($("#nation863AdjustForm").validationEngine('validate')){
        	console.log("nation863AdjustSubmitButton");
        	var tempFormData = acquireFormData();
        	generalAjaxCallToLoadData("submit863Adjust.action",tempFormData, showSubmitingResult);
        }
        check.preventDefault();//此处阻止提交表单  
    });
    

    var tempSubmitData = {"a863adjustPk":a863adjustPk, "itemPK":itemPK};
	//异步取得国家基金项目的预算信息，初始化页面
	generalAjaxCallToLoadData("acquire863AdjustInfo.action",tempSubmitData, initialize863Adjust);

	//载入当前项目的附件列表
	refreshPicList();
	
});

//累计支出经费
function costSum(){
	var costSum_adjust = getInputWidgetValue("equipmentCost_adjust") + getInputWidgetValue("materialCost_adjust")
	+ getInputWidgetValue("testCost_adjust") + getInputWidgetValue("fuelCost_adjust")
	+ getInputWidgetValue("travelCost_adjust")+ getInputWidgetValue("conferenceCost_adjust")+ getInputWidgetValue("exchangeCost_adjust")
	+ getInputWidgetValue("publishCost_adjust")+ getInputWidgetValue("serviceCost_adjust")+ getInputWidgetValue("consultCost_adjust")
	+ getInputWidgetValue("indirectCost_adjust")+ getInputWidgetValue("otherCost_adjust");

	$("#costSum_adjust").html(costSum_adjust);

	afterSum();
}

//计算调整后经费
function afterSum(){
	
	var costSum_after = getLabelWidgetValue("costSum_before") + getLabelWidgetValue("costSum_adjust");
	$("#costSum_after").html(costSum_after);
	
	var equipmentCost_after = getLabelWidgetValue("equipmentCost_before") + getInputWidgetValue("equipmentCost_adjust");
	$("#equipmentCost_after").html(equipmentCost_after);
	
	var materialCost_after = getLabelWidgetValue("materialCost_before") + getInputWidgetValue("materialCost_adjust");
	$("#materialCost_after").html(materialCost_after);
	
	var testCost_after = getLabelWidgetValue("testCost_before") + getInputWidgetValue("testCost_adjust");
	$("#testCost_after").html(testCost_after);
	
	var fuelCost_after = getLabelWidgetValue("fuelCost_before") + getInputWidgetValue("fuelCost_adjust");
	$("#fuelCost_after").html(fuelCost_after);
	
	var travelCost_after = getLabelWidgetValue("travelCost_before") + getInputWidgetValue("travelCost_adjust");
	$("#travelCost_after").html(travelCost_after);
	
	var conferenceCost_after = getLabelWidgetValue("conferenceCost_before") + getInputWidgetValue("conferenceCost_adjust");
	$("#conferenceCost_after").html(conferenceCost_after);
	
	var exchangeCost_after = getLabelWidgetValue("exchangeCost_before") + getInputWidgetValue("exchangeCost_adjust");
	$("#exchangeCost_after").html(exchangeCost_after);
	
	var publishCost_after = getLabelWidgetValue("publishCost_before") + getInputWidgetValue("publishCost_adjust");
	$("#publishCost_after").html(publishCost_after);
	
	var serviceCost_after = getLabelWidgetValue("serviceCost_before") + getInputWidgetValue("serviceCost_adjust");
	$("#serviceCost_after").html(serviceCost_after);
	
	var consultCost_after = getLabelWidgetValue("consultCost_before") + getInputWidgetValue("consultCost_adjust");
	$("#consultCost_after").html(consultCost_after);
	
	var indirectCost_after = getLabelWidgetValue("indirectCost_before") + getInputWidgetValue("indirectCost_adjust");
	$("#indirectCost_after").html(indirectCost_after);
	
	var otherCost_after = getLabelWidgetValue("otherCost_before") + getInputWidgetValue("otherCost_adjust");
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
	
		if(a863adjustPk != "0"){
		//显示预算调整
		$("#costSum_adjust").html(a863adjustInfo.costSum);
		$("#equipmentCost_adjust").val(a863adjustInfo.equipmentCost);	
		$("#materialCost_adjust").val(a863adjustInfo.materialCost);
		$("#testCost_adjust").val(a863adjustInfo.testCost);
		$("#fuelCost_adjust").val(a863adjustInfo.fuelCost);
		$("#travelCost_adjust").val(a863adjustInfo.travelCost);
		$("#conferenceCost_adjust").val(a863adjustInfo.conferenceCost);
		$("#exchangeCost_adjust").val(a863adjustInfo.exchangeCost);
		$("#publishCost_adjust").val(a863adjustInfo.publishCost);
		$("#serviceCost_adjust").val(a863adjustInfo.serviceCost);
		$("#consultCost_adjust").val(a863adjustInfo.consultCost);
		$("#indirectCost_adjust").val(a863adjustInfo.indirectCost);
		$("#otherCost_adjust").val(a863adjustInfo.otherCost);
		$("#ntime").val(a863adjustInfo.ntime);
		
		afterSum();
		}					
	}
	
	
}

//获取表单数据
function acquireFormData(){
	var formData = {};
	formData["a863adjustPk"] = a863adjustPk;
	formData["itemPK"] = itemPK;
	
	var costSum_adjust = $("#costSum_adjust").html();
	var equipmentCost_adjust = $("#equipmentCost_adjust").val();
	var materialCost_adjust = $("#materialCost_adjust").val();
	var testCost_adjust = $("#testCost_adjust").val();
	var fuelCost_adjust = $("#fuelCost_adjust").val();
	var travelCost_adjust = $("#travelCost_adjust").val();
	var conferenceCost_adjust = $("#conferenceCost_adjust").val();
	var exchangeCost_adjust = $("#exchangeCost_adjust").val();
	var publishCost_adjust = $("#publishCost_adjust").val();
	var serviceCost_adjust = $("#serviceCost_adjust").val();
	var consultCost_adjust = $("#consultCost_adjust").val();
	var indirectCost_adjust = $("#indirectCost_adjust").val();
	var otherCost_adjust = $("#otherCost_adjust").val();
	
	
	var ntime = $("#ntime").val();
	ntime = $.trim(ntime);
	if(ntime == null || ntime.length == 0) {
		ntime = "";	
	}
	formData["ntime"] = ntime;
	
	formData["costSum_adjust"] = costSum_adjust;
	formData["equipmentCost_adjust"] = equipmentCost_adjust;
	formData["materialCost_adjust"] = materialCost_adjust;
	formData["testCost_adjust"] = testCost_adjust;
	formData["fuelCost_adjust"] = fuelCost_adjust;
	formData["travelCost_adjust"] = travelCost_adjust;
	formData["conferenceCost_adjust"] = conferenceCost_adjust;
	formData["exchangeCost_adjust"] = exchangeCost_adjust;
	formData["publishCost_adjust"] = publishCost_adjust;
	formData["serviceCost_adjust"] = serviceCost_adjust;
	formData["consultCost_adjust"] = consultCost_adjust;
	formData["indirectCost_adjust"] = indirectCost_adjust;
	formData["otherCost_adjust"] = otherCost_adjust;
	

	return formData;
}


function resetForm(){
	$("#nation863AdjustForm").validationEngine("hideAll");	
	$("#nation863AdjustForm")[0].reset();
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
		$("#nation863AdjustForm").validationEngine("hideAll");
		openGeneralMessageDialogThenGoBack("预算调整提交成功！");
	}
}
