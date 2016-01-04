var itemTypePK;
var itemTypeName;
var itemTypeID;

var departmentPK;
var departmentName;
var departmentId;
var departmentType;//文理科(由 确认窗口时，文科还是理科的项目类型选中决定)
var departmentType2;//文理科(由 确认窗口时，通过项目ID中的院系代码，或者院系代码中的院系代码，查询数据库得到的文理科类型)
var itemID;//项目ID

var directValue=0;
var indirectValue=0;
var performance=0;
var equipment=0;

var actV;
var improveV;
var manageV;
var payV;
var manage2V;
var pay2V;
var consultV;
var availableManageCreditV;

var addOutlayPK;

var teacherPK;
var teacherId;

$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"增加经费",
	                	"href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	$("#addMoneyForm").validationEngine("attach");/***********加载验证引擎**********/
	$($("*[id=calc]")[1]).validationEngine("attach");/***********加载验证引擎**********/
	
	/******************************* 初始化 是否横向项目 开始****************************************/
	
	$("#txtDepartmentPay").attr("disabled", true);
	$("#chkIsArt").attr("disabled", true);
	$("#txtArtPay").attr("disabled", true);
	$("#chkIsTax").attr("disabled", true);
	$("#chkIsScience").attr("disabled", true);
	$("#txtSciencePay").attr("disabled", true);
	$("#txtTax1").attr("disabled", true);
	$("#txtTax2").attr("disabled", true);
	$("#txtTax3").attr("disabled", true);
	
	$("#chkIsBroadwise").change(function(event){//横向项目 初始化时 9个都不能用
		if(this.checked){//横向项目 点下时  4个变可用
			$("#row1").show();
			$("#row2").show();
			$("#row3").show();
			$("#txtDepartmentPay").attr("disabled", false);
			valueOrOutChange();
			$("#chkIsArt").attr("disabled", false);
			$("#chkIsTax").attr("disabled", false);
			$("#chkIsScience").attr("disabled", false);
			/******************************* 初始化 是否税金 开始*********************************/
			$("#chkIsTax").change(function(event){ //初始化的时候 税金1-3不可用
				if(this.checked){//税金 点下时  税金1-3变可用 计算税金
					$("#txtTax1").attr("disabled", false);
					$("#txtTax2").attr("disabled", false);
					$("#txtTax3").attr("disabled", false);
					valueOrOutChange();
				}else{
					$("#txtTax1").attr("disabled", true);
					$("#txtTax2").attr("disabled", true);
					$("#txtTax3").attr("disabled", true);
					$("#txtTax1").val("");
					$("#txtTax2").val("");
					$("#txtTax3").val("");
				}
			  });
			/******************************* 初始化 是否税金 开始*********************************/
			/******************************* 初始化 文科劳务费3 开始*********************************/
			$("#chkIsArt").change(function(event){ //
				if(this.checked){//
					$("#txtArtPay").attr("disabled",false);
					$("#txtSciencePay").attr("disabled",true);
					valueOrOutChange();
					$("#txtSciencePay").val("");
					$("#chkIsScience").attr("checked", false);
				}else{
					$("#txtArtPay").attr("disabled", true);
					$("#chkIsScience").attr("checked", true);
					$("#txtSciencePay").attr("disabled",false);
					valueOrOutChange();
					$("#txtArtPay").val("");
				}
			  });
			/******************************* 初始化 文科劳务费3 结束*********************************/
			/******************************* 初始化 理科劳务费3 开始*********************************/
			$("#chkIsScience").change(function(event){ //
				if(this.checked){//
					$("#txtSciencePay").attr("disabled",false);
					$("#txtArtPay").attr("disabled",true);
					valueOrOutChange();
					$("#txtArtPay").val("");
					$("#chkIsArt").attr("checked", false);
				}else{
					$("#txtSciencePay").attr("disabled", true);
					$("#chkIsArt").attr("checked", true);
					$("#txtArtPay").attr("disabled",false);
					valueOrOutChange();
					$("#txtSciencePay").val("");
				}
			  });
			/******************************* 初始化 理科劳务费3 结束*********************************/
		}else{
			$("#row1").hide();
			$("#row2").hide();
			$("#row3").hide();
			$("#txtDepartmentPay").attr("disabled", true);
			$("#chkIsArt").attr("disabled", true);
			$("#txtArtPay").attr("disabled", true);
			$("#chkIsTax").attr("disabled", true);
			$("#chkIsScience").attr("disabled", true);
			$("#txtSciencePay").attr("disabled", true);
			$("#txtTax1").attr("disabled", true);
			$("#txtTax2").attr("disabled", true);
			$("#txtTax3").attr("disabled", true);
			$("#txtDepartmentPay").val("");
			$("#chkIsArt").attr("checked", false);
			$("#txtArtPay").val("");
			$("#chkIsTax").attr("checked", false);
			$("#chkIsScience").attr("checked", false);
			$("#txtSciencePay").val("");
			$("#txtTax1").val("");
			$("#txtTax2").val("");
			$("#txtTax3").val("");
		}
	  });

	/******************************* 初始化 是否横向项目 结束****************************************/
	
	/******************************* 初始化 第一次拨款部分 开始****************************************/
	$("#chkNewCard").attr("checked", false);
	
	$("#txtNewName").attr("disabled", true);
	$("#txtContractID").attr("disabled", true);
	$("#txtTotalValue").attr("disabled", true);
	$("#time1").attr("disabled", true);
	$("#time2").attr("disabled", true);
	$("#txtDept").attr("disabled", true);
	
	$( "#time1" ).datepicker({
		dateFormat: "yy-mm-dd"
	}).unbind('blur');
	
	$( "#time2" ).datepicker({
		dateFormat: "yy-mm-dd"
	}).unbind('blur');
	
	$("#chkNewCard").change(function(event){
		if(this.checked){//需要开新开卡，项目代码非必填，下面的框都要变成可用
			$("#row4").show();
			$("#row5").show();
			$("#row6").show();
			//$("#txtID").removeClass("validate[required, custom[integer], minSize[10], maxSize[12]]").addClass("validate[option, custom[integer], minSize[10], maxSize[12]]");
			$("#txtID").attr("disabled",true);
			$("#txtNewName").attr("disabled", false);
			$("#txtContractID").attr("disabled", false);
			$("#txtTotalValue").attr("disabled", false);
			$("#time1").attr("disabled", false);
			$("#time2").attr("disabled", false);
			$("#txtDept").attr("disabled", false);
		}else{//不需要开新开卡，项目代码必填，下面的框都要变成不可用，并清空框中的值
			$("#row4").hide();
			$("#row5").hide();
			$("#row6").hide();
			//$("#txtID").removeClass("validate[option, custom[integer], minSize[10], maxSize[12]]").addClass("validate[required, custom[integer], minSize[10], maxSize[12]]");
			$("#txtID").attr("disabled",false);
			$("#txtNewName").attr("disabled", true);
			$("#txtContractID").attr("disabled", true);
			$("#txtTotalValue").attr("disabled", true);
			$("#time1").attr("disabled", true);
			$("#time2").attr("disabled", true);
			$("#txtDept").attr("disabled", true);
			$("#txtNewName").val("");
			$("#txtContractID").val("");
			$("#txtTotalValue").val("");
			$("#time1").val("");
			$("#time2").val("");
			$("#txtDept").val("");
		}
	  });
	/******************************* 初始化 第一次拨款部分 结束****************************************/
	/******************************* 初始化 自行确定可用管理额度 开始****************************************/
	$("#txtAvailableManageCredit").attr("disabled",true);
	$("#chk_availableManageCredit").change(function(event){
		if(this.checked){//自行确定可用管理额度 可用
			$("#txtAvailableManageCredit").attr("disabled",false);
			valueOrOutChange();
		}else{//自行确定可用管理额度 不可用
			$("#txtAvailableManageCredit").attr("disabled",true);
			$("#txtAvailableManageCredit").val("");
		}
	  });
	/******************************* 初始化 自行确定可用管理额度 结束****************************************/
	/******************************* 初始化 项目类型部分 开始****************************************/
	generalAjaxCallToLoadData("acquireAllProjectType.action",{},attachProjectType);
	$("#science").change(function(){
		var checkValue=$("#science").val();
		//改写valueOrOutChange()函数 当来款金额和汇出金额变化时，相应计算公式依据该项目类型的比率。
		//并调用valueOrOutChange()函数
		if(checkValue!="notme"){
			$("#art").get(0).selectedIndex=0;
			$("#art").attr("disabled",true);
		}else{
			$("#art").get(0).selectedIndex=0;
			$("#art").attr("disabled",false);
		}
	}); 
	$("#art").change(function(){
		var checkValue=$("#art").val();
		//改写valueOrOutChange()函数 当来款金额和汇出金额变化时，相应计算公式依据该项目类型的比率。
		//并调用valueOrOutChange()函数
		if(checkValue!="notme"){
			$("#science").get(0).selectedIndex=0;
			$("#science").attr("disabled",true);
		}else{
			$("#science").get(0).selectedIndex=0;
			$("#science").attr("disabled",false);
		}
	}); 
	/******************************* 初始化 项目类型部分 结束****************************************/
	//院系代码 按钮事件
	generalAjaxCallToLoadData("acquireAllDepartmentInfo.action",{},initializeDepartmentTable);
	$("#cmdDept").click(function(check) {
		$('#departmentCode').show;
		new Dialog({type:'id',value:'departmentCode'}).show();
		SetTableColor();
    });
	//确定 按钮 事件
	$("#cmdOK").click(function(check) {
        if($("#addMoneyForm").validationEngine('validate')){//如果验证通过
        	confirmDialog();//点击确定按钮 弹出确定界面
        }
        check.preventDefault();//此处阻止提交表单 
    });
});

