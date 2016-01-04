<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>"></base>

<title>增加经费预算</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="CSS/idealForms/idealForms-theme-sapphire.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="CSS/validationEngine/validationEngine.jquery.css"
	rel="stylesheet" type="text/css" />
<link href="CSS/formPage.css" rel="stylesheet" type="text/css" />
<link href="JqueryLib/development-bundle/themes/base/jquery.ui.all.css"
	rel="stylesheet" type="text/css" />
<link href="JqueryLib/editable-select/jquery.editable-select.css"
	rel="stylesheet" type="text/css" />

<script type="text/javascript" src="JqueryLib/js/jquery-1.7.js"></script>
<script type="text/javascript" src="JS/common/util.js"></script>

<script type="text/javascript"
	src="JqueryLib/validationEngine/jquery.validationEngine-zh_CN.js"></script>
<script type="text/javascript"
	src="JqueryLib/validationEngine/jquery.validationEngine.js"></script>
<!--
	<script type="text/javascript" src="JqueryLib/editable-select/jquery.editable-select.js"></script>
	-->
<script type="text/javascript" src="JqueryLib/SetEditComb.js"></script>

<script type="text/javascript"
	src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
<script type="text/javascript"
	src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
<script type="text/javascript"
	src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
<script type="text/javascript"
	src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>

<LINK href="JqueryLib/dialog/dialog.css" type=text/css rel=stylesheet>
<SCRIPT src="JqueryLib/dialog/dialog.js" type=text/javascript></SCRIPT>
<script type="text/javascript" src="JS/common/fileUpload.js"></script>
<script type="text/javascript" src="JS/common/swfupload.js"></script>

<script type="text/javascript" src="JS/teacher/budget/verifyBudget.js"></script>


<script type="text/javascript">
		/* 传过来的是项目编号 */
  		var itemId = "<%=request.getParameter("projectId")%>";
	</script>

<script type="text/javascript">
		var swfu;
		window.onload = function () {
			swfu = new SWFUpload({
				// Backend Settings
				upload_url: "<%=path%>/fileUpload.action",
			post_params : {
				"flag" : "GuoJia.pdf"
			},

			// File Upload Settings
			file_size_limit : "4 MB", // 4MB
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
			upload_complete_handler : uploadCompleteBudget,

			// Button Settings
			//button_image_url : "/STOMS/Resource/Image/SmallSpyGlassWithTransperancy_17x18.png",
			button_placeholder_id : "spanButtonPlaceHolder",
			button_width : 80,
			button_height : 26,
			button_text : '<span class="theFont">导入预算</span>',
			button_text_style : ".theFont { font-size: 16; }",
			button_text_top_padding : 0,
			button_text_left_padding : 0,
			button_window_mode : SWFUpload.WINDOW_MODE.TRANSPARENT,
			button_cursor : SWFUpload.CURSOR.HAND,

			// Flash Settings
			flash_url : "swf/swfupload.swf",
			/**
			custom_settings : {
				upload_target : "divFileProgressContainer"
			},
			 **/
			// Debug Settings
			debug : false
		});

	};
</script>
<style type="text/css">
.Rep_tab {
	margin: 0px auto;
	font: Georgia 11px;
	font-size: 12px;
	font-family: Tahoma, Arial, Helvetica, Sans-serif, "宋体";
	color: #333333;
	text-align: center;
	vertical-align: middle;
	border-collapse: collapse; /*细线表格代码*/
}
/*　Repeater内部Table的td样式 */
.Rep_tab td {
	border: 1px solid #4d9ab0; /*细线表格线条颜色*/
	height: 20px;
}
/*　Repeater内部Table的caption样式 */
.Rep_tab caption {
	text-align: center;
	font-size: 12px;
	font-weight: bold;
	margin: 0 auto;
}
/*　Repeater内部Table的TR的奇数行样式 */
.Rep_Tab_OddTr {
	background-color: #f8fbfc;
	color: #000000;
	height: 20px;
}
/*　Repeater内部Table的TR的偶数行样式 */
.Rep_Tab_EvenTr {
	background-color: #e5f1f4;
	color: #000000;
	height: 20px;
}

