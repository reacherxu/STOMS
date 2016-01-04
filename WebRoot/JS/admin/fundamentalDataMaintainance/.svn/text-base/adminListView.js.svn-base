/**
 * @author clj
 */

var thisDataTable;

$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	
	
	$("#addTeacherButton").click(function(check) { 
		
		toEditPage("null","no");
	});
	
	generalAjaxCallToLoadData("acquireAllAdminInfo.action",{},initializeTeacherTable);
	
	//generalAjaxCallToLoadData("intializeAllTeacherPassword.action",{},renderPasswordChangingResult);
});

/*
function renderPasswordChangingResult(data) {
	
	if(!data.actionStatus) {
		console.log("acquireAllAdminInfo failed!");
		return false;
	}
	
}*/


/**
 * 初始化页面信息 
 */
function initializeTeacherTable(data){
	if(!data.actionStatus) {
		console.log("acquireAllAdminInfo failed!");
		return false;
	}
	
	var jsonResult = data.jsonResult;
	
	var tableData = new Array();
	
	
	for(var i = 0; i < jsonResult.length; i++) {
		
		//准备页面列表控件的每行数据
		var tempTeacherInfo = jsonResult[i];
		console.log(tempTeacherInfo);
		var tempRowData = new Array();

		tempRowData.push(tempTeacherInfo.teacherPk);
		tempRowData.push(tempTeacherInfo.teacherPk);
		tempRowData.push(tempTeacherInfo.teacherId);
		tempRowData.push(tempTeacherInfo.teacherName);
		tempRowData.push(tempTeacherInfo.titleName);
		tempRowData.push(tempTeacherInfo.departmentId);
		tempRowData.push(tempTeacherInfo.departmentName);
		tempRowData.push(tempTeacherInfo.tel);
		tempRowData.push(tempTeacherInfo.mobile);
		tempRowData.push(tempTeacherInfo.email);

		
		tableData.push(tempRowData);
	}
	
	//准备页面列表控件的标题行
	var teacherTableTagArray = new Array();
	
	teacherTableTagArray.push({ "sTitle": "<input type=\"checkbox\" id=\"selectAllCheckBox\"></input>", "sClass": "center",
		"sWidth": "3%", "bSortable": false,
		"fnRender": function(obj){
			console.log(obj);
			 var PK = obj.aData[ obj.iDataColumn ];
			 var checkBoxID = "checkBox" + PK;
			 var tempCheckBox = "<input type=\"checkbox\" id=" + checkBoxID + " />";
			 return tempCheckBox;
		 }});
	
	teacherTableTagArray.push({ "sTitle": "teacherPK", "sClass": "center", "bVisible": false, "bSearchable": false});	
	
	teacherTableTagArray.push({ "sTitle": "工号", "sClass": "center", "sWidth": "10%" });
	teacherTableTagArray.push({ "sTitle": "姓名", "sClass": "center", "sWidth": "10%" ,
	   "fnRender": function(obj){
			 var name = obj.aData[ obj.iDataColumn];
			 var PK = obj.aData[ obj.iDataColumn - 2];
			 
			 var tempPkValue = {"teacherPK":PK};
			 var tempPkValueString = jsonToString(tempPkValue);
			 
			 var tempHref = "<a onclick = \"detailInfoButtonResponse(" + tempPkValueString + ")\">" + name + "</a>";
			 return tempHref;
		 }});
	
	teacherTableTagArray.push({ "sTitle": "头衔", "sClass": "center", "sWidth": "10%" });
	teacherTableTagArray.push({ "sTitle": "院系编号", "sClass": "center", "sWidth": "10%", "bVisible": false });
	teacherTableTagArray.push({ "sTitle": "院系名称", "sClass": "center", "sWidth": "19%" });
	teacherTableTagArray.push({ "sTitle": "电话", "sClass": "center", "sWidth": "10%" });
	teacherTableTagArray.push({ "sTitle": "手机", "sClass": "center", "sWidth": "15%" });
	teacherTableTagArray.push({ "sTitle": "Email", "sClass": "center", "sWidth": "16%" });
	
	thisDataTable = $("#teacherMaintainanceTable").dataTable({
        "aaData": tableData,
        "aoColumns": teacherTableTagArray,
        "bLengthChange": false,
        "bJQueryUI": true,
        "oLanguage": dataTableLanguageGlobalVariable,
        "sScrollX": "100%",
        "sScrollXInner": "100%",
        "sPaginationType": "full_numbers"
    });
	
	//全选或全不选按钮
	$("#selectAllCheckBox").change(function(event){
		
		$('input[type="checkbox"]', thisDataTable.fnGetNodes()).attr('checked',this.checked);
	  });
	
    //为修改按钮添加响应函数
    $('#modifyTeacherButton').click( function() {
	
    	var selectedRowsOrder = getSelectedItems();
    	
        if(selectedRowsOrder == undefined || selectedRowsOrder.length == 0) {
        	alert("请选中一行！");
        	return false;
        }
        
        if(selectedRowsOrder.length > 1) {
        	alert("请只选中一条您所要修改的教师信息！");
        	return false;
        }
        
        //转移
        toEditPage(selectedRowsOrder[0], "yes");
	});
    
    //删除按钮响应函数
    $('#deleteTeacherButton').click( function() {
    	
    	var allCheckBoxDomnode = $("input[type='checkbox']:checked", thisDataTable.fnGetNodes());
		
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
        	var tempIndex = thisDataTable.fnGetPosition(( $(allCheckBoxDomnode[i]).parent().parent())[0]);
        	indexArray.push(tempIndex);
    	}

    	console.log(PKArray);
    	console.log(indexArray);
    	
    	var dataForDeletion = {"PK":PKArray, "index":indexArray};
    	deleteAction(dataForDeletion);
    } );
}