//确定界面
function confirmDialog(){
	var actP;
	var improveP;
	var manageP;
	var payP;
	var manage2P;
	var pay2P;
	var consultP;
	
	itemID = getStringInputWidgetValue("txtID");
	if(itemID == "" && !$("#chkNewCard").attr("checked")){
		openGeneralMessageDialog("项目代码不能为空！");// 项目代码不为空时 检查 项目代码与项目类型是否匹配
		return;
	}
	$("#confirm").show;
	//对confirm赋值  
	//getStringInputWidgetValue(widgetID) 得到字符输入框的值 $.trim()
	//getNumberInputWidgetValue(widgetID) 得到数值输入框的值 parseInt() 空就是0
	//getSelectWidgetValue(widgetID)得到下拉菜单的值  .find("option:selected").val()
	//getLabelWidgetValue(widgetID) 得到label中的数值 parseInt() 空就是0
	$("#DP").html(getStringInputWidgetValue("txtDP"));
	if(getStringInputWidgetValue("txtName2") == ""){
		$("#name").html(getStringInputWidgetValue("txtName"));
	}else{
		$("#name").html(getStringInputWidgetValue("txtName")+"和"+getStringInputWidgetValue("txtName2"));
	}
	$("#value").html(getNumberInputWidgetValue("txtValue")+"元");
	if(getNumberInputWidgetValue("txtTotalValue")==""){
		$("#totalValue").html("暂无");
	}else{
		$("#totalValue").html(getNumberInputWidgetValue("txtTotalValue")+"元");
	}
	if($("#science").attr("disabled") && !($("#art").attr("disabled"))){
		$("#itemNameAndDepartmentType").html($("#art option:selected").text()+"---文科");
		itemTypePK = ($("#art").val()).split("separator")[0];
		itemTypeID = ($("#art").val()).split("separator")[1];
		itemTypeName = $("#art option:selected").text();
		departmentType = "文科";
		//alert($("#art").val());
		actP = ($("#art").val()).split("separator")[2];
		improveP = ($("#art").val()).split("separator")[3];
		manageP = ($("#art").val()).split("separator")[4];
		payP = ($("#art").val()).split("separator")[5];
		manage2P = ($("#art").val()).split("separator")[6];
		pay2P = ($("#art").val()).split("separator")[7];
		consultP = ($("#art").val()).split("separator")[8];
		var itemid = getStringInputWidgetValue("txtID");
		if(itemid.length != 0){
			if(($("#art").val()).split("separator")[1] != getStringInputWidgetValue("txtID").substring(4,7)){
				openGeneralMessageDialog("项目类型和项目代码不匹配 ，请检查后重新输入！");// 项目代码不为空时 检查 项目代码与项目类型是否匹配
				return;
			}
		}
		
	}else if($("#art").attr("disabled") && !($("#science").attr("disabled"))){
		$("#itemNameAndDepartmentType").html($("#science option:selected").text()+"---理科");
		itemTypePK = ($("#science").val()).split("separator")[0];
		itemTypeName = $("#science option:selected").text();
		itemTypeID = ($("#science").val()).split("separator")[1];
		departmentType = "理科";
		actP = ($("#science").val()).split("separator")[2];
		improveP = ($("#science").val()).split("separator")[3];
		manageP = ($("#science").val()).split("separator")[4];
		payP = ($("#science").val()).split("separator")[5];
		manage2P = ($("#science").val()).split("separator")[6];
		pay2P = ($("#science").val()).split("separator")[7];
		consultP = ($("#science").val()).split("separator")[8];
		var itemid = getStringInputWidgetValue("txtID");
		if(itemid.length != 0){//项目代码不为空时 检查项目代码和项目类型是否匹配
			if(($("#science").val()).split("separator")[1] != getStringInputWidgetValue("txtID").substring(4,7)){
				openGeneralMessageDialog("项目类型和项目代码不匹配 ，请检查后重新输入！");//检查 项目代码与项目类型是否匹配
				return;
			}
		}
	}else{
		openGeneralMessageDialog("请选择项目类型！");
		return;
	}
	if(getNumberInputWidgetValue("txtOut")==""){
		$("#isOut").html("否");
	}else{
		$("#isOut").html("是。汇出金额："+getNumberInputWidgetValue("txtOut")+"元");
	}
	$("#other").html(getStringInputWidgetValue("txtOther"));
	if($("#chkNewCard").attr("checked")){
		$("#isFirstAddMoney").html("第一次拨款，需要开新卡。" +
				"项目名称："+getStringInputWidgetValue("txtNewName") + 
				" 项目时间："+getStringInputWidgetValue("time1")+
				"--"+getStringInputWidgetValue("time2")+
				" 合同号："+getStringInputWidgetValue("txtContractID")+" ");
		$("#departmentCode0").html("入账人院系："+getStringInputWidgetValue("txtDept"));
	}else{
		$("#isFirstAddMoney").html("不开新卡。卡号："+getStringInputWidgetValue("txtID"));
	}
	$("#value2").html(getNumberInputWidgetValue("txtValue")+"元");
	$("#out").html(getNumberInputWidgetValue("txtOut")+"元");
	var value = getNumberInputWidgetValue("txtValue");
	var out = getNumberInputWidgetValue("txtOut");
	if(value-out < 0){
		openGeneralMessageDialog("汇出金额不能大于来款金额，请检查后重新输入");
		return;
	}else if(value-out == 0){
		manageV = 0.0;
		manage2V = 0.0;
		payV = 0.0;
		pay2V = 0.0;
		actV = 0.0;
		improveV = 0.0;
		consultV = 0.0;
		availableManageCreditV = 0.00;
		$("#manage1V").html("0.00 元");
		$("#manage1P").html("0.00 %");
		$("#manage2V").html("0.00 元");
		$("#manage2P").html("0.00 %");
		$("#pay1V").html("0.00 元");
		$("#pay1P").html("0.00 %");
		$("#pay2V").html("0.00 元");
		$("#pay2P").html("0.00 %");
		$("#actV").html("0.00 元");
		$("#actP").html("0.00 %");
		$("#improveV").html("0.00 元");
		$("#improveP").html("0.00 %");
		$("#consultV").html("0.00 元");
		$("#consultP").html("0.00 %");
		$("#aviV").html("0.00 元");
		$("#aviP").html("0.00 %");
	}else{
		if(($("#txtManage").val()).length != 0){
			manageV = getNumberInputWidgetValue("txtManage");
			$("#manage1V").html(parseFloat(manageV).toFixed(2)+" 元");
			$("#manage1P").html((getNumberInputWidgetValue("txtManage")/(value-out)*100).toFixed(2)+" %");
		}else{
			$("#manage1P").html(parseFloat(manageP).toFixed(2)+" %");
			manageV = (manageP*(value-out)/100).toFixed(2);
			$("#manage1V").html(manageV+" 元");
		}
		if(($("#txtManage2").val()).length != 0){
			manage2V = getNumberInputWidgetValue("txtManage2");
			$("#manage2V").html(parseFloat(manage2V).toFixed(2)+" 元");
			$("#manage2P").html((getNumberInputWidgetValue("txtManage2")/(value-out)*100).toFixed(2)+" %");
		}else{
			$("#manage2P").html(parseFloat(manage2P).toFixed(2)+" %");
			manage2V = (manage2P*(value-out)/100).toFixed(2);
			$("#manage2V").html(manage2V+" 元");
		}
		if(($("#txtNewPay").val()).length != 0){
			payV = getNumberInputWidgetValue("txtNewPay");
			$("#pay1V").html(parseFloat(payV).toFixed(2)+" 元");
			$("#pay1P").html((getNumberInputWidgetValue("txtNewPay")/(value-out)*100).toFixed(2)+" %");
		}else{
			$("#pay1P").html(parseFloat(payP).toFixed(2)+" %");
			payV = (payP*(value-out)/100).toFixed(2);
			$("#pay1V").html(payV+" 元");
		}
		if(($("#txtNewPay2").val()).length != 0){
			pay2V = getNumberInputWidgetValue("txtNewPay2");
			$("#pay2V").html(parseFloat(pay2V).toFixed(2)+" 元");
			$("#pay2P").html((getNumberInputWidgetValue("txtNewPay2")/(value-out)*100).toFixed(2)+" %");
		}else if(pay2P >= 0){
			$("#pay2P").html(parseFloat(pay2P).toFixed(2)+" %");
			pay2V = (pay2P*(value-out)/100).toFixed(2);
			$("#pay2V").html(pay2V+" 元");
		}else{
			$("#pay2P").html("* %");
			$("#pay2V").html("* 元");
			pay2V = -1;
		}
		$("#actP").html(parseFloat(actP).toFixed(2)+" %");
		actV = (actP*(value-out)/100).toFixed(2);
		$("#actV").html(actV+" 元");
		
		$("#improveP").html(parseFloat(improveP).toFixed(2)+" %");
		improveV = (improveP*(value-out)/100).toFixed(2);
		$("#improveV").html(improveV+" 元");
		
		if(($("#txtConsult").val()).length != 0){
			consultV = getNumberInputWidgetValue("txtConsult");
			$("#consultV").html(parseFloat(consultV).toFixed(2)+" 元");
			$("#consultP").html((getNumberInputWidgetValue("txtConsult")/(value-out)*100).toFixed(2)+" %");
		}else if(consultP >= 0){
			$("#consultP").html(parseFloat(consultP).toFixed(2)+" %");
			consultV = (consultP*(value-out)/100).toFixed(2);
			$("#consultV").html(consultV+" 元");
		}else{
			$("#consultP").html("* %");
			$("#consultV").html("* 元");
			consultV = -1;
		}
		availableManageCreditV = getNumberInputWidgetValue("txtAvailableManageCredit");
		$("#aviV").html(parseFloat(availableManageCreditV).toFixed(2)+" 元");
		$("#aviP").html((getNumberInputWidgetValue("txtAvailableManageCredit")/(value-out)*100).toFixed(2)+" %");
	}
		
	//通过院系代码 获得院系PK和院系名称  //项目代码不为空时 检查项目代码和文理科是否匹配
	if(getStringInputWidgetValue("txtID").length != 0){
		departmentId = getStringInputWidgetValue("txtID").substring(0,4);
	}
	if(getStringInputWidgetValue("txtDept").length != 0){
		departmentId = getStringInputWidgetValue("txtDept");
	}
	generalAjaxCallToLoadData("acquireOneDepartmentInfoByID.action",{"departmentId":departmentId}, setDepartmentPKAndName);
	
}
function setDepartmentPKAndName(data){
	if(!data.actionStatus) {
		openGeneralMessageDialog("院系代码填写有误 请重新填写！");
	} else {
		var departmentInfo = data.jsonResult;
		departmentPK = departmentInfo.departmentPk;
		departmentName = departmentInfo.departmentName;
		departmentType2 = departmentInfo.departmentType;
		if(departmentType != departmentType2){
			openGeneralMessageDialog("项目文理科类型和院系代码(项目代码中的或者院系代码)不匹配 ，请检查后重新输入！");//检查 项目代码与项目类型是否匹配
			return;
		}
		//通过教师姓名 和 院系PK 取得教师信息，返回error 0 代表无此教师信息，error 2 代表教师名字重复
//		var parameter={};
//		parameter["teacherName"] = getStringInputWidgetValue("txtName");
//		parameter["departmentPk"] = parseInt(departmentPK);
//		generalAjaxCallToLoadData("acquireOneTeacherInfoByTeacherNameAndDepartmentPK.action",parameter,returnTeacherInfo);
		
		new Dialog({type:'id',value:'confirm'}).show();
		SetTableColor();
	}
}
//function returnTeacherInfo(data){
//	if(!data.actionStatus){
//		if(data.jsonResult.error == "0"){
//			openGeneralMessageDialog("教师信息不存在，请检查教师姓名，项目代码，院系代码！");
//			//新增教师
//			return ;
//		}else if(data.jsonResult.error == "2"){
//			openGeneralMessageDialog("教师信息存在重复，请检查教师姓名，项目代码，院系代码！");
//			return ;//同一院系教师重名 暂不处理
//		}
//	}
//	var teacherInfo = data.jsonResult;
//	teacherId = teacherInfo.teacherId;
//	
//}
function submit(){
	
	//如果 选中 第一次拨款 需要开新卡（暂时忽略手动输入项目ID的情况）
	//获取表单内容（其中teacherId，applyYear暂时留空）
	//调用原 提交项目申请的action，为Item表增加记录，状态为未审核 返回ItemPK
	//再调用 项目审核的action，把状态改成已审核。之后一步一步在提交项目 审核项目
	//如果不选中 就提交项目 审核项目
	if($("#chkNewCard:checked").val() == "on"){
		var tempFormData = acquireFormData1();
		generalAjaxCallToLoadData("submitProjectRegistrationInfo.action",tempFormData, showSubmitingResult);
	}else{
		var inAccountInfo = acquireFormData2();
		generalAjaxCallToLoadData("submitAddOutlayInfo.action", inAccountInfo, showSubmitingInAccountInfoResult);
	}
}
//反馈增加经费提交操作的状态
function showSubmitingResult(data) {
	
	if(!data.actionStatus) {
		openGeneralMessageDialog("项目信息提交失败1，请重试！");
	} else {
		//resetProjectRegistrationForm();
		var itemInfo = data.jsonResult;
		var itemPk = itemInfo.itemPk;
		itemID = itemInfo.itemId;
		generalAjaxCallToLoadData("projectInfoAuditApprove.action", {"itemPK":itemPk}, showProjectAuditResult);
	}
}
function showProjectAuditResult(data){
	if(!data.actionStatus) {
		openGeneralMessageDialog("项目信息提交失败2，请重试！");
	} else {
		//resetProjectRegistrationForm();
		var inAccountInfo = acquireFormData2();
		generalAjaxCallToLoadData("submitAddOutlayInfo.action", inAccountInfo, showSubmitingInAccountInfoResult);
	}
}
function showSubmitingInAccountInfoResult(data){
	if(!data.actionStatus) {
		openGeneralMessageDialog("入账申请记录提交失败1，请重试！");
		return false;
	}
	var addOutlayInfo = data.jsonResult;
	addOutlayPK = addOutlayInfo.addOutlayPK;
	var inAccountInfo = acquireFormData3();
	inAccountInfo["addOutlayPK"] = addOutlayPK;
	inAccountInfo["astatus"] = "31";
	generalAjaxCallToLoadData("inAccountAuditProcess.action", inAccountInfo, showInAccountAuditApprovedResult);
}
function showInAccountAuditApprovedResult(data){
	if(!data.actionStatus) {
		openGeneralMessageDialog("入账申请记录提交失败2，请重试！");
		return false;
	}
	//提交成功 是否打印？
	openGeneralMessageDialogThenGoToAddMoney("数据已成功提交，需要打印么？", openInAccountPrintPage, {});
}

