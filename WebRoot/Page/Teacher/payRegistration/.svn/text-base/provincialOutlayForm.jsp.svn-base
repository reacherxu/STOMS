<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>支出登记 (省基金)</title>
    
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
	
	<script type="text/javascript" src="JS/teacher/outlayManagement/provincialOutlayForm.js"></script>
	
	<style type="text/css">
	 	label {
	  		width: 148px;
	  	}
	  	input {
	  		width: 100px;
	  	}
  	</style>
  	
	<script type="text/javascript">
	   var itemPK = "<%= request.getParameter("itemPK")%>";
	</script>

  </head>
  
  <body>
  
   <%@include file="/Page/Common/generalMessageDialog.jsp"%>
   <%@include file="/Page/Common/generalAssureDialog.jsp"%>
   
 
  
   <form id = "provincialOutlayForm" >
		<table  align = "center" style="width: 100%"  border="1" cellspacing="0"  borderColor="#7EC0EE"  >
			<caption><h2>省基金支出登记</h2></caption>			 
			<tr>
				<td><label for = "itemName">项目(课题)名称</label></td>
				<td><label id = "itemName"></label></td>
			</tr>
			<tr>	
				<td><label for = "contractID">课题编号</label></td>
				<td><label id = "contractID"></label></td>
				<td><label for = "teacherName">项目负责人</label></td>
				<td><label id = "teacherName"></label></td>
			</tr>
			<tr>
			<td>
			</td>
			<td>
			</td>
			</tr>
			<tr bgColor="#E2E4FF">
				<td width="10%"><b>项目</b></td>
				<td width="15%"><b>预算情况</b></td>
				<td width="15%"><b>现有支出总额</b></td>
				<td width="15%"><b>结余总额</b></td>
				<td width="15%"><b>省科技厅拨款项目<br>本次经费支出情况</b></td>
				<td width="15%"><b>项目本次自筹经费支出情况</b></td>
				<td width="15%"><b>项目本次总经费支出情况</b></td>
			</tr>
			<tr>
				<td>(1)人员费</td>
				<td><label id="actualFundBudgetStaffCost"></label></td>
				<td><label id="currentStaffCost"></label></td>
				<td><label id="surplusStaffCost"></label></td>
				<td><input type="text" id="agencyStaffCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="selfStaffCost" class = "validate[custom[number]]"/></td>
				<td bgColor="#F0FFF0"><label id="sumStaffCost" ></label></td>
			</tr>
			<tr>
				<td>(2)设备费</td>
				<td><label id="actualFundBudgetEquipmentCost"></label></td>
				<td><label id="currentEquipmentCost"></label></td>
				<td><label id="surplusEquipmentCost"></label></td>
				<td><input type="text" id="agencyEquipmentCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="selfEquipmentCost" class = "validate[custom[number]]"/></td>
				<td bgColor="#F0FFF0"><label id="sumEquipmentCost" ></label></td>
			</tr>
			<tr>
				<td>(3)能源费</td>
				<td><label id="actualFundBudgetFuelCost"></label></td>
				<td><label id="currentFuelCost"></label></td>
				<td><label id="surplusFuelCost"></label></td>
				<td><input type="text" id="agencyFuelCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="selfFuelCost" class = "validate[custom[number]]"/></td>
				<td bgColor="#F0FFF0"><label id="sumFuelCost" ></label></td>
			</tr>
			<tr>
				<td>(4)材料费</td>
				<td><label id="actualFundBudgetMaterialCost"></label></td>
				<td><label id="currentMaterialCost"></label></td>
				<td><label id="surplusMaterialCost"></label></td>
				<td><input type="text" id="agencyMaterialCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="selfMaterialCost" class = "validate[custom[number]]"/></td>
				<td bgColor="#F0FFF0"><label id="sumMaterialCost" ></label></td>
			</tr>
			<tr>
				<td>(5)试验外协费</td>
				<td><label id="actualFundBudgetTestCost"></label></td>
				<td><label id="currentTestCost"></label></td>
				<td><label id="surplusTestCost"></label></td>
				<td><input type="text" id="agencyTestCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="selfTestCost" class = "validate[custom[number]]"/></td>
				<td bgColor="#F0FFF0"><label id="sumTestCost" ></label></td>
			</tr>
			<tr>
				<td>(6)差旅费</td>
				<td><label id="actualFundBudgetTravelCost"></label></td>
				<td><label id="currentTravelCost"></label></td>
				<td><label id="surplusTravelCost"></label></td>
				<td><input type="text" id="agencyTravelCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="selfTravelCost" class = "validate[custom[number]]"/></td>
				<td bgColor="#F0FFF0"><label id="sumTravelCost" ></label></td>
			</tr>
			<tr>
				<td>(7)会议费</td>
				<td><label id="actualFundBudgetConferenceCost"></label></td>
				<td><label id="currentConferenceCost"></label></td>
				<td><label id="surplusConferenceCost"></label></td>
				<td><input type="text" id="agencyConferenceCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="selfConferenceCost" class = "validate[custom[number]]"/></td>
				<td bgColor="#F0FFF0"><label id="sumConferenceCost" ></label></td>
			</tr>
			<tr>
				<td>(8)出版费</td>
				<td><label id="actualFundBudgetPublishCost"></label></td>
				<td><label id="currentPublishCost"></label></td>
				<td><label id="surplusPublishCost"></label></td>
				<td><input type="text" id="agencyPublishCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="selfPublishCost" class = "validate[custom[number]]"/></td>
				<td bgColor="#F0FFF0"><label id="sumPublishCost" ></label></td>
			</tr>
			<tr>
				<td>(9)管理费</td>
				<td><label id="actualFundBudgetManageCost"></label></td>
				<td><label id="currentManageCost"></label></td>
				<td><label id="surplusManageCost"></label></td>
				<td><input type="text" id="agencyManageCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="selfManageCost" class = "validate[custom[number]]"/></td>
				<td bgColor="#F0FFF0"><label id="sumManageCost" ></label></td>
			</tr>
			<tr>
				<td>(10)其他费用</td>
				<td><label id="actualFundBudgetOtherCost"></label></td>
				<td><label id="currentOtherCost"></label></td>
				<td><label id="surplusOtherCost"></label></td>
				<td><input type="text" id="agencyOtherCost" class = "validate[custom[number]]"/></td>
				<td><input type="text" id="selfOtherCost" class = "validate[custom[number]]"/></td>
				<td bgColor="#F0FFF0"><label id="sumOtherCost" ></label></td>
			</tr>
			<tr bgColor="#F0FFF0">
				<td><b>合计</b></td>
				<td><label id = "actualFundBudgetTotal"></label></td>
				<td><label id = "currentTotal"></label></td>
				<td><label id = "surplusTotal"></label></td>
				<td><label id = "agencyTotal"></label></td>
				<td><label id = "selfTotal"></label></td>
				<td><label id = "sumTotal"></label></td>
			</tr>
		</table>
		</form>

		<div align = "center">
			<br/><br/>
			<button type = "button" id = "provincialOutlaySubmitButton">提交</button>
			<button type = "button" id = "resetButton">重置</button>
		</div>
		<div align = "right">
				<br/><br/>
				<button type = "button" onclick = "javascript:history.go(-1);">返回上一页</button>
		</div>
  </body>
</html>
