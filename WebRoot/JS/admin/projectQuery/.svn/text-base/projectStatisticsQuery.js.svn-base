var projectStatisticsQueryTable;

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
	
	//理科项目类型全选或全不选按钮change事件响应函数
	$("#allScienceItemTypeCheckbox").change(function(event){
		
		$("#scienceItemTypeTableBody input[type='checkbox']").attr('checked',this.checked);
	  });
	
	//理科项目类型全选或全不选按钮change事件响应函数
	$("#allArtsItemTypeCheckbox").change(function(event){
		
		$("#artsItemTypeTableBody input[type='checkbox']").attr('checked',this.checked);
	  });
	
	//院系全选或全不选按钮change事件响应函数
	$("#allDepartmentsCheckbox").change(function(event){
		$("#departmentTableBody input[type='checkbox']").attr('checked',this.checked);
	  });
	
	var tableData = new Array();
	var tableTagArray = new Array();
	
	$("#itemTypesClassificationDIV").accordion({
        collapsible: true,
        autoHeight: false
    });
	
	$("#DepartmentClassificationDIV").accordion({
        collapsible: true,
        autoHeight: false
    });

	
	tableTagArray.push({ "sTitle": "申请数", "sClass": "center", "sWidth": "25%" });
	tableTagArray.push({ "sTitle": "批准数", "sClass": "center", "sWidth": "25%" });
	tableTagArray.push({ "sTitle": "在研数", "sClass": "center", "sWidth": "25%" });
	tableTagArray.push({ "sTitle": "已结题", "sClass": "center", "sWidth": "25%" });

	projectStatisticsQueryTable = $("#projectStatisticsQueryTable").dataTable({
	    "aaData": tableData,
	    "aoColumns": tableTagArray,
	    "bLengthChange": false,
	    "bJQueryUI": true,
	    "oLanguage": dataTableLanguageGlobalVariable,
	    "sScrollX": "100%",
	    "sScrollXInner": "100%",
	    "sPaginationType": "full_numbers"
	});
	
	generalAjaxCallToLoadData("acquireProjectQueryInfoAdmin.action",{},initialProjectQueryInfoAdmin);
});

//回显所有的项目类型复选框供选择
function initialProjectQueryInfoAdmin(data) {
	
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	
	var allItemTypesInfo = data.jsonResult.allProjectTypeInfo;

	var scienceItemTypes = new Array();
	var artsItemTypes = new Array();
	
	for(var i = 0; i < allItemTypesInfo.length; i++) {
		
		var tempItemType = allItemTypesInfo[i];
		if(tempItemType.departmentType == "理科") {
			scienceItemTypes.push(tempItemType);
		} else {
			artsItemTypes.push(tempItemType);
		}
	}
	
	renderItemTypes("scienceItemTypeTableBody", scienceItemTypes);
	renderItemTypes("artsItemTypeTableBody", artsItemTypes);
	
	var allDepartmentInfo = data.jsonResult.allDepartmentInfo;
	
	renderDepartmentTypes("departmentTableBody", allDepartmentInfo);
}


//动态生成项目类型复选框
function renderItemTypes(targetTableBody, itemTypesInfo) {
	
	var tempTRElement;
	
	for(var i = 0; i < itemTypesInfo.length; i++) {
		
		if(i%4 == 0) {
			columnIterator = 0;
			tempTRElement = $("<tr>");
			$("#" + targetTableBody).append(tempTRElement);
		}
		
		var tempTDElentment = $("<td>");
		
		var tempItemTypeInfo = itemTypesInfo[i];
		var tempCheckboxID = "checkbox" + tempItemTypeInfo.typePk;
		var tempCheckboxWidget = "<input type='checkbox' id='" + tempCheckboxID + "'/>" + "&nbsp;" + tempItemTypeInfo.typeName;
		tempTDElentment.append(tempCheckboxWidget);
		tempTRElement.append(tempTDElentment);
	}
}

//动态生成院系列表
function renderDepartmentTypes(targetTableBody, departmentInfo) {
	
	
	var allDeparmentsInfo = departmentInfo;
	
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

//项目查询
function projectStatisticsQuery() {
	
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
	
	var departmentPKArray = new Array();
	var allSelectedCheckboxs = $("#departmentTableBody input[type='checkbox']:checked");
	
	for(var i = 0; i < allSelectedCheckboxs.length; i++) {
		
		var tempCheckboxID = allSelectedCheckboxs[i].id;
		var tempDepartmentPK = tempCheckboxID.substr(8);
		departmentPKArray.push(tempDepartmentPK);
	}
	
	
	var itemTypePKArray= new Array();
	
	var allScienceSelectedCheckboxs = $("#scienceItemTypeTableBody input[type='checkbox']:checked");
	for(var i = 0; i < allScienceSelectedCheckboxs.length; i++) {
		
		var tempCheckboxID = allScienceSelectedCheckboxs[i].id;
		var tempDepartmentPK = tempCheckboxID.substr(8);
		itemTypePKArray.push(tempDepartmentPK);
	}
	
	var allArtsSelectedCheckboxs = $("#artsItemTypeTableBody input[type='checkbox']:checked");
	for(var i = 0; i < allArtsSelectedCheckboxs.length; i++) {
		
		var tempCheckboxID = allArtsSelectedCheckboxs[i].id;
		var tempDepartmentPK = tempCheckboxID.substr(8);
		itemTypePKArray.push(tempDepartmentPK);
	}
	
	var submitDatas = {
			"isCross":iscross,
			"selectedItemTypePKs":itemTypePKArray,
			"startDate":startDate,
			"endDate":endDate,
			"selectedDepartmentPKs":departmentPKArray
	};
	
	generalAjaxCallToLoadData("projectStatisticAdminQuery.action",submitDatas,renderAllQueryResult);

}

//显示查询的结果
function renderAllQueryResult(data) {

	var queryStatistic = data.jsonResult;
	
	//清空表格内的数据
	projectStatisticsQueryTable.fnClearTable();
	
	var tempRowData = new Array();
	
	var state11 = 0;
	var state10 = 0;
	var state311 = 0;     //结题
	var state310 = 0;     //在研
	
	for ( var i=0; i<queryStatistic.length; i++ ) {
		if( queryStatistic[i].projectStatus == "31:0" )
			state310 = queryStatistic[i].itemCount;
		else if ( queryStatistic[i].projectStatus == "31:1" )
			state311 = queryStatistic[i].itemCount;
		else if ( queryStatistic[i].projectStatus == "10" )
			state10 = queryStatistic[i].itemCount;	
		else if ( queryStatistic[i].projectStatus == "11" )
			state11 = queryStatistic[i].itemCount;	
	}
	
	
	tempRowData.push(state10 + state11);
	tempRowData.push(state310 + state311);
	tempRowData.push(state310);
	tempRowData.push(state311);
	
		//添加一行数据
	projectStatisticsQueryTable.fnAddData( tempRowData );

}