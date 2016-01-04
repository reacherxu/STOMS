var teacherOutlayStatisticsListTable;

$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"经费统计",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	$( "#startDate" ).datepicker({
		showOn: 'button',
		buttonImage: "JqueryLib/css/datepickerCss/images/calendar.gif",
		buttonImageOnly: true,
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd"
	}).unbind('blur');
	
	$( "#endDate" ).datepicker({
		showOn: 'button',
		buttonImage: "JqueryLib/css/datepickerCss/images/calendar.gif",
		buttonImageOnly: true,
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd"
	}).unbind('blur');
	
	//初始化时间空间的默认值
	var currentDate = new Date();
	var currentYear = currentDate.getFullYear();
	var defaultStartDate = currentYear + "-01-01";
	var defaultEndDate = currentYear + "-12-31";
	$( "#startDate" ).val(defaultStartDate);
	$( "#endDate" ).val(defaultEndDate);
	
	//由于CSS样式包冲突，手动关闭日期控件
	$("#ui-datepicker-div")[0].style.display = "none";
	
	var tableData = new Array();
	var tableTagArray = new Array();
	
	tableTagArray.push({ "sTitle": "项目名", "sClass": "center", "sWidth": "20%",
		"fnRender": function(obj){
			 var itemName = obj.aData[ obj.iDataColumn];
			 var itemID = obj.aData[ obj.iDataColumn + 1];
			 var tempItemInfo = {"itemID":itemID};
			 var tempItemInfoStr = jsonToString(tempItemInfo);
			 var tempHref = "<a onclick = \"detailInfoButtonResponse(" + tempItemInfoStr + ")\">" + itemName + "</a>";
			 return tempHref;
		 }});
	tableTagArray.push({ "sTitle": "项目代码", "sClass": "center", "bVisible": false, "bSearchable": false });
	tableTagArray.push({ "sTitle": "课题编号", "sClass": "center", "sWidth": "15%" });
	tableTagArray.push({ "sTitle": "入账", "sClass": "center", "sWidth": "10%" });
	tableTagArray.push({ "sTitle": "支出", "sClass": "center", "sWidth": "10%" });
	tableTagArray.push({ "sTitle": "总入账", "sClass": "center", "sWidth": "15%" });
	tableTagArray.push({ "sTitle": "总支出", "sClass": "center", "sWidth": "15%" });
	tableTagArray.push({ "sTitle": "总结余", "sClass": "center", "sWidth": "15%" });
	
	teacherOutlayStatisticsListTable = $("#teacherOutlayStatisticsListTable").dataTable({
	    "aaData": tableData,
	    "aoColumns": tableTagArray,
	    "bLengthChange": false,
	    "bJQueryUI": true,
	    "oLanguage": dataTableLanguageGlobalVariable,
	    "sScrollX": "100%",
	    "sScrollXInner": "100%",
	    "sPaginationType": "full_numbers"
	});
	
});

function detailInfoButtonResponse(tempItemInfo) {
	var itemID = tempItemInfo.itemID;
	
	var detailInfoUrl = "Page/Teacher/inAccountApplication/inAccountApplicationList.jsp?itemID=" + itemID;
	parent.pageTransition(detailInfoUrl);
}

//教师端统计查询，查看在查询时间范围内的特定项目类型的入账和支出情况
function teacherOutlayStatisticsQuery() {
	
	var iscross = $("#iscross").find("option:selected").val();
	iscross = $.trim(iscross);
	
	
	var startDate = $("#startDate").val();
	startDate = $.trim(startDate);
	if(startDate == null || startDate.length == 0) {
		startDate = "";
	}
	
	var endDate = $("#endDate").val();
	endDate = $.trim(endDate);
	if(endDate == null || endDate.length == 0) {
		endDate = "";
	}
	
	//"YYYY-MM-DD"日期格式正则表达式
	var ex = /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/;
	var pattern = new RegExp(ex);
	
	//判断开始日期格式是否为"YYYY-MM-DD"
	if(startDate.length > 0 && !pattern.test(startDate)) {
		alert("开始日期格式有误，格式为\"YYYY-MM-DD\"");
		return false;
	}
	//判断结束日期格式是否为"YYYY-MM-DD"
	if(endDate.length > 0 && !pattern.test(endDate)) {
		alert("结束日期格式有误，格式为\"YYYY-MM-DD\"");
		return false;
	}
	
	var submitDatas = {
			"isCross":iscross,
			"startDate":startDate,
			"endDate":endDate
	};
	
	generalAjaxCallToLoadData("teacherOutlayStatisticsQuery.action",submitDatas,renderAllQueryResult);
}

//显示查询的结果
function renderAllQueryResult(data) {
	
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	
	var teacherOutlayStatisticsQueryResult = data.jsonResult;
	console.log(teacherOutlayStatisticsQueryResult);
	
	//清空表格内的数据
	teacherOutlayStatisticsListTable.fnClearTable();
	
	
	for(var i = 0; i < teacherOutlayStatisticsQueryResult.length; i++) {
		
		var tempItemInfo = teacherOutlayStatisticsQueryResult[i];
		var tempRowData = new Array();
		tempRowData.push(tempItemInfo.itemName);
		tempRowData.push(tempItemInfo.itemId);
		tempRowData.push(tempItemInfo.contractId);
		tempRowData.push(tempItemInfo.addOutlay);
		tempRowData.push(tempItemInfo.outlay);
		tempRowData.push(tempItemInfo.sumaddoutlay);
		tempRowData.push(tempItemInfo.sumoutlay);
		tempRowData.push(tempItemInfo.sumbalance);
		
		//添加一行数据
		teacherOutlayStatisticsListTable.fnAddData( tempRowData );
	}
	
	/*
	if(teacherOutlayStatisticsQueryResult.length > 0) {
		var sumDataOfItemStatistics = teacherOutlayStatisticsQueryResult[teacherOutlayStatisticsQueryResult.length - 1];
		$("#sumOfInAccount").html(sumDataOfItemStatistics.addOutlay);
		$("#sumOfInOutlay").html(sumDataOfItemStatistics.outlay);
		//$("#sumOfBalance").html(sumDataOfItemStatistics.balance);
		console.log(sumDataOfItemStatistics);
	}
	*/
	
}