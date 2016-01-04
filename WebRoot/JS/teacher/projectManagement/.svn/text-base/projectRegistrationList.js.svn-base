var projectRegistrationDataTable;

$(document).ready(function(){
	consoleResponseInUnusabalEnvirenment();
	
	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"我的项目",
	                	"href":"Page/Teacher/projectManagement/projectRegistrationList.jsp"
	                 }
	                 ];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	console.log("project registration page begin");
	// 新添项目按钮的响应事件，即跳入到填写申请项目的页面
    $('#addNewProjectRegistrationButton').click( function() {
        var itemPK = "";
        var itemTypeID = "";
    	var detailInfoUrl = "Page/Teacher/projectManagement/projectRegistration.jsp?itemPK=" 
							+ itemPK + "&itemTypeID=" + itemTypeID;
    	parent.pageTransition(detailInfoUrl);
    } );
    
    //删除按钮的响应事件，即删除选中的项目，删除其项目信息，以及相应的预算表和扫描件
    $('#deleteProjectRegistrationButton').click( function() {
        console.log("deleteProjectRegistrationButton!");
        var itemPKArray = getSelectedItems();
        for(var i = 0; i < itemPKArray.length; i++) {
        	console.log(itemPKArray[i]);
        }
    } );
    
	generalAjaxCallToLoadData("findAllUnapprovedItems.action",{},initializePageContent);
});

