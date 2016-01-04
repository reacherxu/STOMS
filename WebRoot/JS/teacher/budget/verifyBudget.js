var budgetFlag = false; //数据库中是否有表  false默认无表
var existedBudget ; //数据库中已有的预算值  用于判断是否发生变化
var manager ;
var contractID ; 

$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();

	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"经费项目",
	                	"href":""
	                 },
	                 {
	                	"name":"导入预算",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	
	consoleResponseInUnusabalEnvirenment();
	
	generalAjaxCallToLoadData("acquireContractID.action",{"itemId":itemId},showBudget);
	
});

function isInsertBudget() {
	if( !budgetFlag ) { //是导入的  需要存入数据库
		insertBudget();
	} 
	else {
		judgeBudgetHasChanged();
	}
}

//判断导入的数据  是否发生了变化
function judgeBudgetHasChanged() {
	if( $("#studyOutlay").val() != existedBudget["studyOutlay"] ||
		$("#studyOutlay_sr").val()	!= existedBudget["studyOutlaySr"] ||
		$("#studyOutlay_sr_test").val()	!= existedBudget["studyOutlaySrTest"] ||
		$("#studyOutlay_sr_energy").val() != existedBudget["studyOutlaySrEnergy"] ||
		$("#studyOutlay_sr_meeting").val() !=  existedBudget["studyOutlaySrMeeting"] ||
		$("#studyOutlay_sr_publish").val() != existedBudget["studyOutlaySrPublish"] ||
		$("#studyOutlay_sr_other").val() != existedBudget["studyOutlaySrOther"] ||
		$("#studyOutlay_em").val() != existedBudget["studyOutlayEm"] ||
		$("#studyOutlay_em_material").val() != existedBudget["studyOutlayEmMaterial"] ||
		$("#studyOutlay_em_other").val() != existedBudget["studyOutlayEmOther"] ||
		$("#studyOutlay_ei").val() != existedBudget["studyOutlayEi"] ||
		$("#studyOutlay_ei_purchase").val() != existedBudget["studyOutlayEiPurchase"] ||
		$("#studyOutlay_ei_produce").val() != existedBudget["studyOutlayEiProduce"] ||
		$("#studyOutlay_lr").val() != existedBudget["studyOutlayLr"] ||
		$("#studyOutlay_colaborate").val() != existedBudget["studyOutlayColaborate"] ||
		$("#international").val() != existedBudget["international"] ||
		$("#international_1").val() !=  existedBudget["international1"] ||
		$("#international_2").val() != existedBudget["international2"] ||
		$("#service").val() != existedBudget["service"] ||
		$("#management").val() != existedBudget["management"] ||
		$("#sum").val() != existedBudget["sum"] ) {
		
		if(confirm("是否需要保存？") )  {
			var submitData = {"contractId":contractID.trim(),"manager":manager.trim(),"studyOutlay":$("#studyOutlay").val().trim(),
					"studyOutlaySr":$("#studyOutlay_sr").val().trim(),"studyOutlaySrTest":$("#studyOutlay_sr_test").val().trim(),
					"studyOutlaySrEnergy":$("#studyOutlay_sr_energy").val().trim(),"studyOutlaySrMeeting":$("#studyOutlay_sr_meeting").val().trim(),
					"studyOutlaySrPublish":$("#studyOutlay_sr_publish").val().trim(),"studyOutlaySrOther":$("#studyOutlay_sr_other").val().trim(),
					"studyOutlayEm":$("#studyOutlay_em").val().trim(),"studyOutlayEmMaterial":$("#studyOutlay_em_material").val().trim(),
					"studyOutlayEmOther":$("#studyOutlay_em_other").val().trim(),"studyOutlayEi":$("#studyOutlay_ei").val().trim(),
					"studyOutlayEiPurchase":$("#studyOutlay_ei_purchase").val().trim(),"studyOutlayEiProduce":$("#studyOutlay_ei_produce").val().trim(),
					"studyOutlayLr":$("#studyOutlay_lr").val().trim(),"studyOutlayColaborate":$("#studyOutlay_colaborate").val().trim(),
					"international":$("#international").val().trim(),"international1":$("#international_1").val().trim(),
					"international2":$("#international_2").val().trim(),"service":$("#service").val().trim(),
					"management":$("#management").val().trim(),"sum":$("#sum").val().trim()};

			generalAjaxCallToLoadData("updateBudget.action",submitData, showSavingResult);
		}
		
	} else {
		parent.pageTransition("Page/Teacher/budget/setMapping.jsp?projectId=" + itemId + "&flag=0");
	}
	
}

