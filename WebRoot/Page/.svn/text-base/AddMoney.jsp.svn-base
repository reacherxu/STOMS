<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>增加经费</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="CSS/idealForms/idealForms-theme-sapphire.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="CSS/validationEngine/validationEngine.jquery.css" rel="stylesheet" type="text/css"/>
    <link href="CSS/formPage.css" rel="stylesheet" type="text/css"/>
    <link href="JqueryLib/development-bundle/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css"/>
    <link href="JqueryLib/editable-select/jquery.editable-select.css" rel="stylesheet" type="text/css"/>
    
    <script type="text/javascript" src="JqueryLib/js/jquery-1.7.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine.js"></script>
	<!--
	<script type="text/javascript" src="JqueryLib/editable-select/jquery.editable-select.js"></script>
	-->
	<script type="text/javascript" src="JqueryLib/SetEditComb.js"></script>
	
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>
	
	<script type="text/javascript" src="JS/addMoney.js"></script>
	
	<LINK href="JqueryLib/dialog/dialog.css" type=text/css rel=stylesheet>
	<SCRIPT src="JqueryLib/dialog/dialog.js" type=text/javascript></SCRIPT>
	<script type="text/javascript" src="JS/common/fileUpload.js"></script>
	<script type="text/javascript" src="JS/common/swfupload.js"></script>
	
	<script type="text/javascript">
		var swfu;
		var swfu2;
		var swfu3;
		var swfu4;
		window.onload = function () {
			swfu = new SWFUpload({
				// Backend Settings
				upload_url: "<%=path%>/fileUpload.action",
				post_params: { "flag" : "GuoJia.pdf"  },

				// File Upload Settings
				file_size_limit : "4 MB",	// 4MB
				file_types : "*.pdf",
				file_types_description : "All Files",
				file_upload_limit : "0",
				
				// Event Handler Settings - these functions as defined in Handlers.js
				//  The handlers are not part of SWFUpload but are part of my website and control how
				//  my website reacts to the SWFUpload events.
				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,
				upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : uploadSuccess,
				upload_complete_handler : uploadComplete,

				// Button Settings
				button_image_url : "/STOMS/Resource/Image/SmallSpyGlassWithTransperancy_17x18.png",
				button_placeholder_id : "spanButtonPlaceHolder",
				button_width: 170,
				button_height: 18,
				button_text : '<span class="button">开卡"国家自然科学基金"Pdf</span>',
				button_text_style : '.button { font-family: Helvetica, Arial, sans-serif; font-size: 12pt; }',
				button_text_top_padding: 0,
				button_text_left_padding: 18,
				button_window_mode: SWFUpload.WINDOW_MODE.TRANSPARENT,
				button_cursor: SWFUpload.CURSOR.HAND,
				
				// Flash Settings
				flash_url : "swf/swfupload.swf",
				/**
				custom_settings : {
					upload_target : "divFileProgressContainer"
				},
				**/
				// Debug Settings
				debug: false
			});
			swfu2 = new SWFUpload({
				// Backend Settings
				upload_url: "<%=path%>/fileUpload.action",
				post_params: { "flag" : "Sheng.pdf"  },

				// File Upload Settings
				file_size_limit : "4 MB",	// 4MB
				file_types : "*.pdf",
				file_types_description : "All Files",
				file_upload_limit : "0",
				
				// Event Handler Settings - these functions as defined in Handlers.js
				//  The handlers are not part of SWFUpload but are part of my website and control how
				//  my website reacts to the SWFUpload events.
				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,
				upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : uploadSuccess,
				upload_complete_handler : uploadComplete2,

				// Button Settings
				button_image_url : "/STOMS/Resource/Image/SmallSpyGlassWithTransperancy_17x18.png",
				button_placeholder_id : "spanButtonPlaceHolder2",
				button_width: 170,
				button_height: 18,
				button_text : '<span class="button">开卡"省科技项目"Pdf</span>',
				button_text_style : '.button { font-family: Helvetica, Arial, sans-serif; font-size: 12pt; }',
				button_text_top_padding: 0,
				button_text_left_padding: 18,
				button_window_mode: SWFUpload.WINDOW_MODE.TRANSPARENT,
				button_cursor: SWFUpload.CURSOR.HAND,
				
				// Flash Settings
				flash_url : "swf/swfupload.swf",
				/**
				custom_settings : {
					upload_target : "divFileProgressContainer"
				},
				**/
				// Debug Settings
				debug: false
			});
			swfu3 = new SWFUpload({
				// Backend Settings
				upload_url: "<%=path%>/fileUpload.action",
				post_params: { "flag" : "Twice.xls"  },

				// File Upload Settings
				file_size_limit : "4 MB",	// 4MB
				file_types : "*.xls",
				file_types_description : "All Files",
				file_upload_limit : "0",
				
				// Event Handler Settings - these functions as defined in Handlers.js
				//  The handlers are not part of SWFUpload but are part of my website and control how
				//  my website reacts to the SWFUpload events.
				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,
				upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : uploadSuccess,
				upload_complete_handler : uploadComplete3,

				// Button Settings
				button_image_url : "/STOMS/Resource/Image/SmallSpyGlassWithTransperancy_17x18.png",
				button_placeholder_id : "spanButtonPlaceHolder3",
				button_width: 170,
				button_height: 18,
				button_text : '<span class="button">导入"国家基金"Excel</span>',
				button_text_style : '.button { font-family: Helvetica, Arial, sans-serif; font-size: 12pt; }',
				button_text_top_padding: 0,
				button_text_left_padding: 18,
				button_window_mode: SWFUpload.WINDOW_MODE.TRANSPARENT,
				button_cursor: SWFUpload.CURSOR.HAND,
				
				// Flash Settings
				flash_url : "swf/swfupload.swf",
				/**
				custom_settings : {
					upload_target : "divFileProgressContainer"
				},
				**/
				// Debug Settings
				debug: false
			});
			swfu4 = new SWFUpload({
				// Backend Settings
				upload_url: "<%=path%>/fileUpload.action",
				post_params: { "flag" : "TwiceSheng.pdf"  },

				// File Upload Settings
				file_size_limit : "4 MB",	// 4MB
				file_types : "*.pdf",
				file_types_description : "All Files",
				file_upload_limit : "0",
				
				// Event Handler Settings - these functions as defined in Handlers.js
				//  The handlers are not part of SWFUpload but are part of my website and control how
				//  my website reacts to the SWFUpload events.
				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,
				upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : uploadSuccess,
				upload_complete_handler : uploadComplete4,

				// Button Settings
				button_image_url : "/STOMS/Resource/Image/SmallSpyGlassWithTransperancy_17x18.png",
				button_placeholder_id : "spanButtonPlaceHolder4",
				button_width: 170,
				button_height: 18,
				button_text : '<span class="button">入账"省科技项目"Pdf</span>',
				button_text_style : '.button { font-family: Helvetica, Arial, sans-serif; font-size: 12pt; }',
				button_text_top_padding: 0,
				button_text_left_padding: 18,
				button_window_mode: SWFUpload.WINDOW_MODE.TRANSPARENT,
				button_cursor: SWFUpload.CURSOR.HAND,
				
				// Flash Settings
				flash_url : "swf/swfupload.swf",
				/**
				custom_settings : {
					upload_target : "divFileProgressContainer"
				},
				**/
				// Debug Settings
				debug: false
			});
		};
	</script>