function initializePageContent(data){
	
	var tableData = new Array();
	
	if(data.actionStatus) {
		
		var itemInfoList = data.jsonResult;
		
		for(var i = 0; i < itemInfoList.length; i++) {
			
			var tempItemInfo = itemInfoList[i];
			var tempRowData = new Array();
			tempRowData.push(tempItemInfo.itemPk);//checkBox
			tempRowData.push(tempItemInfo.itemPk);//项目ItemPK
			tempRowData.push(tempItemInfo.itemName);//名称
			tempRowData.push(tempItemInfo.cardId);//经费卡号
			tempRowData.push(tempItemInfo.typeName);//项目类型
			tempRowData.push(tempItemInfo.projectType.typeId);//项目类型ID
			tempRowData.push(tempItemInfo.projectType.budgetType);//预算类型
			tempRowData.push(tempItemInfo.projectStatus);//状态
			tempRowData.push(tempItemInfo.projectStatus);//状态代码
			tempRowData.push(tempItemInfo.itemId);//入账申请
			tempRowData.push(tempItemInfo.itemPk);//支出登记
			
			
			tableData.push(tempRowData);
		}
	}
	
	var tableTagArray = new Array();
	tableTagArray.push({ "sTitle": "<input type=\"checkbox\" id=\"selectAllCheckBox\"></input>", "sClass": "center",
							"sWidth": "5%", "bSortable": false,
							"fnRender": function(obj){
								 var itemPK = obj.aData[ obj.iDataColumn ];
								 var checkBoxID = "checkBox" + itemPK;
								 var tempCheckBox = "<input type=\"checkbox\" id=" + checkBoxID + " />";
								 return tempCheckBox;
							 }});
	
	tableTagArray.push({ "sTitle": "项目ItemPK", "sClass": "center", "bVisible": false, "bSearchable": false});
	
	tableTagArray.push({ "sTitle": "名称", "sClass": "center", "sWidth": "35%",
							"fnRender": function(obj){
								 var itemName = obj.aData[ obj.iDataColumn];
								 var itemTypeID = obj.aData[ obj.iDataColumn + 2];
								 var itemState = obj.aData[ obj.iDataColumn + 5];
								 var itemPK = obj.aData[ obj.iDataColumn - 1];
								 var tempItemInfo = {"itemPK":itemPK, "itemState":itemState, "itemTypeID":itemTypeID};
								 var tempItemInfoStr = jsonToString(tempItemInfo);
								 var tempHref = "<a onclick = \"detailInfoButtonResponse(" + tempItemInfoStr + ")\">" + itemName + "</a>";
								 return tempHref;
							 }});
	
	tableTagArray.push({ "sTitle": "经费卡号", "sClass": "center", "sWidth": "12%" });
	
	tableTagArray.push({ "sTitle": "项目类型", "sClass": "center", "sWidth": "14%" });
	
	tableTagArray.push({ "sTitle": "项目类型ID", "sClass": "center", "bVisible": false, "bSearchable": false});
	
	tableTagArray.push({ "sTitle": "预算类型", "sClass": "center", "bVisible": false, "bSearchable": false});
	
	tableTagArray.push({ "sTitle": "状态", "sClass": "center", "sWidth": "10%", 
							"fnRender": function(obj){
								 var itemState = obj.aData[ obj.iDataColumn ];
								 var tempProjectType = projectStateArrayGlobalVariable[itemState];
								 return tempProjectType;
							 }});
	
	tableTagArray.push({ "sTitle": "状态代码", "sClass": "center", "bVisible": false, "bSearchable": false});
	
	tableTagArray.push({ "sTitle": "入账申请", "sClass": "center", "sWidth": "12%", "bSortable": false,
		 "fnRender": function(obj){
			 var itemID = obj.aData[ obj.iDataColumn ];
			 var itemState = obj.aData[ obj.iDataColumn - 1];
			 var tempItemInfo = {"itemID":itemID, "itemState":itemState};
			 var tempItemInfoStr = jsonToString(tempItemInfo);
			 var addInAccountButton = "<a onclick = \"addInAccountButtonResponse(" + tempItemInfoStr + ")\"";
			 if(itemState == "10") {
				 addInAccountButton = addInAccountButton +  " style=\"color: #808080;\"";
			 }
			 addInAccountButton = addInAccountButton + ">申请</a>";
			 
			 var inAccountHistroyButton = "<a onclick = \"inAccountHistroyButtonResponse(" + tempItemInfoStr + ")\"";
			 if(itemState == "10") {
				 inAccountHistroyButton = inAccountHistroyButton +  " style=\"color: #808080;\"";
			 }
			 inAccountHistroyButton = inAccountHistroyButton + ">记录</a>";
			 
			 var tempReturnResult = addInAccountButton + "&nbsp;" + inAccountHistroyButton;
			 return tempReturnResult;
		 }});
	
	tableTagArray.push({ "sTitle": "经费管理", "sClass": "center", "sWidth": "12%", "bSortable": false,
		 "fnRender": function(obj){
			 var itemPK = obj.aData[ obj.iDataColumn ];
			 var itemState = obj.aData[ obj.iDataColumn - 2];
			 var itemBudgetType = obj.aData[ obj.iDataColumn - 4];
			 var tempItemInfo = {"itemPK":itemPK, "itemState":itemState, "itemBudgetType":itemBudgetType};
			 var tempItemInfoStr = jsonToString(tempItemInfo);
			 
			 var addPayRegisterButton = "<a onclick = \"addPayRegisterButtonResponse(" + tempItemInfoStr + ")\"";
			 if(itemState == "10" 
				 || !(itemBudgetType == "1" || itemBudgetType == "2" || itemBudgetType == "3" || itemBudgetType == "4")) {
				 addPayRegisterButton = addPayRegisterButton +  " style=\"color: #808080;\"";
			 }
			 addPayRegisterButton = addPayRegisterButton + ">登记</a>";
			 
			 var payRegisterHistroyButton = "<a onclick = \"payRegisterHistroyButtonResponse(" + tempItemInfoStr + ")\"";
			 if(itemState == "10"
				 || !(itemBudgetType == "1" || itemBudgetType == "2" || itemBudgetType == "3" || itemBudgetType == "4")) {
				 payRegisterHistroyButton = payRegisterHistroyButton +  " style=\"color: #808080;\"";
			 }
			 payRegisterHistroyButton = payRegisterHistroyButton + ">记录</a>";
			 
			 var tempReturnResult = addPayRegisterButton + "&nbsp;" + payRegisterHistroyButton;
			 return tempReturnResult;
		 }});
	
//	tableTagArray.push({ "sTitle": "预算调整", "sClass": "center", "sWidth": "12%", "bSortable": false,
//		 "fnRender": function(obj){
//			 var itemPK = obj.aData[ obj.iDataColumn ];
//			 var itemState = obj.aData[ obj.iDataColumn - 3];
//			 var itemBudgetType = obj.aData[ obj.iDataColumn - 5];
//			 var tempItemInfo = {"itemPK":itemPK, "itemState":itemState, "itemBudgetType":itemBudgetType};
//			 var tempItemInfoStr = jsonToString(tempItemInfo);
//			 
//			 var budgetAdjustmentButton = "<a onclick = \"budgetAdjustmentButtonResponse(" + tempItemInfoStr + ")\"";
//			 if(itemState == "10" || !(itemBudgetType == "3" || itemBudgetType == "2")) {
//				 budgetAdjustmentButton = budgetAdjustmentButton +  " style=\"color: #808080;\"";
//			 }
//			 budgetAdjustmentButton = budgetAdjustmentButton + ">调整</a>";
//			 
//			 var budgetAdjustmentButtonHistroyButton = "<a onclick = \"budgetAdjustmentButtonHistroyButtonResponse(" + tempItemInfoStr + ")\"";
//			 if(itemState == "10" || !(itemBudgetType == "3" || itemBudgetType == "2")) {
//				 budgetAdjustmentButtonHistroyButton = budgetAdjustmentButtonHistroyButton +  " style=\"color: #808080;\"";
//			 }
//			 budgetAdjustmentButtonHistroyButton = budgetAdjustmentButtonHistroyButton + ">历史</a>";
//			 
//			 var tempReturnResult = budgetAdjustmentButton + "&nbsp;" + budgetAdjustmentButtonHistroyButton;
//			 return tempReturnResult;
//		 }});
	
	
	projectRegistrationDataTable = $("#projectRegistrationListTable").dataTable({
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
		
		$('input[type="checkbox"]', projectRegistrationDataTable.fnGetNodes()).attr('checked',this.checked);
	  });
}

