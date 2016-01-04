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

		<title>入账申请查看</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link href="CSS/formPage.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="JqueryLib/js/jquery-1.7.js"></script>
		<script type="text/javascript" src="JS/common/util.js"></script>

		<script type="text/javascript"
			src="JS/teacher/inAccountApplication/inAccountApplicationView.js"></script>

		<script type="text/javascript" src="JS/common/inAccountFileUpload.js"></script>

		<script type="text/javascript">
	 	var addOutlayPK = "<%=request.getParameter("addOutlayPK")%>";
	   var itemID = "<%=request.getParameter("itemID")%>";
</script>

		<style type="text/css">
tr td:first {
	width: 30%;
}

body {
	text-align: left;
}
</style>
	</head>

	<body>
		<div>
			<br>
			<br>
		</div>

		<div align="center">

			<table align="center" style="width: 80%;">
				<caption style="height: 40px;">
					<h3>
						待审核的入账
					</h3>
				</caption>
				<tr>
					<td>
						项目名称:&nbsp; &nbsp;
						<label id="itemName"></label>
					</td>
					<td>
						项目编号:&nbsp; &nbsp;
						<label id="contractID"></label>
					</td>
				</tr>

				<tr>
					<td>
						项目负责人:&nbsp; &nbsp;
						<label id="teacherName"></label>
					</td>
					<td>
						其他负责人:&nbsp; &nbsp;
						<label id="otherTeacherName"></label>
					</td>
				</tr>

				<tr>
					<td>
						来款单位:&nbsp; &nbsp;
						<label id="inAccountDepartment"></label>
					</td>
					<td>
						银行流水账号（ID号）:&nbsp; &nbsp;
						<label id="bankID"></label>
						&nbsp;&nbsp;
						<a href="http://ndcw.nju.edu.cn/cx3/baobiao/yhtzcx.aspx"
								target="_blank">银行台账查询</a>
					</td>
				</tr>

				<tr>
					<td>
						间接经费卡:&nbsp; &nbsp;
						<label id="indirectID"></label>
					</td>
					<td>
						经费卡卡号:&nbsp; &nbsp;
						<label id="cardID"></label>
					</td>
				</tr>
				
				<tr>
					<td>
						来款金额:&nbsp; &nbsp;
						<label id="outlayValue"></label>
						&nbsp;&nbsp;元
					</td>
					<td>
						汇出金额:&nbsp; &nbsp;
						<label id="remitValue"></label>
						&nbsp;&nbsp;元
					</td>
				</tr>

				<tr>
					<td>
						直接费用:&nbsp; &nbsp;
						<label id="DirectValue"></label>
						&nbsp;&nbsp;元
					</td>
					<td>
						间接费用:&nbsp; &nbsp;
						<label id="IndirectValue"></label>
						&nbsp;&nbsp;元
					</td>
				</tr>
				<tr>
					<td>
						绩效支出:&nbsp; &nbsp;
						<label id="Performance"></label>
						&nbsp;&nbsp;元
					</td>

					<td>
						设备购置费:&nbsp; &nbsp;
						<label id="Equipment"></label>
						&nbsp;&nbsp;元
					</td>
				</tr>

				<tr>
					<td>
						管理费1:&nbsp; &nbsp;
						<label id="Manage"></label>
						&nbsp;&nbsp;元
					</td>

					<td>
						课题绩效支出:&nbsp; &nbsp;
						<label id="Performance2"></label>
						&nbsp;&nbsp;元
					</td>
				</tr>
				<tr>
					<td>
						院系公共支出:&nbsp; &nbsp;
						<label id="DepartmentPublic"></label>
						&nbsp;&nbsp;元
					</td>

					<td>
						课题统筹支出:&nbsp; &nbsp;
						<label id="CoProject"></label>
						&nbsp;&nbsp;元
					</td>
				</tr>


				<tr>
					<td colspan="2">
						开据发票:&nbsp;&nbsp;&nbsp;&nbsp;
						<label id="invoiceCheck"></label>
					</td>

				</tr>

				<tr>
					<td colspan="2">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发票抬头:
						<label id="invoiceTitle"></label>
					</td>
				</tr>

				<tr>
					<td colspan="2">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开票内容:
						<label id="invoiceDetail"></label>
					</td>
				</tr>

				<tr>
					<td colspan="2">
						税金:&nbsp;&nbsp;&nbsp;&nbsp;
						<label id="taxCheck"></label>
					</td>

				</tr>

				<tr>
					<td colspan="2">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;税金1
						<label id="tax1ProportionLabel" style="font-size: 70%;"></label>
						&nbsp;&nbsp;
						<label id="tax1"></label>
						&nbsp;元
					</td>
				</tr>

				<tr>
					<td colspan="2">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;税金2
						<label id="tax2ProportionLabel" style="font-size: 70%;"></label>
						&nbsp;&nbsp;
						<label id="tax2"></label>
						&nbsp;元
					</td>
				</tr>

				<tr>
					<td colspan="2">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;税金3
						<label id="tax3ProportionLabel" style="font-size: 70%;"></label>
						&nbsp;&nbsp;
						<label id="tax3"></label>
						&nbsp;元
					</td>
				</tr>

			</table>

			<!-- 上传部分   start -->
			<div style="width: 80%;" align="left">

				<br>
				<label>
					附件列表:
				</label>

				<div style="padding-left: 50px;">
					<label id="uploadOutputResult"></label>
				</div>

			</div>
			<!-- 上传部分   end -->


			<div align="right">
				<br />
				<br />
				<button type="button" onclick="javascript:history.go(-1);">
					返回上一页
				</button>
			</div>

		</div>
	</body>
</html>
