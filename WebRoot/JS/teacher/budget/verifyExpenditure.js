var PERCENTAGE_THRESHOLD = 1;
var BALANCE_THRESHOLD = 5;
$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"经费项目",
	                	"href":""
	                 },
	                 {
	                	"name":"支出统计",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	consoleResponseInUnusabalEnvirenment();
	
	//显示Budget表 BudgetMapping表   获取项目预算 支出
	generalAjaxCallToLoadData("acquireBudgetContrast.action",{"itemId":itemId},showBudget);
	
	
	//显示映射关系 之后的统计表
//	generalAjaxCallToLoadData("acquireMapping.action",{"projectId":projectId},initializeMapping);
});

function returnTeacherPage() {
	parent.pageTransition("Page/Teacher/projectManagement/projectRegistrationList.jsp");
}


function showBudget(data) {
	
	if(!data.actionStatus) {
		alert("数据库中无项目预算，请按页面下方的导入预算！");
	} else {
		initializeBudget(data);
		budgetFlag = true;
	}
	
}

function calculatePercentage(budget,expenditure,id) {
	var balance = budget - expenditure;
	var percentage;
	if( balance > 0 ) {
		percentage = "";
//		document.getElementById(id).style.display="None";
//		if(percentage > PERCENTAGE_THRESHOLD)
//			document.getElementById(id).style.color="blue";
		
	} else if( balance == 0)  {
		if( budget != 0 ) {
			percentage = "";
//			document.getElementById(id).style.display="None";
		} 
	} else {
		if(  budget == 0 ) {
			percentage = "非预算支出！";
			document.getElementById(id).style.color="red";
		} else {
			percentage = "是";
			document.getElementById(id).style.color="red";
		}
	} 
	return percentage;
}

function calculateBalance(budget,expenditure,id) {
	var balance = budget - expenditure;
	if( balance > 0 ) {
		if( balance < BALANCE_THRESHOLD && expenditure != 0)
			document.getElementById(id).style.color="blue";
	} else if( balance == 0)  {
		if( budget != 0 ) {
			document.getElementById(id).style.color="blue";
		}
	} else {
		if(  budget == 0 ) {
			percentage = "非预算支出！";
			document.getElementById(id).style.color="blue";
		} else {
			document.getElementById(id).style.color="red";
		}
	} 
	return balance.toFixed(4);
}

function calculateExpenditure(expenditure) {
	return (expenditure/10000).toFixed(4);
}

function calculateBudget(budget) {
	return budget.toFixed(4);
}

