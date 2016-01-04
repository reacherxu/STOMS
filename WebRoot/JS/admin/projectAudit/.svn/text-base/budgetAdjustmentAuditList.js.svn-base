var budgetAdjustmentAuditListTable;

$(document).ready(function(){
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"项目查询",
	                	"href":""
	                 },
	                 {
	                	"name":"预算调整审核",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	console.log("budgetAdjustmentAudit List page begin");
	
	generalAjaxCallToLoadData("acquireAllUnAuditedBudgetAdjustment.action",{},initializePageContent);
});

//初始化预算调整列表
function initializePageContent(data) {
	
	var tableData = new Array();
	
	if(!data.actionStatus) {
		console.log("error");
		//return false;
	} else {
		
		var budgetAdjustList = data.jsonResult;
		console.log(budgetAdjustList);
		
		for(var i = 0; i < budgetAdjustList.length; i++) {
			
			var tempBudgetAdjustInfo = budgetAdjustList[i];
			
			var tempRowData = new Array();
			tempRowData.push(tempBudgetAdjustInfo.nationalFundAdjustPk);
			tempRowData.push(tempBudgetAdjustInfo.nationalFundAdjustPk);  //调整PK，不显示
			tempRowData.push(tempBudgetAdjustInfo.itemPk2);//项目PK，不显示
			tempRowData.push(tempBudgetAdjustInfo.item.itemName);   //项目名称
			tempRowData.push(tempBudgetAdjustInfo.item.departmentName);   //项目院系
			tempRowData.push(tempBudgetAdjustInfo.item.typeName);   //项目类型
			tempRowData.push(tempBudgetAdjustInfo.item.departmentType);   // 文/理科
			tempRowData.push(tempBudgetAdjustInfo.ntime);//调整时间
			tempRowData.push(tempBudgetAdjustInfo.sums);//总调整金额
			
			
			tableData.push(tempRowData);
		}
	}
	
var tableTagArray = new Array();
	
	tableTagArray.push({ "sTitle": "<input type=\"checkbox\" id=\"selectAllCheckBox\"></input>", "sClass": "center",
			"sWidth": "5%", "bSortable": false,
			"fnRender": function(obj){
				 var nationalFundAdjustPk = obj.aData[ obj.iDataColumn ];
				 var checkBoxID = "checkBox" + nationalFundAdjustPk;
				 var tempCheckBox = "<input type=\"checkbox\" id=" + checkBoxID + " />";
				 return tempCheckBox;
			 }});
	
	tableTagArray.push({ "sTitle": "nationalFundAdjustPk", "sClass": "center", "bVisible": false, "bSearchable": false});
	
	tableTagArray.push({ "sTitle": "itemPk", "sClass": "center", "bVisible": false, "bSearchable": false});
	
	
	tableTagArray.push({ "sTitle": "项目名称", "sClass": "center", "sWidth": "29%",
			"fnRender": function(obj){
				 var itemName = obj.aData[ obj.iDataColumn];
				 var nationalFundAdjustPk = obj.aData[ obj.iDataColumn - 2];
				 var itemPK = obj.aData[ obj.iDataColumn - 1];
				 
				 var tempAdjustInfo = {"nationalFundAdjustPk":nationalFundAdjustPk, "itemPK":itemPK};
				 var tempAdjustInfoStr = jsonToString(tempAdjustInfo);
				 
				 
				 var tempHref = "<a onclick = \"detailInfoButtonResponse(" + tempAdjustInfoStr + ")\">" + itemName + "</a>";
				 return tempHref;
			 }});
	
	tableTagArray.push({ "sTitle": "院系", "sClass": "center", "sWidth": "10%" });
	
	tableTagArray.push({ "sTitle": "类型", "sClass": "center", "sWidth": "14%" });
	
	tableTagArray.push({ "sTitle": "文/理科", "sClass": "center", "sWidth": "14%" });
	
	tableTagArray.push({ "sTitle": "时间", "sClass": "center", "sWidth": "13%" });
	
	tableTagArray.push({ "sTitle": "调整总金额", "sClass": "center", "sWidth": "15%" });
	
	
	budgetAdjustmentAuditListTable = $("#budgetAdjustmentAuditListTable").dataTable({
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
		
		$('input[type="checkbox"]', budgetAdjustmentAuditListTable.fnGetNodes()).attr('checked',this.checked);
	  });
}
	
function detailInfoButtonResponse(tempAdjustInfo) {
	
	var nationalFundAdjustPk = tempAdjustInfo.nationalFundAdjustPk;
	var itemPK = tempAdjustInfo.itemPK;
	
	var detailInfoUrl = "Page/Admin/projectAudit/budgetAdjustmentAudit.jsp?nationalFundAdjustPk=" + nationalFundAdjustPk + "&itemPK=" + itemPK;
	
	parent.pageTransition(detailInfoUrl);
	
}