//打开入账信息打印页面
function openInAccountPrintPage(parameter) {
	var detailInfoUrl = "";
	detailInfoUrl = "Page/Teacher/inAccountApplication/inAccountPrint.jsp?addOutlayPK=" + addOutlayPK + "&flag=0";
	window.open(detailInfoUrl);
}
function acquireFormData3() {
	var inAccountInfo = {};
	inAccountInfo["itemID"] = itemID;
	inAccountInfo["indirectID"] = "";//？？间接经费卡暂时留空，之后考虑
	inAccountInfo["cardID"] = itemID;
	
	inAccountInfo["pay"] = payV;
	inAccountInfo["manage"] = manageV;
	inAccountInfo["pay2"] = pay2V;
	inAccountInfo["manage2"] = manage2V;
	inAccountInfo["act"] = actV;
	inAccountInfo["improve"] = improveV;
	inAccountInfo["availableManageCredit"] = availableManageCreditV;
	inAccountInfo["consult"] = consultV;
	inAccountInfo["travelCost"] = "";//本字段不用了
	inAccountInfo["exchange"] = "";//本字段不用了
	inAccountInfo["equipment"] = "";//本字段不用了
	inAccountInfo["conference"] = "";//本字段不用了
	
	//add two new DepartmentPublic,CoProject
	inAccountInfo["departmentPublic"] = getNumberInputWidgetValue("txtDepartPublic");
	inAccountInfo["coProject"] = getNumberInputWidgetValue("txtCoProject");
	inAccountInfo["performance"] = performance;
	//txtPerformance1
	inAccountInfo["performance1"] = getStringInputWidgetValue("txtPerformance1");
	inAccountInfo["performance2"] = getStringInputWidgetValue("txtPerformance2");
	
	if(indirectValue > 0){
		inAccountInfo["sumthree"] = indirectValue;
	}
	
	inAccountInfo["departmentPay"] = getNumberInputWidgetValue("txtDepartmentPay");
	
	if($("#chkIsArt:checked").val() == "on") {
		inAccountInfo["pay3"] = getNumberInputWidgetValue("txtArtPay");
	}else if($("#chkIsScience:checked").val() == "on") {
		inAccountInfo["pay3"] = getNumberInputWidgetValue("txtSciencePay");
	}else{
		inAccountInfo["pay3"] = 0;
	}
	
	if($("#chkIsTax:checked").val() == "on") {
		inAccountInfo["isTax"] = 1;
		inAccountInfo["tax1"] = getNumberInputWidgetValue("txtTax1");
		inAccountInfo["tax2"] = getNumberInputWidgetValue("txtTax2");
		inAccountInfo["tax3"] = getNumberInputWidgetValue("txtTax3");
	} else {
		inAccountInfo["isTax"] = 0;
		inAccountInfo["tax1"] = 0;
		inAccountInfo["tax2"] = 0;
		inAccountInfo["tax3"] = 0;
	}
	
	inAccountInfo["isInvoice"] = 0;//本字段不用了
	inAccountInfo["invoiceTitle"] = "";//本字段不用了
	inAccountInfo["invoiceDetail"] = "";//本字段不用了
	
	inAccountInfo["other"] = getStringInputWidgetValue("txtOther");
	
	inAccountInfo["suggestion"] = "";//本字段不用了
	return inAccountInfo;
}
//获取入账申请表单信息
function acquireFormData2() {
	var inAccountInfo = {};
	
	inAccountInfo["addOutlayPK"] = "0";
	inAccountInfo["itemID"] = itemID;
	
	inAccountInfo["teacherName"] = getStringInputWidgetValue("txtName");
	inAccountInfo["otherTeacher"] = getStringInputWidgetValue("txtName2");
	
	inAccountInfo["typePk"] = itemTypePK;
	inAccountInfo["typeId"] = itemTypeID;
	inAccountInfo["typeName"] = itemTypeName;
	
	inAccountInfo["outlayDepartment"] = getStringInputWidgetValue("txtDP");//来款单位
	
	inAccountInfo["cardID"] = itemID;//？？经费卡号默认设置为项目代码  后面在查询数据库验证是不是所有的都是
	
	
	inAccountInfo["outlayValue"] = getNumberInputWidgetValue("txtValue");
	inAccountInfo["remitValue"] = getNumberInputWidgetValue("txtOut");
	
	inAccountInfo["bankId"] = "";//本字段不用了
	
	if($("#chkIsTax:checked").val() == "on") {
		inAccountInfo["isTax"] = 1;
		inAccountInfo["tax1"] = getNumberInputWidgetValue("txtTax1");
		inAccountInfo["tax2"] = getNumberInputWidgetValue("txtTax2");
		inAccountInfo["tax3"] = getNumberInputWidgetValue("txtTax3");
	} else {
		inAccountInfo["isTax"] = 0;
		inAccountInfo["tax1"] = 0;
		inAccountInfo["tax2"] = 0;
		inAccountInfo["tax3"] = 0;
	}
	
	inAccountInfo["isInvoice"] = 0;//本字段不用了
	inAccountInfo["invoiceTitle"] = "";//本字段不用了
	inAccountInfo["invoiceDetail"] = "";//本字段不用了
	if($("#chkNewCard:checked").val() == "on"){
		inAccountInfo["isFirstOutlay"] = 1;
	}else{
		inAccountInfo["isFirstOutlay"] = 0;
	}
	inAccountInfo["directValue"] = directValue;
	inAccountInfo["indirectValue"] = indirectValue;
	inAccountInfo["performance"] = performance;
	inAccountInfo["equipment"] = equipment;
	
	inAccountInfo["manage"] = getNumberInputWidgetValue("txtManage");
	inAccountInfo["departmentPublic"] = getNumberInputWidgetValue("txtDepartPublic");
	inAccountInfo["coProject"] = getNumberInputWidgetValue("txtCoProject");
	
	return inAccountInfo;
}

