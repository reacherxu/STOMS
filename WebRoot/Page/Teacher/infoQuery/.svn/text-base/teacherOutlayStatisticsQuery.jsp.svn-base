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

		<title>教师经费统计查询</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link href="CSS/formPage.css" rel="stylesheet" type="text/css" />
		<link
			href="JqueryLib/development-bundle/themes/base/jquery.ui.all.css"
			rel="stylesheet" type="text/css" />
		<link href="JqueryLib/css/datepickerCss/datepicker_demo.css"
			rel="stylesheet" type="text/css" />

		<link rel="shortcut icon" type="image/ico"
			href="JqueryLib/dataTable/images/favicon.ico" />
		<link href="JqueryLib/dataTable/css/demo_page.css" rel="stylesheet"
			type="text/css" />
		<link href="JqueryLib/dataTable/css/demo_table_jui.css"
			rel="stylesheet" type="text/css" />
		<link
			href="JqueryLib/dataTable/css/smoothness/jquery-ui-1.8.4.custom.css"
			rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="JqueryLib/js/jquery-1.7.js"></script>
		<script type="text/javascript" src="JS/common/util.js"></script>

		<!-- dataTables控件JS代码 -->
		<script type="text/javascript"
			src="JqueryLib/dataTable/js/jquery.dataTables.js"></script>

		<!-- UI界面JS代码 -->
		<script type="text/javascript"
			src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
		<script type="text/javascript"
			src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
		<script type="text/javascript"
			src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
		<script type="text/javascript"
			src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>

		<script type="text/javascript"
			src="JS/teacher/infoQuery/teacherOutlayStatisticsQuery.js"></script>

		<style type="text/css">
.ui-datepicker table td {
	height: 20px;
}

.grayALink {
	color: #808080;
}
</style>

	</head>

	<body>
		<div>
			<br></br>
		</div>
		<div align="center">
			<form method="post" style="width: 95%;">
				<table style="width: 100%;">
					<tr>
						<td>
							<label for="iscross">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;项目类型&nbsp;&nbsp;
							</label>
							<select id="iscross" style="width: 60px;">
								<option value="-1">
									所&nbsp;有
								</option>
								<option value="1">
									横&nbsp;向
								</option>
								<option value="0">
									纵&nbsp;向
								</option>
							</select>

							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

							<label>
								时间范围&nbsp;&nbsp;
							</label>
							<input type="text" id="startDate" style="width: 100px;" />
							&nbsp;&nbsp;&nbsp;&nbsp;到&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text" id="endDate" style="width: 100px;" />

							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

							<button type="button" onclick="teacherOutlayStatisticsQuery()">
								查询
							</button>
							<button type="reset">
								重置
							</button>
						</td>
					</tr>

				</table>
			</form>
		</div>

		<div>
			<table width="95%" align="center">
				<tr>
					<td width="20%">
						<table width="100%">
							<tr>
								<td align="center">
									<b>总入账</b>
								</td>
							</tr>
							<tr>
								<td align="center">
									<label id="sumOfInAccount"></label>
									（元）
								</td>
							</tr>
							<tr>
								<td align="center">
									<b>总支出</b>
								</td>
							<tr>
								<td align="center">
									<label id="sumOfInOutlay"></label>
									（元）
								</td>
							</tr>
							<tr>
								<td align="center">
									<b>总结余</b>
								</td>
							<tr>
								<td align="center">
									<label id="sumOfBalance"></label>
									（元）
								</td>
							</tr>
						</table>

					</td>
					<td width="80%">
						<div style="width: 100%" id="container">
							<div class="demo_jui">
								<table id="teacherOutlayStatisticsListTable" cellspacing="0"
									border="0" class="display">
								</table>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>




	</body>
</html>
