
var menuItems = [
	                {
						"name":"singleProjectQuery",
						"showName":"项目信息查询",
						"href":"Page/Admin/projectQuery/itemQuery.jsp"
					},
					{
						"name":"inAccountQuery",
						"showName":"入账经费查询",
						"href":"Page/Admin/outlayStatisticsQuery/addoutlayQuery.jsp"
					},
					{
						"name":"departmentInfo",
						"showName":"院系信息",
						"href":"Page/Admin/fundamentalDataMaintainance/departmentListView.jsp"
					},
					{
						"name":"teacherInfo",
						"showName":"教师信息",
						"href":"Page/Admin/fundamentalDataMaintainance/teacherListView.jsp"
					},
					{
						"name":"projectType",
						"showName":"项目类型",
						"href":"Page/Admin/fundamentalDataMaintainance/projectTypeListView.jsp"
					},
					{
						"name":"adminInfo",
						"showName":"个人信息",
						"href":"Page/Admin/adminInfo/adminInfo.jsp"
					},
					{
						"name":"adminPasswordChange",
						"showName":"密码修改",
						"href":"Page/Admin/adminInfo/adminPasswordChange.jsp"
					},
					{
						"name":"addMoney",
						"showName":"增加经费",
						"href":"Page/AddMoney.jsp"
					},
					{
						"name":"expenditureQuery",
						"showName":"支出查询",
						"href":"Page/Teacher/budget/expenditureQuery.jsp"
					},
					{
						"name":"expenditureStatistics",
						"showName":"支出统计",
						"href":"Page/Teacher/budget/selectProject.jsp"
					},
					{
						"name":"setDefaultMapping",
						"showName":"修改映射",
						"href":"Page/Admin/fundamentalDataMaintainance/setDefaultMapping.jsp"
					}
				];

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
		
		for(var i = 0; i < menuItems.length; i++) {
			var tempMenuItem = menuItems[i];
			var tempMenuItemShowName = tempMenuItem.showName;
			if(tempMenuItemShowName == aWidgetName) {
				var detailInfoUrl = tempMenuItem.href;
				pageTransition(detailInfoUrl);
				break;
			}
		}
		
	});
	
	//初始时页面对应项目信息审核页面
	var initialIframeUrl = "Page/AddMoney.jsp";
	pageTransition(initialIframeUrl);
	
});

//用户注销页面
function logout() {
	console.log("logout!");
	generalAjaxCallToLoadData("adminLogout.action", {}, pageJumping);
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