//获取入账申请表单信息
function acquireFormData1() {
	var formData = {};
	
	formData["itemPK"] = "0";
	var itemName = getStringInputWidgetValue("txtNewName");
	formData["itemName"] = itemName;
	formData["itemTypePk"] = itemTypePK;
	
	formData["itemType"] = itemTypeName;
	
	var contractID = getStringInputWidgetValue("txtContractID");
	formData["contractID"] = contractID;
	
	var isCross = $("#chkIsBroadwise:checked").val(); 
	if(isCross == "on") {
		isCross = 1;
	}else{
		isCross = 0;
	}
	formData["isCross"] = isCross;
	
	var teacherName = getStringInputWidgetValue("txtName");
	formData["teacherId"] = "";//暂时置空
	formData["teacherName"] = teacherName;
	
	formData["departmentPk"] = departmentPK;
	formData["departmentName"] = departmentName;
	formData["departmentType"] = departmentType;
	
	var itemValue = getNumberInputWidgetValue("txtTotalValue");
	formData["itemValue"] = itemValue;
	
	var timeLower = getStringInputWidgetValue("time1");
	formData["timeLower"] = timeLower;
	var timeUpper = getStringInputWidgetValue("time2");
	formData["timeUpper"] = timeUpper;
	
	var applyYear = "";//暂时置空
	formData["applyYear"] = applyYear;
	
	//参与教师的姓名数组
	var participateTeacherNameArray = new Array();
	var tempTeacherName = getStringInputWidgetValue("txtName2");
	participateTeacherNameArray.push(tempTeacherName);
	formData["participateTeacherNameArray"] = participateTeacherNameArray;
	
	formData["otherTeacher"] = tempTeacherName;
	
	//参与教师的ID数组
	var participateTeacherIDArray = new Array();
	var tempTeacherID = "";//暂时置空
	participateTeacherIDArray.push(tempTeacherID);
	formData["participateTeacherIDArray"] = participateTeacherIDArray;
	return formData;
}

