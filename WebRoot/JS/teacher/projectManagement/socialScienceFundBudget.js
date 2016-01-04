
var allOrgnizationIndexArray = new Array();

$(document).ready(function(){
	
	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"我的项目",
	                	"href":"Page/Teacher/projectManagement/projectRegistrationList.jsp"
	                 },
	                 {
		                "name":"项目登记",
		                "href":"Page/Teacher/projectManagement/projectRegistration.jsp?itemPK=" 
				+ itemPK 
		             },
	                 {
	                	"name":"预算信息",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	 //点击保存按钮时的响应事件
    $("#socialScienceFundBudgetSaveButton").click(function(check) {
 
        var socialScienceFundInfo = acquireFormData();
        socialScienceFundInfo["itemPK"] = itemPK;
        console.log(socialScienceFundInfo);
        
		//异步调用
		generalAjaxCallToLoadData("storeSocialScienceFundBudgetInfo.action",socialScienceFundInfo, showSavingResult);
        check.preventDefault();//此处阻止提交表单
    });
	
	//如果itemPK为空，则将itemPK置为"0"
	if(itemPK == undefined || itemPK == "") {
		console.log("item is empty!");
		itemPK = "0";
	} 

	console.log("itemPK ： " + itemPK);
	
	
	//为所有输入控件绑定事件 
	$("#socialScienceFundBudgetTable input").live('change',function(){
		
		var inputWidgetID = $(this)[0].id;
		var prefixalID = inputWidgetID.substring(0, inputWidgetID.length - 2);
		//自动算出该科目总预算批复数
		accumulateRowSum(prefixalID);
		
	});
	
	//异步取得863项目的详细信息，初始化页面
	generalAjaxCallToLoadData("acquireSocialScienceFundBudgetInfoByItemPK.action",{"itemPK":itemPK}, initializeSocialScienceBudgetInfo);


	//载入当前项目的附件列表
	refreshPicList();
});

function initializeSocialScienceBudgetInfo(data) {
	
	if(!data.actionStatus) {
		//添加列
		addOrganizationColumn(0, {});
	  	addOrganizationColumn(1, {});
	  	addOrganizationColumn(2, {});
	  	addOrganizationColumn(3, {});
	  	addOrganizationColumn(4, {});
	  	
	  	allOrgnizationIndexArray.push(0);
	  	allOrgnizationIndexArray.push(1);
	  	allOrgnizationIndexArray.push(2);
	  	allOrgnizationIndexArray.push(3);
	  	allOrgnizationIndexArray.push(4);
	  	
	  	return false;
	}
	
	console.log(data.jsonResult);
	var socialScienceItemInfo = data.jsonResult.socialScienceItemInfo;
	var socialScienceNjuBudgetInfo = data.jsonResult.socialScienceNjuBudgetInfo;
	var scienceCooperationBudgetInfo = data.jsonResult.scienceCooperationBudgetInfo;
	var socialScienceApprovalBudgetInfo = data.jsonResult.socialScienceApprovalBudgetInfo;
	
	
	//回显项目基本信息
	$("#itemName").html(socialScienceItemInfo.itemName);
	$("#contractID").html(socialScienceItemInfo.contractId);
	$("#teacherName").html(socialScienceItemInfo.teacherName);
	$("#cardID").html(socialScienceItemInfo.cardId);
	
	//回显南京大学数据
	allOrgnizationIndexArray.push(0);
	addOrganizationColumn(0, socialScienceNjuBudgetInfo);
	
	
	//回显协作单位数据
	for(var i = 0; i < scienceCooperationBudgetInfo.length; i++) {
		var indexOfID = i + 1;
		var tempBudgetInfo = scienceCooperationBudgetInfo[i];
		allOrgnizationIndexArray.push(indexOfID);
		addOrganizationColumn(indexOfID, tempBudgetInfo);
	}
	//回显批复预算数数据
	renderSummaryBudgetColumn(socialScienceApprovalBudgetInfo);
}

