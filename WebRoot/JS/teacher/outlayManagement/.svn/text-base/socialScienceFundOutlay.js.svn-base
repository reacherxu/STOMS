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
		                	"href":"Page/Teacher/payRegistration/socialScienceFundOutlayList.jsp?itemPK=" 
		    					+ itemPK
		             },
	                 {
	                	"name":"支出登记",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
  	$("tr").hover(
  			function() {$(this).css("background","#E2E4FF");} ,
  			function() {$(this).css("background","transparent");} 
  			);
	
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
	
	//点击提交按钮时的响应事件
    $("#socialScienceFundOutlaySubmitButton").click(function(check) {
    	
		var socialScienceFundOutlayInfo = acquireFormData();
    	
    	console.log(socialScienceFundOutlayInfo);
    	generalAjaxCallToLoadData("storeSocialScienceFundOutlayInfo.action",socialScienceFundOutlayInfo, showSubmitingResult);
       
        check.preventDefault();//此处阻止提交表单 
    });
    
    console.log("pageType : " + pageType);
    if(pageType == "view") {
    	hideTableColumn("socialScienceFundOutlayTable", 2);
    	hideTableColumn("socialScienceFundOutlayTable", 3);
    	$("input").attr("readonly", "readonly");
		$("textarea").attr("readonly", "readonly");
		$("#socialScienceFundOutlaySubmitButton").hide();
		$("#socialScienceFundOutlayResetButton").hide();
    } else
    	if(pageType == "finalStatement") {
    		hideTableColumn("socialScienceFundOutlayTable", 3);
    		hideTableColumn("socialScienceFundOutlayTable", 4);
    		hideTableColumn("socialScienceFundOutlayTable", 5);
    		$("input").attr("readonly", "readonly");
    		$("textarea").attr("readonly", "readonly");
    		$("#socialScienceFundOutlaySubmitButton").hide();
    		$("#socialScienceFundOutlayResetButton").hide();
    	}
    
    
	generalAjaxCallToLoadData("acquireSocialScienceFundOutlayInfo.action",{"itemPK":itemPK,"outlayPK":outlayPK}, initializeThisPage);
	
});

//页面初始化
function initializeThisPage(data){
	
	if(!data.actionStatus) {
		console.log("initializError!");
		return false;
	}
	
	console.log(data.jsonResult);
	
	
 	var socialScienceFundItemInfo   = data.jsonResult.socialScienceFundItemInfo;
 	var socialScienceFundNjuBudgetInfo = data.jsonResult.socialScienceFundNjuBudgetInfo;
 	var socialScienceBudgetAccumulatedInfo  = data.jsonResult.socialScienceBudgetAccumulatedInfo;
 	var socialScienceFundOutlayInfo =  data.jsonResult.socialScienceFundOutlayInfo;
 	var socialScienceFundOutlayRemarkInfo = data.jsonResult.socialScienceFundOutlayRemarkInfo;
	
  	var socialScienceFundDataBaseNameArry = 
			["materialCost","dataCost","travelCost","conferenceCost",
			 "exchangeCost","equipmentCost","consultCost","serviceCost",
			 "printCost","manageCost","otherCost"];
	
	$("#itemName").html(socialScienceFundItemInfo.itemName);
	$("#contractId").html(socialScienceFundItemInfo.contractId);
	$("#teacherName").html(socialScienceFundItemInfo.teacherName);
	
  	for(var i = 0; i < socialScienceFundDataBaseNameArry.length; i++){
  		
  		$('#'+ socialScienceFundDataBaseNameArry[i]+ "_budget").html(socialScienceFundNjuBudgetInfo[socialScienceFundDataBaseNameArry[i]]);
  		var tempsocialScienceBudgetAccumulatedInfo = socialScienceBudgetAccumulatedInfo[i];
  		if(tempsocialScienceBudgetAccumulatedInfo == null || tempsocialScienceBudgetAccumulatedInfo.length == 0) {
  			tempsocialScienceBudgetAccumulatedInfo = 0;
  		}
  		$('#'+ socialScienceFundDataBaseNameArry[i]+ "_accumulation").html( tempsocialScienceBudgetAccumulatedInfo );
  		$('#'+ socialScienceFundDataBaseNameArry[i]+ "_balance").html( socialScienceFundNjuBudgetInfo[socialScienceFundDataBaseNameArry[i]] - tempsocialScienceBudgetAccumulatedInfo );
  		$('#'+ socialScienceFundDataBaseNameArry[i]+ "_currentOutlay").val( socialScienceFundOutlayInfo[socialScienceFundDataBaseNameArry[i]] );
  		$('#'+ socialScienceFundDataBaseNameArry[i]+ "_remark").val( socialScienceFundOutlayRemarkInfo[socialScienceFundDataBaseNameArry[i]] );
  	}
 	
}


//获取页面信息，只取两个表
function acquireFormData(){
  	var socialScienceFundOutlayInfo = {};
 
  	socialScienceFundOutlayInfo["itemPK"] = itemPK;
  	socialScienceFundOutlayInfo["outlayPK"] = outlayPK;
  		
  	var socialScienceFundDataBaseNameArry = 
		["materialCost","dataCost","travelCost","conferenceCost",
		 "exchangeCost","equipmentCost","consultCost","serviceCost",
		 "printCost","manageCost","otherCost"];
  		
  	
  	for(var i = 0; i < socialScienceFundDataBaseNameArry.length; i++){

  		socialScienceFundOutlayInfo[socialScienceFundDataBaseNameArry[i] + "_currentOutlay"] 
		   = getNumberInputWidgetValue(socialScienceFundDataBaseNameArry[i]+"_currentOutlay");
  		
  		socialScienceFundOutlayInfo[socialScienceFundDataBaseNameArry[i] + "_remark"] 
		   = getTextAreaWidgetValue(socialScienceFundDataBaseNameArry[i]+"_remark");
  		
  	}
  		
  	return socialScienceFundOutlayInfo;
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

//取得area输入框的值
function getTextAreaWidgetValue(widgetID) {
	
	var tempValue = "";
	tempValue = $("#" + widgetID).val();
	tempValue = $.trim(tempValue);
	
	return tempValue;
}

function showSubmitingResult(data) {
		
  	if(!data.actionStatus) {
  		alert("预算信息提交失败，请重试！");
  	} else {
  		alert("预算信息提交成功！");
  	}
}

function hideTableColumn(tableID, nCol)
{   
	var tempWidget = $("#" + tableID + " tr").find('td:eq(' + nCol + ')');
	
	$(tempWidget).hide();
} 
 