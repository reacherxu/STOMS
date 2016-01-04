var departmentDataTable;
var globalDepartmentPK;
var modifyRowNumber;

$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	
	//新增加一个院系的对话框
    $( "#createNewDepartmentDialog" ).dialog({
    	autoOpen: false,
		height: 400,
		width: 400,
		modal: true
    });
    //为createNewDepartmentForm表单添加验证功能
    $("#createNewDepartmentForm").validationEngine("attach");
  //点击assureCreatingTitleButton按钮时的响应事件
    $("#assureCreatingDepartmentButton").click(function(check) {    
        if($("#createNewDepartmentForm").validationEngine('validate')){
        	$( "#createNewDepartmentDialog" ).dialog("close");
        	var departmentId = $("#departmentId").val();
        	var departmentName = $("#departmentName").val();
        	var departmentType = $("#departmentType").val();
        	var assistanceName = $("#assistanceName").val();
        	var assistanceTel = $("#assistanceTel").val();
        	var assistanceMobile = $("#assistanceMobile").val();
        	var assistanceEmail = $("#assistanceEmail").val();
        	
        	var submitData = {};
        	submitData["departmentId"] = departmentId;
        	submitData["departmentName"] = departmentName;
        	submitData["departmentType"] = departmentType;
        	submitData["assistanceName"] = assistanceName;
        	submitData["assistanceTel"] = assistanceTel;
        	submitData["assistanceMobile"] = assistanceMobile;
        	submitData["assistanceEmail"] = assistanceEmail;
        	
        	//清空该Form表单
        	$("#createNewDepartmentForm")[0].reset();
        	
        	generalAjaxCallToLoadData("addNewDepartment.action",submitData,showAddDepartmentResult);
        }
        check.preventDefault();//此处阻止提交表单  
    });
    
  //modify一个院系的对话框
    $( "#modifyDepartmentDialog" ).dialog({
    	autoOpen: false,
		height: 400,
		width: 400,
		modal: true
    });
    
  //为modifyDepartmentForm表单添加验证功能
    $("#modifyDepartmentForm").validationEngine("attach");
    //点击assureModifyingDepartmentButton按钮时的响应事件
    $("#assureModifyingDepartmentButton").click(function(check) {    
        if($("#modifyDepartmentForm").validationEngine('validate')){
        	$( "#modifyDepartmentDialog" ).dialog("close");
        	var departmentId = $("#modifyDepartmentId").val();
        	var departmentName = $("#modifyDepartmentName").val();
        	var departmentType = $("#modifyDepartmentType").val();
        	var assistanceName = $("#modifyAssistanceName").val();
        	var assistanceTel = $("#modifyAssistanceTel").val();
        	var assistanceMobile = $("#modifyAssistanceMobile").val();
        	var assistanceEmail = $("#modifyAssistanceEmail").val();
        	
        	var submitData = {};
        	submitData["departmentId"] = departmentId;
        	submitData["departmentName"] = departmentName;
        	submitData["departmentType"] = departmentType;
        	submitData["assistanceName"] = assistanceName;
        	submitData["assistanceTel"] = assistanceTel;
        	submitData["assistanceMobile"] = assistanceMobile;
        	submitData["assistanceEmail"] = assistanceEmail;
        	submitData["departmentPK"] = globalDepartmentPK;
        	
        	//清空该Form表单
        	$("#modifyDepartmentForm")[0].reset();
        	
        	generalAjaxCallToLoadData("modifyDepartment.action",submitData,showModifyDepartmentResult,submitData);
        }
        check.preventDefault();//此处阻止提交表单  
    });
    
    
	generalAjaxCallToLoadData("acquireAllDepartmentInfo.action",{},initializeDepartmentTable);
});

