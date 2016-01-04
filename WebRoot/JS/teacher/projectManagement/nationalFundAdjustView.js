$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"我的项目",
	                	"href":"Page/Teacher/projectManagement/projectRegistrationList.jsp"
	                 },
	                 {
		                	"name":"预算调整历史",
		                	"href":"Page/Teacher/projectManagement/nationalFundAdjustList.jsp?itemPK=" + itemPK
		             },
	                 {
	                	"name":"预算调整",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	//如果itemPK为空，则将itemPK置为"0"
	if(itemPK == undefined || itemPK == "") {
		console.log("item is empty!");
		itemPK = "0";
	} else {
		
		console.log("itemPK ： " + itemPK);
	}
	
	if(nationalFundAdjustPk == undefined || nationalFundAdjustPk == null || nationalFundAdjustPk == "") {
		nationalFundAdjustPk = "0";
	}
	console.log("nationalFundAdjustPk ： " + nationalFundAdjustPk);
	
	var tempSubmitData = {"nationalFundAdjustPk":nationalFundAdjustPk, "itemPK":itemPK};
	//异步取得国家基金项目的预算信息，初始化页面
	generalAjaxCallToLoadData("acquireBudgetAdjustmentDetail.action",tempSubmitData, initializeBudgetAdjustment);

	//载入当前项目的附件列表
	refreshPicList();
	
	$("input").attr("readonly", "readonly");
	$("textarea").attr("readonly", "readonly");
	
	
});



//初始化页面
function initializeBudgetAdjustment(data){
	
	if(!data.actionStatus) {
		console.log("fail");
		return false;
	}

	var itemInfo = data.jsonResult.itemInfo;
	var nationalFundItemInfo = data.jsonResult.nationalFundItemInfo;
	var nationalFundBudgetInfo = data.jsonResult.nationalFundBudgetInfo;	
	var nationalFundAdjustInfo = data.jsonResult.nationalFundAdjustInfo;
	console.log(itemInfo);
	console.log(nationalFundItemInfo);
	console.log(nationalFundBudgetInfo);
	console.log(nationalFundAdjustInfo);
		
	
	if(itemPK != "0") {
		console.log("tiaozheng");
		console.log(nationalFundAdjustInfo);
		nationalFundAdjustPk = nationalFundAdjustInfo.nationalFundAdjustPk;
		$("#itemName").html(itemInfo.itemName);
		$("#teacherName").html(itemInfo.teacherName);
		$("#approveID").html(nationalFundItemInfo.approveId);	
		$("#dialFundsSum").html(nationalFundItemInfo.dialFundsSum);
		$("#otherPlanFundsBuget").html(nationalFundItemInfo.otherPlanFundsBuget);
		$("#otherSubsidizeBuget").html(nationalFundItemInfo.otherSubsidizeBuget);
		$("#otherSumBuget").html(nationalFundItemInfo.otherSumBuget);
		
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
		
		
		//显示预算调整
		$("#studyFund_Adjust").html(nationalFundAdjustInfo.studyFund);
		$("#sumBusiness_Adjust").html(nationalFundAdjustInfo.sumBusiness);	
		$("#testCost_Adjust").html(nationalFundAdjustInfo.testCost);
		$("#fuelCost_Adjust").html(nationalFundAdjustInfo.fuelCost);
		$("#conferenceCost_Adjust").html(nationalFundAdjustInfo.conferenceCost);
		$("#publishCost_Adjust").html(nationalFundAdjustInfo.publishCost);
		$("#otherBusiness_Adjust").html(nationalFundAdjustInfo.otherBusiness);
		$("#sumMaterial_Adjust").html(nationalFundAdjustInfo.sumMaterial);
		$("#rawMaterial_Adjust").html(nationalFundAdjustInfo.rawMaterial);
		$("#otherMaterial_Adjust").html(nationalFundAdjustInfo.otherMaterial);
		$("#sumEquipment_Adjust").html(nationalFundAdjustInfo.sumEquipment);
		$("#buyEquipment_Adjust").html(nationalFundAdjustInfo.buyEquipment);
		$("#trialEquipment_Adjust").html(nationalFundAdjustInfo.trialEquipment);
		$("#laboratory_Adjust").html(nationalFundAdjustInfo.laboratory);
		$("#cooperation_Adjust").html(nationalFundAdjustInfo.cooperation);
		$("#exchangeSum_Adjust").html(nationalFundAdjustInfo.exchangeSum);
		$("#exchange_Adjust").html(nationalFundAdjustInfo.exchange);
		$("#expert_Adjust").html(nationalFundAdjustInfo.expert);
		$("#serviceCost_Adjust").html(nationalFundAdjustInfo.serviceCost);
		$("#manageCost_Adjust").html(nationalFundAdjustInfo.manageCost);
		$("#sums_Adjust").html(nationalFundAdjustInfo.sums);
		
		$("#ntime").html(nationalFundAdjustInfo.ntime);
		
		$("#suggestion").val(nationalFundAdjustInfo.suggestion);
				
	}
	
	 budgetSum();//计算总经费
}



