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
		                "href":"Page/Teacher/projectManagement/projectRegistrationView.jsp?itemPK=" 
				+ itemPK 
		             },
	                 {
	                	"name":"预算信息",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	
	//如果itemPK为空，则将itemPK置为"0"
	if(itemPK == undefined || itemPK == "") {
		console.log("item is empty!");
		itemPK = "0";
	} 

	console.log("itemPK ： " + itemPK);
	console.log("indexOfBudget : " + indexOfBudget);
	
	
	//异步取得863项目的详细信息，初始化页面
	generalAjaxCallToLoadData("acquire863BudgetInfoByItemPK.action",{"itemPK":itemPK, "indexOfBudget":indexOfBudget}, initializeNation863BudgetInfo);
	

	//载入当前项目的附件列表
	refreshPicList();
});

function initializeNation863BudgetInfo(data) {
	
	if(!data.actionStatus) {
		//添加列
	  	addOrganizationColumn("1", {});
	  	addOrganizationColumn("2", {});
	  	addOrganizationColumn("3", {});
	  	addOrganizationColumn("4", {});
	  	
	  	allOrgnizationIndexArray.push("0");
	  	allOrgnizationIndexArray.push("1");
	  	allOrgnizationIndexArray.push("2");
	  	allOrgnizationIndexArray.push("3");
	  	allOrgnizationIndexArray.push("4");
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
	
	var tempStartYear = a863njubudgetInfo.timeLower;
	$("#startYear").html(tempStartYear + " 年");
	var tempEndYear = a863njubudgetInfo.timeUpper;
	$("#endYear").html(tempEndYear + " 年");
	addOrganizationColumn("0", a863njubudgetInfo);
	
	
	//回显协作单位数据
	for(var i = 0; i < a863cooperationBudgetList.length; i++) {
		var indexOfID = i + 1;
		var tempBudgetInfo = a863cooperationBudgetList[i];
		allOrgnizationIndexArray.push(indexOfID);
		addOrganizationColumn(indexOfID, tempBudgetInfo);
	}
	//回显批复预算数数据
	addOrganizationColumn("Sum", a863sumInfo);
}



//增加参与项目单位的一列
function addOrganizationColumn(index, organizationBudgetInfo) {
	
	var tempTDElement;
	
	if(index == "0") {
		tempTDElement = "<td>课题承担单位</td>";
	} else if(index == "Sum") {
			tempTDElement = "<td>批复预算数</td>";
		} else {
			tempTDElement = "<td>协作单位" + index + "</td>";
		}
	$("#tableHeaderTR").append(tempTDElement);
	
	var cooperationName = organizationBudgetInfo.cooperationName;
	if(cooperationName == null) {
		cooperationName = "";
	}
	if(index == "0") {
		tempTDElement = "<td><label id = 'cooperationName_" + index + "'>南京大学</label></td>";
	} else if(index == "Sum") {
			tempTDElement = "<td><label id = 'cooperationName_" + index + "'></label></td>";
		} else {
			tempTDElement = "<td><label id = 'cooperationName_" + index + "'>" + cooperationName + "</label></td>";
		}
	$("#cooperationNameTR").append(tempTDElement);
	
	var costSum = organizationBudgetInfo.costSum;
	if(costSum == null) {
		costSum = "";
	}
	tempTDElement = "<td><label id = 'costSum_" + index + "'>" + costSum + "</label></td>";
	$("#costSumTR").append(tempTDElement);
	
	var directCost = organizationBudgetInfo.directCost;
	if(directCost == null) {
		directCost = "";
	}
	tempTDElement = "<td><label id = 'directCost_" + index + "'>" + directCost + "</label></td>";
	$("#directCostTR").append(tempTDElement);
	
	var equipmentCost = organizationBudgetInfo.equipmentCost;
	if(equipmentCost == null) {
		equipmentCost = "";
	}
	tempTDElement = "<td><label id = 'equipmentCost_" + index + "'>" + equipmentCost + "</label></td>";
	$("#equipmentCostTR").append(tempTDElement);
	
	var buyEquipment = organizationBudgetInfo.buyEquipment;
	if(buyEquipment == null) {
		buyEquipment = "";
	}
	tempTDElement = "<td><label id = 'buyEquipment_" + index + "'>" + buyEquipment + "</label></td>";
	$("#buyEquipmentTR").append(tempTDElement);
	
	var trialEquipment = organizationBudgetInfo.trialEquipment;
	if(trialEquipment == null) {
		trialEquipment = "";
	}
	tempTDElement = "<td><label id = 'trialEquipment_" + index + "'>" + trialEquipment + "</label></td>";
	$("#trialEquipmentTR").append(tempTDElement);
	
	var transform = organizationBudgetInfo.transform;
	if(transform == null) {
		transform = "";
	}
	tempTDElement = "<td><label id = 'transform_" + index + "'>" + transform + "</label></td>";
	$("#transformTR").append(tempTDElement);
	
	var materialCost = organizationBudgetInfo.materialCost;
	if(materialCost == null) {
		materialCost = "";
	}
	tempTDElement = "<td><label id = 'materialCost_" + index + "'>" + materialCost + "</label></td>";
	$("#materialCostTR").append(tempTDElement);
	
	var testCost = organizationBudgetInfo.testCost;
	if(testCost == null) {
		testCost = "";
	}
	tempTDElement = "<td><label id = 'testCost_" + index + "'>" + testCost + "</label></td>";
	$("#testCostTR").append(tempTDElement);
	
	var fuelCost = organizationBudgetInfo.fuelCost;
	if(fuelCost == null) {
		fuelCost = "";
	}
	tempTDElement = "<td><label id = 'fuelCost_" + index + "'>" + fuelCost + "</label></td>";
	$("#fuelCostTR").append(tempTDElement);
	
	var travelCost = organizationBudgetInfo.travelCost;
	if(travelCost == null) {
		travelCost = "";
	}
	tempTDElement = "<td><label id = 'travelCost_" + index + "'>" + travelCost + "</label></td>";
	$("#travelCostTR").append(tempTDElement);
	
	var conferenceCost = organizationBudgetInfo.conferenceCost;
	if(conferenceCost == null) {
		conferenceCost = "";
	}
	tempTDElement = "<td><label id = 'conferenceCost_" + index + "'>" + conferenceCost + "</label></td>";
	$("#conferenceCostTR").append(tempTDElement);
	
	var exchangeCost = organizationBudgetInfo.exchangeCost;
	if(exchangeCost == null) {
		exchangeCost = "";
	}
	tempTDElement = "<td><label id = 'exchangeCost_" + index + "'>" + exchangeCost + "</label></td>";
	$("#exchangeCostTR").append(tempTDElement);
	
	var publishCost = organizationBudgetInfo.publishCost;
	if(publishCost == null) {
		publishCost = "";
	}
	tempTDElement = "<td><label id = 'publishCost_" + index + "'>" + publishCost + "</label></td>";
	$("#publishCostTR").append(tempTDElement);
	
	var serviceCost = organizationBudgetInfo.serviceCost;
	if(serviceCost == null) {
		serviceCost = "";
	}
	tempTDElement = "<td><label id = 'serviceCost_" + index + "'>" + serviceCost + "</label></td>";
	$("#serviceCostTR").append(tempTDElement);
	
	var consultCost = organizationBudgetInfo.consultCost;
	if(consultCost == null) {
		consultCost = "";
	}
	tempTDElement = "<td><label id = 'consultCost_" + index + "'>" + consultCost + "</label></td>";
	$("#consultCostTR").append(tempTDElement);
	
	var constructionCost = organizationBudgetInfo.constructionCost;
	if(constructionCost == null) {
		constructionCost = "";
	}
	tempTDElement = "<td><label id = 'constructionCost_" + index + "'>" + constructionCost + "</label></td>";
	$("#constructionCostTR").append(tempTDElement);
	
	var otherCost = organizationBudgetInfo.otherCost;
	if(otherCost == null) {
		otherCost = "";
	}
	tempTDElement = "<td><label id = 'otherCost_" + index + "'>" + otherCost + "</label></td>";
	$("#otherCostTR").append(tempTDElement);
	
	var indirectCost = organizationBudgetInfo.indirectCost;
	if(indirectCost == null) {
		indirectCost = "";
	}
	tempTDElement = "<td><label id = 'indirectCost_" + index + "'>" + indirectCost + "</label></td>";
	$("#indirectCostTR").append(tempTDElement);
	
	var performanceCost = organizationBudgetInfo.performanceCost;
	if(performanceCost == null) {
		performanceCost = "";
	}
	tempTDElement = "<td><label id = 'performanceCost_" + index + "'>" + performanceCost + "</label></td>";
	$("#performanceCostTR").append(tempTDElement);
	
	var fundSum = organizationBudgetInfo.fundSum;
	if(fundSum == null) {
		fundSum = "";
	}
	tempTDElement = "<td><label id = 'fundSum_" + index + "'>" + fundSum + "</label></td>";
	$("#fundSumTR").append(tempTDElement);
	
	var subsidizeSpecial = organizationBudgetInfo.subsidizeSpecial;
	if(subsidizeSpecial == null) {
		subsidizeSpecial = "";
	}
	tempTDElement = "<td><label id = 'subsidizeSpecial_" + index + "'>" + subsidizeSpecial + "</label></td>";
	$("#subsidizeSpecialTR").append(tempTDElement);
	
	var selfFinance = organizationBudgetInfo.selfFinance;
	if(selfFinance == null) {
		selfFinance = "";
	}
	tempTDElement = "<td><label id = 'selfFinance_" + index + "'>" + selfFinance + "</label></td>";
	$("#selfFinanceTR").append(tempTDElement);
	
	var otherFundsSelf = organizationBudgetInfo.otherFundsSelf;
	if(otherFundsSelf == null) {
		otherFundsSelf = "";
	}
	tempTDElement = "<td><label id = 'otherFundsSelf_" + index + "'>" + otherFundsSelf + "</label></td>";
	$("#otherFundsSelfTR").append(tempTDElement);
	
	var ownFundsSelf = organizationBudgetInfo.ownFundsSelf;
	if(ownFundsSelf == null) {
		ownFundsSelf = "";
	}
	tempTDElement = "<td><label id = 'ownFundsSelf_" + index + "'>" + ownFundsSelf + "</label></td>";
	$("#ownFundsSelfTR").append(tempTDElement);
	
	var otherSelf = organizationBudgetInfo.otherSelf;
	if(otherSelf == null) {
		otherSelf = "";
	}
	tempTDElement = "<td><label id = 'otherSelf_" + index + "'>" + otherSelf + "</label></td>";
	$("#otherSelfTR").append(tempTDElement);
}