//加载院系代码
function initializeDepartmentTable(data) {
	if(!data.actionStatus) {
		openGeneralMessageDialog("加载院系代码失败 请检查数据库连接");
		return false;
	}
	var jsonResult = data.jsonResult;
	var table = $("#departmentTable");
	var htm ="";
	for(var i = 0; i < jsonResult.length; i++) {
		var tempProjectType = jsonResult[i];
		
		if((i+1)%2){
			htm+="<tr>";
		}
		htm+=("<td>"+tempProjectType.departmentId+"</td><td>"+tempProjectType.departmentName+"</td><td>"+tempProjectType.departmentType+"</td>");
		if(i%2){
			htm+="</tr>";
			table.append(htm);
			htm ="";
		}
	}
}
//设置表格样式
function SetTableColor() {
    var clickClass = "";        //点击样式名
    var moveClass = "";         //鼠标经过样式名
    var clickTR = null;         //点击的行
    var moveTR = null;          //鼠标经过行
    //////////////////////////////////////////////////院系代码 可改进$($("*[id=departmentCode]")[1])
    //var Ptr = document.getElementById(TableID).getElementsByTagName("tr");
    var Ptr = $($("*[id^='dialog-']")[0]).find("tr");
    var test="";
    for (var bian = 1; bian < Ptr.length + 1; bian++) {
    	if((bian % 2 > 0)){
    		Ptr[bian - 1].className = "Rep_Tab_EvenTr";
    	}else{
    		Ptr[bian - 1].className = "Rep_Tab_OddTr";
    	}
    	test+=(bian+"!");
    }
    //设置鼠标的动作事件
    for (var i = 1; i < Ptr.length; i++) {
        //鼠标经过事件
        Ptr[i].onmouseover = function Move() {
            if (clickTR != this) {
                if (moveTR != this) {
                    moveClass = this.className;
                    moveTR = this;
                    this.className = "Rep_Tr_Move";
                }
            }
        };
        //鼠标离开事件
        Ptr[i].onmouseout = function Out() {
            if (clickTR != this) {
                moveTR = null;
                this.className = moveClass;
            }
        };
        //鼠标单击事件
        Ptr[i].onclick = function Ck() {
            if (clickTR != this) {
                if (clickTR) {
                    clickTR.className = clickClass;
                }
                clickTR = this;
                clickClass = moveClass;
            }
            this.className = "Rep_Tr_Click";
        };
    }
}   
//加载项目类型
function attachProjectType(data) {
	if(!data.actionStatus) {
		openGeneralMessageDialog("加载项目类型失败 请检查数据库连接");
		return false;
	}
	var jsonResult = data.jsonResult;
	for(var i = 0; i < jsonResult.length; i++) {
		
		var tempProjectType = jsonResult[i];
		
		var typePK = tempProjectType.typePk;
		var typeID = tempProjectType.typeId;
		var typeName = tempProjectType.typeName;
		var typeActP = tempProjectType.pact;
		var typeImproveP = tempProjectType.pimprove;
		var typeManageP = tempProjectType.pmanage;
		var typePayP = tempProjectType.ppay;
		var typeManage2P = tempProjectType.pmanage2;
		var typePay2P = tempProjectType.ppay2;
		var consultP = tempProjectType.pconsult;
		
		if(tempProjectType.departmentType == "文科"){
			tempOption = "<option value='" + typePK+"separator"+typeID +"separator"+typeActP +
				"separator"+typeImproveP + "separator"+typeManageP +"separator"+typePayP +
				"separator"+typeManage2P +"separator"+typePay2P +"separator"+consultP +
				"'>" + typeName + "</option>";
			$("#art").append(tempOption);
		}else if(tempProjectType.departmentType == "理科"){
			tempOption = "<option value='" + typePK+"separator"+typeID + "separator"+typeActP +
				"separator"+typeImproveP + "separator"+typeManageP +"separator"+typePayP +
				"separator"+typeManage2P +"separator"+typePay2P +"separator"+consultP +
				"'>" + typeName + "</option>";
			$("#science").append(tempOption);
		}
	}
}