.Rep_Tab_HeaderTr {
	background-color: #ffffee;
	color: #000000;
}
/*鼠标经过的颜色*/
.Rep_Tr_Move {
	background-color: #ecfbd4;
	color: #000000;
	height: 20px;
}
/* 鼠标点击的颜色*/
.Rep_Tr_Click {
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
	text-shadow: 0 1px 1px rgba(0, 0, 0, .3);
	-webkit-border-radius: .5em;
	-moz-border-radius: .5em;
	border-radius: .5em;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
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
	background: -webkit-gradient(linear, left top, left bottom, from(#fff),
		to(#ededed) );
	background: -moz-linear-gradient(top, #fff, #ededed);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff',
		endColorstr='#ededed' );
}

.white:hover {
	background: #ededed;
	background: -webkit-gradient(linear, left top, left bottom, from(#fff),
		to(#dcdcdc) );
	background: -moz-linear-gradient(top, #fff, #dcdcdc);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff',
		endColorstr='#dcdcdc' );
}

.white:active {
	color: #999;
	background: -webkit-gradient(linear, left top, left bottom, from(#ededed),
		to(#fff) );
	background: -moz-linear-gradient(top, #ededed, #fff);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ededed',
		endColorstr='#ffffff' );
}
</style>

</head>

<body>

	<%@include file="/Page/Common/generalMessageDialog.jsp"%>
	<%@include file="/Page/Common/generalAssureDialog.jsp"%>

	<div align="center">

		<form id="addMoneyForm" method="post">

			<table align="center" style="width: 71%;">

				<tr>
					<caption>
						<h2>查看预算</h2>
					</caption>
				</tr>
				<tr>

					<td></td>
					<td style="text-align:left" width="129"><b></b>
					</td>

					<td width="168" style="text-align: left"><input type="text"
						style="display :none"
						class="validate[option, custom[number], min[0]]"
						id="txtContractID" /></td>

					<td style="text-align: left" width="128"><b></b></td>

					<td width="366" style="text-align: left"><input type="text"
						style="display :none"
						class="validate[option, custom[number], min[0]]" id="txtName" />
						&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
			</table>

			<table align="center" style="width: 78%; text-align: center">
				<tr>
					<td width="132"></td>

					<td width="314">
						<p style="text-align: left">
							<span style="font-size: 15pt">科目 </span>
					</td>
					<td width="347">
						<p style="text-align: left">
							<font style="font-size: 15pt">申请经费(万元) </font>
					</td>
				</tr>


				<tr>
					<td width="132"></td>
					<td style="text-align: left" width="314"><b>一.研究经费:</b>
					</td>
					<td width="347" style="text-align: left"><input type="text"
						class="validate[option, custom[number], min[0]]" id="studyOutlay" />
						&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="132"></td>
					<td style="text-align: left" width="314">1.科研业务费:<b> </b>
					</td>
					<td width="347" style="text-align: left"><input type="text"
						class="validate[option, custom[number], min[0]]"
						id="studyOutlay_sr" /> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="132"></td>
					<td style="text-align: left" width="314">（1）测试/计算/分析费:</td>
					<td width="347" style="text-align: left"><input type="text"
						class="validate[option, custom[number], min[0]]"
						id="studyOutlay_sr_test" /> &nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="132"></td>
					<td style="text-align: left" width="314">（2）能源/动力费:</td>
					<td width="347" style="text-align: left"><input type="text"
						class="validate[option, custom[number], min[0]]"
						id="studyOutlay_sr_energy" /> &nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="132"></td>
					<td style="text-align: left" width="314">（3）会议费/差旅费:</td>
					<td width="347" style="text-align: left"><input type="text"
						class="validate[option, custom[number], min[0]]"
						id="studyOutlay_sr_meeting" /> &nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="132"></td>
					<td style="text-align: left" width="314">（4）出版物/文献/信息传播费:</td>
					<td width="347" style="text-align: left"><input type="text"
						class="validate[option, custom[number], min[0]]"
						id="studyOutlay_sr_publish" /> &nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="132"></td>
					<td style="text-align: left" width="314">（5）其他:</td>
					<td width="347" style="text-align: left"><input type="text"
						class="validate[option, custom[number], min[0]]"
						id="studyOutlay_sr_other" /> &nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="132"></td>
					<td style="text-align: left" width="314">2.实验材料费:</td>
					<td width="347" style="text-align: left"><input type="text"
						class="validate[option, custom[number], min[0]]"
						id="studyOutlay_em" /> &nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="132"></td>
					<td style="text-align: left" width="314">（1）原材料/试剂/药品购置费:</td>
					<td width="347" style="text-align: left"><input type="text"
						class="validate[option, custom[number], min[0]]"
						id="studyOutlay_em_material" /> &nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="132" height="23"></td>
					<td style="text-align: left" width="314" height="23">（2）其他:</td>
					<td width="347" style="text-align: left" height="23"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="studyOutlay_em_other" /> &nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="132"></td>
					<td style="text-align: left" width="314">3.仪器设备费:</td>
					<td width="347" style="text-align: left"><input type="text"
						class="validate[option, custom[number], min[0]]"
						id="studyOutlay_ei" /> &nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="132"></td>
					<td style="text-align: left" width="314">（1）购置:</td>
					<td width="347" style="text-align: left"><input type="text"
						class="validate[option, custom[number], min[0]]"
						id="studyOutlay_ei_purchase" /> &nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="132"></td>
					<td style="text-align: left" width="314">（2）试制:</td>
					<td width="347" style="text-align: left"><input type="text"
						class="validate[option, custom[number], min[0]]"
						id="studyOutlay_ei_produce" /> &nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="132"></td>
					<td style="text-align: left" width="314">4.实验室改装费:</td>
					<td width="347" style="text-align: left"><input type="text"
						class="validate[option, custom[number], min[0]]"
						id="studyOutlay_lr" /> &nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="132"></td>
					<td style="text-align: left" width="314">5.协作费:</td>
					<td width="347" style="text-align: left"><input type="text"
						class="validate[option, custom[number], min[0]]"
						id="studyOutlay_colaborate" /> &nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="132"></td>
					<td style="text-align: left" width="314"><b>二.国际合作与交流费:</b>
					</td>
					<td width="347" style="text-align: left"><input type="text"
						class="validate[option, custom[number], min[0]]"
						id="international" /> &nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="132"></td>
					<td style="text-align: left" width="314">1.项目组成员出国合作交流:</td>
					<td width="347" style="text-align: left"><input type="text"
						class="validate[option, custom[number], min[0]]"
						id="international_1" /> &nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="132"></td>
					<td style="text-align: left" width="314">2.境外专家来华合作交流:</td>
					<td width="347" style="text-align: left"><input type="text"
						class="validate[option, custom[number], min[0]]"
						id="international_2" /> &nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="132"></td>
					<td style="text-align: left" width="314"><b>三.劳务费:</b>
					</td>
					<td width="347" style="text-align: left"><input type="text"
						class="validate[option, custom[number], min[0]]" id="service" />
						&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="132"></td>
					<td style="text-align: left" width="314"><b>四.管理费:</b>
					</td>
					<td width="347" style="text-align: left"><input type="text"
						class="validate[option, custom[number], min[0]]" id="management" />
						&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="132"></td>
					<td style="text-align: left" width="314"><b>合 计:</b>
					</td>
					<td width="347" style="text-align: left"><input type="text"
						class="validate[option, custom[number], min[0]]" id="sum" />
						&nbsp;&nbsp;</td>
				</tr>
			</table>



		</form>



		<div align="center">
			<hr width="80%" />
			<p></p>
			<table border="0" width="31%">
				<tr>
					<td align="center">
						<p align="left">
							<button class="button white" type="button"
								id="spanButtonPlaceHolder" style="width: 79; height: 64">
								<p align="left">
							</button>
					</td>
					<td align="center">
						<p align="left">
							<button class="button white" type="button" id="assureButton"
								onclick="isInsertBudget()">
								<p align="left">下一步
							</button>
					</td>
				</tr>
			</table>
		</div>
		<div align="center"></div>
		<div align="center"></div>
	</div>

	<div align="right">
		<br /> <br />
	</div>

</body>


</html>
