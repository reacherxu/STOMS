
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

		<title>入账申请审核结果</title>

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

		<script type="text/javascript" src="JqueryLib/js/jquery-1.7.js"></script>
		<script type="text/javascript" src="JS/common/util.js"></script>

		<script type="text/javascript"
			src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
		<script type="text/javascript"
			src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
		<script type="text/javascript"
			src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
		<script type="text/javascript"
			src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>

		<script type="text/javascript"
			src="JS/teacher/inAccountApplication/approvedInAccountApplicationView.js"></script>

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
		
		.inputWidgetWidth {
			width: 100px;
		}
		
		textarea {
	  		width: 250px;
	  		height: 60px;
	  	}
	  	
	  	a {
		    color: #0063DC;
		    cursor: pointer;
		    text-decoration: underline;
		}
		
		a:hover {
			text-decoration: underline;
		}
	</style>

	
	</head>

	<body>
	
		<div align="center">
			<br><br>
			<strong><label style="font-size: 25px;font-family: 黑体;">入账信息</label></strong>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; 
			<a onclick="printInAccountInfoButtonResponse()" style = "font-size: 14px;">打印</a>
			<br><br>
		</div>

		<div align="center">
			<form id="inAccountApplicationForm" method="post">
				<table align="center" style="width: 80%;">
					
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
							&nbsp;&nbsp;&nbsp;
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
						<td colspan="2">
						</td>
					</tr>
					
					<tr >
						<td colspan="2">
							<fieldset style="border: 1px solid #87CEFF; width: 85%;">
								<legend>自行确定费用</legend>
								<table style="width: 90%;">
									<tr>
										
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管理费1
											<label id="manageProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label id="Manage"></label>
											&nbsp;元
										</td>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管理费2
											<label id="manage2ProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label id="Manage2"></label>
											&nbsp;元
										</td>
									</tr>

									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;劳务费1
											<label id="payProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label id="pay"></label>
											&nbsp;元 
										</td>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;可用管理额度
											<label id="availableManageCreditProportionLabel"
												style="font-size: 70%;"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;
											<label id="AvailableManageCredit"></label>
											&nbsp;元
										</td>
										
									</tr>

									<tr>
										<td >
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业务活动费
											<label id="actProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;
											<label id="Act"></label>
											&nbsp;元
										</td>
									
										<td >
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;改善工作条件
											<label id="improveProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;&nbsp;
											<label id="Improve"></label>
											&nbsp;元
										</td>
									</tr>

									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;劳务费2
											<label id="pay2ProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label id="pay2"></label>
											&nbsp;元
										</td>									
										<td >
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;专家咨询费
											<label id="consultProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label id="Consult"></label>
											&nbsp;元
										</td>
									</tr>

									<tr>
										<td >
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;差旅费
											<label id="travelCostProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label id="travelCost"></label>
											&nbsp;元
										</td>
									
										<td >
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;国际合作与交流
											<label id="exchangeProportionLabel" style="font-size: 70%;"></label>
											&nbsp;
											<label id="exchange"></label>
											&nbsp;元
										</td>
									</tr>

									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;设备费
											<label id="equipmentProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label id="equipment"></label>
											&nbsp;元
										</td>
									
										<td >
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;会议费
											<label id="conferenceProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label id="conference"></label>
											&nbsp;元
										</td>
									</tr>
									
									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;院系公共支出
											<label id="departmentPublicProportionLabel" style="font-size: 70%;"></label>
											&nbsp;
											<label id="departmentPublic"></label>
											&nbsp;元
										</td>
									
										<td >
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;课题统筹支出
											<label id="coProjectProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<label id="coProject"></label>
											&nbsp;元
										</td>
									</tr>
									
									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;课题绩效支出
											<label id="performanceProportionLabel" style="font-size: 70%;"></label>
											&nbsp;
											<label id="Performance"></label>
											&nbsp;元
										</td>
									</tr>

								</table>
							</fieldset>

						</td>
					</tr>
					
					<tr>
						<td colspan="2">
						</td>
					</tr>

					<tr>
						<td colspan="2">
							横向项目:&nbsp;&nbsp;&nbsp;&nbsp;<label id="isCross"></label>
						</td>
					</tr>

					<tr>
						<td colspan="2">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;院系酬金
							<label id="departmentPayProportionLabel" style="font-size: 70%;"></label>
							&nbsp;&nbsp;
							<label id="DepartmentPay"></label>
							&nbsp;元
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;劳务费3
							<label id="pay3ProportionLabel" style="font-size: 70%;"></label>
							&nbsp;&nbsp;
							<label id="pay3"></label>
							&nbsp;元
						</td>
					</tr>

					<tr>
						<td colspan="2">
							开据发票:&nbsp;&nbsp;&nbsp;&nbsp;<label id="invoiceCheck"></label>
						</td>
						
					</tr>

					<tr>
						<td colspan="2">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发票抬头:						
							<label id="invoiceTitle"></label>
						</td>
					</tr>

					<tr>
						<td colspan="2">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开票内容:						
							<label id="invoiceDetail"></label>
						</td>
					</tr>

					<tr>
						<td colspan="2">
							税金:&nbsp;&nbsp;&nbsp;&nbsp;<label id="taxCheck"></label>
						</td>
						
					</tr>

					<tr>
						<td colspan="2">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;税金1
							<label id="tax1ProportionLabel" style="font-size: 70%;"></label>
							&nbsp;&nbsp;<label id="tax1"></label>
							&nbsp;元
						</td>
					</tr>

					<tr>
						<td colspan="2">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;税金2
							<label id="tax2ProportionLabel" style="font-size: 70%;"></label>
							&nbsp;&nbsp;<label id="tax2"></label>
							&nbsp;元
						</td>
					</tr>

					<tr>
						<td colspan="2">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;税金3
							<label id="tax3ProportionLabel" style="font-size: 70%;"></label>					
							&nbsp;&nbsp;<label id="tax3"></label>
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
				
				<div align = "left" style = "width:80%;">
					<table>
					<tr>
						<td><b>审批意见:</b></td>
					</tr>
					<tr>
						<td><textarea rows="" cols="" id = "suggestion"></textarea></td>
					</tr>
					</table>
				</div>
				
			</form>
		</div>
		
			
		
		<div align = "right">
				<br/><br/>
				<button type = "button" onclick = "javascript:history.go(-1);">返回上一页</button>
		</div>
	</body>
</html>
