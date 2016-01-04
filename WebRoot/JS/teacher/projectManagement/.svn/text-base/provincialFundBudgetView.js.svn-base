/**
 * @author xjk
 */

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
	
	
	console.log("provincial FundBudget!");

	
	//如果itemPK为空，则将itemPK置为"0"
	if(itemPK == undefined || itemPK == "") {
		console.log("item is empty!");
		itemPK = "0";
	} else {
		
		console.log("itemPK ： " + itemPK);
	}

	//异步取得国家基金项目的详细信息，初始化页面
	generalAjaxCallToLoadData("acquireProvincialFundInfo.action",{"itemPK":itemPK}, initializeProvincialFundInfo);
	
	//载入当前项目的附件列表
	refreshPicList();

	$("input").attr("disabled", "disabled");
	
});

//初始化页面
function initializeProvincialFundInfo(data){
	
	if(!data.actionStatus) {
		console.log("fail");
		return false;
	}
	
	var provincialFundItemNameArray 
	= ["StaffCost", "EquipmentCost", "FuelCost", "MaterialCost", "TestCost", 
	   "TravelCost","ConferenceCost", "PublishCost", "ManageCost", "OtherCost"];
	
	var provincialFundItemModelNameArray
	= ["staffCost", "equipmentCost", "fuelCost", "materialCost", "testCost", 
	   "travelCost","conferenceCost", "publishCost", "manageCost", "otherCost"];

	var itemInfo = data.jsonResult.itemInfo;
	var actualFundItemInfo = data.jsonResult.actualFundItemInfo;
	var actualFundBudgetInfo = data.jsonResult.actualFundBudgetInfo;
	
	if(itemPK != "0") {
		
		$("#itemName").html(itemInfo.itemName);
		$("#contractID").html(itemInfo.contractId);
		$("#teacherName").html(itemInfo.teacherName);
		
		$("#actualFundNationFund").val(actualFundItemInfo.nationFund);
		$("#actualFundAgencyFund").val(actualFundItemInfo.agencyFund);
		$("#actualFundCountyFund").val(actualFundItemInfo.countyFund);
		$("#actualFundDepartmentFund").val(actualFundItemInfo.departmentFund);
		$("#actualFundSelfFund").val(actualFundItemInfo.selfFund);
		$("#actualFundOtherFund").val(actualFundItemInfo.otherFund);
		$("#actualFundTotal").html(actualFundItemInfo.fundSum);
		
		for( var i = 0; i<provincialFundItemNameArray.length; i++ ) {

			$("#actualFundBudget"+provincialFundItemNameArray[i]).val(actualFundBudgetInfo[provincialFundItemModelNameArray[i]]);
		
		}
		
		$("#actualFundBudgetTotal").html(actualFundBudgetInfo.sumCost);
	}
}