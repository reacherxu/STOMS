/**
 * @author clj
 */

$(document).ready(function(){
	
	
//	isViewPage = true;
//	outlayPK = 11;
//	itemPK = 27;
	
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"我的项目",
	                	"href":"Page/Teacher/projectManagement/projectRegistrationList.jsp"
	                 },
	                 {
		                	"name":"支出登记历史",
		                	"href":"Page/Teacher/payRegistration/863OutlayHistory.jsp?itemPK=" + itemPK
		             },
	                 {
	                	"name":"支出登记",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	/*
	$("tr").hover(
  			function() {$(this).css("background","#E2E4FF");} ,
  			function() {$(this).css("background","transparent");} 
  			);
	*/
	//resetForm();
	
	console.log("863 Outlay Form!");
	
	console.log("outlayPK:" + outlayPK);
	
	console.log("pageType:" + pageType);
	
	//如果itemPK为空，则将itemPK置为"0"
	if(itemPK == undefined || itemPK == "" || itemPK == null) {
		console.log("item is empty!");
		itemPK = "0";
	} else {
		
		console.log("itemPK ： " + itemPK);
	}
	
	//如果outlayPK为空，则将outlayPK置为"0"
	if(outlayPK == undefined || outlayPK == "" || outlayPK == null) {
		console.log("outlayPK is empty!");
		outlayPK = "0";
	} else {
		
		console.log("outlayPK ： " + outlayPK);
	}
	
	//$("#provincialOutlayForm").validationEngine("attach");	
  	
	
	//点击提交按钮时的响应事件
    $("#nation863OutlaySubmitButton").click(function(check) {
    	
		var a863OutlayInfo = acquireFormData();
    	
    	console.log(a863OutlayInfo);
    	generalAjaxCallToLoadData("storeA863OutlayInfo.action",a863OutlayInfo, showSubmitingResult);
       
        check.preventDefault();//此处阻止提交表单 
    });
    
    /*
    //根据页面是否提供 isViewPage && outlayPK来决定要否初始成只读页
	if(isViewPage == "true"){
		
		 document.getElementById("nation863OutlaySubmitButton").style.display = "none";
		 document.getElementById("nation863OutlayResetButton").style.display = "none";
		 
		 if(outlayPK != undefined || outlayPK != "" || outlayPK != null){
			 
			 generalAjaxCallToLoadData("acquireOneOutlayInfo.action",{"outlayPK":outlayPK}, initializeOneOutlayViewInfo);
		 }
	}
  	
    
    
   generalAjaxCallToLoadData("acquire863OutlyBudgetInfo.action",{"itemPK":itemPK}, initializeThisPage);
   */
    
    console.log("pageType : " + pageType);
    if(pageType == "view") {
    	hideTableColumn("a863OutlayFormTalbe", 2);
    	hideTableColumn("a863OutlayFormTalbe", 3);
    	$("input").attr("readonly", "readonly");
		$("textarea").attr("readonly", "readonly");
		$("#nation863OutlaySubmitButton").hide();
		$("#nation863OutlayResetButton").hide();
    } else
    	if(pageType == "finalStatement") {
    		hideTableColumn("a863OutlayFormTalbe", 3);
    		hideTableColumn("a863OutlayFormTalbe", 4);
    		hideTableColumn("a863OutlayFormTalbe", 5);
    		$("input").attr("readonly", "readonly");
    		$("textarea").attr("readonly", "readonly");
    		$("#nation863OutlaySubmitButton").hide();
    		$("#nation863OutlayResetButton").hide();
    	}
	
	generalAjaxCallToLoadData("acquire863OutlayInfoByItemPKAndOutlayPK.action",{"itemPK":itemPK,"outlayPK":outlayPK}, initializeThisPage);
	
});

//初始化页面成只读页面
function initializeOneOutlayViewInfo(data){
	
	if(!data.actionStatus) {
		console.log("initializError!");
		return false;
	}
	
	console.log(data);
	
	a863OutlayInfo = data.jsonResult;
	
	$("#buyCost_RealOutGoings").val(a863OutlayInfo.buyEquipment);
	$("#tryToMakeCost_RealOutGoings").val(a863OutlayInfo.trialEquipment);
	$("#reformLeaseCost_RealOutGoings").val(a863OutlayInfo.transform);
	$("#equipmentCost_RealOutGoings").val(a863OutlayInfo.equipmentCost);
	$("#materialCost_RealOutGoings").val(a863OutlayInfo.materialCost);
	$("#testCost_RealOutGoings").val(a863OutlayInfo.testCost);
	$("#fuelCost_RealOutGoings").val(a863OutlayInfo.fuelCost);
	$("#travelCost_RealOutGoings").val(a863OutlayInfo.travelCost);
	$("#conferenceCost_RealOutGoings").val(a863OutlayInfo.conferenceCost);
	$("#internationalCost_RealOutGoings").val(a863OutlayInfo.exchangeCost);
	$("#publishCost_RealOutGoings").val(a863OutlayInfo.publishCost);
	$("#labourCost_RealOutGoings").val(a863OutlayInfo.serviceCost);
	$("#consultationCost_RealOutGoings").val(a863OutlayInfo.consultCost);
	$("#otherCost_RealOutGoings").val(a863OutlayInfo.otherCost);
	$("#outGoings_RealOutGoings").val(a863OutlayInfo.costSum);
	$("#achievementsCost_RealOutGoings").val(a863OutlayInfo.performanceCost);
	$("#indirectCost_RealOutGoings").val(a863OutlayInfo.indirectCost);
	$("#directCost_RealOutGoings").val(a863OutlayInfo.directCost);
}


