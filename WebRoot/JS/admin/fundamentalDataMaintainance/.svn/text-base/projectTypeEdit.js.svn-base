/*
 * @clj
 */

$(document).ready(function(){
	
	//兼容性
	consoleResponseInUnusabalEnvirenment();
	
	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"基础数据",
	                	"href":""
	                 },
	                 {
		                	"name":"项目类型",
		                	"href":"Page/Admin/fundamentalDataMaintainance/projectTypeListView.jsp"
		                 },
	                 {
	                	"name":"查看项目类型",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	//检查projectTypePK， departmentPK的值
	if(projectTypePK == undefined || projectTypePK == "" || projectTypePK == "null") {
		console.log("projectTypePK is empty!");
		departmentPK = "0";
	} 
	
	if(isModifyPage == undefined || isModifyPage == "" || isModifyPage =="null") {
		console.log("isModifyPage is empty!");
		isModifyPage = "yes";
	} 
	
	$("#cancleButton").click(function(check) {
		
		history.go(-1);
	});
	
	console.log("projectTypePK " + projectTypePK);
	
	
	//修改和添加共用一个页面
	if(isModifyPage == "yes"){
		
		$("#assureButton").html("修改");
		
		generalAjaxCallToLoadData("acquireOneProjectTypeInfoByPK.action",{"projectTypePK":projectTypePK},initializeprojectTypeForm);

	}
	else{
		$("#assureButton").html("添加");
	}
	
	//为modifyDepartmentForm表单添加验证功能
	$("#createNewDepartmentForm").validationEngine("attach");
	
	$("#pTaxCheck").change(function(event){
		
		var isDisabled = !(this.checked);
		console.log(isDisabled);
		$("#pTax1")[0].disabled = isDisabled;
		$("#pTax2")[0].disabled = isDisabled;
		$("#pTax3")[0].disabled = isDisabled;
		
	  });
	
	//点击assureButton按钮时的响应事件
    $("#assureButton").click(function(check) {
    	
    	if($("#createNewDepartmentForm").validationEngine('validate')){
    		
    		var submitData = {};
    		submitData["typeId"]                 = $("#typeID").val();
    		submitData["typeName"]               = $("#typeName").val();
    		submitData["pmanage"]                = getNumberInputWidgetValue("pManage");
    		submitData["pmanage2"]               = getNumberInputWidgetValue("pManage2");
    		submitData["ppay"]                   = getNumberInputWidgetValue("pPay");
    		if($("#pPay2").val() == "*"){
    			submitData["ppay2"]              = -1;
    		}else{
    			submitData["ppay2"]              = getNumberInputWidgetValue("pPay2");
    		}
    		if($("#pConsult").val() == "*"){
    			submitData["pconsult"]              = -1;
    		}else{
    			submitData["pconsult"]              = getNumberInputWidgetValue("pConsult");
    		}
    		submitData["pact"]                   = getNumberInputWidgetValue("pAct");
    		submitData["pimprove"]               = getNumberInputWidgetValue("pImprove");

    		var isTaxChecked = $("#pTaxCheck")[0].checked;
    		if(isTaxChecked) {
    			submitData["isTax"] = 1;
    			submitData["ptax1"] = getNumberInputWidgetValue("pTax1");
    			submitData["ptax2"] = getNumberInputWidgetValue("pTax2");
    			submitData["ptax3"] = getNumberInputWidgetValue("pTax3");
    		} else {
    			submitData["isTax"] = 0;
    			submitData["ptax1"] = 0;
    			submitData["ptax2"] = 0;
    			submitData["ptax3"] = 0;
    		}
    		
    		var isWenke = $("input[name=isWenke]:checked").val(); 
    		if(isWenke == undefined || isWenke == 0) {
    			submitData["departmentType"] = "理科";
    		}
    		else submitData["departmentType"] = "文科";
    		
        	if(isModifyPage == "yes"){
        		
        		submitData["projectTypePK "] = projectTypePK ;
        		generalAjaxCallToLoadData("modifyProjectType.action",submitData,showModdifyResult,submitData);
        	}
        	else{
        		generalAjaxCallToLoadData("addNewProjectType.action",submitData,showResult);
        	}
    		
    	 }
    	check.preventDefault();//此处阻止提交表单
    });
    
    
});

function initializeprojectTypeForm(data){
	
	console.log(data);
	if(!data.actionStatus){
		alert("获取数据失败，请返回重试。");
	}
	
	var kaige = data.jsonResult;
	
	//左边为网页的名称， 右边是完全为了配合数据库的名称
	$("#typeID").val(kaige["typeId"]);
	$("#typeName").val(kaige["typeName"]);
	$("#pManage").val(kaige["pmanage"]);
	$("#pManage2").val(kaige["pmanage2"]);
	$("#pPay").val(kaige["ppay"]);
	if(kaige["ppay2"] == -1){
		$("#pPay2").val("*");
	}else{
		$("#pPay2").val(kaige["ppay2"]);
	}
	if(kaige["pconsult"] == -1){
		$("#pConsult").val("*");
	}else{
		$("#pConsult").val(kaige["pconsult"]);
	}
	$("#pAct").val(kaige["pact"]);
	$("#pImprove").val(kaige["pimprove"]);
	
	//是否要税金
	if(kaige["isTax"] == "1"){  
		
		$("#pTaxCheck").attr('checked',true);
		$("#pTax1")[0].disabled = false;
		$("#pTax2")[0].disabled = false;
		$("#pTax3")[0].disabled = false;
		
		//左边为网页的名称， 右边是完全为了配合数据库的名称
		$("#pTax1").val(kaige["ptax1"]);
		$("#pTax2").val(kaige["ptax2"]);
		$("#pTax3").val(kaige["ptax3"]);
	}
	
	//文理科
	if(kaige["departmentType"] == "文科")
		$("#wenKe").attr('checked',true);
	
	else if(kaige["departmentType"] == "理科")	
		$("#liKe").attr('checked',true);

}


//得到数值输入框的值
function getNumberInputWidgetValue(widgetID) {
	
	var tempValue = 0;
	
	if($("#" + widgetID).val() != "") {
		tempValue = $("#" + widgetID).val();
	}
	
	if(isNaN(tempValue)) {
		return 0;
	}
	
	return tempValue;
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
		alert("操作失败，请重试！");
		return;
	}
	
	alert('操作成功！');
	history.go(-1);
	
}