//管理指标计算器 处理函数
function calc() {
	var bound = 10000000;//getNumberInputWidgetValue
	var directFee = $($("*[id=directFee]")[1]).val();//因为dialog复制了一个div,所以页面里有两个id为directFee的input
	var indirectFee = $($("*[id=indirectFee]")[1]).val();
	var performanceSpending = $($("*[id=performanceSpending]")[1]).val();
	var equipmentPurchaseFee = $($("*[id=equipmentPurchaseFee]")[1]).val();
	var manageFee1=0;
	var taskPerformanceSpending=0;
	var departmentPublicSpending=0;
	var taskPlanSpending=0;
	//计算 管理费1
	if(directFee-equipmentPurchaseFee > 0){
		if(directFee-equipmentPurchaseFee < bound){
			manageFee1=(directFee-equipmentPurchaseFee)*0.05;
		}else{
			manageFee1=bound*0.05 + (directFee-bound-equipmentPurchaseFee)*0.03;
		}
	}
	$($("*[id=manageFee1]")[1]).val(manageFee1);
	
	//计算 课题绩效支出
	if(performanceSpending == ""){
		taskPerformanceSpending = 0;
	}else{
		taskPerformanceSpending =  parseFloat(performanceSpending);
	}
	$($("*[id=taskPerformanceSpending]")[1]).val(taskPerformanceSpending);
	//计算 院系公共支出
	if(indirectFee-manageFee1-taskPerformanceSpending > 0){
		departmentPublicSpending = ((indirectFee-manageFee1-taskPerformanceSpending)*0.2).toFixed(2);
	}
	$($("*[id=departmentPublicSpending]")[1]).val(departmentPublicSpending);
	
	//计算 课题统筹支出
	if(indirectFee-manageFee1-taskPerformanceSpending > 0){
		taskPlanSpending = ((indirectFee-manageFee1-taskPerformanceSpending)*0.8).toFixed(2);
	}
	$($("*[id=taskPlanSpending]")[1]).val(taskPlanSpending);
}
//管理指标计算器中的 确定 
function yes() {
	var manageFee1 = $($("*[id=manageFee1]")[1]).val();
	$("#txtManage").val(parseFloat(manageFee1).toFixed(2));
	var departmentPublicSpending = $($("*[id=departmentPublicSpending]")[1]).val();
	$("#txtDepartPublic").val(parseFloat(departmentPublicSpending).toFixed(2));
	var taskPlanSpending = $($("*[id=taskPlanSpending]")[1]).val();
	$("#txtCoProject").val(parseFloat(taskPlanSpending).toFixed(2));
	var taskPerformanceSpending = $($("*[id=taskPerformanceSpending]")[1]).val();
	$("#txtPerformance1").val((taskPerformanceSpending*0.8).toFixed(2));
	$("#txtPerformance2").val((taskPerformanceSpending*0.2).toFixed(2));
	directValue = $($("*[id=directFee]")[1]).val();//因为dialog复制了一个div,所以页面里有两个id为directFee的input
	indirectValue = $($("*[id=indirectFee]")[1]).val();
	performance = $($("*[id=performanceSpending]")[1]).val();
	equipment = $($("*[id=equipmentPurchaseFee]")[1]).val();
}

