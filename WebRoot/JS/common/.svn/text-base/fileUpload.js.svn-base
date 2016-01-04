function fileQueueError(file, errorCode, message) {
	try {
		var imageName = "error.gif";
		var errorName = "";
		if (errorCode === SWFUpload.errorCode_QUEUE_LIMIT_EXCEEDED) {
			errorName = "You have attempted to queue too many files.";
		}

		if (errorName !== "") {
			alert(errorName);
			return;
		}

		switch (errorCode) {
		case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
			imageName = "zerobyte.gif";
			break;
		case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
			imageName = "toobig.gif";
			break;
		case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
		case SWFUpload.QUEUE_ERROR.INVALID_FILETYPE:
		default:
			alert(message);
			break;
		}

		addImage("style/images/" + imageName);

	} catch (ex) {
		this.debug(ex);
	}

}

function fileDialogComplete(numFilesSelected, numFilesQueued) {
	try {
		if (numFilesQueued > 0) {
			this.startUpload();
		}
	} catch (ex) {
		this.debug(ex);
	}
}

function uploadProgress(file, bytesLoaded) {

	try {
		var percent = Math.ceil((bytesLoaded / file.size) * 100);

		var progress = new FileProgress(file,  this.customSettings.upload_target);
		progress.setProgress(percent);
		if (percent === 100) {
			progress.setStatus("Creating thumbnail...");
			progress.toggleCancel(false, this);
		} else {
			progress.setStatus("Uploading...");
			progress.toggleCancel(true, this);
		}
	} catch (ex) {
		this.debug(ex);
	}
}

function uploadSuccess(file, serverData) {
	try {
		var progress = new FileProgress(file,  this.customSettings.upload_target);


		if (serverData.substring(0, 7) === "FILEID:") {
			addImage(serverData.substring(7));

			progress.setStatus("Thumbnail Created.");
			progress.toggleCancel(false);
		} else {
			addImage("style/images/error.gif");
			progress.setStatus("Error.");
			progress.toggleCancel(false);
		//	alert(serverData);

		}


	} catch (ex) {
		this.debug(ex);
	}
}

function uploadError(file, errorCode, message) {
	var imageName =  "error.gif";
	var progress;
	try {
		switch (errorCode) {
		case SWFUpload.UPLOAD_ERROR.FILE_CANCELLED:
			try {
				progress = new FileProgress(file,  this.customSettings.upload_target);
				progress.setCancelled();
				progress.setStatus("Cancelled");
				progress.toggleCancel(false);
			}
			catch (ex1) {
				this.debug(ex1);
			}
			break;
		case SWFUpload.UPLOAD_ERROR.UPLOAD_STOPPED:
			try {
				progress = new FileProgress(file,  this.customSettings.upload_target);
				progress.setCancelled();
				progress.setStatus("Stopped");
				progress.toggleCancel(true);
			}
			catch (ex2) {
				this.debug(ex2);
			}
		case SWFUpload.UPLOAD_ERROR.UPLOAD_LIMIT_EXCEEDED:
			imageName = "uploadlimit.gif";
			break;
		default:
			alert(message);
			break;
		}

		addImage("style/images/" + imageName);

	} catch (ex3) {
		this.debug(ex3);
	}

}


function addImage(src) {
	var newImg = document.createElement("img");
	newImg.style.margin = "5px";

	document.getElementById("thumbnails").appendChild(newImg);
	if (newImg.filters) {
		try {
			newImg.filters.item("DXImageTransform.Microsoft.Alpha").opacity = 0;
		} catch (e) {
			// If it is not set initially, the browser will throw an error.  This will set it if it is not set yet.
			newImg.style.filter = 'progid:DXImageTransform.Microsoft.Alpha(opacity=' + 0 + ')';
		}
	} else {
		newImg.style.opacity = 0;
	}

	newImg.onload = function () {
		fadeIn(newImg, 0);
	};
	newImg.src = src;
}

