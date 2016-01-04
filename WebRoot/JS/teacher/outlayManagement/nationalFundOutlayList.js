var nationalFundOutlayListTable;

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
	
	
	console.log("national Fund Outlay list page begin");
	console.log(itemPK);
	
	
	// 新添支出按钮的响应事件，即跳入到填写预算调整的页面
    $('#addNewNationalFundOutlayButton').click( function() {
    	
    	var detailInfoUrl = "Page/Teacher/payRegistration/nationalFundOutlay.jsp?nationalFundOutlayPk=0&itemPK=" + itemPK;
    	parent.pageTransition(detailInfoUrl);
    } );   
	
	generalAjaxCallToLoadData("acquireAllNationalFundOutlayList.action",{"itemPK":itemPK},initializeOutlayList);
	
});

//初始化 支出列表
function initializeOutlayList(data){
	
	var tableData = new Array();
	
	if(!data.actionStatus) {
		console.log("error");
		//return false;
	} else {
		
		var itemInfo = data.jsonResult.itemInfo;
		console.log(itemInfo);
		$("#contractId").html(itemInfo.contractId);
		$("#itemName").html(itemInfo.itemName);
		$("#itemType").html(itemInfo.typeName);
		
		var allNationalFundOutlayList = data.jsonResult.allNationalFundOutlayListinfo;
		
		for(var i = 0; i < allNationalFundOutlayList.length; i++) {
			
			var tempOutlayInfo = allNationalFundOutlayList[i];
			console.log(tempOutlayInfo);
			var tempRowData = new Array();
			
			tempRowData.push(tempOutlayInfo.nationalFundOutlayPk);
			tempRowData.push(tempOutlayInfo.nationalFundOutlayPk);//支出PK，不显示
			tempRowData.push(tempOutlayInfo.itemPk);//项目PK，不显示
			tempRowData.push(tempOutlayInfo.outlayTime);//支出时间
			tempRowData.push(tempOutlayInfo.sums);//总支出金额		
			
			tableData.push(tempRowData);
		}
	}
	
	var tableTagArray = new Array();
	
		tableTagArray.push({ "sTitle": "<input type=\"checkbox\" id=\"selectAllCheckBox\"></input>", "sClass": "center",
			"sWidth": "5%", "bSortable": false,
			"fnRender": function(obj){
				 var nationalFundOutlayPk = obj.aData[ obj.iDataColumn ];
				 var checkBoxID = "checkBox" + nationalFundOutlayPk;
				 var tempCheckBox = "<input type=\"checkbox\" id=" + checkBoxID + " />";
				 return tempCheckBox;
			 }});	
		
		tableTagArray.push({ "sTitle": "nationalFundOutlayPk", "sClass": "center", "bVisible": false, "bSearchable": false});
		
		tableTagArray.push({ "sTitle": "itemPk", "sClass": "center", "bVisible": false, "bSearchable": false});
		
		tableTagArray.push({ "sTitle": "支出时间", "sClass": "center", "sWidth": "55%",
				"fnRender": function(obj){
					 var outlayTime = obj.aData[ obj.iDataColumn];
					 var nationalFundOutlayPk = obj.aData[ obj.iDataColumn - 2];
					 var itemPK = obj.aData[ obj.iDataColumn - 1];
					 
					 var tempOutlayInfo = {"nationalFundOutlayPk":nationalFundOutlayPk, "itemPK":itemPK};
					 var tempOutlayInfoStr = jsonToString(tempOutlayInfo);
					 var tempHref = "<a onclick = \"detailInfoButtonResponse(" + tempOutlayInfoStr + ")\">" + outlayTime + "</a>";
					 return tempHref;
				 }});
		
		tableTagArray.push({ "sTitle": "支出总金额", "sClass": "center", "sWidth": "40%" });
		
		
		
		nationalFundOutlayListTable = $("#nationalFundOutlayListTable").dataTable({
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
			
			$('input[type="checkbox"]', nationalFundOutlayListTable.fnGetNodes()).attr('checked',this.checked);
		  });
		
}


//支出的详细信息
function detailInfoButtonResponse(tempOutlayInfo) {
	console.log("tempOutlayInfo");
	console.log(tempOutlayInfo);
	
	
	var nationalFundOutlayPk = tempOutlayInfo.nationalFundOutlayPk;
	var itemPK = tempOutlayInfo.itemPK;
	
		
	var detailInfoUrl = "Page/Teacher/payRegistration/nationalFundOutlayView.jsp?nationalFundOutlayPk=" + nationalFundOutlayPk + "&itemPK=" + itemPK;
	
	parent.pageTransition(detailInfoUrl);
}