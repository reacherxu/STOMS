var budgetType;

$(document).ready(function(){
	
	
	consoleResponseInUnusabalEnvirenment();
	
	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"项目查询",
	                	"href":""
	                 },
	                 {
		                	"name":"项目信息审核",
		                	"href":"Page/Admin/projectAudit/projectInfoAuditList.jsp"
		                 },
	                 {
	                	"name":"项目信息",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	
	console.log("project audit view !");
	
	//如果itemPK为空，则将itemPK置为"0"
	if(itemPK == undefined || itemPK == "") {
		console.log("item is empty!");
		itemPK = "0";
	} else {
		console.log("itemPK ： " + itemPK);
	}
	
	$("#projectAuditApproveButton").click(function() {
		
		openGeneralAssureDialog("通过审核,确定?", 
				function(){ generalAjaxCallToLoadData("projectInfoAuditApprove.action", {"itemPK":itemPK}, showProjectAuditResult); }, 
				{} );
    });	

	$("#projectAuditRejectButton").click(function() {
		
		openGeneralAssureDialog("不通过审核,确定?", 
				function(){ generalAjaxCallToLoadData("projectInfoAuditReject.action", {"itemPK":itemPK}, showProjectAuditResult); }, 
				{});
    });	
	
	
	//异步取得页面的初始化信息和该项目的详细信息
	generalAjaxCallToLoadData("acquireInfoToInitializePage.action",{"itemPK":itemPK}, initializePage);
	
});
function initializePage(data) {
	
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	
	var itemInfo = data.jsonResult.itemInfo;
	console.log(itemInfo);
	
	//如果项目信息返回为空，则返回
	if(itemInfo == undefined) {
		console.log("Item info is null!");
		return false;
	}
	
	$("#contractID").html(itemInfo.contractId);
	$("#itemName").html(itemInfo.itemName);
	$("#itemType").html(itemInfo.typeName);
	$("#isCross").html(isCrossArrayGlobalVariable[itemInfo.isCross]);
	$("#teacherName").html(itemInfo.teacherName);
	$("#teacherID").html(itemInfo.teacherId);
	$("#departmentName").html(itemInfo.departmentName);
	$("#departmentType").html(itemInfo.departmentType);
	$("#itemValue").html(itemInfo.itemValue);
	$("#cardID").html(itemInfo.cardId);
	$("#timeLower").html(itemInfo.timeLower);
	$("#timeUpper").html(itemInfo.timeUpper);
	$("#applyYear").html(itemInfo.applyYear);
	
	budgetType = itemInfo.projectType.budgetType;
}

function budgetDetailInfoView() {
	
	var detailInfoUrl = "";

	switch (budgetType)
	   {
	   case 1:
		   detailInfoUrl = "Page/Teacher/projectManagement/provincialFundBudgetView.jsp?itemPk=" + itemPK;
	     break;
	   case 2:
		   detailInfoUrl = "Page/Teacher/projectManagement/nationalFundBudgetView.jsp?itemPk=" + itemPK;
	     break;
	   case 3:
		   detailInfoUrl = "Page/Teacher/projectManagement/nation863ViewForm.jsp?itemPk=" + itemPK + "&indexOfBudget=0";
	     break;
	   case 4:
		   detailInfoUrl = "Page/Teacher/projectManagement/socialScienceFundBudgetView.jsp?itemPk=" + itemPK;
	     break;
	   default:
		   //detailInfoUrl = "Page/Common/pageError.jsp";
		   openGeneralAssureDialog("该项目类型没有预算信息！");
	   	   return;
	}
	parent.pageTransition(detailInfoUrl);
}

function showProjectAuditResult( data ) {
	
	if(!data.actionStatus) {
		openGeneralMessageDialogThenGoBack("项目审批失败，请重试！");
	} else {
		
		openGeneralMessageDialogThenGoBack("恭喜您，项目审批成功！");
	}
}