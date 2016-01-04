$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"我的项目",
	                	"href":"Page/Teacher/projectManagement/projectRegistrationList.jsp"
	                 },
	                 {
		                	"name":"支出登记历史",
		                	"href":"Page/Teacher/payRegistration/nationalFundOutlayList.jsp?itemPK=" + itemPK
		             },
	                 {
	                	"name":"支出登记",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	console.log("nationalFundOutlay!");
	
	//如果itemPK为空，则将itemPK置为"0"
	if(itemPK == undefined || itemPK == "") {
		console.log("item is empty!");
		itemPK = "0";
	} else {
		
		console.log("itemPK ： " + itemPK);
	}
	
	if(nationalFundOutlayPk == undefined || nationalFundOutlayPk == null || nationalFundOutlayPk == "") {
		nationalFundOutlayPk = "0";
	}
	console.log("nationalFundOutlayPk ： " + nationalFundOutlayPk);
	
	
	//点击提交按钮时的响应事件
	$("#nationalFundOutlayForm").validationEngine("attach");	
	$("#nationalFundOutlaySubmitButton").click(function(check) {
		
		if($("#nationalFundOutlayForm").validationEngine('validate')){
	       console.log("nationalFundOutlaySubmitButton");
	       var tempFormData = acquireFormData();
	       console.log(tempFormData);
	       
			//异步调用
			generalAjaxCallToLoadData("saveNationalFundOutlay.action",tempFormData, showSavingResult);
		}
			check.preventDefault();//此处阻止提交表单
	   });
	
	
	 var tempSubmitData = {"nationalFundOutlayPk":nationalFundOutlayPk, "itemPK":itemPK};
		//异步取得国家基金项目的支出信息，初始化页面
		generalAjaxCallToLoadData("acquireNationalFundOutlay.action",tempSubmitData, initializeNationalFundOutlay);
		
	});


//科研业务费累计支出
function reserchBusinessSum() {
	
	var reserchBusinessSumValue = getInputWidgetValue("testCost_Outlay") + getInputWidgetValue("fuelCost_Outlay")
							+ getInputWidgetValue("conferenceCost_Outlay") + getInputWidgetValue("publishCost_Outlay")
							+ getInputWidgetValue("otherBusiness_Outlay");
	
	$("#sumBusiness_Outlay").html(reserchBusinessSumValue);
	
	researchFundSum();
}

//实验材料费
function experimentMaterialSum(){
	
	var experimentMaterialSumValue = getInputWidgetValue("rawMaterial_Outlay") + getInputWidgetValue("otherMaterial_Outlay");
	$("#sumMaterial_Outlay").html(experimentMaterialSumValue);
	
	researchFundSum();
}

//实验设备费
function experimentEquipmentSum() {
	
	var experimentEquipmentSumValue = getInputWidgetValue("buyEquipment_Outlay") + getInputWidgetValue("trialEquipment_Outlay");
	$("#sumEquipment_Outlay").html(experimentEquipmentSumValue);
	
	researchFundSum();
}

//研究经费总和
function researchFundSum() {
	var researchFundSumValue = getLabelWidgetValue("sumBusiness_Outlay") + getLabelWidgetValue("sumMaterial_Outlay")
								+ getLabelWidgetValue("sumEquipment_Outlay") + getInputWidgetValue("laboratory_Outlay")
								+ getInputWidgetValue("cooperation_Outlay");
	$("#studyFund_Outlay").html(researchFundSumValue);
	
	itemFundSum();
}

//国际合作与交流费
function internatialExchangeSum() {
	var internatialExchangeSumValue = getInputWidgetValue("exchange_Outlay") + getInputWidgetValue("expert_Outlay");
	$("#exchangeSum_Outlay").html(internatialExchangeSumValue);
	
	itemFundSum();
}

//项目经费合计
function itemFundSum() {
	var itemFundSumValue = getLabelWidgetValue("studyFund_Outlay") + getLabelWidgetValue("exchangeSum_Outlay")
							+ getInputWidgetValue("serviceCost_Outlay") + getInputWidgetValue("manageCost_Outlay");
	$("#sums_Outlay").html(itemFundSumValue);
	
	 outlaySum();
}

//其他经费来源合计
function otherItemFundSum() {
	
	var otherItemFundSumValue = getInputWidgetValue("otherPlanFundsOutlay") + getInputWidgetValue("otherSubsidizeOutlay");
	$("#otherSumOutlay").html(otherItemFundSumValue);
}

