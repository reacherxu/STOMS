var inAccountQueryTable;
var list;

$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"经费统计",
	                	"href":""
	                 },
	                 {
	                	"name":"入账经费查询",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	$( "#startDate" ).datepicker({
		showOn: 'button',
		buttonImage: "JqueryLib/css/datepickerCss/images/calendar.gif",
		buttonImageOnly: true,
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd"
	}).unbind('blur');
	
	$( "#endDate" ).datepicker({
		showOn: 'button',
		buttonImage: "JqueryLib/css/datepickerCss/images/calendar.gif",
		buttonImageOnly: true,
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd"
	}).unbind('blur');
	
	$("#itemid").focus(); //把焦点放在第一个文本框

	var $inp = $('input'); //所有的input元素
	$inp.keypress(function (e) { //这里给function一个事件参数命名为e，叫event也行，随意的，e就是IE窗口发生的事件。
	    var key = e.which; //e.which是按键的值
	    if (key == 13) {
	    	inAccountQuery();
	    }
	}); 
	
	//由于CSS样式包冲突，手动关闭日期控件
	$("#ui-datepicker-div")[0].style.display = "none";
	
	
	var tableData = new Array();
	var tableTagArray = new Array();
//	tableTagArray.push({ "sTitle": "<input type=\"checkbox\" id=\"selectAllCheckBox\"></input>", "sClass": "center",
//		"sWidth": "2%", "bSortable": false,
//		"fnRender": function(obj){
//			console.log(obj);
//			 var PK = obj.aData[ obj.iDataColumn ];
//			 var checkBoxID = "checkBox" + PK;
//			 var tempCheckBox = "<input type=\"checkbox\" id=" + checkBoxID + " />";
//			 return tempCheckBox;
//		 }});
	tableTagArray.push({ "sTitle": "入账addOutlayPk", "sClass": "center", "bVisible": false, "bSearchable": false});
	
	tableTagArray.push({ "sTitle": "项目ID", "sClass": "center", "bVisible": false, "bSearchable": false});
	
	tableTagArray.push({ "sTitle": "项目ID", "sClass": "center", "sWidth": "10%",
		"fnRender": function(obj){
			 var addOutlayPk = obj.aData[ obj.iDataColumn - 2];
			 var itemID = obj.aData[ obj.iDataColumn - 1];
			 
			 var tempInAccountInfo = {"addOutlayPk":addOutlayPk, "itemID":itemID};
			 var tempInAccountInfoStr = jsonToString(tempInAccountInfo);
			 var tempHref = "<a onclick = \"detailInfoButtonResponse(" + tempInAccountInfoStr + ")\">" + itemID + "</a>";
			 return tempHref;
		 }});
	
	tableTagArray.push({ "sTitle": "项目名称", "sClass": "center", "sWidth": "19%" });
	tableTagArray.push({ "sTitle": "负责人", "sClass": "center", "sWidth": "8%" });
	//tableTagArray.push({ "sTitle": "合同编号", "sClass": "center", "sWidth": "12%" });
	tableTagArray.push({ "sTitle": "来款金额", "sClass": "center", "sWidth": "10%" });
	tableTagArray.push({ "sTitle": "汇出金额", "sClass": "center", "sWidth": "10%" });
	tableTagArray.push({ "sTitle": "来款单位", "sClass": "center", "sWidth": "20%" });
	tableTagArray.push({ "sTitle": "时间", "sClass": "center", "sWidth": "9%" });
//	tableTagArray.push({ "sTitle": "状态", "sClass": "center", "sWidth": "8%",
//		"fnRender": function(obj){
//			 var inAccountState = obj.aData[ obj.iDataColumn ];
//			 var tempProjectType = projectStateArrayGlobalVariable[inAccountState];
//			 return tempProjectType;
//		 }});
	
	inAccountQueryTable = $("#inAccountQueryTable").dataTable({
	    "aaData": tableData,
	    "aoColumns": tableTagArray,
	    "bLengthChange": false,
	    "bJQueryUI": true,
	    "oLanguage": dataTableLanguageGlobalVariable,
	    "sScrollX": "100%",
	    "sScrollXInner": "100%",
	    "sPaginationType": "full_numbers",
	    "aaSorting": [[0, "desc" ]]
	});
	inAccountQuery();
});