/**
 * 删除动作，先数据库，然后是页面列表控件的数据
 */
function deleteAction(dataForDeletion){
	
	var PKArray = dataForDeletion.PK;
	var indexArray = dataForDeletion.index;
	
	generalAjaxCallToLoadData("deleteSelectedTeacher.action",{"PKArray":PKArray},showDeletionResult,indexArray);
}


/**
 * 删除页面上列表框内的数据
 */
function showDeletionResult(data,rowDataArray) {
	
	if(!data.actionStatus) {
		alert("删除失败，请重试！");
		return false;
	}
	
	//删除得从最大的开始删 否则每删一个会从新排序，序号不对
	for(var i = rowDataArray.length - 1; i >= 0; i--) {
		var rowData = rowDataArray[i];
		thisDataTable.fnDeleteRow(rowData);
	}
	
	alert("删除成功！");
}


/**
 * 点的名字上的链接转移函数
 * @param tempInAccountInfo
 */
function detailInfoButtonResponse(tempInAccountInfo) {	
	
	var teacherPK = tempInAccountInfo.teacherPK;
	
	toEditPage(teacherPK,"yes");
}


/**
 * 转移到修改页面去
 * @param isMdfy 取值：yes no
 * @param PK 取值：null 项目PK
 */
function toEditPage(PK, isMdfy){
	
	var detailInfoUrl = "Page/Admin/fundamentalDataMaintainance/adminEdit.jsp?teacherPK=" + PK + "&isModifyPage=" + isMdfy;
	parent.pageTransition(detailInfoUrl);
}


/**
 * 取得被选中的项目
 * @returns {Array}
 */
function getSelectedItems() {
	var itemPKArray = new Array();
	//fnGetFilteredNodes
	var allCheckBoxDomnode = $("input[type='checkbox']:checked", thisDataTable.fnGetNodes());

	
    for(var i = 0; i < allCheckBoxDomnode.length; i++) {
    	var tempCheckBoxID = allCheckBoxDomnode[i].id;
    	var tempItemPK = tempCheckBoxID.substr(8);
    	itemPKArray.push(tempItemPK);
    }
    
    return itemPKArray;
}