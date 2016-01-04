$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"教师端信息登记",
	                	"href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
});


//保存用戶信息
function redirectToTeacherMainPage() {
	
	var teacherId = $("#teacherID").val();
	
	var submitData = {};
	submitData["teacherId"] = teacherId;
	//异步调用
	generalAjaxCallToLoadData("redirectToTeacherMainPage.action",submitData, TeacherMainPageJumping);
	
}

//异步调用设置好教师端的Session后的回调函数
function TeacherMainPageJumping(data) {
	
	if(!data.actionStatus) {
		return false;
	}
	
	var statusCode = data.jsonResult.statusCode;
	var userType = data.jsonResult.userType;
	
	if(statusCode == "2" && userType == "teacher") {
		var detailInfoUrl = "Page/Common/teacherMainPage.jsp";
		window.open(detailInfoUrl);
	} else {
		alert("教师工号不存在，请重新输入!");
	}
}