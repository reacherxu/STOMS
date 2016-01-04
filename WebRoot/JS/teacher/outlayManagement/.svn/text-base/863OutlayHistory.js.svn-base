var outlayListTable;

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
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
//	itemPK = 30;
	console.log(itemPK);
	
	
	$("#addButton").click(function(check) { 
		
    	var url = "Page/Teacher/payRegistration/863OutlayForm.jsp?outlayPK=0"
			+ "&pageType=register&itemPK=" + itemPK;
    	parent.pageTransition(url);
	});
	
	generalAjaxCallToLoadData("acquireA863OutlayHistoryInfoByItemPK.action",{"itemPK":itemPK},initializeTable);
	
    });

//初始化表单
function initializeTable(data) {
	
	var tableData = new Array();
	
	console.log(data.jsonResult);
	
	if(data.actionStatus) {
		var itemInfo = data.jsonResult.A863itemInfo;
		$("#itemName").html(itemInfo.itemName);
		$("#contractId").html(itemInfo.contractId);
		$("#itemType").html(itemInfo.projectType.typeName);
		
		var A863OutlayHistoryList = data.jsonResult.A863OutlayHistoryList;
		
		for(var i = 0; i < A863OutlayHistoryList.length; i++) {
			
			var tempOutlayInfo = A863OutlayHistoryList[i];
			//console.log(tempDepartmentInfo);
			var tempRowData = new Array();
			
			tempRowData.push(tempOutlayInfo.a863outlayPk);
			tempRowData.push(tempOutlayInfo.a863outlayPk);
			tempRowData.push(tempOutlayInfo.outlayTime);
			tempRowData.push(tempOutlayInfo.costSum);

			tableData.push(tempRowData);
		}
	}
	
	console.log(tableData);
	
	
	
	var tableTagArray = new Array();
	
	tableTagArray.push({ "sTitle": "<input type=\"checkbox\" id=\"selectAllCheckBox\"></input>", "sClass": "center",
		"sWidth": "3%", "bSortable": false,
		"fnRender": function(obj){
			console.log(obj);
			 var PK = obj.aData[ obj.iDataColumn ];
			 var checkBoxID = "checkBox" + PK;
			 var tempCheckBox = "<input type=\"checkbox\" id=" + checkBoxID + " />";
			 return tempCheckBox;
		 }});
	
	tableTagArray.push({ "sTitle": "outlayPK", "sClass": "center", "bVisible": false, "bSearchable": false});
	
	tableTagArray.push({ "sTitle": "支出时间", "sClass": "center", "sWidth": "35%",
		"fnRender": function(obj){
			 var outlayTime = obj.aData[ obj.iDataColumn];
			 var outlayPK = obj.aData[ obj.iDataColumn - 1];
			 
			 var tempPkValue = {"outlayPK":outlayPK};
			 var tempPkValueString = jsonToString(tempPkValue);
			 
			 console.log(tempPkValueString);
			 
			 var tempHref = "<a onclick = \"detailInfoButtonResponse(" + tempPkValueString + ")\">" + outlayTime + "</a>";
			 return tempHref;
		 }});
	tableTagArray.push({ "sTitle": "支出总金额", "sClass": "center", "sWidth": "20%" });
	
	outlayListTable = $("#outlayTable").dataTable({
        "aaData": tableData,
        "aoColumns": tableTagArray,
        "bLengthChange": false,
        "bJQueryUI": true,
        "oLanguage": dataTableLanguageGlobalVariable,
        "sScrollX": "100%",
        "sScrollXInner": "100%",
        "sPaginationType": "full_numbers"
    });
	
	//全选或全不选按钮
	$("#selectAllCheckBox").change(function(event){
		
		$('input[type="checkbox"]', outlayListTable.fnGetNodes()).attr('checked',this.checked);
	  });
	
	/*
    //删除按钮响应函数
    $('#deleteButton').click( function() {
    	
    	var allCheckBoxDomnode = $("input[type='checkbox']:checked", outlayListTable.fnGetNodes());
    	
    	if(allCheckBoxDomnode == "null" || allCheckBoxDomnode.length == "0"){
    		alert("请选中一行！");
    		return;
    	}
    	
    	if(confirm("确定删除吗？") == false) return;
    	
    	var PKArray = new Array();
    	var indexArray = new Array();
    	for(var i = 0; i < allCheckBoxDomnode.length; i++) {
    		
        	var tempCheckBoxID = allCheckBoxDomnode[i].id;
        	var tempItemPK = tempCheckBoxID.substr(8);
        	PKArray.push(tempItemPK);
        	
        	console.log(allCheckBoxDomnode[i]);
        	console.log($(allCheckBoxDomnode[i]).parent().parent());
        	
        	//取得表中的index，用于删除
        	var tempIndex = outlayListTable.fnGetPosition(( $(allCheckBoxDomnode[i]).parent().parent())[0]);
        	indexArray.push(tempIndex);
    	}

    	console.log(PKArray);
    	console.log(indexArray);
    	
    	var dataForDeletion = {"PK":PKArray, "index":indexArray};
    	deleteDepartment(dataForDeletion);
    	
    } );
    */
	
	
}

/*
//确认删除院系对话框的确定按钮的响应事件
function deleteDepartment(dataForDeletion){
	
	var PKArray = dataForDeletion.PK;
	var indexArray = dataForDeletion.index;
	
	generalAjaxCallToLoadData("deleteSelectedOutlay.action",{"outlayPKArray":PKArray},showDeletionResult,indexArray);
	
}


function showDeletionResult(data,rowDataArray) {
	
	if(!data.actionStatus) {
		alert("删除失败，请重试！");
		return false;
	}
	
	//删除得从最大的开始删 否则每删一个会从新排序，序号不对
	for(var i = rowDataArray.length - 1; i >= 0; i--) {
		var rowData = rowDataArray[i];
		outlayListTable.fnDeleteRow(rowData);
	}
	
	alert("删除院系成功！");
}
*/

//点的名字上的链接转移函数
function detailInfoButtonResponse(tempInAccountInfo) {	
	
	var outlayPK = tempInAccountInfo.outlayPK;
	
	var detailInfoUrl = "Page/Teacher/payRegistration/863OutlayForm.jsp?outlayPK=" + outlayPK 
	+ "&pageType=view&itemPK=" + itemPK;
	
	parent.pageTransition(detailInfoUrl);
	
}