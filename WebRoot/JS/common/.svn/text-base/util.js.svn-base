////全局的ajax访问，处理ajax清求时sesion超时  
$.ajaxSetup({  
    contentType:"application/x-www-form-urlencoded;charset=utf-8",  
    complete:function(XMLHttpRequest,textStatus){  
        //通过XMLHttpRequest取得响应头，sessionstatus，  
        var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus");   
        if(sessionstatus=="timeout"){  
        //如果超时就处理 ，指定要跳转的页面   top.location.href 
        	top.location.href="/STOMS/teacherLogin.jsp";
        }  
        var illegal_log_in = XMLHttpRequest.getResponseHeader("illegal_log_in");
        if(illegal_log_in == "true"){
        	top.location.href="/STOMS/illegal_log_in_Warming.jsp";
        }
    }  
});  

//异步调用方法
//actionURL   调用后台的action的地址
//actionParameter    调用后台时给后台传递的参数，使用依赖注入的方式将变量值写进后台中
//callbackFunction   异步调用成功后的 回调函数
//extraParameters    回调函数的第二个参数
function generalAjaxCallToLoadData(actionURL, actionParameter, callbackFunction, extraParameters) {
	
	var args = {
			
			url: actionURL,
			type:"POST",
			dataType:"json",
			cache: false,
			contentType:"application/x-www-form-urlencoded",
			data:jQuery.param(actionParameter,true),
			success: function(data, textStatus) {
				
				var resultStructure={};
				
				for(var item in data) {
					if(data[item]==null || data[item]==""){
					      resultStructure[item]="";
					   }else{
						   resultStructure[item] = stringToJson(data[item]);
					   }
				}
				
				callbackFunction(resultStructure,extraParameters);
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				
				console.log("error calback");
			}
			
	};
	
	  
	$.ajax(args);
}

//将字符串转换为对象格式
function stringToJson( strData ){
    return (new Function( "return " + strData ))();
}

//json 格式转换为字符串
function jsonToString(o) {      
	var arr = [];      
	var fmt = function(s) {      
	if (typeof s == 'object' && s != null) return JsonToStr(s);      
	return /^(string|number)$/.test(typeof s) ? "'" + s + "'" : s;      
	};
	for (var i in o) arr.push("'" + i + "':" + fmt(o[i]));      
	return '{' + arr.join(',') + '}';
}

//处理console的一些命令在不支持console语句的环境中的异常
function consoleResponseInUnusabalEnvirenment() {
	
	if (!window.console || !console.firebug)
	
	{
	    var names = ["log", "debug", "info", "warn", "error", "assert", "dir", "dirxml",
	    "group", "groupEnd", "time", "timeEnd", "count", "trace", "profile", "profileEnd"];
	
	    window.console = {};
	    for (var i = 0; i < names.length; ++i)
	        window.console[names[i]] = function() {};
	}
}

//打开消息通知对话框
function openGeneralMessageDialog(content) {
	$( "#generalShowMessageDialog" ).unbind();
	$("#generalShowMessageDialog").dialog({
		autoOpen: false,
		show: "blind",
		hide: "explode"
	});
	
	$("#generalShowMessageDialog").dialog( "open");
	 
	 $("#generalShowMessageContent").html(content);
	 
	//取消所有的绑定事件
	 $("#generalShowMessageCancelButton").unbind();
	 $("#generalShowMessageCancelButton").click( function() {
	    	$("#generalShowMessageDialog").dialog("close");
	    } );
	 
	 //$( "#generalShowMessageDialog" ).dialog("open");
}

function openGeneralMessageDialogThenGoBack(content) {
	$( "#generalShowMessageDialog" ).unbind();
	$("#generalShowMessageDialog").dialog({
		autoOpen: false,
		show: "blind",
		hide: "explode"
	});
	
	$("#generalShowMessageDialog").dialog( "open");
	
	 $("#generalShowMessageContent").html(content);
	 
	//取消所有的绑定事件
	 $("#generalShowMessageCancelButton").unbind();
	 $("#generalShowMessageCancelButton").click( function() {
	    	$("#generalShowMessageDialog").dialog("close");
	    	
	    	history.go(-1);
	    } );
	 
	 //$( "#generalShowMessageDialog" ).dialog("open");
}
//打开对话框后转到addmoney，
function openGeneralMessageDialogThenGoToAddMoney(content, assureOperatingMethod, parameter) {
	$( "#generalAssureDialog" ).unbind();
	$("#generalAssureDialog").dialog({
		autoOpen: false,
		show: "blind",
		hide: "explode"
	});
	
	$("#generalAssureDialog").dialog( "open");
	 
	$("#generalAssureDialogContent").html(content);
	
	//取消所有的绑定事件
	$("#generalAssureDialogAssureButton").unbind();
	$("#generalAssureDialogAssureButton").click( function() {
		$("#generalAssureDialog").dialog("close");
		assureOperatingMethod(parameter);
		top.location.href="/STOMS/Page/Common/adminMainPage.jsp";
    } );
	
	//取消所有的绑定事件
	$("#generalAssureDialogCancelButton").unbind();
	$("#generalAssureDialogCancelButton").click( function() {
	    	$("#generalAssureDialog").dialog("close");
	    	top.location.href="/STOMS/Page/Common/adminMainPage.jsp";
	} );
}
//打开对话框后转到项目列表页面，既主页面
function openGeneralMessageDialogThenGoToItemList(content) {
	$( "#generalShowMessageDialog" ).unbind();
	$("#generalShowMessageDialog").dialog({
		autoOpen: false,
		show: "blind",
		hide: "explode"
	});
	
	$("#generalShowMessageDialog").dialog( "open");
	
	 $("#generalShowMessageContent").html(content);
	 
	//取消所有的绑定事件
	 $("#generalShowMessageCancelButton").unbind();
	 $("#generalShowMessageCancelButton").click( function() {
	    	$("#generalShowMessageDialog").dialog("close");
	    	
	    	var detailInfoUrl = "Page/Teacher/projectManagement/projectRegistrationList.jsp";
			parent.pageTransition(detailInfoUrl);
	    } );
	 
	 //$( "#generalShowMessageDialog" ).dialog("open");
}