//计算项目总经费
function budgetSum(){
	var studyFund_BudgetSum = getLabelWidgetValue("studyFund_Budget") + getLabelWidgetValue("studyFund_Adjust");
	$("#studyFund_BudgetSum").html(studyFund_BudgetSum);
	
	var sumBusiness_BudgetSum = getLabelWidgetValue("sumBusiness_Budget") + getLabelWidgetValue("sumBusiness_Adjust");
	$("#sumBusiness_BudgetSum").html(sumBusiness_BudgetSum);
	
	var testCost_BudgetSum = getLabelWidgetValue("testCost_Budget") + getLabelWidgetValue("testCost_Adjust");
	$("#testCost_BudgetSum").html(testCost_BudgetSum);
	
	var fuelCost_BudgetSum = getLabelWidgetValue("fuelCost_Budget") + getLabelWidgetValue("fuelCost_Adjust");
	$("#fuelCost_BudgetSum").html(fuelCost_BudgetSum);
	
	var conferenceCost_BudgetSum = getLabelWidgetValue("conferenceCost_Budget") + getLabelWidgetValue("conferenceCost_Adjust");
	$("#conferenceCost_BudgetSum").html(conferenceCost_BudgetSum);
	
	var publishCost_BudgetSum = getLabelWidgetValue("publishCost_Budget") + getLabelWidgetValue("publishCost_Adjust");
	$("#publishCost_BudgetSum").html(publishCost_BudgetSum);
	
	var otherBusiness_BudgetSum = getLabelWidgetValue("otherBusiness_Budget") + getLabelWidgetValue("otherBusiness_Adjust");
	$("#otherBusiness_BudgetSum").html(otherBusiness_BudgetSum);
	
	var sumMaterial_BudgetSum = getLabelWidgetValue("sumMaterial_Budget") + getLabelWidgetValue("sumMaterial_Adjust");
	$("#sumMaterial_BudgetSum").html(sumMaterial_BudgetSum);
	
	var rawMaterial_BudgetSum = getLabelWidgetValue("rawMaterial_Budget") + getLabelWidgetValue("rawMaterial_Adjust");
	$("#rawMaterial_BudgetSum").html(rawMaterial_BudgetSum);
	
	var otherMaterial_BudgetSum = getLabelWidgetValue("otherMaterial_Budget") + getLabelWidgetValue("otherMaterial_Adjust");
	$("#otherMaterial_BudgetSum").html(otherMaterial_BudgetSum);
	
	var sumEquipment_BudgetSum = getLabelWidgetValue("sumEquipment_Budget") + getLabelWidgetValue("sumEquipment_Adjust");
	$("#sumEquipment_BudgetSum").html(sumEquipment_BudgetSum);
	
	var buyEquipment_BudgetSum = getLabelWidgetValue("buyEquipment_Budget") + getLabelWidgetValue("buyEquipment_Adjust");
	$("#buyEquipment_BudgetSum").html(buyEquipment_BudgetSum);
	
	var trialEquipment_BudgetSum = getLabelWidgetValue("trialEquipment_Budget") + getLabelWidgetValue("trialEquipment_Adjust");
	$("#trialEquipment_BudgetSum").html(trialEquipment_BudgetSum);
	
	var laboratory_BudgetSum = getLabelWidgetValue("laboratory_Budget") + getLabelWidgetValue("laboratory_Adjust");
	$("#laboratory_BudgetSum").html(laboratory_BudgetSum);
	
	var cooperation_BudgetSum = getLabelWidgetValue("cooperation_Budget") + getLabelWidgetValue("cooperation_Adjust");
	$("#cooperation_BudgetSum").html(cooperation_BudgetSum);
	
	var exchangeSum_BudgetSum = getLabelWidgetValue("exchangeSum_Budget") + getLabelWidgetValue("exchangeSum_Adjust");
	$("#exchangeSum_BudgetSum").html(exchangeSum_BudgetSum);
	
	var exchange_BudgetSum = getLabelWidgetValue("exchange_Budget") + getLabelWidgetValue("exchange_Adjust");
	$("#exchange_BudgetSum").html(exchange_BudgetSum);
	
	var expert_BudgetSum = getLabelWidgetValue("expert_Budget") + getLabelWidgetValue("expert_Adjust");
	$("#expert_BudgetSum").html(expert_BudgetSum);
	
	var serviceCost_BudgetSum = getLabelWidgetValue("serviceCost_Budget") + getLabelWidgetValue("serviceCost_Adjust");
	$("#serviceCost_BudgetSum").html(serviceCost_BudgetSum);
	
	var manageCost_BudgetSum = getLabelWidgetValue("manageCost_Budget") + getLabelWidgetValue("manageCost_Adjust");
	$("#manageCost_BudgetSum").html(manageCost_BudgetSum);
	
	var sums_BudgetSum = getLabelWidgetValue("sums_Budget") + getLabelWidgetValue("sums_Adjust");
	$("#sums_BudgetSum").html(sums_BudgetSum);
	
}

//得到label值
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