//入账信息导出Excel
function exportToExcel(){
	if(list == null || list.length==0){
		alert("数据列表为空，导出无意义！");
	}
	var addoutlayPKs = new Array();
	for(var i = 0; i <list.length ; i++) {
		var tempItemInfo = list[i];
		addoutlayPKs.push(tempItemInfo.addOutlayPk);//入账PK
	}
	var submitDatas = {"addoutlayPKs":addoutlayPKs};
	generalAjaxCallToLoadData("addoutlayExportToExcel.action",submitDatas,exportResult);
}

function exportResult(data){
	if(!data.actionStatus){
		alert("导出失败，请联系管理员！");
	}else{
		var result = data.jsonResult;
		var detailInfoUrl = "";
		detailInfoUrl = "download.jsp?fileName="+result.fileName;
		detailInfoUrl = encodeURI(encodeURI(detailInfoUrl));
		window.open(detailInfoUrl);
	}
}

//查询
function inAccountQuery() {
	
	var itemId = $.trim($("#itemid").val());
	var itemValue = $.trim($("#itemvalue").val());
	var remitValue = $.trim($("#remitvalue").val());
	var iscross = $.trim($("#iscross").val());
	var outlayDepartment = $.trim($("#outlaydepartment").val());
	var teacherName = $.trim($("#teachername").val());
	var departmentId = $.trim($("#departmentid").val());
	var departmentType = $.trim($("#departmenttype").val());
	var timeLower = $.trim($("#startDate").val());
	var timeUpper = $.trim($("#endDate").val());
	
	var submitDatas = {
			"itemId":itemId,
			"itemValue":itemValue,
			"remitValue":remitValue,
			"isCross":iscross,
			"outlayDepartment":outlayDepartment,
			"teacherName":teacherName,
			"departmentId":departmentId,
			"departmentType":departmentType,
			"timeLower":timeLower,
			"timeUpper":timeUpper
	};
	if(!(itemId == "" && itemValue == "" && remitValue == "" && iscross == "2" && 
			outlayDepartment == "" && teacherName == "" && departmentId == "" &&
			departmentType == "" && timeLower == "" && timeUpper == "")){
		generalAjaxCallToLoadData("addoutlayQuery.action",submitDatas,renderAllQueryResult);
	}

}

//显示查询的结果
function renderAllQueryResult(data) {

	list = data.jsonResult;
	console.log(list);
	
	//清空表格内的数据
	inAccountQueryTable.fnClearTable();
	if(list.length == 0){
		alert("查询结果为空，请重新查询！");
	}else{
		var count = list.length;
		if(list.length > 100){
			if(!confirm("查询结果为"+list.length+
					"条，加载需要"+list.length/100+"秒，是否继续？")){
				count = 100;
			}
		}
		
		for(var i = list.length-1; i >=(list.length- count) ; i--) {
			var tempInfo = list[i];
			var tempRowData = new Array();
//			tempRowData.push(tempInfo.addOutlayPk);
			tempRowData.push(tempInfo.addOutlayPk);
			tempRowData.push(tempInfo.itemId);
			tempRowData.push(tempInfo.cardId);
			tempRowData.push(tempInfo.itemName);
			if(tempInfo.otherTeacher == ""){
				tempRowData.push(tempInfo.teacherName);
			}else{
				tempRowData.push(tempInfo.teacherName+ '  ' + tempInfo.otherTeacher);
			}
			//tempRowData.push(tempInfo.contractId);
			tempRowData.push(tempInfo.outlayValue);
			tempRowData.push(tempInfo.remitValue);
			tempRowData.push(tempInfo.outlayDepartment);
			tempRowData.push(tempInfo.outlayTime);
			//tempRowData.push(tempInfo.astatus);
			//添加一行数据
			inAccountQueryTable.fnAddData( tempRowData );
		}
	}
}

//入账的详细信息
function detailInfoButtonResponse(tempInAccountInfo) {
	
	var inAccountApplicationState = tempInAccountInfo.inAccountApplicationState;
	var addOutlayPk = tempInAccountInfo.addOutlayPk;
	var itemID = tempInAccountInfo.itemID;
	
	var detailInfoUrl = "";
	
	detailInfoUrl = "Page/Admin/outlayStatisticsQuery/addoutlayEdit.jsp?addOutlayPK=" + addOutlayPk + "&itemID=" + itemID;
	
	parent.pageTransition(detailInfoUrl);
}
