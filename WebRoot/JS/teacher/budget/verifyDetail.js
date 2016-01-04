var projectRegistrationDataTable;

$(document).ready(function(){
	consoleResponseInUnusabalEnvirenment();
	
	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"我的项目",
	                	"href":"Page/Teacher/budget/verifyDetail.jsp"
	                 }
	                 ];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	generalAjaxCallToLoadData("findDetail.action",{"itemId":itemId,"param":param},initializePageContent);
});



function initializePageContent(data){
	
	var tableData = new Array();
	
	if(data.actionStatus) {
		
		var itemInfoList = data.jsonResult;
		
		if(itemInfoList.length == 0)
			alert("此项无支出！");
		else {
			for(var i = 0; i < itemInfoList.length; i++) {

				var tempItemInfo = itemInfoList[i];
				var tempRowData = new Array();
				tempRowData.push(tempItemInfo.certificateDate);//凭证日期
				tempRowData.push(tempItemInfo.type);//凭证类型
				tempRowData.push(tempItemInfo.certificateId);//凭证编号
				tempRowData.push(tempItemInfo.abstract_);//摘要	
				tempRowData.push(tempItemInfo.subjectId);//科目编号
				tempRowData.push(tempItemInfo.sector);//部门编号
				tempRowData.push(tempItemInfo.projectId);//项目编号
				tempRowData.push(parseInt(tempItemInfo.expenditure));//借金额	
				tempRowData.push(parseInt(tempItemInfo.loan));//贷金额

				tableData.push(tempRowData);
			}
		}
	} else {
		alert("此项无支出！");
	}
	
	
	var tableTagArray = new Array();
	
	tableTagArray.push({ "sTitle": "凭证日期", "sClass": "center", "sWidth": "10%"});
	
	tableTagArray.push({ "sTitle": "凭证类型", "sClass": "center", "sWidth": "10%" });
	
	tableTagArray.push({ "sTitle": "凭证编号", "sClass": "center", "sWidth": "15%" });
	
	tableTagArray.push({ "sTitle": "摘要", "sClass": "center", "sWidth": "15%"});
	
	tableTagArray.push({ "sTitle": "科目编号", "sClass": "center", "sWidth": "15%"});
	
	tableTagArray.push({ "sTitle": "部门编号", "sClass": "center", "sWidth": "10%"});

	tableTagArray.push({ "sTitle": "项目编号", "sClass": "center", "sWidth": "15%"});

	tableTagArray.push({ "sTitle": "借金额", "sClass": "center", "sWidth": "5%"});

	tableTagArray.push({ "sTitle": "贷金额", "sClass": "center", "sWidth": "5%"});

	
	detailedTable = $("#detailedTable").dataTable({
	        "aaData": tableData,
	        "aoColumns": tableTagArray,
	        "bLengthChange": false,
	        "bJQueryUI": true,
	        "oLanguage": dataTableLanguageGlobalVariable,
	        "sScrollX": "100%",
	        "sScrollXInner": "100%",
	        "sPaginationType": "full_numbers"
	    });
	
}
