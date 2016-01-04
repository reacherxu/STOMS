$(document).ready(function(){
	
	consoleResponseInUnusabalEnvirenment();
	
	/******************************* 显示导航条 开始****************************************/
	var tempPagePaths = [
	                 {
	                	"name":"经费统计",
	                	"href":""
	                 },
	                 {
	                	"name":"支出统计",
		                "href":""
	                 }];
	parent.pathWayRender(tempPagePaths);
	/******************************* 显示导航条 结束****************************************/
	

	$("#resetButton").click(function(check) {
		if(confirm("确定恢复之前默认设置么？") == true) {
			generalAjaxCallToLoadData("acquireMapping.action",{"projectId":"000000"},initializeMapping);
		}
	});
	
	$("#clearButton").click(function(check) {
		if(confirm("确定清空设置么？") == true) {
			$("#research").val("");
			$("#srbusiness").val("");
			$("#test").val("");
			$("#energy").val("");
			$("#meetings").val("");
			$("#publishments").val("");
			$("#other_srbusiness").val("");
			$("#experiment_material").val("");
			$("#raw_material").val("");
			$("#other_material").val("");
			$("#equipment").val("");
			$("#equipment_purchase").val("");
			$("#equipment_produce").val("");
			$("#lab_reconstruction").val("");
			$("#collaboration").val("");
			$("#international_communication").val("");
			$("#export_communication").val("");
			$("#import_communication").val("");
			$("#labour").val("");
			$("#management").val("");
		}
	});
	
	$("#saveButton").click(function(check) { 
		if(confirm("确定保存设置么？") == true) {
			var submitData = acquireFormData();
			generalAjaxCallToLoadData("saveMapping.action",submitData,showSaveMappingResult);
		}
	});
	/**
	 * acquire the budget mapping by project id
	 */
	generalAjaxCallToLoadData("acquireMapping.action",{"projectId":"000000"},initializeMapping);
});

function initializeMapping(data){
	if(!data.actionStatus) {
		console.log("initialize mapping failed!");
		return false;
	}
	var mapping = data.jsonResult[0];
	$("#research").val(mapping.research);
	$("#srbusiness").val(mapping.srbusiness);
	$("#test").val(mapping.test);
	$("#energy").val(mapping.energy);
	$("#meetings").val(mapping.meetings);
	$("#publishments").val(mapping.publishments);
	$("#other_srbusiness").val(mapping.other_srbusiness);
	$("#experiment_material").val(mapping.experiment_material);
	$("#raw_material").val(mapping.raw_material);
	$("#other_material").val(mapping.other_material);
	$("#equipment").val(mapping.equipment);
	$("#equipment_purchase").val(mapping.equipment_purchase);
	$("#equipment_produce").val(mapping.equipment_produce);
	$("#lab_reconstruction").val(mapping.lab_reconstruction);
	$("#collaboration").val(mapping.collaboration);
	$("#international_communication").val(mapping.international_communication);
	$("#export_communication").val(mapping.export_communication);
	$("#import_communication").val(mapping.import_communication);
	$("#labour").val(mapping.labour);
	$("#management").val(mapping.management);
	return true;
}

function showSaveMappingResult(data) {
	if(!data.actionStatus) {
		confirm("保存设置失败！");
		console.log("save mapping failed!");
		return false;
	}
	else {
		confirm("保存设置成功！");
		console.log("save mapping succeeded!");
		return true;
	}
	
}

function acquireFormData() {
	
	var test = $("#test").val();
	var energy = $("#energy").val();
	var meetings = $("#meetings").val();
	var publishments = $("#publishments").val();
	var otherSrbusiness = $("#other_srbusiness").val();
	var srbusiness = test+energy+meetings+publishments+otherSrbusiness;
	
	
	var rawMaterial = $("#raw_material").val();
	var otherMaterial = $("#other_material").val();
	var experimentMaterial = rawMaterial+otherMaterial;

	var equipmentPurchase = $("#equipment_purchase").val();
	var equipmentProduce = $("#equipment_produce").val();
	var equipment = equipmentPurchase+equipmentProduce;
	
	var labReconstruction = $("#lab_reconstruction").val();
	var collaboration = $("#collaboration").val();
	var research = srbusiness+experimentMaterial+equipment+labReconstruction+collaboration;
	
	var exportCommunication = $("#export_communication").val();
	var importCommunication = $("#import_communication").val();
	var internationalCommunication = exportCommunication+importCommunication;
	
	var labour = $("#labour").val();
	var management = $("#management").val();
	
	var formData = {};
	formData["projectId"] = "000000";
	formData["manager"] = adminId;
	formData["research"] = research;
	formData["srbusiness"] = srbusiness;
	formData["test"] = test;
	formData["energy"] = energy;
	formData["meetings"] = meetings;
	formData["publishments"] = publishments;
	formData["otherSrbusiness"] = otherSrbusiness;
	formData["experimentMaterial"] = experimentMaterial;
	formData["rawMaterial"] = rawMaterial;
	formData["otherMaterial"] = otherMaterial;
	formData["equipment"] = equipment;
	formData["equipmentPurchase"] = equipmentPurchase;
	formData["equipmentProduce"] = equipmentProduce;
	formData["labReconstruction"] = labReconstruction;
	formData["collaboration"] = collaboration;
	formData["internationalCommunication"] = internationalCommunication;
	formData["exportCommunication"] = exportCommunication;
	formData["importCommunication"] = importCommunication;
	formData["labour"] = labour;
	formData["management"] = management;
	
	return formData;
}

