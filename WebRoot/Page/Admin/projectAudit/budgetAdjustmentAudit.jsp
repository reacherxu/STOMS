<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>预算调整审批Detail</title>
    
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
	
	<script type="text/javascript" src="JS/admin/projectAudit/budgetAdjustmentAudit.js"></script>
	
	<script type="text/javascript" src="JS/common/fileUpload.js"></script>
	
	
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
	   var itemPK = "<%= request.getParameter("itemPK")%>";
	    var nationalFundAdjustPk = "<%= request.getParameter("nationalFundAdjustPk")%>";
	</script>
	
  </head>
  
  <body>
   	
   	<%@include file="/Page/Common/generalMessageDialog.jsp"%>
  	<%@include file="/Page/Common/generalAssureDialog.jsp"%>
  	
   <form id = "budgetAdjustmentAuditForm" >
	<div align="center"  >
		<table align="center" style = "width:80%;"  border="1" cellspacing="0" borderColor="#7EC0EE">
			<caption><h2>国家基金预算调整</h2></caption>
			<tr>
				<td><label for = "itemName">项目(课题)名称</label></td>
				<td colspan="3"><label id = "itemName"></label></td>
			</tr>
			<tr>
				<td><label for = "teacherName">项目(课题)负责人</label></td>
				<td ><label id = "teacherName"></label></td>
				<td><label for = "approveID">批准号</label></td>
				<td ><label id = "approveID"></label></td>
			</tr>
			<tr>
				<td><label for = "dialFundsSum">已拨入经费(总额)</label></td>
				<td colspan="3"><label id = "dialFundsSum"></label></td>
			</tr>
			<tr bgColor=#e2e4ff>
				<td width="40%"><b>科目</b></td>
				<td width="20%">预算经费</td>
				<td width="20%">调整经费</td>
				<td width="20%">预算总经费</td>
			</tr>
			<tr bgColor=#F0FFF0>
				<td><b>一.研究经费</b></td>
				<td><label id = "studyFund_Budget"></label></td>
				<td><label id = "studyFund_Adjust"></label></td>
				<td><label id = "studyFund_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>1.科研业务费</td>
				<td><label id = "sumBusiness_Budget"></label></td>
				<td><label id = "sumBusiness_Adjust"></label></td>
				<td><label id = "sumBusiness_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>(1)测试/计算/分析费</td>
				<td><label id = "testCost_Budget"></label></td>
				<td><label id = "testCost_Adjust"></label> </td>
				<td><label id = "testCost_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>(2)能源/动力费</td>
				<td><label id = "fuelCost_Budget"></label></td>
				<td><label id = "fuelCost_Adjust"></label></td>
				<td><label id = "fuelCost_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>(3)会议费/差旅费</td>
				<td><label id = "conferenceCost_Budget"></label></td>
				<td><label id = "conferenceCost_Adjust"></label></td>
				<td><label id = "conferenceCost_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>(4)出版物/文献/信息传播事务费</td>
				<td><label id = "publishCost_Budget"></label></td>
				<td><label id = "publishCost_Adjust"></label></td>
				<td><label id = "publishCost_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>(5)其他</td>
				<td><label id = "otherBusiness_Budget"></label></td>
				<td><label id = "otherBusiness_Adjust"></label></td>
				<td><label id = "otherBusiness_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>2.实验材料费</td>
				<td><label id = "sumMaterial_Budget"></label></td>				
				<td><label id = "sumMaterial_Adjust"></label></td>
				<td><label id = "sumMaterial_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>(1)原材料/试剂/药品购置费</td>
				<td><label id = "rawMaterial_Budget"></label></td>
				<td><label id = "rawMaterial_Adjust"></label></td>
				<td><label id = "rawMaterial_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>(2)其他</td>
				<td><label id = "otherMaterial_Budget"></label></td>
				<td><label id = "otherMaterial_Adjust" ></label></td>
				<td><label id = "otherMaterial_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>3.仪器设备费</td>
				<td><label id = "sumEquipment_Budget"></label></td>
				<td><label id = "sumEquipment_Adjust"></label></td>
				<td><label id = "sumEquipment_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>(1)购置</td>
				<td><label id = "buyEquipment_Budget"></label></td>
				<td><label id = "buyEquipment_Adjust"></label></td>
				<td><label id = "buyEquipment_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>(2)试制</td>
				<td><label id = "trialEquipment_Budget"></label></td>
				<td><label id = "trialEquipment_Adjust"></label></td>
				<td><label id = "trialEquipment_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>4.实验室改装费</td>
				<td><label id = "laboratory_Budget"></label></td>
				<td><label id = "laboratory_Adjust"></label></td>
				<td><label id = "laboratory_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>5.协作费</td>
				<td><label id = "cooperation_Budget"></label></td>
				<td><label id = "cooperation_Adjust"></label></td>
				<td><label id = "cooperation_BudgetSum"></label></td>
			</tr>
			<tr bgColor=#F0FFF0>
				<td><b>二.国际合作与交流费</b></td>
				<td><label id = "exchangeSum_Budget"></label></td>
				<td><label id = "exchangeSum_Adjust"></label></td>
				<td><label id = "exchangeSum_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>1.项目组成员出国合作交流</td>
				<td><label id = "exchange_Budget"></label></td>
				<td><label id = "exchange_Adjust"></label></td>
				<td><label id = "exchange_BudgetSum"></label></td>
			</tr>
			<tr>
				<td>2.境外专家来华合作交流</td>
				<td><label id = "expert_Budget"></label></td>
				<td><label id = "expert_Adjust"></label></td>
				<td><label id = "expert_BudgetSum"></label></td>
			</tr>
			<tr bgColor=#F0FFF0>
				<td><b>三.劳务费</b></td>
				<td><label id = "serviceCost_Budget"></label></td>
				<td><label id = "serviceCost_Adjust"></label></td>
				<td><label id = "serviceCost_BudgetSum"></label></td>
			</tr>
			<tr bgColor=#F0FFF0>
				<td><b>四.管理费</b></td>
				<td><label id = "manageCost_Budget"></label></td>
				<td><label id = "manageCost_Adjust"></label></td>
				<td><label id = "manageCost_BudgetSum"></label></td>
			</tr>
			<tr bgColor=#e2e4ff>
				<td><b>合计</b></td>
				<td><label id = "sums_Budget"></label></td>
				<td><label id = "sums_Adjust"></label></td>
				<td><label id = "sums_BudgetSum"></label></td>
			</tr>
			<tr bgColor=#e2e4ff>
				<td><b>本项目其他经费来源</b></td>
				<td colspan="3">预算经费</td>
			</tr>
			<tr>
				<td>国家其他计划资助经费</td>
				<td colspan="3"><label style = "width:100%;" id = "otherPlanFundsBuget" ></label></td>
			</tr>
			<tr>
				<td>其他经费资助（含部门匹配）</td>
				<td colspan="3"><label style = "width:100%;" id = "otherSubsidizeBuget" ></label></td>
			</tr>
			<tr bgColor=#e2e4ff>
				<td><b>其他经费来源合计</b></td>
				<td colspan="3"><label style = "width:100%;" id = "otherSumBuget"></label></td>		
			</tr>	
			<tr>
				<td colspan="4"><b>调整时间&nbsp;&nbsp;&nbsp;&nbsp;</b><label id = "ntime"></label></td>
			</tr>
		</table>
		</div>
		
		
		<!-- 上传部分   start -->	
	 	<div style="display: inline; width: 700px; padding-left:10%;">
		<div style="float:left;padding-left:10%;">
		<label>文件列表:</label><label id="uploadOutputResult"></label>
		</div>

		</div>
		<!-- 上传部分   end -->	
		
		<div align = "center" style = "width:100%;">
				<table>
				<tr>
					<td><b>审批意见:</b></td>
				</tr>
				<tr>
					<td><textarea rows="" cols="" id = "suggestion"></textarea></td>
				</tr>
				</table>
								
				</div>
		
		
		<div align = "center">
			<br/><br/>
			<button type = "button" id = "budgetAdjustmentAuditPassButton">审批通过</button>
			<button type = "button" id = "budgetAdjustmentAuditRejectButton">审批不通过</button>
		</div>
		<div align = "right">
				<br/><br/>
				<button type = "button" onclick = "javascript:history.go(-1);">返回上一页</button>
		</div>
		
	</form>
  </body>
</html>
