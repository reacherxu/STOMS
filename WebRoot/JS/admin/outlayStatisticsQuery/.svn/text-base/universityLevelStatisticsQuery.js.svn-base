var universityLevelStatisticsListTable;

$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"经费统计",
	                	"href":""
	                 },
	                 {
	                	"name":"校级统计查询",
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
	
	//理科项目类型全选或全不选按钮change事件响应函数
	$("#allScienceItemTypeCheckbox").change(function(event){
		
		$("#scienceItemTypeTableBody input[type='checkbox']").attr('checked',this.checked);
	  });
	
	//文科项目类型全选或全不选按钮change事件响应函数
	$("#allArtsItemTypeCheckbox").change(function(event){
		
		$("#artsItemTypeTableBody input[type='checkbox']").attr('checked',this.checked);
	  });
	
	
	$("#itemTypesClassificationDIV").accordion({
        collapsible: true,
        autoHeight: false
    });
	
	var tableData = new Array();
	var tableTagArray = new Array();
	
	
	tableTagArray.push({ "sTitle": "项目类型", "sClass": "center", "sWidth": "40%" });
	tableTagArray.push({ "sTitle": "累计到账", "sClass": "center", "sWidth": "20%" });
	tableTagArray.push({ "sTitle": "累计汇出", "sClass": "center", "sWidth": "20%" });
	tableTagArray.push({ "sTitle": "净到帐", "sClass": "center", "sWidth": "20%" });
	
	universityLevelStatisticsListTable = $("#universityLevelStatisticsListTable").dataTable({
	    "aaData": tableData,
	    "aoColumns": tableTagArray,
	    "bLengthChange": false,
	    "bJQueryUI": true,
	    "oLanguage": dataTableLanguageGlobalVariable,
	    "sScrollX": "100%",
	    "sScrollXInner": "100%",
	    "sPaginationType": "full_numbers"
	});
	
	generalAjaxCallToLoadData("acquireAllItemTypesPKAndName.action",{},initialCheckboxWidgets);
});

//回显所有的项目类型复选框供选择
function initialCheckboxWidgets(data) {
	
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	
	var allItemTypesInfo = data.jsonResult;
	console.log(allItemTypesInfo);
	
	
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
}

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

//校级查询
function universityLevelStatisticsQuery() {
	console.log("院系级查询");
	
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
	
	var itemTypePKArray = new Array();
	
	var allSelectedScienceCheckboxs = $("#scienceItemTypeTableBody input[type='checkbox']:checked");
	for(var i = 0; i < allSelectedScienceCheckboxs.length; i++) {
		
		var tempCheckboxID = allSelectedScienceCheckboxs[i].id;
		var tempItemTypePK = tempCheckboxID.substr(8);
		itemTypePKArray.push(tempItemTypePK);
	}
	
	var allSelectedArtsCheckboxs = $("#artsItemTypeTableBody input[type='checkbox']:checked");
	for(var i = 0; i < allSelectedArtsCheckboxs.length; i++) {
		
		var tempCheckboxID = allSelectedArtsCheckboxs[i].id;
		var tempItemTypePK = tempCheckboxID.substr(8);
		itemTypePKArray.push(tempItemTypePK);
	}
	
	var submitDatas = {
			"isCross":iscross,
			"startDate":startDate,
			"endDate":endDate,
			"selectedItemTypePKs":itemTypePKArray
	};
	
	generalAjaxCallToLoadData("universityLevelStatisticsQuery.action",submitDatas,renderAllQueryResult);
	
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
	
	var universityLevelQueryResult = data.jsonResult;
	console.log(universityLevelQueryResult);
	
	//清空表格内的数据
	universityLevelStatisticsListTable.fnClearTable();
	
	for(var i = 0; i < universityLevelQueryResult.length; i++) {
		
		var tempItemInfo = universityLevelQueryResult[i];
		var tempRowData = new Array();
		tempRowData.push(tempItemInfo.groupName);
		tempRowData.push(tempItemInfo.addOutlay);
		tempRowData.push(tempItemInfo.outlay);
		tempRowData.push(tempItemInfo.balance);
		
		//添加一行数据
		universityLevelStatisticsListTable.fnAddData( tempRowData );
	}
	
}