function generateArray() {
	var array = new Array();
	array["0522"]="(0522)科研支出";
	array["052201"]="---(052201)工资福利支出";
	array["05220101"]="------(05220101)基本工资";
	array["0522010101"]="---------(0522010101)岗位工资";
	array["0522010102"]="---------(0522010102)薪级工资";
	array["05220102"]="------(05220102)津贴、补贴";
	array["0522010223"]="---------(0522010223)交通补贴";
	array["0522010231"]="---------(0522010231)校内津贴";
	array["0522010251"]="---------(0522010251)保健津贴";
	array["0522010299"]="---------(0522010299)其他";
	array["05220103"]="------(05220103)奖金";
	array["0522010302"]="---------(0522010302)成果奖";
	array["0522010399"]="---------(0522010399)其他奖金";	
	array["05220107"]="------(05220107)社会保险缴费";
	array["0522010701"]="---------(0522010701)养老统筹";
	array["0522010702"]="---------(0522010702)职工医疗保险费";
	array["0522010703"]="---------(0522010703)失业保险";
	array["0522010799"]="---------(0522010799)其他保险";
	array["05220108"]="------(05220108)伙食补助费";
	array["0522010801"]="---------(0522010801)误餐补贴";
	array["05220109"]="------(05220109)其他";
	array["0522010901"]="---------(0522010901)加班费";
	array["0522010903"]="---------(0522010903)超工作量酬金";
	array["0522010904"]="---------(0522010904)科研酬金";
	array["0522010905"]="---------(0522010905)返聘人员工资及津贴";
	array["0522010906"]="---------(0522010906)非事业编制劳务派遣工资";
	array["0522010907"]="---------(0522010907)非事业编制劳务派遣(五险一金)";
	array["0522010908"]="---------(0522010908)外籍专家工资";
	array["0522010910"]="---------(0522010910)博士后工资";
	array["0522010911"]="---------(0522010911)人事代理工资津贴";
	array["0522010914"]="---------(0522010914)人员费";
	array["0522010999"]="---------(0522010999)其他";	
	
	array["052202"]="---(052202)商品和服务支出";
	array["05220201"]="------(05220201)办公费";
	array["0522020101"]="---------(0522020101)办公用品";
	array["0522020102"]="---------(0522020102)书报杂志";
	array["0522020103"]="---------(0522020103)教材、资料费";
	array["0522020199"]="---------(0522020199)其他";
	array["05220202"]="------(05220202)专用材料购置费";
	array["0522020201"]="---------(0522020201)实验材料";
	array["0522020202"]="---------(0522020202)软件购置费";
	array["0522020203"]="---------(0522020203)体育器材费";
	array["0522020204"]="---------(0522020204)低值仪器";
	array["0522020299"]="---------(0522020299)其他";
	array["05220203"]="------(05220203)印刷费";
	array["05220204"]="------(05220204)劳务费";
	array["0522020401"]="---------(0522020401)兼课酬金";
	array["0522020402"]="---------(0522020402)访问学者津贴";
	array["0522020403"]="---------(0522020403)临时聘用人员费用";
	array["0522020404"]="---------(0522020404)非全日制用工";
	array["0522020499"]="---------(0522020499)其他";
	array["05220205"]="------(05220205)电费";
	array["05220206"]="------(05220206)邮电费";
	array["0522020601"]="---------(0522020601)邮费";
	array["0522020602"]="---------(0522020602)办公电话通讯费";
	array["0522020603"]="---------(0522020603)住宅电话通讯费";
	array["05220207"]="------(05220207)水费";
	array["05220209"]="------(05220209)物业管理费";
	array["0522020901"]="---------(0522020901)物业费";
	array["0522020902"]="---------(0522020902)绿化清洁费";
	array["0522020904"]="---------(0522020904)公用房资源使用费";
	array["05220210"]="------(05220210)交通费";
	array["0522021099"]="---------(0522021099)其他";
	array["05220211"]="------(05220211)差旅费";
	array["0522021101"]="---------(0522021101)出差交通住宿费";
	array["0522021102"]="---------(0522021102)出差补贴";
	array["05220212"]="------(05220212)维修费";
	array["0522021201"]="---------(0522021201)仪器设备维修费";
	array["0522021202"]="---------(0522021202)一般设备维修费";
	array["0522021203"]="---------(0522021203)办公用房维修费";
	array["0522021205"]="---------(0522021205)网络信息系统运行维护费";
	array["0522021299"]="---------(0522021299)其他维修费";
	array["05220213"]="------(05220213)租赁费";
	array["05220214"]="------(05220214)会议费";
	array["05220215"]="------(05220215)培训费";
	array["05220216"]="------(05220216)招待费";
	array["0522021601"]="---------(0522021601)招待费";
	array["0522021602"]="---------(0522021602)外事费";
	array["05220218"]="------(05220218)福利费";
	array["0522021801"]="---------(0522021801)计提福利费";
	array["0522021802"]="---------(0522021802)福利性支出";
	array["05220219"]="------(05220219)工会经费";
	array["05220221"]="------(05220221)出国费";
	array["0522022101"]="---------(0522022101)出差交通住宿费";
	array["0522022102"]="---------(0522022102)出差补贴";
	array["05220222"]="------(05220222)咨询费";
	array["0522022201"]="---------(0522022201)专家咨询费";
	array["0522022299"]="---------(0522022299)其他";
	array["05220223"]="------(05220223)手续费";
	array["05220224"]="------(05220224)委托业务费";
	array["05220225"]="------(05220225)税金及附加";
	array["05220233"]="------(05220233)手续费";
	array["05220299"]="------(05220299)其他";
	array["0522029901"]="---------(0522029901)科研管理费";
	array["0522029902"]="---------(0522029902)国内专家来访费";
	array["0522029903"]="---------(0522029903)科研及专项业务活动支出";
	array["0522029904"]="---------(0522029904)活动费";
	array["0522029905"]="---------(0522029905)国外专家来访费";
	array["0522029908"]="---------(0522029908)科研协作费";
	array["0522029999"]="---------(0522029999)其他";
	
	array["052203"]="---(052203)对个人和家庭补助支出";
	array["05220314"]="------(05220314)医疗费";
	array["05220316"]="------(05220316)住房公积金";
	array["05220317"]="------(05220317)购房补贴";
	array["0522031701"]="---------(0522031701)购房补贴";
	array["0522031702"]="---------(0522031702)校内住房补贴";
	array["0522031703"]="---------(0522031703)校内租金补贴";
	array["0522031704"]="---------(0522031704)贷款贴息";
	array["0522031705"]="---------(0522031705)新进职工购房补贴";
	array["05220319"]="------(05220319)奖励金";
	array["05220325"]="------(05220325)助学金";
	array["0522032514"]="---------(0522032514)本科生其他补贴";
	array["0522032516"]="---------(0522032516)本科生奖学金";
	array["0522032517"]="---------(0522032517)本科生勤工助学酬金";
	array["0522032518"]="---------(0522032518)本科生生助教助研酬金";
	array["0522032524"]="---------(0522032524)硕士生其他补贴";
	array["0522032527"]="---------(0522032527)硕士生勤工助学酬金";
	array["0522032528"]="---------(0522032528)硕士生助教助研酬金";
	array["0522032529"]="---------(0522032529)硕士生奖助学金";
	array["0522032534"]="---------(0522032534)博士生其他补贴";
	array["0522032537"]="---------(0522032537)博士生勤工助学酬金";
	array["0522032538"]="---------(0522032538)博士生助教助研酬金";
	array["0522032539"]="---------(0522032539)博士生奖助学金";
	array["05220399"]="------(05220399)其他";
	array["0522039999"]="---------(0522039999)其他";
	
	array["052204"]="---(052204)其他资本性支出";
	array["05220401"]="------(05220401)房屋建筑物购建费";
	array["05220402"]="------(05220402)办公设备购置";
	array["0522040201"]="---------(0522040201)一般设备购置费";
	array["0522040202"]="---------(0522040202)家具设备购置费";
	array["05220403"]="------(05220403)专用设备购置";
	array["05220404"]="------(05220404)交通工具购置";
	array["05220405"]="------(05220405)基础设施建设";
	array["05220406"]="------(05220406)大型修缮";
	array["05220407"]="------(05220407)信息网络构建";
	array["05220499"]="------(05220499)其他";
	array["0522049901"]="---------(0522049901)图书资料购置费";
	array["0522049902"]="---------(0522049902)无形资产购置费";
	array["0522049999"]="---------(0522049999)其他";
	return array;
}

/******************************select item0******************************/
//创建用于显示隐藏的tableDiv  
var div0;  
function showDiv0() {  
	div0.style.display = "block";  
}  
function hideDiv0() {  
	div0.style.display = "none";  
}  

/* 
*根据复选框中的数值，更新input表单的显示。 
*当下拉框中每个checkbox被点击后，触发刚方法。 
*/  
function updateValue0() {  
	var value = "";   
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox0.length;  
	for (var i = 0; i < len; i++) {  
		if (form.checkbox0[i].checked) {  
			var v = form.checkbox0[i].value;   
			value = value + v + ";";  
		}  
	}  
	form.research.value = value;  
}  
function setSelectBox0(textItem, myArray) {  
	//复选下拉框首次创建，并显示  
	if (div0 == undefined) {  
		var itemTop = textItem.offsetTop;    //控件的定位点top  
		var itemHeight = textItem.clientHeight;    //控件本身的height  
		var itemLeft = textItem.offsetLeft;    //控件的定位点left  

		var top = itemTop + itemHeight - 5;  

		div0 = document.createElement("div0");  
		div0.onmouseover = showDiv0;  
		div0.onmouseout = hideDiv0;  
		//下拉层的位置、下拉滚动等样式  
		var trs = '<div id="tableDiv" style="position:abosolute;text-align: center;OVERFLOW: auto; SCROLLBAR-BASE-COLOR: #cccccc; HEIGHT: 200px;SCROLLBAR-FACE-COLOR: #ffffff;top:' + top + '; left:' + itemLeft + ';WIDTH:390px;Z-INDEX: 1;SCROLLBAR-SHADOW-COLOR:#cccccc;SCROLLBAR-ARROW-COLOR: #cccccc;SCROLLBAR-3DLIGHT-COLOR: #cccccc; background-color: #ffffff; border: 1px solid grey"><table>';  
		trs += '<table>';  
		//初始化下拉的选项  
		for (var key in myArray) {  
			trs += '<tr><td><input type="checkbox" name="checkbox0" value="' + key + '" onchange="updateValue0()">' + myArray[key] + '</td></tr>';  
		}	  
		trs += '</table></div>';  
		div0.innerHTML = trs;    
		textItem.parentNode.appendChild(div0);  
	} 	 
	else {  
		//该复选下拉的层已经创建了，那么再次点击input表单的时候，显示  
		showDiv0();  
	}  
}  

function selectItem0(textItem) { 
	var myArray = generateArray();
	setSelectBox0(textItem, myArray);
	var defaultSelected = $("#research").val();
	var strs = defaultSelected.split(";");
	
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox0.length; 
	for(var i=0;i<strs.length;i++) {
		for(var j=0;j<len;j++) {
			if (form.checkbox0[j].value == strs[i]) {  
				form.checkbox0[j].checked = true;     
			}
		}
	}
}

/******************************select item1******************************/
//创建用于显示隐藏的tableDiv  
var div1;  
function showDiv1() {  
	div1.style.display = "block";  
}  
function hideDiv1() {  
	div1.style.display = "none";  
}  