<style type="text/css">
.Rep_tab
{
    margin: 0px auto;
    font: Georgia 11px;
    font-size: 12px;
    font-family: Tahoma, Arial, Helvetica, Sans-serif, "宋体";
    color: #333333;
    text-align: center;
    vertical-align:middle;
    border-collapse: collapse; /*细线表格代码*/
}
/*　Repeater内部Table的td样式 */
.Rep_tab td
{
    border:1px solid #4d9ab0; /*细线表格线条颜色*/
    height: 20px;
}
/*　Repeater内部Table的caption样式 */
.Rep_tab caption
{
    text-align: center;
    font-size: 12px;
    font-weight: bold;
    margin: 0 auto;
}
/*　Repeater内部Table的TR的奇数行样式 */
.Rep_Tab_OddTr
{
    background-color: #f8fbfc;
    color: #000000;
    height: 20px;
     
}
/*　Repeater内部Table的TR的偶数行样式 */
.Rep_Tab_EvenTr
{
    background-color: #e5f1f4;
    color: #000000;
    height: 20px;
}
.Rep_Tab_HeaderTr
{
    background-color: #ffffee;
    color: #000000;
}
/*鼠标经过的颜色*/
.Rep_Tr_Move
{
    background-color: #ecfbd4;
    color: #000000;
    height: 20px;
}
/* 鼠标点击的颜色*/
.Rep_Tr_Click
{
    background-color: #bce774;
    color: #333333;
    height: 20px;
}
/* button 
---------------------------------------------- */
.button {
	display: inline-block;
	zoom: 1; /* zoom and *display = ie7 hack for display:inline-block */
	*display: inline;
	vertical-align: baseline;
	margin: 0 2px;
	outline: none;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	font: 14px/100% Arial, Helvetica, sans-serif;
	padding: .2em 1em .25em;
	text-shadow: 0 1px 1px rgba(0,0,0,.3);
	-webkit-border-radius: .5em; 
	-moz-border-radius: .5em;
	border-radius: .5em;
	-webkit-box-shadow: 0 1px 2px rgba(0,0,0,.2);
	-moz-box-shadow: 0 1px 2px rgba(0,0,0,.2);
	box-shadow: 0 1px 2px rgba(0,0,0,.2);
}
.button:hover {
	text-decoration: none;
}
.button:active {
	position: relative;
	top: 1px;
}