function initializeBudget(data) {
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	existedBudget = data.jsonResult;

	manager = existedBudget["manager"];
	contractID = existedBudget["contractId"];
	
	$("#txtName").val(existedBudget["manager"]);
	$("#txtContractID").val(existedBudget["contractId"]);
	
	//取budget值
	var studyOutlay = calculateBudget(existedBudget["studyOutlay"]);
	var studyOutlaySr =	calculateBudget(existedBudget["studyOutlaySr"] );
	var studyOutlaySrTest =	calculateBudget(existedBudget["studyOutlaySrTest"] );
	var studyOutlaySrEnergy = calculateBudget(existedBudget["studyOutlaySrEnergy"]) ;
	var studyOutlaySrMeeting = calculateBudget(existedBudget["studyOutlaySrMeeting"]);
	var studyOutlaySrPublish = calculateBudget(existedBudget["studyOutlaySrPublish"]) ;
	var	studyOutlaySrOther = calculateBudget(existedBudget["studyOutlaySrOther"] );
	var studyOutlayEm = calculateBudget(existedBudget["studyOutlayEm"]) ;
	var studyOutlay_em_material = calculateBudget(existedBudget["studyOutlayEmMaterial"]) ;
	var studyOutlay_em_other = calculateBudget(existedBudget["studyOutlayEmOther"]);
	var studyOutlay_ei = calculateBudget(existedBudget["studyOutlayEi"]);
	var studyOutlay_ei_purchase = calculateBudget(existedBudget["studyOutlayEiPurchase"] );
	var studyOutlay_ei_produce = calculateBudget(existedBudget["studyOutlayEiProduce"]);
	var studyOutlay_lr = calculateBudget(existedBudget["studyOutlayLr"]);
	var studyOutlay_colaborate = calculateBudget(existedBudget["studyOutlayColaborate"] );
	var international = calculateBudget(existedBudget["international"] );
	var international_1 = calculateBudget(existedBudget["international1"] );
	var international_2 = calculateBudget(existedBudget["international2"]);
	var service = calculateBudget(existedBudget["service"] );
	var management = calculateBudget(existedBudget["manage"] );
	var sum = calculateBudget(existedBudget["sum"] );
	
	//取 expenditure
	var research = calculateExpenditure(existedBudget["research"] );
	var srbusiness = calculateExpenditure(existedBudget["srbusiness"] );
	var test = calculateExpenditure(existedBudget["test"] ) ;
	var energy = calculateExpenditure(existedBudget["energy"] );
	var meetings = calculateExpenditure(existedBudget["meetings"] );
	var publishments = calculateExpenditure(existedBudget["publishments"]) ;
	var otherSrbusiness = calculateExpenditure(existedBudget["otherSrbusiness"] );
	var experimentMaterial = calculateExpenditure(existedBudget["experimentMaterial"]) ;
	var rawMaterial = calculateExpenditure(existedBudget["rawMaterial"]  );
	var otherMaterial = calculateExpenditure(existedBudget["otherMaterial"]) ;
	var equipment = calculateExpenditure(existedBudget["equipment"] );
	var equipmentPurchase = calculateExpenditure(existedBudget["equipmentPurchase"] );
	var equipmentProduce =calculateExpenditure( existedBudget["equipmentProduce"] );
	var labReconstruction = calculateExpenditure(existedBudget["labReconstruction"] );
	var collaboration = calculateExpenditure(existedBudget["collaboration"] );
	var internationalCommunication = calculateExpenditure(existedBudget["internationalCommunication"]) ;
	var exportCommunication = calculateExpenditure(existedBudget["exportCommunication"]) ;
	var importCommunication = calculateExpenditure(existedBudget["importCommunication"] );
	var labour = calculateExpenditure(existedBudget["labour"] );
	var management_expenditure = calculateExpenditure(existedBudget["management"]) ;
	var sum_expenditure = parseFloat(research) + parseFloat(internationalCommunication) + parseFloat(labour) + parseFloat(management_expenditure) ;
	
	//Budget 部分显示
	$("#studyOutlay").val(studyOutlay);
	$("#studyOutlay_sr").val(studyOutlaySr);
	$("#studyOutlay_sr_test").val(studyOutlaySrTest);
	$("#studyOutlay_sr_energy").val(studyOutlaySrEnergy);
	$("#studyOutlay_sr_meeting").val(studyOutlaySrMeeting);
	$("#studyOutlay_sr_publish").val(studyOutlaySrPublish);
	$("#studyOutlay_sr_other").val(studyOutlaySrOther);
	$("#studyOutlay_em").val(studyOutlayEm);
	$("#studyOutlay_em_material").val(studyOutlay_em_material);
	$("#studyOutlay_em_other").val(studyOutlay_em_other);
	$("#studyOutlay_ei").val(studyOutlay_ei);
	$("#studyOutlay_ei_purchase").val(studyOutlay_ei_purchase);
	$("#studyOutlay_ei_produce").val(studyOutlay_ei_produce);
	$("#studyOutlay_lr").val(studyOutlay_lr);
	$("#studyOutlay_colaborate").val(studyOutlay_colaborate);
	$("#international").val(international);
	$("#international_1").val(international_1);
	$("#international_2").val(international_2);
	$("#service").val(service);
	$("#management").val(management);
	$("#sum").val(sum);
	
	//BudgetMapping 部分显示
	$("#research").val(research);
	$("#srbusiness").val(srbusiness);
	$("#test").val(test);
	$("#energy").val(energy);
	$("#meetings").val(meetings);
	$("#publishments").val(publishments);
	$("#other_srbusiness").val(otherSrbusiness);
	$("#experiment_material").val(experimentMaterial);
	$("#raw_material").val(rawMaterial);
	$("#other_material").val(otherMaterial);
	$("#equipment").val(equipment);
	$("#equipment_purchase").val(equipmentPurchase);
	$("#equipment_produce").val(equipmentProduce);
	$("#lab_reconstruction").val(labReconstruction);
	$("#collaboration").val(collaboration);
	$("#international_communication").val(internationalCommunication);
	$("#export_communication").val(exportCommunication);
	$("#import_communication").val(importCommunication);
	$("#labour").val(labour);
	$("#management_expenditure").val(management_expenditure);
	$("#sum_expenditure").val(sum_expenditure.toFixed(4));
	
	//balance 部分显示
	$("#research_balance").val(calculateBalance(studyOutlay,research,"research_balance") );
	$("#srbusiness_balance").val(calculateBalance(studyOutlaySr,srbusiness,"srbusiness_balance") );
	$("#test_balance").val(calculateBalance(studyOutlaySrTest,test,"test_balance"));
	$("#energy_balance").val(calculateBalance(studyOutlaySrEnergy,energy,"energy_balance"));
	$("#meetings_balance").val(calculateBalance(studyOutlaySrMeeting,meetings,"meetings_balance"));
	$("#publishments_balance").val(calculateBalance(studyOutlaySrPublish,publishments,"publishments_balance"));
	$("#other_srbusiness_balance").val(calculateBalance(studyOutlaySrOther,otherSrbusiness,"other_srbusiness_balance"));
	$("#experiment_material_balance").val(calculateBalance(studyOutlayEm,experimentMaterial,"experiment_material_balance"));
	$("#raw_material_balance").val(calculateBalance(studyOutlay_em_material,rawMaterial,"raw_material_balance"));
	$("#other_material_balance").val(calculateBalance(studyOutlay_em_other,otherMaterial,"other_material_balance"));
	$("#equipment_balance").val(calculateBalance(studyOutlay_ei,equipment,"equipment_balance"));	
	$("#equipment_purchase_balance").val(calculateBalance(studyOutlay_ei_purchase,equipmentPurchase,"equipment_purchase_balance"));
	$("#equipment_produce_balance").val(calculateBalance(studyOutlay_ei_produce,equipmentProduce,"equipment_produce_balance"));
	$("#lab_reconstruction_balance").val(calculateBalance(studyOutlay_lr,labReconstruction,"lab_reconstruction_balance"));
	$("#collaboration_balance").val(calculateBalance(studyOutlay_colaborate,collaboration,"collaboration_balance"));
	$("#international_communication_balance").val(calculateBalance(international,internationalCommunication,"international_communication_balance"));
	$("#export_communication_balance").val(calculateBalance(international_1,exportCommunication,"export_communication_balance"));
	$("#import_communication_balance").val(calculateBalance(international_2,importCommunication,"import_communication_balance"));
	$("#labour_balance").val(calculateBalance(service,labour,"labour_balance"));
	$("#management_expenditure_balance").val(calculateBalance(management,management_expenditure,"management_expenditure_balance"));
	$("#sum_expenditure_balance").val(calculateBalance(sum,sum_expenditure,"sum_expenditure_balance"));
	
	//percentage 部分显示
	$("#research_percentage").val(calculatePercentage(studyOutlay,research,"research_percentage") );
	$("#srbusiness_percentage").val(calculatePercentage(studyOutlaySr,srbusiness,"srbusiness_percentage") );
	$("#test_percentage").val(calculatePercentage(studyOutlaySrTest,test,"test_percentage"));
	$("#energy_percentage").val(calculatePercentage(studyOutlaySrEnergy,energy,"energy_percentage"));
	$("#meetings_percentage").val(calculatePercentage(studyOutlaySrMeeting,meetings,"meetings_percentage"));
	$("#publishments_percentage").val(calculatePercentage(studyOutlaySrPublish,publishments,"publishments_percentage"));
	$("#other_srbusiness_percentage").val(calculatePercentage(studyOutlaySrOther,otherSrbusiness,"other_srbusiness_percentage"));
	$("#experiment_material_percentage").val(calculatePercentage(studyOutlayEm,experimentMaterial,"experiment_material_percentage"));
	$("#raw_material_percentage").val(calculatePercentage(studyOutlay_em_material,rawMaterial,"raw_material_percentage"));
	$("#other_material_percentage").val(calculatePercentage(studyOutlay_em_other,otherMaterial,"other_material_percentage"));
	$("#equipment_percentage").val(calculatePercentage(studyOutlay_ei,equipment,"equipment_percentage"));	
	$("#equipment_purchase_percentage").val(calculatePercentage(studyOutlay_ei_purchase,equipmentPurchase,"equipment_purchase_percentage"));
	$("#equipment_produce_percentage").val(calculatePercentage(studyOutlay_ei_produce,equipmentProduce,"equipment_produce_percentage"));
	$("#lab_reconstruction_percentage").val(calculatePercentage(studyOutlay_lr,labReconstruction,"lab_reconstruction_percentage"));
	$("#collaboration_percentage").val(calculatePercentage(studyOutlay_colaborate,collaboration,"collaboration_percentage"));
	$("#international_communication_percentage").val(calculatePercentage(international,internationalCommunication,"international_communication_percentage"));
	$("#export_communication_percentage").val(calculatePercentage(international_1,exportCommunication,"export_communication_percentage"));
	$("#import_communication_percentage").val(calculatePercentage(international_2,importCommunication,"import_communication_percentage"));
	$("#labour_percentage").val(calculatePercentage(service,labour,"labour_percentage"));
	$("#management_expenditure_percentage").val(calculatePercentage(management,management_expenditure,"management_expenditure_percentage"));
	$("#sum_expenditure_percentage").val(calculatePercentage(sum,sum_expenditure,"sum_expenditure_percentage"));
}