//自动计算改行的总和
function accumulateRowSum(prefixalID) {
	
	var tempSumValue = 0;
	
	for(var i = 0; i < allOrgnizationIndexArray.length; i++) {
		var tempIndex = allOrgnizationIndexArray[i];
		var tempWidgetID = prefixalID + "_" + tempIndex;
		var tempWidgetValue = getNumberInputWidgetValue(tempWidgetID);
		tempSumValue = tempSumValue + tempWidgetValue;
	}
	
	var sumLabelID = prefixalID + "_" + "Sum";
	$("#" + sumLabelID).html(tempSumValue);
}

//得到数值输入框的值
function getNumberInputWidgetValue(widgetID) {
	
	var tempValue = $("#" + widgetID).val();
	tempValue = $.trim(tempValue);
	
	if(tempValue == "") {
		tempValue = "0";
	}
	
	if(isNaN(Number(tempValue))) {
		return 0;
	}
	
	var num = new Number(tempValue);
	tempValue = num.toFixed(4);
	
	return Number(tempValue);
}
 
//得到数值标签的值
 function getNumberLabelWidgetValue(widgetID) {
 	
 	var tempValue = 0;
 	
 	if($("#" + widgetID).html() != "") {
 		tempValue = $("#" + widgetID).html();
 	}
 	
 	if(isNaN(Number(tempValue))) {
 		return 0;
 	}
 	
 	var num = new Number(tempValue);
 	tempValue = num.toFixed(4);
 	
 	return Number(tempValue);
 }

//获取表单数据
function acquireFormData() {
	
	//合计总量
	var materialCost_Sum = getNumberLabelWidgetValue("materialCost_Sum");
	var dataCost_Sum = getNumberLabelWidgetValue("dataCost_Sum");
	var travelCost_Sum = getNumberLabelWidgetValue("travelCost_Sum");
	var conferenceCost_Sum = getNumberLabelWidgetValue("conferenceCost_Sum");
	var exchangeCost_Sum = getNumberLabelWidgetValue("exchangeCost_Sum");
	var equipmentCost_Sum = getNumberLabelWidgetValue("equipmentCost_Sum");
	var consultCost_Sum = getNumberLabelWidgetValue("consultCost_Sum");
	var serviceCost_Sum = getNumberLabelWidgetValue("serviceCost_Sum");
	var printCost_Sum = getNumberLabelWidgetValue("printCost_Sum");
	var manageCost_Sum = getNumberLabelWidgetValue("manageCost_Sum");
	var otherCost_Sum = getNumberLabelWidgetValue("otherCost_Sum");
	
	
	//
	var organizationName_Array = new Array();
	var materialCost_Array = new Array();
	var dataCost_Array = new Array();
	var travelCost_Array = new Array();
	var conferenceCost_Array = new Array();
	var exchangeCost_Array = new Array();
	var equipmentCost_Array = new Array();
	var consultCost_Array = new Array();
	var serviceCost_Array = new Array();
	var printCost_Array = new Array();
	var manageCost_Array = new Array();
	var otherCost_Array = new Array();
	
	
	for(var indexOfID = 0; indexOfID < allOrgnizationIndexArray.length; indexOfID++) {
		
		var organizationName_temp = $("#organizationName_" + indexOfID).val();
		organizationName_Array.push(organizationName_temp);
		var materialCost_temp = getNumberInputWidgetValue("materialCost_" + indexOfID);
		materialCost_Array.push(materialCost_temp);
		var dataCost_temp = getNumberInputWidgetValue("dataCost_" + indexOfID);
		dataCost_Array.push(dataCost_temp);
		var travelCost_temp = getNumberInputWidgetValue("travelCost_" + indexOfID);
		travelCost_Array.push(travelCost_temp);
		var conferenceCost_temp = getNumberInputWidgetValue("conferenceCost_" + indexOfID);
		conferenceCost_Array.push(conferenceCost_temp);
		var exchangeCost_temp = getNumberInputWidgetValue("exchangeCost_" + indexOfID);
		exchangeCost_Array.push(exchangeCost_temp);
		var equipmentCost_temp = getNumberInputWidgetValue("equipmentCost_" + indexOfID);
		equipmentCost_Array.push(equipmentCost_temp);
		var consultCost_temp = getNumberInputWidgetValue("consultCost_" + indexOfID);
		consultCost_Array.push(consultCost_temp);
		var serviceCost_temp = getNumberInputWidgetValue("serviceCost_" + indexOfID);
		serviceCost_Array.push(serviceCost_temp);
		var printCost_temp = getNumberInputWidgetValue("printCost_" + indexOfID);
		printCost_Array.push(printCost_temp);
		var manageCost_temp = getNumberInputWidgetValue("manageCost_" + indexOfID);
		manageCost_Array.push(manageCost_temp);
		var otherCost_temp = getNumberInputWidgetValue("otherCost_" + indexOfID);
		otherCost_Array.push(otherCost_temp);
	}
	
	var socialScienceFundFormData = {
			"materialCost_Sum":materialCost_Sum,
			"dataCost_Sum":dataCost_Sum,
			"travelCost_Sum":travelCost_Sum,
			"conferenceCost_Sum":conferenceCost_Sum,
			"exchangeCost_Sum":exchangeCost_Sum,
			"equipmentCost_Sum":equipmentCost_Sum,
			"consultCost_Sum":consultCost_Sum,
			"serviceCost_Sum":serviceCost_Sum,
			"printCost_Sum":printCost_Sum,
			"manageCost_Sum":manageCost_Sum,
			"otherCost_Sum":otherCost_Sum,
			"organizationName_Array":organizationName_Array,
			"materialCost_Array":materialCost_Array,
			"dataCost_Array":dataCost_Array,
			"travelCost_Array":travelCost_Array,
			"conferenceCost_Array":conferenceCost_Array,
			"exchangeCost_Array":exchangeCost_Array,
			"equipmentCost_Array":equipmentCost_Array,
			"consultCost_Array":consultCost_Array,
			"serviceCost_Array":serviceCost_Array,
			"printCost_Array":printCost_Array,
			"manageCost_Array":manageCost_Array,
			"otherCost_Array":otherCost_Array
			
	};
	
	
	return socialScienceFundFormData;
}

