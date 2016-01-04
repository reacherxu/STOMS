$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	
	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"经费统计",
	                	"href":""
	                 },
	                 {
	                	"name":"支出统计",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	$("#nextButton").click(function(check) { 
		var projectId = $("#project").val();
		if(projectId == "null") {
			confirm("尚未选择项目！");
		}
		else {
			var url = "Page/Teacher/budget/verifyBudget.jsp?projectId=" + projectId + "&flag=0";
			parent.pageTransition(url);
		}
	});
	generalAjaxCallToLoadData("acquireProjectsByTeacher.action",{"teacherId":teacherId},attachProjects);
});

//加载项目
function attachProjects(data) {
	if(!data.actionStatus) {
		confirm("加载项目失败 请检查数据库连接！");
		return false;
	}
	
	var jsonResult = data.jsonResult;
	
	for(var i = 0; i < jsonResult.length; i++) {
		
		var tempProject = jsonResult[i];	
		var projectId = tempProject.itemId;
		var projectName = tempProject.itemName;
		
		tempOption = "<option value='" + projectId + "'>" + projectName + "</option>";
		$("#project").append(tempOption);
	}
}