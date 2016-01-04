$(document).ready(function(){
	
	//兼容性
	consoleResponseInUnusabalEnvirenment();

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"基础数据",
	                	"href":""
	                 },
	                 {
		                	"name":"院系信息",
		                	"href":"Page/Admin/fundamentalDataMaintainance/departmentListView.jsp"
		                 },
	                 {
	                	"name":"查看院系信息",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	
	
	//检查departmentPK， departmentPK的值
	if(departmentPK == undefined || departmentPK == "" || departmentPK == "null") {
		console.log("item is empty!");
		departmentPK = "0";
	} 
	
	if(IsModifyPage == undefined || IsModifyPage == "" || IsModifyPage =="null") {
		console.log("item is empty!");
		IsModifyPage = "yes";
	} 
	
	$("#cancleButton").click(function(check) {
		
		history.go(-1);
	});
	
	
	//修改和添加共用一个页面
	if(IsModifyPage == "yes"){
		
		$("#assureButton").html("修改");
		generalAjaxCallToLoadData("acquireOneDepartmentInfoByPK.action",{"departmentPK":departmentPK},initializeDepartmentForm);

	}
	else{
		$("#assureButton").html("添加");
	}
	
	
	//为modifyDepartmentForm表单添加验证功能
	$("#createNewDepartmentForm").validationEngine("attach");
	
	
	//点击assureButton按钮时的响应事件
    $("#assureButton").click(function(check) {
    	
        if($("#createNewDepartmentForm").validationEngine('validate')){

        	var departmentId = $("#departmentId").val();
        	var departmentName = $("#departmentName").val();
        	var departmentType = $("#departmentType").val();
        	var assistanceId = $("#assistanceId").val();
        	var directorId = $("#directorId").val();
        	var assistanceTel = $("#assistanceTel").val();
        	var assistanceMobile = $("#assistanceMobile").val();
        	var assistanceEmail = $("#assistanceEmail").val();
        	
        	var submitData = {};
        	submitData["departmentId"] = departmentId;
        	submitData["departmentName"] = departmentName;
        	submitData["departmentType"] = departmentType;
        	submitData["assistanceId"] = assistanceId;
        	submitData["directorId"] = directorId;
        	submitData["assistanceTel"] = assistanceTel;
        	submitData["assistanceMobile"] = assistanceMobile;
        	submitData["assistanceEmail"] = assistanceEmail;
        	
        	if(IsModifyPage == "yes"){
        		
        		submitData["departmentPK"] = departmentPK;
        		generalAjaxCallToLoadData("modifyDepartment.action",submitData,showModifyDepartmentResult,submitData);
        	}
        	else{
        		generalAjaxCallToLoadData("addNewDepartment.action",submitData,showAddDepartmentResult);
        	}
        	
        }
        check.preventDefault();//此处阻止提交表单
    });
    
});

function initializeDepartmentForm(data){
	
	console.log(data);
	if(!data.actionStatus){
		alert("获取数据失败，请返回重试。");
	}
	
	var kaige = data.jsonResult;
	
	console.log(kaige);
	console.log(kaige.departmentId);

	$("#departmentId").val(kaige["departmentId"]);
	$("#departmentName").val(kaige["departmentName"]);
	$("#departmentType").val(kaige["departmentType"]);
	$("#assistanceId").val(kaige["assistanceId"]);
	$("#directorId").val(kaige["directorId"]);
	$("#assistanceTel").val(kaige["assistanceTel"]);
	$("#assistanceMobile").val(kaige["assistanceMobile"]);
	$("#assistanceEmail").val(kaige["assistanceEmail"]);
	
}

function showModifyDepartmentResult(data, tempRowData){
	
	if(!data.actionStatus){
		alert("修改院系失败，请重试！");
		return;
	}
	
	alert('恭喜你，修改成功！');
	history.go(-1);
	
}

function showAddDepartmentResult(data) {
	
	if(!data.actionStatus) {
		alert("添加院系失败，请重试！");
		return;
	}
	
	alert('恭喜你，添加成功！');
	history.go(-1);
}