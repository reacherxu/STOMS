

$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	//回显用户名和上次登录的IP
	$("#currentUserName").html(userName);
	$("#currentUserLastLoginIP").html(lastLoginIP);
	
});

//用户注销页面
function logout() {
	console.log("logout!");
	generalAjaxCallToLoadData("superAdminLogout.action", {}, pageJumping);
}

//注销成功后的页面跳转
function pageJumping(data) {
	
	if(data.actionStatus) {
		window.location.href = path + "/teacherLogin.jsp";
	} else {
		console.log("注销失败!");
	}
}

//iframe 页面跳转
function pageTransition(url) {
	$("#contentIFrame")[0].src = url;
}

//显示当前页面路径
function pathWayRender(pathWayInfos) {
	
	var adminPagePathWayLabel = $("#adminPagePathWayLabel");
	
	if(adminPagePathWayLabel == undefined || pathWayInfos.length < 1) {
		
		return false;
	}
	
	adminPagePathWayLabel.empty();
	
	for(var i = 0; i < pathWayInfos.length; i++) {
		
		var currentPathWayInfo = pathWayInfos[i];
		var name = currentPathWayInfo.name;
		var href = currentPathWayInfo.href;
		
		var tempAWidget = $("<a onclick = \"navigatorAWidgetClickEvent(this)\">" + name + "</a>");
		tempAWidget.attr("hrefAddress",href);
		
		adminPagePathWayLabel.append(tempAWidget);
		
		if(i < pathWayInfos.length - 1) {
			adminPagePathWayLabel.append(">>");
		}
	}
}

//路径中的A标签的单击响应事件处理函数
function navigatorAWidgetClickEvent(aWidgetHtml) {
	
	var currentAWidget = $(aWidgetHtml);
	var tempHrefAddress = currentAWidget.attr("hrefAddress");
	
	if(tempHrefAddress != undefined && tempHrefAddress.trim().length > 0) {
		pageTransition(tempHrefAddress);
	}
}