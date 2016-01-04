var tempRowNumber = 0;
var globalTitlePK = 0;
var titleDataTable;

$(document).ready(function(){
	consoleResponseInUnusabalEnvirenment();
	
	//新增加一个头衔的对话框
    $( "#createNewTitleDialog" ).dialog({
    	autoOpen: false,
		height: 200,
		width: 300,
		modal: true
    });
    //为createNewTitleForm表单添加验证功能
    $("#createNewTitleForm").validationEngine("attach");
    //点击assureCreatingTitleButton按钮时的响应事件
    $("#assureCreatingTitleButton").click(function(check) {    
        if($("#createNewTitleForm").validationEngine('validate')){
        	$( "#createNewTitleDialog" ).dialog("close");
        	var addedTitleName = $("#titleName").val();
        	generalAjaxCallToLoadData("addNewTitle.action",{"titleName":addedTitleName},showAddResult);
        }
        check.preventDefault();//此处阻止提交表单  
    });
    //点击cancleCreatingTitleButton按钮时的响应事件
    $('#cancleCreatingTitleButton').click( function() {
    	$("#createNewTitleForm").validationEngine("hideAll");
    	$( "#createNewTitleDialog" ).dialog("close");
    } );
    
    
  //修改头衔的对话框
    $( "#modifyTitleDialog" ).dialog({
    	autoOpen: false,
		height: 200,
		width: 300,
		modal: true
    });
    //为modifyTitleForm表单添加验证功能
    $("#modifyTitleForm").validationEngine("attach");
    //点击assureModifyingTitleButton按钮时的响应事件
    $("#assureModifyingTitleButton").click(function(check) {    
        if($("#modifyTitleForm").validationEngine('validate')){
        	$( "#modifyTitleDialog" ).dialog("close");
        	var modifiedTitleName = $("#modifyTitleName").val();
        	var submitData = {"titlePK":globalTitlePK, "titleName":modifiedTitleName};
        	generalAjaxCallToLoadData("updateTitle.action", submitData, showModifyingResult, modifiedTitleName);
        }
        check.preventDefault();//此处阻止提交表单  
    });
    //点击cancleModifyingTitleButton按钮时的响应事件
    $('#cancleModifyingTitleButton').click( function() {
    	$("#modifyTitleForm").validationEngine("hideAll");
    	$( "#modifyTitleDialog" ).dialog("close");
    } );
    //取得所有的教师头衔信息，并显示在表中
	generalAjaxCallToLoadData("acquireAllTeacherTitles.action",{}, initializeTeacherTitleTable);
});

function initializeTeacherTitleTable(data) {
	
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	
	console.log("initializeTeacherTitleTable success");
	
	var jsonResult = data.jsonResult;
	
	console.log(jsonResult);
	var tableData = new Array();
	
	for(var i = 0; i < jsonResult.length; i++) {
		var tempTeacherTitle = jsonResult[i];
		var tempRowData = new Array();
		tempRowData.push(tempTeacherTitle.titleName);
		tempRowData.push(tempTeacherTitle.titlePk);
		tableData.push(tempRowData);
	}
	
	var tableTagArray = new Array();
	tableTagArray.push({ "sTitle": "名称", "sClass": "center" });
	tableTagArray.push({ "sTitle": "主键", "sClass": "center"});
	
	titleDataTable = $("#titleLevelMaintainanceTable").dataTable({
	        "aaData": tableData,
	        "aoColumns": tableTagArray
	    });
	 
	
	/* Add a click handler to the rows - this could be used as a callback */
	$("#titleLevelMaintainanceTable tbody").click(function(event) {
	    $(event.target.parentNode).toggleClass('row_selected');
	});

	/* Add a click handler for the add row */
    $('#addTitleButton').click( function() {
        
        console.log("addTitleButton");
        $( "#createNewTitleDialog" ).dialog( "open" );
    } );
    
    /* Add a click handler for the delete row */
    $('#deleteTitleButton').click( function() {
    	
        var anSelected = acquireSelectedRowsInfo( titleDataTable );
        
        if(anSelected.length == 0) {
        	openGeneralMessageDialog("请选中一行！");
        	return false;
        }
        
        var temTdArray = $(anSelected[0].rowData).children();
        var tempTitlePK = temTdArray[1].innerHTML;
        var dataForDeletion = {"titlePK":tempTitlePK, "rowData":anSelected[0].rowData};
        openGeneralAssureDialog("您确定要删除改头衔么？", deleteTeacherTitle, dataForDeletion);
        //generalAjaxCallToLoadData("deleteTitle.action", {"titlePK":tempTitlePK}, showDeletionResult, anSelected[0].rowData);
        
    } );
    
    /* Add a click handler for the modify row */
    $('#modifyTitleButton').click( function() {
        var anSelected = acquireSelectedRowsInfo( titleDataTable );
        
        if(anSelected.length == 0) {
        	openGeneralMessageDialog("请选中一行！");
        	return false;
        }
        
        if(anSelected.length > 1) {
        	openGeneralMessageDialog("请只选中一条您所修改的头衔信息！");
        	return false;
        }
        var tempRow = $(anSelected[0].rowData);
        //删除改行被选择的状态，即删除row_selected样式
        tempRow.removeClass('row_selected');
        var temTdArray = tempRow.children();
        
        var tempTitleName = temTdArray[0].innerHTML;
        globalTitlePK = temTdArray[1].innerHTML;
        
        tempRowNumber = anSelected[0].rowNumber;
        
        $("#modifyTitleName").val(tempTitleName);
        $( "#modifyTitleDialog" ).dialog( "open" );
    } );
    
}

//确认删除一个教师头衔
function deleteTeacherTitle(dataForDeletion) {
	
	var tempTitlePK = dataForDeletion.titlePK;
	var rowData = dataForDeletion.rowData;
	
	generalAjaxCallToLoadData("deleteTitle.action", {"titlePK":tempTitlePK}, showDeletionResult, rowData);
}

function showAddResult(data) {
	if(!data.actionStatus) {
		console.log("add failed!");
		return false;
	}
	var jsonResult = data.jsonResult;
	console.log(jsonResult);
	titleDataTable.fnAddData([jsonResult.titleName, jsonResult.titlePk]);
	console.log("add success!");
}

function showDeletionResult(data, rowData) {
	if(!data.actionStatus) {
		console.log("delete failed!");
		return false;
	} 
	
	titleDataTable.fnDeleteRow(rowData);
	
	console.log("delete success");
	
}

function showModifyingResult(data, modifiedTitleName) {
	if(!data.actionStatus) {
		console.log("modifying failed!");
		return false;
	}
	
	titleDataTable.fnUpdate( [modifiedTitleName, globalTitlePK], tempRowNumber, 0 );
	console.log('恭喜你，修改成功！');
}