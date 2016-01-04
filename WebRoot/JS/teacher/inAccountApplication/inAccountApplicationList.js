var inAccountApplicationListTable;

$(document).ready(function(){
	consoleResponseInUnusabalEnvirenment();
	
	
	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"我的项目",
	                	"href":"Page/Teacher/projectManagement/projectRegistrationList.jsp"
	                 },
	                 {
	                	"name":"入账申请历史",
		                "href":""
	                 }];

	if(parent.pathWayRender != undefined) {
		parent.pathWayRender(tempPagePaths);
	}
	
	/*if(parent.pathWayRender instanceof Function) {
		parent.pathWayRender(tempPagePaths);
	}*/
	
	/******************************* 显示导航条 结束****************************************/
	
	
	console.log("inAccount application list page begin");
	// 新添入账按钮的响应事件，即跳入到填写入账申请的页面
    $('#addNewInAccountApplicationButton').click( function() {
    	
    	var detailInfoUrl = "Page/Teacher/inAccountApplication/inAccountApplication.jsp?addOutlayPK=0&itemID=" + itemID;
    	if(parent.pageTransition != undefined) {
    		parent.pageTransition(detailInfoUrl);
    	}
    } );
    
	generalAjaxCallToLoadData("acquireAllInAccountApplicationsByItemID.action",{"itemID":itemID},initializePageContent);
});

//初始化入账申请列表
function initializePageContent(data) {
	
	var tableData = new Array();
	
	if(!data.actionStatus) {
		console.log("error");
		//return false;
	} else {
		//回显项目基本信息
		var itemBaseInfo = data.jsonResult.itemInfo;
		$("#itemTypeName").html(itemBaseInfo.typeName);
		$("#contractID").html(itemBaseInfo.contractId);
		$("#itemName").html(itemBaseInfo.itemName);
		
		//向表格填入历史入账数据
		var inAccountApplicationList = data.jsonResult.inAcccountListInfo;
		console.log(inAccountApplicationList);
		
		for(var i = 0; i < inAccountApplicationList.length; i++) {
			
			var tempInAccountInfo = inAccountApplicationList[i];
			
			var tempRowData = new Array();
			tempRowData.push(tempInAccountInfo.addOutlayPk);
			tempRowData.push(tempInAccountInfo.addOutlayPk);  //入账PK，不显示
			tempRowData.push(tempInAccountInfo.itemId);   //项目ID， 不显示
			tempRowData.push(tempInAccountInfo.outlayTime);
			tempRowData.push(tempInAccountInfo.outlayDepartment);
			tempRowData.push(tempInAccountInfo.cardId);
			tempRowData.push(tempInAccountInfo.outlayValue);
			tempRowData.push(tempInAccountInfo.astatus);
			tempRowData.push(tempInAccountInfo.astatus);  //状态代码，不显示
			
			tableData.push(tempRowData);
		}
	}
	
	
	
	var tableTagArray = new Array();
	
	tableTagArray.push({ "sTitle": "<input type=\"checkbox\" id=\"selectAllCheckBox\"></input>", "sClass": "center",
			"sWidth": "5%", "bSortable": false,
			"fnRender": function(obj){
				 var addOutlayPk = obj.aData[ obj.iDataColumn ];
				 var checkBoxID = "checkBox" + addOutlayPk;
				 var tempCheckBox = "<input type=\"checkbox\" id=" + checkBoxID + " />";
				 return tempCheckBox;
			 }});
	
	tableTagArray.push({ "sTitle": "入账addOutlayPk", "sClass": "center", "bVisible": false, "bSearchable": false});
	
	tableTagArray.push({ "sTitle": "项目ID", "sClass": "center", "bVisible": false, "bSearchable": false});
	
	tableTagArray.push({ "sTitle": "申请日期", "sClass": "center", "sWidth": "15%",
		"fnRender": function(obj){
			 var outlayTime = obj.aData[ obj.iDataColumn];
			 var addOutlayPk = obj.aData[ obj.iDataColumn - 2];
			 var itemID = obj.aData[ obj.iDataColumn - 1];
			 var inAccountApplicationState = obj.aData[ obj.iDataColumn + 5];
			 
			 var tempInAccountInfo = {"addOutlayPk":addOutlayPk, "itemID":itemID, "inAccountApplicationState":inAccountApplicationState};
			 var tempInAccountInfoStr = jsonToString(tempInAccountInfo);
			 var tempHref = "<a onclick = \"detailInfoButtonResponse(" + tempInAccountInfoStr + ")\">" + outlayTime + "</a>";
			 return tempHref;
		 }});
	
	tableTagArray.push({ "sTitle": "来款单位", "sClass": "center", "sWidth": "30%" });
	
	tableTagArray.push({ "sTitle": "经费卡号", "sClass": "center", "sWidth": "15%" });
	
	tableTagArray.push({ "sTitle": "来款金额", "sClass": "center", "sWidth": "15%" });
	
	tableTagArray.push({ "sTitle": "状态", "sClass": "center", "sWidth": "20%" , 
			"fnRender": function(obj){
				 var inAccountState = obj.aData[ obj.iDataColumn ];
				 var tempProjectType = projectStateArrayGlobalVariable[inAccountState];
				 return tempProjectType;
			 }});
	
	tableTagArray.push({ "sTitle": "状态ID", "sClass": "center", "bVisible": false, "bSearchable": false});
	
	
	inAccountApplicationListTable = $("#inAccountApplicationListTable").dataTable({
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
		
		$('input[type="checkbox"]', inAccountApplicationListTable.fnGetNodes()).attr('checked',this.checked);
	  });
}

//入账的详细信息
function detailInfoButtonResponse(tempInAccountInfo) {
	console.log("tempInAccountInfo");
	console.log(tempInAccountInfo);
	
	var inAccountApplicationState = tempInAccountInfo.inAccountApplicationState;
	var addOutlayPk = tempInAccountInfo.addOutlayPk;
	var itemID = tempInAccountInfo.itemID;
	
	var detailInfoUrl = "";
	
	if(inAccountApplicationState == "10" || inAccountApplicationState == "30") {
		
		detailInfoUrl = "Page/Teacher/inAccountApplication/inAccountApplication.jsp?addOutlayPK=" + addOutlayPk + "&itemID=" + itemID;
	} else if (inAccountApplicationState == "31") {
		
		detailInfoUrl = "Page/Teacher/inAccountApplication/approvedInAccountApplicationView.jsp?addOutlayPK=" + addOutlayPk + "&itemID=" + itemID;
	} else {
		
		detailInfoUrl = "Page/Teacher/inAccountApplication/inAccountApplicationView.jsp?addOutlayPK=" + addOutlayPk + "&itemID=" + itemID;
	}
	
	if(parent.pageTransition != undefined) {
		parent.pageTransition(detailInfoUrl);
	} else {
		window.open(detailInfoUrl);
	}
}