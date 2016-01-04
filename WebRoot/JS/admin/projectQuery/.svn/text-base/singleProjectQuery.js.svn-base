var singleProjectQueryTable;

$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"项目查询",
	                	"href":""
	                 },
	                 {
	                	"name":"项目信息查询",
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
	
	tableTagArray.push({ "sTitle": "项目ID", "sClass": "center", "sWidth": "10%" });
	tableTagArray.push({ "sTitle": "项目名称", "sClass": "center", "sWidth": "15%" });
	tableTagArray.push({ "sTitle": "负责人", "sClass": "center", "sWidth": "10%" });
	tableTagArray.push({ "sTitle": "院系", "sClass": "center", "sWidth": "10%" });
	tableTagArray.push({ "sTitle": "项目类型", "sClass": "center", "sWidth": "10%" });
	tableTagArray.push({ "sTitle": "项目状态", "sClass": "center", "sWidth": "10%" });
	
	tableTagArray.push({ "sTitle": "typeid", "sClass": "center", "bVisible": false, "bSearchable": false});
	tableTagArray.push({ "sTitle": "状态代码", "sClass": "center", "bVisible": false, "bSearchable": false});
	tableTagArray.push({ "sTitle": "历史信息查看", "sClass": "center", "sWidth": "35%",  "bSearchable": false, "bSortable": false,
		"fnRender": function(obj){
		
			var itemPK = obj.aData[ obj.iDataColumn ];
		 	var itemID = obj.aData[ obj.iDataColumn - 8 ];
		 	var itemState = obj.aData[ obj.iDataColumn - 1];
		 	var itemTypeID = obj.aData[ obj.iDataColumn - 2];
		 	
		 	var tempItemInfo = {"itemPK":itemPK, "itemID":itemID, "itemState":itemState, "itemTypeID":itemTypeID};
		 	var tempItemInfoStr = jsonToString(tempItemInfo);
		 	
		 	var inAccountHistroyButton = "<a style=\"cursor: pointer\" onclick = \"inAccountHistroyButtonResponse(" + tempItemInfoStr + ")\"";
		 	inAccountHistroyButton = inAccountHistroyButton + ">入账</a>";
		 	var tempReturnResult = inAccountHistroyButton;
		 	
		 	
		 	var payRegisterHistroyButton = "<a style=\"cursor: pointer\" onclick = \"payRegisterHistroyButtonResponse(" + tempItemInfoStr + ")\"";
		 	payRegisterHistroyButton = payRegisterHistroyButton + ">支出</a>";
		 	tempReturnResult = tempReturnResult + "&nbsp;" + payRegisterHistroyButton;
		 	
		 	var budgetAdjustmentButtonHistroyButton = "<a style=\"cursor: pointer\" onclick = \"budgetAdjustmentButtonHistroyButtonResponse(" + tempItemInfoStr + ")\"";
		 	budgetAdjustmentButtonHistroyButton = budgetAdjustmentButtonHistroyButton + ">预算调整</a>";
		 	tempReturnResult = tempReturnResult + "&nbsp;" + budgetAdjustmentButtonHistroyButton;
		 	
		 	
		 	return tempReturnResult;
		}});
	
	singleProjectQueryTable = $("#singleProjectQueryTable").dataTable({
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
function singleProjectQuery() {
	
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
	
	generalAjaxCallToLoadData("singleProjectInfoAdminQuery.action",submitDatas,renderAllQueryResult);

}

//显示查询的结果
function renderAllQueryResult(data) {

	var queryResultItemList = data.jsonResult;
	
	//清空表格内的数据
	singleProjectQueryTable.fnClearTable();
	
	for(var i = 0; i < queryResultItemList.length ; i++) {
		
		var tempItemInfo = queryResultItemList[i];
		var tempRowData = new Array();
		tempRowData.push(tempItemInfo.itemId);
		tempRowData.push(tempItemInfo.itemName);
		tempRowData.push(tempItemInfo.teacherName);
		tempRowData.push(tempItemInfo.departmentName);
		tempRowData.push(tempItemInfo.typeId);
		tempRowData.push(projectStateArrayGlobalVariable[tempItemInfo.projectStatus]);
		
		//tempRowData.push(tempItemInfo.projectType.typeId);
		tempRowData.push(tempItemInfo.typeId);
		tempRowData.push(tempItemInfo.projectStatus);//项目状态代码，不显示
		tempRowData.push(tempItemInfo.itemPk);//项目PK
		
		//添加一行数据
		singleProjectQueryTable.fnAddData( tempRowData );
	}
}

//入账历史查看按钮的点击响应事件
function inAccountHistroyButtonResponse(tempItemInfo) {
	
	var itemState = tempItemInfo.itemState;
	
	if(itemState == "10") {
		return false;
	} else {
		
		var itemID = tempItemInfo.itemID;
		
		var detailInfoUrl = "Page/Teacher/inAccountApplication/inAccountApplicationList.jsp?itemID=" + itemID;
		
		window.open(detailInfoUrl);
		//parent.pageTransition(detailInfoUrl);
	}
}

//支出登记历史按钮响应事件
function payRegisterHistroyButtonResponse(tempItemInfo) {
	
	console.log(tempItemInfo);
	var itemState = tempItemInfo.itemState;
	var itemTypeID = tempItemInfo.itemTypeID;
	var itemPK = tempItemInfo.itemPK;
	
	if(itemState == "10") {
		return false;
	} else {
		
		var detailInfoUrl = "";
		switch (itemTypeID)
		   {
		   case "117":
			   detailInfoUrl = "Page/Teacher/payRegistration/863OutlayHistory.jsp?itemPK=" 
					+ itemPK;
		     break;
		   case "134":
			   detailInfoUrl = "Page/Teacher/payRegistration/863OutlayHistory.jsp?itemPK=" 
					+ itemPK;
		     break;
		   case "2":
			   detailInfoUrl = "Page/Teacher/payRegistration/nationalFundOutlayList.jsp?itemPK=" + itemPK;
		     break;
		   case "1":
			   detailInfoUrl = "Page/Teacher/payRegistration/provincialOutlayHistory.jsp?itemPK=" + itemPK;
		     break;
		   default:
			   detailInfoUrl = "Page/Common/pageError.jsp";
		}
		window.open(detailInfoUrl);
	}
}


//预算调整历史按钮响应事件
function budgetAdjustmentButtonHistroyButtonResponse(tempItemInfo) {
	
	var itemState = tempItemInfo.itemState;
	
	if(itemState == "10") {
		return false;
	} else {
		
		var itemPK = tempItemInfo.itemPK;
		var detailInfoUrl = "Page/Teacher/projectManagement/nationalFundAdjustList.jsp?itemPK=" + itemPK;
		window.open(detailInfoUrl);
	}
	
	
}