function showSavingResult(data){
  		
  	if(!data.actionStatus) {
  		alert("保存信息失败，请重试！");
  	} else {
  		openGeneralMessageDialogThenGoBack("预算信息提交成功！");
  	}
}


//增加参与项目单位的一列
function addOrganizationColumn(index, organizationBudgetInfo) {
	
	var tempTDElement;
	
	if(index == 0) {
		tempTDElement = "<td>课题承担单位</td>";
	} else {
		tempTDElement = "<td>协作单位" + index + "</td>";
	}
	$("#tableHeaderTD").before(tempTDElement);
	
	var organizationName = organizationBudgetInfo.cooperationName;
	if(organizationName == null) {
		organizationName = "";
	}
	if(index == 0) {
		tempTDElement = "<td><input type='text' value = '南京大学' id = 'organizationName_" + index + "' disabled/></td>";
	} else {
		tempTDElement = "<td><input type='text' value = '" + organizationName
		+ "'id = 'organizationName_" + index + "'/></td>";
	}
	$("#organizationNameTD").before(tempTDElement);
	
	var materialCost = organizationBudgetInfo.materialCost;
	if(materialCost == null) {
		materialCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + materialCost
					+ "'id = 'materialCost_" + index + "'/></td>";
	$("#materialCostTD").before(tempTDElement);
	
	var dataCost = organizationBudgetInfo.dataCost;
	if(dataCost == null) {
		dataCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + dataCost
					+ "'id = 'dataCost_" + index + "'/></td>";
	$("#dataCostTD").before(tempTDElement);
	
	var travelCost = organizationBudgetInfo.travelCost;
	if(travelCost == null) {
		travelCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + travelCost
					+ "'id = 'travelCost_" + index + "'/></td>";
	$("#travelCostTD").before(tempTDElement);
	
	var conferenceCost = organizationBudgetInfo.conferenceCost;
	if(conferenceCost == null) {
		conferenceCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + conferenceCost
					+ "'id = 'conferenceCost_" + index + "'/></td>";
	$("#conferenceCostTD").before(tempTDElement);
	
	var exchangeCost = organizationBudgetInfo.exchangeCost;
	if(exchangeCost == null) {
		exchangeCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + exchangeCost
					+ "'id = 'exchangeCost_" + index + "'/></td>";
	$("#exchangeCostTD").before(tempTDElement);
	
	var equipmentCost = organizationBudgetInfo.equipmentCost;
	if(equipmentCost == null) {
		equipmentCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + equipmentCost
					+ "'id = 'equipmentCost_" + index + "'/></td>";
	$("#equipmentCostTD").before(tempTDElement);
	
	var consultCost = organizationBudgetInfo.consultCost;
	if(consultCost == null) {
		consultCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + consultCost
					+ "'id = 'consultCost_" + index + "'/></td>";
	$("#consultCostTD").before(tempTDElement);
	
	var serviceCost = organizationBudgetInfo.serviceCost;
	if(serviceCost == null) {
		serviceCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + serviceCost
					+ "'id = 'serviceCost_" + index + "'/></td>";
	$("#serviceCostTD").before(tempTDElement);
	
	var printCost = organizationBudgetInfo.printCost;
	if(printCost == null) {
		printCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + printCost
					+ "'id = 'printCost_" + index + "'/></td>";
	$("#printCostTD").before(tempTDElement);
	
	var manageCost = organizationBudgetInfo.manageCost;
	if(manageCost == null) {
		manageCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + manageCost
					+ "'id = 'manageCost_" + index + "'/></td>";
	$("#manageCostTD").before(tempTDElement);
	
	var otherCost = organizationBudgetInfo.otherCost;
	if(otherCost == null) {
		otherCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + otherCost
					+ "'id = 'otherCost_" + index + "'/></td>";
	$("#otherCostTD").before(tempTDElement);
}

//回显预算批复数
function renderSummaryBudgetColumn(summaryBudgetInfo) {
	
	var materialCost = summaryBudgetInfo.materialCost;
	$("#materialCost_Sum").html(materialCost);
	
	var dataCost = summaryBudgetInfo.dataCost;
	$("#dataCost_Sum").html(dataCost);
	
	var travelCost = summaryBudgetInfo.travelCost;
	$("#travelCost_Sum").html(travelCost);
	
	var conferenceCost = summaryBudgetInfo.conferenceCost;
	$("#conferenceCost_Sum").html(conferenceCost);
	
	var exchangeCost = summaryBudgetInfo.exchangeCost;
	$("#exchangeCost_Sum").html(exchangeCost);
	
	var equipmentCost = summaryBudgetInfo.equipmentCost;
	$("#equipmentCost_Sum").html(equipmentCost);
	
	var consultCost = summaryBudgetInfo.consultCost;
	$("#consultCost_Sum").html(consultCost);
	
	var serviceCost = summaryBudgetInfo.serviceCost;
	$("#serviceCost_Sum").html(serviceCost);
	
	var printCost = summaryBudgetInfo.printCost;
	$("#printCost_Sum").html(printCost);
	
	var manageCost = summaryBudgetInfo.manageCost;
	$("#manageCost_Sum").html(manageCost);
	
	var otherCost = summaryBudgetInfo.otherCost;
	$("#otherCost_Sum").html(otherCost);
}

//增加协作单位按钮单击响应事件
function addCooperationButtonOnclickResponse() {
	
	console.log();
	var cooperationNum = allOrgnizationIndexArray.length;
	allOrgnizationIndexArray.push(cooperationNum);
	addOrganizationColumn(cooperationNum, {});
}