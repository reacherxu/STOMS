var projectInfoAuditListTable;

$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"项目查询",
	                	"href":""
	                 },
	                 {
	                	"name":"项目信息审核",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	generalAjaxCallToLoadData("acquireProjectInfoAuditList.action",{},initializePageContent);
});


/**
 * 初始化列表
 * @param data
 */
function initializePageContent(data) {
	
	var tableData = new Array();
	
	if(!data.actionStatus) {
		console.log("error");
		
	} else {
		
		var projectInfoAuditList = data.jsonResult;
		console.log(projectInfoAuditList);
		
		for(var i = 0; i < projectInfoAuditList.length; i++) {
			
			var tempItemInfo = projectInfoAuditList[i];
			
			var tempRowData = new Array();
//			tempRowData.push(tempItemInfo.itemPk);
			tempRowData.push(tempItemInfo.itemPk);
			tempRowData.push(tempItemInfo.projectType.typeId);
			tempRowData.push(tempItemInfo.itemName);   //项目名称
			tempRowData.push(tempItemInfo.departmentName);   //项目院系
			tempRowData.push(tempItemInfo.typeName);   //项目类型
			tempRowData.push(tempItemInfo.departmentType);   // 文/理科
			tempRowData.push(tempItemInfo.teacherName);   //项目负责人
			
			tableData.push(tempRowData);
		}
	}
	
	var tableTagArray = new Array();
	
//	tableTagArray.push({ "sTitle": "<input type=\"checkbox\" id=\"selectAllCheckBox\"><label id = \"selectAllCheckBoxLabel\">全选</label></input>", "sClass": "center",
//			"sWidth": "10%", "bSortable": false,
//			"fnRender": function(obj){
//				 var itemPK = obj.aData[ obj.iDataColumn ];
//				 var checkBoxID = "checkBox" + itemPK;
//				 var tempCheckBox = "<input type=\"checkbox\" id=" + checkBoxID + " />";
//				 return tempCheckBox;
//			 }});
	
	tableTagArray.push({ "sTitle": "项目ItemPK", "sClass": "center", "bVisible": false, "bSearchable": false});
	
	tableTagArray.push({ "sTitle": "项目类型ID", "sClass": "center", "bVisible": false, "bSearchable": false});

	tableTagArray.push({ "sTitle": "项目名称", "sClass": "center", "sWidth": "27%",
			"fnRender": function(obj){
		
				 var itemName = obj.aData[ obj.iDataColumn];
				 var itemPK = obj.aData[ obj.iDataColumn - 2];
				 var itemTypeID = obj.aData[ obj.iDataColumn - 1];
				 
				 var tempItemInfo = {"itemPK":itemPK, "itemTypeID":itemTypeID};
				 var tempItemInfoStr = jsonToString(tempItemInfo);
				 
				 var tempHref = "<a onclick = \"detailInfoButtonResponse(" + tempItemInfoStr + ")\">" + itemName + "</a>";
				 return tempHref;
			 }});
	
	tableTagArray.push({ "sTitle": "院系", "sClass": "center", "sWidth": "15%" });
	
	tableTagArray.push({ "sTitle": "项目类型", "sClass": "center", "sWidth": "20%" });
	
	tableTagArray.push({ "sTitle": "文/理科", "sClass": "center", "sWidth": "13%" });
	
	tableTagArray.push({ "sTitle": "负责人", "sClass": "center", "sWidth": "15%" });
	
	
	projectInfoAuditListTable = $("#projectInfoAuditListTable").dataTable({
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
		
		if(this.checked) {
			$("#selectAllCheckBoxLabel")[0].innerHTML = "全不选";
		} else {
			$("#selectAllCheckBoxLabel")[0].innerHTML = "全选";
		}
		
		$('input[type="checkbox"]', projectInfoAuditListTable.fnGetNodes()).attr('checked',this.checked);
	  });
}

function detailInfoButtonResponse(tempItemInfo) {
	
	var itemPK = tempItemInfo.itemPK;
	var itemTypeID = tempItemInfo.itemTypeID;
	
	var detailInfoUrl = "Page/Admin/projectAudit/projectInfoAudit.jsp?itemPK=" + itemPK;
	
	parent.pageTransition(detailInfoUrl);
	
}