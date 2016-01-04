<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"></base>
    
    <title>社科基金支出登记列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link rel="shortcut icon" type="image/ico" href="JqueryLib/dataTable/images/favicon.ico" />
	<link href="CSS/formPage.css" rel="stylesheet" type="text/css"/>
	<link href="JqueryLib/dataTable/css/demo_page.css" rel="stylesheet" type="text/css"/>
	<link href="JqueryLib/dataTable/css/demo_table_jui.css" rel="stylesheet" type="text/css"/>
    <link href="JqueryLib/dataTable/css/smoothness/jquery-ui-1.8.4.custom.css" rel="stylesheet" type="text/css"/>
    
    <script type="text/javascript" src="JqueryLib/development-bundle/jquery-1.6.2.js"></script>
	<script type="text/javascript" src="JS/common/util.js"></script>
	<!-- dataTables控件JS代码 -->
	<script type="text/javascript" src="JqueryLib/dataTable/js/jquery.dataTables.js"></script>
	<!-- UI界面JS代码 -->
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.ui.core.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/external/jquery.bgiframe-2.1.2.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery-ui-1.8.16.custom.js"></script>
	<script type="text/javascript" src="JqueryLib/development-bundle/ui/jquery.effects.core.js"></script>
	
	<script type="text/javascript" src="JS/teacher/outlayManagement/socialScienceFundOutlayList.js"></script>
	
	<script type="text/javascript">
		var itemPK = "<%= request.getParameter("itemPK")%>";
	</script>
	
  </head>
  
 <body id="dt_example">
 
 
	<div align = "center">
		<table>
			<tr>
				<td ><label>项目名称:</label></td>
				<td ><label id = "itemName"/></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td ><label>课题编号:</label></td>
				<td ><label id = "contractId"/></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td ><label>项目类型:</label></td>
				<td ><label id = "itemType"/></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td >
				<a href="Page/Teacher/payRegistration/socialScienceFundOutlay.jsp?outlayPK=0&pageType=finalStatement&itemPK=<%= request.getParameter("itemPK")%>">*查看决算表*</a>
				</td>
			</tr>	
		</table>
	</div>
		
	<div style = "width:95%" align = "center" id="container">
  		
  		<div class = "demo_jui">
  			<table id = "socialScienceFundOutlayListTable" cellpadding="0" cellspacing="0" border="0" class="display">
  			</table>
  		</div>
  		<div>
  			<button type="button" id = "addNewSocialScienceFundOutlayButton">新添支出</button>
  			<button type="button" id = "deleteSocialScienceFundOutlayButton">删除</button>
  		</div>
  		
  	</div>
	
	</body>
</html>
	