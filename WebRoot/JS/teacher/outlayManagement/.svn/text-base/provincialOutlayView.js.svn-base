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
	                	"name":"支出登记",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	console.log("provincial FundBudget!");
  	
//  	$("tr").hover(
//  			function() {$(this).css("background","#E2E4FF");} ,
//  			function() {$(this).css("background","transparent");} 
//  			);
  	
	//如果itemPK为空，则将itemPK置为"0"
	if(itemPK == undefined || itemPK == "") {
		console.log("item is empty!");
		itemPK = "0";
	} else {
		console.log("outlayPk ： " + outlayPk);
		console.log("itemPK ： " + itemPK);
	}
	
	var tempSubmitData = {"outlayPk":outlayPk, "itemPK":itemPK};
	//异步取得国家基金项目的详细信息，初始化页面
	generalAjaxCallToLoadData("acquireProvincialOutlayView.action", tempSubmitData, initializeProvincialOutlayView);
	
	$("input").attr("readonly", "readonly");
});

//初始化页面
function initializeProvincialOutlayView(data){
	
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
	var agencyFundOutlayInfo = data.jsonResult.agencyFundOutlayInfo;
	var selfFundOutlayInfo = data.jsonResult.selfFundOutlayInfo;
	var sumFundOutlayInfo = data.jsonResult.sumFundOutlayInfo;		
	
	if(itemPK != "0") {
		
		$("#itemName").html(itemInfo.itemName);
		$("#contractID").html(itemInfo.contractId);
		$("#teacherName").html(itemInfo.teacherName);
		
		for( var i = 0; i<provincialFundItemNameArray.length; i++ ) {

			$("#agency"+provincialFundItemNameArray[i]).val(agencyFundOutlayInfo[provincialFundItemModelNameArray[i]]);
			$("#self"+provincialFundItemNameArray[i]).val(selfFundOutlayInfo[provincialFundItemModelNameArray[i]]);
			$("#sum"+provincialFundItemNameArray[i]).html(sumFundOutlayInfo[provincialFundItemModelNameArray[i]]);
		}
		
		$("#agencyTotal").html(agencyFundOutlayInfo.sumCost);
		$("#selfTotal").html(selfFundOutlayInfo.sumCost);	
		$("#sumTotal").html(sumFundOutlayInfo.sumCost);
	}	
}