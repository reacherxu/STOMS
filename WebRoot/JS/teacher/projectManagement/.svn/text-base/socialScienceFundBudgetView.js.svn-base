
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
	
	
	//如果itemPK为空，则将itemPK置为"0"
	if(itemPK == undefined || itemPK == "") {
		console.log("item is empty!");
		itemPK = "0";
	} 

	console.log("itemPK ： " + itemPK);
	
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
		tempTDElement = "<td><label id = 'organizationName_" + index + "'>南京大学</label></td>";
	} else {
		tempTDElement = "<td><label id = 'organizationName_" + index + "'>" + organizationName + "</label></td>";
	}
	$("#organizationNameTD").before(tempTDElement);
	
	var materialCost = organizationBudgetInfo.materialCost;
	if(materialCost == null) {
		materialCost = "";
	}
	tempTDElement = "<td><label id = 'materialCost_" + index + "'>" + materialCost + "</label></td>";
	$("#materialCostTD").before(tempTDElement);
	
	var dataCost = organizationBudgetInfo.dataCost;
	if(dataCost == null) {
		dataCost = "";
	}
	tempTDElement = "<td><label id = 'dataCost_" + index + "'>" + dataCost + "</label></td>";
	$("#dataCostTD").before(tempTDElement);
	
	var travelCost = organizationBudgetInfo.travelCost;
	if(travelCost == null) {
		travelCost = "";
	}
	tempTDElement = "<td><label id = 'travelCost_" + index + "'>" + travelCost + "</label></td>";
	$("#travelCostTD").before(tempTDElement);
	
	var conferenceCost = organizationBudgetInfo.conferenceCost;
	if(conferenceCost == null) {
		conferenceCost = "";
	}
	tempTDElement = "<td><label id = 'conferenceCost_" + index + "'>" + conferenceCost + "</label></td>";
	$("#conferenceCostTD").before(tempTDElement);
	
	var exchangeCost = organizationBudgetInfo.exchangeCost;
	if(exchangeCost == null) {
		exchangeCost = "";
	}
	tempTDElement = "<td><label id = 'exchangeCost_" + index + "'>" + exchangeCost + "</label></td>";
	$("#exchangeCostTD").before(tempTDElement);
	
	var equipmentCost = organizationBudgetInfo.equipmentCost;
	if(equipmentCost == null) {
		equipmentCost = "";
	}
	tempTDElement = "<td><label id = 'equipmentCost_" + index + "'>" + equipmentCost + "</label></td>";
	$("#equipmentCostTD").before(tempTDElement);
	
	var consultCost = organizationBudgetInfo.consultCost;
	if(consultCost == null) {
		consultCost = "";
	}
	tempTDElement = "<td><label id = 'consultCost_" + index + "'>" + consultCost + "</label></td>";
	$("#consultCostTD").before(tempTDElement);
	
	var serviceCost = organizationBudgetInfo.serviceCost;
	if(serviceCost == null) {
		serviceCost = "";
	}
	tempTDElement = "<td><label id = 'serviceCost_" + index + "'>" + serviceCost + "</label></td>";
	$("#serviceCostTD").before(tempTDElement);
	
	var printCost = organizationBudgetInfo.printCost;
	if(printCost == null) {
		printCost = "";
	}
	tempTDElement = "<td><label id = 'printCost_" + index + "'>" + printCost + "</label></td>";
	$("#printCostTD").before(tempTDElement);
	
	var manageCost = organizationBudgetInfo.manageCost;
	if(manageCost == null) {
		manageCost = "";
	}
	tempTDElement = "<td><label id = 'manageCost_" + index + "'>" + manageCost + "</label></td>";
	$("#manageCostTD").before(tempTDElement);
	
	var otherCost = organizationBudgetInfo.otherCost;
	if(otherCost == null) {
		otherCost = "";
	}
	tempTDElement = "<td><label id = 'otherCost_" + index + "'>" + otherCost + "</label></td>";
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