function initializeDepartmentTable(data) {
	//console.log(data);
	if(!data.actionStatus) {
		//console.log("acquireAllDepartmentInfo failed!");
		return false;
	}
	
	var jsonResult = data.jsonResult;
	
	var tableData = new Array();
	
	
	for(var i = 0; i < jsonResult.length; i++) {
		
		var tempDepartmentInfo = jsonResult[i];
		//console.log(tempDepartmentInfo);
		var tempRowData = new Array();
		
		tempRowData.push(tempDepartmentInfo.departmentId);
		tempRowData.push(tempDepartmentInfo.departmentName);
		tempRowData.push(tempDepartmentInfo.departmentType);
		tempRowData.push(tempDepartmentInfo.assistanceId);
		tempRowData.push(tempDepartmentInfo.directorId);
		tempRowData.push(tempDepartmentInfo.assistanceTel);
		tempRowData.push(tempDepartmentInfo.assistanceMobile);
		tempRowData.push(tempDepartmentInfo.assistanceEmail);
		tempRowData.push(tempDepartmentInfo.departmentPk);
		
		tableData.push(tempRowData);
	}
	
	var departmentTableTagArray = new Array();
	departmentTableTagArray.push({ "sTitle": "编号", "sClass": "center", "sWidth": "10%" });
	departmentTableTagArray.push({ "sTitle": "名称", "sClass": "center", "sWidth": "15%" });
	departmentTableTagArray.push({ "sTitle": "类型", "sClass": "center", "sWidth": "10%" });
	departmentTableTagArray.push({ "sTitle": "秘书工号", "sClass": "center", "sWidth": "10%" });
	departmentTableTagArray.push({ "sTitle": "科研主任工号", "sClass": "center", "sWidth": "10%" });
	departmentTableTagArray.push({ "sTitle": "秘书电话", "sClass": "center", "sWidth": "15%" });
	departmentTableTagArray.push({ "sTitle": "秘书手机", "sClass": "center", "sWidth": "15%" });
	departmentTableTagArray.push({ "sTitle": "秘书Email", "sClass": "center", "sWidth": "15%" });
	departmentTableTagArray.push({ "sTitle": "PK", "sClass": "center", "bVisible": false, "bSearchable": false });
	
	departmentDataTable = $("#departmentMaintainanceTable").dataTable({
        "aaData": tableData,
        "aoColumns": departmentTableTagArray
    });
	
	 /* Add a click handler to the rows - this could be used as a callback */
	$("#departmentMaintainanceTable tbody").click(function(event) {
	    $(event.target.parentNode).toggleClass('row_selected');
	});
	
	/* Add a click handler for the add row */
    $('#addDepartmentButton').click( function() {
        
        //console.log("addDepartmentButton");
        $( "#createNewDepartmentDialog" ).dialog( "open" );
    } );
    
    /* Add a click handler for the delete row */
    $('#deleteDepartmentButton').click( function() {
        
        //console.log("deleteDepartmentButton");
        
        var selectedRows = acquireSelectedRowsInfo(departmentDataTable);
        
        if(selectedRows == undefined || selectedRows.length == 0) {
        	openGeneralMessageDialog("请选中一行！");
        	return false;
        }
        
        var departmentPKArray = new Array();
        var selectedRowArray = new Array();
        
        for(var i = 0; i < selectedRows.length; i++) {
        	
        	var rowNumber = selectedRows[i].rowNumber;
            var selectedRow = departmentDataTable.fnSettings().aoData[rowNumber]._aData;
            
            var departmentPK = selectedRow[7];
            departmentPKArray.push(departmentPK);
            selectedRowArray.push(selectedRows[i].rowData);
        	
        }
        
        
        
        var dataForDeletion = {"departmentPK":departmentPKArray, "rowData":selectedRowArray};
        openGeneralAssureDialog("您确定要删除该院系么？", deleteDepartment, dataForDeletion);
    } );
    
    /* Add a click handler for the delete row */
    $('#modifyDepartmentButton').click( function() {
        
       
        var selectedRows = acquireSelectedRowsInfo(departmentDataTable);
        
        if(selectedRows == undefined || selectedRows.length == 0) {
        	openGeneralMessageDialog("请选中一行！");
        	return false;
        }
        
        if(selectedRows.length > 1) {
        	openGeneralMessageDialog("请只选中一条您所要修改的院系信息！");
        	return false;
        }
        
        modifyRowNumber = selectedRows[0].rowNumber;
        var selectedRow = departmentDataTable.fnSettings().aoData[modifyRowNumber]._aData;
       
        $("#modifyDepartmentId").val(selectedRow[0]);
        $("#modifyDepartmentName").val(selectedRow[1]);
        $("#modifyDepartmentType").val(selectedRow[2]);
        $("#modifyAssistanceName").val(selectedRow[3]);
        $("#modifyAssistanceTel").val(selectedRow[4]);
        $("#modifyAssistanceMobile").val(selectedRow[5]);
        $("#modifyAssistanceEmail").val(selectedRow[6]);
        
        
        $( "#modifyDepartmentDialog" ).dialog( "open" );
        
        globalDepartmentPK = selectedRow[7];
        
        //var dataForDeletion = {"departmentPK":departmentPK, "rowData":selectedRows[0].rowData};
        //openGeneralAssureDialog("您确定要删除该院系么？", deleteDepartment, dataForDeletion);
    } );
}

function showAddDepartmentResult(data) {
	
	if(!data.actionStatus) {
		openGeneralMessageDialog("添加院系失败，请重试！");
		return false;
	}
	
	var jsonResult = data.jsonResult;
	departmentDataTable.fnAddData([jsonResult.departmentId, jsonResult.departmentName,jsonResult.departmentType,
	                               jsonResult.assistanceName,jsonResult.assistanceTel,jsonResult.assistanceMobile,
	                               jsonResult.assistanceEmail, jsonResult.departmentPk]);
}



//确认删除院系对话框的确定按钮的响应事件
function deleteDepartment(dataForDeletion){
	
	var departmentPKArray = dataForDeletion.departmentPK;
	var rowDataArray = dataForDeletion.rowData;
	
	generalAjaxCallToLoadData("deleteSelectedDepartment.action",{"departmentPKArray":departmentPKArray},showDeletionResult,rowDataArray);
	
}

function showDeletionResult(data,rowDataArray) {
	
	if(!data.actionStatus) {
		openGeneralMessageDialog("删除院系失败，请重试！");
		return false;
	}
	
	for(var i = 0; i < rowDataArray.length; i++) {
		var rowData = rowDataArray[i];
		departmentDataTable.fnDeleteRow(rowData);
	}
	
	openGeneralMessageDialog("删除院系成功！");
}

function showModifyDepartmentResult(data, tempRowData){
	
	if(!data.actionStatus){
		openGeneralMessageDialog("修改院系失败，请重试！");
	}
	
	departmentDataTable.fnUpdate( [tempRowData.departmentId, tempRowData.departmentName,tempRowData.departmentType,
	                               tempRowData.assistanceName,tempRowData.assistanceTel,tempRowData.assistanceMobile,
	                               tempRowData.assistanceEmail,tempRowData.departmentPK], modifyRowNumber, 0 );
	openGeneralMessageDialog('恭喜你，修改成功！');
	
	
	
}