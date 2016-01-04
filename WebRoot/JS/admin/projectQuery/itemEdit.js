var departmentPK;
var departmentName;
$(document).ready(function(){
	
	//兼容性
	consoleResponseInUnusabalEnvirenment();
	
	if(isModifyPage == undefined || isModifyPage == "" || isModifyPage =="null") {
		console.log("item is empty!");
		isModifyPage = "yes";
	}
	
	$("#cancleButton").click(function(check) {
		history.go(-1);
	});
	
	$("#deleteButton").click(function(check) {
		//itemPK，itemID
		//先通过itemID,在Addoutlay表中，查看有几条入账记录：
		//	0：直接删除
		//  ！0：提示用户先去处理入账信息。
		generalAjaxCallToLoadData("acquireAllInAccountApplicationsByItemID.action",{"itemID":itemID},processDelete);
	});
	
	//为modifyDepartmentForm表单添加验证功能
	$("#editItemForm").validationEngine("attach");
	
	if(isModifyPage == "yes"){
		
		$("#assureButton").html("修改");
		$("#itemid").attr("disabled",true);
		$("#typeid").attr("disabled",true);
		$("#departmentid").attr("disabled",true);
		$("#departmentname").attr("disabled",true);
		$("#departmenttype").attr("disabled",true);
		$("#cardid").attr("disabled",true);
		generalAjaxCallToLoadData("acquireOneItemInfo.action",{"itemPK":itemPK},initializeModdifyPage);
	}
	else{
		$("#assureButton").html("添加");	
	}
	//点击assureButton按钮时的响应事件
    $("#assureButton").click(function(check) {
    	
    	if($("#editItemForm").validationEngine('validate')){
    		
    		var submitData = {};
    		
    		submitData["itemname"] = $("#itemname").val();
    		submitData["contractid"] = $("#contractid").val();
    		submitData["teachername"] = $("#teachername").val();
    		submitData["otherteacher"] = $("#otherteacher").val();
    		submitData["typeid"] = $("#typeid").val();
    		submitData["departmentPK"] = departmentPK;
    		submitData["departmentid"] = $("#departmentid").val();
    		submitData["departmentname"] = departmentName;
    		submitData["departmenttype"] = $("#departmenttype").val();
    		submitData["cardid"] = $("#cardid").val();
    		submitData["itemvalue"] = $("#itemvalue").val();
    		submitData["remitvalue"] = $("#remitvalue").val();
    		submitData["startDate"] = $("#startDate").val();
    		submitData["endDate"] = $("#endDate").val();
    		submitData["isFinished"] = $("#isFinished").val();
    		console.log("submitData");
    		console.log(submitData);
    		
        	if(isModifyPage == "yes"){
        		submitData["itemPK"] = itemPK;
        		generalAjaxCallToLoadData("modifyItem.action",submitData,showModdifyResult);
        	}
        	else{
        		generalAjaxCallToLoadData("addNewAdmin.action",submitData,showResult);
        	}
        	
    	}
    });
    $("#printButton").click(function(check) {
    	var detailInfoUrl = "";
    	detailInfoUrl = "Page/Admin/projectQuery/itemPrint.jsp?itemPK=" + itemPK;
    	window.open(detailInfoUrl);
		//generalAjaxCallToLoadData("acquireAllInAccountApplicationsByItemID.action",{"itemID":itemID},processDelete);
	});
	
});

function DeleteStatus(data){
	if(!data.actionStatus) {
		alert("删除失败！");
	} else {
		alert("删除成功！");
		history.go(-1);
	}
}

function processDelete(data){
	if(!data.actionStatus) {
		alert("获取该itemid的数据时失败！");
	} else {
		var inAccountApplicationList = data.jsonResult.inAcccountListInfo;
		if(inAccountApplicationList.length == 0){
			//删除操作
			if(confirm("确定删除吗？") == false) return;
			generalAjaxCallToLoadData("deleteItem.action",{"itemPK":itemPK},DeleteStatus);
		}else{
			alert("该项目还有"+inAccountApplicationList.length+"个项目经费，不能删除！");
		}
	}
}

function adjustDepartment(){
	departmentId = $.trim($("#departmentid").val());
	generalAjaxCallToLoadData("acquireOneDepartmentInfoByID.action",{"departmentId":departmentId}, setDepartmentPKAndName);
}

function showModdifyResult(data){
	if(!data.actionStatus) {
		alert("更新失败 ！");
	} else {
		var submitData = {};
		submitData["itemName"] = $("#itemname").val();
		submitData["contractId"] = $("#contractid").val();
		submitData["itemID"] = $("#cardid").val();
		generalAjaxCallToLoadData("updateItemNameAndContractId.action",submitData, showModdifyResult2);
	}
}

function showModdifyResult2(data){
	if(!data.actionStatus) {
		alert("更新失败！");
	} else {
		alert("更新成功！");
	}
}


function setDepartmentPKAndName(data){
	if(!data.actionStatus) {
		alert("院系代码填写有误 请重新填写！");
	} else {
		var departmentInfo = data.jsonResult;
		departmentPK = departmentInfo.departmentPk;
		departmentName = departmentInfo.departmentName;
		$("#departmentname").val(departmentName);
		return;
	}
}

/**
 *是修改页面的时候，初始文科选择的菜单 
 * @param data
 * @returns {Boolean}
 */
function initializeModdifyPage(data){
	
	if(!data.actionStatus) {
		console.log("acquireInfoToInitializePage failed!");
		return false;
	}
	var kaige = data.jsonResult;
	$("#itemid").val(kaige["itemId"]);
	$("#itemname").val(kaige["itemName"]);
	$("#contractid").val(kaige["contractId"]);
	$("#teachername").val(kaige["teacherName"]);
	$("#otherteacher").val(kaige["otherTeacher"]);
	$("#typeid").val(kaige["typeId"]);
	$("#departmentid").val(kaige["departmentId"]);
	$("#departmentname").val(kaige["departmentName"]);
	$("#departmenttype").val(kaige["departmentType"]);
	$("#cardid").val(kaige["cardId"]);
	$("#itemvalue").val(kaige["itemValue"]);
	$("#remitvalue").val(kaige["remitValue"]);
	$("#startDate").val(kaige["timeLower"]);
	$("#endDate").val(kaige["timeUpper"]);
	$("#isFinished").val(kaige["isFinished"]);
	adjustDepartment();//取得院系pk和name，赋值给全局变量
}
	


