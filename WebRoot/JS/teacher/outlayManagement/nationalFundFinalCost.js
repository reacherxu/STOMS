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
	
	 var tempSubmitData = {"nationalFundOutlayPk":0, "itemPK":itemPK};
		//异步取得国家基金项目的支出信息，初始化页面
		generalAjaxCallToLoadData("acquireNationalFundOutlay.action",tempSubmitData, initializeNationalFundAllOutlay);
		
		$("textarea").attr("readonly", "readonly");
		
	});


//初始化页面
function initializeNationalFundAllOutlay(data){
	
	if(!data.actionStatus) {
		console.log("fail");
		return false;
	}

	var itemInfo = data.jsonResult.itemInfo;
	var nationalFundItemInfo = data.jsonResult.nationalFundItemInfo;
	var nationalFundBudgetInfo = data.jsonResult.nationalFundBudgetInfo;	
	var allNationalFundOutlayInfo = data.jsonResult.allNationalFundOutlayInfo;
	var nationalFundBudgetRemarkInfo =  data.jsonResult.nationalFundBudgetRemarkInfo;
	
	
	
	if(itemPK != "0") {
			
		$("#itemName").html(itemInfo.itemName);
		$("#teacherName").html(itemInfo.teacherName);
		$("#approveID").html(nationalFundItemInfo.approveId);	
		$("#dialFundsSum").html(nationalFundItemInfo.dialFundsSum);
		$("#dialFundsLast").html(nationalFundItemInfo.dialFundsLast);	
		$("#otherPlanFundsBuget").html(nationalFundItemInfo.otherPlanFundsBuget);
		$("#otherSubsidizeBuget").html(nationalFundItemInfo.otherSubsidizeBuget);
		$("#otherPlanFundsOutlay").html(nationalFundItemInfo.otherPlanFundsOutlay);
		$("#otherSubsidizeOutlay").html(nationalFundItemInfo.otherSubsidizeOutlay);
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
}

