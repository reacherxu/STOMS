$(document).ready(function(){
	
	//consoleResponseInUnusabalEnvirenment();
	
	$("#printDate").html("2014/07/12");
	generalAjaxCallToLoadData("acquireOneItemInfo.action",{"itemPK":itemPK},initializePrintPage);
	
});

function initializePrintPage(data){
	if(!data.actionStatus) {
		console.log("acquireInfoToInitializePage failed!");
		return false;
	}
	var mydate = new Date();
	var str = "" + mydate.getFullYear() + "/";
	str += (mydate.getMonth()+1) + "/";
	str += mydate.getDate();
	$("#printDate").val(str);
	
	var kaige = data.jsonResult;
	$("#itemId").html(kaige["itemId"]);
	$("#itemName").html(kaige["itemName"]);
	$("#contractId").html(kaige["contractId"]);
	$("#teacherName").html(kaige["teacherName"]);
	$("#otherTeacher").html(kaige["otherTeacher"]);
	$("#departmentName").html(kaige["departmentName"]);
	$("#startDate").html(kaige["timeLower"]);
	$("#endDate").html(kaige["timeUpper"]);
	if(kaige["isFinished"]==0){
		$("#isFinished").html("否");
	}else{
		$("#isFinished").html("是");
	}
	
}
