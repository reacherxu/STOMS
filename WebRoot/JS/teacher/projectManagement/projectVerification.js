$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	
	console.log("project registration !");
	
	//如果itemPK为空，则将itemPK置为"0"
	if(itemPK == undefined || itemPK == "") {
		console.log("item is empty!");
		itemPK = "0";
	} else {
		
		console.log("itemPK ： " + itemPK);
	}
	
	//$("#projectRegistrationForm").idealForms();
	$( "#timeLower" ).datepicker({
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd",
		showAnim: "slideDown"
	});
	
	$( "#timeUpper" ).datepicker({
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd",
		showAnim: "slideDown"
	});

	$("#projectRegistrationForm").validationEngine("attach");
	//点击提交按钮时的响应事件
    $("#projectRegistrationInfoSubmitButton").click(function(check) {    
        if($("#projectRegistrationForm").validationEngine('validate')){
        	console.log("projectRegistrationInfoSubmitButton");
        	var tempFormData = acquireFormData();
        	generalAjaxCallToLoadData("submitProjectRegistrationInfo.action",tempFormData, showSubmitingResult);
        }
        check.preventDefault();//此处阻止提交表单  
    });
    
  //点击保存按钮时的响应事件
    $("#projectRegistrationInfoSaveButton").click(function(check) {
    	
        console.log("projectRegistrationInfoSaveButton");
        var tempFormData = acquireFormData();
        console.log(tempFormData);
        var itemId = tempFormData.itemID;
        if(itemId == "") {
        	openGeneralMessageDialog("请填写项目代码！");
        	return;
        }
		var itemName = tempFormData.itemName;
		if(itemName == "") {
        	openGeneralMessageDialog("请填写项目名称！");
        	return;
        }
		var itemTypePk = tempFormData.itemTypePk;;
		if(itemTypePk == "") {
			openGeneralMessageDialog("请选择项目类型！");
			return;
		}
		generalAjaxCallToLoadData("saveProjectRegistrationInfo.action",tempFormData, showSavingResult);
        check.preventDefault();//此处阻止提交表单
    });
	
	//异步取得页面的初始化信息和该项目的详细信息
	generalAjaxCallToLoadData("acquireInfoToInitializePage.action",{"itemPK":itemPK}, initializePage);
});


function acquireFormData() {
	var formData = {};
	
	formData["itemPK"] = itemPK;
	
	var itemId = $("#itemID").val();
	formData["itemID"] = itemId;
	
	var itemName = $("#itemName").val();
	formData["itemName"] = itemName;
	
	var itemTypePk = $("#itemType").find("option:selected").val();
	formData["itemTypePk"] = itemTypePk;
	
	var itemTypeName = $("#itemType").find("option:selected").text();
	if(itemTypeName == "选择一个项目类型") {
		itemTypeName = "";
	}
	formData["itemType"] = itemTypeName;
	
	var isCross = $("input[name=isCross]:checked").val(); 
	if(isCross == undefined) {
		isCross = -1;
	}
	formData["isCross"] = isCross;
	
	var teacherName = $("#teacherName").val();
	formData["teacherName"] = teacherName;
	
	var teacherId = $("#teacherID").val();
	formData["teacherId"] = teacherId;
	
	var departmentPk = $("#departmentID").find("option:selected").val();
	if(departmentPk == "") {
		departmentPk = -1;
	}
	formData["departmentPk"] = departmentPk;
	
	var departmentName =  $("#departmentID").find("option:selected").text();
	if(departmentName == "选择一个院系") {
		departmentName = "";
	}
	formData["departmentName"] = departmentName;
	
	var departmentType = $("input[name=departmentType]:checked").val();
	if(departmentType == undefined) {
		departmentType = -1;
	}
	formData["departmentType"] = departmentType;
	
	var itemValue = $("#itemValue").val();
	if(itemValue == "") {
		itemValue = 0;
	}
	formData["itemValue"] = itemValue;
	
	var remitValue = $("#remitValue").val();
	if(remitValue == "") {
		remitValue = 0;
	}
	formData["remitValue"] = remitValue;
	
	var timeLower = $("#timeLower").val();
	formData["timeLower"] = timeLower;
	
	var timeUpper = $("#timeUpper").val();
	formData["timeUpper"] = timeUpper;
	
	var paidFunds = $("#paidFunds").val();
	if(paidFunds == "") {
		paidFunds = 0;
	}
	formData["paidFunds"] = paidFunds;
	
	var isFinished = $("input[name=isFinished]:checked").val();
	if(isFinished == undefined) {
		isFinished = -1;
	}
	formData["isFinished"] = isFinished;
	
	return formData;
}
function initializePage(data) {
	
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	
	var jsonResult = data.jsonResult;
	
	var allProjectTypeInfo = jsonResult.allProjectTypeInfo;
	var allDepartmentInfo = jsonResult.allDepartmentInfo;
	var itemInfo = jsonResult.itemInfo;
	
	console.log(allProjectTypeInfo);
	console.log(allDepartmentInfo);
	console.log(itemInfo);
	//为项目类型下拉列表添加option
	for(var i = 0; i < allProjectTypeInfo.length; i++) {
		var typePK = allProjectTypeInfo[i].typePk;
		var typeName = allProjectTypeInfo[i].typeName;
		var tempOption = "<option value='" + typePK + "'>" + typeName + "</option>";
		$("#itemType").append(tempOption);
	}
	
	//为院系下拉列表添加option
	for(var i = 0; i < allDepartmentInfo.length; i++) {
		var departmentPk = allDepartmentInfo[i].departmentPk;
		var departmentName = allDepartmentInfo[i].departmentName;
		var tempOption = "<option value='" + departmentPk + "'>" + departmentName + "</option>";
		$("#departmentID").append(tempOption);
	}
	
	//如果项目的主键不为空，则回显表单信息
	if(itemPK != "0") {
		$("#itemID").val(itemInfo.itemId);
		$("#itemName").val(itemInfo.itemName);
		$("#itemType").val(itemInfo.projectType.typePk);
		$("input[name='isCross'][value=" + itemInfo.isCross + "]").attr("checked",true);
		$("#teacherName").val(itemInfo.teacherName);
		$("#teacherID").val(itemInfo.teacherId);
		$("#departmentID").val(itemInfo.department.departmentPk);
		$("input[name='departmentType'][value=" + itemInfo.departmentType+ "]").attr("checked",true);
		$("#itemValue").val(itemInfo.itemValue);
		$("#remitValue").val(itemInfo.remitValue);
		$("#timeLower").val(itemInfo.timeLower);
		$("#timeUpper").val(itemInfo.timeUpper);
		$("#paidFunds").val(itemInfo.paidFunds);
		$("input[name='isFinished'][value= " + itemInfo.isFinished + "]").attr("checked",true);
	}
}

function resetProjectRegistrationForm() {
	
	$("#projectRegistrationForm")[0].reset();
	$("#projectRegistrationForm").validationEngine("hideAll");
}

//反馈项目信息保存操作的状态
function showSavingResult(data) {
	
	if(!data.actionStatus) {
		openGeneralMessageDialog("项目信息保存失败，请重试！");
	} else {
		resetProjectRegistrationForm();
		openGeneralMessageDialog("项目信息保存成功！");
	}
}

//反馈项目信息提交操作的状态
function showSubmitingResult(data) {
	
	if(!data.actionStatus) {
		openGeneralMessageDialog("项目信息提交失败，请重试！");
	} else {
		resetProjectRegistrationForm();
		openGeneralMessageDialog("项目信息提交成功！");
	}
}

