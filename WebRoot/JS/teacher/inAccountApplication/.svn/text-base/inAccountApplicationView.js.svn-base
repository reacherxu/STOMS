//是否申请卡
var isFirstOutlay = 0;
//项目类型信息
var projectTypeInfo;

$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"我的项目",
	                	"href":"Page/Teacher/projectManagement/projectRegistrationList.jsp"
	                 },
	                 {
		                "name":"入账申请历史",
		                "href":"Page/Teacher/inAccountApplication/inAccountApplicationList.jsp?itemID=" + itemID
		             },
	                 {
	                	"name":"入账申请",
		                "href":""
	                 }];
	
	if(parent.pathWayRender != undefined) {
		parent.pathWayRender(tempPagePaths);
	}
	
	/******************************* 显示导航条 结束****************************************/
	
	
	console.log("editableSelect!!!!!!!!!!!!!!!!!!");
	
	if(addOutlayPK == undefined || addOutlayPK == null || addOutlayPK == "") {
		addOutlayPK = "0";
	}
	
	//取得页面的基本信息然后回显
	
	var tempSubmitData = {"addOutlayPK":addOutlayPK, "itemID":itemID};
	generalAjaxCallToLoadData("accquireAddOutlayByAddOutlayPKAndItemID.action", tempSubmitData, initializePageContent);

	//载入当前项目入账信息的附件列表
	refreshPicList();
});


//初始化页面，并回显入账内容
function initializePageContent(data) {
	
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	console.log(data.jsonResult);
	var inAccountInfo = data.jsonResult.addOutlayInfo;
	var cardIDArray = data.jsonResult.cardIDs;
	var currentCardID = data.jsonResult.currentCardID;
	projectTypeInfo = data.jsonResult.projectTypeInfo;
	
	var indirectID = data.jsonResult.indirectID;
	
	/*
	//卡号
	for(var i = 0; i < cardIDArray.length; i++) {
		var tempCardID = cardIDArray[i];
		
		if(tempCardID == undefined || tempCardID == null || tempCardID.length == 0) {
			continue;
		}
		
		var tempOption = "<option value = '" + tempCardID + "'>" + tempCardID + "</option>";
		$("#cardID").append(tempOption);
	}
	
	
	
	
	//如果该项目已有经费卡号，则不让用户新开经费卡
	if(currentCardID != undefined && currentCardID != null && currentCardID.length > 0) {
		
		//$("#createNewCardIDButton").remove();
		$("#cardID").html(inAccountInfo.cardId);
	} else 
		if(inAccountInfo.isFirstOutlay) {
			
			//assureCreatingNewCardID({});
			$("#cardID").html("申请新开卡");
		} else {
			$("#cardID").html(inAccountInfo.cardId);
		}
	*/
	
	
	//回显该项目类型的各个税的比例
	renderProportionLabel("tax1ProportionLabel", projectTypeInfo.ptax1);
	renderProportionLabel("tax2ProportionLabel", projectTypeInfo.ptax2);
	renderProportionLabel("tax3ProportionLabel", projectTypeInfo.ptax3);
	
	$("#itemName").html(inAccountInfo.itemName);
	$("#contractID").html(inAccountInfo.contractId);
	$("#teacherName").html(inAccountInfo.teacherName);
	$("#otherTeacherName").html(inAccountInfo.otherTeacher);
	$("#inAccountDepartment").html(inAccountInfo.outlayDepartment);
	$("#bankID").html(inAccountInfo.bankId);
	$("#indirectID").html(indirectID);
	if(inAccountInfo.cardId == null || inAccountInfo.cardId.length < 1) {
		$("#cardID").html("申请开新卡");
	} else {
		$("#cardID").html(inAccountInfo.cardId);
	}
	
	$("#outlayValue").html(inAccountInfo.outlayValue);
	$("#remitValue").html(inAccountInfo.remitValue);
	
	
	if(inAccountInfo.isTax == 1) {
		$("#taxCheck").html("是");
	} else {
		$("#taxCheck").html("否");
	}
	$("#tax1").html(inAccountInfo.tax1);
	$("#tax2").html(inAccountInfo.tax2);
	$("#tax3").html(inAccountInfo.tax3);
	
	if(inAccountInfo.isInvoice == 1) {
		$("#invoiceCheck").html("是");
	} else {
		$("#invoiceCheck").html("否");
	}
	$("#invoiceTitle").html(inAccountInfo.invoiceTitle);
	$("#invoiceDetail").html(inAccountInfo.invoiceDetail);
	
	$("#DirectValue").html(inAccountInfo.directValue);
	$("#IndirectValue").html(inAccountInfo.indirectValue);
	$("#Performance").html(inAccountInfo.performance);
	$("#Equipment").html(inAccountInfo.equipment);
	$("#Manage").html(inAccountInfo.manage);
	$("#Performance2").html(inAccountInfo.performance);
	$("#DepartmentPublic").html(inAccountInfo.departmentPublic);
	$("#CoProject").html(inAccountInfo.coProject);		
	
}


//回显各种税的比例
function renderProportionLabel(labelID, proportion){
	
	proportion = parseFloat(proportion * 100).toFixed(2);
	var labelContent = "(" + proportion + "%)";
	$("#" + labelID).html(labelContent);
}