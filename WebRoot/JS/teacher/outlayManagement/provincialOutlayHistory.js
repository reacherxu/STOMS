var provincialOutlayHistoryTable;

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
	
	
	console.log("provincial Outlay list page begin");
	console.log(itemPK);
	
	
	// 新添支出按钮的响应事件，即跳入到填写预算调整的页面
    $('#addNewProvincialOutlayButton').click( function() {
    	
    	var detailInfoUrl = "Page/Teacher/payRegistration/provincialOutlayForm.jsp?itemPK=" + itemPK;
    	parent.pageTransition(detailInfoUrl);
    } );
	
	generalAjaxCallToLoadData("acquireProvincialOutlayHistory.action",{"itemPK":itemPK},initializeProvincialOutlayHistory);
	
});

//初始化 支出列表
function initializeProvincialOutlayHistory(data){
	
	var tableData = new Array();
	
	if(!data.actionStatus) {
		console.log("error");
		//return false;
	} else {
		
		var outlayList = data.jsonResult.provincialOutlayList;
		var itemInfo = data.jsonResult.itemInfo;
		
		$("#itemName").html(itemInfo.itemName);
		$("#contractID").html(itemInfo.contractId);
		$("#typeName").html(itemInfo.typeName);
		
		for(var i = 0; i < outlayList.length; i++) {
			
			var tempOutlayInfo = outlayList[i];
			console.log(tempOutlayInfo);
			var tempRowData = new Array();
			
			tempRowData.push(tempOutlayInfo.sumFundOutlayPk);
			tempRowData.push(tempOutlayInfo.sumFundOutlayPk);//支出PK，不显示
			tempRowData.push(tempOutlayInfo.itemPk);//项目PK，不显示
			tempRowData.push(tempOutlayInfo.outlayTime);//支出时间
			tempRowData.push(tempOutlayInfo.sumCost);//总支出金额		
			
			tableData.push(tempRowData);
		}
	}
	
	var tableTagArray = new Array();
	
		tableTagArray.push({ "sTitle": "<input type=\"checkbox\" id=\"selectAllCheckBox\"></input>", "sClass": "center",
			"sWidth": "5%", "bSortable": false,
			"fnRender": function(obj){
				 var outlayPk = obj.aData[ obj.iDataColumn ];
				 var checkBoxID = "checkBox" + outlayPk;
				 var tempCheckBox = "<input type=\"checkbox\" id=" + checkBoxID + " />";
				 return tempCheckBox;
			 }});	
		
		tableTagArray.push({ "sTitle": "sumFundOutlayPk", "sClass": "center", "bVisible": false, "bSearchable": false});
		
		tableTagArray.push({ "sTitle": "itemPk", "sClass": "center", "bVisible": false, "bSearchable": false});
		
		tableTagArray.push({ "sTitle": "支出时间", "sClass": "center", "sWidth": "55%",
				"fnRender": function(obj){
					 var outlayTime = obj.aData[ obj.iDataColumn];
					 var outlayPk = obj.aData[ obj.iDataColumn - 2];
					 var itemPK = obj.aData[ obj.iDataColumn - 1];
					 
					 var tempOutlayInfo = {"outlayPk":outlayPk, "itemPK":itemPK};
					 var tempOutlayInfoStr = jsonToString(tempOutlayInfo);
					 var tempHref = "<a onclick = \"detailInfoButtonResponse(" + tempOutlayInfoStr + ")\">" + outlayTime + "</a>";
					 return tempHref;
				 }});
		
		tableTagArray.push({ "sTitle": "支出总金额", "sClass": "center", "sWidth": "40%" });

		provincialOutlayHistoryTable = $("#provincialOutlayHistoryTable").dataTable({
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
			
			$('input[type="checkbox"]', provincialOutlayHistoryTable.fnGetNodes()).attr('checked',this.checked);
		  });
		
		
		 //删除按钮响应函数
	    $('#deleteProvincialOutlayButton').click( function() {
	    	
	    	var allCheckBoxDomnode = $("input[type='checkbox']:checked", provincialOutlayHistoryTable.fnGetNodes());
	    	
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
		
}

//确认删除院系对话框的确定按钮的响应事件
function deleteDepartment(dataForDeletion){
	
	var PKArray = dataForDeletion.PK;
	var indexArray = dataForDeletion.index;
	
	//generalAjaxCallToLoadData("deleteSelectedOutlay.action",{"outlayPKArray":PKArray},showDeletionResult,indexArray);
	
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
	
	alert("删除成功！");
}


//支出的详细信息
function detailInfoButtonResponse(tempOutlayInfo) {
	console.log("tempOutlayInfo");
	console.log(tempOutlayInfo);
	
	
	var outlayPk = tempOutlayInfo.outlayPk;
	var itemPK = tempOutlayInfo.itemPK;
	
		
	var detailInfoUrl = "Page/Teacher/payRegistration/provincialOutlayView.jsp?outlayPk=" + outlayPk + "&itemPK=" + itemPK;
	
	parent.pageTransition(detailInfoUrl);
}