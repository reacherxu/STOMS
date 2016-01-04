
var itemStatisticsListTable;

$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"项目查询",
	                	"href":""
	                 },
	                 {
	                	"name":"项目统计查询",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	var currentDate = new Date();
	var currentYear = currentDate.getFullYear();
	redrawSelectWidgetOptions("startYear", currentYear);
	$("#startYear").change(function(){
		var tempCurrentSelectValue = $("#startYear").val();
		tempCurrentSelectValue = $.trim(tempCurrentSelectValue);
		
		if(tempCurrentSelectValue.length > 0) {
			redrawSelectWidgetOptions("startYear", tempCurrentSelectValue);
		}
	});
	
	redrawSelectWidgetOptions("endYear", currentYear);
	$("#endYear").change(function(){
		var tempCurrentSelectValue = $("#endYear").val();
		tempCurrentSelectValue = $.trim(tempCurrentSelectValue);
		
		if(tempCurrentSelectValue.length > 0) {
			redrawSelectWidgetOptions("endYear", tempCurrentSelectValue);
		}
	});
	
	var tableData = new Array();
	var tableTagArray = new Array();
	
	tableTagArray.push({ "sTitle": "项目名", "sClass": "center", "sWidth": "40%" });
	tableTagArray.push({ "sTitle": "项目代码", "sClass": "center", "sWidth": "15%" });
	tableTagArray.push({ "sTitle": "入账", "sClass": "center", "sWidth": "15%" });
	tableTagArray.push({ "sTitle": "支出", "sClass": "center", "sWidth": "15%" });
	tableTagArray.push({ "sTitle": "结余", "sClass": "center", "sWidth": "15%" });
	
	itemStatisticsListTable = $("#itemStatisticsListTable").dataTable({
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


//项目统计查询
function itemStatisticsQuery() {
	
	var iscross = $("#iscross").find("option:selected").val();
	iscross = $.trim(iscross);
	
	var startYear = $("#startYear").val();
	startYear = $.trim(startYear);
	if(startYear == null || startYear.length == 0) {
		startYear = "";
	}
	
	var endYear = $("#endYear").val();
	endYear = $.trim(endYear);
	if(endYear == null || endYear.length == 0) {
		endYear = "";
	}
	
	//"YYYY-MM-DD"日期格式正则表达式
	var ex = /^(19|20)[0-9][0-9]$/;
	var pattern = new RegExp(ex);
	
	//判断开始日期格式是否为"YYYY"
	if(startYear.length > 0 && !pattern.test(startYear)) {
		alert("请输入有效的开始年度，格式为\"2012\"");
		return false;
	}
	//判断结束日期格式是否为"YYYY"
	if(endYear.length > 0 && !pattern.test(endYear)) {
		alert("请输入有效的结束年度，格式为\"2012\"");
		return false;
	}
	
	var submitData = {
			"isCross":iscross,
			"startYear":startYear,
			"endYear":endYear
	};
	
	generalAjaxCallToLoadData("itemStatisticsQuery.action", submitData, renderItemStatisticsResult);
}

//显示项目统计结果
function renderItemStatisticsResult(data) {
	
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	
	var itemStatisticsResult = data.jsonResult;
	console.log(itemStatisticsResult);
	
	//清空表格内的数据
	itemStatisticsListTable.fnClearTable();
	
	for(var i = 0; i < itemStatisticsResult.length - 1; i++) {
		
		var tempItemInfo = itemStatisticsResult[i];
		var tempRowData = new Array();
		tempRowData.push(tempItemInfo.itemName);
		tempRowData.push(tempItemInfo.itemId);
		tempRowData.push(tempItemInfo.addOutlay);
		tempRowData.push(tempItemInfo.outlay);
		tempRowData.push(tempItemInfo.balance);
		
		//添加一行数据
		itemStatisticsListTable.fnAddData( tempRowData );
	}
	
	if(itemStatisticsResult.length > 0) {
		var sumDataOfItemStatistics = itemStatisticsResult[itemStatisticsResult.length - 1];
		$("#sumOfInAccount").html(sumDataOfItemStatistics.addOutlay);
		$("#sumOfInOutlay").html(sumDataOfItemStatistics.outlay);
		$("#sumOfBalance").html(sumDataOfItemStatistics.balance);
		console.log(sumDataOfItemStatistics);
	}
}

//重绘Select下来菜单的Option选项
function redrawSelectWidgetOptions(selectID, currentYear) {
	
	$("#" + selectID).find("option").remove();
	
	var tempOption = "<option value=''>选择一个年度</option>";
	$("#" + selectID).append(tempOption);
	
	currentYear = parseInt(currentYear);
	for(var i = currentYear - 5; i < currentYear + 5; i++) {
		tempOption = "<option value='" + i + "'";
		if(i == currentYear) {
			tempOption = tempOption + "selected='selected'";
		}
		tempOption = tempOption + ">" + i + "&nbsp;年</option>";
		$("#" + selectID).append(tempOption);
	}
}
