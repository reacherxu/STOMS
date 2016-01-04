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

<script type="text/javascript"
	src="JS/teacher/budget/verifyExpenditure.js"></script>
<script type="text/javascript">
		/* 传过来的是项目编号 */
  		var itemId = "<%=request.getParameter("projectId")%>";
</script>

<style type="text/css">

:link, 
a:visited { 
color:black; 
text-decoration:none; 
} 
a:hover, 
a:active { 
color:blue; 
text-decoration:underline; 
} 

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

				<caption>
					<h2>支出统计</h2>
				</caption>
			</table>
			<hr width="80%" />
			<table align="center" style="width: 79%; text-align: center">
				<tr>
					<td width="0"></td>

					<td width="244">
						<p style="text-align: left">科目
					</td>
					<td width="116">
						<p style="text-align: left">申请经费(万元)
					</td>
					<td width="108">
						<p style="text-align: left">支出(万元)
					</td>
					<td width="108">
						<p style="text-align: left">差额(万元)
					</td>
					<td width="161">
						<p style="text-align: left">是否超支
					</td>

				</tr>

				<tr>
					<td width="0" height="39"></td>
					<td style="text-align: left" width="244" height="39">
					<b>一.<a href="Page/Teacher/budget/verifyDetail.jsp?projectId=<%=request.getParameter("projectId")%>&param=research">研究经费</a>:</b>
					</td>
					<td width="116" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="studyOutlay" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="research" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="research_balance" size="12" />
					</td>
					<td width="161" style="text-align: left" height="39"><input 
						type="text" class="validate[option, custom[number], min[0]]"
						id="research_percentage" size="12" style="background:transparent;border:0"/>
					</td>


				</tr>
				<tr>
					<td width="0" height="39"></td>
					<td style="text-align: left" width="244" height="39">
					<b>1.<a href="Page/Teacher/budget/verifyDetail.jsp?projectId=<%=request.getParameter("projectId")%>&param=srbusiness">科研业务费</a>:</b>
					</td>
					<td width="116" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="studyOutlay_sr" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="srbusiness" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="srbusiness_balance" size="12" />
					</td>
					<td width="161" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="srbusiness_percentage" size="12" style="background:transparent;border:0"/>
					</td>


				</tr>
				<tr>
					<td width="0"></td>
					<td style="text-align: left" height="46" width="244">
					（1）<a href="Page/Teacher/budget/verifyDetail.jsp?projectId=<%=request.getParameter("projectId")%>&param=test">测试/计算/分析费</a>:</td>
					<td width="116" style="text-align: left" height="46"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="studyOutlay_sr_test" size="12" /></td>
					<td width="108" style="text-align: left" height="46"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="test" size="12" />
					</td>
					<td width="108" style="text-align: left" height="46"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="test_balance" size="12" />
					</td>
					<td width="161" style="text-align: left" height="46"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="test_percentage" size="12" style="background:transparent;border:0"/>
					</td>


				</tr>
				<tr>
					<td width="0"></td>
					<td style="text-align: left" height="39" width="244">
					（2）<a href="Page/Teacher/budget/verifyDetail.jsp?projectId=<%=request.getParameter("projectId")%>&param=energy">能源/动力费</a>:</td>
					<td width="116" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="studyOutlay_sr_energy" size="12" />
					</td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="energy" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="energy_balance" size="12" /></td>
					<td width="161" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="energy_percentage" size="12" style="background:transparent;border:0"/></td>


				</tr>
				<tr>
					<td width="0"></td>
					<td style="text-align: left" height="39" width="244">
					（3）<a href="Page/Teacher/budget/verifyDetail.jsp?projectId=<%=request.getParameter("projectId")%>&param=meetings">会议费/差旅费</a>:</td>
					<td width="116" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="studyOutlay_sr_meeting" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="meetings" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="meetings_balance" size="12" />
					</td>
					<td width="161" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="meetings_percentage" size="12" style="background:transparent;border:0"/>
					</td>


				</tr>
				<tr>
					<td width="0"></td>
					<td style="text-align: left" height="39" width="244">
					（4）<a href="Page/Teacher/budget/verifyDetail.jsp?projectId=<%=request.getParameter("projectId")%>&param=publishments">出版物/文献/信息传播费</a>:</td>
					<td width="116" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="studyOutlay_sr_publish" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="publishments" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="publishments_balance" size="12" />
					</td>
					<td width="161" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="publishments_percentage" size="12" style="background:transparent;border:0"/>
					</td>


				</tr>
				<tr>
					<td width="0"></td>
					<td style="text-align: left" height="39" width="244">
					（5）<a href="Page/Teacher/budget/verifyDetail.jsp?projectId=<%=request.getParameter("projectId")%>&param=other_srbusiness">其他</a>:</td>
					<td width="116" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="studyOutlay_sr_other" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="other_srbusiness" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="other_srbusiness_balance" size="12" />
					</td>
					<td width="161" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="other_srbusiness_percentage" size="12" style="background:transparent;border:0"/>
					</td>


				</tr>
				<tr>
					<td width="0"></td>
					<td style="text-align: left" height="39" width="244">
					<b>2.<a href="Page/Teacher/budget/verifyDetail.jsp?projectId=<%=request.getParameter("projectId")%>&param=experiment_material">实验材料费</a>:</b>
					</td>
					<td width="116" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="studyOutlay_em" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="experiment_material" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="experiment_material_balance" size="12" />
					</td>
					<td width="161" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="experiment_material_percentage" size="12" style="background:transparent;border:0"/>
					</td>


				</tr>
				<tr>
					<td width="0"></td>
					<td style="text-align: left" height="39" width="244">
					（1）<a href="Page/Teacher/budget/verifyDetail.jsp?projectId=<%=request.getParameter("projectId")%>&param=raw_material">原材料/试剂/药品购置费</a>:</td>
					<td width="116" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="studyOutlay_em_material" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="raw_material" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="raw_material_balance" size="12" />
					</td>
					<td width="161" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="raw_material_percentage" size="12" style="background:transparent;border:0"/>
					</td>


				</tr>
				<tr>
					<td width="0"></td>
					<td style="text-align: left" height="39" width="244">
					（2）<a href="Page/Teacher/budget/verifyDetail.jsp?projectId=<%=request.getParameter("projectId")%>&param=other_material">其他</a>:</td>
					<td width="116" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="studyOutlay_em_other" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="other_material" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="other_material_balance" size="12" />
					</td>
					<td width="161" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="other_material_percentage" size="12" style="background:transparent;border:0"/>
					</td>


				</tr>
				<tr>
					<td width="0" height="22"></td>
					<td style="text-align: left" height="39" width="244" height="22">
					<b>3.<a href="Page/Teacher/budget/verifyDetail.jsp?projectId=<%=request.getParameter("projectId")%>&param=equipment">仪器设备费</a>:</b>
					</td>
					<td width="116" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="studyOutlay_ei" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="equipment" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="equipment_balance" size="12" />
					</td>
					<td width="161" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="equipment_percentage" size="12" style="background:transparent;border:0"/>
					</td>



				</tr>
				<tr>
					<td width="0"></td>
					<td style="text-align: left" height="39" width="244">
					（1）<a href="Page/Teacher/budget/verifyDetail.jsp?projectId=<%=request.getParameter("projectId")%>&param=equipment_purchase">购置</a>:</td>
					<td width="116" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="studyOutlay_ei_purchase" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="equipment_purchase" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="equipment_purchase_balance" size="12" />
					</td>
					<td width="161" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="equipment_purchase_percentage" size="12" style="background:transparent;border:0"/>
					</td>


				</tr>
				<tr>
					<td width="0"></td>
					<td style="text-align: left" height="39" width="244">
					（2）<a href="Page/Teacher/budget/verifyDetail.jsp?projectId=<%=request.getParameter("projectId")%>&param=equipment_produce">试制</a>:</td>
					<td width="116" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="studyOutlay_ei_produce" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="equipment_produce" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="equipment_produce_balance" size="12" />
					</td>
					<td width="161" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="equipment_produce_percentage" size="12" style="background:transparent;border:0"/>
					</td>


				</tr>
				<tr>
					<td width="0"></td>
					<td style="text-align: left" height="39" width="244">
					<b>4.<a href="Page/Teacher/budget/verifyDetail.jsp?projectId=<%=request.getParameter("projectId")%>&param=lab_reconstruction">实验室改装费</a>:</b>
					</td>
					<td width="116" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="studyOutlay_lr" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="lab_reconstruction" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="lab_reconstruction_balance" size="12" />
					</td>
					<td width="161" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="lab_reconstruction_percentage" size="12" style="background:transparent;border:0"/>
					</td>


				</tr>
				<tr>
					<td width="0"></td>
					<td style="text-align: left" height="39" width="244">
					<b>5.<a href="Page/Teacher/budget/verifyDetail.jsp?projectId=<%=request.getParameter("projectId")%>&param=collaboration">协作费</a>:</b>
					</td>
					<td width="116" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="studyOutlay_colaborate" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="collaboration" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="collaboration_balance" size="12" />
					</td>
					<td width="161" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="collaboration_percentage" size="12" style="background:transparent;border:0"/>
					</td>

				</tr>
				<tr>
					<td width="0"></td>
					<td style="text-align: left" height="39" width="244">
					<b>二.<a href="Page/Teacher/budget/verifyDetail.jsp?projectId=<%=request.getParameter("projectId")%>&param=international_communication">国际合作与交流费</a>:</b>
					</td>
					<td width="116" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="international" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="international_communication" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="international_communication_balance" size="12" />
					</td>
					<td width="161" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="international_communication_percentage" size="12" style="background:transparent;border:0"/>
					</td>


				</tr>
				<tr>
					<td width="0"></td>
					<td style="text-align: left" height="39" width="244">
					1.<a href="Page/Teacher/budget/verifyDetail.jsp?projectId=<%=request.getParameter("projectId")%>&param=export_communication">项目组成员出国合作交流</a>:</td>
					<td width="116" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="international_1" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="export_communication" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="export_communication_balance" size="12" />
					</td>
					<td width="161" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="export_communication_percentage" size="12" style="background:transparent;border:0"/>
					</td>


				</tr>
				<tr>
					<td width="0"></td>
					<td style="text-align: left" height="39" width="244">
					2.<a href="Page/Teacher/budget/verifyDetail.jsp?projectId=<%=request.getParameter("projectId")%>&param=import_communication">境外专家来华合作交流:</a></td>
					<td width="116" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="international_2" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="import_communication" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="import_communication_balance" size="12" />
					</td>
					<td width="161" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="import_communication_percentage" size="12" style="background:transparent;border:0"/>
					</td>


				</tr>
				<tr>
					<td width="0"></td>
					<td style="text-align: left" height="39" width="244">
					<b>三.<a href="Page/Teacher/budget/verifyDetail.jsp?projectId=<%=request.getParameter("projectId")%>&param=labour">劳务费</a>:</b>
					</td>
					<td width="116" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="service" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="labour" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="labour_balance" size="12" />
					</td>
					<td width="161" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="labour_percentage" size="12" style="background:transparent;border:0"/>
					</td>

				</tr>
				<tr></tr>
				
				<tr>
					<td width="0"></td>
					<td style="text-align: left" height="39" width="244">
					<b>四.<a href="Page/Teacher/budget/verifyDetail.jsp?projectId=<%=request.getParameter("projectId")%>&param=management">管理费</a>:</b>
					</td>
					<td width="116" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="management" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="management_expenditure" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="management_expenditure_balance" size="12" />
					</td>
					<td width="161" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="management_expenditure_percentage" size="12" style="background:transparent;border:0"/>
					</td>


				</tr>
				<tr>
					<td width="0"></td>
					<td style="text-align: left" height="39" width="244"><b>合
							计:</b></td>
					<td width="116" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="sum" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="sum_expenditure" size="12" /></td>
					<td width="108" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="sum_expenditure_balance" size="12" />
					</td>
					<td width="161" style="text-align: left" height="39"><input
						type="text" class="validate[option, custom[number], min[0]]"
						id="sum_expenditure_percentage" size="12" style="background:transparent;border:0"/>
					</td>


				</tr>
			</table>



		</form>



		<div align="center">
			<hr width="80%" />
			<p></p>
			<table border="0" width="31%">
				<tr>
					<td align="center">
						<p>
							<button class="button white" type="button" id="btnReturn"
								onclick="returnTeacherPage()">
								<p>返回
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