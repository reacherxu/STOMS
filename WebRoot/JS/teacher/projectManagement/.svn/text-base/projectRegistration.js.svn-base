var itemTypeObject;

//动态添加参与教师的输入框编号
var participateTeacherID = 0;
//所有项目类型信息
var allProjectTypeInfo;

$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	
	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"我的项目",
	                	"href":"Page/Teacher/projectManagement/projectRegistrationList.jsp"
	                 },
	                 {
	                	"name":"项目登记",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	console.log("project registration !");
	
	//如果itemPK为空，则将itemPK置为"0"
	if(itemPK == undefined || itemPK == "") {
		console.log("item is empty!");
		itemPK = "0";
		$("#budgetInfoLabel").html("如需填写预算信息，请先点击保存按钮");
	} else {
		$("#budgetInfoButton")[0].disabled = false;
		console.log("itemPK ： " + itemPK);
	}
	
	//$("#projectRegistrationForm").idealForms();
	$( "#timeLower" ).datepicker({
		showOn: 'button',
		buttonImage: "JqueryLib/css/datepickerCss/images/calendar.gif",
		buttonImageOnly: true,
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd"
	}).unbind('blur');
	
	$( "#timeUpper" ).datepicker({
		showOn: 'button',
		buttonImage: "JqueryLib/css/datepickerCss/images/calendar.gif",
		buttonImageOnly: true,
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd"
	}).unbind('blur');

	$("#projectRegistrationForm").validationEngine("attach");
	//点击提交按钮时的响应事件
	
	
	//初始化申请年度下拉列表
	var myDate = new Date();
	var currentYear = myDate.getFullYear();
	for(var i = currentYear - 5; i < currentYear + 5; i++) {
		var tempOption = "<option value='" + i + "'";
		if(i == currentYear) {
			tempOption = tempOption + "selected='selected'";
		}
		tempOption = tempOption + ">" + i + "&nbsp;年</option>";
		$("#applyYear").append(tempOption);
	}
	
    $("#projectRegistrationInfoSubmitButton").click(function(check) {
    	
        if($("#projectRegistrationForm").validationEngine('validate')){
        	//$("#timeUpper").datepicker( "hide" );
        	integratedFunctionForCodeReuse(submitItemRegistrationInfo);
        }
        check.preventDefault();//此处阻止提交表单 
    });
    
  //点击保存按钮时的响应事件
    $("#projectRegistrationInfoSaveButton").click(function(check) {
    	
        console.log("projectRegistrationInfoSaveButton");
        var tempFormData = acquireFormData();
        console.log(tempFormData);
        
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
		
		integratedFunctionForCodeReuse(saveItemRegistrationInfo);
        check.preventDefault();//此处阻止提交表单
    });
	
	//异步取得页面的初始化信息和该项目的详细信息
	generalAjaxCallToLoadData("acquireInfoToInitializePage.action",{"itemPK":itemPK}, initializePage);
});

//保存项目信息
function saveItemRegistrationInfo() {
	
	var tempFormData = acquireFormData();
	generalAjaxCallToLoadData("saveProjectRegistrationInfo.action",tempFormData, showSavingResult);
}

//提交项目信息
function submitItemRegistrationInfo() {
	
	var tempFormData = acquireFormData();
	generalAjaxCallToLoadData("submitProjectRegistrationInfo.action",tempFormData, showSubmitingResult);
}