/* 
*根据复选框中的数值，更新input表单的显示。 
*当下拉框中每个checkbox被点击后，触发刚方法。 
*/  
function updateValue1() {  
	var value = "";   
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox1.length;  
	for (var i = 0; i < len; i++) {  
		if (form.checkbox1[i].checked) {  
			var v = form.checkbox1[i].value;   
			value = value + v + ";";  
		}  	
	}  
	form.srbusiness.value = value;  
}  
function setSelectBox1(textItem, myArray) {  
	//复选下拉框首次创建，并显示  
	if (div1 == undefined) {  
		var itemTop = textItem.offsetTop;    //控件的定位点top  
		var itemHeight = textItem.clientHeight;    //控件本身的height  
		var itemLeft = textItem.offsetLeft;    //控件的定位点left  

		var top = itemTop + itemHeight - 5;  

		div1 = document.createElement("div1");  
		div1.onmouseover = showDiv1;  
		div1.onmouseout = hideDiv1;  
		//下拉层的位置、下拉滚动等样式  
		var trs = '<div id="tableDiv" style="position:abosolute;text-align: center;OVERFLOW: auto; SCROLLBAR-BASE-COLOR: #cccccc; HEIGHT: 200px;SCROLLBAR-FACE-COLOR: #ffffff;top:' + top + '; left:' + itemLeft + ';WIDTH:390px;Z-INDEX: 1;SCROLLBAR-SHADOW-COLOR:#cccccc;SCROLLBAR-ARROW-COLOR: #cccccc;SCROLLBAR-3DLIGHT-COLOR: #cccccc; background-color: #ffffff; border: 1px solid grey"><table>';  
		trs += '<table>';  
		//初始化下拉的选项  
		for (var key in myArray) {  
			trs += '<tr><td><input type="checkbox" name="checkbox1" value="' + key + '" onchange="updateValue1()">' + myArray[key] + '</td></tr>';  
		}  
		trs += '</table></div>';  
		div1.innerHTML = trs;    
		textItem.parentNode.appendChild(div1);  
	}  
	else {  
		//该复选下拉的层已经创建了，那么再次点击input表单的时候，显示  
		showDiv1();  
	}  
}  

function selectItem1(textItem) { 
	var myArray = generateArray(); 
	setSelectBox1(textItem, myArray);
	var defaultSelected = $("#srbusiness").val();
	var strs = defaultSelected.split(";");
	
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox1.length; 
	for(var i=0;i<strs.length;i++) {
		for(var j=0;j<len;j++) {
			if (form.checkbox1[j].value == strs[i]) {  
				form.checkbox1[j].checked = true;     
			}
		}
	}
}

/******************************select item2******************************/
//创建用于显示隐藏的tableDiv  
var div2;  
function showDiv2() {  
	div2.style.display = "block";  
}  
function hideDiv2() {  
	div2.style.display = "none";  
}  

/* 
*根据复选框中的数值，更新input表单的显示。 
*当下拉框中每个checkbox被点击后，触发刚方法。 
*/  
function updateValue2() {  
	var value = "";   
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox2.length;  
	for (var i = 0; i < len; i++) {  
		if (form.checkbox2[i].checked) {  
			var v = form.checkbox2[i].value;   
			value = value + v + ";";  
		}  	
	}  
	form.test.value = value;  
}  
function setSelectBox2(textItem, myArray) {  
	//复选下拉框首次创建，并显示  
	if (div2 == undefined) {  
		var itemTop = textItem.offsetTop;    //控件的定位点top  
		var itemHeight = textItem.clientHeight;    //控件本身的height  
		var itemLeft = textItem.offsetLeft;    //控件的定位点left  

		var top = itemTop + itemHeight - 5;  

		div2 = document.createElement("div2");  
		div2.onmouseover = showDiv2;  
		div2.onmouseout = hideDiv2;  
		//下拉层的位置、下拉滚动等样式  
		var trs = '<div id="tableDiv" style="position:abosolute;text-align: center;OVERFLOW: auto; SCROLLBAR-BASE-COLOR: #cccccc; HEIGHT: 200px;SCROLLBAR-FACE-COLOR: #ffffff;top:' + top + '; left:' + itemLeft + ';WIDTH:390px;Z-INDEX: 1;SCROLLBAR-SHADOW-COLOR:#cccccc;SCROLLBAR-ARROW-COLOR: #cccccc;SCROLLBAR-3DLIGHT-COLOR: #cccccc; background-color: #ffffff; border: 1px solid grey"><table>';  
		trs += '<table>';  
		//初始化下拉的选项  
		for (var key in myArray) {  
			trs += '<tr><td><input type="checkbox" name="checkbox2" value="' + key + '" onchange="updateValue2()">' + myArray[key] + '</td></tr>';  
		}  
		trs += '</table></div>';  
		div2.innerHTML = trs;    
		textItem.parentNode.appendChild(div2);  
	}  
	else {  
		//该复选下拉的层已经创建了，那么再次点击input表单的时候，显示  
		showDiv2();  
	}  
}  

function selectItem2(textItem) { 
	var myArray = generateArray(); 
	setSelectBox2(textItem, myArray); 
	var defaultSelected = $("#test").val();
	var strs = defaultSelected.split(";");
	
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox2.length; 
	for(var i=0;i<strs.length;i++) {
		for(var j=0;j<len;j++) {
			if (form.checkbox2[j].value == strs[i]) {  
				form.checkbox2[j].checked = true;     
			}
		}
	}
}

/******************************select item3******************************/
//创建用于显示隐藏的tableDiv  
var div3;  
function showDiv3() {  
	div3.style.display = "block";  
}  
function hideDiv3() {  
	div3.style.display = "none";  
}  

/* 
*根据复选框中的数值，更新input表单的显示。 
*当下拉框中每个checkbox被点击后，触发刚方法。 
*/  
function updateValue3() {  
	var value = "";   
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox3.length;  
	for (var i = 0; i < len; i++) {  
		if (form.checkbox3[i].checked) {  
			var v = form.checkbox3[i].value;   
			value = value + v + ";";  
		}  	
	}  
	form.energy.value = value;  
}  
function setSelectBox3(textItem, myArray) {  
	//复选下拉框首次创建，并显示  
	if (div3 == undefined) {  
		var itemTop = textItem.offsetTop;    //控件的定位点top  
		var itemHeight = textItem.clientHeight;    //控件本身的height  
		var itemLeft = textItem.offsetLeft;    //控件的定位点left  

		var top = itemTop + itemHeight - 5;  

		div3 = document.createElement("div3");  
		div3.onmouseover = showDiv3;  
		div3.onmouseout = hideDiv3;  
		//下拉层的位置、下拉滚动等样式  
		var trs = '<div id="tableDiv" style="position:abosolute;text-align: center;OVERFLOW: auto; SCROLLBAR-BASE-COLOR: #cccccc; HEIGHT: 200px;SCROLLBAR-FACE-COLOR: #ffffff;top:' + top + '; left:' + itemLeft + ';WIDTH:390px;Z-INDEX: 1;SCROLLBAR-SHADOW-COLOR:#cccccc;SCROLLBAR-ARROW-COLOR: #cccccc;SCROLLBAR-3DLIGHT-COLOR: #cccccc; background-color: #ffffff; border: 1px solid grey"><table>';  
		trs += '<table>';  
		//初始化下拉的选项  
		for (var key in myArray) {  
			trs += '<tr><td><input type="checkbox" name="checkbox3" value="' + key + '" onchange="updateValue3()">' + myArray[key] + '</td></tr>';  
		}  
		trs += '</table></div>';  
		div3.innerHTML = trs;    
		textItem.parentNode.appendChild(div3);	
	}  
	else {  
		//该复选下拉的层已经创建了，那么再次点击input表单的时候，显示  
		showDiv3();  
	}
}  

function selectItem3(textItem) { 
	var myArray = generateArray();
	setSelectBox3(textItem, myArray);
	var defaultSelected = $("#energy").val();
	var strs = defaultSelected.split(";");
	
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox3.length; 
	for(var i=0;i<strs.length;i++) {
		for(var j=0;j<len;j++) {
			if (form.checkbox3[j].value == strs[i]) {  
				form.checkbox3[j].checked = true;     
			}
		}
	}
}

/******************************select item4******************************/
//创建用于显示隐藏的tableDiv  
var div4;  
function showDiv4() {  
	div4.style.display = "block";  
}  
function hideDiv4() {  
	div4.style.display = "none";  
}  

