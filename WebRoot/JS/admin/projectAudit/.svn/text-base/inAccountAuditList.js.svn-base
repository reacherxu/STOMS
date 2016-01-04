var inAccountAuditListTable;

$(document).ready(function(){
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"项目查询",
	                	"href":""
	                 },
	                 {
	                	"name":"入账审核",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	console.log("inAccount audit list page begin");
	
	generalAjaxCallToLoadData("acquireAllUnAuditedInAccountApplications.action",{},initializePageContent);
});

//初始化入账申请列表
function initializePageContent(data) {
	
	var tableData = new Array();
	
	if(!data.actionStatus) {
		console.log("error");
		//return false;
	} else {
		
		var inAccountApplicationList = data.jsonResult;
		console.log(inAccountApplicationList);
		
		for(var i = 0; i < inAccountApplicationList.length; i++) {
			
			var tempInAccountInfo = inAccountApplicationList[i];
			
			var tempRowData = new Array();
			tempRowData.push(tempInAccountInfo.addOutlayPk);
			tempRowData.push(tempInAccountInfo.addOutlayPk);  //入账PK，不显示
			tempRowData.push(tempInAccountInfo.itemName);   //项目名称
			tempRowData.push(tempInAccountInfo.departmentName);   //项目院系
			tempRowData.push(tempInAccountInfo.typeName);   //项目类型
			tempRowData.push(tempInAccountInfo.departmentType);   // 文/理科
			tempRowData.push(tempInAccountInfo.outlayValue);     //入账金额
			//tempRowData.push(tempInAccountInfo.teacherName);   //项目负责人
			
			tableData.push(tempRowData);
		}
		
		console.log(tableData);
	}
	
	var tableTagArray = new Array();
	
	tableTagArray.push({ "sTitle": "<input type=\"checkbox\" id=\"selectAllCheckBox\"></input>", "sClass": "center",
			"sWidth": "5%", "bSortable": false,
			"fnRender": function(obj){
				console.log(obj);
				 var addOutlayPk = obj.aData[ obj.iDataColumn ];
				 var checkBoxID = "checkBox" + addOutlayPk;
				 var tempCheckBox = "<input type=\"checkbox\" id=" + checkBoxID + " />";
				 return tempCheckBox;
			 }});
	
	tableTagArray.push({ "sTitle": "入账addOutlayPk", "sClass": "center", "bVisible": false, "bSearchable": false});
	
	tableTagArray.push({ "sTitle": "项目名称", "sClass": "center", "sWidth": "30%",
			"fnRender": function(obj){
				 var outlayDepartment = obj.aData[ obj.iDataColumn];
				 var addOutlayPk = obj.aData[ obj.iDataColumn - 1];
				 
				 var tempInAccountInfo = {"addOutlayPk":addOutlayPk};
				 var tempInAccountInfoStr = jsonToString(tempInAccountInfo);
				 
				 var tempHref = "<a onclick = \"detailInfoButtonResponse(" + tempInAccountInfoStr + ")\">" + outlayDepartment + "</a>";
				 return tempHref;
			 }});
	
	tableTagArray.push({ "sTitle": "院系", "sClass": "center", "sWidth": "15%" });
	
	tableTagArray.push({ "sTitle": "项目类型", "sClass": "center", "sWidth": "20%" });
	
	tableTagArray.push({ "sTitle": "文/理科", "sClass": "center", "sWidth": "15%" });
	
	tableTagArray.push({ "sTitle": "来款金额", "sClass": "center", "sWidth": "15%" });
	
	//tableTagArray.push({ "sTitle": "负责人", "sClass": "center", "sWidth": "15%" });
	
	
	inAccountAuditListTable = $("#inAccountAuditListTable").dataTable({
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
		
		$('input[type="checkbox"]', inAccountAuditListTable.fnGetNodes()).attr('checked',this.checked);
	  });
}

function detailInfoButtonResponse(tempInAccountInfo) {	
	
	var addOutlayPk = tempInAccountInfo.addOutlayPk;
	
	var detailInfoUrl = "Page/Admin/projectAudit/inAccountAudit.jsp?addOutlayPK=" + addOutlayPk;
	
	parent.pageTransition(detailInfoUrl);
	
}