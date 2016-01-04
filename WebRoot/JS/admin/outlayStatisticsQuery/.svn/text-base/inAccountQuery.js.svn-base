var inAccountQueryTable;

$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"经费统计",
	                	"href":""
	                 },
	                 {
	                	"name":"入账经费查询",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	$( "#itemStartDate" ).datepicker({
		showOn: 'button',
		buttonImage: "JqueryLib/css/datepickerCss/images/calendar.gif",
		buttonImageOnly: true,
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd"
	}).unbind('blur');
	
	$( "#itemEndDate" ).datepicker({
		showOn: 'button',
		buttonImage: "JqueryLib/css/datepickerCss/images/calendar.gif",
		buttonImageOnly: true,
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd"
	}).unbind('blur');
	
	$( "#inAccountStartDate" ).datepicker({
		showOn: 'button',
		buttonImage: "JqueryLib/css/datepickerCss/images/calendar.gif",
		buttonImageOnly: true,
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd"
	}).unbind('blur');
	
	$( "#inAccountEndDate" ).datepicker({
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
	
	$("#itemTypesClassificationDIV").accordion({
        collapsible: true,
        autoHeight: false
    });
	
	$("#DepartmentClassificationDIV").accordion({
        collapsible: true,
        autoHeight: false
    });
	
	var tableData = new Array();
	var tableTagArray = new Array();
	
	tableTagArray.push({ "sTitle": "入账addOutlayPk", "sClass": "center", "bVisible": false, "bSearchable": false});
	
	tableTagArray.push({ "sTitle": "项目ID", "sClass": "center", "bVisible": false, "bSearchable": false});
	
	tableTagArray.push({ "sTitle": "经费卡号", "sClass": "center", "sWidth": "12%",
		"fnRender": function(obj){
			 var addOutlayPk = obj.aData[ obj.iDataColumn - 2];
			 var itemID = obj.aData[ obj.iDataColumn - 1];
			 
			 var tempInAccountInfo = {"addOutlayPk":addOutlayPk, "itemID":itemID};
			 var tempInAccountInfoStr = jsonToString(tempInAccountInfo);
			 var tempHref = "<a onclick = \"detailInfoButtonResponse(" + tempInAccountInfoStr + ")\">" + itemID + "</a>";
			 return tempHref;
		 }});
	
	tableTagArray.push({ "sTitle": "项目名称", "sClass": "center", "sWidth": "15%" });
	tableTagArray.push({ "sTitle": "负责人", "sClass": "center", "sWidth": "8%" });
	tableTagArray.push({ "sTitle": "合同编号", "sClass": "center", "sWidth": "12%" });
	tableTagArray.push({ "sTitle": "来款金额", "sClass": "center", "sWidth": "12%" });
	tableTagArray.push({ "sTitle": "汇出金额", "sClass": "center", "sWidth": "12%" });
	tableTagArray.push({ "sTitle": "来款单位", "sClass": "center", "sWidth": "12%" });
	tableTagArray.push({ "sTitle": "时间", "sClass": "center", "sWidth": "9%" });
	tableTagArray.push({ "sTitle": "状态", "sClass": "center", "sWidth": "8%",
		"fnRender": function(obj){
			 var inAccountState = obj.aData[ obj.iDataColumn ];
			 var tempProjectType = projectStateArrayGlobalVariable[inAccountState];
			 return tempProjectType;
		 }});
	
	inAccountQueryTable = $("#inAccountQueryTable").dataTable({
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

//查询
function inAccountQuery() {
	
	var iscross = $("#iscross").find("option:selected").val();
	iscross = $.trim(iscross);
	
	
	
	var teacherName = $("#teacherName").val();
	var itemName = $("#itemName").val();
	var cardId = $("#cardID").val();
	var itemId = $("#itemID").val();
	var contractId = $("#contractID").val();
	var outlayDepartment = $("#inAccountDepartment").val();
	
	var isInvoiceChecked = $("#invoiceCheck")[0].checked;
	var isInvoice;
	if(isInvoiceChecked) {
		isInvoice = 1;
	} else {
		isInvoice = 0;
	}
	
	
	
	
	
	var timeLower = $("#itemStartDate").val();
	timeLower = $.trim(timeLower);
	if(timeLower == null || timeLower.length == 0) {
		timeLower = "";
	}
	
	var timeUpper = $("#itemEndDate").val();
	timeUpper = $.trim(timeUpper);
	if(timeUpper == null || timeUpper.length == 0) {
		timeUpper = "";
	}
	
	var outlayStartDate = $("#inAccountStartDate").val();
	outlayStartDate = $.trim( outlayStartDate );
	if( outlayStartDate == null || outlayStartDate.length == 0) {
		outlayStartDate = "";
	}
	
	var outlayEndDate = $("#inAccountEndDate").val();
	outlayEndDate = $.trim(outlayEndDate);
	if(outlayEndDate == null || outlayEndDate.length == 0) {
		outlayEndDate = "";
	}
	
	//"YYYY-MM-DD"日期格式正则表达式
	var ex = /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/;
	var pattern = new RegExp(ex);
	
	//判断日期格式是否为"YYYY-MM-DD"
	if(timeLower.length > 0 && !pattern.test(timeLower)) {
		alert("开始日期格式有误，格式为\"YYYY-MM-DD\"");
		return false;
	}
	
	if(timeUpper.length > 0 && !pattern.test(timeUpper)) {
		alert("结束日期格式有误，格式为\"YYYY-MM-DD\"");
		return false;
	}
	
	if(outlayStartDate.length > 0 && !pattern.test(outlayStartDate)) {
		alert("开始日期格式有误，格式为\"YYYY-MM-DD\"");
		return false;
	}
	
	if(outlayEndDate.length > 0 && !pattern.test(outlayEndDate)) {
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
			"teacherName":teacherName,
			"itemName":itemName,
			"cardId":cardId,
			"itemId":itemId,
			"contractId":contractId,
			"outlayDepartment":outlayDepartment,
			"isInvoice":isInvoice,
			"outlayStartDate":outlayStartDate,
			"outlayEndDate":outlayEndDate,
			"timeLower":timeLower,
			"timeUpper":timeUpper,
			"selectedItemTypePKs":itemTypePKArray,
			"selectedDepartmentPKs":departmentPKArray
	};
	
	generalAjaxCallToLoadData("inAccountAdminQuery.action",submitDatas,renderAllQueryResult);

}

//显示查询的结果
function renderAllQueryResult(data) {

	var list = data.jsonResult;
	console.log(list);
	
	//清空表格内的数据
	inAccountQueryTable.fnClearTable();
	
	for(var i = 0; i < list.length ; i++) {
		
		var tempInfo = list[i];
		var tempRowData = new Array();
		tempRowData.push(tempInfo.addOutlayPk);
		tempRowData.push(tempInfo.itemId);
		tempRowData.push(tempInfo.cardId);
		tempRowData.push(tempInfo.itemName);
		tempRowData.push(tempInfo.teacherName);
		tempRowData.push(tempInfo.contractId);
		tempRowData.push(tempInfo.outlayValue);
		tempRowData.push(tempInfo.remitValue);
		tempRowData.push(tempInfo.outlayDepartment);
		tempRowData.push(tempInfo.outlayTime);
		tempRowData.push(tempInfo.astatus);
		
		
		//添加一行数据
		inAccountQueryTable.fnAddData( tempRowData );
	}
}

//入账的详细信息
function detailInfoButtonResponse(tempInAccountInfo) {
	
	var inAccountApplicationState = tempInAccountInfo.inAccountApplicationState;
	var addOutlayPk = tempInAccountInfo.addOutlayPk;
	var itemID = tempInAccountInfo.itemID;
	
	var detailInfoUrl = "";
	
	detailInfoUrl = "Page/Teacher/inAccountApplication/approvedInAccountApplicationView.jsp?addOutlayPK=" + addOutlayPk + "&itemID=" + itemID;
	
	window.open(detailInfoUrl);
}
