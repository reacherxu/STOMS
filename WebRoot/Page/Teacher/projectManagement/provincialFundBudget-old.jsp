<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>省基金预算表</title>
    
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
		
	<!-- 表单验证JS代码 -->
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="JqueryLib/validationEngine/jquery.validationEngine.js"></script>
	
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>
	
	<script type="text/javascript" src="JS/teacher/projectManagement/provincialFundBudget.js"></script>
    
	<script type="text/javascript" src="JS/common/fileUpload.js"></script>
	<script type="text/javascript" src="JS/common/jquery.form.js"></script>

	
	<script type="text/javascript">
	   var itemPK = "<%= request.getParameter("itemPk")%>";
	</script>

  </head>
  
  <body>
  
   <%@include file="/Page/Common/generalMessageDialog.jsp"%>
   <%@include file="/Page/Common/generalAssureDialog.jsp"%>
   
  
  
   <form id = "provincialFundBudgetForm" >
		<table  align = "center" style="width: 100%"  >
			<caption><h2>省基金预算表</h2></caption>			 
			<tr>
				<td><label for = "itemName">项目(课题)名称</label></td>
				<td><label id = "itemName"></label></td>
			</tr>
			<tr>	
				<td><label for = "itemId">项目编号</label></td>
				<td><label id = "itemId"></label></td>
				<td><label for = "teacherName">项目负责人</label></td>
				<td><label id = "teacherName"></label></td>
			</tr>
			<tr>
			<td>
			</td>
			</tr>
			<tr>
				<td><strong>项目总经费</strong></td>
				<td><label id = "actualFundTotal"></label></td>
			</tr>
			<tr>
				<td>国家拨款</td>
				<td><input type="text" id = "actualFundNationFund"
				class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>省科技厅拨款</td>
				<td><input type="text"  id = "actualFundAgencyFund"
				class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>市县拨款</td>
				<td><input type="text"  id = "actualFundCountyFund"
				class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>部门拨款</td>
				<td><input type="text"  id = "actualFundDepartmentFund"
				class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>自筹(含贷款)</td>
				<td><input type="text"  id = "actualFundSelfFund"
				class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>其他</td>
				<td><input type="text"  id = "actualFundOtherFund"
				class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
			<td>
			</td>
			</tr>
			<tr>
				<td width="26%">项目</td>
				<td width="18%">预算情况</td>
				<td width="18%">省科技厅拨款项目经费支出情况</td>
				<td width="18%">项目自筹经费支出情况</td>
				<td width="20%">项目总经费支出情况</td>
			</tr>
			<tr>
				<td>(1)人员费</td>
				<td><input type="text" id="actualFundBudgetStaffCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="agencyStaffCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="selfStaffCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="sumStaffCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(2)设备费</td>
				<td><input type="text" id="actualFundBudgetEquipmentCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="agencyEquipmentCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="selfEquipmentCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="sumEquipmentCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(3)能源费</td>
				<td><input type="text" id="actualFundBudgetFuelCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="agencyFuelCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="selfFuelCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="sumFuelCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(4)材料费</td>
				<td><input type="text" id="actualFundBudgetMaterialCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="agencyMaterialCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="selfMaterialCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="sumMaterialCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(5)试验外协费</td>
				<td><input type="text" id="actualFundBudgetTestCost" class = "validate[custom[number]]m"/></td>
				<td><input type="text" id="agencyTestCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="selfTestCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="sumTestCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(6)差旅费</td>
				<td><input type="text" id="actualFundBudgetTravelCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="agencyTravelCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="selfTravelCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="sumTravelCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(7)会议费</td>
				<td><input type="text" id="actualFundBudgetConferenceCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="agencyConferenceCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="selfConferenceCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="sumConferenceCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(8)出版费</td>
				<td><input type="text" id="actualFundBudgetPublishCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="agencyPublishCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="selfPublishCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="sumPublishCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(9)管理费</td>
				<td><input type="text" id="actualFundBudgetManageCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="agencyManageCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="selfManageCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="sumManageCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(10)其他费用</td>
				<td><input type="text" id="actualFundBudgetOtherCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="agencyOtherCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="selfOtherCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="sumOtherCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td><strong>合计</strong></td>
				<td><label id = "actualFundBudgetTotal"></label></td>
				<td><label id = "agencyTotal"></label></td>
				<td><label id = "selfTotal"></label></td>
				<td><label id = "sumTotal"></label></td>
			</tr>
		</table>
		</form>
	

		<div align = "center">
			<br/><br/>
			<button type = "button" id = "provincialFundSavaButton">保存</button>
			<button type = "button" id = "provincialFundSubmitButton">提交</button>
			<button type = "button" id = "resetButton" onclick = "resetForm()">重置</button>
		</div>
	
  </body>
</html>