/* 
*根据复选框中的数值，更新input表单的显示。 
*当下拉框中每个checkbox被点击后，触发刚方法。 
*/  
function updateValue4() {  
	var value = "";   
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox4.length;  
	for (var i = 0; i < len; i++) {  
		if (form.checkbox4[i].checked) {  
			var v = form.checkbox4[i].value;   
			value = value + v + ";";  
		}  	
	}  
	form.meetings.value = value;  
}  
function setSelectBox4(textItem, myArray) {  
	//复选下拉框首次创建，并显示  
	if (div4 == undefined) {  
		var itemTop = textItem.offsetTop;    //控件的定位点top  
		var itemHeight = textItem.clientHeight;    //控件本身的height  
		var itemLeft = textItem.offsetLeft;    //控件的定位点left  

		var top = itemTop + itemHeight - 5;  

		div4 = document.createElement("div4");  
		div4.onmouseover = showDiv4;  
		div4.onmouseout = hideDiv4;  
		//下拉层的位置、下拉滚动等样式  
		var trs = '<div id="tableDiv" style="position:abosolute;text-align: center;OVERFLOW: auto; SCROLLBAR-BASE-COLOR: #cccccc; HEIGHT: 200px;SCROLLBAR-FACE-COLOR: #ffffff;top:' + top + '; left:' + itemLeft + ';WIDTH:390px;Z-INDEX: 1;SCROLLBAR-SHADOW-COLOR:#cccccc;SCROLLBAR-ARROW-COLOR: #cccccc;SCROLLBAR-3DLIGHT-COLOR: #cccccc; background-color: #ffffff; border: 1px solid grey"><table>';  
		trs += '<table>';  
		//初始化下拉的选项  
		for (var key in myArray) {  
			trs += '<tr><td><input type="checkbox" name="checkbox4" value="' + key + '" onchange="updateValue4()">' + myArray[key] + '</td></tr>';  
		}  
		trs += '</table></div>';  
		div4.innerHTML = trs;    
		textItem.parentNode.appendChild(div4);  
	}  
	else {  
		//该复选下拉的层已经创建了，那么再次点击input表单的时候，显示  
		showDiv4();  
	}  
}  

function selectItem4(textItem) { 
	var myArray = generateArray(); 
	setSelectBox4(textItem, myArray); 
	var defaultSelected = $("#meetings").val();
	var strs = defaultSelected.split(";");
	
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox4.length; 
	for(var i=0;i<strs.length;i++) {
		for(var j=0;j<len;j++) {
			if (form.checkbox4[j].value == strs[i]) {  
				form.checkbox4[j].checked = true;     
			}
		}
	}
}

/******************************select item5******************************/
//创建用于显示隐藏的tableDiv  
var div5;  
function showDiv5() {  
	div5.style.display = "block";  
}  
function hideDiv5() {  
	div5.style.display = "none";  
}  

/* 
*根据复选框中的数值，更新input表单的显示。 
*当下拉框中每个checkbox被点击后，触发刚方法。 
*/  
function updateValue5() {  
	var value = "";   
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox5.length;  
	for (var i = 0; i < len; i++) {  
		if (form.checkbox5[i].checked) {  
			var v = form.checkbox5[i].value;   
			value = value + v + ";";  
		}  	
	}  
	form.publishments.value = value;  
}  
function setSelectBox5(textItem, myArray) {  
	//复选下拉框首次创建，并显示  
	if (div5 == undefined) {  
		var itemTop = textItem.offsetTop;    //控件的定位点top  
		var itemHeight = textItem.clientHeight;    //控件本身的height  
		var itemLeft = textItem.offsetLeft;    //控件的定位点left  

		var top = itemTop + itemHeight - 5;  

		div5 = document.createElement("div5");  
		div5.onmouseover = showDiv5;  
		div5.onmouseout = hideDiv5;  
		//下拉层的位置、下拉滚动等样式  
		var trs = '<div id="tableDiv" style="position:abosolute;text-align: center;OVERFLOW: auto; SCROLLBAR-BASE-COLOR: #cccccc; HEIGHT: 200px;SCROLLBAR-FACE-COLOR: #ffffff;top:' + top + '; left:' + itemLeft + ';WIDTH:390px;Z-INDEX: 1;SCROLLBAR-SHADOW-COLOR:#cccccc;SCROLLBAR-ARROW-COLOR: #cccccc;SCROLLBAR-3DLIGHT-COLOR: #cccccc; background-color: #ffffff; border: 1px solid grey"><table>';  
		trs += '<table>';  
		//初始化下拉的选项  
		for (var key in myArray) {  
			trs += '<tr><td><input type="checkbox" name="checkbox5" value="' + key + '" onchange="updateValue5()">' + myArray[key] + '</td></tr>';  
		}  
		trs += '</table></div>';  
		div5.innerHTML = trs;    
		textItem.parentNode.appendChild(div5);  
	}  
	else {  
		//该复选下拉的层已经创建了，那么再次点击input表单的时候，显示  
		showDiv5();  
	}  
}  

function selectItem5(textItem) { 
	var myArray = generateArray();
	setSelectBox5(textItem, myArray);
	var defaultSelected = $("#publishments").val();
	var strs = defaultSelected.split(";");
	
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox5.length; 
	for(var i=0;i<strs.length;i++) {
		for(var j=0;j<len;j++) {
			if (form.checkbox5[j].value == strs[i]) {  
				form.checkbox5[j].checked = true;     
			}
		}
	}
}

/******************************select item6******************************/
//创建用于显示隐藏的tableDiv  
var div6;  
function showDiv6() {  
	div6.style.display = "block";  
}  
function hideDiv6() {  
	div6.style.display = "none";  
}  

/* 
*根据复选框中的数值，更新input表单的显示。 
*当下拉框中每个checkbox被点击后，触发刚方法。 
*/  
function updateValue6() {  
	var value = "";   
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox6.length;  
	for (var i = 0; i < len; i++) {  
		if (form.checkbox6[i].checked) {  
			var v = form.checkbox6[i].value;   
			value = value + v + ";";  
		}  	
	}  
	form.other_srbusiness.value = value;  
}  
function setSelectBox6(textItem, myArray) {  
	//复选下拉框首次创建，并显示  
	if (div6 == undefined) {  
		var itemTop = textItem.offsetTop;    //控件的定位点top  
		var itemHeight = textItem.clientHeight;    //控件本身的height  
		var itemLeft = textItem.offsetLeft;    //控件的定位点left  

		var top = itemTop + itemHeight - 5;  

		div6 = document.createElement("div6");  
		div6.onmouseover = showDiv6;  
		div6.onmouseout = hideDiv6;  
		//下拉层的位置、下拉滚动等样式  
		var trs = '<div id="tableDiv" style="position:abosolute;text-align: center;OVERFLOW: auto; SCROLLBAR-BASE-COLOR: #cccccc; HEIGHT: 200px;SCROLLBAR-FACE-COLOR: #ffffff;top:' + top + '; left:' + itemLeft + ';WIDTH:390px;Z-INDEX: 1;SCROLLBAR-SHADOW-COLOR:#cccccc;SCROLLBAR-ARROW-COLOR: #cccccc;SCROLLBAR-3DLIGHT-COLOR: #cccccc; background-color: #ffffff; border: 1px solid grey"><table>';  
		trs += '<table>';  
		//初始化下拉的选项  
		for (var key in myArray) {  
			trs += '<tr><td><input type="checkbox" name="checkbox6" value="' + key + '" onchange="updateValue6()">' + myArray[key] + '</td></tr>';  
		}  
		trs += '</table></div>';  
		div6.innerHTML = trs;    
		textItem.parentNode.appendChild(div6);  
	}  
	else {  
		//该复选下拉的层已经创建了，那么再次点击input表单的时候，显示  
		showDiv6();  
	}  
}  

function selectItem6(textItem) { 
	var myArray = generateArray();
	setSelectBox6(textItem, myArray);
	var defaultSelected = $("#other_srbusiness").val();
	var strs = defaultSelected.split(";");
	
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox6.length; 
	for(var i=0;i<strs.length;i++) {
		for(var j=0;j<len;j++) {
			if (form.checkbox6[j].value == strs[i]) {  
				form.checkbox6[j].checked = true;     
			}
		}
	}
}

/******************************select item7******************************/
//创建用于显示隐藏的tableDiv  
var div7;  
function showDiv7() {  
	div7.style.display = "block";  
}  
function hideDiv7() {  
	div7.style.display = "none";  
}  

/* 
*根据复选框中的数值，更新input表单的显示。 
*当下拉框中每个checkbox被点击后，触发刚方法。 
*/  
function updateValue7() {  
	var value = "";   
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox7.length;  
	for (var i = 0; i < len; i++) {  
		if (form.checkbox7[i].checked) {  
			var v = form.checkbox7[i].value;   
			value = value + v + ";";  
		}  	
	}  
	form.experiment_material.value = value;  
}  
function setSelectBox7(textItem, myArray) {  
	//复选下拉框首次创建，并显示  
	if (div7 == undefined) {  
		var itemTop = textItem.offsetTop;    //控件的定位点top  
		var itemHeight = textItem.clientHeight;    //控件本身的height  
		var itemLeft = textItem.offsetLeft;    //控件的定位点left  

		var top = itemTop + itemHeight - 5;  

		div7 = document.createElement("div7");  
		div7.onmouseover = showDiv7;  
		div7.onmouseout = hideDiv7;  
		//下拉层的位置、下拉滚动等样式  
		var trs = '<div id="tableDiv" style="position:abosolute;text-align: center;OVERFLOW: auto; SCROLLBAR-BASE-COLOR: #cccccc; HEIGHT: 200px;SCROLLBAR-FACE-COLOR: #ffffff;top:' + top + '; left:' + itemLeft + ';WIDTH:390px;Z-INDEX: 1;SCROLLBAR-SHADOW-COLOR:#cccccc;SCROLLBAR-ARROW-COLOR: #cccccc;SCROLLBAR-3DLIGHT-COLOR: #cccccc; background-color: #ffffff; border: 1px solid grey"><table>';  
		trs += '<table>';  
		//初始化下拉的选项  
		for (var key in myArray) {  
			trs += '<tr><td><input type="checkbox" name="checkbox7" value="' + key + '" onchange="updateValue7()">' + myArray[key] + '</td></tr>';  
		}  
		trs += '</table></div>';  
		div7.innerHTML = trs;    
		textItem.parentNode.appendChild(div7);  
	}  
	else {  
		//该复选下拉的层已经创建了，那么再次点击input表单的时候，显示  
		showDiv7();  
	}  
}  

