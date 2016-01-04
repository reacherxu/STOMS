var projectTypeDataTable;

$(document).ready(function(){
	consoleResponseInUnusabalEnvirenment();
	
	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"基础数据",
	                	"href":""
	                 },
	                 {
	                	"name":"项目类型",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	$("#addProjectTypeButton").click(function(check) { 
		
		var detailInfoUrl = "Page/Admin/fundamentalDataMaintainance/projectTypeEdit.jsp?isModifyPage=no";
    	parent.pageTransition(detailInfoUrl);
	});
	
	
	generalAjaxCallToLoadData("acquireAllProjectType.action",{},initializeProjectTypeTable);
});

function initializeProjectTypeTable(data){
	
	if(!data.actionStatus) {
		console.log("acquireProjectType failed!");
		return false;
	}
	
	var jsonResult = data.jsonResult;
	
	var tableData = new Array();
	
	
	for(var i = 0; i < jsonResult.length; i++) {
		
		var tempProjectType = jsonResult[i];
		
		var tempRowData = new Array();

		tempRowData.push(tempProjectType.typePk);
		tempRowData.push(tempProjectType.typePk);
		tempRowData.push(tempProjectType.typeId);
		tempRowData.push(tempProjectType.typeName);
		tempRowData.push(tempProjectType.departmentType);
		tempRowData.push(tempProjectType.isTax);
		tempRowData.push(tempProjectType.isCross);

		
		tableData.push(tempRowData);
	}
	
	var projectTypeTableTagArray = new Array();
	
	projectTypeTableTagArray.push({ "sTitle": "<input type=\"checkbox\" id=\"selectAllCheckBox\"></input>", "sClass": "center",
		"sWidth": "3%", "bSortable": false,
		"fnRender": function(obj){
			 var PK = obj.aData[ obj.iDataColumn ];
			 var checkBoxID = "checkBox" + PK;
			 var tempCheckBox = "<input type=\"checkbox\" id=" + checkBoxID + " />";
			 return tempCheckBox;
		 }});
	
	projectTypeTableTagArray.push({ "sTitle": "PK", "sClass": "center", "bVisible": false, "bSearchable": false });
	projectTypeTableTagArray.push({ "sTitle": "类型ID", "sClass": "center", "sWidth": "15%" });

	projectTypeTableTagArray.push({ "sTitle": "类型名称", "sClass": "center", "sWidth": "37%",
		"fnRender": function(obj){
			 var name = obj.aData[ obj.iDataColumn];
			 var typePK = obj.aData[ obj.iDataColumn - 2];
			 
			 var tempPkValue = {"typePK":typePK};
			 var tempPkValueString = jsonToString(tempPkValue);
			 
			 var tempHref = "<a onclick = \"detailInfoButtonResponse(" + tempPkValueString + ")\">" + name + "</a>";
			 return tempHref;
		 }});
	
	projectTypeTableTagArray.push({ "sTitle": "文理科", "sClass": "center", "sWidth": "15%" });
	
	projectTypeTableTagArray.push({ "sTitle": "有税金 ", "sClass": "center", "sWidth": "15%" ,"fnRender": function(obj){
		
		var isValue = obj.aData[obj.iDataColumn];
		
		if(isValue == "1") return "是";
		else if(isValue == "0") return "否";
		else return "未知";
	}});
	
	projectTypeTableTagArray.push({ "sTitle": "横向项目 ", "sClass": "center", "sWidth": "15%" ,"fnRender": function(obj){
		
		var isValue = obj.aData[obj.iDataColumn];
		
		if(isValue == "1") return "是";
		else if(isValue == "0") return "否";
		else return "未知";
	}});
	
	projectTypeDataTable = $("#projectTypeMaintainanceTable").dataTable({
        "aaData": tableData,
        "aoColumns": projectTypeTableTagArray,
        "bLengthChange": false,
        "bJQueryUI": true,
        "oLanguage": dataTableLanguageGlobalVariable,
        "sScrollX": "100%",
        "sScrollXInner": "100%",
        "sPaginationType": "full_numbers"
    });
	
	//全选或全不选按钮
	$("#selectAllCheckBox").change(function(event){
		
		$('input[type="checkbox"]', projectTypeDataTable.fnGetNodes()).attr('checked',this.checked);
	  });
	
    //为修改按钮添加响应函数
    $('#modifyProjectTypeButton').click( function() {
    	
    	var selectedRowsOrder = getSelectedItems();
    	
        if(selectedRowsOrder == undefined || selectedRowsOrder.length == 0) {
        	alert("请选中一行！");
        	return false;
        }
        
        if(selectedRowsOrder.length > 1) {
        	alert("请只选中一条您所要修改的院系信息！");
        	return false;
        }
        
        //转移
    	var url = "Page/Admin/fundamentalDataMaintainance/projectTypeEdit.jsp?projectTypePK=" + selectedRowsOrder[0] + "&isModifyPage=" + "yes";
    	parent.pageTransition(url);
    	
    } );
    
    //删除按钮响应函数
    $('#deleteProjectTypeButton').click( function() {
    	
    	var allCheckBoxDomnode = $("input[type='checkbox']:checked", projectTypeDataTable.fnGetNodes());
		
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
        	var tempIndex = projectTypeDataTable.fnGetPosition(( $(allCheckBoxDomnode[i]).parent().parent())[0]);
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
	
	generalAjaxCallToLoadData("deleteSelectedProjectType.action",{"PKArray":PKArray},showDeletionResult,indexArray);
	
}

function showDeletionResult(data,rowDataArray) {
	
	if(!data.actionStatus) {
		alert("删除失败，请重试！");
		return false;
	}
	
	//删除得从最大的开始删 否则每删一个会从新排序，序号不对
	for(var i = rowDataArray.length - 1; i >= 0; i--) {
		var rowData = rowDataArray[i];
		projectTypeDataTable.fnDeleteRow(rowData);
	}
	
	alert("删除成功！");
}


//点的名字上的链接转移函数
function detailInfoButtonResponse(tempInAccountInfo) {	
	
	var projectTypePK = tempInAccountInfo.typePK;
	
	var detailInfoUrl = "Page/Admin/fundamentalDataMaintainance/projectTypeEdit.jsp?projectTypePK=" + projectTypePK + "&isModifyPage=" + "yes";
	
	parent.pageTransition(detailInfoUrl);
	
}

//取得被选中的项目
function getSelectedItems() {
	var itemPKArray = new Array();
	//fnGetFilteredNodes
	var allCheckBoxDomnode = $("input[type='checkbox']:checked", projectTypeDataTable.fnGetNodes());

	
    for(var i = 0; i < allCheckBoxDomnode.length; i++) {
    	var tempCheckBoxID = allCheckBoxDomnode[i].id;
    	var tempItemPK = tempCheckBoxID.substr(8);
    	itemPKArray.push(tempItemPK);
    }
    
    return itemPKArray;
}