
$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"用户信息",
	                	"href":""
	                 },
	                 {
	                	"name":"授权管理",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	var submitInfo = {};
	generalAjaxCallToLoadData("acquireUserAuthorizationInfo.action",submitInfo, showUserAuthorizationInfo);
});

//回显用户授权信息
function showUserAuthorizationInfo(data) {
	if(!data.actionStatus) {
		console.log("fail");
		return false;
	}
	
	var teacherAuthorityInfo = data.jsonResult;
	
	var authorizedTeacherName = teacherAuthorityInfo.authorizedName;
	var authorizedTeacherID = teacherAuthorityInfo.authorizedId;
	$("#authorizedTeacherName").val(authorizedTeacherName);
	$("#authorizedTeacherID").val(authorizedTeacherID);
}

//授权管理
function authorizationManage() {
	console.log("授权管理");
	
	var authorizedName = $("#authorizedTeacherName").val();
	var authorizedId = $("#authorizedTeacherID").val();
	
	var submitData = {};
	submitData["authorizedName"] = authorizedName;
	submitData["authorizedId"] = authorizedId;
	//异步调用
	generalAjaxCallToLoadData("authorizationManage.action",submitData, showAuthorizationResult);
	console.log(submitData);
}

//异步调用保存好授权后的回调函数
function showAuthorizationResult(data) {
	
	if(!data.actionStatus) {
		console.log("fail");
		return false;
	}
	
	console.log("success!");
}