function selectItem7(textItem) { 
	var myArray = generateArray(); 
	setSelectBox7(textItem, myArray);
	var defaultSelected = $("#experiment_material").val();
	var strs = defaultSelected.split(";");
	
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox7.length; 
	for(var i=0;i<strs.length;i++) {
		for(var j=0;j<len;j++) {
			if (form.checkbox7[j].value == strs[i]) {  
				form.checkbox7[j].checked = true;     
			}
		}
	}
}

/******************************select item8******************************/
//创建用于显示隐藏的tableDiv  
var div8;  
function showDiv8() {  
	div8.style.display = "block";  
}  
function hideDiv8() {  
	div8.style.display = "none";  
}  

/* 
*根据复选框中的数值，更新input表单的显示。 
*当下拉框中每个checkbox被点击后，触发刚方法。 
*/  
function updateValue8() {  
	var value = "";   
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox8.length;  
	for (var i = 0; i < len; i++) {  
		if (form.checkbox8[i].checked) {  
			var v = form.checkbox8[i].value;   
			value = value + v + ";";  
		}  	
	}  
	form.raw_material.value = value;  
}  
function setSelectBox8(textItem, myArray) {  
	//复选下拉框首次创建，并显示  
	if (div8 == undefined) {  
		var itemTop = textItem.offsetTop;    //控件的定位点top  
		var itemHeight = textItem.clientHeight;    //控件本身的height  
		var itemLeft = textItem.offsetLeft;    //控件的定位点left  

		var top = itemTop + itemHeight - 5;  

		div8 = document.createElement("div8");  
		div8.onmouseover = showDiv8;  
		div8.onmouseout = hideDiv8;  
		//下拉层的位置、下拉滚动等样式  
		var trs = '<div id="tableDiv" style="position:abosolute;text-align: center;OVERFLOW: auto; SCROLLBAR-BASE-COLOR: #cccccc; HEIGHT: 200px;SCROLLBAR-FACE-COLOR: #ffffff;top:' + top + '; left:' + itemLeft + ';WIDTH:390px;Z-INDEX: 1;SCROLLBAR-SHADOW-COLOR:#cccccc;SCROLLBAR-ARROW-COLOR: #cccccc;SCROLLBAR-3DLIGHT-COLOR: #cccccc; background-color: #ffffff; border: 1px solid grey"><table>';  
		trs += '<table>';  
		//初始化下拉的选项  
		for (var key in myArray) {  
			trs += '<tr><td><input type="checkbox" name="checkbox8" value="' + key + '" onchange="updateValue8()">' + myArray[key] + '</td></tr>';  
		}  
		trs += '</table></div>';  
		div8.innerHTML = trs;    
		textItem.parentNode.appendChild(div8);  
	}  
	else {  
		//该复选下拉的层已经创建了，那么再次点击input表单的时候，显示  
		showDiv8();  
	}  
}  

function selectItem8(textItem) { 
	var myArray = generateArray(); 
	setSelectBox8(textItem, myArray);
	var defaultSelected = $("#raw_material").val();
	var strs = defaultSelected.split(";");
	
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox8.length; 
	for(var i=0;i<strs.length;i++) {
		for(var j=0;j<len;j++) {
			if (form.checkbox8[j].value == strs[i]) {  
				form.checkbox8[j].checked = true;     
			}
		}
	}
}

/******************************select item9******************************/
//创建用于显示隐藏的tableDiv  
var div9;  
function showDiv9() {  
	div9.style.display = "block";  
}  
function hideDiv9() {  
	div9.style.display = "none";  
}  

/* 
*根据复选框中的数值，更新input表单的显示。 
*当下拉框中每个checkbox被点击后，触发刚方法。 
*/  
function updateValue9() {  
	var value = "";   
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox9.length;  
	for (var i = 0; i < len; i++) {  
		if (form.checkbox9[i].checked) {  
			var v = form.checkbox9[i].value;   
			value = value + v + ";";  
		}  	
	}  
	form.other_material.value = value;  
}  
function setSelectBox9(textItem, myArray) {  
	//复选下拉框首次创建，并显示  
	if (div9 == undefined) {  
		var itemTop = textItem.offsetTop;    //控件的定位点top  
		var itemHeight = textItem.clientHeight;    //控件本身的height  
		var itemLeft = textItem.offsetLeft;    //控件的定位点left  

		var top = itemTop + itemHeight - 5;  

		div9 = document.createElement("div9");  
		div9.onmouseover = showDiv9;  
		div9.onmouseout = hideDiv9;  
		//下拉层的位置、下拉滚动等样式  
		var trs = '<div id="tableDiv" style="position:abosolute;text-align: center;OVERFLOW: auto; SCROLLBAR-BASE-COLOR: #cccccc; HEIGHT: 200px;SCROLLBAR-FACE-COLOR: #ffffff;top:' + top + '; left:' + itemLeft + ';WIDTH:390px;Z-INDEX: 1;SCROLLBAR-SHADOW-COLOR:#cccccc;SCROLLBAR-ARROW-COLOR: #cccccc;SCROLLBAR-3DLIGHT-COLOR: #cccccc; background-color: #ffffff; border: 1px solid grey"><table>';  
		trs += '<table>';  
		//初始化下拉的选项  
		for (var key in myArray) {  
			trs += '<tr><td><input type="checkbox" name="checkbox9" value="' + key + '" onchange="updateValue9()">' + myArray[key] + '</td></tr>';  
		}  
		trs += '</table></div>';  
		div9.innerHTML = trs;    
		textItem.parentNode.appendChild(div9);  
	}  
	else {  
		//该复选下拉的层已经创建了，那么再次点击input表单的时候，显示  
		showDiv9();  
	}  
}  

function selectItem9(textItem) { 
	var myArray = generateArray();
	setSelectBox9(textItem, myArray);
	var defaultSelected = $("#other_material").val();
	var strs = defaultSelected.split(";");
	
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox9.length; 
	for(var i=0;i<strs.length;i++) {
		for(var j=0;j<len;j++) {
			if (form.checkbox9[j].value == strs[i]) {  
				form.checkbox9[j].checked = true;     
			}
		}
	}
}

/******************************select item10******************************/
//创建用于显示隐藏的tableDiv  
var div10;  
function showDiv10() {  
	div10.style.display = "block";  
}  
function hideDiv10() {  
	div10.style.display = "none";  
}  

/* 
*根据复选框中的数值，更新input表单的显示。 
*当下拉框中每个checkbox被点击后，触发刚方法。 
*/  
function updateValue10() {  
	var value = "";   
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox10.length;  
	for (var i = 0; i < len; i++) {  
		if (form.checkbox10[i].checked) {  
			var v = form.checkbox10[i].value;   
			value = value + v + ";";  
		}  
	}  
	form.equipment.value = value;  
}  
function setSelectBox10(textItem, myArray) {  
	//复选下拉框首次创建，并显示  
	if (div10 == undefined) {  
		var itemTop = textItem.offsetTop;    //控件的定位点top  
		var itemHeight = textItem.clientHeight;    //控件本身的height  
		var itemLeft = textItem.offsetLeft;    //控件的定位点left  

		var top = itemTop + itemHeight - 5;  

		div10 = document.createElement("div10");  
		div10.onmouseover = showDiv10;  
		div10.onmouseout = hideDiv10;  
		//下拉层的位置、下拉滚动等样式  
		var trs = '<div id="tableDiv" style="position:abosolute;text-align: center;OVERFLOW: auto; SCROLLBAR-BASE-COLOR: #cccccc; HEIGHT: 200px;SCROLLBAR-FACE-COLOR: #ffffff;top:' + top + '; left:' + itemLeft + ';WIDTH:390px;Z-INDEX: 1;SCROLLBAR-SHADOW-COLOR:#cccccc;SCROLLBAR-ARROW-COLOR: #cccccc;SCROLLBAR-3DLIGHT-COLOR: #cccccc; background-color: #ffffff; border: 1px solid grey"><table>';  
		trs += '<table>';  
		//初始化下拉的选项  
		for (var key in myArray) {  
			trs += '<tr><td><input type="checkbox" name="checkbox10" value="' + key + '" onchange="updateValue10()">' + myArray[key] + '</td></tr>';  
		}	  
		trs += '</table></div>';  
		div10.innerHTML = trs;    
		textItem.parentNode.appendChild(div10);  
	} 	 
	else {  
		//该复选下拉的层已经创建了，那么再次点击input表单的时候，显示  
		showDiv10();  
	}  
}  