//点击项目信息按钮的响应事件，即跳入项目主键为itemPK的项目登记页面
function detailInfoButtonResponse(tempItemInfo) {
	
	var itemPK = tempItemInfo.itemPK;
	var itemState = tempItemInfo.itemState;
	var itemTypeID = tempItemInfo.itemTypeID;
	
	var detailInfoUrl = "";
	/*
	if(itemState == "10") {
		detailInfoUrl = "Page/Teacher/projectManagement/projectRegistration.jsp?itemPK=" 
							+ itemPK + "&itemTypeID=" + itemTypeID;
	} else {
		detailInfoUrl = "Page/Teacher/projectManagement/projectRegistrationView.jsp?itemPK=" 
			+ itemPK + "&itemState=" + itemTypeID;
	}*/
	switch (itemState)
	   {
	   case "10":
		   detailInfoUrl = "Page/Teacher/projectManagement/projectRegistration.jsp?itemPK=" 
				+ itemPK;
	     break;
	   case "11":
		   detailInfoUrl = "Page/Teacher/projectManagement/projectRegistrationView.jsp?itemPK=" 
				+ itemPK;
	     break;
	   case "30":
		   detailInfoUrl = "Page/Teacher/projectManagement/projectRegistration.jsp?itemPK=" 
				+ itemPK;
	     break;
	   case "41":
		   detailInfoUrl = "Page/Teacher/projectManagement/projectVerification.jsp?itemPK=" + itemPK;
	     break;
	   default:
		   detailInfoUrl = "Page/Teacher/projectManagement/projectRegistrationView.jsp?itemPK=" 
				+ itemPK;
	}
	parent.pageTransition(detailInfoUrl);
}

//点击新添入账申请按钮的响应事件
function addInAccountButtonResponse(tempItemInfo){
	
	var itemState = tempItemInfo.itemState;
	
	if(itemState == "10") {
		return false;
	} else {
		
		var itemID = tempItemInfo.itemID;
		
		var detailInfoUrl = "Page/Teacher/inAccountApplication/inAccountApplication.jsp?addOutlayPK=0&itemID=" + itemID;
		parent.pageTransition(detailInfoUrl);
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
		parent.pageTransition(detailInfoUrl);
	}
	
}

