var projectVerificationDataTable;

$(document).ready(function(){
	consoleResponseInUnusabalEnvirenment();
	
	console.log("project verification list page begin");
    
	generalAjaxCallToLoadData("findAllUnapprovedItems.action",{},initializePageContent);
});

function initializePageContent(data){
	
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	
	console.log("initialize project registration success");
	
	var jsonResult = data.jsonResult;
	console.log(jsonResult);
	
	var tableData = new Array();
	
	for(var i = 0; i < jsonResult.length; i++) {
		
		var tempItemInfo = jsonResult[i];
		var tempRowData = new Array();
		tempRowData.push(tempItemInfo.itemName);
		tempRowData.push(tempItemInfo.typeName);
		tempRowData.push(tempItemInfo.projectType.typeId);
		tempRowData.push(tempItemInfo.projectStatus);
		tempRowData.push(tempItemInfo.projectStatus);
		tempRowData.push(tempItemInfo.itemPk);
		tableData.push(tempRowData);
	}
	
	var tableTagArray = new Array();
	tableTagArray.push({ "sTitle": "名称", "sClass": "center", "sWidth": "30%"});
	tableTagArray.push({ "sTitle": "项目类型", "sClass": "center", "sWidth": "20%", "bSearchable": false});
	tableTagArray.push({ "sTitle": "项目类型ID", "sClass": "center", "bVisible": false, "bSearchable": false});
	tableTagArray.push({ "sTitle": "状态", "sClass": "center", "sWidth": "20%", "bSearchable": false,
							"fnRender": function(obj){
								 var itemState = obj.aData[ obj.iDataColumn ];
								 var tempProjectType = projectTypeArrayGlobalVariable[itemState];
								 return tempProjectType;
							 }});
	tableTagArray.push({ "sTitle": "状态代码", "sClass": "center", "bVisible": false, "bSearchable": false});
	tableTagArray.push({ "sTitle": "项目确认", "sClass": "center", "sWidth": "15%", "bSortable": false, "bSearchable": false,
							 "fnRender": function(obj){
								 var itemPK = obj.aData[ obj.iDataColumn ];
								 var itemState = obj.aData[ obj.iDataColumn - 1];
								 var itemTypeID = obj.aData[ obj.iDataColumn - 3];
								 var tempItemInfo = {"itemPK":itemPK, "itemState":itemState, "itemTypeID":itemTypeID};
								 var tempItemInfoStr = jsonToString(tempItemInfo);
								 var tempButton = "<button type=\"button\" onclick = \"detailInfoButtonResponse(" + tempItemInfoStr + ")\">项目确认</button>";
								 return tempButton;
							 }});
	
	projectVerificationDataTable = $("#projectVerificationListTable").dataTable({
	        "aaData": tableData,
	        "aoColumns": tableTagArray,
	        "bLengthChange": false,
	        "bJQueryUI": true,
	        "oLanguage": dataTableLanguageGlobalVariable,
	        "sScrollX": "100%",
	        "sScrollXInner": "100%",
	        "sPaginationType": "full_numbers",
	        "aaSorting": []
	    });
	
	
}

//点击项目信息按钮的响应事件，即跳入项目主键为itemPK的项目登记页面
function detailInfoButtonResponse(tempItemInfo) {
	
	var itemPK = tempItemInfo.itemPK;
	var itemState = tempItemInfo.itemState;
	var itemTypeID = tempItemInfo.itemTypeID;
	
	var detailInfoUrl = "Page/Teacher/projectManagement/projectVerification.jsp?itemPK=" 
		+ itemPK+ "&itemTypeID=" + itemTypeID;
	
	
//	if(itemState == "10")  {
//		detailInfoUrl = "Page/Teacher/projectManagement/projectRegistration.jsp?itemPK=" + itemPK;
//	} else {
//		detailInfoUrl = "Page/Teacher/projectManagement/projectRegistrationView.jsp?itemPK=" + itemPK;
//	}
//	
	
	
	parent.pageTransition(detailInfoUrl);
}