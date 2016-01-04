var titleDataTable;
var globalTitlePK;
var tempRowNumber;

$(document).ready(function(){
	consoleResponseInUnusabalEnvirenment();
	
	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"基础数据",
	                	"href":""
	                 },
	                 {
	                	"name":"头衔等级",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
    //为修改按钮添加响应函数
    $('#addTitleButton').click( function() {
    	
    	var name=prompt("请输入新的教师职称","");
    	if (name!=null && name!=""){
    		generalAjaxCallToLoadData("addNewTitle.action",{"titleName":name},showAddResult);
    	}
    });
	
    //取得所有的教师头衔信息，并显示在表中
	generalAjaxCallToLoadData("acquireAllTeacherTitles.action",{}, initializeTeacherTitleTable);
	
});

function showAddResult(data) {
	if(!data.actionStatus) {
		alert("添加失败");
		return false;
	}
	var jsonResult = data.jsonResult;
	console.log(jsonResult);
	titleDataTable.fnAddData([jsonResult.titlePk,jsonResult.titlePk,jsonResult.titleName]);
	alert("添加成功");
}


//初始化表格
function initializeTeacherTitleTable(data) {
	
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	
	console.log("initializeTeacherTitleTable success");
	
	var jsonResult = data.jsonResult;
	

	var tableData = new Array();
	
	for(var i = 0; i < jsonResult.length; i++) {
		var tempTeacherTitle = jsonResult[i];
		var tempRowData = new Array();
		
		tempRowData.push(tempTeacherTitle.titlePk);
		tempRowData.push(tempTeacherTitle.titlePk);
		tempRowData.push(tempTeacherTitle.titleName);
		
		tableData.push(tempRowData);
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
	tableTagArray.push({ "sTitle": "PK", "sClass": "center", "bVisible": false, "bSearchable": false});
	tableTagArray.push({ "sTitle": "教师职称", "sClass": "center"});

	

	
	titleDataTable = $("#titleLevelMaintainanceTable").dataTable({
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
		
		$('input[type="checkbox"]', titleDataTable.fnGetNodes()).attr('checked',this.checked);
	  });
	
    //为修改按钮添加响应函数
    $('#modifyTitleButton').click( function() {
    	
    	var allCheckBoxDomnode = $("input[type='checkbox']:checked", titleDataTable.fnGetNodes());
    	
    	if(allCheckBoxDomnode == "null" || allCheckBoxDomnode.length != "1"){
    		alert("请选中其中一行！");
    		return;
    	}
    	
    	 var name = $(allCheckBoxDomnode[0]).parent().parent().children();
    	 var oldName = name[1].innerHTML;
    	 globalTitlePK =  allCheckBoxDomnode[0].id.substr(8);
    	 tempRowNumber = titleDataTable.fnGetPosition(( $(allCheckBoxDomnode[0]).parent().parent())[0]);
    	 
    	 
    	 console.log(oldName);
    	 console.log(globalTitlePK);
    	 
     	var modifiedTitleName = prompt("请输入您的名字",oldName);
     	
    	if (modifiedTitleName ==null || modifiedTitleName == ""){
    		
    		alert("输入为空，没作修改");
    		return;
    	}
    	var submitData = {"titlePK":globalTitlePK, "titleName":modifiedTitleName};
    	generalAjaxCallToLoadData("updateTitle.action", submitData, showModifyingResult, modifiedTitleName);
	});
    
    //为删除按钮提供响应函数
    $('#deleteTitleButton').click( function() {

    	var allCheckBoxDomnode = $("input[type='checkbox']:checked", titleDataTable.fnGetNodes());
		
    	if(allCheckBoxDomnode == "null" || allCheckBoxDomnode.length != "1"){
    		alert("请只选中其中一行！");
    		return;
    	}

    	if(confirm("确定删除吗？") == false) return;
    	
    	var PK =  allCheckBoxDomnode[0].id.substr(8);
    	var index = titleDataTable.fnGetPosition(( $(allCheckBoxDomnode[0]).parent().parent())[0]);
    	
    	generalAjaxCallToLoadData("deleteTitle.action", {"titlePK":PK}, showDeletionResult, index);
    	
    });

}

//删除更新表格
function showDeletionResult(data, rowData) {
	
	if(!data.actionStatus) {
		
		alert("删除失败");
		return false;
	} 
	
	titleDataTable.fnDeleteRow(rowData);
	alert("删除成功");
	
}


//修改更新 表格
function showModifyingResult(data, modifiedTitleName) {
	if(!data.actionStatus) {
		console.log("modifying failed!");
		return false;
	}
	
	titleDataTable.fnUpdate( [globalTitlePK,globalTitlePK,modifiedTitleName], tempRowNumber, 0 );
	alert('修改成功！');
}

//取得被选中的项目
function getSelectedItems() {
	var itemPKArray = new Array();
	//fnGetFilteredNodes
	var allCheckBoxDomnode = $("input[type='checkbox']:checked", titleDataTable.fnGetNodes());

    for(var i = 0; i < allCheckBoxDomnode.length; i++) {
    	var tempCheckBoxID = allCheckBoxDomnode[i].id;
    	var tempItemPK = tempCheckBoxID.substr(8);
    	itemPKArray.push(tempItemPK);
    }
    
    return itemPKArray;
}