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
	
	
	console.log("provincial Outlay Form!");
  	
//  	$("tr").hover(
//  			function() {$(this).css("background","#E2E4FF");} ,
//  			function() {$(this).css("background","transparent");} 
//  			);
//  	
	//如果itemPK为空，则将itemPK置为"0"
	if(itemPK == undefined || itemPK == "" || itemPK == null) {
		console.log("item is empty!");
		itemPK = "0";
	} else {
		
		console.log("itemPK ： " + itemPK);
	}
    
	$("#provincialOutlayForm").validationEngine("attach");	
	//点击提交按钮时的响应事件
    $("#provincialOutlaySubmitButton").click(function(check) {
        if($("#provincialOutlayForm").validationEngine('validate')){

        	var tempFormData = acquireFormData();
        	generalAjaxCallToLoadData("submitProvincialOutlayInfo.action",tempFormData, showSubmitingResult);
        }
        check.preventDefault();//此处阻止提交表单  
    });
    

	//取得改项目的基本信息，初始化页面
	generalAjaxCallToLoadData("acquireProvincialOutlayInfo.action",{"itemPK":itemPK}, initializeProvincialOutlayInfo);
	
	//绑定所有控件的统计函数
	
	$("input[id^='agency']" ).bind( "blur", function(){
    	setProvincialSum(  "agency" );
    });
    
	$("input[id^='self']" ).bind( "blur", function(){
    	setProvincialSum(  "self" );
    });
	
	$("#resetButton").bind( "click", function(){
		resetForm();
    });
	
});

function setProvincialSum(  itemNamePrefix ) {
	
	var sumResult = 0;
	
	$("input[id^='"+ itemNamePrefix + "']" ).each( function() {
		sumResult += getInputInt( $(this).val() );
	});
	
	$("#"+itemNamePrefix+"Total").html(sumResult);
	
	setTotalSum();
}

function setTotalSum() {
	
	var trObjects = $("tr");
  	for(var i = 4; i < trObjects.length-1; i++){
  		var tempValue4 = getInputInt(trObjects[i].children[4].children[0].value);
  		var tempValue5 = getInputInt(trObjects[i].children[5].children[0].value);
  		var tempResult = tempValue4 + tempValue5;
  		trObjects[i].children[6].children[0].innerHTML = tempResult;
  	}
  	
  	var tempSum = getInputInt( $("#agencyTotal").html() )+ getInputInt( $("#selfTotal").html() );
  	$("#sumTotal").html( tempSum );
  
}

function getInputInt( tempValue){
	
	if(isNaN(parseInt(tempValue, 10 ) )) {
		return parseInt("0");
	}

	return parseInt(tempValue);
}


//初始化页面
function initializeProvincialOutlayInfo(data){

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

			
			var tempBudget = actualFundBudgetInfo[provincialFundItemModelNameArray[i]];
			
			$("#actualFundBudget"+provincialFundItemNameArray[i]).html(tempBudget);
			$("#current"+provincialFundItemNameArray[i]).html( getInputInt ( columnSumInfo[i]) );
			
			
			$("#surplus"+provincialFundItemNameArray[i]).html(tempBudget - getInputInt ( columnSumInfo[i]));
			
		}
		
		
		$("#actualFundBudgetTotal").html(actualFundBudgetInfo.sumCost);
		$("#currentTotal").html(columnSumInfo[10] );
		
		
	 	var tempSum = getInputInt( $("#actualFundBudgetTotal").html() ) - getInputInt( $("#currentTotal").html() );
	  	$("#surplusTotal").html( tempSum );
		
	}

}

//获得省基金项目数据
function acquireFormData(){
	
	var formData = {};
	
	var provincialFundItemNameArray 
	= ["StaffCost", "EquipmentCost", "FuelCost", "MaterialCost", "TestCost", 
	   "TravelCost","ConferenceCost", "PublishCost", "ManageCost", "OtherCost"];
	
	formData["itemPK"] = itemPK;
	formData["itemId"] = $("#itemId").html();
	
	//保存数据到json
	for( var i = 0; i<provincialFundItemNameArray.length; i++ ) {
		
		formData[ "agency"+provincialFundItemNameArray[i] ] 
			= $("#agency"+provincialFundItemNameArray[i]).val();
		
		formData[ "self"+provincialFundItemNameArray[i] ] 
			= $("#self"+provincialFundItemNameArray[i]).val();
		
		formData[ "sum"+provincialFundItemNameArray[i] ] 
			= $("#sum"+provincialFundItemNameArray[i]).html();
	}
	
	formData["agencyFundTotal"] = $("#agencyTotal").html();
	formData["selfFundTotal"] = $("#selfTotal").html();	
	formData["sumFundTotal"] = $("#sumTotal").html();

	return formData;
		
}

function resetForm(){
	$( "#provincialOutlayForm" )[0].reset();
	$( "#agencyTotal" ).html("");
	$( "#selfTotal" ).html("");
	$( "label[id^='sum']" ).html("");
}

//反馈提交操作的状态
function showSubmitingResult(data) {
	
	if(!data.actionStatus) {
		openGeneralMessageDialog("支出提交失败，请重试！");
	} else {
		resetForm();
		openGeneralMessageDialogThenGoBack("支出提交成功！");

	}
}
