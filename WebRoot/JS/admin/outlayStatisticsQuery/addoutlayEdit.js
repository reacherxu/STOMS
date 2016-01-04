var departmentName;
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
	

	/******************************* 初始化 自行确定可用管理额度 开始****************************************/
	$("#chk_availableManageCredit").change(function(event){
		if(this.checked){//自行确定可用管理额度 可用
			$("#txtAvailableManageCredit").attr("disabled",false);
			valueOrOutChange();
		}else{//自行确定可用管理额度 不可用
			$("#txtAvailableManageCredit").attr("disabled",true);
			$("#txtAvailableManageCredit").val("0");
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
	/******************************* 初始化 是否横向项目 结束****************************************/
	$("#deleteButton").click(function(check) {
		if(confirm("确定删除吗？") == false) return;
		generalAjaxCallToLoadData("deleteAddoutlay.action",{"addoutlayPK":addOutlayPK},DeleteStatus);
	});
	
	//为modifyDepartmentForm表单添加验证功能
	$("#editAddoutlayForm").validationEngine("attach");
	
	if(isModifyPage == "yes"){
		
		$("#assureButton").html("修改");
//		$("#itemid").attr("disabled",true);
//		$("#departmentid").attr("disabled",true);
//		$("#departmentname").attr("disabled",true);
//		$("#departmenttype").attr("disabled",true);
//		$("#cardid").attr("disabled",true);
	}
	else{
		$("#assureButton").html("添加");	
	}
	//点击assureButton按钮时的响应事件
    $("#assureButton").click(function(check) {
    	
    	if($("#editAddoutlayForm").validationEngine('validate')){
    		
    		var submitData = {};

    		submitData["outlayDepartment"] = $("#txtDP").val();
    		submitData["teacherName"] = $("#txtName").val();
    		submitData["otherTeacher"] = $("#txtName2").val();
    		submitData["outlayValue"] = getNumberInputWidgetValue("txtValue");
    		submitData["itemId"] = $("#txtID").val();
    		submitData["cardId"] = $("#txtID").val();
    		
    		submitData["departmentId"] = ($("#txtID").val()).substring(0,4);
    		submitData["departmentName"] = departmentName;
    		
    		if($("#science").attr("disabled") && !($("#art").attr("disabled"))){
    			itemTypePK = ($("#art").val()).split("separator")[0];
    			itemTypeID = ($("#art").val()).split("separator")[1];
    			itemTypeName = $("#art option:selected").text();
    			departmentType = "文科";
    			
    			submitData["departmentType"] = departmentType;
    			submitData["typePk"] = itemTypePK;
        		submitData["typeId"] = itemTypeID;
        		submitData["typeName"] = itemTypeName;
    		}else if($("#art").attr("disabled") && !($("#science").attr("disabled"))){
    			itemTypePK = ($("#science").val()).split("separator")[0];
    			itemTypeName = $("#science option:selected").text();
    			itemTypeID = ($("#science").val()).split("separator")[1];
    			departmentType = "理科";
    			
    			submitData["departmentType"] = departmentType;
    			submitData["typePk"] = itemTypePK;
        		submitData["typeId"] = itemTypeID;
        		submitData["typeName"] = itemTypeName;
    		}else{
    			openGeneralMessageDialog("请选择项目类型！");
    			return;
    		}
    		
    		submitData["remitValue"] = getNumberInputWidgetValue("txtOut");
    		submitData["other"] = $("#txtOther").val();
    		
    		submitData["pay"] = getNumberInputWidgetValue("txtNewPay");
    		submitData["manage"] = getNumberInputWidgetValue("txtManage");
    		if($("#txtNewPay2").val() != "*"){
    			submitData["pay2"] = getNumberInputWidgetValue("txtNewPay2");
    		}else{
    			submitData["pay2"] = -1;
    		}
    		submitData["manage2"] = getNumberInputWidgetValue("txtManage2");
    		submitData["availableManageCredit"] = getNumberInputWidgetValue("txtAvailableManageCredit");
    		if($("#txtConsult").val() != "*"){
    			submitData["consult"] = getNumberInputWidgetValue("txtConsult");
    		}else{
    			submitData["consult"] = -1;
    		}
    		submitData["act"] = getNumberInputWidgetValue("txtAct");
    		submitData["improve"] = getNumberInputWidgetValue("txtImprove");
    		
    		submitData["directValue"] = getNumberInputWidgetValue("directFee");
    		submitData["indirectValue"] = getNumberInputWidgetValue("indirectFee");
    		submitData["performance"] = getNumberInputWidgetValue("performanceSpending");
    		submitData["equipment"] = getNumberInputWidgetValue("equipmentPurchaseFee");
    		
    		submitData["departmentPublic"] = getNumberInputWidgetValue("txtDepartPublic");
    		submitData["coProject"] = getNumberInputWidgetValue("txtCoProject");
    		submitData["performance1"] = getNumberInputWidgetValue("txtPerformance1");
    		submitData["performance2"] = getNumberInputWidgetValue("txtPerformance2");
    		
    		if($("#chkIsBroadwise:checked").val() == "on") {
    			submitData["isCross"] = 1;
    			submitData["departmentPay"] = getNumberInputWidgetValue("txtDepartmentPay");
    			if($("#chkIsArt:checked").val() == "on"){
    				submitData["pay3"] = getNumberInputWidgetValue("txtArtPay");
    			}else{
    				submitData["pay3"] = getNumberInputWidgetValue("txtSciencePay");
    			}
    		}else{
    			submitData["isCross"] = 0;
    			submitData["departmentPay"] = 0;
    			submitData["pay3"] = 0;
    		}
    		
    		if($("#chkIsTax:checked").val() == "on") {
    			submitData["isTax"] = 1;
    			submitData["tax1"] = getNumberInputWidgetValue("txtTax1");
        		submitData["tax2"] = getNumberInputWidgetValue("txtTax2");
        		submitData["tax3"] = getNumberInputWidgetValue("txtTax3");
    		} else {
    			submitData["isTax"] = 0;
    			submitData["tax1"] = 0;
        		submitData["tax2"] = 0;
        		submitData["tax3"] = 0;
    		}
    		submitData["remark"] = $("#remark").val();
    		
    		console.log("submitData");
    		console.log(submitData);
    		
        	if(isModifyPage == "yes"){
        		submitData["addoutlayPK"] = addOutlayPK;
        		generalAjaxCallToLoadData("modifyAddoutlay.action",submitData,showModdifyResult);
        	}
        	else{
        		generalAjaxCallToLoadData("addNewAdmin.action",submitData,showResult);
        	}
        	
    	}
    });
    $("#showHistory").click(function(check) {
    	var tempSubmitData = {"addOutlayPK":addOutlayPK};
    	generalAjaxCallToLoadData("accquireOldAddoutlaysByAddoutlayPK.action",tempSubmitData,handle);
    });
	
});

function openInAccountPrintPage() {
	var detailInfoUrl = "";
	detailInfoUrl = "Page/Teacher/inAccountApplication/inAccountPrint.jsp?addOutlayPK=" + addOutlayPK + "&flag=0";
	window.open(detailInfoUrl);
}
function openInAccountPrintPage2() {
	var detailInfoUrl = "";
	detailInfoUrl = "Page/Teacher/inAccountApplication/inAccountPrint.jsp?addOutlayPK=" + addOutlayPK + "&flag=1";
	window.open(detailInfoUrl);
}
function DeleteStatus(data){
	if(!data.actionStatus) {
		alert("删除失败！");
	} else {
		alert("删除成功！");
		history.go(-1);
	}
}

//function processDelete(data){
//	if(!data.actionStatus) {
//		alert("获取该itemid的数据时失败！");
//	} else {
//		var inAccountApplicationList = data.jsonResult.inAcccountListInfo;
//		if(inAccountApplicationList.length == 0){
//			//删除操作
//			generalAjaxCallToLoadData("deleteItem.action",{"itemPK":itemPK},DeleteStatus);
//		}else{
//			alert("该项目还有"+inAccountApplicationList.length+"个项目经费，不能删除！");
//		}
//	}
//}

function adjustDepartment(){
	departmentId = ($("#txtID").val()).substring(0,4);
	generalAjaxCallToLoadData("acquireOneDepartmentInfoByID.action",{"departmentId":departmentId}, setDepartmentName);
}

function showModdifyResult(data){
	if(!data.actionStatus) {
//		alert("更新失败！");
		var jsonR = data.jsonResult;
		if(jsonR.equal == 1){
			alert("没有改变,无需更新！");
		}else{
			alert("更新失败！");
		}
	} else {
		alert("更新成功！");
	}
}

function setDepartmentName(data){
	if(!data.actionStatus) {
		alert("项目代码填写有误 请重新填写！");
	} else {
		var departmentInfo = data.jsonResult;
		departmentName = departmentInfo.departmentName;
		return;
	}
}

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
	
	//document.write(data.jsonResult["departmentType"]);
	
	var kaige = data.jsonResult;
	$("#txtDP").val(kaige["outlayDepartment"]);
	$("#txtName").val(kaige["teacherName"]);
	$("#txtName2").val(kaige["otherTeacher"]);
	$("#txtValue").val((kaige["outlayValue"]).toFixed(2));
	$("#txtID").val(kaige["itemId"]);//项目代码
	//项目类型 art science departmentType
	//<option>备选类型</option>
	//$("#science option:contains('备用类型2')").attr('selected', true);
	//$("#science <option>备选类型2</option>").attr("selected", true);
	//$("#science").get(0).selectedIndex=1;
	//var checkText=$("#science").find("option:selected").text(); 
	//$("#science option:contains('备用类型2')").attr("selected", true);
	if(kaige["departmentType"] == "理科"){
		$("#science option:contains('"+kaige["typeName"]+"')").attr("selected", true);
		//$("#science option[text='备选类型']").attr("selected", true);
		$("#art").attr("disabled",true);
	}else{
		$("#art option:contains('"+kaige["typeName"]+"')").attr("selected", true);
		$("#science").attr("disabled",true);
	}
	$("#txtOut").val((kaige["remitValue"]).toFixed(2));
	$("#txtOther").val(kaige["other"]);
	$("#txtNewPay").val((kaige["pay"]).toFixed(2));
	$("#txtManage").val((kaige["manage"]).toFixed(2));
	if(kaige["pay2"] == "-1"){
		$("#txtNewPay2").val("*");
	}else{
		$("#txtNewPay2").val((kaige["pay2"]).toFixed(2));//-1的情况 显示*
	}
	$("#txtManage2").val((kaige["manage2"]).toFixed(2));
	if(kaige["availableManageCredit"] == '0'){
		$("#txtAvailableManageCredit").attr("disabled",true);
		$("#chk_availableManageCredit").attr("checked", false);
	}else{
		$("#txtAvailableManageCredit").attr("disabled",false);
		$("#chk_availableManageCredit").attr("checked", true);
	}
	$("#txtAvailableManageCredit").val((kaige["availableManageCredit"]).toFixed(2));
	if(kaige["consult"] == "-1"){
		$("#txtConsult").val("*");
	}else{
		$("#txtConsult").val((kaige["consult"]).toFixed(2));//-1的情况 显示*
	}
	$("#txtAct").val((kaige["act"]).toFixed(2));
	$("#txtImprove").val((kaige["improve"]).toFixed(2));
	
	$("#directFee").val((kaige["directValue"]).toFixed(2));
	$("#indirectFee").val((kaige["indirectValue"]).toFixed(2));
	$("#performanceSpending").val((kaige["performance"]).toFixed(2));
	$("#equipmentPurchaseFee").val((kaige["equipment"]).toFixed(2));
	
	$("#txtDepartPublic").val((kaige["departmentPublic"]).toFixed(2));
	$("#txtCoProject").val((kaige["coProject"]).toFixed(2));
	$("#txtPerformance1").val((kaige["performance1"]).toFixed(2));
	$("#txtPerformance2").val((kaige["performance2"]).toFixed(2));
	if(kaige["isCross"] == 0){
		$("#chkIsBroadwise").attr("checked", false);//纵向
	}else{
		$("#chkIsBroadwise").attr("checked", true);//横向
		$("#row1").show();
		$("#row2").show();
		$("#row3").show();
		$("#txtDepartmentPay").attr("disabled", false);
		$("#chkIsArt").attr("disabled", false);
		$("#chkIsTax").attr("disabled", false);
		$("#chkIsScience").attr("disabled", false);
		$("#txtDepartmentPay").val((kaige["departmentPay"]).toFixed(2));
		if(kaige["departmentType"] == "理科"){
			$("#chkIsArt").attr("checked", false);
			$("#chkIsScience").attr("checked", true);
			$("#txtSciencePay").attr("disabled", false);
			$("#txtSciencePay").val((kaige["pay3"]).toFixed(2));
			$("#txtArtPay").val("");
		}else{
			$("#chkIsScience").attr("checked", false);
			$("#chkIsArt").attr("checked", true);
			$("#txtArtPay").attr("disabled", false);
			$("#txtArtPay").val((kaige["pay3"]).toFixed(2));
			$("#txtSciencePay").val("");
		}
		if(kaige["isTax"] != 0){//有税金
			$("#chkIsTax").attr("checked", true);
			$("#txtTax1").attr("disabled", false);
			$("#txtTax2").attr("disabled", false);
			$("#txtTax3").attr("disabled", false);
			$("#txtTax1").val((kaige["tax1"]).toFixed(2));
			$("#txtTax2").val((kaige["tax2"]).toFixed(2));
			$("#txtTax3").val((kaige["tax3"]).toFixed(2));
		}
	}
	$("#remark").val(kaige["remark"]);
	//addOutlayPK = kaige["addOutlayPk"];
	adjustDepartment();//取得院系name，赋值给全局变量
}
//管理指标计算器 处理函数
function calc() {
	var bound = 10000000;//getNumberInputWidgetValue
	var directFee = getNumberInputWidgetValue("directFee");
	var indirectFee =  getNumberInputWidgetValue("indirectFee");
	var performanceSpending = getNumberInputWidgetValue("performanceSpending");
	var equipmentPurchaseFee = getNumberInputWidgetValue("equipmentPurchaseFee");
	var manageFee1=0;
	var taskPerformanceSpending=performanceSpending;
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
	$("#txtManage").val(manageFee1.toFixed(2));
	
	//计算 课题绩效支出
	$("#txtPerformance1").val((performanceSpending*0.8).toFixed(2));
	$("#txtPerformance2").val((performanceSpending*0.2).toFixed(2));
	//计算 院系公共支出
	if(indirectFee-manageFee1-taskPerformanceSpending > 0){
		departmentPublicSpending = ((indirectFee-manageFee1-taskPerformanceSpending)*0.2).toFixed(2);
	}
	$("#txtDepartPublic").val(departmentPublicSpending);
	
	//计算 课题统筹支出
	if(indirectFee-manageFee1-taskPerformanceSpending > 0){
		taskPlanSpending = ((indirectFee-manageFee1-taskPerformanceSpending)*0.8).toFixed(2);
	}
	$("#txtCoProject").val(taskPlanSpending);
}
//来款金额和汇出金额变化时 6个框随着变化:自行确定可用管理额度，院系公共支出，文科/理科劳务费3，税金1，税金2，税金3
function valueOrOutChange(){
	var value = parseFloat(getNumberInputWidgetValue("txtValue"));
	var out = parseFloat(getNumberInputWidgetValue("txtOut"));
	if(value >0 && value-out < 0){
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

//得到数值输入框的值
function getNumberInputWidgetValue(widgetID) {
	
	var tempValue = 0;
	
	if($("#" + widgetID).val() != "") {
		tempValue = $("#" + widgetID).val();
	}
	
	if(isNaN(parseFloat(tempValue))) {
		return parseFloat("0");
	}
	
	return parseFloat(tempValue);
}

//得到字符输入框的值
function getStringInputWidgetValue(widgetID) {
	
	var tempValue = "";
	
	tempValue = $("#" + widgetID).val();
	
	tempValue = $.trim(tempValue);
	
	return tempValue;
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
	generalAjaxCallToLoadData("acquireOneAddoutlayInfo.action",{"addoutlayPK":addOutlayPK},initializeModdifyPage);
}

function getChanges(tempInfo){
	var changes="";
	if(tempInfo.outlayValue != getNumberInputWidgetValue("txtValue")){
		var change="";
		change = "来款金额："+tempInfo.outlayValue;
		change+=";  ";
		changes+=change;
	}
	if(tempInfo.remitValue != getNumberInputWidgetValue("txtOut")){
		var change="";
		change = "汇出金额："+tempInfo.remitValue;
		change+=";  ";
		changes+=change;
	}
	if(tempInfo.other != getStringInputWidgetValue("txtOther")){
		var change="";
		change = "其它说明："+tempInfo.other;
		change+=";  ";
		changes+=change;
	}
	if(tempInfo.pay != getNumberInputWidgetValue("txtNewPay")){
		var change="";
		change = "劳务费1："+tempInfo.pay;
		change+=";  ";
		changes+=change;
	}
	if(tempInfo.manage != getNumberInputWidgetValue("txtManage")){
		var change="";
		change = "管理费1："+tempInfo.manage;
		change+=";  ";
		changes+=change;
	}
	//pay2
	if("*" == getStringInputWidgetValue("txtNewPay2")){
		var change="";
		if(tempInfo.pay2 == -1){
			//相同 不操作
		}else{
			change = "劳务费2："+tempInfo.pay2;
			change+=";  ";
		}
		changes+=change;
	}else{//界面上得到的是数字
		var change="";
		if(tempInfo.pay2 == -1){
			//不相同
			change = "劳务费2：*";
			change+=";  ";
		}else{
			if(tempInfo.pay2 == getNumberInputWidgetValue("txtNewPay2")){
				//都是数字且相同不操作
			}else{
				change = "劳务费2："+tempInfo.pay2;
				change+=";  ";
			}
		}
		changes+=change;
	}
	if(tempInfo.manage2 != getNumberInputWidgetValue("txtManage2")){
		var change="";
		change = "管理费2："+tempInfo.manage2;
		change+=";  ";
		changes+=change;
	}
	if(tempInfo.availableManageCredit != getNumberInputWidgetValue("txtAvailableManageCredit")){
		var change="";
		change = "可用管理额度："+tempInfo.availableManageCredit;
		change+=";  ";
		changes+=change;
	}
	//consult
	if("*" == getStringInputWidgetValue("txtConsult")){
		var change="";
		if(tempInfo.consult == -1){
			//相同 不操作
		}else{
			change = "专家咨询费："+tempInfo.consult;
			change+=";  ";
		}
		changes+=change;
	}else{//界面上得到的是数字
		var change="";
		if(tempInfo.consult == -1){
			//不相同
			change = "专家咨询费：*";
			change+=";  ";
		}else{
			if(tempInfo.consult == getNumberInputWidgetValue("txtConsult")){
				//都是数字且相同不操作
			}else{
				change = "专家咨询费："+tempInfo.consult;
				change+=";  ";
			}
		}
		changes+=change;
	}
	if(tempInfo.act != getNumberInputWidgetValue("txtAct")){
		var change="";
		change = "业务活动费："+tempInfo.act;
		change+=";  ";
		changes+=change;
	}
	if(tempInfo.improve != getNumberInputWidgetValue("txtImprove")){
		var change="";
		change = "改善工作条件费："+tempInfo.improve;
		change+=";  ";
		changes+=change;
	}
	if(tempInfo.directValue != getNumberInputWidgetValue("directFee")){
		var change="";
		change = "直接费用："+tempInfo.directValue;
		change+=";  ";
		changes+=change;
	}
	if(tempInfo.indirectValue != getNumberInputWidgetValue("indirectFee")){
		var change="";
		change = "间接费用："+tempInfo.indirectValue;
		change+=";  ";
		changes+=change;
	}
	if(tempInfo.performance != getNumberInputWidgetValue("performanceSpending")){
		var change="";
		change = "绩效支出："+tempInfo.performance;
		change+=";  ";
		changes+=change;
	}
	if(tempInfo.equipment != getNumberInputWidgetValue("equipmentPurchaseFee")){
		var change="";
		change = "设备购置费："+tempInfo.equipment;
		change+=";  ";
		changes+=change;
	}
	if(tempInfo.departmentPublic != getNumberInputWidgetValue("txtDepartPublic")){
		var change="";
		change = "院系公共支出："+tempInfo.departmentPublic;
		change+=";  ";
		changes+=change;
	}
	if(tempInfo.coProject != getNumberInputWidgetValue("txtCoProject")){
		var change="";
		change = "课题统筹支出："+tempInfo.coProject;
		change+=";  ";
		changes+=change;
	}
	if(tempInfo.performance1 != getNumberInputWidgetValue("txtPerformance1")){
		var change="";
		change = "绩效(80%)："+tempInfo.performance1;
		change+=";  ";
		changes+=change;
	}
	if(tempInfo.performance2 != getNumberInputWidgetValue("txtPerformance2")){
		var change="";
		change = "绩效(20%)："+tempInfo.performance2;
		change+=";  ";
		changes+=change;
	}
	if(tempInfo.departmentPay != getNumberInputWidgetValue("txtDepartmentPay")){
		var change="";
		change = "院系酬金："+tempInfo.departmentPay;
		change+=";  ";
		changes+=change;
	}
	if(getNumberInputWidgetValue("txtArtPay")!=0){
		if(tempInfo.pay3 != getNumberInputWidgetValue("txtArtPay")){
			var change="";
			change = "文科劳务费："+tempInfo.pay3;
			change+=";  ";
			changes+=change;
		}
	}else if(getNumberInputWidgetValue("txtSciencePay")!=0){
		if(tempInfo.pay3 != getNumberInputWidgetValue("txtSciencePay")){
			var change="";
			change = "理科劳务费："+tempInfo.pay3;
			change+=";  ";
			changes+=change;
		}
	}
	
	if(tempInfo.tax1 != getNumberInputWidgetValue("txtTax1")){
		var change="";
		change = "税金1："+tempInfo.tax1;
		change+=";  ";
		changes+=change;
	}
	if(tempInfo.tax2 != getNumberInputWidgetValue("txtTax2")){
		var change="";
		change = "税金2："+tempInfo.tax2;
		change+=";  ";
		changes+=change;
	}
	if(tempInfo.tax3 != getNumberInputWidgetValue("txtTax3")){
		var change="";
		change = "税金3："+tempInfo.tax3;
		change+=";  ";
		changes+=change;
	}
	if(tempInfo.remark != getStringInputWidgetValue("remark")){
		var change="";
		change = "修改备注："+tempInfo.remark;
		change+=";  ";
		changes+=change;
	}
	
	return changes;
}

function handle(data){
	if(!data.actionStatus) {
		alert("该次入账没有历史信息！");
	} else {
		var list = data.jsonResult;
		$("#history").html("");
		for(var i = list.length-1; i >=0  ; i--) {
			
			var tempInfo = list[i];
			var changes = getChanges(tempInfo);
			if(changes.length == 0){
				changes = "相对于无变化   ";
				$("#history").append("<tr><td>"+changes+"</td><td>入账时间:"+tempInfo.outlayTime+"</td></tr>");
			}else{
				$("#history").append("<tr><td>"+changes+"</td><td>入账时间:"+tempInfo.outlayTime+"</td></tr>");
			}
			
//			tempRowData.push(tempInfo.addOutlayPk);
//			tempRowData.push(tempInfo.itemId);
//			tempRowData.push(tempInfo.cardId);
//			tempRowData.push(tempInfo.itemName);
//			tempRowData.push(tempInfo.teacherName);
//			tempRowData.push(tempInfo.contractId);
//			tempRowData.push(tempInfo.outlayValue);
//			tempRowData.push(tempInfo.remitValue);
//			tempRowData.push(tempInfo.outlayDepartment);
//			tempRowData.push(tempInfo.outlayTime);
//			tempRowData.push(tempInfo.astatus);
			
		}
		return;
	}
}