function selectItem10(textItem) { 
	var myArray = generateArray();
	setSelectBox10(textItem, myArray);
	var defaultSelected = $("#equipment").val();
	var strs = defaultSelected.split(";");
	
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox10.length; 
	for(var i=0;i<strs.length;i++) {
		for(var j=0;j<len;j++) {
			if (form.checkbox10[j].value == strs[i]) {  
				form.checkbox10[j].checked = true;     
			}
		}
	}
}

/******************************select item11******************************/
//创建用于显示隐藏的tableDiv  
var div11;  
function showDiv11() {  
	div11.style.display = "block";  
}  
function hideDiv11() {  
	div11.style.display = "none";  
}  

/* 
*根据复选框中的数值，更新input表单的显示。 
*当下拉框中每个checkbox被点击后，触发刚方法。 
*/  
function updateValue11() {  
	var value = "";   
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox11.length;  
	for (var i = 0; i < len; i++) {  
		if (form.checkbox11[i].checked) {  
			var v = form.checkbox11[i].value;   
			value = value + v + ";";  
		}  	
	}  
	form.equipment_purchase.value = value;  
}  
function setSelectBox11(textItem, myArray) {  
	//复选下拉框首次创建，并显示  
	if (div11 == undefined) {  
		var itemTop = textItem.offsetTop;    //控件的定位点top  
		var itemHeight = textItem.clientHeight;    //控件本身的height  
		var itemLeft = textItem.offsetLeft;    //控件的定位点left  

		var top = itemTop + itemHeight - 5;  

		div11 = document.createElement("div11");  
		div11.onmouseover = showDiv11;  
		div11.onmouseout = hideDiv11;  
		//下拉层的位置、下拉滚动等样式  
		var trs = '<div id="tableDiv" style="position:abosolute;text-align: center;OVERFLOW: auto; SCROLLBAR-BASE-COLOR: #cccccc; HEIGHT: 200px;SCROLLBAR-FACE-COLOR: #ffffff;top:' + top + '; left:' + itemLeft + ';WIDTH:390px;Z-INDEX: 1;SCROLLBAR-SHADOW-COLOR:#cccccc;SCROLLBAR-ARROW-COLOR: #cccccc;SCROLLBAR-3DLIGHT-COLOR: #cccccc; background-color: #ffffff; border: 1px solid grey"><table>';  
		trs += '<table>';  
		//初始化下拉的选项  
		for (var key in myArray) {  
			trs += '<tr><td><input type="checkbox" name="checkbox11" value="' + key + '" onchange="updateValue11()">' + myArray[key] + '</td></tr>';  
		}  
		trs += '</table></div>';  
		div11.innerHTML = trs;    
		textItem.parentNode.appendChild(div11);  
	}  
	else {  
		//该复选下拉的层已经创建了，那么再次点击input表单的时候，显示  
		showDiv11();  
	}  
}  

function selectItem11(textItem) { 
	var myArray = generateArray();
	setSelectBox11(textItem, myArray); 
	var defaultSelected = $("#equipment_purchase").val();
	var strs = defaultSelected.split(";");
	
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox11.length; 
	for(var i=0;i<strs.length;i++) {
		for(var j=0;j<len;j++) {
			if (form.checkbox11[j].value == strs[i]) {  
				form.checkbox11[j].checked = true;     
			}
		}
	}
}

/******************************select item12******************************/
//创建用于显示隐藏的tableDiv  
var div12;  
function showDiv12() {  
	div12.style.display = "block";  
}  
function hideDiv12() {  
	div12.style.display = "none";  
}  

/* 
*根据复选框中的数值，更新input表单的显示。 
*当下拉框中每个checkbox被点击后，触发刚方法。 
*/  
function updateValue12() {  
	var value = "";   
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox12.length;  
	for (var i = 0; i < len; i++) {  
		if (form.checkbox12[i].checked) {  
			var v = form.checkbox12[i].value;   
			value = value + v + ";";  
		}  	
	}  
	form.equipment_produce.value = value;  
}  
function setSelectBox12(textItem, myArray) {  
	//复选下拉框首次创建，并显示  
	if (div12 == undefined) {  
		var itemTop = textItem.offsetTop;    //控件的定位点top  
		var itemHeight = textItem.clientHeight;    //控件本身的height  
		var itemLeft = textItem.offsetLeft;    //控件的定位点left  

		var top = itemTop + itemHeight - 5;  

		div12 = document.createElement("div12");  
		div12.onmouseover = showDiv12;  
		div12.onmouseout = hideDiv12;  
		//下拉层的位置、下拉滚动等样式  
		var trs = '<div id="tableDiv" style="position:abosolute;text-align: center;OVERFLOW: auto; SCROLLBAR-BASE-COLOR: #cccccc; HEIGHT: 200px;SCROLLBAR-FACE-COLOR: #ffffff;top:' + top + '; left:' + itemLeft + ';WIDTH:390px;Z-INDEX: 1;SCROLLBAR-SHADOW-COLOR:#cccccc;SCROLLBAR-ARROW-COLOR: #cccccc;SCROLLBAR-3DLIGHT-COLOR: #cccccc; background-color: #ffffff; border: 1px solid grey"><table>';  
		trs += '<table>';  
		//初始化下拉的选项  
		for (var key in myArray) {  
			trs += '<tr><td><input type="checkbox" name="checkbox12" value="' + key + '" onchange="updateValue12()">' + myArray[key] + '</td></tr>';  
		}  
		trs += '</table></div>';  
		div12.innerHTML = trs;    
		textItem.parentNode.appendChild(div12);  
	}  
	else {  
		//该复选下拉的层已经创建了，那么再次点击input表单的时候，显示  
		showDiv12();  
	}  
}  

function selectItem12(textItem) { 
	var myArray = generateArray(); 
	setSelectBox12(textItem, myArray);
	var defaultSelected = $("#equipment_produce").val();
	var strs = defaultSelected.split(";");
	
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox12.length; 
	for(var i=0;i<strs.length;i++) {
		for(var j=0;j<len;j++) {
			if (form.checkbox12[j].value == strs[i]) {  
				form.checkbox12[j].checked = true;     
			}
		}
	}
}

/******************************select item13******************************/
//创建用于显示隐藏的tableDiv  
var div13;  
function showDiv13() {  
	div13.style.display = "block";  
}  
function hideDiv13() {  
	div13.style.display = "none";  
}  

/* 
*根据复选框中的数值，更新input表单的显示。 
*当下拉框中每个checkbox被点击后，触发刚方法。 
*/  
function updateValue13() {  
	var value = "";   
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox13.length;  
	for (var i = 0; i < len; i++) {  
		if (form.checkbox13[i].checked) {  
			var v = form.checkbox13[i].value;   
			value = value + v + ";";  
		}  	
	}  
	form.lab_reconstruction.value = value;  
}  
function setSelectBox13(textItem, myArray) {  
	//复选下拉框首次创建，并显示  
	if (div13 == undefined) {  
		var itemTop = textItem.offsetTop;    //控件的定位点top  
		var itemHeight = textItem.clientHeight;    //控件本身的height  
		var itemLeft = textItem.offsetLeft;    //控件的定位点left  

		var top = itemTop + itemHeight - 5;  

		div13 = document.createElement("div13");  
		div13.onmouseover = showDiv13;  
		div13.onmouseout = hideDiv13;  
		//下拉层的位置、下拉滚动等样式  
		var trs = '<div id="tableDiv" style="position:abosolute;text-align: center;OVERFLOW: auto; SCROLLBAR-BASE-COLOR: #cccccc; HEIGHT: 200px;SCROLLBAR-FACE-COLOR: #ffffff;top:' + top + '; left:' + itemLeft + ';WIDTH:390px;Z-INDEX: 1;SCROLLBAR-SHADOW-COLOR:#cccccc;SCROLLBAR-ARROW-COLOR: #cccccc;SCROLLBAR-3DLIGHT-COLOR: #cccccc; background-color: #ffffff; border: 1px solid grey"><table>';  
		trs += '<table>';  
		//初始化下拉的选项  
		for (var key in myArray) {  
			trs += '<tr><td><input type="checkbox" name="checkbox13" value="' + key + '" onchange="updateValue13()">' + myArray[key] + '</td></tr>';  
		}  
		trs += '</table></div>';  
		div13.innerHTML = trs;    
		textItem.parentNode.appendChild(div13);  
	}  
	else {  
		//该复选下拉的层已经创建了，那么再次点击input表单的时候，显示  
		showDiv13();  
	}  
}  

