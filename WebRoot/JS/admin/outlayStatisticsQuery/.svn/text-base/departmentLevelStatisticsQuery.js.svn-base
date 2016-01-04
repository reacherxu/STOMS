var departmentLevelStatisticsListTable;

$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"经费统计",
	                	"href":""
	                 },
	                 {
	                	"name":"按院系统计查询",
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
	
	
	//由于CSS样式包冲突，手动关闭日期控件
	$("#ui-datepicker-div")[0].style.display = "none";
	
	//console.log($("#departmentTableBody input[type='checkbox']"));
	//院系全选或全不选按钮change事件响应函数
	$("#allDepartmentsCheckbox").change(function(event){
		//console.log($("#departmentTableBody input[type='checkbox']:checked"));
		$("#departmentTableBody input[type='checkbox']").attr('checked',this.checked);
		//$("input[type='checkbox']", $("#departmentTableBody input")).attr('checked',this.checked);
	  });
	

	$("#DepartmentClassificationDIV").accordion({
        collapsible: true,
        autoHeight: false
    });
	
	var tableData = new Array();
	var tableTagArray = new Array();
	
	//tableTagArray.push({ "sTitle": "院系ID", "sClass": "center", "sWidth": "15%" });
	tableTagArray.push({ "sTitle": "院系名称", "sClass": "center", "sWidth": "40%" });
	tableTagArray.push({ "sTitle": "累计到账", "sClass": "center", "sWidth": "20%" });
	tableTagArray.push({ "sTitle": "累计汇出", "sClass": "center", "sWidth": "20%" });
	tableTagArray.push({ "sTitle": "净到帐", "sClass": "center", "sWidth": "20%" });
	
	departmentLevelStatisticsListTable = $("#departmentLevelStatisticsListTable").dataTable({
	    "aaData": tableData,
	    "aoColumns": tableTagArray,
	    "bLengthChange": false,
	    "bJQueryUI": true,
	    "oLanguage": dataTableLanguageGlobalVariable,
	    "sScrollX": "100%",
	    "sScrollXInner": "100%",
	    "sPaginationType": "full_numbers"
	});
	
	generalAjaxCallToLoadData("acquireAllDepartmentPKAndName.action",{},renderAllDepartments);
});


function renderAllDepartments(data) {
	
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	
	var allDeparmentsInfo = data.jsonResult;
	console.log(allDeparmentsInfo);
	
	var tempTRElement;
	for(var i = 0; i < allDeparmentsInfo.length; i++) {
		
		if(i%5 == 0) {
			columnIterator = 0;
			tempTRElement = $("<tr>");
			$("#departmentTableBody").append(tempTRElement);
		}
		
		var tempTDElentment = $("<td>");
		
		var tempDepartmentInfo = allDeparmentsInfo[i];
		var tempCheckboxID = "checkbox" + tempDepartmentInfo.departmentPk;
		var tempCheckboxWidget = "<input type='checkbox' id='" + tempCheckboxID + "'/>" + "&nbsp;" + tempDepartmentInfo.departmentName;
		tempTDElentment.append(tempCheckboxWidget);
		tempTRElement.append(tempTDElentment);
	}
	
}
//院系级查询
function departmentLevelStatisticsQuery() {
	console.log("院系级查询");
	
	var iscross = $("#iscross").find("option:selected").val();
	iscross = $.trim(iscross);
	
	var departmentType = $("#departmentType").find("option:selected").val();
	departmentType = $.trim(departmentType);
	
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
	
	
	console.log(iscross);
	console.log(departmentType);
	console.log(startDate);
	console.log(endDate);
	
	var departmentPKArray = new Array();
	var allSelectedCheckboxs = $("#departmentTableBody input[type='checkbox']:checked");
	
	for(var i = 0; i < allSelectedCheckboxs.length; i++) {
		
		var tempCheckboxID = allSelectedCheckboxs[i].id;
		var tempDepartmentPK = tempCheckboxID.substr(8);
		departmentPKArray.push(tempDepartmentPK);
	}
	
	console.log(departmentPKArray);
	
	var submitDatas = {
			"isCross":iscross,
			"departmentType":departmentType,
			"startDate":startDate,
			"endDate":endDate,
			"selectedDepartmentPKs":departmentPKArray
	};
	
	generalAjaxCallToLoadData("departmentLevelStatisticsQuery.action",submitDatas,renderAllQueryResult);
	
	/*for(var tempCheckbox in $("#departmentTableBody input[type='checkbox']:checked")) {
		console.log(tempCheckbox.id);
	}*/
}

//显示查询的结果
function renderAllQueryResult(data) {
	
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	
	var departmentLevelQueryResult = data.jsonResult;
	console.log(departmentLevelQueryResult);
	
	//清空表格内的数据
	departmentLevelStatisticsListTable.fnClearTable();
	
	for(var i = 0; i < departmentLevelQueryResult.length; i++) {
		
		var tempItemInfo = departmentLevelQueryResult[i];
		var tempRowData = new Array();
		tempRowData.push(tempItemInfo.departmentName);
		tempRowData.push(tempItemInfo.addOutlay);
		tempRowData.push(tempItemInfo.outlay);
		tempRowData.push(tempItemInfo.balance);
		
		//添加一行数据
		departmentLevelStatisticsListTable.fnAddData( tempRowData );
	}
	
	//oTable.fnClearTable();
	/*
	 *  $('#example').dataTable().fnAddData( [
    giCount+".1",
    giCount+".2",
    giCount+".3",
    giCount+".4" ]
  ); */
}