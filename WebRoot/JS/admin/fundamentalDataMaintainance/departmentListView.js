/**
 * @author clj
 */

var thisDataTable;

$(document).ready(function(){
	
	//设置兼容环境
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"基础数据",
	                	"href":""
	                 },
	                 {
	                	"name":"院系信息",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	$("#addDepartmentButton").click(function(check) { 
		
    	var url = "Page/Admin/fundamentalDataMaintainance/departmentEdit.jsp?departmentPK=" + "null" + "&IsModifyPage=" + "no";
    	parent.pageTransition(url);
	});
	
	generalAjaxCallToLoadData("acquireAllDepartmentInfo.action",{},initializeDepartmentTable);
});


/**
 * 初始化页面信息 
 */
function initializeDepartmentTable(data) {
	
	if(!data.actionStatus) {
		console.log("acquireAllDepartmentInfo failed!");
		return false;
	}
	
	console.log(data);
	var tableData = new Array();
	
	var jsonResult = data.jsonResult;
	
	for(var i = 0; i < jsonResult.length; i++) {
		
		var tempDepartmentInfo = jsonResult[i];
		var tempRowData = new Array();
		
		//准备页面列表控件的每行数据
		tempRowData.push(tempDepartmentInfo.departmentPk);
		tempRowData.push(tempDepartmentInfo.departmentPk);
		tempRowData.push(tempDepartmentInfo.departmentId);
		tempRowData.push(tempDepartmentInfo.departmentName);
		tempRowData.push(tempDepartmentInfo.departmentType);
		tempRowData.push(tempDepartmentInfo.assistanceId);
		tempRowData.push(tempDepartmentInfo.directorId);
		tempRowData.push(tempDepartmentInfo.assistanceTel);
		tempRowData.push(tempDepartmentInfo.assistanceMobile);
		tempRowData.push(tempDepartmentInfo.assistanceEmail);
		
		
		tableData.push(tempRowData);
	}
	
	//准备页面列表控件的标题行
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
	
	tableTagArray.push({ "sTitle": "departmentPK", "sClass": "center", "bVisible": false, "bSearchable": false});
	
	tableTagArray.push({ "sTitle": "编号", "sClass": "center","sWidth": "7%"});
	
	tableTagArray.push({ "sTitle": "名称", "sClass": "center", "sWidth": "15%",
		"fnRender": function(obj){
			 var departmentName = obj.aData[ obj.iDataColumn];
			 var departmentPK = obj.aData[ obj.iDataColumn - 2];
			 
			 var tempPkValue = {"departmentPK":departmentPK};
			 var tempPkValueString = jsonToString(tempPkValue);
			 
			 var tempHref = "<a onclick = \"detailInfoButtonResponse(" + tempPkValueString + ")\">" + departmentName + "</a>";
			 return tempHref;
		 }});
	
	tableTagArray.push({ "sTitle": "类型", "sClass": "center", "sWidth": "8%" ,"bVisible": false});
	tableTagArray.push({ "sTitle": "秘书工号", "sClass": "center", "sWidth": "11%" });
	tableTagArray.push({ "sTitle": "科研主任工号", "sClass": "center", "sWidth": "12%" });
	tableTagArray.push({ "sTitle": "秘书电话", "sClass": "center", "sWidth": "14%" });
	tableTagArray.push({ "sTitle": "秘书手机", "sClass": "center", "sWidth": "14%" });
	tableTagArray.push({ "sTitle": "秘书Email", "sClass": "center", "sWidth": "16%" ,"bVisible": false});
	
	thisDataTable = $("#departmentTable").dataTable({
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
		
		$('input[type="checkbox"]', thisDataTable.fnGetNodes()).attr('checked',this.checked);
	  });
	
	
    //为修改按钮添加响应函数
    $('#modifyDepartmentButton').click( function() {
        
        console.log("modifyDepartmentButton");
    	
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
    	toEditPage(selectedRowsOrder[0],"yes");
    } );
    
    //删除按钮响应函数
    $('#deleteDepartmentButton').click( function() {
    	
    	var allCheckBoxDomnode = $("input[type='checkbox']:checked", thisDataTable.fnGetNodes());
    		
    	if(allCheckBoxDomnode == "null" || allCheckBoxDomnode.length == "0"){
    		alert("请选中一行！");
    		return;
    	}
    		
    	
    	console.log(thisDataTable.fnGetNodes());
    	
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
	
	generalAjaxCallToLoadData("deleteSelectedDepartment.action",{"departmentPKArray":PKArray},showDeletionResult,indexArray);
	
}


/**
 * 删除页面上列表框内的数据
 */
function showDeletionResult(data,rowDataArray) {
	
	if(!data.actionStatus) {
		alert("删除院系失败，请重试！");
		return false;
	}
	
	//删除得从最大的开始删 否则每删一个会从新排序，序号不对
	for(var i = rowDataArray.length - 1; i >= 0; i--) {
		var rowData = rowDataArray[i];
		thisDataTable.fnDeleteRow(rowData);
	}
	
	alert("删除院系成功！");
}


/**
 * 点的名字上的链接转移函数
 * @param tempInAccountInfo
 */
function detailInfoButtonResponse(tempInAccountInfo) {	
	
	var departmentPK = tempInAccountInfo.departmentPK;
	
	toEditPage(departmentPK, "yes");
}


/**
 * 转移到修改页面去
 * @param isMdfy 取值：yes no
 * @param PK 取值：null 项目PK
 */
function toEditPage(PK, isMdfy){
	
	var detailInfoUrl = "Page/Admin/fundamentalDataMaintainance/departmentEdit.jsp?departmentPK=" + PK + "&isModifyPage=" + isMdfy;
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