function selectItem13(textItem) { 
	var myArray = generateArray();
	setSelectBox13(textItem, myArray);
	var defaultSelected = $("#lab_reconstruction").val();
	var strs = defaultSelected.split(";");
	
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox13.length; 
	for(var i=0;i<strs.length;i++) {
		for(var j=0;j<len;j++) {
			if (form.checkbox13[j].value == strs[i]) {  
				form.checkbox13[j].checked = true;     
			}
		}
	}
}

/******************************select item14******************************/
//创建用于显示隐藏的tableDiv  
var div14;  
function showDiv14() {  
	div14.style.display = "block";  
}  
function hideDiv14() {  
	div14.style.display = "none";  
}  

/* 
*根据复选框中的数值，更新input表单的显示。 
*当下拉框中每个checkbox被点击后，触发刚方法。 
*/  
function updateValue14() {  
	var value = "";   
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox14.length;  
	for (var i = 0; i < len; i++) {  
		if (form.checkbox14[i].checked) {  
			var v = form.checkbox14[i].value;   
			value = value + v + ";";  
		}  	
	}  
	form.collaboration.value = value;  
}  
function setSelectBox14(textItem, myArray) {  
	//复选下拉框首次创建，并显示  
	if (div14 == undefined) {  
		var itemTop = textItem.offsetTop;    //控件的定位点top  
		var itemHeight = textItem.clientHeight;    //控件本身的height  
		var itemLeft = textItem.offsetLeft;    //控件的定位点left  

		var top = itemTop + itemHeight - 5;  

		div14 = document.createElement("div14");  
		div14.onmouseover = showDiv14;  
		div14.onmouseout = hideDiv14;  
		//下拉层的位置、下拉滚动等样式  
		var trs = '<div id="tableDiv" style="position:abosolute;text-align: center;OVERFLOW: auto; SCROLLBAR-BASE-COLOR: #cccccc; HEIGHT: 200px;SCROLLBAR-FACE-COLOR: #ffffff;top:' + top + '; left:' + itemLeft + ';WIDTH:390px;Z-INDEX: 1;SCROLLBAR-SHADOW-COLOR:#cccccc;SCROLLBAR-ARROW-COLOR: #cccccc;SCROLLBAR-3DLIGHT-COLOR: #cccccc; background-color: #ffffff; border: 1px solid grey"><table>';  
		trs += '<table>';  
		//初始化下拉的选项  
		for (var key in myArray) {  
			trs += '<tr><td><input type="checkbox" name="checkbox14" value="' + key + '" onchange="updateValue14()">' + myArray[key] + '</td></tr>';  
		}  
		trs += '</table></div>';  
		div14.innerHTML = trs;    
		textItem.parentNode.appendChild(div14);  
	}  
	else {  
		//该复选下拉的层已经创建了，那么再次点击input表单的时候，显示  
		showDiv14();  
	}  
}  

function selectItem14(textItem) { 
	var myArray = generateArray();
	setSelectBox14(textItem, myArray); 
	var defaultSelected = $("#collaboration").val();
	var strs = defaultSelected.split(";");
	
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox14.length; 
	for(var i=0;i<strs.length;i++) {
		for(var j=0;j<len;j++) {
			if (form.checkbox14[j].value == strs[i]) {  
				form.checkbox14[j].checked = true;     
			}
		}
	}
}

/******************************select item15******************************/
//创建用于显示隐藏的tableDiv  
var div15;  
function showDiv15() {  
	div15.style.display = "block";  
}  
function hideDiv15() {  
	div15.style.display = "none";  
}  

/* 
*根据复选框中的数值，更新input表单的显示。 
*当下拉框中每个checkbox被点击后，触发刚方法。 
*/  
function updateValue15() {  
	var value = "";   
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox15.length;  
	for (var i = 0; i < len; i++) {  
		if (form.checkbox15[i].checked) {  
			var v = form.checkbox15[i].value;   
			value = value + v + ";";  
		}  	
	}  
	form.international_communication.value = value;  
}  
function setSelectBox15(textItem, myArray) {  
	//复选下拉框首次创建，并显示  
	if (div15 == undefined) {  
		var itemTop = textItem.offsetTop;    //控件的定位点top  
		var itemHeight = textItem.clientHeight;    //控件本身的height  
		var itemLeft = textItem.offsetLeft;    //控件的定位点left  

		var top = itemTop + itemHeight - 5;  

		div15 = document.createElement("div15");  
		div15.onmouseover = showDiv15;  
		div15.onmouseout = hideDiv15;  
		//下拉层的位置、下拉滚动等样式  
		var trs = '<div id="tableDiv" style="position:abosolute;text-align: center;OVERFLOW: auto; SCROLLBAR-BASE-COLOR: #cccccc; HEIGHT: 200px;SCROLLBAR-FACE-COLOR: #ffffff;top:' + top + '; left:' + itemLeft + ';WIDTH:390px;Z-INDEX: 1;SCROLLBAR-SHADOW-COLOR:#cccccc;SCROLLBAR-ARROW-COLOR: #cccccc;SCROLLBAR-3DLIGHT-COLOR: #cccccc; background-color: #ffffff; border: 1px solid grey"><table>';  
		trs += '<table>';  
		//初始化下拉的选项  
		for (var key in myArray) {  
			trs += '<tr><td><input type="checkbox" name="checkbox15" value="' + key + '" onchange="updateValue15()">' + myArray[key] + '</td></tr>';  
		}  
		trs += '</table></div>';  
		div15.innerHTML = trs;    
		textItem.parentNode.appendChild(div15);  
	}  
	else {  
		//该复选下拉的层已经创建了，那么再次点击input表单的时候，显示  
		showDiv15();  
	}  
}  

function selectItem15(textItem) { 
	var myArray = generateArray();
	setSelectBox15(textItem, myArray);
	var defaultSelected = $("#international_communication").val();
	var strs = defaultSelected.split(";");
	
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox15.length; 
	for(var i=0;i<strs.length;i++) {
		for(var j=0;j<len;j++) {
			if (form.checkbox15[j].value == strs[i]) {  
				form.checkbox15[j].checked = true;     
			}
		}
	}
}

/******************************select item16******************************/
//创建用于显示隐藏的tableDiv  
var div16;  
function showDiv16() {  
	div16.style.display = "block";  
}  
function hideDiv16() {  
	div16.style.display = "none";  
}  

/* 
*根据复选框中的数值，更新input表单的显示。 
*当下拉框中每个checkbox被点击后，触发刚方法。 
*/  
function updateValue16() {  
	var value = "";   
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox16.length;  
	for (var i = 0; i < len; i++) {  
		if (form.checkbox16[i].checked) {  
			var v = form.checkbox16[i].value;   
			value = value + v + ";";  
		}  	
	}  
	form.export_communication.value = value;  
}  
function setSelectBox16(textItem, myArray) {  
	//复选下拉框首次创建，并显示  
	if (div16 == undefined) {  
		var itemTop = textItem.offsetTop;    //控件的定位点top  
		var itemHeight = textItem.clientHeight;    //控件本身的height  
		var itemLeft = textItem.offsetLeft;    //控件的定位点left  

		var top = itemTop + itemHeight - 5;  

		div16 = document.createElement("div16");  
		div16.onmouseover = showDiv16;  
		div16.onmouseout = hideDiv16;  
		//下拉层的位置、下拉滚动等样式  
		var trs = '<div id="tableDiv" style="position:abosolute;text-align: center;OVERFLOW: auto; SCROLLBAR-BASE-COLOR: #cccccc; HEIGHT: 200px;SCROLLBAR-FACE-COLOR: #ffffff;top:' + top + '; left:' + itemLeft + ';WIDTH:390px;Z-INDEX: 1;SCROLLBAR-SHADOW-COLOR:#cccccc;SCROLLBAR-ARROW-COLOR: #cccccc;SCROLLBAR-3DLIGHT-COLOR: #cccccc; background-color: #ffffff; border: 1px solid grey"><table>';  
		trs += '<table>';  
		//初始化下拉的选项  
		for (var key in myArray) {  
			trs += '<tr><td><input type="checkbox" name="checkbox16" value="' + key + '" onchange="updateValue16()">' + myArray[key] + '</td></tr>';  
		}  
		trs += '</table></div>';  
		div16.innerHTML = trs;    
		textItem.parentNode.appendChild(div16);  
	}  
	else {  
		//该复选下拉的层已经创建了，那么再次点击input表单的时候，显示  
		showDiv16();  
	}  
}  

