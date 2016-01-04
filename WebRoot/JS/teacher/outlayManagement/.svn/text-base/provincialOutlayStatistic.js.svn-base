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
		                	"name":"支出登记历史",
		                	"href":"Page/Teacher/payRegistration/provincialOutlayHistory.jsp?itemPK=" + itemPK
		             },
	                 {
	                	"name":"决算表",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	

//  	$("tr").hover(
//  			function() {$(this).css("background","#E2E4FF");} ,
//  			function() {$(this).css("background","transparent");} 
//  			);
  	
	//如果itemPK为空，则将itemPK置为"0"
	if(itemPK == undefined || itemPK == "" || itemPK == null) {
		console.log("item is empty!");
		itemPK = "0";
	} else {
		
		console.log("itemPK ： " + itemPK);
	}
	
	//取得改项目的基本信息，初始化页面
	generalAjaxCallToLoadData("acquireProvincialStatistic.action",{"itemPK":itemPK}, initializeProvincialStatistic);

});

//初始化页面
function initializeProvincialStatistic(data){

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
	var actualFundBudgetInfo = data.jsonResult.actualFundBudgetInfo;
	var columnSumInfo = data.jsonResult.columnSumInfo;
	
	if(itemPK != "0") {
		
		$("#itemName").html(itemInfo.itemName);
		$("#contractID").html(itemInfo.contractId);
		$("#teacherName").html(itemInfo.teacherName);
		
		for( var i = 0; i<provincialFundItemNameArray.length; i++ ) {

			$("#actualFundBudget"+provincialFundItemNameArray[i]).html(actualFundBudgetInfo[provincialFundItemModelNameArray[i]]);
		
			$("#current"+provincialFundItemNameArray[i]).html( columnSumInfo[i] );
		}
		$("#actualFundBudgetTotal").html(actualFundBudgetInfo.sumCost);
		$("#currentTotal").html(columnSumInfo[10] );
	}
}