//新添支出登记按钮响应事件
function addPayRegisterButtonResponse(tempItemInfo) {
	
	console.log(tempItemInfo);
	var itemState = tempItemInfo.itemState;
	var itemBudgetType = tempItemInfo.itemBudgetType;
	var itemPK = tempItemInfo.itemPK;
	
	if(itemState == "10"
		 || !(itemBudgetType == "1" || itemBudgetType == "2" || itemBudgetType == "3" || itemBudgetType == "4")) {
		return false;
	} else {
		
		var detailInfoUrl = "";
		switch (itemBudgetType)
		   {
		   case "4":
			   detailInfoUrl = "Page/Teacher/payRegistration/socialScienceFundOutlay.jsp?outlayPK=0&itemPK=" + itemPK + "&pageType=register";
		     break;
		   case "3":
			   detailInfoUrl = "Page/Teacher/payRegistration/863OutlayForm.jsp?outlayPK=0"
				+ "&pageType=register&itemPK=" + itemPK;
		     break;
		   case "2":
			   detailInfoUrl = "Page/Teacher/payRegistration/nationalFundOutlay.jsp?nationalFundOutlayPk=0&itemPK=" + itemPK;
		     break;
		   case "1":
			   detailInfoUrl = "Page/Teacher/payRegistration/provincialOutlayForm.jsp?itemPK=" + itemPK;
		     break;
		   default:
			   detailInfoUrl = "Page/Common/pageError.jsp";
		}
		parent.pageTransition(detailInfoUrl);
	}
}

//支出登记历史按钮响应事件
function payRegisterHistroyButtonResponse(tempItemInfo) {
	
	console.log(tempItemInfo);
	var itemState = tempItemInfo.itemState;
	var itemBudgetType = tempItemInfo.itemBudgetType;
	var itemPK = tempItemInfo.itemPK;
	
	if(itemState == "10"
		 || !(itemBudgetType == "1" || itemBudgetType == "2" || itemBudgetType == "3" || itemBudgetType == "4")) {
		return false;
	} else {
		
		var detailInfoUrl = "";
		switch (itemBudgetType)
		   {
		   case "4":
			   detailInfoUrl = "Page/Teacher/payRegistration/socialScienceFundOutlayList.jsp?itemPK=" 
					+ itemPK;
		     break;
		   case "3":
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
		parent.pageTransition(detailInfoUrl);
	}
}

//预算调整按钮响应事件
function budgetAdjustmentButtonResponse(tempItemInfo) {
	
	var itemState = tempItemInfo.itemState;
	var itemBudgetType = tempItemInfo.itemBudgetType;
	
	if(itemState == "10" || !(itemBudgetType == "2" || itemBudgetType == "3")) {
		return false;
	} else {
		
		var itemPK = tempItemInfo.itemPK;
		var detailInfoUrl = "";
		
		switch(itemBudgetType) {
			case "2":
			   detailInfoUrl = "Page/Teacher/projectManagement/nationalFundBudgetAdjustment.jsp?nationalFundAdjustPk=0&itemPK=" + itemPK;
			   break;
			case "3":
			   detailInfoUrl = "Page/Teacher/projectManagement/863Adjust.jsp?a863adjustPk=0&itemPK=" + itemPK;
			   break;
			default:
				detailInfoUrl = "Page/Common/pageError.jsp";
		}
		
		parent.pageTransition(detailInfoUrl);
	}
	
	
}

//预算调整历史按钮响应事件
function budgetAdjustmentButtonHistroyButtonResponse(tempItemInfo) {
	
	var itemState = tempItemInfo.itemState;
	var itemBudgetType = tempItemInfo.itemBudgetType;
	
	if(itemState == "10" || !(itemBudgetType == "2" || itemBudgetType == "3")) {
		return false;
	} else {
		
		var itemPK = tempItemInfo.itemPK;
		var detailInfoUrl = "";
		
		switch(itemBudgetType) {
			case "2":
			   detailInfoUrl = "Page/Teacher/projectManagement/nationalFundAdjustList.jsp?itemPK=" + itemPK;
			   break;
			case "3":
			   detailInfoUrl = "Page/Teacher/projectManagement/863AdjustList.jsp?itemPK=" + itemPK;
			   break;
			default:
				detailInfoUrl = "Page/Common/pageError.jsp";
		}
		
		parent.pageTransition(detailInfoUrl);
	}
	
	
}

//取得被选中的项目
function getSelectedItems() {
	var itemPKArray = new Array();
	//fnGetFilteredNodes
	var allCheckBoxDomnode = $("input[type='checkbox']:checked", projectRegistrationDataTable.fnGetNodes());
    for(var i = 0; i < allCheckBoxDomnode.length; i++) {
    	var tempCheckBoxID = allCheckBoxDomnode[i].id;
    	var tempItemPK = tempCheckBoxID.substr(8);
    	itemPKArray.push(tempItemPK);
    }
    
    return itemPKArray;
}