//获取表单的数据
function acquireFormData() {
	var formData = {};
	
	formData["itemPK"] = itemPK;
	
	var itemName = $("#itemName").val();
	formData["itemName"] = itemName;
	
	var itemTypePk = $("#itemType").find("option:selected").val();
	formData["itemTypePk"] = itemTypePk;
	
	var itemTypeName = $("#itemType").find("option:selected").text();
	if(itemTypeName == "选择一个项目类型") {
		itemTypeName = "";
	}
	formData["itemType"] = itemTypeName;
	
	var contractID = $("#contractID").val();
	formData["contractID"] = contractID;
	
	var isCross = $("input[name=isCross]:checked").val(); 
	if(isCross == undefined) {
		isCross = -1;
	}
	formData["isCross"] = isCross;
	
	
	var teacherId = $("#responsibleTeacher").find("option:selected").val();
	if(teacherId == "") {
		formData["teacherId"] = "";
		formData["teacherName"] = "";
	} else {
		formData["teacherId"] = teacherId;
		var currentOptionContent = $("#responsibleTeacher").find("option:selected").text();
		var teacherName = currentOptionContent.substring(0, currentOptionContent.indexOf("("));
		formData["teacherName"] = teacherName;
	}
	
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
	
	var departmentType = $("#departmentType").find("option:selected").val();
	formData["departmentType"] = departmentType;
	
	var itemValue = $("#itemValue").val();
	if(itemValue == "") {
		itemValue = 0;
	}
	formData["itemValue"] = itemValue;
	
	var timeLower = $("#timeLower").val();
	formData["timeLower"] = timeLower;
	
	var timeUpper = $("#timeUpper").val();
	formData["timeUpper"] = timeUpper;
	
	var applyYear = $("#applyYear").find("option:selected").val();
	formData["applyYear"] = applyYear;
	
	//参与教师的姓名数组
	var participateTeacherNameArray = new Array();
	var participateTeacherName = $(".particicateTeacherName");
	for(var i = 0 ; i < participateTeacherName.length; i++) {
		var tempTeacherName = $(participateTeacherName[i]).val();
		participateTeacherNameArray.push(tempTeacherName);
	}
	formData["participateTeacherNameArray"] = participateTeacherNameArray;
	
	//参与教师的ID数组
	var participateTeacherIDArray = new Array();
	var participateTeacherID = $(".particicateTeacherID");
	for(var i = 0 ; i < participateTeacherID.length; i++) {
		var tempTeacherID = $(participateTeacherID[i]).val();
		participateTeacherIDArray.push(tempTeacherID);
	}
	formData["participateTeacherIDArray"] = participateTeacherIDArray;
	
	return formData;
}

//初始化页面信息
function initializePage(data) {
	
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	
	var jsonResult = data.jsonResult;
	
	allProjectTypeInfo = jsonResult.allProjectTypeInfo;
	console.log(allProjectTypeInfo);
	var allDepartmentInfo = jsonResult.allDepartmentInfo;
	var itemInfo = jsonResult.itemInfo;
	var participateTeachers = jsonResult.participateTeachers;
	var responsibleTeachersInfo = jsonResult.responsibleTeachersInfo;
	
	//为负责教师下拉列表添加option
	for(var i = 0; i < responsibleTeachersInfo.length; i++) {
		var responsibleTeacherID = responsibleTeachersInfo[i].teacherId;
		var responsibleTeacherName = responsibleTeachersInfo[i].teacherName;
		var optionShowName = responsibleTeacherName + "(" + responsibleTeacherID + ")";
		var tempOption = "<option value='" + responsibleTeacherID + "'>" + optionShowName + "</option>";
		$("#responsibleTeacher").append(tempOption);
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
		//全局变量项目类型的编号
		
		console.log(itemInfo);
		itemTypeObject = itemInfo.projectType;
		
		$("#itemName").val(itemInfo.itemName);
		
		$("#departmentType").val(itemInfo.departmentType);
		//给项目列表添加内容
		renderRelevantProjectTypes();
		
		$("#itemType").val(itemInfo.projectType.typePk);
		$("input[name='isCross'][value=" + itemInfo.isCross + "]").attr("checked",true);
		$("#contractID").val(itemInfo.contractId);
		$("#responsibleTeacher").val(itemInfo.teacherId);
		if(itemInfo.department != null) {
			$("#departmentID").val(itemInfo.department.departmentPk);
		}
		$("#itemValue").val(itemInfo.itemValue);
		$("#timeLower").val(itemInfo.timeLower);
		$("#timeUpper").val(itemInfo.timeUpper);
		$("#paidFunds").val(itemInfo.paidFunds);
		$("#applyYear").val(itemInfo.applyYear);
		
		console.log("回显参与教师信息");
		//回显参与教师信息
		for(var i = 0; i < participateTeachers.length; i++) {
			var participateTeacherID = participateTeachers[i].teacher2id;
			var participateTeacherName = participateTeachers[i].teacher2name;
			renderParticipateTeacher(participateTeacherID, participateTeacherName);
		}
	}
}

function resetProjectRegistrationForm() {
	
	$("#projectRegistrationForm").validationEngine("hideAll");
	$("#projectRegistrationForm")[0].reset();
}