function selectItem16(textItem) { 
	var myArray = generateArray();
	setSelectBox16(textItem, myArray);
	var defaultSelected = $("#export_communication").val();
	var strs = defaultSelected.split(";");
	
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox16.length; 
	for(var i=0;i<strs.length;i++) {
		for(var j=0;j<len;j++) {
			if (form.checkbox16[j].value == strs[i]) {  
				form.checkbox16[j].checked = true;     
			}
		}
	}
}

/******************************select item17******************************/
//创建用于显示隐藏的tableDiv  
var div17;  
function showDiv17() {  
	div17.style.display = "block";  
}  
function hideDiv17() {  
	div17.style.display = "none";  
}  

/* 
*根据复选框中的数值，更新input表单的显示。 
*当下拉框中每个checkbox被点击后，触发刚方法。 
*/  
function updateValue17() {  
	var value = "";   
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox17.length;  
	for (var i = 0; i < len; i++) {  
		if (form.checkbox17[i].checked) {  
			var v = form.checkbox17[i].value;   
			value = value + v + ";";  
		}  	
	}  
	form.import_communication.value = value;  
}  
function setSelectBox17(textItem, myArray) {  
	//复选下拉框首次创建，并显示  
	if (div17 == undefined) {  
		var itemTop = textItem.offsetTop;    //控件的定位点top  
		var itemHeight = textItem.clientHeight;    //控件本身的height  
		var itemLeft = textItem.offsetLeft;    //控件的定位点left  

		var top = itemTop + itemHeight - 5;  

		div17 = document.createElement("div17");  
		div17.onmouseover = showDiv17;  
		div17.onmouseout = hideDiv17;  
		//下拉层的位置、下拉滚动等样式  
		var trs = '<div id="tableDiv" style="position:abosolute;text-align: center;OVERFLOW: auto; SCROLLBAR-BASE-COLOR: #cccccc; HEIGHT: 200px;SCROLLBAR-FACE-COLOR: #ffffff;top:' + top + '; left:' + itemLeft + ';WIDTH:390px;Z-INDEX: 1;SCROLLBAR-SHADOW-COLOR:#cccccc;SCROLLBAR-ARROW-COLOR: #cccccc;SCROLLBAR-3DLIGHT-COLOR: #cccccc; background-color: #ffffff; border: 1px solid grey"><table>';  
		trs += '<table>';  
		//初始化下拉的选项  
		for (var key in myArray) {  
			trs += '<tr><td><input type="checkbox" name="checkbox17" value="' + key + '" onchange="updateValue17()">' + myArray[key] + '</td></tr>';  
		}  
		trs += '</table></div>';  
		div17.innerHTML = trs;    
		textItem.parentNode.appendChild(div17);  
	}  
	else {  
		//该复选下拉的层已经创建了，那么再次点击input表单的时候，显示  
		showDiv17();  
	}  
}  

function selectItem17(textItem) { 
	var myArray = generateArray();
	setSelectBox17(textItem, myArray);
	var defaultSelected = $("#import_communication").val();
	var strs = defaultSelected.split(";");
	
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox17.length; 
	for(var i=0;i<strs.length;i++) {
		for(var j=0;j<len;j++) {
			if (form.checkbox17[j].value == strs[i]) {  
				form.checkbox17[j].checked = true;     
			}
		}
	}
}

/******************************select item18******************************/
//创建用于显示隐藏的tableDiv  
var div18;  
function showDiv18() {  
	div18.style.display = "block";  
}  
function hideDiv18() {  
	div18.style.display = "none";  
}  

/* 
*根据复选框中的数值，更新input表单的显示。 
*当下拉框中每个checkbox被点击后，触发刚方法。 
*/  
function updateValue18() {  
	var value = "";   
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox18.length;  
	for (var i = 0; i < len; i++) {  
		if (form.checkbox18[i].checked) {  
			var v = form.checkbox18[i].value;   
			value = value + v + ";";  
		}  	
	}  
	form.labour.value = value;  
}  
function setSelectBox18(textItem, myArray) {  
	//复选下拉框首次创建，并显示  
	if (div18 == undefined) {  
		var itemTop = textItem.offsetTop;    //控件的定位点top  
		var itemHeight = textItem.clientHeight;    //控件本身的height  
		var itemLeft = textItem.offsetLeft;    //控件的定位点left  

		var top = itemTop + itemHeight - 5;  

		div18 = document.createElement("div18");  
		div18.onmouseover = showDiv18;  
		div18.onmouseout = hideDiv18;  
		//下拉层的位置、下拉滚动等样式  
		var trs = '<div id="tableDiv" style="position:abosolute;text-align: center;OVERFLOW: auto; SCROLLBAR-BASE-COLOR: #cccccc; HEIGHT: 200px;SCROLLBAR-FACE-COLOR: #ffffff;top:' + top + '; left:' + itemLeft + ';WIDTH:390px;Z-INDEX: 1;SCROLLBAR-SHADOW-COLOR:#cccccc;SCROLLBAR-ARROW-COLOR: #cccccc;SCROLLBAR-3DLIGHT-COLOR: #cccccc; background-color: #ffffff; border: 1px solid grey"><table>';  
		trs += '<table>';  
		//初始化下拉的选项  
		for (var key in myArray) {  
			trs += '<tr><td><input type="checkbox" name="checkbox18" value="' + key + '" onchange="updateValue18()">' + myArray[key] + '</td></tr>';  
		}  
		trs += '</table></div>';  
		div18.innerHTML = trs;    
		textItem.parentNode.appendChild(div18);  
	}  
	else {  
		//该复选下拉的层已经创建了，那么再次点击input表单的时候，显示  
		showDiv18();  
	}  
}  

function selectItem18(textItem) { 
	var myArray = generateArray();
	setSelectBox18(textItem, myArray);
	var defaultSelected = $("#labour").val();
	var strs = defaultSelected.split(";");
	
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox18.length; 
	for(var i=0;i<strs.length;i++) {
		for(var j=0;j<len;j++) {
			if (form.checkbox18[j].value == strs[i]) {  
				form.checkbox18[j].checked = true;     
			}
		}
	}
}

/******************************select item19******************************/
//创建用于显示隐藏的tableDiv  
var div19;  
function showDiv19() {  
	div19.style.display = "block";  
}  
function hideDiv19() {  
	div19.style.display = "none";  
}  

/* 
*根据复选框中的数值，更新input表单的显示。 
*当下拉框中每个checkbox被点击后，触发刚方法。 
*/  
function updateValue19() {  
	var value = "";   
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox19.length;  
	for (var i = 0; i < len; i++) {  
		if (form.checkbox19[i].checked) {  
			var v = form.checkbox19[i].value;   
			value = value + v + ";";  
		}  	
	}  
	form.management.value = value;  
}  
function setSelectBox19(textItem, myArray) {  
	//复选下拉框首次创建，并显示  
	if (div19 == undefined) {  
		var itemTop = textItem.offsetTop;    //控件的定位点top  
		var itemHeight = textItem.clientHeight;    //控件本身的height  
		var itemLeft = textItem.offsetLeft;    //控件的定位点left  

		var top = itemTop + itemHeight - 5;  

		div19 = document.createElement("div19");  
		div19.onmouseover = showDiv19;  
		div19.onmouseout = hideDiv19;  
		//下拉层的位置、下拉滚动等样式  
		var trs = '<div id="tableDiv" style="position:abosolute;text-align: center;OVERFLOW: auto; SCROLLBAR-BASE-COLOR: #cccccc; HEIGHT: 200px;SCROLLBAR-FACE-COLOR: #ffffff;top:' + top + '; left:' + itemLeft + ';WIDTH:390px;Z-INDEX: 1;SCROLLBAR-SHADOW-COLOR:#cccccc;SCROLLBAR-ARROW-COLOR: #cccccc;SCROLLBAR-3DLIGHT-COLOR: #cccccc; background-color: #ffffff; border: 1px solid grey"><table>';  
		trs += '<table>';  
		//初始化下拉的选项  
		for (var key in myArray) {  
			trs += '<tr><td><input type="checkbox" name="checkbox19" value="' + key + '" onchange="updateValue19()">' + myArray[key] + '</td></tr>';  
		}  
		trs += '</table></div>';  
		div19.innerHTML = trs;    
		textItem.parentNode.appendChild(div19);  
	}  
	else {  
		//该复选下拉的层已经创建了，那么再次点击input表单的时候，显示  
		showDiv19();  
	}  
}  

function selectItem19(textItem) { 
	var myArray = generateArray();
	setSelectBox19(textItem, myArray);
	var defaultSelected = $("#management").val();
	var strs = defaultSelected.split(";");
	
	var form = document.getElementById("mappingForm");  
	var len = form.checkbox19.length; 
	for(var i=0;i<strs.length;i++) {
		for(var j=0;j<len;j++) {
			if (form.checkbox19[j].value == strs[i]) {  
				form.checkbox19[j].checked = true;     
			}
		}
	}
}