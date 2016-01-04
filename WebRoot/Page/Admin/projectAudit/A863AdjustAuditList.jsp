<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>863预算调整审核</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="shortcut icon" type="image/ico" href="JqueryLib/dataTable/images/favicon.ico" />
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
	
	<script type="text/javascript" src="JS/admin/projectAudit/A863AdjustAuditList.js"></script>
	

  </head>
  
  <body id="dt_example">
  	
  	<div style = "width:95%" align = "center" id="container">
  		
  		<div class = "demo_jui">
  			<table id = "A863AdjustAuditListTable" cellpadding="0" cellspacing="0" border="0" class="display">
  			</table>
  		</div>
  	</div>
  </body>
</html>
