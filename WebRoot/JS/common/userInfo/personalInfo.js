$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	console.log("personal information page!");
	
	$( "#teacherInfoTab" ).tabs();
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
	var teacherAuthorityInfo = data.jsonResult.teacherAuthorityInfo;
	console.log(teacherAuthorityInfo);
	console.log(teacherInfo);
	console.log(teacherLoginInfo);
	
	var name = teacherInfo.teacherName;
	var teacherId = teacherInfo.teacherId;
	var titleName = teacherInfo.titleName;
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
	$("#tel").val(tel);
	$("#mobile").val(mobile);
	$("#email").val(email);
	$("#lastLoginTime").html(recentLoginTime);
	$("#lastLoginIP").html(recentLoginIp);
	
	
	var authorizedTeacherName = teacherAuthorityInfo.authorizedName;
	var authorizedTeacherID = teacherAuthorityInfo.authorizedId;
	$("#authorizedTeacherName").val(authorizedTeacherName);
	$("#authorizedTeacherID").val(authorizedTeacherID);
	
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


//保存用戶密码
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
