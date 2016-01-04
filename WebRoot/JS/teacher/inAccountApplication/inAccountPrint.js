$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	
	
	if(addOutlayPK == undefined || addOutlayPK == null || addOutlayPK == "") {
		addOutlayPK = "0";
	}
	if(flag==0){
		//取得页面的基本信息然后回显addOutlayPK=" + addOutlayPK + "&flag="+flag
		var tempSubmitData = {"addOutlayPK":addOutlayPK};
		generalAjaxCallToLoadData("accquireAddOutlayByAddOutlayPK.action", tempSubmitData, initializePageContent);
	}else if(flag ==1){
		//取得页面的基本信息然后回显
		var tempSubmitData = {"addOutlayPK":addOutlayPK};
		generalAjaxCallToLoadData("accquireAddOutlayByAddOutlayPK2.action", tempSubmitData, initializePageContent2);
	}
	
});
function getValue(val){
	if(isNaN(val)){
		return  parseFloat(0).toFixed(2);
	}else{
		return val;
	}
}
//初始化页面，并回显入账内容
function initializePageContent2(data) {
	
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	
	
	var today = new Date();
	var year = today.getFullYear().toString().substring(2);
	$("#addOutlayYear").html(year);
	var month = today.getMonth() + 1;
	$("#addOutlayMonth").html(month);
	var day = today.getDate();
	$("#addOutlayDay").html(day);
	
	console.log(data.jsonResult);
	var inAccountInfo = data.jsonResult.addoutlayInfo;
	var oldInAccountInfo = data.jsonResult.oldAddoutlayInfo;
	//data.jsonResult.itemYearRange
	var projectTypeInfo = data.jsonResult.projectTypeInfo;//无用
	var indirectID = data.jsonResult.indirectID;//无用
	
//	$("#indirectCardID").html(indirectID);
	
	var outlayValue = inAccountInfo.outlayValue - inAccountInfo.remitValue;
	
	$("#inAccountDepartment").html(inAccountInfo.outlayDepartment);
	//outlayValue
	if(inAccountInfo.outlayValue != oldInAccountInfo.outlayValue){
		var zhengFuHao = "";
		if(inAccountInfo.outlayValue>oldInAccountInfo.outlayValue){
			zhengFuHao = "+";
		}
		$("#outlayValue").html(zhengFuHao+(inAccountInfo.outlayValue-oldInAccountInfo.outlayValue));
	}else{
		$("#outlayValue").html("-");
	}
	
	if(inAccountInfo.isFirstOutlay == 1) {
		$("#isNewCreatedCard").html("是");
	} else {
		$("#isNewCreatedCard").html("否");
	}
	//manage
	if(inAccountInfo.manage != oldInAccountInfo.manage){
		var zhengFuHao = "";
		if(inAccountInfo.manage>oldInAccountInfo.manage){
			zhengFuHao = "+";
		}
		$("#manage").html(zhengFuHao+(inAccountInfo.manage-oldInAccountInfo.manage));
	}else{
		$("#manage").html("-");
	}
	$("#manageProportionLabel").html(" ");
	//act
	if(inAccountInfo.act != oldInAccountInfo.act){
		var zhengFuHao = "";
		if(inAccountInfo.act>oldInAccountInfo.act){
			zhengFuHao = "+";
		}
		$("#act").html(zhengFuHao+(inAccountInfo.act-oldInAccountInfo.act));
	}else{
		$("#act").html("-");
	}
	$("#actProportionLabel").html(" ");
	//improve
	if(inAccountInfo.improve != oldInAccountInfo.improve){
		var zhengFuHao = "";
		if(inAccountInfo.improve>oldInAccountInfo.improve){
			zhengFuHao = "+";
		}
		$("#improve").html(zhengFuHao+(inAccountInfo.improve-oldInAccountInfo.improve));
	}else{
		$("#improve").html("-");
	}
	$("#improveProportionLabel").html(" ");
	//availableManageCredit
	if(inAccountInfo.availableManageCredit != oldInAccountInfo.availableManageCredit){
		var zhengFuHao = "";
		if(inAccountInfo.availableManageCredit>oldInAccountInfo.availableManageCredit){
			zhengFuHao = "+";
		}
		$("#availableManageCredit").html(zhengFuHao+(inAccountInfo.availableManageCredit-oldInAccountInfo.availableManageCredit));
	}else{
		$("#availableManageCredit").html("-");
	}
	$("#availableManageCreditProportionLabel").html(" ");
	$("#itemType").html(inAccountInfo.typeName);
	//departmentPay
	if(inAccountInfo.departmentPay != oldInAccountInfo.departmentPay){
		var zhengFuHao = "";
		if(inAccountInfo.departmentPay>oldInAccountInfo.departmentPay){
			zhengFuHao = "+";
		}
		$("#departmentPay").html(zhengFuHao+(inAccountInfo.departmentPay-oldInAccountInfo.departmentPay));
	}else{
		$("#departmentPay").html("-");
	}
	$("#departmentPayProportionLabel").html(" ");
	//departmentPublic
	if(inAccountInfo.departmentPublic != oldInAccountInfo.departmentPublic){
		var zhengFuHao = "";
		if(inAccountInfo.departmentPublic>oldInAccountInfo.departmentPublic){
			zhengFuHao = "+";
		}
		$("#departmentPublic").html(zhengFuHao+(inAccountInfo.departmentPublic-oldInAccountInfo.departmentPublic));
	}else{
		$("#departmentPublic").html("-");
	}
	$("#departmentPublicProportionLabel").html(" ");
	//performance2Left
	if(inAccountInfo.performance1 != oldInAccountInfo.performance1){
		var zhengFuHao = "";
		if(inAccountInfo.performance1>oldInAccountInfo.performance1){
			zhengFuHao = "+";
		}
		$("#performance2Left").html(zhengFuHao+(inAccountInfo.performance1-oldInAccountInfo.performance1));
	}else{
		$("#performance2Left").html("-");
	}
	
	if(inAccountInfo.otherTeacher == ""){
		$("#teacherName").html(inAccountInfo.teacherName);
	}else{
		$("#teacherName").html(inAccountInfo.teacherName+'  '+inAccountInfo.otherTeacher);
	}
	
	
	$("#contractID").html(inAccountInfo.itemId);
	
	var itemYearRange = data.jsonResult.itemYearRange;
	$("#itemYearRange").html(itemYearRange);
	
	//manage2
	if(inAccountInfo.manage2 != oldInAccountInfo.manage2){
		var zhengFuHao = "";
		if(inAccountInfo.manage2>oldInAccountInfo.manage2){
			zhengFuHao = "+";
		}
		$("#manage2").html(zhengFuHao+(inAccountInfo.manage2-oldInAccountInfo.manage2));
	}else{
		$("#manage2").html("-");
	}
	$("#manage2ProportionLabel").html(" ");
	//pay
	if(inAccountInfo.pay != oldInAccountInfo.pay){
		var zhengFuHao = "";
		if(inAccountInfo.pay>oldInAccountInfo.pay){
			zhengFuHao = "+";
		}
		$("#pay").html(zhengFuHao+(inAccountInfo.pay-oldInAccountInfo.pay));
	}else{
		$("#pay").html("-");
	}
	$("#payProportionLabelLabel").html(" ");
	//pay2
	if(inAccountInfo.pay2 == '-1'){
		if(oldInAccountInfo.pay2 =="-1"){
			$("#pay2").html("-");
		}else{
			//从有额度变成*
			$("#pay2").html((oldInAccountInfo.pay2).toFixed(2)+" - *");
		}
	}else{
		if(oldInAccountInfo.pay2 =="-1"){
			//从*变成有额度
			$("#pay2").html("* - "+(inAccountInfo.pay2).toFixed(2));
		}else{
			//额度变额度
			if(inAccountInfo.pay2 != oldInAccountInfo.pay2){
				var zhengFuHao = "";
				if(inAccountInfo.pay2>oldInAccountInfo.pay2){
					zhengFuHao = "+";
				}
				$("#pay2").html(zhengFuHao+(inAccountInfo.pay2-oldInAccountInfo.pay2));
			}else{
				$("#pay2").html("-");
			}
		}
	}
	$("#pay2ProportionLabelLabel").html(" ");
	//consult
	if(inAccountInfo.consult == '-1'){
		if(oldInAccountInfo.consult =="-1"){
			$("#consult").html("-");
		}else{
			//从有额度变成*
			$("#consult").html((oldInAccountInfo.consult).toFixed(2)+" - *");
		}
	}else{
		if(oldInAccountInfo.consult =="-1"){
			//从*变成有额度
			$("#consult").html("* - "+(inAccountInfo.consult).toFixed(2));
		}else{
			//额度变额度
			if(inAccountInfo.consult != oldInAccountInfo.consult){
				var zhengFuHao = "";
				if(inAccountInfo.consult>oldInAccountInfo.consult){
					zhengFuHao = "+";
				}
				$("#consult").html(zhengFuHao+(inAccountInfo.consult-oldInAccountInfo.consult));
			}else{
				$("#consult").html("-");
			}
		}
	}
	$("#consultProportionLabelLabel").html(" ");
	
	if((inAccountInfo.itemName).length < 22){
		$("#itemName").html(inAccountInfo.itemName);
	}else{
		$("#itemName").html((inAccountInfo.itemName).substring(0,21));
		$("#itemName2").html((inAccountInfo.itemName).substring(21,(inAccountInfo.itemName).length));
	}
	
	if(inAccountInfo.departmentType == "理科"){
		if(inAccountInfo.pay3 != oldInAccountInfo.pay3){
			var zhengFuHao = "";
			if(inAccountInfo.pay3>oldInAccountInfo.pay3){
				zhengFuHao = "+";
			}
			$("#pay3").html(zhengFuHao+(inAccountInfo.pay3-oldInAccountInfo.pay3));
		}else{
			$("#pay3").html("-");
		}
	}else{
		if(inAccountInfo.pay3 != oldInAccountInfo.pay3){
			var zhengFuHao = "";
			if(inAccountInfo.pay3>oldInAccountInfo.pay3){
				zhengFuHao = "+";
			}
			$("#artsPay3").html(zhengFuHao+(inAccountInfo.pay3-oldInAccountInfo.pay3));
		}else{
			$("#artsPay3").html("-");
		}
	}
	$("#pay3ProportionLabel").html(" ");
	$("#artsPay3ProportionLabel").html(" ");
	
	
	var tempTaxInfo = "";
	if(inAccountInfo.tax1 > 0) {
		if(inAccountInfo.tax1 != oldInAccountInfo.tax1){
			var zhengFuHao = "";
			if(inAccountInfo.tax1>oldInAccountInfo.tax1){
				zhengFuHao = "+";
			}
			tempTaxInfo = tempTaxInfo + (zhengFuHao+(inAccountInfo.tax1-oldInAccountInfo.tax1)) + "&nbsp;&nbsp;&nbsp;&nbsp;";
		}else{
			tempTaxInfo = tempTaxInfo + (inAccountInfo.tax1).toFixed(2) + "&nbsp;&nbsp;&nbsp;&nbsp;";
		}
	}
	if(inAccountInfo.tax2 > 0) {
		if(inAccountInfo.tax2 != oldInAccountInfo.tax2){
			var zhengFuHao = "";
			if(inAccountInfo.tax2>oldInAccountInfo.tax2){
				zhengFuHao = "+";
			}
			tempTaxInfo = tempTaxInfo + (zhengFuHao+(inAccountInfo.tax2-oldInAccountInfo.tax2)) + "&nbsp;&nbsp;&nbsp;&nbsp;";
		}else{
			tempTaxInfo = tempTaxInfo + (inAccountInfo.tax2).toFixed(2) + "&nbsp;&nbsp;&nbsp;&nbsp;";
		}
	}
	if(inAccountInfo.tax3 > 0) {
		if(inAccountInfo.tax3 != oldInAccountInfo.tax3){
			var zhengFuHao = "";
			if(inAccountInfo.tax3>oldInAccountInfo.tax3){
				zhengFuHao = "+";
			}
			tempTaxInfo = tempTaxInfo + (zhengFuHao+(inAccountInfo.tax3-oldInAccountInfo.tax3)) + "&nbsp;&nbsp;&nbsp;&nbsp;";
		}else{
			tempTaxInfo = tempTaxInfo + (inAccountInfo.tax3).toFixed(2) + "&nbsp;&nbsp;&nbsp;&nbsp;";
		}
		//tempTaxInfo = tempTaxInfo + (inAccountInfo.tax3).toFixed(2);
	}
	$("#taxInfo").html(tempTaxInfo);
	
	$("#coProjectProportionLabel").html(" ");
	//coProject
	if(inAccountInfo.coProject != oldInAccountInfo.coProject){
		var zhengFuHao = "";
		if(inAccountInfo.coProject>oldInAccountInfo.coProject){
			zhengFuHao = "+";
		}
		$("#coProject").html(zhengFuHao+(inAccountInfo.coProject-oldInAccountInfo.coProject));
		$("#sumone").html(((inAccountInfo.coProject-oldInAccountInfo.coProject)*0.4).toFixed(2));
	}else{
		$("#coProject").html("-");
		$("#sumone").html("-");
	}
	//sumone
	//performance2
	if(inAccountInfo.performance2 != oldInAccountInfo.performance2){
		var zhengFuHao = "";
		if(inAccountInfo.performance2>oldInAccountInfo.performance2){
			zhengFuHao = "+";
		}
		$("#performance2Right").html(zhengFuHao+(inAccountInfo.performance2-oldInAccountInfo.performance2));
	}else{
		$("#performance2Right").html("-");
	}
	//sumtwo
	if((inAccountInfo.coProject+inAccountInfo.performance) != (oldInAccountInfo.coProject+oldInAccountInfo.performance)){
		var zhengFuHao = "";
		if((inAccountInfo.coProject + inAccountInfo.performance)>(oldInAccountInfo.coProject + oldInAccountInfo.performance)){
			zhengFuHao = "+";
		}
		$("#sumtwo").html(zhengFuHao+(inAccountInfo.coProject - oldInAccountInfo.coProject + inAccountInfo.performance-oldInAccountInfo.performance));
	}else{
		$("#sumtwo").html("-");
	}
	
	//sumthree
	if(inAccountInfo.indirectValue != oldInAccountInfo.indirectValue){
		var zhengFuHao = "";
		if(inAccountInfo.indirectValue>oldInAccountInfo.indirectValue){
			zhengFuHao = "+";
		}
		$("#sumthree").html(zhengFuHao+(inAccountInfo.indirectValue-oldInAccountInfo.indirectValue));
	}else{
		$("#sumthree").html("-");
	}
	var tempOther = "";
	if(inAccountInfo.remitValue > 0){
		tempOther = tempOther + "汇出金额："+ (inAccountInfo.remitValue).toFixed(2) + "元<br/>&nbsp;&nbsp;&nbsp;&nbsp;";
	}
	if(inAccountInfo.remark.length > 0){
		tempOther = tempOther + "修改备注："+inAccountInfo.remark+ "<br/>&nbsp;&nbsp;&nbsp;&nbsp;";
	}
	
	tempOther = tempOther + inAccountInfo.other;
	$("#comment").html(tempOther);
	if(inAccountInfo.operatorId == "123"){
		$("#jbr").html("盛少聪");
	}else if(inAccountInfo.operatorId == "111"){
		$("#jbr").html("无效-程序员测试");
	}else if(inAccountInfo.operatorId == "11"){
		$("#jbr").html("无效-程序员测试");
	}else if(inAccountInfo.operatorId == "002725"){
		$("#jbr").html("孙旭");
	}else{
		$("#jbr").html(inAccountInfo.operatorId+"（该管理员为新添加的，请联系程序员关联姓名）");
	}
	
	
}
//初始化页面，并回显入账内容
function initializePageContent(data) {
	
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	
	
	var today = new Date();
	var year = today.getFullYear().toString().substring(2);
	$("#addOutlayYear").html(year);
	var month = today.getMonth() + 1;
	$("#addOutlayMonth").html(month);
	var day = today.getDate();
	$("#addOutlayDay").html(day);
	
	console.log(data.jsonResult);
	var inAccountInfo = data.jsonResult.addoutlayInfo;
	//data.jsonResult.itemYearRange
	var projectTypeInfo = data.jsonResult.projectTypeInfo;//无用
	var indirectID = data.jsonResult.indirectID;//无用
	
//	$("#indirectCardID").html(indirectID);
	
	var outlayValue = inAccountInfo.outlayValue - inAccountInfo.remitValue;
	
	$("#inAccountDepartment").html(inAccountInfo.outlayDepartment);
	$("#outlayValue").html((inAccountInfo.outlayValue).toFixed(2));
	
	if(inAccountInfo.isFirstOutlay == 1) {
		$("#isNewCreatedCard").html("是");
	} else {
		$("#isNewCreatedCard").html("否");
	}
	
	var manageProportion = parseFloat((inAccountInfo.manage * 100)/outlayValue).toFixed(2);
	$("#manageProportionLabel").html(getValue(manageProportion));
	$("#manage").html((inAccountInfo.manage).toFixed(2));
	
	var actProportion = parseFloat((inAccountInfo.act * 100)/outlayValue).toFixed(2);
	$("#actProportionLabel").html(getValue(actProportion));
	$("#act").html((inAccountInfo.act).toFixed(2));
	
	var improveProportion = parseFloat((inAccountInfo.improve * 100)/outlayValue).toFixed(2);
	$("#improveProportionLabel").html(getValue(improveProportion));
	$("#improve").html((inAccountInfo.improve).toFixed(2));
	
	var availableManageCreditProportion = parseFloat((inAccountInfo.availableManageCredit * 100)/outlayValue).toFixed(2);
	$("#availableManageCreditProportionLabel").html(getValue(availableManageCreditProportion));
	$("#availableManageCredit").html((inAccountInfo.availableManageCredit).toFixed(2));
	
	$("#itemType").html(inAccountInfo.typeName);
	
	var departmentPayProportion = parseFloat((inAccountInfo.departmentPay * 100)/outlayValue).toFixed(2);
	$("#departmentPayProportionLabel").html(getValue(departmentPayProportion));
	$("#departmentPay").html((inAccountInfo.departmentPay).toFixed(2));
	
	var departmentPublicProportion = parseFloat((inAccountInfo.departmentPublic * 100)/outlayValue).toFixed(2);
	$("#departmentPublicProportionLabel").html(getValue(departmentPublicProportion));
	$("#departmentPublic").html((inAccountInfo.departmentPublic).toFixed(2));
	
	$("#performance2Left").html((inAccountInfo.performance1).toFixed(2));
	if(inAccountInfo.otherTeacher == ""){
		$("#teacherName").html(inAccountInfo.teacherName)
	}else{
		$("#teacherName").html(inAccountInfo.teacherName+'  '+inAccountInfo.otherTeacher);
	}
	
	
	$("#contractID").html(inAccountInfo.itemId);
	
	var itemYearRange = data.jsonResult.itemYearRange;
	$("#itemYearRange").html(itemYearRange);
	
	var manage2Proportion = parseFloat((inAccountInfo.manage2 * 100)/outlayValue).toFixed(2);
	$("#manage2ProportionLabel").html(getValue(manage2Proportion));
	$("#manage2").html((inAccountInfo.manage2).toFixed(2));

	var payProportion = parseFloat((inAccountInfo.pay * 100)/outlayValue).toFixed(2);
	$("#payProportionLabel").html(getValue(payProportion));
	$("#pay").html((inAccountInfo.pay).toFixed(2));
	
	if(inAccountInfo.pay2 == '-1'){
		$("#pay2ProportionLabel").html("*");
		$("#pay2").html("*");
	}else{
		var pay2Proportion = parseFloat((inAccountInfo.pay2 * 100)/outlayValue).toFixed(2);
		$("#pay2ProportionLabel").html(getValue(pay2Proportion));
		$("#pay2").html((inAccountInfo.pay2).toFixed(2));
	}
	
	if(inAccountInfo.consult == '-1'){
		$("#consultProportionLabel").html("*");
		$("#consult").html("*");
	}else{
		var consultProportion = parseFloat((inAccountInfo.consult * 100)/outlayValue).toFixed(2);
		$("#consultProportionLabel").html(getValue(consultProportion));
		$("#consult").html((inAccountInfo.consult).toFixed(2));
	}
	if((inAccountInfo.itemName).length < 22){
		$("#itemName").html(inAccountInfo.itemName);
	}else{
		$("#itemName").html((inAccountInfo.itemName).substring(0,21));
		$("#itemName2").html((inAccountInfo.itemName).substring(21,(inAccountInfo.itemName).length));
	}
	
	
	var pay3Proportion = parseFloat((inAccountInfo.pay3 * 100)/outlayValue).toFixed(2);
	if(inAccountInfo.departmentType == "理科"){
		$("#pay3ProportionLabel").html($("#pay3ProportionLabel").html()+" "+getValue(pay3Proportion));
		$("#pay3").html($("#pay3").val()+" "+(inAccountInfo.pay3).toFixed(2));
	}else{
		$("#artsPay3ProportionLabel").html($("#artsPay3ProportionLabel").html()+" "+getValue(pay3Proportion));
		$("#artsPay3").html($("#artsPay3").val()+" "+(inAccountInfo.pay3).toFixed(2));
	}
	
	var tempTaxInfo = "";
	if(inAccountInfo.tax1 > 0) {
		tempTaxInfo = tempTaxInfo + (inAccountInfo.tax1).toFixed(2) + "&nbsp;&nbsp;&nbsp;&nbsp;";
	}
	
	if(inAccountInfo.tax2 > 0) {
		tempTaxInfo = tempTaxInfo + (inAccountInfo.tax2).toFixed(2) + "&nbsp;&nbsp;&nbsp;&nbsp;";
	}
	
	if(inAccountInfo.tax3 > 0) {
		tempTaxInfo = tempTaxInfo + (inAccountInfo.tax3).toFixed(2);
	}
	$("#taxInfo").html(tempTaxInfo);
	
	var coProjectProportion = parseFloat((inAccountInfo.coProject * 100)/outlayValue).toFixed(2);
	$("#coProjectProportionLabel").html(getValue(coProjectProportion));
	$("#coProject").html((inAccountInfo.coProject).toFixed(2));
	$("#sumone").html((inAccountInfo.coProject*0.4).toFixed(2));
	
	$("#performance2Right").html((inAccountInfo.performance2).toFixed(2));
	$("#sumtwo").html((inAccountInfo.coProject + inAccountInfo.performance).toFixed(2));
	$("#sumthree").html((inAccountInfo.indirectValue).toFixed(2));
	
	var tempOther = "";
	if(inAccountInfo.remitValue > 0){
		tempOther = tempOther + "汇出金额："+ (inAccountInfo.remitValue).toFixed(2) + "元<br/>&nbsp;&nbsp;&nbsp;&nbsp;";
	}
	if(inAccountInfo.remark.length > 0){
		tempOther = tempOther + "修改备注："+inAccountInfo.remark+ "<br/>&nbsp;&nbsp;&nbsp;&nbsp;";
	}
	
	tempOther = tempOther + inAccountInfo.other;
	$("#comment").html(tempOther);
//	if(inAccountInfo.operatorId == "123"){
//		$("#jbr").html("盛少聪");
//	}else if(inAccountInfo.operatorId == "111"){
//		$("#jbr").html("无效-程序员测试");
//	}else if(inAccountInfo.operatorId == "11"){
//		$("#jbr").html("无效-程序员测试");
//	}else if(inAccountInfo.operatorId == "002725"){
//		$("#jbr").html("孙旭");
//	}else{
//		$("#jbr").html(inAccountInfo.operatorId+"（该管理员为新添加的，请联系程序员关联姓名）");
//	}
	
	
}