/* white */
.white {
	color: #606060;
	border: solid 1px #b7b7b7;
	background: #fff;
	background: -webkit-gradient(linear, left top, left bottom, from(#fff), to(#ededed));
	background: -moz-linear-gradient(top,  #fff,  #ededed);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff', endColorstr='#ededed');
}
.white:hover {
	background: #ededed;
	background: -webkit-gradient(linear, left top, left bottom, from(#fff), to(#dcdcdc));
	background: -moz-linear-gradient(top,  #fff,  #dcdcdc);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff', endColorstr='#dcdcdc');
}
.white:active {
	color: #999;
	background: -webkit-gradient(linear, left top, left bottom, from(#ededed), to(#fff));
	background: -moz-linear-gradient(top,  #ededed,  #fff);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#ededed', endColorstr='#ffffff');
}
</style>
	
  </head>
  
  <body>
   	
   	<%@include file="/Page/Common/generalMessageDialog.jsp"%>
  	<%@include file="/Page/Common/generalAssureDialog.jsp"%>
  	
  		
  	
  	<div>
  		<br><br>
  	</div>
  	<div id="departmentCode" style="display:none">
		<table id="departmentTable" class="Rep_tab">
			<tr>
				<td>
					院系代码&nbsp;&nbsp;
				</td>
				<td>
					院系名称
				</td>
				<td>
					文/理科&nbsp;&nbsp;
				</td>
				<td>
					院系代码
				</td>
				<td>
					院系名称
				</td>
				<td>
					文/理科
				</td>
			</tr>
		</table>
	</div>
	<div id="confirm" style="display:none">
		<table class="Rep_tab">
			<tr>
				<td colspan="2">
					<h3>您所填写的信息如下</h3>
				</td>
			</tr>
			<tr>
				<td>
					来款单位：
				</td>
				<td>
					<label id="DP"></label>
				</td>
			</tr>
			<tr>
				<td>
					入账人姓名：
				</td>
				<td>
					<label id="name"></label>
				</td>
			</tr>
			<tr>
				<td>
					来款金额：
				</td>
				<td>
					<label id="value"></label>
				</td>
			</tr>
			<tr>
				<td>
					该项目总金额：
				</td>
				<td>
					<label id="totalValue"></label>
				</td>
			</tr>
			<tr>
				<td>
					来款性质：
				</td>
				<td>
					<label id="itemNameAndDepartmentType"></label>
				</td>
			</tr>
			<tr>
				<td>
					是否汇出：
				</td>
				<td>
					<label id="isOut"></label>
				</td>
			</tr>
			<tr>
				<td>
					其它说明：
				</td>
				<td>
					<label id="other"></label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<label id="isFirstAddMoney"></label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<label id="departmentCode0"></label>
				</td>
			</tr>
		</table>
		<table class="Rep_tab">
			<tr>
				<td colspan="3">
					<h3>打印的内容</h3>
				</td>
			</tr>
			<tr>
				<td>
					来款金额：
				</td>
				<td colspan="2">
					<label id="value2"></label>
				</td>
			</tr>
			<tr>
				<td>
					汇出金额：
				</td>
				<td colspan="2">
					<label id="out"></label>
				</td>
			</tr>
			<tr>
				<td>
					管理费1：
				</td>
				<td>
					<label id="manage1P"></label>
				</td>
				<td>
					<label id="manage1V"></label>
				</td>
			</tr>
			<tr>
				<td>
					管理费2：
				</td>
				<td>
					<label id="manage2P"></label>
				</td>
				<td>
					<label id="manage2V"></label>
				</td>
			</tr>
			<tr>
				<td>
					劳务费1：
				</td>
				<td>
					<label id="pay1P"></label>
				</td>
				<td>
					<label id="pay1V"></label>
				</td>
			</tr>
			<tr>
				<td>
					劳务费2：
				</td>
				<td>
					<label id="pay2P"></label>
				</td>
				<td>
					<label id="pay2V"></label>
				</td>
			</tr>
			<tr>
				<td>
					业务活动费：
				</td>
				<td>
					<label id="actP"></label>
				</td>
				<td>
					<label id="actV"></label>
				</td>
			</tr>
			<tr>
				<td>
					改善工作条件费：
				</td>
				<td>
					<label id="improveP"></label>
				</td>
				<td>
					<label id="improveV"></label>
				</td>
			</tr>
			<tr>
				<td>
					专家咨询费：
				</td>
				<td>
					<label id="consultP"></label>
				</td>
				<td>
					<label id="consultV"></label>
				</td>
			</tr>
			<tr>
				<td>
					可用管理额度：
				</td>
				<td>
					<label id="aviP"></label>
				</td>
				<td>
					<label id="aviV"></label>
				</td>
			</tr>
		</table>
		<button class="button white" type="button" onclick="submit()" id="cmdSubmit">
			提交
		</button>
	</div>
	<div id="ManageIndicatorCalc" style="display:none">
			<table>
				<tr>
					<td>
						直接费用：
					</td>
					<td>
						<input type="text" class="validate[option, custom[number], min[0]]" id="directFee"/>
						&nbsp;元
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td>
						间接费用：
					</td>
					<td>
						<input type="text" class="validate[option, custom[number], min[0]]" id="indirectFee"/>
						&nbsp;元
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td>
						绩效支出：
					</td>
					<td>
						<input type="text" class="validate[option, custom[number], min[0]]" id="performanceSpending"/>
						&nbsp;元
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td>
						设备购置费：
					</td>
					<td>
						<input type="text" class="validate[option, custom[number], min[0]]" id="equipmentPurchaseFee"/>
						&nbsp;元
					</td>
					<td>
						<input type="button" class="button white" value="计算费用" onclick="calc()" id="calc"/>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<hr/>
					</td>
				</tr>
				<tr>
					<td>
						管理费1：
					</td>
					<td>
						<input type="text" class="validate[option, custom[number], min[0]]" id="manageFee1"/>
						&nbsp;元
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td>
						课题绩效支出：
					</td>
					<td>
						<input type="text" class="validate[option, custom[number], min[0]]" id="taskPerformanceSpending"/>
						&nbsp;元
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td>
						院系公共支出：
					</td>
					<td>
						<input type="text" class="validate[option, custom[number], min[0]]" id="departmentPublicSpending"/>
						&nbsp;元
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td>
						课题统筹支出：
					</td>
					<td>
						<input type="text" class="validate[option, custom[number], min[0]]" id="taskPlanSpending"/>
						&nbsp;元
					</td>
					<td>
						<input type="button" class="button white" value="确定" onclick="yes()" id="yes"/>
					</td>
				</tr>
			</table>
	</div>
		
   	<div align = "center">
        
	   	<form id = "addMoneyForm" method="post">

			<table align="center" style="width: 80%;">
				<caption style = "height:40px;">
					<form>
					        <div style="float:left;width: 170px; border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px;">
								<span id="spanButtonPlaceHolder"></span>
							</div>
							&nbsp;&nbsp;
							<div style="float:left;width: 170px; border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px;">
								<span id="spanButtonPlaceHolder2"></span>
							</div>
							&nbsp;&nbsp;
							<div style="float:left;width: 170px; border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px;">
								<span id="spanButtonPlaceHolder3"></span>
							</div>
							&nbsp;&nbsp;
							<div style="float:left;width: 170px; border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px;">
								<span id="spanButtonPlaceHolder4"></span>
							</div>
					</form>
					<br></br>
					<h3>
						请输入项目详细资料
					</h3>
					
				</caption>
				<tr>
					<td align="right">来款单位:</td>
					<td>
						<input type="text" class="validate[required]" id = "txtDP"/>
					</td>
				</tr>
				<tr>
					<td align="right">入账人姓名:</td>
					<td>
						<input type="text" id = "txtName"/>
						和
						<input type="text" id = "txtName2"/>
					</td>
				</tr>
				<tr>
					<td align="right">来款金额:</td>
					<td> 
						<input type="text"  class="validate[required, custom[number], min[0]]" id = "txtValue" onkeyup = "valueOrOutChange()"/>
						&nbsp;&nbsp;元
					</td>
				</tr>
				<tr>
					<td align="right">项目代码:</td>
					<td>
						<input type="text"  class="validate[option, custom[integer], minSize[10], maxSize[12]]" id = "txtID"/>&nbsp;&nbsp;
						开新卡时不填写，则产生随机数作为新项目的代码
					</td>
				</tr>
			</table>
			<table align="center" style="width: 70%;">
				<tr>
					<td>理科:</td>
					<td>
						<select id="science" style = "height:20px; width:240px">
							<option value="notme">无</option>
						</select>
					</td>
					<td>文科:</td>
					<td>
						<select id="art" style = "height:20px; width:220px">
							<option value="notme">无</option>
						</select>
					</td>
				</tr>
				
			</table>
			<hr width="80%" />
			<table  align="center" style="width: 80%; text-align: center;">
				<tr>
					<td></td>
					<td>汇出金额:</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtOut" onkeyup = "valueOrOutChange()()"/>
						&nbsp;&nbsp;元
						&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td>其它说明:</td>
					<td>
						该块已移至最下方。
					</td>
				</tr>
				<tr>
					<td></td>
					<td>自行确定劳务费1 金额:</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtNewPay"/>
						&nbsp;&nbsp;元
						&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td>自行确定管理费1 金额:</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtManage"/>
						&nbsp;&nbsp;元
					</td>
				</tr>
				<tr>
					<td></td>
					<td>自行确定劳务费2 金额:</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtNewPay2"/>
						&nbsp;&nbsp;元
						&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td>自行确定管理费2 金额:</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtManage2"/>
						&nbsp;&nbsp;元
					</td>
				</tr>
				<tr>
					<td>
					<input type="checkbox" id="chk_availableManageCredit"/>
					</td>
					<td>自行确定可用管理额度:</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtAvailableManageCredit"/>
						&nbsp;&nbsp;元
						&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td>自行确定专家咨询费:</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtConsult"/>
						&nbsp;&nbsp;元
					</td>
				</tr>
			</table>
			<table   align="center" style="width: 80%; text-align: center;">
				<tr>
					<td>
						<button class="button white" type="button" id="comSepecial"  onclick="$('#ManageIndicatorCalc').show;dlg=new Dialog({type:'id',value:'ManageIndicatorCalc'}).show();" >
							管理指标计算器
						</button>
					</td>
					<td>院系公共支出:</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtDepartPublic"/>
						&nbsp;&nbsp;元
						&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td>课题统筹支出:</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtCoProject"/>
						&nbsp;&nbsp;元
					</td>
				</tr>
				<tr>
					<td></td>
					<td>绩效(80%):</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtPerformance1"/>
						&nbsp;&nbsp;元
						&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td>绩效(20%):</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtPerformance2"/>
						&nbsp;&nbsp;元
					</td>
				</tr>
			</table>
			<table  align="center" style="width: 80%;">
				<tr>
					<td colspan="2" width="17%">
						<input type="checkbox" id="chkIsBroadwise"/>
						是否是横向项目
					</td>
					<td colspan="8">
						<hr/>
					</td>
				</tr>
				<tr id="row1" style="display: none">
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td colspan="2">
						院系酬金(5%):
					</td>
					<td >
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtDepartmentPay"/>
					</td>
					<td >
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="checkbox" id="chkIsArt"/>
						文科劳务费3：
					</td>
					<td colspan="5">
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtArtPay"/>
					</td>
				</tr>
				<tr id="row2" style="display: none">
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td colspan="3">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="checkbox" id="chkIsTax"/>
						是否税金
					</td>
					<td >
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="checkbox" id="chkIsScience"/>
						理科劳务费3：
					</td>
					<td colspan="6">
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtSciencePay"/>
					</td>
				</tr>
				<tr id="row3" style="display: none">
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td >&nbsp;&nbsp;&nbsp;&nbsp;税金1：</td>
					<td colspan="2"><input type="text"  class="validate[option, custom[number], min[0]]" id = "txtTax1"/></td>
					<td >&nbsp;&nbsp;&nbsp;&nbsp;税金2：</td>
					<td colspan="2"><input type="text"  class="validate[option, custom[number], min[0]]" id = "txtTax2"/></td>
					<td >&nbsp;&nbsp;&nbsp;&nbsp;税金3：</td>
					<td colspan="2"><input type="text"  class="validate[option, custom[number], min[0]]" id = "txtTax3"/></td>
					<td></td>
				</tr>
			</table>
			
			<table  align="center" style="width: 80%;">
				<tr>
					<td colspan="3" width="39%">
						<input type="checkbox" id="chkNewCard"/>
						第一次拨款，需要开新卡，请填写以下内容
					</td>
					<td colspan="4">
						<hr/>
					</td>
				</tr>
				<tr id="row4" style="display: none">
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						项目名称：
					</td>
					<td>
						<input type="text" id = "txtNewName"/>
					</td>
					<td>
						合同号：
					</td>
					<td>
						<input type="text" id = "txtContractID"/>
					</td>
					<td>
						项目总金额：
					</td>
					<td>
						<input type="text"  class="validate[option, custom[number], min[0]]" id = "txtTotalValue"/>
					</td>
				</tr>
				<tr id="row5" style="display: none">
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						项目开始时间：
					</td>
					<td colspan="2">
						<input type="text"  class="validate[option, custom[date]]" id = "time1"/>
					</td>
					<td>
						项目结束时间：
					</td>
					<td colspan="2">
						<input type="text"  class="validate[option, custom[date]]" id = "time2"/>
					</td>
				</tr>
				<tr id="row6" style="display: none">
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						入账人院系：
					</td>
					<td colspan="2">
						<input type="text"  class="validate[required, custom[integer], minSize[4], maxSize(4), min[0]]" id = "txtDept"/>
					</td>
					<td colspan="2">
						入账人的院系代码，点击按钮可查询：
					</td>
					<td >
						<button class="button white" type="button" id="cmdDept">
							院系代码
						</button>
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td width="10%"></td>							
					<td width="40%"></td>	
					<td width="10%">其它说明：</td>							
					<td width="40%"><textarea id = "txtOther" rows="2" cols="40" style="font-size: 14px"></textarea></td>	
				</tr>
			</table>
		</form>
	
		<div align = "center">
				<br/><br/>
				<button class="button white" type = "button" id = "cmdOK">确定信息</button>
		</div>
	</div>
	
	<div align = "right">
				<br/><br/>
			</div>
		
  </body>
</html>
