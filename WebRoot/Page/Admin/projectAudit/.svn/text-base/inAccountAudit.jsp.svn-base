<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>入账申请审核</title>
    
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
    
    <script type="text/javascript" src="JqueryLib/js/jquery-1.7.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine.js"></script>
	
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>
	
	<script type="text/javascript" src="JS/admin/projectAudit/inAccountAudit.js"></script>
	
	<script type="text/javascript" src="JS/common/inAccountFileUpload.js"></script>
	
	<script type="text/javascript">
	 	var addOutlayPK = "<%= request.getParameter("addOutlayPK")%>";
	</script>
	
	<style type="text/css">
	
		tr td:first {
			width:30%;
		}
		
		body {
			text-align:left;
		}
		
		.inputWidgetWidth {
			width:100px;
		}
	</style>
	
	<style type="text/css">
  	textarea {
  		width: 250px;
  		height: 60px;
  	}
  	
  	</style>
	
	
  </head>
  
  <body>
   	
   	<%@include file="/Page/Common/generalMessageDialog.jsp"%>
  	<%@include file="/Page/Common/generalAssureDialog.jsp"%>
  	
   	<div align = "center">
	   	<form id = "inAccountApplicationForm" method="post">
			<table align="center" style="width: 80%;">
					<caption style = "height:40px;">
						<h3>
							入账申请审核
						</h3>
					</caption>
					<tr>
						<td>
							项目名称:&nbsp; &nbsp;
							<label id="itemName"></label>
						</td>
						<td>
							课题编号:&nbsp; &nbsp;
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
							<label id="indirectID" style="width: 150px;"></label>
							<button type = "button" id = "approveCreatingIndirectCardButton" onclick = "approveCreatingIndirectCard()">同意开卡</button>
						</td>
						<td>
							经费卡卡号:&nbsp; &nbsp;
							<label id="cardID" style="width: 150px;"></label>
							<button type = "button" id = "approveCreatingNewCardButton" onclick = "approveCreatingNewCard()">同意开卡</button>
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
							<fieldset style="border: 1px solid #87CEFF; width: 90%;">
								<legend>
									自行确定费用
								</legend>
								<table style="width: 100%;">

									<tr>									
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;管理费1
											<label id="manageProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;
											<input type="text" class="inputWidgetWidth" id="Manage" class="validate[custom[number]]" onchange = "modifyProportion()" />
											&nbsp;元
										</td>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;管理费2
											<label id="manage2ProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;
											<input type="text" class="inputWidgetWidth" id="Manage2" class="validate[custom[number]]" onchange = "modifyProportion()" />
											&nbsp;元
										</td>
									</tr>

									<tr>
										<td >
											&nbsp;&nbsp;&nbsp;&nbsp;劳务费1
											<label id="payProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;
											<input type="text" class="inputWidgetWidth" id="pay" class="validate[custom[number]]" onchange = "modifyProportion()"/>
											&nbsp;元 
										</td>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;可用管理额度
											<label id="availableManageCreditProportionLabel"
												style="font-size: 70%;"></label>
											&nbsp;&nbsp;
											<input type="text" class="inputWidgetWidth"
												id="AvailableManageCredit" class="validate[custom[number]]" onchange = "modifyProportion()"/>
											&nbsp;元
										</td>
									
										
									</tr>

									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;业务活动费
											<label id="actProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;
											<input type="text" class="inputWidgetWidth" id="Act" class="validate[custom[number]]" onchange = "modifyProportion()"/>
											&nbsp;元
										</td>
									
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;改善工作条件
											<label id="improveProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;
											<input type="text" class="inputWidgetWidth" id="Improve" class="validate[custom[number]]" onchange = "modifyProportion()"/>
											&nbsp;元
										</td>
									</tr>

									<tr>
										<td >
											&nbsp;&nbsp;&nbsp;&nbsp;劳务费2
											<label id="pay2ProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;
											<input type="text" class="inputWidgetWidth" id="pay2" class="validate[custom[number]]" onchange = "modifyProportion()"/>
											&nbsp;元 
										</td>
										
										
										<td >
											&nbsp;&nbsp;&nbsp;&nbsp;专家咨询费
											<label id="consultProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;
											<input type="text" class="inputWidgetWidth" id="Consult" class="validate[custom[number]]" onchange = "modifyProportion()"/>
											&nbsp;元
										</td>
									</tr>

									<tr>
										<td >
											&nbsp;&nbsp;&nbsp;&nbsp;差旅费
											<label id="travelCostProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;
											<input type="text" class="inputWidgetWidth" id="travelCost" class="validate[custom[number]]" onchange = "modifyProportion()"/>
											&nbsp;元
										</td>
									
										<td >
											&nbsp;&nbsp;&nbsp;&nbsp;国际合作与交流
											<label id="exchangeProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;
											<input type="text" class="inputWidgetWidth" id="exchange" class="validate[custom[number]]" onchange = "modifyProportion()"/>
											&nbsp;元
										</td>
									</tr>

									<tr>
										<td >
											&nbsp;&nbsp;&nbsp;&nbsp;设备费
											<label id="equipmentProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;
											<input type="text" class="inputWidgetWidth" id="equipment" class="validate[custom[number]]" onchange = "modifyProportion()"/>
											&nbsp;元
										</td>
									
										<td >
											&nbsp;&nbsp;&nbsp;&nbsp;会议费
											<label id="conferenceProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;
											<input type="text" class="inputWidgetWidth" id="conference" class="validate[custom[number]]" onchange = "modifyProportion()"/>
											&nbsp;元
										</td>
									</tr>

									<tr>
										<td >
											&nbsp;&nbsp;&nbsp;&nbsp;院系公共支出
											<label id="departmentPublicProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;
											<input type="text" class="inputWidgetWidth" id="departmentPublic" class="validate[custom[number]]" onchange = "modifyProportion()"/>
											&nbsp;元
										</td>
									
										<td >
											&nbsp;&nbsp;&nbsp;&nbsp;课题统筹支出
											<label id="coProjectProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;
											<input type="text" class="inputWidgetWidth" id="coProject" class="validate[custom[number]]" onchange = "modifyProportion()"/>
											&nbsp;元
										</td>
									</tr>
									<tr>
										<td >
											&nbsp;&nbsp;&nbsp;&nbsp;课题绩效支出
											<label id="PerformanceProportionLabel" style="font-size: 70%;"></label>
											&nbsp;&nbsp;
											<input type="text" class="inputWidgetWidth" id="Performance" class="validate[custom[number]]" onchange = "modifyProportion()"/>
											&nbsp;元
										</td>
										</tr>
								</table>
							</fieldset>

						</td>
					</tr>

					<tr>
					<td colspan="2">
						横向项目：&nbsp; &nbsp;<label id = "isCross"></label>
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						&nbsp;&nbsp;&nbsp;&nbsp;院系酬金
						<label id = "departmentPayProportionLabel"  style="font-size:70%;"></label>&nbsp;&nbsp;
						<input type="text"  class="inputWidgetWidth" id = "DepartmentPay" class="validate[custom[number]]" onchange = "modifyProportion()" disabled/>元
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;劳务费3
						<label id = "pay3ProportionLabel"  style="font-size:70%;"></label>&nbsp;&nbsp;
						<input type="text"  class="inputWidgetWidth" id = "pay3" class="validate[custom[number]]" onchange = "modifyProportion()" disabled/>元
					</td>
				</tr>
				
				<tr>
					<td colspan="2"><input type = "checkbox" id = "invoiceCheck"/>&nbsp;&nbsp;开据发票</td>
				</tr>
				
				<tr>
					<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发票抬头
					<input type="text"  class="validate[required]" id = "invoiceTitle" disabled/></td>
				</tr>
				
				<tr>
					<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开票内容
					<input type="text" id = "invoiceDetail" disabled/></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type = "checkbox" id = "taxCheck"/>&nbsp;&nbsp;税金</td>
				</tr>
				
				<tr>
					<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;税金1
						<label id = "tax1ProportionLabel"  style="font-size:70%;"></label>
					<input type="text"  class="validate[required]" id = "tax1" class="validate[custom[number]]" onchange = "modifyProportion()" disabled/>&nbsp;元</td>
				</tr>
				
				<tr>
					<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;税金2
						<label id = "tax2ProportionLabel"  style="font-size:70%;"></label>
					<input type="text"  class="validate[required]" id = "tax2"  class="validate[custom[number]]" onchange = "modifyProportion()" disabled/>&nbsp;元</td>
				</tr>
				
				<tr>
					<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;税金3
						<label id = "tax3ProportionLabel"  style="font-size:70%;"></label>
					<input type="text"  class="validate[required]" id = "tax3" class="validate[custom[number]]" onchange = "modifyProportion()" disabled/>&nbsp;元</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<!-- 上传部分   start -->	
					 	<div style = "width:100%;" align = "left">
					 		
							<br>
							<label>附件列表:</label>
							
							<div style = "padding-left: 50px;">
								<label id="uploadOutputResult"></label>
							</div>
						
						</div>
						<!-- 上传部分   end -->
					</td>
				</tr>
				
			</table>
			
			<div align = "left" style = "width:100%;padding-left:10%">
				<table>
				<tr>
					<td><b>备注:</b></td>
				</tr>
				<tr>
					<td><textarea rows="" cols="" id = "suggestion"></textarea></td>
				</tr>
				</table>
				</div>
			
			<div align = "center">
				<br/><br/>
				<button type = "button" id = "inAccountAuditApproveButton">审批通过 </button>
				<button type = "button" id = "inAccountAuditRejectButton">审批未通过</button>
			</div>
			
			<div align = "right">
				<br/><br/>
				<button type = "button" onclick = "javascript:history.go(-1);">返回上一页</button>
			</div>
		</form>
	</div>
  </body>
</html>
