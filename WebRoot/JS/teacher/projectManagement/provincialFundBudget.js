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
		                "href":"Page/Teacher/projectManagement/projectRegistration.jsp?itemPK=" + itemPK 
		             },
	                 {
	                	"name":"预算信息",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	console.log("provincial FundBudget!");
//  	
//  	$("tr").hover(
//  			function() {$(this).css("background","#E2E4FF");} ,
//  			function() {$(this).css("background","transparent");} 
//  			);
  	
	//如果itemPK为空，则将itemPK置为"0"
	if(itemPK == undefined || itemPK == "") {
		console.log("item is empty!");
		itemPK = "0";
	} else {
		
		console.log("itemPK ： " + itemPK);
	}
	
//	 //点击保存按钮时的响应事件
//    $("#provincialFundSavaButton").click(function(check) {
//    	
//        console.log("provincialFundSaveButton");
//        var tempFormData = acquireFormData();
//        console.log(tempFormData);
//        
//		//异步调用
//		generalAjaxCallToLoadData("saveProvincialFundInfo.action",tempFormData, showSavingResult);
//        check.preventDefault();//此处阻止提交表单
//    });
//    
    
	$("#provincialFundBudgetForm").validationEngine("attach");	
	//点击提交按钮时的响应事件
    $("#provincialFundSubmitButton").click(function(check) {
        if($("#provincialFundBudgetForm").validationEngine('validate')){
        	console.log("provincialFundSubmitButton");
        	var tempFormData = acquireFormData();
        	generalAjaxCallToLoadData("submitProvincialFundInfo.action",tempFormData, showSubmitingResult);
        }
        check.preventDefault();//此处阻止提交表单  
    });
    

	//异步取得国家基金项目的详细信息，初始化页面
	generalAjaxCallToLoadData("acquireProvincialFundInfo.action",{"itemPK":itemPK}, initializeProvincialFundInfo);

	
	
	//绑定所有控件的统计函数
	$("input[id^='actualFund']" ).bind( "blur", function(){
		
		setProvincialSum();
		setActualSum();
	});
	


	
	//载入当前项目的附件列表
	refreshPicList();
});

function setProvincialSum( ) {
	
	var sumResult = 0;
	
	$("input[id^='actualFundBudget']" ).each( function() {
		sumResult += getInputInt( $(this).val() );
	});
	
	$("#actualFundBudgetTotal").html(sumResult);
}

function setActualSum ( ) {
	
	var sumResult = 0;
	
	sumResult += getInputInt( $("#actualFundNationFund").val() );
	sumResult += getInputInt( $("#actualFundAgencyFund").val() );
	sumResult += getInputInt( $("#actualFundCountyFund").val() );
	sumResult += getInputInt( $("#actualFundDepartmentFund").val() );
	sumResult += getInputInt( $("#actualFundSelfFund").val() );
	sumResult += getInputInt( $("#actualFundOtherFund").val() );
	
	$("#actualFundTotal").html(sumResult);
}

function getInputInt( tempValue){
	
	if(isNaN(parseInt(tempValue, 10 ) )) {
		return parseInt("0");
	}

	return parseInt(tempValue);
}


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

//获得省基金项目数据
function acquireFormData(){
	
	var formData = {};
	
	var provincialFundItemNameArray 
	= ["StaffCost", "EquipmentCost", "FuelCost", "MaterialCost", "TestCost", 
	   "TravelCost","ConferenceCost", "PublishCost", "ManageCost", "OtherCost"];
	
	formData["itemPK"] = itemPK;
	formData["itemName"] = $("#itemName").html();
	formData["itemId"] = $("#itemId").html();
	formData["teacherName"] = $("#teacherName").html();

	//实际到位
	formData["actualNationFund"] = $("#actualFundNationFund").val();
	formData["actualAgencyFund"] = $("#actualFundAgencyFund").val();
	formData["actualCountyFund"] = $("#actualFundCountyFund").val();
	formData["actualDepartmentFund"] = $("#actualFundDepartmentFund").val();
	formData["actualSelfFund"] = $("#actualFundSelfFund").val();
	formData["actualOtherFund"] = $("#actualFundOtherFund").val();
	formData["actualFundTotal"] = $("#actualFundTotal").html();
	
	//保存数据到json
	for( var i = 0; i<provincialFundItemNameArray.length; i++ ) {
		
		formData[ "actualFundBudget"+provincialFundItemNameArray[i] ] 
		= $("#actualFundBudget"+provincialFundItemNameArray[i]).val();
	}
	
	formData["actualFundBudgetTotal"] = $("#actualFundBudgetTotal").html();


	return formData;
		
}

function resetForm(){
	$( "#provincialFundBudgetForm" )[0].reset();
	$( "label[id$='Total']" ).html("");
}

////反馈保存操作的状态
//function showSavingResult(data) {
//	
//	if(!data.actionStatus) {
//		openGeneralMessageDialog("预算信息保存失败，请重试");
//	} else {
//		openGeneralMessageDialog("预算信息保存成功！");
//	}
//}

//反馈提交操作的状态
function showSubmitingResult(data) {
	
	if(!data.actionStatus) {
		openGeneralMessageDialog("预算信息提交失败，请重试！");
	} else {
		resetForm();
		openGeneralMessageDialogThenGoBack("预算信息提交成功！");

	}
}
