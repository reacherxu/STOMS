var singleProjectQueryTable;
var queryResultItemList;

$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"项目查询",
	                	"href":""
	                 },
	                 {
	                	"name":"项目信息查询",
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
	
//	var myDate = new Date();
//	$("#startDate").val(myDate.getFullYear()+"-01-01");
//	$("#endDate").val((myDate.getFullYear()+10)+"-01-01");
	
	$("#itemid").focus(); //把焦点放在第一个文本框

	var $inp = $('input'); //所有的input元素
	$inp.keypress(function (e) { //这里给function一个事件参数命名为e，叫event也行，随意的，e就是IE窗口发生的事件。
	    var key = e.which; //e.which是按键的值
	    if (key == 13) {
	    	singleProjectQuery();
	    }
	}); 
	
	//由于CSS样式包冲突，手动关闭日期控件
	$("#ui-datepicker-div")[0].style.display = "none";
		
	var tableData = new Array();
	var tableTagArray = new Array();
	
	tableTagArray.push({ "sTitle": "departmentPK", "sClass": "center", "bVisible": false, "bSearchable": false});
	tableTagArray.push({ "sTitle": "项目ID", "sClass": "center", "sWidth": "15%" ,
		"fnRender":function(obj){
			var itemPK = obj.aData[ obj.iDataColumn -1];
			var itemID = obj.aData[ obj.iDataColumn ];
			var tempItemInfo = {"itemPK":itemPK,"itemID":itemID};
			var tempItemInfoStr = jsonToString(tempItemInfo);
			var tempHref = "<a onclick = \"detailInfoButtonResponse(" + tempItemInfoStr + ")\">" + itemID + "</a>";
			 return tempHref;
		}});
	tableTagArray.push({ "sTitle": "项目名称", "sClass": "center", "sWidth": "28%" });
	tableTagArray.push({ "sTitle": "负责人", "sClass": "center", "sWidth": "10%" });
	tableTagArray.push({ "sTitle": "院系", "sClass": "center", "sWidth": "25%" });
	tableTagArray.push({ "sTitle": "项目类型", "sClass": "center", "sWidth": "13%" });
	//tableTagArray.push({ "sTitle": "项目状态", "sClass": "center", "sWidth": "15%" });
	
	//tableTagArray.push({ "sTitle": "typeid", "sClass": "center", "bVisible": false, "bSearchable": false});
	//tableTagArray.push({ "sTitle": "状态代码", "sClass": "center", "bVisible": false, "bSearchable": false});
	
	singleProjectQueryTable = $("#singleProjectQueryTable").dataTable({
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
	singleProjectQuery();
});

//项目信息导出Excel
function exportToExcel(){
	if(queryResultItemList == null || queryResultItemList.length==0){
		alert("数据列表为空，导出无意义！");
	}
	var itemPKs = new Array();
	for(var i = 0; i <queryResultItemList.length ; i++) {
		var tempItemInfo = queryResultItemList[i];
		itemPKs.push(tempItemInfo[0]);//项目PK
	}
	var submitDatas = {"itemPKs":itemPKs};
	generalAjaxCallToLoadData("itemExportToExcel.action",submitDatas,exportResult);
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

//项目查询
function singleProjectQuery() {
	
	var startDate = $("#startDate").val();
	startDate = $.trim(startDate);
	if(startDate == null || startDate.length == 0) {
		startDate = "";
	}
	
	var endDate = $("#endDate").val();
	endDate = $.trim(endDate);
	if(endDate == null || endDate.length == 0) {
		endDate = "";
	}
	
	//"YYYY-MM-DD"日期格式正则表达式
	var ex = /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/;
	var pattern = new RegExp(ex);
	
	//判断开始日期格式是否为"YYYY-MM-DD"
	if(startDate.length > 0 && !pattern.test(startDate)) {
		alert("开始日期格式有误，格式为\"YYYY-MM-DD\"");
		return false;
	}
	//判断结束日期格式是否为"YYYY-MM-DD"
	if(endDate.length > 0 && !pattern.test(endDate)) {
		alert("结束日期格式有误，格式为\"YYYY-MM-DD\"");
		return false;
	}
	
	var departmenttype = $("#departmenttype").find("option:selected").val();
	departmenttype = $.trim(departmenttype);
	
	var itemid = $.trim($("#itemid").val());
	var contractid = $.trim($("#contractid").val());
	var typeid = $.trim($("#typeid").val());
	var itemname = $.trim($("#itemname").val());
	var departmentid = $.trim($("#departmentid").val());
	var teachername = $.trim($("#teachername").val());
	
	var submitDatas = {
			"itemid":itemid,
			"contractid":contractid,
			"typeid":typeid,
			"itemname":itemname,
			"departmentid":departmentid,
			"departmenttype":departmenttype,
			"teachername":teachername,
			"startDate":startDate,
			"endDate":endDate
	};
	if(!(itemid == "" && contractid == "" && typeid == "" && itemname == "" && 
			departmentid == "" && departmenttype == "" && teachername == "" &&
			startDate == "" && endDate == "" )){
		generalAjaxCallToLoadData("itemQuery.action",submitDatas,renderAllQueryResult);
	}
}

//显示查询的结果
function renderAllQueryResult(data) {

	queryResultItemList = data.jsonResult;
	
	//清空表格内的数据
	singleProjectQueryTable.fnClearTable();
	
	if(queryResultItemList.length == 0){
		alert("查询结果为空，请重新查询！");
	}else{
		var count = queryResultItemList.length;
		if(queryResultItemList.length > 100){
			if(!confirm("查询结果为"+queryResultItemList.length+
					"条，加载需要"+queryResultItemList.length/100+"秒，是否继续？")){
				count = 100;
			}
		}
		
		for(var i = queryResultItemList.length-1; i >=(queryResultItemList.length- count) ; i--) {
			var tempItemInfo = queryResultItemList[i];
			var tempRowData = new Array();
			tempRowData.push(tempItemInfo[0]);//项目PK
			tempRowData.push(tempItemInfo[1]);
			tempRowData.push(tempItemInfo[2]);
			if(tempItemInfo[4] == "" || tempItemInfo[4] == null){
				tempRowData.push(tempItemInfo[3]);
			}else{
				tempRowData.push(tempItemInfo[3]+"  "+tempItemInfo[4]);
			}
			
			tempRowData.push(tempItemInfo[5]);
			tempRowData.push(tempItemInfo[6]);
			singleProjectQueryTable.fnAddData( tempRowData );
		}
	}
}
//具体item
function detailInfoButtonResponse(tempItemInfo) {
	
	var itemPK = tempItemInfo.itemPK;
	var itemID = tempItemInfo.itemID;
	
	var detailInfoUrl = "Page/Admin/projectQuery/itemEdit.jsp?itemPK=" + itemPK+"&isModifyPage=yes&itemID=" + itemID;
	
	//window.open(detailInfoUrl);
	parent.pageTransition(detailInfoUrl);

}


//入账历史查看按钮的点击响应事件
function inAccountHistroyButtonResponse(tempItemInfo) {
	
	var itemState = tempItemInfo.itemState;
	
	if(itemState == "10") {
		return false;
	} else {
		
		var itemID = tempItemInfo.itemID;
		
		var detailInfoUrl = "Page/Teacher/inAccountApplication/inAccountApplicationList.jsp?itemID=" + itemID;
		
//		window.open(detailInfoUrl);
		parent.pageTransition(detailInfoUrl);
	}
}