//反馈项目信息保存操作的状态
function showSavingResult(data) {
	
	if(!data.actionStatus) {
		openGeneralMessageDialog("项目信息保存失败，请重试！");
	} else {
		$("#projectRegistrationForm").validationEngine("hideAll");
		var itemInfo = data.jsonResult;
		itemTypeObject = itemInfo.projectType;
		itemPK = itemInfo.itemPk;
		
		detailInfoUrl = "Page/Teacher/projectManagement/projectRegistration.jsp?itemPK=" 
			+ itemPK;
		parent.pageTransition(detailInfoUrl);
		//openGeneralMessageDialog("项目信息保存成功！");
	}
}

//反馈项目信息提交操作的状态
function showSubmitingResult(data) {
	
	if(!data.actionStatus) {
		openGeneralMessageDialog("项目信息提交失败，请重试！");
	} else {
		//resetProjectRegistrationForm();
		var itemInfo = data.jsonResult;
		var itemId = itemInfo.itemId;
		
		var dialogMessageContent = "恭喜您，项目信息提交成功！<br/>";
		openGeneralMessageDialogThenGoToItemList(dialogMessageContent);
	}
}

//回显创建经费卡号结果
function showCreateCardIDResult(data) {
	if(!data.actionStatus) {
		openGeneralMessageDialog("创建经费卡失败！");
	} else {
		var cardID = data.jsonResult.cardID;
		openGeneralMessageDialog("恭喜您，创建经费卡成功！<br/> 经费卡卡号：" + cardID);
	}
}

//回显参与教师的用户名和工号
function renderParticipateTeacher(teacherID, teacherName) {
	
	if(teacherID == undefined) {
		teacherID = "";
	}
	if(teacherName == undefined) {
		teacherName = "";
	}
	
	var tempNameInputID = "particicateTeacherName" + participateTeacherID;
	var tempIDInputID = "particicateTeacherID" + participateTeacherID;
	participateTeacherID = participateTeacherID + 1;
	
	var newRowHtml = "<tr>"
			+ "<td class = \"leftLabel\"><label>参与教师姓名</label></td>"
			+ "<td class = \"rightContent\"><input type=\"text\"  class=\"validate[required] particicateTeacherName\""
				+ " id = \"" + tempNameInputID + "\" value = " + teacherName  + "></input></td>"
			+ "<td class = \"leftLabel\"><label>参与教师工号</label></td>"
			+ "<td class = \"rightContent\"><input type=\"text\"  class=\"validate[required] particicateTeacherID\""
				+ " id = \"" + tempIDInputID + "\" value = " + teacherID + "></input>"
			+ "<button type = \"button\" onclick = \"addParticipateTeacher(this)\" title = \"增加教师\" style = \"background-image:url(Resource/Image/add.png); width:27px; height:27px;" +
					" background-color: transparent; border-style: none; cursor: pointer;\"></button>"
			+ "&nbsp;"
			+ "<button type = \"button\" onclick = \"deleteParticipateTeacher(this)\" title = \"删除教师\" style = \"background-image:url(Resource/Image/delete.png); width:27px; height:27px;" +
					" background-color: transparent; border-style: none; cursor: pointer;\"></button>"
			+ "</td>"
			+ "</tr>";
	
	//在院系信息这一行前逐个插入参与教师信息
	var insertPlaceTr = $("#departmentTR");
	
	insertPlaceTr.before(newRowHtml);
}

//增加参与者教师
function addParticipateTeacher(button) {
	
	var belongedTr = $(button).parent().parent();
	var tempNameInputID = "particicateTeacherName" + participateTeacherID;
	var tempIDInputID = "particicateTeacherID" + participateTeacherID;
	participateTeacherID = participateTeacherID + 1;
	
	var newRowHtml = "<tr>"
		 			+ "<td class = \"leftLabel\"><label>参与教师姓名</label></td>"
		 			+ "<td class = \"rightContent\"><input type=\"text\"  class=\"validate[required] particicateTeacherName\"" + " id = \"" + tempNameInputID + "\" /></td>"
		 			+ "<td class = \"leftLabel\"><label>参与教师工号</label></td>"
		 			+ "<td class = \"rightContent\"><input type=\"text\"  class=\"validate[required] particicateTeacherID\"" + " id = \"" + tempIDInputID + "\" />"
					+ "<button type = \"button\" onclick = \"addParticipateTeacher(this)\" title = \"增加教师\" style = \"background-image:url(Resource/Image/add.png); width:27px; height:27px;" +
										"  background-color: transparent; border-style: none; cursor: pointer;\"></button>"
					+ "&nbsp;"
					+ "<button type = \"button\" onclick = \"deleteParticipateTeacher(this)\" title = \"删除教师\" style = \"background-image:url(Resource/Image/delete.png); width:27px; height:27px;" +
										"  background-color: transparent; border-style: none; cursor: pointer;\"></button>"
					+ "</td>"
					+ "</tr>";
	
	belongedTr.after(newRowHtml);
}