//打开带有确认按钮的对话框
//content  提示用户的 信息
//assureOperatingMethod   点击确认按钮后执行的函数
//parameter   assureOperatingMethod函数的参数
function openGeneralAssureDialog(content, assureOperatingMethod, parameter) {
	$( "#generalAssureDialog" ).unbind();
	$("#generalAssureDialog").dialog({
		autoOpen: false,
		show: "blind",
		hide: "explode"
	});
	
	$("#generalAssureDialog").dialog( "open");
	 
	$("#generalAssureDialogContent").html(content);
	
	//取消所有的绑定事件
	$("#generalAssureDialogAssureButton").unbind();
	$("#generalAssureDialogAssureButton").click( function() {
		$("#generalAssureDialog").dialog("close");
		assureOperatingMethod(parameter);
    	
    } );
	
	//取消所有的绑定事件
	$("#generalAssureDialogCancelButton").unbind();
	$("#generalAssureDialogCancelButton").click( function() {
	    	$("#generalAssureDialog").dialog("close");
	    } );
}

//打开带有确认按钮的对话框,并返回到上一个页面
//content  提示用户的 信息
//assureOperatingMethod   点击确认按钮后执行的函数
//parameter   assureOperatingMethod函数的参数
function openGeneralAssureDialogAndGoBack(content, assureOperatingMethod, parameter) {
	$( "#generalAssureDialog" ).unbind();
	$("#generalAssureDialog").dialog({
		autoOpen: false,
		show: "blind",
		hide: "explode"
	});
	
	$("#generalAssureDialog").dialog( "open");
	 
	$("#generalAssureDialogContent").html(content);
	
	//取消所有的绑定事件
	$("#generalAssureDialogAssureButton").unbind();
	$("#generalAssureDialogAssureButton").click( function() {
		$("#generalAssureDialog").dialog("close");
		assureOperatingMethod(parameter);
		history.go(-1);
  } );
	
	//取消所有的绑定事件
	$("#generalAssureDialogCancelButton").unbind();
	$("#generalAssureDialogCancelButton").click( function() {
	    	$("#generalAssureDialog").dialog("close");
	    	
	    	history.go(-1);
	    } );
}

//取得表格中被选中行的数据，oTableLocal表格对象
function acquireSelectedRowsInfo( oTableLocal )
{
    var aReturn = new Array();
    
    var aTrs = oTableLocal.fnGetNodes();
    
    for ( var i=0 ; i<aTrs.length ; i++ )
    {
    	
        if ( $(aTrs[i]).hasClass('row_selected') )
        {
        	var tempRowInfo = {};
        	tempRowInfo["rowData"] = aTrs[i];
        	
        	var apos = oTableLocal.fnGetPosition( ($(aTrs[i]).children())[1] );
        	tempRowInfo["rowNumber"] = apos[0];
            aReturn.push( tempRowInfo );
        }
    }
    return aReturn;
}

//几个全局变量数组，表示状态值
//项目状态全局变量
var projectStateArrayGlobalVariable = {
		"10":"未提交",
		"11":"待审核",
		"20":"院级审批未通过",
		"21":"院级审批通过",
		"30":"拒绝",
		"31":"同意",
		"40":"国家级审批未通过",
		"41":"国家级审批通过",
		"50":"教师未确认",
		"51":"教师确认",
		"60":"科技处确认不通过",
		"61":"科技处确认通过"
};

//是否是横向项目的数组全局变量
var isCrossArrayGlobalVariable = new Array("否", "是");

//dataTable表语言全局变量
var dataTableLanguageGlobalVariable = {
										"sEmptyTable":" ",
										"sZeroRecords": "很抱歉，没有符合您查找的数据！",
										 "sInfo": "显示第  _START_ 到 _END_ 条记录, 共 _TOTAL_ 条记录",
										 "sInfoEmpty": "显示第  0 到 0 条记录, 共 0 条记录",
										 "sInfoFiltered": "(从  _MAX_ 条记录中筛选)",
										 "oPaginate": {
								                "sFirst": "首页",
								                "sPrevious": "上一页",
								                "sNext": "下一页",
								                "sLast": "尾页"
										 },
										 "sLoadingRecords": "请稍后，正在导入中...",
										 "sSearch": "搜索:"
									};