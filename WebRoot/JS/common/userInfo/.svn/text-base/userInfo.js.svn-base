$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"用户信息",
	                	"href":""
	                 },
	                 {
	                	"name":"个人资料",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	console.log("personal information page!");
	
	var submitInfo = {};
	generalAjaxCallToLoadData("acquireTeacherInfo.action",submitInfo, showTeacherInfo);
});

function showTeacherInfo(data) {
	
	if(!data.actionStatus) {
		console.log("fail");
		return false;
	}
	
	var teacherLoginInfo = data.jsonResult.teacherLoginInfo;
	var teacherInfo = data.jsonResult.teacherInfo;
	
	//console.log(teacherInfo);
	//console.log(teacherLoginInfo);
	
	var name = teacherInfo.teacherName;
	var teacherId = teacherInfo.teacherId;
	var titleName = teacherInfo.titleName;
	var indirectId = teacherInfo.indirectId;
	var mobile = teacherInfo.mobile;
	var email = teacherInfo.email;
	var departmentName = teacherInfo.departmentName;
	var tel = teacherInfo.tel;
	var recentLoginIp = teacherLoginInfo.recentLoginIp;
	var recentLoginTime = teacherLoginInfo.recentLoginTime;
	
	$("#name").html(name);
	$("#teacherID").html(teacherId);
	$("#department").html(departmentName);
	$("#titleName").html(titleName);
	$("#indirectID").html(indirectId);
	$("#tel").val(tel);
	$("#mobile").val(mobile);
	$("#email").val(email);
	$("#lastLoginTime").html(recentLoginTime);
	$("#lastLoginIP").html(recentLoginIp);
	
}

//保存用戶信息
function saveTeacherInfo() {
	var mobile = $("#mobile").val();
	var tel = $("#tel").val();
	var email = $("#email").val();
	
	var submitData = {};
	submitData["mobile"] = mobile;
	submitData["tel"] = tel;
	submitData["email"] = email;
	//异步调用
	generalAjaxCallToLoadData("saveTeacherInfo.action",submitData, showSavingResult);
	console.log(submitData);
}

//异步调用保存好用户信息后的回调函数
function showSavingResult(data) {
	
	if(!data.actionStatus) {
		console.log("fail");
		return false;
	}
	
	console.log("success!");
}