//来款金额和汇出金额变化时 6个框随着变化:自行确定可用管理额度，院系公共支出，文科/理科劳务费3，税金1，税金2，税金3
function valueOrOutChange(){
	var value = parseFloat(getNumberInputWidgetValue("txtValue"));
	var out = parseFloat(getNumberInputWidgetValue("txtOut"));
	if(value > 0 && value-out < 0){
		openGeneralMessageDialog("汇出金额不能大于来款金额，请检查后重新输入");
		return;
	}
	if($("#chk_availableManageCredit").attr("checked")){
		$("#txtAvailableManageCredit").attr("value",((value-out)*0.05).toFixed(2));
	}
	if($("#chkIsBroadwise").attr("checked")){
		$("#txtDepartmentPay").attr("value",((value-out)*0.05).toFixed(2));
	}
	if($("#chkIsTax").attr("checked")){
		var tax1 = (value/1.03)* 0.03;
		var tax2 = tax1 * 0.07;
		var tax3 = tax1 * 0.05;
		$("#txtTax1").val(tax1.toFixed(2));
		$("#txtTax2").val(tax2.toFixed(2));
		$("#txtTax3").val(tax3.toFixed(2));
	}
	if($("#chkIsArt").attr("checked")){
		$("#txtArtPay").attr("value",((value-out)*0.2).toFixed(2));
	}
	if($("#chkIsScience").attr("checked")){
		$("#txtSciencePay").attr("value",((value-out)*0.2).toFixed(2));
	}
}