function insertBudget() {
	contractID = $("#txtContractID").val().trim(); //暂用合同id代替项目编号
	manager = $("#txtName").val().trim(); //负责人
	
	//Budget 部分
	var studyOutlay = $("#studyOutlay").val().trim();
	var studyOutlay_sr = $("#studyOutlay_sr").val().trim();
	var studyOutlay_sr_test = $("#studyOutlay_sr_test").val().trim();
	var studyOutlay_sr_energy = $("#studyOutlay_sr_energy").val().trim();
	var studyOutlay_sr_meeting = $("#studyOutlay_sr_meeting").val().trim();
	var studyOutlay_sr_publish = $("#studyOutlay_sr_publish").val().trim();
	var studyOutlay_sr_other = $("#studyOutlay_sr_other").val().trim();
	var studyOutlay_em = $("#studyOutlay_em").val().trim();
	var studyOutlay_em_material = $("#studyOutlay_em_material").val().trim();
	var studyOutlay_em_other = $("#studyOutlay_em_other").val().trim();
	var studyOutlay_ei = $("#studyOutlay_ei").val().trim();
	var studyOutlay_ei_purchase = $("#studyOutlay_ei_purchase").val().trim();
	var studyOutlay_ei_produce = $("#studyOutlay_ei_produce").val().trim();
	var studyOutlay_lr = $("#studyOutlay_lr").val().trim();
	var studyOutlay_colaborate = $("#studyOutlay_colaborate").val().trim();
	var international = $("#international").val().trim();
	var international_1 = $("#international_1").val().trim();
	var international_2 = $("#international_2").val().trim();
	var service = $("#service").val().trim();
	var management = $("#management").val().trim();
	var sum = $("#sum").val().trim();
	
	var submitData = {"itemId":itemId,"contractId":contractID,"manager":manager,"studyOutlay":studyOutlay,"studyOutlaySr":studyOutlay_sr,
			"studyOutlaySrTest":studyOutlay_sr_test,"studyOutlaySrEnergy":studyOutlay_sr_energy,"studyOutlaySrMeeting":studyOutlay_sr_meeting,
			"studyOutlaySrPublish":studyOutlay_sr_publish,"studyOutlaySrOther":studyOutlay_sr_other,"studyOutlayEm":studyOutlay_em,
			"studyOutlayEmMaterial":studyOutlay_em_material,"studyOutlayEmOther":studyOutlay_em_other,"studyOutlayEi":studyOutlay_ei,
			"studyOutlayEiPurchase":studyOutlay_ei_purchase,"studyOutlayEiProduce":studyOutlay_ei_produce,"studyOutlayLr":studyOutlay_lr,
			"studyOutlayColaborate":studyOutlay_colaborate,"international":international,"international1":international_1,
			"international2":international_2,"service":service,"management":management,"sum":sum};
	
	generalAjaxCallToLoadData("insertBudget.action",submitData, showSavingResult);
	
}


//异步调用保存好用户信息后的回调函数
function showSavingResult(data) {
	
	if(!data.actionStatus) {
		alert("数据库中已存在！");
	} else {
		alert("保存成功!");
	}
	parent.pageTransition("Page/Teacher/budget/setMapping.jsp?projectId=" + itemId + "&flag=0");
}


function showBudget(data) {
	
	if(!data.actionStatus) {
		alert("数据库中无项目预算，请按页面下方的导入预算！");
	} else {
		initializeBudget(data);
		budgetFlag = true;
	}
	
}