//删除参与者教师
function deleteParticipateTeacher(button) {
	
	var belongedTr = $(button).parent().parent();
	
	belongedTr.remove();
}

//跳转到预算表信息
function budgetDetailInfo() {
	console.log("budgetDetailInfo");
	//itemTypeID
	
	var itemTypePk = $("#itemType").find("option:selected").val();
	if(itemTypePk == undefined || itemTypePk == "") {
		openGeneralMessageDialog("请选择项目类型！");
		return;
	}
	
	var tempBudegetType = accquireBudgetTypeByTypePK(itemTypePk);
	
	if(tempBudegetType == 1 || tempBudegetType == 2 || tempBudegetType == 3 || tempBudegetType == 4) {
		integratedFunctionForCodeReuse(jumpToBudgetInfoPage);
	} else {
		openGeneralMessageDialog("该项目类型没有预算信息！");
	}
	
}

//如果该项目已包含预算信息并修改了项目类型的情况下需要删除已存在的预算信息,
//由于在项目保存，项目提交和进入预算信息页面的操作的时候都得做此判断
//为了代码复用，写了该方法，actualOperationFunctionName为实际要操作的内容(项目保存/项目提交/预算信息)
function integratedFunctionForCodeReuse(actualOperationFunctionName) {
	
	if(itemPK == "0") {
		//如果是新建项目，则提示保存当前信息，点击确定后进入预算
		actualOperationFunctionName();
	} else {
		//如果该项目已在Item表中存在
		var budgetType = accquireBudgetTypeByTypePK(itemPK);
		var submitData = {"itemPK":itemPK, "budgetType":budgetType};
		generalAjaxCallToLoadData("judgeWhetherHavedBudgetInfo.action", submitData, getIsBudgetExisted, actualOperationFunctionName);
	}
}

//异步查看该项目是否存在预算操作后的回调函数
function getIsBudgetExisted(data, actualOperationFunctionName) {
	
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	
	var isBudgetExisted = data.jsonResult.isBudgetExisted;
	
	if(isBudgetExisted) {
		//如果该项目存在预算表
		console.log(" budget is existed!!!!!");
		var currentItemTypePK = $("#itemType").find("option:selected").val();
		var currentItemTypeName = $("#itemType").find("option:selected").text();
		var originalItemTypePK = itemTypeObject.typePk;
		var originalItemTypeName = itemTypeObject.typeName;
		
		if(originalItemTypePK != currentItemTypePK) {
			//如果用户修改项目类型
			var dialogMessageContent = "当前项目类型为：" + originalItemTypeName + ", 确定要改类型为：" 
							+ currentItemTypeName + " 么？ 此修改将删除已保存的预算信息！";
			var itemTypeId = itemTypeObject.typeId;
			var dataForDeletion = {"itemPK":itemPK, "typeId":itemTypeId, "actualOperationFunctionName":actualOperationFunctionName};
			openGeneralAssureDialog(dialogMessageContent, deleteRelatedBudgetInfo, dataForDeletion);
		} else {
			//如果用户没有修改项目类型
			actualOperationFunctionName();
		}
	} else {
		//如果该项目不存在预算表
		actualOperationFunctionName();
	}
}

//删除主键为itemPK的项目的已存在的预算信息
function deleteRelatedBudgetInfo(dataForDeletion) {
	var actualOperationFunctionName = dataForDeletion.actualOperationFunctionName;
	var submitData = {};
	submitData["itemPK"] = dataForDeletion.itemPK;
	submitData["budgetType"] = accquireBudgetTypeByTypePK(dataForDeletion.itemPK);
	generalAjaxCallToLoadData("deleteRelatedBudgetOfThisItem.action", submitData, showBudgetDeletionResult, actualOperationFunctionName);
}

