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
		
	 var tempSubmitData = {"nationalFundOutlayPk":nationalFundOutlayPk, "itemPK":itemPK};
		//异步取得国家基金项目的支出信息，初始化页面
		generalAjaxCallToLoadData("acquireNationalFundOutlay.action",tempSubmitData, initializeNationalFundOutlay);
		
		$("input").attr("readonly", "readonly");
		$("textarea").attr("readonly", "readonly");
		
	});


//初始化页面
function initializeNationalFundOutlay(data){
	
	if(!data.actionStatus) {
		console.log("fail");
		return false;
	}

	var itemInfo = data.jsonResult.itemInfo;
	var nationalFundItemInfo = data.jsonResult.nationalFundItemInfo;
	var nationalFundBudgetInfo = data.jsonResult.nationalFundBudgetInfo;	
	var nationalFundOutlayInfo = data.jsonResult.nationalFundOutlayInfo;
	var nationalFundRemarkInfo = nationalFundOutlayInfo.nationalFundRemark;
	console.log(itemInfo);
	console.log(nationalFundItemInfo);
	console.log(nationalFundBudgetInfo);
	console.log(nationalFundOutlayInfo);
		
	
	if(itemPK != "0") {
		console.log("zhichudengji");
		console.log(nationalFundOutlayInfo);
		nationalFundOutlayPk = nationalFundOutlayInfo.nationalFundOutlayPk;
		if(nationalFundRemarkInfo == null){
			nationalFundRemarkPk = "0";
		}else{
			nationalFundRemarkPk = nationalFundRemarkInfo.nationalFundRemarkPk;}
		
		console.log(nationalFundRemarkPk);
	
		
		
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
		
		
		//显示支出
		$("#studyFund_Outlay").html(nationalFundOutlayInfo.studyFund);
		$("#sumBusiness_Outlay").html(nationalFundOutlayInfo.sumBusiness);	
		$("#testCost_Outlay").val(nationalFundOutlayInfo.testCost);
		$("#fuelCost_Outlay").val(nationalFundOutlayInfo.fuelCost);
		$("#conferenceCost_Outlay").val(nationalFundOutlayInfo.conferenceCost);
		$("#publishCost_Outlay").val(nationalFundOutlayInfo.publishCost);
		$("#otherBusiness_Outlay").val(nationalFundOutlayInfo.otherBusiness);
		$("#sumMaterial_Outlay").html(nationalFundOutlayInfo.sumMaterial);
		$("#rawMaterial_Outlay").val(nationalFundOutlayInfo.rawMaterial);
		$("#otherMaterial_Outlay").val(nationalFundOutlayInfo.otherMaterial);
		$("#sumEquipment_Outlay").html(nationalFundOutlayInfo.sumEquipment);
		$("#buyEquipment_Outlay").val(nationalFundOutlayInfo.buyEquipment);
		$("#trialEquipment_Outlay").val(nationalFundOutlayInfo.trialEquipment);
		$("#laboratory_Outlay").val(nationalFundOutlayInfo.laboratory);
		$("#cooperation_Outlay").val(nationalFundOutlayInfo.cooperation);
		$("#exchangeSum_Outlay").html(nationalFundOutlayInfo.exchangeSum);
		$("#exchange_Outlay").val(nationalFundOutlayInfo.exchange);
		$("#expert_Outlay").val(nationalFundOutlayInfo.expert);
		$("#serviceCost_Outlay").val(nationalFundOutlayInfo.serviceCost);
		$("#manageCost_Outlay").val(nationalFundOutlayInfo.manageCost);
		$("#sums_Outlay").html(nationalFundOutlayInfo.sums);
		
		//显示说明
		$("#studyFund_Remark").val(nationalFundRemarkInfo.studyFund);
		$("#sumBusiness_Remark").val(nationalFundRemarkInfo.sumBusiness);	
		$("#testCost_Remark").val(nationalFundRemarkInfo.testCost);
		$("#fuelCost_Remark").val(nationalFundRemarkInfo.fuelCost);
		$("#conferenceCost_Remark").val(nationalFundRemarkInfo.conferenceCost);
		$("#publishCost_Remark").val(nationalFundRemarkInfo.publishCost);
		$("#otherBusiness_Remark").val(nationalFundRemarkInfo.otherBusiness);
		$("#sumMaterial_Remark").val(nationalFundRemarkInfo.sumMaterial);
		$("#rawMaterial_Remark").val(nationalFundRemarkInfo.rawMaterial);
		$("#otherMaterial_Remark").val(nationalFundRemarkInfo.otherMaterial);
		$("#sumEquipment_Remark").val(nationalFundRemarkInfo.sumEquipment);
		$("#buyEquipment_Remark").val(nationalFundRemarkInfo.buyEquipment);
		$("#trialEquipment_Remark").val(nationalFundRemarkInfo.trialEquipment);
		$("#laboratory_Remark").val(nationalFundRemarkInfo.laboratory);
		$("#cooperation_Remark").val(nationalFundRemarkInfo.cooperation);
		$("#exchangeSum_Remark").val(nationalFundRemarkInfo.exchangeSum);
		$("#exchange_Remark").val(nationalFundRemarkInfo.exchange);
		$("#expert_Remark").val(nationalFundRemarkInfo.expert);
		$("#serviceCost_Remark").val(nationalFundRemarkInfo.serviceCost);
		$("#manageCost_Remark").val(nationalFundRemarkInfo.manageCost);
		$("#sums_Remark").val(nationalFundRemarkInfo.sums);
				
	}
}

