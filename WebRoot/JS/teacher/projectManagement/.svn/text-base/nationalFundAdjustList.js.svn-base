var nationalFundAdjustListTable;

$(document).ready(function(){
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"我的项目",
	                	"href":"Page/Teacher/projectManagement/projectRegistrationList.jsp"
	                 },
	                 {
	                	"name":"预算调整历史",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	console.log("national Fund Adjust list page begin");
	console.log(itemPK);
	
	// 新添调整按钮的响应事件，即跳入到填写预算调整的页面
    $('#addNewNationalFundAdjustButton').click( function() {
    	
    	var detailInfoUrl = "Page/Teacher/projectManagement/nationalFundBudgetAdjustment.jsp?nationalFundAdjustPk=0&itemPK=" + itemPK;
    	parent.pageTransition(detailInfoUrl);
    } );
    
	
	generalAjaxCallToLoadData("acquireAllNationalFundAdjustList.action",{"itemPK":itemPK},initializeAdjustList);
	
});


//初始化预算调整列表
function initializeAdjustList(data){
	

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
		
		
		
		
		var allNationalFundAdjustList = data.jsonResult.allNationalFundAdjustListinfo;
		
		console.log(allNationalFundAdjustList);
		
		for(var i = 0; i < allNationalFundAdjustList.length; i++) {
			
			var tempAdjustInfo = allNationalFundAdjustList[i];
			console.log(tempAdjustInfo);
			var tempRowData = new Array();
			
			tempRowData.push(tempAdjustInfo.nationalFundAdjustPk);
			tempRowData.push(tempAdjustInfo.nationalFundAdjustPk);//调整PK，不显示
			tempRowData.push(tempAdjustInfo.itemPk2);//项目PK，不显示
			tempRowData.push(tempAdjustInfo.ntime);//调整时间
			tempRowData.push(tempAdjustInfo.sums);//总调整金额		
			tempRowData.push(tempAdjustInfo.nstatus);//状态
			tempRowData.push(tempAdjustInfo.nstatus);//状态代码，不显示
			
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
		
		tableTagArray.push({ "sTitle": "调整时间", "sClass": "center", "sWidth": "40%",
				"fnRender": function(obj){
					 var ntime = obj.aData[ obj.iDataColumn];
					 var nationalFundAdjustPk = obj.aData[ obj.iDataColumn - 2];
					 var itemPK = obj.aData[ obj.iDataColumn - 1];
					 var adjustState = obj.aData[ obj.iDataColumn + 2];
					 
					 var tempAdjustInfo = {"nationalFundAdjustPk":nationalFundAdjustPk, "itemPK":itemPK, "adjustState":adjustState};
					 var tempAdjustInfoStr = jsonToString(tempAdjustInfo);
					 var tempHref = "<a onclick = \"detailInfoButtonResponse(" + tempAdjustInfoStr + ")\">" + ntime + "</a>";
					 return tempHref;
				 }});
		
		tableTagArray.push({ "sTitle": "调整总金额", "sClass": "center", "sWidth": "35%" });
		
		
		tableTagArray.push({ "sTitle": "状态", "sClass": "center", "sWidth": "20%" , 
				"fnRender": function(obj){
					 var adjustState = obj.aData[ obj.iDataColumn ];
					 var tempProjectType = projectStateArrayGlobalVariable[adjustState];
					 return tempProjectType;
				 }});
		
		tableTagArray.push({ "sTitle": "状态ID", "sClass": "center", "bVisible": false, "bSearchable": false});
		
		
		nationalFundAdjustListTable = $("#nationalFundAdjustListTable").dataTable({
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
			
			$('input[type="checkbox"]', nationalFundAdjustListTable.fnGetNodes()).attr('checked',this.checked);
		  });
		
		
}

//调整的详细信息
function detailInfoButtonResponse(tempAdjustInfo) {
	console.log("tempAdjustInfo");
	console.log(tempAdjustInfo);
	
	var adjustState = tempAdjustInfo.adjustState;
	var nationalFundAdjustPk = tempAdjustInfo.nationalFundAdjustPk;
	var itemPK = tempAdjustInfo.itemPK;
	
	var detailInfoUrl = "";
	
	if(adjustState == "10") {
		
		detailInfoUrl = "Page/Teacher/projectManagement/nationalFundBudgetAdjustment.jsp?nationalFundAdjustPk=" + nationalFundAdjustPk + "&itemPK=" + itemPK;
	} else {
		detailInfoUrl = "Page/Teacher/projectManagement/nationalFundAdjustView.jsp?nationalFundAdjustPk=" + nationalFundAdjustPk + "&itemPK=" + itemPK;
	}
	
	parent.pageTransition(detailInfoUrl);
}