function fadeIn(element, opacity) {
	var reduceOpacityBy = 5;
	var rate = 30;	// 15 fps


	if (opacity < 100) {
		opacity += reduceOpacityBy;
		if (opacity > 100) {
			opacity = 100;
		}

		if (element.filters) {
			try {
				element.filters.item("DXImageTransform.Microsoft.Alpha").opacity = opacity;
			} catch (e) {
				// If it is not set initially, the browser will throw an error.  This will set it if it is not set yet.
				element.style.filter = 'progid:DXImageTransform.Microsoft.Alpha(opacity=' + opacity + ')';
			}
		} else {
			element.style.opacity = opacity / 100;
		}
	}

	if (opacity < 100) {
		setTimeout(function () {
			fadeIn(element, opacity);
		}, rate);
	}
}



/* ******************************************
 *	FileProgress Object
 *	Control object for displaying file info
 * ****************************************** */

function FileProgress(file, targetID) {
	this.fileProgressID = "divFileProgress";

	this.fileProgressWrapper = document.getElementById(this.fileProgressID);
	if (!this.fileProgressWrapper) {
		this.fileProgressWrapper = document.createElement("div");
		this.fileProgressWrapper.className = "progressWrapper";
		this.fileProgressWrapper.id = this.fileProgressID;

		this.fileProgressElement = document.createElement("div");
		this.fileProgressElement.className = "progressContainer";

		var progressCancel = document.createElement("a");
		progressCancel.className = "progressCancel";
		progressCancel.href = "#";
		progressCancel.style.visibility = "hidden";
		progressCancel.appendChild(document.createTextNode(" "));

		var progressText = document.createElement("div");
		progressText.className = "progressName";
		progressText.appendChild(document.createTextNode(file.name));

		var progressBar = document.createElement("div");
		progressBar.className = "progressBarInProgress";

		var progressStatus = document.createElement("div");
		progressStatus.className = "progressBarStatus";
		progressStatus.innerHTML = "&nbsp;";

		this.fileProgressElement.appendChild(progressCancel);
		this.fileProgressElement.appendChild(progressText);
		this.fileProgressElement.appendChild(progressStatus);
		this.fileProgressElement.appendChild(progressBar);

		this.fileProgressWrapper.appendChild(this.fileProgressElement);

		document.getElementById(targetID).appendChild(this.fileProgressWrapper);
		fadeIn(this.fileProgressWrapper, 0);

	} else {
		this.fileProgressElement = this.fileProgressWrapper.firstChild;
		this.fileProgressElement.childNodes[1].firstChild.nodeValue = file.name;
	}

	this.height = this.fileProgressWrapper.offsetHeight;

}
FileProgress.prototype.setProgress = function (percentage) {
	this.fileProgressElement.className = "progressContainer green";
	this.fileProgressElement.childNodes[3].className = "progressBarInProgress";
	this.fileProgressElement.childNodes[3].style.width = percentage + "%";
};
FileProgress.prototype.setComplete = function () {
	this.fileProgressElement.className = "progressContainer blue";
	this.fileProgressElement.childNodes[3].className = "progressBarComplete";
	this.fileProgressElement.childNodes[3].style.width = "";

};
FileProgress.prototype.setError = function () {
	this.fileProgressElement.className = "progressContainer red";
	this.fileProgressElement.childNodes[3].className = "progressBarError";
	this.fileProgressElement.childNodes[3].style.width = "";

};
FileProgress.prototype.setCancelled = function () {
	this.fileProgressElement.className = "progressContainer";
	this.fileProgressElement.childNodes[3].className = "progressBarError";
	this.fileProgressElement.childNodes[3].style.width = "";

};
FileProgress.prototype.setStatus = function (status) {
	this.fileProgressElement.childNodes[2].innerHTML = status;
};