function initializeBudget(data) {
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	
	existedBudget = data.jsonResult;
	existedBudget["studyOutlay"] = existedBudget["studyOutlay"] ==0 ? "" : existedBudget["studyOutlay"].toFixed(4);
	existedBudget["studyOutlaySr"] = existedBudget["studyOutlaySr"] ==0 ? "" : existedBudget["studyOutlaySr"].toFixed(4);
	existedBudget["studyOutlaySrTest"] = existedBudget["studyOutlaySrTest"] ==0 ? "" : existedBudget["studyOutlaySrTest"].toFixed(4);
	existedBudget["studyOutlaySrEnergy"] = existedBudget["studyOutlaySrEnergy"] ==0 ? "" : existedBudget["studyOutlaySrEnergy"].toFixed(4);
	existedBudget["studyOutlaySrMeeting"] = existedBudget["studyOutlaySrMeeting"] ==0 ? "" : existedBudget["studyOutlaySrMeeting"].toFixed(4);
	existedBudget["studyOutlaySrPublish"] = existedBudget["studyOutlaySrPublish"] ==0 ? "" : existedBudget["studyOutlaySrPublish"].toFixed(4);
	existedBudget["studyOutlaySrOther"] = existedBudget["studyOutlaySrOther"] ==0 ? "" : existedBudget["studyOutlaySrOther"].toFixed(4);
	existedBudget["studyOutlayEm"] = existedBudget["studyOutlayEm"] ==0 ? "" : existedBudget["studyOutlayEm"].toFixed(4);
	existedBudget["studyOutlayEmMaterial"] = existedBudget["studyOutlayEmMaterial"] ==0 ? "" : existedBudget["studyOutlayEmMaterial"].toFixed(4);
	existedBudget["studyOutlayEmOther"] = existedBudget["studyOutlayEmOther"] ==0 ? "" : existedBudget["studyOutlayEmOther"].toFixed(4);
	existedBudget["studyOutlayEi"] = existedBudget["studyOutlayEi"] ==0 ? "" : existedBudget["studyOutlayEi"].toFixed(4);
	existedBudget["studyOutlayEiPurchase"] = existedBudget["studyOutlayEiPurchase"] ==0 ? "" : existedBudget["studyOutlayEiPurchase"].toFixed(4);
	existedBudget["studyOutlayEiProduce"] = existedBudget["studyOutlayEiProduce"] ==0 ? "" : existedBudget["studyOutlayEiProduce"].toFixed(4);
	existedBudget["studyOutlayLr"] = existedBudget["studyOutlayLr"] ==0 ? "" : existedBudget["studyOutlayLr"].toFixed(4);
	existedBudget["studyOutlayColaborate"] = existedBudget["studyOutlayColaborate"] ==0 ? "" : existedBudget["studyOutlayColaborate"].toFixed(4);
	existedBudget["international"] = existedBudget["international"] ==0 ? "" : existedBudget["international"].toFixed(4);
	existedBudget["international1"] = existedBudget["international1"] ==0 ? "" : existedBudget["international1"].toFixed(4);
	existedBudget["international2"] = existedBudget["international2"] ==0 ? "" : existedBudget["international2"].toFixed(4);
	existedBudget["service"] = existedBudget["service"] ==0 ? "" : existedBudget["service"].toFixed(4);
	existedBudget["management"] = existedBudget["management"] ==0 ? "" : existedBudget["management"].toFixed(4);
	existedBudget["sum"] = existedBudget["sum"] ==0 ? "" : existedBudget["sum"].toFixed(4);
	
	manager = existedBudget["manager"];
	contractID = existedBudget["contractId"];
	
	$("#txtName").val(existedBudget["manager"]);
	$("#txtContractID").val(existedBudget["contractId"]);
	
	//Budget 部分
	$("#studyOutlay").val(existedBudget["studyOutlay"] );
	$("#studyOutlay_sr").val(existedBudget["studyOutlaySr"] );
	$("#studyOutlay_sr_test").val(existedBudget["studyOutlaySrTest"]);
	$("#studyOutlay_sr_energy").val(existedBudget["studyOutlaySrEnergy"]);
	$("#studyOutlay_sr_meeting").val(existedBudget["studyOutlaySrMeeting"]);
	$("#studyOutlay_sr_publish").val(existedBudget["studyOutlaySrPublish"] );
	$("#studyOutlay_sr_other").val(existedBudget["studyOutlaySrOther"] );
	$("#studyOutlay_em").val(existedBudget["studyOutlayEm"] );
	$("#studyOutlay_em_material").val(existedBudget["studyOutlayEmMaterial"] );
	$("#studyOutlay_em_other").val(existedBudget["studyOutlayEmOther"] );
	$("#studyOutlay_ei").val(existedBudget["studyOutlayEi"]);
	$("#studyOutlay_ei_purchase").val(existedBudget["studyOutlayEiPurchase"] );
	$("#studyOutlay_ei_produce").val(existedBudget["studyOutlayEiProduce"] );
	$("#studyOutlay_lr").val(existedBudget["studyOutlayLr"]);
	$("#studyOutlay_colaborate").val(existedBudget["studyOutlayColaborate"]);
	$("#international").val(existedBudget["international"] );
	$("#international_1").val(existedBudget["international1"] );
	$("#international_2").val(existedBudget["international2"] );
	$("#service").val(existedBudget["service"] );
	$("#management").val(existedBudget["management"] );
	$("#sum").val(existedBudget["sum"] );
}