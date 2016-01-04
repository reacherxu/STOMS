
var allOrgnizationIndexArray = new Array();

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
		                "href":"Page/Teacher/projectManagement/projectRegistration.jsp?itemPK=" 
				+ itemPK 
		             },
	                 {
	                	"name":"预算信息",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	/********************************预算年度起止时间  开始*********************************/
	var currentDate = new Date();
	var currentYear = currentDate.getFullYear();
	redrawSelectWidgetOptions("startYear", currentYear);
	$("#startYear").change(function(){
		var tempCurrentSelectValue = $("#startYear").val();
		tempCurrentSelectValue = $.trim(tempCurrentSelectValue);
		
		if(tempCurrentSelectValue.length > 0) {
			redrawSelectWidgetOptions("startYear", tempCurrentSelectValue);
		}
	});
	
	redrawSelectWidgetOptions("endYear", currentYear);
	$("#endYear").change(function(){
		var tempCurrentSelectValue = $("#endYear").val();
		tempCurrentSelectValue = $.trim(tempCurrentSelectValue);
		
		if(tempCurrentSelectValue.length > 0) {
			redrawSelectWidgetOptions("endYear", tempCurrentSelectValue);
		}
	});
	/********************************预算年度起止时间  结束*********************************/
	
	 //点击保存按钮时的响应事件
    $("#nation863BudgetSaveButton").click(function(check) {
 
        var a863FundInfo = acquireFormData();
        a863FundInfo["itemPK"] = itemPK;
        console.log(a863FundInfo);
        
		//异步调用
		generalAjaxCallToLoadData("store863BudgetInfo.action",a863FundInfo, showSavingResult);
        check.preventDefault();//此处阻止提交表单
    });
	
	//如果itemPK为空，则将itemPK置为"0"
	if(itemPK == undefined || itemPK == "") {
		console.log("item is empty!");
		itemPK = "0";
	} 

	console.log("itemPK ： " + itemPK);
	console.log("indexOfBudget : " + indexOfBudget);
	
	
	//为所有输入控件绑定事件 
	$("#a863BudgetFormTable input").live('change',function(){
		
		var inputWidgetID = $(this)[0].id;
		var prefixalID = inputWidgetID.substring(0, inputWidgetID.length - 2);
		var indexOfID = inputWidgetID.substring(inputWidgetID.length - 1);
		
		accumulateRowSum(prefixalID);
		
		switch(prefixalID) {
		case "buyCost":
		case "tryToMakeCost":
		case "reformLeaseCost":
			accumulateEquipmentCost(indexOfID);
			break;
		case "materialCost":
		case "testCost":
		case "fuelCost":
		case "travelCost":
		case "conferenceCost":
		case "internationalCost":
		case "publishCost":
		case "labourCost":
		case "consultationCost":
		case "otherCost":
			accumulateDirectCost(indexOfID);
			break;
		case "indirectCost":
			accumulateOutGoings(indexOfID);
			break;
		case "specialFundSource":
			accumulateFundSourse(indexOfID);
			break;
		case "otherFinanceSource":
		case "itsOwnSource":
		case "otherSource":
			accumulateSelfFundSource(indexOfID);
			break;
		default:
		}
		
	});
	
	//异步取得863项目的详细信息，初始化页面
	generalAjaxCallToLoadData("acquire863BudgetInfoByItemPK.action",{"itemPK":itemPK, "indexOfBudget":indexOfBudget}, initializeNation863BudgetInfo);
	

	//载入当前项目的附件列表
	refreshPicList();
});