FileProgress.prototype.toggleCancel = function (show, swfuploadInstance) {
	this.fileProgressElement.childNodes[0].style.visibility = show ? "visible" : "hidden";
	if (swfuploadInstance) {
		var fileID = this.fileProgressID;
		this.fileProgressElement.childNodes[0].onclick = function () {
			swfuploadInstance.cancelUpload(fileID);
			return false;
		};
	}
};

function calc2(directFee,indirectFee,performanceSpending,equipmentPurchaseFee) {
	var bound = 10000000;//getNumberInputWidgetValue
	var manageFee1=0;
	var taskPerformanceSpending=performanceSpending;
	var departmentPublicSpending=0;
	var taskPlanSpending=0;
	//计算 管理费1
	if(directFee-equipmentPurchaseFee > 0){
		if(directFee-equipmentPurchaseFee < bound){
			manageFee1=(directFee-equipmentPurchaseFee)*0.05;
		}else{
			manageFee1=bound*0.05 + (directFee-bound-equipmentPurchaseFee)*0.03;
		}
	}
	$("#txtManage").val(manageFee1.toFixed(2));
	
	//计算 课题绩效支出
	$("#txtPerformance1").val((performanceSpending*0.8).toFixed(2));
	$("#txtPerformance2").val((performanceSpending*0.2).toFixed(2));
	//计算 院系公共支出
	if(indirectFee-manageFee1-taskPerformanceSpending > 0){
		departmentPublicSpending = ((indirectFee-manageFee1-taskPerformanceSpending)*0.2).toFixed(2);
	}
	$("#txtDepartPublic").val(departmentPublicSpending);
	
	//计算 课题统筹支出
	if(indirectFee-manageFee1-taskPerformanceSpending > 0){
		taskPlanSpending = ((indirectFee-manageFee1-taskPerformanceSpending)*0.8).toFixed(2);
	}
	$("#txtCoProject").val(taskPlanSpending);
}
function resetForm(){
	$("#txtDP").val("");
	$("#txtName").val("");
	$("#txtName2").val("");
	$("#txtValue").val("");
	$("#txtID").val("");
	$("#art").attr("disabled",false);
	$("#science").attr("disabled",false);
	$("#art option:contains('无')").attr("selected", true);
	$("#science option:contains('无')").attr("selected", true);
	$("#txtOut").val("");
	$("#txtNewPay").val("");
	$("#txtManage").val("");
	$("#txtNewPay2").val("");
	$("#txtManage2").val("");
	if($("#chk_availableManageCredit").attr("checked")){
		$("#chk_availableManageCredit").click();
	}
	$("#txtAvailableManageCredit").val("");
	$("#txtConsult").val("");
	$("#txtDepartPublic").val("");
	$("#txtCoProject").val("");
	$("#txtPerformance1").val("");
	$("#txtPerformance2").val("");
	if($("#chkIsBroadwise").attr("checked")){
		$("#chkIsBroadwise").click();
	}
	if($("#chkNewCard").attr("checked")){
		$("#chkNewCard").click();
	}
	$("#txtOther").val("");
}