//得到输入框的值
function getInputWidgetValue(widgetID) {
	
	var tempValue = 0;
	
	if($("#" + widgetID).val() != "") {
		tempValue = $("#" + widgetID).val();
	}
	
	if(isNaN(parseInt(tempValue, 10))) {
		return parseInt("0");
	}
	
	return parseInt(tempValue);
}

//得到数值输入框的值
function getNumberInputWidgetValue(widgetID) {
	
	var tempValue = 0;
	
	if($("#" + widgetID).val() != "") {
		tempValue = $("#" + widgetID).val();
	}
	
	if(isNaN(parseInt(tempValue))) {
		return parseFloat("0", 2);
	}
	
	return parseFloat(tempValue, 2);
}

//得到字符输入框的值
function getStringInputWidgetValue(widgetID) {
	
	var tempValue = "";
	
	tempValue = $("#" + widgetID).val();
	
	tempValue = $.trim(tempValue);
	
	return tempValue;
}

function getLabelWidgetValue(widgetID) {
	
	var tempValue = 0;
	
	if($("#" + widgetID).html() != "") {
		tempValue = $("#" + widgetID).html();
	}
	
	if(isNaN(parseInt(tempValue, 10))) {
		return parseInt("0");
	}
	
	return parseInt(tempValue);
}

//得到下拉菜单的值
function getSelectWidgetValue(widgetID) {
	
	var tempValue = "";
	
	tempValue = $("#" + widgetID).find("option:selected").val();
	tempValue = $.trim(tempValue);
	
	return tempValue;
}

//申请创建一张新经费卡
function createNewCardIDButtonResponse() {
	
	var dialogMessageContent = "您确定要申请新经费卡么？";
	openGeneralAssureDialog(dialogMessageContent, assureCreatingNewCardID, {});
}

//确定要申请新经费卡
function assureCreatingNewCardID(parameter) {
	
	console.log("create new card id!");
	isFirstOutlay = 1;
	$("#createNewCardIDButton")[0].disabled = true;
	
	var tempOption = "<option selected value = ''>新开经费卡</option>";
	$("#cardID").append(tempOption);
	$("#cardID")[0].disabled = true;
}

//根据项目类型自动计算各种税金
function autoCalculateTaxsValue(isChecked) {
	
	//如果含有税
	if(isChecked) {
		
		var outlayValue = getNumberInputWidgetValue("outlayValue");
		
		if(outlayValue > 0) {
			
			
			var newTax1 = (outlayValue/1.03)* 0.03;
			var newTax2 = newTax1 * 0.07;
			var newTax3 = newTax1 * 0.05;
			//var newTax1 = outlayValue * (projectTypeInfo.ptax1);
			//var newTax2 = outlayValue * (projectTypeInfo.ptax2);
			//var newTax3 = outlayValue * (projectTypeInfo.ptax3);
			
			$("#tax1").val(newTax1.toFixed(2));
			$("#tax2").val(newTax2.toFixed(2));
			$("#tax3").val(newTax3.toFixed(2));
			
			//$("#tax1").val( parseInt(newTax1, 10) );
			//$("#tax2").val( parseInt(newTax2, 10) );
			//$("#tax3").val( parseInt(newTax3, 10) );
		} else {
			$("#tax1").val(0);
			$("#tax2").val(0);
			$("#tax3").val(0);
		}
	} else {
		//如果不含有税
		$("#tax1").val(0);
		$("#tax2").val(0);
		$("#tax3").val(0);
	}
}
////??来款金额和汇出金额输入框改变时的响应事件，自动计算税额
//function addoutInputWidgetOnchangeResponse() {
//	
//	var isTaxChecked = $("#taxCheck")[0].checked;
//	autoCalculateTaxsValue(isTaxChecked);
//}
//
////直接费用、间接费用计算管理费等
//function addDirectIndirectOnchangeResponse(){
//	
//	var DirectValue= getNumberInputWidgetValue("DirectValue");
//	var IndirectValue = getNumberInputWidgetValue("IndirectValue");
//	var Performance = getNumberInputWidgetValue("Performance");	
//	var Equipment = getNumberInputWidgetValue("Equipment");
//	 
//	var Manage ;
//	if((DirectValue-Equipment)<10000000){
//		Manage = ((DirectValue-Equipment)*0.05).toFixed(2);	
//	}
//	else Manage = ((DirectValue-Equipment)*0.03).toFixed(2);	
//	
//	var DepartmentPublic = ((IndirectValue-Manage-Performance)*0.2).toFixed(2);
//	var CoProject = ((IndirectValue-Manage-Performance)*0.8).toFixed(2);
//	
//	if(Manage<0) Manage = 0;
//	if(DepartmentPublic<0) DepartmentPublic = 0;
//	if(CoProject<0) CoProject = 0;
//	
//	$("#Manage").html(Manage);
//	$("#Performance2").html(Performance);
//	$("#DepartmentPublic").html(DepartmentPublic);
//	$("#CoProject").html(CoProject);
//	
//}
//
////回显各种税的比例
//function renderProportionLabel(labelID, proportion){
//	proportion = parseFloat(proportion * 100).toFixed(2);
//	//var proportionIntergerType = parseInt(proportion, 10);
//	var labelContent = "(" + proportion + "%)";
//	$("#" + labelID).html(labelContent);
//}