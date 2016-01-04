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
		<base href="<%=basePath%>">

		<title>国家重大专项课题支出预算科目调整情况表</title>

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
		<link
			href="JqueryLib/development-bundle/themes/base/jquery.ui.all.css"
			rel="stylesheet" type="text/css" />

		<script type="text/javascript"
			src="JqueryLib/development-bundle/jquery-1.6.2.js"></script>
		<script type="text/javascript" src="JS/common/util.js"></script>

		<script type="text/javascript"
			src="JqueryLib/validationEngine/jquery.validationEngine-zh_CN.js"></script>
		<script type="text/javascript"
			src="JqueryLib/validationEngine/jquery.validationEngine.js"></script>

		<script type="text/javascript"
			src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
		<script type="text/javascript"
			src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
		<script type="text/javascript"
			src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
		<script type="text/javascript"
			src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>

		<script type="text/javascript"
			src="JS/teacher/projectManagement/863AdjustView.js"></script>


		<script type="text/javascript" src="JS/common/fileUpload.js"></script>

		<script type="text/javascript" src="JS/common/PrintAndExcel.js"></script>

		<style type="text/css">
label {
	width: 148px;
}

input {
	width: 100px;
}

textarea {
	width: 250px;
	height: 60px;
}
</style>

		<script type="text/javascript">
	   var itemPK = "<%=request.getParameter("itemPK")%>";
	   var a863adjustPk = "<%=request.getParameter("a863adjustPk")%>";
</script>

	</head>

	</head>
	<body>

		<%@include file="/Page/Common/generalMessageDialog.jsp"%>
		<%@include file="/Page/Common/generalAssureDialog.jsp"%>



		<div align="center" id="table">
			<form id="nation863AdjustForm">

				<table align="center" style="width: 90%;" border="1" cellspacing="0"
					borderColor="#7EC0EE">
					<caption style="height: 50px;">
						<h2>
							国家重大专项课题支出预算科目调整情况表
						</h2>
					</caption>
					<tr bgColor=#e2e4ff>
						<td width="34%">
							<b>科目</b>
						</td>
						<td width="22%">
							<b>批准专项经费预算</b>
						</td>
						<td width="22%">
							<b>计划调整专项经费预算</b>
						</td>
						<td width="22%">
							<b>调整后专项经费预算</b>
						</td>
					</tr>
					<tr>
						<td>
							一.经费支出
						</td>
						<td>
							<label id="costSum_before"></label>
						</td>
						<td>
							<label id="costSum_adjust"></label>
						</td>
						<td>
							<label id="costSum_after"></label>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;&nbsp; 1.设备费
						</td>
						<td>
							<label id="equipmentCost_before"></label>
						</td>
						<td>
							<label id="equipmentCost_adjust"></label>
						</td>
						<td>
							<label id="equipmentCost_after"></label>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;&nbsp; 2.材料费
						</td>
						<td>
							<label id="materialCost_before"></label>
						</td>
						<td>
							<label id="materialCost_adjust"></label>
						</td>
						<td>
							<label id="materialCost_after"></label>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;&nbsp; 3.测试化验加工费
						</td>
						<td>
							<label id="testCost_before"></label>
						</td>
						<td>
							<label id="testCost_adjust"></label>
						</td>
						<td>
							<label id="testCost_after"></label>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;&nbsp; 4.燃料动力费
						</td>
						<td>
							<label id="fuelCost_before"></label>
						</td>
						<td>
							<label id="fuelCost_adjust"></label>
						</td>
						<td>
							<label id="fuelCost_after"></label>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;&nbsp; 5.差旅费
						</td>
						<td>
							<label id="travelCost_before"></label>
						</td>
						<td>
							<label id="travelCost_adjust"></label>
						</td>
						<td>
							<label id="travelCost_after"></label>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;&nbsp; 6.会议费
						</td>
						<td>
							<label id="conferenceCost_before"></label>
						</td>
						<td>
							<label id="conferenceCost_adjust"></label>
						</td>
						<td>
							<label id="conferenceCost_after"></label>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;&nbsp; 7.国际合作与交流费
						</td>
						<td>
							<label id="exchangeCost_before"></label>
						</td>
						<td>
							<label id="exchangeCost_adjust"></label>
						</td>
						<td>
							<label id="exchangeCost_after"></label>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;&nbsp; 8.出版/文献/信息传播/知识产权/事务费
						</td>
						<td>
							<label id="publishCost_before"></label>
						</td>
						<td>
							<label id="publishCost_adjust"></label>
						</td>
						<td>
							<label id="publishCost_after"></label>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;&nbsp; 9.劳务费
						</td>
						<td>
							<label id="serviceCost_before"></label>
						</td>
						<td>
							<label id="serviceCost_adjust"></label>
						</td>
						<td>
							<label id="serviceCost_after"></label>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;&nbsp; 10.专家咨询费
						</td>
						<td>
							<label id="consultCost_before"></label>
						</td>
						<td>
							<label id="consultCost_adjust"></label>
						</td>
						<td>
							<label id="consultCost_after"></label>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;&nbsp; 11.间接费用
						</td>
						<td>
							<label id="indirectCost_before"></label>
						</td>
						<td>
							<label id="indirectCost_adjust"></label>
						</td>
						<td>
							<label id="indirectCost_after"></label>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;&nbsp; 12.其他费用
						</td>
						<td>
							<label id="otherCost_before"></label>
						</td>
						<td>
							<label id="otherCost_adjust"></label>
						</td>
						<td>
							<label id="otherCost_after"></label>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<b>调整时间&nbsp;&nbsp;&nbsp;&nbsp;</b>
							<label id="ntime"></label>
						</td>
					</tr>
				</table>
			</form>

		</div>


		<div style="padding-left: 5%;">
			<!-- 上传部分   start -->
			<div style="display: inline; width: 700px;">
				<div style="float: left;">
					<label>
						文件列表:
					</label>
					<label id="uploadOutputResult"></label>
				</div>

			</div>
			<!-- 上传部分   end -->

		</div>

		<div align="center" style="width: 100%;">
			<table>
				<tr>
					<td>
						<b>审批意见:</b>
					</td>
				</tr>
				<tr>
					<td>
						<textarea rows="" cols="" id="suggestion"></textarea>
					</td>
				</tr>
			</table>
		</div>

		<div align="center">
			<input type="button" value="打印表格" onclick="myprint('table')" />
			<input type="button" onclick="myexcel('table');"  value="导入到EXCEL">
		</div>

		<div align="right">
			<br />
			<br />

			<button type="button" onclick="javascript:history.go(-1);">
				返回上一页
			</button>
		</div>
	</body>
</html>