function initializeNation863BudgetInfo(data) {
	
	if(!data.actionStatus) {
		//添加列
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
	var a863itemInfo = data.jsonResult.A863itemInfo;
	var a863njubudgetInfo = data.jsonResult.A863njubudgetInfo;
	var a863cooperationBudgetList = data.jsonResult.A863cooperationBudgetList;
	var a863sumInfo = data.jsonResult.A863sumInfo;
	
	
	//回显项目基本信息
	$("#itemName").html(a863itemInfo.itemName);
	$("#contractID").html(a863itemInfo.contractId);
	$("#teacherName").html(a863itemInfo.teacherName);
	$("#insideID").html(a863itemInfo.insideId);
	$("#cardID").html(a863itemInfo.cardId);
	
	//回显南京大学数据
	allOrgnizationIndexArray.push(0);
	
	var currentDate = new Date();
	var currentYear = currentDate.getFullYear();
	var tempStartYear = a863njubudgetInfo.timeLower;
	if($.trim(tempStartYear).length == 0) {
		tempStartYear = currentYear;
	}
	redrawSelectWidgetOptions("startYear", tempStartYear);
	
	var tempEndYear = a863njubudgetInfo.timeUpper;
	if($.trim(tempEndYear).length == 0) {
		tempEndYear = currentYear;
	}
	redrawSelectWidgetOptions("endYear", tempEndYear);
	
	addOrganizationColumn(0, a863njubudgetInfo);
	
	
	//回显协作单位数据
	for(var i = 0; i < a863cooperationBudgetList.length; i++) {
		var indexOfID = i + 1;
		var tempBudgetInfo = a863cooperationBudgetList[i];
		allOrgnizationIndexArray.push(indexOfID);
		addOrganizationColumn(indexOfID, tempBudgetInfo);
	}
	//回显批复预算数数据
	renderSummaryBudgetColumn(a863sumInfo);
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

//自动计算序号为indexOfID一列的设备费
function accumulateEquipmentCost(indexOfID) {
	var buyCost = getNumberInputWidgetValue("buyCost_" + indexOfID);
	var tryToMakeCost = getNumberInputWidgetValue("tryToMakeCost_" + indexOfID);
	var reformLeaseCost = getNumberInputWidgetValue("reformLeaseCost_" + indexOfID);
	var equipmentCost = buyCost + tryToMakeCost + reformLeaseCost;
	$("#equipmentCost_" + indexOfID).html(equipmentCost);
	
	accumulateEquipmentSumCost();
	accumulateDirectCost(indexOfID);
}

//自动计算预算总数一列的设备费
function accumulateEquipmentSumCost() {
	
	var buyCost = getNumberLabelWidgetValue("buyCost_Sum");
	var tryToMakeCost = getNumberLabelWidgetValue("tryToMakeCost_Sum");
	var reformLeaseCost = getNumberLabelWidgetValue("reformLeaseCost_Sum");
	var equipmentCost = buyCost + tryToMakeCost + reformLeaseCost;
	$("#equipmentCost_Sum").html(equipmentCost);
}

//自动计算序号为indexOfID一列的直接费用
function accumulateDirectCost(indexOfID) {
	
	var equipmentCost = getNumberLabelWidgetValue("equipmentCost_" + indexOfID);
	var materialCost = getNumberInputWidgetValue("materialCost_" + indexOfID);
	var testCost = getNumberInputWidgetValue("testCost_" + indexOfID);
	var fuelCost = getNumberInputWidgetValue("fuelCost_" + indexOfID);
	var travelCost = getNumberInputWidgetValue("travelCost_" + indexOfID);
	var conferenceCost = getNumberInputWidgetValue("conferenceCost_" + indexOfID);
	var internationalCost = getNumberInputWidgetValue("internationalCost_" + indexOfID);
	var publishCost = getNumberInputWidgetValue("publishCost_" + indexOfID);
	var labourCost = getNumberInputWidgetValue("labourCost_" + indexOfID);
	var consultationCost = getNumberInputWidgetValue("consultationCost_" + indexOfID);
	var constructionCost = getNumberInputWidgetValue("constructionCost_" + indexOfID);
	var otherCost = getNumberInputWidgetValue("otherCost_" + indexOfID);
	
	var directCost = equipmentCost + materialCost + testCost + fuelCost 
					+ travelCost + conferenceCost + internationalCost + publishCost
					+ labourCost + consultationCost + constructionCost + otherCost;
	$("#directCost_" + indexOfID).html(directCost);
	
	accumulateDirectSumCost();
	accumulateOutGoings(indexOfID);
}

//自动计算预算总数一列的直接费用
function accumulateDirectSumCost() {
	
	var equipmentCost = getNumberLabelWidgetValue("equipmentCost_Sum");
	var materialCost = getNumberLabelWidgetValue("materialCost_Sum");
	var testCost = getNumberLabelWidgetValue("testCost_Sum");
	var fuelCost = getNumberLabelWidgetValue("fuelCost_Sum");
	var travelCost = getNumberLabelWidgetValue("travelCost_Sum");
	var conferenceCost = getNumberLabelWidgetValue("conferenceCost_Sum");
	var internationalCost = getNumberLabelWidgetValue("internationalCost_Sum");
	var publishCost = getNumberLabelWidgetValue("publishCost_Sum");
	var labourCost = getNumberLabelWidgetValue("labourCost_Sum");
	var consultationCost = getNumberLabelWidgetValue("consultationCost_Sum");
	var constructionCost = getNumberLabelWidgetValue("constructionCost_Sum");
	var otherCost = getNumberLabelWidgetValue("otherCost_Sum");
	
	var directCost = equipmentCost + materialCost + testCost + fuelCost 
					+ travelCost + conferenceCost + internationalCost + publishCost
					+ labourCost + consultationCost + constructionCost + otherCost;
	$("#directCost_Sum").html(directCost);
}

//自动计算序号为indexOfID一列的经费支出
function accumulateOutGoings(indexOfID) {
	
	var directCost = getNumberLabelWidgetValue("directCost_" + indexOfID);
	var indirectCost = getNumberInputWidgetValue("indirectCost_" + indexOfID);
	var outGoings = directCost + indirectCost;
	$("#outGoings_" + indexOfID).html(outGoings);
	
	accumulateSumOutGoings();
}

//自动计算预算总数一列的经费支出
function accumulateSumOutGoings() {
	
	var directCost = getNumberLabelWidgetValue("directCost_Sum");
	var indirectCost = getNumberLabelWidgetValue("indirectCost_Sum");
	var outGoings = directCost + indirectCost;
	$("#outGoings_Sum").html(outGoings);
}

//自动计算序号为indexOfID一列的自筹经费来源
function accumulateSelfFundSource(indexOfID) {
	
	var otherFinanceSource = getNumberInputWidgetValue("otherFinanceSource_" + indexOfID);
	var itsOwnSource = getNumberInputWidgetValue("itsOwnSource_" + indexOfID);
	var otherSource = getNumberInputWidgetValue("otherSource_" + indexOfID);
	var selfFundSource = otherFinanceSource + itsOwnSource + otherSource;
	$("#selfFundSource_" + indexOfID).html(selfFundSource);
	
	accumulateSelfFundSourceSum();
	accumulateFundSourse(indexOfID);
}

//自动计算预算总数一列的自筹经费来源
function accumulateSelfFundSourceSum() {
	
	var otherFinanceSource = getNumberLabelWidgetValue("otherFinanceSource_Sum");
	var itsOwnSource = getNumberLabelWidgetValue("itsOwnSource_Sum");
	var otherSource = getNumberLabelWidgetValue("otherSource_Sum");
	var selfFundSource = otherFinanceSource + itsOwnSource + otherSource;
	$("#selfFundSource_Sum").html(selfFundSource);
}

//自动计算序号为indexOfID一列的经费来源
function accumulateFundSourse(indexOfID) {
	
	var specialFundSource = getNumberInputWidgetValue("specialFundSource_" + indexOfID);
	var selfFundSource = getNumberLabelWidgetValue("selfFundSource_" + indexOfID);
	var fundSourse = specialFundSource + selfFundSource;
	$("#fundSourse_" + indexOfID).html(fundSourse);
	
	accumulateFundSourseSum();
	
}

//自动计算预算总数一列的经费来源
function accumulateFundSourseSum() {
	
	var specialFundSource = getNumberLabelWidgetValue("specialFundSource_Sum");
	var selfFundSource = getNumberLabelWidgetValue("selfFundSource_Sum");
	var fundSourse = specialFundSource + selfFundSource;
	$("#fundSourse_Sum").html(fundSourse);
	
}

//得到数值输入框的值
 function getNumberInputWidgetValue(widgetID) {
 	
 	var tempValue = 0;
 	
 	if($("#" + widgetID).val() != "") {
 		tempValue = $("#" + widgetID).val();
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
	var outGoings_Sum = getNumberLabelWidgetValue("outGoings_Sum");
	var directCost_Sum = getNumberLabelWidgetValue("directCost_Sum");
	var equipmentCost_Sum = getNumberLabelWidgetValue("equipmentCost_Sum");
	var buyCost_Sum = getNumberLabelWidgetValue("buyCost_Sum");
	var tryToMakeCost_Sum = getNumberLabelWidgetValue("tryToMakeCost_Sum");
	var reformLeaseCost_Sum = getNumberLabelWidgetValue("reformLeaseCost_Sum");
	var materialCost_Sum = getNumberLabelWidgetValue("materialCost_Sum");
	var testCost_Sum = getNumberLabelWidgetValue("testCost_Sum");
	var fuelCost_Sum = getNumberLabelWidgetValue("fuelCost_Sum");
	var travelCost_Sum = getNumberLabelWidgetValue("travelCost_Sum");
	var conferenceCost_Sum = getNumberLabelWidgetValue("conferenceCost_Sum");
	var internationalCost_Sum = getNumberLabelWidgetValue("internationalCost_Sum");
	var publishCost_Sum = getNumberLabelWidgetValue("publishCost_Sum");
	var labourCost_Sum = getNumberLabelWidgetValue("labourCost_Sum");
	var consultationCost_Sum = getNumberLabelWidgetValue("consultationCost_Sum");
	var constructionCost_Sum = getNumberLabelWidgetValue("constructionCost_Sum");
	var otherCost_Sum = getNumberLabelWidgetValue("otherCost_Sum");
	var indirectCost_Sum = getNumberLabelWidgetValue("indirectCost_Sum");
	var achievementsCost_Sum = getNumberLabelWidgetValue("achievementsCost_Sum");
	var fundSourse_Sum = getNumberLabelWidgetValue("fundSourse_Sum");
	var specialFundSource_Sum = getNumberLabelWidgetValue("specialFundSource_Sum");
	var selfFundSource_Sum = getNumberLabelWidgetValue("selfFundSource_Sum");
	var otherFinanceSource_Sum = getNumberLabelWidgetValue("otherFinanceSource_Sum");
	var itsOwnSource_Sum = getNumberLabelWidgetValue("itsOwnSource_Sum");
	var otherSource_Sum = getNumberLabelWidgetValue("otherSource_Sum");
	
	//
	var organizationName_Array = new Array();
	var outGoings_Array = new Array();
	var directCost_Array = new Array();
	var equipmentCost_Array = new Array();
	var buyCost_Array = new Array();
	var tryToMakeCost_Array = new Array();
	var reformLeaseCost_Array = new Array();
	var materialCost_Array = new Array();
	var testCost_Array = new Array();
	var fuelCost_Array = new Array();
	var travelCost_Array = new Array();
	var conferenceCost_Array = new Array();
	var internationalCost_Array = new Array();
	var publishCost_Array = new Array();
	var labourCost_Array = new Array();
	var consultationCost_Array = new Array();
	var constructionCost_Array = new Array();
	var otherCost_Array = new Array();
	var indirectCost_Array = new Array();
	var achievementsCost_Array = new Array();
	var fundSourse_Array = new Array();
	var specialFundSource_Array = new Array();
	var selfFundSource_Array = new Array();
	var otherFinanceSource_Array = new Array();
	var itsOwnSource_Array = new Array();
	var otherSource_Array = new Array();
	
	for(var indexOfID = 0; indexOfID < allOrgnizationIndexArray.length; indexOfID++) {
		
		var organizationName_temp = $("#organizationName_" + indexOfID).val();
		organizationName_Array.push(organizationName_temp);
		var outGoings_temp = getNumberLabelWidgetValue("outGoings_" + indexOfID);
		outGoings_Array.push(outGoings_temp);
		var directCost_temp = getNumberLabelWidgetValue("directCost_" + indexOfID);
		directCost_Array.push(directCost_temp);
		var equipmentCost_temp = getNumberLabelWidgetValue("equipmentCost_" + indexOfID);
		equipmentCost_Array.push(equipmentCost_temp);
		var buyCost_temp = getNumberInputWidgetValue("buyCost_" + indexOfID);
		buyCost_Array.push(buyCost_temp);
		var tryToMakeCost_temp = getNumberInputWidgetValue("tryToMakeCost_" + indexOfID);
		tryToMakeCost_Array.push(tryToMakeCost_temp);
		var reformLeaseCost_temp = getNumberInputWidgetValue("reformLeaseCost_" + indexOfID);
		reformLeaseCost_Array.push(reformLeaseCost_temp);
		var materialCost_temp = getNumberInputWidgetValue("materialCost_" + indexOfID);
		materialCost_Array.push(materialCost_temp);
		var testCost_temp = getNumberInputWidgetValue("testCost_" + indexOfID);
		testCost_Array.push(testCost_temp);
		var fuelCost_temp = getNumberInputWidgetValue("fuelCost_" + indexOfID);
		fuelCost_Array.push(fuelCost_temp);
		var travelCost_temp = getNumberInputWidgetValue("travelCost_" + indexOfID);
		travelCost_Array.push(travelCost_temp);
		var conferenceCost_temp = getNumberInputWidgetValue("conferenceCost_" + indexOfID);
		conferenceCost_Array.push(conferenceCost_temp);
		var internationalCost_temp = getNumberInputWidgetValue("internationalCost_" + indexOfID);
		internationalCost_Array.push(internationalCost_temp);
		var publishCost_temp = getNumberInputWidgetValue("publishCost_" + indexOfID);
		publishCost_Array.push(publishCost_temp);
		var labourCost_temp = getNumberInputWidgetValue("labourCost_" + indexOfID);
		labourCost_Array.push(labourCost_temp);
		var consultationCost_temp = getNumberInputWidgetValue("consultationCost_" + indexOfID);
		consultationCost_Array.push(consultationCost_temp);
		var constructionCost_temp = getNumberInputWidgetValue("constructionCost_" + indexOfID);
		constructionCost_Array.push(constructionCost_temp);
		var otherCost_temp = getNumberInputWidgetValue("otherCost_" + indexOfID);
		otherCost_Array.push(otherCost_temp);
		var indirectCost_temp = getNumberInputWidgetValue("indirectCost_" + indexOfID);
		indirectCost_Array.push(indirectCost_temp);
		var achievementsCost_temp = getNumberInputWidgetValue("achievementsCost_" + indexOfID);
		achievementsCost_Array.push(achievementsCost_temp);
		var fundSourse_temp = getNumberLabelWidgetValue("fundSourse_" + indexOfID);
		fundSourse_Array.push(fundSourse_temp);
		var specialFundSource_temp = getNumberInputWidgetValue("specialFundSource_" + indexOfID);
		specialFundSource_Array.push(specialFundSource_temp);
		var selfFundSource_temp = getNumberLabelWidgetValue("selfFundSource_" + indexOfID);
		selfFundSource_Array.push(selfFundSource_temp);
		var otherFinanceSource_temp = getNumberInputWidgetValue("otherFinanceSource_" + indexOfID);
		otherFinanceSource_Array.push(otherFinanceSource_temp);
		var itsOwnSource_temp = getNumberInputWidgetValue("itsOwnSource_" + indexOfID);
		itsOwnSource_Array.push(itsOwnSource_temp);
		var otherSource_temp = getNumberInputWidgetValue("otherSource_" + indexOfID);
		otherSource_Array.push(otherSource_temp);
	}
	
	//预算起止结束年度
	var startYear = $("#startYear").val();
	startYear = $.trim(startYear);
	if(startYear == null || startYear.length == 0) {
		startYear = "";
	}
	
	var endYear = $("#endYear").val();
	endYear = $.trim(endYear);
	if(endYear == null || endYear.length == 0) {
		endYear = "";
	}
	
	var a863FormData = {
			"outGoings_Sum":outGoings_Sum,
			"directCost_Sum":directCost_Sum,
			"equipmentCost_Sum":equipmentCost_Sum,
			"buyCost_Sum":buyCost_Sum,
			"tryToMakeCost_Sum":tryToMakeCost_Sum,
			"reformLeaseCost_Sum":reformLeaseCost_Sum,
			"materialCost_Sum":materialCost_Sum,
			"testCost_Sum":testCost_Sum,
			"fuelCost_Sum":fuelCost_Sum,
			"travelCost_Sum":travelCost_Sum,
			"conferenceCost_Sum":conferenceCost_Sum,
			"internationalCost_Sum":internationalCost_Sum,
			"publishCost_Sum":publishCost_Sum,
			"labourCost_Sum":labourCost_Sum,
			"consultationCost_Sum":consultationCost_Sum,
			"constructionCost_Sum":constructionCost_Sum,
			"otherCost_Sum":otherCost_Sum,
			"indirectCost_Sum":indirectCost_Sum,
			"achievementsCost_Sum":achievementsCost_Sum,
			"fundSourse_Sum":fundSourse_Sum,
			"specialFundSource_Sum":specialFundSource_Sum,
			"selfFundSource_Sum":selfFundSource_Sum,
			"otherFinanceSource_Sum":otherFinanceSource_Sum,
			"itsOwnSource_Sum":itsOwnSource_Sum,
			"otherSource_Sum":otherSource_Sum,
			"organizationName_Array":organizationName_Array,
			"outGoings_Array":outGoings_Array,
			"directCost_Array":directCost_Array,
			"equipmentCost_Array":equipmentCost_Array,
			"buyCost_Array":buyCost_Array,
			"tryToMakeCost_Array":tryToMakeCost_Array,
			"reformLeaseCost_Array":reformLeaseCost_Array,
			"materialCost_Array":materialCost_Array,
			"testCost_Array":testCost_Array,
			"fuelCost_Array":fuelCost_Array,
			"travelCost_Array":travelCost_Array,
			"conferenceCost_Array":conferenceCost_Array,
			"internationalCost_Array":internationalCost_Array,
			"publishCost_Array":publishCost_Array,
			"labourCost_Array":labourCost_Array,
			"consultationCost_Array":consultationCost_Array,
			"constructionCost_Array":constructionCost_Array,
			"otherCost_Array":otherCost_Array,
			"indirectCost_Array":indirectCost_Array,
			"achievementsCost_Array":achievementsCost_Array,
			"fundSourse_Array":fundSourse_Array,
			"specialFundSource_Array":specialFundSource_Array,
			"selfFundSource_Array":selfFundSource_Array,
			"otherFinanceSource_Array":otherFinanceSource_Array,
			"itsOwnSource_Array":itsOwnSource_Array,
			"otherSource_Array":otherSource_Array,
			"startYear":startYear,
			"endYear":endYear
			
	};
	
	
	return a863FormData;
}

function showSavingResult(data){
  		
  	if(!data.actionStatus) {
  		alert("保存信息失败，请重试！");
  	} else {
  		alert("保存信息提交成功！");
  	}
}


function showSubmitingResult(data) {
  		
  	if(!data.actionStatus) {
  		alert("预算信息提交失败，请重试！");
  	} else {
  		alert("预算信息提交成功！");
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
	
	var outGoings = organizationBudgetInfo.costSum;
	if(outGoings == null) {
		outGoings = "";
	}
	tempTDElement = "<td><label id = 'outGoings_" + index + "'>" + outGoings + "</label></td>";
	$("#outGoingsTD").before(tempTDElement);
	
	var directCost = organizationBudgetInfo.directCost;
	if(directCost == null) {
		directCost = "";
	}
	tempTDElement = "<td><label id = 'directCost_" + index + "'>" + directCost + "</label></td>";
	$("#directCostTD").before(tempTDElement);
	
	var equipmentCost = organizationBudgetInfo.equipmentCost;
	if(equipmentCost == null) {
		equipmentCost = "";
	}
	tempTDElement = "<td><label id = 'equipmentCost_" + index + "'>" + equipmentCost + "</label></td>";
	$("#equipmentCostTD").before(tempTDElement);
	
	var buyCost = organizationBudgetInfo.buyEquipment;
	if(buyCost == null) {
		buyCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + buyCost
						+ "'id = 'buyCost_" + index + "'/></td>";
	$("#buyCostTD").before(tempTDElement);
	
	var tryToMakeCost = organizationBudgetInfo.trialEquipment;
	if(tryToMakeCost == null) {
		tryToMakeCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + tryToMakeCost
						+ "'id = 'tryToMakeCost_" + index + "'/></td>";
	$("#tryToMakeCostTD").before(tempTDElement);
	
	var reformLeaseCost = organizationBudgetInfo.transform;
	if(reformLeaseCost == null) {
		reformLeaseCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + reformLeaseCost
						+ "'id = 'reformLeaseCost_" + index + "'/></td>";
	$("#reformLeaseCostTD").before(tempTDElement);
	
	var materialCost = organizationBudgetInfo.materialCost;
	if(materialCost == null) {
		materialCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + materialCost
						+ "'id = 'materialCost_" + index + "'/></td>";
	$("#materialCostTD").before(tempTDElement);
	
	var testCost = organizationBudgetInfo.testCost;
	if(testCost == null) {
		testCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + testCost
						+ "'id = 'testCost_" + index + "'/></td>";
	$("#testCostTD").before(tempTDElement);
	
	var fuelCost = organizationBudgetInfo.fuelCost;
	if(fuelCost == null) {
		fuelCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + fuelCost
						+ "'id = 'fuelCost_" + index + "'/></td>";
	$("#fuelCostTD").before(tempTDElement);
	
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
	
	var internationalCost = organizationBudgetInfo.exchangeCost;
	if(internationalCost == null) {
		internationalCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + internationalCost
						+ "'id = 'internationalCost_" + index + "'/></td>";
	$("#internationalCostTD").before(tempTDElement);
	
	var publishCost = organizationBudgetInfo.publishCost;
	if(publishCost == null) {
		publishCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + publishCost
						+ "'id = 'publishCost_" + index + "'/></td>";
	$("#publishCostTD").before(tempTDElement);
	
	var labourCost = organizationBudgetInfo.serviceCost;
	if(labourCost == null) {
		labourCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + labourCost
						+ "'id = 'labourCost_" + index + "'/></td>";
	$("#labourCostTD").before(tempTDElement);
	
	var consultationCost = organizationBudgetInfo.consultCost;
	if(consultationCost == null) {
		consultationCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + consultationCost
						+ "'id = 'consultationCost_" + index + "'/></td>";
	$("#consultationCostTD").before(tempTDElement);
	
	var constructionCost = organizationBudgetInfo.constructionCost;
	if(constructionCost == null) {
		constructionCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + constructionCost
						+ "'id = 'constructionCost_" + index + "'/></td>";
	$("#constructionCostTD").before(tempTDElement);
	
	var otherCost = organizationBudgetInfo.otherCost;
	if(otherCost == null) {
		otherCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + otherCost
						+ "'id = 'otherCost_" + index + "'/></td>";
	$("#otherCostTD").before(tempTDElement);
	
	var indirectCost = organizationBudgetInfo.indirectCost;
	if(indirectCost == null) {
		indirectCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + indirectCost
						+ "'id = 'indirectCost_" + index + "'/></td>";
	$("#indirectCostTD").before(tempTDElement);
	
	var achievementsCost = organizationBudgetInfo.performanceCost;
	if(achievementsCost == null) {
		achievementsCost = "";
	}
	tempTDElement = "<td><input type='text' value = '" + achievementsCost
						+ "'id = 'achievementsCost_" + index + "'/></td>";
	$("#achievementsCostTD").before(tempTDElement);
	
	var fundSourse = organizationBudgetInfo.fundSum;
	if(fundSourse == null) {
		fundSourse = "";
	}
	tempTDElement = "<td><label id = 'fundSourse_" + index + "'>" + fundSourse + "</label></td>";
	$("#fundSourseTD").before(tempTDElement);
	
	var specialFundSource = organizationBudgetInfo.subsidizeSpecial;
	if(specialFundSource == null) {
		specialFundSource = "";
	}
	tempTDElement = "<td><input type='text' value = '" + specialFundSource
						+ "'id = 'specialFundSource_" + index + "'/></td>";
	$("#specialFundSourceTD").before(tempTDElement);
	
	var selfFundSource = organizationBudgetInfo.selfFinance;
	if(selfFundSource == null) {
		selfFundSource = "";
	}
	tempTDElement = "<td><label id = 'selfFundSource_" + index + "'>" + selfFundSource + "</label></td>";
	$("#selfFundSourceTD").before(tempTDElement);
	
	var otherFinanceSource = organizationBudgetInfo.otherFundsSelf;
	if(otherFinanceSource == null) {
		otherFinanceSource = "";
	}
	tempTDElement = "<td><input type='text' value = '" + otherFinanceSource
						+ "'id = 'otherFinanceSource_" + index + "'/></td>";
	$("#otherFinanceSourceTD").before(tempTDElement);
	
	var itsOwnSource = organizationBudgetInfo.ownFundsSelf;
	if(itsOwnSource == null) {
		itsOwnSource = "";
	}
	tempTDElement = "<td><input type='text' value = '" + itsOwnSource
						+ "'id = 'itsOwnSource_" + index + "'/></td>";
	$("#itsOwnSourceTD").before(tempTDElement);
	
	var otherSource = organizationBudgetInfo.otherSelf;
	if(otherSource == null) {
		otherSource = "";
	}
	tempTDElement = "<td><input type='text' value = '" + otherSource
						+ "'id = 'otherSource_" + index + "'/></td>";
	$("#otherSourceTD").before(tempTDElement);
}

//重绘Select下来菜单的Option选项
function redrawSelectWidgetOptions(selectID, currentYear) {
	
	$("#" + selectID).find("option").remove();
	
	var tempOption = "<option value=''>选择一个年度</option>";
	$("#" + selectID).append(tempOption);
	
	currentYear = parseInt(currentYear);
	for(var i = currentYear - 5; i < currentYear + 5; i++) {
		tempOption = "<option value='" + i + "'";
		if(i == currentYear) {
			tempOption = tempOption + "selected='selected'";
		}
		tempOption = tempOption + ">" + i + "&nbsp;年</option>";
		$("#" + selectID).append(tempOption);
	}
}

//回显预算批复数
function renderSummaryBudgetColumn(summaryBudgetInfo) {
	
	var outGoings = summaryBudgetInfo.costSum;
	$("#outGoings_Sum").html(outGoings);
	
	var directCost = summaryBudgetInfo.directCost;
	$("#directCost_Sum").html(directCost);
	
	var equipmentCost = summaryBudgetInfo.equipmentCost;
	$("#equipmentCost_Sum").html(equipmentCost);
	
	var buyCost = summaryBudgetInfo.buyEquipment;
	$("#buyCost_Sum").html(buyCost);
	
	var tryToMakeCost = summaryBudgetInfo.trialEquipment;
	$("#tryToMakeCost_Sum").html(tryToMakeCost);
	
	var reformLeaseCost = summaryBudgetInfo.transform;
	$("#reformLeaseCost_Sum").html(reformLeaseCost);
	
	var materialCost = summaryBudgetInfo.materialCost;
	$("#materialCost_Sum").html(materialCost);
	
	var testCost = summaryBudgetInfo.testCost;
	$("#testCost_Sum").html(testCost);
	
	var fuelCost = summaryBudgetInfo.fuelCost;
	$("#fuelCost_Sum").html(fuelCost);
	
	var travelCost = summaryBudgetInfo.travelCost;
	$("#travelCost_Sum").html(travelCost);
	
	var conferenceCost = summaryBudgetInfo.conferenceCost;
	$("#conferenceCost_Sum").html(conferenceCost);
	
	var internationalCost = summaryBudgetInfo.exchangeCost;
	$("#internationalCost_Sum").html(internationalCost);
	
	var publishCost = summaryBudgetInfo.publishCost;
	$("#publishCost_Sum").html(publishCost);
	
	var labourCost = summaryBudgetInfo.serviceCost;
	$("#labourCost_Sum").html(labourCost);
	
	var consultationCost = summaryBudgetInfo.consultCost;
	$("#consultationCost_Sum").html(consultationCost);
	
	var constructionCost = summaryBudgetInfo.constructionCost;
	$("#constructionCost_Sum").html(constructionCost);
	
	var otherCost = summaryBudgetInfo.otherCost;
	$("#otherCost_Sum").html(otherCost);
	
	var indirectCost = summaryBudgetInfo.indirectCost;
	$("#indirectCost_Sum").html(indirectCost);
	
	var achievementsCost = summaryBudgetInfo.performanceCost;
	$("#achievementsCost_Sum").html(achievementsCost);
	
	var fundSourse = summaryBudgetInfo.fundSum;
	$("#fundSourse_Sum").html(fundSourse);
	
	var specialFundSource = summaryBudgetInfo.subsidizeSpecial;
	$("#specialFundSource_Sum").html(specialFundSource);
	
	var selfFundSource = summaryBudgetInfo.selfFinance;
	$("#selfFundSource_Sum").html(selfFundSource);
	
	var otherFinanceSource = summaryBudgetInfo.otherFundsSelf;
	$("#otherFinanceSource_Sum").html(otherFinanceSource);
	
	var itsOwnSource = summaryBudgetInfo.ownFundsSelf;
	$("#itsOwnSource_Sum").html(itsOwnSource);
	
	var otherSource = summaryBudgetInfo.otherSelf;
	$("#otherSource_Sum").html(otherSource);
}

//增加协作单位按钮单击响应事件
function addCooperationButtonOnclickResponse() {
	
	console.log();
	var cooperationNum = allOrgnizationIndexArray.length;
	allOrgnizationIndexArray.push(cooperationNum);
	addOrganizationColumn(cooperationNum, {});
}