function initializeMapping(data){
	if(!data.actionStatus) {
		console.log("initialize mapping failed!");
		return false;
	}
	var existedBudget = data.jsonResult[0];
	$("#research").val(existedBudget.research);
	$("#srbusiness").val(existedBudget.srbusiness);
	$("#test").val(existedBudget.test);
	$("#energy").val(existedBudget.energy);
	$("#meetings").val(existedBudget.meetings);
	$("#publishments").val(existedBudget.publishments);
	$("#other_srbusiness").val(existedBudget.other_srbusiness);
	$("#experiment_material").val(existedBudget.experiment_material);
	$("#raw_material").val(existedBudget.raw_material);
	$("#other_material").val(existedBudget.other_material);
	$("#equipment").val(existedBudget.equipment);
	$("#equipment_purchase").val(existedBudget.equipment_purchase);
	$("#equipment_produce").val(existedBudget.equipment_produce);
	$("#lab_reconstruction").val(existedBudget.lab_reconstruction);
	$("#collaboration").val(existedBudget.collaboration);
	$("#international_communication").val(existedBudget.international_communication);
	$("#export_communication").val(existedBudget.export_communication);
	$("#import_communication").val(existedBudget.import_communication);
	$("#labour").val(existedBudget.labour);
	$("#management_expenditure").val(existedBudget.management);
	return true;
}