//开卡国家自然科学基金的处理
function uploadComplete(file) {
	try {
		/*  I want the next upload to continue automatically so I'll call startUpload here */
		if (this.getStats().files_queued > 0) {
			this.startUpload();
		} else {
			var progress = new FileProgress(file,  this.customSettings.upload_target);
			progress.setComplete();
			progress.setStatus("All images received.");
			progress.toggleCancel(false);

		}
	} catch (ex) {
		this.debug(ex);
	}
	$("#divFileProgressContainer").html("");
	generalAjaxCallToLoadData("getDataToForm.action",{}, initializeAddMoney);
}
//开卡国家自然科学基金的回显表单
function initializeAddMoney(data) {
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	var kaige = data.jsonResult;
	//先清空表单
	resetForm();
	$("#txtDP").val("自然基金");
	$("#txtName").val(kaige["teacherName"]);
	if(!$("#chkNewCard").attr("checked")){
		$("#chkNewCard").click();
	}
	//$("#chkNewCard").attr("checked", true);
	$("#txtNewName").val($.trim(kaige["itemName"]));
	
	$("#art").get(0).selectedIndex=0;
	$("#science").get(0).selectedIndex=0;
	
	$("#txtContractID").val(kaige["contractId"]);
	
	var outlayValue=kaige["outlayValue"];
	var out2 = outlayValue*10000;
	$("#txtTotalValue").val(out2);
	$("#time1").val(kaige["invoiceTitle"]);
	$("#time2").val(kaige["invoiceDetail"]);
	
	$("#txtDept").val(kaige["departmentId"]);
}
//开卡省科技项目的处理
function uploadComplete2(file) {
	try {
		/*  I want the next upload to continue automatically so I'll call startUpload here */
		if (this.getStats().files_queued > 0) {
			this.startUpload();
		} else {
			var progress = new FileProgress(file,  this.customSettings.upload_target);
			progress.setComplete();
			progress.setStatus("All images received.");
			progress.toggleCancel(false);
		}
	} catch (ex) {
		this.debug(ex);
	}
	generalAjaxCallToLoadData("getDataToForm2.action",{}, initializeAddMoney2);
}
//开卡省科技项目的回显表单
function initializeAddMoney2(data) {
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	var kaige = data.jsonResult;
	resetForm();
	$("#txtDP").val("江苏省科技厅");
	$("#txtName").val(kaige["teacherName"]);
	$("#txtName2").val(kaige["otherTeacher"]);
	if(kaige["departmentType"] == "理科"){
		$("#science option:contains('本省各厅局项目（理科无专项规定）--H')").attr("selected", true);
		//$("#science option[text='备选类型']").attr("selected", true);
		$("#art").attr("disabled",true);
		$("#art").get(0).selectedIndex=0;
	}else{
		$("#art option:contains('本省各厅局项目（文科无专项规定）--H')").attr("selected", true);
		$("#science").attr("disabled",true);
		$("#science").get(0).selectedIndex=0;
	}
	//directFee,indirectFee,performanceSpending,equipmentPurchaseFee
	var directFee = kaige["directValue"];
	var indirectFee = kaige["indirectValue"];
	var performanceSpending = kaige["performance"];
	var equipmentPurchaseFee = kaige["equipment"];
	calc2(directFee,indirectFee,performanceSpending,equipmentPurchaseFee);
	
	$("#txtNewPay2").val(kaige["pay"]);
	$("#txtConsult").val(kaige["consult"]);
	
	if(!$("#chkNewCard").attr("checked")){
		$("#chkNewCard").click();
	}
	//$("#chkNewCard").attr("checked", true);
	$("#txtNewName").val($.trim(kaige["itemName"]));
	
	$("#txtContractID").val(kaige["contractId"]);
	
	var outlayValue=kaige["outlayValue"];
	var out2 = outlayValue;
	$("#txtTotalValue").val(out2);
	$("#time1").val(kaige["invoiceTitle"]);
	$("#time2").val(kaige["invoiceDetail"]);
	
	$("#txtDept").val(kaige["departmentId"]);
}
//入账国家基金的处理
function uploadComplete3(file) {
	try {
		/*  I want the next upload to continue automatically so I'll call startUpload here */
		if (this.getStats().files_queued > 0) {
			this.startUpload();
		} else {
			var progress = new FileProgress(file,  this.customSettings.upload_target);
			progress.setComplete();
			progress.setStatus("All images received.");
			progress.toggleCancel(false);

		}
	} catch (ex) {
		this.debug(ex);
	}
	$("#divFileProgressContainer").html("");
	generalAjaxCallToLoadData("stateFundTwiceAdd.action",{}, initializeAddMoney3);
}
//入账国家基金的结果
function initializeAddMoney3(data) {
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	var list = data.jsonResult;
	if(list.length == 0){
		alert("全部入账成功！");
	}else{
		var count = list.length;
		var failed="";
		for(var i = 0; i <list.length; i++) {
			var tempInfo = list[i];
			failed = failed + tempInfo.contractId;
			failed = failed + "\t";
			failed = failed + tempInfo.itemId;
			failed = failed +"\n";
		}
		alert("！！注意务必保存一下内容！！\n以下项目ID和合同ID没有入账成功（没入账过，或者没项目ID）：\n"+failed);
	}
}
//入账省基金的处理
function uploadComplete4(file) {
	try {
		/*  I want the next upload to continue automatically so I'll call startUpload here */
		if (this.getStats().files_queued > 0) {
			this.startUpload();
		} else {
			var progress = new FileProgress(file,  this.customSettings.upload_target);
			progress.setComplete();
			progress.setStatus("All images received.");
			progress.toggleCancel(false);

		}
	} catch (ex) {
		this.debug(ex);
	}
	
	$("#divFileProgressContainer").html("");
	generalAjaxCallToLoadData("getDataToForm22.action",{}, initializeAddMoney4);
}
//入账省基金的回显表单
function initializeAddMoney4(data) {
	if(!data.actionStatus) {
		alert("入账错误！");
		return false;
	}
	var kaige = data.jsonResult;
	resetForm();
	$("#txtDP").val("江苏省科技厅");
	$("#txtName").val(kaige["teacherName"]);
	$("#txtName2").val(kaige["otherTeacher"]);
	$("#txtID").val(kaige["itemId"]);
	if(kaige["departmentType"] == "理科"){
		$("#science option:contains('本省各厅局项目（理科无专项规定）--H')").attr("selected", true);
		//$("#science option[text='备选类型']").attr("selected", true);
		$("#art").attr("disabled",true);
		$("#art").get(0).selectedIndex=0;
	}else{
		$("#art option:contains('本省各厅局项目（文科无专项规定）--H')").attr("selected", true);
		$("#science").attr("disabled",true);
		$("#science").get(0).selectedIndex=0;
	}
	//directFee,indirectFee,performanceSpending,equipmentPurchaseFee
	var directFee = kaige["directValue"];
	var indirectFee = kaige["indirectValue"];
	var performanceSpending = kaige["performance"];
	var equipmentPurchaseFee = kaige["equipment"];
	calc2(directFee,indirectFee,performanceSpending,equipmentPurchaseFee);
	
	$("#txtNewPay2").val(kaige["pay"]);
	$("#txtConsult").val(kaige["consult"]);
	
	if($("#chkNewCard").attr("checked")){
		$("#chkNewCard").click();
	}

}

//载入当前项目的附件列表的回调函数
function initializeItemPicList(data) {
	
	if(!data.actionStatus) {
		console.log("error!");
		return false;
	}
	
	var picList = data.jsonResult.picUploadArray;

	showUploadOutputResult (picList );
}

function showUploadOutputResult (picList ) {

	if ( picList == null )
		return;
	
	var msg = ""; 
	for( var i =0; i<picList.length; i++ ) {
		
		if( picList[i] !=null && $.trim( picList[i]) != "" && picList[i]  )
		msg = msg + "<a href=\""+picList[i]+"\" target=\"_blank\">附件"+i+"</a>   ";
	}
	
	$("#uploadOutputResult").html(msg);
}

function deleteItemPic ( ) {
	
	if( confirm("删除所有附件，确定？") ) {

		generalAjaxCallToLoadData("deleteItemPic.action",{"itemPK":itemPK}, showDeleteResponse);
	}
}

function  showDeleteResponse ( data ) {
	
	var deleteNum = data.jsonResult;
	alert(  deleteNum + "个文件已删除！" );
	$("#uploadOutputResult").html("");
}