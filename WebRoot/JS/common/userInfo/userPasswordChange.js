//保存用戶密码


	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"用户信息",
	                	"href":""
	                 },
	                 {
	                	"name":"密码修改",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
function modifyTeacherPassord() {
	
	var newPassword = $("#newPassord").val();
	var currentPassword = $("#currentPassord").val();
	var confirmPassword = $("#confirmPassord").val();
	console.log(newPassword);
	console.log(currentPassword);
	console.log(confirmPassword);
	
	if(newPassword != confirmPassword) {
		alert("两次输入的密码不一致，请重新输入！");
		$("#newPassord").val("");
		$("#confirmPassord").val("");
		return false;
	}
	
	var submitData = {"currentPassord":$.sha256(currentPassword),"newPassord":$.sha256( newPassword )};
	
	//异步调用
	generalAjaxCallToLoadData("saveTeacherPassord.action",submitData, showSavingResult);
	//console.log(submitData);
}

//异步调用保存好用户信息后的回调函数
function showSavingResult(data) {
	
	if(!data.actionStatus) {
		alert("密码错误！");
		$("#currentPassord").val("");
	} else {
		alert("保存成功!");
		$("#newPassord").val("");
		$("#confirmPassord").val("");
		$("#currentPassord").val("");
	}
	
}