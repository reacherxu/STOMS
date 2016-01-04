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
	
	<script type="text/javascript" src="JS/teacher/projectManagement/provincialFundBudgetView.js"></script>
	
	<script type="text/javascript" src="JS/common/fileUpload.js"></script>
	
	<style type="text/css">
	 	label {
	  		width: 148px;
	  	}
	  	input {
	  		width: 100px;
	  	}
  	</style>
  	
	<script type="text/javascript">
	   var itemPK = "<%= request.getParameter("itemPk")%>";
	</script>

  </head>
  
  <body>
  
   <%@include file="/Page/Common/generalMessageDialog.jsp"%>
   <%@include file="/Page/Common/generalAssureDialog.jsp"%>
   
  
  
   <form id = "provincialFundBudgetForm" >
   	<div align="center"  >
		<table  align = "center" style="width: 70%" border="1" cellspacing="0" borderColor="#7EC0EE"  >
			<caption><h2>省基金预算表</h2></caption>			 
			<tr>
				<td><label for = "itemName">项目(课题)名称</label></td>
				<td><label id = "itemName"></label></td>
			</tr>
			<tr>
				<td><label for = "contractID">课题编号</label></td>
				<td><label id = "contractID"></label></td>
			</tr>
			<tr>	
				<td><label for = "teacherName">项目负责人</label></td>
				<td><label id = "teacherName"></label></td>
			</tr>
			<tr  bgColor="#F0FFF0">
				<td><b>项目总经费</b></td>
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
			<tr bgColor="#E2E4FF">
				<td width="26%"><b>项目</b></td>
				<td width="18%"><b>预算情况</b></td>
			</tr>
			<tr>
				<td>(1)人员费</td>
				<td><input type="text" id="actualFundBudgetStaffCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(2)设备费</td>
				<td><input type="text" id="actualFundBudgetEquipmentCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(3)能源费</td>
				<td><input type="text" id="actualFundBudgetFuelCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(4)材料费</td>
				<td><input type="text" id="actualFundBudgetMaterialCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(5)试验外协费</td>
				<td><input type="text" id="actualFundBudgetTestCost" class = "validate[custom[number]]m"/></td>
			</tr>
			<tr>
				<td>(6)差旅费</td>
				<td><input type="text" id="actualFundBudgetTravelCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(7)会议费</td>
				<td><input type="text" id="actualFundBudgetConferenceCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(8)出版费</td>
				<td><input type="text" id="actualFundBudgetPublishCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(9)管理费</td>
				<td><input type="text" id="actualFundBudgetManageCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr>
				<td>(10)其他费用</td>
				<td><input type="text" id="actualFundBudgetOtherCost" class = "validate[custom[number]]"/></td>
			</tr>
			<tr bgColor="#F0FFF0">
				<td><b>合计</b></td>
				<td><label id = "actualFundBudgetTotal"></label></td>
			</tr>
		</table>
		</div>
		</form>
		
	<!-- 上传部分   start -->	
	 	<div style="display: inline; width: 700px;">
		<div style="float:left;">
		<label>文件列表:</label><label id="uploadOutputResult"></label>
		</div>

		</div>
	<!-- 上传部分   end -->	
	
  </body>
</html>
