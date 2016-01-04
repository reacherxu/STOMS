var allDepartmentInfo;
var allTitleInfo;

$(document).ready(function(){
	
	//兼容性
	consoleResponseInUnusabalEnvirenment();
	
	if(isModifyPage == undefined || isModifyPage == "" || isModifyPage =="null") {
		console.log("item is empty!");
		isModifyPage = "yes";
	}
	
	$("#cancleButton").click(function(check) {
		
		history.go(-1);
	});
	
	
	//为modifyDepartmentForm表单添加验证功能
	$("#editTeacherForm").validationEngine("attach");
	
	generalAjaxCallToLoadData("acquireTeacherInfoToInitializePage.action",{},initializePage);
	
	//点击assureButton按钮时的响应事件
    $("#assureButton").click(function(check) {
    	
    	if($("#editTeacherForm").validationEngine('validate')){
    		
    		var submitData = {};
    		submitData["teacherId"] = $("#teacherId").val();
    		submitData["teacherName"] = $("#teacherName").val();
    		submitData["tel"] = $("#tel").val();
    		submitData["mobile"] = $("#mobile").val();
    		submitData["email"] = $("#email").val();
    		
    		var title = $("#title").find("option:selected").text();
    		if(title == "请选择教师职称")
    			title = "";
    		submitData["titleName"] = title;
    		submitData["titlePK"] = $("#title").find("option:selected").val();
    		
    		var departmentID = $("#itemType").find("option:selected").val();
    		var departmentName = $("#itemType").find("option:selected").text();
    		
    		if(departmentID == "" || departmentName == "选择院系<"){
    			
    			departmentID = "";
    			departmentName = "";
    		}
    		
    		submitData["departmentId"] = departmentID;
    		submitData["departmentName"] = departmentName;
    		
    		console.log("submitData");
    		console.log(submitData);
    		
        	if(isModifyPage == "yes"){
        		
        		submitData["teacherPK"] = teacherPK;
        		generalAjaxCallToLoadData("modifyTeacher.action",submitData,showModdifyResult);
        	}
        	else{
        		generalAjaxCallToLoadData("addNewAdmin.action",submitData,showResult);
        	}
        	
    	}
    });
	
});

/**
 *是修改页面的时候，初始文科选择的菜单 
 * @param data
 * @returns {Boolean}
 */
function initializeModdifyPage(data){
	
	if(!data.actionStatus) {
		console.log("acquireInfoToInitializePage failed!");
		return false;
	}
	
	var kaige = data.jsonResult;
	
	$("#teacherId").val(kaige["teacherId"]);
	$("#teacherName").val(kaige["teacherName"]);
	$("#tel").val(kaige["tel"]);
	$("#mobile").val(kaige["mobile"]);
	$("#email").val(kaige["email"]);
	
	//选中教师职称
	var sel = document.getElementById('title').options;
	var titleName = kaige["titleName"];

	for(var i=0;i<sel.length;i++)
	{
	    if(titleName==sel[i].text)
	    	
	    	sel[i].selected=true;
	}
	
	
	//选中院系
	var currentDpName = kaige["departmentName"];
	var currentDpType = "";
	
	//根据名称先找出是文科还是理科
	for( var i = 0; i < allDepartmentInfo.length; i++){
		
			var tempDpName = allDepartmentInfo[i].departmentName;		
			if(currentDpName == tempDpName){
				
				currentDpType = allDepartmentInfo[i].departmentType;
				break;
			}
	}
	
	//令文理科选项选上
	var typeSel = document.getElementById('departmentType').options;
	for(var i = 0; i < typeSel.length; i++){
		
		if(currentDpType == typeSel[i].value)
			typeSel[i].selected=true;
	}
	
	//根据得到文理科信息跟院系的名称，边添加选择边判断是否对应，是则置其为选中状态
	if(currentDpType.length > 0) {
		
		$("#itemType").find("option").remove();
		
		var tempOption = "<option value=''>选择院系</option>";
		$("#itemType").append(tempOption);
		
		for(var i = 0; i < allDepartmentInfo.length; i++) {
			
			var tempDepartmentType = allDepartmentInfo[i].departmentType;
			
			//如果是选中的文理科 则添加
			if(currentDpType == tempDepartmentType) {
				
				var Id = allDepartmentInfo[i].departmentId;
				var name = allDepartmentInfo[i].departmentName;
				
				tempOption = "<option value='" + Id + "'>" + name + "</option>";
				
				//如果是对应的院系令其选上
				if(currentDpName == name){
					tempOption = "<option value='" + Id + "'selected='selected'>" + name + "</option>";
					}
				
				$("#itemType").append(tempOption);
				}
			}
		
	} else {
		
		tempOption = "<option value=''>请先选文/理科</option>";
		$("#itemType").append(tempOption);
	}

}
	

/**
 * 将数据初始化成两个全局变量，为教师职称添加下拉
 * @param data
 * @returns {Boolean}
 */
function initializePage(data){
	
	if(!data.actionStatus) {
		console.log("acquireInfoToInitializePage failed!");
		return false;
	}
	
	console.log(data);
	
	 allDepartmentInfo = data.jsonResult.allDepartmentInfo;
	 allTitleInfo = data.jsonResult.allTitleInfo;

	//为教师职称下拉列表添加option
	for(var i = 0; i < allTitleInfo.length; i++) {
		var titlePk = allTitleInfo[i].titlePk;
		var titleName = allTitleInfo[i].titleName;
		var tempOption = "<option value='" + titlePk + "'>" + titleName + "</option>";
		$("#title").append(tempOption);
	}
	
	//修改和添加共用一个页面
	if(isModifyPage == "yes"){
		
		$("#assureButton").html("修改");
		generalAjaxCallToLoadData("acquireOneTeacherInfo.action",{"teacherPK":teacherPK},initializeModdifyPage);
	}
	else{
		
		$("#assureButton").html("添加");	
	}
}

/**
 * 为文理科的改变添加处理函数
 */
function renderRelevantProjectTypes(){
	
	$("#itemType").find("option").remove();
	
	var tempOption;
	
	var departmentType = $("#departmentType").find("option:selected").val();
	var departmentType = $.trim(departmentType);
	
	if(departmentType.length > 0) {
		
		tempOption = "<option value=''>选择院系</option>";
		$("#itemType").append(tempOption);
		
		for(var i = 0; i < allDepartmentInfo.length; i++) {
			
			var tempDepartmentType1 = allDepartmentInfo[i].departmentType;
			
			//如果是选中的科目 则添加
			if(departmentType == tempDepartmentType1) {
				
				var departmentId = allDepartmentInfo[i].departmentId;
				var departmentName = allDepartmentInfo[i].departmentName;
				
				tempOption = "<option value='" + departmentId + "'>" + departmentName + "</option>";
				$("#itemType").append(tempOption);
				
			}
		}
	} else {
		tempOption = "<option value=''>请先选文/理科</option>";
		$("#itemType").append(tempOption);
	}
	
}
	
function showModdifyResult(data, tempRowData){
	
	if(!data.actionStatus){
		alert("操作失败，请重试！");
		return;
	}
	
	alert('操作成功！');
}


function showResult(data, tempRowData){
	
	if(!data.actionStatus){
		alert("工号已存在，请重试！");
		return;
	}
	
	alert('操作成功！');
	history.go(-1);
}