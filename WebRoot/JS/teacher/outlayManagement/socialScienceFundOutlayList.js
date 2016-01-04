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
	
	console.log("itemPK : " + itemPK);
	
	
	$("#addNewSocialScienceFundOutlayButton").click(function(check) { 
		
    	var url = "Page/Teacher/payRegistration/socialScienceFundOutlay.jsp?outlayPK=0"
			+ "&itemPK=" + itemPK + "&pageType=register";
    	parent.pageTransition(url);
	});
	
	generalAjaxCallToLoadData("acquireSocialScienceFundOutlayListInfoByItemPK.action",{"itemPK":itemPK},initializeTable);
	
    });

//初始化表单
function initializeTable(data) {
	
	var tableData = new Array();
	
	console.log(data.jsonResult);
	
	if(data.actionStatus) {
		var itemInfo = data.jsonResult.socialScienceFundItemInfo;
		$("#itemName").html(itemInfo.itemName);
		$("#contractId").html(itemInfo.contractId);
		$("#itemType").html(itemInfo.projectType.typeName);
		
		var socialScienceFundOutlayList = data.jsonResult.socialScienceFundOutlayList;
		
		for(var i = 0; i < socialScienceFundOutlayList.length; i++) {
			
			var tempOutlayInfo = socialScienceFundOutlayList[i];
			//console.log(tempDepartmentInfo);
			var tempRowData = new Array();
			
			tempRowData.push(tempOutlayInfo.socialScienceOutlayPk);
			tempRowData.push(tempOutlayInfo.socialScienceOutlayPk);
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
	
	outlayListTable = $("#socialScienceFundOutlayListTable").dataTable({
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
	
}

//点的名字上的链接转移函数
function detailInfoButtonResponse(tempInAccountInfo) {	
	
	var outlayPK = tempInAccountInfo.outlayPK;
	
	var detailInfoUrl = "Page/Teacher/payRegistration/socialScienceFundOutlay.jsp?outlayPK=" + outlayPK 
						+ "&itemPK=" + itemPK + "&pageType=view";
	
	parent.pageTransition(detailInfoUrl);
	
}

function hideTableColumn(tableID, nCol)   
{   
    var rows = $("#" + tableID).rows;
    for(var i=0; i < rows.length; i++) {
    	if (rows[i].cells.length   >   nCol) {
    		rows[i].cells[nCol].style.display = "none";
    	}
    }
} 