//页面初始化
function initializeThisPage(data){
	
	if(!data.actionStatus) {
		console.log("initializError!");
		return false;
	}
	
	console.log(data.jsonResult);
	
	
 	var a863ItemInfo   = data.jsonResult.A863itemInfo;
 	var a863ActualFundBudget = data.jsonResult.A863njubudgetInfo;
 	var A863njuBudgetSumUsed  = data.jsonResult.A863njuBudgetSumUsed;
 	var current863OutlayInfo =  data.jsonResult.current863OutlayInfo;
 	var a863RemarkInfo = data.jsonResult.A863RemarkInfo;
	
  	var a863DataBaseNameArry = 
			["buyEquipment","trialEquipment","transform","equipmentCost",
			 "materialCost","testCost","fuelCost","travelCost",
			 "conferenceCost","exchangeCost","publishCost","serviceCost",
			 "consultCost","constructionCost","otherCost","costSum","performanceCost",
			 "indirectCost","directCost"];
		
	var a863PageNameArry = 
			["buyCost","tryToMakeCost","reformLeaseCost","equipmentCost",
		      "materialCost","testCost","fuelCost","travelCost",
		      "conferenceCost","internationalCost","publishCost","labourCost",
		      "consultationCost","constructionCost","otherCost","outGoings","achievementsCost",
		      "indirectCost","directCost"];
	
	$("#itemName").html(a863ItemInfo.itemName);
	$("#contractId").html(a863ItemInfo.contractId);
	$("#teacherName").html(a863ItemInfo.teacherName);
	
  	for(var i = 0; i < a863DataBaseNameArry.length; i++){
  		
  		$('#'+ a863PageNameArry[i]+ "_ActualFundBudget").html(a863ActualFundBudget[a863DataBaseNameArry[i]]);
  		var tempA863njuBudgetSumUsed = A863njuBudgetSumUsed[i];
  		if(tempA863njuBudgetSumUsed == null || tempA863njuBudgetSumUsed.length == 0) {
  			tempA863njuBudgetSumUsed = 0;
  		}
  		$('#'+ a863PageNameArry[i]+ "_Current").html( tempA863njuBudgetSumUsed );
  		$('#'+ a863PageNameArry[i]+ "_Balance").html( a863ActualFundBudget[a863DataBaseNameArry[i]] - tempA863njuBudgetSumUsed );
  		$('#'+ a863PageNameArry[i]+ "_RealOutGoings").val( current863OutlayInfo[a863DataBaseNameArry[i]] );
  		$('#'+ a863PageNameArry[i]+ "_Remark").val( a863RemarkInfo[a863DataBaseNameArry[i]] );
  	}
 	
}


//获取页面信息，只取两个表
function acquireFormData(){
  	var a863OutlayInfo = {};
 
  	a863OutlayInfo["itemPK"] = itemPK;
  	a863OutlayInfo["outlayPK"] = outlayPK;
  		
  	var a863DataBaseNameArry = 
  			["buyEquipment","trialEquipment","transform","equipmentCost",
  			 "materialCost","testCost","fuelCost","travelCost",
  			 "conferenceCost","exchangeCost","publishCost","serviceCost",
  			 "consultCost","constructionCost","otherCost","costSum","performanceCost",
  			 "indirectCost","directCost"];
  		
  	var a863PageNameArry = 
  			["buyCost","tryToMakeCost","reformLeaseCost","equipmentCost",
  		      "materialCost","testCost","fuelCost","travelCost",
  		      "conferenceCost","internationalCost","publishCost","labourCost",
  		      "consultationCost","constructionCost","otherCost","outGoings","achievementsCost",
  		      "indirectCost","directCost"];
  		
  	for(var i = 0; i < a863DataBaseNameArry.length; i++){

  		a863OutlayInfo[a863DataBaseNameArry[i] + "_RealOutGoings"] 
		   = $('#'+a863PageNameArry[i]+"_RealOutGoings").val();
  		
  		a863OutlayInfo[a863DataBaseNameArry[i] + "_Remark"] 
		   = $('#'+a863PageNameArry[i]+"_Remark").val();
  		
  	}
  		
  	return a863OutlayInfo;
}
	
function showSubmitingResult(data) {
		
  	if(!data.actionStatus) {
  		alert("预算信息提交失败，请重试！");
  	} else {
  		alert("预算信息提交成功！");
  	}
}

//重置表框
function resetForm(){
  		
  	var trObjects = $('tr');
  	for(var i = 3; i < trObjects.length; i++){
  		
  		trObjects[i].children[3].children[0].value = 0;
  	}
}

function hideTableColumn(tableID, nCol)
{   
	var tempWidget = $("#" + tableID + " tr").find('td:eq(' + nCol + ')');
	
	$(tempWidget).hide();
} 