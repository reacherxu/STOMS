//教师一级和二级目录列表
var adminMenu;
//二级目录列表
var secondLevelMenuList

$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	//回显用户名和上次登录的IP
	$("#currentUserName").html(userName);
	$("#currentUserLastLoginIP").html(lastLoginIP);
	
	//创建导航栏
	ddsmoothmenu.init({
		mainmenuid: "menu", //Menu DIV id
		orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
		classname: 'ddsmoothmenu', //class added to menu's outer DIV
		//customtheme: ["#804000", "#482400"],
		shadow: {enable:false, offsetx:5, offsety:5}, //enable shadow?
		contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
	});
	
	$("#menu a").click(function(){
		
		var aWidgetName = this.innerHTML;
		aWidgetName = $.trim( aWidgetName ); 
		var detailInfoUrl = "";
		
		console.log(aWidgetName);
		
		switch (aWidgetName)
		{
		case "我的项目":
			detailInfoUrl = "Page/Teacher/projectManagement/projectRegistrationList.jsp";
			break;
			
		case "支出查询":
			detailInfoUrl = "Page/Teacher/infoQuery/teacherOutlayStatisticsQuery.jsp";
			break;
		
		case "支出统计":
			detailInfoUrl = "Page/Teacher/budget/selectProject.jsp";
			break;
			
		case "个人资料":
			detailInfoUrl = "Page/Common/userInfo/userInfo.jsp";
			break;
			
		case "密码修改":
			detailInfoUrl = "Page/Common/userInfo/userPasswordChange.jsp";
			break;
			
		case "授权管理":
			detailInfoUrl = "Page/Common/userInfo/userAuthorizationManagement.jsp";
			break;
			
		default:
			return false;
		}
		
		pageTransition(detailInfoUrl);
	});
});

//用户注销页面
function logout() {
	console.log("logout!");
	generalAjaxCallToLoadData("userLogout.action", {}, pageJumping);
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
	$("#contentIFrame")[0].src = path + "/" +  url;
}

//显示当前页面路径
function pathWayRender(pathWayInfos) {
	
	var teacherPagePathWayLabel = $("#teacherPagePathWayLabel");
	
	if(teacherPagePathWayLabel == undefined || pathWayInfos.length < 1) {
		
		return false;
	}
	
	teacherPagePathWayLabel.empty();
	
	for(var i = 0; i < pathWayInfos.length; i++) {
		var currentPathWayInfo = pathWayInfos[i];
		var name = currentPathWayInfo.name;
		var href = currentPathWayInfo.href;
		
		var tempAWidget = $("<a onclick = \"navigatorAWidgetClickEvent(this)\">" + name + "</a>");
		tempAWidget.attr("hrefAddress",href);
		
		teacherPagePathWayLabel.append(tempAWidget);
		
		if(i < pathWayInfos.length - 1) {
			teacherPagePathWayLabel.append(">>");
		}
	}
}

//路径中的A标签的单击响应事件处理函数
function navigatorAWidgetClickEvent(aWidgetHtml) {
	
	var currentAWidget = $(aWidgetHtml);
	var tempHrefAddress = currentAWidget.attr("hrefAddress");
	$.trim(tempHrefAddress);
	
	if(tempHrefAddress != undefined && tempHrefAddress.length > 0) {
		pageTransition(tempHrefAddress);
	}
}