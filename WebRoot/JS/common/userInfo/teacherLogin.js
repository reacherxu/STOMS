$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	
	$("#teacherId").keydown(function(e){
    	var theEvent = window.event || e;
        var code = theEvent.keyCode || theEvent.which;
        if (code == 13) {
        	$("#password").focus();
        }
	});
	
    $("#password").keydown(function(e){
    	var theEvent = window.event || e;
        var code = theEvent.keyCode || theEvent.which;
        if (code == 13) {
        	$("#authorizedCode").focus();
        }
	});
    
    $("#authorizedCode").keydown(function(e){
    	var theEvent = window.event || e;
        var code = theEvent.keyCode || theEvent.which;
        if (code == 13) {
        	teacherLogin();
        }
	});
});

function teacherLogin( obj ) {
	
	console.log("teacherLogin!!!");
	
	var teacherID = $("#teacherId").val();
	var password = $("#password").val();
	var authorizedCode = $("#authorizedCode").val();
	
	if(teacherID == "") {
		alert("用户名不可为空，请重试！");
		return false;
	}
	
	if(password == "") {
		alert("密码不可为空，请重试！");
		return false;
	}
	
	if(authorizedCode == "") {
		alert("验证码不可为空，请重试！");
		return false;
	}
	
	var submitInfo = {"teacherId":teacherID, "password":$.sha256(password),"authorizedCode":authorizedCode };
	generalAjaxCallToLoadData("isValidate.action", submitInfo, showLoginResult);
	
}

function showLoginResult(data) {
	
	if(!data.actionStatus) {
		
		return false;
	}
	
	var statusCode = data.jsonResult.statusCode;
	var userType = data.jsonResult.userType;
	
	var errorMessage = "";
	
	if(statusCode != "2") {
		switch(statusCode) {
		case "0": {
			errorMessage = "输入验证码有误，请重试！";
			break;
		}
		case "1": {
			errorMessage = "用户名或密码有误，请重试！";
			break;
		}
		}
		
		$("#password").val("");
		$("#authorizedCode").val("");
		authorizedCodeChange();
		openGeneralMessageDialog(errorMessage);
		return false;
	}
	
	if(userType == "superAdmin") {
		window.location.href="Page/Common/superAdminMainPage.jsp";
	} else if(userType == "admin") {
		window.location.href="Page/Common/adminMainPage.jsp";
	} else 
		if(userType == "teacher") {
			window.location.href="Page/Common/teacherMainPage.jsp";
		} else {
			window.location.href="Page/Common/pageError.jsp";
		}
}

//通过重新加载zuthorizedCode.jsp页面来修改验证码
function authorizedCodeChange() {
	
	$("#authorizedCodeImgWidget")[0].src =  path + "/authorizedCode.jsp?yy=" + new Date().getTime();
}