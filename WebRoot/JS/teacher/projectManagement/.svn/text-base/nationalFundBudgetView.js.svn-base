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
		                "href":"Page/Teacher/projectManagement/projectRegistrationView.jsp?itemPK=" 
				+ itemPK
		             },
	                 {
	                	"name":"预算信息",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	
	console.log("national FundBudget View!");
	
	//如果itemPK为空，则将itemPK置为"0"
	if(itemPK == undefined || itemPK == "") {
		console.log("item is empty!");
		itemPK = "0";
	} else {
		
		console.log("itemPK ： " + itemPK);
	}
	
	//异步取得国家基金项目的详细信息
	generalAjaxCallToLoadData("acquireNationalFundBudgetInfo.action",{"itemPK":itemPK}, showNationalFundBudgetInfo);
	
	
	//载入当前项目的附件列表
	refreshPicList();
	
	$("textarea").attr("readonly", "readonly");
	
});


function showNationalFundBudgetInfo(data){
	
	if(!data.actionStatus) {
		console.log("fail");
		return false;
	}
	
	var itemInfo = data.jsonResult.itemInfo;
	var nationalFundItemInfo = data.jsonResult.nationalFundItemInfo;
	var nationalFundBudgetInfo = data.jsonResult.nationalFundBudgetInfo;
	var nationalFundBudgetRemarkInfo = data.jsonResult.nationalFundBudgetRemarkInfo;
	console.log(nationalFundItemInfo);
	console.log(nationalFundBudgetInfo);
	
	var itemName = itemInfo.itemName;
	var teacherName = itemInfo.teacherName;
	var approveId = nationalFundItemInfo.approveId;
	var dialFundsSum = nationalFundItemInfo.dialFundsSum;
	var otherPlanFundsBuget = nationalFundItemInfo.otherPlanFundsBuget;
	var otherSubsidizeBuget = nationalFundItemInfo.otherSubsidizeBuget;
	var otherSumBuget = nationalFundItemInfo.otherSumBuget;
	
	
	var studyFund = nationalFundBudgetInfo.studyFund;
	var sumBusiness = nationalFundBudgetInfo.sumBusiness;
	var testCost = nationalFundBudgetInfo.testCost;
	var fuelCost = nationalFundBudgetInfo.fuelCost;
	var conferenceCost = nationalFundBudgetInfo.conferenceCost;
	var publishCost = nationalFundBudgetInfo.publishCost;
	var otherBusiness = nationalFundBudgetInfo.otherBusiness;
	var sumMaterial = nationalFundBudgetInfo.sumMaterial;
	var rawMaterial = nationalFundBudgetInfo.rawMaterial;
	var otherMaterial = nationalFundBudgetInfo.otherMaterial;
	var sumEquipment = nationalFundBudgetInfo.sumEquipment;
	var buyEquipment = nationalFundBudgetInfo.buyEquipment;
	var trialEquipment = nationalFundBudgetInfo.trialEquipment;
	var laboratory = nationalFundBudgetInfo.laboratory;
	var cooperation = nationalFundBudgetInfo.cooperation;
	var exchangeSum = nationalFundBudgetInfo.exchangeSum;
	var exchange = nationalFundBudgetInfo.exchange;
	var expert = nationalFundBudgetInfo.expert;
	var serviceCost = nationalFundBudgetInfo.serviceCost;
	var manageCost = nationalFundBudgetInfo.manageCost;
	var sums = nationalFundBudgetInfo.sums;
	
	
	
	$("#itemName").html(itemName);
	$("#teacherName").html(teacherName);
	$("#approveID").html(approveId);	
	$("#dialFundsSum").html(dialFundsSum);
	$("#otherPlanFundsBuget").html(otherPlanFundsBuget);
	$("#otherSubsidizeBuget").html(otherSubsidizeBuget);
	$("#otherSumBuget").html(otherSumBuget);
	
	$("#studyFund_Budget").html(studyFund);
	$("#sumBusiness_Budget").html(sumBusiness);	
	$("#testCost_Budget").html(testCost);
	$("#fuelCost_Budget").html(fuelCost);
	$("#conferenceCost_Budget").html(conferenceCost);
	$("#publishCost_Budget").html(publishCost);
	$("#otherBusiness_Budget").html(otherBusiness);
	$("#sumMaterial_Budget").html(sumMaterial);
	$("#rawMaterial_Budget").html(rawMaterial);
	$("#otherMaterial_Budget").html(otherMaterial);
	$("#sumEquipment_Budget").html(sumEquipment);
	$("#buyEquipment_Budget").html(buyEquipment);
	$("#trialEquipment_Budget").html(trialEquipment);
	$("#laboratory_Budget").html(laboratory);
	$("#cooperation_Budget").html(cooperation);
	$("#exchangeSum_Budget").html(exchangeSum);
	$("#exchange_Budget").html(exchange);
	$("#expert_Budget").html(expert);
	$("#serviceCost_Budget").html(serviceCost);
	$("#manageCost_Budget").html(manageCost);
	$("#sums_Budget").html(sums);
	
	//显示说明
	$("#studyFund_Remark").val(nationalFundBudgetRemarkInfo.studyFund);
	$("#sumBusiness_Remark").val(nationalFundBudgetRemarkInfo.sumBusiness);	
	$("#testCost_Remark").val(nationalFundBudgetRemarkInfo.testCost);
	$("#fuelCost_Remark").val(nationalFundBudgetRemarkInfo.fuelCost);
	$("#conferenceCost_Remark").val(nationalFundBudgetRemarkInfo.conferenceCost);
	$("#publishCost_Remark").val(nationalFundBudgetRemarkInfo.publishCost);
	$("#otherBusiness_Remark").val(nationalFundBudgetRemarkInfo.otherBusiness);
	$("#sumMaterial_Remark").val(nationalFundBudgetRemarkInfo.sumMaterial);
	$("#rawMaterial_Remark").val(nationalFundBudgetRemarkInfo.rawMaterial);
	$("#otherMaterial_Remark").val(nationalFundBudgetRemarkInfo.otherMaterial);
	$("#sumEquipment_Remark").val(nationalFundBudgetRemarkInfo.sumEquipment);
	$("#buyEquipment_Remark").val(nationalFundBudgetRemarkInfo.buyEquipment);
	$("#trialEquipment_Remark").val(nationalFundBudgetRemarkInfo.trialEquipment);
	$("#laboratory_Remark").val(nationalFundBudgetRemarkInfo.laboratory);
	$("#cooperation_Remark").val(nationalFundBudgetRemarkInfo.cooperation);
	$("#exchangeSum_Remark").val(nationalFundBudgetRemarkInfo.exchangeSum);
	$("#exchange_Remark").val(nationalFundBudgetRemarkInfo.exchange);
	$("#expert_Remark").val(nationalFundBudgetRemarkInfo.expert);
	$("#serviceCost_Remark").val(nationalFundBudgetRemarkInfo.serviceCost);
	$("#manageCost_Remark").val(nationalFundBudgetRemarkInfo.manageCost);
	$("#sums_Remark").val(nationalFundBudgetRemarkInfo.sums);
	
	
}