//异步删除预算信息的回调函数
function showBudgetDeletionResult(data, actualOperationFunctionName) {
	
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	
	//删除预算信息成功后,跳转到预算页面
	actualOperationFunctionName();
}

//跳转到预算信息页面
function jumpToBudgetInfoPage() {
	
	var dialogMessageContent = "在转入预算信息页面前，系统将自动保存当前的项目信息，您确定要进入预算信息么？";
	var parameter = {};
	openGeneralAssureDialog(dialogMessageContent, autoSaveItemInfoForBudget, parameter);
}


//为了预算填写，自动保存项目信息
function autoSaveItemInfoForBudget(parameter) {
	
	var tempFormData = acquireFormData();
    console.log(tempFormData);
    
	var itemName = tempFormData.itemName;
	if(itemName == "") {
    	openGeneralMessageDialog("请填写项目名称！");
    	return;
    }
	var itemTypePk = tempFormData.itemTypePk;
	if(itemTypePk == "") {
		openGeneralMessageDialog("请选择项目类型！");
		return;
	}
	generalAjaxCallToLoadData("saveProjectRegistrationInfo.action",tempFormData, showSavingProjectRegistrationInfoResult);
}

//保存项目信息成功后转入预算信息页面
function showSavingProjectRegistrationInfoResult(data) {
	if(!data.actionStatus) {
		openGeneralMessageDialog("项目信息保存失败，请重试！");
	} else {
		$("#projectRegistrationForm").validationEngine("hideAll");
		
		var itemInfo = data.jsonResult;
		itemTypeObject = itemInfo.projectType;
		itemPK = itemInfo.itemPk;
		
		var itemTypePk = $("#itemType").find("option:selected").val();
		var itemBudgetType = accquireBudgetTypeByTypePK(itemTypePk);
		
		var detailInfoUrl = "";
		
		switch (itemBudgetType)
		   {
		   case 4:
			   // 社科基金预算类型
			   detailInfoUrl = "Page/Teacher/projectManagement/socialScienceFundBudget.jsp?itemPk=" + itemPK;
		     break;
		   case 3:
			   // 863/973预算类型
			   detailInfoUrl = "Page/Teacher/projectManagement/nation863BudgetForm.jsp?itemPk=" + itemPK + "&indexOfBudget=0";
		     break;
		   case 2:
			   // 国家基金预算类型
			   detailInfoUrl = "Page/Teacher/projectManagement/nationalFundBudget.jsp?itemPk=" + itemPK;
		     break;
		   case 1:
			   // 省基金预算类型
			   detailInfoUrl = "Page/Teacher/projectManagement/provincialFundBudget.jsp?itemPk=" + itemPK;
		     break;
		   default:
			   detailInfoUrl = "Page/Common/pageError.jsp";
		}
		parent.pageTransition(detailInfoUrl);
	}
}

//选择文/理科后将相应的项目类型显示在后面的下拉列表中
function renderRelevantProjectTypes() {
	
	$("#itemType").find("option").remove();
	
	var tempOption;
	
	var departmentType = $("#departmentType").find("option:selected").val();
	var departmentType = $.trim(departmentType);
		
	if(departmentType.length > 0) {
		
		tempOption = "<option value=''>选择一个项目类型</option>";
		$("#itemType").append(tempOption);
		
		for(var i = 0; i < allProjectTypeInfo.length; i++) {
			
			var tempDepartmentType1 = allProjectTypeInfo[i].departmentType;
			if(departmentType == tempDepartmentType1) {
				
				var typePK = allProjectTypeInfo[i].typePk;
				var typeName = allProjectTypeInfo[i].typeName;
				
				tempOption = "<option value='" + typePK + "'>" + typeName + "</option>";
				$("#itemType").append(tempOption);
				
			}
		}
	} else {
		tempOption = "<option value=''>请先选文/理科</option>";
		$("#itemType").append(tempOption);
	}
}

//根据项目类型PK得到该项目的预算类型
function accquireBudgetTypeByTypePK(itemTypePK) {
	
	var itemBudgetType = 0;
	
	for(var i = 0; i < allProjectTypeInfo.length; i++) {
		var tempItemtypePK = "" + allProjectTypeInfo[i].typePk + "";
		
		if(tempItemtypePK == itemTypePK) {
			itemBudgetType = allProjectTypeInfo[i].budgetType;
			break;
		}
	}
	
	return itemBudgetType;
}