function outlaySum(){
	var dialFundsLastValue = getLabelWidgetValue("dialFundsSum") - getLabelWidgetValue("sums_Outlay")- getLabelWidgetValue("sums_AllOutlay");
	$("#dialFundsLast").html(dialFundsLastValue);
	
	
}

//计算结余
function computeSurplus(){
	var studyFund_Surplus = getLabelWidgetValue("studyFund_Budget") - getLabelWidgetValue("studyFund_AllOutlay");
	$("#studyFund_Surplus").html(studyFund_Surplus);
	
	var sumBusiness_Surplus = getLabelWidgetValue("sumBusiness_Budget") - getLabelWidgetValue("sumBusiness_AllOutlay");
	$("#sumBusiness_Surplus").html(sumBusiness_Surplus);
	
	var testCost_Surplus = getLabelWidgetValue("testCost_Budget") - getLabelWidgetValue("testCost_AllOutlay");
	$("#testCost_Surplus").html(testCost_Surplus);
	
	var fuelCost_Surplus = getLabelWidgetValue("fuelCost_Budget") - getLabelWidgetValue("fuelCost_AllOutlay");
	$("#fuelCost_Surplus").html(fuelCost_Surplus);
	
	var conferenceCost_Surplus = getLabelWidgetValue("conferenceCost_Budget") - getLabelWidgetValue("conferenceCost_AllOutlay");
	$("#conferenceCost_Surplus").html(conferenceCost_Surplus);
	
	var publishCost_Surplus = getLabelWidgetValue("publishCost_Budget") - getLabelWidgetValue("publishCost_AllOutlay");
	$("#publishCost_Surplus").html(publishCost_Surplus);
	
	var otherBusiness_Surplus = getLabelWidgetValue("otherBusiness_Budget") - getLabelWidgetValue("otherBusiness_AllOutlay");
	$("#otherBusiness_Surplus").html(otherBusiness_Surplus);
	
	var sumMaterial_Surplus = getLabelWidgetValue("sumMaterial_Budget") - getLabelWidgetValue("sumMaterial_AllOutlay");
	$("#sumMaterial_Surplus").html(sumMaterial_Surplus);
	
	var rawMaterial_Surplus = getLabelWidgetValue("rawMaterial_Budget") - getLabelWidgetValue("rawMaterial_AllOutlay");
	$("#rawMaterial_Surplus").html(rawMaterial_Surplus);
	
	var otherMaterial_Surplus = getLabelWidgetValue("otherMaterial_Budget") - getLabelWidgetValue("otherMaterial_AllOutlay");
	$("#otherMaterial_Surplus").html(otherMaterial_Surplus);
	
	var sumEquipment_Surplus = getLabelWidgetValue("sumEquipment_Budget") - getLabelWidgetValue("sumEquipment_AllOutlay");
	$("#sumEquipment_Surplus").html(sumEquipment_Surplus);
	
	var buyEquipment_Surplus = getLabelWidgetValue("buyEquipment_Budget") - getLabelWidgetValue("buyEquipment_AllOutlay");
	$("#buyEquipment_Surplus").html(buyEquipment_Surplus);
	
	var trialEquipment_Surplus = getLabelWidgetValue("trialEquipment_Budget") - getLabelWidgetValue("trialEquipment_AllOutlay");
	$("#trialEquipment_Surplus").html(trialEquipment_Surplus);
	
	var laboratory_Surplus = getLabelWidgetValue("laboratory_Budget") - getLabelWidgetValue("laboratory_AllOutlay");
	$("#laboratory_Surplus").html(laboratory_Surplus);
	
	var cooperation_Surplus = getLabelWidgetValue("cooperation_Budget") - getLabelWidgetValue("cooperation_AllOutlay");
	$("#cooperation_Surplus").html(cooperation_Surplus);
	
	var exchangeSum_Surplus = getLabelWidgetValue("exchangeSum_Budget") - getLabelWidgetValue("exchangeSum_AllOutlay");
	$("#exchangeSum_Surplus").html(exchangeSum_Surplus);
	
	var exchange_Surplus = getLabelWidgetValue("exchange_Budget") - getLabelWidgetValue("exchange_AllOutlay");
	$("#exchange_Surplus").html(exchange_Surplus);
	
	var expert_Surplus = getLabelWidgetValue("expert_Budget") - getLabelWidgetValue("expert_AllOutlay");
	$("#expert_Surplus").html(expert_Surplus);
	
	var serviceCost_Surplus = getLabelWidgetValue("serviceCost_Budget") - getLabelWidgetValue("serviceCost_AllOutlay");
	$("#serviceCost_Surplus").html(serviceCost_Surplus);
	
	var manageCost_Surplus = getLabelWidgetValue("manageCost_Budget") - getLabelWidgetValue("manageCost_AllOutlay");
	$("#manageCost_Surplus").html(manageCost_Surplus);
	
	var sums_Surplus = getLabelWidgetValue("sums_Budget") - getLabelWidgetValue("sums_AllOutlay");
	$("#sums_Surplus").html(sums_Surplus);
	
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


//初始化页面
function initializeNationalFundOutlay(data){
	
	if(!data.actionStatus) {
		console.log("fail");
		return false;
	}

	var itemInfo = data.jsonResult.itemInfo;
	var nationalFundItemInfo = data.jsonResult.nationalFundItemInfo;
	var nationalFundBudgetInfo = data.jsonResult.nationalFundBudgetInfo;	
	var allNationalFundOutlayInfo = data.jsonResult.allNationalFundOutlayInfo;
	console.log("allNationalFundOutlayInfo");
	console.log(allNationalFundOutlayInfo);
	
	
	if(itemPK != "0") {
		console.log("zhichudengji");
		nationalFundOutlayPk = "0";
		nationalFundRemarkPk = "0";
			
		$("#itemName").html(itemInfo.itemName);
		$("#teacherName").html(itemInfo.teacherName);
		$("#approveID").html(nationalFundItemInfo.approveId);	
		$("#dialFundsSum").html(nationalFundItemInfo.dialFundsSum);
		$("#dialFundsLast").html(nationalFundItemInfo.dialFundsLast);	
		$("#otherPlanFundsBuget").html(nationalFundItemInfo.otherPlanFundsBuget);
		$("#otherSubsidizeBuget").html(nationalFundItemInfo.otherSubsidizeBuget);
		$("#otherPlanFundsOutlay").val(nationalFundItemInfo.otherPlanFundsOutlay);
		$("#otherSubsidizeOutlay").val(nationalFundItemInfo.otherSubsidizeOutlay);
		$("#otherSumBuget").html(nationalFundItemInfo.otherSumBuget);
		$("#otherSumOutlay").html(nationalFundItemInfo.otherSumOutlay);
		
		//显示预算经费
		$("#studyFund_Budget").html(nationalFundBudgetInfo.studyFund);
		$("#sumBusiness_Budget").html(nationalFundBudgetInfo.sumBusiness);	
		$("#testCost_Budget").html(nationalFundBudgetInfo.testCost);
		$("#fuelCost_Budget").html(nationalFundBudgetInfo.fuelCost);
		$("#conferenceCost_Budget").html(nationalFundBudgetInfo.conferenceCost);
		$("#publishCost_Budget").html(nationalFundBudgetInfo.publishCost);
		$("#otherBusiness_Budget").html(nationalFundBudgetInfo.otherBusiness);
		$("#sumMaterial_Budget").html(nationalFundBudgetInfo.sumMaterial);
		$("#rawMaterial_Budget").html(nationalFundBudgetInfo.rawMaterial);
		$("#otherMaterial_Budget").html(nationalFundBudgetInfo.otherMaterial);
		$("#sumEquipment_Budget").html(nationalFundBudgetInfo.sumEquipment);
		$("#buyEquipment_Budget").html(nationalFundBudgetInfo.buyEquipment);
		$("#trialEquipment_Budget").html(nationalFundBudgetInfo.trialEquipment);
		$("#laboratory_Budget").html(nationalFundBudgetInfo.laboratory);
		$("#cooperation_Budget").html(nationalFundBudgetInfo.cooperation);
		$("#exchangeSum_Budget").html(nationalFundBudgetInfo.exchangeSum);
		$("#exchange_Budget").html(nationalFundBudgetInfo.exchange);
		$("#expert_Budget").html(nationalFundBudgetInfo.expert);
		$("#serviceCost_Budget").html(nationalFundBudgetInfo.serviceCost);
		$("#manageCost_Budget").html(nationalFundBudgetInfo.manageCost);
		$("#sums_Budget").html(nationalFundBudgetInfo.sums);
		
		//显示已支出经费
		$("#studyFund_AllOutlay").html(allNationalFundOutlayInfo[0]);
		$("#sumBusiness_AllOutlay").html(allNationalFundOutlayInfo[1]);	
		$("#testCost_AllOutlay").html(allNationalFundOutlayInfo[2]);
		$("#fuelCost_AllOutlay").html(allNationalFundOutlayInfo[3]);
		$("#conferenceCost_AllOutlay").html(allNationalFundOutlayInfo[4]);
		$("#publishCost_AllOutlay").html(allNationalFundOutlayInfo[5]);
		$("#otherBusiness_AllOutlay").html(allNationalFundOutlayInfo[6]);
		$("#sumMaterial_AllOutlay").html(allNationalFundOutlayInfo[7]);
		$("#rawMaterial_AllOutlay").html(allNationalFundOutlayInfo[8]);
		$("#otherMaterial_AllOutlay").html(allNationalFundOutlayInfo[9]);
		$("#sumEquipment_AllOutlay").html(allNationalFundOutlayInfo[10]);
		$("#buyEquipment_AllOutlay").html(allNationalFundOutlayInfo[11]);
		$("#trialEquipment_AllOutlay").html(allNationalFundOutlayInfo[12]);
		$("#laboratory_AllOutlay").html(allNationalFundOutlayInfo[13]);
		$("#cooperation_AllOutlay").html(allNationalFundOutlayInfo[14]);
		$("#exchangeSum_AllOutlay").html(allNationalFundOutlayInfo[15]);
		$("#exchange_AllOutlay").html(allNationalFundOutlayInfo[16]);
		$("#expert_AllOutlay").html(allNationalFundOutlayInfo[17]);
		$("#serviceCost_AllOutlay").html(allNationalFundOutlayInfo[18]);
		$("#manageCost_AllOutlay").html(allNationalFundOutlayInfo[19]);
		$("#sums_AllOutlay").html(allNationalFundOutlayInfo[20]);
		
		
		
	}
	
	computeSurplus();
}

//获得国家基金项目支出及说明
function acquireFormData(){
	
	var formData = {};
	formData["nationalFundOutlayPk"] = nationalFundOutlayPk;
	formData["itemPK"] = itemPK;
	formData["nationalFundRemarkPk"] = nationalFundRemarkPk;
	
	
	var otherPlanFundsOutlay = $("#otherPlanFundsOutlay").val();
	var otherSubsidizeOutlay = $("#otherSubsidizeOutlay").val();
	var otherSumOutlay = $("#otherSumOutlay").html();
	var dialFundsLast = $("#dialFundsLast").html();
			
	formData["dialFundsLast"] = dialFundsLast;
	formData["otherPlanFundsOutlay"] = otherPlanFundsOutlay;
	formData["otherSubsidizeOutlay"] = otherSubsidizeOutlay;
	formData["otherSumOutlay"] = otherSumOutlay;
	
	
	//支出
	var studyFund_Outlay = $("#studyFund_Outlay").html();
	var sumBusiness_Outlay = $("#sumBusiness_Outlay").html();
	var testCost_Outlay = $("#testCost_Outlay").val();
	var fuelCost_Outlay = $("#fuelCost_Outlay").val();
	var conferenceCost_Outlay = $("#conferenceCost_Outlay").val();
	var publishCost_Outlay = $("#publishCost_Outlay").val();
	var otherBusiness_Outlay = $("#otherBusiness_Outlay").val();
	var sumMaterial_Outlay = $("#sumMaterial_Outlay").html();
	var rawMaterial_Outlay = $("#rawMaterial_Outlay").val();
	var otherMaterial_Outlay = $("#otherMaterial_Outlay").val();
	var sumEquipment_Outlay = $("#sumEquipment_Outlay").html();
	var buyEquipment_Outlay = $("#buyEquipment_Outlay").val();
	var trialEquipment_Outlay = $("#trialEquipment_Outlay").val();
	var laboratory_Outlay = $("#laboratory_Outlay").val();
	var cooperation_Outlay = $("#cooperation_Outlay").val();
	var exchangeSum_Outlay = $("#exchangeSum_Outlay").html();
	var exchange_Outlay = $("#exchange_Outlay").val();
	var expert_Outlay = $("#expert_Outlay").val();
	var serviceCost_Outlay = $("#serviceCost_Outlay").val();
	var manageCost_Outlay = $("#manageCost_Outlay").val();
	var sums_Outlay = $("#sums_Outlay").html();
	
	formData["studyFund_Outlay"] = studyFund_Outlay;
	formData["sumBusiness_Outlay"] = sumBusiness_Outlay;
	formData["testCost_Outlay"] = testCost_Outlay;
	formData["fuelCost_Outlay"] = fuelCost_Outlay;
	formData["conferenceCost_Outlay"] = conferenceCost_Outlay;
	formData["publishCost_Outlay"] = publishCost_Outlay;
	formData["otherBusiness_Outlay"] = otherBusiness_Outlay;
	formData["sumMaterial_Outlay"] = sumMaterial_Outlay;
	formData["rawMaterial_Outlay"] = rawMaterial_Outlay;
	formData["otherMaterial_Outlay"] = otherMaterial_Outlay;
	formData["sumEquipment_Outlay"] = sumEquipment_Outlay;
	formData["buyEquipment_Outlay"] = buyEquipment_Outlay;
	formData["trialEquipment_Outlay"] = trialEquipment_Outlay;
	formData["laboratory_Outlay"] = laboratory_Outlay;
	formData["cooperation_Outlay"] = cooperation_Outlay;
	formData["exchangeSum_Outlay"] = exchangeSum_Outlay;
	formData["exchange_Outlay"] = exchange_Outlay;
	formData["expert_Outlay"] = expert_Outlay;
	formData["serviceCost_Outlay"] = serviceCost_Outlay;
	formData["manageCost_Outlay"] = manageCost_Outlay;
	formData["sums_Outlay"] = sums_Outlay;
	
	//说明
	var studyFund_Remark = $("#studyFund_Remark").val();
	var sumBusiness_Remark = $("#sumBusiness_Remark").val();
	var testCost_Remark = $("#testCost_Remark").val();
	var fuelCost_Remark = $("#fuelCost_Remark").val();
	var conferenceCost_Remark = $("#conferenceCost_Remark").val();
	var publishCost_Remark = $("#publishCost_Remark").val();
	var otherBusiness_Remark = $("#otherBusiness_Remark").val();
	var sumMaterial_Remark = $("#sumMaterial_Remark").val();
	var rawMaterial_Remark = $("#rawMaterial_Remark").val();
	var otherMaterial_Remark = $("#otherMaterial_Remark").val();
	var sumEquipment_Remark = $("#sumEquipment_Remark").val();
	var buyEquipment_Remark = $("#buyEquipment_Remark").val();
	var trialEquipment_Remark = $("#trialEquipment_Remark").val();
	var laboratory_Remark = $("#laboratory_Remark").val();
	var cooperation_Remark = $("#cooperation_Remark").val();
	var exchangeSum_Remark = $("#exchangeSum_Remark").val();
	var exchange_Remark = $("#exchange_Remark").val();
	var expert_Remark = $("#expert_Remark").val();
	var serviceCost_Remark = $("#serviceCost_Remark").val();
	var manageCost_Remark = $("#manageCost_Remark").val();
	var sums_Remark = $("#sums_Remark").val();
		
	formData["studyFund_Remark"] = studyFund_Remark;
	formData["sumBusiness_Remark"] = sumBusiness_Remark;
	formData["testCost_Remark"] = testCost_Remark;
	formData["fuelCost_Remark"] = fuelCost_Remark;
	formData["conferenceCost_Remark"] = conferenceCost_Remark;
	formData["publishCost_Remark"] = publishCost_Remark;
	formData["otherBusiness_Remark"] = otherBusiness_Remark;
	formData["sumMaterial_Remark"] = sumMaterial_Remark;
	formData["rawMaterial_Remark"] = rawMaterial_Remark;
	formData["otherMaterial_Remark"] = otherMaterial_Remark;
	formData["sumEquipment_Remark"] = sumEquipment_Remark;
	formData["buyEquipment_Remark"] = buyEquipment_Remark;
	formData["trialEquipment_Remark"] = trialEquipment_Remark;
	formData["laboratory_Remark"] = laboratory_Remark;
	formData["cooperation_Remark"] = cooperation_Remark;
	formData["exchangeSum_Remark"] = exchangeSum_Remark;
	formData["exchange_Remark"] = exchange_Remark;
	formData["expert_Remark"] = expert_Remark;
	formData["serviceCost_Remark"] = serviceCost_Remark;
	formData["manageCost_Remark"] = manageCost_Remark;
	formData["sums_Remark"] = sums_Remark;
	
	return formData;
		
}


//反馈保存操作的状态
function showSavingResult(data) {
	
	if(!data.actionStatus) {
		openGeneralMessageDialog("支出登记提交失败，请重试");
	} else {
		resetForm();
		openGeneralMessageDialogThenGoBack("支出登记提交成功！");
	}
}

function resetForm(){
	$("#nationalFundOutlayForm")[0].reset();
	$( "label[id$='Total']" ).html("");
	$( "label[id^='sum']" ).html("");
	
}
